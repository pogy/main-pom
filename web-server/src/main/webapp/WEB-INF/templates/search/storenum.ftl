<#assign $pageid="storenum">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/search__common_css.ftl">
<#include "/__style_torrent__/search__storenum_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/search__common_js.ftl">
<#include "/__style_torrent__/search__storenum_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign searchType="shop">
<#assign headerTitle=null>
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/search__common__nav.ftl">
<#list [{"fields":[{"name":"webSite","value":""+query.webSite},{"name":"mid","value":""+query.mid},{"name":"keyword","value":""+query.keyword}]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<div class="layout">
<div class="categoryFilterBar">
    <#if $pageid == "search">
        <div class="cateNav innerbox">
            <label>所有分类：</label>
            <div class="goodsCount"><#if query.keyword??> <span>&gt; ${query.keyword!}</span></#if>为您提供<em>${goodsCount!}</em>件宝贝</div>
        </div>
    </#if>
    <#if $pageid == "goods">
        <div class="navCate innerbox clearfix">
            <div class="layout navCon">
                <div class="navList">
                    <label>总类：</label>
                    <ul>
                        <#list navCate as cate>
                            <li <#if query.pid?? && query.pid == cate.id>class="select"</#if>>
                                <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if cate.id??>&pid=${cate.id!}</#if><#if cate.keyword??>&keyword=${cate.keyword!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${cate.text!}</a>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </#if>
    <#if cates??>
        <div class="cates clearfix innerbox">
            <#if $pageid == "search">
                <label>按类目：</label>
            <#elseif $pageid == "goods">
                <label>分类：</label>
            </#if>
            <ul>
                <#if $pageid == 'goods'>
                    <li <#if query.cid??><#else>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
                    </li>
                <#else>
                    <li <#if query.pid?? || query.cid??><#else>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a>
                    </li>
                </#if>
                <#list cates as cate>
                    <li <#if query.pid?? && query.pid == cate.id || query.cid?? && query.cid == cate.id >class="selected"</#if>>
                        <#if $pageid == 'goods'>
                            <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}&cid=${cate.id!}<#else>&pid=${cate.id!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${cate.text!}</a>
                        <#else>
                            <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if>&pid=${cate.id!}<#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${cate.text!}</a>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if markets??>
        <div class="markets clearfix innerbox">
            <label>按市场：</label>
            <ul>
                <li <#if query.mid??><#else>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">全部</a>
                </li>
                <#list markets as market>
                    <li <#if query.mid?? && query.mid == market.id>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}&mid=${market.id!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if>">${market.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if styles?? && $pageid == 'goods'>
        <div class="styles clearfix innerbox">
            <label>按风格：</label>
            <ul>
                <li <#if query.keyword??><#else>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
                </li>
                <#list styles as style>
                    <li <#if query.keyword?? && query.keyword == style.keyword>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${style.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${style.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if elements?? && $pageid == 'goods'>
        <div class="elements clearfix innerbox">
            <label>按元素：</label>
            <ul>
                <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a></li>
                <#list elements as element>
                    <li <#if query.keyword?? && query.keyword == element.keyword>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${element.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${element.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
</div>
    <#if (storelist?size) gt 0>
<div class="storelist">
    <#list storelist as store>
    <div class="storeitem">
        <a class="storeImgBox" href="/shop.htm?id=${store.id!}">
            <img src="${store.imgsrc!}">
        </a>
        <div class="storeInfoBox">
            <div class="p1">
                <a class="title" href="/shop.htm?id=${store.id!}" title="${store.marketName!} ${store.name!}"><em class="marketName">${store.highMarketName!}</em><em class="storeName">${store.highName!}</em></a>
                <span class="xy">
<#list [{"num":store.xy}] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
                </span>
                <span class="imbox">
<#list [{"id":"${store.aliww!}"}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
<#list [{"id":"${store.imqq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
                </span>
            </div>
            <div class="p2">
                <p>主营：${store.mainCate!}</p>
                <p>市场：${store.fullMarketText!}</p>
                <p>电话：${store.tel!}</p>
            </div>
            <div class="p3">
                共<em>${store.goodsCount!}</em>件商品
            </div>
        </div>
        <div class="storeGoodslistBox">
            <#list store.goodslist as goods>
            <div class="picitem">
                <a class="imgbox" href="/item.htm?id=${goods.id!}">
                    <img class="img" src="${goods.imgsrc!}_220x220.jpg">
                </a>
                <p>&yen;${goods.piprice!}</p>
            </div>
            </#list>
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
<div class="goodslistEmptyCon">
    <p class="fs18 yahei fc6">Sorry, 未查询到相应商品~</p>
</div>
    </#if>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">