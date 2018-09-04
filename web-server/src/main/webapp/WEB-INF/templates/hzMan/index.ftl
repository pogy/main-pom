<#assign $pageid="index">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>[四季星座网]杭州站-四季星座网-四季星座论坛-四季青服装货源，四季青市场，网店代理货源，网上服装进货，男装淘宝货源，女装淘宝货源，网络货源,网店货源导航,淘宝店货源,实体网络进货,杭州网店之家,杭州专业网店货源,杭州网店货源</title>
    <meta name="keywords" content="四季星座,四季星座网,四季星座论坛,网店代理货源,开淘宝店货源,淘宝货源,服装批发市场,杭州网店之家,杭州四季青服装批发市场,杭州四季青服装批发市场地址,外贸服装进货渠道,服装进货渠道">
    <meta name="description" content="四季星座网杭州的服装杭州女装货源批发网,市场包含了四季星座,星座女装电子商务楼,之江服装电子商务楼,四季青,意法服饰城,新杭派,四季星座男装等,是网络卖家网络货源平台,网店货源,女装货源,杭州女装货源,淘宝货源,实体店网络进货渠道,星座论坛 ,四季星座论坛，网店货源,实体店网络进货优选渠道!">
<#include "/common/base__config.ftl">
<#assign searchType="goods">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/hzMan__common_css.ftl">
<#include "/__style_torrent__/hzMan__index_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/hzMan/plugins/ekoo.min.js"></script>
<script src="//style.571xz.com/v6/hzMan/plugins/jquery.cookie.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/hzMan__common_js.ftl">
<#include "/__style_torrent__/hzMan__index_js.ftl">
</head>
<body>
<#include "/__ftl_links__/hzMan__common__fixedSearchBar.ftl">
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/hzMan__common__topGoatPic.ftl">
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<#assign disabledIndexNav=false>
<script modulepath="hzMan/common#forIps">
var hreflocation = window.location.href;
if(/^https?:\/\/(www\.)?571xz\.com/.test(hreflocation)){//仅首页
    jQuery.getScript("//ip.ws.126.net/ipquery",function(){  //新浪废弃接口int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
        var city = localAddress["city"];
        var prov = localAddress["province"];
        if(city == '石狮市'){
            window.location.href = "//ss.571xz.com";
        }else if(city == '常熟市'){
            window.location.href = "//cs.571xz.com";
        }else if(city == '广州市'){
            window.location.href = "//gz.571xz.com";
        }else if(city == '泉州市'){
            window.location.href = "//qz.571xz.com";
        }else if(prov == '河北省'){
            window.location.href = "//cz.571xz.com";
        }
    }) ;
}
</script>
<#include "/common/xz__searchHeaderV2.ftl">
<#include "/common/xz__navV2.ftl">
<#include "/common/xz__choosePageType.ftl">
<div class="firstScreenContent layout">
    <div class="leftbox">
<div class="catemenu" id="catemenu">
    <div class="listbox yahei">
        <#list catemenu as menu>
        <div class="list" data-menuid="${menu.id!}">
            <h3 class="mtitle"><em>${menu.text!}</em><i></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                <#list menu.listitems as item>
                    <li><a target="_blank" href="${item.href!}">${item.name!}</a></li>
                </#list>
                </ul>
            </div>
        </div>
        </#list>
    </div>
    <div class="detailbox">
        <#list catemenu as menu>
            <div class="innerbox ${menu.id!}">
            <#list menu.detailitems as pitem>
                <div class="itemsbox">
                    <h4>${pitem.text!}</h4>
                    <div class="itemlist clearfix">
                        <#list pitem.items as item>
                            <a href="${item.href!}" target="_blank">${item.name!}</a>
                        </#list>
                    </div>
                </div>
            </#list>
            </div>
        </#list>
    </div>
</div>
    </div>
    <div class="centerbox">
<div class="topBanner">
    <div id="slideBox" class="slideBox">
		<div class="hd">
			<ul></ul>
		</div>
		<div class="bd">
			<ul>
				<#list topBanner as banner>
				    <li><a href="${banner.href!}" target="_blank"><img width="738" height="320" alt="" src="${banner.imgsrc!}"></a></li>
				</#list>
			</ul>
		</div>
		<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
		<a class="prev" href="javascript:void(0)"></a>
		<a class="next" href="javascript:void(0)"></a>
	</div>
