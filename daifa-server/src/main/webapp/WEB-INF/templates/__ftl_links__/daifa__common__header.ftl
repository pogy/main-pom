<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if userIcon?? && userIcon?length gt 0>
        <img src="${userIcon!}">
        <#else>
        <img src="../img/LOGO_3.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="/init/logout.htm" class="fcF40 fs16">退出</a>
        <input id="menus" type="hidden" value="${menu!}"/>
    </div>
</div>