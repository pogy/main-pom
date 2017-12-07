<#assign $pageid>batchOrders</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>批量下单，和重复劳动力说再见 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzPage__batchOrders_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzPage__batchOrders_js.ftl">
</head>
<body>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="banner">
    <div class="layout pr"></div><a href="http://www.571xz.com/contact.htm" target="_blank"></a></div>
</div>
<div class="bg">
<div class="introduction layout">
    <div class="title"></div>
    <div class="content yahei">
        <ul>
            <li>
                <span class="taobao"></span>
                <h3>同步淘宝订单</h3>
                <p>四季星座网订单信息同步淘宝订单，可批量下单，操作：四季星座网后台“我的星座”→ “批量下单”操作。</p>
            </li>
            <li>
                <span class="order"></span>
                <h3>订单批量付款</h3>
                <p>未付款的订单一次性批量付款，操作：四季星座网后台“我的星座”→“我的订单”→选择订单点击“批量付款”。</p>
            </li>
            <li>
                <span class="send"></span>
                <h3>批量标记淘宝发货</h3>
                <p>发货标记直接同步到淘宝，操作：四季星座网后台“我的星座”→“我的订单”→选择订单点击“批量标记淘宝发货”。</p>
            </li>
        </ul>
    </div>
</div>
<div class="progress layout">
    <div class="title"></div>
    <div class="content"></div>
</div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">