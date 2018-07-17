<#assign $pageid="recommendVip">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <title>四季星座网-邀请有礼</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/h5__recommendVip_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/h5/js/clipboard.min.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/h5__recommendVip_js.ftl">
</head>
<body>
<div class="inviteContainer">
    <div class="myLinkBox bgbox">
        <div class="myLinkType">
            <div class="myQrcode">
                <div class="qrcodeImg"></div>
                <p>我的邀请码：${inviteCode!}</p>
            </div>
            <div class="line"></div>
            <div class="myLink">
                <p>邀请注册地址：</p>
                <input class="link" readonly="readonly" id="copyText" value="${inviteSrc!}" />
                <button id="copyLinkBtn" data-clipboard-target="#copyText">复制</button>
            </div>
        </div>
        <div class="introduce1"></div>
        <div class="introduce2"></div>
    </div>
    <div class="ruleBox bgbox">
        <h2>活动细则</h2>
        <p>1、当您的好友通过邀请码注册、下单且交易完成后，您可以获得相应返利，金额至高为订单商品总额的50%（系统随机抓取）；</p>
        <p>2、订单交易完成后，您的四季星座网账户将获得一笔返利；</p>
        <p>3、好友使用您的邀请码注册成功后，好友将获得10元下单红包；</p>
        <p>4、下单红包可至“红包余额”中查看。</p>
    </div>
    <div class="inviteList bgbox">
        <h2>已邀请的好友</h2>
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
<script modulepath="h5/recommendVip#inviteContainer">
var qrcodeUrl = '${inviteSrc!}';
</script>
<#include "/common/cnzz.ftl">