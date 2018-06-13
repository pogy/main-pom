<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>登录 - 四季星座网</title>
  
    
    <link href="//style.571xz.com/loginV2/css/login.css" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/loginV2/js/login.js"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="header">
    <div class="headerContainer  layout  clearfix">
        <a href="index.html" class="logo"></a>
        <span class="pageTag">
            欢迎登录
        </span>
            <p class="guideInfo">还没有四季星座网账号？<a href="${main_host!}regedit.htm">立即注册</a></p>
    </div>
</div>
<div class="loginMain" style="background-color:#${index_goat.text!}" >
    <div class="layout">
        <div class="loginBanner">
            <a href="${index_goat.href!}" target="_blank">
                <img src="${index_goat.imgsrc!}" width="572px" height="442px" class="fl c_img">
            </a>
        </div>
        <div class="loginMode">
            <div class="loginContainer">
                <div class="loginHeader">
                    <ul>
                        <li class="current passwordLogin">密码登录</li>
                        <li class="msgLogin">手机验证码登录</li>
                    </ul>
                </div>
                <div class="loginSwitch">
                    <div class="loginItems" >
                        <div class="loginItem">
                            <label class="iconfont icon-user"></label>
                            <input type="text" class="form-input" name="username" placeholder="用户名/手机号/邮箱" >
                        </div>
                        <div class="loginItem">
                            <label class="iconfont icon-password"></label>
                            <input type="password" class="form-input" name="password" placeholder="请输入密码" >
                        </div>
                        <div class="error-tip"></div>
                        <div class="loginItem fogertPassword">
                            <a href="${main_host!}forgetPassword.htm">忘记密码?</a>
                            <a href="${main_host!}regedit.htm" class="regegitEntery">立即注册</a>
                        </div>
                        <div class="loginItem">
                            <button type="button" class="btn btn-lg btn-orange logoinBtn" id="loginBtn">立即登录</button>
                        </div>
                    </div>
                    <div class="loginItems"  style="display:none">
                        <div class="loginItem">
                            <label class="iconfont icon-user"></label>
                            <input type="text" class="form-input" name="telephone" maxlength="11" placeholder="手机号"  >
                        </div>
                        <div class="loginItem">
                            <label class="iconfont icon-password"></label>
                            <input type="text" class="form-input imgValidate" name="imgValidate" maxlength="4"  placeholder="右侧验证码" >
                            <img id="checkCode" src="IMG.htm" />
                        </div>
                        <div class="loginItem">
                            <label class="iconfont icon-password"></label>
                            <input type="text" class="form-input" name="msgValidate" maxlength="6" placeholder="手机验证码" >
                            <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
                        </div>
                        <div class="error-tip"></div>
                        <div class="loginItem">
                            <button type="button" class="btn btn-lg btn-orange logoinBtn" id="msgLoginBtn">立即登录</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="fastLoginIn">
                <p>你也可以用以下方式登录</p>
                <ul>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="iconfont icon-taobao"></i><span>淘宝账号</span></a></li>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆"><i class="iconfont icon-alibaba"></i><span>阿里巴巴账号</span></a></li>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆"><i class="iconfont icon-weixin"></i><span>微信</span></a></li>
                </ul>
            </div>
        </div>
        <script>/*============ loginV2/login#loginForm BEGIN ============*/

var backUrl = '${backUrl!}';

/*============ loginV2/login#loginForm END ============*/


</script>
    </div>
</div>
<div class="footer">
    <p class="sitemap"> 
        <a href="/" target="_blank">首页</a>
        <a href="//hz.571xz.com" target="_blank">杭州站</a>
        <a href="//bj.571xz.com" target="_blank">北京站</a>
        <a href="//gz.571xz.com" target="_blank">广州站</a>
        <a href="//ss.571xz.com" target="_blank">石狮站</a>
        <a href="//cs.571xz.com" target="_blank">常熟站</a>
        <a href="//wa.571xz.com" target="_blank">辽源站</a>
        <a href="//zixun.571xz.com" target="_blank">资讯</a>
        
        
        <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        
    </p>
    <p class="jyga">
        <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
        
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="//style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
    </p>
</div>
</body>
</html>