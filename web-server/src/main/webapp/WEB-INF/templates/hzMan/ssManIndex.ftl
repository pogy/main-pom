<#assign $pageid="ssManIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>[四季星座网]石狮站-四季星座网</title>
    <meta name="keywords" content="四季星座,四季星座网,四季星座论坛,网店代理货源,开淘宝店货源,淘宝货源,服装批发市场,是网络卖家网络货源平台,网店货源,女装货源,杭州女装货源,淘宝货源,实体店网络进货渠道,星座论坛 ,四季星座论坛，网店货源,实体店网络进货优选渠道!">
<#include "/common/base__config.ftl">
<#assign searchType="goods">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/hzMan__common_css.ftl">
<#include "/__style_torrent__/hzMan__ssManIndex_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/hzMan/plugins/ekoo.min.js"></script>
<script src="//style.571xz.com/v6/hzMan/plugins/jquery.cookie.js"></script>
<script src="//style.571xz.com/v6/common/js/plugin/jquery.SuperSlide.2.1.1.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/hzMan__common_js.ftl">
<#include "/__style_torrent__/hzMan__ssManIndex_js.ftl">
</head>
<body>
<#include "/__ftl_links__/hzMan__common__fixedSearchBar.ftl">
<#list [{"disabledChooseCity":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/hzMan__common__topGoatPic.ftl">
<script modulepath="hzMan/ssManIndex#config">
var pageType = 'M'
if(pageType == 'W'){
    $('body').addClass('pageWoman')
}
</script>
<#include "/common/xz__searchHeaderV2.ftl">
<#include "/common/xz__navV2.ftl">
<#include "/common/xz__choosePageType.ftl">
<#include "/__ftl_links__/hzMan__common__firstScreenContent.ftl">
<#include "/__ftl_links__/hzMan__common__hotSaleGoods.ftl">
<#include "/__ftl_links__/hzMan__common__intimeGoods.ftl">
<#include "/__ftl_links__/hzMan__common__serviceIntro.ftl">
<#include "/__ftl_links__/hzMan__common__siteInfo.ftl">
<#include "/__ftl_links__/hzMan__common__sideStyleBar.ftl">
<#list [{"bg":"whiteBg"}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">