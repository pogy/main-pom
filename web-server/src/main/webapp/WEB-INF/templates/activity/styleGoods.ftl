<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>风格馆 - 四季星座网</title>
    
    <meta name="keywords" content="四季星座，四季星座网，男装货源，女装货源，男鞋货源，女鞋货源，杭州服装批发，四季青服饰，淘宝货源，网店货源，服饰批发，代发平台！">
    
    <meta name="description" content="四季星座网是最专业的网店货源分销平台，提供一键上传、一键代发等服务，找货源就上www.571xz.com！">
    
    <link href="//style.571xz.com/searchV5/css/styleGoods.css?t=1495450039503" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/searchV5/js/styleGoods.js?t=1495450039503"></script>
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
                        <li><a href="//hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="//cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="//ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="//bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="//gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="//wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                        <li><a href="//jx.571xz.com" <#if webSite == "jx">class="select"</#if>>濮院</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="//www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="//www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
                
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
                <li class="noDown"><a href="//wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a></li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                                <li><a href="//hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
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
            <a href="//${webSite!}.571xz.com">
                <img src="//style.571xz.com/xz/css/img/mtLogo.png" alt width=168 height=30 />
            </a>
            <em></em>
        </div>
        <div class="search">
            <div class="tabList clearfix">
                <ul>
                    
                    
                    
                    
                    
                    <li type="goods" class="select">商品</li>
                    <li type="store" >档口</li>
                    
                </ul>
                <#if webSite == 'hz'>
                <a href="${main_host!}picSearch.htm" class="picSearchBox" target="_blank">图搜</a>
                </#if>
            </div>
            <div class="searchBox">
                
                <form id="formSearch" action="//so.571xz.com/${webSite!}search.htm" >
                
                    
                    
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
<#assign text>{    "fields":[        {"name":'webSite', "value":"${query.webSite!}"},        {"name":'sid', "value":"${query.sid!}"},        {"name":'pid', "value":"${query.pid!}"},        {"name":'cid', "value":"${query.cid!}"},        {"name":'mid', "value":"${query.mid!}"},        {"name":'keyword', "value":"${query.keyword!}"},        {"name":'sort', "value":"${query.sort!}"},        {"name":'d', "value":"${query.d!}"},        {"name":'page', "value":${query.page!}},        {"name":'sp', "value":"${query.sp!}"},        {"name":'ep', "value":"${query.ep!}"}    ]}</#assign>
<#assign $it=text?eval />
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
<div class="nav">
    <div class="layout navCon">
        <div class="navList">
            <ul>
                <li class="first"><a href="//${webSite!}.571xz.com" target="_blank">首页</a></li>
                <#if webSite == 'jx'>
                    <li><a href="//jx.571xz.com/market.htm?mid=33">逛市场</a></li>
                <#elseif webSite == 'wa'>
                    <li><a href="//www.571xz.com/storelist.htm?webSite=wa">企业列表</a></li>
                <#elseif webSite == 'cs'>
                    <li><a href="//jx.571xz.com/market.htm?mid=43">逛市场</a></li>
                <#else>
                <li><a href="//${webSite!}.571xz.com/market.htm">逛市场</a></li>
                </#if>
                <li ><a href="//so.571xz.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
                <#if webSite !="jx" && webSite != 'wa'>
                <li ><a href="//so.571xz.com/newgoods.htm?webSite=${webSite!}" target="_blank">今日新品</a></li>
                <#if webSite == "hz">
                <li ><a href="//www.571xz.com/activity/redbull.htm" target="_blank">发现好货<i class="hot"></i></a></li>
                </#if>
                <li><a href="//daifa.571xz.com/" target="_blank">一件代发</a></li>
                <li><a href="//zixun.571xz.com/index" target="_blank">资讯</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<div class="picCateNav layout">
    
    
    
    
    <#list picCateNav.picCates as picCate>
    <div class="picCateItem<#if (query.sid && query.sid == picCate.id) || (!query.sid && cateIndex==0)> selected</#if>">
        <div class="cateBottom">
            <a class="" target="_blank"><img src="${picCate.imgsrc!}" alt="" /></a>
        </div>
        <div class="cateMiddle">
        </div>
        <a  class="cateTop" data-sid="${picCate.id!}"   href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if picCate.id??>&sid=${picCate.id!}</#if><#if picCate.keyword??>&keyword=${picCate.keyword!}<#if query.pid??>&pid=${query.pid!}</#if></#if>">
            <span class="cateTitle">${picCate.text!}</span>
            <span class="cateNum">共计商品${picCate.goodscount!}件</span>
        </a>
    </div>
    </#list>
    
    <div class="picMoreCate">
        <h3 class="title">更多风格</h3>
        <ul class="moreCateItems clearfix">
            
            
            
            <#list picCateNav.textCates as textCate>
                <#if textCate_index lt 20>
                <li  class="<#if query.sid?? && query.sid == textCate.id> selected</#if>"><a data-sid="${textCate.id!}" class="moreCateStyle" href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if textCate.id??>&sid=${textCate.id!}</#if><#if textCate.keyword??>&keyword=${textCate.keyword!}<#if query.pid??>&pid=${query.pid!}</#if></#if>">${textCate.text!}</a></li>
                </#if>
            </#list>
                
        </ul>
    </div>
