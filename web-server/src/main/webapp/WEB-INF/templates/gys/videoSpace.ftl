<#assign $pageid="videoSpace">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>视频空间 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__videoSpace_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<script src="//style.571xz.com/v6/gys/plugin/clipboard/clipboard.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__videoSpace_js.ftl">
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
<div class="headTitle fc6">
    <h2 class="fs16 fwb yahei">视频空间</h2>
</div>
<div id="bodyContent" class="">
    <p class="loadingTips">视频空间加载中...</p>
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
    <div class="imgSpace fr" id="pictureSpaceSizeInfo">
        <div class="allBar pr"><div class="bar" style="width:0%"></div></div>
        <p class="infotext fl">0M/0M</p>
        <p class="fr fc3">扩容功能即将上线</p>
    </div>
</div>
<div class="fileList yahei" id="fileList">
    <div class="fileItems" id="fileItemsBox">
        <#if (videoList?size) gt 0>
        <ul class="clearfix">
            <#list videoList as item>
            <li class="fileItem" data-id="${item.videoId!}">
                <a class="videoBox" href="${item.videoSrc!}" target="_blank">
                    <video preload="auto" webkit-playsinline="webkit-playsinline" playsinline="playsinline" src="${item.videoSrc!}" type="video/mp4"></video>
                    <div class="videoOpe">
                        <b class="clipBoardImgSrc" data-clipboard-text="${item.videoSrc!}">复制</b>
                        <b class="delete">删除</b>
                        <b class="rename" data-title="${item.title!}">重命名</b>
                    </div>
                </a>
                <div class="videoInfo">
                    <p class="title fs14 ellip" title="${item.title!}">${item.title!}</p>
                    <p class="clearfix"><span class="fl videoTime">${item.videoTime!}</span><span class="fr">${item.videoSize!}</span></p>
                </div>
            </li>
            </#list>
        </ul>
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
        <p class="noFile fs18 fwb">暂无任何文件！</p>
        </#if>
    </div>
</div>
</div>
<div class="successTip"><i></i><span>文件上传成功！</span></div>
<div class="errorTips"><i></i><span>上传失败！单个文件大于10M！</span></div>
<script modulepath="gys/videoSpace#file">
var existeVideos = '${existeVideos!}';
</script>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>