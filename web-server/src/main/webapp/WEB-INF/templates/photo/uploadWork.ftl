<#assign $pageid="uploadWork">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>上传作品 - 摄影平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/photo__common_css.ftl">
<#include "/__style_torrent__/photo__uploadWork_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/photo/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/photo__common_js.ftl">
<#include "/__style_torrent__/photo__uploadWork_js.ftl">
</head>
<body>
<#include "/__ftl_links__/photo__common__topbar.ftl">
<#include "/__ftl_links__/photo__common__nav.ftl">
<#include "/__ftl_links__/photo__common__userTheme.ftl">
<#include "/__ftl_links__/photo__common__userInfo.ftl">
<#include "/__ftl_links__/photo__common__userNav.ftl">
<div class="uploadForm layout yahei">
    <p class="fcF40 uploadTips">上传作品：请确认您拥有该作品的版权；带有 * 的项目是必填的</p>
    <div class="validateForm applyForm">
        <div class="validateItem clearfix">
            <div class="formGroup clearfix">
                <label><i>*</i>上传图片：</label>
                <p class="fc9 imgControl">（作品主图大小不能超过5MB；最多只能上传20张图片；建议上传700*700 以上图片；仅支持JPG、PNG、JPEG图片格式。）</p>
            </div>
        </div>
        <div class="validateItem clearfix">
            <div class="formGroup clearfix">
                <label></label>
                <ul class="pics clearfix fl">
                    <#if worksData.cover??>
<#list [{"isShowPic":true,"isCover":true,"img":worksData.cover,"name":"picUrl","changeId":"changeWorks1"}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                    </#if>
                    <#if worksData.imgs??>
                        <#list worksData.imgs as img>
<#list [{"isShowPic":true,"img":cover,"name":"picUrl","changeId":"changeWorks${img_index+2}"}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                        </#list>
                    </#if>
<#list [{"uploadBtn":"addPicBtn","isAdd":true}] as $it>
<#include "/__ftl_links__/photo__common__imgUploadBox.ftl">
</#list>
                </ul>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label><i>*</i>作品标题：</label>
                <input class="fmInput title yahei" id="workTitle" name="title" maxlength="19" <#if worksData.title??>value="${worksData.title!}"</#if>>
                <span class="lastNumber"><em><#if worksData.title??>${(worksData.title)?length!}<#else>0</#if></em>/19</span>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup">
                <label><i></i>作品描述：</label>
                <textarea class="desc yahei" id="workDesc" maxlength="200"><#if worksData.desc??>${worksData.desc!}</#if></textarea>
                <span class="lastNumber"><em><#if worksData.desc??>${(worksData.desc?length)!}<#else>0</#if></em>/200</span>
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
<#list [{"text":style.text,"value":style.id,"checked":style.checkedIs}] as $it>
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
        <div class="validateItem clearfix">
            <div class="formGroup clearfix">
                <label><i>*</i>类目：</label>
                <div class="radioWrap fl">
                    <#list cateList as cate>
<#list [{"text":cate.text,"value":cate.id,"checked":cate.checkedIs}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="cateList"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            <#if $it.checked??>
                checked
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
            </div>
        </div>
        <div class="validateItem">
             <div class="formGroup clearfix">
                <label>价格：</label>
                <div class="radioWrap">
<#list [{}] as $it>
<label class="fmRadio clearfix
        checked
">
    <input
        type="radio"
        autocomplete="off"
            name="chat"
            value="1"
            checked
    >
    <i class="before"></i>
    <span>
        私聊
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                </div>
            </div>
        </div>
        <div class="validateItem">
            <div class="formGroup clearfix">
                <label>禁止右键保存：</label>
                <div class="radioWrap">
                    <#if worksData.saveType == 0>
<#list [{}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="saveChoice"
            value="1"
            <#if $it.checked??>
                checked
            </#if>
    >
    <i class="before"></i>
    <span>
        是
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
<#list [{}] as $it>
<label class="fmRadio clearfix
        checked
">
    <input
        type="radio"
        autocomplete="off"
            name="saveChoice"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            checked
    >
    <i class="before"></i>
    <span>
        否
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    <#else>
<#list [{}] as $it>
<label class="fmRadio clearfix
        checked
">
    <input
        type="radio"
        autocomplete="off"
            name="saveChoice"
            value="1"
            checked
    >
    <i class="before"></i>
    <span>
        是
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
<#list [{}] as $it>
<label class="fmRadio clearfix
        <#if $it.checked??>
            checked
        </#if>
">
    <input
        type="radio"
        autocomplete="off"
            name="saveChoice"
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
            <#if $it.checked??>
                checked
            </#if>
    >
    <i class="before"></i>
    <span>
        否
        <#if $it.html??>
            ${$it.html}
        </#if>
    </span>
</label>
</#list>
                    </#if>
                </div>
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
         fmButton-orange
         uploadBtn yahei"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="uploadBtn"
>
        上传作品
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
    </div>
    <input type="hidden" value="${query.id!}" id="worksId">
</div>
<#include "/__ftl_links__/photo__common__footer.ftl">
<#include "/common/cnzz.ftl">