<#assign $pageid="goodsCollectOriginal">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>收藏的商品 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__goodsCollectOriginal_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__goodsCollectOriginal_js.ftl">
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
<#list [{"fields":[{"name":"website","value":""+query.website}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="pageTabs clearfix yahei">
    <ul>
        <li class="select"><a href="goodsCollectOriginal.htm">收藏的商品</a></li>
        <li><a href="storeCollectinit.htm">收藏的档口</a></li>
        <li class="website">
<#list [{"value":""+query.website}] as $it>
<div class="fmSelect" id="websiteList">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        </li>
    </ul>
</div>
<div class="dataList goodsList" id="goodsList">
    <ul class="head clearfix">
        <li class="name">
            <label>
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
            name="allFavoriteGoods"
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
            </label>
            <button jbtn="removeStoreGoods">批量删除</button>
        </li>
        <li class="piprice">批发价(元)</li>
        <li class="gysName">供应商</li>
        <li class="control">操作</li>
    </ul>
    <#if (goodsList?size) gt 0>
        <#list goodsList as goods>
            <ul class="body clearfix" data-id="${goods.collId!}">
                <li class="name">
<#list [{"value":goods.collId}] as $it>
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
            name="favoriteGoods"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            data-selectParent="allFavoriteGoods"
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
                    <a class="piclink fl" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">
                        <img src="${goods.imgSrc!}_80x80.jpg">
                    </a>
                    <p>
                        <a class="title" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">${goods.title!}</a>
                    </p>
                    <p><span>货号：${goods.goodsNo!}</span></p>
                    <p class="saleState">
                        <#if goods.onSaleIs == true>
                        <i class="inSale"></i>
                        <#else>
                        <i class="noSale"></i>
                        </#if>
                    </p>
                </li>
                <li class="piprice">
                    ${goods.piprice!}
                </li>
                <li class="gysName">
                    <p>${goods.marketName!}</p>
                    <p>${goods.shopNum!}</p>
                    <p>
<#list [{"id":goods.imWw}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
<#list [{"id":goods.imQq}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
                    </p>
                </li>
                <li class="control">
<#list [{"dataId":goods.collId}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-o
        "
        jbtn="removeStoreGoods"
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
        删除
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
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
        <p class="noData">暂无收藏的商品</p>
    </#if>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">