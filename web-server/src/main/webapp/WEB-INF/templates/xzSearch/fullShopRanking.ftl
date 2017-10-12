
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
<#include "/common/base__config.ftl">
<#assign $pageid>fullShopRanking</#assign>
<#assign webSite>hz</#assign>
    <#include "/__private_torrent__/common__base_css.ftl">
<#include "/__private_torrent__/common__xz_css.ftl">
<#include "/__private_torrent__/xzSearch__common_css.ftl">
<#include "/__private_torrent__/xzSearch__fullShopRanking_css.ftl">
    <script src="http://style.571xz.com/v4/common/js/jquery.js"></script>
    <#include "/__private_torrent__/common__base_js.ftl">
<#include "/__private_torrent__/common__xz_js.ftl">
<#include "/__private_torrent__/xzSearch__fullShopRanking_js.ftl">
</head>
<body>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__private_template__/xzSearch__common__header.ftl">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="nav">
    <div class="layout navCon">
        <div class="navList">
            <ul>
                <li class="first"><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
                <#if webSite == 'hz'>
<li >
    <a href="http://hz.571xz.com/market.htm" target="_blank">
        逛市场
        <i class="hot"></i>
    </a>
</li>
<li >
    <a href="http://so.571xz.com/hzgoods.htm" target="_blank">
        商品库
    </a>
</li>
<li >
    <a href="http://so.571xz.com/newgoods.htm" target="_blank">
        今日新品
    </a>
</li>
<li >
    <a href="http://www.571xz.com/activity/redbull.htm" target="_blank">
        发现好货
        <i class="hot"></i>
    </a>
</li>
<li >
    <a href="/daifaIndex.htm" target="_blank">
        一件代发
    </a>
</li>
<li class="actived">
    <a href="/shopRanking.htm" target="_blank">
        排行榜
        <i class="hot"></i>
    </a>
</li>
<li >
    <a href="/shopIconCopyright.htm" target="_blank">
        知识产权
    </a>
</li>
<li >
    <a href="http://zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
                <#elseif webSite == 'cs'>
                <#elseif webSite == 'ss'>
                <#elseif webSite == 'bj'>
                <#elseif webSite == 'gz'>
                </#if>
        </div>
    </div>
</div>
<div class="layout shopRanking">
    <h3 class="title">${shopRanking.title!}</h3>
    <div class="tableBox">
        <table border="0">
             <thead>
                <tr>
                    <th align="left" class="firstTh">档口</th>
                    <th align="left">商品数(件)</th>
                    <th class="exponentTh" align="left">指数</th>
                    <th align="left">升降位次</th>
                </tr>
            </thead>
            <tbody>
                <#list shopRanking.shopList as shopItem>
                <tr>
                    <td  class="firstTd<#if shopItem_index == 0> num1<#elseif shopItem_index == 1> num2<#elseif shopItem_index == 2> num3</#if>">
                        <span class="rank-num"><#if shopItem_index gt 2>${shopItem_index + 1}</#if></span>
                        <a class="place" href="/shop.htm?id=${shopItem.shopId!}">${shopItem.fullShopName!}</a>
                        <span class="honor">
<#assign text>{"num":shopItem.shopLevel}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
</span>
                    </td>
                    <td>${shopItem.goodsNum!}</td>
                    <td>
                        ${shopItem.exponent!}
                    </td>
                    <td>
                        <div class="upDown">
                            <span>
                                <#if shopItem.changeNum lt 0>
                                    ${-shopItem.changeNum}
                                <#else>
                                    ${shopItem.changeNum!}
                                </#if>
                            </span>
                            <#if shopItem.changeNum gt 0>
                            <img src="http://style.571xz.com/v4/xzSearch/css/img/rank1.png" alt="" />
                            <#elseif shopItem.changeNum lt 0>
                            <img src="http://style.571xz.com/v4/xzSearch/css/img/rank2.png" alt="" />
                            <#else>
                            <img src="http://style.571xz.com/v4/xzSearch/css/img/rank3.png" alt="" />
                            </#if>
                        </div>
                    </td>
                </tr>
                </#list>
            <tbody>
        </table>
    </div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
</#list>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">
