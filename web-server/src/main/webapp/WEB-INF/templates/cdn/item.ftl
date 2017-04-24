<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${vo.cdnItem.title!}-${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}-四季星座网</title>

    <meta name="keywords" content="欢迎前来四季星座网实力档口，选择 ${vo.cdnItem.title!}">

    <meta name="description" content="四季星座，四季星座网，代拿商品，网店货源，一键代发，一键上传，${vo.cdnItem.title!}">


    <link href="http://style.571xz.com/shopItemCopy/css/item.css?t=" rel="stylesheet">

</head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="http://cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="http://ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="http://bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="http://gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="http://wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="http://www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>

            </div>
        </div>

        <div class="rightbox">
            <ul>
                <li class="noIndex">
                    <a href="${main_host!}" class="c_ff4400">四季星座网首页</a>
                </li>
            <#if session_user_redis__??>
                <#if session_user_redis__.logshop??>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                            <div class="myStore cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                    <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                <#else>
                    <li class="noDown">
                        <a href="${main_host!}carts.htm">
                            <i class="cgcatIcon"></i>
                            <span>购物车</span>
                            <em class="cgNum"></em>
                        </a>
                    </li>
                    <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                            <div class="myxz cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                            <div class="myColle cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </#if>

            <#else>
                <li class="noDown">
                    <a href="${main_host!}carts.htm">
                        <i class="cgcatIcon"></i>
                        <span>购物车</span>
                        <em class="cgNum"></em>
                    </a>
                </li>
                <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon">
                            <ul>
                                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon">
                            <ul>
                                <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon">
                            <ul>
                                <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </#if>
                <li class="noDown"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a></li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>

                                <li><a href="http://hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</div>
