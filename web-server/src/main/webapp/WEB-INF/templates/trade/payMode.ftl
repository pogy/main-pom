
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>收银台 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/order/css/payMode.css?v=2017112401" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/order/js/payMode.js?v=2017112401"></script>
    
</head>
<body>


<#assign text>{"isFxs":true}</#assign>
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
        <a href="http://www.571xz.com">
            <img src="http://style.571xz.com/v2/xz/css/img/mtLogo.png" width="168" height="30" />
        </a>
        <em class="yahei">收银台</em>
    </div>
    <div class="statusRight fr">
        <div class="stTitle clearfix">
            <ul>
                
                <li class="pr cgState">
                    <h5>1、确认商品</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr cgState">
                    <h5>2、提交订单</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr cgState">
                    <h5>3、选择支付方式</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr">
                    <h5>4、支付成功</h5>
                    <span class="pa"></span>
                </li>
                
            </ul>
        </div>
        <div class="subScript"></div>
    </div>
</div>






<div class="minHeight">
<div class="layout">
    <div class="orderInfo">
    <span class="successIcon fl"></span>
    <div class="fl">
        <h3 class="fs18 yahei fwb fc3">订单提交成功，请尽快付款！</h3>
        <#if orderId??>
        <p><span class="orderNumber">订单编号：<em class="arail fs14">${orderId!}</em></span>请在<span class="fcF40 validTime"><em class="arail fs14">72</em>小时</span>之内完成付款，否则订单将会被取消！</p>
        <#else>
        <p>您已选择<span class="fcF40">${orderNum!}单</span>订单，请在<span class="fcF40 validTime"><em class="arail fs14">72</em>小时</span>之内完成付款，否则订单将会被取消！</p>
        </#if>
    </div>
    <div class="fr totalPrice">应付金额：<span class="fwb fcF40 arail">${amountPay!}</span>元</div>
    <input type=hidden id="orderCode" value="${orderCode!}">
    <input type=hidden id="orderId" value="${orderId!}">
</div>




    
<div class="payMode pr">
    <span class="tag pr fs16 yahei">请选择支付方式 <em class="pa"></em></span>
    <div class="payForm">
        <ul>
            <li class="selected">
                

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<label class="fmRadio clearfix
    
        checked
    
    
        buttonRadio
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="pay"
        
        
        
            value="alipay"
        
        
        
            checked
        
    >
    <i class="before"></i>
    <span>
    
        支付宝
    
    </span>
</label>




</#list>

                <span class="payNumber fr">支付：<em class="fwb fcF40 arail">${amountPay!}</em>元</span>
                <#if orderId??>
                <input type=hidden name="alipayUrl" value="/order/alipay.htm?id=${orderId!}&tempCode=${tempCode!}"></li>
                <#else>
                <input type=hidden name="alipayUrl" value="/order/alipay.htm?orderCode=${orderCode!}&tempCode=${tempCode!}"></li>
                </#if>
            
            <li>
                

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<label class="fmRadio clearfix
    
        <#if $it.checked??>
            checked
        </#if>
    
    
        buttonRadio
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="pay"
        
        
        
            value="xzpay"
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i>
    <span>
    
        星座宝
    
    </span>
</label>




</#list>

                <div class="lastMoneyBox">
                    <span class="lastMoney none"><em class="fc9">余额：</em><em class="yahei">&yen;</em><em class="fs14 fwb">${currentAmount!}</em></span>
                    <span class="recharge"></span>
                </div>
                <span class="payNumber fr">支付：<em class="fwb fcF40 arail">${amountPay!}</em>元</span>
            </li>
        </ul>
        <div class="payPwd">
            <p class="fc9">请输入支付密码</p>
            <input type="password" placeholder="请输入支付密码" name="xzpayPwd">
            <#if notSetPassword??>
            <span class="recharge notSetPassword"><i></i><em class="fcF40">您还未设置星座宝（余额）支付密码，请尽快设置以防资金被盗！ </em> <a href="${main_host!}member/safeXgPaymm.htm">立即设置</a></span>
            </#if>
        </div>
        
        <div class="payBtn">
            <b class="fs18 yahei fwb">立即支付</b>
        </div>
    </div>
</div>













<script>
var currentAmount = '${currentAmount!}';
var amountPay = '${amountPay!}';
</script>
































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







