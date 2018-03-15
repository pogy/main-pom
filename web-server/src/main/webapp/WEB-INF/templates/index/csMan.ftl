<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>[四季星座网]常熟站-四季星座网-四季星座论坛-四季青服装货源，四季青市场，网店代理货源，网上服装进货，男装淘宝货源，女装淘宝货源，网络货源,网店货源导航,淘宝店货源,实体网络进货,杭州网店之家,杭州专业网店货源,杭州网店货源</title>
    <meta name="keywords" content="四季星座,四季星座网,四季星座论坛,网店代理货源,开淘宝店货源,淘宝货源,服装批发市场,杭州网店之家,杭州四季青服装批发市场,杭州四季青服装批发市场地址,外贸服装进货渠道,服装进货渠道">
    <meta name="description" content="四季星座网杭州的服装杭州女装货源批发网,市场包含了四季星座,星座女装电子商务楼,之江服装电子商务楼,四季青,意法服饰城,新杭派,四季星座男装等,是网络卖家网络货源平台,网店货源,女装货源,杭州女装货源,淘宝货源,实体店网络进货渠道,星座论坛 ,四季星座论坛，网店货源,实体店网络进货优选渠道!">

    <link href="http://style.571xz.com/indexV4/css/csMan.css?t=1498441471787" rel="stylesheet">
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/indexV4/js/jquery.cookie.js"></script>
<script>/*============ indexV4/page#layoutHeader BEGIN ============*/

'${test!}'
        var hreflocation=window.location.href;
          if(hreflocation.indexOf('http://www.571xz.com')==0||hreflocation.indexOf('http://571xz.com')==0){//仅首页
              var province = '' ;
              var city = '' ;
              jQuery.getScript("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js",function(){
                  province = remote_ip_info["province"];
                  if(province=='福建'){
                      window.location.href="http://ss.571xz.com";
                  }else if(province == '江苏'){
                      window.location.href="http://cs.571xz.com";
                  }else if(province == '广东'){
                      window.location.href="http://gz.571xz.com";
                  }else if(province == '吉林'){
                      window.location.href="http://wa.571xz.com";
                  }
              }) ;
          }

/*============ indexV4/page#layoutHeader END ============*/


</script>    <script src="http://style.571xz.com/indexV4/js/temp/ekoo.min.js"></script>
    <script src="http://style.571xz.com/indexV4/js/csMan.js?t=1498441471787"></script>
  </head>
<body >
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
<div class="fixtopbar">
    <div class="innner">
        <a class="logo" href="http://www.571xz.com"><img src="http://style.571xz.com/xz/css/img/mtLogo.png" title="四季星座网-首页" height="30" width="170"></a>
         <div class="searchbar">
            <div class="btnbox"><span>商品</span></div>
            <form action="http://so.571xz.com/cssearch.htm" target="_blank" id="searchgo3">
                <#if page?? && page.type == 'W'>
                <input type="hidden" name="cid" value="16">
                <#elseif page?? && page.type == 'M'>
                <input type="hidden" name="cid" value="30">
                </#if>
                <input style="text-indent:1em;" class="text-search" name="keyword" type="text">
                <button class="btn-search">搜索</button>
            </form>
        </div>
        
    </div>
</div>
<#if topPic??>
<#list topPic as tp>
<div class="topPic layout">
    <a href="<#if tp.href == ''>javascript:;<#else>${tp.href!}</#if>" target="_blank">
        <img src="${tp.imgsrc!}">
    </a>
</div>
</#list>
</#if>
<div class="header layout">
    <div class="logoLeft">
        <a href="http://${webSite!}.571xz.com">
            <img src="http://style.571xz.com/xz/css/img/logoWeb.png" alt width=170 height=52 />
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
            
            <form id="formSearch" action="http://so.571xz.com/${webSite!}search.htm" target="_blank">


                <input type="hidden" name="pid" value="30">
                
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
<div class="headerV1 layout">
    
