<#assign $pageid="storeGoodsList21init">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>出售中的商品 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__storeGoodsList21init_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__storeGoodsList21init_js.ftl">
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
<#list [{"fields":[{"name":"state","value":query.state},{"name":"keyword","value":query.keyword},{"name":"goodsNo","value":query.goodsNo},{"name":"goodsStyle","value":query.goodsStyle}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="storeGoodsList21init.htm">出售中的商品<em>${goods_counts.sale!}</em></a></li>
</ul>
<div class="tabOptionsBox clearfix">
    <ul>
        <li <#if !query.state>class="select"</#if>><a href="storeGoodsList21init.htm">全部商品</a></li>
        <li <#if query.state == 1>class="select"</#if>>
            <a href="storeGoodsList21init.htm?state=1">无最低零售价
                <i id="noPriceNum"></i>
            </a>
        </li>
        <li <#if query.state == 2>class="select"</#if>>
            <a href="storeGoodsList21init.htm?state=2">无大图商品
                <i id="noBigpicNum"></i>
            </a>
        </li>
        <li <#if query.state == 3>class="select"</#if>>
            <a href="storeGoodsList21init.htm?state=3">无材料成分
                <i id="noMaterialNum"></i>
            </a>
        </li>
        <li <#if query.state == 4>class="select"</#if>>
            <a href="storeGoodsList21init.htm?state=4">无主图视频
                <i id="noVideoNum"></i>
            </a>
        </li>
        <li <#if query.state == 5>class="select"</#if>>
            <a href="storeGoodsList21init.htm?state=5">无风格标签
                <i id="noGoodsStyleNum"></i>
            </a>
        </li>
    </ul>
</div>
<div class="goodsFilterBar">
    <ul class="clearfix">
        <li><label>商品名称：</label><input id="keyword" class="textinput" value="${query.keyword!}"></li>
        <li><label>商品货号：</label><input id="goodsNo" class="textinput" value="${query.goodsNo!}"></li>
        <#if query.state != 5>
            <li>
                <label>商品风格：</label>
<#list [{"name":"goodsStyle","value":query.goodsStyle}] as $it>
<div class="fmSelect" id="goodsStyle">
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
        </#if>
        <li><button id="doGoodsFilterSearch">查询</button></li>
    </ul>
</div>
<script modulepath="gys/common#goodsFilterBar">
var goodsStyles = '${goodsStyles!}';
$$.domready('#goodsStyle', function(){
    var cGoodsStyles = [':全部']
    var childStyleList = JSON.parse(goodsStyles);
    $.each(childStyleList, function(i, item){
        cGoodsStyles[i+1] = item.scid + ':' + item.scname
    })
    $$.select('#goodsStyle', {
        options:cGoodsStyles
    })
});
</script>
<#if (goodslist?size) gt 0 >
    <#if query.state == 5>
<div class="goodsList" id="goodsList">
    <ul class="head clearfix">
        <li class="fiveName">
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
            <span style="display:inline-block; text-align:center;">商品名称</span>
        </li>
        <li class="fivePrice">批发价</li>
        <li class="fiveSetAttr">风格设置</li>
    </ul>
    <ul class="funOpe">
        <li>
            <#if session_user_redis__.logshop.type == 1>
            <button class="tbGoods" jhand="syncMultiTbGoods">批量同步商品</button>
            <button class="tbGoods" jhand="syncAllTbGoods" data-id="${session_user_redis__.logshop.shopId!}">同步整店商品</button>
            </#if>
            <button class="tbGoods" jhand="openEditGoodsStyleWindow">批量设置风格</button>
            <span>&nbsp;</span>
            <a href="http://zixun.571xz.com/detail?id=619" class="bigPicPro" target="_blank">大图设置教程</a>
            <a href="http://zixun.571xz.com/affiche/detail.htm?id=643" class="videoPro" target="_blank">主图视频使用指南</a>
        </li>
    </ul>
    <#list goodslist as item>
    <ul class="body clearfix" data-id="${item.id!}">
        <li class="fiveName">
<#list [{"value":item.id}] as $it>
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
            name="storeGoods"
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
            <a class="piclink" href="${item.href!}" title="查看宝贝详情" target="_blank">
                <img src="${item.imgsrc!}_80x80.jpg">
            </a>
            <p>
                <a class="title" href="${item.href!}" title="${item.title!}" target="_blank">${item.title!}</a>
                <span class="goodsNoParent">
                    <em>货号：</em>
                    <em class="goodsNo">${item.goodsNo!}</em>
                    <b class="penIcon" jhand="openEditGoodsNo"></b>
                </span>
            </p>
        </li>
        <li class="fivePrice">
            <p class="p2"><span>${item.price2!}</span><b class="penIcon" jhand="openEditPiPrice"></b></p>
        </li>
        <li class="fiveSetAttr">
            <div>
                <b jhand="openEditGoodsStyleWindow" data-goodsstyleid="${item.goodsStyleId!}">
                    <i class="icon-tag <#if item.goodsStyleType == 2> setted </#if>"></i>
                    <#if item.goodsStyleType == 2>
                    风格:${item.goodsStyleName!}
                    <#else>
                    风格标签
                    </#if>
                </b>
            </div>
        </li>
    </ul>
    </#list>
