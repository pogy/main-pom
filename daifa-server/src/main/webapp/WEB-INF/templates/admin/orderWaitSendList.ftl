<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>待发表显示处理 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="${daifa_host}/css/table.css" rel="stylesheet">
<!--<link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">-->
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/sys/common/common.js?t=201709121011"></script>
    <script src="${daifa_host}/js/admin/sys/waitsend/waitsend.js?t=201709121011"></script>
    <style>
        .ptitle{
            width: 100px;
            display: inline-block;
            text-align: right;
        }
        .orderCon .tddiv{width:10%;}
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
                <li><label>交易号：</label><input type="text" class="fmInput" name="dfTradeId" <#if query.dfTradeId??> value="${query.dfTradeId!}" </#if> ></li>
                <li><label>收货人：</label><input type="text" class="fmInput" name="receiverName" <#if query.receiverName??> value="${query.receiverName!}" </#if>></li>
                <li>
                    <label>拿货人：</label><select class="fmInput" name="orderDisplay" <#if query.orderDisplay??> value="${query.orderDisplay!}" </#if>>
                    <option value="-1">请选择</option>
                <#if query.orderDisplay == 0>
                    <option value="0" selected>不显示</option>
                    <option value="1">显示</option>
                <#elseif query.orderDisplay == 1>
                    <option value="0">不显示</option>
                    <option value="1" selected>显示</option>
                <#elseif query.orderDisplay == -1>
                    <option value="0">不显示</option>
                    <option value="1" >显示</option>

                </#if>

                </select>
                </li>

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

    <#assign text>{"fields":[{"name":"dfTradeId","value":"${query.dfTradeId!}"},{"name":"orderDisplay","value":"${query.orderDisplay!}"},{"name":"receiverName","value":"${query.receiverName!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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

        <div class="orderSearch orderSearchBox">

        </div>


        <div class="orderCon">
            <div class="theadCon">
                <ul class="">

                    <li class="tddiv">订单号</li>
                    <li class="tddiv">代发机构ID</li>
                    <li class="tddiv">发货状态</li>
                    <li class="tddiv">创建时间</li>
                    <li class="tddiv">快递名</li>
                    <li class="tddiv">收件人手机号</li>
                    <li class="tddiv">是否显示</li>
                    <li class="tddiv">收件人姓名</li>
                    <li class="tddiv">收件人详细地址</li>

                    <li class="tddiv">操作</li>
                </ul>
            </div>
        <#list lists as list>
            <div class="orderItem">
            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="tddiv"><p>${list.dfTradeId!}|${list.tradeCode!}</p></li>
                    <li class="tddiv">
                        <p class="title">${list.sellerId!}</p>
                    </li>
                    <li class="tddiv">
                        <#if list.sendStatus == 1>
                            <p class="fc3">待发货</p>
                        <#elseif list.sendStatus == 2>
                            <p>已发货</p>
                        </#if>
                    </li>
                    <li class="tddiv"><p>${list.createTime!}</p></li>
                    <li class="tddiv"><p>${list.expressName!}</p></li>
                    <li class="tddiv"><p>${list.receiverPhone!}</p></li>
                    <li class="tddiv">

                        <#if list.orderDisplay == 0>
                            <p class="fc3">不显示</p>
                        <#elseif list.orderDisplay == 1>
                            <p>显示</p>
                        </#if>
                    </li>


                    <li class="tddiv">
                            <p class="fc3">${list.receiverName!}</p>
                    </li>
                    <li class="tddiv"><p>${list.receiverAddress!}</p></li>

                    <li class="tddiv">
                        <#if list.orderDisplay == 0>
                            <input type="button" name="refundfax1" id="refundfax1" class="fmButton fmButton-blue" value="显示" onclick="editDisplay(this,'${list.dfTradeId!}',1)">
                        <#elseif list.orderDisplay == 1>
                            <input type="button" name="refundfax" id="refundfax" class="fmButton fmButton-blue" value="不显示" onclick="editDisplay(this,'${list.dfTradeId!}',0)">
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