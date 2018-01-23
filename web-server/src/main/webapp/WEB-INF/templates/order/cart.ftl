<#assign $pageid="cart">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>进货车 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__cart_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__cart_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
    <#assign statusNum=1>
<#include "/__ftl_links__/order__common__whiteHeader.ftl">
<#assign headerTitle="进货车">
<#assign headerTitle="进货车">
<div class="titleBar layout">
    <h3 class="fcF40 yahei fs16">全部商品 <span id="allOrderGoodsNum">${cart.goodsCount!}</span></h3>
    <#if (cart.orders?size) gt 0>
    <div class="accoutnInfo fr">
        已选商品 <span class="orderTotalNumValue fcF40 fs14 fwb">0</span> 件（不含运费）<span class="yahei fcF40">&yen;</span> <span class="fcF40 fs14 fwb orderTotalPriceValue">0.00</span>
        <span class="accountBtn pr">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-out
         submitOrders"
        jbtn="submitOrders"
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
        结算
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <div class="tips pa fwb none">请勾选您要结算的商品 <i></i></div>
        </span>
    </div>
    </#if>
</div>
<div class="orderList layout">
<#if (cart.orders?size) gt 0>
    <ul class="listHeader clearfix">
        <li class="checkBox">
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
        <li class="goodsTitle">货品</li>
        <li class="goodsPrice tac">单价</li>
        <li class="goodsAttr">属性</li>
        <li class="goodsCount tac">数量</li>
        <li class="goodsTotalPrice tac">小计</li>
        <li class="goodsOperate tac">操作</li>
    </ul>
    <#list cart.orders as order>
    <div class="orderItem" data-id="${order.orderId!}" data-website="${order.webSite!}">
        <div class="shopInfo clearfix">
            <div class="fl">
<#list [{"name":order.orderId,"text":order.marketName+order.storeNum}] as $it>
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
</#list>
<#list [{"id":order.imQq}] as $it>
<#if $it.id != ''>
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list>
<#list [{"id":order.imWw}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
            </div>
            <div class="fr fc9">发货地：
                <#if order.webSite == 'hz'>
                    浙江-杭州
                <#elseif order.webSite == 'cs'>
                    江苏-常熟
                <#elseif order.webSite == 'ss'>
                    福建-石狮
                <#elseif order.webSite == 'bj'>
                    北京
                <#elseif order.webSite == 'gz'>
                    广东-广州
                <#elseif order.webSite == 'wa'>
                    吉林-辽源
                <#elseif order.webSite == 'jx'>
                    浙江-濮院
                <#else>
                    浙江-杭州
                </#if>
            </div>
        </div>
        <div class="childOrderList clearfix">
            <#list order.childOrders as childOrder>
<ul class="childOrderItem<#if childOrder.disabled == true> disabled</#if>"
    data-id="${childOrder.childOrderId!}"
    data-price="${childOrder.price!}"
>
    <li class="checkBox">
        <#if childOrder.disabled == false>
<#list [{"name":childOrder.childOrderId,"selectParent":order.orderId}] as $it>
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
    </li>
    <li class="goodsInfo">
        <#if childOrder.disabled == true>
        <a href="javascript:;"><img src="${childOrder.imgsrc!}_240x240.jpg" class="fl"></a>
        <#else>
        <a href="http://www.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank"><img src="${childOrder.imgsrc!}_240x240.jpg" class="fl"></a>
        </#if>
        <div class="fl goodsTitle fc3">
            <h4>
                <#if childOrder.disabled == true>
                <a href="javascript:;" class="out">${childOrder.title!}</a>
                <#else>
                <a href="http://www.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank">${childOrder.title!}</a>
                </#if>
            </h4>
            <p class="fwb">商品货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="goodsPrice tac fc3 yahei"><span>&yen;</span><span class="fwb">${childOrder.price!}</span></li>
    <li class="goodsAttr fc9 pr">
        <div class="skuBox" data-colorid="${childOrder.color!}" data-sizeid="${childOrder.size!}">
            颜色：${childOrder.color!}<br>尺码：${childOrder.size!}
        </div>
        <#if childOrder.disabled == false>
        <i class="edit" jhand="openEditWindow">修改</i>
        <div class="attrInfo">
            <em></em>
            <div class="attrItem clearfix">
                <label class="fl">颜色：</label>
                <ul class="fl">
                    <#list childOrder.colors as color>
                    <li <#if childOrder.color == color>class="selected"</#if>  jhand="selectedSku">${color!}</li>
                    </#list>
                </ul>
            </div>
            <div class="attrItem clearfix">
                <label class="fl">尺码：</label>
                <ul class="fl">
                    <#list childOrder.sizes as size>
                    <li <#if childOrder.size == size>class="selected"</#if>  jhand="selectedSku">${size!}</li>
                    </#list>
                </ul>
            </div>
            <div class="btnsBox clearfix">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
        "
        jhand="submitOrderSku"
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
        确定
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-none
        "
        jhand="closeEditWindow"
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
        取消
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
        </#if>
    </li>
    <li class="goodsCount tac">
        <#if childOrder.disabled == true>
            <span>商品已失效</span>
        <#else>
<#list [{"name":childOrder.childOrderId,"value":childOrder.num}] as $it>
<span class="fmNumberInput">
    <i jbtn="reduce">-</i>
    <input class="textInput" type="text" autocomplete=off
            <#if $it.name??>
                data-name="${$it.name!}"
            <#else>
                data-name="fmNumberInput0"
            </#if>
            <#if $it.value != null >
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
            <#if $it.minValue != null >
                minValue="${$it.minValue!}"
            <#else>
                minValue="1"
            </#if>
            <#if $it.maxValue != null >
                maxValue="${$it.maxValue!}"
            <#else>
                maxValue="*"
            </#if>
    maxlength="">
    <input class="realInput" type="hidden"
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
                name="fmNumberInput0"
            </#if>
            <#if $it.value != null >
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
   >
    <i jbtn="add">+</i>
</span>
</#list>
        </#if>
    </li>
    <li class="goodsTotalPrice tac fcF40 yahei"><span>&yen;</span><span class="fwb goodsTotalPriceValue">0</span></li>
    <li class="goodsOperate tac"><b jhand="openRemoveChildOrderWindow">删除</b></li>
</ul>
            </#list>
        </div>
    </div>
    </#list>
<#else>
<p class="listIsEmpty tac fs16 fc6">进货车里空空的哦，先去<a href="http://www.571xz.com/">逛一逛</a>吧！</p>
</#if>
</div>
<#if (cart.orders?size) gt 0>
<div class="settlementInfoBar layout" id="settlementInfoBar">
    <div class="totalWrap layout">
        <div class="fl operateBox">
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
</#list>
            <b id="deleteSelectedOrders">删除</b>
        </div>
        <div class="accountBtnBox fr pr yahei">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-out
         submitOrders"
        jbtn="submitOrders"
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
        结算
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            <div class="tips pa fwb none">请勾选您要结算的商品 <i></i></div>
        </div>
        <div class="fr totalInfo">
            已选商品<span class="fs18 yahei fcF40 count orderTotalNumValue">0</span>件
            合计（不含运费）：<span class="fs18 yahei fcF40"><em class="fs14">&yen;</em> <em class="fwb totalPrice orderTotalPriceValue">0</em></span>
        </div>
    </div>
    <form action="" id="submitOrdersForm">
        <input type="hidden" id="submitOrderIds" name="childOrderIds">
    </form>
</div>
</#if>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">