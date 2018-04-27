package com.shigu.buyer.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tools.JsonResponseUtil;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 路径: com.shigu.buyer.services.TbUploadService
 * 工程: main-pom
 * 时间: 18-4-27 下午3:17
 * 创建人: wanghaoxiang
 * 描述: 与淘宝一键上传项目交互
 */
@Service
public class TbUploadService {

    @Autowired
    private RedisIO redisIO;

    private final String TB_LOGIN_TOKEN_PREFIX = "tb_login_token_";

    /**
     * 由加密过的淘宝nick生成token
     *
     * @param encryptedTbUserName des加密过的淘宝userNick
     * @return
     */
    public JSONObject getToken(String encryptedTbUserName) {
        String tbUserNick = Opt3Des.decryptPlainData(encryptedTbUserName);
        if (StringUtils.isBlank(tbUserNick)) {
            return JsonResponseUtil.error("无效的用户名");
        }
        String token = TB_LOGIN_TOKEN_PREFIX + UUIDGenerator.getUUID() + System.currentTimeMillis();
        // token有效期只有半小时
        redisIO.putTemp(token, tbUserNick, 60 * 30);
        return JsonResponseUtil.success().element("token", token);
    }


    /**
     * 淘宝登陆token解析
     *
     * @param token
     * @return
     * @throws Main4Exception
     */
    public String tbTokenResolve(String token) throws Main4Exception {
        String tbUserNick = redisIO.get(token, String.class);
        if (StringUtils.isBlank(tbUserNick)) {
            throw new Main4Exception("无效的用户");
        }
        redisIO.del(token);
        return tbUserNick;
    }
}
