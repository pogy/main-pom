<#assign $pageid="xznzMerchants">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>保太和招商 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzPage__xznzMerchants_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzPage__xznzMerchants_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="banner"></div>
<div class="sowlj"></div>
<#if (openImgs?size) gt 0>
<div class="content layout">
    <h3></h3>
    <div class="slideBox" id="slideBox">
        <div class="hd">
			<ul></ul>
		</div>
		<div class="bd">
			<ul>
				<#list openImgs as img>
				<li><a><img src="${img.imgsrc!}"></a></li>
				</#list>
			</ul>
		</div>
    </div>
</div>
</#if>
<div class="bgContent"></div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">