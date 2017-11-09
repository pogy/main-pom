<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>逛市场 - 看鞋网</title>
    <meta name="keywords" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <meta name="description" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <link href="http://style.571xz.com/xieMarket/css/xieIndex.css?t=1499308737775" rel="stylesheet">
    
  </head>
<body>
<#include "/common/host_config.ftl">
<script>/*============ xieMarket/host_config#base BEGIN ============*/

'${test!}';
var main_host = 'http://www.kxie.com/';

/*============ xieMarket/host_config#base END ============*/


</script>
<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "kx">看鞋网</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://www.kxie.com" <#if webSite == "kx">class="select"</#if>>看鞋网</a></li>
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
                        <a href="${main_host!}carts.htm">
                            <i class="cgcatIcon"></i>
                            <span>购物车</span>
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
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    </#if>
                    
                <#else>
                    <li class="noDown">
                        <a href="${main_host!}carts.htm">
                            <i class="cgcatIcon"></i>
                            <span>购物车</span>
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
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
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
                                
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<script>/*============ xz/kxPage#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/kxPage#topbar END ============*/


</script>
<div class="header layout">
    <div class="logoLeft">
        <a href="http://www.kxie.com">
            <img src="http://style.571xz.com/xz/css/img/logo.png" alt width=150 height=48 />
        </a>
        <em>逛市场</em>
    </div>
    
    <div class="search">
        <div class="tabList clearfix">
            <ul>
                <li type="goods">商品</li>
                <li class="select" type="store">档口</li>
            </ul>
        </div>
        <div class="searchBox">
            <form id="formSearch" action="http://www.kxie.com/storenum.htm?webSite=${webSite!}">
                <input type="text" class="searchCon" name="keyword" placeholder="输入档口号进行查询">
                <input type=hidden name="webSite" value="${webSite!}">
                <button class="searchBtn">搜索</button>
            </form>
        </div>
    </div>
    
    <script>/*============ xieMarket/page#search BEGIN ============*/

var webSite = '${webSite!}';

/*============ xieMarket/page#search END ============*/


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
                <li><a href="http://www.kxie.com" target="_blank">首页</a></li>
                <li class="select"><a href="http://www.kxie.com/market.htm?mid=68">逛市场</a></li>
                <li><a href="http://www.kxie.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
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
        <h3 data-lm='${markets.title!}'>
            <span>${markets.title!}</span>
            <i></i>
        </h3>
        <ul class="storeList clearfix">
        <#list markets.stores as store>
            <li>
                <div class="bgfff"></div>
                <a href="shop.htm?id=${store.id!}" target="_blank">
                    <h5>${store.num!}<#if store.isNew == 1><i></i></#if></h5>
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
<script>/*============ xieMarket/xieIndex#marketList BEGIN ============*/

'${hack!}';
if(this.$wgt && $wgt.setBg){
    $wgt.setBg();
}

/*============ xieMarket/xieIndex#marketList END ============*/


</script><script>/*============ xieMarket/xieIndex#marketList BEGIN ============*/

'${hack!}';
var marketName = '${marketName!}';
if(this.$wgt){
    $wgt.reloadNavbar &&$wgt.reloadNavbar();
    $wgt.reloadFilterbar && $wgt.reloadFilterbar();
    $wgt.marketBar &&$wgt.marketBar();
}

/*============ xieMarket/xieIndex#marketList END ============*/


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
            <a href="http://www.kxie.com" target="_blank">看鞋网</a>
        </p>
        <!--#<p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>#-->
        <p class="jyga">
            <span>&copy; 2017-2017 kxie.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=17015635" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙ICP备17015635号 </a>
        </p>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
        <script src="http://style.571xz.com/xieMarket/js/jquery.pjax.js"></script>
        <script src="http://style.571xz.com/xieMarket/js/nprogress.js"></script>
<script src="http://style.571xz.com/xieMarket/js/xieIndex.js?t=1499308737775"></script>
<#include "/common/cnzz.ftl">
</body>
</html>