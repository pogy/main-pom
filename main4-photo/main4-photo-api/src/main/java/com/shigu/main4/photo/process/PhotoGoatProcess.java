package com.shigu.main4.photo.process;

import com.shigu.main4.photo.vo.GoatAuthorVO;
import com.shigu.main4.photo.vo.GoatBannerVO;
import com.shigu.main4.photo.vo.GoatMenuVO;
import com.shigu.main4.photo.vo.PhotoWorksVO;

import java.util.List;

public interface PhotoGoatProcess {
    /**
     * 获取首页左侧导航栏
     * @return
     */
    List<GoatMenuVO> selMenus();

    /**
     * 获取首页轮播图
     * @return
     */
    List<GoatBannerVO> selBanner();

    /**
     * 获取首页右下方广告图
     * @return
     */
    String selRightImg();

    /**
     * 获取广告模特数据
     * @return
     */
    List<GoatAuthorVO> selModel();

    /**
     * 获取广告摄影机构数据
     * @return
     */
    List<GoatAuthorVO> selOff();

    /**
     * 获取广告商品
     * @return
     */
    List<PhotoWorksVO> selWorks();
}
