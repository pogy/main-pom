<#assign $pageid="index">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__index_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/temp/echarts.common.min.js"></script>
<script src="//style.571xz.com/v6/gys/temp/html5sup.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__index_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<#if session_user_redis__.logshop.webSite??><#assign webSite='${session_user_redis__.logshop.webSite!}'><#else><#assign webSite='hz'></#if>
<script modulepath="gys/index#config">
var webSite = '${webSite!}';
</script>
<div class="bindRight fr">
    <div class="c_top clearfix">
        <div class="fl c_shop_logo">
            <div class="c_default_logo"><span class="iconfont">&#xe604;</span></div>
            <div class="c_own_logo">
                <#if session_user_redis__.headUrl??>
                <img src="${session_user_redis__.headUrl!}" width="120" height="120">
                <#else>
                <img src="//www.571xz.com/images/default160.jpg" width="120" height="120">
                </#if>
            </div>
        </div>
        <div class="fl clearfix c_shop_info">
            <div class="clearfix c_name">
                <strong class="fl">${session_user_redis__.userNick!}</strong>
                <p class="fr">
                    <#if session_user_redis__.logshop.tbNick??>
                    <span class="iconfont c_ff7112 icon-c-shop" title="店铺授权" alt="店铺授权" ></span>
                    <#else>
                    <span class="iconfont icon-c-shop" title="店铺未授权" alt="店铺未授权"></span>
                    </#if>
                    <span class="iconfont c_22ca75 icon-c-user" title="实名认证" alt="实名认证"></span>
                </p>
                <p class="fr">店铺名称:<i>${session_user_redis__.logshop.shopName!}</i></p>
            </div>
            <div class="c_cb c_address clearfix">
                <p>城市：
                    <i>
                        <#if session_user_redis__.logshop.webSite == 'jx'>嘉兴<#elseif session_user_redis__.logshop.webSite == 'ss'>石狮<#elseif session_user_redis__.logshop.webSite == 'gz'>广州<#elseif session_user_redis__.logshop.webSite == 'cs'>常熟<#elseif session_user_redis__.logshop.webSite == 'bj'>北京<#elseif session_user_redis__.logshop.webSite == 'qz'>泉州<#else>杭州</#if>
                    </i>
                </p>
                <p class="c_dkh">档口号：<i style="float:right; width: 80px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" title="${session_user_redis__.logshop.shopNum!}">${session_user_redis__.logshop.shopNum!}</i></p>
                <p>市场：<i style="float:right; width: 70px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" title="${session_user_redis__.logshop.market!}">${session_user_redis__.logshop.market!}</i></p>
            </div>
        </div>
        <div class="fr c_index">
          <p>关注指数：<i>5120</i> 排名 44</p>
          <p>评价积分：<i>5.0</i> 高于 4.83179</p>
          <p>商家权重：<i>正常</i> 提升权重</p>
        </div>
        <#if session_user_redis__.logshop.webSite == 'qz'>
        <div class="truthDataBox">
            <ul>
                <#list eachAllDataList as item>
                <li>
                    <p class="num">${item.num!}</p>
                    <p>${item.text!}</p>
                </li>
                </#list>
            </ul>
        </div>
        </#if>
    </div>
    <#if session_user_redis__.logshop.webSite == 'qz'>
    <div class="c_dataBox">
        <div class="pdBdBox">
            <div class="readDownDataBox">
                <h2>最近访问统计数据</h2>
                <div id="j_echart_3" class="c_echart_3"></div>
            </div>
        </div>
        <div class="pdBdBox">
            <div class="readDownDataBox">
                <h2>今日下载排行榜</h2>
                <div class="todayDownlaodRank">
                    <div class="head">
                        <ul class="clearfix">
                            <li class="pic">图片</li>
                            <li class="goods">商品</li>
                            <li class="lastDownUser">最后下载用户</li>
                            <li class="downNum">下载次数</li>
                            <li class="lastDownTime">最后下载时间</li>
                        </ul>
                    </div>
                    <#if (todayDownlaodList?size) gt 0>
                    <div class="body">
                        <#list todayDownlaodList as item>
                        <ul class="clearfix">
                            <li class="pic">
                                <img src="${item.imgSrc!}_80x80.jpg">
                            </li>
                            <li class="goods"><a href="//www.571xz.com/item.htm?id=${item.goodsId!}" target="_blank" class="fc3 ellip" title="${item.title!}">${item.title!}</a></li>
                            <li class="lastDownUser"><#if item.userPhone??>${item.userPhone?substring(0, 3)}****${item.userPhone?substring(7, 11)}</#if></li>
                            <li class="downNum">${item.downNum!}</li>
                            <li class="lastDownTime">${item.lastDownTime!}</li>
                        </ul>
                        </#list>
                    </div>
                    <#else>
                    <div class="empty">暂无数据！</div>
                    </#if>
                </div>
            </div>
        </div>
        <div class="pdBdBox">
            <div class="readDownDataBox">
                <h2>一周访问排行榜</h2>
                <div class="weekReadRank">
                    <div class="head">
                        <ul class="clearfix">
                            <li class="pic">图片</li>
                            <li class="goods">商品</li>
                            <li class="readNum">浏览次数</li>
                            <li class="lastReadTime">最后浏览时间</li>
                        </ul>
                    </div>
                    <#if (weekReadList?size) gt 0>
                    <div class="body">
                        <#list weekReadList as item>
                        <ul class="clearfix">
                            <li class="pic">
                                <img src="${item.imgSrc!}_80x80.jpg">
                            </li>
                            <li class="goods"><a href="//www.571xz.com/item.htm?id=${item.goodsId!}" target="_blank" class="fc3 ellip" title="${item.title!}">${item.title!}</a></li>
                            <li class="readNum">${item.readNum!}</li>
                            <li class="lastReadTime">${item.lastReadTime!}</li>
                        </ul>
                        </#list>
                    </div>
                    <#else>
                    <div class="empty">暂无数据！</div>
                    </#if>
                </div>
            </div>
        </div>
        <div class="pdBdBox">
            <div class="readDownDataBox">
                <h2>一周下载排行榜</h2>
                <div class="weekDownlaodRank">
                    <div class="head">
                        <ul class="clearfix">
                            <li class="pic">图片</li>
                            <li class="goods">商品</li>
                            <li class="downNum">下载次数</li>
                            <li class="lastDownTime">最后下载时间</li>
                        </ul>
                    </div>
                    <#if (weekDownlaodList?size) gt 0>
                    <div class="body">
                        <#list weekDownlaodList as item>
                        <ul class="clearfix">
                            <li class="pic">
                                <img src="${item.imgSrc!}_80x80.jpg">
                            </li>
                            <li class="goods"><a href="//www.571xz.com/item.htm?id=${item.goodsId!}" target="_blank" class="fc3 ellip" title="${item.title!}">${item.title!}</a></li>
                            <li class="downNum">${item.downNum!}</li>
                            <li class="lastDownTime">${item.lastDownTime!}</li>
                        </ul>
                        </#list>
                    </div>
                    <#else>
                    <div class="empty">暂无数据！</div>
                    </#if>
                </div>
            </div>
        </div>
    </div>
    <#else>
    <div class="c_goods_info clearfix">
        <div class="imglist_left fl">
            <p class="c_title">热门宝贝</span></p>
            <ul class="hotGoods clearfix">
            </ul>
            <p class="c_title">建议优化宝贝</p>
            <ul class="nothotGoods clearfix">
            </ul>
        </div>
        <div class="imglist_right fr">
            <p><img src="//www.571xz.com/jquery2015/imgTempindex/shaoma.jpg"></p>
        </div>
    </div>
    <div class="c_agent">
        <h2>代理数据分析</h2>
        <div id="j_echart_2" class="c_echart_2">
            <p class='c_no_data'>暂无数据~</p>
        </div>
    </div>
    </#if>
</div>
<script modulepath="common/xz#openImgtips">
var imgsrc = '${imgsrc!}';
var tHref = '${tHref!}';
</script>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>