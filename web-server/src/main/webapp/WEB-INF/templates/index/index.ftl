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
<#include "/__style_torrent__/index__index_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/index/plugins/ekoo.min.js"></script>
<script src="http://style.571xz.com/v6/index/plugins/jquery.cookie.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/index__index_js.ftl">
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
                <#if page?? && page.type == 'W'>
                <input type="hidden" name="cid" value="16">
                <#elseif page?? && page.type == 'M'>
                <input type="hidden" name="cid" value="30">
                </#if>
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
<div class="topGoatPic layout">
    <a href="<#if tp.href == ''>javascript:;<#else>${tp.href!}</#if>" target="_blank">
        <img src="${tp.imgsrc!}">
    </a>
</div>
</#list>
</#if>
<script modulepath="index/index#config">
var pageType = 'W'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<script modulepath="index/index#config">
var pageType = 'W'
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
    <h3 class="head none">
        <em>${page.typeText!}</em>
        <#if page.type == 'W'>
        <b xzclick="gotoManPage">点击切换男装</b>
        <#else>
        <b xzclick="gotoWomanPage">点击切换女装</b>
        </#if>
    </h3>
    <div class="listbox">
        <div class="list" data-menuid="manMarket">
            <h3 class="mtitle"><em>女装市场</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=4">星座女装</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=80">M21</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=6">好四季女装</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=7">意法服饰</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=15">中星外贸</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=13">四季青</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=19">其他市场</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="manCoat">
            <h3 class="mtitle"><em>女装上衣</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50000671">T恤</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162104">衬衫</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162116">蕾丝衫/雪纺衫</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50000697">针织衫</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="manPants">
            <h3 class="mtitle"><em>女装裤子/裙子</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162205">牛仔裤</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50010850">连衣裙</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=长裙">长裙</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="xbpsCate">
            <h3 class="mtitle"><em>鞋包配饰</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;keyword=休闲鞋">休闲鞋</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012027">低帮鞋</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012825">高帮鞋</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="styleCate">
            <h3 class="mtitle"><em>时尚风格</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=韩版">韩版</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=通勤">通勤</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=淑女">淑女</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=文艺">文艺</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="detailbox">
            <div class="innerbox w320c2 manMarket" data-width="w320c2">
                <div class="itemsbox">
                    <h4>女装市场</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=4" target="_blank">星座女装</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=80" target="_blank">M21</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=6" target="_blank">好四季女装</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=7" target="_blank">意法服饰</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=15" target="_blank">中星外贸</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=14" target="_blank">中纺服饰</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=13" target="_blank">四季青</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=19" target="_blank">其他市场</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 manCoat" data-width="w320c0">
                <div class="itemsbox">
                    <h4>女装上衣</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50000671" target="_blank">T恤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162104" target="_blank">衬衫</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162116" target="_blank">蕾丝衫/雪纺衫</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=121412004" target="_blank">背心/吊带</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162103" target="_blank">毛衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50000697" target="_blank">针织衫</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008898" target="_blank">卫衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50013196" target="_blank">马夹</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50013194" target="_blank">外套</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008897" target="_blank">西装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008901" target="_blank">风衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008904" target="_blank">皮衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008905" target="_blank">皮草</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50013194" target="_blank">毛呢外套</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008900" target="_blank">棉衣/棉服</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50008899" target="_blank">羽绒服</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 manPants" data-width="w320c0">
                <div class="itemsbox">
                    <h4>裙子</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=50010850" target="_blank">连衣裙</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=1623" target="_blank">半身裙</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=背带裙" target="_blank">背带裙</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=长裙" target="_blank">长裙</a></li>
                    </ul>
                </div>
                <div class="itemsbox">
                    <h4>裤子</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=短裤" target="_blank">短裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162205" target="_blank">牛仔裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=打底裤" target="_blank">打底裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;cid=162201" target="_blank">休闲裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=阔腿裤" target="_blank">阔腿裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=背带裤" target="_blank">背带裤</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 xbpsCate" data-width="w320c0">
                <div class="itemsbox">
                    <h4>女鞋</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;keyword=单鞋" target="_blank">单鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012032" target="_blank">凉鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012033" target="_blank">拖鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012042" target="_blank">帆布鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;keyword=高跟鞋" target="_blank">高跟鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012028" target="_blank">靴子</a></li>
                    </ul>
                </div>
                <div class="itemsbox">
                    <h4>包包</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;cid=121434005" target="_blank">钱包</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;cid=122690003" target="_blank">双肩包</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;keyword=单肩包" target="_blank">单肩包</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;keyword=手提包" target="_blank">手提包</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;keyword=斜挎包" target="_blank">斜挎包</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;keyword=手拿包" target="_blank">手拿包</a></li>
                    </ul>
                </div>
                <div class="itemsbox">
                    <h4>配饰</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;cid=50009032" target="_blank">皮带</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;keyword=领带" target="_blank">领带</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;cid=50007003" target="_blank">围巾/丝巾</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;cid=302910" target="_blank">帽子</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;cid=50010410" target="_blank">手套</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;keyword=眼镜" target="_blank">眼镜</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;keyword=手表" target="_blank">手表</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50010404&amp;keyword=袜子" target="_blank">袜子</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w240c2 styleCate" data-width="w240c2">
                <div class="itemsbox">
                    <h4>时尚风格</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=韩版" target="_blank">韩版</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=通勤" target="_blank">通勤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=淑女" target="_blank">淑女</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=文艺" target="_blank">文艺</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=气质" target="_blank">气质</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=欧美" target="_blank">欧美</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=英伦" target="_blank">英伦</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=日系" target="_blank">日系</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=港风" target="_blank">港风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=复古" target="_blank">复古</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=原创" target="_blank">原创</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=休闲" target="_blank">休闲</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=运动" target="_blank">运动</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=情侣" target="_blank">情侣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=大码" target="_blank">大码</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=性感" target="_blank">性感</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=甜美" target="_blank">甜美</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=简约" target="_blank">简约</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=学院" target="_blank">学院</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=街头" target="_blank">街头</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=小香风" target="_blank">小香风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=16&amp;keyword=波西米亚" target="_blank">波西米亚</a></li>
                    </ul>
                </div>
            </div>
    </div>
