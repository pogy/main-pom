<#assign $pageid="editCourierTemp">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>星座网代发 - 编辑快递模板</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__editCourierTemp_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__editCourierTemp_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="courierTempEdit">
    <div class="addTempBox">
<#list [{}] as $it>
    <a href="addCourierTemp.htm"
    class="fmButton
         fmButton-lighter-b
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
        增加快递
    </a>
</#list></div>
<div class="tempCon">
    <div class="topConSetBox">
        <div class="leftBox fl">
            <strong>快递名称：</strong>
<#list [{"value":courierId}] as $it>
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
<#list [{"checked":initiateIs}] as $it>
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
            <#list freightList as fre>
            <span data-freightid="${fre.freightId!}" class="defaultFre">${fre.text!} <input type="number" value="${fre.costFee!}" placeholder="暂无">元，</span>
            </#list>
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
                        <#list freightList as fre>
                        <li class="freText" data-freightid="${fre.freightId!}" data-threshold="${fre.threshold!}">${fre.text!} <b class="fcBlue" jhand="deleteFreightBar">删除</b></li>
                        </#list>
                    </ul>
                </div>
            </li>
            <li class="ope">操作</li>
        </ul>
    </div>
    <div class="body">
        <#list groupList as item>
        <ul class="groupItem" data-groupid="${item.groupId!}">
            <li class="courierWay">
                <span class="provs">${item.provs!}</span>
                <b class="fr fcBlue" data-provids="${item.provIds!}" jhand="editProvs">编辑</b>
            </li>
            <li class="freightMoudle">
                <div class="freightTitle">
                    <ul>
                        <#list item.costFeeList as cost>
                        <li class="freText" data-freightid="${cost.freightId!}" data-threshold="${cost.threshold!}" data-freightchildid="${cost.freightChildId!}"><input type="number" value="${cost.costFee!}" placeholder="暂无"></li>
                        </#list>
                    </ul>
                </div>
            </li>
            <li class="ope"><b class="fcBlue" jhand="deleteGroup">删除</b></li>
        </ul>
        </#list>
    </div>
</div>
    <div class="saveTempBtnBox">
        <button type="button" class="fmButton fmButton-lighter-b" data-webtype="1" data-tempid="${tempId!}" jhand="saveTemp">保存</button>
    </div>
</div>
<script modulepath="daifa/editCourierTemp#tempCon">
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
</div>