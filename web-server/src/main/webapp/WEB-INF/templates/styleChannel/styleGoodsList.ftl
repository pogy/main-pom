<#assign $pageid="styleGoodsList">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>风格频道商品列表 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/styleChannel__common_css.ftl">
<#include "/__style_torrent__/styleChannel__styleGoodsList_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/styleChannel__common_js.ftl">
<#include "/__style_torrent__/styleChannel__styleGoodsList_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign isShowHoverCate=undefined>
<#include "/__ftl_links__/styleChannel__common__searchHeader.ftl">
<#list [{"fields":[{"name":"spid","value":""+query.spid},{"name":"webSite","value":""+query.webSite},{"name":"pid","value":""+query.pid},{"name":"keyword","value":""+query.pid},{"name":"mid","value":""+query.mid},{"name":"cid","value":""+query.cid},{"name":"sort","value":""+query.sort},{"name":"d","value":""+query.d},{"name":"sp","value":""+query.sp},{"name":"ep","value":""+query.ep},{"name":"st","value":""+query.st},{"name":"et","value":""+query.et},{"name":"page","value":""+query.page},{"name":"bpic","value":""+query.bpic},{"name":"goodsVideo","value":""+query.goodsVideo}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#include "/__ftl_links__/styleChannel__common__pageNav.ftl">
<div class="layout">
<#list [{"style":"close"}] as $it>
<#include "/__ftl_links__/styleChannel__common__pageCateMenu.ftl">
</#list>
<div class="cateFilterBar">
    <div class="filterBox byCate">
        <label>按分类：</label>
        <ul>
            <li <#if !query.cid && !query.keyword>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}&spid=${query.spid!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
            </li>
            <#list catemenu as cate>
                <#list cate.submenu as item>
                    <li <#if query.cid?? && query.cid == item.cid || query.keyword?? && query.keyword == item.keyword>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}&spid=${query.spid!}<#if item.cid??>&cid=${item.cid!}</#if><#if item.keyword??>&keyword=${item.keyword!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${item.text!}</a>
                    </li>
                </#list>
            </#list>
        </ul>
    </div>
    <div class="filterBox byMarket">
        <label>按市场：</label>
        <ul>
            <li <#if !query.mid>class="selected"</#if>>
                <a href="?webSite=${query.webSite!}&spid=${query.spid!}<#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
            </li>
            <#list marketList as market>
                <li <#if query.mid?? && query.mid == market.mid>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}&spid=${query.spid!}&mid=${market.mid!}<#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${market.name!}</a>
                </li>
            </#list>
        </ul>
    </div>
</div>
<div class="pageTitle">
    <h2 class="yahei">男装</h2>
