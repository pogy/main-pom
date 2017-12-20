<#if newGoodsList??>
<div class="newGoods">
    <h3>店铺新品</h3>
    <#list newGoodsList as goods>
        <div class="goodsitem">
            <a class="imgbox" href="item.htm?id=${goods.itemId!}" target="_blank">
                <img class="lazyload img" src="${goods.imgUrl!}_240x240.jpg">
            </a>
            <p class="p1">
                <span class="pricebox">&yen; ${goods.price!}</span>
            </p>
            <p class="title"><a href="item.htm?id=${goods.itemId!}" target="_blank">${goods.title!}</a></p>
        </div>
    </#list>
</div>
</#if>