<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录-[四季星座网]</title>
    <link href="http://style.571xz.com/login/css/login.css" rel="stylesheet">
    
        <#include "/common/host_config.ftl">

  </head>
<body class="c_login c_2016">
<div class="c_w100 c_m0auto c_head_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto rect-wrap clearfix">
            <a class="logo iconfont c_logo2016" href="http://www.571xz.com"></a>
            <h2>欢迎登录</h2>
        </div>
    </div>
</div>
<div class="c_w100 c_m0auto c_body_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto clearfix">
            <a href="${index_goat.href!}" target="_blank">
                <img src="${index_goat.imgsrc!}" width="572px" height="440px" class="fl c_img">
            </a>
            <div class="c_login_from j_login_from login571">
                <form method="post" id="login_form" action="login.htm<#if backUrl??>?backUrl=${backUrl!}</#if>">
                    <div class="head clearfix">
                        <h1 class="fl">欢迎登录</h1><span class="fr no_zh"><a class="c_c_ff4400" href="${main_host!}regedit.htm" target="_blank">立即注册</a></span>
                    </div>
                    <input class="loginxz" type="text" id="userName" name="userName" placeholder="用户名/邮箱/手机号" class="logintxt" value="${userName!}"  ><span class="ico_1"></span><span class="ico_2 j_ico_2 c_none"></span>
                    <input class="loginxz" type="password" id="password" name="password" placeholder="请输入密码" class="logintxt"  ><span class="ico_3"></span>
                    <div id="erralt" class="error-mess c_none">
                        <span class="error-icon fl"></span><span id="error-message" class="fl">${msg!}</span>
                    </div>
                    <div class="button clearfix">
                        <a class="fr" href="forgetPassword.htm" target="_blank">忘记登录密码？</a>
                        
                    </div>
                    <a onClick="checkForm()" class="button c_b_ff4400 login-btn" alt="立即登录" title="立即登录" >立即登录</a>
                </form>
                <ul class="login3 loginlist clearfix">
                    <li class="thirth loginlist_ico1"><a href="${main_host!}ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆">淘宝账号<i></i></a></li>
                    <li class="thirth loginlist_ico2"><a href="${main_host!}ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆">阿里账号</a></li>
                    <li class="thirth loginlist_ico3"><a href="${main_host!}ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆">微信</a></li>
                    <!--<li class="thirth loginlist_ico4"><a color="#d6d6d6" alt="淘宝账号登陆" title="QQ号码登陆">QQ号码</a></li>-->
                    <li class="thirth loginlist_ico5"><a href="${main_host!}phoneAuthCodeLogininit.htm?backUrl=${backUrl!}" target="_blank"  alt="短信验证码登陆" title="短信验证码登陆">短信验证码</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="c_w100 c_m0auto c_foot_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto">
            <p class="c_c_777777">
                <a href="/index.html" target="_blank">首页</a> <a href="http://hz.571xz.com" target="_blank">杭州站</a> <a href="http://bj.571xz.com" target="_blank">北京站</a> <a href="http://gz.571xz.com" target="_blank">广州站</a> <a href="http://ss.571xz.com" target="_blank">石狮站</a> <a href="http://cs.571xz.com" target="_blank">常熟站</a> <a href="http://bbs.571xz.com/" target="_blank">星座论坛</a> <a href="http://market.571xz.com/" target="_blank">服装批发市场</a> <a href="http://hz.571xz.com:8070/zixun/article?id=87" target="_blank">联系我们</a> <a href="http://www.571xz.com/shigu/contact/zpyc/" target="_blank">招聘英才</a>
            </p>
            <p class="c_c_acacac">&copy; 2009-2017 571xz.com 版权所有 <a rel="nofollow" href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank">网上交易市场登记证</a> <a rel="nofollow" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a> | <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" style="display:inline;text-decoration:none;height:20px;line-height:20px;"> <img src="http://www.571xz.com/images/beian.png" style="vertical-align: middle; display: inline;" width="20" height="20" original="http://www.571xz.com/images/beian.png"> 浙公网安备 33010202000302号 </a> </p>
        </div>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/login/js/login.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>