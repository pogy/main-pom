<#assign $pageid="goodsDataPackageinit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>已生成的数据包 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__goodsDataPackageinit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__goodsDataPackageinit_js.ftl">
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
<div class="pageTabs clearfix yahei">
    <ul>
        <li><a href="goodsCollectinit.htm">我的数据包</a></li>
        <li class="select"><a href="goodsDataPackageinit.htm">已生成的数据包</a></li>
    </ul>
</div>
<div class="dataList goodsList" id="goodsList">
    <ul class="head clearfix">
        <li class="name">
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
            name="allItems"
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
        全选
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
            <button jbtn="removePacketed">全部删除</button>
        </li>
        <li class="count">未下架的商品数</li>
        <li class="time">时间</li>
        <li class="control">操作</li>
    </ul>
    <#if (goodslist?size) gt 0>
        <#list goodslist as packet>
            <ul class="body clearfix">
                <li class="name">
                    <dl>
                    <#if packet.remark10??>
                        <dt>
<#list [{"value":packet.dataPackageId}] as $it>
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
            name="packetItem"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="allItems"
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                            <a class="piclink" href="javascript:;" title="查看宝贝详情"><img src="${packet.remark9!}"></a>
                            <p><a class="title" href="javascript:;" title="${packet.remark10!}">${packet.remark10!}</a></p>
                        </dt>
                    <#else>
                        <#list packet.goods as goods>
                            <#if goods_index == 0>
                            <dt>
<#list [{"value":packet.dataPackageId}] as $it>
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
            name="packetItem"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="allItems"
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                                <a class="piclink" href="#" title="查看宝贝详情" target="_blank"><img src="${goods.imgsrc!}"></a>
                                <p><a class="title" href="/item.htm?id=${goods.id!}" title="查看宝贝详情" target="_blank">标题：${goods.title!}</a></p>
                            </dt>
                            </#if>
                            <dd>
                                <i class="line"></i>
                                <a class="piclink smallpic" href="#" title="查看宝贝详情" target="_blank"><img src="${goods.imgsrc!}"></a>
                                <p><a class="title" href="/item.htm?id=${goods.id!}" title="查看宝贝详情" target="_blank">标题：${goods.title!}</a></p>
                            </dd>
                        </#list>
                    </#if>
                    </dl>
                </li>
                <li class="count">
                    <#if packet.remark10??>
                        数据包中的商品都已下架
                    <#else>
                        ${(packet.goods?size)!}
                    </#if>
                </li>
                <li class="time">${packet.createtime!}</li>
                <li class="control">
                    <a href="${packet.href!}" target="_blank">下载</a>
                    <button jbtn="removePacketed" packetid=${packet.dataPackageId!}>删除</button>
                    <#if !packet.remark10>
                        <#if (goodslist?size) gt 0>
                            <button jbtn="togglePacketGoods">展开</button>
                        </#if>
                    </#if>
                </li>
            </ul>
        </#list>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    <#else>
        <p class="noData">暂无已生成的数据包！</p>
    </#if>
</div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">