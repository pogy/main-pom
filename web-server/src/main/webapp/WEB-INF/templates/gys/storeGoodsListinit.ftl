<#assign $pageid="storeGoodsListinit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>仓库中的商品 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__storeGoodsListinit_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__storeGoodsListinit_js.ftl">
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
<#list [{"fields":[{"name":"keyword","value":query.keyword},{"name":"goodsNo","value":query.goodsNo}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">仓库中的商品</a></li>
</ul>
<div class="goodsFilterBar">
    <ul class="clearfix">
        <li><label>商品名称：</label><input id="keyword" class="textinput" value="${query.keyword!}"></li>
        <li><label>商品货号：</label><input id="goodsNo" class="textinput" value="${query.goodsNo!}"></li>
        <li><button id="doGoodsFilterSearch">查询</button></li>
    </ul>
</div>
<input id="shopWebSite" type="hidden" value="${session_user_redis__.logshop.webSite!}">
<#if (goodslist?size) gt 0 >
<div class="goodsList" id="goodsList">
    <ul class="head clearfix">
        <li class="name">
<#list [{}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="allItems"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        全选
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            <#if session_user_redis__.logshop.type == 2>
            <button class="sjgoods" jhand="muiltiUpGoods">上架</button>
            </#if>
            <button class="scgoods" jhand="muiltiRemoveGoods">删除</button>
        </li>
        <li class="price">批发价(元)</li>
        <li class="posttype">发布方式</li>
        <li class="downshelftime">下架时间</li>
        <li class="control">操作</li>
    </ul>
    <#list goodslist as item>
    <ul class="body clearfix" data-id="${item.id!}">
        <li class="name">
<#list [{"value":item.id}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="storeGoods"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="allItems"
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            <a class="piclink" href="${item.href!}" title="查看商品详情" target="_blank">
                <img src="${item.imgsrc!}_80x80.jpg">
            </a>
            <p>
                <a class="title" href="${item.href!}" title="查看商品详情" target="_blank">${item.title!}</a>
                <span>货号：${item.goodsNo!}</span>
            </p>
        </li>
        <li class="price">¥ ${item.price!}</li>
        <li class="posttype">${item.type!}</li>
        <li class="downshelftime"><#if item.delistTime??>${item.delistTime!}<#else>--</#if></li>
        <li class="control">
            <#if session_user_redis__.logshop.type == 2>
            <button class="sjgoods" jhand="upGoods" data-goodsid="${item.id!}">上架</button>
            </#if>
            <button class="scgoods" jhand="removeGoods" data-goodsid="${item.id!}">删除</button>
        </li>
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
<#include "/common/xz__footer.ftl">