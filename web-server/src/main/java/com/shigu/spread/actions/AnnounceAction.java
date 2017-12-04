package com.shigu.spread.actions;

import com.shigu.spread.services.AnnounceService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述：公告信息
 * 工程：main-pom
 * 类路径：com.shigu.spread.actions.AnnounceAction
 * 创建人：wanghaoxiang 17-12-4 下午12:27
 */
@Controller
public class AnnounceAction {

    @Autowired
    private AnnounceService announceService;

    /**
     * 获取公告数据
     *
     * @param announceId 公告识别标志
     * @return 公告信息
     */
    public JSONObject acquireAnnounceInfo(String announceId) {
        String announceInfo = announceService.acquireAnnounceInfo(announceId);
        JSONObject result = JsonResponseUtil.success();
        if (announceInfo != null) {
            result.element("announceInfo",announceInfo);
        }
        return result;
    }
}
