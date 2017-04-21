<input id="main_host" value="http://www.571xz.com/" type="hidden">
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>手机验证码登录-[四季星座网]</title>
    <link href="http://style.571xz.com/login/css/phoneAuthCodeLogininit.css" rel="stylesheet">
         <#include "/common/host_config.ftl" />
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
        <h1>手机验证码登录</h1>
        <form method="post" id="phone_form" action="loginByPhone.htm">
        <div class="login-block">
           <div class="mobilephone">
              <span class="mobileuser">手机号:</span>
              <input type="text" class="mobileipt" id="phone" name="telephone" value="">
              <a id="wwww" onClick="return sendphoneCode();" class="mobilebtn">发送验证码</a>
           </div>
           <div class="mobilephone">
              <span class="mobileuser">验证码:</span>
              <input type="text" class="mobileipt" id="authcode" name="phoneVerify">
              <a onClick="checkPhoneForm();" class="mobilebtn">提交</a>
           </div>
           <p class="mobilesm">绑定后你也可以用手机号码和密码登录!</p>
        </div>
        </form>
        <input type="hidden" id="msg" value="${msg!}">
    </div>
</div>
</div>
</div>
<div class="layout">
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
        <h4 class="modal-title" id="exampleModalLabel">本手机号是第一次登录请先创建账号！</h4>
         <h4 class="modal-title" id="exampleModalLabel">如您有星座网账号，未绑定手机号码，请<a href="${main_host!}login.htm" >登录</a>之前的号码进行绑定！</h4>
      </div>
      <div class="modal-body">
        <form>
         <input type="hidden"  id="loginPhone" name="loginPhone" value="${telephone}">
          <div class="form-group" style="padding-left:140px;">
            <label for="recipient-name" class="control-label" style="width:70px;text-align:center;">账号:</label>
           ${telephone!}
          </div>
          <div class="form-group" style="padding-left:140px;">
            <label for="message-text" class="control-label" style="width:70px;text-align:center;">昵称:</label>
            <input type="text"  id="userNick" name="userNick">
          </div>
          <div class="form-group" style="padding-left:140px;">
            <label for="message-text" class="control-label" style="width:70px;text-align:center;">登录密码:</label>
            <input type="password"  id="password" name="password">
          </div>
           <div class="form-group" style="padding-left:140px;">
            <label for="message-text" class="control-label" style="width:70px;text-align:center;">确认密码:</label>
            <input type="password"  id="agassword" name="agassword">
          </div>
        </form>
      </div>
      <div class="modal-footer">
      <!--
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        -->
        <button type="button" class="btn btn-sm btn-danger" onclick="regd()" style="margin-right:37%;background-color:#f4120b;padding:7px 60px;font-size:20px;">提交</button>
      </div>
    </div>
  </div>
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
<script src="http://style.571xz.com/login/js/phoneAuthCodeLogininit.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>