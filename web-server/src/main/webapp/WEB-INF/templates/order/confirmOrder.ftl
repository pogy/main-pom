<#assign $pageid="confirmOrder">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>确认订单 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__confirmOrder_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__confirmOrder_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
    <#assign statusNum=2>
<#include "/__ftl_links__/order__common__whiteHeader.ftl">
<div class="mainBox layout">
    <h3 class="infoTitle fs16 yahei">填写并核对订单信息</h3>
    <div class="orderInfoEdit">
<div id="serviceList" style="display:none">
<#list [{"choiceCon":sender}] as $it>
<div class="radioList marBottom deliMethod">
    <h3 class="fs14 yahei">
        发货方式
        <span>星座网代发是指从档口帮您拿到货物并且打包，送货到物流公司！</span>
    </h3>
    <div class="choiceBox clearfix">
        <ul>
            <#list $it.choiceCon as option>
<#list [{"value":""+option.id,"text":""+option.text,"checked":option.checked}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
        buttonRadio
">
    <input
        type="radio"
        autocomplete="off"
            name="serviceId"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            <#if $it.checked??>
                checked
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
            </#list>
        </ul>
    </div>
</div>
</#list>
</div>
<script modulepath="order/confirmOrder#order">
var code = '${code!}'
</script>
        <div class="consigneeInfo marBottom clearfix">
            <h3 class="fs14 yahei">收货人信息</h3>
            <div id="addressEditBox" class="addressEditBox clearfix" <#if tbOrderAddressInfo??>style="display:none"</#if>>
<div id="addressForm" class="addressForm">
    <div class="parseAddress clearfix">
        <label class="fl">解析地址：</label>
        <input class="fl" type="text" name="orignAddress" id="addressForParse" placeholder="淘宝订单详情页中的地址信息黏贴到此处">
        <b class="fl" id="doParseAddress">一键解析</b>
    </div>
    <div class="parseFormBox">
        <ul>
            <li class="framBox">
                <div class="provAndCity congineeBox">
                    <label><span class="fcF40 required">*</span>所在地区：</label>
<#list [{}] as $it>
<div data-id="myArea"
    class="fmCitypick" data-value="${$it.value!}">
</div>
</#list>
                </div>
            </li>
            <li class="framBox">
                <div class="detailAddress congineeBox">
                    <label><span class="fcF40 required">*</span>详细地址：</label>
                    <input type="text" name="detailAddress" placeholder="请填写准确详细的收货地址，例如街道名称，门牌号，楼层和房间号等信息" >
                </div>
            </li>
            <li class="framBox">
                <div class="congineeName congineeBox">
                    <label><span class="fcF40 required">*</span>收货人：</label>
                    <input type="text" name="congineeName" placeholder="长度不超过25个字符" maxlength="25">
                </div>
            </li>
            <li class="congineeBox framBox">
                <div class="clearfix phone">
                    <div class="mobile fl">
                        <label>手机号码：</label>
                        <input type="text" name="mobile" placeholder="手机号码、电话号码必须填写一项" maxlength="11">
                    </div>
                    <div class="telePhone fl">
                        <label>电话号码：</label>
                        <input type="text" name="areaCode" class="areaCode" placeholder="区号">
                        <span>-</span>
                        <input type="text" name="telePhone" placeholder="电话号码">
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="qrAndColBtn">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         qrBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitPostAddress"
>
        确认
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
         fmButton-lighter-o
         collBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="savePostAddress"
>
        确认并收藏
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        <span class="lgErrorTip fcF40">地址最多可收藏5个！</span>
    </div>
</div>
<script modulepath="order/confirmOrder#order">
var code = '${code!}'
</script>
<div class="addressList simsun fl">
    <h5>收藏地址列表 <span class="fcF40 surAmount" id="addressListNum">(${(collList?size)!}/5)</span> <em class="fc9">您可使用收藏的地址</em></h5>
    <ul id="addressListBox">
        <#list collList as addressInfo>
        <li class="pr" data-fulladdresstext="${addressInfo.name!},${addressInfo.phone!},${addressInfo.address!}" data-addressid="${addressInfo.id!}">
<#list [{"text":""+addressInfo.name+","+addressInfo.phone+","+addressInfo.address}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="collAdress"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            <#if $it.checked??>
                checked
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
            <b class="deleteColl pa" jbtn="removeAddress" data-addressid="${addressInfo.id!}">删除</b>
        </li>
        </#list>
    </ul>
</div>
<script modulepath="order/confirmOrder#order">
var code = '${code!}'
</script>
            </div>
<div id="addressInfo" class="consigneeAddress clearfix" <#if !tbOrderAddressInfo>style="display:none"</#if>>
    <div id="addressName" class="simuCheckBox select"><#if tbOrderAddressInfo??>${tbOrderAddressInfo.name!}</#if></div>
    <div id="fullAddressText" class="fl congineeText">
        <#if tbOrderAddressInfo??>
            ${tbOrderAddressInfo.allAddressInfo!}
        </#if>
    </div>
    <b class="openEditAddressForm" id="openEditAddressForm">更改地址</b>
