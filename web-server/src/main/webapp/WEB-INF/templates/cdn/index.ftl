<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>逛市场 - 四季星座网</title>
    <meta name="keywords" content="四季星座网,四季星座论坛,杭州网店之家,网店代理货源,淘宝货源,男装货源,女装货源,一件代发,一键上传。">
    
    <meta name="description" content="发现好货-发现好货，每天实时推荐档口最新热卖商品！">
    
    <link href="http://style.571xz.com/marketV3/css/index.css?t=1507859528487" rel="stylesheet">
    
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源<#elseif webSite == "jx">濮院</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="http://cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="http://ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="http://bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="http://gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="http://wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                        <li><a href="http://jx.571xz.com" <#if webSite == "jx">class="select"</#if>>濮院</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="http://www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
                
            </div>
        </div>
        
        <div class="rightbox">
            <ul>
                <li class="noIndex">
                    <a href="${main_host!}" class="c_ff4400">四季星座网首页</a>
                </li>
                <#if session_user_redis__??>
                    <#if session_user_redis__.logshop??>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                            <div class="myStore cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                    <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    <#else>
                    <li class="noDown">
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
                            <em class="cgNum"></em>
                        </a>
                    </li>
                    <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                            <div class="myxz cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                            <div class="myColle cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    </#if>
                    
                <#else>
                    <li class="noDown">
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
                            <em class="cgNum"></em>
                        </a>
                    </li>
                    <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                            <div class="myxz cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                            <div class="myColle cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                            <div class="myStore cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                    <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                </#if>
                <li class="noDown">
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                    
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                                <li><a href="http://hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<script>/*============ xz/page#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/page#topbar END ============*/


</script>
<div class="header layout">
    <div class="logoLeft">
        <a href="http://${webSite!}.571xz.com">
            <img src="http://style.571xz.com/marketV3/css/img/mtLogo.png" alt width=168 height=30 />
        </a>
        <em>逛市场</em>
    </div>
    
    <div class="search">
        <div class="tabList clearfix">
            <ul>
                <li type="goods">商品</li>
                <li class="select" type="store">档口</li>
                
            </ul>
            <#if webSite == 'hz'>
            <a href="${main_host!}picSearch.htm" class="picSearchBox" target="_blank">图搜</a>
            </#if>
        </div>
        <div class="searchBox">
            <form id="formSearch" action="http://www.571xz.com/storenum.htm?webSite=${webSite!}">
                <input type="text" class="searchCon" name="keyword" placeholder="输入档口号进行查询">
                <input type=hidden name="webSite" value="${webSite!}">
                <button class="searchBtn">搜索</button>
            </form>
        </div>
    </div>
    
    <script>/*============ marketV3/page#search BEGIN ============*/

var webSite = '${webSite!}';

/*============ marketV3/page#search END ============*/


</script>
</div>
<div class="nav">
    <div class="layout navCon">
        <div class="cateGory">
            <div class="cateFication">全部商品分类</div>
            <div class="cateCon">
                <ul>
                    
                </ul>
            </div>
        </div>
        <div class="navList">
            <ul>
                <li><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
                <#if webSite == 'jx'>
                <li class="select"><a href="http://${webSite!}.571xz.com/market.htm?mid=33">逛市场</a></li> 
                <#elseif webSite == 'cs'>
                <li class="select"><a href="http://${webSite!}.571xz.com/market.htm?mid=43">逛市场</a></li>
                <#elseif webSite == 'ss'>
                <li class="select"><a href="http://${webSite!}.571xz.com/market.htm?mid=62">逛市场</a></li>
                <#else>
                <li class="select"><a href="http://${webSite!}.571xz.com/market.htm">逛市场</a></li>
                </#if>
                <li><a href="http://so.571xz.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
                <#if webSite =="hz" || webSite == 'cs'>
                <li><a href="http://so.571xz.com/newgoods.htm?webSite=${webSite!}" target="_blank">今日新品</a></li>
                <#if webSite == 'hz'>
                <li><a href="http://www.571xz.com/shopRanking.htm" target="_blank">排行榜<i class="hot"></i></a></li>
                </#if>
                <li><a href="/daifaIndex.htm" target="_blank">一件代发</a></li>
                <#if webSite == 'hz'>
                <li><a href="http://www.571xz.com/shopIconCopyright.htm" target="_blank">知识产权</a></li>
                </#if>
                <li><a href="http://zixun.571xz.com/index" target="_blank">资讯</a></li>
                </#if>
            </ul>
        </div>
        <div class="storeIn">
            <i class="iconfont">&#xe644;</i>
            <a href="${main_host!}ruzhu.htm">商家入驻</a>
        </div>
    </div>
