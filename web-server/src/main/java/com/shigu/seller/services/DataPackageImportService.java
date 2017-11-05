package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.PackageImportGoodsDataService;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import com.shigu.zhb.utils.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：DataPackageImportService
 * @文件路径：com.shigu.seller.services.DataPackageImportService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:01
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("dataPackageImportService")
public class DataPackageImportService {
    @Autowired
    PackageImportGoodsDataService packageImportGoodsDataService;

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    OssIO ossIO;

    final String URL_FLAG="/itemImgs/temp/";//临时图片地址标志
    final String URL_NORMAL="/itemImgs/";//正式图片地址

    @Autowired
    ShiguShopMapper shiguShopMapper;

    public List<ShiguGoodsTinyVO> importtempGoods(String packageUrl, Long storeId, String flag)throws Main4Exception{
      return  packageImportGoodsDataService.packageImporttempGoods (packageUrl,  storeId,  flag);
    }

    /**
     * 添加商品到星座网
     * @param shopId
     * @param tiny
     * @throws ItemModifyException
     */
    public void addToXzw(Long shopId,ShiguGoodsTinyVO tiny) throws ItemModifyException {
        SynItem item= BeanMapper.map(tiny,SynItem.class);
        ShiguShop shop=shiguShopMapper.selectByPrimaryKey(shopId);
        item.setShopId(shop.getShopId());
        item.setFloorId(shop.getFloorId());
        item.setMarketId(shop.getMarketId());
        item.setOnsale(true);
        item.setGoodsDesc(tiny.getExtendsGoods().getGoodsDesc());
        item.setPropsName(tiny.getExtendsGoods().getPropsName());
        item.setPropertyAlias(tiny.getExtendsGoods().getPropertyAlias());
        item.setProps(tiny.getExtendsGoods().getProps());
        item.setInputPids(tiny.getExtendsGoods().getInputPids());
        item.setInputStr(tiny.getExtendsGoods().getInputStr());
        List<ShiguPropImg> propImgs=BeanMapper.mapList(tiny.getExtendsGoods().getList_spi(), ShiguPropImg.class);
        for(ShiguPropImg img:propImgs){
            img.setUrl(banjia(img.getUrl()));
        }
        item.setPropImgs(propImgs);
        item.setItemFrom(ItemFrom.PACKAGE);
        item.setGoodsId(null);
        String images=tiny.getExtendsGoods().getImages();
        List<String> imageList=new ArrayList<>();
        if (StringUtils.isNotEmpty(images)) {
            String[] imgarr=images.split(",");
            for(String img:imgarr){
                imageList.add(banjia(img));
            }
        }
        item.setImageList(imageList);
        itemAddOrUpdateService.userAddItem(item);
    }

    public String banjia(String url){
        String targetUrl=url;
        if (url.contains(URL_FLAG)) {
            String srcFilePath=url.substring(url.indexOf(URL_FLAG)+1,url.length());
            String targetFilePath=srcFilePath.replace(URL_FLAG,URL_NORMAL);
            targetUrl=url.replace(URL_FLAG,URL_NORMAL);
            ossIO.moveFile(srcFilePath,targetFilePath);
        }
        return targetUrl;
    }
}
