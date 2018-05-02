<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>濮院站-四季星座网</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/otherIndex/css/py.css?t=1498441462645" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/otherIndex/js/py.js?t=1498441462645"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="inner">
        <div class="topbar-left">
            <span>Hi,</span> 
            欢迎来到四季星座网!
            <a class="login" href="http://www.571xz.com/login.htm" target="_blank">请登录</a>
            <a class="register" href="http://www.571xz.com/regedit.htm" target="_blank">免费注册</a>
        </div>
        <ul class="topbar-right clearfix">
            <li> 
                <div class="nav-name"><em>我是代理<i class="img-jiantou"></i></em></div>
                <div class="nav-list">
                    <a href="http://www.571xz.com/member/shiguOnekeyRecordinit.htm" target="_blank" rel="nofollow">已上传的商品</a>
                    <a href="http://www.571xz.com/carts.htm" target="_blank" rel="nofollow">我的购物车</a>
                </div>
            </li>
            
            
            <li>
                <div class="nav-name"><em><i class="iconfont iconsc">&#xe615;</i>收藏夹<i class="img-jiantou"></i></em></div>
                <div class="nav-list">
                    <a href="http://www.571xz.com/member/storeCollectinit.htm?index=0" target="_blank" rel="nofollow">我的收藏</a>
                    <a href="http://www.571xz.com/member/goodsCollectinit.htm?webSite=hz" target="_blank" rel="nofollow">我的数据包</a>
                </div>
            </li>
            <li> 
                <div class="nav-name"><a href="http://www.571xz.com/seller/memberghs.htm" target="_blank">档口中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="http://www.571xz.com/seller/releaseGoodsinit.htm" target="_blank" rel="nofollow">发布宝贝</a>
                    <a href="http://www.571xz.com/seller/storeGoodsListinit.htm" target="_blank" rel="nofollow">已发布的宝贝</a>
                </div>    
            </li>
            <li class="last">
                <div class="nav-name"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=4000761116"  target="_blank" >客服中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="http://www.571xz.com/contact.htm" target="_blank" rel="nofollow">在线客服</a>
                    <a href="http://zixun.571xz.com/detail?id=87" target="_blank" rel="nofollow">联系我们</a>
                    <a href="http://zixun.571xz.com/detail?id=14" target="_blank" rel="nofollow">新手入门</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<!--公用顶部条结束-->
<div class="fixtopbar">
    <div class="innner">
        <a class="logo" href="http://www.571xz.com/index.html"><img src="http://www.571xz.com/images/LOGO_3.png" title="四季星座网-首页" height="42" width="180"></a>
         <div class="searchbar">
            <div class="btnbox"><span>商品</span></div>
            <form action="http://so.571xz.com/jxsearch.htm" target="_blank" id="searchgo3">
                <input style="text-indent:1em;" class="text-search" name="keyword" type="text">
                <button class="btn-search">搜索</button>
            </form>
        </div>
        <div class="rightbox"> 
            <a href="http://www.571xz.com/seller/index.htm">进入代理商后台</a> 
        </div> 
    </div>
</div>
<script>/*============ otherIndex/page#fixtopbar BEGIN ============*/

/*====== 头部浮动工具条 ======*/
$(window).on('scroll',function(){
    $(window).scrollTop() > 180 ? $('.fixtopbar').fadeIn() : $('.fixtopbar').fadeOut();
});

$(function(){
var webSite = '{{pageid}}';
var typeToAction = {
    '宝贝': 'http://so.571xz.com/'+ webSite +'search.htm',
    '商品': 'http://so.571xz.com/'+ webSite +'search.htm',
    '货号': 'http://www.571xz.com/'+ webSite +'goodsNoSearch.htm',
    '档口': 'http://www.571xz.com/storenum.htm'
};

$('.fixtopbar .tabbox li').on('click', function(){
    var type = $(this).html();
    var first = $(this).parent().children().first();
    if(type == first.html())return;
    $(this).insertBefore(first);
    $('#searchgo3').attr('action', typeToAction[type]);
});
    
});

/*============ otherIndex/page#fixtopbar END ============*/


