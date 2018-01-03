<#assign $pageid="withdraw5Apply">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>提现 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__withdraw5Apply_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__withdraw5Apply_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="mybag">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<div class="remainSum">
    <div class="remainSumTop">
        <div class="myRemain">
            <h3>我的余额（元）</h3>
            <p id="yuerBalance">加载中…</p>
        </div>
        <div class="amountFrozen">
            <h3>冻结金额（元）</h3>
            <p id="yuerBlockMoney">加载中…</p>
        </div>
    </div>
    <input type="hidden" id="tempCode" value="${tempCode!}">
</div>
<hr class="splitLine">
<div class="cashBox pr">
    <div class="validateForm cashApplyForm">
        <div class="validateItem">
            <div class="formGroup">
                <label>提现类型：</label>
                <input type="text" value="支付宝" class="fmInput" readonly="readonly">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>支付宝账号：</label>
                <input type="text" name="alipay" class="fmInput" placeholder="支付宝账户邮箱号或手机号">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>支付宝实名：</label>
                <input type="text" name="payname" class="fmInput" placeholder="正确输入支付宝账户实名，防止打错账">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>金额：</label>
                <input type="text" name="paynum" class="fmInput" placeholder="请输入提现金额">元
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label></label>
                <span class="freeWithdrawNum">当月免费提现：<em class="fcF40 fs14" id="freeWithdrawNum"></em> 次</span>
                <span class="withdrawUpperLimit">每次提现上限：<em class="fcF40 fs14" id="withdrawUpperLimit"></em> 元</span>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label></label>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         applyCashBtn"
        disabled="disabled"
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="<#--applyCashBtn-->"
>
        支付升级中...
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
    </div>
    <div class="wxTip fc6">
        <em></em>
        <h2>温馨提示：</h2>
        <p>1.余额小于100时不能提现<br>2.提现金额会在两个工作日内打到您支付宝内。<br><span class="fcF40">3.请正确输入实名，如实名有误将不予提现！</span><br></p>
    </div>
    <div class="ewmWk">
        <div class="imgewm">
            <img src="http://wxpublish.hz.taeapp.com/otlink/qrcode.htm?secret_id=5&amp;outer_id=1000000808&amp;t=1483668924057&amp;sign=8533b1f836a9f1ffa6459abf1cc2572d" alt="" width="140" height="140">
        </div>
        <p class="ewmtip fcF40">关注二维码，及时查收提现信息</p>
    </div>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">