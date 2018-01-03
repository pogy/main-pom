<#assign $pageid="onlyRefund">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>仅退款 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__onlyRefund_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__onlyRefund_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/order__common__header.ftl">
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="/">首页</a> &gt;
    <a href="/member/index.htm">我的星座网</a> &gt;
    <a href="myOrder.htm">我的订单</a> &gt;
    <span class="fcF40">退款申请</span>
</div>
<div class="returnBox layout">
    <div class="returnLeft fl">
        <#if onlyRefundStateNum == 1>
<div class="reRefundGoods refundBox" data-orderId="${orderId!}" data-goodsId="${childOrderId!}">
    <label class="fl fc6">退款商品：</label>
    <img src="${childOrderImgSrc!}" >
    <div class="goodsInfo fl">
        <p class="arial fs14 fc3">${childOrderCode!}</p>
        <p class="fc9"><span>颜色：${childOrderColor!}</span><span>尺码：${childOrderSize!}</span></p>
    </div>
</div>
<script modulepath="order/onlyRefund#refundApply">
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var refundGoodsPrice = '${refundGoodsPrice!}'
var refundNum = '${refundNumber!}';
var otherRefundPrice = ${otherRefundPrice!};
</script>
<div class="refundApply refundBox">
    <li>
        <label><em class="fcF40 vm">*</em> 退货件数：</label>
<#list [{"name":"count","value":""}] as $it>
<div class="fmSelect" id="refundCount">
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
        <label><em class="fcF40 vm">*</em> 退款金额：</label>
        <span class="refundCountNum fcF40 fs14 yahei"><em class="yahei">&yen;</em><em class="fwb" id="refundMoney">${refundGoodsPrice!}</em></span>
    </li>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg applyBtn
         fmButton-orange
        "
        disabled="disabled"
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="<#--refundApplyBtn-->"
>
        支付升级中...
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
        <#elseif onlyRefundStateNum == 2>
<div class="reWaitFeedback refundBox">
        <h4 class="fwb yahei fc3">退款申请已提交，请等待处理！</h4>
        <p>退款总金额：<span class="fcF40 yahei fs14">&yen;<em class="fwb">${refundAmount!}</em></span></p>
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
        <#elseif onlyRefundStateNum == 3>
<div class="reRefundSuccess refundBox fc6">
    <h4 class="yahei fc3 fwb">退款成功！</h4>
    <p>退款总金额：<span class="fcF40 yahei fs14">&yen;<em class="fwb">${finalRefundAmount!}</em></span></p>
    <p>退款去向：${refundGoto!}<span class="refundSucTime">退款成功时间：<em class="yahei fs14">${refundSuccessTime!}</em></span></p>
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
        <#elseif onlyRefundStateNum == 4>
<div class="reRefuseApply refundBox">
        <h4 class="fwb yahei fc3">退款申请已拒绝！</h4>
    <p class="refuseReason fcF40">${refuseReason!}</p>
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
<#if refundId != ''>
<div class="reRefundInfo">
    <ul>
        <li><label>退款编号：</label><span class="yahei fs14 fcBlue">${refundId!}</span></li>
        <li><label>退款总额：</label><span class="yahei fs14">&yen;<em class="fwb">
            <#if $pageid == 'refund' && refundStateNum == 4>
                ${finalRefundAmount!}
            <#else>
                ${refundAmount!}
            </#if>
            </em></span>
        </li>
    </ul>
</div>
</#if>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">