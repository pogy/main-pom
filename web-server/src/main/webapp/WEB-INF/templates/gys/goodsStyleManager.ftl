<#assign $pageid>goodsStyleManager</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>商品风格管理 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__goodsStyleManager_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__goodsStyleManager_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<#assign text>{"fields":[{"name":"pid","value":query.pid}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">自定义管理</a></li>
    <li class="fr styleTip fcF40"><i class="icon-warn"></i>自定义内容仅在店铺页面展示</li>
</ul>
<div class="categoryTabs clearfix">
    <#list categoryTabs as item>
    <a class="<#if query.pid == item.cateId>selected</#if>" href="goodsStyleManager.htm?pid=${item.cateId!}" data-cateid="${item.cateId!}">${item.cateName!} (${item.goodsNum!})</a>
    </#list>
    <ul>
        <b class="setUserGoodsStyle fr" jhand="openGoodsStyleWindow"><i class="icon-s-add"></i>自定义</b>
    </ul>
</div>
<div class="userGoodsStyleList">
    <div class="styleHead">
        <ul>
            <li class="rank">序号</li>
            <li class="style">自定义内容</li>
            <li class="cat">所属类目</li>
            <li class="num">影响商品数量</li>
            <li class="move">移动</li>
            <li class="operate">操作</li>
        </ul>
    </div>
    <div class="styleList">
        <#list userGoodsStyleList as item>
            <ul data-styleid="${item.goodsStyleId!}" data-categoryid="${item.categoryId!}" data-stylename="${item.goodsStyleName!}">
                <li class="rank">${item_index+1}</li>
                <li class="style" title="${item.goodsStyleName!}">${item.goodsStyleName!}</li>
                <li class="cat">${item.categoryName!}</li>
                <li class="num">${item.goodsNum!}</li>
                <li class="move"><i class="icon-s-up" jhand="moveTo" data-move="up"></i><i class="icon-s-down" jhand="moveTo" data-move="down"></i></li>
                <li class="operate"><span class="fcBlue" jhand="openGoodsStyleWindow">内容编辑</span><span class="fcF40" jhand="deleteGoodsStyle">删除</span></li>
            </ul>
        </#list>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">