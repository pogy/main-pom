<#assign $pageid>bindAlipayUser</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>绑定设置 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__bindAlipayUser_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__bindAlipayUser_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>mybag</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>我的资金 &gt; 绑定设置</a></li>
</ul>
<div class="alipayUserList">
    <h3 class="title fs16 yahei tac"><i class="icon-s-alipay"></i>绑定的支付宝账户</h3>
    <ul class="clearfix">
        <#list alipayUserList as user>
        <li>
            <span>${user.aliAccount!}（${user.userRealName!}）</span>
            <b class="fr fcF40 delete" jbtn="deleteUser" data-aliaccountid="${user.aliAccountId!}">删除</b>
        </li>
        </#list>
        <li class="addNewAlipayUser">
            <a href="bindAlipayUserOpe.htm" class="fs16 fcBlue"><i class="icon-plus"></i>添加新的支付宝账号</a>
        </li>
    </ul>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">