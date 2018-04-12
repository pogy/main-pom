<#assign $pageid="ruzhu_sq">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>申请审核中 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__ruzhu_sq_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__ruzhu_sq_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <div class="noSidebarBox">
<div class="applyState clearfix">
    <span class="active first">
        <em>1</em>
        <i>填写账户信息</i>
    </span>
    <span class="second active">
        <i class="line"></i>
        <em>2</em>
        <i>等待专员审核</i>
    </span>
    <span class="third">
        <i class="line"></i>
        <em>3</em>
        <i>入驻成功</i>
    </span>
</div>
<div class="applyInfo yahei">
    <div class="imgbox">
        <img src="${wxpic!}">
    </div>
    <div class="storeInfo">
        <p class="fweight">店铺${storeName!}正在审核中!</p>
        <p>审核时间需要 2 个工作日，请留意您的账户。</p>
        <p>请扫描左侧二维码点击关注    审核通过立刻通知！您也可以在【个人中心】—【店铺申请】中查看进度！</p>
        <p>如您希望快速审核，请把编号 ${userCode!} 发给客服。</p>
        <p class="tosearch"><a href="/member/storeIn.htm">立即查看</a></p>
    </div>
</div>
</div>
    </div>
</div>
<#include "/common/xz__footer.ftl">