<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="http://www.571xz.com/">
                <img src="/style/xz/css/img/mtLogo.png" alt="四季星座网" width="168" height="30">
            </a>
        </div>
        <div class="splitline"></div>
        <div class="storeInfobox hover">
            <div class="storeLogo iconfont"></div>

            <div class="storeNamebox">
                <h3>${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h3>
            <#assign text>{"id":"${vo.storeRelation.imWw!}"}</#assign>
            <#assign $it=text?eval />
                <a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
            <#assign text>{"id":"${vo.storeRelation.imQq!}"}</#assign>
            <#assign $it=text?eval />
            <#if $it.id != "">
                <a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
            </#if>
                <i class="ti iconfont">&#xe60b;</i>
            </div>

            <div class="storeXybox">
            <#assign text>{"num":${vo.starNum!}}</#assign>
            <#assign $it=text?eval />

                <em class="shopLevel">
                <#if $it.num lt 11>
                    <i class="star1"></i>
                <#elseif $it.num lt 41>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif $it.num lt 91>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif $it.num lt 151>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif $it.num lt 251>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif $it.num lt 501>
                    <i class="star2"></i>
                <#elseif $it.num lt 1001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif $it.num lt 2001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif $it.num lt 5001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif $it.num lt 10001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif $it.num lt 20001>
                    <i class="star3"></i>
                <#elseif $it.num lt 50001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif $it.num lt 100001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif $it.num lt 200001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif $it.num lt 500001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif $it.num lt 1000001>
                    <i class="star4"></i>
                <#elseif $it.num lt 2000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif $it.num lt 5000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif $it.num lt 10000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif $it.num gt 10000000>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                </#if>
                </em>
            </div>

            <div class="storeDetailInfobox">
                <div class="p1 clearfix">
                    <ul class="r1">
                        <li><label>地址：</label><#if vo.storeRelation.webSite == "hz">杭州<#elseif vo.storeRelation.webSite == "cs">常熟<#elseif vo.storeRelation.webSite == "gz">广州<#elseif vo.storeRelation.webSite == "ss">石狮<#elseif vo.storeRelation.webSite == "wa">辽源</#if>—${vo.storeRelation.marketName!}${vo.storeRelation.floor!}</li>
                        <li><label>电话：</label>${vo.storeRelation.telephone!}</li>
                        <li><label>主营：</label>${vo.other.mainBus!}</li>
                        <li><label>开店时间：</label>${vo.other.openTime!}</li>
                    </ul>
                    <ul class="r2">
                    <#if vo.shopLicenses??>
                        <#list vo.shopLicenses as license>
                            <#if license.licenseType == 3>
                                <li><i class="i1"></i>实体认证</li>
                            </#if>
                        </#list>
                    </#if>
                    <#if vo.hasAuth == 0>
                        <li><i class="i2"></i>未授权</li>
                    <#elseif vo.hasAuth == 1>
                        <li><i class="i2"></i>同步授权</li>
                    <#elseif vo.hasAuth == 2>
                        <li><i class="i2"></i>授权过期</li>
                    </#if>
                    </ul>
                </div>

                <div class="p2 clearfix">
                <#if vo.other.taobaoUrl??>
                    <b xzclick="openTaobaoShop" data-href="${vo.other.taobaoUrl!}">淘宝店铺</b>

                <#else>
                    <em class="disabled">淘宝店铺</em>
                </#if>
                <#if session_user_redis__.logshop.shopId??>
                    <b xzclick="addGoodsData" data-goodsid="${vo.itemId!}">数据包</b>
                <#else>
                    <b xzclick="addGoodsDataCannot">数据包</b>
                </#if>
                    <b xzclick="collectShop" data-shopid="${vo.storeRelation.storeId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>



                </div>

            </div>

        </div>

        <form id="searchgo3" class="c_shop_search_2016" action="http://so.571xz.com/${vo.storeRelation.webSite!}search.htm">
            <button id="allSearchbtn">搜全站</button>
            <div class="shopSecrh">
                <div class="search">
                    <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text" value="${query.pstring!}">
                    <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
                </div>
            </div>
        </form>
    </div>
</div>
${navCon}
<div class="content_top layout">
    <div class="leftbox">
        <div class="shopContent">
            <div class="proBanner">
                <div class="bigBanner">
                    <ul>
                    <#list vo.cdnItem.imgUrl as img>
                        <#if img_index == 0>
                            <li><a href="javascript:;"><img id="conImage" src="${img!}_400x400.jpg"></a></li>
                        </#if>
                    </#list>
                    </ul>
                </div>
                <div class="imageBox">
                    <ul>
                    <#list vo.cdnItem.imgUrl as img>
                        <#if img_index lt 6>
                            <li class="" data_img='${img!}'><a href="javascript:;"><img src='${img!}_72x72.jpg'  width="72px" height="72px"></a></li>
                        </#if>
                    </#list>
                    </ul>
                </div>
                <div class="shareBox">
                    <a class="red" href="javascript:;" onclick="sc_goods(${vo.itemId!})" ><span class="iconfont">&#xe649;</span>收藏商品<!--（228人气）--></a>
                    <a class="green" href="${qq_qy!}" target="_blankt"><span class="iconfont">&#xe677;</span>举报</a>
                </div>
            </div>
            <div class="proconInfo">
            <#if vo.onsale == true>
                <div class="ewm">
                    <span><div id="j_erweimahhh" style="width:100px;height:100px;background:url(http://www.571xz.com/images/loading_s.gif) center no-repeat;margin: 0 auto;"></div></span>
                    <p>扫二维码上传微信<a style="font-size: 12px; color: #1179EA;" href="http://www.571xz.com/help_site/help.htm?p=xzwfx">(帮助)</a></p>
                </div>
            </#if>
                <div id="proTitle"><!--这里有三种情况 所以要这样混,0 淘宝 1 数据包 2本站输入 3:剽窃 -->
                <#if vo.cdnItem.itemFrom.value == "taobao">
                    <a class="tb-main-title"  rel="nofollow" href="https://item.taobao.com/item.htm?id=${vo.cdnItem.tbNumIid!}" target="_blankt"><span class="iconfont" title="跳转至供货商淘宝页面，查看货源" >&#xe679;</span></a><h2>${vo.cdnItem.title!}</h2>
                <#elseif vo.cdnItem.itemFrom.value == "package">
                    <span class="iconfont" title="此商品为数据包上传">&#xe6a6;</span><h2>${vo.cdnItem.title!}</h2>
                <#else>
                    <h2>${vo.cdnItem.title!}</h2>
                </#if>
                </div>
                <div class="proPrice">
                    <p>零售价：<span class="style1">¥${vo.cdnItem.price!}</span><a href="http://zixun.571xz.com/article?id=382" target="_blank" style="color: #ff4400; margin-left: 10px;">什么是零售价？</a></p>
                <#if vo.cdnItem.price == vo.cdnItem.piPrice>
                    <p>拿货价：<span class="style2" style="position: relative;">¥${vo.cdnItem.piPrice!}<b class='iconfont alt_no_pi_price' alt='卖家可能未对该商品设置批发价，请通知卖家来星座网设置批发价' title='卖家可能未对该商品设置批发价，请通知卖家来星座网设置批发价'>&#xe630;</b></span></p>
                <#else>
                    <p>拿货价：<span class="style2">¥${vo.cdnItem.piPrice!}</span></p>
                </#if>
                </div>
                <table class="proconTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="name" width="64">上架时间：</td>
                        <td>${vo.cdnItem.listTime!} <em>货号：</em>${vo.cdnItem.huohao!}<em>发货地：</em>${vo.cdnItem.sendFrom!}</td>
                    </tr>
                    <tr>
                        <td class="name">选择尺码：</td>
                        <td class="selectStyle"  id="size_id">
                        <#list vo.cdnItem.sizes as size>
                            <span class="radioBtn">
                        <label>
                            <input name="size" type="radio" data-value='${size.pid!}:${size.vid!}' title="${size.value!}"/>${size.value!}
                        </label>
                    </span>
                        </#list>
                        </td>
                    </tr>
                    <tr>
                        <td class="name">选择颜色：</td>
                        <td class="selectStyle" id="color_id">
                        <#list vo.cdnItem.colors as fcolor>
                            <#if fcolor.imgUrl?? && fcolor.imgUrl != "">
                                <span class="radioBtn" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}" style='width:30px;height:30px;background:url(${fcolor.imgUrl!}_30x30.jpg) center no-repeat;' alt='${fcolor.value!}'
                                      data_img='${fcolor.imgUrl!}' ><img src='${fcolor.imgUrl!}_30x30.jpg' width="30"></span>
                            <#else>
                                <span class="radioBtn" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}" ><label><input name="color" type="radio" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}"  />${fcolor.value!}</label></span>
                            </#if>
                        </#list>
                        </td>
                    </tr>
                    <tr>
                        <td class="name">选择数量：</td>
                        <td>
                            <div class="selectNum">
                                <a href="javascript:;" id="Cuts">-</a>
                                <input type="text" id="Num" value="1">
                                <a href="javascript:;" id="Add">+</a>
                            </div>

                        </td>
                    </tr>
                <#if vo.onsale == true>
                    <tr>
                        <td colspan="2">
                            <div  id="j_upload_btns"></div>
                            <div>
                                <button class="addPro imgDownload" xzclick="showDownloadWindow" data-goodsid="${vo.itemId!}">
                                    <span>图片下载</span>
                                </button>
                            </div>
                            <div id="j_upload_items">
                                <button class="keyUpload"  onclick="showOnkeyUploadWindow();this.blur();"  >
                                    <span>一键上传</span>
                                </button>
                            </div>
                        </td>

                    </tr>
                    <tr class="j_upload_item">
                        <td colspan="2">
                            <div class="boxBtn">
                                <a  class="first" href="http://www.571xz.net/publish.htm?id=${vo.itemId!}" target="_blankt"  alt="上传淘宝"  title="点击按钮，可将本商品直接上传至您的淘宝店" >传淘宝</a>
                                <a href="http://1688.571xz.com/offer/publish.htm?id=${vo.itemId!}" target="_blankt" alt="上传阿里"  title="点击按钮，可将本商品直接上传至您的阿里巴巴">传阿里</a>

                                <a href="javascript:;" onclick="sc_goods(${vo.itemId!})" title="点击按钮，可将本商品在线生成数据包"  data-hhh="20160307test4" >加数据包</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <!--<p style="color:#ff4901"><font color="#666">提示：</font>代发本商品为认证代发团队接单，在线进货直接向本商家下单。</p>-->
                        </td>
                    </tr>
                <#else>
                    <tr>
                        <td colspan="2">
                            <div style="width: 100%;height: 150px;text-align: center;line-height: 150px;font-size: 42px;border: 3px #ddd dashed;">
                                商品已下架!
                            </div>
                        </td>
                    </tr>
                </#if>
                </table>
            </div>

        </div>
        <input type="hidden" id="goodsId" value="${vo.itemId!}">
        <script>/*============ shopItemCopy/item#goodsinfo BEGIN ============*/

        var marketId = ${vo.cdnItem.marketId!};
        var storeId = ${vo.cdnItem.shopId!};
        var item_id = ${vo.itemId!};
        if(storeId == 34869){
            var supportStore=false;
        }else{
            var supportStore=true;
        }
        var gysShopId = '${session_user_redis__.logshop.shopId!}';
        if(gysShopId && gysShopId != ""){
            var isGys = true;
        }else{
            var isGys = false;
        }

        /*============ shopItemCopy/item#goodsinfo END ============*/


        </script>
    </div>
    <div class="rightbox">
        <div class="shopInfo">
            <h2>${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h2>
            <div class="Diamonds xinyuxingxingS">
                <div class="starnumbox">
                <#if vo.starNum lt 11>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 41>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 91>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 151>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 251>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 501>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 1001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 2001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 5001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 10001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 20001>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 50001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 100001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 200001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 500001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 1000001>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 2000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 5000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 10000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum gt 10000000>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                </#if>
                </div>


            </div>
            <ul class="setShow item_page">
            <#if vo.storeRelation.webSite == "hz" || vo.storeRelation.webSite == "cs" || vo.storeRelation.webSite == "ss" >
                <li>
                    <div class="iconfont cor1">&#xe63d;</div>
                    <p>一件代发</p>
                </li>
            </#if>
            <#list vo.tags as tag>
                <#if tag == 1>
                    <li><div class="iconfont cor2">&#xe67a;</div><p>退现金</p></li>
                </#if>
                <#if tag == 2>
                    <li><div class="iconfont cor3">&#xe673;</div><p>包换款</p></li>
                </#if>
            </#list>

            </ul>
            <div class="txtInfo">
                <p>市场：${vo.storeRelation.marketName!} ${vo.storeRelation.floor!}</p>
                <p>电话：<font color="#ff4901">${vo.storeRelation.telephone!}</font></p>
                <p>本商品库存：${vo.cdnItem.num!}</p>

            </div>
            <ul class="contactUl" style="display:none">
                <li>在线客服：</li>
                <li>
                <#if vo.storeRelation.imQq?? && vo.storeRelation.imQq != "">
                    <a class="online" href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank" style="color:#333"><i class="qq"></i>和我联系</a>
                </#if>


                    <a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=${vo.storeRelation.imWw!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8"><img src="http://amos.alicdn.com/online.aw?v=2&amp;uid=${vo.storeRelation.imWw!}&amp;site=cntaobao&amp;s=1&amp;charset=utf-8" alt="点这里给我发消息" border="0"></a>


                </li>
            </ul>
            <div class="Coll">
                <ul>
                    <li><a href="javascript:;" id="scStore" data-id="${vo.storeRelation.storeId!}" title="收藏本店">收藏本店</a></li>
                <#if vo.other.taobaoUrl != "">
                    <li><a href="${vo.other.taobaoUrl!}" rel="nofollow" target="_blank" title="进入批发商淘宝店铺">进入淘宝店</a></li>
                <#else>
                    <li><a class="disabled" rel="nofollow" target="_blank" title="进入批发商淘宝店铺">进入淘宝店</a></li>
                </#if>
                </ul>
            </div>
        </div>


    </div>
</div>
<script>/*============ shopItemCopy/item#showOnkeyUploadWindow BEGIN ============*/

var goodsId = '${vo.itemId!}';

/*============ shopItemCopy/item#showOnkeyUploadWindow END ============*/


</script>
<div class="content_main layout">
    <div class="leftbox">


    <#assign text>{            "freemarker":true,            "fields":[                {"name":'id', 'value':${vo.storeRelation.storeId!}}            ]        }</#assign>
    <#assign $it=text?eval />
        <form id="wgt_search">
        <#list $it.fields as field>
            <input type=hidden name="${field.name!}" value="${field.value!}">
        </#list>
        </form>

        <h2 class="shopStyle">站内搜索</h2>
        <ul class="searchInfo">
            <form>
                <input name="storeNumId" value="${vo.storeRelation.storeId!}" type="hidden">
                <li>商品：<input class="pro" name="keyword" id="pstring" value="" type="text"></li>
                <li>价格：<input class="price j_Num" name="" placeholder="￥" value="" id="beginPrice" type="text"><span>-</span><input class="price j_Num" name="" placeholder="￥" value="" id="endPrice" type="text"></li>
                <li><input class="button" id="dosearchOnShop" value="确定" type="button"></li>
            </form>
        </ul>

        <h2 class="shopStyle">商品分类</h2>
        <ul class="sxUl">
            <li class="all"><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=2"><span class="iconfont"></span>查看所有宝贝</a></li>
            <li class="allTime">
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=3">今日新款</a>
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=5">本周更新</a>
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=6">本月更新</a>
            </li>
        </ul>

    <#list vo.shopCats as cat>

        <span class="shopMenu" title="${cat.name!}">
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;scid=${cat.cid!}&amp;timeflag=2">${cat.name!}</a>
            <#if cat.subCats??>
                <span class="iconfont j_iconfont">&#xe658;</span>
            <#else>
                <span class="iconfont">&#xe676;</span>
            </#if>
            </span>

        <#if (cat.subCats?size) gt 0>
            <ul class="menuList">
                <#list cat.subCats as subCat>
                    <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;scid=${subCat.cid!}&amp;timeflag=2">${subCat.name!}</a></li>
                </#list>
            </ul>
        </#if>

    </#list>

    </div>

    <div class="right">
        <div class="conRight">
            <h1 class="conTitle">
                <a class="select" href="javascript:;">商品详情</a>
                <!-- <a href="javascript:;">互动评论</a> -->
            </h1>
            <ul class="shopConTab">
                <li class="shopli" style="display:block">
                    <div class="conProInfo">
                        <ul>
                        <#list vo.cdnItem.normalProps as prop>
                            <li title="${prop.value!}"><span>${prop.pname!}:</span>${prop.value!}</li>
                        </#list>
                        </ul>
                    </div>
                    <div class="proPicSow">
                    ${vo.cdnItem.description}
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="right2box">
        <div id="onkeyupFixbar" class="onkeyupFixbar">
            <div class="innerbox">
                <ul class="keybox">
                    <li><a class="btn" href="http://www.571xz.net/publish.htm?id=${vo.itemId!}" target="_blank"><i class="ii"></i><span>上传到淘宝</span></a></li>
                    <li><a class="btn" href="http://1688.571xz.com/offer/publish.htm?id=${vo.itemId!}" target="_blank"><i class="ii"></i><span>上传到阿里</span></a></li>
                    <li class="wxContainer"><b xzclick="showGoodsWx" data-goodsid="${vo.itemId!}"><i class="ii"></i><span>分享朋友圈</span></b><div id="wxEwmbox"></div></li>
                    <li class="addData"><b xzclick="addGoodsData"><i class="ii"></i><span>加入数据包</span></b></li>
                </ul>
                <div class="grewLine"></div>
                <div class="contactbox">
                    <h3>联系档口</h3>
                <#if vo.storeRelation.imWw??><p class="wangwang">档口旺旺<#assign text>{"id":"${vo.storeRelation.imWw!}"}</#assign>
                    <#assign $it=text?eval />
                    <a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
                </p></#if>
                <#if vo.storeRelation.imQq??><p class="qq">档口QQ<#assign text>{"id":"${vo.storeRelation.imQq!}"}</#assign>
                    <#assign $it=text?eval />
                    <#if $it.id != "">
                        <a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
                    </#if>
                </p></#if>
                </div>
            </div>
        </div>
    </div>
</div>
<#if newGoodsList??>
<div class="newGoods layout">
    <h3>店铺新品</h3>
    <#list newGoodsList as goods>
        <div class="goodsitem">
            <a class="imgbox" href="item.htm?id=${goods.itemId!}" target="_blank">
                <img class="lazyload img" src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${goods.imgUrl!}_240x240.jpg">
            </a>
            <p class="p1">
                <span class="pricebox">&yen; ${goods.price!}</span>
            </p>
            <p class="title"><a href="item.htm?id=${goods.itemId!}" target="_blank">${goods.title!}</a></p>
        </div>
    </#list>
</div>
</#if>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:650px;">
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>


            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>

        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br>
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a>
        </p>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/shopItemCopy/js/item.js?t="></script>
<#include "/common/cnzz.ftl">
</body>
</html>