</div>
<div class="textCateNav layout">
    
    <#if (textCateNav.cates?size) gt 0>
    <div class="goodsCategory classfiyStyle">
        <h3 class="title">商品分类</h3>
        <div class="bottomLine">
            <i></i>
            <i class="second"></i>
            <i></i>
        </div>
        <div class="goodsCateItem classfiyItem">
            <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.sid??>&sid=${query.sid!}</#if>"  class="<#if !query.cid>selected</#if>" >全部</a>
            <#list textCateNav.cates as item>
            <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if item.id??>&cid=${item.id!}</#if><#if item.keyword??>&keyword=${item.keyword!}<#if query.pid??>&pid=${query.pid!}</#if></#if><#if query.sid??>&sid=${query.sid!}</#if>"  class="<#if query.cid?? && query.cid == item.id>selected</#if>">${item.text!}</a>
            </#list>
        </div>
    </div>
    </#if>
    
    <#if (textCateNav.markets?size) gt 0>
    <div class="shopCategory classfiyStyle">
         <h3 class="title">市场分类</h3>
        <div class="bottomLine">
            <i></i>
            <i class="second"></i>
            <i></i>
        </div>
         <div class="shopCateItem classfiyItem">
             <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.pid??>&pid=${query.pid!}</#if>"  class="<#if !query.mid>selected</#if>" >全部</a>
            <#list textCateNav.markets as item>
            <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.sid??>&sid=${query.sid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if item.id??>&mid=${item.id!}</#if><#if item.keyword??>&keyword=${item.keyword!}<#if query.pid??>&pid=${query.pid!}</#if></#if>"  class="<#if query.mid?? && query.mid == item.id>selected</#if>" class="<#if query.mid?? && query.mid == item.id>selected</#if>">${item.text!}</a>
            </#list>
        </div>
    </div>
    </#if>
    
    <#if (textCateNav.styles?size) gt 0>
    <div class="lastestStyle classfiyStyle">
         <h3 class="title">最新风格</h3>
        <div class="bottomLine">
            <i></i>
            <i class="second"></i>
            <i></i>
        </div>
         <div class="lastestStyleItem classfiyItem">
           <#list textCateNav.styles as item>
            <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if item.id??>&sid=${item.id!}</#if><#if item.keyword??>&keyword=${item.keyword!}<#if query.pid??>&pid=${query.pid!}</#if></#if>"  class="<#if query.sid?? && query.sid == item.id> selected</#if>">${item.text!}</a>
            </#list>
        </div>
    </div>
    </#if>
    
    
    
</div>
<div class="goodsContent">
    <div class="layout before">
        <div class="cateName clearfix">
            <h3 class="">${styleTitle!}</h3>
            <span>${styleGoodsCount!}件商品</span>
        </div>
        <div class="formFilterBar clearfix" id="formFilterBar">
            <div class="sortTypeBox">
                <b jbtn="sortByXp" <#if query.sort?? && query.sort == 'xp'>class="selected"</#if>>新品</b>
                <b jbtn="sortByZh" <#if query.sort?? && query.sort == 'comp'>class="selected"</#if>>综合</b>
                
                
                
            </div>
            <div class="sortPriceBox<#if query.sort == 'price-asc' || query.sort == 'price-desc'> actived</#if>">
                
                <#if query.sort == 'price-desc'>
                <b class="initial">批发价从高到低<i class="imgicon16"></i></b>
                <div class="hoverBox">
                    <b class="selected">批发价从高到低</b>
                    <b jbtn="searchPriceAsc">批发价从低到高</b>
                </div>
                <#elseif query.sort == 'price-asc'>
                <b class="initial">批发价从低到高<i class="imgicon16"></i></b>
                <div class="hoverBox">
                    <b class="selected">批发价从低到高</b>
                    <b jbtn="searchPriceDesc">批发价从高到低</b>
                </div>
                <#else>
                <b class="initial">批发价<i class="imgicon16"></i></b>
                <div class="hoverBox">
                    <b jbtn="searchPriceAsc" class="first">批发价从低到高</b>
                    <b jbtn="searchPriceDesc">批发价从高到低</b>
                </div>
                </#if>
            </div>
            
            <div class="filterPriceBox">
                <div class="innerbox">
                    <input placeholder="&yen;" name="sp" value="${query.sp!}">-<input placeholder="&yen;" name="ep" value="${query.ep!}">
                    <b jbtn="searchPriceSE">确定</b>
                </div>
            </div>
            
            <div class="rtbox">
                <div class="sortTimeBox">
                    <div class="bg1"></div>
                    <b class="initial">
                        
                        <#if query.d??>
                            
                            <#if query.d == '1'>
                            1日内
                            <#elseif query.d == '7'>
                            1周内
                            <#elseif query.d == '30'>
                            1月内
                            <#elseif query.d == '90'>
                            3月内
                            <#elseif query.d == '180'>
                            6月内
                            <#elseif query.d == '365'>
                            1年内
                            
                            </#if>
                            
                        <#else>
                           全部时间
                        </#if>
                    <i class="imgicon16"></i></b>
                    <div class="hoverBox">
                         <div class="innerbox">
                             <b jbtn="searchTime" <#if !query.d> class="selected"</#if> d="">全部</b>
                            <b jbtn="searchTime" <#if query.d =="1"> class="selected"</#if> d="1">1日内</b>
                            <b jbtn="searchTime" <#if query.d =="7"> class="selected"</#if> d="7">1周内</b>
                            <b jbtn="searchTime" <#if query.d =="30"> class="selected"</#if> d="30">1月内</b>
                            <b jbtn="searchTime" <#if query.d =="90"> class="selected"</#if> d="90">3月内</b>
                            <b jbtn="searchTime" <#if query.d =="180"> class="selected"</#if> d="180">6月内</b>
                            <b jbtn="searchTime" <#if query.d =="365"> class="selected"</#if> d="365">1年内</b>
                        </div>
                        
                    </div>
                   
                </div>
                 <div class="defineTime">
        
                                <i class="cal"></i>
                                <input type="text" id="u_startTime" class="jq_datepicker" placeholder="请选择日期" readonly>
                                <input type="text" id="u_endTime" class="jq_datepicker" placeholder="请选择日期" readonly>
                                <button id="searchByUserTime">确定</button>
                    </div>
                
                    
                <div class="paginationBox">
        
                    <i jbtn="prevPage" class="iconfont prev<#if query.page == 1> disabled</#if>">&#xe61a;</i>
                    <span><em class="curPage">${query.page!}</em>/<em class="totalPage">${totalPage!}</em></span>
                    <i jbtn="nextPage" class="iconfont next<#if query.page == totalPage> disabled</#if>">&#xe61a;</i>
                </div>
                
            </div>
            
        </div>
        
        
        <div class="goodsList clearfix">
            <#if (goodslist?size) gt 0>
                <#list goodslist as goods>
                <div class="goodsItem">
                    <div class="goodsImg">
                        <a class="imgbox" href="//${webSite!}.571xz.com/item.htm?id=${goods.id!}">
                            <img class="img" src="${goods.imgsrc!}_300x300.jpg" data-original="${goods.imgsrc!}" alt="" target="_blank"/>
                            </a>
                        <span>&yen;${goods.piprice!}</span>
                    
                    </div>
                    <div class="goodsDesc before">
                        <a href="//${webSite!}.571xz.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}" class="shopName">
                            <span>${goods.fullStoreName!}</span>
                        </a>
                        <button class="uploadBtn">一键上传</button>
                        <div class="noHide">
                            <div class="hoverBox">
                           <ul class="keybox">
                                <li><a href="//upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><i class="ii"></i><span>上传到淘宝</span></a></li>
                                <li><a href="//1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><i class="ii"></i><span>上传到阿里</span></a></li>
                                <li class="wxContainer"><b xzclick="showGoodsWx" data-goodsid="${goods.id!}"><i class="ii"></i><span>分享朋友圈</span></b></li>
                                <li class="addData"><b  xzclick="addGoodsData" data-goodsid="${goods.id!}"><i class="ii"></i><span>加入数据包</span></b></li>
                
                            </ul>
                            <span class="angle"><em></em></span>
                        </div>
                        </div>
                       
                    </div>
                    <div class="wxEwmbox"></div>
                     
                </div>
                
                
                
                
                
                </#list> 
            <#else>
            <div class="goodslistEmptyCon">
                <p>Sorry, 未查询到相应商品~</p>
            </div>
            
            </#if>
            
        </div>
                <div class="jq_pagination" data-option="${pageOption!}"></div>
    </div>
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:650px;"> 
            <a href="/" target="_blank">首页</a>
            <a href="//hz.571xz.com" target="_blank">杭州站</a>
            <a href="//bj.571xz.com" target="_blank">北京站</a>
            <a href="//gz.571xz.com" target="_blank">广州站</a>
            <a href="//ss.571xz.com" target="_blank">石狮站</a>
            <a href="//cs.571xz.com" target="_blank">常熟站</a>
            <a href="//wa.571xz.com" target="_blank">辽源站</a>
            <a href="//zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="//style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">
</body>
</html>