</div>
    </div>
    <div class="centerbox">
<div class="topBanner">
    <div class="slides" id="slides">
        <div class="ulDiv">
            <ul>
            <#list topBanner as item>
                <li><a href="${item.href!}" target="_blank"><img width="742" height="342" alt="" src="${item.imgsrc!}"></a></li>
            </#list>
            </ul>
        </div>
        <div class="small"><div class="small-lab"></div></div>
        <div class="j_next icon icon-rightarrow"></div>
        <div class="j_prev icon icon-leftarrow"></div>
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
<div class="topInfoBox">
    <div class="noticebox">
        <div class="tabBtn">
            <b class="btn1 selected">公告</b>
        </div>
        <div class="tabCon">
            <ul>
                <#list notices as item>
                <li><a href="${item.href!}" target="_blank">${item.text!}</a></li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="userbox">
        <div class="p1 clearfix">
            <div class="userIcon">
                <img src="http://style.571xz.com/v6/index/css/img/touxiang.png">
            </div>
            <div class="wellcom">
                <p class="s1" id="wellcomUserInfo">Hi，欢迎来到</p>
                <p>www.571xz.com</p>
            </div>
        </div>
        <div class="p2 clearfix" id="goBackstageButtonBox">
            <a class="first" href="/login.htm">登录</a>
            <a href="/regedit.htm">注册</a>
            <a href="/member/ruzhu.htm">商家入驻</a>
        </div>
    </div>
    <div class="userCount">
        <div class="p1">
            <ul class="clearfix">
                <#list userCount as num>
                <li>${num!}</li>
                </#list>
            </ul>
        </div>
        <div class="p2">
            服装采购商的选择
        </div>
    </div>
</div>
    </div>
</div>
<div class="hotsaleGoodslist goodslistBox layout">
<div class="goodslistTitleV1">
    <a class="sideNavbarDot" name="hotsaleGoods" data-text="热销"></a>
    <h3 class="fs20 fwb yahei">热销商品 <span class="fs12 fc9">爆款尖货 品质护航</span></h3>
</div>
<#list [{"goodslist":hotsaleGoodslist}] as $it>
<div class="goodslistBody clearfix">
    <ul class="clearfix">
            <#list $it.goodslist as item>
