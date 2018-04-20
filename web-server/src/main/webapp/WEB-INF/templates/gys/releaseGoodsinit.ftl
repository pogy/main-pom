<#assign $pageid="releaseGoodsinit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>发布商品 - 供应商后台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__releaseGoodsinit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__releaseGoodsinit_js.ftl">
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
<div class="category-history">
    您最近使用的类目：
    <select id="categoryHistorySelect" autocomplete="off">
        <option value="-1">请选择</option>
        <#list historyCategory as cate>
        <option value="${cate.value!}" data-cid="${cate.cid!}">${cate.text!}</option>
        </#list>
    </select>
</div>
<div class="categoryList clearfix">
    <#if webSite == 'qz'>
    <div class="categoryContainer" data-level="0">
<ul>
    <li data-cid="50011740" data-child="1">流行男鞋<i class="icon-rightarrow"></i></li>
    <li data-cid="50006843" data-child="1">女鞋<i class="icon-rightarrow"></i></li>
</ul>
    </div>
    <div class="categoryContainer" data-level="1">
    </div>
    <#else>
    <div class="categoryContainer" data-level="0">
<ul>
    <li data-cid="30" data-child="1">男装<i class="icon-rightarrow"></i></li>
    <li data-cid="50011740" data-child="1">流行男鞋<i class="icon-rightarrow"></i></li>
    <li data-cid="16" data-child="1">女装/女士精品<i class="icon-rightarrow"></i></li>
    <li data-cid="50006843" data-child="1">女鞋<i class="icon-rightarrow"></i></li>
    <li data-cid="50006842" data-child="1">箱包皮具/热销女包/男包<i class="icon-rightarrow"></i></li>
    <li data-cid="1625" data-child="1">女士内衣/男士内衣/家居服<i class="icon-rightarrow"></i></li>
    <li data-cid="50010404" data-child="1">服饰配件/皮带/帽子/围巾<i class="icon-rightarrow"></i></li>
    <li data-cid="50008165" data-child="1">童装/童鞋/亲子装<i class="icon-rightarrow"></i></li>
    <li data-cid="50013886" data-child="1">户外/登山/野营/旅行用品<i class="icon-rightarrow"></i></li>
</ul>
    </div>
    <div class="categoryContainer" data-level="1">
<ul>
    <li data-cid="3035" data-child="0">休闲裤</li>
    <li data-cid="50000436" data-child="0">T恤</li>
    <li data-cid="50000557" data-child="0">针织衫/毛衣</li>
    <li data-cid="50001748" data-child="0">民族服装</li>
    <li data-cid="50005867" data-child="0">工装制服</li>
    <li data-cid="50010158" data-child="0">夹克</li>
    <li data-cid="50010159" data-child="0">卫衣</li>
    <li data-cid="50010160" data-child="0">西服</li>
    <li data-cid="50010167" data-child="0">牛仔裤</li>
    <li data-cid="50010402" data-child="0">Polo衫</li>
    <li data-cid="50011123" data-child="0">衬衫</li>
    <li data-cid="50011127" data-child="0">皮裤</li>
    <li data-cid="50011129" data-child="0">西裤</li>
    <li data-cid="50011130" data-child="0">西服套装</li>
    <li data-cid="50011153" data-child="0">背心/马甲</li>
    <li data-cid="50011159" data-child="0">风衣</li>
    <li data-cid="50011161" data-child="0">皮衣</li>
    <li data-cid="50011165" data-child="0">棉衣</li>
    <li data-cid="50011167" data-child="0">羽绒服</li>
    <li data-cid="50025883" data-child="0">毛呢大衣</li>
    <li data-cid="50025884" data-child="0">羽绒裤</li>
    <li data-cid="50025885" data-child="0">棉裤</li>
    <li data-cid="124730001" data-child="1">套装<i class="icon-rightarrow"></i></li>
</ul>
    </div>
    </#if>
    <div class="categoryContainer" data-level="2"></div>
    <div class="categoryContainer" data-level="3"></div>
</div>
<div class="category-tips">
    <div class="msgbox1">
        <i></i>
        <div class="inner">
            <em>您当前选择的类目是：</em><span class="currentCategory"></span>
        </div>
    </div>
</div>
<div class="category-submit">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitCategory"
>
        现在发布宝贝
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>