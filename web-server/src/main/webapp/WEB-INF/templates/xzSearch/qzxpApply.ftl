<#assign $pageid>qzxpApply</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>${activeName!} - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__qzxpApply_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__qzxpApply_js.ftl">
</head>
<body>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle></#assign>
<#assign searchType>goods</#assign>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__nav.ftl">
<div class="banner" style="background-image:url(${bannerSrc!});">
<div class="applyBtnBox yahei pr">
    <#if alreadyApply == true>
        <img class="disabledBtn" src="${disabledBtnSrc!}">
    <#else>
        <img src="${applyBtnSrc!}" class="applyBtn">
    </#if>
</div>
</div>
<div class="pinkBg">
<div class="actIntroduce yahei layout actBox">
    <h2 class="tac">活动介绍</h2>
    <ul class="actText fs14 fc3">
        <#list actIntroduce as intro>
            <li>${intro!}</li>
        </#list>
    </ul>
</div>
<div class="actApplyExplain yahei layout actBox">
    <h2 class="tac">活动报名说明</h2>
    <ul class="actText fs14 fc3">
        <#list applyExplain as explain>
            <li>${explain!}</li>
        </#list>
    </ul>
</div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">