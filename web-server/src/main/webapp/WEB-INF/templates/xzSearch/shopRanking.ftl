
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
<#include "/common/base__config.ftl">
<#assign $pageid>shopRanking</#assign>
<#assign webSite>hz</#assign>
    <#include "/__private_torrent__/common__base_css.ftl">
<#include "/__private_torrent__/common__xz_css.ftl">
<#include "/__private_torrent__/xzSearch__common_css.ftl">
<#include "/__private_torrent__/xzSearch__shopRanking_css.ftl">
    <script src="http://style.571xz.com/v4/common/js/jquery.js"></script>
    <#include "/__private_torrent__/common__base_js.ftl">
<#include "/__private_torrent__/common__xz_js.ftl">
<#include "/__private_torrent__/xzSearch__shopRanking_js.ftl">
</head>
<body>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__private_template__/xzSearch__common__header.ftl">
<#include "/__private_template__/xzSearch__common__nav.ftl">
 <div class="layout">
<#list rankingCateList as rankingCateItem>
<div class="rankingCateItem">
        <h3 class="title">${rankingCateItem.rankingTitle!}</h3>
        <div class="rankBox clearfix">
            <div class="left clearfix">
                <ul class="clearfix">
                    <#list rankingCateItem.cateLineList as cateLine>
                    <li>
                        <div class="colorBlock <#if cateLine_index == 0>first<#elseif cateLine_index == 1>second<#elseif cateLine_index == 2>last</#if>">
                             <h4>上升${cateLine.upPos!}</h4>
                             <div class="details">
                                <p>${cateLine.text!}</p>
                                <p>${cateLine.totalNum!}</p>
                             </div>
                        </div>
                    </li>
                    </#list>
                </ul>
            </div>
            <div class="right">
                <table border="0">
                    <thead>
                        <tr>
                            <th class="firstTh" align="left">档口</th>
                            <th class="exponentTh" align="left">指数</th>
                            <th  align="left">升降位次</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list rankingCateItem.shopList as shopItem>
                        <tr>
                            <td class="firstTd<#if shopItem_index == 0> num1<#elseif shopItem_index == 1> num2<#elseif shopItem_index == 2> num3</#if>">
                                <span class="rank-num"><#if shopItem_index gt 2>${shopItem_index + 1}</#if></span>
                                <a target="_blank" href="/shop.htm?id=${shopItem.shopId!}" class="place">${shopItem.fullShopName!}</span>
                                <span class="honor">
<#assign text>{"num":shopItem.shopLevel}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
</span>
                            </td>
                            <td>${shopItem.exponent!}</td>
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
                    </tbody>
                </table>
                <div class="checkAll">
                    <a href="fullShopRanking.htm?id=${rankingCateItem.rankingId!}">完整榜单 >></a>
                </div>
            </div>
        </div>
</div>
</#list>
<div class="totalRanks clearfix">
    <#list rankingShopList as rankingShopItem>
<div class="rankingShopItem">
    <h3 class="title">${rankingShopItem.rankingTitle!}</h3>
    <div class="tableBox">
        <table border="0">
             <thead>
                <tr>
                    <th class="firstTh" align="left">档口</th>
                    <th class="lastTH" align="right">指数</th>
                </tr>
            </thead>
            <tbody>
                <#list rankingShopItem.shopList as shopItem>
                <tr>
                    <td class="firstTd<#if shopItem_index == 0> num1<#elseif shopItem_index == 1> num2<#elseif shopItem_index == 2> num3</#if>">
                        <span class="rank-num"><#if shopItem_index gt 2>${shopItem_index + 1}</#if></span>
                        <a target="_blank" href="/shop.htm?id=${shopItem.shopId!}" class="place">${shopItem.fullShopName!}</span>
                    </td>
                    <td class="lastTd"> <span class="honor">
<#assign text>{"num":shopItem.shopLevel}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
</span></td>
                </tr>
                </#list>
            <tbody>
        </table>
         <div class="checkAll">
            <a href="fullShopRanking.htm?id=${rankingShopItem.rankingId!}">完整榜单 &gt;&gt;</a>
        </div>
    </div>
</div>
    </#list>
</div>
 </div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">
