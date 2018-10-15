package com.shigu.activity.service;

import com.shigu.activity.vo.NewActivityVO;

import java.util.List;

public interface ActivityForShowInterface {

    void add(Long userId,List activeForShowVOList,NewActivityVO newActivityVO);
}
