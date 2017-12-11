<#assign $pageid>dtggapplyinfo</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>广告派位结果 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__dtggapplyinfo_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__dtggapplyinfo_js.ftl">
</head>
<body>
<#assign text>{"disabledChooseCity":true,"isGys":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<div class="applyInfo">
    <div class="bsTip">
        <p><i class="icon-c-checked"></i>申请资料已提交</p>
    </div>
    <ul>
        <li><label>所属市场：</label>${marketText!}</li>
        <li><label>档口号：</label>${storeNum!}</li>
        <li><label>联系人：</label>${lxuser!}</li>
        <li><label>联系电话：</label>${lxtel!}</li>
    </ul>
</div>
<div id="countdown" class="countdown"></div>
<script modulepath="gys/dtggapplyinfo#countdown">
var typeId = '${typeId!}'; //广告id
var countdownValue = ${countdownValue!}; //倒计时时间戳
var nowTimeValue = ${nowTimeValue!}; //服务器当前时间戳
</script>
<div class="introduction">
    ${introductionHtml}
</div>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">