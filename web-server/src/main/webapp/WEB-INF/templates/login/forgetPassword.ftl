<#assign $pageid="forgetPassword">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>忘记密码 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__forgetPassword_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__forgetPassword_js.ftl">
</head>
<body>
<#include "/__ftl_links__/login__common__header.ftl">
<div class="layout950">
    <div class="forgetPassword">
<div class="pwdStep">
    <ul>
        <li class="current"><span>1</span>填写手机号<i></i></li>
        <li><span>2</span>验证身份<i></i></li>
        <li><span>3</span>设置新密码<i></i></li>
        <li><span class="finish"></span>完成<i></i></li>
    </ul>
    <div class="line"></div>
</div>
<div class="pwdContainer validateForm">
    <div class="pwdForm">
        <div class="pwdValItems validateItem">
            <div class="pwdGroup">
                <label>手机号码：</label>
                <input type="text" class="fmInputNormal fmInput" name="telephone" maxlength="11" placeholder="请输入手机号码" >
            </div>
        </div>
        <div class="pwdValItems validateItem">
            <div class="pwdGroup">
                <label>数字验证码：</label>
                <input type="text" class="fmInputNormal fmInput imgValidate" maxlength="4" name="imgValidate" placeholder="右侧验证码" >
                <img id="checkCode" src="/IMG.htm" />
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepOne"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>短信验证码：</label>
                <input type="text" name="msgValidate" class="fmInputNormal fmInput" maxlength="6" placeholder="请输入短信验证码" >
                <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepTwo"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>密码：</label>
                <input type="password" class="fmInputNormal fmInput" name="password" maxlength="20" placeholder="请输入密码" >
            </div>
        </div>
        <div class="pwdValItems">
            <div class="pwdGroup">
                <label>确认密码：</label>
                <input type="password" class="fmInputNormal fmInput" name="confirmPassword" maxlength="20" placeholder="请再次输入密码" >
            </div>
        </div>
        <div class="pwdValItems">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         netxStep"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="stepThree"
>
        下一步
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="pwdForm" style="display:none">
        <div class="updateSuccess">
            <p>密码修改成功！</p>
            <div class="successTip"><span class="time">3</span>s 后跳转到<a href="/">网站首页</a></div>
        </div>
    </div>
</div>
    </div>
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap">
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://py.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br>
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            |
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <i class="bigIcon" title="浙公网安备"></i>
                浙公网安备 33010202000302号
            </a>
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">