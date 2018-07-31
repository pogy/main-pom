<#assign $pageid="changeGoodsCate">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>苏宁类目更换 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/suning__changeGoodsCate_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/suning__changeGoodsCate_js.ftl">
</head>
<body>
<#include "/__ftl_links__/suning__common__topbar.ftl">
<div class="goodsCateChangeBox">
    <ul class="clearfix">
        <#list cates as cate>
        <li class="cate <#if cate.cid == query.cid>selected</#if>" data-id="${cate.cid!}">${cate.cname!}</li>
        </#list>
    </ul>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitCate"
>
        下一步，填写信息
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
<script modulepath="suning/changeGoodsCate#goodsCateChangeBox">
var goodsId = '${query.goodsId!}';
</script>
<#include "/common/cnzz.ftl">