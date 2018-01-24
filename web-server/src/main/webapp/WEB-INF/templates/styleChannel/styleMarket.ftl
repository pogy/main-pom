<#assign $pageid="styleMarket">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>风格档口列表 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/styleChannel__common_css.ftl">
<#include "/__style_torrent__/styleChannel__styleMarket_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/styleChannel/plugin/jquery.pjax.js"></script>
<script src="http://style.571xz.com/v6/styleChannel/plugin/nprogress.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/styleChannel__common_js.ftl">
<#include "/__style_torrent__/styleChannel__styleMarket_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign isShowHoverCate=undefined>
<#include "/__ftl_links__/styleChannel__common__searchHeader.ftl">
<#list [{"fields":[{"name":"spid","value":""+query.spid},{"name":"mid","value":""+query.mid}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#include "/__ftl_links__/styleChannel__common__pageNav.ftl">
<div class="layout">
<#list [{"style":"close"}] as $it>
<#include "/__ftl_links__/styleChannel__common__pageCateMenu.ftl">
</#list>
</div>
<div id="pjaxContainer">
<div id="filterbarWrapper" class="useFixed_2">
    <div class="filterbar clearfix" id="filterbar">
        <div class="layout">
            <div class="innerbox markets">
                <div class="ctnbox">
                    <label><i class="iconfont marketIcon"></i>市场：</label>
                    <ul>
                        <#list markets as market>
                            <li <#if market.id == marketId>class="selected"</#if>><a href="?mid=${market.id!}&spid=${query.spid!}">${market.name!}</a></li>
                        </#list>
                    </ul>
                    <i class="iconfont showmore icon-downarrow"></i>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="marketList layout">
    <#list marketList as markets>
        <#if marketId == '5'>
            <#if markets.title == '8F'>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!} 石狮工厂店</span>
                <i></i>
            </h3>
            <#elseif markets.title == '9F'>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!} 牛仔城</span>
                <i></i>
            </h3>
            <#else>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!}</span>
                <i></i>
            </h3>
            </#if>
        <#else>
        <h3 data-lm='${markets.title!}'>
            <span>${markets.title!}</span>
            <i></i>
        </h3>
        </#if>
        <ul class="storeList clearfix">
        <#list markets.stores as store>
            <li>
                <div class="bgfff"></div>
                <a href="${mainHost!}/shop.htm?id=${store.id!}" target="_blank">
                    <h5><#if store.isfdGoods?? && store.isfdGoods == 1><span class="isfdGoods"></span></#if>${store.num!}<#if store.isNew == 1><i></i></#if></h5>
                    <em>${store.cate!}</em>
                    <p>
                        <#list store.tags as tag>
                            <#if tag == 1>
                                <i class="tui"></i>
                            </#if>
                            <#if tag == 2>
                                <i class="huan"></i>
                            </#if>
                            <#if tag == 3>
                                <i class="dai"></i>
                            </#if>
                        </#list>
                    </p>
                </a>
            </li>
        </#list>
        </ul>
    </#list>
</div>
<div id="navbar" class="navbar init">
    <h3>${marketName!}</h3>
    <ul></ul>
    <b><i class="iconfont upArrow"></i>顶部</b>
</div>
<script modulepath="styleChannel/styleMarket#marketList">
var marketName = '${marketName!}';
$$.reloadNavbar(); // 重新生成左侧浮动条
$$.reloadFilterbar(); // 重新生成顶部浮动条
$$.setBg();  // 重新生成背景
</script>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">