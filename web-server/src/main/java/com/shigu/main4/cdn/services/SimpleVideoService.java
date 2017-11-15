package com.shigu.main4.cdn.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类名：SimpleVideoService
 * 类路径：com.shigu.main4.cdn.services.SimpleVideoService
 * 创建者：王浩翔
 * 创建时间：2017-11-15 17:55
 * 项目：main-pom
 * 描述：
 */
@Service
public class SimpleVideoService {

    @Autowired
    private ShowForCdnService showForCdnService;

    @Autowired
    private CdnService cdnService;

    public void downloadVideo(Long goodsId, HttpServletResponse resp) throws JsonErrException {
        CdnItem cdnItem = showForCdnService.selItemById(goodsId);
        try {
            String linkUrl = cdnItem.getGoodsVideoUrl();
            int point = linkUrl.lastIndexOf(".");
            String fileFormat = linkUrl.substring(point);
            CdnShopInfoVO shopInfoVO = cdnService.cdnShopInfo(cdnItem.getShopId());
            URL url = new URL(linkUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufIn = new BufferedInputStream(urlConnection.getInputStream());
            ServletOutputStream out = resp.getOutputStream();
            resp.addHeader("Content-Disposition",String.format("attachment;filename=%s-%s-%s-%d%s",shopInfoVO.getMarketName(),shopInfoVO.getShopNo(),cdnItem.getHuohao(),goodsId,fileFormat));
            byte[] bytes = new byte[8096];
            int readLen = -1;
            while ((readLen = bufIn.read(bytes))>-1){
                out.write(bytes,0,readLen);
                out.flush();
            }
            bufIn.close();
            out.close();
        } catch (Exception e){
            throw new JsonErrException(e.getMessage());
        }
    }
}