</div>
<input id="provText" <#if tbOrderAddressInfo??>value="${tbOrderAddressInfo.prov!}"</#if> type="hidden">
<input id="addressId" <#if tbOrderAddressInfo??>value="${tbOrderAddressInfo.addressId!}"</#if> type="hidden">
        </div>
<div id="postList">
    <div class="portCommonBox marBottom courierName">
        <h3 class="fs14 yahei">快递名称</h3>
        <div class="choiceBox clearfix">
            <p class="fcF40">请选择或填写一个地址（快递费用是根据收货地址计算哦）！</p>
        </div>
    </div>
</div>
<script modulepath="order/confirmOrder#order">
var code = '${code!}'
</script>
<div id="orderGoodsList" class="orderGoodsList">
    <h3 class="fs14 yahei orderBoxTitle">商品清单</h3>
<div class="orderDetail clearfix">
    <div class="listHeader clearfix">
        <ul>
            <li class="goodsTitle tac">商品</li>
            <li class="goodsPrice tac">单价</li>
            <li class="goodsAttr">属性</li>
            <li class="goodsCount tac">数量</li>
            <li class="postFee tac">快递费用</li>
            <li class="serverFee tac">服务费用</li>
        </ul>
    </div>
    <div class="orderAllInfo fl">
        <#list goodsOrders as order>
        <div class="orderItemInfo fl" data-shopid="${order.shopId!}">
            <div class="orderInfo clearfix">
                <span class="orderStore">档口：${order.marketName!}  ${order.storeNum!}</span>
<#list [{"id":order.imQq}] as $it>
<#if $it.id != ''>
<a class="imQQ" href="//wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list>
<#list [{"id":order.imWw}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
            </div>
            <div class="shopGoodsList clearfix">
                <#list order.childOrders as childOrder>
<ul class="childOrderItem"
    data-childorderid="${childOrder.childOrderId!}"
    data-price="${childOrder.price!}"
    data-weight="${childOrder.weight!}"
>
    <li class="goodsTitle clearfix">
        <a href="javascript:;" class="fl imgBox"><img src="${childOrder.imgsrc!}_70x70.jpg" width=62 height=62 class="fl"></a>
        <div class="fl goodsInfo fc3">
            <h4>${childOrder.title!}</h4>
            <p class="fwb">货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="goodsPrice tac fc3 yahei"><span>&yen;</span><span class="fwb">${childOrder.price!}</span></li>
    <li class="goodsAttr fc9 pr">
        <div class="skuBox">
            颜色：${childOrder.color!}<br>尺码：${childOrder.size!}
        </div>
    </li>
    <li class="goodsCount tac">
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
            minValue="0"
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
    </li>
</ul>
                </#list>
            </div>
        </div>
        </#list>
    </div>
    <div class="orderCost tac fl clearfix">
        <div class="postFee postCost fl">
            &yen;<span id="postPriceOther">0.00</span>
        </div>
        <div class="serverFee serverCost fl">
            &yen;<span id="servicePriceOther">0.00</span>
            <div class="serverDetail pr">
                <p class="fc9 curPointer">详情<i class="downArrow"></i></p>
                <div class="serverCon pa" id="priceListBox"></div>
            </div>
        </div>
    </div>
</div>
    <div class="orderLastBox">
        <p class="none">
<#list [{}] as $it>
<label class="fmCheckbox
        checked
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="agreen"
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
            checked
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        同意
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list><a href="571xz.com" target="_blank">《档口退换货规则》</a><span class="fcF40">（特别提示：货物是否可退货换是根据档口规则，所以拍下时请咨询档口）</span>
        </p>
        <p class="tar goodsFee">商品总金额:<em class="fcF40" id="orderTotalGoodsPrice">0.00</em>元</p>
    </div>
</div>
<script modulepath="order/confirmOrder#order">
var code = '${code!}'
</script>
    </div>
<div class="settlement tar">
    <div class="settlementBox">
        <div class="settleInfo">
            <ul>
                <li>
                    <span>运费总计：</span>
                    <em class="fs14 yahei">&yen;<span id="postPrice">0.00</span></em>
                </li>
                <li class="freePostBox">
                    <span>邮费已减免：</span>
                    <em class="fs14 yahei fcF40">&yen;-<span class="freePostCost">0.00</span></em>
                </li>
                <li>
                    <span>服务费总计：</span>
                    <em class="fs14 yahei">&yen;<span id="servicePrice">0.00</span></em>
                </li>
                <li>
                    <span>商品金额总计：</span>
                    <em class="fs14 yahei">&yen;<span id="goodsPrice">0.00</span></em>
                </li>
            </ul>
        </div>
        <div class="corfirmInfo">
            <p>应付总金额：<em class="fcF40 yahei fs20">&yen;</em><span class="fcF40 yahei totalAmount" id="allPayPrice">0.00</span></p>
            <p class="confirmAddress fc9">
                <#if tbOrderAddressInfo??>
                    <span>${tbOrderAddressInfo.allAddressInfo!}</span>
                </#if>
            </p>
        </div>
        <p class="msgTip fcF40"></p>
    </div>
    <div class="settleBtn clearfix">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitOrder"
>
        提交订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    </div>
</div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">