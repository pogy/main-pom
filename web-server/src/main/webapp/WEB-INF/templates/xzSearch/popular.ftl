<#assign $pageid="popular">
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
<#include "/__style_torrent__/xzSearch__popular_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__popular_js.ftl">
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
            <#list goodsStyle as item>
                <div class="styleItem">
                    <#if item.titleText??>
                        <h3 class="styleTitle" name="${item.titleText!}"  id="style${item.id!}">
                            <#if item.titleImg??>
                                <img src="${item.titleImg!}" />
                            </#if>
                        </h3>
                    <#else>
                        <div class="mt40"></div>
                    </#if>
                    <ul class="clearfix">
                        <#list item.goodsList as goods>
                            <li class="goodsItem" >
                                <a href="//www.571xz.com/item.htm?id=${goods.goodsId!}" target="_blank" class="imgBox">
                                    <img src="${goods.imgSrc!}_300x300.jpg" alt="${goods.title!}" >
                                </a>
                                <h4 class="title"><a href="//www.571xz.com/item.htm?id=${goods.goodsId!}" target="_blank" title="${goods.title!}">${goods.title!}</a></h4>
                                <div class="goodsInfo clearfix pr fcF40">
                                    <span class="goodsPrice"><i>&yen;</i>${goods.piPriceString!}</span>
                                    <#if goods.shStatus == 0>
                                    <#elseif goods.shStatus == 1>
                                    <i class="thIcon"></i>
                                    <#elseif goods.shStatus == 2>
                                    <i class="hhIcon"></i>
                                    <#elseif goods.shStatus == 3>
                                    <i class="hhIcon"></i>
                                    <i class="thIcon"></i>
                                    </#if>
                                </div>
                                <div class="otherOpe clearfix">
                                    <a class="goodAddr text-999" href="//www.571xz.com/shop.htm?id=${goods.shopId!}" target="_blank" title="${goods.marketName!} ${goods.shopNum!}">${goods.marketName!} ${goods.shopNum!}</a>
                                    <a class="oneKeyUp" href="//www.571xz.com/item.htm?id=${goods.goodsId!}">一键上传 ></a>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </#list>
        </div>
    </div>
</div>
<div class="leftSidebar yahei">
    <div class="styleDot">
        <ul id="leftSidebarbox"></ul>
    </div>
    <div class="toTop">返回顶部<i class="topRow"></i></div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">