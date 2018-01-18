<#assign $pageid="queDetail">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>${queTitle!} - 帮助中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/helpCenter__common_css.ftl">
<#include "/__style_torrent__/helpCenter__queDetail_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/helpCenter__common_js.ftl">
<#include "/__style_torrent__/helpCenter__queDetail_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/helpCenter__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType=undefined>
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/helpCenter__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<div class="queCon">
    <h3 class="fs14 yahei">${queCateNamePath!}</h3>
    <div class="queListCon">
        <h4 class="fcF40 yahei fs20">${queTitle!}</h4>
        <div class="queDetail">
            ${queDetail}
        </div>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">