<#assign $pageid="capStatistic">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>资金明细 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__capStatistic_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/fxs__capStatistic_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="mybag">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<ul class="pageTabs clearfix">
    <li class="select"><a>资金明细</a></li>
</ul>
<div class="filterBar">
    <div class="timer">
        <div class="import_time">
            <label>时间：</label>
            <input autocomplete="off" class="jqDatepicker begintime" data-format="%Y-%M-%D" placeholder="请选择开始日期">
            <span>—</span>
            <input autocomplete="off" class="jqDatepicker endtime" data-format="%Y-%M-%D" placeholder="请选择结束日期">
        </div>
        <div class="click_time">
            <span jbtn="time_btn" data-id="0">今天</span>
            <em>|</em>
            <em>最近：</em>
            <span jbtn="time_btn" data-id="1">1个月</span>
            <span jbtn="time_btn" data-id="2">3个月</span>
            <span jbtn="time_btn" data-id="3">1年</span>
        </div>
    </div>
    <div class="type">
        <label>分类：</label>
        <span class="active" jbtn="type_btn">全部</span>
        <span data-id="2" jbtn="type_btn">交易</span>
        <span data-id="1" jbtn="type_btn">充值</span>
        <span data-id="3" jbtn="type_btn">退款</span>
        <span data-id="4" jbtn="type_btn">提现</span>
    </div>
    <div class="search_con">
        <label>搜索：<input autocomplete="off" type="text" placeholder="请输入订单号关键词" class="input_search" /></label>
        <button class="search_con_btn" jbtn="search_con">搜索</button>
    </div>
</div>
<p class="friendlyTips fc3 yahei tac">提示：资金明细只显示星座宝的交易记录，如使用微信、支付宝支付的订单交易记录，请在相关的软件中查看。为了方便您查看资金明细，支付方式建议您首选星座宝！</p>
<div class="capital_subsidiary_all">
    <table>
        <thead>
            <tr class="th_tr">
                <th class="orderno">交易编号</th>
                <th class="time">时间</th>
                <th class="money">金额</th>
                <th class="type">类型</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <input type="hidden" class="tempCode" value="${tempCode!}" />
    <div class="pagination">
    </div>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>