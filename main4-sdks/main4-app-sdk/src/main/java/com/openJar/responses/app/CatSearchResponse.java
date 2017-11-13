package com.openJar.responses.app;

import com.openJar.beans.app.AppCatGroup;
import com.openJar.responses.Response;

import java.util.List;

/**
 * 类名：CatSearchResponse
 * 类路径：com.openJar.responses.app.CatSearchResponse
 * 创建者：任真飞
 * 创建时间：2017-11-13 13:07
 * 项目：main-pom
 * 描述：
 */
public class CatSearchResponse extends Response {
    //类目分组数据	必须
    private List<AppCatGroup> catGroups;
    public List<AppCatGroup> getCatGroups(){
        return catGroups;
    }

    public void setCatGroups(List<AppCatGroup> catGroups){
        this.catGroups=catGroups;
    }

}