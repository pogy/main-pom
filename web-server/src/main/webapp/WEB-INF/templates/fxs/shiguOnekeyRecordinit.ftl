<#assign $pageid="shiguOnekeyRecordinit">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>已上传的商品 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__shiguOnekeyRecordinit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__common_js.ftl">
<#include "/__style_torrent__/fxs__shiguOnekeyRecordinit_js.ftl">
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
<#list [{"fields":[{"name":"uploadGoodsState","value":""+query.uploadGoodsState},{"name":"startTime","value":""+query.startTime},{"name":"endTime","value":""+query.endTime},{"name":"shopState","value":""+query.shopState},{"name":"tbState","value":""+query.tbState}]}] as $it>
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
        <li <#if !query.uploadGoodsState >class="select"</#if>><a href="javascript:;" data-state="">全部</a></li>
        <li <#if query.uploadGoodsState == 1 >class="select"</#if>><a href="javascript:;" data-state="1">档口在售</a></li>
        <li <#if query.uploadGoodsState == 2 >class="select"</#if>>
            <a href="javascript:;" class="pr" data-state="2">
                档口已下架
                <#if shopDownNum??>
                <i class="shopDownNum pa">${shopDownNum!}</i>
                </#if>
            </a>
        </li>
        <li <#if query.uploadGoodsState == 3 >class="select"</#if>><a href="javascript:;" data-state="3">历史上传</a></li>
    </ul>
</div>
<div class="searchBox">
    <ul class="clearfix">
        <li>
            <label>时间：</label>
            <input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" id="startTime" placeholder="开始时间" <#if query.startTime??>value="${query.startTime!}"</#if>>
            <span class="divideLine">-</span>
            <input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" id="endTime" placeholder="截止时间" <#if query.endTime??>value="${query.endTime!}"</#if>>
        </li>
        <#if query.uploadGoodsState != 1 && query.uploadGoodsState != 2>
        <li><label>档口状态：</label>
<#list [{"value":""+query.shopState}] as $it>
<div class="fmSelect" id="shopState">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list></li>
        <li><label>淘宝状态：</label>
<#list [{"value":""+query.tbState}] as $it>
<div class="fmSelect" id="tbState">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list></li>
        </#if>
        <li class="noMargin">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         searchBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="searchBtn"
>
        搜索订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </li>
    </ul>
</div>
<div id="goodsList" class="dataList goodsList">
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
            <button jbtn="downTbGoods">批量淘宝下架</button>
        </li>
        <li class="piprice">批发价(元)</li>
        <li class="gysName">供应商</li>
        <li class="upTime">上架时间</li>
        <li class="control">操作</li>
    </ul>
    <#if (goodsList?size) gt 0 >
        <#list goodsList as goods>
        <ul class="body clearfix" goodsid="${goods.goodsId!}">
            <li class="name">
                <#if goods.taobaoSaleState == 1>
<#list [{"value":goods.goodsId}] as $it>
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
                <#elseif goods.taobaoSaleState == 2>
                <span class="zwf fl"></span>
                </#if>
                <a class="piclink fl" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">
                    <img src="${goods.imgsrc!}_80x80.jpg">
                </a>
                <p class="fl">
                    <a class="title" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">${goods.title!}</a>
                </p>
                <p class="fl"><span>货号：${goods.goodsNo!}</span></p>
                <p class="fl">
                    <#if goods.shopSaleState == 1>
                    <i class="shopSaleState"></i>
                    <#elseif goods.shopSaleState == 2>
                    <i class="shopSaleState noSale"></i>
                    </#if>
                    <#if goods.taobaoSaleState == 1>
                    <i class="taobaoSaleState"></i>
                    <#elseif goods.taobaoSaleState == 2>
                    <i class="taobaoSaleState noSale"></i>
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
            <li class="upTime">
                <p>${goods.upTime!}</p>
            </li>
            <li class="control">
                <#if goods.taobaoSaleState == 1>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-o
        "
        jbtn="downTbGoods"
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
        淘宝下架
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
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
        <p class="fs20 fc6 tac">暂无数据</p>
    </#if>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">