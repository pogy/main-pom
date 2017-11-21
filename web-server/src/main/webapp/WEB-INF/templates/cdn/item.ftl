
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>${goodsInfo.title!}-${shopInfo.marketName!}${shopInfo.shopNo!}-四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/goodsDetail/css/item.css?v=2017112101" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/goodsDetail/js/item.js?v=2017112101"></script>
    
</head>
<body>



<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            
            <div class="cityChooseBox fl pr">
                <span class="lable pr">
                    <em>
                        <#if webSite == 'hz'>
                            杭州
                        <#elseif webSite == 'cs'>
                            常熟
                        <#elseif webSite == 'ss'>
                            石狮
                        <#elseif webSite == 'bj'>
                            北京
                        <#elseif webSite == 'gz'>
                            广州
                        <#elseif webSite == 'wa'>
                            辽源
                        <#elseif webSite == 'jx'>
                            濮院
                        <#else>
                            杭州
                        </#if>
                    </em>
                    <i class="downArrow"></i>
                </span>
                <ul>
                    <li><a href="http://hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
                    <li><a href="http://cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
                    <li><a href="http://ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
                    <li><a href="http://bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
                    <li><a href="http://gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
                    <li><a href="http://wa.571xz.com" <#if webSite == 'wa'>class="select"</#if>>辽源</a></li>
                    <li><a href="http://jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
                </ul>
            </div>
            
            <div class="loginBox fl">
                
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                
                 
                <li class="noIndex">
                    <a href="${main_host!}" class="fcF40">四季星座网首页</a>
                </li>
                
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop> 
                <li class="noDown">
                    <a href="${main_host!}order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                        
                        
                    </a>
                </li>
                <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? > 
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                <li class="noDown">
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                </li>
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            
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
                </#if>
            </ul>
        </div>
    </div>
</div>










</#list>


<script>
var webSite = '${webSite!}';
</script>







<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/v2//xz/css/img/mtLogo.png" alt="四季星座网" width="168" height="30">
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
                    onclick="jumpShopLink('http://${webSite!}.571xz.com/shop.htm?id=${shopInfo.shopId!}')"
                </#if>
                >${shopInfo.marketName!}${shopInfo.shopNo!}</h3>
                

<#assign text>{"id":"${(shopInfo.imWw!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>

                

<#assign text>{"id":"${shopInfo.imQq!}"}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>

                <i class="ti icon-downarrow"></i>
            </div>
            <div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "gz">广州<#elseif webSite == "ss">石狮<#elseif webSite == "wa">辽源</#if>—${shopInfo.marketName!}${shopInfo.floor!}</li>
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
        <b><a href="http://${webSite!}.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <b xzclick="openTaobaoShop" data-href="${shopInfo.tbUrl!}">淘宝店铺</b>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop.shopId??>
            <b xzclick="collectShopCannot"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
        
        













        













    </div>
    
    
</div>
            <div class="storeXybox">
                

<#assign text>{"num":shopInfo.starNum}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>

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


</#list>

            </div>
            
            <div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "gz">广州<#elseif webSite == "ss">石狮<#elseif webSite == "wa">辽源</#if>—${shopInfo.marketName!}${shopInfo.floor!}</li>
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
        <b><a href="http://${webSite!}.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <b xzclick="openTaobaoShop" data-href="${shopInfo.tbUrl!}">淘宝店铺</b>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop.shopId??>
            <b xzclick="collectShopCannot"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
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





${userShopHdHtml}








<div class="content layout">
    <div class="topContentBox clearfix">
        <div class="leftCol1">
            
<div class="goodsPicbox">
    <div class="bigBanner">
        <ul>
            <#list goodsInfo.imgUrls as imgUrl>
                <#if imgUrl_index == 0>
                    <#if goodsInfo.tbGoodsId?? && goodsInfo.tbGoodsId != "">
                    <li><a data-href="https://item.taobao.com/item.htm?id=${goodsInfo.tbGoodsId!}" target="_blank"><img id="conImage" src="${imgUrl!}_400x400.jpg"></a></li>
                    <#else>
                    <li><a href="javascript:;"><img id="conImage" src="${imgUrl!}_400x400.jpg"></a></li>
                    </#if>
                </#if>
            </#list>
        </ul>
        <#if goodsInfo.goodsVideoUrl??><i class="buttonIcon smallPlayButton"></i></#if>
        <span class="scalceIcon"></span>
        <#if goodsInfo.goodsVideoUrl??>
