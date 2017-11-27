<#assign $pageid>storeGoodsNoListinit</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>批量修改货号 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__storeGoodsNoListinit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__common_js.ftl">
<#include "/__style_torrent__/gys__storeGoodsNoListinit_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="pageTabs clearfix">
    <li class="tabbutton selected"><a href="javascript:;">批量修改货号</a></li>
</ul>
<input type="hidden" id="shopWebSite" value="${webSite!}">
<div class="numSave">
   <h1>宝贝件数：<em>${inSaleCount!}</em> 件</h1>
   <b class="save">保存</b>
</div>
<div class="gntable">
    <table>
        <thead>
            <tr>
                <th class="goods">宝贝</th>
                <th class="goods_no">货号</th>
                <th class="price">零售价(元)</th>
                <th class="piprice">批发价(元)</th>
                <th class="creat_time">上架时间</th>
            </tr>
        </thead>
        <tbody>
            <#if (dataList?size) gt 0>
                <#list dataList as goods>
                <tr>
                    <td class="goodsImg"><input type="hidden" class="goodsId" value="${goods.itemId!}"><a href="http://${webSite!}.571xz.com/item.htm?id=${goods.itemId!}" target="_blank"><img src="${goods.picUrl!}_80x80.jpg" width=80 height=80 /></a></td>
                    <td class="hh"><input type="text" class="goodsno" value="${goods.goodsNo!}"></td>
                    <td class="lsj"><input type="text" class="priceit" value="${goods.price!}"></td>
                    <td class="pfj"><input type="text" class="pipriceit" value="${goods.piPrice!}"></td>
                    <td class="sxsj">${goods.created!}</td>
                </tr>
               </#list>
           <#else>
<p class="goodsListIsEmpty">找不到结果</p>
           </#if>
        </tbody>
    </table>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
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
</#list>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">