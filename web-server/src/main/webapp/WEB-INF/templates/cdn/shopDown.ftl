<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>四季星座网</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="//style.571xz.com/shopItemCopy/css/shopDown.css?t=1504256450648" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
            <script src="//style.571xz.com/shopItemCopy/js/temp/ekoo.min.js"></script>
    <script src="//style.571xz.com/shopItemCopy/js/shopDown.js?t=1504256450648"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                    <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源<#elseif webSite == "jx">濮院<#elseif webSite == "cz">沧州<#elseif webSite == "qz">泉州</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="//hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="//cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="//qz.571xz.com" <#if webSite == "qz">class="select"</#if>>泉州</a></li>
                        <li><a href="//cz.571xz.com" <#if webSite == "cz">class="select"</#if>>沧州</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="//www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="//www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
                
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
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
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
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
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
                    <a href="//www.571xz.com/contact.htm" target="_blank">联系客服</a>
                    
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                                <li><a href="//hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<script>/*============ xz/page#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/page#topbar END ============*/


</script>
<div class="headeV1">
    <div class="layout">
        <div class="logoBox">
            <a href="//${webSite!}.571xz.com/">
                <img src="//style.571xz.com/xz/css/img/mtLogo.png" alt="四季星座网" width="168" height="30">
            </a>
        </div>
        <div class="splitline"></div>
        <div class="storeInfobox hover">
            <div class="storeLogo iconfont"></div>
            
            <div class="storeNamebox">
                <h3 onclick="openShop()">${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h3>
<#assign text>{"id":"${vo.storeRelation.imWw!}"}</#assign>
<#assign $it=text?eval />
                <a class="imAliww" href="//amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&uid=${$it.id!}" target="_blank"></a>
<#assign text>{"id":"${vo.storeRelation.imQq!}"}</#assign>
<#assign $it=text?eval />
                <#if $it.id != "">
                <a class="imQQ" href="//wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
                </#if>

            <#if vo.existWx??><i style="display: inline-block; cursor: default; width: 18px; height: 18px; vertical-align: -2px; margin-left: 5px; background: url(//style.571xz.com/v6/goodsDetail/css/img/wxIcon.png)"></i></#if>
                <i class="ti iconfont">&#xe60b;</i>
            </div>
            
<script>/*============ shopItemCopy/page#headeV1 BEGIN ============*/

function openShop(){
                var shopId = '${vo.storeRelation.storeId!}';
                var webSite = '${webSite!}';
                window.open('//'+ webSite +'.571xz.com/shop.htm?id=' + shopId);
            }

/*============ shopItemCopy/page#headeV1 END ============*/


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
                        <li><label>地址：</label><#if vo.storeRelation.webSite == "hz">杭州<#elseif vo.storeRelation.webSite == "cs">常熟<#elseif vo.storeRelation.webSite == "gz">广州<#elseif vo.storeRelation.webSite == "ss">石狮<#elseif vo.storeRelation.webSite == "wa">辽源<#elseif vo.storeRelation.webSite == 'jx'>濮院</#if>—${vo.storeRelation.marketName!}${vo.storeRelation.floor!}</li>
                        <li><label>档口电话：</label>${vo.storeRelation.telephone!}</li>
                        <#if vo.isZx??><li><label>发货咨询：</label>${vo.storeRelation.advisoryMobile!}</li></#if>
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
                    <b><a href="//${webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}">进入店铺</a></b>
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
        
        <form id="searchgo3" class="c_shop_search_2016" action="//so.571xz.com/${vo.storeRelation.webSite!}search.htm">
            <button id="allSearchbtn">搜全站</button>
            <div class="shopSecrh">
                <div class="search">
                    <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text" value="${query.pstring!}">
                    <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
                </div>
            </div>
        </form>
        
<script>/*============ shopItemCopy/page#headeV1 BEGIN ============*/

var webSite = '${webSite!}';

/*============ shopItemCopy/page#headeV1 END ============*/


</script>        
    </div>
</div>
${navCon}
<div class="content layout">
 <p>该店铺已关店</p>
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:656px;"> 
            <a href="/" target="_blank">首页</a>
            <a href="//hz.571xz.com" target="_blank">杭州站</a>
            <a href="//cs.571xz.com" target="_blank">常熟站</a>
            <a href="//qz.571xz.com" target="_blank">泉州站</a>
            <a href="//cz.571xz.com" target="_blank">沧州站</a>
            <a href="//zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2018 571xz.com 版权所有</span> <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="//style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a>
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">
</body>
</html>