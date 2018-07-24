package com.shigu.photo.service;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.photo.bo.PhotoWorksBO;
import com.shigu.main4.photo.exceptions.PhotoException;
import com.shigu.main4.photo.process.PhotoUserProcess;
import com.shigu.main4.photo.process.PhotoWorksProcess;
import com.shigu.main4.photo.vo.PhotoWorkDetailVO;
import com.shigu.main4.photo.vo.PhotoWorksUpdateVO;
import com.shigu.main4.photo.vo.PhotoWorksVO;
import com.shigu.photo.vo.PhotoWorksChangeVO;
import com.shigu.photo.vo.PhotoWorksDetailWebVO;
import com.shigu.photo.vo.PhotoWorksSearchVO;
import com.shigu.photo.vo.PhotoWorksStyleVO;
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
     * 作品详情信息，包含已登陆用户相关状态
     *
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
        //作者userId  外层一律使用userId,隐藏实际authId
        worksDetail.setAuthorId(photoWorkDetailVO.getUserId());
        worksDetail.setSaveType(0);
        if (photoWorkDetailVO.getForbidSave() != null && photoWorkDetailVO.getForbidSave()) {
            worksDetail.setSaveType(1);
        }
        String imgsStr = photoWorkDetailVO.getImgs();
        if (StringUtils.isNotBlank(imgsStr)) {
            List<String> imgList = Arrays.asList(imgsStr.split(","));
            worksDetail.setImgList(imgList);
        }
        worksDetail.setUserThumbUpIs(false);
        return worksDetail;
    }


    public ShiguPager<PhotoWorksSearchVO> selList(PhotoWorksBO photoWorksBO) throws PhotoException {
        ShiguPager<PhotoWorksVO> photoWorksVOShiguPager = photoWorksProcess.selPhotoWorksVos(photoWorksBO);
        ShiguPager<PhotoWorksSearchVO> pager = new ShiguPager<>();
        pager.setNumber(photoWorksVOShiguPager.getNumber());
        pager.calPages(photoWorksVOShiguPager.getTotalCount(), photoWorksBO.getPageSize());
        pager.setContent(photoWorksVOShiguPager.getContent().stream()
                .map(PhotoWorksService::toSearchVO).collect(Collectors.toList()));
        return pager;
    }

    public static PhotoWorksSearchVO toSearchVO(PhotoWorksVO photoWorksVO) {
        PhotoWorksSearchVO vo = new PhotoWorksSearchVO();
        vo.setId(photoWorksVO.getUserId());
        vo.setAddress(photoWorksVO.getAddress());
        vo.setImgsrc(photoWorksVO.getPicUrl());
        vo.setNick(photoWorksVO.getAuthorName());
        vo.setPublishedTime(DateUtil.dateToString(photoWorksVO.getCreateTime(), DateUtil.patternA));
        vo.setTypeName(PhotoUserService.selAuthType(photoWorksVO.getUserType(), photoWorksVO.getSex()));
        vo.setWorksId(photoWorksVO.getWorksId());
        vo.setTitle(photoWorksVO.getTitle());
        if(photoWorksVO.getAuthStatus()!=1){
            vo.setCheckState(photoWorksVO.getAuthStatus()==0?1:2);
        }
        return vo;
    }

    /**
     * 获取风格列表，传入userId时，会额外取出该用户自定义风格
     *
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
     *
     * @param worksId
     * @return
     */
    public PhotoWorksChangeVO selUpdateBean(Long worksId) {
        PhotoWorksUpdateVO photoWorksUpdateVO = photoWorksProcess.selPhotoSingel(worksId);
        if (photoWorksUpdateVO == null) {
            return null;
        }
        PhotoWorksChangeVO vo = new PhotoWorksChangeVO();
        vo.setCate(photoWorksUpdateVO.getWorksCid());
        vo.setCover(photoWorksUpdateVO.getPicUrl());
        vo.setDesc(photoWorksUpdateVO.getContent());
        vo.setImgs(Arrays.asList(photoWorksUpdateVO.getImages().split(",")));
        vo.setPrice(photoWorksUpdateVO.getHavePrice() ? 0 : 1);
        vo.setSaveType(photoWorksUpdateVO.getForbidSave() ? 1 : 0);
        vo.setTitle(photoWorksUpdateVO.getTitle());
        vo.setWorksId(photoWorksUpdateVO.getWorksId());
        vo.setStyleIds(photoWorksUpdateVO.getStyleIds());
        return vo;
    }


}
