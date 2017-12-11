<#assign $pageid>index</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>首页 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__index_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__index_js.ftl">
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
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#if goodsDownCount gt 0>
<div class="topTips">
    提示：您的所售商品中，有<em>${goodsDownCount!}</em>件已被档口下架！
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <a href="shiguOnekeyRecordinit.htm?uploadGoodsState=2"
    class="fmButton
         fmButton-sm
         fmButton-orange-o
        "
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
        立即查看
    </a>
</#list>
</div>
</#if>
<input type="hidden" id="userId" value="${session_user_redis__.userId!}">
<div class="userInfo">
    <div class="fl userBase">
        <#if session_user_redis__.headUrl??>
        <img src="${session_user_redis__.headUrl!}" class="headImg fl">
        <#else>
        <img src="${$stylepath!}${$projectid!}/css/img/DefaultImg.jpg" class="headImg fl">
        </#if>
        <div class="myinfo">
            <p class="welcome"><em></em>您好！</p>
            <ul class="clearfix">
                <li class="disabled" id="icon_taobao">淘宝</li>
                <li class="disabled" id="icon_aliww">阿里</li>
                <li class="disabled" id="icon_wx">微信</li>
                <li>支付宝</li>
            </ul>
            <p><a href="sysSetsindex.htm">修改个人信息 &gt;</a></p>
        </div>
    </div>
<div class="fl userAccount">
    <h4>账户余额（元）</h4>
    <p class="money">
        <em id="yuer_balance">加载中...</em>（可提现<span id="yuer_carry">加载中...</span>）
    </p>
    <p class="button-box clearfix">
<#assign text>{"href":"iwantToRechargein5.htm"}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-b
        "
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
        充值
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#assign text>{"href":"withdraw5Apply.htm"}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-b
        "
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
        提现
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    </p>
    <input type="hidden" id="tempCode" value="${tempCode!}">
</div>
</div>
<div class="tradeCounts">
    <ul class="clearfix fs16 iconList"></ul>
</div>
<div class="userShop">
    <h3 class="boxTitle fs18 fc3">淘宝上架店铺动态</h3>
    <div class="shopInfo">
        <ul class="clearfix"></ul>
    </div>
    <p class="button-box">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-gray-b
        "
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="showmore"
>
        点击加载更多
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
    </p>
</div>
<script modulepath="common/xz#openImgtips">
var imgsrc = '${imgsrc!}';
var tHref = '${tHref!}';
</script>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">