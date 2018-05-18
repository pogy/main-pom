<#assign $pageid="goodsStyleManager">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>商品风格管理 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__goodsStyleManager_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__goodsStyleManager_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<#list [{"fields":[{"name":"spid","value":query.spid}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">风格管理</a></li>
</ul>
<div class="categoryTabs clearfix">
    <#list styleList as item>
    <a class="<#if query.spid == item.spid>selected</#if>" href="goodsStyleManager.htm?spid=${item.spid!}" data-spid="${item.spid!}">${item.sname!} <#if item.goodsCount gt 0>(${item.goodsCount!})</#if></a>
    </#list>
</div>
<div class="goodsList">
    <div class="listHead">
        <ul>
            <li class="rank">序号</li>
            <li class="goodsInfo">商品</li>
            <li class="style">风格</li>
            <li class="operate">操作</li>
        </ul>
    </div>
    <#if (goodsList?size) gt 0>
        <div class="listBody">
            <#list goodsList as item>
                <ul data-scid="${item.scid!}" data-goodsid="${item.goodsid!}">
                    <li class="rank">${item_index+1}</li>
                    <li class="goodsInfo">
                        <a href="${mainHost!}/item.htm?id=${item.goodsid!}" target="_blank"><img src="${item.imgsrc!}_80x80.jpg"></a>
                        <p><a href="${mainHost!}/item.htm?id=${item.goodsid!}" target="_blank">${item.title!}</a></p>
                    </li>
                    <li class="style">${item.scname!}</li>
                    <li class="operate"><span class="fcBlue" jhand="openGoodsStyleWindow">编辑</span><span class="fcF40" jhand="deleteGoodsStyle">删除</span></li>
                </ul>
            </#list>
        </div>
<#list [{}] as $it>
<div class="jqPagination blue" id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    <#else>
<p class="goodsListIsEmpty">找不到结果</p>
    </#if>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>