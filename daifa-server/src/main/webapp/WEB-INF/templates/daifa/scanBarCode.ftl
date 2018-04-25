<#assign $pageid>scanBarCode</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>扫描订单 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__scanBarCode_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__scanBarCode_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<div class="scanContainer fs14 yahei">
    <div class="scanInput">
        <label>条形码：</label><input type="text" class="fmInput fmInput-lg fs14 yahei" name="barCode" placeholder="扫描或者输入标签条形码">
    </div>
    <div class="scanResult">
        <ul>
            <li><label>条码信息：</label><span class="fs20 arail barCodeNum"><!--34678923578923457--></span></li>
            <li><label>商品信息：</label><span class="goodsProp"><!--DSJD_A209_K0975678 黑色 XXL--></span></li>
            <li><label>扫码结果：</label><span class="msg"><!--订单全部已拿到货，快递单打印失败（申通快递，没有快递单号了）--></span></li>
        </ul>
    </div>
</div>
    </div>
</div>