</div>
<div class="firstScreen layout">
    <div class="leftbox developBg1">
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
                            <li><a target="_blank" href="http://${webSite!}.571xz.com/market.htm?mid=43">国际服装城</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="manCate">
                    <h3 class="mtitle"><em>男装分类</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50000436">T恤</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011123">衬衫</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010159">卫衣</a></li>
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
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012906">低帮鞋</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=50006842&amp;cid=122654005">箱包</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="styleCate">
                    <h3 class="mtitle"><em>时尚风格</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=店主">店主</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=休闲">休闲</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动">运动</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=情侣">情侣</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="elementCate">
                    <h3 class="mtitle"><em>流行元素</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=刺绣">刺绣</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=印花">印花</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=纯色">纯色</a></li>
                            <li><a target="_blank" href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=棉麻">棉麻</a></li>
                        </ul>
                    </div>
                </div>

                
            </div>
            
            <div class="detailbox">
                    <div class="innerbox w320c2 manMarket" data-width="w320c2">
                        <div class="itemConTop">
                            <h4 class="itemTitle">市场导航</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://${webSite!}.571xz.com/market.htm?mid=43" target="_blank">国际服装城</a></li>
                            </ul>
                        </div>
                    
                    </div>
                    <div class="innerbox w320c0 manCate" data-width="w320c0">


                        <div class="itemsbox">
                            <h4>上衣</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50000436" target="_blank">T恤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011123" target="_blank">衬衫</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010402" target="_blank">Polo衫</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011153" target="_blank">背心/马甲</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010159" target="_blank">卫衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50000557" target="_blank">针织衫/毛衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011159" target="_blank">风衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011161" target="_blank">皮衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010158" target="_blank">夹克</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011129" target="_blank">西装</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011130" target="_blank">西装套装</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50025883" target="_blank">毛呢大衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011165" target="_blank">棉衣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011167" target="_blank">羽绒服</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>裤子</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=短裤" target="_blank">短裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=西装裤" target="_blank">西装裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50010167" target="_blank">牛仔裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=3035" target="_blank">休闲裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=运动裤" target="_blank">运动裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50011127" target="_blank">皮裤</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;cid=50025885" target="_blank">棉裤</a></li>
                            </ul>
                        </div>

                    </div>
                    <div class="innerbox w320c0 xbpsCate" data-width="w320c0">
                    
                        
                        <div class="itemsbox">
                            <h4>男鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740" target="_blank">男鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=小白鞋" target="_blank">小白鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011745" target="_blank">凉鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011746" target="_blank">拖鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011744" target="_blank">帆布鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=皮鞋" target="_blank">皮鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=运动鞋" target="_blank">运动鞋</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=马丁靴" target="_blank">马丁靴</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=50011740&amp;keyword=豆豆鞋" target="_blank">豆豆鞋</a></li>
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
                    <div class="innerbox w240c2 styleCate" data-width="w240c2">
                        <div class="itemConTop">
                            <h4 class="itemTitle">时尚风格</h4>
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
                            </ul>
                        </div>
                    
                    </div>
                    <div class="innerbox w240c2 elementCate" data-width="w240c2">
                        <div class="itemConTop">
                            <h4 class="itemTitle">流行元素</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=刺绣" target="_blank">刺绣</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=印花" target="_blank">印花</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=纯色" target="_blank">纯色</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=棉麻" target="_blank">棉麻</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=丝光棉" target="_blank">丝光棉</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=水洗" target="_blank">水洗</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=旧" target="_blank">做旧</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=破洞" target="_blank">破洞</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=修身" target="_blank">修身</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=条纹" target="_blank">条纹</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=格子" target="_blank">格子</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=字母" target="_blank">字母</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=迷彩" target="_blank">迷彩</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=人物" target="_blank">人物</a></li>
                                <li><a href="http://so.571xz.com/${webSite!}goods.htm?pid=30&amp;keyword=束脚" target="_blank">束脚</a></li>
                            </ul>
                        </div>

                    </div>

            </div>
        
            
            
        </div>
        
    </div>
    <div class="centerbox">
        <div class="topNav">
            <ul class="clearfix">
                <li>
                    <a href="http://cs.571xz.com/market.htm?mid=43" target="_blank">