</div>
    <#else>
    <div class="goodsList" id="goodsList">
        <ul class="head clearfix">
            <li class="name">
                <#if session_user_redis__.logshop.type == 1 || query.state == 5>
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
                <!--<label><input type="checkbox" class="checkbox">全选</label>-->
                <#else>
                    <span style="display:block; text-align:center;">商品名称</span>
                </#if>
            </li>
            <li class="price">批发价</li>
            <li class="lowestPrice">最低零售价</li>
            <li class="setAttr">属性设置</li>
            <!--<li class="constituent">材料成分</li>
            <li class="bigPicCorrelate">大图关联</li>-->
            <li class="saleCount">总销量</li>
            <li class="upcount">上货量</li>
            <li class="control">操作</li>
        </ul>
        <ul class="funOpe">
            <li>
                <#if session_user_redis__.logshop.type == 1>
                <button class="tbGoods" jhand="syncMultiTbGoods">批量同步商品</button>
                <button class="tbGoods" jhand="syncAllTbGoods" data-id="${session_user_redis__.logshop.shopId!}">同步整店商品</button>
                </#if>
                <span>&nbsp;</span>
                <a href="http://zixun.571xz.com/detail?id=619" class="bigPicPro" target="_blank">大图设置教程</a>
                <a href="http://zixun.571xz.com/affiche/detail.htm?id=643" class="videoPro" target="_blank">主图视频使用指南</a>
            </li>
        </ul>
        <#list goodslist as item>
        <ul class="body clearfix" data-id="${item.id!}">
            <li class="name">
                <#if session_user_redis__.logshop.type == 1 || query.state == 5>
<#list [{"value":item.id}] as $it>
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
            name="storeGoods"
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
                <!--<input type="checkbox" class="checkbox" value="${item.id!}">-->
                </#if>
                <a class="piclink" href="${item.href!}" title="查看宝贝详情" target="_blank">
                    <img src="${item.imgsrc!}_80x80.jpg">
                </a>
                <p>
                    <a class="title" href="${item.href!}" title="${item.title!}" target="_blank">${item.title!}</a>
                    <span class="goodsNoParent">
                        <em>货号：</em>
                        <em class="goodsNo">${item.goodsNo!}</em>
                        <b class="penIcon" jhand="openEditGoodsNo"></b>
                    </span>
                </p>
            </li>
            <li class="price">
                <p class="p2"><span>${item.price2!}</span><b class="penIcon" jhand="openEditPiPrice"></b></p>
            </li>
            <li class="lowestPrice">
                <p class="p3"><span>${item.lowestLiPrice!}</span><b class="penIcon" jhand="openEditLowPrice"></b></p>
            </li>
            <li class="setAttr">
                <div class="">
                    <ul class="clearfix">
                        <li>
                            <b jhand="openEditBigPicWindow" data-type="${item.bigPicType!}" data-link="${item.linkHref!}" data-psw="${item.linkHrefPassword!}" >
                                <i class="icon-lgImg <#if item.correlateType == 2>setted</#if>"></i>
                                大图商品
                            </b>
                        </li>
                        <li>
                            <b jhand="openEditConstituentWindow" data-fabric="${item.fabric!}" data-infabric="${item.inFabric!}">
                                <i class="icon-materials <#if item.constituentType == 2>setted</#if>"></i>
                                材料成分
                            </b>
                        </li>
                        <li>
                            <b jhand="openEditGoodsStyleWindow" data-goodsstyleid="${item.goodsStyleId!}">
                                <i class="icon-tag <#if item.goodsStyleType == 2> setted </#if>"></i>
                                <#if item.goodsStyleType == 2>
                                风格:${item.goodsStyleName!}
                                <#else>
                                风格标签
                                </#if>
                            </b>
                        </li>
                        <li>
                            <b jhand="openEditGoodsVideoWindow" data-goodsvideourl="${item.goodsVideoUrl!}">
                                <i class="icon-video <#if item.goodsVideoType == 2> setted </#if>"></i>
                                主图视频
                            </b>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="saleCount">${item.saleCount!}</li>
            <li class="upcount">${item.count!}</li>
            <li class="control">
                <#if item.goodsSource == 1>
                <p><b class="tbGoods" jhand="syncTbGoods" data-goodsid="${item.id!}">同步商品</b></p>
                <#elseif item.goodsSource == 2>
                <p><em class="xjgoods" jhand="downGoods">下架</em></p>
                </#if>
            </li>
        </ul>
        </#list>
    </div>
    </#if>
<#list [{}] as $it>
<div class="jqPagination blue" id="jqPagination0"
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
<p class="goodsListIsEmpty">找不到结果</p>
</#if>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>