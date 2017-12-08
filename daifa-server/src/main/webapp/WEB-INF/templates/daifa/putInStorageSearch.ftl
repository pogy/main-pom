<#assign $pageid>putInStorageSearch</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>入库查询 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__putInStorageSearch_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__putInStorageSearch_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="pageTabs">
    <ul>
        <li ><a href="allInventory.htm">全部库存</a></li>
        <li class="select"><a href="putInStorageSearch.htm">入库查询</a></li>
        <li ><a href="outboundSearch.htm">出库查询</a></li>
    </ul>
</div>
<div class="orderSearch">
    <ul>
        <li><label>入库日期查询：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         searchBtn"
        jbtn="searchBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
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
    </button>
    </#if>
</#list></li>
        <li class="fc6">共计商品：<span class="fs20 fc3">${allChildOrderNum!} </span>件</li>
        <li class="fc6">对应商品金额：<span class="fs20 fc3">${allChildOrderGoodsMoney!} </span>元</li>
    </ul>
</div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="orderCon">
    <table>
        <thead class="theadCon">
            <tr class="">
                <td class="childOrderId">子订单ID</td>
                <td class="goodsInfo">商品货号</td>
                <td class="price">商品金额</td>
                <td class="time">入库时间</td>
                <td class="opeName">操作员</td>
                <td class="remark">备注</td>
            </tr>
        </thead>
        <tbody class="childOrderItem">
            <#list childOrders as childOrder>
            <tr class="" data-childorderid="${childOrder.childOrderId!}">
                <td class="childOrderId">
                    ${childOrder.childOrderId!}
                </td>
                <td class="goodsInfo">
                    <span>${childOrder.goodsNo!}</span>
                    <span>${childOrder.goodsProperty!}</span>
                </td>
                <td class="price">
                    <span>${childOrder.piPrice!}</span>
                </td>
                <td class="time">
                    ${childOrder.putInTime!}
                </td>
                <td class="opeName">
                    ${childOrder.opeName!}
                </td>
                <td class="remark">
                    ${childOrder.remark}
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    </div>
</div>