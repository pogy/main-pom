<#assign $pageid="noOrderInfo">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>不存在订单 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__noOrderInfo_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/order__noOrderInfo_js.ftl">
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
    <span class="fcF40">我的订单</span>
</div>
<div class="noOrderInfo layout tac">
    <span></span>
    <p class="fc9 fs18 yahei">Sorry,此订单不存在~</p>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">