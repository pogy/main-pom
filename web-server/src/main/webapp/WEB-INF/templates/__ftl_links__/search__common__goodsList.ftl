<#if (goodslist?size) gt 0>
    <div class="goodsList clearfix">
        <#list goodslist as goods>
            <div class="goodsitem" data-goodsid="${goods.id!}">
                <a class="imgbox" href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank">
                    <#if goods_index lt 20>
                        <img class="img" src="${goods.imgsrc!}_240x240.jpg" data-original="${goods.imgsrc!}_240x240.jpg">
                    <#else>
                        <img class="lazyload img" src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${goods.imgsrc!}_240x240.jpg">
                    </#if>
                </a>
                <p class="p1">
                    <span class="pricebox yahei">&yen; ${goods.piprice!}</span>
                    <span class="viewCountBox"></span>
                </p>
                <#if $pageid == "search">
                    <#if goods.goodsNo?? && goods.goodsNo != "">
                        <p class="goodsNo"><a href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank" title="${goods.goodsNo!}">货号：${goods.highLightGoodsNo!}</a></p>
                    <#else>
                        <p class="title"><a href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank" title="${goods.title!}">${goods.highLightTitle!}</a></p>
                    </#if>
                <#else>
                    <p class="title"><a href="http://www.571xz.com/item.htm?id=${goods.id!}" target="_blank">${goods.title!}</a></p>
                </#if>
                <div class="p3">
                    <span class="storeName"><a href="http://${webSite!}.571xz.com/shop.htm?id=${goods.storeid!}" target="_blank" title="${goods.fullStoreName!}"><i class="icon1p"></i>${goods.fullStoreName!}</a></span>
<#assign text>{"id":""+goods.aliww}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.id != ''>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
</#if>
</#list>
                    <div class="upload">
                        <em><i class="iconUp"></i>一键上传</em>
                        <div class="list">
                            <ul>
                                <li><a href="http://upload.571xz.com/publish.htm?id=${goods.id!}" target="_blank" title="淘宝一键上传"><em class="iconUp"></em>上传淘宝</a></li>
                                <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goods.id!}" target="_blank" title="阿里一键上传"><em class="iconUp"></em>上传阿里</a></li>
                                <li><a href="#" jbtn="showGoodsWx"><em class="iconUp"></em>分享朋友圈</a></li>
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
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
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