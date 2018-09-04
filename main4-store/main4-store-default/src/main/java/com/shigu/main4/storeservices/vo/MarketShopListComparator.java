package com.shigu.main4.storeservices.vo;

import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 市场列表店铺档口排序
 *
 * @author shigu_zjb
 * @date 2017/02/2/28 13:47
 * <p>
 * <p>排序规则</p>
 * 1.按shopNum进行字母顺序升序排列
 * 2.如果碰到-，则只识别-前面部分，如果-前面部分一样，则-后面部分进行字母升序
 * <p>
 * method<compare>return:1升序 -1降序 0保持不变
 */
public class MarketShopListComparator implements Comparator<ShopShow> {

    @Override
    public int compare(ShopShow o1, ShopShow o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.getFloorId().equals(o2.getFloorId())) {
            String shopNumo1 = o1.getSortOrderKey().trim();
            String shopNumo2 = o2.getSortOrderKey().trim();
            if (StringUtils.equals(shopNumo1, shopNumo2)) {
                return 0;
            }
            try {
                double shopNumd1=shopnumNumber(shopNumo1);
                double shopNumd2=shopnumNumber(shopNumo2);
                if (shopNumd1>shopNumd2) {
                    return 1;
                }else if(shopNumd1 == shopNumd2){
                    return compareByChar(shopNumo1,shopNumo2);
                }else{
                    return -1;
                }
            } catch (Exception e) {//没有数字可比
                return compareByChar(shopNumo1,shopNumo2);
            }
        } else {
            int floor1 = floorNumber(o1.getFloor());
            int floor2 = floorNumber(o2.getFloor());
            return floor1-floor2;
        }
    }
    private int floorNumber(String floor) {
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(floor);
        if (m.find() && !"".equals(m.group())) {
            return Integer.valueOf(m.group());
        } else {
            return 100;
        }
    }
    public int compareByChar(String s1,String s2){
        int sortInt = s1.compareTo(s2);
        if (sortInt == 2) {
            return 1;
        }
        if (sortInt == -2) {
            return -1;
        }
        return sortInt;
    }

    /**
     * 档口号转化成数字
     * @param shopNum
     * @return
     */
    public double shopnumNumber(String shopNum){
        if (shopNum == null) {
            return 1000000d;
        }
        String result="";
        if(shopNum.startsWith("A")){
            result+="1";
        }else if(shopNum.startsWith("B")){
            result+="2";
        }else if(shopNum.startsWith("C")){
            result+="3";
        }else if(shopNum.startsWith("D")){
            result+="4";
        }else if(shopNum.startsWith("E")){
            result+="5";
        }else if(shopNum.startsWith("F")){
            result+="6";
        }
        shopNum=shopNum.replaceAll("-东[^-]*-","-101-")
                .replaceAll("-南[^-]*-","-102-")
                .replaceAll("-西[^-]*-","-103-")
                .replaceAll("-北[^-]*-","-104-");
        String regex = "\\d+";
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(shopNum);
        if(m.find()){//第一个数字
            result+=m.group()+".0";
        }
        while(m.find()){
            result+=bunumber(m.group());
        }
        return Double.valueOf(result);
    }
    private String bunumber(String number){
        int max=5-number.length();
        for(int i=0;i<max;i++){
            number="0"+number;
        }
        return number;
    }

}
