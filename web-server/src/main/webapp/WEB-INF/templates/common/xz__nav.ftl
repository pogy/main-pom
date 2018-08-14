<ul class="nav yahei">
    <#if !disabledIndexNav>
    <li class="first"><a href="//${webSite!}.571xz.com" target="_blank">首页</a></li>
    </#if>
    <#if webSite == 'hz'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="//hz.571xz.com/market.htm" target="_blank">
        逛市场
    </a>
</li>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/hzgoods.htm" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/newgoods.htm" target="_blank">
        今日新品
    </a>
</li>
<li
        <#if 'shopRanking' == $pageid>class="actived"</#if>
        <#if 'fullShopRanking' == $pageid>class="actived"</#if>
>
    <a href="/shopRanking.htm" target="_blank">
        排行榜
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
    <a href="//zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
<li
>
    <a href="//photo.571xz.com" target="_blank">
        摄影基地
        <i class="new"></i>
    </a>
</li>
    <#elseif webSite == 'cs'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="//cs.571xz.com/market.htm?mid=43" target="_blank">
        逛市场
    </a>
</li>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/csgoods.htm" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'photoPics' == $pageid>class="actived"</#if>
>
    <a href="//www.571xz.com/photoPics.htm?webSite=cs" target="_blank">
        图片库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/newgoods.htm?webSite=cs" target="_blank">
        今日新品
    </a>
</li>
<li
>
    <a href="//zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
    <#elseif webSite == 'ss'>
    <#elseif webSite == 'bj'>
    <#elseif webSite == 'gz'>
    <#elseif webSite == 'qz'>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/qzgoods.htm?pid=50011740" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/newgoods.htm?cid=2&amp;webSite=qz" target="_blank">
        今日新品
    </a>
</li>
<li
>
    <a href="//zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
<li
>
    <a href="//hz.571xz.com" target="_blank">
        男装
    </a>
</li>
    <#elseif webSite == 'zl'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="//zl.571xz.com/market.htm?mid=82" target="_blank">
        逛市场
    </a>
</li>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/zlgoods.htm?pid=50008165" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
>
    <a href="//so.571xz.com/newgoods.htm?webSite=zl&amp;cid=5" target="_blank">
        今日新品
    </a>
</li>
<li
>
    <a href="//zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
    </#if>
</ul>