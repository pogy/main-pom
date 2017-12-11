<div class="nav">
    <div class="layout navCon">
        <div class="navList">
            <ul>
                <li class="first"><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
                <#if webSite == 'hz'>
<li
>
    <a href="http://hz.571xz.com/market.htm" target="_blank">
        逛市场
        <i class="hot"></i>
    </a>
</li>
<li
>
    <a href="http://so.571xz.com/hzgoods.htm" target="_blank">
        商品库
    </a>
</li>
<li
>
    <a href="http://so.571xz.com/newgoods.htm" target="_blank">
        今日新品
    </a>
</li>
<li
        <#if 'shopRanking' == $pageid>class="actived"</#if>
        <#if 'fullShopRanking' == $pageid>class="actived"</#if>
>
    <a href="/shopRanking.htm" target="_blank">
        排行榜
        <i class="hot"></i>
    </a>
</li>
<li
        <#if 'daifaIndex' == $pageid>class="actived"</#if>
>
    <a href="/daifaIndex.htm" target="_blank">
        一件代发
    </a>
</li>
<li
        <#if 'shopIconCopyright' == $pageid>class="actived"</#if>
        <#if 'bqsqIndex' == $pageid>class="actived"</#if>
>
    <a href="/shopIconCopyright.htm" target="_blank">
        知识产权
    </a>
</li>
<li
>
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