<#assign $pageid="item">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>${goodsInfo.title!}-${shopInfo.marketName!}${shopInfo.shopNo!}-四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/goodsDetail__common_css.ftl">
<#include "/__style_torrent__/goodsDetail__item_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/goodsDetail/js/clipboard/jquery.zeroclipboard.min.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/goodsDetail__common_js.ftl">
<#include "/__style_torrent__/goodsDetail__item_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="/">
                <img src="http://style.571xz.com/v6/common/css/img/xz/mtLogo.png" alt="四季星座网" width="168" height="30">
            </a>
        </div>
        <div class="splitline"></div>
        <div class="shopInfobox hover">
            <div class="storeLogo icon-shop"></div>
            <div class="storeNamebox">
                <h3
                <#if shopInfo.domain??>
                    onclick="jumpShopLink('http://${shopInfo.domain!}.571xz.com')"
                <#else>
                    onclick="jumpShopLink('/shop.htm?id=${shopInfo.shopId!}')"
                </#if>
                >${shopInfo.marketName!}${shopInfo.shopNo!}</h3>
<#list [{"id":shopInfo.imWw}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
<#list [{"id":"${shopInfo.imQq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
                <i class="ti icon-downarrow"></i>
            </div>
<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>电话：</label>${shopInfo.mobile!}</li>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="http://www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>
            <div class="storeXybox">
<#list [{"num":shopInfo.starNum}] as $it>
<#include "/common/xz__shopLevel.ftl">
</#list>
            </div>
<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>电话：</label>${shopInfo.mobile!}</li>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="http://www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>
        </div>
        <form id="searchgo3" class="c_shop_search_2016" action="http://so.571xz.com/${webSite!}search.htm">
            <button id="allSearchbtn">搜全站</button>
            <div class="shopSecrh">
                <div class="search">
                    <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text" value="<#if query??>${query.pstring!}</#if>">
                    <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
                </div>
            </div>
        </form>
    </div>
</div>
<script modulepath="goodsDetail/item#config">
var shopId = '${shopInfo.shopId!}';
var goodsId = '${goodsInfo.goodsId!}';
</script>
<script modulepath="goodsDetail/item#config">
var shopId = '${shopInfo.shopId!}';
var goodsId = '${goodsInfo.goodsId!}';
</script>
<#list [{"fields":[]}] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
${userShopHdHtml}
<div class="layout topContentBox">
    <div class="leftCol1">
<div class="goodsPicbox" id="goodsPicbox">
    <div class="mainImgBox" id="mainImgBox">
        <#list goodsInfo.imgUrls as imgUrl>
            <#if imgUrl_index == 0>
            <a class="mainImgWrapper"
                <#if goodsInfo.tbGoodsId??>
                href="https://item.taobao.com/item.htm?id=${goodsInfo.tbGoodsId!}" target="_blank"
                <#else>
                href="javascript:;"
                </#if>
            >
                <span class="imgBox">
                <img src="${imgUrl!}_400x400.jpg">
<span id="scaleTipsLayer"></span>
<span id="scaleImgbox"></span>
                </span>
            </a>
            </#if>
        </#list>
        <#if goodsInfo.goodsVideoUrl??><i class="buttonIcon smallPlayButton"></i></#if>
<#if goodsInfo.goodsVideoUrl??>
<div id="goodsVideo" class="goodsVideo">
    <video class="video" controls="controls" webkit-playsinline="webkit-playsinline" playsinline="playsinline" autoplay="true" poster="" src="${goodsInfo.goodsVideoUrl!}" type="video/mp4"></video>
    <i class="buttonIcon bigPlayButton"></i>
    <i class="buttonIcon closeButton"></i>
</div>
</#if>
    </div>
    <div class="imgTabBox">
        <ul class="clearfix">
        <#list goodsInfo.imgUrls as imgUrl>
            <li data-img='${imgUrl!}' <#if img_index == 0 >class="selected"</#if>><a href="${imgUrl!}" target="_blank"><img src='${imgUrl!}_72x72.jpg'></a></li>
        </#list>
        </ul>
    </div>
    <div class="shareBox">
        <a class="store" xzclick="collectGoods" href="javascript:;"  data-goodsid="${goodsInfo.goodsId!}">收藏此商品</a>
        <a class="find_error" href="/contact.htm" target="_blank">我要纠错<span class="text-999">（如价格有误请联系我们客服修改）</span></a>
    </div>
</div>
    </div>
    <div class="leftCol2">
<div class="goodsAttrAndOperate" id="goodsAttrAndOperate" data-goodsid="${goodsInfo.goodsId!}">
<div class="goodsTitle">
    <h2 class="fs18 fc3 yahei">
        <#if goodsInfo.tbGoodsId??>
            <a href="http://item.taobao.com/item.htm?id=${goodsInfo.tbGoodsId!}" target="_blank">${goodsInfo.title!}</a>
        <#else>
            ${goodsInfo.title!}
        </#if>
        <#list goodsInfo.services as service>
            <#if service == 1>
            <span class="return fs12 fc6 simsun">可退</span>
            </#if>
            <#if service == 2>
            <span class="change fs12 fc6 simsun">可换</span>
            </#if>
        </#list>
    </h2>