<div id="goodsVideoBox">
    <video class="video" controls="controls" webkit-playsinline="webkit-playsinline" playsinline="playsinline" autoplay="true" poster="" src="${goodsInfo.goodsVideoUrl!}" type="video/mp4"></video>
    
    <i class="buttonIcon bigPlayButton"></i>
    <i class="buttonIcon closeButton"></i>
</div>
</#if>


    </div>
    <div class="imageBox">
        <ul>
            <#list goodsInfo.imgUrls as imgUrl>
                <#if img_index lt 6>
                <li class="<#if img_index == 0>select</#if>" data-img='${imgUrl!}'><a href="${imgUrl!}" target="_blank"><img src='${imgUrl!}_72x72.jpg'></a></li>
                </#if>
            </#list>
        </ul>
        



        
    </div>
    <div class="shareBox">
        <#if session_user_redis__?? && session_user_redis__.logshop.shopId??>
            <a xzclick="addCollGoodsDataCannot" href="javascript:;" class="store">收藏此商品</a>
        <#else>
            <a xzclick="addCollGoodsData" href="javascript:;" class="store" data-goodsid="${goodsInfo.goodsId!}">收藏此商品</a>
        </#if>
        <a class="find_error" href="http://www.571xz.com/contact.htm" target="_blank">我要纠错<span class="text-999">（如价格有误请联系我们客服修改）</span></a>
        
    </div>
    















</div>



        </div>
        <div class="leftCol2">
            
<div class="goodsOrderBox" id="goodsOrderBox" data-goodsid="${goodsInfo.goodsId!}">
    <div class="goodsTitle">
        <#if goodsInfo.tbGoodsId??>
        <h2 class="fs18 fc3 yahei"><a href="http://item.taobao.com/item.htm?id=${goodsInfo.tbGoodsId!}" target="_blank">${goodsInfo.title!}</a>
        <#else>
        <h2 class="fs18 fc3 yahei">${goodsInfo.title!}
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
    <div class="goodsNumber">
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
    <div class="goodsPrice clearfix">
        <ul>
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
                <span class="fc3 yahei fs14"><em class="arail imClicks">-</em></span>
            </li>
        </ul>
        
    </div>
    
    
    <#if goodsInfo.onSale == false>
    <p class="noSale">此商品已下架</p>
    <#else>
    <div class="goodsColors clearfix">
        <label class="fc9 fl">颜色</label>
        <div id="colorsMetabox" class="colors clearfix">
            
        </div>
        
    </div>
    <div class="sizeBoxOuter">
        <div class="sizeBox clearfix">
            <label class="fc9">尺码</label>
            <div class="sizes"></div>
        </div>
        <div class="viewMorebox">
            <b class="button"><i class="icon-downarrow"></i></b>
        </div>
    </div>
    
    <div class="orderMenubox">
        <div class="countbox"><em>0</em>件</div>
        <div class="pricebox yahei fcF40">&yen;<em>0</em></div>
        <div class="menuButtonbox yahei tac">已选商品清单<i class="icon-uparrow"></i></div>
        <div class="menuListbox">
            <table>
                
            </table>
        </div>
        
    </div>
    
    

    <div class="buttonbox clearfix">
        <b class="btn btn-lg pr btn-orange <#if goodsInfo.onlineSale == true>addGwc<#else>notAddGwc</#if>">加入进货车
            <div class="pa notOnlineSale">
                商家暂未开通！
                <i class="i1"></i>
                <i class="i2"></i>
            </div>
        </b>
        <#if goodsInfo.hasOriginalPic == true>
        <b class="btn btn-lg btn-orange picDownload noLoadIcon" id="picDownload" data-goodsid="${goodsInfo.goodsId!}">
            精修大图下载
            <i class="originalPicIcon"></i>
        </b>
        <#else>
        <b class="btn btn-lg btn-orange picDownload" id="picDownload" data-goodsid="${goodsInfo.goodsId!}">图片下载</b>
        </#if>
        
















<script>
var hasYt = ${goodsInfo.hasOriginalPic!}; // 判断是否存在原图下载
</script>






        <b class="btn btn-lg oneKeyUp hover" data-goodsid="${goodsInfo.goodsId!}">一键上传</b>
        
        <#if goodsInfo.goodsVideoUrl??>
        <b class="btn btn-lg hover videoDownload" id="downloadGoodsVideo" data-videourl="downloadVideo.json?id=${goodsInfo.goodsId!}" data-goodsid="${goodsInfo.goodsId!}">视频下载</b>
        </#if>
        
        
        
        
        
    </div>
    <div class="payMode">
        <label class="fc9">支付</label>
        <span class="alipay">支付宝</span>
        <span class="weixin">微信</span>
    </div>
    
    </#if>
