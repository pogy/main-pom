<#assign $pageid="bindAlipaySuccess">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>绑定设置 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__bindAlipaySuccess_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__bindAlipaySuccess_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="mybag">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>我的资金 &gt; 绑定设置</a></li>
</ul>
<div class="bindAlipaySuccessCon">
    <p class="fs18"><i class="icon-checked"></i>恭喜您，<span class="fcBlue">您已经成功绑定支付宝，</span></p>
    <p class="fs18">可以进行提现！</p>
    <p class="fc6 toLinkTime"><span class="time">3</span>秒后自动跳转到<a href="withdraw5Apply.htm" class="fcBlue">提现页面</a></p>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">