</div>
<div id="pjaxContainer">
<div id="filterbarWrapper" class="useFixed_2">
    <div class="filterbar clearfix" id="filterbar">
        <div class="layout">
            <div class="innerbox markets">
                <div class="ctnbox">
                    <label><i class="iconfont marketIcon"></i>市场：</label>
                    <ul>
                        <#list markets as market>
                            <li <#if market.id == marketId>class="selected"</#if>><a href="?mid=${market.id!}">${market.name!}</a></li>
                        </#list>
                    </ul>
                    <i class="iconfont showmore">&#xe60b;</i>
                </div>
            </div>
            <div class="innerbox splitline"></div>
            <div class="innerbox cates">
                <div class="ctnbox">
                    <label><i class="iconfont mainDoi"></i>主营：</label>
                    <ul>
                        
                        <li <#if !cateId>class="selected"</#if>><a href="?mid=${marketId!}">全部</a></li>
                        <#list cates as cate>
                            <li <#if cate.id == cateId>class="selected"</#if>><a href="?mid=${marketId!}&cid=${cate.id!}">${cate.name!}</a></li>
                        </#list>
                    </ul>
                    <i class="iconfont showmore">&#xe60b;</i>
                </div>
            </div>
            
        </div>
    </div>
</div>
<div class="marketList layout">
    <#list marketList as markets>
        <#if marketId == '5'>
            <#if markets.title == '8F'>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!} 石狮工厂店</span>
                <i></i>
            </h3>
            <#elseif markets.title == '9F'>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!} 牛仔城</span>
                <i></i>
            </h3>
            <#else>
            <h3 data-lm='${markets.title!}'>
                <span>${markets.title!}</span>
                <i></i>
            </h3>
            </#if>
        
        <#else>
        <h3 data-lm='${markets.title!}'>
            <span>${markets.title!}</span>
            <i></i>
        </h3>
        </#if>
        <ul class="storeList clearfix">
        <#list markets.stores as store>
            <li>
                <div class="bgfff"></div>
                <a href="shop.htm?id=${store.id!}" target="_blank">
                    <h5><#if store.isfdGoods?? && store.isfdGoods == 1><span class="isfdGoods"></span></#if>${store.num!}<#if store.isNew == 1><i></i></#if></h5>
                    <em>${store.cate!}</em>
                    <p>
                        <#list store.tags as tag>
                        <#if tag == 1>
                        <i class="tui"></i>
                        </#if>
                        <#if tag == 2>
                        <i class="huan"></i>
                        </#if>
                        <#if tag == 3>
                        <i class="dai"></i>
                        </#if>
                        </#list>
                    </p>
                </a>
            </li> 
        </#list>
        </ul>
    </#list>
</div>
<script>/*============ marketV3/index#marketList BEGIN ============*/

'${hack!}';
if(this.$wgt && $wgt.setBg){
    $wgt.setBg();
}

/*============ marketV3/index#marketList END ============*/


</script><script>/*============ marketV3/index#marketList BEGIN ============*/

'${hack!}';
var marketName = '${marketName!}';
if(this.$wgt){
    $wgt.reloadNavbar &&$wgt.reloadNavbar();
    $wgt.reloadFilterbar && $wgt.reloadFilterbar();
    $wgt.marketBar &&$wgt.marketBar();
}

/*============ marketV3/index#marketList END ============*/


</script>
</div>
<div id="navbar" class="navbar init">
    <h3>${marketName!}</h3>
    <ul>
        
        
    </ul>
    <b><i class="iconfont upArrow"></i>顶部</b>
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:656px;"> 
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
<script src="http://style.571xz.com/global/js/jquery.js"></script>
        <script src="http://style.571xz.com/marketV3/js/jquery.pjax.js"></script>
        <script src="http://style.571xz.com/marketV3/js/nprogress.js"></script>
<script src="http://style.571xz.com/marketV3/js/index.js?t=1507859528487"></script>
<#include "/common/cnzz.ftl">
</body>
</html>