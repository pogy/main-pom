<#assign $pageid="index">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>[四季星座网]杭州站-四季星座网-四季星座论坛-四季青服装货源，四季青市场，网店代理货源，网上服装进货，男装淘宝货源，女装淘宝货源，网络货源,网店货源导航,淘宝店货源,实体网络进货,杭州网店之家,杭州专业网店货源,杭州网店货源</title>
    <meta name="keywords" content="四季星座,四季星座网,四季星座论坛,网店代理货源,开淘宝店货源,淘宝货源,服装批发市场,杭州网店之家,杭州四季青服装批发市场,杭州四季青服装批发市场地址,外贸服装进货渠道,服装进货渠道">
    <meta name="description" content="四季星座网杭州的服装杭州女装货源批发网,市场包含了四季星座,星座女装电子商务楼,之江服装电子商务楼,四季青,意法服饰城,新杭派,四季星座男装等,是网络卖家网络货源平台,网店货源,女装货源,杭州女装货源,淘宝货源,实体店网络进货渠道,星座论坛 ,四季星座论坛，网店货源,实体店网络进货优选渠道!">
<#include "/common/base__config.ftl">
<#assign searchType="goods">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/hzMan__common_css.ftl">
<#include "/__style_torrent__/hzMan__index_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/hzMan/plugins/ekoo.min.js"></script>
<script src="//style.571xz.com/v6/hzMan/plugins/jquery.cookie.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/hzMan__common_js.ftl">
<#include "/__style_torrent__/hzMan__index_js.ftl">
</head>
<body>
<#include "/__ftl_links__/hzMan__common__fixedSearchBar.ftl">
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/hzMan__common__topGoatPic.ftl">
<script modulepath="hzMan/index#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<#assign disabledIndexNav=false>
<script modulepath="hzMan/common#forIps">
var hreflocation = window.location.href;
if(/^https?:\/\/(www\.)?571xz\.com/.test(hreflocation)){//仅首页
    jQuery.getScript("//ip.ws.126.net/ipquery",function(){  //新浪废弃接口int.dpool.sina.com.cn/iplookup/iplookup.php?format=js
        var city = localAddress["city"];
        var prov = localAddress["province"];
        if(city == '石狮市'){
            window.location.href = "//ss.571xz.com";
        }else if(city == '常熟市'){
            window.location.href = "//cs.571xz.com";
        }else if(city == '广州市'){
            window.location.href = "//gz.571xz.com";
        }else if(city == '泉州市'){
            window.location.href = "//qz.571xz.com";
        }else if(prov == '河北省'){
            window.location.href = "//cz.571xz.com";
        }
    }) ;
}
</script>
<#include "/common/xz__searchHeaderV2.ftl">
<#include "/common/xz__navV2.ftl">
<#include "/common/xz__choosePageType.ftl">
<#include "/__ftl_links__/hzMan__common__firstScreenContent.ftl">
<div class="styleChannel layout">
<div class="commonTitle">
    <a class="sideNavbarDot" name="styleGoods" data-text="风格"></a>
    <h3><span class="yahei">风格馆</span>专业选款，你的专属腔调</h3>
</div>
    <div class="styleList yahei">
        <#list styleList as item>
            <div class="styleItem pr<#if (item_index+1) % 6 == 0> last</#if>">
                <div class="line pa"></div>
                <h4 class="fc3"><a href="/styleIndex.htm?spid=${item.spid!}" target="_blank">${item.sname!}</a></h4>
                <ul>
                    <li><a href="/styleGoodsList.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>全部商品</li>
                    <li><a href="/styleMarket.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>市场列表</li>
                    <!--<li><a href="/styleRecommd.htm?spid=${item.spid!}" target="_blank"><i class="icon-s-addr"></i>推荐商品</li>-->
                </ul>
                <a href="${item.href!}" target="_blank"><img src="${item.imgsrc!}"></a>
            </div>
        </#list>
    </div>
</div>
<#include "/__ftl_links__/hzMan__common__hotSaleGoods.ftl">
<#include "/__ftl_links__/hzMan__common__popularGoods.ftl">
<#include "/__ftl_links__/hzMan__common__intimeGoods.ftl">
<div class="cooperatMarket layout">
    <div class="commonTitle">
        <h3><span class="yahei">合作市场</span>市场精选 甄选优质好款</h3>
    </div>
    <div class="cooperatMarketList">
        <div class="map"></div>
        <ul class="yahei">
            <li>
                <a  href="//hz.571xz.com/market.htm?mid=1" target="_blank">
                    <h4>电商基地</h4>
                    <p>男装网批，爆款发源地</p>
                    <span class="dsjd"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="//hz.571xz.com/market.htm?mid=5" target="_blank">
                    <h4>钱塘大厦</h4>
                    <p>男装精选，有型有实力</p>
                    <span class="qtds"></span>
                </a>
            </li>
            <li>
                <a href="//hz.571xz.com/market.htm?mid=3" target="_blank">
                    <h4>四季星座</h4>
                    <p>行业优选，专业货源</p>
                    <span class="sjxz"></span>
                </a>
            </li>
            <li class="bgGray">
                <a href="//hz.571xz.com/market.htm?mid=12" target="_blank">
                    <h4>新杭派</h4>
                    <p>万千好货，原创集结</p>
                    <span class="xhp"></span>
                </a>
            </li>
        </ul>
    </div>
</div>
<#include "/__ftl_links__/hzMan__common__serviceIntro.ftl">
<#include "/__ftl_links__/hzMan__common__siteInfo.ftl">
<#include "/__ftl_links__/hzMan__common__sideStyleBar.ftl">
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">