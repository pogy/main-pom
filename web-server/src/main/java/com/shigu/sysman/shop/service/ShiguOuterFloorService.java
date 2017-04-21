package com.shigu.sysman.shop.service;


import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 外部楼层展示SERVICE
 *
 * @author shigu_zjb
 * @date 2017/03/25 11：25
 *
 */
@Service
public class ShiguOuterFloorService {

    @Autowired
    private ShiguOutMarketService shiguOutMarketService;

    @Autowired
    private ShiguOuterFloorMapper shiguOuterFloorMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguMarketService shiguMarketService;

    private List<Long> parseIds(String ids){
        if(StringUtils.isEmpty(ids)){
            return null;
        }
        List<Long> idslist = new ArrayList<>();
        String[] idsarr = ids.split(",");
        for(String id:idsarr){
            idslist.add(Long.valueOf(id));
        }
        return idslist;
    }

    /**
     * 外部楼层list
     * @param marketId
     * @return
     */
    public List<ShiguOuterFloor> findOuterFloorList(Long marketId){
        ShiguOuterMarket shiguOuterMarket = shiguOutMarketService.getOutMarketById(marketId);
        if(shiguOuterMarket == null){
            return Collections.EMPTY_LIST;
        }
        if(StringUtils.isEmpty(shiguOuterMarket.getOuterFloorIds())){
            return Collections.EMPTY_LIST;
        }
        String [] floorIds = shiguOuterMarket.getOuterFloorIds().split(",");
        List<ShiguOuterFloor> outerFloorList = shiguOuterFloorMapper.selFloorListByIds(floorIds);
        if(outerFloorList == null){
            return Collections.EMPTY_LIST;
        }
        for(int m = 0;m<outerFloorList.size();m++){
            ShiguOuterFloor outerFloor = outerFloorList.get(m);
            String floorId = outerFloor.getFloorIds();
            if(!StringUtils.isEmpty(floorId)&&!StringUtils.equals(floorId,"-1")){
                String [] sjFloorIds = floorId.split(",");
                String floorNames = "";
                for(int k = 0;k<sjFloorIds.length;k++){
                    ShiguMarket shiguMarket = shiguMarketService.getShiguMarketById(Long.valueOf(sjFloorIds[k]));
                    if(k!=0&&!StringUtils.isEmpty(floorNames)){
                        floorNames = floorNames + ",";
                    }
                    if(shiguMarket!=null){
                        floorNames = floorNames + shiguMarket.getParentMarketName()+ "-"+shiguMarket.getMarketName();
                    }
                }
                outerFloorList.get(m).setFloorNames(floorNames);
            }

            String addShops = outerFloor.getAddedShop();
            if(StringUtils.isEmpty(addShops)){
                continue;
            }
            String[] shops = addShops.split(";");
            List<String> shopIdList = new ArrayList<String>();
            for (int i = 0; i < shops.length; i++) {
                String[] shopInfos = shops[i].split(",");
                if (!StringUtils.isEmpty(shopInfos[0])) {
                    shopIdList.add(shopInfos[0]);
                }
            }
            List<String> shopNumList = shiguShopMapper.selectShopNumByIds(shopIdList);
            String shopNums = StringUtils.join(shopNumList,",");
            outerFloorList.get(m).setAddedShop(shopNums);
        }
        return outerFloorList;
    }

    /**
     * 新的楼层展示
     * @param outerFloor
     * @param ruleId
     */
    @Transactional
    public void addOuterFloor(ShiguOuterFloor outerFloor, Long ruleId){
        if(outerFloor == null){
            return;
        }
        if(ruleId == null){
            return;
        }
        ShiguOuterMarket outerMarket = shiguOutMarketService.getOutMarketById(ruleId);
        if(outerFloor == null){
            return;
        }
        shiguOuterFloorMapper.insertSelective(outerFloor);
        if (StringUtils.isEmpty(outerMarket.getOuterFloorIds())) {
            outerMarket.setOuterFloorIds(outerFloor.getOuterFloorId().toString());
        } else {
//            boolean panss = false;
//            String[] floorIds = outerMarket.getOuterFloorIds().split(",");
//            for (int i = 0; i < floorIds.length; i++) {
//                String floorId = floorIds[i];
//                if (StringUtils.equals(floorId, outerFloor.getOuterFloorId().toString())) {
//                    panss = true;
//                }
//            }
//            if (!panss) {
//
//            }
            outerMarket.setOuterFloorIds(outerMarket.getOuterFloorIds() + "," + outerFloor.getOuterFloorId());
        }
        shiguOutMarketService.updateOuterMarket(outerMarket);
    }

