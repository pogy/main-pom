package com.shigu.main4.ucenter.services.impl;


import com.opentae.data.mall.beans.MemberLoginRecord;
import com.opentae.data.mall.examples.MemberLoginRecordExample;
import com.opentae.data.mall.interfaces.MemberLoginRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员登录记录
 *
 * @author shigu_zjb
 * @date 2017/02/22 13:04
 *
 */
@Service("memberLoginRecordServiceImpl")
public class MemberLoginRecordServiceImpl {

    @Resource(name = "tae_mall_memberLoginRecordMapper")
    private MemberLoginRecordMapper memberLoginRecordMapper;

    /**
     * 查找会员登录信息
     * @return
     */
    public List<MemberLoginRecord> findLoginRecordList(int pageNo, int pageSize) {
        if(pageNo == 0 || pageSize == 0){
            return new ArrayList<MemberLoginRecord>();
        }
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = pageNo * pageSize;
        MemberLoginRecordExample example = new MemberLoginRecordExample();
        example.setStartIndex(startIndex);
        example.setEndIndex(endIndex);
        List<MemberLoginRecord> memberLoginRecordList = memberLoginRecordMapper.selectByConditionList(example);
        return memberLoginRecordList;
    }

}
