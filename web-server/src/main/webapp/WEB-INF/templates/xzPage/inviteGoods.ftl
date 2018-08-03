<#assign $pageid="inviteGoods">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>新人进阶福利二步曲 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzPage__inviteGoods_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzPage__inviteGoods_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#list [{"fields":[{"name":"type","value":""+query.type},{"name":"page","value":""+query.page}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="banner"></div>
<div class="goodlist layout yahei">
    <div class="typeTab">
        <ul>
            <li <#if query.type == 'tj'>class="current"</#if>><a href="?type=tj"><i class="tuijian"></i>特别推荐</a></li>
            <li <#if query.type == 'qc'>class="current"</#if>><a href="?type=qc"><i class="qingcang"></i>清仓特惠</a></li>
            <li><a href="${mainHost!}/hzgoods.htm" target="_blank"><i class="richang"></i>日常用品</a></li>
        </ul>
    </div>
    <div class="goods">
        <ul class="clearfix">
            <#list goodslist as goods>
                <li>
                    <a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank"><image src="${goods.imgsrc!}_240x240.jpg" /></a>
                    <p class="title"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">${goods.title!}</a></p>
                    <div class="infobox">
                        <div class="fl price">￥<em>${goods.piprice!}</em>/件</div>${goods.piPrice}
                        <div class="fr service simsun">
                            <#list goods.services as service>
                                <#if service == 1>
                                    <span class="tui">退</span>
                                </#if>
                                <#if service == 2>
                                    <span class="huan">换</span>
                                </#if>
                            </#list>
                        </div>
                    </div>
                    <a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank" class="buyBtn">立即购买</a>
                </li>
            </#list>
        </ul>
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
<div class="rules layout yahei">
    <div class="ruleTitle"></div>
    <ul>
        <li><i>1</i>使用邀请码注册四季星座网账号，即获得10元下单红包；</li>
        <li><i>2</i>下单红包可至“红包余额”中查看，首次下单付款时，系统将自动去除红包金额；</li>
        <li><i>3</i>使用下单红包支付的订单，若产生退货，红包均不退回，退款金额按红包扣除后的小计金额退款；</li>
        <li><i>4</i>邀请好友：当您的好友通过邀请码注册、下单且交易完成后，您可以获得该笔订单的返利，返现金额至高为订单商品总额的50%（系统随机抓取）。</li>
    </ul>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">