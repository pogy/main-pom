<#assign $pageid="lottery">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>幸运大抽奖 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__lottery_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/xzSearch/js/rotate/jQueryRotate.2.2.js"></script>
<script src="//style.571xz.com/v6/xzSearch/js/rotate/jquery.easing.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__lottery_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="rotateContainer">
    <div class="layout pr">
        <div class="title"></div>
        <a href="//www.571xz.com/member/awardInfo.htm" class="toMyAward pa yahei">查看我的奖品</a></a>
        <div class="rotateBox pr" style="background-image:url(${rotateImgSrc!})">
            <div class="rotateBg pa"></div>
            <div class="lotteryStar pa"><img src="//style.571xz.com/v6/xzSearch/css/img/lottery/rotate.png" id="lotteryBtn"><img src="//style.571xz.com/v6/xzSearch/css/img/lottery/go.png" class="go" id="goBtn"><p class="yahei fs14 pa">还有<span id="lettoryNum">${lettoryNumber!}</span>次机会</p></div>
        </div>
        <div class="bottonSeat pr"></div>
        <div class="person pa"></div>
    </div>
</div>
<script modulepath="xzSearch/lottery#rotateContaier">
 var lettoryNumber = ${lettoryNumber!};
</script>
<div class="rules">
    <div class="layout awardsBox">
        <h2 class="yahei fs18 tac"><span class="pr">活动大揭秘</span></h2>
        <ol>
            <#list awardList as award>
                <li>${award!}</li>
            </#list>
        </ol>
    </div>
    <div class="layout rulesBox">
        <h2 class="yahei fs18 tac"><span class="pr">活动规则</span></h2>
        <ol>
            <#list ruleList as rule>
                <li>${rule!}</li>
            </#list>
        </ol>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">