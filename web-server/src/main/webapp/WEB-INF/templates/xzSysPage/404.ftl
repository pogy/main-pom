<#assign $pageid="404">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>404错误 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSysPage__common_css.ftl">
<#include "/__style_torrent__/xzSysPage__404_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSysPage__common_js.ftl">
<#include "/__style_torrent__/xzSysPage__404_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="header">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/v6/common/css/img/xz/mtLogo.png" alt width="168" height="30">
            </a>
        </div>
    </div>
</div>
<div class="errorTip tac">
    <i class="errorPng"></i>
    <#if errorCon??>
    <p class="tac fs18 fc3 yahei">${errorCon!}</p>
    <#else>
    <p class="tac fs18 fc3 yahei">您要访问的页面 ,越狱啦！</p>
    </#if>
    <#if backUrl??>
    <p class="tac yahei"><span class="fcF40 countdown">5</span> 秒后跳转到上一级，若没有跳转请</p>
    <p class="tac"><a href="${backUrl!}" class="jumpUrl fs14">点击这里</a></p>
    <#else>
    <p class="tac yahei"><span class="fcF40 countdown">5</span> 秒后跳转到首页，若没有跳转请</p>
    <p class="tac"><a href="http://www.571xz.com" class="jumpUrl fs14">点击这里</a></p>
    </#if>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">