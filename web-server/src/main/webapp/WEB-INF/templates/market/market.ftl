<#assign $pageid="market">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>逛市场 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/market__market_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/market/plugin/jquery.pjax.js"></script>
<script src="http://style.571xz.com/v6/market/plugin/nprogress.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/market__market_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle="">
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<div class="pageNav">
    <div class="layout">
        <div class="allCateNavBox">
            <div class="cateFication yahei fs14">全部商品分类 <i class="icon-downarrow"></i></div>
            <div class="cateCon">
                <ul>
                    <#list catemenu as menu>
                        <li>
                            <em class="${menu.icon!}"></em>${menu.text!}<i class="icon-rightarrow"></i>
                            <div class="cateDatail">
                                <h3 class="yahei fs14 fc3">${menu.text!}</h3>
                                <div class="dateItem">
                                    <#list menu.submenu as item>
                                        <a href="http://so.571xz.com/${webSite!}goods.htm?pid=${item.pid!}<#if item.cid??>&cid=${item.cid!}</#if><#if item.keyword??>&keyword=${item.keyword!}</#if>" target="_blank">${item.text!}</a>
                                    </#list>
                                </div>
                            </div>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
<#include "/common/xz__nav.ftl">
        <div class="regShopButton">
            <i class="icon-user"></i>
            <a href="/member/ruzhu.htm">商家入驻</a>
        </div>
    </div>
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
                            <li <#if market.id == marketId>class="selected"</#if>><a href="?mid=${market.id!}">${market.name!}</a></li>
                        </#list>
                    </ul>
                    <i class="iconfont showmore">&#xe60b;</i>
                </div>
            </div>
            <div class="innerbox splitline"></div>
            <div class="innerbox cates">
                <div class="ctnbox">
                    <label><i class="iconfont mainDoi"></i>主营：</label>
                    <ul>
                        <li <#if !cateId>class="selected"</#if>><a href="?mid=${marketId!}">全部</a></li>
                        <#list cates as cate>
                            <li <#if cate.id == cateId>class="selected"</#if>><a href="?mid=${marketId!}&cid=${cate.id!}">${cate.name!}</a></li>
                        </#list>
                    </ul>
                    <i class="iconfont showmore">&#xe60b;</i>
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
                <a href="shop.htm?id=${store.id!}" target="_blank">
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
<script modulepath="market/market#marketList">
var marketName = '${marketName!}';
$$.reloadNavbar(); // 重新生成左侧浮动条
$$.reloadFilterbar(); // 重新生成顶部浮动条
$$.setBg();  // 重新生成背景
</script>
</div>
<#include "/common/xz__footer.ftl">
</body>
<#include "/common/cnzz.ftl">