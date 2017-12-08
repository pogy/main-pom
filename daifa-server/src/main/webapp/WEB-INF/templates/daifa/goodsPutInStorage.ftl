<#assign $pageid>goodsPutInStorage</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>商品入库 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__goodsPutInStorage_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/daifa__goodsPutInStorage_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<script modulepath="daifa/goodsPutInStorage#config">
var userPermissions = '${isAfterSale!}';
var outBoundAllNum = '${outBoundAllNum!}';
var outBoundAllMoney = '${outBoundAllMoney!}';
</script>
<div class="scanBarCode">
    <div class="fl">
        <label>商品条码：</label>
        <input type="text" placeholder="请扫描或手动输入商品条码" id="barCode" class="barCode">
    </div>
    <div class="fr">
        <div class="opeBtnBox <#if (childOrders?size) gt 0>hasData</#if>">
            <span class="goodsNum fc6">共计商品：<em class="fs20 fc3 putInStorageNum">${putInStorageNum!}</em> 件</span>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-o
        "
        jbtn="submitPutIn"
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
        确认入库
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-o
        "
        jbtn="afreshScan"
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
        重新扫描
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
</div>
<div class="orderCon">
    <table>
        <thead class="theadCon">
            <tr class="">
                <td class="childOrderId">子订单ID</td>
                <td class="goodsInfo">商品货号</td>
                <td class="price">商品金额</td>
                <td class="time">入库时间</td>
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
                <td class="remark">
                    ${childOrder.remark}
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
    </div>
</div>