</div>









<script>
var colorsMeta = ${goodsInfo.colorsMeta!};
var sizesMeta = ${goodsInfo.sizesMeta!};
var piPrice = '${goodsInfo.piPrice!}';
</script>













































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
    <div class="detailContentBox">
        <div class="pageFixbar clearfix">
    <div class="fixContainer ">
        <div class="layout">
            <div class="shopName" >
                <span class="nameDetails" 
                    <#if shopInfo.xzUrl??>
                        onclick="jumpShopUrl(event, '${shopInfo.xzUrl!}')"
                    <#else> 
                        onclick="javascript:void(0)"
                    </#if>>${shopInfo.marketName!}${shopInfo.shopNo!}</span>
                <span>

<#assign text>{"id":"${(shopInfo.imWw!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>
</span>
                <span>

<#assign text>{"id":"${(shopInfo.imQq!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>
</span>
                <i class="ti icon-downarrow"></i>
                <div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li><label>地址：</label><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "gz">广州<#elseif webSite == "ss">石狮<#elseif webSite == "wa">辽源</#if>—${shopInfo.marketName!}${shopInfo.floor!}</li>
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
        <b><a href="http://${webSite!}.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <b xzclick="openTaobaoShop" data-href="${shopInfo.tbUrl!}">淘宝店铺</b>
        <#else>
        <em class="disabled">淘宝店铺</em>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop.shopId??>
            <b xzclick="collectShopCannot"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
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




<#assign text>{}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
        <#if field.timeFormat??>
            <#if field.value??>
            <input type=hidden name="${field.name!}" value="${field.value?string(field.timeFormat)}">
            <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
            </#if>
        <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
        </#if>
    </#list>
</form>
</#if>





</#list>


                
                <div class="itemDetailGoat">
    <h3>推荐商品</h3>
    <div class="goatCon">
        <ul>
            
        </ul>
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
                <li class="wxContainer"><b xzclick="showGoodsWx" data-goodsid="${goodsInfo.goodsId!}"><i class="ii"></i><span>分享朋友圈</span></b><div id="wxEwmbox" data-goodsid="${goodsInfo.goodsId!}"></div></li>
                <li class="addData"><b xzclick="addGoodsData" data-goodsid="${goodsInfo.goodsId!}"><i class="ii"></i><span>加入数据包</span></b></li>
                













                <li class="imgDownload" id="picDownload" data-goodsid="${goodsInfo.goodsId!}"><b xzclick="imgDownload"><i class="ii"></i><span>图片下载</span></b></li>
                <li class="copyCode" id="copyCodeBtn">
                    <script src="http://style.571xz.com/v2/xz/js/clipboard/jquery.zeroclipboard.min.js"></script>

                    <b><i class="ii"></i><span>复制详情HTML代码</span></b>
                </li>
        </ul>
        <p class="copyCodeSuccess"><em>宝贝描述复制完成</em></p>
        <div class="grewLine"></div>
        <div class="contactbox">
            <h3>联系档口</h3>
            <#if shopInfo.imWw??><p class="wangwang"><a href="http://www.taobao.com/webww/ww.php?ver=3&touid=${shopInfo.imWw!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank">档口旺旺</a>

<#assign text>{"id":"${(shopInfo.imWw!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>
</p></#if>
            <#if shopInfo.imQq?? && shopInfo.imQq != ""><p class="qq"><a href="http://wpa.qq.com/msgrd?v=3&uin=${shopInfo.imQq!}&site=qq&menu=yes" target="_blank">档口QQ</a>

<#assign text>{"id":"${(shopInfo.imQq!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>
</p></#if>
        </div>
    </div>
</div>



















            </div>
        </div>
    </div>
</div>
<div class="layout">
    
    <div class="recommendShop">
    <h3 class="fcF40">推荐档口</h3>
    <div class="shopCon">
        <ul class="clearfix">
            
        </ul>
    </div>
</div>






</div>























<script>
var goodsId = '${goodsInfo.goodsId!}';

</script>

<script src="http://style.571xz.com/v2/xz/js/rightbarV1.js"></script>




<div class="footer">
    <div class="inner">
        <p class="sitemap"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            | 
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <img src="http://style.571xz.com/v2/global/css/img/beian.png" alt="浙公网安备">
                浙公网安备 33010202000302号
            </a> 
        </p>
    </div>
</div>




<!--省略end，让浏览器自动添加-->

<#include "/common/cnzz.ftl">


