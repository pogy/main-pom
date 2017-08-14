<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>全部订单 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
    
    <link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">
    

    

    

    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
            <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
        
    
    <script src="http://style.571xz.com/v2/dfgl/js/orderAll.js"></script>
</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if (userIcon?size) gt 0>
        <img src="${userIcon!}">
        <#else>
        <img src="${$stylepath!}${$projectid!}/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="#" class="fcF40 fs16">退出</a>
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
        <div class="sidebar fl yahei">
    <ul>
        
            <li>
                
                <a class="current"  href="orderAll.htm" ><i class="icon-allorders"></i>全部订单</a>
                
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="orderAllocation.htm"><i></i>任务分配</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="orderHasAllocation.htm"><i></i>我的任务</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="scanBarCode.htm"><i></i>扫描打印</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
    </ul>
</div>




    </div>
    <div class="contentBox">
        <div class="statistics yahei fc9">
    <ul>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.totalNumber!}</span>
            <p>今日总订单（单）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.totalMoney!}</span>
            <p>今日订单总额（元）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.sendNumber!}</span>
            <p>今日发货商品（件）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.sendMoney!}</span>
            <p>今日发货金额（元）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.stockoutNumber!}</span>
            <p>今日缺货（件）</p>
        </li>
    </ul>
</div>



















<div class="orderSearch orderSearchBox">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>手机：</label><input type="text" class="fmInput" name="telephone" <#if query.telephone??> value="${query.telephone!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-blue
         searchBtn"
    
        jbtn="searchBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        搜索
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






</#list>
</li>
    </ul>
</div>













<#assign text>{"fields":[{"name":"orderId","value":"${query.orderId!}"},{"name":"telephone","value":"${query.telephone!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>





</#list>





<div class="orderCon">
    <div class="theadCon">
        <ul class="">
            <li class="childOrderId">子订单ID</li>
            <li class="goodsInfo">商品信息</li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="otherFee">其他费用</li>
            <li class="orderState">订单状态</li>
            <li class="remark">备注</li>
            <li class="tradeState">交易状态</li>
        </ul>
    </div>
    <#list orders as order>
    <div class="orderItem">
        <div class="orderItemHead">
            <div class="leftConBox fl">
                <span>订单编号：${order.orderId!}</span>
                <span>时间：${order.tradeTime!}</span>
                <span>阿里旺旺：<a href="http://www.taobao.com/webww/ww.php?ver=3&touid=${order.imWw!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank" class="fcBlue">${order.imWw!}</a></span>
            </div>
            <div class="rightConBox fr">
                <span class="fl">${order.receiverName!}（${order.receiverPhone!}）</span>
                <#if order.buyerRemark??>
                <div class="pr fl buyerRemark">
                    <i class="icon-s-message iconfont haveRemark"></i>
                    <div class="remarkCon">
                        ${order.buyerRemark!}
                    </div>
                </div>
                </#if>
                <span class="fl">总费用：${order.totalFee!}（含快递：${order.expressFee!}，服务费：${order.serversFee!}，减免：${order.discountFee!}）</span>
            </div>
        </div>
        <#list order.childOrders as childOrder>
        <div class="childOrderItem" data-id="${childOrder.childOrderId!}">
    <ul class="clearfix">
        <li class="childOrderId">${childOrder.childOrderId!}</li>
        <li class="goodsInfo">
            <div class="fl imgBox">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width=54 height=54>
            </div>
            <p class="title">${childOrder.title!}</p>
            <p>商品属性：${childOrder.goodsProperty!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </li>
        <li class="price">
            <p>批价：${childOrder.piPrice!}</p>
            <#if childOrder.payPrice??>
            <p>实价：${childOrder.payPrice!}</p>
            <#else>
            <p>实价：——</p>
            </#if>
        </li>
        <li class="goodsNum">${childOrder.num!}</li>
        <li class="otherFee">
            <p>服务费：${childOrder.childServersFee!}</p>
        </li>
        <li class="orderState">
            <#if order.tradeState == 1>
                <#if childOrder.allotState == 1>
                <p class="fc3">未分配</p>
                <#else>
                <p>已分配</p>
                </#if>
                
                <#if childOrder.takeGoodsState == 1>
                <p>已拿到</p>
                <#elseif childOrder.takeGoodsState == 2>
                <p class="fcF40">缺货</p>
                </#if>
                
            <#elseif order.tradeState == 2>
                <#if childOrder.afterSaleState == 1>
                <p>已拿货</p>
                <#elseif childOrder.afterSaleState == 2>
                <p>申请退货</p>
                <#elseif childOrder.afterSaleState == 3>
                <p>已受理退货</p>
                <#elseif childOrder.afterSaleState == 4>
                <p>退货完成</p>
                <#elseif childOrder.afterSaleState == 5>
                <p>拒绝退货申请</p>
                <#elseif childOrder.afterSaleState == 6>
                <p>申请换货</p>
                <#elseif childOrder.afterSaleState == 7>
                <p>已受理换货</p>
                <#elseif childOrder.afterSaleState == 8>
                <p>换货完成</p>
                <#elseif childOrder.afterSaleState == 9>
                <p>拒绝换货申请</p>
                </#if>
            </#if>
        </li>
        <li class="remark">
            <#if childOrder.haveGoodsTime??>
            <p>${childOrder.haveGoodsTime!} 有货</p>
            </#if>
            <p><b class="fcBlue" jbtn="setTime">设置有货时间</b></p>
            <#if childOrder.isNoSale == true>
            <p><span class="fcF40">已标记下架</span></p>
            <#else>
            <p><b class="fcBlue" jbtn="noSale">标记下架</b></p>
            </#if>
            <div class="childOrderRemark pr">
                <i class="icon-s-message iconfont <#if childOrder.childRemark??>haveRemark</#if>"></i>
                <div class="remarkCon pa">
                    <#if childOrder.childRemark??>
                    ${childOrder.childRemark!}
                    </#if>
                    <p><b class="addChildRemark" jbtn="addChildRemark">添加备注</b></p>
                </div>
            </div>
        </li>
        <li class="tradeState">
            <#if childOrder_index == 0>
                <#if order.tradeState == 1>
                <p>未发货</p>
                <#elseif order.tradeState == 2>
                <p>已发货</p>
                </#if>
                <p>${order.expressName!}</p>
                <#if order.tradeState == 2>
                    <p>（${order.expressCode!}）</p>
                </#if>
            </#if>
        </li>
    </ul>
</div>


        </#list>
    </div>
    </#list>
    

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
<!--省略end，让浏览器自动添加-->



