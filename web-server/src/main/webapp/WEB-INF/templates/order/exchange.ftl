<#assign $pageid="exchange">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title></title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__exchange_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__common_js.ftl">
<#include "/__style_torrent__/order__exchange_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/order__common__header.ftl">
<script modulepath="order/exchange#config">
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var express = '${expressList!}';
</script>
<script modulepath="order/exchange#config">
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var express = '${expressList!}';
</script>
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="/">首页</a> &gt;
    <a href="/member/index.htm">我的星座网</a> &gt;
    <a href="myOrder.htm">我的订单</a> &gt;
    <span class="fcF40">申请售后</span>
</div>
<div class="exchangeStep layout">
    <ul>
        <li <#if 0 lt exchangeStateNum> class="selected" </#if>><span>1、买家申请换货</span><em></em><i></i><i class="leftArrow"></i></li>
        <li <#if 1 lt exchangeStateNum> class="selected" </#if>><span>2、等待处理换货申请</span><em></em><i></i><i class="leftArrow"></i></li>
        <li <#if 2 lt exchangeStateNum> class="selected" </#if>><span>3、换货完成</span><em></em><i></i><i class="leftArrow"></i></li>
    </ul>
</div>
<div class="returnBox layout">
    <div class="returnLeft fl">
        <#if exchangeStateNum == 1>
<div class="reRefundGoods refundBox" data-orderId="${orderId!}" data-goodsId="${childOrderId!}">
    <label class="fl fc6">换货商品：</label>
    <img src="${childOrderImgSrc!}" >
    <div class="goodsInfo fl">
        <p class="arial fs14 fc3">${childOrderCode!}</p>
        <p class="fc9"><span>颜色：${childOrderColor!}</span><span>尺码：${childOrderSize!}</span></p>
    </div>
</div>
<div class="exchangeApply refundBox">
    <ul>
        <li>
            <label><em class="fcF40 vm">*</em> 服务类型：</label>
<#list [{"name":"service","value":"exchange"}] as $it>
<div class="fmSelect" id="serviceType">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </li>
        <li>
            <label>换货原因：</label>
<#list [{"name":"reason","value":"0"}] as $it>
<div class="fmSelect" id="refundReason">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </li>
        <li class="refundDesc">
            <label>换货说明：</label>
            <textarea placeholder="最多16个字符" maxlength="16"></textarea>
        </li>
        <li>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei applyBtn"
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
        提交申请
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></li>
    </ul>
</div>
        <#elseif exchangeStateNum == 2>
            <#if query.express??>
<script modulepath="order/common#reChooseExpress">
var refundId = '${refundId!}';
</script>
<div class="reChooseExpress refundBox">
        <h4 class="yahei fwb fc3">换货申请已通过，请及时确认完成！</h4>
        <p class="fc3">换货申请已通过，请填写退货物流信息！</p>
    <ul>
        <li class="refundAddr">
            <label>换货地址：</label>
            <p class="fs3">
                ${addrInfo.name!} , ${addrInfo.phone!},<br>${addrInfo.address!}
            </p>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 选择快递：</label>
<#list [{"name":"expressList","value":""}] as $it>
<div class="fmSelect" id="expressList">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 物流单号：</label>
            <input type="text" name="expressCode" class="fmInput" maxlength="18" placeholder="请填写物流单号">
            <div class="errorTip">物流单号格式不正确！</div>
        </li>
        <li>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei sureBtn"
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
        提交
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></li>
    </ul>
</div>
            <#else>
                <#if exchangeWaitState == 1>
<div class="reWaitFeedback refundBox">
        <h4 class="fwb yahei fc3">换货申请已提交，请等待处理！</h4>
</div>
                <#elseif exchangeWaitState == 2>
<script modulepath="order/common#reChooseExpress">
var refundId = '${refundId!}';
</script>
<div class="reChooseExpress refundBox">
        <h4 class="yahei fwb fc3">换货申请已通过，请及时确认完成！</h4>
        <p class="fc3">换货申请已通过，请填写退货物流信息！</p>
    <ul>
        <li class="refundAddr">
            <label>换货地址：</label>
            <p class="fs3">
                ${addrInfo.name!} , ${addrInfo.phone!},<br>${addrInfo.address!}
            </p>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 选择快递：</label>
