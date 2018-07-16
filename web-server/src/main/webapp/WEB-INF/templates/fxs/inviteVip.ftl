<#assign $pageid="inviteVip">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>邀请有礼 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__inviteVip_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/fxs/js/clipboard.min.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__inviteVip_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<div class="introduce">
    <div class="banner"></div>
    <ul class="clearfix">
        <li class="introduce1"></li>
        <li class="introduce2"></li>
    </ul>
</div>
<div class="myLink yahei">
    <div class="qrcode"></div>
    <p class="mycode">我的邀请码：${inviteCode!}</p>
    <div class="line"></div>
    <div class="myUrl">
        <p>邀请注册地址：<span id="copyText">${inviteSrc!}</span></p>
        <button id="copyLinkBtn" class="copyBtn yahei" data-clipboard-target="#copyText">复制</button>
    </div>
</div>
<script modulepath="fxs/inviteVip#myLink">
var qrcodeUrl = '${inviteSrc!}';
</script>
<div class="rules actbox yahei">
    <h2><span>活动细则</span></h2>
    <p>1、当您的好友通过邀请码注册、下单且交易完成后，您可以获得相应返利，金额至高为订单商品总额的50%（系统随机抓取）；</p>
    <p>2、订单交易完成后，您的四季星座网账户将获得一笔返利；</p>
    <p>3、好友使用您的邀请码注册成功后，好友将获得10元下单红包；</p>
    <p>4、下单红包可至“红包余额”中查看。</p>
</div>
<div class="inviteList actbox yahei">
    <h2><span>已邀请的好友</span></h2>
    <ul>
        <#list invitedUserList as item>
        <li>
            <image src="${item.headImg!}" />
            <div class="registInfo">
                <p class="telephone">${item.telephone!}</p>
                <p class="registeTime">${item.registeDate!}</p>
            </div>
            <span class="userState">
                <#if item.userState == 1>已注册<#else>已成功下单</#if>
            </span>
        </li>
        </#list>
    </ul>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>