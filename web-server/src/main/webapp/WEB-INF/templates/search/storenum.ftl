<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>档口搜索 - 四季星座网</title>
    
    <meta name="keywords" content="四季星座，四季星座网，男装货源，女装货源，男鞋货源，女鞋货源，杭州服装批发，四季青服饰，淘宝货源，网店货源，服饰批发，代发平台！">
    
    <meta name="description" content="四季星座网是最专业的网店货源分销平台，提供一键上传、一键代发等服务，找货源就上www.571xz.com！">
    
    <link href="http://style.571xz.com/searchV5/css/storenum.css?t=1507859797182" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/searchV5/js/storenum.js?t=1507859797182"></script>
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
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
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
                    
                    
                    
                    
                    
                    <li type="goods" >商品</li>
                    <li type="store" class="select">档口</li>
                    
                </ul>
                <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
                <a href="${main_host!}picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
                </#if>
            </div>
            <div class="searchBox">
                
                <form id="formSearch" action="http://www.571xz.com/storenum.htm?webSite=${webSite!}" >
                    <input class="searchWeb" type=hidden name="webSite" value="${webSite!}">
                    
                    
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
                    <li><a href="http://${webSite!}.571xz.com/market.htm?mid=43">逛市场</a></li>
                <#elseif webSite == 'ss'>
                    <li><a href="http://${webSite!}.571xz.com/market.htm?mid=62">逛市场</a></li>
                <#elseif webSite == 'bj'>
                    <li><a href="http://bj.571xz.com/huoyuan/index.html">逛市场</a></li>
                <#elseif webSite == 'gz'>
                    <li><a href="http://gz.571xz.com/huoyuan/index.html">逛市场</a></li>
                <#else>
                    <li><a href="http://${webSite!}.571xz.com/market.htm">逛市场</a></li>
                </#if>
                <li ><a href="http://so.571xz.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
                <#if webSite =="hz" || webSite == 'cs'>
                <li ><a href="http://so.571xz.com/newgoods.htm?webSite=${webSite!}" target="_blank">今日新品</a></li>
                <#if webSite == "hz">
                <li><a href="http://www.571xz.com/shopRanking.htm" target="_blank">排行榜<i class="hot"></i></a></li>
                </#if>
                <li><a href="/daifaIndex.htm" target="_blank">一件代发</a></li>
                <#if webSite == "hz">
                <li><a href="http://www.571xz.com/shopIconCopyright.htm">知识产权</a></li>
                </#if>
                <li><a href="http://zixun.571xz.com/index" target="_blank">资讯</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<#assign text>{    "fields":[        {"name":'keyword', "value":"${query.keyword!}"},        {"name":'mid', "value":"${query.mid!}"},        {"name":'webSite', "value":"${query.webSite!}"}    ]}</#assign>
<#assign $it=text?eval />
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
<div class="layout">
    
    <div class="categoryFilterBar">
        
        
        
        
        
        <#if cates??>
        <div class="cates clearfix innerbox">
            <ul>
                <li <#if query.pid?? || query.cid??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a></li>
                <#list cates as cate>
                <li <#if query.pid?? && query.pid == cate.id || query.cid?? && query.cid == cate.id >class="selected"</#if>>
                    
                    
                    <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if>&pid=${cate.id!}<#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${cate.text!}</a>
                    
                
                </li>
                </#list>
            </ul>
        </div>
        </#if>
        
        <#if markets??>
        <div class="markets clearfix innerbox">
            <label>按市场：</label>
            <ul>
                
                <li <#if query.mid??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">全部</a></li>
                
                <#list markets as market>
                <li <#if query.mid?? && query.mid == market.id>class="selected"</#if>><a href="?webSite=${query.webSite!}&mid=${market.id!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">${market.text!}</a></li>
                </#list>
            </ul>
        </div>
        </#if>
        
        <#if styles??>
        <div class="styles clearfix innerbox">
            <label>按风格：</label>
            <ul>
                
                <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">全部</a></li>
                
                <#list styles as style>
                <li <#if query.keyword?? && query.keyword == style.keyword>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${style.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">${style.text!}</a></li>
                </#list>
            </ul>
        </div>
        </#if>
        
        <#if elements??>
        <div class="elements clearfix innerbox">
            <label>按元素：</label>
            <ul>
                
                <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">全部</a></li>
                
                <#list elements as element>
                <li <#if query.keyword?? && query.keyword == element.keyword>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${element.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">${element.text!}</a></li>
                </#list>
            </ul>
        </div>
        </#if>
        
    </div>
    
    
    <#if (storelist?size) gt 0>
    <div class="storelist">
        <#list storelist as store>
        <div class="storeitem">
            <a class="storeImgBox" href="shop.htm?id=${store.id!}">
                <img src="${store.imgsrc!}">
            </a>
            <div class="storeInfoBox">
                <div class="p1">
                    <a class="title" href="http://${webSite!}.571xz.com/shop.htm?id=${store.id!}" title="${store.marketName!} ${store.name!}"><em class="marketName">${store.highMarketName!}</em><em class="storeName">${store.highName!}</em></a>
                    <span class="xy">
    <#assign text>{"num":${store.xy!}}</#assign>
