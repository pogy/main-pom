<#assign $pageid="userHomePage">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>作品集 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__userHomePage_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__userHomePage_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<div class="userWorks yahei">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#if (userWorksList?size) gt 0>
    <div class="worksList layout">
        <#list userWorksList as item>
<#include "/__ftl_links__/photo__common__coverItem.ftl">
        </#list>
    </div>
<#include "/__ftl_links__/photo__common__worksPage.ftl">
<#else>
    <div class="worksList clearfix layout">
        <div class="noWork yahei">
            <div class="noWorkIcon"></div>
            <p>暂无作品信息！</p>
            <a href="/photo/photoIndex.htm" class="uploadBtn">去首页看看</a>
        </div>
    </div>
</#if>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">