
<!doctype html>
<html lang="zh-CN">
<#include "/common/host_config.ftl">
<head>
    <meta charset="utf-8" />

    <title>代发管理系统登录</title>

    <link href="http://static.571xz.com:86/hhh2016/??global.css" rel="stylesheet" />
    <link href="${daifa_host}fonts/iconfont.css" rel="stylesheet" />
    <link href="${daifa_host}css/login.css" rel="stylesheet" />


    <script type="text/javascript" src="${daifa_host}js/jquery.min.js"></script>
</head>
<body>
<input type="hidden" id="daifa_host" value="${daifa_host}">
<div class="qjbg">
    <form  method="post" id="login_form">
    <div class="login_wk">
        <div class="login_nk">
            <div class="logoTop c_hidden">
                <div class="logoIcon fl"><i class="iconfont">&#xe614;</i></div>
                <h1 class="fl">代发管理系统</h1>
            </div>
            <div class="login_con">
                <p class="j_passError c_none" id="err_msg_div">您输入的密码有误！</p>
                <div class="userName">
                    <input type="text" placeholder="请输入账号" id="username_inp" name="username" class="j_jd j_userN" />
                    <span class="j_user_img iconfont">&#xe6da;</span>
                </div>
                <div class="passWord">
                    <input type="password" placeholder="请输入密码" name="password" id="password_inp" class="j_jd j_passW" />
                    <span class="j_pass_img iconfont">&#xe6db;</span>
                </div>
                <div class="forgetP fr">
                    <a href="${daifa_host}admin/index.htm" >系统后台</a>
                </div>
            </div>
            <div class="loginBtn c_cb">

                <button type="button" class="lnBtn j_loginBtn">登录</button>
            </div>
        </div>
    </div>
    </form>
</div>
<script type="text/javascript" src="${daifa_host}js/login.js"></script>

<script>
    var username_key='admin_user_name';
    var pass_key='admin_pwd';
    var username=getCookie(username_key);
    var pass=getCookie(pass_key);
    if(username!=''&&username!==undefined&&username!=null&&pass!=''&&pass!==undefined&&pass!=null){
        $('#username_inp').val(username);
        $('#password_inp').val(pass);
        $('#remember_password').attr("checked", true);
    }
    $('#remember_password').on('click',function(){
        if(this.checked){
            setCookie(username_key,$('#username_inp').val());
            setCookie(pass_key,$('#password_inp').val());
        }else{
            delCookie(username_key);
            delCookie(pass_key);
        }
    });
    //写cookies
    function setCookie(name,value)
    {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }

    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }

    function delCookie(name)
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=getCookie(name);
        if(cval!=null)
            document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    }
</script>
</body>
</html>
