package com.shigu.productAi.services;

import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import cn.productai.api.core.exceptions.ClientException;
import cn.productai.api.pai.entity.dataset.DataSetBatchXzAddRequest;
import cn.productai.api.pai.entity.dataset.DataSetBatchXzDeleteRequest;
import cn.productai.api.pai.entity.dataset.DataSetModifyResponse;
import cn.productai.api.pai.entity.search.ImageSearchByImageUrlRequest;
import cn.productai.api.pai.entity.search.ImageSearchResponse;
import cn.productai.api.pai.response.SearchResult;
import com.shigu.productAi.beans.*;
import com.shigu.productAi.configs.ProductAiConfig;
import com.shigu.productAi.utils.DataConvertUtil;
import com.shigu.productAi.utils.ProductAiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-07-12.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class ProductAiService implements ProductAiInterface{
    private final Logger log = LoggerFactory.getLogger(ProductAiService.class);
    @Autowired
    ProductAiClient aiClient;
    @Autowired
    ProductAiConfig aiConfig;
    @Override
    public ProductAiVo addAi(ProductAiAddBo bo) {
        ProductAiVo vo =new ProductAiVo();
        IWebClient client = aiClient.getClient();
        List<AiImageInfo> images = bo.getImages();
        //调用添加单个接口


        byte[] bytes = DataConvertUtil.dataToMLBytes(images);

        DataSetBatchXzAddRequest request = new DataSetBatchXzAddRequest(aiConfig.imageSetId);
        request.setBytes(bytes);
            request.setLanguage(LanguageType.Chinese);

            try {
                DataSetModifyResponse response = client.getResponse(request);

                vo.setImageSetId(response.getDataSetId());
                vo.setImageSetName(response.getDataSetName());
                vo.setRequestId(response.getRequestId());
            } catch (cn.productai.api.core.exceptions.ServerException e) {

                log.error("码隆搜图服务错误，错误码:" + e.getErrorCode() + "\r\n 错误信息: " + e.getErrorMessage()
                        + "\r\n 请求id:" + e.getRequestId()
                );

            } catch (ClientException e) {
                log.error("码隆搜图身份错误，错误码:" + e.getErrorCode() + "\r\n 错误信息: "
                        + e.getErrorMessage() + "\r\n 请求id:" + e.getRequestId());

            } catch (Exception e) {
                log.error("码隆搜图错误:", e);
            }
            return vo;




    }

    @Override
    public List<AiImageInfo> search(ProductAiSearchBo bo) {
        IWebClient client = aiClient.getClient();


        ImageSearchByImageUrlRequest request = new ImageSearchByImageUrlRequest(aiConfig.clothesSearchId);
        request.setUrl(bo.getUrl());
        request.setCount(bo.getCount());

        request.setLoc(bo.getIoc());
        request.tags = bo.getTags();
//        if(bo.getTags()!=null) {
//            String[] strings = bo.getTags().split("\\|");
//            ITag tags = new SearchTag();
//            request.setSearchTag(tags);
//            ISearchTag tag = new AndTag();
//            for(String tagstr:strings) {
//                tag.Add(tagstr);
//            }
//            tags.setTag(tag);
//        }
        request.setLanguage(LanguageType.Chinese);
        List<AiImageInfo> images = new ArrayList<>();
        try {
            ImageSearchResponse response = client.getResponse(request);

            String standard = null;
            SearchResult[] results = response.getResults();
            for (int i=0;i<results.length;i++) {
                SearchResult result = results[i];
                //测试库不存在标签
                String[] metas = result.getMetadata().split("-");
                if(i == 0 && metas.length>1){
                    standard = metas[1];
                }
//
                if(standard!=null && (metas.length <= 1 || !standard.equals(metas[1]))){
                     continue;
                }
                AiImageInfo info = new AiImageInfo();
                info.setImageUrl(result.getUrl());
                info.setScore(result.getScore());
                info.setMeta(result.getMetadata());
                images.add(info);
            }

        } catch (cn.productai.api.core.exceptions.ServerException e) {

            log.error("码隆搜图服务错误，错误码:" + e.getErrorCode() + "\r\n 错误信息: " + e.getErrorMessage()
                    + "\r\n 请求id:" + e.getRequestId()
            );

        } catch (ClientException e) {
            log.error("码隆搜图身份错误，错误码:"+e.getErrorCode()+"\r\n 错误信息: "
                    +e.getErrorMessage()+"\r\n 请求id:"+e.getRequestId());

        } catch (Exception e) {
             log.error("码隆搜图错误:",e);
        }




        return images;
    }

    @Override
    public ProductAiVo delete(ProductAiDelBo bo) {
        ProductAiVo vo =new ProductAiVo();
        byte[] bytes = DataConvertUtil.dataToMLBytes(bo.getImages());
        DataSetBatchXzDeleteRequest request =new DataSetBatchXzDeleteRequest(aiConfig.imageSetId);
        request.setBytes(bytes);
        IWebClient client = aiClient.getClient();
        try {
            DataSetModifyResponse response = client.getResponse(request);
            vo.setImageSetId(response.getDataSetId());
            vo.setImageSetName(response.getDataSetName());
            vo.setRequestId(response.getRequestId());
        }  catch (cn.productai.api.core.exceptions.ServerException e) {

            log.error("码隆搜图服务错误，错误码:" + e.getErrorCode() + "\r\n 错误信息: " + e.getErrorMessage()
                    + "\r\n 请求id:" + e.getRequestId()
            );

        } catch (ClientException e) {
            log.error("码隆搜图身份错误，错误码:"+e.getErrorCode()+"\r\n 错误信息: "
                    +e.getErrorMessage()+"\r\n 请求id:"+e.getRequestId());

        } catch (Exception e) {
             log.error("码隆搜图错误:",e);
        }


        return vo;
    }
}
