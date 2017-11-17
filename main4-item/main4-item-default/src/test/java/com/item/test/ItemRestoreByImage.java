package com.item.test;

import com.openJar.commons.MD5Attestation;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRestoreByImage extends BaseSpringTest {

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Test
    public void restore() throws IOException {
        Long oldStoreId=43368L;
        Long newStoreId=43544L;
        //先查出老店的所有图片与ID对
        Map<String,Long> imgMap=new HashMap<>();
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(oldStoreId);
        example.setWebSite("hz");
        List<ShiguGoodsTiny> tinys=shiguGoodsTinyMapper.selectByExample(example);
        for(ShiguGoodsTiny tiny:tinys){
            imgMap.put(codeImage(tiny.getPicUrl()+"_240x240.jpg"),tiny.getGoodsId());
        }
        example.clear();
        example.createCriteria().andStoreIdEqualTo(newStoreId);
        List<ShiguGoodsTiny> newtinys=shiguGoodsTinyMapper.selectByExample(example);
        for(ShiguGoodsTiny tiny:newtinys){
            Long oldGid=imgMap.get(codeImage(tiny.getPicUrl()+"_240x240.jpg"));
            replaceTwo(oldGid,tiny);
        }
    }

    /**
     * 交换2个商品的ID(权重)
     * @param oldGid
     * @param tiny
     */
    private void replaceTwo(Long oldGid,ShiguGoodsTiny tiny){

        ShiguGoodsTiny oldTiny=null;
        Long newGid=tiny.getGoodsId();
        if(oldGid!=null){
            ShiguGoodsTiny selTiny=new ShiguGoodsTiny();
            selTiny.setGoodsId(oldGid);
            selTiny.setWebSite("hz");
            oldTiny=shiguGoodsTinyMapper.selectByPrimaryKey(selTiny);
            shiguGoodsTinyMapper.deleteByPrimaryKey(selTiny);
        }else {
            return;
        }
        shiguGoodsTinyMapper.deleteByPrimaryKey(tiny);
        tiny.setGoodsId(oldGid);
        shiguGoodsTinyMapper.insert(tiny);
        oldTiny.setGoodsId(newGid);
        shiguGoodsTinyMapper.insert(oldTiny);
    }

    @Test
    public void replace(){
        Long newId=21638048L;
        Long oldId=21619326L;
        ShiguGoodsTiny tiny=new ShiguGoodsTiny();
        tiny.setWebSite("hz");
        tiny.setGoodsId(newId);
        tiny=shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        replaceTwo(oldId,tiny);
    }

    @Test
    public void upinsert(){
        ShiguGoodsTiny tiny=new ShiguGoodsTiny();
        tiny.setWebSite("hz");
        tiny.setGoodsId(21427612L);
        tiny=shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        tiny.setGoodsId(21614485L);
        tiny.setNick("真美伊丝");
        tiny.setStoreId(43368L);
        shiguGoodsTinyMapper.insert(tiny);
    }

    public String codeImage(String url) throws IOException {
        Connection conn= Jsoup.connect(url);
        conn.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.0 Safari/537.36");
        conn.timeout(50000);
        Connection.Response response=conn.execute();
        byte[] data=response.bodyAsBytes();
        return MD5Attestation.MD5Encode(new String(data));
    }

    @Test
    public void codeImageTest() throws IOException {
        System.out.println(codeImage("https://img.alicdn.com/bao/uploaded/i3/822981417/TB17G2egURIWKJjSZFgXXboxXXa_!!0-item_pic.jpg_240x240.jpg"));
    //https://img.alicdn.com/bao/uploaded/i2/822981417/TB1hzpIhNuaVKJjSZFjXXcjmpXa_!!0-item_pic.jpg_240x240.jpg
        System.out.println(codeImage("https://img.alicdn.com/bao/uploaded/i2/822981417/TB1hzpIhNuaVKJjSZFjXXcjmpXa_!!0-item_pic.jpg_240x240.jpg"));
    }

}
