<input id="main_host" value="http://www.571xz.com/" type="hidden">
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>忘记密码-[四季星座网]</title>
    <link href="http://style.571xz.com/login/css/phoneForgetPasswordinit.css" rel="stylesheet">
          <#include "/common/host_config.ftl">
  </head>
<body class="c_login c_2016">
<div class="site-topbar">
    <div class="container">
        <div class="topbar-nav">
            <div class="nowp" onmouseover="nowpover(this)" onmouseout="nowpout(this)">
            
            </div>
            <span class="sep"></span>  <a href="http://www.571xz.com/static/AppDownload/" target="_blank">星座网移动版</a>
        </div>
        <div class="topbar-info J_userInfo">
        
        </div>
    </div>
</div>
<div class="wrapper">
    <div class="subwrapper">
        <div class="headlogo"><img src="http://style.571xz.com/login/css/img/loginlogo.jpg" onclick="toindex()"></div>
    
<div class="newlogin">
    <div class="subnav">
        <ul>
            <li><a href="${main_host!}regedit.htm" class="subnav-item">注册</a></li>
            <li><span class="sep">|</span></li>
            <li><a href="${main_host!}login.htm" class="subnav-item">登录</a></li>
            <li><span class="sep">|</span></li>
            <li><a href="${main_host!}" class="subnav-item">首页</a></li>
        </ul>
    </div>
    <div class="loginmain">
        <h1>通过验证码重设密码</h1>
        ${errorString!}
    <form method="post" id="phone_form" action="forgetPassword.htm">
        <div class="login-block">
            <div class="mobilephone">
                <span class="mobileuser">手机号:</span>
                <input type="text" class="mobileipt" value="${telephone!}" id="phone" name="telephone">
                <a id="wwww" class="mobilebtn" onClick="return sendphoneCode();">发送验证码</a>
            </div>
            <div class="mobilephone">
                <span class="mobileuser">验证码:</span>
                <input type="text" class="mobileipt" value="${phoneVerify!}" id="authcode" name="phoneVerify" >
                <a onClick="checkPhoneForm();" class="mobilebtn">提交</a>
            </div>
            <p class="mobilesm">忘记密码,但是绑定过手机的用户可以按以下步骤进行重设密码!</p>
            <div class="mobile-bz">
                <ul>
                <li>忘记密码</li>
                <li><img src="http://style.571xz.com/login/css/img/jtico.png"></li>
                <li>获取短信验证码</li>
                <li><img src="http://style.571xz.com/login/css/img/jtico.png"></li>
                <li>设置密码</li>
                <li><img src="http://style.571xz.com/login/css/img/jtico.png"></li>
                <li>登录</li>
                </ul>
            </div>
        </div>
        </form>
    </div>
</div>
</div>
</div>
<div class="layout">
</div>
<div class="copyright-100">
    <div class="y-row copyright">
        <p class="big">
            <a href="http://www.571xz.com/shigu/about_gyxz/" target="_blank">关于我们</a>
            <a href="http://www.571xz.com/shigu/contact/zpyc/" target="_blank">招聘英才</a>
            <a href="http://www.571xz.com/shigu/about_gyxz/guanggaofuwu/" target="_blank">广告合作</a>
        </p>
        <p>
            <a href="http://hz.571xz.com/huoyuan/xingzuonvzhuang/" target="_blank">星座女装</a><a href="http://hz.571xz.com/huoyuan/zhijiangnvzhuang/" target="_blank">之江服装</a><a href="http://hz.571xz.com/huoyuan/nanzhuangjingpin/" target="_blank">精品男装</a><a href="http://hz.571xz.com/huoyuan/sijixingzuo/" target="_blank">四季星座</a><a href="http://hz.571xz.com/huoyuan/yifafushi/" target="_blank">意法服饰</a><a href="http://hz.571xz.com/huoyuan/erhaojidi/" target="_blank">二号基地</a><a href="http://hz.571xz.com/huoyuan/yihaojidi/" target="_blank">一号基地</a><a href="http://hz.571xz.com/huoyuan/zhongxingwaimao/" target="_blank">中星外贸</a><a href="http://hz.571xz.com/huoyuan/zhidiguoji/" target="_blank">置地国际</a><a href="http://hz.571xz.com/huoyuan/jiutianguoji/" target="_blank">九天国际</a><a href="http://hz.571xz.com/huoyuan/sijiqing/" target="_blank">四季青</a><a href="http://hz.571xz.com/huoyuan/zhongfangfushi/" target="_blank">中纺服饰</a><a href="http://hz.571xz.com/huoyuan/xinhangpai/" target="_blank">新杭派</a><a href="http://hz.571xz.com/huoyuan/zhoubianshichang/" target="_blank">周边市场</a>
        </p>
        <p>
            © 2014 571xz.com 版权所有 ICP证：浙B2-20120165
        </p>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/login/js/phoneForgetPasswordinit.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>