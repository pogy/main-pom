//package com.shigu.seller.services;
//
//import com.opentae.data.mall.beans.SearchCategory;
//import com.opentae.data.mall.beans.ShiguCustomerStyle;
//import com.opentae.data.mall.examples.SearchCategoryExample;
//import com.opentae.data.mall.examples.ShiguCustomerStyleExample;
//import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
//import com.opentae.data.mall.interfaces.SearchCategoryMapper;
//import com.opentae.data.mall.interfaces.ShiguCustomerStyleMapper;
//import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
//import com.shigu.main4.item.services.ItemAddOrUpdateService;
//import com.shigu.seller.vo.CategoryTabsVo;
//import com.shigu.seller.vo.CategoryVo;
//import com.shigu.seller.vo.UserGoodsStyleVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Service
//// TODO: 18-1-23 准备撤掉
//public class GoodStyleService {
//    @Autowired
//    private  SearchCategoryMapper SearchCategoryMapper;
//    @Autowired
//    private ItemAddOrUpdateService ItemAddOrUpdateService;
//    @Autowired
//    private ShiguCustomerStyleMapper shiguCustomerStyleMapper;
//
//    @Autowired
//    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
//    @Autowired
//    private GoodsCountForsearchMapper goodsCountForsearchMapper;
//    /**
//     * 获取自定义风格列表
//     */
//    public List<UserGoodsStyleVo> getUserStyle(Long pid, Long userId, Long shopId, String webSite){
//        ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
//        SearchCategoryExample example = new SearchCategoryExample();
//        example.createCriteria().andTypeEqualTo(1).andWebSiteEqualTo(webSite);
//        //朱类目
//        List<SearchCategory> list2 =new ArrayList<>();
//        list2=SearchCategoryMapper.selectByExample(example);
//        //所有的 主类目 值
////        List<String> collect = new ArrayList<>();
//        if(pid!=null){
////            collect.add(String.valueOf(pid));
//            shiguCustomerStyleExample.createCriteria().andCIdEqualTo(pid).andUserIdEqualTo(userId);
//        }else{
////            collect=list2.stream().map(o->o.getCateValue()).collect(Collectors.toList());
//            shiguCustomerStyleExample.createCriteria().andUserIdEqualTo(userId);
//        }
//        //所有自定义风格
//        List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
//        //返回对象
//        ArrayList<UserGoodsStyleVo> list = new ArrayList<>();
//        if(shiguCustomerStyles!=null&&shiguCustomerStyles.size()>0){
//            List<Long> sids = shiguCustomerStyles.stream().map(ShiguCustomerStyle::getStyleId).collect(Collectors.toList());
//            List<Map<String, Long>> maps = goodsCountForsearchMapper.countGoodsByStyles(userId, sids, webSite);
//            HashMap<Long, Long> sidMap = new HashMap<>(maps.size());
//            for (Map<String, Long> map : maps) {
//                sidMap.put(map.get("sid").longValue(),map.get("COUNT(1)").longValue());
//            }
//            for ( SearchCategory searchCategory    :list2 ){
//                String value =searchCategory.getCateValue();
//                for (ShiguCustomerStyle customerStyle:shiguCustomerStyles) {
//                    if(customerStyle.getCId().equals( Long.valueOf(value))){
//                        UserGoodsStyleVo userGoodsStyleVo = new UserGoodsStyleVo();
//                        userGoodsStyleVo.setGoodsStyleName(customerStyle.getStyleName());
//                        userGoodsStyleVo.setGoodsStyleId(customerStyle.getStyleId());
//                        userGoodsStyleVo.setCategoryId(customerStyle.getCId());
//                        userGoodsStyleVo.setCategoryName(searchCategory.getCateName());
//                        long i=0;
//                        if( sidMap.get(customerStyle.getStyleId())!=null){
//                            i=sidMap.get(customerStyle.getStyleId());
//                        }
//                        userGoodsStyleVo.setGoodsNum(i);
//                        list.add(userGoodsStyleVo);
//                    }
//                }
//            }
//        }else {
//            return null;
//        }
//        return list;
//    }
//
//    /**
//     * 获取类目列表
//     */
//    public List<CategoryVo> getCategory(String website){
//        SearchCategoryExample example = new SearchCategoryExample();
//        example.createCriteria().andTypeEqualTo(1).andWebSiteEqualTo(website);
//        List<SearchCategory> list = SearchCategoryMapper.selectByExample(example);
//        List<CategoryVo> categoryVos = new ArrayList();
//        for (SearchCategory searchCategory:list) {
//            CategoryVo categoryVo = new CategoryVo();
//            categoryVo.setCategoryId(Long.valueOf(searchCategory.getCateValue()));
//            categoryVo.setCategoryName(searchCategory.getCateName());
//            categoryVos.add(categoryVo);
//        }
//        return categoryVos;
//    }
//
//    /**
//     * 添加自定义风格
//     * @param categoryId
//     * @param goodsStyleName
//     * @param
//     * @param userId
//     */
//    public Long addCustomerStyle(Long categoryId, String goodsStyleName, Long userId) {
//        Long aLong = ItemAddOrUpdateService.addCustomerStyle(categoryId, goodsStyleName, userId);
//        return aLong;
//    }
//
//    /**
//     * 修改自定义风格
//     * @param
//     * @param categoryId
//     * @param goodsStyleId
//     * @param goodsStyleName
//     * @param userId
//     */
//    public Long updateCustomerStyle(Long categoryId, Long goodsStyleId, String goodsStyleName, Long userId) {
//        Long aLong = ItemAddOrUpdateService.updateCustomerStyle(categoryId, goodsStyleId, goodsStyleName, userId);
//        return aLong;
//    }
//
//    /**
//     * 删除自定义风格
//     * @param
//     * @param userId
//     * @param website
//     * @param goodsStyleId
//     */
//    public void delCustomerStyle(Long goodsStyleId, Long userId, String website, Long shopId) {
//        if(goodsStyleId!=null){
//            ItemAddOrUpdateService.deleteCustomerStyle(goodsStyleId,userId,website,shopId);
//        }
//    }
//
//    /**
//     * 移动商品风格排序
//     * @param goodsStyleId
//     * @param sortType
//     */
//    public void sortCustomerStyle(Long goodsStyleId, Integer sortType) {
//        ItemAddOrUpdateService.moveSortCustomerStyle(goodsStyleId,sortType);
//    }
//
//    /**
//     * 查类目选项卡数据
//     * @param webSite
//     * @param shopId
//     * @param userId
//     */
//    public List<CategoryTabsVo> selCategoryTabVos(String webSite, Long shopId, Long userId) {
//        SearchCategoryExample example = new SearchCategoryExample();
//        example.createCriteria().andTypeEqualTo(1).andWebSiteEqualTo(webSite);
//        //主类目
//        List<SearchCategory> list = SearchCategoryMapper.selectByExample(example);
//        if (list.isEmpty()) {
//            return Collections.emptyList();
//        }
//        //返回数据
//        List<CategoryTabsVo> categoryTabsVos = new ArrayList();
//        //主类目 值
//        List<Long> collect = list.stream().map(o->Long.valueOf(o.getCateValue())).collect(Collectors.toList());
//
//        ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
//        shiguCustomerStyleExample.createCriteria().andCIdIn(collect).andUserIdEqualTo(userId);
//        //风格集合
//        List<ShiguCustomerStyle> shiguCustomerStyles1 = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
//
//        if(shiguCustomerStyles1!=null && shiguCustomerStyles1.size()>0 ) {
//
//            //风格id集合
//            List<Long> sids = shiguCustomerStyles1.stream().map(ShiguCustomerStyle::getStyleId).collect(Collectors.toList());
//            //
//            List<Map<String, Long>> maps =new ArrayList<>();
//
//            maps = goodsCountForsearchMapper.countGoodsByStyles(userId, sids, webSite);
//            for (SearchCategory searchCategory:list) {
//                CategoryTabsVo categoryTabsVo = new CategoryTabsVo();
//                categoryTabsVo.setCateId(searchCategory.getCateValue());
//                categoryTabsVo.setCateName(searchCategory.getCateName());
//                Long i=0L;
//                Long cid = Long.valueOf(searchCategory.getCateValue());
//                HashMap<Long, Long> sidMap = new HashMap<>(maps.size());
//                for (Map<String, Long> map : maps) {
//                    Long sid = map.get("sid");
//                    Long count = map.get("COUNT(1)");
//                    sidMap.put(sid,count);
//                }
//                for (ShiguCustomerStyle style:shiguCustomerStyles1) {
//                    if( sidMap.get(style.getStyleId())!=null && style.getCId() .equals(cid) ){
//                            i = i+ sidMap.get(style.getStyleId());
//                    }
//                }
//                categoryTabsVo.setGoodsNum(i);
//                categoryTabsVos.add(categoryTabsVo);
//            }
//        }
//        return categoryTabsVos;
//    }
//}
