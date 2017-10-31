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
    <script src="${daifa_host}/js/admin/orderSendErrorDeal/orderSendErrorDeal.js?t=201709121011"></script>
    <style>
        .ptitle{
            width: 100px;
            display: inline-block;
            text-align: right;
            margin-top: 20px;
        }
        .orderCon .tddiv{width:13%;}
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
                <li><label>主订单ID：</label><input type="text" class="fmInput" name="dfTradeId" <#if query.dfTradeId??> value="${query.dfTradeId!}" </#if> ></li>
                <li><label>手机：</label><input type="text" class="fmInput" name="phone" <#if query.telephone??> value="${query.phone!}" </#if>></li>
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

    <#assign text>{"fields":[{"name":"dfTradeId","value":"${query.dfTradeId!}"},{"name":"phone","value":"${query.phone!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
                    <li class="tddiv" style="width: 22%">1代发编号</li>
                    <li class="tddiv">订单编号</li>
                    <li class="tddiv">收货人</li>
                    <li class="tddiv">收件人地址</li>
                    <li class="tddiv">快递名</li>
                    <li class="tddiv">订单状态</li>
                    <li class="tddiv">操作</li>
                </ul>
            </div>
        <#list orders as order>
            <div class="orderItem">


            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="tddiv">${order.dfTradeId!}</li>
                    <li class="tddiv">${order.tradeCode!}</li>
                    <li class="tddiv"><input type="text" id="receiverNames" name="receiverNames" value="${order.receiverName!}" class="fmInput"/></li>
                    <li class="tddiv"><input type="text" id="receiverAddrs" name="receiverAddrs" value="${order.receiverAddress!}" style="width:400px" class="fmInput"/></li>
                    <li class="tddiv">${order.expressName!}</li>
                    <li class="tddiv">${order.tradeStatus!}</li>
                    <li class="tddiv"><input type="button" id="deal" name="deal" value="修改完提交" onclick="editAddr(this,'${order.dfTradeId!}')" class="fmButton fmButton-blue"/></li>
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