<#assign $pageid="index">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>[四季星座网]泉州站-四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/qzIndex__index_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/qzIndex__index_js.ftl">
</head>
<body>
<script modulepath="qzIndex/common#forIps">
var hreflocation = window.location.href;
if(hreflocation.indexOf('http://www.571xz.com') == 0 || hreflocation.indexOf('http://571xz.com') == 0){//仅首页
    var province = '' ;
    var city = '' ;
    jQuery.getScript("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js",function(){
        province = remote_ip_info["province"];
        if(province == '福建'){
            window.location.href = "http://ss.571xz.com";
        }else if(province == '江苏'){
            window.location.href = "http://cs.571xz.com";
        }else if(province == '广东'){
            window.location.href = "http://gz.571xz.com";
        }else if(province == '吉林'){
            window.location.href = "http://wa.571xz.com";
        }else if(province == '泉州'){
            window.location.href = "http://qz.571xz.com";
        }
    }) ;
}
</script>
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
<#assign searchType="goods">
<#assign disabledIndexNav=false>
<#assign searchType="goods">
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
            <input type="text" class="searchCon fl" name="keyword" placeholder="<#if searchType == 'shop'>输入店铺名称<#else>输入商品名称</#if>" <#if $pageid == 'search' || $pageid == 'storenum'>value="${query.keyword!}"</#if> autofocus="autofocus">
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
        <#elseif webSite == 'qz'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="http://qz.571xz.com/market.htm?mid=82" target="_blank">
        逛市场
    </a>
</li>
<li
        <#if 'goods' == $pageid>class="actived"</#if>
>
    <a href="http://so.571xz.com/qzgoods.htm?pid=50011740" target="_blank">
        商品库
    </a>
</li>
<li
        <#if 'newgoods' == $pageid>class="actived"</#if>
>
    <a href="http://so.571xz.com/newgoods.htm?cid=2&amp;webSite=qz" target="_blank">
        今日新品
    </a>
</li>
<li
>
    <a href="http://zixun.571xz.com/index" target="_blank">
        资讯
    </a>
</li>
        </#if>
    </ul>
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
        <img class="userIcon" src="http://style.571xz.com/v6/qzIndex/css/img/touxiang.png">
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
<div class="intimeGoods layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="intimeGoods" data-text="周推"></a>
    <h3><span class="yahei">本周推荐</span>每周推荐 掌握潮流优款</h3>
</div>
    <div class="goodsList">
        <#list weekPushGoodsList as goods>
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
<div class="sideNavbar" id="sideNavbar"></div>
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">