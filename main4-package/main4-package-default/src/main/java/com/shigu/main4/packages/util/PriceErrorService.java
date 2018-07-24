package com.shigu.main4.packages.util;

import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.main4.packages.vo.PriceDataGrid;
import com.shigu.main4.packages.vo.ShiguGoodsTinyVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @类编号
 * @类名称：PipriceErrorService
 * @文件路径：com.shigu.main4.ucenter.util.PipriceErrorService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 19:07
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("priceErrorService")
public class PriceErrorService {

    private static final String priceMatcherKey = "keyword[\\s]*[0-9]+\\.{0,1}[0-9]{0,2}";
    private static final String priceMatcherOnly = "[0-9]+\\.{0,1}[0-9]{0,2}";
    public static final Double SCALE = 0.2D;

    public PriceDataGrid piPriceMatcher(ShiguShop shop, ShiguGoodsTinyVO goods, Double standardprice, Double pricescale, int pipeitype, String keyword, int model) {
        PriceDataGrid dg = new PriceDataGrid();
        if (goods == null) {
            return null;
        } else {
            String title = goods.getTitle();
            if (title == null) {
                goods.setIsStandard(Integer.valueOf(1));
                dg.setGoods(goods);
                dg.setSuccess(false);
                dg.setMsg("商品标题为空");
                return dg;
            } else if (goods.getStoreId() == null) {
                goods.setIsStandard(Integer.valueOf(1));
                dg.setGoods(goods);
                dg.setSuccess(false);
                dg.setMsg("商品所属的店铺ID为空");
                return dg;
            } else {
                String taobaoPriceString = goods.getPriceString();
                if (this.isNull(taobaoPriceString)) {
                    goods.setIsStandard(Integer.valueOf(1));
                    dg.setGoods(goods);
                    dg.setSuccess(false);
                    dg.setMsg("没有零售价,PriceString为空");
                    return dg;
                } else {
                    double taobaoPrice = Double.valueOf(taobaoPriceString).doubleValue();
                    double minprice = 0.0D;
                    if (taobaoPrice > standardprice.doubleValue()) {
                        if (pricescale == null) {
                            pricescale = SCALE;
                        }

                        double scaleValue = taobaoPrice * pricescale.doubleValue();
                        minprice = scaleValue;
                    }

                    String priceRole = null;
                    String webSite;
                    if (goods.getStoreId() != null) {
                        webSite = goods.getWebSite();


                        if (webSite != null) {

                            if (shop != null) {
                                priceRole = shop.getPriceRule ();
                            }
                        }
                    }

                    webSite = goods.getGoodsNo();
                    List<Double> doublelist = new ArrayList ();
                    List<Double> pricelist = this.pipei(pipeitype, keyword, title, webSite, taobaoPrice, priceRole);
                    Set<Double> priceset = this.getPriceList(minprice, taobaoPrice, pricelist);
                    if (priceset.size() > 0) {
                        Iterator<Double> iter = priceset.iterator();

                        while(iter.hasNext()) {
                            doublelist.add(iter.next());
                        }
                    }

                    if (doublelist.size() == 0) {
                        goods.setIsStandard(Integer.valueOf(1));
                        dg.setGoods(goods);
                        dg.setSuccess(false);
                        dg.setMsg("没有匹配到批发价");
                    } else if (doublelist.size() == 1) {
                        BigDecimal pibig = new BigDecimal(String.valueOf(doublelist.get(0)));
                        String piPrice = String.valueOf(pibig.multiply(new BigDecimal(100)).longValue());
                        goods.setIsStandard(Integer.valueOf(0));
                        goods.setPiPrice(Long.valueOf(piPrice));
                        goods.setPiPriceString(this.DoubleToString((Double)doublelist.get(0)));
                        dg.setGoods(goods);
                        dg.setSuccess(true);
                        dg.setpPriceString(this.DoubleToString((Double)doublelist.get(0)));
                    } else {
                        dg = this.changePrice(goods, doublelist, model);
                    }

                    return dg;
                }
            }
        }
    }
    private List<Double> pipei(int pipeitype, String keyword, String title, String goodsNo, double taobaoPrice, String role) {
        List<Double> pricelist = new ArrayList();
        String[] array = keyword.split(",");
        String[] arr;
        int len$;
        int i$;
        String key;
        List temp;
        switch(pipeitype) {
            case 1:
                arr = array;
                len$ = array.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    key = arr[i$];
                    temp = this.calculate(title, key, taobaoPrice, role, "title");
                    pricelist.addAll(temp);
                }

                return pricelist;
            case 2:
                if (goodsNo != null) {
                    arr = array;
                    len$ = array.length;

                    for(i$ = 0; i$ < len$; ++i$) {
                        key = arr[i$];
                        temp = this.calculate(goodsNo, key, taobaoPrice, role, "goodsNo");
                        pricelist.addAll(temp);
                    }
                }
                break;
            case 3:
                arr = array;
                len$ = array.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    key = arr[i$];
                    pricelist.addAll(this.calculate(title, key, taobaoPrice, role, "title"));
                    if (goodsNo != null) {
                        pricelist.addAll(this.calculate(goodsNo, key, taobaoPrice, role, "goodsNo"));
                    }
                }