<li class="goodsItem1">
    <a class="imgBox" href="http://www.571xz.com/item.htm?id=${item.id!}" target="_blank">
        <img src="${item.imgsrc!}_300x300.jpg" width="230" height="230">
    </a>
    <div class="gsOtInfo">
        <span class="yahei fs14 fcF40">&yen;${item.piprice!}</span>
        <div class="storeNum" title="${item.storeText!}"><a href="http://www.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
    </div>
    <#if item.styleText?? && item.styleText != '' >
    <div class="tally">${item.styleText!}</div>
    </#if>
    <#if item.elementText?? && item.elementText != ''>
    <div class="tally">${item.elementText!}</div>
    </#if>
</li>
            </#list>
    </ul>
</div>
</#list>
</div>
<div class="styleGoodslist goodslistBox layout">
<div class="goodslistTitleV1">
    <a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
    <h3 class="fs20 fwb yahei">风格馆 <span class="fs12 fc9">各类风格  应有尽有</span></h3>
</div>
<#list [{"navs":styleCateList}] as $it>
<div class="goodslistNav clearfix">
    <#list $it.navs as nav>
    <div class="navItem"><a href="${nav.href!}" target="_blank">${nav.text!}</a></div>
    </#list>
</div>
</#list>
<#list [{"goodslist":styleGoodslist}] as $it>
<div class="goodslistBody clearfix">
    <ul class="clearfix">
            <#list $it.goodslist as item>
<li class="goodsItem1">
    <a class="imgBox" href="http://www.571xz.com/item.htm?id=${item.id!}" target="_blank">
        <img src="${item.imgsrc!}_300x300.jpg" width="230" height="230">
    </a>
    <div class="gsOtInfo">
        <span class="yahei fs14 fcF40">&yen;${item.piprice!}</span>
        <div class="storeNum" title="${item.storeText!}"><a href="http://www.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
    </div>
    <#if item.styleText?? && item.styleText != '' >
    <div class="tally">${item.styleText!}</div>
    </#if>
    <#if item.elementText?? && item.elementText != ''>
    <div class="tally">${item.elementText!}</div>
    </#if>
</li>
            </#list>
    </ul>
</div>
</#list>
</div>
<div class="elementGoodslist goodslistBox layout">
<div class="goodslistTitleV1">
    <a class="sideNavbarDot" name="elementGoods" data-text="流行"></a>
    <h3 class="fs20 fwb yahei">流行元素 <span class="fs12 fc9">潮流阵地 时尚前沿</span></h3>
</div>
<#list [{"navs":elementCateList}] as $it>
<div class="goodslistNav clearfix">
    <#list $it.navs as nav>
    <div class="navItem"><a href="${nav.href!}" target="_blank">${nav.text!}</a></div>
    </#list>
</div>
</#list>
<#list [{"goodslist":elementGoodslist}] as $it>
<div class="goodslistBody clearfix">
    <ul class="clearfix">
            <#list $it.goodslist as item>
<li class="goodsItem1">
    <a class="imgBox" href="http://www.571xz.com/item.htm?id=${item.id!}" target="_blank">
        <img src="${item.imgsrc!}_300x300.jpg" width="230" height="230">
    </a>
    <div class="gsOtInfo">
        <span class="yahei fs14 fcF40">&yen;${item.piprice!}</span>
        <div class="storeNum" title="${item.storeText!}"><a href="http://www.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
    </div>
    <#if item.styleText?? && item.styleText != '' >
    <div class="tally">${item.styleText!}</div>
    </#if>
    <#if item.elementText?? && item.elementText != ''>
    <div class="tally">${item.elementText!}</div>
    </#if>
</li>
            </#list>
    </ul>
</div>
</#list>
</div>
<div class="recommendShopList goodslistBox layout">
<div class="goodslistTitleV1">
    <a class="sideNavbarDot" name="recommendShop" data-text="推荐"></a>
    <h3 class="fs20 fwb yahei">推荐档口 <span class="fs12 fc9">实力档口 源头好货</span></h3>
</div>
<#list [{"goodslist":recommendShoplist}] as $it>
<div class="goodslistBody clearfix">
    <ul class="clearfix">
            <#list $it.goodslist as item>
