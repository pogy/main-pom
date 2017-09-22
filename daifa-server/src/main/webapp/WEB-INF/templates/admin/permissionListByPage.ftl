<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>权限表 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="${daifa_host}/css/table.css" rel="stylesheet">
<!--<link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">-->
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/sys/common/common.js?t=201709121011"></script>
    <script src="${daifa_host}/js/admin/sys/permission/permission.js?t=201709121011"></script>
    <style>
        .ptitle{
            width: 100px;
            display: inline-block;
            text-align: right;
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
                <li><label>namespace：</label><input type="text" class="fmInput" name="namespace" <#if query.namespace??> value="${query.namespace!}" </#if> ></li>
                <li><label>权限标签：</label><input type="text" class="fmInput" name="permissionTag" <#if query.permissionTag??> value="${query.permissionTag!}" </#if>></li>
                <li><label>sellerId：</label><input type="text" class="fmInput" name="createUserId" <#if query.createUserId??> value="${query.createUserId!}" </#if>></li>
                <li><label>可用状态：</label>
                    <input type="text" class="fmInput" name="status" <#if query.status??> value="${query.status!}" </#if>>
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

    <#assign text>{"fields":[{"name":"namespace","value":"${query.namespace!}"},{"name":"permissionTag","value":"${query.permissionTag!}"},{"name":"status","value":"${query.status!}"},{"name":"createUserId","value":"${query.createUserId!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="添加" onclick="addRecord()">
        </div>


        <div class="orderCon">
            <div class="theadCon">
                <ul class="">

                    <li class="tddiv">namespace</li>
                    <li class="tddiv">权限标签</li>
                    <li class="tddiv">代发机构ID</li>
                    <li class="tddiv">可用性</li>
                    <li class="tddiv">权限备注</li>
                    <li class="tddiv">父权限标签</li>
                    <li class="tddiv">创建时间</li>
                    <li class="tddiv">操作</li>
                </ul>
            </div>
        <#list list as order>
            <div class="orderItem">
            <div class="childOrderItem" >
                <ul class="clearfix">
                    <li class="tddiv"><p>${order.namespace!}</p></li>
                    <li class="tddiv">
                        <p class="title">${order.permissionTag!}</p>
                    </li>

                    <li class="tddiv"><p>${order.createUserId!}</p></li>
                    <li class="tddiv">
                        <#if order.status == 0>
                            <p class="fc3">不可用</p>
                        <#elseif order.status == 1>
                            <p>可用</p>
                        </#if>
                    </li>
                    <li class="tddiv"><p>${order.permissionComment!}</p></li>
                    <li class="tddiv"><p>${order.parentPid!}</p></li>

                    <li class="tddiv">
                            <p class="fc3">${order.createTime!}</p>
                    </li>

                    <li class="tddiv">
                       <input type="button" name="refundfax" id="refundfax" class="fmButton fmButton-blue" value="修改" onclick="editRecord(this,'${order.permissionId!}')">
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