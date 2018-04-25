<#assign $pageid>parcelSweepCode</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>包裹扫码 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__parcelSweepCode_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__parcelSweepCode_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="scanPost">
    <label>快递单号：</label><input type="text" class="fmInput fmInput-lg fs14 yahei scanPostCode" placeholder="扫描或者输入快递单号">
    <div class="postCon">
        <ul>
            <li><label>快递单号：</label><span class="postCodeCon"><!--1234567890987654--></span></li>
            <li><label>快递名称：</label><span class="postNameCon"><!--申通快递--></span></li>
            <li><label>查询结果：</label><span class="callbackMsg"><!--已查询到此快递单在如下售后订单中，并且已自动标记已收到售后商品--></span></li>
        </ul>
    </div>
    <div class="printGoodsTabBox"><b jbtn="printGoodsTab" class="printGoodsTabBtn">打印商品标签</b></div>
    <div class="setWareBox"><b jbtn="setWareBtn" class="setWareBtn">保存包裹信息并入库登记</b></div>
</div>
<div class="orderCon">
</div>
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