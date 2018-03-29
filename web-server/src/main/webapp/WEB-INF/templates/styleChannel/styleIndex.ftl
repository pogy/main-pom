<#assign $pageid="styleIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>风格频道首页 - 四季星座网</title>
<#include "/common/base__config.ftl">
<#assign searchType="goods">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/styleChannel__common_css.ftl">
<#include "/__style_torrent__/styleChannel__styleIndex_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/styleChannel/plugin/ekoo.min.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/styleChannel__common_js.ftl">
<#include "/__style_torrent__/styleChannel__styleIndex_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign isShowHoverCate=false>
<#include "/__ftl_links__/styleChannel__common__searchHeader.ftl">
<#list [{"fields":[{"name":"spid","value":""+query.spid}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#include "/__ftl_links__/styleChannel__common__pageNav.ftl">
<div class="layout pr">
<#list [{}] as $it>
<#include "/__ftl_links__/styleChannel__common__pageCateMenu.ftl">
</#list>
<div class="banner">
    <div id="slideBox" class="slideBox">
		<div class="hd">
			<ul></ul>
		</div>
		<div class="bd">
			<ul>
				<#list styleBanner as banner>
				    <li>
				        <a href="${banner.href!}" target="_blank">
				        <img src="${banner.imgsrc!}"></a>
				    </li>
				</#list>
			</ul>
		</div>
		<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
		<a class="prev" href="javascript:void(0)"></a>
		<a class="next" href="javascript:void(0)"></a>
	</div>
</div>
</div>
<div class="powerStore yahei">
    <div class="layout">
        <h3 class="fc3"><strong>实力</strong>档口</h3>
        <div class="storeList">
            <div class="storeContainer clearfix">
                <#list shopList as store>
                    <div class="storeItem">
                        <div class="storeHead">
                            <a href="${mainHost!}/shop.htm?id=${store.shopId!}" target="_blank">${store.shopName!}</a><span class="fr"><i></i><em>${store.shopAge!}年老店</em></span>
                        </div>
                        <div class="storeGoods">
                            <ul>
                                <#list store.goodsList as goods>
                                    <li><a href="item.htm?id=${goods.goodsId!}" target="_blank"><img src="${goods.imgsrc!}"></a></li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </#list>
            </div>
            <a href="styleMarket.htm?spid=${query.spid!}" class="shopMore" target="_blank">查看全部 ${sname!} 档口 <i class="icon-rightarrow"></i></a>
        </div>
    </div>
</div>
<div class="hotSaleGoods">
    <div class="layout">
        <h3 class="fc3 yahei"><strong>爆款</strong>商品</h3>
        <div class="goodsList clearfix">
            <ul>
                <#list hotSaleGoodsList as goods>
                    <li>
                        <a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                            <img src="${goods.imgSrc!}_300x300.jpg">
                        </a>
                        <div class="goodsInfo">
                            <span class="fcF40 yahei fs14">&yen;${goods.piprice!}</span>
                            <a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" class="fr">${goods.marketName!} ${goods.shopNo!}</a>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
        <a href="styleGoodsList.htm?spid=${query.spid!}" class="shopMore yahei" target="_blank">查看全部 ${sname!} 商品<i class="icon-rightarrow"></i></a>
    </div>
</div>
<#include "/common/xz__footer.ftl">
</body>
<#include "/common/cnzz.ftl">