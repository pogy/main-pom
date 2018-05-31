<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if userIcon??>
        <img src="${userIcon!}">
        <#else>
        <img src="http://style.571xz.com/v6/daifa/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="/init/logout.htm" class="fcF40 fs16">退出</a>
        <input id="menus" type="hidden" value="${menu!}"/>
    </div>
</div>