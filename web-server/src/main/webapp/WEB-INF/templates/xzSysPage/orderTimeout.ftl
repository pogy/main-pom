<#assign $pageid="orderTimeout">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>订单超时 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSysPage__common_css.ftl">
<#include "/__style_torrent__/xzSysPage__orderTimeout_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSysPage__orderTimeout_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="header">
    <div class="layout">
        <div class="logoLeft">
            <a href="//${webSite!}.571xz.com">
                <img src="//style.571xz.com/v6/common/css/img/xz/mtLogo.png" alt width="168" height="30">
            </a>
        </div>
    </div>
</div>
<div class="errorTip tac">
    <i class="errorPng"></i>
    <#if errorCon??>
    <p class="tac fs18 fc3 yahei">${errorCon!}</p>
    <#else>
    <p class="tac fs18 fc3 yahei">对不起，您的订单已超时请重新下单。</p>
    </#if>
    <#if backUrl??>
    <p class="tac"><a href="${backUrl!}" class="jumpUrl fs14">重新下单</a></p>
    <#else>
    <p class="tac"><a href="//www.571xz.com/order/cart.htm" class="jumpUrl fs14">重新下单</a></p>
    </#if>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">