<li class="goodsItem2">
    <a class="imgBox" href="http://www.571xz.com/item.htm?id=${item.id!}" target="_blank">
        <img src="${item.imgsrc!}_300x300.jpg" width="230" height="230">
    </a>
    <div class="gsOtInfo">
        <div class="inSell">
            <a href="http://www.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">
                <span class="s1">${item.marketText!}</span>
                <span class="s2">${item.storeNum!}</span>
            </a>
        </div>
        <div class="userText fs12 fc6 tac" title="${item.userText!}">${item.userText!}</div>
    </div>
</li>
            </#list>
    </ul>
</div>
</#list>
</div>
<div class="loveGoodslist goodslistBox layout">
<div class="goodslistTitleV2">
    <a class="sideNavbarDot" name="loveGoods" data-text="喜欢"></a>
    <h3 class="yahei fs20 tac"><i class="iconLove"></i>猜你喜欢</h3>
    <p class="title tac fc9">实时推荐 为你寻觅档口好货</p>
</div>
<#list [{"goodslist":loveGoodslist}] as $it>
<div class="goodslistBody clearfix">
    <#list $it.goodslist as pitem>
    <ul class="clearfix pr tle <#if pitem_index % 2 ==0>tleL<#else>tleR</#if>">
        <#if (pitem.items?size) gt 0>
            <#list pitem.items as item>
<li class="goodsItem1">
    <a class="imgBox" href="http://www.571xz.com/item.htm?id=${item.id!}" target="_blank">
        <img src="${item.imgsrc!}_300x300.jpg" width="230" height="230">
    </a>
    <div class="gsOtInfo">
        <span class="yahei fs14 fcF40">&yen;${item.piprice!}</span>
        <div class="storeNum" title="${item.storeText!}"><a href="http://www.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
    </div>
    <#if item.styleText?? && item.styleText != '' >
    <div class="tally">${item.styleText!}</div>
    </#if>
    <#if item.elementText?? && item.elementText != ''>
    <div class="tally">${item.elementText!}</div>
    </#if>
</li>
            </#list>
            <li class="loveCate">${pitem.typeText!}</li>
        </#if>
    </ul>
    </#list>
</div>
</#list>
</div>
<div class="sideNavbar" id="sideNavbar"></div>
<div class="serverIntro">
    <div class="layout serverCon">
        <ul>
            <li>
                <i class="iconServer manDp"></i>
                <p>15,000多家档口</p>
                <span>精选货源 一网打尽</span>
            </li>
            <li>
                <i class="iconServer manUp"></i>
                <p>1键轻松上传</p>
                <span>上传各大网购平台</span>
            </li>
            <li>
                <i class="iconServer manDf"></i>
                <p>1件商品代发</p>
                <span>0库存，0成本</span>
            </li>
            <li>
                <i class="iconServer manTh"></i>
                <p>无理由退换</p>
                <span>可支持无条件退换货</span>
            </li>
        </ul>
    </div>
</div>
<div class="siteInfo layout">
    <div class="logoInfo fl">
        <i></i>
        <p>400-076-1116</p>
        <span>工作时间：9:00 — 17:30</span>
    </div>
    <div class="siteCon">
        <ul>
            <li>
                <h5>四季星座网</h5>
                <p><a href="http://www.571xz.com/xzPage/about.htm" target="_blank">关于我们</a></p>
                <p><a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a></p>
            </li>
            <li>
                <h5>代理商</h5>
                <p><a href="http://zixun.571xz.com/article?id=45" target="_blank">一键上传</a></p>
                <p><a href="http://daifa.571xz.com" target="_blank">一件代发</a></p>
            </li>
            <li>
                <h5>供应商</h5>
                <p><a href="/ruzhu.htm" target="_blank">商家入驻</a></p>
                <p><a href="/seller/memberghs.htm" target="_blank">档口后台</a></p>
                <p><a href="http://wpa.qq.com/msgrd?v=3&amp;uin=653157838&amp;site=qq&amp;menu=yes" target="_blank">广告投放</a></p>
            </li>
            <li>
                <h5>帮助中心</h5>
                <p><a href="http://zixun.571xz.com/article?id=14" target="_blank">新手入门</a></p>
                <p><a href="http://zixun.571xz.com/article?id=71" target="_blank">成为代理</a></p>
                <p><a href="http://zixun.571xz.com/article?id=72" target="_blank">成为供货商</a></p>
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
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">