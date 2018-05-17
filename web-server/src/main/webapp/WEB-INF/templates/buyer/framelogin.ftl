<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>登录 - 四季星座网</title>
  
    
    <link href="//style.571xz.com/loginV2/css/login.css" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/loginV2/js/login.js"></script>
      <style>
          .layout {
              width: 2px;
              margin-right: 0px;
          }
          .loginMain {
              background: #546add;
              width: 100%;
              height: 443px;

              width: 542px;
          }
          .loginMode {
              width: 540px;
              margin-top: 0px;
              float: right;
              position: relative;
              box-shadow: 0 0 10px rgba(0,0,0,.2);
              -webkit-box-shadow: 0 0 10px rgba(0,0,0,.2);
              -moz-box-shadow: 0 0 10px rgba(0,0,0,.2);
              -o-box-shadow: 0 0 10px rgba(0,0,0,.2);
              -ms-box-shadow: 0 0 10px rgba(0,0,0,.2);
          }
      </style>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="loginMain" style="background-color:#${index_goat.text!}" >
    <div class="layout">

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
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=5&backUrl=${main_host!}loginortherSystem.htm?backUrl=${backUrl!}" target="_self" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="iconfont icon-taobao"></i><span>淘宝账号</span></a></li>

                </ul>
            </div>
        </div>
        <script>/*============ loginV2/login#loginForm BEGIN ============*/

        var backUrl = '${main_host!}loginortherSystem.htm?backUrl=${backUrl!}';
        //var backUrl = '//local.571xz.net:9001/main4/';
       // var backUrl = '${main_host!}loginortherSystem.htm?backUrl=//www.baidu.com';

/*============ loginV2/login#loginForm END ============*/


</script>
    </div>
</div>

</body>
</html>