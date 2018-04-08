<#assign $pageid="addCourierTemp">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>星座网代发 - 添加快递模板</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__addCourierTemp_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__addCourierTemp_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="courierTempEdit">
    <div class="tempCon">
        <div class="topConSetBox">
            <div class="leftBox fl">
                <strong>快递名称：</strong>
<#list [{}] as $it>
<div class="fmSelect" id="courierId">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
<#list [{}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
            </#if>
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        开启
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            </div>
            <div class="rightBox fr">
                <span>默认运费：</span>
            </div>
        </div>
<div class="tempTable" data-tempid="${tempId!}">
    <div class="head">
        <ul>
            <li class="courierWay">
                <p>运送到</p>
                <p><b class="fcBlue" jhand="addGroup">添加分组</b></p>
            </li>
            <li class="freightMoudle">
                <div class="freightBox">运费（元）<b class="fcBlue" jhand="addFreightBar">添加运费栏</b></div>
                <div class="freightTitle">
                    <ul>
                    </ul>
                </div>
            </li>
            <li class="ope">操作</li>
        </ul>
    </div>
    <div class="body">
    </div>
</div>
        <div class="saveTempBtnBox">
            <button type="button" class="fmButton fmButton-lighter-b" data-tempid="${tempId!}" jhand="saveTemp">保存</button>
        </div>
    </div>
</div>
<script modulepath="daifa/addCourierTemp#courierTempEdit">
var courierList = '${courierList!}';
$$.domready('#courierId', function(){
    var cGoodscCourier = [':请选择'];
    var childCourierList = JSON.parse(courierList);
    $.each(childCourierList, function(i, item){
        cGoodscCourier[i+1] = item.courierId + ':' + item.courierName
    })
    $$.select('#courierId', {
        options:cGoodscCourier
    })
});
</script>
    </div>
</div>