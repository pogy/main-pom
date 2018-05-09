<#assign $pageid="photoDetail">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>作品详情 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__photoDetail_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__photoDetail_js.ftl">
</head>
<body <#if worksData.saveType == 1>oncontextmenu='return false' ondragstart='return false' onselectstart ='return false' onselect='document.selection.empty()' oncopy='document.selection.empty()' onbeforecopy='return false'</#if>>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<div class="photoDetail layout">
<div class="leftDetailBox fl" data-id="${query.id!}">
    <div class="photoInfo clearfix">
        <div class="imgBox fl"><img src="${worksData.coverImgSrc!}_j300x300.jpg"></div>
        <div class="clearfix fl photoInfoDetail yahei">
            <h3 class="title">${worksData.title!}</h3>
            <p class="worksDesc fc6">${worksData.desc!}</p>
            <div class="clearfix">
                <div class="worksCont fl">
                    <ul>
                        <li><label>价格：</label><span class="fcF40">${worksData.price!}</span></li>
                        <li><label>拍摄风格：</label><span>${worksData.style!}</span></li>
                        <li><label>发布时间：</label><span>${worksData.publishedTime!}</span></li>
                        <li><label>位置：</label><span>${userInfo.address!}</span></li>
                    </ul>
                </div>
                <div class="worksCout fl">
                    <ul>
                        <li><label>浏览：</label><span class="readCount"></span></li>
                        <li><label>点赞：</label><span class="thumbUpCount">${worksData.thumbUpCount!}</span></li>
                    </ul>
                </div>
            </div>
            <div class="thumbUpBox">
                <#if worksData.userThumbUpIs == true>
                <b jhand="removeThumbUp" class="removeThumbUp"><i class="icon-store"></i>取消赞</b>
                <#else>
                <b jhand="thumbUp"><i class="icon-s-store"></i>点赞</b>
                </#if>
            </div>
        </div>
    </div>
    <div class="morePhotoDetail">
        <#if (worksData.imgList?size) gt 0>
            <#list worksData.imgList as img>
            <p><img src="${img!}_w750.jpg"></p>
            </#list>
        </#if>
    </div>
</div>
<div class="rightUserInfoBox fr yahei">
    <div class="detailUserInfo">
        <p class="imgBox"><img src="${userInfo.imgSrc!}"></p>
        <p class="fs14">${userInfo.typeName!}：${userInfo.nick!}</p>
        <p>
            <span class="addr"><i class="icon-s-addr"></i>${userInfo.address!}</span>
            <span class="fcF40 worksCount"><i></i>${userInfo.worksCount!}个作品</span>
        </p>
        <p class="btnBox">
            <a href="/photo/userHomePage.htm?id=${userInfo.userId!}" target="_blank">全部作品</a>
        </p>
    </div>
    <div class="wxQrCodeBox">
        <p><img src="${userInfo.wxQrCode!}"></p>
        <p>扫一扫 加微信</p>
        <p><i class="icon-s-phone2"></i>${userInfo.tele!}</p>
    </div>
</div>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">