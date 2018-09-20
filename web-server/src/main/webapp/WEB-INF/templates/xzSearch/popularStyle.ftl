<#assign $pageid="popularStyle">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>${activeName!} - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__popularStyle_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__popularStyle_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="bannerImg">
    <div class="imgShow">
        <img src="${bannerSrc!}">
    </div>
</div>
<div style="background:${bgColor!};overflow:hidden;">
    <div class="goodsList layout">
        <div>
            <ul class="clearfix">
                <#list goodsList as goods>
                    <li class="goodsItem<#if (goods_index + 1) % 5 == 0> last</#if>">
                        <div class="goodsItemBox clearfix">
                            <div class="imgBox pr fl">
                                <a href="//www.571xz.com/item.htm?id=${goods.goodsId!}" target="_blank" class="">
                                    <img src="${goods.imgSrc!}_300x300.jpg" alt="${goods.title!}" >
                                </a>
                                <a class="pa goodAddr" href="//www.571xz.com/shop.htm?id=${goods.shopId!}" target="_blank" title="${goods.marketName!} ${goods.shopNum!}">${goods.marketName!} ${goods.shopNum!}</a>
                            </div>
                            <div class="goodsInfo fcF40">
                                <span class="goodsPrice"><i>&yen;</i>${goods.piPriceString!}</span>
                                <h4 class="title"><a href="//www.571xz.com/item.htm?id=${goods.goodsId!}" target="_blank" title="${goods.title!}">${goods.title!}</a></h4>
                            </div>
                            <div class="otherOpe fl clearfix">
                                <a class="oneKeyUp fs14" href="//www.571xz.com/item.htm?id=${goods.goodsId!}">一键上传 <i></i></a>
                            </div>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="paginationBox layout">
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
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">