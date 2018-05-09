<#assign $pageid="userProfileEdit">
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
<#include "/__style_torrent__/photo__userProfileEdit_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/photo/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__userProfileEdit_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="userProfile yahei layout">
    <div class="userBaseInfo pr clearfix">
        <div class="userInfoTit clearfix">
            <h2 class="fc3 fl">基本资料</h2>
            <b class="fr submitInfo">确认修改</b>
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
                    <label><em class="fcF40">*</em>性别：</label>
<#list [{"name":"sex","value":userInfo.sex}] as $it>
<div class="fmSelect" id="sex">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label><em class="fcF40">*</em>常居地：</label>
<#list [{"name":"provId","value":userInfo.provId}] as $it>
<div class="fmSelect" id="provId">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
<#list [{"name":"cityId","value":userInfo.cityId}] as $it>
<div class="fmSelect" id="cityId">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>职业类型：</label>
                    <p>${userInfo.typeName!}</p>
                </div>
            </div>
            <div class="validateItem clearfix oldTele">
                <div class="formGroup">
                    <label><em class="fcF40">*</em>手机号：</label>
                    <p><span class="oldTeleText">${userInfo.tele!}</span>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-gray-o
         changeBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        更改
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list></p>
                </div>
            </div>
            <div class="changeTele">
                <div class="validateItem clearfix">
                    <div class="formGroup">
                        <label><em class="fcF40">*</em>手机号：</label>
                        <input type="text" name="newTele" class="fmInput tele" placeholder="请输入手机号" value="">
                        <div class="getMsgValidateBox">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-gray-o
         getMsgValidate"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        获取验证码
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
                        </div>
                    </div>
                </div>
                <div class="validateItem clearfix">
                    <div class="formGroup">
                        <label><em class="fcF40">*</em>短信验证：</label>
                        <input type="text" name="msgValidate" class="fmInput msgValidate" placeholder="请输入短信验证码" value="">
                    </div>
                </div>
            </div>
            <div class="validateItem clearfix">
                <div class="formGroup">
                    <label>个人简介：</label>
                    <textarea class="profile" maxlength="200">${userInfo.profile!}</textarea>
                    <span class="lastNumber"><em><#if userInfo.profile??>${(userInfo.profile)?length!}<#else>0</#if></em>/200</span>
                </div>
            </div>
        </div>
        <div class="userRelatePics pa fr">
            <ul>
                <li>
<#list [{"isShowPic":true,"img":"${userInfo.coverImgSrc!}_j200x200.jpg","imgData":userInfo.coverImgSrc,"uploadBtn":"uploadUserCover","changeId":"changeUserCover","name":"userCover"}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                    <span>更换图片</span>
                    <p>展示封面</p>
                </li>
                <li class="wxQrcode">
<#list [{"isShowPic":true,"img":"${userInfo.wxQrCode!}_j200x200.jpg","imgData":userInfo.wxQrCode,"uploadBtn":"uploadWxQrCode","changeId":"changeWxQrCode","name":"wxQrCode"}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                    <span>更换图片</span>
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
<script modulepath="photo/userProfileEdit#userProfile">
var provsAndCitys = '${provsAndCitys!}';
</script>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">