<#assign $pageid="myBatchTbOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>批量淘宝订单 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__myBatchTbOrder_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__myBatchTbOrder_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#list [{"fields":[{"name":"st","value":""+query.st},{"name":"et","value":""+query.et},{"name":"orderId","value":""+query.orderId}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="pageTabs clearfix yahei">
    <ul>
        <li class="select"><a>淘宝已卖出商品</a></li>
    </ul>
</div>
<div class="searchBox clearfix">
    <ul>
        <li><label>订单编号：</label><input type="text" name="orderId" <#if query.orderId??>value="${query.orderId!}"</#if>></li>
        <li>
            <label>成交时间：</label><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="startTime" placeholder="请选择时间范围起始" <#if query.st??>value="${query.st!}"</#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择时间范围起始" <#if query.et??>value="${query.et!}"</#if>>
        </li>
        <li>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
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
        搜索订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </li>
    </ul>
</div>
<div id="orderList" class="orderList orderDetail">
<div class="listHead clearfix">
    <ul>
        <li class="goods">商品</li>
        <li class="tbPrice">淘宝价格</li>
        <li class="xzPrice">星座网价格</li>
        <li class="num">数量</li>
        <li class="profits">利润(元)</li>
        <li class="opera">操作</li>
    </ul>
</div>
<#if notLinkNum gt 0>
<div class="tbOrderTip fc3">
    提示：淘宝已卖出的商品中有<em class="fcF40">${notLinkNum!}</em>件商品暂未绑定四季星座网商品库中对应的商品,只有绑定后才可准确无误下单哦！<a class="fcF40" href="tbBindGoodsNo.htm?notLinkCode=${notLinkCode!}" target="_blank">立即查看</a>
</div>
</#if>
<div class="tbOrderCheck">
    <div class="tbOpe">
<#list [{}] as $it>
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
            name="flagCheckAll"
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
</#list>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-white-o
         moreToOrder"
        jhand="moreToOrder"
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
        批量下单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    </div>
    <div class="flagCheckBox">
        <span>您也可以通过旗帜的颜色快速选择订单：</span>
<#list [{}] as $it>
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
            name="flagBlue"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        <i class="flag4 icon-s-flag"></i>蓝色
    </span>
</label>
</#list>
<#list [{}] as $it>
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
            name="flagPurple"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        <i class="flag5 icon-s-flag"></i>紫色
    </span>
</label>
</#list>
<#list [{}] as $it>
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
            name="flagRed"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        <i class="flag1 icon-s-flag"></i>红色
    </span>
</label>
</#list>
<#list [{}] as $it>
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
            name="flagGreen"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        <i class="flag3 icon-s-flag"></i>绿色
    </span>
</label>
</#list>
<#list [{}] as $it>
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
            name="flagYellow"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        <i class="flag2 icon-s-flag"></i>黄色
    </span>
</label>
</#list>
<#list [{}] as $it>
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
            name="flagNoColor"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="flagCheckAll"
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
        无旗帜
    </span>
</label>
</#list>
    </div>
</div>
    <div class="orderBox">
        <#if (orders?size) gt 0>
            <#list orders as order>
<div class="orderItem" data-id="${order.tbId!}">
    <div class="orderHead">
        <#if order.flagState == 1>
<#list [{}] as $it>
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
            data-selectParent="flagRed"
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
</#list>
        <#elseif order.flagState == 2>
<#list [{}] as $it>
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
            data-selectParent="flagYellow"
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
</#list>
        <#elseif order.flagState == 3>
<#list [{}] as $it>
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
            data-selectParent="flagGreen"
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
</#list>
        <#elseif order.flagState == 4>
<#list [{}] as $it>
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
            data-selectParent="flagBlue"
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
</#list>
        <#elseif order.flagState == 5>
<#list [{}] as $it>
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
            data-selectParent="flagPurple"
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
</#list>
        <#else>
<#list [{}] as $it>
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
            data-selectParent="flagNoColor"
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
</#list>
        </#if>
        <span class="fc6 mr">订单编号：<em class="fs14">${order.tbId!}</em></span>
        <span class="fc6 mr">成交时间：<em class="fs14">${order.time!}</em></span>
        <b class="fcBlue fr detailBtn" jbtn="detailBtn">详情<i class="icon-downarrow"></i></b>
        <#if order.flagState??>
        <i class="flag${order.flagState!} icon-s-flag fr flag"></i>
        </#if>
        <#if order.lastTime??>
        <em class="fr fc6">${order.lastTime!} 已下单</em>
        </#if>
    </div>
    <div class="orderCon">
        <div class="orderInfo">
            <#list order.childOrders as childOrder>
<div class="childOrderItem" name="${childOrder.numiid!}" data-webSite="${childOrder.webSite!}">
    <ul class="clearfix">
        <li class="goods clearfix borderBot" data-imgsrc="${childOrder.imgSrc!}" data-title="${childOrder.title!}" data-goodsno="${childOrder.goodsNo!}" data-price="<#if childOrder.newTbPrice??>${childOrder.newTbPrice!}<#else>${childOrder.oldTbPrice!}</#if>" data-tbid="${childOrder.numiid!}">
            <span href="javascript:;" class="imgBox fl">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="80" height="80">
            </span>
            <div class="goodsInfo fl">
                <span title="${childOrder.title!}">${childOrder.title!}</span>
                <p class="fc9" title="颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
                <#if childOrder.goodsNo??>
                <p class="goodsNoShow" title="已关联货号：${childOrder.goodsNo!}">已关联货号：${childOrder.goodsNo!}</p>
                <p class="goodsGlBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-white-o
         glBtn"
        jhand="openGlWindow"
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
        重新关联
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
                <#else>
                <p class="goodsNoShow" title="">已关联货号：<em class="fcF40">暂未关联</em></p>
                <p class="goodsGlBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange-o
         toGlBtn"
        jhand="openGlWindow"
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
        暂未关联
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
                </#if>
            </div>
        </li>
        <li class="tbPrice yahei borderBot">
            <p class="<#if childOrder.newTbPrice??>oldTbPrice</#if>">&yen;${childOrder.oldTbPrice!}</p>
            <#if childOrder.newTbPrice??>
            <p class="fs14">&yen; ${childOrder.newTbPrice!}<i class="editIcon"></i></p>
            </#if>
        </li>
        <li class="xzPrice yahei borderBot">
            <#if childOrder.xzPrice??>
            <p class="fs14">&yen; ${childOrder.xzPrice!}</p>
            <#else>
            <p class="fs12 fcF40">暂未关联</p>
            </#if>
        </li>
        <li class="num fs14 borderBot">${childOrder.num!}</li>
        <li class="profits fcF40 fs16 borderLe">
            <#if childOrder_index == 0>
            ${order.profits!}
            </#if>
        </li>
        <li class="opera borderLe">
            <#if childOrder_index == 0>
                <#if order.canOrder == true>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         toOrder"
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
        立即下单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                <#else>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         notOrder"
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
        立即下单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                </#if>
            </#if>
        </li>
    </ul>
</div>
            </#list>
        </div>
        <div class="receAddress">
            ${order.address!}
        </div>
    </div>
</div>
            </#list>
        <#else>
            <p class="tac fs20 fc6">暂无数据</p>
        </#if>
    </div>
</div>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
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
<#include "/common/xz__footer.ftl">