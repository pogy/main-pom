<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link href="http://style.571xz.com/login/css/regedit.css" rel="stylesheet">
          <#include "/common/host_config.ftl">

  </head>
<body class="c_regedit c_2016">
<div class="c_w100 c_m0auto c_head_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto rect-wrap clearfix">
            <a class="logo iconfont c_logo2016" href="http://www.571xz.com"></a>
            <h2>欢迎注册</h2>
            <a class="fr c_c_ff4400" href="${main_host!}login.htm">请登录</a>
            <span class="fr c_c_777777">已有账号</span>
        </div>
    </div>
</div>
<div class="c_w100 c_m0auto c_body_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto clearfix">
            <input type="hidden" id="chev1" name="chev1" value="0"/>
            <form method="post" id="login_form" action="memberlogin.action">
                <div class="loginmain c_m0auto">
                    <div class="login-block">
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>手机号码:</span>
                            <input type="text" class="mobileipt" id="phone" name="phone" placeholder="你的手机号码" type="text"maxlength="11">
                            <span class="fl c_none error-mess">你输入的手机号有误</span>
                        </div>
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>图形验证码:</span>
                            <input type="text" class="mobileipt" id="authCode" name="authCode"  placeholder="请输入右侧图案中的验证码">
                            <div class="yanzheng"><img id="checkCode" src="http://www.571xz.com/IMG.htm" width="113px;" height="36px;"></div>
                            <span class="fl c_none error-mess">验证码不能为空</span>
                        </div>
                        
                        
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>短信验证码:</span>
                            <input type="text" class="mobileipt phoneCode" id="phoneCode" name="phoneCode" placeholder="请输入上手机接收到的验证码">
                            <a id="wwww" onClick="return sendphoneCode();" class="mobilebtn">点击获取验证码</a>
                            <span class="fl c_none error-mess">验证码错误</span>
                        </div>
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>昵称:</span>
                            <input type="text" class="mobileipt" id="userNick" name="userNick" placeholder="昵称">
                            <span class="fl c_none error-mess">昵称不能为空！</span>
                        </div>
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>密码:</span>
                            <input class="mobileipt" type="password" id="password" name="password" placeholder="这里是登录密码">
                            <span class="fl c_none error-mess">密码不能为空！</span>
                        </div>
                        <div class="mobilephonehide clearfix">
                            <span class="mobileuser"><font>*</font>确认密码:</span>
                            <input class="mobileipt" type="password"  id="agassword" name="agassword" placeholder="在确认一次密码">
                            <span class="fl c_none error-mess">密码与确认密码不一致！</span>
                        </div>
                        <div class="mobilephonehide clearfix" title="为了您的利益,请确认阅读后勾选此项" alt="为了您的利益,请确认阅读后勾选此项">
                            <span class="mobileuser"></span>
                            <input type="checkbox" value="1" id="checkboxFiveInput"  onclick="changechev1()">
                            <label for="checkboxFiveInput" class="checkboxlable c_c_000"> 我已阅读并同意 <a class="c_c_ff4400"target="_blank" href="http://www.571xz.com/static/mianze/contract.html">隐私政策 服务条款</a></label>
                        </div>
                        <a onClick="checkForm()" class="mobilereg c_b_ff4400">立即注册</a>
                    </div>
                </div>
            </form>
            <input type="hidden" id="telephone_msg" value="${telephone_msg!}">
            <input type="hidden" id="phoneVerify_msg" value="${phoneVerify_msg!}">
            <input type="hidden" id="userNick_msg" value="${userNick_msg!}">
            <input type="hidden" id="password_msg" value="${password_msg!}">
        </div>
    </div>
</div>
<div class="c_w100 c_m0auto c_foot_2016">
    <div class="c_w1190 c_m0auto">
        <div class="c_w990 c_m0auto">
            <p class="c_c_777777">
                <a href="/index.html" target="_blank">首页</a> <a href="http://hz.571xz.com" target="_blank">杭州站</a> <a href="http://bj.571xz.com" target="_blank">北京站</a> <a href="http://gz.571xz.com" target="_blank">广州站</a> <a href="http://ss.571xz.com" target="_blank">石狮站</a> <a href="http://cs.571xz.com" target="_blank">常熟站</a> <a href="http://bbs.571xz.com/" target="_blank">星座论坛</a> <a href="http://market.571xz.com/" target="_blank">服装批发市场</a> <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a> <a href="http://www.571xz.com/shigu/contact/zpyc/" target="_blank">招聘英才</a>
            </p>
            <p class="c_c_acacac">&copy; 2009-2017 571xz.com 版权所有 <a rel="nofollow" href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank">网上交易市场登记证</a> <a rel="nofollow" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a> | <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" style="display:inline;text-decoration:none;height:20px;line-height:20px;"> <img src="http://www.571xz.com/images/beian.png" style="vertical-align: middle; display: inline;" width="20" height="20" original="http://www.571xz.com/images/beian.png"> 浙公网安备 33010202000302号 </a> </p>
        </div>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/login/js/regedit.js?t=20170531"></script>
<#include "/common/cnzz.ftl">
</body>
</html>