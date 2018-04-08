<#assign $pageid>takeGoodsStatistic</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>拿货统计 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__takeGoodsStatistic_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/daifa__takeGoodsStatistic_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="timeArea">
    <label class="fc6">时间:</label>
    <span class="fs14">${timeArea!}</span>
</div>
<div class="statisticCon">
    <ul class="clearfix">
        <#list takeGoodsStatisticList as item>
        <li>${item.name!}&nbsp;&nbsp;&nbsp;(${item.num!}件)</li>
        </#list>
    </ul>
</div>
    </div>
</div>