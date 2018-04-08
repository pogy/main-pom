<div class="header">
    <div class="headerContainer  layout950  clearfix">
        <a href="index.html" class="logo"></a>
        <span class="pageTag">
            <#if $pageid =='login'>
            欢迎登录
            <#elseif $pageid == 'regedit'>
            欢迎注册
            </#if>
        </span>
        <#if $pageid == 'login'>
            <p class="guideInfo">还没有四季星座网账号？<a href="regedit.htm">立即注册</a></p>
        <#else>
            <p class="guideInfo">已有四季星座网账号了？<a href="login.htm">立即登录 </a></p>
        </#if>
    </div>
</div>