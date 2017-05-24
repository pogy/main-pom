<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>发现好货 - 四季星座网</title>
    
    <meta name="keywords" content="四季星座网,四季星座论坛,四季星座,服装批发市场,男装批发,女装批发,一件代发,一键上传,网店货源,淘宝货源,男装货源,女装货源,服装货源,服装进货渠道。">
    
    <meta name="description" content="四季星座网拥有丰富的线下服装批发进货渠道，四季星座、置地国际、电商基地、钱塘大厦、保太和、星座女装、新杭派、九天女装、意法服饰等杭州四季青实体批发市场都已入驻，实体批发档口高达15000多家，为全国淘宝网店代理商提供一手货源。同时支持一件代发，一键上传到淘宝、到阿里、到微信，数据包下载，无理由退换货服务。">
    
    <link href="http://style.571xz.com/searchV5/css/newStyleHd.css?t=1495420443427" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/searchV5/js/newStyleHd.js?t=1495420443427"></script>
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
                <li class="noDown"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a></li>
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
            <a href="<#if webSite == 'jx'>http://jx.571xz.com<#else>${main_host!}</#if>">
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
                <#if webSite == 'hz'>
                <a href="${main_host!}picSearch.htm" class="picSearchBox" target="_blank">图搜</a>
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
                <#if webSite == 'jx'>
                <li class="first"><a href="http://jx.571xz.com" target="_blank">首页</a></li>
                <#else>
                <li class="first"><a href="${main_host!}" target="_blank">首页</a></li>
                </#if>
                <#if webSite == 'jx'>
                    <li><a href="http://jx.571xz.com/market.htm?mid=33">逛市场</a></li>
                    <#elseif webSite == 'wa'>
                    <li><a href="http://www.571xz.com/storelist.htm?webSite=wa">企业列表</a></li>
                    <#else>
                    <li><a href="http://${webSite!}.571xz.com/market.htm">逛市场</a></li>
                </#if>
                <li ><a href="http://so.571xz.com/${webSite!}goods.htm" target="_blank">商品库</a></li>
                <#if webSite !="jx" || webSite != 'wa'>
                <li ><a href="http://so.571xz.com/newgoods.htm" target="_blank">今日新品</a></li>
                <#if webSite == "hz">
                <li class="select"><a href="http://www.571xz.com/activity/redbull.htm" target="_blank">发现好货<i class="hot"></i></a></li>
                </#if>
                <li><a href="http://daifa.571xz.com/" target="_blank">一件代发</a></li>
                <li><a href="http://zixun.571xz.com/index" target="_blank">资讯</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<div class="fdCon">
    <div class="slider">
        <div class="flexslider">
          <ul class="slides">
            <li>
              <img src="http://style.571xz.com/searchV5/css/img/styleHd/banner1.jpg" />
              </li>
              
          </ul>
        </div>
    </div>

    <div class="awardUser layout">
        <h3>获奖名单<span class="abortDate">（截止xx月xx日）</span>:</h3>
        <div class="userName">
            <ul>
                <#list awardList as user>
                <li>
                    <img src='http://wwc.taobaocdn.com/avatar/getAvatar.do?userNick=${user.userNick!}&width=80&height=80&type=sns' alt />
                    <span>${user.hideUserNick!}</span>
                    <#if user.pemId == 8 && (user.ward == 'A2' || user.ward == 'B2')>
                    <span>（机械键盘或鼠标一个）</span>
                    <#elseif user.pemId == 8 && user.ward == 'A3'>
                    <span>（二合一笔记本一台）</span>
                    <#elseif user.pemId == 8 && user.ward == 'A4'>
                    <span>（外星人台式机一台）</span>
                    <#elseif user.pemId == 9 && (user.ward == 'A2' || user.ward == 'B2')>
                    <span>（音响/台灯二合一）</span>
                    <#elseif user.pemId == 9 && user.ward == 'A3'>
                    <span>（华为P10一台）</span>
                    <#elseif user.pemId == 9 && user.ward == 'A4'>
                    <span>（iMac一台）</span>
                    </#if>
                </li>
                </#list>
            </ul>
        </div>
    </div>
    
    <div class="styleGoods layout">
        <div class="styleName styleTitle" name="发现好货"><div class="bgy"><h3>发现好货</h3></div></div>
        <div class="award">
            <h4>上传商品免费领取奖品</h4>
            <div class="awardCon clearfix">
                <div class="awardInline">
                    <ul>
                            <li>
                                <div class="imgBox">
                                    <i class="water"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传3件</div>
                                
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                        
                            <li>
                                <div class="imgBox">
                                    <i class="cola"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传5件</div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            <li>
                                <div class="imgBox">
                                    <i class="redBull"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传8件</div>
                                <div class="awardStatus ">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            <li>
                                <div class="imgBox">
                                    <i class="phone"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传10件</div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                    </ul>
                </div>
            </div>
            <b class="hdRule"><i class="wenIcon"></i>活动规则</b>
        </div>
        <div class="award1 layout">
            <h4>您的上一期中奖信息:</h4>
            <div class="awardCon clearfix">
                <div class="awardInline">
                    <ul>
                            <li>
                                <div class="imgBox">
                                    <i class="water"></i>
                                </div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            
                            <li>
                                <div class="imgBox">
                                    <i class="cola"></i>
                                </div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            
                            <li>
                                <div class="imgBox">
                                    <i class="redBull"></i>
                                </div>
                                <div class="awardStatus ">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            
                    </ul>
                </div>
            </div>
        </div>
        <div class="goodsList">
            <ul>
            <#list styleItem.goodsList as goodsItem>
                <li class="goodsItem">
                    <div class="imgBox">
                        <a href="http://hz.571xz.com/item.htm?id=${goodsItem.goodsId!}" target="_blank">
                            <img src="${goodsItem.imgSrc!}_300x300.jpg" alt />
                        </a>
                    </div>
                    <div class="title" title="${goodsItem.title!}">${goodsItem.title!}</div>
                    <div class="otherInfo">
                        <span>¥：<em>${goodsItem.piPriceString!}</em></span>
                        <a href="http://hz.571xz.com/shop.htm?id=${goodsItem.shopId!}" title="${goodsItem.marketName!} ${goodsItem.shopNum!}" target="_blank">${goodsItem.marketName!} ${goodsItem.shopNum!}</a>
                    </div>
                </li>
            </#list>
            </ul>
        </div>
    </div>
    <div class="styleShop layout">
        <div class="styleName styleTitle" name="发现好店"><div class="bgy"><h3>发现好店</h3></div></div>
        
        <div class='shopList'>
            <ul>
              
                <#list styleItem.shopList as shopItem>
                    <li class="shopListNum">
                        <div class="imgBox">
                            <a href="http://hz.571xz.com/shop.htm?id=${shopItem.shopId!}" target="_blank" title="${shopItem.marketName!} ${shopItem.shopNum!}">
                                <img src="${shopItem.imgSrc!}" alt  />
                            </a>
                        </div>
                        
                        <div class="shopNum">
                            <a href="http://hz.571xz.com/shop.htm?id=${shopItem.shopId!}" target="_blank" title="${shopItem.marketName!} ${shopItem.shopNum!}">
                                <p>${shopItem.marketName!}</p>
                                <p class="storeNum">${shopItem.shopNum!}</p>
                            </a>
                        </div>
                        <div class="shopTitle">
                            <p class="shopName" title="">${shopItem.uText!}</p>
                            <p class="userTitle" title="">${shopItem.dText!}</p>
                        </div>
                        <div class="otherGn">
                            <b xzclick='collectShop' data-shopid='${shopItem.shopId!}'><i></i>关注</b>
                            <a href="http://hz.571xz.com/shop.htm?id=${shopItem.shopId!}" target="_blank">进店逛逛 ></a>
                        </div>
                    </li>
                        
                </#list>
            </ul>
        </div>
    </div>
    <div class="fdGoods layout">
        <div class="styleName styleTitle" name="每日发现"><div class="bgy"><h3>每日发现</h3></div></div>
        <div class="award">
            <h4>上传商品免费领取奖品</h4>
            <div class="awardCon clearfix">
                <div class="awardInline">
                    <ul>
                            <li>
                                <div class="imgBox">
                                    <i class="water"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传3件</div>
                                
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                        
                            <li>
                                <div class="imgBox">
                                    <i class="cola"></i>
                                </div>
                                <div class="adStatus"></div>
                                <div class="awardDemand">上传5件</div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                    </ul>
                </div>
            </div>
            <b class="hdRule"><i class="wenIcon"></i>活动规则</b>
        </div>
        <div class="award1 layout">
            <h4>您的上一期中奖信息:</h4>
            <div class="awardCon clearfix">
                <div class="awardInline">
                    <ul>
                            <li>
                                <div class="imgBox">
                                    <i class="water"></i>
                                </div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                            
                            <li>
                                <div class="imgBox">
                                    <i class="cola"></i>
                                </div>
                                <div class="awardStatus">
                                    <p><em class="noFinish">未完成</em></p>
                                </div>
                            </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="goodsList">
            <ul>
            <#list likeGoodsList as goodsItem>
                <li class="goodsItem">
                    <div class="imgBox">
                        <a href="http://hz.571xz.com/item.htm?id=${goodsItem.goodsId!}" target="_blank">
                            <img src="${goodsItem.imgSrc!}_300x300.jpg" alt />
                        </a>
                    </div>
                    <div class="title" title="${goodsItem.title!}">${goodsItem.title!}</div>
                    <div class="otherInfo">
                        <span>¥：<em>${goodsItem.piPriceString!}</em></span>
                        <a href="http://hz.571xz.com/shop.htm?id=${goodsItem.shopId!}" title="${goodsItem.marketName!} ${goodsItem.shopNum!}" target="_blank">${goodsItem.marketName!} ${goodsItem.shopNum!}</a>
                    </div>
                </li>
            </#list>
            </ul>
        </div>
    </div>
    <script>/*============ searchV5/newStyleHd#awardJson BEGIN ============*/

var lastUserAward = ${lastUserAward!};

/*============ searchV5/newStyleHd#awardJson END ============*/


</script>
</div>
<div class="leftSidebar">
    <h3>发现好货</h3>
    <div class="styleDot">
        <ul id="leftSidebarbox">
            
            
        </ul>
    </div>
    <div class="toTop"><i class="topRow"></i>顶部</div>
</div>
<div class="imgLoading">
    <div class="layout">
        <p>数据加载中……</p>
        <div class="loading">
    </div>
    
    
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