    /**
     * 新增绑定店铺
     * @param floorId
     * @param shopIds
     */
    @Transactional
    public void addOuterShop(Long floorId, Long shopIds,String shopNum){
        if (floorId == null || shopIds == null) {
            return;
        }
        ShiguOuterFloor outerFloor = shiguOuterFloorMapper.selectByPrimaryKey(floorId);
        if (outerFloor == null) {
            return;
        }
        String addShops = outerFloor.getAddedShop();
        if (StringUtils.isEmpty(addShops)) {
            addShops = new String("");
        }
        boolean panss = false;
        String[] shops = addShops.split(";");
        for (int i = 0; i < shops.length; i++) {
            String[] shopInfos = shops[i].split(",");
            if (!StringUtils.isEmpty(shopInfos[0])) {
                if (StringUtils.equals(shopIds.toString(), shopInfos[0])) {
                    panss = true;
                }
            }
        }
        if(panss){
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(Long.valueOf(shopIds));
        if (shiguShop == null) {
            return;
        }
        String systemRecommon = shiguShop.getSystemRecommon();
        if(StringUtils.isEmpty(systemRecommon)){
            systemRecommon="";
        }
        systemRecommon = systemRecommon.replaceAll(","," ");
        String addOuterShops = shiguShop.getShopId() + "," + shopNum + "," + shiguShop.getShopName() +
                "," + systemRecommon + ",";
        stringBuffer.append(addOuterShops);
        if (StringUtils.isEmpty(addShops)) {
            addShops = stringBuffer.toString();
        } else {
            addShops = addShops + ";" + stringBuffer.toString();
        }
        outerFloor.setAddedShop(addShops);
        shiguOuterFloorMapper.updateByPrimaryKeySelective(outerFloor);
    }

    /**
     * 查询
     * @param outerFloorId
     * @return
     */
    public ShiguOuterFloor findOuterFloorById(Long outerFloorId){
        ShiguOuterFloor outerFloor = shiguOuterFloorMapper.selectByPrimaryKey(outerFloorId);
        if(!StringUtils.isEmpty(outerFloor.getFloorIds())){
            String floorNames = "";
            String [] floorids = outerFloor.getFloorIds().split(",");
            for(int i = 0;i<floorids.length;i++){
                ShiguMarket shiguMarket = shiguMarketService.getShiguMarketById(Long.valueOf(floorids[i]));
                if(shiguMarket!=null){
                    if(!StringUtils.isEmpty(floorNames)){
                        floorNames = floorNames + ",";
                    }
                    floorNames = floorNames + shiguMarket.getMarketName();
                }
            }
            outerFloor.setFloorNames(floorNames);
        }
        return outerFloor;
    }

    /**
     * 更新楼层
     * @param outerFloor
     */
    @Transactional
    public void updateOutFloor(ShiguOuterFloor outerFloor){
        if(outerFloor == null){
            return;
        }
        shiguOuterFloorMapper.updateByPrimaryKeySelective(outerFloor);
    }

    /**
     * 删除楼层
     * @param outFloorIds
     */
    @Transactional
    public void delOutFloor(String [] outFloorIds, Long ruleId) throws Main4Exception {
        if(outFloorIds == null || outFloorIds.length == 0){
            return;
        }
        for (int i = 0; i < outFloorIds.length; i++) {
            Long outFloorId = Long.valueOf(outFloorIds[i]);
            ShiguOuterFloor outerFloor = shiguOuterFloorMapper.selectByPrimaryKey(outFloorId);
            if(outerFloor == null){
                return;
            }
            if(!StringUtils.isEmpty(outerFloor.getAddedShop())){
                //throw new Main4Exception("楼层名称：" + outerFloor.getShowName() + "下存在自定义绑定店铺，请先删除");
            }
            shiguOuterFloorMapper.deleteByPrimaryKey(outFloorId);
        }
        // 移除市场中的楼层
        shiguOutMarketService.removeOuterFloor(outFloorIds, ruleId);
    }

    /**
     * 店铺绑定列表
     * @param outFloorId
     * @return
     */
    public List<ShiguShop> getOuterShopList(Long outFloorId){
        if(outFloorId == null){
            return Collections.EMPTY_LIST;
        }
        ShiguOuterFloor shiguOuterFloor = shiguOuterFloorMapper.selectByPrimaryKey(outFloorId);
        if(shiguOuterFloor == null){
            return Collections.EMPTY_LIST;
        }
        String addshops = shiguOuterFloor.getAddedShop();
        if(StringUtils.isEmpty(addshops)){
            return Collections.EMPTY_LIST;
        }
        String [] shops = addshops.split(";");
        List<ShiguShop> shopList = new ArrayList<ShiguShop>();
        for (int i = 0; i < shops.length; i++) {
            String[] shopInfos = shops[i].split(",");
            if (!StringUtils.isEmpty(shopInfos[0])) {
                ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(Long.valueOf(shopInfos[0]));
                ShiguMarket shiguMarket = shiguMarketService.getShiguMarketById(shiguShop.getMarketId());
                if(shiguMarket!=null){
                    shiguShop.setParentMarketName(shiguMarket.getMarketName());
                }
                shiguShop.setShopNum(shopInfos[1]);
                shopList.add(shiguShop);
            }
        }
        return shopList;
    }

    /**
     * 删除店铺绑定
     * @param outerFloorId
     * @param shopIds
     */
    @Transactional
    public void delOuterShop(Long outerFloorId,String [] shopIds){
        if(outerFloorId == null || shopIds == null || shopIds.length == 0){
            return;
        }
        ShiguOuterFloor outerFloor = shiguOuterFloorMapper.selectByPrimaryKey(outerFloorId);
        if(outerFloor == null){
            return;
        }
        String addshops = outerFloor.getAddedShop();
        if(StringUtils.isEmpty(addshops)){
            return;
        }
        String [] addShopIds = addshops.split(";");
        for(int i = 0;i<addShopIds.length;i++){
            String[] shopInfos = addShopIds[i].split(",");
            for (int j = 0; j < shopIds.length; j++) {
                if (StringUtils.equals(shopIds[j], shopInfos[0])) {
                    addShopIds[i] = null;
                }
            }
        }
        List<String> addShopList = new ArrayList<String>();
        for(int m = 0;m<addShopIds.length;m++){
            if(!StringUtils.isEmpty(addShopIds[m])){
                addShopList.add(addShopIds[m]);
            }
        }
        addShopIds = addShopList.toArray(new String[addShopList.size()]);
        addshops = StringUtils.join(addShopIds,";");
        outerFloor.setAddedShop(addshops);
        shiguOuterFloorMapper.updateByPrimaryKey(outerFloor);
    }
}
