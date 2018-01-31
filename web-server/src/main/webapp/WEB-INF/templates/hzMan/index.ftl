<#assign $pageid="index">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/hzMan__index_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/hzMan/plugins/ekoo.min.js"></script>
<script src="http://style.571xz.com/v6/hzMan/plugins/jquery.cookie.js"></script>
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
<#list [{}] as $it>
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
<#include "/common/xz__searchHeader.ftl">
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<#assign disabledIndexNav=true>
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<div class="sideNavbar" id="sideNavbar"></div>
<div class="firstScreenContent layout">
    <div class="leftbox">
<div class="catemenu" id="catemenu">
    <h3 class="head">
        <em>${page.typeText!}</em>
        <#if page.type == 'W'>
            <b xzclick="gotoManPage">点击切换男装</b>
        <#else>
            <b xzclick="gotoWomanPage">点击切换女装</b>
        </#if>
    </h3>
    <div class="listbox">
        <div class="list" data-menuid="manMarket">
            <h3 class="mtitle"><em>男装市场</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=1">电商基地</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=2">精品男装</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=3">四季星座</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=12">新杭派</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=8">置地国际</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=10">之江服饰</a></li>
                    <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=76">优品基地</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="manCoat">
            <h3 class="mtitle"><em>男装上衣</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011123">衬衫</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50000557">针织衫/毛衣</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010158">夹克</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010159">卫衣</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011165">棉衣</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="manPants">
            <h3 class="mtitle"><em>男装裤子</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=3035">休闲裤</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010167">牛仔裤</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动裤">运动裤</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="xbpsCate">
            <h3 class="mtitle"><em>鞋包配饰</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=休闲鞋">休闲鞋</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=皮鞋">皮鞋</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011743">靴子</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;cid=122654005">箱包</a></li>
                </ul>
            </div>
        </div>
        <div class="list" data-menuid="styleCate">
            <h3 class="mtitle"><em>时尚风格</em><i class="iconfont"></i></h3>
            <div class="mlist">
                <ul class="clearfix">
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=港风">港风</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=日系">日系</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=英伦">英伦</a></li>
                    <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=国潮">国潮</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="detailbox">
            <div class="innerbox w320c2 manMarket" data-width="w320c2">
                <div class="itemsbox">
                    <h4>男装市场</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=1" target="_blank">电商基地</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=2" target="_blank">精品男装</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=3" target="_blank">四季星座</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=5" target="_blank">钱塘大厦</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=12" target="_blank">新杭派</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=8" target="_blank">置地国际</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=10" target="_blank">之江服饰</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=18" target="_blank">男鞋基地</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=20" target="_blank">石狮工厂店</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=76" target="_blank">优品基地</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=16" target="_blank">原创男装</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=11" target="_blank">九天国际</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=9" target="_blank">潮牌基地</a></li>
                            <li><a href="http://${webSite!}.571xz.com/market.htm?mid=19" target="_blank">周边市场</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 manCoat" data-width="w320c0">
                <div class="itemsbox">
                    <h4>男装上衣</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011123" target="_blank">衬衫</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50000557" target="_blank">针织衫/毛衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=外套" target="_blank">外套</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011159" target="_blank">风衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011165" target="_blank">棉衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011167" target="_blank">羽绒服</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50025883" target="_blank">毛呢大衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011161" target="_blank">皮衣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=套装" target="_blank">套装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010160" target="_blank">西装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011130" target="_blank">西装套装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动套装" target="_blank">运动套装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=情侣装" target="_blank">情侣装</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011153" target="_blank">背心/马甲</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 manPants" data-width="w320c0">
                <div class="itemsbox">
                    <h4>男装裤子</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=3035" target="_blank">休闲裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010167" target="_blank">牛仔裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动裤" target="_blank">运动裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=西装裤" target="_blank">西装裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=工装裤" target="_blank">工装裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=阔腿裤" target="_blank">阔腿裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=哈伦裤" target="_blank">哈伦裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=小脚裤" target="_blank">小脚裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=卫裤" target="_blank">卫裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=长裤" target="_blank">长裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=九分裤" target="_blank">九分裤</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=七分裤" target="_blank">七分裤</a></li>
                    </ul>
                </div>
            </div>
            <div class="innerbox w320c0 xbpsCate" data-width="w320c0">
                <div class="itemsbox">
                    <h4>男鞋</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=运动鞋" target="_blank">运动鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=休闲鞋" target="_blank">休闲鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=雪地靴" target="_blank">雪地靴</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=棉鞋" target="_blank">棉鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=工装靴" target="_blank">工装靴</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=马丁靴" target="_blank">马丁靴</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012907" target="_blank">高帮鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=皮鞋" target="_blank">皮鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012906" target="_blank">低帮鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=平底板鞋" target="_blank">平底板鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011744" target="_blank">帆布鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=豆豆鞋" target="_blank">豆豆鞋</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011746" target="_blank">拖鞋</a></li>
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
            <div class="innerbox w320c0 styleCate" data-width="w320c0">
                <div class="itemsbox">
                    <h4>时尚风格</h4>
                    <ul class="itemlist clearfix">
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=店主" target="_blank">店主</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=休闲" target="_blank">休闲</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动" target="_blank">运动</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=情侣" target="_blank">情侣</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=大码" target="_blank">大码</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=北模" target="_blank">北模</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=街拍" target="_blank">街拍</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=摆拍" target="_blank">摆拍</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=港风" target="_blank">港风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=日系" target="_blank">日系</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=欧美" target="_blank">欧美</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=英伦" target="_blank">英伦</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=原宿" target="_blank">原宿</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=嘻哈" target="_blank">嘻哈</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=原创" target="_blank">原创</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=平铺" target="_blank">平铺</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=硬汉" target="_blank">硬汉</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=绅士" target="_blank">绅士</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=白墙风" target="_blank">白墙风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=超市风" target="_blank">超市风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=咖啡店风" target="_blank">咖啡店风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=中国风" target="_blank">中国风</a></li>
                            <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=国潮" target="_blank">国潮</a></li>
                    </ul>
                </div>
            </div>
    </div>
