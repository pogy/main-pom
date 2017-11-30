<#assign $pageid>fenxiaoZhanghao</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>第三方绑定 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__fenxiaoZhanghao_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__fenxiaoZhanghao_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>safecenter</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>账号绑定管理</a></li>
</ul>
<div class="accountList">
    <div class="tips">绑定手机号或者第三方账号即可通过该账号登录四季星座网</div>
    <ul class="itemBox clearfix">
        <#if outer_taobao??>
        <li class="bd">
            <div class="iconApplication">
                <i class="icon${outer_taobao.from!} iconApp"></i>
                <i class="iconBd"></i>
                <p>${outer_taobao.name!}</p>
            </div>
            <div class="status">
                <b class="unBind" jbtn="${outer_taobao.from!}" data-id="${outer_taobao.id!}">解绑</b>
            </div>
        </li>
        <#else>
        <li class="noBd">
            <div class="iconApplication">
                <i class="icontaobao iconApp"></i>
                <i class="iconBd"></i>
                <p>淘宝</p>
            </div>
            <div class="status">
                <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
            </div>
        </li>
        </#if>
        <#if outer_ali??>
        <li class="bd">
            <div class="iconApplication">
                <i class="icon${outer_ali.from!} iconApp"></i>
                <i class="iconBd"></i>
                <p>${outer_ali.name!}</p>
            </div>
            <div class="status">
                <b class="unBind" jbtn="${outer_ali.from!}" data-id="${outer_ali.id!}">解绑</b>
            </div>
        </li>
        <#else>
        <li class="noBd">
            <div class="iconApplication">
                <i class="iconali iconApp"></i>
                <i class="iconBd"></i>
                <p>阿里巴巴</p>
            </div>
            <div class="status">
                <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=2&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
            </div>
        </li>
        </#if>
        <#if outer_weixin??>
        <li class="bd">
            <div class="iconApplication">
                <i class="icon${outer_weixin.from!} iconApp"></i>
                <i class="iconBd"></i>
                <p>${outer_weixin.name!}</p>
            </div>
            <div class="status">
                <b class="unBind" jbtn="${outer_weixin.from!}" data-id="${outer_weixin.id!}">解绑</b>
            </div>
        </li>
        <#else>
        <li class="noBd">
            <div class="iconApplication">
                <i class="iconweixin iconApp"></i>
                <i class="iconBd"></i>
                <p>微信</p>
            </div>
            <div class="status">
                <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=4&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
            </div>
        </li>
        </#if>
    </ul>
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">