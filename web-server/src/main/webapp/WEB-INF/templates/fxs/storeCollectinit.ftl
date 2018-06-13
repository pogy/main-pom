<#assign $pageid="storeCollectinit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>收藏的档口 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__storeCollectinit_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__storeCollectinit_js.ftl">
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
        <li><a href="goodsCollectOriginal.htm">收藏的商品</a></li>
        <li class="select"><a href="storeCollectinit.htm">收藏的档口</a></li>
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
<div class="dataList shopList" id="shopList">
    <ul class="head clearfix">
        <li>
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
            </label>
            <button jbtn="removeStoreShops">批量删除</button>
        </li>
    </ul>
    <#if (shopList?size) gt 0>
        <#list shopList as shop>
            <ul class="body clearfix" data-id="${shop.collId!}">
                <li class="name">
<#list [{"value":shop.collId}] as $it>
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
                    <div class="fl">
                        <a class="imgBox fl" href="//www.571xz.com/shop.htm?id=${shop.shopId!}" target="_blank">
                            <#if shop.shopImgSrc??>
                                <img src="${shop.shopImgSrc!}_80x80.jpg">
                            <#else>
                                <img src="${$stylepath!}${$projectid!}/css/img/shopDefault.jpg">
                            </#if>
                        </a>
                        <div class="fl shopInfo">
                           <p>
                               <a class="marketAndShop" href="//www.571xz.com/shop.htm?id=${shop.shopId!}" target="_blank" title="${shop.marketName!}${shop.shopNum!}">${shop.marketName!}${shop.shopNum!}</a>
<#list [{"num":shop.starNum}] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
                           </p>
                           <p>
<#list [{"id":shop.imWw}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
<#list [{"id":shop.imQq}] as $it>
<#if $it.id != ''>
<a class="imQQ" href="//wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list></p>
                        </div>
                    </div>
                </li>
                <li class="shopGoodsImg">
                    <ul class="clearfix">
                        <#if (shop.goodsList?size) gt 0>
                            <#list shop.goodsList as goods>
                                <#if goods_index lt 4>
                                    <li>
                                        <a href="//www.571xz.com/item.htm?id=${goods.goodsId!}" target="_blank"><img src="${goods.imgSrc!}_180x180.jpg" width="150" height="150"></a>
                                    </li>
                                </#if>
                            </#list>
                        <#else>
                            <p class="fc6 notNewGoodsUp">暂时没有店铺的上新！去店铺看看吧～</p>
                        </#if>
                    </ul>
                    <p><a href="//www.571xz.com/shop.htm?id=${shop.shopId!}" target="_blank">查看更多></a></p>
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
        <p class="noData">暂无收藏的档口！</p>
    </#if>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>