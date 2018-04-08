<#assign $pageid>allInventory</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>全部库存 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__allInventory_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__allInventory_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"childOrderId","value":""+query.childOrderId},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
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
        <li class="select"><a href="allInventory.htm">全部库存</a></li>
        <li ><a href="putInStorageSearch.htm">入库查询</a></li>
        <li ><a href="outboundSearch.htm">出库查询</a></li>
    </ul>
</div>
<div class="statistics yahei fc9">
    <ul>
        <li>
            <span class="fs20 arail fc3">${inventory.allInventoryNum!}</span>
            <p>当前库存总数（件）</p>
        </li>
        <li>
            <a href="putInStorageSearch.htm">
                <span class="fs20 arail fc3">${inventory.putInStorageNum!}</span>
                <p>今日入库总数（件）</p>
            </a>
        </li>
        <li>
            <a href="outboundSearch.htm">
                <span class="fs20 arail fc3">${inventory.outBoundNum!}</span>
                <p>今日出库总数（件）</p>
            </a>
        </li>
    </ul>
</div>
<div class="orderSearch">
    <ul>
        <li><label>子订单ID：</label><input type="text" class="fmInput" name="childOrderId" <#if query.childOrderId??> value="${query.childOrderId!}" </#if>></li>
        <li><label>首次入库时间：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
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
                <td class="putInTime">入库时间</td>
                <td class="outBoundTime">出库时间</td>
                <td class="childOrderState">状态</td>
                <td class="opeName">操作员</td>
                <td class="remark">备注</td>
            </tr>
        </thead>
        <#list childOrders as childOrder>
        <tbody class="childOrderItem">
            <#list childOrder.putInOutRecords as item>
            <tr class="" data-childorderid="${item.childOrderId!}">
                <#if item_index == 0>
                <td class="childOrderId" rowspan="${(childOrder.putInOutRecords?size)!}">
                    ${item.childOrderId!}
                </td>
                <td class="goodsInfo" rowspan="${(childOrder.putInOutRecords?size)!}">
                    <span>${item.goodsNo!}</span>
                    <span>${item.goodsProperty!}</span>
                </td>
                <td class="price" rowspan="${(childOrder.putInOutRecords?size)!}">
                    <span>${item.piPrice!}</span>
                </td>
                </#if>
                <td class="putInTime">
                    <#if item.type == 1>
                        ${item.time!}
                    <#elseif item.type == 2>
                        ——
                    <#elseif item.type == 3>
                        ——
                    </#if>
                </td>
                <td class="outBoundTime">
                    <#if item.type == 1>
                        ——
                    <#elseif item.type == 2>
                        ${item.time!}
                    <#elseif item.type == 3>
                        ——
                    </#if>
                </td>
                <td class="childOrderState">
                    <#if item.type == 1>
                        ——
                    <#elseif item.type == 2>
                        ——
                    <#elseif item.type == 3>
                        已退货
                    </#if>
                </td>
                <td class="opeName">
                    ${item.opeName!}
                </td>
                <#if item_index == 0>
                <td class="remark" rowspan="${(childOrder.putInOutRecords?size)!}">
                    ${item.remark}
                </td>
                </#if>
            </tr>
            </#list>
        </tbody>
        </#list>
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