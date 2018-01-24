<#assign $pageid="styleRecommd">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>风格商品推荐 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/styleChannel__common_css.ftl">
<#include "/__style_torrent__/styleChannel__styleRecommd_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/styleChannel__common_js.ftl">
<#include "/__style_torrent__/styleChannel__styleRecommd_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign isShowHoverCate=undefined>
<#include "/__ftl_links__/styleChannel__common__searchHeader.ftl">
<#list [{"fields":[{"name":"spid","value":""+query.spid}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#include "/__ftl_links__/styleChannel__common__pageNav.ftl">
<div class="layout">
<#list [{"style":"close"}] as $it>
<#include "/__ftl_links__/styleChannel__common__pageCateMenu.ftl">
</#list>
<#if (goodsList?size) gt 0>
    <div class="goodsList clearfix">
        <#list goodsList as goods>
            <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/v6/styleChannel/css/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                </a>
                <p class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                <#if goods.goodsNo?? && goods.goodsNo != "">
                    <p class="goodsNo"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank" title="${goods.goodsNo!}">货号：${goods.highLightGoodsNo}</a></p>
                <#else>
                    <p class="title"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank" title="${goods.title!}">${goods.highLightTitle}</a></p>
                </#if>
                <div class="p3">
                    <span class="storeName"><a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
<#list [{"id":""+goods.aliww}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
                    <div class="upload">
                        <em><i class="iconUp"></i>一键上传</em>
                        <div class="list">
                            <ul>
                                <li><a href="http://upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                                <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                                <li><a href="javascript:;" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
                                <li><a href="javascript:;" xzclick="addGoodsPkg" data-goodsid="${goods.id!}"><em class="iconAdd"></em>加入数据包</a></li>
                            </ul>
                            <i class="i2"></i>
                            <i class="i1"></i>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
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
<#include "/__ftl_links__/styleChannel__common__noDateTip.ftl">
</#if>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">