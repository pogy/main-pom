<#assign $pageid>actDetails</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>活动报名 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__actDetails_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__actDetails_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
<ol class="pageNav clearfix">
    <li><a class="index" href="http://www.571xz.com/">首页</a><em>/</em></li>
    <li><a href="javascript:;">营销中心</a><em>/</em></li>
    <li><a href="actRegister.htm">活动报名</a><em>/</em></li>
    <li><a href="javascript:;" class="active">${actDetails.actTitle!}</a></li>
</ol>
<div class="actDetail clearfix">
    <div class="leftImg">
        <img src="${actDetails.actImg!}" alt="">
    </div>
    <div class="actProcess content shadow-box">
        <h3 class="title">${actDetails.actTitle!}<span><#if actDetails.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span></h3>
        <p class="applyRange">${actDetails.applyRange!}</p>
        <p class="actTime">
            <span class="actStartTime">活动开始时间：${actDetails.actStartTime!}</span>
            <span class="actEndTime">活动结束时间：${actDetails.actEndTime!}</span>
        </p>
        <div class="charge clearfix">
            <p>推广渠道：<span>${actDetails.actPosition!}</span></p>
            <p>收费标准：<span><#if actDetails.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span></p>
        </div>
        <div class="applyQualify clearfix">
            <h3 class="title">报名条件：</h3>
            <div class="qualifyContent">
                ${actDetails.applyCondition}
            </div>
        </div>
        <div class="uploadImgBox clearfix">
            <div class=" clearfix">
                <div class="activityInfo">
                    <h3 class="title">活动商品信息：</h3>
                    <ul>
                        <li class="clearfix">
                            <label>商品1：</label>
                            <input name="goodsUrl" type="text" placeholder="请输入产品链接">
                        </li>
                    </ul>
                </div>
                <div class="contactPhone">
                    <h3 class="title">联系方式：</h3>
                    <div class="clearfix">
                        <input type="text" name="tel" value="" placeholder="请输入您的手机号码">
                    </div>
                </div>
            </div>
            <div class="checkBtns">
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         goRegister"
        jhand="doSubmit"
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
        我要报名
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
    </div>
</div>
<script modulepath="gys/actDetails#actDetail">
var actidVal = '${RequestParameters.actid!}';/*query.actid，ftl可通过Request直接去请求的参数*/
</script>
    </div>
</div>
<#include "/common/xz__footer.ftl">