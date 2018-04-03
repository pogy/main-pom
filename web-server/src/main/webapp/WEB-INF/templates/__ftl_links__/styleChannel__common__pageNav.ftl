<div class="pageNav clearfix">
    <div class="layout pr yahei">
        <ul>
            <li <#if $pageid == "styleIndex">class="selected"</#if>><a href="styleIndex.htm?spid=${query.spid!}">首页</a></li>
            <li <#if $pageid == "styleGoodsList">class="selected"</#if>><a href="styleGoodsList.htm?spid=${query.spid!}">商品列表</a></li>
            <!--<li <#if $pageid == "styleRecommd">class="selected"</#if>><a href="styleRecommd.htm?spid=${query.spid!}">新品推荐</a></li>-->
            <li <#if $pageid == "styleMarket">class="selected"</#if>><a href="styleMarket.htm?spid=${query.spid!}">档口列表</a></li>
        </ul>
    </div>
</div>