package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShopSize;
import com.opentae.data.mall.beans.ShopVideoTime;
import com.opentae.data.mall.examples.ShopSizeExample;
import com.opentae.data.mall.examples.ShopVideoTimeExample;
import com.opentae.data.mall.interfaces.ShopVideoTimeMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.tools.OssFile;
import com.shigu.seller.vo.FileSizeVO;
import com.shigu.seller.vo.VideoFileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService extends GoodsFileService{

    @Autowired
    ShopVideoTimeMapper shopVideoTimeMapper;

    @PostConstruct
    private void init() {
        super.setBucketName("shigu-media");
        super.setDomain("http://media.571xz.com/");
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

    public VideoFileVo upload(Long shopId, String vid,String time) throws JsonErrException {
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
        ShopVideoTime shopVideoTime=new ShopVideoTime();
        shopVideoTime.setShopId(shopId);
        shopVideoTime.setVideo(vid);
        shopVideoTime.setTime(time);
        shopVideoTimeMapper.insert(shopVideoTime);
//        fileVO.setVideoTime(new Date().getTime());
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
            ShopVideoTimeExample shopVideoTimeExample=new ShopVideoTimeExample();
            shopVideoTimeExample.createCriteria().andShopIdEqualTo(shopId).andVideoEqualTo(videoFileVo.getTitle());
            List<ShopVideoTime> shopVideoTimes=shopVideoTimeMapper.selectByExample(shopVideoTimeExample);
            if(shopVideoTimes.size()==0){
                videoFileVo.setVideoTime("时长未知");
            }else {
                videoFileVo.setVideoTime(shopVideoTimes.get(0).getTime());
            }
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

    /*public static boolean download(String urlString, String filename,int timeout){
        boolean ret = false;
        File file = new File(filename);
        try {
            if(file.exists()){
                ret = true;
            }else{
                // 构造URL
                URL url = new URL(urlString);
                // 打开连接
                HttpURLConnection con = (HttpURLConnection )url.openConnection();
                con.setConnectTimeout(timeout);
                con.setReadTimeout(timeout);
                con.connect();
                int contentLength = con.getContentLength();
                // 输入流
                InputStream is = con.getInputStream();
                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流

                file.createNewFile();//创建文件
                OutputStream os = new FileOutputStream(file);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                os.close();
                is.close();
                if(contentLength != file.length()){
                    file.delete();
                    ret = false;
                }else{
                    ret = true;
                }
            }
        } catch (IOException e) {
            file.delete();
            ret = false;
        }finally {
            return ret;
        }
    }*/

    /*public String getTime(String filename){
        File source = new File(filename);
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            int second = (int)Math.ceil(Double.valueOf(String.valueOf(ls)) / 1000.00);
            int min=0;
            if(second>60L){
                min=second/60;
                second=second%60;
            }
            source.delete();
            if(min<10){
                return "0"+min+":"+second;
            }else{
                return min+":"+second;
            }
        } catch (Exception e) {
            source.delete();
            e.printStackTrace();
        }
        return "";
    }*/
}
