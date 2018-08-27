<#assign $pageid="appDownIntro">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>APP下载介绍页 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <link rel=stylesheet href="//style.571xz.com/v6/xzSearch/temp/css/animate.css">
<#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__appDownIntro_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/xzSearch/temp/js/jquery.scrollLoading.min.js"></script>
<script src="//style.571xz.com/v6/xzSearch/temp/js/ekoo.min.js"></script>
<script src="//style.571xz.com/v6/xzSearch/temp/js/wow.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__appDownIntro_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<script src="//style.571xz.com/v6/xzSearch/temp/js/wow.min.js"></script>
<script modulepath="xzSearch/appDownIntro#config">
if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
    new WOW().init();
};
</script>
<div class="dfBanner">
	<div class="dfBigBox layout">
        <a href="//style.571xz.com/other/apk/SJXZ_Purchaser_V2.5.3_253_jiagu_sign.apk" target="_blank" class="androidBtn pa"></a>
        <a href="https://itunes.apple.com/cn/app/xing-zuo-jin-huo-bao/id965751969?mt=8" target="_blank" class="iosBtn pa"></a>
    </div>
    <div class="dfSmall"></div>
</div>
<div class="what" id="what">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="550" valign="top">
        	<div class="lefttxt animated bounceInLeft wow">
               <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/title1.png">
            </div>
        </td>
        <td>
        	<img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/pic1.png"  class="animated bounceInRight wow">
        </td>
      </tr>
    </table>
</div>
<div class="what hui" id="mianfei">
   <div class="what">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="400">
            <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/pic2.png"  class="animated bounceInUp wow">
        </td>
        <td valign="top">
            <div class="lefttxt animated bounceInDown wow" style="margin-left:100px;">
               <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/title2.png">
            </div>
        </td>
      </tr>
    </table>
    </div>
</div>
<div class="what" id="what">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="700" valign="top">
            <div class="lefttxt animated bounceInDown wow">
               <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/title3.png">
            </div>
        </td>
        <td>
            <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/pic3.png"  class="animated bounceInUp wow">
        </td>
      </tr>
    </table>
</div>
<div class="dflc clearfix" id="liuchen">
	<div class="animated bounceInUp wow tac">
	    <img src="//style.571xz.com/v6/xzSearch/css/img/appDownIntro/ftIcon.jpg">
	</div>
</div>
<div class="fhbz bgf5" id="baozhang"></div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">