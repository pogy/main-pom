<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>登录 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/loginV2/css/loginWindow.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/loginV2/js/loginWindow.js"></script>
</head>
<body>


 





<div class="loginMode">
    <div class="loginContainer">
        <div class="loginHeader yahei fs16">
            <ul>
                <li class="current passwordLogin">账号登录</li>
                <li class="msgLogin">手机验证码登录</li>
            </ul>
        </div>
        <div class="loginSwitch">
            <div class="loginItems">
                <div class="errorTip"></div>
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="username" placeholder="账号" >
                </div>
                <div class="loginItem">
                    <label class="icon-password"></label>
                    <input type="password" class="fmInput-lg fmInput" name="password" placeholder="密码" >
                </div>
                <div class="loginItem fogertPassword">
                    <a href="${main_host!}forgetPassword.htm">忘记密码?</a>
                    <a href="${main_host!}regedit.htm" class="regegitEntery fr">注册账号</a>
                </div>
                <div class="loginItem">
                    

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="loginBtn"
    
>

    
        立即登录
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






</#list>

                </div>
            </div>
            <div class="loginItems"  style="display:none">
                <div class="errorTip"></div>
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="telephone" maxlength="11" placeholder="手机号码"  >
                </div>
                <div class="loginItem">
                    <label class="icon-verifycode"></label>
                    <input type="text" class="fmInput-lg fmInput msgIpt" name="msgValidate" maxlength="6" placeholder="短信验证码" >
                    <div class="getMsgBox"><button type="button" id="getMsgBtn">获取验证码</button></div>
                </div>
                 <div class="loginItem fogertPassword">
                    <a href="${main_host!}forgetPassword.htm">忘记密码?</a>
                    <a href="${main_host!}regedit.htm" class="regegitEntery fr">注册账号</a>
                </div>
                <div class="loginItem">
                    

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="msgLoginBtn"
    
>

    
        立即登录
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






</#list>

                </div>
            </div>
        </div>
    </div>
    <div class="fastLoginIn">
    <p>你也可以用以下方式登录：</p>
    <ul>
        <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="icon-s-taobao"></i><span>淘宝账号</span></a></li>
        <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆"><i class="icon-s-alibaba"></i><span>阿里巴巴账号</span></a></li>
        <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆"><i class="icon-s-weixin"></i><span>微信</span></a></li>
    </ul>
</div>


</div>

































<!--省略end，让浏览器自动添加-->


