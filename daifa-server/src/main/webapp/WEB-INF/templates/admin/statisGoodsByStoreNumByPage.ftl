<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>按档口统计商品表 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">

    <link href="${daifa_host}/css/table.css" rel="stylesheet">
<!--<link href="http://style.571xz.com/v2/dfgl/css/orderAll.css" rel="stylesheet">-->
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/laydate/laydate.js"></script>
    <script src="${daifa_host}/js/admin/sys/common/common.js?t=201709121011"></script>
    <script src="${daifa_host}/js/admin/sys/statisGoods/statisGoodsbyStoreNum.js?t=201711071011"></script>
    <style>
        .ptitle{
            width: 100px;
            display: inline-block;
            text-align: right;
        }
        .orderCon .tddiv{width:20%;}
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


                <li><label>拿货状态：</label>
                    <select class="fmInput" name="takeGoodsStatus" <#if query.takeGoodsStatus??> value="${query.takeGoodsStatus!}" </#if>>
                        <option value="-1">请选择</option>
                    <#if query.takeGoodsStatus == 0>
                        <option value="0" selected>全部</option>
                        <option value="1">已拿</option>
                    <#elseif query.takeGoodsStatus == 1>
                        <option value="0">全部</option>
                        <option value="1" selected>已拿</option>
                    <#elseif query.takeGoodsStatus == -1>
                        <option value="0">全部</option>
                        <option value="1" >已拿</option>

                    </#if>

                    </select>
                </li>

                <li><label>创建日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
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

    <#assign text>{"fields":[{"name":"takeGoodsStatus","value":"${query.takeGoodsStatus!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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


                    <li class="tddiv">市场名</li>
                    <li class="tddiv">楼层名</li>
                    <li class="tddiv">店铺ID</li>
                    <li class="tddiv">档口号</li>

                    <li class="tddiv">数量</li>

                </ul>
            </div>
        <#list lists as list>
            <div class="orderItem">
            <div class="childOrderItem" >
                <ul class="clearfix">

                    <li class="tddiv"><p>${list.marketName!}</p></li>
                    <li class="tddiv">
                        <p class="title">${list.floorName!}</p>
                    </li>

                    <li class="tddiv"><p>${list.storeId!}</p></li>

                    <li class="tddiv"><p>${list.storeNum!}</p></li>
                    <li class="tddiv"><p>${list.goodsNum!}</p></li>


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