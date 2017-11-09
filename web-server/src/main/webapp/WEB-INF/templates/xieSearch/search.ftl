<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>搜索 - 看鞋网</title>
    
    <meta name="keywords" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <meta name="description" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <link href="http://style.571xz.com/xieSearch/css/search.css?t=1499308743516" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/xieSearch/js/search.js?t=1499308743516"></script>
  </head>
<body>
<#include "/common/host_config.ftl">
<script>/*============ xieSearch/host_config#base BEGIN ============*/

'${test!}';
var main_host = 'http://www.kxie.com/';

/*============ xieSearch/host_config#base END ============*/


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
<div class="headerV1">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://www.kxie.com">
                <img src="http://style.571xz.com/xz/css/img/logo.png" alt width=150 height=48 />
            </a>
            <em></em>
        </div>
        <div class="search">
            <div class="tabList clearfix">
                <ul>
                    
                    
                    
                    
                    
                    <li type="goods" class="select">商品</li>
                    <li type="store" >档口</li>
                    
                </ul>
            </div>
            <div class="searchBox">
                
                <form id="formSearch" action="http://www.kxie.com/${webSite!}search.htm" >
                    
                    <input type="text" class="searchCon" name="keyword" placeholder="输入商品名称" value="<#if query.keyword??>${query.keyword!}</#if>">
                    <button class="searchBtn">搜索</button>
                </form>
            </div>
        </div>
        
        <script>/*============ xieSearch/page#search BEGIN ============*/

var webSite = '${webSite!}';

/*============ xieSearch/page#search END ============*/


</script>
    </div>
</div>
<div class="nav">
    <div class="layout navCon">
        <div class="navList">
            <ul>
                <li class="first"><a href="http://www.kxie.com" target="_blank">首页</a></li>
                <li><a href="http://www.kxie.com/market.htm?mid=68">逛市场</a></li>
                <li ><a href="http://www.kxie.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
            </ul>
        </div>
    </div>
