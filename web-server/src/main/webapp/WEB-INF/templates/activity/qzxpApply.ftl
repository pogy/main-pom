<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>秋装新品发布会活动报名中 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/qzhd/css/qzxpApply.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/qzhd/js/qzxpApply.js"></script>
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
                    <li><a href="http://hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
                    <li><a href="http://cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
                    <li><a href="http://ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
                    <li><a href="http://bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
                    <li><a href="http://gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
                    <li><a href="http://wa.571xz.com" <#if webSite == 'wa'>class="select"</#if>>辽源</a></li>
                    <li><a href="http://jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
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
                    <a href="${main_host!}carts.htm">
                        <i class="cgcatIcon"></i>
                        <span>购物车</span>
                        
                        
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
                                <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
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
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                </li>
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            
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
        <a href="http://${webSite!}.571xz.com">
            <img src="http://style.571xz.com/v2/xz/css/img/mtLogo.png" width="168" height="30" />
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
            
                action="http://so.571xz.com/${webSite!}search.htm" 
            
            
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
    
        <li>
            <a href="http://hz.571xz.com/market.htm" target="_blank">
                逛市场
                <i class="hot"></i>
                
            </a>
        </li>
    
        <li>
            <a href="http://so.571xz.com/hzgoods.htm" target="_blank">
                商品库
                
                
            </a>
        </li>
    
        <li>
            <a href="http://so.571xz.com/newgoods.htm" target="_blank">
                今日新品
                
                
            </a>
        </li>
    
        <li>
            <a href="http://www.571xz.com/activity/redbull.htm" target="_blank">
                发现好货
                <i class="hot"></i>
                
            </a>
        </li>
    
        <li>
            <a href="http://daifa.571xz.com/" target="_blank">
                一件代发
                
                
            </a>
        </li>
    
        <li>
            <a href="http://zixun.571xz.com/index" target="_blank">
                资讯
                
                
            </a>
        </li>
    
    </ul>
</div>



<div class="grayBg">
    <div class="banner"></div>

    <div class="applyBtn">
    <#if alreadyApply == true>
        <b class="disabled">已报名</b>
    <#else>
        <#if !session_user_redis__> 
            <b onclick="loginBack()">立刻报名</b>
        <#else> 
            <#if session_user_redis__.logshop??> 
            <b class="supplierBtn">立刻报名</b>
            <#else> 
            <b class="agentBtn">立刻报名</b>
            </#if>
        </#if>
    </#if>
</div>





































</div>
<div class="blueBg">
    <div class="actIntroduce yahei layout">
    <h2 class="tac">活动介绍</h2>
    <ul class="actText fs14 fc3">
        <li>报名时间：2017.07.13</li>
        <li>活动上线时间：待定（由报名审核通过的大部分档口共同协商确定）</li>
        <li>活动名额：20家档口</li>
        <li>收费类型：免费</li>
        <li>报名资质：支持退货、支持换货</li>
        <li>风格要求：港风、日系、韩风、休闲、原创、情侣、中国风等风格均可报名</li>
    </ul>
</div>

    <div class="actApplyExplain yahei layout">
    <h2 class="tac">活动报名说明</h2>
    
    <ul class="actText fs14 fc3">
        <li>1、 有秋装新品即将发布的档口老板们，点击立即报名，就有机会参与活动；</li>
        <li>2、 本次活动将从所有报名的档口中精选20家优质档口；</li>
        <li>3、 活动正式上线前，每家档口将获得一个活动预热广告位，广告位所需图片需档口自行提供（图片尺寸要求：490x260px），<br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如在指定时间内无法提供，则视为自动放弃活动资格；</li>
        <li>4、 满足报名条件并被选中的档口，每家可提供5款活动商品，且5款商品必须属于同一风格/系列；</li>
        <li>5、 活动上线时展示的商品需为之前未上架过的商品；</li>
        <li>6、 活动上线时间，将与报名通过的大部分档口统一确认后，再行安排；</li>
        <li>7、 本次活动四季星座网将给予最大限度的线上、线下推广资源支持，只为助力档口打造今年秋季新品的最爆款；</li>
        <li>8、 本次活动将采用线上报名，线下确认相结合的方式，确保今年的秋装新品发布会圆满顺利进行；</li>
        <li>9、 本次活动的最终解释权归四季星座网所有，如有疑问，可咨询网站客服。</li>
        <li class="last">备注：活动上线前，预热页面档口展示效果图如下</li>
    </ul>
    
    <div class="shopShow fs14">
        <ul>
            <li>
                <img src="http://style.571xz.com/v2/qzhd/css/img/qzxpApply/show.jpg">
                <p class="fc6">电商基地 <span class="fc9">|&nbsp;&nbsp;A002</span></p>
            </li>
            <li>
                <img src="http://style.571xz.com/v2/qzhd/css/img/qzxpApply/show.jpg">
                <p class="fc6">电商基地 <span class="fc9">|&nbsp;&nbsp;A002</span></p>
            </li>
        </ul>
    </div>
    
    <div class="applyBtn">
    <#if alreadyApply == true>
        <b class="disabled">已报名</b>
    <#else>
        <#if !session_user_redis__> 
            <b onclick="loginBack()">立刻报名</b>
        <#else> 
            <#if session_user_redis__.logshop??> 
            <b class="supplierBtn">立刻报名</b>
            <#else> 
            <b class="agentBtn">立刻报名</b>
            </#if>
        </#if>
    </#if>
</div>





































</div>


</div>



<div class="footer">
    <div class="inner">
        <p class="sitemap"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://py.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
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
            <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            | 
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <img src="http://style.571xz.com/v2/global/css/img/beian.png" alt="浙公网安备">
                浙公网安备 33010202000302号
            </a> 
        </p>
    </div>
</div>




<!--省略end，让浏览器自动添加-->

<#include "/common/cnzz.ftl">


