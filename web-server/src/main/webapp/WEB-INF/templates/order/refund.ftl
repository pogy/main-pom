<#assign $pageid="refund">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>退货退款 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/order__common_css.ftl">
<#include "/__style_torrent__/order__refund_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/order__common_js.ftl">
<#include "/__style_torrent__/order__refund_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/order__common__header.ftl">
<script modulepath="order/refund#config">
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var express = '${expressList!}';
</script>
<script modulepath="order/refund#config">
var orderId = '${orderId!}';
var childOrderId = '${childOrderId!}';
var express = '${expressList!}';
</script>
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="/">首页</a> &gt;
    <a href="/member/index.htm">我的星座网</a> &gt;
    <a href="myOrder.htm">我的订单</a> &gt;
    <span class="fcF40">退款申请</span>
</div>
<div class="refundStep layout">
    <ul>
        <li <#if 0 lt refundStateNum> class="selected" </#if>><span>1、买家申请退货退款</span><em></em><i></i><i class="leftArrow"></i></li>
        <li <#if 1 lt refundStateNum> class="selected" </#if>><span>2、等待处理退货申请</span><em></em><i></i><i class="leftArrow"></i></li>
        <li <#if 2 lt refundStateNum> class="selected" </#if>><span>3、买家退货</span><em></em><i></i><i class="leftArrow"></i></li>
        <li <#if 3 lt refundStateNum> class="selected" </#if>><span>4、退货退款完成</span><em></em><i></i><i class="leftArrow"></i></li>
    </ul>
</div>
<div class="returnBox layout">
    <div class="returnLeft fl">
        <#if refundStateNum == 1>
<div class="reRefundGoods refundBox" data-orderId="${orderId!}" data-goodsId="${childOrderId!}">
    <label class="fl fc6">退货商品：</label>
    <img src="${childOrderImgSrc!}" >
    <div class="goodsInfo fl">
        <p class="arial fs14 fc3">${childOrderCode!}</p>
        <p class="fc9"><span>颜色：${childOrderColor!}</span><span>尺码：${childOrderSize!}</span></p>
    </div>
</div>
<script modulepath="order/refund#refundApply">
var refundGoodsPrice = '${refundGoodsPrice!}'
var refundNum = '${refundNumber!}'
</script>
<div class="refundApply refundBox">
    <ul>
        <li>
            <label><em class="fcF40 vm">*</em> 服务类型：</label>
<#list [{"name":"service","value":"refund"}] as $it>
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
            <label>退款原因：</label>
<#list [{"name":"reason","value":3}] as $it>
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
        <li class="refundDesc">
            <label>退款说明：</label>
            <textarea maxlength="16" placeholder="最多填写16个字符"></textarea>
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
        <#elseif refundStateNum == 2>
            <#if waitState == 1>
<div class="reWaitFeedback refundBox">
        <h4 class="fwb yahei fc3">退货退款申请已提交，请等待处理！</h4>
</div>
            <#elseif waitState == 2>
<div class="reRefuseApply refundBox">
        <h4 class="fwb yahei fc3">退货退款申请已拒绝！</h4>
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
                        <#if record.afterSaleInfoShowIs == true>
                            退款类型：退货退款<br>
                            退款金额：${afterSaleCost!}<br>
                            退款商品：（货号：${childOrderCode!}&nbsp;&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;&nbsp;件数：${afterGoodsNum!}）
                        </#if>
                <#elseif record.userType == 0>
                    ${record.recordContent!}<br>
                        <#if record.afterSaleInfoShowIs == true>
                        货号：${childOrderCode!}&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;件数：${failNum!}&nbsp;&nbsp;${failReason!}
                        </#if>
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
    </div>
</div>
        <#elseif refundStateNum == 3>
            <#if query.express??>
<script modulepath="order/common#reChooseExpress">
var refundId = '${refundId!}';
</script>
<div class="reChooseExpress refundBox">
        <h4 class="yahei fwb fc3">已同意退货退款申请！</h4>
        <p class="fc3">退货退款申请已通过，请填写退货物流信息！</p>
    <ul>
        <li class="refundAddr">
            <label>退货地址：</label>
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
                <#if returnState == 1>
<script modulepath="order/common#reChooseExpress">
var refundId = '${refundId!}';
</script>
<div class="reChooseExpress refundBox">
        <h4 class="yahei fwb fc3">已同意退货退款申请！</h4>
        <p class="fc3">退货退款申请已通过，请填写退货物流信息！</p>
    <ul>
        <li class="refundAddr">
            <label>退货地址：</label>
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
                <#elseif returnState == 2>
<script modulepath="order/common#reExpressInfo">
var expressCreateTime = ${express.createTime!};
</script>
<div class="reExpressInfo fc3 refundBox">
        <h4 class="yahei fwb">退货快递已提交！</h4>
    <p>
        <span class="fc6" data-expressid="${express.id!}">${express.name!}</span>
        <span class="yahei fs14 vm">${express.code!}</span>
        <a href="javascript:;" id="modifyExpress">修改快递</a>
    </p>
</div>
                <#elseif returnState == 3>
<script modulepath="order/refund#modifyRefundMoney">
var refundId = '${refundId!}';
</script>
<div class="modifyRefundMoney refundBox">
    <h4 class="fwb yahei fc3">退款金额已修改！</h4>
    <p class="fc6">退款金额已修改为：<span class="fcF40 yahei">&yen; <em class="fs14">${modifyRefundMoney!}</em></span></p>
    <div class="agreeBtns yahei">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         agreeBtn"
        jbtn="agree"
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
        同意退款金额
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
         fmButton-lg
         fmButton-white-o
         disagreeBtn"
        jbtn="disagree"
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
        不同意退款金额
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    </div>
</div>
                <#elseif returnState == 4>
<div class="disagreeRefundMondy refundBox">
    <h4 class="fwb yahei fc3">您不同意修改后的退款金额！</h4>
    <p class="fc6">修改过的价格，您不同意，请等待处理！</p>
</div>
                </#if>
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
                        <#if record.afterSaleInfoShowIs == true>
                            退款类型：退货退款<br>
                            退款金额：${afterSaleCost!}<br>
                            退款商品：（货号：${childOrderCode!}&nbsp;&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;&nbsp;件数：${afterGoodsNum!}）
                        </#if>
                <#elseif record.userType == 0>
                    ${record.recordContent!}<br>
                        <#if record.afterSaleInfoShowIs == true>
                        货号：${childOrderCode!}&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;件数：${failNum!}&nbsp;&nbsp;${failReason!}
                        </#if>
                </#if>
                </p>
            </div>
            <p class="applyTime yahei fs14">${record.recordTime!}</p>
        </div>
        </#list>
    </div>
</div>
        <#elseif refundStateNum == 4>
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
                        <#if record.afterSaleInfoShowIs == true>
                            退款类型：退货退款<br>
                            退款金额：${afterSaleCost!}<br>
                            退款商品：（货号：${childOrderCode!}&nbsp;&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;&nbsp;件数：${afterGoodsNum!}）
                        </#if>
                <#elseif record.userType == 0>
                    ${record.recordContent!}<br>
                        <#if record.afterSaleInfoShowIs == true>
                        货号：${childOrderCode!}&nbsp;&nbsp;颜色：${childOrderColor!}&nbsp;&nbsp;尺码：${childOrderSize!}&nbsp;&nbsp;件数：${failNum!}&nbsp;&nbsp;${failReason!}
                        </#if>
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
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">