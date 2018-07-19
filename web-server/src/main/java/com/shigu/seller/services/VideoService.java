package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShopSize;
import com.opentae.data.mall.examples.ShopSizeExample;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.tools.OssFile;
import com.shigu.seller.vo.FileSizeVO;
import com.shigu.seller.vo.VideoFileVo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VideoService extends GoodsFileService{

    @PostConstruct
    private void init() {
        super.setBucketName("shigu-media");
        super.setDomain("https://media.571xz.com/");
    }

    @Override
    public Long shopDataSize(Long shopId) {
        ShopSizeExample shopSizeExample=new ShopSizeExample();
        shopSizeExample.createCriteria().andShopIdEqualTo(shopId);
        List<ShopSize> shopSizes=shopSizeMapper.selectByExample(shopSizeExample);
        if(shopSizes.size()==0){
            return DEFAULT_SIZE;
        }else if(shopSizes.get(0).getVideoSize()==null){
            return DEFAULT_SIZE;
        }else {
            return shopSizes.get(0).getVideoSize()*1024;
        }
    }

    @Override
    public boolean deleteFile(Long shopId, String fileKey, String fileType) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            fileKey = fileKey +"/";
        }
        String path=getHomeDir(shopId)+fileKey;
        return super.deleteFile(path);
    }

    public VideoFileVo upload(Long shopId, String vid) throws JsonErrException {
        //取新文件大小
        Long newSize=super.getSizeInfo(getTempDir(shopId)+vid)/1024;
        //取已存总大小
        Long hadSize=super.getSizeInfo(getHomeDir(shopId))/1024;
        //取容量
        Long shopSize=shopDataSize(shopId);
        if(newSize+hadSize>shopSize){//超了
            throw new JsonErrException("容量超出,上传失败");
        }
        //迁移
        super.moveFile(getTempDir(shopId)+vid, getHomeDir(shopId)+vid);
        VideoFileVo fileVO=new VideoFileVo();
        fileVO.setVideoId(vid);
        fileVO.setTitle(vid);
        fileVO.setVideoTime(new Date().getTime());
        BeanMapper.map(sizeparseToShow(newSize.doubleValue()),fileVO);
        return fileVO;
    }

    public List<VideoFileVo> selFilesByVid(Long shopId, String vid) {
        List<OssFile> files = super.getFileList(parseMyFilePath(shopId,vid));
        List<VideoFileVo> newFiles = new ArrayList<>();
//        List<String> fileKeys=BeanMapper.getFieldList(files,"videoId",String.class);//文件ID
        for (OssFile item : files) {
            VideoFileVo videoFileVo=new VideoFileVo();
//            fileKeys.add(item.getVideoId());
            videoFileVo.setVideoId(item.getFileId().replace(getHomeDir(shopId),""));
            videoFileVo.setTitle(item.getFileName().replace(getHomeDir(shopId),""));
            videoFileVo.setVideoSrc(super.getDomain()+ item.getFileName());
            double fileSize = Double.parseDouble(item.getFileSize());
            FileSizeVO fileSizeVO=sizeparseToShow(fileSize);
            videoFileVo.setVideoSize(fileSizeVO.getFileSize()+fileSizeVO.getUnit());
            videoFileVo.setVideoTime(item.getFileCreateTime());
            newFiles.add(videoFileVo);
        }
        return newFiles;
    }

    private String getHomeDir(Long shopId) {
        return  ROOT_PATH + shopId + "/zip/";
    }

    /**
     * 转换用户目录到绝对路径
     * @param shopId
     * @param vid
     * @return
     */
    private String parseMyFilePath(Long shopId,String vid){
        return getHomeDir(shopId)+(vid==null?"":vid);
    }

    /**
     * 得到用户临时目录
     * @param shopId
     * @return
     */
    private String getTempDir(Long shopId) {
        return ROOT_PATH + shopId + "/temp/";
    }
}
