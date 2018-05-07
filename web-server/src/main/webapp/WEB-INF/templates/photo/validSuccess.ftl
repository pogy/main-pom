<#assign $pageid="validSuccess">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__validSuccess_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__validSuccess_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="validSuccess yahei layout">
    <p class="fc3"><i class="tick"></i>认证已提交，正在审核中，请耐心等待......</p>
    <p class="fc9 timeBox"><span class="time fcF40">5s</span> <span>后，自动跳转主页</span></p>
    <p class="toLinkBox"><a href="userWorkList.htm?id=${userId!}">去主页</a></p>
    <input type="hidden" id="userId" value="${userId!}">
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">