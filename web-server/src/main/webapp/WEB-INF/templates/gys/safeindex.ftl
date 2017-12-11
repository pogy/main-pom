<#assign $pageid>safeindex</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>安全设置 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__safeindex_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__safeindex_js.ftl">
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
            <#assign sidebarType>safecenter</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<ul class="safeLevel">
    <li class="d1 yahei">安全等级</li>
    <li class="d2">${safe_level!}</li>
    <li class="d3">
        <div class="iwrapper">
            <em class="e1"></em>
            <em class="e2" style="width:${safe_level!}%"></em>
        </div>
    </li>
</ul>
<div class="infobox">
    <ul class="clearfix">
        <li class="d1"><i class="iconfont mm"></i></li>
        <li class="d2">
            <p>
                登录密码
                <#if info_pwd == 'low'>
                <em class="no"><i class="iconfont">&#xe697;</i>低</em>
                <#elseif info_pwd == 'hign'>
                <em class="yes"><i class="iconfont">&#xe68a;</i>高</em>
                <#else>
                <em class="yes"><i class="iconfont">&#xe68a;</i>中</em>
                </#if>
            </p>
            <p class="desc">安全性高的密码可以使账号更安全。建议您定期更换密码，且设置一个包含数字和字母，并长度超过6位以上的密码。</p>
        </li>
        <li class="d3">
            <a href="safexgmm.htm">修改密码</a>
        </li>
    </ul>
    <ul class="clearfix">
        <li class="d1"><i class="iconfont phone"></i></li>
        <li class="d2">
            <p>
                手机绑定
                <#if info_mobile == true>
                <em class="mobileNum">${text_mobile!}</em>
                <#else>
                <em class="no"><i class="iconfont">&#xe697;</i>未绑定</em>
                </#if>
            </p>
            <p class="desc">绑定手机后，便于支付时接收动态密码及发货等方便用户的功能。</p>
        </li>
    </ul>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">