<#assign $pageid="inviteGoodslist">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <title>新人进阶福利二步曲 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/h5__inviteGoodslist_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/h5__inviteGoodslist_js.ftl">
</head>
<body>
<#list [{"fields":[{"name":"type","value":""+query.type},{"name":"page","value":""+query.page}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="banner">
    <span class="ruleBtn"></span>
</div>
<div class="shadow"></div>
<div class="ruleList">
    <i class="closeIcon"></i>
    <h2>活动规则</h2>
    <ul>
        <li><p>1.使用邀请码注册四季星座网账号，即获得10元下单红包；</p></li>
        <li><p>2.下单红包可至“红包余额”中查看，首次下单付款时，系统将自动去除红包金额；</p></li>
        <li><p>3.使用下单红包支付的订单，若产生退货，红包均不退回，退款金额按红包扣除后的小计金额退款；</p></li>
        <li><p>4.邀请好友：当您的好友通过邀请码注册并完成首笔订单后，1-7个工作日您可以获得该笔订单的返利，返现金额至高为订单商品总额的50%（系统随机抓取），此福利次数不上限。</p></li>
    </ul>
</div>
<div class="goodslist">
    <div class="typeTab" id="typeTab">
        <a href="?type=tj" <#if query.type == 'tj'>class="current"</#if>>特别推荐</a>
        <a href="?type=qc" <#if query.type == 'qc'>class="current"</#if>>清仓特惠</a>
        <a onclick="gotoAppGoods()">日常用品</a>
    </div>
    <div class="typeTab fixed" id="fixTab" style="display:none">
        <a href="?type=tj#typeTab" <#if query.type == 'tj'>class="current"</#if>>特别推荐</a>
        <a href="?type=qc#typeTab" <#if query.type == 'qc'>class="current"</#if>>清仓特惠</a>
        <a onclick="gotoAppGoods()">日常用品</a>
    </div>
    <div class="listbox">
        <ul id="goodsList">
            <#list goodslist as goods>
                <li onclick="gotoApp(${goods.id!})">
                    <image src="${goods.imgsrc!}_240x240.jpg" />
                    <p class="title">${goods.title!}</p>
                    <div class="infobox">
                        <div class="fl price">￥<em>${goods.piprice!}</em>/件</div>
                        <div class="fr service">
                            <#list goods.services as service>
                                <#if service == 1><span class="tui"></span></#if><#if service == 2><span class="huan"></span></#if>
                            </#list>
                        </div>
                    </div>
                    <div class="buyBtn">立即购买</div>
                </li>
            </#list>
        </ul>
    </div>
    <div class="nomore">没有更多商品了...</div>
    <#if goodslist.size = 20>
        <div class="viewMore">查看更多</div>
    </#if>
</div>
<#include "/common/cnzz.ftl">