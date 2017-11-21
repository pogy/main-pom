
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>售后管理 - 分销商中心 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">











    
    <link href="http://style.571xz.com/v2/fxsV1/css/shManaOrderv1.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/fxsV1/js/shManaOrderv1.js"></script>
    
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






<div class="header">
    <div class="layout">
        <a href="http://www.571xz.com" class="fl">
            <img src="http://style.571xz.com/v2/xz/css/img/whiteLogo.png" width="168" height="28" />
        </a>
        <ul class="fl fs16 yahei clearfix">
            <li><a href="${main_host!}member/index.htm"  >首页</a></li>
            <li><a href="${main_host!}member/userBalance.htm" >我的钱包</a></li>
            <li><a href="${main_host!}member/sysSetsindex.htm" >安全中心</a></li>
        </ul>
    </div>
</div>


<div class="wrapper">
    <div class="layout">
        <div class="leftSidebar yahei">

    <h2>交易管理</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}order/myOrder.htm" >我的订单</a></li>
            
        
        
    
        
        
            
            <li><a href="${main_host!}order/myTbOrder.htm" target="_blank">淘宝订单</a></li>
            
        
        
    
        
        
            
            <li><a class="selected" href="${main_host!}order/shManaOrder.htm">售后管理</a></li> 
            
        
        
    
        
        <#if session_user_redis__.otherPlatform.__moreOrder__>
        
        
            
            <li><a href="${main_host!}order/myBatchTbOrder.htm" target="_blank">批量操作</a></li>
            
        
        
        </#if>
        
    
    </ul> 

    <h2>商品管理</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm" >已上传的商品</a></li>
            
        
        
    
        
        
            
            <li><a href="${main_host!}member/goodsCollectinit.htm" >我的数据包</a></li>
            
        
        
    
        
        
            
            <li><a href="${main_host!}member/storeCollectinit.htm" >我的收藏</a></li>
            
        
        
    
    </ul> 

    <h2>供应商申请</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/storeIn.htm" >店铺申请</a></li>
            
        
        
    
    </ul> 

    <h2>会员俱乐部</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/awardInfo.htm" >开奖结果</a></li>
            
        
        
    
    </ul> 

</div>




        

<#assign text>{"fields":[{"name":"shStatus","value":"${query.shStatus!}"}]}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
        <#if field.timeFormat??>
            <#if field.value??>
            <input type=hidden name="${field.name!}" value="${field.value?string(field.timeFormat)}">
            <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
            </#if>
        <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
        </#if>
    </#list>
</form>
</#if>





</#list>



<div class="rightBox fr">
    <div class="tabBox clearfix yahei">
    <ul>
        <li <#if !query.shStatus>class="select"</#if>><a href="shManaOrder.htm">所有订单</a></li>
        <li <#if query.shStatus == "1">class="select"</#if>><a href="shManaOrder.htm?shStatus=1">退款</a></li>
        <li <#if query.shStatus == "2">class="select"</#if>><a href="shManaOrder.htm?shStatus=2">换货</a></li>
    </ul>
