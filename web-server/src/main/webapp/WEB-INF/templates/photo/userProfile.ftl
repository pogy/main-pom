<#assign $pageid="userProfile">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>个人资料 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__userProfile_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__userProfile_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="userProfile yahei layout">
    <div class="userBaseInfo clearfix">
        <div class="userInfoTit clearfix">
            <h2 class="fc3 fl">基本资料</h2>
            <a href="userProfileEdit.htm" class="fr">编 辑</a>
        </div>
        <div class="userInfoList fl validateForm">
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>用户名：</label>
                    <p>${userInfo.nick!}</p>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>性别：</label>
                    <p><#if userInfo.sex == 0>男<#else>女</#if></p>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>常居地：</label>
                    <p>${userInfo.address!}</p>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>职业类型：</label>
                    <p>${userInfo.typeName!}</p>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>手机号：</label>
                    <p>${userInfo.tele!}</p>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>个人简介：</label>
                    <p>${userInfo.profile!}</p>
                </div>
            </div>
        </div>
        <div class="userRelatePics fr">
            <ul>
                <li>
                    <#if userInfo.coverImgSrc??>
                        <img src="${userInfo.coverImgSrc!}" />
                    <#else>
                        <img src="http://style.571xz.com/v6/photo/css/img/noCoverImg.png" />
                    </#if>
                    <p>展示封面</p>
                </li>
                <li class="wxQrcode">
                    <#if userInfo.wxQrCode??>
                        <img src="${userInfo.wxQrCode!}" />
                    <#else>
                        <img src="http://style.571xz.com/v6/photo/css/img/noQrcode.png" />
                    </#if>
                    <p>微信二维码</p>
                </li>
            </ul>
        </div>
    </div>
    <div class="userPwd clearfix none">
        <div class="userInfoTit clearfix">
            <h2 class="fc3 fl">账户安全</h2>
            <a href="#" class="fr">编 辑</a>
        </div>
        <div class="userInfoList validateForm clearfix">
            <div class="validateItem">
                <div class="formGroup">
                    <label>登录密码：</label>
                    <p>********</p>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">