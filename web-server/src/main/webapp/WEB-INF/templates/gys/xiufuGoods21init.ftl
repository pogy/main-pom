<#assign $pageid="xiufuGoods21init">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>商品类目管理 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__xiufuGoods21init_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__xiufuGoods21init_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>商品类目管理</a></li>
</ul>
<div class="synchronous">
    <div class="synCon">
        <h4>同步商品类目：</h4>
        <p>1、将淘宝店铺中的商品类目同步到四季星座网店铺中</p>
        <p>2、将四季星座网店铺中的全部商品归类到新的商品类目下</p>
    </div>
</div>
<p class="buttonCen" data-id="${session_user_redis__.logshop.shopId!}">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-blue
        "
        jbtn="tbGoodsCate"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        同步商品类目
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">