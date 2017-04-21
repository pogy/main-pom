package tinytoes;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.vo.SynItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2017-03-25.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/main4/spring/item-update.xml")
public class CsItemMove {

    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;
    @Resource(name="tae_mall_shiguGoodsTinyMapper")
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Resource(name="tae_mall_shiguShopMapper")
    ShiguShopMapper shiguShopMapper;

    @Test
    public void moveItem() throws ItemModifyException {
        String gooNO="38985";
        gooNO+="#";
        Integer testStatus=0;
        Long goodsId=20099623l;
        ShiguGoodsTinyExample stex=new ShiguGoodsTinyExample();

        Long originId=36434l;
        stex.setWebSite("cs");
        if(testStatus==1){
            stex.createCriteria().andGoodsIdEqualTo(goodsId).andStoreIdEqualTo(originId);

        }else{
            stex.createCriteria().andStoreIdEqualTo(originId).andGoodsStatusEqualTo(0).andGoodsNoLike(gooNO+"%");
        }
        //查出所有商品
        List<ShiguGoodsTiny> tinyList=shiguGoodsTinyMapper.selectByExample(stex);

        for(ShiguGoodsTiny tiny:tinyList){


            SynItem item=itemAddOrUpdateService.selItemByGoodsId(tiny.getGoodsId(),tiny.getWebSite());
            String goodsNo=item.getGoodsNo();
            String[] cstr=goodsNo.split("#");

            item.setItemFrom(ItemFrom.MEMBER);
            try {
                item.setShopId(Long.parseLong(cstr[0]));
                ShiguShop shop=shiguShopMapper.selectFieldsByPrimaryKey(item.getShopId()
                        , FieldUtil.codeFields("shop_id,market_id,floor_id,web_site"));
                if(!shop.getWebSite().equals("cs")){
                    continue;
                }
                item.setMarketId(shop.getMarketId());
                item.setFloorId(shop.getFloorId());


            } catch (NumberFormatException e) {
                System.out.println(item.getGoodsId()+"该商品不存在商品编码");
                continue;
            }
            try {
                itemAddOrUpdateService.systemAddItem(item);
                System.out.println(item.getGoodsNo()+"--添加成功");
            } catch (ItemModifyException e) {
                if(e.getCode()=="IllegalArgumentException"){
                    System.out.println("不存在可能么。。");

                }
                if(e.getCode()=="ITEM_ALREADY_EXIST"){
                    //商品已存在
                    ShiguGoodsTiny tiny_g=new ShiguGoodsTiny();
                    tiny_g.setWebSite(item.getWebSite());
                    tiny_g.setGoodsNo(item.getGoodsNo());
                    tiny_g.setNumIid(item.getNumIid());
                    tiny_g.setStoreId(item.getShopId());
                    List<ShiguGoodsTiny> tiny_glist=shiguGoodsTinyMapper.select(tiny_g);//防止有多条
                    for(ShiguGoodsTiny tiny1:tiny_glist){
                        //管他几条都更新
                        item.setGoodsId(tiny1.getGoodsId());
//                        itemAddOrUpdateService.systemUpdateItem(item);
                    }


                }
               if(e.getCode()=="SHOP_DOES_NOT_EXIST"){
                   System.out.println(item.getGoodsId()+"店铺不存在");
               }


            }


        }






    }

    public void  test(){

        CsItemMove move=new CsItemMove();
        //move.moveItem(1,20012311l);

    }
}
