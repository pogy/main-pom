<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>秋装新品发布会 爆款预告 抢先get - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="//style.571xz.com/v2/qzhd/css/qzxpShop.css?v=20180809" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="//style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="//style.571xz.com/v2/qzhd/js/qzxpShop.js?v=20180809"></script>
</head>
<body>



<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            
            <div class="cityChooseBox fl pr">
                <span class="lable pr">
                    <em>
                        <#if webSite == 'hz'>
                            杭州
                        <#elseif webSite == 'cs'>
                            常熟
                        <#elseif webSite == 'ss'>
                            石狮
                        <#elseif webSite == 'bj'>
                            北京
                        <#elseif webSite == 'gz'>
                            广州
                        <#elseif webSite == 'wa'>
                            辽源
                        <#elseif webSite == 'jx'>
                            濮院
                        <#else>
                            杭州
                        </#if>
                    </em>
                    <i class="downArrow"></i>
                </span>
                <ul>
                    <li><a href="//hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
                    <li><a href="//cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
                    <li><a href="//ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
                    <li><a href="//bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
                    <li><a href="//gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
                    <li><a href="//wa.571xz.com" <#if webSite == 'wa'>class="select"</#if>>辽源</a></li>
                    <li><a href="//jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
                </ul>
            </div>
            
            <div class="loginBox fl">
                
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                
                 
                <li class="noIndex">
                    <a href="${main_host!}" class="fcF40">四季星座网首页</a>
                </li>
                
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop> 
                <li class="noDown">
                    <a href="${main_host!}order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                        
                        
                    </a>
                </li>
                <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? > 
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                <li class="noDown">
                    <a href="//www.571xz.com/contact.htm" target="_blank">联系客服</a>
                </li>
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            
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
                </#if>
            </ul>
        </div>
    </div>
</div>










</#list>


<script>
var webSite = '${webSite!}';
</script>







<div class="header layout">
    <div class="logoLeft fl">
        <a href="//${webSite!}.571xz.com">
            <img src="//style.571xz.com/v2/xz/css/img/mtLogo.png" width="168" height="30" />
        </a>
        <em class="fs18 yahei"></em>
    </div>
    <div class="searchBar fr">
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
        
        <form id="formSearch"
            
                action="//so.571xz.com/${webSite!}search.htm"
            
            
        >
            
            
            
            
            <input type="text" class="searchCon fl" name="keyword" placeholder="输入商品名称" >
            <button type="submit" class="searchBtn fs14">搜索</button>
        </form>
    </div>
</div>



<script>
var webSite = '${webSite!}';
</script>




</div>



<div class="topNav">
    <ul class="clearfix">
    
        <li >
            <a href="//hz.571xz.com/market.htm" target="_blank">
                逛市场
                <i class="hot"></i>
                
            </a>
        </li>
    
        <li >
            <a href="//so.571xz.com/hzgoods.htm" target="_blank">
                商品库
                
                
            </a>
        </li>
    
        <li >
            <a href="//so.571xz.com/newgoods.htm" target="_blank">
                今日新品
                
                
            </a>
        </li>
    
        <li >
            <a href="//www.571xz.com/shopRanking.htm" target="_blank">
                排行榜
                <i class="hot"></i>
                
            </a>
        </li>
    
        <li >
            <a href="/daifaIndex.htm" target="_blank">
                一件代发
                
                
            </a>
        </li>
    
        <li >
            <a href="//www.571xz.com/shopIconCopyright.htm" target="_blank">
                知识产权
                
                
            </a>
        </li>
    
        <li >
            <a href="//zixun.571xz.com/index" target="_blank">
                资讯
                
                
            </a>
        </li>
    
    </ul>
</div>



<div class="banner">
    <div class="contanir layout pr">
        <div style="background:#000; width:20px; height:10px; top:10px; right:20px;" class="pa"></div>
    </div>
</div>

<div class="shopList">
    <ul class="layout">
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40413" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A001.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40923" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A007.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40908" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A009.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=29479" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A231A.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40238" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A326.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35026" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/B297.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=42603" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/B249.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35348" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A247.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=29911" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A249.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35922" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A088.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=29727" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/C211.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=39899" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A448.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35611" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A210.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=42592" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A409-2.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35477" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/B231.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=29913" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/C219.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=35748" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A240.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40269" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A066.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=40435" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/A002.jpg">
            </a>
        </li>
        
        <li>
            <a href="//hz.571xz.com/shop.htm?id=29674" target="_blank">
                <img src="//style.571xz.com/v2/qzhd/img/C213.jpg">
            </a>
        </li>
        
    </ul>
</div>







<div class="footer">
    <div class="inner">
        <p class="sitemap"> 
            <a href="/" target="_blank">首页</a>
            <a href="//hz.571xz.com" target="_blank">杭州站</a>
            <a href="//bj.571xz.com" target="_blank">北京站</a>
            <a href="//gz.571xz.com" target="_blank">广州站</a>
            <a href="//ss.571xz.com" target="_blank">石狮站</a>
            <a href="//cs.571xz.com" target="_blank">常熟站</a>
            <a href="//wa.571xz.com" target="_blank">辽源站</a>
            <a href="//jx.571xz.com" target="_blank">濮院站</a>
            <a href="//zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            | 
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <img src="//style.571xz.com/v2/global/css/img/beian.png" alt="浙公网安备">
                浙公网安备 33010202000302号
            </a> 
        </p>
    </div>
</div>




<!--省略end，让浏览器自动添加-->

<#include "/common/cnzz.ftl">


