<#assign $pageid>userBalance</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>我的资金 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__userBalance_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__userBalance_js.ftl">
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
    <li class="select"><a>我的资金</a></li>
</ul>
<div class="remainSum">
    <div class="remainSumTop">
        <div class="myRemain">
            <h3>我的余额（元）</h3>
            <p id="yuerBalance" data-m="">加载中…</p>
        </div>
        <div class="amountFrozen">
            <h3>冻结金额（元）</h3>
            <p>加载中…</p>
        </div>
    </div>
    <div class="remainSumBtom">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <a href="iwantToRechargein5.htm"
    class="fmButton
         fmButton-orange
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="recharge"
>
        充值
    </a>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <a href="withdraw5Apply.htm"
    class="fmButton
         fmButton-lighter-o
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="withdrawal"
>
        提现
    </a>
</#list>
    </div>
    <input type="hidden" class="tempCode" value="${tempCode!}">
</div>
<div class="capSub">
    <table>
        <thead>
            <tr class="thTr">
                <th class="orderno">订单编号</th>
                <th class="time">时间</th>
                <th class="money">金额</th>
                <th class="type">类型</th>
            </tr>
        </thead>
        <tbody class="yahei"></tbody>
    </table>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">