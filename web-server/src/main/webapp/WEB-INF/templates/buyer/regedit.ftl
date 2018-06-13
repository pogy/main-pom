<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>注册 - 四季星座网</title>
  
    
    <link href="//style.571xz.com/loginV2/css/regedit.css" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/loginV2/js/regedit.js"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="header">
    <div class="headerContainer  layout950  clearfix">
        <a href="index.html" class="logo"></a>
        <span class="pageTag">
            欢迎注册
        </span>
            <p class="guideInfo">已有四季星座网账号了？<a href="${main_host!}login.htm">立即登录</a></p>
    </div>
</div>
<div class="layout950">
    <div class="regeditContainer">
        <div class="regeditForm">
            <div class="regeditItem">
                <div class="formGroup">
                    <label><i>*</i>手机号码：</label>
                    <input type="text" name="telephone" class="form-input" maxlength="11" placeholder="请输入手机号码"    >
                </div>
            </div>
            <div class="regeditItem">
                <div class="formGroup">
                    <label><i>*</i>数字验证码：</label>
                    <input type="text" name="imgValidate"  class="imgValidate form-input" maxlength="4" placeholder="右侧验证码"  >
                    <img id="checkCode" src="IMG.htm" />
                </div>
            </div>
            <div class="regeditItem">
                <div class="formGroup">
                    <label><i>*</i>短信验证码：</label>
                    <input type="text" name="msgValidate" class="form-input" maxlength="6" placeholder="请输入短信验证码" >
                    <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
                </div>
            </div>
            <div class="regeditItem">
                <div class="formGroup">
                    <label><i>*</i>密码：</label>
                    <input type="password" name="password" class="form-input" maxlength="20" placeholder="请输入登录密码" >
                </div>
            </div>
            <div class="regeditItem">
                <div class="formGroup">
                    <label><i>*</i>确认密码：</label>
                    <input type="password" name="confirmPassword" class="form-input" maxlength="20" placeholder="再次输入密码" >
                </div>
            </div>
            <div class="regeditItem">
                <div class="formGroup">
                    <label></label>
                    <button class="regeditButton btn btn-orange" name="regeditButton" id="regeditButton">立即注册</button>
                </div>
            </div>
            <div class="checkContract">点击“立即注册”，即表示您同意并愿意遵守四季星座网<a href="${main_host!}privacy.htm" target="_blank">隐私政策</a>和<a href="${main_host!}contract.htm" target="_blank">服务条款</a></div>
        </div>
        <div class="regeditFastLoginIn">
            <div class="fastLoginIn">
                <p>你也可以用以下方式登录</p>
                <ul>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=1&backUrl=${backUrl!}" target="_blank" alt="淘宝账号登陆" title="淘宝账号登陆"><i class="iconfont icon-taobao"></i><span>淘宝账号</span></a></li>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=2&backUrl=${backUrl!}" target="_blank"  alt="阿里账号登陆" title="阿里账号登陆"><i class="iconfont icon-alibaba"></i><span>阿里巴巴账号</span></a></li>
                    <li><a href="${main_host!}ortherLogin.htm?ortherLoginType=4&backUrl=${backUrl!}" target="_blank"  alt="微信登陆" title="微信登陆"><i class="iconfont icon-weixin"></i><span>微信</span></a></li>
                </ul>
            </div>
        </div>
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