<#assign $pageid="addOrModify">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title></title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/helpCenter__common_css.ftl">
<#include "/__style_torrent__/helpCenter__addOrModify_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/helpCenter__addOrModify_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="wrapper">
    <div class="layout">
            <div class="noSidebarBox">
<div class="queDetailModify">
    <div class="dataItem">
        <label>主类目：</label>
        <select class="fmInput mainCate">
            <option>请选择主类目</option>
            <#list mainCate as cate>
            <option value="${cate.id!}" <#if cate.id == pid>selected</#if>>${cate.name!}</option>
            </#list>
        </select>
        <input type="text" name="mainCateName" class="fmInput" placeholder="如下拉框内无所需主类目，请手动填写">
    </div>
    <div class="dataItem">

        <label>子类目：</label>
        <select class="fmInput categories">
        </select>
        <input type="text" name="categoryName" class="fmInput" placeholder="如下拉框内无所需子类目，请手动填写">
    </div>
    <div class="dataItem">
        <label>问题标题：</label>
        <input type="text" name="queTitle" class="fmInput" <#if queTitle??>value="${queTitle!}"</#if>>
        <input type="hidden" name="queId" <#if query.id??>value="${query.id!}"</#if>>
    </div>
    <div class="dataItem">
        <label>问题答案：</label>
        <div id="edit" class="fl" style="height:400px;max-height:500px;">
            ${queAnswer}
        </div>
    </div>
    <div class="dataItem">
        <p class="tac"><b class="save">保存</b></p>
    </div>
</div>
<link href="http://style.571xz.com/v6/helpCenter/temp/css/wangEditor.min.css" rel="stylesheet">
<script src="http://style.571xz.com/v6/helpCenter/temp/wangEditor.min.js"></script>
<script src="http://style.571xz.com/v6/helpCenter/temp/MyEditor.js"></script>
<script modulepath="helpCenter/addOrModify#queDetail">
var cid = '${cid!}';
</script>
</div>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">