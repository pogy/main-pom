<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>忘记密码-四季星座网</title>
  
    
    <link href="http://style.571xz.com/loginV2/css/forgetPassword.css" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/loginV2/js/forgetPassword.js"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="header">
    <div class="headerContainer  layout950  clearfix">
        <a href="index.html" class="logo"></a>
        <span class="pageTag">
        </span>
            <p class="guideInfo">已有四季星座网账号了？<a href="${main_host!}login.htm">立即登录</a></p>
    </div>
</div>
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
        <div class="pwdContainer">
            <div class="pwdForm">
                <div class="pwdValItems">
                    <div class="pwdGroup">
                        <label>手机号码：</label>
                        <input type="text" class="form-input" name="telephone" maxlength="11" placeholder="请输入手机号码" >
                    </div>
                </div>
                <div class="pwdValItems">
                    <div class="pwdGroup">
                        <label>数字验证码：</label>
                        <input type="text" class="form-input imgValidate" maxlength="4" name="imgValidate" placeholder="右侧验证码" >
                        <img id="checkCode" src="IMG.htm" />
                    </div>
                </div>
                <div class="pwdValItems">
                    <button type="button" class="btn btn-lg btn-orange netxStep" id="stepOne">下一步</button>
                </div>
            </div>
            <div class="pwdForm" style="display:none">
                <div class="pwdValItems">
                    <div class="pwdGroup">
                        <label>短信验证码：</label>
                        <input type="text" name="msgValidate" class="form-input" maxlength="6" placeholder="请输入短信验证码" >
                        <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
                    </div>
                </div>
                <div class="pwdValItems">
                    <button type="button" class="btn btn-lg btn-orange netxStep" id="stepTwo">下一步</button>
                </div>
            </div>
            <div class="pwdForm" style="display:none">
                <div class="pwdValItems">
                    <div class="pwdGroup">
                        <label>密码：</label>
                        <input type="password" class="form-input" name="password" maxlength="20" placeholder="请输入密码" >
                    </div>
                </div>
                <div class="pwdValItems">
                    <div class="pwdGroup">
                        <label>确认密码：</label>
                        <input type="password" class="form-input" name="confirmPassword" maxlength="20" placeholder="请再次输入密码" >
                    </div>
                </div>
                <div class="pwdValItems">
                    <button type="button" class="btn btn-lg btn-orange netxStep" id="stepThree">下一步</button>
                </div>
            </div>
            <div class="pwdForm" style="display:none">
                <div class="updateSuccess">
                    <p>密码修改成功！</p>
                    <div class="successTip"><span class="time">3</span>s 后跳转到<a href="http://www.571xz.com">四季星座网首页</a></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p class="sitemap"> 
        <a href="/" target="_blank">首页</a>
        <a href="http://hz.571xz.com" target="_blank">杭州站</a>
        <a href="http://bj.571xz.com" target="_blank">北京站</a>
        <a href="http://gz.571xz.com" target="_blank">广州站</a>
        <a href="http://ss.571xz.com" target="_blank">石狮站</a>
        <a href="http://cs.571xz.com" target="_blank">常熟站</a>
        <a href="http://wa.571xz.com" target="_blank">辽源站</a>
        <a href="http://zixun.571xz.com" target="_blank">资讯</a>
        
        
        <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        
    </p>
    <p class="jyga">
        <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
        
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
    </p>
</div>
</body>
</html>