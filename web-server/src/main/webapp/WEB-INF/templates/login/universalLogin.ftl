<#assign $pageid="login">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>登录 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__login_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#--<#include "/__style_torrent__/login__login_js.ftl">-->
</head>
<body>
<#include "/__ftl_links__/login__common__header.ftl">
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
            </ul>
        </div>
        <div class="loginSwitch">
            <div class="loginItems" >
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="loginname" placeholder="管理名" >
                </div>
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="username" placeholder="用户名/手机号/邮箱" >
                </div>
                <div class="loginItem">
                    <label class="icon-password"></label>
                    <input type="password" class="fmInput-lg fmInput fmInput" name="password" placeholder="请输入密码" >
                </div>
                <div class="errorTip"></div>
                <div class="loginItem fogertPassword">
                    <a href="forgetPassword.htm">忘记密码?</a>
                    <a href="regedit.htm" class="regegitEntery">立即注册</a>
                </div>
                <div class="loginItem">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="loginBtn"
>
        立即登录
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                </div>
            </div>
            <div class="loginItems"  style="display:none">
                <div class="loginItem">
                    <label class="icon-user"></label>
                    <input type="text" class="fmInput-lg fmInput" name="telephone" maxlength="11" placeholder="手机号"  >
                </div>
                <div class="loginItem">
                    <label class="icon-password"></label>
                    <input type="text" class="fmInput-lg fmInput imgValidate" name="imgValidate" maxlength="4"  placeholder="右侧验证码" >
                    <img id="checkCode" src="IMG.htm" />
                </div>
                <div class="loginItem">
                    <label class="icon-verifycode"></label>
                    <input type="text" class="fmInput-lg fmInput" name="msgValidate" maxlength="6" placeholder="手机验证码" >
                    <div class="getMsgBox"><i></i><button type="button" id="getMsgBtn">获取验证码</button></div>
                </div>
                <div class="errorTip"></div>
                <div class="loginItem">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-lg
         fmButton-orange
         logoinBtn"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="msgLoginBtn"
>
        立即登录
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                </div>
            </div>
        </div>
    </div>
</div>
<script modulepath="login/login#loginForm">
var backUrl = '${backUrl!}';
/*===== code build by lazycat =====*/