</script>
<div class="header layout">
    <a  class="logo" href="http://${webSite!}.571xz.com/" title="四季星座网-首页">四季星座网</a>
    <div class="changecity">
        <strong>濮院</strong>
        <div class="citylist">
            <span class="changebutton">切换城市<i class="img-jiantou"></i></span>
            <ul>
                        <li><a href="http://hz.571xz.com">杭州</a></li>
                        <li><a href="http://cs.571xz.com">常熟</a></li>
                        <li><a href="http://ss.571xz.com">石狮</a></li>
                        <li><a href="http://bj.571xz.com">北京</a></li>
                        <li><a href="http://gz.571xz.com">广州</a></li>
                        <li><a href="http://wa.571xz.com">辽源</a></li>
                        <li class="selected"><a href="http://jx.571xz.com">濮院</a></li>
            </ul>
        </div>
    </div>
    <div class="sobar clearfix">
        <ul class="tabs clearfix"> 
            <li class="so-goods selected">商品</li>
        </ul>
        
        <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
        <a href="${main_host!}picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
        </#if>
        <form class="so-form" action="http://so.571xz.com/jxsearch.htm" target="_blank">
            <input class="so-input" type="text" name="keyword" placeholder="输入产品名称"> <button class="so-go">搜索</button>
        </form>
    </div>
    <div class="downloadapp"> 
        <a href="http://www.571xz.com/static/NewDown/" target="_blank"><div>手机客户端</div><img width="80" height="80" alt="手机客户端二维码" src="http://style.571xz.com/otherIndex/css/img/appQrCode.png"></a> 
    </div>
</div>
<div class="topnav layout">
    <div class="fastnav">
        <i class="iconfont">&#xe616;</i>
        <span>快速导航</span>
    </div>
    <ul class="pagenav">
        
        <li><a href="http://${webSite!}.571xz.com/" target="_blank">首页</a></li> 
        <li><a href="http://jx.571xz.com/market.htm?mid=33" target="_blank">逛市场</a><i class="img-tjdk"></i></li> 
        <li><a href="http://so.571xz.com/jxgoods.htm" target="_blank">商品库</a></li> 
        
        
    </ul>
</div>
<div class="topcontent layout">
    <div class="fastnav-list">
        
        
        <div class="list">
        
            <h2><a href="http://so.571xz.com/huoyuan/index.html" target="_blank"><i class="iconfont">&#xe604;</i>市场列表</a></h2>
            <ul class="clearfix">
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=33">羊毛衫市场</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=42">中央商场</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=37">外贸区</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=34">时尚裤都</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=38">国贸大厦</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=40">世贸大厦</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=39">国际时装城</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=35">臭豆豆童贸</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=41">环贸中心</a></li>
                <li><a target="_blank" href="http://jx.571xz.com/market.htm?mid=36">交易中心</a></li>
            </ul>
        </div>
        
            <span class="splitline"></span>
            
        
        <div class="list j-list" data-id="j-manclo">
        
            <h2><a href="http://so.571xz.com/jxgoods.htm?pid=30" target="_blank"><i class="iconfont">&#xe605;</i>男装</a></h2>
            <ul class="clearfix">
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000436&amp;pid=30">T恤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011123&amp;pid=30">衬衫</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010159&amp;pid=30">卫衣</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010402&amp;pid=30">Polo衫</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011159&amp;pid=30">风衣</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=3035&amp;pid=30">休闲裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010167&amp;pid=30">牛仔裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=运动裤&amp;pid=30">运动裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=短裤&amp;pid=30">短裤</a></li>
            </ul>
        </div>
        
            <span class="splitline"></span>
            
        
        <div class="list j-list" data-id="j-womanclo">
        
            <h2><a href="http://so.571xz.com/jxgoods.htm?pid=16" target="_blank"><i class="iconfont">&#xe606;</i>女装</a></h2>
            <ul class="clearfix">
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000671&amp;pid=16">T恤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162104&amp;pid=16">衬衫</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=针织衫&amp;pid=16">针织衫</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008898&amp;pid=16">卫衣</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=背带裙&amp;pid=16">背带裙</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162205&amp;pid=16">牛仔裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010850&amp;pid=16">连衣裙</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=长裙&amp;pid=16">长裙</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=1629&amp;pid=16">大码女装</a></li>
            </ul>
        </div>
        
            <span class="splitline"></span>
            
        
        <div class="list j-list" data-id="j-pants">
        
            <h2><a href="javascript:;" target="_blank"><i class="iconfont">&#xe6ef</i>裤子</a></h2>
            <ul class="clearfix">
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=休闲裤">休闲裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=牛仔裤">牛仔裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=西裤">西裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=长裤">长裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=短裤">短裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=九分裤">九分裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=七分裤">七分裤</a></li>
                <li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=五分裤">五分裤</a></li>
            </ul>
        </div>
        
            
        
    </div>
    <!-- 快速导航详情-->
    <div class="fastnav-detail"  id="j-fastnav-detail">
        <div class="detail-box j-manclo">
        
            <ul class="box-cols3 clearfix"> <!-- 根据类目数量控制容器宽度 -->
