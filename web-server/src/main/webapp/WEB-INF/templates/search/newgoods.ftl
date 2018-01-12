<#assign $pageid="newgoods">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>今日新品 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__newgoods_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/search__common_js.ftl">
<#include "/__style_torrent__/search__newgoods_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="goods">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/search__common__pageNav.ftl">
<div class="bgBox">
<div class="iconCateNav layout">
    <ul>
        <#list iconCateNav as cate>
        <li <#if cate.id?? && cate.id == query.cid>class="selected"</#if>>
            <a href="?cid=${cate.id!}&webSite=${webSite!}">
                <i class="icon-${cate.name!} ${cate.name!}"></i>
                <span>${cate.text!}</span>
            </a>
        </li>
        </#list>
    </ul>
</div>
<#if styleCateNavs?? && (styleCateNavs?size) gt 0>
    <div id="styleCateNav" class="styleCateNav clearfix layout">
        <em class="label">风格</em>
        <ul>
            <#list styleCateNavs as cate>
                <li><a href="?webSite=${webSite!}&keyword=${cate.keyword!}<#if query.cid??>&cid=${query.cid!}</#if>" <#if query.keyword == cate.keyword>class="selected"</#if>>${cate.text!}</a></li>
            </#list>
        </ul>
        <b class="show" jbtn="showHide">点击展开<i class="downRow"></i></b>
    </div>
</#if>
<div class="layout">
    <#if (goodslist?size) gt 0>
        <div class="newGoodsList clearfix">
             <#list goodslist as goods>
             <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_300x300.jpg" data-original="${goods.imgsrc!}_300x300.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/v6/search/css/img/opacity0.png" data-original="${goods.imgsrc!}_300x300.jpg">
                    </#if>
                </a>
                <div class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <div class="upload">
                        <em><i class="iconUp"></i>一键上传</em>
                        <div class="list">
                            <ul>
                                <li><a href="http://upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                                <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                                <li><a href="#" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
                                <li><a href="javascript:;" xzclick="addGoodsPkg" data-goodsid="${goods.id!}"><em class="iconAdd"></em>加入数据包</a></li>
                            </ul>
                            <i class="i2"></i>
                            <i class="i1"></i>
                        </div>
                    </div>
                </div>
                <p class="title"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">${goods.title!}</a></p>
                <div class="p3">
                    <span class="storeName"><a href="${mainHost!}/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
<#list [{"id":""+goods.aliww}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
                    <#if goods.postTimeText??><span class="viewCountBox">${goods.postTimeText!}</span></#if>
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
<div class="goodslistEmptyCon">
    <p class="fs18 yahei fc6">Sorry, 未查询到相应商品~</p>
</div>
    </#if>
</div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">