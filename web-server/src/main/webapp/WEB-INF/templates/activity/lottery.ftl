<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>秋装上上上，幸运大抽奖 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/qzhd/css/lottery5.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/qzhd/js/lottery5.js"></script>
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
    
        <li >
            <a href="http://hz.571xz.com/market.htm" target="_blank">
                逛市场
                <i class="hot"></i>
                
            </a>
        </li>
    
        <li >
            <a href="http://so.571xz.com/hzgoods.htm" target="_blank">
                商品库
                
                
            </a>
        </li>
    
        <li >
            <a href="http://so.571xz.com/newgoods.htm" target="_blank">
                今日新品
                
                
            </a>
        </li>
    
        <li >
            <a href="http://www.571xz.com/shopRanking.htm" target="_blank">
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
            <a href="http://www.571xz.com/shopIconCopyright.htm" target="_blank">
                知识产权
                
                
            </a>
        </li>
    
        <li >
            <a href="http://zixun.571xz.com/index" target="_blank">
                资讯
                
                
            </a>
        </li>
    
    </ul>
</div>



<script src="http://style.571xz.com/v2/xz/js/rotate/jQueryRotate.2.2.js"></script>
<script src="http://style.571xz.com/v2/xz/js/rotate/jquery.easing.min.js"></script>

<div class="rotateContainer">
    <div class="layout pr">
        <div class="title"></div>
        <a href="http://www.571xz.com/member/awardInfo.htm" class="toMyAward pa yahei">查看我的奖品</a></a>
        <div class="rotateBox pr">
            <div class="rotateBg pa"></div>
            <div class="lotteryStar pa"><img src="http://style.571xz.com/v2/qzhd/css/img/lottery/rotate.png" id="lotteryBtn"><img src="http://style.571xz.com/v2/qzhd/css/img/lottery/go.png" class="go" id="goBtn"><p class="yahei fs14 pa">还有<span id="lettoryNum">${lettoryNumber!}</span>次机会</p></div>
        </div>
        <div class="bottonSeat pr"></div>
        <div class="person pa"></div>
    </div>
</div>




















<script>
 var lettoryNumber = ${lettoryNumber!};
</script>


































<div class="rules">
    <div class="layout awardsBox">
        <h2 class="yahei fs18 tac"><span class="pr">活动大揭秘</span></h2>
        <ol>
            <li>1、一等奖：Apple iPad mini4；</li>
            <li>2、二等奖：AC4000夜鹰X6S千兆游戏无线路由器；</li>
            <li>3、三等奖：耳机，键盘，电子称等电子生活用品随机领取；</li>
            <li>4、参与奖：小茗同学，红牛等健康饮品随机领取。</li>
        </ol>
    </div>
    <div class="layout rulesBox">
        <h2 class="yahei fs18 tac"><span class="pr">活动规则</span></h2>
        <ol>
            <li>1、活动时间：上新及抽奖时间：2017.09.18--2017.09.25日。</li>
            <li>2、活动商品：仅限“活动页商品”。</li>
            <li>3、抽奖次数：每个ID最多5次，即上新商品个数分别为3、5、9、13、20。</li>
            <li>4、上新商品：须为不同新品，不可同一新品重复上架，否则不计入上新数量。</li>
            <li>5、上架时间：活动期间，上架的活动新品不可以下架，否则将被判定为不符合对应的抽奖资格。</li>
            <li>6、中奖查询：点击“我的奖品”，查看中奖信息。若中奖，会出现对应的奖品下方的提货码，即可凭提货码领奖（提货码不记名，为唯一凭证，请妥善保管）。</li>
            <li>7、奖品领取：为了保证奖品公证有效性，奖品在活动结束后7个工作日内凭提货码，前往电商基地大厅领取。</li>
            <li>8、本期活动结束后若未领取，可及时咨询四季星座网在线客服。若7日内未领奖品视为自动放弃。 </li>
            <li>9、本活动四季星座网享有最终解释权。</li>
        </ol>
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
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
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


