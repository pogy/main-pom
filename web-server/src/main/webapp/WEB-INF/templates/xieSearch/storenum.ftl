<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>档口搜索 - 看鞋网</title>
    
    <meta name="keywords" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <meta name="description" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <link href="http://style.571xz.com/xieSearch/css/storenum.css?t=1499308744437" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/xieSearch/js/storenum.js?t=1499308744437"></script>
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
                    
                    
                    
                    
                    
                    <li type="goods" >商品</li>
                    <li type="store" class="select">档口</li>
                    
                </ul>
            </div>
            <div class="searchBox">
                
                <form id="formSearch" action="http://www.kxie.com/storenum.htm?webSite=${webSite!}" >
                    <input class="searchWeb" type=hidden name="webSite" value="${webSite!}">
                    
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
    
    
    <#if (storelist?size) gt 0>
    <div class="storelist">
        <#list storelist as store>
        <div class="storeitem">
            <a class="storeImgBox" href="shop.htm?id=${store.id!}">
                <img src="${store.imgsrc!}">
            </a>
            <div class="storeInfoBox">
                <div class="p1">
                    <a class="title" href="http://www.kxie.com/shop.htm?id=${store.id!}" title="${store.marketName!} ${store.name!}"><em class="marketName">${store.highMarketName!}</em><em class="storeName">${store.highName!}</em></a>
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
                    <a class="imgbox" href="http://www.kxie.com/item.htm?id=${goods.id!}">
                        
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