<li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011123&amp;pid=30">衬衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010158&amp;pid=30">夹克</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000557&amp;pid=30">针织衫/毛衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010159&amp;pid=30">卫衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011127&amp;pid=30">皮裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50001748&amp;pid=30">民族服装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011129&amp;pid=30">西裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50005867&amp;pid=30">工装制服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011130&amp;pid=30">西服套装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=124730001&amp;pid=30">套装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011153&amp;pid=30">背心/马甲</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=3035&amp;pid=30">休闲裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50025884&amp;pid=30">羽绒裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50025885&amp;pid=30">棉裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000436&amp;pid=30">T恤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50025883&amp;pid=30">毛呢大衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011159&amp;pid=30">风衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011161&amp;pid=30">皮衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010402&amp;pid=30">Polo衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010160&amp;pid=30">西服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011165&amp;pid=30">棉衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010167&amp;pid=30">牛仔裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011167&amp;pid=30">羽绒服</a></li>            </ul>
        
        
<a class="channel" href="http://so.571xz.com/jxgoods.htm?pid=30">进入男装频道<i class="iconfont">&#xe676;</i></a>        </div>
        <div class="detail-box j-womanclo">
        
            <ul class="box-cols4 clearfix"> <!-- 根据类目数量控制容器宽度 -->
<li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50022566&amp;pid=16">西装裤/正装裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50010850&amp;pid=16">连衣裙</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011277&amp;pid=16">短外套</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162116&amp;pid=16">蕾丝衫/雪纺衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000697&amp;pid=16">毛针织衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162205&amp;pid=16">牛仔裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=121434004&amp;pid=16">抹胸</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162201&amp;pid=16">休闲裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50011404&amp;pid=16">婚纱/旗袍/礼服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50026651&amp;pid=16">棉裤/羽绒裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008906&amp;pid=16">唐装/民族服装/舞台服装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008904&amp;pid=16">皮衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008905&amp;pid=16">皮草</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008898&amp;pid=16">卫衣/绒衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008899&amp;pid=16">羽绒服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000852&amp;pid=16">中老年女装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=121412004&amp;pid=16">背心吊带</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008897&amp;pid=16">西装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008900&amp;pid=16">棉衣/棉服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50000671&amp;pid=16">T恤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50008901&amp;pid=16">风衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=1624&amp;pid=16">职业套装/学生校服/工作制服</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162103&amp;pid=16">毛衣</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=1629&amp;pid=16">大码女装</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50013194&amp;pid=16">毛呢外套</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50007068&amp;pid=16">打底裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162104&amp;pid=16">衬衫</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=162105&amp;pid=16">小背心/小吊带</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=1623&amp;pid=16">半身裙</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?cid=50013196&amp;pid=16">马夹</a></li>            </ul>
        
        
<a class="channel" href="http://so.571xz.com/jxgoods.htm?cid=16">进入女装频道<i class="iconfont">&#xe676;</i></a>        </div>
        <div class="detail-box j-pants">
        
            <ul class="box-cols2 clearfix"> <!-- 根据类目数量控制容器宽度 -->
<li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=休闲裤">休闲裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=牛仔裤">牛仔裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=西裤">西裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=长裤">长裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=短裤">短裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=九分裤">九分裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=七分裤">七分裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=五分裤">五分裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=打底裤">打底裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=正装裤">正装裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=棉裤">棉裤</a></li><li><a target="_blank" href="http://so.571xz.com/jxgoods.htm?keyword=羽绒裤">羽绒裤</a></li>            </ul>
        
        
        </div>
    </div>
    <div class="rightbox">
        <div class="slides" id="slides"> 
         <div class="ulDiv"> 
          <ul id="myLunb" style="position: relative;"> 
          <#list topBanner as item>
           <li><a rel="nofollow" target="_blank" href="${item.href!}"><img width="700" height="320" alt="" src="${item.imgsrc!}"></a></li>
           </#list>
          </ul> 
         </div>
         
            <div class="small"><div class="small-lab"></div></div> 
         
            <div class="j_next c_next iconfont">&#xe603;</div>
            <div class="j_prev c_prev iconfont">&#xe602;</div>
        </div>
        
        <div class="rightbar">
            <div class="notice">
                <h3>星座公告</h3>
                <ul> 
                    <#list notices as item>
                    <li><a title="${item.text!}" target="_blank" href="${item.href!}">${item.text!}</a></li> 
                    </#list>
                </ul>
            </div>
            <div class="rzbox"> 
                <a target="_blank" href="http://www.571xz.com/ruzhu.htm">供应商</a>
                <p>已入驻档口<span>${hasStore!}</span>家 </p> 
            </div>
            <div class="goodscount"> 
              <h3>商品总数</h3> 
              <span>${hasGoods!}</span> 
            </div>
        </div>
        
        <ul class="storewindow"> 
        <#list topStoread as item>
            <li><a rel="nofollow" target="_blank" href="${item.href!}"><img width="175" height="195" alt="" src="${item.imgsrc!}"></a></li>
        </#list>
        </ul>
    </div>
