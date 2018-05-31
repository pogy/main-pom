<#assign $pageid="showCourierTemp">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>星座网代发-快递模板</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__showCourierTemp_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__showCourierTemp_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="courierTempInfo">
    <div class="finalEditTime"><a href="addCourierTemp.htm" class="fr fcBlue">增加模板</a> <span class="fr fc9">最后编辑时间：${finalEditTime!}</span> </div>
    <div class="formTable">
        <div class="head">
            <ul>
                <li class="courierWay">快递方式</li>
                <li class="transportTo">运送到</li>
                <li class="courierFee">运费（元）</li>
                <li class="tempStatus">状态</li>
            </ul>
        </div>
        <div class="body">
            <#list courierTempList as item>
            <ul class="freightTextBox <#if item_index%2 == 0>gray</#if>">
                <li class="courierWay"></li>
                <li class="transportTo"></li>
                <li class="courierFee">
                    <#list item.provsListByTemp as prov>
                        <#if prov_index == 0>
                            <#list prov.freightList as fre>
                            <div class="costText fl">${fre.text!}</div>
                            </#list>
                        </#if>
                    </#list>
                </li>
                <li class="tempStatus"></li>
            </ul>
            <ul class="<#if item_index%2 == 0>gray</#if>" tempId="${item.tempId!}">
                <li class="courierWay">${item.courierName!}</li>
                <li class="transportTo">
                    <#list item.provsListByTemp as prov>
                    <div class="provs">
                        ${prov.provs!}
                    </div>
                    </#list>
                </li>
                <li class="courierFee">
                    <#list item.provsListByTemp as prov>
                        <div class="costFeeBox">
                        <#list prov.freightList as fre>
                            <span class="costFee">${fre.freight!}</span>
                        </#list>
                        </div>
                    </#list>
                </li>
                <li class="tempStatus">
<#list [{"checked":item.initiateIs}] as $it>
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
            name="checkedIs"
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
        启动
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    <a href="editCourierTemp.htm?tempId=${item.tempId!}" class="fcBlue">编辑</a>
                </li>
            </ul>
            </#list>
        </div>
    </div>
</div>
    </div>
</div>