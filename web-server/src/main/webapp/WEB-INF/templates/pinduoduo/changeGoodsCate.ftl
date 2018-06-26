<#assign $pageid="changeGoodsCate">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/pinduoduo__changeGoodsCate_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/pinduoduo__changeGoodsCate_js.ftl">
</head>
<body>
<#include "/__ftl_links__/pinduoduo__common__topbar.ftl">
<script modulepath="pinduoduo/changeGoodsCate#config">
var curCate = '${allCids!}';
var goodsId = '${goodsId!}';
</script>
<div class="goodsCateChangeBox">
<div class="categoryHistory">
    您最近使用的类目：
    <select id="categoryHistorySelect" autocomplete="off">
        <option value="-1">请选择</option>
        <#list pddHistoryCategory as cate>
        <option value="${cate.value!}" data-cid="${cate.cid!}">${cate.text!}</option>
        </#list>
    </select>
</div>
<div class="categoryList clearfix">
    <div class="categoryContainer" data-level="0">
<ul>
</ul>
    </div>
    <div class="categoryContainer" data-level="1">
    </div>
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
        下一步，填写信息
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
</div>
<#include "/common/cnzz.ftl">