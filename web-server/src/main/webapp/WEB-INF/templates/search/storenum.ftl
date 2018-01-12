<#assign $pageid="storenum">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>星座搜索 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__storenum_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/search__common_js.ftl">
<#include "/__style_torrent__/search__storenum_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="shop">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/search__common__pageNav.ftl">
<#list [{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"mid","value":""+query.mid},{"name":"keyword","value":""+query.keyword}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="layout">
<#include "/__ftl_links__/search__common__catFilterBar.ftl">
    <#if (storelist?size) gt 0>
<div class="storelist">
    <#list storelist as store>
    <div class="storeitem">
        <a class="storeImgBox" href="${mainHost!}/shop.htm?id=${store.id!}" target="_blank">
            <img src="${store.imgsrc!}">
        </a>
        <div class="storeInfoBox">
            <div class="p1">
                <a class="title" href="${mainHost!}/shop.htm?id=${store.id!}" title="${store.marketName!} ${store.name!}" target="_blank"><em class="marketName">${store.highMarketName!}</em><em class="storeName">${store.highName!}</em></a>
                <span class="xy">
<#list [{"num":store.xy}] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
                </span>
                <span class="imbox">
<#list [{"id":"${store.aliww!}"}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
<#list [{"id":"${store.imqq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
                </span>
            </div>
            <div class="p2">
                <p>主营：${store.mainCate!}</p>
                <p>市场：${store.fullMarketText!}</p>
                <p>电话：${store.tel!}</p>
            </div>
            <div class="p3">
                共<em>${store.goodsCount!}</em>件商品
            </div>
        </div>
        <div class="storeGoodslistBox">
            <#list store.goodslist as goods>
            <div class="picitem">
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <img class="img" src="${goods.imgsrc!}_220x220.jpg">
                </a>
                <p>&yen;${goods.piprice!}</p>
            </div>
            </#list>
        </div>
    </div>
    </#list>
</div>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    <#else>
<div class="goodslistEmptyCon">
    <p class="fs18 yahei fc6">Sorry, 未查询到相应商品~</p>
</div>
    </#if>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">