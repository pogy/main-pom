<#assign $pageid="ghTongbu">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>授权管理 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__ghTongbu_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__ghTongbu_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<div class="tableContainer">
    <table border="0" width="100%">
          <tbody>
          <tr>
            <th class="border_1" width="154" height="104" align="right">&nbsp;</th>
            <th class="border_1" width="380" align="left">不授权同步</th>
            <th class="border_3" width="393" align="left">淘宝授权同步</th>
          </tr>
          <tr>
            <td class="border_1" align=""><p>优点</p></td>
            <td class="border_1" class="" align="left"><p>无</p></td>
            <td class="border_3" align="left"><p>1、每天自动更新店铺所有宝贝1次，实现与淘宝同步<br/>2、更新宝贝正确率100%<br/>3、赠送每天2次手动更新店铺宝贝</p></td>
          </tr>
          <tr>
            <td class="border_2" align=""><p>缺点</p></td>
            <td class="border_2" align="left"><p>1、有可能无法及时更新店铺宝贝<br/>2、可能出现店铺宝贝重复<br/>3、以上等未知的不稳定错误</p></td>
            <td align="left"><p>无</p></td>
          </tr>
        </tbody>
    </table>
</div>
<a href="/ortherLogin.htm?ortherLoginType=1&backUrl=/seller/ghTongbu.htm" class="sqBtn">授权或重新授权</a>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">