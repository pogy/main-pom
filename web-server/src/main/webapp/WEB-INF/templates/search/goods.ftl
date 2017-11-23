<#assign $pageid>goods</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>商品库 - 四季星座网</title>
<#include "/common/base__config.ftl">
<#assign $pageid>goods</#assign>
<#assign webSite>hz</#assign>
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/search__goods_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/search__goods_js.ftl">
</head>
<body>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/search__common__header.ftl">
<#assign text>{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"mid","value":""+query.mid},{"name":"pid","value":""+query.pid},{"name":"cid","value":""+query.cid},{"name":"sort","value":""+query.sort},{"name":"d","value":""+query.d},{"name":"sp","value":""+query.sp},{"name":"ep","value":""+query.ep},{"name":"st","value":""+query.st},{"name":"et","value":""+query.et},{"name":"keyword","value":""+query.keyword},{"name":"page","value":""+query.page},{"name":"bpic","value":""+query.bpic},{"name":"goodsVideo","value":""+query.goodsVideo}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#include "/__ftl_links__/search__common__nav.ftl">
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
<#include "/__ftl_links__/search__common__goodsList.ftl">
    </div>
<div class="goodsCommand fr">
    <h3><em>商品推荐</em><i></i></h3>
    <#if (tjGoodsList?size) gt 0>
        <ul>
            <#list tjGoodsList as goods>
            <li>
                <a class="imgbox" href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank"><img src="${goods.imgsrc!}_240x240.jpg"></a>
                <p>
                    <em class="money yahei">&yen;${goods.piprice!}</em>
                    <a class="storename" href="http://www.571xz.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
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
                <a href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank" class="imgBox">
                    <img src="${goods.imgsrc!}_220x220.jpg" alt>
                </a>
                <a href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank" class="title" title="${goods.title!}">${goods.title!}</a>
                <p>
                    <span class="price">&yen;${goods.piprice!}</span>
                    <a href="http://${webSite!}.571xz.com/shop.htm?id=${goods.storeid!}" target="_blank" class="shopNum" title="${goods.fullStoreName!}">${goods.fullStoreName!}</a>
                </p>
            </li>
            </#list>
        </ul>
    </div>
</#if>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">