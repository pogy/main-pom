<#assign $pageid="photoIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>首页 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__photoIndex_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__photoIndex_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<div class="firstScreen yahei">
    <div class="layout">
<div class="menuList fl">
    <#list menuList as menu>
        <div class="menuItems <#if menu.menuId == 'userHomePage'>lastone</#if>">
            <h3>${menu.menuText!}
            <#if menu.menuId == 'userHomePage'>
                <a href="/photo/photoPlace.htm" target="_blank" class="fr">更多&gt;</a>
            <#else>
                <a href="/photo/${menu.menuId!}.htm" target="_blank" class="fr">更多&gt;</a>
            </#if>
            </h3>
            <div class="menuItem">
                <#list menu.items as item>
                    <#if menu.menuId == 'photoWorks'>
                        <a href="/photo/${menu.menuId!}.htm?sid=${item.id!}" target="_blank">${item.text!}</a>
                    <#elseif menu.menuId == 'photoOrg'>
                        <a href="/photo/${menu.menuId!}.htm?coid=${item.id!}" target="_blank">${item.text!}</a>
                    <#elseif menu.menuId == 'photoModel'>
                        <a href="/photo/${menu.menuId!}.htm?crid=${item.id!}" target="_blank">${item.text!}</a>
                    <#else>
                        <a href="/photo/${menu.menuId!}.htm?id=${item.id!}" target="_blank">${item.text!}</a>
                    </#if>
                </#list>
            </div>
        </div>
    </#list>
</div>
<div class="focusPics fl">
    <div id="slideBox" class="slideBox">
		<div class="hd">
			<ul></ul>
		</div>
		<div class="bd">
			<ul>
				<#list photoBanner as banner>
				    <li>
				        <a href="${banner.href!}" target="_blank">
				        <img src="${banner.imgsrc!}"></a>
				    </li>
				</#list>
			</ul>
		</div>
		<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
		<a class="prev" href="javascript:void(0)"></a>
		<a class="next" href="javascript:void(0)"></a>
	</div>
</div>
<div class="rightSide fr">
    <div class="userLogin" id="userLoginInfo">
        <div class="userHeadImg">
            <img src="//style.571xz.com/v6/photo/css/img/userDefault.png" />
        </div>
        <p>您好 ，请登录！</p>
        <a href="/photo/member/userWorkList.htm">用户主页</a>
    </div>
    <img src="${littleBannerSrc!}" class="littleBanner" />
</div>
    </div>
</div>
<div class="coverList yahei layout modelList">
    <h2 class="listTitle">网红模特 <a href="/photo/photoModel.htm">更多 &gt;</a></h2>
    <div class="listContent">
        <div class="itemWrap">
            <#list modelCoverList as item>
<#include "/__ftl_links__/photo__common__roleItem.ftl">
            </#list>
        </div>
    </div>
</div>
<div class="coverList yahei layout">
    <h2 class="listTitle">摄影机构<a href="/photo/photoOrg.htm">更多 &gt;</a></h2>
    <div class="listContent">
        <div class="itemWrap">
            <#list orgCoverList as item>
<#include "/__ftl_links__/photo__common__roleItem.ftl">
            </#list>
        </div>
    </div>
</div>
<div class="coverList yahei layout">
    <h2 class="listTitle">热门作品 <a href="/photo/photoWorks.htm">更多 &gt;</a></h2>
    <div class="popWorks layout">
        <div class="worksBox">
            <#list workList as item>
<#include "/__ftl_links__/photo__common__coverItem.ftl">
            </#list>
        </div>
    </div>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">