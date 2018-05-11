<#assign $pageid="pictureSpace">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>图片空间 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__pictureSpace_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__pictureSpace_js.ftl">
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
<script modulepath="gys/pictureSpace#config">
var shopId = '${session_user_redis__.logshop.shopId!}';
</script>
<script modulepath="gys/pictureSpace#config">
var shopId = '${session_user_redis__.logshop.shopId!}';
</script>
<div class="headTitle fc6">
    <h2 class="fs16 fwb yahei">图片空间</h2>
</div>
<div id="bodyContent" class="hideContent">
    <p class="loadingTips">图片空间加载中...</p>
<div class="headButton">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         uploadBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="uploadBtn"
>
        上传
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-white-b
         newFloderBtn"
        jbtn="newFloderBtn"
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
        新建文件夹
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    <span class="fcF40">上传的文件为压缩包（zip、rar、7z），才可关联对应的商品哦！</span>
    <div class="imgSpace fr" id="pictureSpaceSizeInfo">
        <div class="allBar pr"><div class="bar" style="width:0%"></div></div>
        <p class="infotext fl">0M/0M</p>
        <p class="fr fc3">扩容功能即将上线</p>
    </div>
</div>
<div class="fileList yahei" id="fileList">
    <div class="subNav" id="subNav"><span class="active">全部文件</span> <span class="fcBlue">&gt;</span> 2017年秋装</div>
    <div class="listTitle fc6">
        <ul class="clearfix">
            <li class="name">文件名称</li>
            <li class="size">大小</li>
            <li class="cjTime">创建时间</li>
        </ul>
    </div>
    <div class="fileItems" id="fileItemsBox">
    </div>
</div>
</div>
<div class="successTip"><i></i><span>文件上传成功！</span></div>
<div class="errorTips"><i></i><span>上传失败！单个文件大于150M！</span></div>
<#list [{}] as $it>
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
<#list [{}] as $it>
</#list>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>