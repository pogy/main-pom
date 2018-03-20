<#assign $pageid="userBonus">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>红包余额 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__userBonus_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__userBonus_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="mybag">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li><a href="userBalance.htm">我的资金</a></li>
    <li class="select"><a>红包余额</a></li>
</ul>
<div class="bonusBalance">
    <h3 class="fs16 yahei fc3">红包余额（元）</h3>
    <p class="money fcF40 yahei">
        <#if bonusBalance??>
            ${bonusBalance!}
        <#else>
            0.00
        </#if>
    </p>
    <p class="tips fc3">红包余额仅支持兑换代金券，线下档口支付使用！&nbsp;&nbsp;&nbsp;&nbsp;兑换地址：电商基地一楼大厅</p>
</div>
<div class="bonusList">
    <h3 class="yahei fs16 fc3">红包明细</h3>
    <div class="itemList">
        <div class="listHeader clearfix">
            <ul>
                <li class="time">时间</li>
                <li class="money">金额</li>
                <li class="type">类型</li>
            </ul>
        </div>
        <div class="listBody">
            <#if (bonusList?size) gt 0>
                <#list bonusList as item>
                    <ul class="clearfix">
                        <li class="time fc3">${item.time!}</li>
                        <li class="money">
                            <#if item.payState == 1>
                                <span class="green">+${item.money!}</span>
                            <#elseif item.payState ==2>
                                <span class="red">-${item.money!}</span>
                            </#if>
                        </li>
                        <li class="type">
                            <p class="fc3">${item.payText!}</p>
                            <p class="fc9"><#if item.payCode??>${item.payCodeText!}${item.payCode!}</#if></p>
                        </li>
                    </ul>
                </#list>
            <#else>
                <p class="fc3 noDataTip">Sorry，您还没收到任何红包哦~</p>
            </#if>
        </div>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">