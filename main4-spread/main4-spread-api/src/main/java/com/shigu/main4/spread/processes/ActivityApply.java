package com.shigu.main4.spread.processes;

/**
 * 类名：ActivityApply
 * 类路径：com.shigu.main4.spread.processes.ActivityApply
 * 创建者：王浩翔
 * 创建时间：2017-09-15 10:39
 * 项目：main-pom
 * 描述：秋装报名，临时用下，独立出来，避免与其他分支修改冲突
 */
public interface ActivityApply {
    String apply(String flag,Long userId,Long shopId);
}
