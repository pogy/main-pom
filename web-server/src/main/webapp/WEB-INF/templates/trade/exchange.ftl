<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>换货 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/order/css/exchange.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/order/js/exchange.js"></script>
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
        <a href="http://www.571xz.com" class="fl">
            <img src="http://style.571xz.com/v2/xz/css/img/whiteLogo.png" width="168" height="28" />
        </a>
        <ul class="fl fs16 yahei clearfix">
            <li><a href="${main_host!}member/index.htm">首页</a></li>
            <li><a href="${main_host!}member/userBalance.htm">我的钱包</a></li>
            <li><a href="${main_host!}member/sysSetsindex.htm">安全中心</a></li>
        </ul>
    </div>
</div>



<div class="minHeight">
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="http://www.571xz.com">首页</a> &gt;
    <a href="${main_host!}member/index.htm">我的星座网</a> &gt;
    <a href="${main_host!}order/myOrder.htm">我的订单</a> &gt;
    <span class="fcF40">申请售后</span>
</div> 

<div class="exchangeStep layout">
    <ul>
        <#list exchangeDesc as desc>
        <li <#if desc_index lt exchangeStateNum>class="selected"</#if>><span>${desc!}</span><em></em><i></i><i class="leftArrow"></i></li>
        </#list>
    </ul>
</div>





<div class="returnBox layout">
    <div class="returnLeft fl">
        <#if exchangeStateNum == 1>
        <div class="reRefundGoods refundBox" data-orderId="${orderId!}" data-goodsId="${childOrderId!}">
    
    <label class="fl fc6">换货商品：</label>
    
    <img src="${childOrderImgSrc!}" >
    <div class="goodsInfo fl">
        <p class="arail fs14 fc3">${childOrderCode!}</p>
        <p class="fc9"><span>颜色：${childOrderColor!}</span><span>尺码：${childOrderSize!}</span></p>
    </div>
</div>




        <div class="exchangeApply refundBox">
    <ul>
        <li>
            <label><em class="fcF40 vm">*</em> 服务类型：</label>
            

<#assign text>{"name":"service","value":"exchange"}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<div class="fmSelect" id="serviceType">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>




        </li>
        <li>
            <label>换货原因：</label>
            

<#assign text>{"name":"reason","value":"0"}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<div class="fmSelect" id="refundReason">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>




        </li>
        <li class="refundDesc">
            <label>换货说明：</label>
            <textarea placeholder="最多16个字符" maxlength="16"></textarea>
        </li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei applyBtn"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        提交申请
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</li>
    </ul>
</div>





        <#elseif exchangeStateNum == 2>
            <#if query.express??>
                


<div class="reChooseExpress refundBox">
    
    <h4 class="yahei fwb fc3">换货申请已通过，请及时确认完成！</h4>
    <p class="fc3">换货申请已通过，请填写退货物流信息！</p>
    
    <ul>
        <li class="refundAddr">
            
            <label>换货地址：</label>
            
            <p class="fs3">
                ${addrInfo.name!} , ${addrInfo.phone!},<br>${addrInfo.address!}
            </p>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 选择快递：</label>
            

<#assign text>{"name":"expressList","value":""}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>
<div class="fmSelect" id="expressList">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>




        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 物流单号：</label>
            <input type="text" name="expressCode" class="fmInput" placeholder="请填写物流单号">
            <div class="errorTip">物流单号格式不正确！</div>
        </li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei sureBtn"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        提交
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</li>
    </ul>
</div>


















<script>
var refundId = '${refundId!}';
</script>









            <#else>
                <#if exchangeWaitState == 1>
                <div class="reWaitFeedback refundBox">
    
    <h4 class="fwb yahei fc3">换货申请已提交，请等待处理！</h4>
    
</div>


                <#elseif exchangeWaitState == 2>
                


<div class="reChooseExpress refundBox">
    
    <h4 class="yahei fwb fc3">换货申请已通过，请及时确认完成！</h4>
    <p class="fc3">换货申请已通过，请填写退货物流信息！</p>
    
    <ul>
        <li class="refundAddr">
            
            <label>换货地址：</label>
            
            <p class="fs3">
                ${addrInfo.name!} , ${addrInfo.phone!},<br>${addrInfo.address!}
            </p>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 选择快递：</label>
            