</div>
<div class="formFilterBar clearfix" id="formFilterBar">
    <div class="sortTypeBox">
        <b jbtn="rankBySort" data-sort="comp" <#if query.sort?? && query.sort == 'comp'>class="selected"</#if>>综合</b>
        <b jbtn="rankBySort" data-sort="xp" <#if query.sort?? && query.sort == 'xp'>class="selected"</#if>>新品</b>
        <b jbtn="rankBySort" data-sort="popular" <#if query.sort?? && query.sort == 'popular'>class="selected"</#if>>人气</b>
    </div>
    <div class="sortPriceBox<#if query.sort == 'price-asc' || query.sort == 'price-desc'> actived</#if>">
        <#if query.sort == 'price-desc'>
            <b class="initial">批发价从高到低<i class="imgicon16"></i></b>
            <div class="hoverBox">
                <b class="selected">批发价从高到低</b>
                <b jbtn="rankBySort" data-sort="price-asc">批发价从低到高</b>
            </div>
        <#elseif query.sort == 'price-asc'>
            <b class="initial">批发价从低到高<i class="imgicon16"></i></b>
            <div class="hoverBox">
                <b class="selected">批发价从低到高</b>
                <b jbtn="rankBySort" data-sort="price-desc">批发价从高到低</b>
            </div>
        <#else>
        <b class="initial">批发价<i class="imgicon16"></i></b>
        <div class="hoverBox">
            <b jbtn="rankBySort" data-sort="price-asc" class="first">批发价从低到高</b>
            <b jbtn="rankBySort" data-sort="price-desc">批发价从高到低</b>
        </div>
        </#if>
    </div>
    <div class="filterPriceBox">
        <div class="innerbox">
            <input placeholder="&yen;" name="sp" id="sp" value="${query.sp!}">-<input placeholder="&yen;" id="ep" name="ep" value="${query.ep!}">
            <b id="searchPriceSE">确定</b>
        </div>
    </div>
    <div class="rtbox">
        <div class="dateClassify">
            <div class="inner">
                <b jbtn="searchTime" <#if !query.d && !query.et && !query.st> class="selected"</#if> data-day="">全部</b>
                <b jbtn="searchTime" <#if query.d =="1"> class="selected"</#if> data-day="1">1日内</b>
                <b jbtn="searchTime" <#if query.d =="2"> class="selected"</#if> data-day="2">2日内</b>
                <b jbtn="searchTime" <#if query.d =="3"> class="selected"</#if> data-day="3">3日内</b>
            </div>
        </div>
        <div class="sortTimeBox">
            <div class="bg1"></div>
            <b class="initial" <#if query.d gt 3 || query.st??> id="selected" </#if>>
                <#if query.d??>
                    <#if query.d == '7'>
                        1周内
                    <#elseif query.d == '30'>
                        1月内
                    <#elseif query.d == '90'>
                        3月内
                    <#elseif query.d == '180'>
                        6月内
                    <#elseif query.d == '365'>
                        1年内
                    <#elseif query.d == '1' || query.d == '2' || query.d == '3'>
                        其他
                    </#if>
                <#else>
                    <#if query.et?? || query.st??>
                        自定义时间
                    <#else>
                        其他
                    </#if>
                </#if>
            <i class="imgicon16"></i></b>
            <div class="hoverBox">
                 <div class="innerbox">
                    <b jbtn="searchTime" <#if query.d =="7"> class="selected"</#if> data-day="7">1周内</b>
                    <b jbtn="searchTime" <#if query.d =="30"> class="selected"</#if> data-day="30">1月内</b>
                    <b jbtn="searchTime" <#if query.d =="90"> class="selected"</#if> data-day="90">3月内</b>
                    <b jbtn="searchTime" <#if query.d =="180"> class="selected"</#if> data-day="180">6月内</b>
                    <b jbtn="searchTime" <#if query.d =="365"> class="selected"</#if> data-day="365">1年内</b>
                    <b id="selfDefine" <#if query.st?? && query.et??> class="selected"</#if>>自定义</b>
                </div>
            </div>
        </div>
        <div class="defineTime">
            <i class="cal"></i>
            <input type="text" class="jqDatepicker" data-format="%Y-%M-%D" id="startTime" placeholder="开始时间">
            <input type="text" class="jqDatepicker" data-format="%Y-%M-%D" id="endTime" placeholder="结束时间">
            <button id="searchByUserTime">确定</button>
        </div>
        <div class="paginationBox">
            <i class="prevPage prev<#if query.page == 1> disabled</#if>"></i>
            <span><em class="curPage">${query.page!}</em>/<em class="totalPage">${totalPage!}</em></span>
            <i class="nextPage next<#if query.page == totalPage> disabled</#if>"></i>
        </div>
    </div>
</div>
<#if webSite == 'hz'>
    <div class="otherFilterBox">
        <label><input id="toggleBpicFilter" type="checkbox" <#if query.bpic?? && query.bpic == 1>checked</#if>> 大图下载</label>
         <label><input id="toggleGoodsVideoFilter" type="checkbox" <#if query.goodsVideo?? && query.goodsVideo == 1>checked</#if>> 视频商品</label>
    </div>
</#if>
<#if (goodsList?size) gt 0>
    <div class="goodsList clearfix">
        <#list goodsList as goods>
            <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/v6/styleChannel/css/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                </a>
                <p class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                <#if goods.goodsNo?? && goods.goodsNo != "">
                    <p class="goodsNo"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank" title="${goods.goodsNo!}">货号：${goods.highLightGoodsNo}</a></p>
                <#else>
                    <p class="title"><a href="${mainHost!}/item.htm?id=${goods.id!}" target="_blank" title="${goods.title!}">${goods.highLightTitle}</a></p>
                </#if>
                <div class="p3">
                    <span class="storeName"><a href="${mainHost!}/shop.htm?id=${goods.shopId!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
<#list [{"id":""+goods.aliww}] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
                    <div class="upload">
                        <em><i class="iconUp"></i>一键上传</em>
                        <div class="list">
                            <ul>
                                <li><a href="http://upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                                <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                                <li><a href="javascript:;" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
                                <li><a href="javascript:;" xzclick="addGoodsPkg" data-goodsid="${goods.id!}"><em class="iconAdd"></em>加入数据包</a></li>
                            </ul>
                            <i class="i2"></i>
                            <i class="i1"></i>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
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
<#else>
<#include "/__ftl_links__/styleChannel__common__noDateTip.ftl">
</#if>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">