</div>
<div class="goodsNoAttr">
    <span class="text-666">货号：<em class="fcF40 fs14 arail">${goodsInfo.goodsNo!}</em></span><span class="fc3 online arail"><em>${goodsInfo.postTime!}</em>上架</span>
    <#if goodsInfo.fabric??>
    <div class="pr fs12 fcBlue fabricWindow">
        <span class="showFabric">面料成分</span>
        <div class="pa fabricCon">
            <i class="icon-close closeTip fc6"></i>
            <i class="leftArrow pa"></i>
            <p class="fc3 fs14">面料成分</p>
            <p class="fc9 fs14">${goodsInfo.fabric!}</p>
            <#if goodsInfo.inFabric??>
            <p class="fc3 fs14">里料成分</p>
            <p class="fc9 fs14">${goodsInfo.inFabric!}</p>
            </#if>
        </div>
    </div>
    </#if>
</div>
<ul class="goodsPriceAttr clearfix">
    <li class="piprice">
        <label class="fc9">价格</label>
        <span class="fcF40 yahei">&yen;<em class="fs18 arail">${goodsInfo.piPrice!}</em></span>
    </li>
    <li class="minprice">
        <#if goodsInfo.lowestLiPrice??>
        <label class="fc9">电商最低零售价</label>
        <span class="fcF40 fs14 yahei">&yen;<em class="arail">${goodsInfo.lowestLiPrice!}</em>
            <div class="tipsbox fs12 simsun">
                售卖时不能低于此价格，否则会被厂家投诉
                <i class="i1"></i>
                <i class="i2"></i>
            </div>
        </span>
        </#if>
    </li>
    <li class="view">
        <label class="fc9">浏览</label>
        <span class="fc3 yahei fs14"><em class="arail" id="pageViewNum">-</em></span>
    </li>
</ul>
    <#if goodsInfo.onSale == false>
    <p class="noSale">此商品已下架</p>
    <#else>
<div class="goodsOrderAttr" id="goodsOrderAttr">
 <div class="goodsColors clearfix">
    <label class="fc9 fl">颜色</label>
    <div id="colorsMetabox" class="colors clearfix"></div>
</div>
<div class="sizeBoxOuter">
    <div class="sizeBox clearfix">
        <label class="fc9">尺码</label>
        <div class="sizes"></div>
    </div>
    <div class="viewMorebox">
        <b jhand="showMoreSize" class="button"><i class="icon-downarrow"></i></b>
    </div>
</div>
 <div class="orderMenubox">
    <div class="countbox"><em>0</em>件</div>
    <div class="pricebox yahei fcF40">&yen;<em>0</em></div>
    <div class="menuButtonbox yahei tac" jhand="toggleOrderMenu">已选商品清单<i class="icon-uparrow"></i></div>
    <div class="menuListbox">
        <table></table>
    </div>
</div>
</div>
<script modulepath="goodsDetail/item#goodsOrder">
var colorsMeta = ${goodsInfo.colorsMeta!};
var sizesMeta = ${goodsInfo.sizesMeta!};
var piPrice = '${goodsInfo.piPrice!}';
</script>
<#list [{}] as $it>
</#list>
<div class="goodsOperateButtons clearfix">
    <b class="btn btn-lg pr btn-orange <#if goodsInfo.onlineSale == true>addGwc<#else>notAddGwc</#if>" id="addGoodsToCart">加入进货车
        <div class="pa notOnlineSale">
            商家暂未开通！
            <i class="i1"></i>
            <i class="i2"></i>
        </div>
    </b>
    <#if goodsInfo.hasOriginalPic == true>
    <b class="btn btn-lg btn-orange picDownload noLoadIcon" jhand="downloadPic">精修大图下载 <i class="originalPicIcon"></i></b>
    <#else>
    <b class="btn btn-lg btn-orange picDownload" jhand="downloadPic">图片下载</b>
    </#if>
    <b class="btn btn-lg oneKeyUp hover" id="oneKeyUpGoods">一键上传</b>
    <#if goodsInfo.goodsVideoUrl??>
    <b class="btn btn-lg hover videoDownload" id="downloadGoodsVideo">视频下载</b>
    </#if>
</div>
<script modulepath="goodsDetail/item#downloadImgWindow">
var hasOriginalPic = ${goodsInfo.hasOriginalPic!}; // 判断是否存在原图下载
</script>
 <div class="goodsPayMode">
    <label class="fc9">支付方式</label>
    <span class="alipay">支付宝</span>
    <span class="weixin">微信</span>
</div>
    </#if>
</div>
    </div>
    <div class="leftCol3">
<div class="goodsHistoryBox fr">
    <h2 class="pr tac"><span class="text-999">看了又看</span></h2>
    <ul>
        <#list tjGoodsList as tjGoods>
        <Li>
            <a href="http://${webSite!}.571xz.com/item.htm?id=${tjGoods.goodsId!}" target="_blank"><img src="${tjGoods.imgSrc!}_140x140.jpg" title="${tjGoods.title!}" /></a>
            <p class="text-size14"><em class="yahei">&yen;</em>${tjGoods.price!}</p>
        </Li>
        </#list>
    </ul>
