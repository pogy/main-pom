package com.shigu.main4.cdn.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.session.main4.PersonalSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

import static com.opentae.data.mall.examples.ShiguShopApplyExample.tbUrl;

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
            if (!isVideoUrl(linkUrl)) {
                throw new JsonErrException("不提供该格式的视频下载");
            }
            int point = linkUrl.lastIndexOf(".");
            String fileFormat = linkUrl.substring(point);
            CdnShopInfoVO shopInfoVO = cdnService.cdnShopInfo(cdnItem.getShopId());
            URL url = new URL(linkUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufIn = new BufferedInputStream(urlConnection.getInputStream());
            ServletOutputStream out = resp.getOutputStream();
            resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(String.format("%s-%s-%s-%d%s", shopInfoVO.getMarketName(), shopInfoVO.getShopNo(), cdnItem.getHuohao(), goodsId, fileFormat), "UTF-8"));
            byte[] bytes = new byte[8096];
            int readLen = -1;
            while ((readLen = bufIn.read(bytes)) > -1) {
                out.write(bytes, 0, readLen);
                out.flush();
            }
            bufIn.close();
            out.close();
        } catch (Exception e) {
            throw new JsonErrException(e.getMessage());
        }
    }

    /**
     * 判断是否是支持的视频格式
     * @param videoUrl
     * @return
     */
    public boolean isVideoUrl(String videoUrl) {
        if (videoUrl == null) {
            return false;
        }
        if (videoUrl.endsWith(".mp4") || videoUrl.endsWith(".MP4")
                || videoUrl.endsWith(".webm") || videoUrl.endsWith(".WEBM")
                || videoUrl.endsWith("ogg") || videoUrl.endsWith("OGG")) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是淘宝的的主图视频地址
     * @param tbUrl
     * @return
     */
    public boolean isTbUrl(String tbUrl) {
        if (tbUrl.startsWith("http://cloud.video.taobao.com")
                || (tbUrl.startsWith("https://cloud.video.taobao.com"))){
            return true;
        }
        return false;
    }

}
