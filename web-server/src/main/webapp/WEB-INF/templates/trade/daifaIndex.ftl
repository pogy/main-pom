<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>一件代发，您身边的服务</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/daifaV1/css/daifaIndex.css?v=20170102301" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/daifaV1/js/daifaIndex.js?v=20170102301"></script>
    
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
    
        <li class="select">
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




<div class="graybg">
<div class="banner">
    <div class="layout pr">
        <div class="notice pa yahei">
    <h2 class="fs18">【公告】</h2>
    <h3 class="fs16 fc3">四季星座网一件代发功能，您身边的服务</h3>
    <p>四季星座网致力于为您提供高效、优质的服务。在使用过程中有任何问题、意见与建议，请与客服联系。我们会及时跟进解决。</p>
    <p>目前代发开通的市场：电商基地，四季星座，钱塘大厦。</p>
    <ul>
        <li><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后悠悠&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺1</span></a></li>
        <li><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后小匀&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺2</span></a></li>
        
        <li class="last"><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后慧慧&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺3</span></a></li>
    </ul>
    <p class="serviceTime">服务时间 :  9:00-18:00  （周六，周日不休息）</p>
    <p class="tac tel"><i class="icon-s-phone"></i><span>0571-86070380</span></p>
    

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
        
         toMyOrders"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        我的代发订单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

</div>
















    </div>
</div>


