<div class="header">
    <div class="layout">
        <a class="logo iconfont" href="//www.571xz.com"></a>
        <ul class="fl fs16 yahei clearfix">
            <li><a href="/seller/index.htm"  <#if $pageid == 'memberghs' || $pageid == 'index'>class="selected"</#if>>首页</a></li>
            <li><a href="/seller/userBalance.htm" <#if $pageid == 'iwantToRechargein5' || $pageid == 'withdraw5Apply' || $pageid == 'bindAlipayUser' || $pageid == 'bindAlipayUserOpe' || $pageid == 'bindAlipaySuccess' || $pageid == 'userBalance'>class="selected"</#if>>我的钱包</a></li>
            <li><a href="/seller/sysSetsindex.htm" <#if $pageid == 'safeindex' || $pageid == 'safexgmm' || $pageid == 'safeXgPaymm' || $pageid == 'sysSetsindex'>class="selected"</#if>>安全中心</a></li>
            <#if session_user_redis__.logshop.webSite == 'cs'>
            <li><a href="/seller/photoAlbumManagement.htm" <#if $pageid == 'photoAlbumManagement' || $pageid == 'photoAlbumItem'>class="selected"</#if>>商品相册</a><i class="new"></i></li>
            </#if>
        </ul>
    </div>
</div>