<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>要退货的订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/orderRefund/orderRefund.js?t=201709121011"></script>

</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
    <#if userIcon??>
        <img src="${userIcon!}">
    <#else>
        <img src="http://style.571xz.com/v2/dfgl/css/img/headImg.jpg">
    </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="${daifa_host!}init/logout.htm" class="fcF40 fs16">退出</a>
    </div>
</div>

<div class="mainContent">
    <div class="sideBarBox">

    <#include "/admin/common/menu_admin.ftl">

    </div>
    <div class="contentBox">

        <div class="statistics yahei fc9">

        </div>



        <div class="orderSearch orderSearchBox">
            <ul>
                <li><label>主订单号：</label><input type="text" class="fmInput" name="dfTradeId" <#if query.dfTradeId??> value="${query.dfTradeId!}" </#if> ></li>
                <li><label>子订单号：</label><input type="text" class="fmInput" name="suborderId" <#if query.suborderId??> value="${query.suborderId!}" </#if>></li>
                <li>

                <#assign text>{}</#assign>
                <#assign moduledata0=text?eval />
                <#list [moduledata0] as $it>

                    <#if $it.href??>
                        <a href="${$it.href!}"
                    <#else>
                            <b
                    </#if>
             class="fmButton fmButton-blue searchBtn" jbtn="searchBtn"
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

    <#assign text>{"fields":[{"name":"dfTradeId","value":"${query.dfTradeId!}"},{"name":"suborderId","value":"${query.suborderId!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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




        <div class="orderCon">
            <div class="theadCon">
                <ul class="">
                    <li class="childOrderId" style="width: 16%">订单编号</li>
                    <li class="goodsInfo">商品信息</li>

                    <li class="childOrderId">子单号</li>
                    <li class="remark">批发价</li>

                    <li class="orderState">状态</li>
                    <li class="orderState">是否下架</li>
                    <li class="tradeState" style="width: 12%">操作</li>
                </ul>
            </div>
        <#list orders as order>
            <div class="orderItem">


            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="childOrderId" style="width: 16%"><p>代发订单号：<br>${order.dfTradeId!}</p><p>订单号：${order.tradeCode!}<p></li>
                    <li class="goodsInfo">
                        <div class="fl imgBox">
                            <img src="${order.picPath!}_80x80.jpg" alt width="54" height="54">
                        </div>
                        <p class="title">${order.title!}</p>
                        <p>商品属性：${order.propStr!}</p>
                        <p>商家编码：${order.storeGoodsCode!}</p>
                        <p>${order.marketName!}|${order.floorName!}|${order.storeNum!}</p>
                    </li>

                    <li class="childOrderId"><p>代发子单号:${order.dfOrderId!}</p><p>子订单号:${order.orderCode!}</p><p>折单号:${order.orderPartitionId!}</p></li>
                    <li class="remark">${order.singlePiPrice!}</li>
                    <li class="orderState">
                    <#if order.allocatStatus == 0>
                        <p class="fc3">未分配</p>
                    <#elseif order.allocatStatus == 1>
                        <p>已分配</p>
                    </#if>

                        <#if order.takeGoodsStatus == 1>
                            <p class="fc3">已拿</p>
                        <#elseif order.takeGoodsStatus == 2>
                            <p>缺货</p>
                        </#if>

                        <#if order.refundStatus == 1>
                            <p class="fc3">等待退款</p>
                            <p class="fc3">退款ID:${order.refundId!}</p>
                        <#elseif order.refundStatus == 2>
                            <p>已退款</p>
                            <p >退款ID:${order.refundId!}</p>
                        </#if>
                    </li>

                    <li class="orderState">
                        <#if order.delistIs == 0>
                            <p class="fc3">可售</p>
                        <#elseif order.delistIs == 1>
                            <p>下架</p>
                        </#if>

                    </li>

                    <li class="tradeState">
                            要自己判断<br>
                                <#if order.refundId??>
                                    <input type="button" name="refundfax" id="refundfax" class="fmButton fmButton-blue" value="退款" onclick="refunddeal('${order.dfTradeId!}','${order.dfOrderId!}','${order.refundId!}')">
                                <#else>

                                </#if>

                    </li>
                </ul>
            </div>



            </div>
        </#list>
        </div>
    <#assign text>{}</#assign>
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

        <!--分页-->
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
<!--省略end，让浏览器自动添加-->