<#list [{"name":"expressList","value":""}] as $it>
<div class="fmSelect" id="expressList">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </li>
        <li>
            <label><em class="fcF40 vm">*</em> 物流单号：</label>
            <input type="text" name="expressCode" class="fmInput" maxlength="18" placeholder="请填写物流单号">
            <div class="errorTip">物流单号格式不正确！</div>
        </li>
        <li>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         yahei sureBtn"
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
        提交
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></li>
    </ul>
</div>
                <#elseif exchangeWaitState == 3>
<script modulepath="order/common#reExpressInfo">
var expressCreateTime = ${express.createTime!};
</script>
<div class="reExpressInfo fc3 refundBox">
        <h4 class="yahei fwb">换货快递已提交！</h4>
    <p>
        <span class="fc6" data-expressid="${express.id!}">${express.name!}</span>
        <span class="yahei fs14 vm">${express.code!}</span>
        <a href="javascript:;" id="modifyExpress">修改快递</a>
    </p>
    <p class="finishBtn" data-refundid="${refundId!}">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         finishExchange"
        jbtn="finishExchange"
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
        换货已完成
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
</div>
                <#elseif exchangeWaitState == 4>
<div class="reRefuseApply refundBox">
        <h4 class="fwb yahei fc3">换货申请已拒绝！</h4>
    <p class="refuseReason fcF40">${refuseReason!}</p>
</div>
                </#if>
<div class="reApplyRecord">
    <label class="fl tar">申请记录：</label>
    <div class="recordList fl">
        <#list applylist as record>
        <div class="recordItem clearfix">
            <img class="fl" src="${record.userHeadimg!}">
            <div class="applyRecord fl">
                <h4>
                <#if record.userType == 1>
                    ${record.userNickname!}
                <#elseif record.userType == 0>
                    平台客服
                </#if>
                </h4>
                <p>
                <#if record.userType == 1>
                买家（${record.userNickname!}）于 ${record.recordTime!} ${record.recordContent!}<br>
                <#elseif record.userType == 0>
                    ${record.recordContent!}<br>
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
    </div>
</div>
            </#if>
        <#elseif exchangeStateNum == 3>
<div class="exchageFinish refundBox">
    <h4 class="yahei fwb fc3">换货完成！</h4>
    <p>完成时间：<span class="yahei fs14 vm">${exchageFinishTime!}</span></p>
</div>
<div class="reApplyRecord">
    <label class="fl tar">申请记录：</label>
    <div class="recordList fl">
        <#list applylist as record>
        <div class="recordItem clearfix">
            <img class="fl" src="${record.userHeadimg!}">
            <div class="applyRecord fl">
                <h4>
                <#if record.userType == 1>
                    ${record.userNickname!}
                <#elseif record.userType == 0>
                    平台客服
                </#if>
                </h4>
                <p>
                <#if record.userType == 1>
                买家（${record.userNickname!}）于 ${record.recordTime!} ${record.recordContent!}<br>
                <#elseif record.userType == 0>
                    ${record.recordContent!}<br>
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
    </div>
</div>
        </#if>
    </div>
    <div class="returnRight fr">
<div class="reOderInfo">
    <ul>
        <li><label>订单编号：</label><span class="yahei fs14 fcBlue">${orderId!}</span></li>
        <li><label>成交时间：</label><span class="yahei fs14">${orderDealTime!}</span></li>
        <li><label>商品价格：</label><span class="yahei fs14">&yen;<em class="fwb">${orderGoodsPrice!}</em></span></li>
        <li><label>快递费：</label><span class="yahei fs14">&yen;<em class="fwb">${orderExpressPrice!}</em></span></li>
        <li><label>服务费：</label><span class="yahei fs14">&yen;<em class="fwb">${orderServicePrice!}</em></span></li>
        <li><label>订单总额：</label><span class="yahei fs14">&yen;<em class="fwb">${orderTotalPrice!}</em></span></li>
    </ul>
</div>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">