<#assign text>{"name":"expressList","value":""}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>
<div class="fmSelect" id="expressList">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>




        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 物流单号：</label>
            <input type="text" name="expressCode" class="fmInput" placeholder="请填写物流单号">
            <div class="errorTip">物流单号格式不正确！</div>
        </li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei sureBtn"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        提交
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</li>
    </ul>
</div>


















<script>
var refundId = '${refundId!}';
</script>









                <#elseif exchangeWaitState == 3>
                <div class="reExpressInfo fc3 refundBox">
    
    <h4 class="yahei fwb">换货快递已提交！</h4>
    
    
    <p><span class="fc6" data-expressId="${express.id!}">${express.name!}</span><span class="yahei fs14 vm">${express.code!}</span><a href="javascript:;" id="modifyExpress">修改快递</a></p>
    
    <p class="finishBtn" data-id="${refundId!}">

<#assign text>{}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
         finishExchange"
    
        jbtn="finishExchange"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        换货已完成
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
    
    
</div>



<script>
var expressCreateTime = ${express.createTime!};
</script>




                <#elseif exchangeWaitState == 4>
                <div class="reRefuseApply refundBox">
    
    <h4 class="fwb yahei fc3">换货申请已拒绝！</h4>
    
    <p class="refuseReason fcF40">${refuseReason!}</p>
</div>




                </#if>
                <div class="reApplyRecord">
    <label class="fl tar">申请记录：</label>
    <div class="recordList fl">
        
        <#list applylist as record>
        <div class="recordItem clearfix">
            <img class="fl" src="${record.userHeadimg!}">
            <div class="applyRecord fl">
                <h4>
                <#if record.userType == 1>
                    ${record.userNickname!}
                <#elseif record.userType == 0>
                    平台客服
                </#if>
                </h4>
                <p>
                <#if record.userType == 1>
                买家（${record.userNickname!}）于 ${record.recordTime!} ${record.recordContent!}<br>
                    
                <#elseif record.userType == 0>
                ${record.recordContent!}<br>
                    
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
        
    </div>
</div>




            </#if>
        <#elseif exchangeStateNum == 3>
            <div class="exchageFinish refundBox">
    <h4 class="yahei fwb fc3">换货完成！</h4>
    <p>完成时间：<span class="yahei fs14 vm">${exchageFinishTime!}</span></p>
</div>




            <div class="reApplyRecord">
    <label class="fl tar">申请记录：</label>
    <div class="recordList fl">
        
        <#list applylist as record>
        <div class="recordItem clearfix">
            <img class="fl" src="${record.userHeadimg!}">
            <div class="applyRecord fl">
                <h4>
                <#if record.userType == 1>
                    ${record.userNickname!}
                <#elseif record.userType == 0>
                    平台客服
                </#if>
                </h4>
                <p>
                <#if record.userType == 1>
                买家（${record.userNickname!}）于 ${record.recordTime!} ${record.recordContent!}<br>
                    
                <#elseif record.userType == 0>
                ${record.recordContent!}<br>
                    
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
        
    </div>
</div>




        </#if>
        
    </div>
    <div class="returnRight fr">
        <div class="reOderInfo">
    <ul>
        <li><label>订单编号：</label><span class="yahei fs14 fcBlue">${orderId!}</span></li>
        <li><label>成交时间：</label><span class="yahei fs14">${orderDealTime!}</span></li>
        <li><label>商品价格：</label><span class="yahei fs14">&yen;<em class="fwb">${orderGoodsPrice!}</em></span></li>
        <li><label>快递费：</label><span class="yahei fs14">&yen;<em class="fwb">${orderExpressPrice!}</em></span></li>
        <li><label>服务费：</label><span class="yahei fs14">&yen;<em class="fwb">${orderServicePrice!}</em></span></li>
        <li><label>订单总额：</label><span class="yahei fs14">&yen;<em class="fwb">${orderTotalPrice!}</em></span></li>
    </ul>
</div>



    </div>
</div>


<script>
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var express = '${expressList!}';
</script>









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