</div>
    </div>
    <div class="centerbox">
<ul class="nav yahei">
    <#if !disabledIndexNav>
    <li class="first"><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
    </#if>
    <#if webSite == 'hz'>
<li
        <#if 'market' == $pageid>class="actived"</#if>
>
    <a href="http://hz.571xz.com/market.htm" target="_blank">
        逛市场
        <i class="hot"></i>
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
        <i class="hot"></i>
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
<div class="topChoosePageType">
    <a class="wbtn" href="/" xzclick="gotoWomanPage">女装</a>
    <a class="mbtn" href="/" xzclick="gotoManPage">男装</a>
</div>
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
                <img src="http://style.571xz.com/v6/hzMan/css/img/touxiang.png">
            </div>
            <div class="wellcom">
                <p class="s1" id="wellcomUserInfo">Hi，欢迎来到</p>
                <p>www.571xz.com</p>
            </div>
        </div>
        <div class="p2 clearfix" id="goBackstageButtonBox">
            <a class="first" onclick="loginBack()">登录</a>
            <a href="${main_host!}regedit.htm">注册</a>
            <a href="${main_host!}ruzhu.htm">商家入驻</a>
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
<a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
<div class="styleChannel layout">
    <h2 class="fs20 yahei fc3">风格</h2>
    <div class="styleList yahei">
        <#list styleList as item>
            <div class="styleItem pr">
                <div class="line pa"></div>
                <h3 class="fc3"><a href="/styleIndex.htm?spid=${item.spid!}" target="_blank">${item.sname!}</a></h3>
                <p class="desc fc9">${item.desc!}</p>
                <ul>
                    <li><a href="/styleGoodsList.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>全部商品</li>
                    <li><a href="/styleMarket.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>市场列表</li>
                    <li><a href="/styleRecommd.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>推荐商品</li>
                </ul>
                <a href="/styleIndex.htm?spid=${item.spid!}" target="_blank"><img src="${item.imgsrc!}"></a>
            </div>
        </#list>
    </div>
</div>
<a class="sideNavbarDot" name="hotsaleGoods" data-text="热销"></a>
<div class="hotSaleGoods layout">
    <h3><span class="yahei">热卖商品</span>爆款尖货 品质护航</h3>
<div class="goodsList clearfix">
    <ul>
        <#list hotSaleGoodsList as goods>
            <li>
                <a class="imgBox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <img src="${goods.imgSrc!}_300x300.jpg">
                </a>
                <div class="goodsInfo">
                    <span class="fcF40 yahei fs14">&yen;${goods.piprice!}</span>
                    <a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" class="fr">${goods.market!} ${goods.shopNo!}</a>
                </div>
            </li>
        </#list>
    </ul>
</div>
</div>
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
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">