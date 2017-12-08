<#assign $pageid>orderHasAllocation</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>我的任务 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__orderHasAllocation_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/daifa/js/laydate/laydate.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__orderHasAllocation_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"status","value":""+query.status},{"name":"orderId","value":""+query.orderId},{"name":"childOrderId","value":""+query.childOrderId},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime}]}</#assign>
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
        <li <#if !query.status>class="select"</#if> ><a href="orderHasAllocation.htm">全部子订单</a></li>
        <li <#if query.status == 1>class="select"</#if> data-status='1'><a href="orderHasAllocation.htm?status=1">未打印子订单</a></li>
        <li <#if query.status == 2>class="select"</#if> data-status='2'><a href="orderHasAllocation.htm?status=2">已打印子订单</a></li>
    </ul>
</div>
<div class="orderSearch">
    <ul>
        <li><label>主订单ID：</label><input type="text" class="fmInput" name="orderId" <#if query.orderId??> value="${query.orderId!}" </#if> ></li>
        <li><label>子订单ID：</label><input type="text" class="fmInput" name="childOrderId" <#if query.childOrderId??> value="${query.childOrderId!}" </#if>></li>
        <li><label>订单日期：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择起始时间" <#if query.startTime??> value="${query.startTime!}" </#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择结束时间" <#if query.endTime??>value="${query.endTime!}"</#if>></li>
        <li>
            <label>拿货人：</label><select class="fmInput" name="searchWorkerId" <#if query.searchWorkerId??> value="${query.searchWorkerId!}" </#if>>
                <option value="">请选择</option>
                <#list workers as worker>
                <option value="${worker.id!}" <#if query.searchWorkerId == worker.id>selected</#if>>${worker.name!}</option>
                </#list>
            </select>
        </li>
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
    <div class="theadCon">
        <ul class="">
            <li class="checkBox">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="selectAll"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        全选
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list></li>
            <li class="childOrderId"></li>
            <li class="goodsInfo"><b class="printGoodsTab" data-type="1">打印全部商品标签</b><b class="printGoodsTab" data-type="2">打印已选商品标签</b></li>
            <li class="price">价格（元）</li>
            <li class="goodsNum">数量</li>
            <li class="dffs">代发方式</li>
            <li class="orderState">订单状态</li>
            <li class="operator">操作</li>
            <li class="remark">备注</li>
        </ul>
    </div>
    <div id="orderContainer">
    <#list childOrders as childOrder>
<div class="childOrderItem" data-id="${childOrder.childOrderId!}" data-takeGoodsId="${childOrder.takeGoodsId!}">
    <ul class="clearfix">
        <li class="checkBox">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
            </#if>
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="selectAll"
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list></li>
        <li class="childOrderId">${childOrder.childOrderId!}</li>
        <li class="goodsInfo">
            <div class="fl imgBox">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="54" height="54">
            </div>
            <p class="title">${childOrder.title!}</p>
            <p>商品属性：${childOrder.goodsProperty!}</p>
            <p>商品货号：${childOrder.goodsNo!}</p>
        </li>
        <li class="price">
            <p>批价：${childOrder.piPrice!}</p>
            <#if childOrder.payPrice??>
            <p>实价：${childOrder.payPrice!}</p>
            <#else>
            <p>实价：——</p>
            </#if>
        </li>
        <li class="goodsNum">${childOrder.num!}</li>
        <li class="dffs">
            <#if childOrder.dffs == 1>
            <p>普通代发</p>
            </#if>
        </li>
        <li class="orderState">
            <#if childOrder.takeGoodsState == 1>
            <p class="alreadyGet">已拿到</p>
            <#elseif childOrder.takeGoodsState == 2>
            <p class="fcF40">缺货</p>
            <#else>
            <p>拿货中</p>
            </#if>
        </li>
        <li class="operator">
            <#if childOrder.takeGoodsState == 0>
                <#if childOrder.isMyTask == true>
                <p><b class="fcBlue" jbtn="isGetGoods" data-type="1">已拿到</b></p>
                <p><b class="fcBlue" jbtn="isGetGoods" data-type="2">未拿到</b></p>
                </#if>
            <#else>
            <p class="fcBlue">——</p>
            </#if>
        </li>
        <li class="remark">
            <#if childOrder.haveGoodsTime??>
                <p>${childOrder.haveGoodsTime!} 有货</p>
            </#if>
            <#if childOrder.noSaleIs == true>
                <p><span class="fcF40">已标记下架</span></p>
            <#else>
                <#if childOrder.takeGoodsState != 1>
                <p><b class="fcBlue" jbtn='setHasGoodsTime'>设置有货时间</b></p>
                <p><b class="fcBlue" jbtn="setNoSale">标记下架</b></p>
                </#if>
            </#if>
            <div class="childOrderRemark pr">
                <i class="icon-s-message iconfont <#if childOrder.childRemark??>haveRemark</#if>"></i>
                <div class="remarkCon pa">
                    <#if childOrder.childRemark??>
                    ${childOrder.childRemark!}
                    </#if>
                    <p><b class="addChildRemark" jbtn="addChildRemark">添加备注</b></p>
                </div>
            </div>
        </li>
    </ul>
</div>
    </#list>
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
</div>