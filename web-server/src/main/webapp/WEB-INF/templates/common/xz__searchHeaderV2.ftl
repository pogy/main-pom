<div class="searchHeaderV2">
    <div class="layout">
        <div class="logoLeft">
            <a href="//${webSite!}.571xz.com">
                <img src="//style.571xz.com/v6/common/css/img/xz/logo.png" width="168" height="103">
            </a>
        </div>
<#include "/common/xz__siteList.ftl">
<#list [{}] as $it>
<div class="searchBar fr yahei">
    <div class="tabList clearfix">
        <ul>
            <li type="goods" <#if 'goods' == searchType>class="select"</#if>>商品</li>
            <li type="shop" <#if 'shop' == searchType>class="select"</#if>>档口</li>
        </ul>
        <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
        <a href="${mainHost!}/picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
        </#if>
    </div>
    <div class="searchBox clearfix">
        <form id="formSearch"
            <#if searchType == 'shop'>
                action="//www.571xz.com/storenum.htm"
            <#else>
                action="//so.571xz.com/${webSite!}search.htm"
            </#if>
        >
            <#if searchType == 'shop'><input class="searchWeb" type="hidden" name="webSite" value="${webSite!}"> </#if>
            <input type="text" class="searchCon fl" name="keyword" placeholder="<#if searchType == 'shop'>输入店铺名称<#else>输入商品名称</#if>" <#if $pageid == 'search' || $pageid == 'storenum'>value="${query.keyword!}"</#if> autofocus="autofocus">
            <button type="submit" class="searchBtn fs14">搜索</button>
            <div class="myOrderBox fl">
            <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop>
<#list [{"href":mainHost+"/order/myOrder.htm"}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-white-o
         myOrderBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        我的代发
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
            </div>
        </form>
    </div>
</div>
</#list>
    </div>
</div>