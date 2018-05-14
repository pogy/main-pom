<#assign $pageid="photoShop">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>${shopInfo.marketName}${shopInfo.shopNo} - 相册 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/goodsDetail__common_css.ftl">
<#include "/__style_torrent__/goodsDetail__photoShop_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/goodsDetail__common_js.ftl">
<#include "/__style_torrent__/goodsDetail__photoShop_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="/">
                <img src="//style.571xz.com/v6/common/css/img/xz/mtLogo.png" alt="四季星座网" width="168" height="30">
            </a>
        </div>
        <div class="splitline"></div>
        <div class="shopInfobox hover">
            <div class="storeLogo icon-shop"></div>
            <div class="storeNamebox">
                <h3
                <#if shopInfo.domain??>
                    onclick="jumpShopLink('//${shopInfo.domain!}.571xz.com')"
                <#else>
                    onclick="jumpShopLink('/shop.htm?id=${shopInfo.shopId!}')"
                </#if>
                title="${shopInfo.marketName!}${shopInfo.shopNo!}">${shopInfo.marketName!}${shopInfo.shopNo!}</h3>
<#list [{"id":shopInfo.imWw}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
<#list [{"id":"${shopInfo.imQq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
                <i class="ti icon-downarrow"></i>
            </div>
<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                <#elseif webSite == "qz">
                    泉州
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>电话：</label>${shopInfo.mobile!}</li>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="//www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>
            <div class="storeXybox">
<#list [{"num":shopInfo.starNum}] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
            </div>
<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                <#elseif webSite == "qz">
                    泉州
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>电话：</label>${shopInfo.mobile!}</li>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="//www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>
        </div>
        <#if $pageid == 'photoShop' || $pageid == 'photoItem'>
        <div class="linkTab fr">
            <ul class="clearfix">
                <li class="fl"><a class="selected">相册</a></li>
                <li class="fl"><a href="${mainHost!}/shop/search.htm?id=${shopInfo.shopId!}">商品</a></li>
            </ul>
        </div>
        <#else>
        <form id="searchgo3" class="c_shop_search_2016" action="//so.571xz.com/${webSite!}search.htm">
            <button id="allSearchbtn">搜全站</button>
            <div class="shopSecrh">
                <div class="search">
                    <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text" value="<#if query??>${query.pstring!}</#if>">
                    <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
                </div>
            </div>
        </form>
        </#if>
    </div>
</div>
<#list [{"fields":[{"name":"cid","value":""+query.cid},{"name":"id","value":""+query.id}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="photoConBox">
<div class="layout">
    <div class="filterBox clearfix yahei">
        <label class="fl fc9">分类：</label>
        <ul class="clearfix fl">
            <li><a href="photoShop.htm?id=${shopInfo.shopId!}" <#if !query.cid>class="selected"</#if>>全部</a></li>
            <#list cates as cate>
            <li><a href="photoShop.htm?id=${shopInfo.shopId!}&cid=${cate.cateId!}" <#if query.cid == cate.cateId>class="selected"</#if>>${cate.cateName!}</a></li>
            </#list>
        </ul>
    </div>
</div>
<div class="layout pb70">
    <div class="photoAlbumList">
        <ul class="clearfix">
            <#list photoAlbums as item>
            <li>
                <a href="photoItem.htm?id=${item.id!}" target="_blank" class="imgBox">
                    <#if item.cover?? && item.cover != "">
                    <img src="${item.cover!}_200x200.jpg" alt>
                    <#else>
                    <img src="//style.571xz.com/v6/goodsDetail/css/img/defaultPic.png" alt>
                    </#if>
                </a>
                <p><a href="photoItem.htm?id=${item.id!}" target="_blank" class="ellip title" title="${item.title!}">${item.title!}</a><span class="fr">(${item.picCount!})</span></p>
                <p class="fc9"><span class="created">${item.created!}</span><span class="fr">浏览：${item.readCount!}</span></p>
            </li>
            </#list>
        </ul>
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
</div>
</div>
<#include "/common/xz__rightbar.ftl">
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">