package com.shigu.main4.daifa.utils;

import com.opentae.data.daifa.beans.DaifaListDeal;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaListDealExample;
import com.opentae.data.daifa.interfaces.DaifaListDealMapper;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.enums.DaifaListDealTypeEnum;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-05-24.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@Service("tae_daifaListDealUtil")
public class DaifaListDealUtil {
    private DaifaListDealMapper daifaListDealMapper;
    private DaifaWorkerMapper daifaWorkerMapper;

    @Autowired
    public void setDaifaListDealMapper(DaifaListDealMapper daifaListDealMapper) {
        this.daifaListDealMapper = daifaListDealMapper;
    }

    @Autowired
    public void setDaifaWorkerMapper(DaifaWorkerMapper daifaWorkerMapper) {
        this.daifaWorkerMapper = daifaWorkerMapper;
    }

    /**
     * 默认需要 sellerId user_ID(TK_CODE,GGOODS_CODE)要传
     *
     * @param type      类型
     * @param seller_id 代发机构Id
     * @param user_id   代发人员Id
     * @return string
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String queryListCode(DaifaListDealTypeEnum type, Long seller_id, Long user_id) {

        String date = DateUtil.dateToString(new Date(), DateUtil.patternB);
        String listCode;
        switch (type) {
            case TRADE_SORT: {
                DaifaListDealExample example = new DaifaListDealExample();
                example.createCriteria().andTypeEqualTo(type.name()).andSellerIdEqualTo(seller_id).andCreateDateEqualTo(date);
                List<DaifaListDeal> dataList = daifaListDealMapper.selectByExample(example);

                if (dataList.size() > 0) {
                    DaifaListDeal dld = dataList.get(0);
                    int num = dld.getNum() + 1;
                    dld.setNum(num);

                    if (num >= 100) {
                        //字母转ascii码+1，再转成字母
                        if (dld.getRemark3().equals("Z")){
                            dld.setNum(1);
                            dld.setRemark3("A");
                            listCode="A01";
                        }else {
                            int sascii = new Integer(stringToAscii(dld.getRemark3())) + 1;//字母转ascii码
                            String sbm_zm = asciiToString(sascii + "");
                            listCode = sbm_zm + "01";
                            num = 1;
                            dld.setNum(num);
                            dld.setRemark3(sbm_zm);
                        }

                    }
                    else {
                        //数字小于10要加0
                        if (num < 10) {
                            listCode = dld.getRemark3() + "0" + num;
                        } else {
                            listCode = dld.getRemark3() + num;
                        }
                        dld.setRemark3(dld.getRemark3());
                    }

                    dld.setCreateDate(date);
                    dld.setListCode(type.getRule());
                    dld.setSellerId(seller_id);
                    dld.setType(type.name());
                    dld.setUserId(null);
                    dld.setRemark1(listCode);
                    dld.setRemark2(type.getInstruction());
                    daifaListDealMapper.updateByPrimaryKey(dld);
                } else {
                    String date2 = DateUtil.dateToString(DateUtil.addDayV1_8(-1), DateUtil.patternB);
                    DaifaListDeal deal = getDaifaListDeal(type,seller_id,date2);
                    DaifaListDeal dld = new DaifaListDeal();
                    int nums = deal.getNum();
                    dld.setNum(nums);
                    if (nums >= 100) {
                        if (deal.getRemark3().equals("Z")){
                            dld.setNum(1);
                            dld.setRemark3("A");
                            listCode="A01";
                        }else {
                            int sascii = new Integer(stringToAscii(deal.getRemark3())) + 1;
                            String sbm_zm = asciiToString(sascii + "");
                            listCode = sbm_zm + "01";
                            nums = 1;
                            dld.setNum(nums);
                            dld.setRemark3(sbm_zm);
                        }
                    } else {
                        if (nums < 10) {
                            listCode = deal.getRemark3() + "0" + nums;
                        } else {
                            listCode = deal.getRemark3() + nums;
                        }
                        dld.setRemark3(deal.getRemark3());
                    }

                    dld.setCreateDate(date);
                    dld.setListCode(type.getRule());
                    dld.setSellerId(seller_id);
                    dld.setType(type.name());
                    dld.setUserId(null);
                    dld.setRemark1(listCode);
                    dld.setRemark2(type.getInstruction());
                    daifaListDealMapper.insert(dld);
                }
                break;
            }
            default: {
                DaifaWorker worker = daifaWorkerMapper.selectByPrimaryKey(user_id);
                Long accountId = worker.getAccountId();
                listCode = defaultDeal(type, seller_id, user_id, accountId, date);
                break;
            }
        }
        return listCode;

    }

    public DaifaListDeal getDaifaListDeal(DaifaListDealTypeEnum type, Long seller_id,String date){
        DaifaListDeal deal=new DaifaListDeal();
        DaifaListDealExample examples = new DaifaListDealExample();
        examples.createCriteria().andTypeEqualTo(type.name()).andSellerIdEqualTo(seller_id).andCreateDateEqualTo(date);
        List<DaifaListDeal> daifaListDeals = daifaListDealMapper.selectByExample(examples);
        if (daifaListDeals.size()>0){
            deal=daifaListDeals.get(0);
        }else {
            String date2 = DateUtil.dateToString(DateUtil.addDayV1_8(-2), DateUtil.patternB);
            getDaifaListDeal(type,seller_id,date2);
        }
        return deal;
    }


    /**
     * @param type      类型
     * @param seller_id 代发机构Id
     * @param user_id   代发人员Id
     * @param accountId //
     * @param date      时间格式yyyyMMdd
     * @return string
     * @since xx
     */
    private String defaultDeal(DaifaListDealTypeEnum type, Long seller_id, Long user_id, Long accountId, String date) {
        //查询
        String listCode;
        DaifaListDealExample example = new DaifaListDealExample();
        DaifaListDealExample.Criteria ce = example.createCriteria();
        ce.andTypeEqualTo(type.name()).andSellerIdEqualTo(seller_id).andCreateDateEqualTo(date);
        if (type.name().equals(DaifaListDealTypeEnum.TK_CODE.name()) ||
                type.name().equals(DaifaListDealTypeEnum.GGOODS_CODE.name())) {
            ce.andUserIdEqualTo(user_id);
        }

        List<DaifaListDeal> dataList = daifaListDealMapper.selectByExample(example);
        if (dataList.size() > 0) {
            DaifaListDeal dld = dataList.get(0);
            int num = dld.getNum() + 1;
            if (type.name().equals(DaifaListDealTypeEnum.GGOODS_CODE.name())) {
                listCode = type.getTag() + date + "_" + accountId + "_" + num;
            } else {
                listCode = type.getTag() + date + "_" + seller_id + "_" + num;
            }
            dld.setNum(num);
            dld.setRemark1(listCode);

            if (!type.name().equals(DaifaListDealTypeEnum.DAIFA_SEND_CODE.name())) {
                //发货不需要修改
                daifaListDealMapper.updateByPrimaryKey(dld);
            }
        } else {
            if (type.name().equals(DaifaListDealTypeEnum.GGOODS_CODE.name())) {
                listCode = type.getTag() + date + "_" + accountId + "_" + 1;
            } else {
                listCode = type.getTag() + date + "_" + seller_id + "_" + 1;
            }
            DaifaListDeal dld = new DaifaListDeal();
            dld.setNum(1);
            dld.setCreateDate(date);
            dld.setListCode(type.getRule());
            dld.setSellerId(seller_id);
            dld.setUserId(user_id);
            dld.setType(type.name());
            dld.setRemark1(listCode);
            daifaListDealMapper.insert(dld);
        }

        return listCode;
    }


    private static String stringToAscii(String value) {
        StringBuilder sbu = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    private static String asciiToString(String value) {
        StringBuilder sbu = new StringBuilder();
        String[] chars = value.split(",");
        for (String aChar : chars) {
            sbu.append((char) Integer.parseInt(aChar));
        }
        return sbu.toString();
    }

}
