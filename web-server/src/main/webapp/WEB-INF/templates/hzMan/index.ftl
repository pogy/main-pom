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
<#include "/__style_torrent__/hzMan__index_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/hzMan/plugins/ekoo.min.js"></script>
<script src="http://style.571xz.com/v6/hzMan/plugins/jquery.cookie.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/hzMan__index_js.ftl">
</head>
<body>
<div class="fixedSearchBar" id="fixedSearchBar">
    <div class="innner">
        <a class="logo" href="http://www.571xz.com"><img src="http://style.571xz.com/v6/common/css/img/xz/mtLogo.png" title="四季星座网-首页" height="30" width="170"></a>
         <div class="searchbar">
            <#if webSite == 'hz'>
            <div class="tabbox">
                <ul>
                    <li>商品</li>
                    <li>档口</li>
                </ul>
               <i class="img-jiantou"></i>
            </div>
            <#else>
            <div class="btnbox"><span>商品</span></div>
            </#if>
            <form action="http://so.571xz.com/${webSite!}search.htm" target="_blank" id="searchgo3">
                <input type="hidden" name="cid" value="30">
                <input style="text-indent:1em;" class="text-search" name="keyword" type="text">
                <button class="btn-search">搜索</button>
            </form>
        </div>
    </div>
</div>
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#if topPic??>
    <#list topPic as tp>
        <div class="topGoatPic">
            <div class="layout">
                <a href="<#if tp.href == ''>javascript:;<#else>${tp.href!}</#if>" target="_blank">
                    <img src="${tp.imgsrc!}">
                </a>
            </div>
        </div>
    </#list>
</#if>
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<#assign disabledIndexNav=false>
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<div class="searchHeaderV2">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/v6/common/css/img/xz/logo.png" width="168" height="103">
            </a>
        </div>
<#include "/common/xz__siteList.ftl">
<#list [{}] as $it>
<div class="searchBar fr yahei">
    <div class="tabList clearfix">
        <ul>
            <li type="goods" <#if 'goods' == searchType>class="select"</#if>>商品</li>
            <li type="shop" <#if 'shop' == searchType>class="select"</#if>>档口</li>
        </ul>
        <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
        <a href="${mainHost!}/picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
        </#if>
    </div>
    <div class="searchBox clearfix">
        <form id="formSearch"
            <#if searchType == 'shop'>
                action="http://www.571xz.com/storenum.htm"
            <#else>
                action="http://so.571xz.com/${webSite!}search.htm"
            </#if>
        >
            <#if searchType == 'shop'><input class="searchWeb" type="hidden" name="webSite" value="${webSite!}"> </#if>
            <input type="text" class="searchCon fl" name="keyword" placeholder="<#if searchType == 'shop'>输入店铺名称<#else>输入商品名称</#if>" <#if $pageid == 'search' || $pageid == 'storenum'>value="${query.keyword!}"</#if>>
            <button type="submit" class="searchBtn fs14">搜索</button>
            <div class="myOrderBox fl">
            <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop>
<#list [{}] as $it>
    <a href="http://www.571xz.com/order/myOrder.htm"
        target="_blank"
    class="fmButton
         fmButton-white-o
         myOrderBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        我的代发
    </a>
</#list>
            </#if>
            </div>
        </form>
    </div>
</div>
</#list>
    </div>
</div>
<div class="navV2 yahei clearfix">
    <ul>
        <#if !disabledIndexNav>
        <li class="actived"><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
        </#if>
        <#if webSite == 'hz'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="http://hz.571xz.com/market.htm" target="_blank">
        逛市场
    </a>
</li>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="http://so.571xz.com/hzgoods.htm" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
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
    </ul>
</div>
<div class="choosePageType yahei">
    <a class="wbtn" href="/" xzclick="gotoWomanPage">女装</a>
    <a class="mbtn" href="/" xzclick="gotoManPage">男装</a>
