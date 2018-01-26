<#assign $pageid="cash">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>疯抢10万红包 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzPage__cash_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzPage__cash_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="bodyBg">
<div class="banner" style="background-image:url(${bannerImg!})">
    <div class="layout pr yahei">
        <div class="actNumber pa"><em>${actNumber!}</em></div>
        <div class="actPeriod">活动时间：${actPeriod!}</div>
        <div class="actCountDown">
            <span class="word">活动倒计时:</span>
<#list [{"nowTime":actNowTime,"endTime":actEndTime}] as $it>
<span id="countdown1" class="xzCountdown" data-format="&lt;em&gt;%dd&lt;/em&gt;天&lt;em&gt;%hh&lt;/em&gt;时&lt;em&gt;%mm&lt;/em&gt;分&lt;em&gt;%ss&lt;/em&gt;秒" data-nowTime="${$it.nowTime!}" data-endTime="${$it.endTime!}"></span>
</#list>
        </div>
    </div>
</div>
<div class="instruction">
    <div class="intrBox">
        <h2></h2>
        <div class="intrItem">
            <h3 class="yahei"><i></i>上传任意商品，平分10万元现金：</h3>
            <ul>
                <li>活动期间，<strong>四季星座网分销商</strong>（淘宝店铺要求3钻以上的）上传四季星座网任意商品（仅限男装），至淘宝出售中的商品，且<strong>综合排名为Top100</strong>的用户即可平分10万元现金。活动结束后7个工作日内短信通知您领奖时间，逾期作废。</li>
            </ul>
        </div>
        <div class="intrItem">
            <h3 class="yahei"><i></i>综合排名Top100的用户：</h3>
            <ul>
                <li>根据淘宝用户的<strong>上传商品数量、上传商品的淘宝销量、淘宝店铺较上周的增长指数</strong>综合统计，作为最终的Top排名数据。</li>
            </ul>
        </div>
        <div class="intrItem">
            <h3 class="yahei"><i></i>中奖奖品发放期限及方式：</h3>
            <ul>
                <li>(1)、用户有2种途径查看中奖结果：</li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;① 四季星座网分销后台→会员俱乐部→开奖结果；</li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;② 四季星座网官方APP【星座进货宝】：我→我的奖品。对应的奖品金额下方显示的兑奖码，不记名，为唯一凭证，请妥善保管。</li>
                <li>(2)、为了保证奖品及时有效性，奖品在活动结束后以短信的方式通知您领奖时间，前往杭州上城区清江路136号（电商基地1楼大厅）领取。 </li>
                <li>(3)、本期活动结束后若未领取，可及时咨询四季星座网在线客服。逾期时间以短信内容为准，逾期未领取奖品视为自动放弃。 </li>
            </ul>
        </div>
        <div class="intrItem">
            <h3 class="yahei"><i></i>中奖资格的排除：</h3>
            <ul>
                <li>(1)、活动周期内，上架活动商品后72小时内下架的系统将判定为失效上传，不计入统计。</li>
                <li>(2)、本次活动的所有数据统计均以四季星座网活动平台统计为准，如被发现有违规行为（如恶意刷上传再下架、刷单等违反活动公平性的问题），四季星座网
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平台方将取消您本次活动资格，并取消您的奖励资格。</li>
                <li>(3)、同一用户仅享有一次中奖资格。同一用户是指：根据用户登录或使用的四季星座网账号，四季星座网根据其关联信息判断实际为同一用户的，关联信息包
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;括但不限于：同一手机号或同一旺旺。</li>
            </ul>
        </div>
    </div>
</div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">