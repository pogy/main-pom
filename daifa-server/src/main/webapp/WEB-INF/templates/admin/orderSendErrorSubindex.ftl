<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>订单发货错误 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/sys/common/common.js?t=201709121011"></script>
    <script src="${daifa_host}/js/admin/orderSendErrorDeal/orderSendErrorSub.js?t=201709121011"></script>
    <style>

        .orderCon .tddiv{width:11%;}
    </style>
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
                <li><label>主订单ID：</label><input type="text" class="fmInput" name="dfTradeId" <#if query.dfTradeId??> value="${query.dfTradeId!}" </#if> ></li>

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

    <#assign text>{"fields":[{"name":"dfTradeId","value":"${query.dfTradeId!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
                    <li class="tddiv">主订单号|子订单号</li>
                    <li class="tddiv">标题</li>
                    <li class="tddiv">市场-楼层-档口-货号</li>
                    <li class="tddiv">商品属性</li>
                    <li class="tddiv">货号</li>
                    <li class="tddiv">商家编码</li>
                    <li class="tddiv">数量</li>
                    <li class="tddiv">订单状态</li>
                    <li class="tddiv">操作</li>
                </ul>
            </div>
        <#list orders as order>
            <div class="orderItem">


            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="tddiv">${order.dfTradeId!}|<br>${order.dfOrderId!}</li>
                    <li class="tddiv">${order.title!}</li>
                    <li class="tddiv">${order.marketName!}-${order.floorName!}-${order.storeNum!}-${order.goodsCode!}</li>
                    <li class="tddiv"><input type="text" id="propStr" name="propStr" value="${order.propStr!}" style="width:200px" class="fmInput"/></li>
                    <li class="tddiv"><input type="text" id="goodsCode" name="goodsCode" value="${order.goodsCode!}" style="width:200px" class="fmInput"/></li>
                    <li class="tddiv"><input type="text" id="storeGoodsCode" name="storeGoodsCode" value="${order.storeGoodsCode!}" style="width:200px" class="fmInput"/></li>
                    <li class="tddiv">${order.goodsNum!}</li>
                    <li class="tddiv">${order.orderStatus!}</li>
                    <li class="tddiv"><input type="button" id="deal" name="deal" value="修改完提交" onclick="editProp(this,'${order.dfOrderId!}')" class="fmButton fmButton-blue"/></li>
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