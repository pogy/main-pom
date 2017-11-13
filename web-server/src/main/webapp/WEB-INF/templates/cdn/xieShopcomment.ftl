<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>店铺讨论区域-${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}-看鞋网</title>
    
    <meta name="keywords" content="欢迎前来看鞋网 ${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!} 优质档口，众多商品任你选择">
    
    <meta name="description" content="看鞋网，一键代发，一键上传，${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}">
    
    <link href="http://style.571xz.com/xieShopItem/css/xieShopcomment.css?t=1499248646113" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/xieShopItem/js/xieShopcomment.js?t=1499248646113"></script>
  </head>
<body>
<#include "/common/host_config.ftl">
<script>/*============ xieShopItem/host_config#base BEGIN ============*/

'${test!}';
var main_host = 'http://www.kxie.com/';

/*============ xieShopItem/host_config#base END ============*/


</script>
<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "kx">看鞋网</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://www.kxie.com" <#if webSite == "kx">class="select"</#if>>看鞋网</a></li>
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
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
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
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
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
                <li class="noDown">
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                    
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<script>/*============ xz/kxPage#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/kxPage#topbar END ============*/


</script>
<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="http://www.kxie.com/">
                <img src="http://style.571xz.com/xz/css/img/logo.png" alt="看鞋网" width="150" height="48">
            </a>
        </div>
        <div class="splitline"></div>
        <div class="storeInfobox hover">
            <div class="storeLogo iconfont"></div>
            
            <div class="storeNamebox">
                <h3 onclick="openShop()">${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h3>
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
            
<script>/*============ xieShopItem/page#headeV1 BEGIN ============*/

function openShop(){
                var shopId = '${vo.storeRelation.storeId!}';
                var webSite = '${webSite!}';
                window.open('http://www.kxie.com/shop.htm?id=' + shopId);
            }

/*============ xieShopItem/page#headeV1 END ============*/


</script>            
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
                        <li><label>地址：</label>看鞋网—${vo.storeRelation.marketName!}${vo.storeRelation.floor!}</li>
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
                    <b><a href="http://www.kxie.com/shop.htm?id=${vo.storeRelation.storeId!}">进入店铺</a></b>
                    <#if vo.other.taobaoUrl??>
                    <b xzclick="openTaobaoShop" data-href="${vo.other.taobaoUrl!}">淘宝店铺</b>
                    
                    <#else>
                    <em class="disabled">淘宝店铺</em>
                    </#if>
                    <#if session_user_redis__.logshop.shopId??>
                        
                        <b xzclick="collectShopCannot" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
                    <#else>
                        
                        <b xzclick="collectShop" data-shopid="${vo.storeRelation.storeId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
                    </#if>
            
            
            
                </div>
                
            </div>
            
        </div>
        
        <form id="searchgo3" class="c_shop_search_2016" action="http://www.kxie.com/${vo.storeRelation.webSite!}search.htm">
            <button id="allSearchbtn">搜全站</button>
            <div class="shopSecrh">
                <div class="search">
                    <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text" value="${query.pstring!}">
                    <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
                </div>
            </div>
        </form>
        
<script>/*============ xieShopItem/page#headeV1 BEGIN ============*/

var webSite = '${webSite!}';

/*============ xieShopItem/page#headeV1 END ============*/


</script>        
    </div>
</div>
${navCon}
<div class="content layout">
    <div class="leftbox">
        
    
<#assign text>{        "freemarker":true,        "fields":[            {"name":'id', "value":${vo.storeRelation.storeId!}},            {"name":'pstring', "value":"${query.pstring!}"},            {"name":'beginPrice', "value":"${query.beginPrice!}"},            {"name":'endPrice', "value":"${query.endPrice!}"}        ]    }</#assign>
<#assign $it=text?eval />
        <form id="wgt_search">
        <#list $it.fields as field>
        <input type=hidden name="${field.name!}" value="${field.value!}">
        </#list>
    </form>
    
        
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
        <ul class="setShow">
            <#if vo.shopLicenses??>
            <#list vo.shopLicenses as license>
                <#if license.licenseType == 3> 
                <li>
                    <a class="iconfont yellow" href="javascript:;"><em></em></a>
                    <p>实体认证</p>
                </li>
                </#if>
            </#list>
            </#if>
            <#if vo.hasAuth == 0>
            <li>
                <a class="iconfont green" href="javascript:;"><em></em></a>
                <p>未授权</p>
            </li>
            <#elseif vo.hasAuth == 1>
            <li>
                <a class="iconfont green" href="javascript:;"><em></em></a>
                <p>同步授权</p>
            </li>
            <#elseif vo.hasAuth == 2>
            <li>
                <a class="iconfont green" href="javascript:;"><em></em></a>
                <p>授权过期</p>
            </li>
            </#if>
            
            
        </ul>
        <div class="txtInfo">
            <p>市场：${vo.storeRelation.marketName!} ${vo.storeRelation.floor!}</p>
            <p>宝贝数：<span id="j_goods_count">${vo.goodsNum!}</span></p>
            <p>主营：${vo.other.mainBus!}</p>
            <p>联系：<font color="#ff4901">${vo.storeRelation.telephone!}</font></p>
            <p>开店时间：${vo.other.openTime!}</p>
            
        </div>
        <ul class="contactUl" >
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
                <li>
                    <#if session_user_redis__.logshop.shopId??>
                    <a href="javascript:;" id="scStore" xzclick="collectShopCannot" title="收藏本店">收藏本店</a>
                    <#else>
                    <a href="javascript:;" id="scStore" xzclick="collectShop" data-id="${vo.storeRelation.storeId!}" title="收藏本店">收藏本店</a>
                    </#if>
                </li>
                <#if vo.other.taobaoUrl != "">
                <li><a href="${vo.other.taobaoUrl!}"  rel="nofollow" target="_blank" title="进入批发商淘宝店铺">进入淘宝店</a></li>
                <#else>
                <li><a class="disabled" rel="nofollow" target="_blank" title="进入批发商淘宝店铺">进入淘宝店</a></li>
                </#if>
            </ul>
        </div>
    </div>
    
    
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
    <div class="rightbox">
    <div class="shopComment">
    <!--1-->
        <div class="comTitle">
            累计评分（<font color="#ff4901">${vo.scoreAvg!}</font>分）
            <ul><li></li><li></li><li></li><li></li><li></li></ul>
            累计评论（<font color="#ff4901">${vo.totalCount!}</font>）
        </div>
        <div class="box">
            <table id="j_add_comment_desc" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="30" valign="middle">
                    您的评价：
                    <p class="fr"><em class="iconfont">&#xe67e;</em>打分需要满足一定条件的（如一天只能打分1次，淘宝绑定才能评论）</p>
                </td>
              </tr>
              <tr>
                <td><textarea></textarea></td>
              </tr>
              <tr>
                <td>
                    <ul class="pFxx" id="j_pFxx">
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    <p class="fenshu"><em id="fsNum">0</em>分</p>
                    <button id="j_add_comment">提交评价</button>
                </td>
              </tr>
            </table>
        </div>
        <div class="comBox">
            <table class="hpConTab" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                    <tr>
                        <th align="left" width="60%">评价心得</th>
                        <th width="20%">评分</th>
                        <th>评论者</th>
                    </tr>
                    <#list vo.discus.content as discu>
                    <tr>
                        <td>
                            <ul class="plBox">
                                <li>
                                     <p class="txt">${discu.say!}</p> 
                                </li>
                            </ul>
                        </td>
                        <td align="center" valign="middle">
                            <p class="xxShow">
                                <#if discu.giveScore == 1>
                                <a href="javascript:;"></a>
                                <#elseif discu.giveScore == 2>
                                <a href="javascript:;"></a><a href="javascript:;"></a>
                                <#elseif discu.giveScore == 3>
                                <a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a>
                                <#elseif discu.giveScore == 4>
                                <a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a>
                                <#elseif discu.giveScore == 5>
                                <a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a>
                                </#if>
                            </p>
                        </td>
                        <td align="center" valign="middle">
                            <div class="people">
                                ${discu.who!}<font color="#666"></font>
                                <p><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a></p>
                            </div>
                        </td>
                      </tr>
                    </#list>
                </tbody>  
             </table>
        </div>
        <div class="jq_pagination" data-option="${pageOption!}"></div>
    </div>
    
    <script>/*============ xieShopItem/xieShopcomment#comment_con BEGIN ============*/

var storeId = ${vo.storeRelation.storeId!};

/*============ xieShopItem/xieShopcomment#comment_con END ============*/


</script>
    </div> 
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:656px;"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
            <a href="http://www.kxie.com" target="_blank">看鞋网</a>
        </p>
        <!--#<p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>#-->
        <p class="jyga">
            <span>&copy; 2017-2017 kxie.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=17015635" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙ICP备17015635号 </a>
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">
</body>
</html>