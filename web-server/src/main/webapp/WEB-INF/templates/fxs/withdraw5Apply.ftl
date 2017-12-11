<#assign $pageid>withdraw5Apply</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>提现 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__withdraw5Apply_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__withdraw5Apply_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>mybag</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>我的资金 &gt; 提现</a></li>
</ul>
<div class="remainSum">
    <div class="remainSumTop">
        <div class="myRemain">
            <h3>我的余额（元）</h3>
            <p id="yuerBalance" data-m="">加载中…</p>
        </div>
        <div class="amountFrozen">
            <h3>冻结金额（元）</h3>
            <p>加载中…</p>
        </div>
    </div>
    <input type="hidden" class="tempCode" value="${tempCode!}">
</div>
<hr class="splitLine">
<div class="cashBox pr">
    <div class="validateForm cashApplyForm">
        <div class="validateItem">
            <div class="formGroup">
                <label>提现类型：</label>
                <span class="fs16 fc3 alipay">支付宝</span>
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
                <input type="text" name="paynum" id="paynum" class="fmInput" placeholder="请输入提现金额">元
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label>实际到账金额：</label>
                <input type="text" name="realWithdrawMoney" class="fmInput" placeholder="0.00" readonly>元
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label></label>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         applyCashBtn"
        disabled="disabled"
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
        提交提现申请信息
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
        <p>1.余额小于100时不能提现<br>2.提现金额会在两个工作日内打到您支付宝内。<br><span class="fcF40">3.请正确输入实名，如实名有误将不予提现！</span><br><span class="fcF40">4.账户余额提现收取0.6%的手续费！</span></p>
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