</div>
<div class="topImgGoat">
    <ul class="clearfix">
        <#list topStoread as item>
            <#if item_index lt 2>
                <li><a href="${item.href!}" target="_blank"><img src="${item.imgsrc!}"></a></li>
            </#if>
        </#list>
    </ul>
</div>
    </div>
    <div class="rightbox">
<div class="topInfoBox yahei">
    <div class="userbox tac">
        <img class="userIcon" src="//style.571xz.com/v6/hzMan/css/img/touxiang.png">
        <div class="wellcom">
            <p class="s1" id="wellcomUserInfo">Hi，欢迎来到</p>
            <p>www.571xz.com</p>
        </div>
        <div class="btnLinks clearfix" id="goBackstageButtonBox">
            <a class="first" href="/login.htm">登录</a>
            <a href="/regedit.htm">注册</a>
            <a href="/member/ruzhu.htm">供应商</a>
        </div>
    </div>
    <div class="userCount">
        <ul class="numbers clearfix">
            <#list userCount as num>
                <li>${num!}</li>
            </#list>
        </ul>
        <p class="countDesc">充足的货源任你进货选择</p>
    </div>
    <div class="noticebox">
        <div class="tabBtn">
            <span class="selected">公告</span><span>规则</span>
        </div>
        <div class="tabCon">
            <ul>
                <#list notices as item>
                    <li><a href="${item.href!}" target="_blank" title="${item.text!}">${item.text!}</a></li>
                </#list>
            </ul>
            <ul>
                <#list rules as item>
                    <li><a href="${item.href!}" target="_blank" title="${item.text!}">${item.text!}</a></li>
                </#list>
            </ul>
        </div>
    </div>
</div>
    </div>
</div>
<div class="styleChannel layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
    <h3><span class="yahei">风格馆</span>专业选款，你的专属腔调</h3>
</div>
    <div class="styleList yahei">
        <#list styleList as item>
            <div class="styleItem pr">
                <div class="line pa"></div>
                <h4 class="fc3"><a href="/styleIndex.htm?spid=${item.spid!}" target="_blank">${item.sname!}</a></h4>
                <ul>
                    <li><a href="/styleGoodsList.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>全部商品</li>
                    <li><a href="/styleMarket.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>市场列表</li>
                    <!--<li><a href="/styleRecommd.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>推荐商品</li>-->
                </ul>
                <a href="${item.href!}" target="_blank"><img src="${item.imgsrc!}"></a>
            </div>
        </#list>
    </div>
</div>
<div class="hotSaleGoods layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="hotsaleGoods" data-text="热卖"></a>
    <h3><span class="yahei">热卖商品</span>行业优选 精选档口主打款</h3>
</div>
    <div class="goodsList">
        <#list hotSaleGoodsList as goods>
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
</div>
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
<div class="intimeGoods layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="intimeGoods" data-text="实时"></a>
    <h3><span class="yahei">实时新品</span>实时更新 店内引流好款</h3>
</div>
    <div class="goodsList" id="intimeGoodsList">
    </div>
</div>
<div class="cooperatMarket layout">
    <div class="commonTitle">
        <h3><span class="yahei">合作市场</span>市场精选 甄选优质好款</h3>
    </div>
    <div class="cooperatMarketList">
        <div class="map"></div>
        <ul class="yahei">
            <li>
                <a  href="//hz.571xz.com/market.htm?mid=1" target="_blank">
                    <h4>电商基地</h4>
                    <p>男装网批，爆款发源地</p>
                    <span class="dsjd"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="//hz.571xz.com/market.htm?mid=5" target="_blank">
                    <h4>钱塘大厦</h4>
                    <p>男装精选，有型有实力</p>
                    <span class="qtds"></span>
                </a>
            </li>
            <li>
                <a href="//hz.571xz.com/market.htm?mid=3" target="_blank">
                    <h4>四季星座</h4>
                    <p>行业优选，专业货源</p>
                    <span class="sjxz"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="//hz.571xz.com/market.htm?mid=12" target="_blank">
                    <h4>新杭派</h4>
                    <p>万千好货，原创集结</p>
                    <span class="xhp"></span>
                </a>
            </li>
        </ul>
    </div>
</div>
<#include "/__ftl_links__/hzMan__common__serviceIntro.ftl">
<#include "/__ftl_links__/hzMan__common__siteInfo.ftl">
<div class="sideNavbar" id="sideNavbar"></div>
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">