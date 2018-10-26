<div class="styleGoods layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
    <h3><span class="yahei">风格馆</span>各类风格 应有尽有</h3>
</div>
    <div class="goodsList">
        <#list styleGoodsList as goods>
<div class="goodsItem<#if (goods_index+1) % 5 == 0> last</#if>">
    <a class="imgBox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
        <img src="${goods.imgSrc!}_300x300.jpg">
    </a>
    <div class="goodsInfo">
        <span class="fcF40 yahei fs14">&yen;${goods.piprice!}</span>
        <a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" class="fr" title="${goods.marketName!} ${goods.shopNo!}">${goods.marketName!} ${goods.shopNo!}</a>
    </div>
</div>
        </#list>
    </div>
</div>