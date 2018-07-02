<#assign $pageid="fenxiaoZhanghao">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>第三方绑定 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__fenxiaoZhanghao_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__fenxiaoZhanghao_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="safecenter">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>账号绑定管理</a></li>
</ul>
<div class="accountList">
    <div class="tips">绑定手机号或者第三方账号即可通过该账号登录四季星座网</div>
    <ul class="itemBox clearfix">
        <#list _outer_accountType_ as item>
            <#if item.id??>
            <li class="bd">
                <div class="iconApplication">
                    <i class="icon${item.from!} iconApp"></i>
                    <i class="iconBd"></i>
                    <p>${item.name!}</p>
                </div>
                <div class="status">
                    <b class="unBind" jbtn="${item.from!}" data-id="${item.id!}">解绑</b>
                </div>
            </li>
            <#else>
            <li class="noBd">
                <div class="iconApplication">
                    <i class="icon${item.from!} iconApp"></i>
                    <p>${item.name!}</p>
                </div>
                <div class="status">
                    <a href="//www.571xz.com/ortherLogin.htm?ortherLoginType=${item.ortherLoginType!}&backUrl=//www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
                </div>
            </li>
            </#if>
        </#list>
    </ul>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>