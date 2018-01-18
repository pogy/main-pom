<#assign $pageid="showQuestion">
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
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/helpCenter__common_css.ftl">
<#include "/__style_torrent__/helpCenter__showQuestion_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/helpCenter__showQuestion_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="wrapper">
    <div class="layout">
            <div class="noSidebarBox">
<div class="queSearch">
    <form action="showQuestion.htm" class="fl">
        <label>问题标题：<input type="text" class="fmInput" name="keyword" <#if query?? && query.keyword??>value="${query.keyword!}"</#if>></label>
        <button type="submit" class="fmButton fmButton-blue searchBtn">查询</button>
<#list [{}] as $it>
</#list>
    </form>
    <a href="addOrModify.htm" class="fr fs18" target="_blank">+ 添加问题</a>
</div>
<#list [{"fields":[{"name":"keyword","value":""+query.keyword}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="queList">

    <table>
        <thead>
            <th class="queId">ID</th>
            <th class="title">标题</th>
            <th class="time">时间</th>
            <th class="ope">操作</th>
        </thead>
        <tbody>
            <#list queList as que>
            <tr>
                <td>${que.id!}</td>
                <td><a href="queDetail.htm?id=${que.id!}">${que.title!}</a></td>
                <td>${que.time!}</td>
                <td>
                    <b class="fcF40 delete" data-id="${que.id!}">删除</b>
                    <a href="addOrModify.htm?id=${que.id!}" target="_blank" class="fcBlue">修改</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
<#list [{}] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#list [{}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
</div>
</div>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">