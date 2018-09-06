<div class="popularGoods layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="popularGoods" data-text="人气"></a>
    <h3><span class="yahei">人气商品</span>人气爆款 0点更新</h3>
</div>
    <div class="styleTabs" id="styleSlide">
        <div class="styleTabTitle clearfix">
            <ul>
                <#list popularGoodsList as tabs>
                    <li>${tabs.sname!}<em></em></li>
                </#list>
            </ul>
        </div>
        <div class="styleTabContent">
            <#list popularGoodsList as tabs>
                <div class="goodsList">
                    <#list tabs.goodsList as goods>
<div class="goodsItem">
    <a class="imgBox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
        <img src="${goods.imgSrc!}_300x300.jpg">
    </a>
    <div class="goodsInfo">
        <span class="fcF40 yahei fs14">&yen;${goods.piprice!}</span>
        <a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" class="fr">${goods.marketName!} ${goods.shopNo!}</a>
    </div>
</div>
                    </#list>
                </div>
            </#list>
        </div>
    </div>
</div>