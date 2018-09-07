<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户表 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="${daifa_host}/css/table.css" rel="stylesheet">
<!--<link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">-->
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/sys/common/common.js?t=201709121011"></script>
    <script src="${daifa_host}/js/admin/sys/worker/worker.js?t=201709121011"></script>
    <style>
        .ptitle{
            width: 100px;
            display: inline-block;
            text-align: right;
            margin-top: 20px;
        }
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
                <li><label>用户名：</label><input type="text" class="fmInput" name="userName" <#if query.userName??> value="${query.userName!}" </#if> ></li>
                <li><label>登录名：</label><input type="text" class="fmInput" name="daifaWorker" <#if query.daifaWorker??> value="${query.daifaWorker!}" </#if> ></li>
                <li><label>手机号：</label><input type="text" class="fmInput" name="phone" <#if query.phone??> value="${query.phone!}" </#if>></li>
                <li><label>sellerId：</label><input type="text" class="fmInput" name="daifaSellerId" <#if query.daifaSellerId??> value="${query.daifaSellerId!}" </#if>></li>
                <li><label>可用状态：</label>
                    <input type="text" class="fmInput" name="useStatus" <#if query.useStatus??> value="${query.useStatus!}" </#if>>
                </li>
                <li><label>用户类型：</label>
                    <input type="text" class="fmInput" name="workType" <#if query.workType??> value="${query.workType!}" </#if>>
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

    <#assign text>{"fields":[{"name":"userName","value":"${query.userName!}"},{"name":"daifaWorker","value":"${query.daifaWorker!}"},{"name":"phone","value":"${query.phone!}"},{"name":"daifaSellerId","value":"${query.daifaSellerId!}"},{"name":"useStatus","value":"${query.useStatus!}"},{"name":"workType","value":"${query.workType!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="添加" onclick="addWorker()">
        </div>


        <div class="orderCon">
            <div class="theadCon">
                <ul class="">

                    <li class="tddiv">用户名</li>
                    <li class="tddiv">登录名</li>
                    <li class="tddiv">代发机构ID</li>
                    <li class="tddiv">手机号</li>
                    <li class="tddiv">用户类型</li>
                    <li class="tddiv">可用性</li>
                    <li class="tddiv">支付宝账户</li>
                    <li class="tddiv">角色ID</li>
                    <li class="tddiv" style="width:12%;">操作</li>
                </ul>
            </div>
        <#list lists as list>
            <div class="orderItem">
            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="tddiv"><p>${list.userName!}</p></li>
                    <li class="tddiv">
                        <p class="title">${list.daifaWorker!}</p>
                    </li>

                    <li class="tddiv"><p>${list.daifaSellerId!}</p></li>
                    <li class="tddiv"><p>${list.phone!}</p></li>
                    <li class="tddiv"><p>${list.workType!}</p></li>
                    <li class="tddiv">
                        <#if list.useStatus == 0>
                            <p class="fc3">不可用</p>
                        <#elseif list.useStatus == 1>
                            <p>可用</p>
                        </#if>
                    </li>
                    <li class="tddiv"><p>${list.payBaoAccount!}</p></li>


                    <li class="tddiv">
                            <p class="fc3">${list.remark2!}</p>
                    </li>

                    <li class="tddiv">
                       <input type="button" name="refundfax" id="refundfax" class="fmButton fmButton-blue" value="修改" onclick="editWorker(this,'${list.daifaWorkerId!}','${list.password!}')">
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