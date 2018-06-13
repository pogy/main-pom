<div class="searchHeader">
    <div class="layout">
        <div class="logoLeft">
            <a href="//${webSite!}.571xz.com">
                <img src="//style.571xz.com/v6/common/css/img/xz/mtLogo.png" alt width="168" height="30">
            </a>
            <em class="yahei">${headerTitle!}</em>
        </div>
<div class="searchBar fr">
    <div class="tabList clearfix">
        <ul>
            <li type="goods" <#if 'goods' == searchType>class="select"</#if>>商品</li>
            <li type="shop" <#if 'shop' == searchType>class="select"</#if>>档口</li>
        </ul>
        <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
        <a href="${mainHost!}/picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
        </#if>
    </div>
    <div class="searchBox">
        <form id="formSearch"
            <#if searchType == 'shop'>
                action="//www.571xz.com/storenum.htm"
            <#else>
                action="//so.571xz.com/${webSite!}search.htm"
            </#if>
        >
            <#if searchType == 'shop'><input class="searchWeb" type="hidden" name="webSite" value="${webSite!}"> </#if>
            <input type="text" class="searchCon fl" name="keyword" placeholder="<#if searchType == 'shop'>输入店铺名称<#else>输入商品名称</#if>" <#if $pageid == 'search' || $pageid == 'storenum'>value="${query.keyword!}"</#if>>
            <button type="submit" class="searchBtn fs14">搜索</button>
        </form>
    </div>
</div>
    </div>
</div>