<#assign $it=text?eval />

                        <em class="shopLevel">
                        <#if $it.num lt 11>
                            <i class="star1"></i>
                        <#elseif $it.num lt 41>
                            <i class="star1"></i>
                            <i class="star1"></i>
                        <#elseif $it.num lt 91>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                        <#elseif $it.num lt 151>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                        <#elseif $it.num lt 251>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                            <i class="star1"></i>
                        <#elseif $it.num lt 501>
                            <i class="star2"></i>
                        <#elseif $it.num lt 1001>
                            <i class="star2"></i>
                            <i class="star2"></i>
                        <#elseif $it.num lt 2001>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                        <#elseif $it.num lt 5001>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                        <#elseif $it.num lt 10001>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                            <i class="star2"></i>
                        <#elseif $it.num lt 20001>
                            <i class="star3"></i>
                        <#elseif $it.num lt 50001>
                            <i class="star3"></i>
                            <i class="star3"></i>
                        <#elseif $it.num lt 100001>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                        <#elseif $it.num lt 200001>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                        <#elseif $it.num lt 500001>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                            <i class="star3"></i>
                        <#elseif $it.num lt 1000001>
                            <i class="star4"></i>
                        <#elseif $it.num lt 2000001>
                            <i class="star4"></i>
                            <i class="star4"></i>
                        <#elseif $it.num lt 5000001>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                        <#elseif $it.num lt 10000001>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                        <#elseif $it.num gt 10000000>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                            <i class="star4"></i>
                        </#if>
                        </em>
                    </span>
                    <span class="imbox">
    <#assign text>{"id":"${store.aliww!}"}</#assign>
<#assign $it=text?eval />
                    <a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
    <#assign text>{"id":"${store.imqq!}"}</#assign>
<#assign $it=text?eval />
                    <#if $it.id != "">
                        <a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
                        </#if>
                    </span>
                </div>
                <div class="p2">
                    <p>主营：${store.mainCate!}</p>
                    <p>市场：${store.fullMarketText!}</p>
                    <p>电话：${store.tel!}</p>
                </div>
                <div class="p3">
                    共<em>${store.goodsCount!}</em>件商品
                </div>
            </div>
            <div class="storeGoodslistBox">
                <#list store.goodslist as goods>
                <div class="goodsitem">
                    <a class="imgbox" href="http://${webSite!}.571xz.com/item.htm?id=${goods.id!}">
                        
                        <img class="img" src="${goods.imgsrc!}_220x220.jpg">
                    </a>
                    <p>&yen;${goods.piprice!}</p>
                </div>
                </#list>
            </div>
        </div>
        </#list>
    </div>
        <div class="jq_pagination" data-option="${pageOption!}"></div>
    <#else>
    <div class="goodslistEmptyCon">
        <p>Sorry, 未查询到相应档口~</p>
    </div>
    
    </#if>
    
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
<#include "/common/cnzz.ftl">
</body>
</html>