<#assign $pageid>regedit</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>注册 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__regedit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__regedit_js.ftl">
</head>
<body>
<#include "/__ftl_links__/login__common__header.ftl">
<div class="regeditContainer layout950">
<div class="regeditForm validateForm">
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>手机号码：</label>
            <input type="text" name="telephone" class="fmInput" maxlength="11" placeholder="请输入手机号码"    >
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>数字验证码：</label>
            <input type="text" name="imgValidate"  class="imgValidate fmInput" maxlength="4" placeholder="右侧验证码"  >
            <img id="checkCode" src="http://www.571xz.com/IMG.htm">
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>短信验证码：</label>
            <input type="text" name="msgValidate" class="fmInput" maxlength="6" placeholder="请输入短信验证码" >
            <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>密码：</label>
            <input type="password" name="password" class="fmInput" maxlength="20" placeholder="请输入登录密码" >
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label><i>*</i>确认密码：</label>
            <input type="password" name="confirmPassword" class="fmInput" maxlength="20" placeholder="再次输入密码" >
        </div>
    </div>
    <div class="validateItem">
        <div class="formGroup">
            <label></label>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         regeditButton"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="regeditButton"
>
        立即注册
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        </div>
    </div>
    <div class="checkContract">点击“立即注册”，即表示您同意并愿意遵守四季星座网<a href="privacy.htm" target="_blank">隐私政策</a>和<a href="contract.htm" target="_blank">服务条款</a></div>
</div>
    <div class="regeditFastLoginIn">
<div class="fastLoginList">
    <p>你也可以用以下方式登录：</p>
    <ul>
        <li><a href="ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="icon-s-taobao"></i><span>淘宝账号</span></a></li>
        <li><a href="ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆"><i class="icon-s-alibaba"></i><span>阿里巴巴账号</span></a></li>
        <li><a href="ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆"><i class="icon-s-weixin"></i><span>微信</span></a></li>
    </ul>
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