/*===== login/login#loginForm:0 =====*/
$$(function($it){

    $it.extend({
        domready: function(){
            $it.listenTabSwitch()
            $it.listenClearError()
            $it.listenPasswordLogin()
            $it.listenGetImgCode()
            $it.listenGetMsgCode()
            $it.listenMessageLogin()
        },
        listenTabSwitch: function(){
            $('.loginHeader li').on('click',function(){
                $(this).addClass('current').siblings().removeClass('current');
                $('.loginSwitch > div').eq($(this).index()).show().siblings().hide();
            })
        },
        listenClearError: function(){
            $(".loginItem input").on('keyup', function(){
                $(this).parents('.loginItems').find('.errorTip').hide();
            });
        },
        listenPasswordLogin: function(){
            var loginForm = $$.validate('.loginContainer', {
                username: function(e){
                    e.isNull('用户名不能为空');
                },
                password: function(e){
                    e.isNull('密码不能为空');
                }
            }, {
                onError: function(e){
                    e.errors(function(errorItem){
                        $it.showError(errorItem);
                        return false;
                    });
                },
                onSuccess: function(e){
                    e.values($it.hideError);
                    var user = $.trim($('[name=username]').val());
                    var pwd = $.trim($('[name=password]').val());
                    var loginname=$.trim($('[name=loginname]').val());
                    $$.post('passwordLogin.json',function(resp){
                        if(resp.err){
                            $it.showRespError('[name=username]', resp.err);
                        }else{
                            location.href = backUrl;
                        }
                    },{
                        'username': user,
                        'password': pwd,
                        'loginname':loginname
                    });
                }
            });

            $('.fmInput-lg.fmInput[name=password]').keydown(function(e){
                if(e.keyCode == 13){
                    loginForm.validate();
                }
            });

            $('#loginBtn').click(function(){
                loginForm.validate();
            });

        },
        listenGetImgCode: function(){
            $("#checkCode").on('click', function(){
                $(this).prop('src', "IMG.htm?"+ +new Date);
            });
        },
        listenGetMsgCode: function(){
            //获取短信验证码表单验证
            var vcodeForm = $$.validate('.loginContainer', {
                telephone: function(e){
                    e.isNull('手机号码不能为空').notTel('手机号码格式不正确');
                },
                imgValidate: function(e){
                    e.isNull('数字验证码不能为空').notMatch(/^\d{4}$/,'请输入4位数字验证码');
                }
            }, {
                onError: function(e){
                    e.errors($it.showError);
                    return false;
                },
                onSuccess: function(e){
                    e.values($it.hideError);
                    var tel = $.trim($('[name=telephone]').val());
                    var imgVal = $.trim($('[name=imgValidate]').val());
                    $$.post('loginGetMsgCode.json', function(resp){
                        if(resp.err){
                            $it.showRespError('[name=telephone]', resp.err);
                        }else{
                            lockButton($('#getMsgBtn'), 60);
                        }
                    }, {
                        'telephone': tel,
                        'imgValidate': imgVal
                    });
                }
            });

            function lockButton($dom, time){

                doLock()
                var tr = setInterval(doStep, 1000)

                function doLock(){
                    $dom.prop('disabled', true).text(time + 's可重新发送').css('color', '#999');
                }
                function unLock(){
                    $dom.prop('disabled', false).text('获取验证码').css('color', '#f40');
                }
                function doStep(){
                    if(time <= 0){
                        unLock();
                        return clearInterval(tr)
                    }else{
                        $dom.text(--time + 's可重新发送')
                    }
                }
            }

            $('#getMsgBtn').click(function(){
                vcodeForm.validate();
            });
        },
        listenMessageLogin: function(){
            var msgLoginForm = $$.validate('.loginContainer', {
                telephone: function(e){
                    e.isNull('手机号码不能为空').notTel('手机号码格式不正确');
                },
                //imgValidate: function(e){
                //e.isNull('数字验证码不能为空').notMatch(/^\d{4}$/,'请输入4位数字验证码');
                //},
                msgValidate: function(e){
                    e.isNull('短信验证码不能为空').notMatch(/^\d{6}$/,'请输入6位数字短信验证码');
                }
            }, {
                onError: function(e){
                    e.errors(function(errorItem){
                        $it.showError(errorItem);
                        return false;
                    });
                },
                onSuccess: function(e){
                    e.values($it.hideError);
                    var tel = $.trim($('[name=telephone]').val());
                    var imgVal = $.trim($('[name=imgValidate]').val());
                    var msgVal = $.trim($('[name=msgValidate]').val());
                    $$.post('telephoneLogin.json',function(resp){
                        if(resp.err){
                            $it.showRespError('[name=telephone]', resp.err);
                        }else{
                            location.href = backUrl;
                        }
                    },{
                        'telephone': tel,
                        'imgValidate': imgVal,
                        'msgValidate': msgVal
                    });
                }
            });
            $('.fmInput-lg fmInput[name=msgValidate]').keydown(function(e){
                if(e.keyCode == 13){
                    msgLoginForm.validate();
                }
            });

            $('#msgLoginBtn').click(function(){
                msgLoginForm.validate();
            });
        },
        showError: function(item){
            var $dom = $(item.dom);
            var $parent = $dom.parents('.loginItems');
            var $errorTips = $parent.find('.errorTip');
            $errorTips.text(item.msg).show();

        },
        showRespError: function(dom, msg){
            $parent = $(dom).parents('.loginItems');
            $errorTip = $parent.find('.errorTip');
            $errorTip.text(msg).show();
        },
        hideError: function(item){
            $(item.dom).parents('.loginItems').find('.errorTip').hide();
        }
    })

})


</script>
    </div>
</div>
<#list [{}] as $it>
<div class="footer ${$it.bg!}">
    <div class="inner">
        <p class="sitemap">
            <a href="${mainHost!}/" target="_blank">首页</a>
            <a href="//hz.571xz.com" target="_blank">杭州站</a>
            <a href="//bj.571xz.com" target="_blank">北京站</a>
            <a href="//gz.571xz.com" target="_blank">广州站</a>
            <a href="//ss.571xz.com" target="_blank">石狮站</a>
            <a href="//cs.571xz.com" target="_blank">常熟站</a>
            <a href="//py.571xz.com" target="_blank">濮院站</a>
            <a href="//zixun.571xz.com" target="_blank">资讯</a>
            <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br>
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            |
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <i class="bigIcon" title="浙公网安备"></i>
                浙公网安备 33010202000302号
            </a>
        </p>
    </div>
</div>
</#list>
<#include "/common/cnzz.ftl">