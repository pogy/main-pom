package com.opentae.data.mana.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mana.beans.UserAction;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mana_userActionMapper")
@Scope("singleton")
@Lazy(true)
public interface UserActionMapper extends Mapper<UserAction> {
    int insert(UserAction userAction);
}
