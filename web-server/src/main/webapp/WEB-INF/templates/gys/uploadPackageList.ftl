<#assign $pageid>uploadPackageList</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>数据包上传 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__uploadPackageList_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<script src="http://style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__uploadPackageList_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">数据包上传</a></li>
</ul>
<div class="packageList">
    <table class="packageTable">
        <thead>
            <th class="listNum"></th>
            <th class="goodsTitle">商品标题</th>
            <th class="goodsPrice">价格(元)</th>
            <th class="goodsNo">商家编码</th>
            <th class="goodsCate">类目</th>
            <th class="status">状态</th>
        </thead>
        <tbody class="packageCon">
            <#list packageList as package>
            <tr data-goodsId="${package.goodsId!}">
                <td>${package_index + 1}</td>
                <td><p class="goodsTitle">${package.title!}</p></td>
                <td>${package.piPrice!}</td>
                <td>${package.shopCode!}</td>
                <td>${package.catName!}</td>
                <td class="dyStatus">等待上传中…</td>
            </tr>
            </#list>
        </tbody>
    </table>
    <div class="continueAddBox fr">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
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
        id="uploadGoodsPackage"
>
        继续添加数据包
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
</div>
<#include "/common/xz__footer.ftl">