</div>
<#assign text>{    "fields":[        {"name":'webSite', "value":"${query.webSite!}"},        {"name":'pid', "value":"${query.pid!}"},        {"name":'mid', "value":"${query.mid!}"},        {"name":'keyword', "value":"${query.keyword!}"},        {"name":'sort', "value":"${query.sort!}"},        {"name":'d', "value":"${query.d!}"},        {"name":'page', "value":${query.page!}},        {"name":'sp', "value":"${query.sp!}"},        {"name":'ep', "value":"${query.ep!}"}    ]}</#assign>
<#assign $it=text?eval />
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
<div class="content layout">
    <div class="cttlfbox">
        <#if topShopList??>
        <div class="topShopList">
            <#list topShopList as shop>
            <div class="shopbox">
                <div class="r1">
                    <em>${shop.storeNum!}</em>
                </div>
                <div class="r2">
                    <p class="p1" title="${shop.marketName!} ${shop.storeNum!}">${shop.marketName!} ${shop.storeNum!}</p>
                    <p class="p2">主营类目：${shop.mainCate!}</p>
                    <p class="p2">宝贝件数：${shop.goodsCount!}件</p>
                </div>
                <div class="r3">
                    
                    <a class="a2" href="http://www.kxie.com/shop.htm?id=${shop.storeId!}" target="_blank">进入店铺</a>
                </div>
                <div class="r4">
                    <a href="${shop.otherStoreUrl!}" target="_blank">进入相关店铺</a>
                </div>
            </div>
            </#list>
        </div>
        </#if>
        <div class="categoryFilterBar">
            
            
            
            
            <div class="cateNav innerbox">
                <label>所有分类：</label>
                
                
                
                
                <div class="goodsCount"><#if query.keyword??> <span>> ${query.keyword!}</span></#if>为您提供<em>${goodsCount!}</em>件宝贝</div>
            </div>
            
            <#if cates??>
            <div class="cates clearfix innerbox">
                <label>按类目：</label>
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
                    
                    <li <#if query.mid??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a></li>
                    
                    <#list markets as market>
                    <li <#if query.mid?? && query.mid == market.id>class="selected"</#if>><a href="?webSite=${query.webSite!}&mid=${market.id!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${market.text!}</a></li>
                    </#list>
                </ul>
            </div>
            </#if>
            
            <#if styles??>
            <div class="styles clearfix innerbox">
                <label>按风格：</label>
                <ul>
                    
                    <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a></li>
                    
                    <#list styles as style>
                    <li <#if query.keyword?? && query.keyword == style.keyword>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${style.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${style.text!}</a></li>
                    </#list>
                </ul>
            </div>
            </#if>
            
            <#if elements??>
            <div class="elements clearfix innerbox">
                <label>按元素：</label>
                <ul>
                    
                    <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a></li>
                    
                    <#list elements as element>
                    <li <#if query.keyword?? && query.keyword == element.keyword>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${element.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${element.text!}</a></li>
                    </#list>
                </ul>
            </div>
            </#if>
            
        </div>
        
        <div class="formFilterBar clearfix" id="formFilterBar">
            <div class="sortTypeBox">
                <b jbtn="sortByZh" <#if query.sort?? && query.sort == 'comp'>class="selected"</#if>>综合</b>
                <b jbtn="sortByXp" <#if query.sort?? && query.sort == 'xp'>class="selected"</#if>>新品</b>
                <b jbtn="sortByRq" <#if query.sort?? && query.sort == 'popular'>class="selected"</#if>>人气</b>
                
                
                
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
        
        <#if (goodslist?size) gt 0>
        <div class="goodslistWindow clearfix">
             <#list goodslist as goods>
             <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="http://www.kxie.com/item.htm?id=${goods.id!}" target="_blank">
                    
                    <#if goods_index lt 20> 
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                    
                </a> 
                
                
                <p class="p1">
                    <span class="pricebox">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                    <#if goods.goodsNo?? && goods.goodsNo != "">
                    <p class="goodsNo"><a href="http://www.kxie.com/item.htm?id=${goods.id!}" target="_blank" title="${goods.goodsNo!}">货号：${goods.highLightGoodsNo!}</a></p>
                    <#else>
                    <p class="title"><a href="http://www.kxie.com/item.htm?id=${goods.id!}" target="_blank" title="${goods.title!}">${goods.highLightTitle!}</a></p>
                    </#if>
                <div class="p3">
                    <span class="storeName"><a href="http://www.kxie.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
                    
        <#assign text>{"id":"${goods.aliww!}"}</#assign>
<#assign $it=text?eval />
            <a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
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
            </div>
             </#list>
        </div>
        
        <script>/*============ xieSearch/page#goodslistWindow BEGIN ============*/

'${hacker!}';
$(function(){
    $(".goodsitem img.lazyload").lazyload({
        effect: "fadeIn",
        threshold: 400
    });
});

/*============ xieSearch/page#goodslistWindow END ============*/


</script>
        <div class="jq_pagination" data-option="${pageOption!}"></div>
        <#else>
        <div class="goodslistEmptyCon">
            <p>Sorry, 未查询到相应商品~</p>
        </div>
        
        </#if>
    </div>
    <div class="cttrtbox">
       <div class="tjGoodsBox">
           <h3><em>商品推荐</em><i></i></h3>
           <#if (tjGoodsList?size) gt 0>
           <ul>
               <#list tjGoodsList as goods>
               <li>
                   <a class="imgbox" href="http://www.kxie.com/item.htm?id=${goods.id!}" target="_blank">
                       
                       <img src="${goods.imgsrc!}_240x240.jpg"></a>
                   <p>
                       <em class="money">&yen;${goods.piprice!}</em>
                       <a class="storename" href="http://www.kxie.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
                   </p>
               </li>
               </#list>
           </ul>
           <#else>
           <p class="empty">暂无数据</p>
           </#if>
       </div>
    </div>
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
<#include "/common/cnzz.ftl">
</body>
</html>