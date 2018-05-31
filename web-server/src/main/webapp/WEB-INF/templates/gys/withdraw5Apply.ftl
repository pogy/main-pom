<#assign $pageid="withdraw5Apply">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>提现 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__withdraw5Apply_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a>我的资金 &gt; 提现</a></li>
    <a href="bindAlipayUserOpe.htm" class="fr fcBlue fs14"><i class="icon-plus"></i>添加新的支付宝账号</a>
</ul>
<div class="withdrawTip">
    提现金额不能小于100元，提现金额会在2个工作日内打到您的支付宝内，账户余额提现收取0.6%的手续费！
</div>
<div class="cashBox pr">
    <div class="validateForm cashApplyForm">
        <div class="validateItem">
            <div class="formGroup">
                <label>已绑定的支付宝：</label>
                <select class="bindAlipay" name="bindAlipay">
                    <option value="">请选择</option>
                    <#list alipayUserList as item>
                    <option value="${item.aliAccountId!}">${item.aliAccount!}</option>
                    </#list>
                </select>
                <#if (alipayUserList?size) == 0>
                <span class="fc6">提示：暂无已绑定支付宝，马上去<a href="bindAlipayUserOpe.htm" class="fcF40">绑定</a></span>
                </#if>
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
                <input type="text" name="realWithdrawMoney" class="fmInput realWithdrawMoney" placeholder="扣除手续费后实际到账金额" readonly>元
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
                <label>支付密码：</label>
                <#if payPasswordIs == 1>
                <input type="password" name="payPassword" class="fmInput" placeholder="请输入星座宝支付密码">
                <#elseif payPasswordIs == 0>
                <span class="toSetPayPassword">您暂未设置支付密码，请 <a href="safeindex.htm" target="_blank" class="fcF40">立即设置</a></span>
                <input type="hidden" name="payPassword" class="fmInput" autocomplete="off" placeholder="请输入星座宝支付密码">
                </#if>
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
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="applyCashBtn"
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
        <input type=hidden name="userBalance" value="${userBalance!}">
    </div>
    <!--<div class="ewmWk">
        <div class="imgewm">
            <img src="//wxpublish.hz.taeapp.com/otlink/qrcode.htm?secret_id=5&amp;outer_id=1000000808&amp;t=1483668924057&amp;sign=8533b1f836a9f1ffa6459abf1cc2572d" alt="" width="140" height="140">
        </div>
        <p class="ewmtip fcF40">关注二维码，及时查收提现信息</p>
    </div>-->
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>