逛市场<i class="hot"></i>                    </a>
                </li>
                <li>
                    <a href="http://so.571xz.com/csgoods.htm" target="_blank">
商品库                    </a>
                </li>
                <li>
                    <a href="http://so.571xz.com/newgoods.htm?webSite=cs" target="_blank">
今日新品                    </a>
                </li>
                <li>
                    <a href="http://daifa.571xz.com/" target="_blank">
一件代发                    </a>
                </li>
                <li>
                    <a href="http://zixun.571xz.com/index" target="_blank">
资讯                    </a>
                </li>
            </ul>
        </div>
        
        <div class="topBanner">
            
            <div class="slides" id="slides"> 
                <div class="ulDiv">
                    <ul>
                    <#list topBanner as item>
                        <li>
                            <a href="${item.href!}" target="_blank"><img width="742" height="342px" alt="" src="${item.imgsrc!}"></a>
                        </li>
                    </#list>
                    </ul>
                </div>
             
                <div class="small"><div class="small-lab">
                    
                    
                </div></div>
                <div class="j_next c_next iconfont">&#xe603;</div>
                <div class="j_prev c_prev iconfont">&#xe602;</div>
            </div>
            
        </div>
        <div class="topStoread">
            <ul class="clearfix">
                <#list topStoread as item>
                <li><a href="${item.href!}" target="_blank"><img src="${item.imgsrc!}"></a></li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="rightbox">
        <div class="topChooseType">
            <a class="wbtn" href="/" xzclick="gotoWomanPage">女装</a>
            <a class="mbtn" href="/" xzclick="gotoManPage">男装</a>
        </div>
        <div class="topRtbox">
            
            <div class="noticebox">
                <div class="tabBtn">
                    <b class="btn1 selected ">公告</b>
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
                        <img src="http://style.571xz.com/indexV4/css/img/touxiang.png">
                    </div>
                    <div class="wellcom">
                        <p class="s1">Hi，欢迎来到</p>
                        <p>www.571xz.com</p>
                    </div>
                </div>
                
                
                <div class="p2 clearfix">
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
        <script>/*============ indexV4/page#topRtbox BEGIN ============*/

${test!}
var isgys = false;
var session_shopId = '${session_user_redis__.logshop.shopId!}';
if(session_shopId != ""){
    isgys = true;
}else{
    isgys = false;
}

/*============ indexV4/page#topRtbox END ============*/


</script>
    </div>
