package com.shigu.goodsup.jd.util;

import com.jd.open.api.sdk.internal.util.codec.Base64;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdVasSubscribeVO;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created By admin on 2017/12/14/16:43
 * 转换京东state
 */
public class JdParseStateUtil {


    /**
     * state 解析
     * 参见 http://jos.jd.com/doc/channel.htm?id=246
     * @param state
     * @return
     * @throws JdUpException
     */
    public static JdVasSubscribeVO parseState(String state) throws JdUpException {
        //state中如果有“+”号，因浏览器交互的原因，会出现“+”号替换成空格的现象，导致授权报错
        //如果出现此种情况，请把的state 中的空格再替换成“+”号
        state = state.replace(" ","+");
        state = Base64.decodeBase64(state.getBytes()).toString();
        JSONObject uerSubscribeJson = JSONObject.fromObject(state);
        //验证state
        String itemCode = uerSubscribeJson.getString("item_code");
        if (StringUtils.isEmpty(itemCode)) {//未订阅
            throw new JdUpException("授权失败");
        }

        String userName = uerSubscribeJson.getString("user_name");
        String source = uerSubscribeJson.getString("source");
        Integer versionNo = uerSubscribeJson.getInt("version_no");
        //验证订阅是否过期
        Long endDate = uerSubscribeJson.getLong("end_date");
        Date now = new Date();
        Date endAt = new Date(endDate);
        if(endAt.before(now)){
            throw new JdUpException("服务订阅已到期");
        }

//        String source = uerSubscribeJson.getString("source");
//        String versionNo = uerSubscribeJson.getString("version_no");

        JdVasSubscribeVO subscribeVO = new JdVasSubscribeVO();
        subscribeVO.setItemCode(itemCode);
        subscribeVO.setUserName(userName);
        subscribeVO.setEndDate(new Date(endDate));
        subscribeVO.setItemSource(source);
        subscribeVO.setVersionNo(versionNo);

        return subscribeVO;
    }
}
