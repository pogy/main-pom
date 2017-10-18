package com.shigu.phone.waps.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.beans.app.AppItemKv;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.ImgSearchRequest;
import com.openJar.requests.app.ItemSearchRequest;
import com.openJar.requests.app.OneItemRequest;
import com.openJar.responses.app.ImgSearchResponse;
import com.openJar.responses.app.ItemSearchResponse;
import com.openJar.responses.app.OneItemResponse;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.newcdn.vo.CdnGoodsInfoVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.phone.baseservices.BasePhoneGoodsSearchService;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.vo.GoodsInSearch;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class WapPhoneGoodsSearchService {

    @Autowired
    private BasePhoneGoodsSearchService basePhoneGoodsSearchService;

    /**
     * 移动端商品搜索
     * @return
     */
    public ItemSearchVO itemSearch(SearchBO bo,String orderBy ) {
        return basePhoneGoodsSearchService.itemSearch(bo, orderBy);
    }

    /**
     * 移动端图搜
     * @return
     */
    public  List<AppGoodsBlock> imgSearch(String imgUrl,String webSite) throws IOException {
       return basePhoneGoodsSearchService.imgSearch(imgUrl, webSite);
    }

    /**
     * app单商品信息
     * @return
     */
    public OneItemVO oneItem(String webSite,Long itemId,Long userId) throws CdnException, TemplateException, IOException {
       return basePhoneGoodsSearchService.oneItem(webSite, itemId, userId);
    }

}