</div>
<div class="main-content">
    <div id="navbar" class="navbar"> 
        <ul class="nav">
                <li><a href="#0F"><i class="iconfont">&#xe610;</i><span>热卖</span></a></li> 
                <li><a href="#1F"><i class="iconfont">&#xe62d;</i><span>新品</span></a></li> 
                <li><a href="#2F"><i class="iconfont">&#xe60e;</i><span>男装</span></a></li> 
                <li><a href="#3F"><i class="iconfont">&#xe606</i><span>女装</span></a></li> 
                <li><a href="#4F"><i class="iconfont">&#xe6ef</i><span>裤子</span></a></li> 
        </ul> 
        <a class="linkqq" target="_blank" href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=4000761116"><i class="iconfont">&#xe60d;</i><span>客服</span></a>
    </div>
<#assign text>{        "type":'热卖商品',        "nF":'0F',        "goods":${hotgoods!}}</#assign>
<#assign $it=text?eval />
    <#if ($it.goods?size) gt 0 >
    <div class="goods-list layout goodslist-cols5">
        <h2 id="0F">热卖商品</h2> 
        <ul class="clearfix">
            <#list $it.goods as item>
            <li>
                <div> 
                    <a title="${item.title!}" target="_blank" class="picbox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}">
                        <img alt="${item.title!}" src="${item.imgsrc!}" original="${item.imgsrc!}">
                    </a> 
                    <p class="introduce">
                        <a target="_blank" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" title="批发价： ￥ ${item.piprice!}" class="fl">批发价：<i>￥</i><b>${item.piprice!}</b></a>
                        <a target="_blank" href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" title="${item.storeNum!}" class="fr"><b>${item.storeNum!}</b><i class="iconfont"></i></a> 
                    </p> 
                </div> 
            </li>
            </#list>
        </ul>
    </div>
    </#if>
    
<#assign text>{        "type":'最新商品',        "nF":'1F',        "goods":${list_newGoods!}}</#assign>
<#assign $it=text?eval />
    <#if ($it.goods?size) gt 0 >
    <div class="goods-list layout goodslist-cols5">
        <h2 id="1F">最新商品</h2> 
        <ul class="clearfix">
            <#list $it.goods as item>
            <li>
                <div> 
                    <a title="${item.title!}" target="_blank" class="picbox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}">
                        <img alt="${item.title!}" src="${item.imgsrc!}" original="${item.imgsrc!}">
                    </a> 
                    <p class="introduce">
                        <a target="_blank" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" title="批发价： ￥ ${item.piprice!}" class="fl">批发价：<i>￥</i><b>${item.piprice!}</b></a>
                        <a target="_blank" href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" title="${item.storeNum!}" class="fr"><b>${item.storeNum!}</b><i class="iconfont"></i></a> 
                    </p> 
                </div> 
            </li>
            </#list>
        </ul>
    </div>
    </#if>
    
<#assign text>{        "type":'男装',        "nF":'2F',        "goods":${nzgoods!}}</#assign>
<#assign $it=text?eval />
    <#if ($it.goods?size) gt 0 >
    <div class="goods-list layout goodslist-cols5">
        <h2 id="2F">男装</h2> 
        <ul class="clearfix">
            <#list $it.goods as item>
            <li>
                <div> 
                    <a title="${item.title!}" target="_blank" class="picbox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}">
                        <img alt="${item.title!}" src="${item.imgsrc!}" original="${item.imgsrc!}">
                    </a> 
                    <p class="introduce">
                        <a target="_blank" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" title="批发价： ￥ ${item.piprice!}" class="fl">批发价：<i>￥</i><b>${item.piprice!}</b></a>
                        <a target="_blank" href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" title="${item.storeNum!}" class="fr"><b>${item.storeNum!}</b><i class="iconfont"></i></a> 
                    </p> 
                </div> 
            </li>
            </#list>
        </ul>
    </div>
    </#if>
