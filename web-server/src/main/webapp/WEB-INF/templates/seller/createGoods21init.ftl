
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>发布宝贝 - 供应商后台 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/gysV1/css/createGoods21initv1.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
            <script src="http://style.571xz.com/v2/gysV1/plupload2.1.2/plupload.full.min.js"></script>
        
    
    <script src="http://style.571xz.com/v2/gysV1/js/createGoods21initv1.js"></script>
    
</head>
<body>


<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            
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






<div class="header">
    <div class="layout">
        <a class="logo iconfont" href="http://www.571xz.com"></a>
        <i class="splitline"></i>
        <a class="shop" href="http://${session_user_redis__.logshop.webSite!}.571xz.com/${session_user_redis__.logshop.shopId!}">${session_user_redis__.logshop.market!}${session_user_redis__.logshop.shopNum!}</a>
    </div>
</div>




<div class="wrapper layout">
    
    <div class="sidebar shadowBox">

    <h2>商品管理</h2>
    <ul>
    
        
        <li><a class="selected"  href="${main_host!}seller/createGoods21init.htm">发布商品</a></li> 
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsList21init.htm"  >出售中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsListinit.htm?pinteger=2"  >仓库中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsNoListinit.htm"  >批量修改货号</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/xiufuGoods21init.htm"  >商品类目管理</a></li> 
        
        
    
    </ul> 

    <h2>店铺管理</h2>
    <ul>
    
        
        
        <li><a href="http://${session_user_redis__.logshop.webSite!}.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"  target="_blank">查看我的店铺</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/design.htm"  target="_blank">店铺装修</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/pictureSpace.htm"  >图片空间<i class="new"></i></a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/shiguStoreerjiyuming.htm"  >二级域名</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/shiguStorebasicStore.htm"  >店铺资料</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/ghTongbu.htm"  >授权管理</a></li> 
        
        
    
    </ul> 

    <h2>财务信息</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/iwantToRechargein5.htm"  target="_blank">充值</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/withdraw5Apply.htm"  >提现</a></li> 
        
        
    
    </ul> 

    <h2>账号管理</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/safeindex.htm"  >安全设置</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/sysSetsindex.htm"  >个人信息</a></li> 
        
        
    
    </ul> 

    <h2>营销管理</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/dtggapply.htm?id=1001" class='dtgg' >免费LED广告</a></li> 
        
        
    
        
        
        <li><a href="https://shop121675953.taobao.com" target="_blank" style="color:#f40">广告位竞拍</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/indexgglist.htm" class='indexgg' >广告申请</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/promotion.htm"  >广告展示管理</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/actRegister.htm"  >立即报名活动</a></li> 
        
        
    
    </ul> 

</div>




    
    



<div class="content shadowBox">
    <div class="goods-tabbox clearfix">
    <div class="tabbutton selected"><a href="JavaScript:;">发布宝贝</a></div>
</div>




    

<ul class="goodsPostList">
<#if session_user_redis__.logshop.type == 1>
    <li>
        <div class="goodsPostListIntro">
            <h3>自动同步</h3>
            <p>在您变更淘宝店铺的商品的3-5分钟内，四季星座网系统会自动将新的商品或商品状态同步到四季星座网店铺中。</p>
        </div>
        <div class="clickButton beOpenStatus">
            <#if get.feedback?? && get.feedback gt 0>
                <#if get.feedback == 1>
                

<#assign text>{"text":"立即开通","href":"${main_host!}seller/ghTongbu.htm"}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
        <a class="gyButton" href="${$it.href!}" id="${$it.id!}">${$it.text!}</a>
    <#else>
        <button class="gyButton" jbtn="${$it.jbtn!}" id="${$it.id!}">${$it.text!}</button>
    </#if>



</#list>

                <#else>
                <i class="beOpen"></i>
                </#if>
            <#else>
                
                <i class="beOpen"></i>
            </#if>
        </div>
    </li>
    <li>
        <div class="goodsPostListIntro">
            <h3>整店同步</h3>
            <p>有淘宝商品没有展示在四季星座网？上下架状态不一致？整店同步一次商品可以解决您的问题！</p>
        </div>
        <div class="clickButton" data-id="${session_user_redis__.logshop.shopId!}">
            <#if get.feedback?? && get.feedback gt 0>
                <#if get.feedback == 1>
                

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    
        <button class="gyButton" jbtn="toSq" id="">立即同步</button>
    



</#list>

                

<#assign text>{"jid":"toSq","options":[{"name":"tipConText","value":"您未授权淘宝店铺"},{"name":"href_","value":"${main_host!}seller/ghTongbu.htm"},{"name":"tipIcon","value":"errorTipIcon"},{"name":"btText","value":"立即授权"}]}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>

<div jid="${$it.jid!}">
    <#list $it.options as option> 
    <input type="hidden" name="${option.name!}" value="${option.value!}" />
    </#list>
</div>










</#list>







                <#elseif get.feedback == 2>
                

<#assign text>{}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>

    
        <button class="gyButton" jbtn="againSq" id="">立即同步</button>
    



</#list>

                

<#assign text>{"jid":"againSq","options":[{"name":"tipConText","value":"您的淘宝店授权过期"},{"name":"href_","value":"${main_host!}ortherLogin.htm?ortherLoginType=1&backUrl=${main_host!}seller/createGoods21init.htm"},{"name":"tipIcon","value":"errorTipIcon"},{"name":"btText","value":"重新授权"}]}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>

<div jid="${$it.jid!}">
    <#list $it.options as option> 
    <input type="hidden" name="${option.name!}" value="${option.value!}" />
    </#list>
</div>










</#list>







                </#if>
            <#else>
                

<#assign text>{}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>

    
        <button class="gyButton" jbtn="toTb" id="">立即同步</button>
    



</#list>

            </#if>
        </div>
    </li>
<#elseif session_user_redis__.logshop.type == 2>
    <li>
        <div class="goodsPostListIntro">
            <h3>添加数据包</h3>
            <p>您可以通过数据包形式上传商品到四季星座网店铺中！</p>
            <p class="fcF40">*注：添加的数据包必须为zip格式的压缩包（压缩包中必须包含对应csv格式文件和对应图片文件夹），否则系统无法解析！</p>
        </div>
        <div class="clickButton">
            

<#assign text>{}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>

    
        <button class="gyButton" jbtn="" id="uploadGoodsPackage">添加数据包</button>
    



</#list>

        </div>
    </li>
    <li>
        <div class="goodsPostListIntro">
            <h3>手动发布</h3>
            <p>您也可以手动发布非淘宝店铺中出售的商品到四季星座网店铺中！</p>
        </div>
        <div class="clickButton">
            

<#assign text>{"text":"手动发布","href":"${main_host!}seller/releaseGoodsinit.htm"}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>

    <#if $it.href??>
        <a class="gyButton" href="${$it.href!}" id="${$it.id!}">${$it.text!}</a>
    <#else>
        <button class="gyButton" jbtn="${$it.jbtn!}" id="${$it.id!}">${$it.text!}</button>
    </#if>



</#list>

        </div>
    </li>
</#if>
</ul>
 
   














































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




