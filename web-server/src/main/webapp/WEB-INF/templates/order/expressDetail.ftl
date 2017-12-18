<#assign $pageid="expressDetail">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>物流详情 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__expressDetail_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/order__expressDetail_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/order__common__header.ftl">
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="http://www.571xz.com">首页</a> &gt;
    <a href="member/index.htm">我的星座网</a> &gt;
    <a href="myOrder.htm">我的订单</a> &gt;
    <span class="fcF40">物流详情</span>
</div>
<div class="expressInfo layout">
    <h2 class="fs16 fwb yahei">物流详情</h2>
    <div class="exoressStatus">
        <ul>
                <#if (0+1) lt expressCurrentState >
                    <li class="step1-done"></li>
                <#elseif (0+1) == expressCurrentState>
                    <li class="step1-current"><span class="pa arrow"></span></li>
                <#else>
                    <li></li>
                </#if>
                <#if (1+1) lt expressCurrentState >
                    <li class="step2-done"></li>
                <#elseif (1+1) == expressCurrentState>
                    <li class="step2-current"><span class="pa arrow"></span></li>
                <#else>
                    <li></li>
                </#if>
                <#if (2+1) lt expressCurrentState >
                    <li class="step3-done"></li>
                <#elseif (2+1) == expressCurrentState>
                    <li class="step3-current"><span class="pa arrow"></span></li>
                <#else>
                    <li></li>
                </#if>
                <#if (3+1) lt expressCurrentState >
                    <li class="step4-done"></li>
                <#elseif (3+1) == expressCurrentState>
                    <li class="step4-current"><span class="pa arrow"></span></li>
                <#else>
                    <li></li>
                </#if>
        </ul>
    </div>
    <div class="expressDetailBox">
        <div class="expressDetail">
            <div class="packageTitle yahei fs16">您的包裹
            <#if expressCurrentState == 1>
            正在待揽件，请耐心等待...
            <#elseif expressCurrentState == 2>
            正在运输中，请耐心等待...
            <#elseif expressCurrentState == 3>
            正在派送中，请耐心等待...
            <#elseif expressCurrentState == 4>
            已签收，谢谢您的使用！
            </#if></div>
            <div class="packageBox pr">
                <#list expressDetail as detail>
                <span class="date fwb arail">${detail.date!}</span>
                <span class="week fwb">${detail.week!}</span>
                <ul>
                    <#list detail.detailList as list>
                    <li>
                        <span class="time arail">${list.time!}</span>
                        <span class="desc">${list.desc!}</span>
                    </li>
                    </#list>
                </ul>
                </#list>
            </div>
            <div class="expressTips tar fc9">以上为快递公司原文信息</div>
        </div>
    </div>
    <div class="orderInfo">
        <p class="fc6"><span class="expressNum">运单编号：<em class="yahei fs14 fwb">${expressCode!}</em></span><span>物流公司：</span><em class="fwb fc3">${expressName!}</em></p>
        <p class="fc6">收货地址：<span class="fc3 fwb">${expressAddrInfo.address!} ${expressAddrInfo.name!} ${expressAddrInfo.phone!}</span></p>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">