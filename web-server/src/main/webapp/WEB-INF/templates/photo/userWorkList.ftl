<#assign $pageid="userWorkList">
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
<#include "/__style_torrent__/photo__userWorkList_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__userWorkList_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="userWorkList layout">
    <#if (userWorksList?size) gt 0>
    <div class="worksBox clearfix">
        <div class="coverItem smallMar addWorksBtn">
            <a href="/photo/auth/uploadWork.htm">
                <i></i>
                点击上传作品
            </a>
        </div>
        <div class="clearfix worksList">
            <#list userWorksList as item>
<#include "/__ftl_links__/photo__common__coverItem.ftl">
            </#list>
        </div>
    </div>
<#include "/__ftl_links__/photo__common__worksPage.ftl">
    <#else>
    <div class="worksBox clearfix">
        <div class="noWork yahei">
            <div class="noWorkIcon"></div>
            <p>您还没有上传过任何作品</p>
            <a href="/photo/auth/uploadWork.htm" class="uploadBtn">立即上传作品</a>
        </div>
    </div>
    </#if>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">