</div>
<div class="hotsaleGoodslist advs layout">
    <a class="sideNavbarDot" name="hotsaleGoods" data-text="热销"></a>
    <h3>热销商品 <span>爆款尖货  品质护航</span></h3>
    <div class="goodslist clearfix">
        <ul class="clearfix tle tleL">
            
            <#list hotsaleGoodslist as item>
            <li class="item1">
                <a class="imgBox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="styleGoodslist advs layout">
    <a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
    <h3>风格馆 <span>各类风格  应有尽有</span></h3>
    <div class="goodslist clearfix">
        <div class="styleGoods clearfix">
            <#list styleCateList as item>
            <div class="style"><a href="${item.href!}" target="_blank">${item.text!}</a></div>
            </#list>
        </div>
        
        <ul class="clearfix tle tleL">
            <#list styleGoodslist as item>
            <li class="item1">
                <a class="imgBox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="elementGoodslist advs layout">
    <a class="sideNavbarDot" name="elementGoods" data-text="元素"></a>
    <h3>流行元素 <span>潮流阵地  时尚前沿</span></h3>
    <div class="goodslist clearfix">
        <div class="elementGoods clearfix">
            <#list elementCateList as item>
            <div class="element"><a href="${item.href!}" target="_blank">${item.text!}</a></div>
            </#list>
        </div>
        
        <ul class="clearfix tle tleL">
            <#list elementGoodslist as item>
            <li class="item1">
                <a class="imgBox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="recommendShoplist layout advs">
    <a class="sideNavbarDot" name="recommendShop" data-text="推荐"></a>
    <h3>推荐档口 <span>实力档口  源头好货</span></h3>
    <div class="goodslist clearfix">
        <ul class="clearfix tle tleL">
            
            <#list recommendShoplist as item>
            <li class="item2">
                <a class="imgBox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                <div class="gsOtInfo">
                    <div class="inSell">
                        <a href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">
                            <span class="s1">${item.marketText!}</span>
                            <span class="s2">${item.storeNum!}</span>
                        </a>
                        
                    </div>
                
                <div class="userText" title="${item.userText!}">${item.userText!}</div>
                
                </div>
            </li>
            
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="loveGoodslist advs layout">
    <a class="sideNavbarDot" name="loveGoods" data-text="喜欢"></a>
    <h3><i class="iconLove"></i>猜您喜欢</h3>
    <p class="title">实时推荐 最适合你的商品</p>
    <div class="clearfix goodslist">
        
        <#list loveGoodslist as pitem>
            <#if (pitem.items?size) gt 0>
                <ul class="clearfix tle <#if pitem_index % 2 ==0>tleL<#else>tleR</#if>">
                <#list pitem.items as item>
                <li class="item1">
                    <a class="imgBox" href="http://${webSite!}.571xz.com/item.htm?id=${item.id!}" target="_blank">
                        <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                    </a>
                    
                    <div class="gsOtInfo">
                        <span class="price">¥${item.piprice!}</span>
                        <div class="storeNum" title="${item.storeText!}"><a href="http://${webSite!}.571xz.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                    </div>
                    <#if item.styleText?? && item.styleText != "" >
                        <div class="tally">${item.styleText!}</div>
                    </#if>
                    <#if item.elementText?? && item.elementText != "">
                    <div class="tally">${item.elementText!}</div>
                    </#if>
                </li>
                
                </#list>
                <li class="loveCate">${pitem.typeText!}</li>
                </ul>
            </#if>
        </#list>
    </div>
</div>
<div class="serverIntro">
    <div class="layout serverCon">
        
        <ul>
            <li>
                <i class="iconServer manDp"></i>
                <p>15,000多家档口</p>
                <span>集合最优质货源</span>
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
    <div class="logoInfo">
        <i></i>
        <p>400-076-1116</p>
        <span>工作时间：9:00 — 17:30</span>
    </div>
    
    <div class="siteCon">
        
        <ul>
            <li>
                <h5>四季星座网</h5>
                <p><a href="http://zixun.571xz.com/article?id=67" target="_blank">关于我们</a></p>
                <p><a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a></p>
            </li>
            <li>
                <h5>代理商</h5>
                <p><a href="http://zixun.571xz.com/article?id=45" target="_blank">一键上传</a></p>
                <p><a href="http://www.571xz.com/daifaIndex.htm" target="_blank">一件代发</a></p>
            </li>
            <li>
                <h5>供应商</h5>
                <p><a href="${main_host!}ruzhu.htm" target="_blank">商家入驻</a></p>
                <p><a href="${main_host!}seller/memberghs.htm" target="_blank">档口后台</a></p>
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
    
    <div class="ewm">
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
<div class="sideNavbar" id="sideNavbar">
    
</div>
<script>/*============ indexV4/csMan#main BEGIN ============*/

'${hacker!}';
$(".imgBox img").lazyload({
    effect: "fadeIn", // 载入使用何种效果
    threshold: 400 // 提前开始加载
});

/*============ indexV4/csMan#main END ============*/


</script>
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
<#include "/common/cnzz.ftl">
</body>
</html>