                return pricelist;
            case 4:
                List<Double> titlefour = new ArrayList();
                List<Double> nofour = new ArrayList();
                String[] arr1 = array;
                int len = array.length;

                for(int i = 0; i < len; ++i) {
                    String key1 = arr1[i];
                    titlefour.addAll(this.calculate(title, key1, taobaoPrice, role, "title"));
                    if (goodsNo != null) {
                        nofour.addAll(this.calculate(goodsNo, key1, taobaoPrice, role, "goodsNo"));
                    }
                }

                if (titlefour.size() > 0) {
                    pricelist = titlefour;
                } else {
                    pricelist = nofour;
                }
                break;
            case 5:
                List<Double> titlefive = new ArrayList();
                List<Double> nofive = new ArrayList();
                String[] arr2 = array;
                int len2 = array.length;

                for(int i = 0; i < len2; ++i) {
                    String key1 = arr2[i];
                    titlefive.addAll(this.calculate(title, key1, taobaoPrice, role, "title"));
                    if (goodsNo != null) {
                        nofive.addAll(this.calculate(goodsNo, key1, taobaoPrice, role, "goodsNo"));
                    }
                }

                if (nofive.size() > 0) {
                    pricelist = nofive;
                } else {
                    pricelist = titlefive;
                }
        }

        return pricelist;
    }
    private PriceDataGrid changePrice(ShiguGoodsTinyVO goods, List<Double> doublelist, int model) {
        PriceDataGrid dg = new PriceDataGrid();
        switch(model) {
            case 1:
                Double temp = 0.0D;
                Iterator i$ = doublelist.iterator();

                while(i$.hasNext()) {
                    Double d = (Double)i$.next();
                    if (d.doubleValue() > temp.doubleValue()) {
                        temp = d;
                    }
                }

                BigDecimal pibig = new BigDecimal(temp.doubleValue());
                String piPrice = String.valueOf(pibig.multiply(new BigDecimal(100)).longValue());
                goods.setIsStandard(Integer.valueOf(0));
                goods.setPiPrice(Long.valueOf(piPrice));
                goods.setPiPriceString(this.DoubleToString(temp));
                dg.setGoods(goods);
                dg.setSuccess(true);
                dg.setpPriceString(this.DoubleToString(temp));
                break;
            case 2:
                String suffix = "";

                for(int i = 0; i < doublelist.size(); ++i) {
                    suffix = suffix + this.DoubleToString((Double)doublelist.get(i)) + ",";
                }

                Long flagId = goods.getGoodsId();
                if (flagId == null) {
                    //flagId = goods.getNumIid();
                }



                goods.setIsStandard(Integer.valueOf(1));
                dg.setGoods(goods);
                dg.setSuccess(false);
                dg.setMsg("商品批发价有多个,已插入批发价错误表中");
        }

        return dg;
    }
    private List<Double> calculate(String content, String keyword, Double taobaoPrice, String role, String type) {
        new ArrayList();
        List pricelist;
        if (role != null && role.trim().length() > 0) {
            String[] temp = role.split(":");
            if (type.equals(temp[0])) {
                String want = temp[1].split("@between@")[0];
                pricelist = this.filter(content, want, taobaoPrice);
                if (temp.length > 2) {
                    String del = temp[2].split("@else@")[0];
                    if (del.indexOf(want) == del.length() - want.length()) {
                        List<Double> removelist = this.filter(content, del, taobaoPrice);
                        Iterator i$ = removelist.iterator();

                        while(i$.hasNext()) {
                            Double d = (Double)i$.next();
                            pricelist.remove(d);
                        }
                    }
                }

                return pricelist;
            }
        }

        pricelist = this.filter(content, keyword, taobaoPrice);
        return pricelist;
    }
    private List<Double> filter(String content, String keyword, Double taobaoPrice) {
        List<Double> pricelist = new ArrayList();
        content = content.toLowerCase();
        keyword = keyword.toLowerCase();
        Pattern p1 = Pattern.compile("keyword[\\s]*[0-9]+\\.{0,1}[0-9]{0,2}".replace("keyword", keyword));
        Matcher m1 = p1.matcher(content);

        while(m1.find()) {
            String pPriceStr = m1.group();
            Double pPrice = this.getDouble(pPriceStr);
            if (pPrice.doubleValue() <= taobaoPrice.doubleValue()) {
                pricelist.add(pPrice);
            }
        }

        return pricelist;
    }

    private Set<Double> getPriceList(Double minprice, Double maxprice, List<Double> list) {
        Set<Double> set = new HashSet ();
        if (list != null && list.size() > 0) {
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                Double d = (Double)i$.next();
                if (d.doubleValue() >= minprice.doubleValue() && d.doubleValue() <= maxprice.doubleValue()) {
                    set.add(d);
                }
            }
        }

        return set;
    }

    private Double getDouble(String pPrice) {
        if (pPrice != null && pPrice.trim().length() > 0) {
            Pattern p_str = Pattern.compile("[0-9]+\\.{0,1}[0-9]{0,2}");
            Matcher m = p_str.matcher(pPrice);
            if (m.find()) {
                pPrice = m.group();
                Double price = Double.valueOf(pPrice);
                return this.formatPrice(price);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private Double formatPrice(Double price) {
        if (price == null) {
            return null;
        } else {
            BigDecimal b = new BigDecimal(price.doubleValue());
            price = b.setScale(2, 4).doubleValue();
            return price;
        }
    }

    private boolean isNull(Object object) {
        if (object == null) {
            return true;
        } else {
            boolean isNull = false;
            if (object instanceof String) {
                isNull = object.toString().trim().length() <= 0;
            } else if (object instanceof List) {
                List list = (List)object;
                isNull = list.size() <= 0;
            }

            return isNull;
        }
    }
    private String DoubleToString(Double dd) {
        String dString = dd + "";
        String xiaoshuString = "";
        String[] ds = dString.split("\\.");
        if (ds.length > 1) {
            if (ds[1].length() == 0) {
                xiaoshuString = ds[1] + "00";
            } else if (ds[1].length() == 1) {
                xiaoshuString = ds[1] + "0";
            } else if (ds[1].length() == 2) {
                xiaoshuString = ds[1];
            } else {
                xiaoshuString = ds[1].substring(0, 2);
            }

            dString = ds[0] + "." + xiaoshuString;
        } else {
            dString = dString + ".00";
        }

        return dString;
    }
}
