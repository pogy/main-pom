package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.bo.TsysRoleBO;

/**
 * @类编号
 * @类名称：SysDealProcess
 * @文件路径：com.shigu.main4.daifa.process.SysDealProcess
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/19 11:07
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface SysDealProcess {


    int roleInsert(String roleName,String roleTag,Long createUserId,Long status,String roleComment);

    int roleUpdate(Long roleId,String roleName,String roleTag,Long createUserId,Long status,String roleComment);
}