</div>


    
    <div class="orderDetail">
    <div class="listHead clearfix">
        <ul>
            <li class="goods goodsHead">商品</li>
            <li class="price">单价</li>
            <li class="num">数量</li>
            <li class="opera">商品操作</li>
            <li class="payMoney">实付款(元)</li>
            <li class="orderState">交易状态</li>
        </ul>
    </div>
    <#if (orders?size) gt 0>
        <#list orders as order>
        <div class="orderItem clearfix <#if order.mainState == 4>finish</#if>">
            <div class="orderHead fl">
                <span class="fc6">订单编号：${order.orderId!}</span>
                <span class="fc6">成交时间：${order.tradeTime!}</span>
                <b class="fr delete" jbtn="deleteBtn" data-id="${order.orderId!}"></b>
            </div>
            <div class="childOrderList fl">
                <#list order.childOrders as childOrder>
                <ul class="childOrderItem <#if childOrder_index == (order.childOrders?size) - 1>lastChildOrder</#if> clearfix">
    <li class="goods goodsDetail">
        <div class="imgBox fl">
            <img src="${childOrder.imgsrc!}_80x80.jpg" width="80" height="80">
        </div>
        <div class="goodsCon">
            <a href="http://${order.webSite!}.571xz.com/item.htm?id=${childOrder.goodsId!}" target="_blank" class="goodsTitle" title="${childOrder.title!}">${childOrder.title!}</a>
            <p class="goodsSku fc9">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="price yahei">&yen;${childOrder.price!}</li>
    <li class="num">
        ${childOrder.num!}
        <#if childOrder.stockoutNum??>
        <div class="pr stockoutNum">
            <p class="fcF40"><i class="icon-c-warn"></i>缺货 x${childOrder.stockoutNum!}</p>
            <#if childOrder.haveGoodsTime??>
            <div class="pa haveGoodsTime">
                ${childOrder.haveGoodsTime!} 有货
            </div>
            </#if>
        </div>
        </#if>
    </li>
    <li class="opera">
        <#if order.mainState == 3 || order.mainState == 4>
            <#if childOrder.afterSales?? && (childOrder.afterSales?size) gt 0>
                <#if childOrder.refundCount != childOrder.num && childOrder.hasAfter == false && order.mainState == 3>
                <p><a href="returnOrChange.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                </#if>
                
                <#list childOrder.afterSales as afterSale>
                    <#if afterSale.type == 1>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">申请退款成功 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 2>
                        <#if afterSale.state == 2>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank">退货退款完成x${afterSale.afterSaleNum!}</a></p>
                        <#elseif afterSale.state == 1>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" data-id="${afterSale.refundId!}" jbtn="afterSaleBtn" target="_blank">售后处理中<#if afterSale.newAfterSaleInfoIs == true><i class="afterSaleDot"></i></#if></a></p>
                            <#list afterSale.afterSaling as after>
                                <#if after.type == 1>
                                <p class="fc6">售后已同意</p>
                                <#elseif after.type == 2>
                                <p class="fc6">售后已发货</p>
                                <#elseif after.type == 3>
                                <p class="fc6">档口退款失败 x${after.opeAfterSaleNum!}</p>
                                <#elseif after.type == 4>
                                <p class="fc6">档口已退款 x${after.opeAfterSaleNum!}</p>
                                <#elseif after.type == 5>
                                <p class="fc6">退款金额已更改</p>
                                </#if>
                            </#list>
                        <#elseif afterSale.state == 3>
                        <div class="refuseAfterSale pr">
                            <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank"><i class="icon-c-warn"></i>退货申请已拒绝</a></p>
                            <div class="pa refuseReason fc6">
                                ${afterSale.refuseReason!}
                            </div>
                        </div>
                        <#elseif afterSale.state == 4>
                        <p><a class="fcF40" href="refund.htm?refundId=${afterSale.refundId!}" target="_blank">档口退货失败</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 3>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="exchange.htm?refundId=${afterSale.refundId!}" target="_blank">换货完成</a></p>
                        <#elseif afterSale.state == 1>
                        <p><a class="fcF40" href="exchange.htm?refundId=${afterSale.refundId!}" data-id="${afterSale.refundId!}" jbtn="afterSaleBtn" target="_blank">售后处理中<#if afterSale.newAfterSaleInfoIs == true><i class="afterSaleDot"></i></#if></a></p>
                            <#list afterSale.afterSaling as after>
                                <#if after.type == 1>
                                <p class="fc6">售后已同意</p>
                                <#elseif after.type == 2>
                                <p class="fc6">售后已发货</p>
                                </#if>
                            </#list>
                        <#elseif afterSale.state == 3>
                        <div class="refuseAfterSale pr">
                            <p><a class="fcF40" href="exchange.htm?refundId=${afterSale.refundId!}" target="_blank"><i class="icon-c-warn"></i>换货申请已拒绝</a></p>
                            <div class="pa refuseReason fc6">
                                ${afterSale.refuseReason!}
                            </div>
                        </div>
                        </#if>
                    </#if>
                    <#if afterSale.type == 4>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">自动退款 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                    <#if afterSale.type == 5>
                        <#if afterSale.state == 2>
                        <p><a class="fcBlue" href="onlyRefund.htm?refundId=${afterSale.refundId!}" target="_blank">自动退款 x${afterSale.afterSaleNum!}</a></p>
                        </#if>
                    </#if>
                </#list>
            <#else>
                <#if order.mainState == 3>
                <p><a href="returnOrChange.htm?childOrderId=${childOrder.childOrderId!}" target="_blank" class="fc9">申请售后</a></p>
                <#elseif order.mainState == 4>
                ——
                </#if>
            </#if>
        </#if>
        
    </li>
    <li class="payMoney">
        <#if childOrder_index == 0>
        <p class="totalPay fs16">${order.tradePay!}</p>
        <p class="fc9">含快递费：${order.postPay!}</p>
        <p class="fc9">含服务费：${order.serverPay!}</p>
            <#if order.isTbOrder == true>
            <i class="tbOrderIcon"></i>
            </#if>
        </#if>
    </li>
    <li class="orderState">
        <#if childOrder_index == 0>
            <#if order.mainState == 3>
            <p>已发货</p>
            <#elseif order.mainState == 4>
            <p>交易完成</p>
            </#if>
            <p><a href="${main_host!}order/orderDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">订单详情</a></p>
            <#if order.mainState == 3>
            <p><a href="${main_host!}order/expressDetail.htm?orderId=${order.orderId!}" target="_blank" class="fc9">查看物流</a></p>
            </#if>
        </#if>
    </li>
</ul>








                </#list>
            </div>
        </div>
        </#list>
    <#else>
        <p class="fs20 fc6 tac noOrder">暂无订单！</p>
    </#if>
    
    

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

<div class="jqPagination " id="jqPagination0" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>







</#list>

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