</div>
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
        <img class="userIcon" src="http://style.571xz.com/v6/hzMan/css/img/touxiang.png">
        <div class="wellcom">
            <p class="s1" id="wellcomUserInfo">Hi，欢迎来到</p>
            <p>www.571xz.com</p>
        </div>
        <div class="btnLinks clearfix" id="goBackstageButtonBox">
            <a class="first" href="/login.htm">登录</a>
            <a href="/regedit.htm">注册</a>
            <a href="/member/ruzhu.htm">商家入驻</a>
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
                    <li><a href="${item.href!}" target="_blank">${item.text!}</a></li>
                </#list>
            </ul>
            <ul>
                <#list rules as item>
                    <li><a href="${item.href!}" target="_blank">${item.text!}</a></li>
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
                    <li><a href="/styleRecommd.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>推荐商品</li>
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
                <a  href="http://hz.571xz.com/market.htm?mid=1" target="_blank">
                    <h4>电商基地</h4>
                    <p>男装网批，爆款发源地</p>
                    <span class="dsjd"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="http://hz.571xz.com/market.htm?mid=5" target="_blank">
                    <h4>钱塘大厦</h4>
                    <p>男装精选，有型有实力</p>
                    <span class="qtds"></span>
                </a>
            </li>
            <li>
                <a href="http://hz.571xz.com/market.htm?mid=3" target="_blank">
                    <h4>四季星座</h4>
                    <p>行业优选，专业货源</p>
                    <span class="sjxz"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="http://hz.571xz.com/market.htm?mid=12" target="_blank">
                    <h4>新杭派</h4>
                    <p>万千好货，原创集结</p>
                    <span class="xhp"></span>
                </a>
            </li>
        </ul>
    </div>
</div>
<div class="serverIntro">
    <div class="layout serverCon">
        <ul>
            <li>
                <i class="iconServer manDp"></i>
                <p class="yahei">15,000多家档口</p>
                <span>精选货源 一网打尽</span>
            </li>
            <li>
                <i class="iconServer manUp"></i>
                <p class="yahei">1键轻松上传</p>
                <span>上传各大网购平台</span>
            </li>
            <li>
                <i class="iconServer manDf"></i>
                <p class="yahei">1件商品代发</p>
                <span>0库存，0成本</span>
            </li>
            <li>
                <i class="iconServer manTh"></i>
                <p class="yahei">无理由退换</p>
                <span>可支持无条件退换货</span>
            </li>
        </ul>
    </div>
</div>
<div class="siteInfo">
    <div class="layout">
        <div class="logoInfo fl">
            <i></i>
            <p>400-076-1116</p>
            <span>工作时间：9:00 — 17:30</span>
        </div>
        <div class="siteCon">
            <ul>
                <li>
                    <h5>四季星座网</h5>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=78" target="_blank">关于我们</a></p>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=79" target="_blank">联系我们</a></p>
                </li>
                <li>
                    <h5>代理商</h5>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=99" target="_blank">一键上传</a></p>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=106" target="_blank">一件代发</a></p>
                </li>
                <li>
                    <h5>供应商</h5>
                    <p><a href="http://www.571xz.com/helpCenter/queIndex.htm?cid=41" target="_blank">发布商品</a></p>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=90" target="_blank">账户安全</a></p>
                    <p><a href="http://www.571xz.com/seller/indexgglist.htm" target="_blank">广告投放</a></p>
                </li>
                <li>
                    <h5>帮助中心</h5>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=80" target="_blank">新手入门</a></p>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=97" target="_blank">成为代理</a></p>
                    <p><a href="http://www.571xz.com/helpCenter/queDetail.htm?id=81" target="_blank">成为供货商</a></p>
                </li>
            </ul>
        </div>
        <div class="ewm fr">
            <ul>
                <li>
                    <i class="gzh"></i>
                    <p>公众号</p>
                </li>
                <li>
                    <i class="cApp"></i>
                    <p>代理商APP</p>
                </li>
                <li>
                    <i class="bApp"></i>
                    <p>供货商APP</p>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="sideNavbar" id="sideNavbar"></div>
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">