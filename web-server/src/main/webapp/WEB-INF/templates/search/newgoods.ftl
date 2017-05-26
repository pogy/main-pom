<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>今日新品 - 四季星座网</title>
    
    <meta name="keywords" content="四季星座，四季星座网，男装货源，女装货源，男鞋货源，女鞋货源，杭州服装批发，四季青服饰，淘宝货源，网店货源，服饰批发，代发平台！">
    
    <meta name="description" content="四季星座网是最专业的网店货源分销平台，提供一键上传、一键代发等服务，找货源就上www.571xz.com！">
    
    <link href="http://style.571xz.com/searchV5/css/newgoods.css?t=1495516579985" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/searchV5/js/newgoods.js?t=1495516579985"></script>
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
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
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
                    <a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a>

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
<div class="headerV1">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/xz/css/img/mtLogo.png" alt width=168 height=30 />
            </a>
            <em></em>
        </div>
        <div class="search">
            <div class="tabList clearfix">
                <ul>
                    
                    
                    
                    
                    
                    <li type="goods" class="select">商品</li>
                    <li type="store" >档口</li>
                    
                </ul>
                <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
                <a href="${main_host!}picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
                </#if>
            </div>
            <div class="searchBox">
                
                <form id="formSearch" action="http://so.571xz.com/${webSite!}search.htm" >
                
                    
                    
                    <input type="text" class="searchCon" name="keyword" placeholder="输入商品名称" value="<#if query.keyword??>${query.keyword!}</#if>">
                    <button class="searchBtn">搜索</button>
                </form>
            </div>
        </div>
        <script>/*============ xz/page#search BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/page#search END ============*/


</script>
    </div>
</div>
<div class="nav">
    <div class="layout navCon">
        <div class="navList">
            <ul>
                <li class="first"><a href="http://${webSite!}.571xz.com" target="_blank">首页</a></li>
                <#if webSite == 'jx'>
                    <li><a href="http://jx.571xz.com/market.htm?mid=33">逛市场</a></li>
                <#elseif webSite == 'wa'>
                    <li><a href="http://www.571xz.com/storelist.htm?webSite=wa">企业列表</a></li>
                <#elseif webSite == 'cs'>
                    <li><a href="http://jx.571xz.com/market.htm?mid=43">逛市场</a></li>
                <#else>
                <li><a href="http://${webSite!}.571xz.com/market.htm">逛市场</a></li>
                </#if>
                <li ><a href="http://so.571xz.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
                <#if webSite !="jx" && webSite != 'wa'>
                <li class="select"><a href="http://so.571xz.com/newgoods.htm?webSite=${webSite!}" target="_blank">今日新品</a></li>
                <#if webSite == "hz">
                <li ><a href="http://www.571xz.com/activity/redbull.htm" target="_blank">发现好货<i class="hot"></i></a></li>
                </#if>
                <li><a href="http://daifa.571xz.com/" target="_blank">一件代发</a></li>
                <li><a href="http://zixun.571xz.com/index" target="_blank">资讯</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<#assign text>{    "fields":[        {"name":'webSite', "value":"${query.webSite!}"},        {"name":'keyword', "value":"${query.keyword!}"},        {"name":'cid', "value":"${query.cid!}"}    ]}</#assign>
<#assign $it=text?eval />
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
<div class="bgbox">
<div class="layout">
    <div class="iconCateNav">
        <ul>
            <#list iconCateNav as cate>
            <li <#if cate.id?? && cate.id == query.cid>class="selected"</#if>>
                <a href="?cid=${cate.id!}&webSite=${webSite!}">
                    <i class="iconfont ${cate.name!}">&#xe${cate.icon!};</i>
                    <span>${cate.text!}</span>
                </a>
            </li>
            </#list>
        </ul>
    </div>
    <#if styleCateNavs?? && (styleCateNavs?size) gt 0>
    <div id="styleCateNav" class="styleCateNav clearfix">
        <em class="label">风格</em>
        <ul>
            
            <#list styleCateNavs as cate>
            <li><a href="?webSite=${webSite!}&keyword=${cate.keyword!}<#if query.cid??>&cid=${query.cid!}</#if>" <#if query.keyword == cate.keyword>class="selected"</#if>>${cate.text!}</a></li>
            </#list>
        </ul>
        <b class="show" jbtn="showHide">点击展开<i class="downRow"></i></b>
    </div>
    </#if>
    <#if (goodslist?size) gt 0>
    
    <div class="goodslistWindow clearfix">
         <#list goodslist as goods>
         <div class="goodsitem" data-goodsid="${goods.id!}">
            <a class="imgbox" href="http://${webSite!}.571xz.com/item.htm?id=${goods.id!}" target="_blank">
                
                <#if goods_index lt 20> 
                    <img class="img" src="${goods.imgsrc!}_300x300.jpg" data-original="${goods.imgsrc!}_300x300.jpg" data-original="${goods.imgsrc!}_300x300.jpg">
                <#else>
                    <img class="lazyload img" src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${goods.imgsrc!}_300x300.jpg">
                </#if>
                
            </a> 
            
            
            <div class="p1">
                <span class="pricebox">&yen; ${goods.piprice!}</span>
                <div class="upload">
                    <em><i class="iconUp"></i>一键上传</em>
                    <div class="list">
                        <ul>
                            <li><a href="http://upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                            <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                            <li><a href="#" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
                            <li><a href="javascript:;" xzclick="addGoodsData" data-goodsid="${goods.id!}"><em class="iconAdd"></em>加入数据包</a></li>
                        </ul>
                        <i class="i2"></i>
                        <i class="i1"></i>
                    </div>
                </div>
                
            </div>
            <p class="title"><a href="http://${webSite!}.571xz.com/item.htm?id=${goods.id!}" target="_blank">${goods.title!}</a></p>
            <div class="p3">
                <span class="storeName"><a href="http://${webSite!}.571xz.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
                
    <#assign text>{"id":"${goods.aliww!}"}</#assign>
<#assign $it=text?eval />
            <a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
                    <#if goods.postTimeText??><span class="viewCountBox">${goods.postTimeText!}</span></#if>
            </div>
        </div>
         </#list>
    </div>
    <script>/*============ searchV5/newgoods#goodslistWindow BEGIN ============*/

'${hacker!}';
$(function(){
    $(".goodsitem img.lazyload").lazyload({
        effect: "fadeIn",
        threshold: 400
    });
});

/*============ searchV5/newgoods#goodslistWindow END ============*/


</script>
    <div class="jq_pagination" data-option="${pageOption!}"></div>
    <#else>
    <div class="goodslistEmptyCon">
        <p>Sorry, 未查询到相应商品~</p>
    </div>
    
    </#if>
</div>
</div>
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
<#include "/common/cnzz.ftl">
</body>
</html>