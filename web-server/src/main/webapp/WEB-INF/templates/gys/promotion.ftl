<#assign $pageid="promotion">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>广告展示管理 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__promotion_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__promotion_js.ftl">
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
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">正在生效的广告</a></li>
    <li class="tabbutton"><a href="javascript:;">即将生效的广告</a></li>
</ul>
<div class="tabContent clearfix">
    <div class="goatBox clearfix">
        <#if (inForceList?size) gt 0>
            <#list inForceList as pos>
            <div class="posItem">
                <h3 class="posArea">${pos.code!}</h3>
                <div class="posList">
                    <#list pos.posList as list>
                    <div class="posInfo" <#if list.goodsId?? && list.goodsId != ''> data-goodsid="${list.goodsId!}" </#if> data-codeid="${list.codeId!}">
                        <#if list.picUrl?? && list.picUrl != ''>
                        <div class="imgBox">
                            <img src="${list.picUrl!}">
                        </div>
                        <#else>
                        <div class="imgBox">
                            <img src="//style.571xz.com/v6/gys/css/img/ggDefault.jpg">
                        </div>
                        </#if>
                        <p class="validTime">有效期：${list.startOnline!} - ${list.endOnline!}</p>
                        <#if list.goodsId??>
                        <b class="reRelateBtn" jhand="openGlWindow" data-codeid="${list.codeId!}">重新关联</b>
                        <#else>
                        <b class="relateBtn" jhand="openGlWindow" data-codeid="${list.codeId!}">立即关联商品</b>
                        </#if>
                    </div>
                    </#list>
                </div>
            </div>
            </#list>
        <#else>
            <p class="noPos">您还没有购买广告位，看不到推广信息哦！</p>
        </#if>
    </div>
    <div class="goatBox clearfix" style="display:none">
        <#if (willInForceList?size) gt 0>
            <#list willInForceList as pos>
            <div class="posItem">
                <h3 class="posArea">${pos.code!}</h3>
                <div class="posList">
                    <#list pos.posList as list>
                    <div class="posInfo" <#if list.goodsId?? && list.goodsId != ''> data-goodsid="${list.goodsId!}" </#if> data-codeid="${list.codeId!}">
                        <#if list.picUrl?? && list.picUrl != ''>
                        <div class="imgBox">
                            <img src="${list.picUrl!}">
                        </div>
                        <#else>
                        <div class="imgBox">
                            <img src="//style.571xz.com/v6/gys/css/img/ggDefault.jpg">
                        </div>
                        </#if>
                        <p class="validTime">有效期：${list.startOnline!} - ${list.endOnline!}</p>
                        <#if pos.goodsId??>
                        <b class="reRelateBtn" jhand="openGlWindow" data-codeid="${list.codeId!}">重新关联</b>
                        <#else>
                        <b class="relateBtn" jhand="openGlWindow" data-codeid="${list.codeId!}">立即关联商品</b>
                        </#if>
                    </div>
                    </#list>
                </div>
            </div>
            </#list>
        <#else>
        <p class="noPos">您还没有购买广告位，看不到推广信息哦！</p>
        </#if>
    </div>
</div>
<#list [{}] as $it>
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
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>