<div class="advantage listBox">
    <div class="layout yahei">
        <div class="title"></div>
        <div class="advList">
            <ul>
                <li>
                    <span class="icon-fbkj"></span>
                    <h3>方便快捷</h3>
                    <p>支持手动下单与淘宝同步一键下单<br>两种方式可根据需要任意选择</p>
                </li>
                <li class="icon-step"></li>
                
                <li>
                    <span class="icon-jsfh"></span>
                    <h3>发货及时</h3>
                    <p>一般每日16点前下的不缺货订单<br>保证当天发货</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-fwbz"></span>
                    <h3>服务保障</h3>
                    <p>强大的客服团队<br>提供优质服务，保障客户利益。</p>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="progress listBox">
    <div class="layout yahei">
        <div class="title title-progress"></div>
        <div class="proList">
            <ul>
                <li>
                    <span class="icon-tjdd"></span>
                    <h3>1、提交订单</h3>
                    <p>添加需要代发的商品，完善收货地址，提交订单</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-qrdd"></span>
                    <h3>2、确认订单</h3>
                    <p>核对包裹的商品及收件人信息准确无误</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-wcjs"></span>
                    <h3>3、完成结算</h3>
                    <p>结算该笔订单代发安排发货</p>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="problems listBox">
    <div class="layout yahei">
        <div class="title title-problem"></div>
        <div class="proContainer">
            <div class="proTitle clearfix">
                <ul>
                    <li class="current">代发问题<em></em></li>
                    <li>售后问题<em></em></li>
                    <li>合作市场<em></em></li>
                </ul>
            </div>
            <div class="proContent fs14">
                <div class="">
                    <ul>
                        <li>
                            <p class="question">1、星座代发什么时候截单？</p>
                            <p class="answer">每天16:00截单，如有特殊情况会提前截单。为了保证您的发货时效，请尽早下单。</p>
                        </li>
                        <li>
                            <p class="question">2、星座代发什么时候拿货？</p>
                            <p class="answer">每日11时起，会有专门的配货员为您配货，直至截单后最后一单配货完成。</p>
                        </li>
                        <li>
                            <p class="question">3、星座代发什么时候发货？</p>
                            <p class="answer">当天配齐订单，保证当天发货，物流信息以快递公司揽件后更新为准。</p>
                        </li>
                        <li>
                            <p class="question">4、已下代发订单可以取消吗？</p>
                            <p class="answer">1）未配商品：即时退款，包括商品金额+代配服务费等该订单所涉及的费用。</p>
                            <p class="answer">2）已配商品：如果商品已经采购，代配服务费已经产生，不予以退还，如有增值服务费用系统即时自动返还：增值服务费用。商品进入售后流程，第二天退货后退款（如遇档口下架商品无法退货，此商品视为您的库存商品）。</p>
                            <p class="answer">3）发货完成：如果商品已经发货完成，视为正常售后流程所产生的费用不予以退还，本平台可以配合物流公司进行截单服务，为您更好控制损失。</p>
                        </li>
                        <li>
                            <p class="question">5、下单的宝贝没有货，可以退款吗？</p>
                            <p class="answer">1）单件缺货继续配货或者退款：</p>
                            <p class="answer">当天缺货，我们默认会在第二天重新安排采购，您无需重新下单，我们会第一时间反馈后台方便您操作。单件连续缺货3天或者档口下架，我们将直接进行退款处理。</p>
                            <p class="answer">2）多件缺货：</p>
                            <p class="answer">配货员在配货时如遇缺货会第一时间反馈予您的后台，您可根据情况转成缺货先发或者取消订单进入退款流程。如连续3天（以日期为单位第一日至第三日16时为准）配货缺货时未进行操作，平台默认为同意缺货先发，扣除快递等费用，未配货进入退款或拆单流程。</p>
                        </li>
                        <li>
                            <p class="question">6、代发商品，你们会进行检查吗？</p>
                            <p class="answer">拿到商品，我们会检查外包装，包括：颜色，尺码，款式，套装是否齐整一致，是否大面积破损等。不包括：拆包平铺检查、剪线头、破损包装袋、内衬、口袋、拉链、袖子、裤管</p>
                            <p class="answer">注：以下非质检问题：</p>
                            <p class="answer">面料问题：掉色、面料潮湿、起球、开线等；</p>
                            <p class="answer">做工问题：做工粗糙；</p>
                            <p class="answer">尺寸问题：尺寸和档口描述相差大；</p>
                            <p class="answer">货不对板：实物与图片版型、款式、颜色等相差大。</p>
                        </li>
                    </ul>
                </div>
                <div class="none">
                    <ul>
                        <li>
                            <p class="question">1、怎么进行退货申请？</p>
                            <p class="answer">退货需先进行退货申请，请让客户留便签随包寄回，方便为你提供快捷的售后时效。</p>
                            <p class="answer">如未申请寄回，本公司一律按未知件处理，后续不便售后查询，无法保证时效。</p>
                            <p class="answer">如若快件超过15天（以签收时间为准）未主动申请，本公司将商品视为无效件概不负责，作废品处理，将无法找回。</p>
                        </li>
                        <li>
                            <p class="question">2、退货申请时间多久？</p>
                            <p class="answer">建议您在收到退货后的7天内申请退货退款，保证您的退货时效，以免商品下架无法退货，造成您的经济损失。</p>
                        </li>
                        <li>
                            <p class="question">3、退货后，多久可以退款？</p>
                            <p class="answer">快递签收后第二天进行退货后退款。重大促销比如618、双十一、双十二等，杭州男装市场每月1日休业，节假日春节放假等，市场不接受退货，退货退款时间顺延。</p>
                            <p class="answer">如果档口下架等无法退货，后台会反馈予您，您可以在售后页面里面进行查看，再根据情况联系客服，进行寄回等处理（库存物品我们为您保管30天，如30天未申请操作，本公司视为无人认领物品，作废品处理）。</p>
                        </li>
                        <li>
                            <p class="question">4、申请退货失败，怎么办？</p>
                            <p class="answer">退货失败后，您可以联系客服，申请将商品寄回（库存物品我们为您保管30天，如30天未申请操作，本公司视为无人认领物品，作废品处理）。</p>
                            <p class="answer">若超过30天未主动申请，本公司将商品视为无效件，作废品处理无法找回。</p>
                        </li>
                    </ul>
                </div>
                <div class="none">
                    <p>目前开通市场： 电商基地，四季星座，钱塘大厦</p>
                </div>
            </div>
            
        </div>
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


