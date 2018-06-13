<#assign $pageid="createGoods21init">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>发布宝贝 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__createGoods21init_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__createGoods21init_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">发布宝贝</a></li>
</ul>
<ul class="goodsPostEntryList yahei">
<#if session_user_redis__.logshop.type == 1>
    <li>
        <div class="goodsPostEntryListIntro">
            <h3>自动同步</h3>
            <p>在您变更淘宝店铺的商品的3-5分钟内，四季星座网系统会自动将新的商品或商品状态同步到四季星座网店铺中。</p>
        </div>
        <div class="clickButton beOpenStatus">
            <#if query.feedback?? && query.feedback gt 0>
                <#if query.feedback == 1>
<#list [{}] as $it>
    <a href="ghTongbu.htm"
    class="fmButton
         fmButton-blue
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
        立即开通
    </a>
</#list>
                <#else>
                <i class="beOpen"></i>
                </#if>
            <#else>
                <i class="beOpen"></i>
            </#if>
        </div>
    </li>
    <li>
        <div class="goodsPostEntryListIntro">
            <h3>整店同步</h3>
            <p>有淘宝商品没有展示在四季星座网？上下架状态不一致？整店同步一次商品可以解决您的问题！</p>
        </div>
        <div class="clickButton" data-id="${session_user_redis__.logshop.shopId!}">
            <#if query.feedback?? && query.feedback gt 0>
                <#if query.feedback == 1>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        jbtn="toSq"
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
        立即同步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#list [{"jid":"toSq","options":[{"name":"tipConText","value":"您未授权淘宝店铺"},{"name":"href_","value":"/seller/ghTongbu.htm"},{"name":"tipIcon","value":"errorTipIcon"},{"name":"btText","value":"立即授权"}]}] as $it>
<div jid="${$it.jid!}">
    <#list $it.options as option>
    <input type="hidden" name="${option.name!}" value="${option.value!}" />
    </#list>
</div>
</#list>
                <#elseif query.feedback == 2>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        jbtn="againSq"
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
        立即同步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
<#list [{"jid":"againSq","options":[{"name":"tipConText","value":"您的淘宝店授权过期"},{"name":"href_","value":"/ortherLogin.htm?ortherLoginType=1&backUrl=/seller/createGoods21init.htm"},{"name":"tipIcon","value":"errorTipIcon"},{"name":"btText","value":"重新授权"}]}] as $it>
<div jid="${$it.jid!}">
    <#list $it.options as option>
    <input type="hidden" name="${option.name!}" value="${option.value!}" />
    </#list>
</div>
</#list>
                </#if>
            <#else>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        jbtn="toTb"
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
        立即同步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </#if>
        </div>
    </li>
<#elseif session_user_redis__.logshop.type == 2>
    <li>
        <div class="goodsPostEntryListIntro">
            <h3>添加数据包</h3>
            <p>您可以通过数据包形式上传商品到四季星座网店铺中！</p>
            <p class="fcF40">*注：添加的数据包必须为zip格式的压缩包（压缩包中必须包含对应csv格式文件和对应图片文件夹），否则系统无法解析！</p>
        </div>
        <div class="clickButton">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="uploadGoodsPackage"
>
        添加数据包
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </li>
    <li>
        <div class="goodsPostEntryListIntro">
            <h3>手动发布</h3>
            <p>您也可以手动发布非淘宝店铺中出售的商品到四季星座网店铺中！</p>
        </div>
        <div class="clickButton">
<#list [{}] as $it>
    <a href="releaseGoodsinit.htm"
    class="fmButton
         fmButton-blue
         publishBtn"
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
        手动发布
    </a>
</#list>
        </div>
    </li>
</#if>
</ul>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>