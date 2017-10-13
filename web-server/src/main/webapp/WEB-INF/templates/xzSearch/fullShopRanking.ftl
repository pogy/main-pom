
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${shopRanking.rankingTitle!} - 四季星座网</title>
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
<#assign text>{"fields":[{"name":"id","value":""+rankingId}]}</#assign>
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
<#include "/__private_template__/xzSearch__common__nav.ftl">
<div class="layout shopRanking">
    <h3 class="title">${shopRanking.rankingTitle!}</h3>
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
                    <td  class="firstTd<#if shopItem.rank == 1> num1<#elseif shopItem.rank == 2> num2<#elseif shopItem.rank == 3> num3</#if>">
                        <span class="rank-num"><#if shopItem.rank gt 3>${shopItem.rank!}</#if></span>
                        <a class="place" href="/shop.htm?id=${shopItem.shopId!}">${shopItem.fullShopName!}</a>
                        <span class="honor">
<#assign text>{"num":shopItem.shopLevel}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
</span>
                    </td>
                    <td>${shopItem.goodsCount!}</td>
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
