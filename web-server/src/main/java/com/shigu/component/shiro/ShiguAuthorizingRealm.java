package com.shigu.component.shiro;

import com.shigu.component.shiro.enums.CacheEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;

/**
 * 登陆认证的父类
 * Created by zhaohongbo on 17/2/15.
 */
public abstract class ShiguAuthorizingRealm extends AuthorizingRealm {
    /**
     * 得到缓存
     * @param cachetype
     * @return
     */
    protected Cache getCache(CacheEnum cachetype){
        return this.getCacheManager().getCache(cachetype.getValue());
    }

    /**
     * 返回缓存的对象
     * @param cachetype
     * @param key
     * @return
     */
    protected Object getCacheObject(CacheEnum cachetype,String key){
        Cache cache=getCache(cachetype);
        if(cache!=null){
            return cache.get(key);
        }
        return null;
    }

    /**
     * 创建缓存
     * @param cachetype
     * @param key
     * @param value
     * @return
     */
    protected boolean putCacheObject(CacheEnum cachetype,String key,Object value){
        Cache cache=getCache(cachetype);
        if(cache!=null){
            cache.put(key,value);
            return true;
        }
        return false;
    }

    /**
     * 从session判断用户角色
     * @param info
     */
    protected void addRoleFromSession(SimpleAuthorizationInfo info){
        Session session = SecurityUtils.getSubject().getSession();
        //判断会员的
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps!=null){
            info.addRole(UserType.MEMBER.getValue());
            if(ps.getLogshop()!=null){
                info.addRole(RoleEnum.STORE.getValue());
            }else if(ps.getOtherShops()!=null&&ps.getOtherShops().size()>0){
                ps.setLogshop(ps.getOtherShops().get(0));
                info.addRole(RoleEnum.STORE.getValue());
            }
        }
        //判断后台的
    }
}
