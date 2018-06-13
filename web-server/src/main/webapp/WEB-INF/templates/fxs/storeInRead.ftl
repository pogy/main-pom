<#assign $pageid="storeInRead">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>店铺申请信息 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__storeInRead_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__storeInRead_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<div class="formDataList">
    <#if applyInfo.applyFail?? && applyInfo.applyFail !="">
    <div class="errorTip yahei">
        抱歉，由于${applyInfo.applyFail!}，店铺申请未通过！
    </div>
    </#if>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 档口号：</label>
        <div class="formData">${applyInfo.storeNum!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 主营商品：</label>
        <div class="formData">${applyInfo.mainCate!}</div>
    </div>
    <#if applyInfo.hasTaobaoStore == "1">
        <div class="formDataItem">
            <label><span class="fcF40">*</span> 是否有淘宝店：</label>
            <div class="formData">
                <a class="tbUrl" href="${applyInfo.tbStoreUrl!}" target="_blank">${applyInfo.tbStoreUrl!}</a>
                <span>（${applyInfo.tbStoreName!}）</span>
            </div>
        </div>
    </#if>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 联系电话：</label>
        <div class="formData">${applyInfo.tel!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 微信号：</label>
        <div class="formData">${applyInfo.wx!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 旺旺号：</label>
        <div class="formData">${applyInfo.aliWw!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> QQ：</label>
        <div class="formData">${applyInfo.qq!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 电子邮箱：</label>
        <div class="formData">${applyInfo.email!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 所属市场：</label>
        <div class="formData">${applyInfo.cityName!}-${applyInfo.marketName!}-${applyInfo.marketFloorNum!}</div>
    </div>
    <div class="formDataItem">
        <label><span class="fcF40">*</span> 售后服务：</label>
        <div class="formData"><#if applyInfo.serverLevel == "0">不可退换<#elseif applyInfo.serverLevel == "1">可退<#elseif applyInfo.serverLevel == "2">可换<#else>可退可换</#if></div>
    </div>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>