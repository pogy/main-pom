package com.shigu.goodsup.pinduoduo.service;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.goodsup.pinduoduo.vo.ItemColorPropVO;
import com.shigu.goodsup.pinduoduo.vo.PddItemDetailVO;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.HtmlImgsLazyLoad;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gtx on 2018/6/18.
 * 一键上传拼多多
 * @author gtx
 * @since
 */
@Service
public class PddGoodsUpService {

    @Resource
    private ShowForCdnService showForCdnService;
    @Resource(name = "tae_mall_memberUserSubMapper")
    private MemberUserSubMapper memberUserSubMapper;

    /**
     * 获取上传页面商品数据
     */
    /**
     * app单商品信息
     * @return
     */
    public PddItemDetailVO goodsDetail(Long itemId, Long userId) {
        PddItemDetailVO vo = new PddItemDetailVO();
        //商品数据填充
        CdnItem cdnItem = showForCdnService.selItemById(itemId);
        if(cdnItem==null){//已经下架
            cdnItem=showForCdnService.selItemInstockById(itemId);
        }
        if(cdnItem==null){//商品不存在
            return null;
        }
        vo.setGoodsId(itemId.toString());
        vo.setGoodsNo(cdnItem.getHuohao());
        vo.setPrice(cdnItem.getPiPrice());
        vo.setTitle(cdnItem.getTitle());
        //a. 尺寸 等宽高 宽高不低于480px
        //b. 大小1M
        //c. 图片格式仅支持JPG,PNG格式
//        vo.setImgSrcs(cdnItem.getImgUrl().stream().map(s -> ImgUtils.formatImg(s, ImgFormatEnum.GOODS_HEAD_IMAGES)).collect(Collectors.toList()));
        vo.setLiPrice(cdnItem.getPrice());

        BigDecimal liPrce = new BigDecimal(cdnItem.getPrice());
        BigDecimal piPrce = new BigDecimal(cdnItem.getPiPrice());
        BigDecimal subtract = liPrce.subtract(piPrce);
        subtract = subtract.setScale(2, BigDecimal.ROUND_HALF_UP);

        if (subtract.doubleValue() < 0) {
            vo.setProfit("0.00");
        }else {
            vo.setProfit(subtract.toString());
        }

        //a. 尺寸要求宽度处于480~1200px之间，高度0-1500px之间
        //b. 大小1M以内
        //c. 图片格式仅支持JPG,PNG格式
        if(cdnItem.getDescription()!=null){
            vo.setDetailsImgs(getDetailImgs(HtmlImgsLazyLoad.replaceLazyLoad(cdnItem.getDescription())));
        }

        vo.setColors(cdnItem.getColors().stream().map(item->{
            ItemColorPropVO itemColorProp = new ItemColorPropVO();
            itemColorProp.setText(item.getValue());
            itemColorProp.setImgSrc(item.getImgUrl());
            return itemColorProp;
        }).collect(Collectors.toList()));

        List<SaleProp> sizes=cdnItem.getSizes();
        if(sizes==null || sizes.isEmpty()){
            vo.setSize(Arrays.asList("均码"));
        }else {
            vo.setSize(sizes.stream().map(item-> item.getValue()).collect(Collectors.toList()));
        }

        return vo;
    }

    /**
     * 过滤HTML只返回内容中的 img 地址<br>直接将真实图片地址赋值到src<br>同时返回内容的img标签只包含 src data-original title 三种属性
     * @param source
     * @return
     */
    public  List<String> getDetailImgs(String source){
        if (StringUtil.isNull(source)){
            return null;
        }
        //只接受图片
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("img").addAttributes("img",  "src","data-original", "title").addProtocols("img", "src", "http", "https");
        String cleanSource = Jsoup.clean(source,whitelist);

        Document cleanOriginnal = Jsoup.parse(cleanSource);

        Elements imgs = cleanOriginnal.select("img");
        List<String> imgUrls = new ArrayList<>();
        for (Element img : imgs){
            String imgUrl = img.attr("data-original");
            imgUrls.add(ImgUtils.formatImg(imgUrl, ImgFormatEnum.GOODS_DETAIL));
        }
        return imgUrls;
    }

    /**
     * 根据userId获取用户拼多多id
     * @param userId
     */
    public Long selPddUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setUserId(userId);
        memberUserSub.setAccountType(LoginFromType.PDD.getAccountType());
        memberUserSub = memberUserSubMapper.selectOne(memberUserSub);
        if (memberUserSub != null) {
            return Long.parseLong(memberUserSub.getSubUserKey());
        }
        return null;
    }
}