<#assign text>{        "type":'女装',        "nF":'3F',        "goods":${nvzgoods!}}</#assign>
<#assign $it=text?eval />
    <#if ($it.goods?size) gt 0 >
    <div class="goods-list layout goodslist-cols5">
        <h2 id="3F">女装</h2> 
        <ul class="clearfix">
            <#list $it.goods as item>
            <li>
                <div> 
                    <a title="${item.title!}" target="_blank" class="picbox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}">
                        <img alt="${item.title!}" src="${item.imgsrc!}" original="${item.imgsrc!}">
                    </a> 
                    <p class="introduce">
                        <a target="_blank" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" title="批发价： ￥ ${item.piprice!}" class="fl">批发价：<i>￥</i><b>${item.piprice!}</b></a>
                        <a target="_blank" href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" title="${item.storeNum!}" class="fr"><b>${item.storeNum!}</b><i class="iconfont"></i></a> 
                    </p> 
                </div> 
            </li>
            </#list>
        </ul>
    </div>
    </#if>
<#assign text>{        "type":'裤子',        "nF":'4F',        "goods":${pantgoods!}}</#assign>
<#assign $it=text?eval />
    <#if ($it.goods?size) gt 0 >
    <div class="goods-list layout goodslist-cols5">
        <h2 id="4F">裤子</h2> 
        <ul class="clearfix">
            <#list $it.goods as item>
            <li>
                <div> 
                    <a title="${item.title!}" target="_blank" class="picbox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}">
                        <img alt="${item.title!}" src="${item.imgsrc!}" original="${item.imgsrc!}">
                    </a> 
                    <p class="introduce">
                        <a target="_blank" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" title="批发价： ￥ ${item.piprice!}" class="fl">批发价：<i>￥</i><b>${item.piprice!}</b></a>
                        <a target="_blank" href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" title="${item.storeNum!}" class="fr"><b>${item.storeNum!}</b><i class="iconfont"></i></a> 
                    </p> 
                </div> 
            </li>
            </#list>
        </ul>
    </div>
    </#if>
    
    
    
    
</div>
<div class="footerinfo layout">
    <div class="four-bz">
        <ul class="clearfix"> 
            <li>
                <i class="iconfont">&#xe608;</i>
                <p>
                    <span>15,000家档口</span>
                    <em>一手货源</em>
                </p>
            </li> 
            <li>
                <i class="iconfont">&#xe600;</i>
                <p>
                    <span>1键上传</span>
                    <em>轻松开淘宝</em>
                </p>
            </li>
            <li>
                <i class="iconfont">&#xe60a;</i>
                <p>
                    <span>1件代发</span>
                    <em>0库存0成本</em>
                </p>
            </li>
            <li>
                <i class="iconfont">&#xe609;</i>
                <p>
                    <span>7天无理由</span>
                    <em>包退换0风险</em>
                </p>
            </li>
        </ul>
    </div>
    <div class="siteinfo">
        <div class="maps">
            <ul>
                <li><h4>四季星座网</h4></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=67">关于我们</a></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=87">联系我们</a></li>
            </ul>
            <ul>
                <li><h4>代理商</h4></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=45">一键上传</a></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=82">一件代发</a></li>
            </ul>
            <ul>
                <li><h4>供货商</h4></li>
                <li><a target="_blank" href="http://www.571xz.com//member/memberghs.htm">档口后台</a></li>
                <li><a target="_blank" href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝授权</a></li>
            </ul>
            <ul>
                <li><h4>帮助中心</h4></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=14">新手入门</a></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=71">如何成为代理商</a></li>
                <li><a target="_blank" href="http://zixun.571xz.com/detail?id=72">如何成为供货商</a></li>
            </ul>
        </div>
        <div class="ewm"> 
            <div class="wx_ewm"> 
              <h4>微信公众号</h4> 
              <img width="76" height="76" title="四季星座网微信微信公众号二维码" alt="四季星座网微信微信公众号二维码" src="http://www.571xz.com/images/foot_wx_2016.png"> 
            </div> 
            <div class="app_ewm">
                <h4>手机APP</h4>
                <img width="76" height="76" title="四季星座网手机app下载二维码" alt="四季星座网手机app下载二维码" src="http://style.571xz.com/otherIndex/css/img/appQrCode.png"> 
            </div> 
        </div>
        <div class="tel"> 
            <img width="200" height="120" title="四季星座网服务热线" alt="四季星座网服务热线" src="http://style.571xz.com/otherIndex/css/img/pyTel.png"> 
        </div>
    </div>
</div>
<!--#mobile-jump-js 移动端跳转js-->
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:650px;"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
        </p>
    </div>
</div>
<!--懒加载模块开始-->
<!--懒加载模块结束-->
</body>
</html>