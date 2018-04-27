<#assign $pageid="userValidate">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>用户认证 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__userValidate_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/photo/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__userValidate_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="userValidateForm layout yahei">
    <div class="userValidTip clearfix">
        <img src="http://style.571xz.com/v6/photo/css/img/userHomePage/defaultTx.png" class="fl">
        <div class="userWords">
            <h3 class="fc3 fs16">认证身份后才能上传作品哦~</h3>
            <p class="fcF40">身份认证后无法修改，请认证填写~</p>
        </div>
    </div>
    <div class="validateForm userFormWrap">
        <div class="validateItem">
            <div class="formGroup">
                <label><i>*</i>用户名称：</label>
                <input type="text" name="username" class="fmInput" maxlength="12" placeholder="请输入用户名称">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label><i>*</i>职业类型：</label>
<#list [{"name":"roleStyle"}] as $it>
<div class="fmSelect" id="roleStyle">
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
        <div class="validateItem">
            <div class="formGroup">
                <label><i>*</i>工作手机：</label>
                <input type="text" name="workphone"  class="fmInput workphone" maxlength="11" placeholder="请输入工作手机号">
                <button type="button" id="getMsgBtn" class="getMsgBtn">获取验证码</button>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label><i>*</i>短信验证码：</label>
                <input type="text" name="msgCode"  class="fmInput" maxlength="6" placeholder="请输入短信验证码" >
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup styleType">
                <label>风格：</label>
                <p>（多选，最多可选5项）</p>
            </div>
        </div>
        <div class="validateItem clearfix styleList">
            <div class="formGroup">
                <label></label>
                <div class="styleItems">
                    <#list styleList as style>
<#list [{"text":style.text,"value":style.id}] as $it>
<label class="fmCheckbox
        <#if $it.checked??>
            checked
        </#if>
        <#if $it.disabled??>
            disabled
        </#if>
">
    <input
        type="checkbox"
        autocomplete="off"
            name="userStyle"
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
            </#if>
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
            <#if $it.disabled??>
                disabled
            </#if>
    >
    <i class="before"></i>
    <span>
        <#if $it.text??>
            ${$it.text!}
        </#if>
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    </#list>
                </div>
                <input type="hidden" id="userStyle" name="userStyle" value="0">
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label></label>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         submitBtn yahei"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="submitBtn"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
    </div>
    <div class="userPicsValid validateItem validateForm">
        <div class="formGroup">
            <label><i>*</i>图片上传：</label>
            <div class="uploadPics">
                <ul class="clearfix">
                    <li>
<#list [{}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                        <span class="textTitle">展示封面</span>
                    </li>
                    <li>
<#list [{}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                        <span class="textTitle">微信二维码</span>
                    </li>
                </ul>
                <p class="fcF40 fs12 tip">此图片将作为个人形象展示，建议上传图片尺寸不小于500x500，不超5M。</p>
            </div>
        </div>
    </div>
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">