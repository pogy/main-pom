<#assign $pageid="contact">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>联系我们 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__contact_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__contact_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="contactBanner pr">
    <div class="imgBox">
        <div class="imgInsertBox">
            <img src="//style.571xz.com/v6/xzSearch/css/img/contact/banner.png">
        </div>
    </div>
    <div class="contactDesc pa">
        <p class="fs20">专门为你解决各类账户、订单、支付、代发、档口入驻、等问题，0秒响应...</p>
        <p class="fs18">（在线客服咨询、服务时间：9:00-11:30，13:00-17:30）</p>
    </div>
</div>
<div class="contactSelect">
    <div class="contactContainer">
        <div class="contactBoxs1 clearfix">
            <div class="linkBox linkQQ">
                <h3 class="title">官方QQ</h3>
                <p class="desc">4000761116</p>
                <a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4000761116&amp;aty=0&amp;a=0&amp;curl=&amp;ty=1" class="linkBtn">
                    <i class="icon-s-qq"></i>
                    在线咨询
                </a>
            </div>
            <div class="linkBox linkAlWW1">
                <h3 class="title">官方旺旺1</h3>
                <p class="desc">杭州石谷网络科技有限公司</p>
                <a class="linkBtn" href="https://amos.alicdn.com/getcid.aw?v=3&amp;uid=杭州石谷网络科技有限公司&amp;site=cntaobao&amp;groupid=0&amp;s=1&amp;charset=utf-8" target="_blank">
                    <i class="icon-s-aliww"></i>
                    在线咨询
                </a>
            </div>
            <div class="linkBox linkAlWW2">
                <h3 class="title">官方旺旺2</h3>
                <p class="desc">杭州石谷网络科技有限公司</p>
                <a class="linkBtn" href="https://amos.alicdn.com/getcid.aw?v=3&amp;uid=杭州石谷网络科技有限公司&amp;site=cntaobao&amp;groupid=0&amp;s=1&amp;charset=utf-8" target="_blank">
                    <i class="icon-s-aliww"></i>
                    在线咨询
                </a>
            </div>
        </div>
        <div class="contactBoxs2">
            <div class="byEmail contactBy">
                <div class="emailFont">
                    <i class="icon-email"></i>
                </div>
                <div class="desc">
                    <h3 class="title">邮箱</h3>
                    <p>admin@571xz.com</p>
                </div>
            </div>
            <div class="dfPhone contactBy">
                <div class="phoneFont">
                    <i class="icon-phone"></i>
                </div>
                <div class="desc">
                    <h3 class="title">代发电话</h3>
                    <p>${daifaTelphone!'0571-86070380'}</p>
                </div>
            </div>
            <div class="byPhone contactBy">
                <div class="phoneFont">
                    <i class="icon-phone"></i>
                </div>
                <div class="desc">
                    <h3 class="title">电话</h3>
                    <p>400-076-1116</p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="otherSelect">
   <h3 class="title">其他联系方式</h3>
   <div class="contactList">
       <ul class="listBar clearfix none">
           <li data-item="addressBox" class="selected">总部地址</li>
           <!--<li data-item="wechatBox">官方微信</li>-->
       </ul>
       <div class="contactBox">
           <div class="addressBox fl">
               <p>地址：浙江省杭州市上城区清江路136号</p>
               <div id="dituContent"></div>
           </div>
           <div class="wechatBox fr">
               <p>关注公众号</p>
               <img src="//style.571xz.com/v6/xzSearch/css/img/contact/erweima.png">
           </div>
       </div>
   </div>
</div>
<script src="//api.map.baidu.com/api?key=&amp;v=1.1&amp;services=true"></script>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">