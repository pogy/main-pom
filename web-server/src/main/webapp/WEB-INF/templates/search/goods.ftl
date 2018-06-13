<#assign $pageid="goods">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>商品库 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__goods_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/search__common_js.ftl">
<#include "/__style_torrent__/search__goods_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="goods">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/search__common__pageNav.ftl">
<#list [{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"mid","value":""+query.mid},{"name":"pid","value":""+query.pid},{"name":"cid","value":""+query.cid},{"name":"cname","value":""+query.cname},{"name":"sort","value":""+query.sort},{"name":"d","value":""+query.d},{"name":"sp","value":""+query.sp},{"name":"ep","value":""+query.ep},{"name":"st","value":""+query.st},{"name":"et","value":""+query.et},{"name":"keyword","value":""+query.keyword},{"name":"page","value":""+query.page},{"name":"bpic","value":""+query.bpic},{"name":"goodsVideo","value":""+query.goodsVideo}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="layout clearfix">
    <div class="fl leftContent">
<#include "/__ftl_links__/search__common__catFilterBar.ftl">
<#if query.pid??>
<div class="cateName clearfix">
    <h3 class="fs22 yahei"><#if query.pid == '30'>男装<#elseif query.pid == '16'>女装<#elseif query.pid == '50011740'>男鞋<#elseif query.pid == '50010404'>配饰<#elseif query.pid == '50006843'>女鞋<#elseif query.pid == '50006842'>箱包</#if></h3>
    <span>为您提供${goodsCount!}件宝贝</span>
</div>
</#if>
<#include "/__ftl_links__/search__common__rankFliterBar.ftl">
<#if webSite == 'hz'>
    <div class="otherFilterBox">
        <label><input id="toggleBpicFilter" type="checkbox" <#if query.bpic?? && query.bpic == 1>checked</#if>> 大图下载</label>
         <label><input id="toggleGoodsVideoFilter" type="checkbox" <#if query.goodsVideo?? && query.goodsVideo == 1>checked</#if>> 视频商品</label>
    </div>
</#if>
<#if (goodslist?size) gt 0>
    <div class="goodsList clearfix">
        <#list goodslist as goods>
            <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="//style.571xz.com/v6/search/css/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                </a>
                <p class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                <p class="title"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">${goods.title!}</a></p>
                <div class="p3">
                    <span class="storeName"><a href="${mainHost!}/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
<#list [{"id":""+goods.aliww}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
                    <div class="upload">
                        <em><i class="iconUp"></i>一键上传</em>
                        <div class="list">
                            <ul>
                                <li><a href="//upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                                <li><a href="//1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                                <li><a href="#" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
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
<#include "/__ftl_links__/search__common__noDateTip.ftl">
</#if>
    </div>
<div class="goodsCommand fr">
    <h3><em>商品推荐</em><i></i></h3>
    <#if (tjGoodsList?size) gt 0>
        <ul>
            <#list tjGoodsList as goods>
            <li>
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank"><img src="${goods.imgsrc!}_240x240.jpg"></a>
                <p>
                    <em class="money yahei">&yen;${goods.piprice!}</em>
                    <a class="storename" href="${mainHost!}/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
                </p>
            </li>
            </#list>
        </ul>
    <#else>
        <p class="empty">暂无数据</p>
    </#if>
</div>
</div>
<#if goodsGoats?? && (goodsGoats?size) gt 0>
    <div class="goodsGoat layout">
        <h3>掌柜热卖</h3>
        <ul class="clearfix">
            <#list goodsGoats as goods>
            <li>
                <a href="//www.571xz.com/item.htm?id=${goods.id!}" target="_blank" class="imgBox">
                    <img src="${goods.imgsrc!}_220x220.jpg" alt>
                </a>
                <a href="//www.571xz.com/item.htm?id=${goods.id!}" target="_blank" class="title" title="${goods.title!}">${goods.title!}</a>
                <p>
                    <span class="price">&yen;${goods.piprice!}</span>
                    <a href="//www.571xz.com/shop.htm?id=${goods.storeId!}" target="_blank" class="shopNum" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
                </p>
            </li>
            </#list>
        </ul>
    </div>
</#if>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">