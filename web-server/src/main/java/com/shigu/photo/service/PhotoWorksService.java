package com.shigu.photo.service;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.photo.bo.PhotoWorksBO;
import com.shigu.photo.bo.PhotoWorksSearchBO;
import com.shigu.photo.exceptions.PhotoException;
import com.shigu.photo.process.PhotoUserProcess;
import com.shigu.photo.process.PhotoWorksProcess;
import com.shigu.photo.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 路径: com.shigu.photo.service.PhotoWorksService
 * 工程: main-pom
 * 时间: 18-4-26 下午1:42
 * 创建人: wanghaoxiang
 * 描述:
 */
@Service
public class PhotoWorksService {


    @Autowired
    private PhotoWorksProcess photoWorksProcess;

    @Autowired
    private PhotoUserProcess photoUserProcess;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    /**
     * 作品详情信息
     *
     * @param worksId
     * @return
     */
    public PhotoWorksDetailWebVO photoWorksDetail(Long worksId) {
        if (worksId == null) {
            return null;
        }
        PhotoWorkDetailVO photoWorkDetailVO = photoWorksProcess.selPhotoWorkDetail(worksId);
        if (photoWorkDetailVO == null) {
            return null;
        }
        // 页面显示作品信息
        PhotoWorksDetailWebVO worksDetail = new PhotoWorksDetailWebVO();
        worksDetail.setTitle(photoWorkDetailVO.getTitle());
        worksDetail.setDesc(photoWorkDetailVO.getContent());
        worksDetail.setCoverImgSrc(photoWorkDetailVO.getPicUrl());
        worksDetail.setPrice(photoWorkDetailVO.getPriceStr());
        worksDetail.setStyle(photoWorkDetailVO.getStylesStr());
        worksDetail.setPublishedTime(sdf.format(photoWorkDetailVO.getCreateTime()));
        worksDetail.setThumbUpCount(photoWorkDetailVO.getPraiseNum());
        worksDetail.setAuthorId(photoWorkDetailVO.getAuthorId());
        String imgsStr = photoWorkDetailVO.getImgs();
        if (StringUtils.isNotBlank(imgsStr)) {
            List<String> imgList = Arrays.asList(imgsStr.split(","));
            worksDetail.setImgList(imgList);
        }
        worksDetail.setUserThumbUpIs(false);
        return worksDetail;
    }

    /**
     * 作品详情信息，包含已登陆用户相关状态
     * @param worksId
     * @param userId
     * @return
     */
    public PhotoWorksDetailWebVO photoWorksDetailForUser(Long worksId, Long userId) {
        PhotoWorksDetailWebVO vo = photoWorksDetail(worksId);
        if (vo == null) {
            return null;
        }
        if (userId != null) {
            vo.setUserThumbUpIs(photoUserProcess.isPraised(userId, worksId));
        }
        return vo;
    }


    public ShiguPager<PhotoWorksSearchVO> selList(PhotoWorksSearchBO query) throws PhotoException {
        PhotoWorksBO photoWorksBO = query.toPhotoWorksBO();
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(photoWorksBO);
        ShiguPager<PhotoWorksSearchVO> pager=new ShiguPager<>();
        pager.setNumber(pager.getNumber());
        pager.calPages(pager.getTotalCount(),photoWorksBO.getPageSize());
        pager.setContent(photoWorksVOShiguPager.getContent().stream()
            .map(PhotoWorksService::toSearchVO).collect(Collectors.toList()));
        return pager;
    }

    public static PhotoWorksSearchVO toSearchVO(PhotoWorksVO photoWorksVO){
        PhotoWorksSearchVO vo=new PhotoWorksSearchVO();
        vo.setId(photoWorksVO.getAuthorId());
        vo.setAddress(photoWorksVO.getAddress());
        vo.setImgsrc(photoWorksVO.getPicUrl());
        vo.setNick(photoWorksVO.getAuthorName());
        vo.setPublishedTime(DateUtil.dateToString(photoWorksVO.getCreateTime(),DateUtil.patternA));
        vo.setTypeName(PhotoUserService.selAuthType(photoWorksVO.getUserType(),photoWorksVO.getSex()));
        vo.setWorksId(photoWorksVO.getWorksId());
        return vo;
    }

    /**
     * 获取风格列表，传入userId时，会额外取出该用户自定义风格
     * @param userId
     * @return
     */
    public List<PhotoWorksStyleVO> selStyleListWithUser(Long userId) {
        return photoWorksProcess.selPhotoStyleVos(userId).stream().map(o -> {
            PhotoWorksStyleVO vo = new PhotoWorksStyleVO();
            vo.setId(o.getStyleId());
            vo.setText(o.getStyleName());
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * 获取编辑坐票用的信息
     * @param worksId
     * @return
     */
    public PhotoWorksChangeVO selUpdateBean(Long worksId){
        PhotoWorksUpdateVO photoWorksUpdateVO = photoWorksProcess.selPhotoSingel(worksId);
        if(photoWorksUpdateVO==null){
            return null;
        }
        PhotoWorksChangeVO vo=new PhotoWorksChangeVO();
        vo.setCate(photoWorksUpdateVO.getWorksCid());
        vo.setCover(photoWorksUpdateVO.getPicUrl());
        vo.setDesc(photoWorksUpdateVO.getContent());
        vo.setImgs(Arrays.asList(photoWorksUpdateVO.getImages().split(",")));
        vo.setPrice(photoWorksUpdateVO.getHavePrice()?0:1);
        vo.setSaveType(photoWorksUpdateVO.getForbidSave()?1:0);
        vo.setTitle(photoWorksUpdateVO.getTitle());
        vo.setWorksId(photoWorksUpdateVO.getWorksId());
        return vo;
    }


}