</div>
    </div>
</div>
<div class="layout detailContentBox">
<div class="pageFixbar clearfix">
    <div class="fixContainer ">
        <div class="layout">
            <div class="shopName" >
                <a class="nameDetails" href='http://${webSite!}.571xz.com/shop.htm?id=${shopInfo.shopId!}' target="_blank">${shopInfo.marketName!}${shopInfo.shopNo!}</a>
                <span>
<#list [{"id":"${shopInfo.imWw!}"}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
</span>
                <span>
<#list [{"id":"${shopInfo.imQq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
</span>
                <i class="ti icon-downarrow"></i>
<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>电话：</label>${shopInfo.mobile!}</li>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="http://www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>
            </div>
            <div class="goodsTitle">
                <h3 class="titleStyle">
                    商品详情
                </h3>
            </div>
            <div class="joinCart">
                <b>加入进货车</b>
            </div>
        </div>
    </div>
</div>
    <div class="clearfix">
        <div class="leftCol1">
<div class="shopSearch">
    <h2 class="shopStyle">本店搜索</h2>
    <ul class="searchInfo">
    <form>
        <input name="storeNumId" value="${shopInfo.shopId!}" type="hidden">
        <li><span class="wordKeyword">关键字</span><input class="pro" name="keyword" id="pstring" value="" type="text"></li>
        <li><span class="wordPrice">价格</span><input class="price j_Num" name="" placeholder="¥" value="" id="beginPrice" type="text"><span style="color:#999">-</span><input class="price j_Num" name="" placeholder="¥" value="" id="endPrice" type="text"></li>
        <li><input class="button" id="dosearchOnShop" value="搜索" type="button"></li>
    </form>
    </ul>
</div>
<div class="itemDetailGoat">
    <h3>推荐商品</h3>
    <div class="goatCon">
        <ul></ul>
    </div>
</div>
        </div>
        <div class="leftCol2">
<div class="goodsAttribute">
    <ul class="clearfix">
        <#list goodsInfo.normalAttrs as attr>
            <li title="${attr.value!}">${attr.name!}：${attr.value!}</li>
        </#list>
    </ul>
</div>
<div class="goodsDetail">
    ${goodsInfo.descHtml}
</div>
        </div>
        <div class="leftCol3">
<div id="onkeyupFixbar" class="onkeyupFixbar">
    <div class="innerbox">
         <ul class="keybox">
                <li><a href="http://upload.571xz.com/publish.htm?id=${goodsInfo.goodsId!}" target="_blank"><i class="ii"></i><span>上传到淘宝</span></a></li>
                <li><a href="http://1688.571xz.com/offer/publish.htm?id=${goodsInfo.goodsId!}" target="_blank"><i class="ii"></i><span>上传到阿里</span></a></li>
                <li class="wxContainer"><b id="showGoodsWxCode" data-goodsid="${goodsInfo.goodsId!}"><i class="ii"></i><span>分享朋友圈</span></b><div id="wxEwmbox" data-goodsid="${goodsInfo.goodsId!}"></div></li>
                <li class="addData"><b xzclick="addGoodsPkg" data-goodsid="${goodsInfo.goodsId!}"><i class="ii"></i><span>加入数据包</span></b></li>
                <li class="imgDownload" jhand="downloadPic" data-goodsid="${goodsInfo.goodsId!}"><b xzclick="imgDownload"><i class="ii"></i><span>图片下载</span></b></li>
                <li class="copyCode" id="copyCodeBtn">
                    <b><i class="ii"></i><span>复制详情HTML代码</span></b>
                </li>
        </ul>
        <p class="copyCodeSuccess"><em>宝贝描述复制完成</em></p>
        <div class="grewLine"></div>
        <div class="contactbox">
            <h3>联系档口</h3>
            <#if shopInfo.imWw??>
                <p class="wangwang"><a href="http://www.taobao.com/webww/ww.php?ver=3&touid=${shopInfo.imWw!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank">档口旺旺</a>
<#list [{"id":"${shopInfo.imWw!}"}] as $it>
<#include "/common/xz__imAliww.ftl">
</#list>
</p>
            </#if>
            <#if shopInfo.imQq?? && shopInfo.imQq != "">
                <p class="qq"><a href="http://wpa.qq.com/msgrd?v=3&uin=${shopInfo.imQq!}&site=qq&menu=yes" target="_blank">档口QQ</a>
<#list [{"id":"${shopInfo.imQq!}"}] as $it>
<#include "/common/xz__imQQ.ftl">
</#list>
</p>
            </#if>
        </div>
    </div>
</div>
        </div>
    </div>
</div>
<div class="recommendShop">
    <h3 class="fcF40">推荐档口</h3>
    <div class="shopCon">
        <ul class="clearfix">
        </ul>
    </div>
</div>
<#include "/common/xz__rightbar.ftl">
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">