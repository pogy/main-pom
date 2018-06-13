package com.shigu.buyer.services;

import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
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

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    private final String TB_LOGIN_TOKEN_PREFIX = "tb_login_token_";

    private final String TB_LOGIN_USERID_TOKEN_PREFIX = "tb_login_userId_token_";

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


    /**
     * 淘宝登陆成功，生成淘宝上传站获取星座网userId用token
     *
     * @param userId
     * @return
     * @throws Main4Exception
     */
    public String genXzUserIdToken(Long userId) throws Main4Exception {
        if (userId == null) {
            throw new Main4Exception("用户不存在");
        }
        String xzUserIdToken = TB_LOGIN_USERID_TOKEN_PREFIX + UUIDGenerator.getUUID() + System.currentTimeMillis();
        redisIO.putTemp(xzUserIdToken, userId, 60 * 30);
        return xzUserIdToken;
    }

    public JSONObject uploadTbGetXzUserId(String userIdToken) {
        Long userId = redisIO.get(userIdToken, Long.class);
        if (userId == null) {
            return JsonResponseUtil.error("获取用户信息失败");
        }
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        String userName = memberUser.getUserName();
        ShiguShop shiguShop = new ShiguShop();
        shiguShop.setUserId(userId);
        shiguShop.setShopStatus(0);
        // 是否有开店
        int hasShop = shiguShopMapper.selectCount(shiguShop) > 0 ? 1 : 0;
        return JsonResponseUtil.success().element("xzUserKey", Opt3Des.encryptPlainData(userId + "")).element("xzUserName", Opt3Des.encryptPlainData(userName)).element("hasShop", hasShop);
    }
}
