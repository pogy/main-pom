<#assign $pageid="search">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>星座搜索 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__search_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/search__common_js.ftl">
<#include "/__style_torrent__/search__search_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="goods">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#list [{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"mid","value":""+query.mid},{"name":"pid","value":""+query.pid},{"name":"cid","value":""+query.cid},{"name":"sort","value":""+query.sort},{"name":"d","value":""+query.d},{"name":"sp","value":""+query.sp},{"name":"ep","value":""+query.ep},{"name":"keyword","value":""+query.keyword},{"name":"page","value":""+query.page}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</script>
<#include "/__ftl_links__/search__common__nav.ftl">
<div class="layout clearfix">
    <div class="fl leftContent">
<#if topShopList??>
<div class="topShopList">
    <#list topShopList as shop>
    <div class="shopbox">
        <div class="r1">
            <em>${shop.storeNum!}</em>
        </div>
        <div class="r2 yahei">
            <p class="p1" title="${shop.marketName!} ${shop.storeNum!}">${shop.marketName!} ${shop.storeNum!}</p>
            <p class="p2">主营类目：${shop.mainCate!}</p>
            <p class="p2">宝贝件数：${shop.goodsCount!}件</p>
        </div>
        <div class="r3">
            <a class="a2" href="/shop.htm?id=${shop.storeId!}" target="_blank">进入店铺</a>
        </div>
        <div class="r4">
            <a href="${shop.otherStoreUrl!}" target="_blank">进入相关店铺</a>
        </div>
    </div>
    </#list>
</div>
</#if>
<#include "/__ftl_links__/search__common__catFilterBar.ftl">
<#include "/__ftl_links__/search__common__rankFliterBar.ftl">
<#if (goodslist?size) gt 0>
    <div class="goodsList clearfix">
        <#list goodslist as goods>
            <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/v6/search/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                </a>
                <p class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                <#if goods.goodsNo?? && goods.goodsNo != "">
                    <p class="goodsNo"><a href="/item.htm?id=${goods.id!}" target="_blank" title="${goods.goodsNo!}">货号：${goods.highLightGoodsNo!}</a></p>
                <#else>
                    <p class="title"><a href="/item.htm?id=${goods.id!}" target="_blank" title="${goods.title!}">${goods.highLightTitle!}</a></p>
                </#if>
                <div class="p3">
                    <span class="storeName"><a href="/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
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
<div class="goodslistEmptyCon">
    <p class="fs18 yahei fc6">Sorry, 未查询到相应商品~</p>
</div>
</#if>
    </div>
<div class="goodsCommand fr">
    <h3><em>商品推荐</em><i></i></h3>
    <#if (tjGoodsList?size) gt 0>
        <ul>
            <#list tjGoodsList as goods>
            <li>
                <a class="imgbox" href="/item.htm?id=${goods.id!}" target="_blank"><img src="${goods.imgsrc!}_240x240.jpg"></a>
                <p>
                    <em class="money yahei">&yen;${goods.piprice!}</em>
                    <a class="storename" href="/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
                </p>
            </li>
            </#list>
        </ul>
    <#else>
        <p class="empty">暂无数据</p>
    </#if>
</div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">