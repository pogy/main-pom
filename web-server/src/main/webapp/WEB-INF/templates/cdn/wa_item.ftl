<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${vo.cdnItem.title!} -四季星座网(全国专业网店货源、网络进货平台)</title>
    
    <meta name="keywords" content="欢迎前来四季星座网实力旺铺，选购${vo.cdnItem.title!},想了解更多${vo.cdnItem.title!}，请进入实力旺铺，更多商品任你选购">
    
    <meta name="description" content="四季星座,四季星座网,网上购物,店铺,${vo.cdnItem.title!},网店代理,淘宝货源,实体店网络进货">
    
    
    
    <link href="http://style.571xz.com/wa_shop_item_temp/css/item.css" rel="stylesheet">
    
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="inner">
        <div class="topbar-left">
            <span>Hi,</span> 
            欢迎来到四季星座网!
            <span class="c_margin_l20">
                <em>请</em>
                <a class="login" href="${main_host!}login.htm" target="_blank">登录</a>
            </span>
            <a class="register" href="${main_host!}regedit.htm" target="_blank">免费注册</a>
            <a class="login c_margin_l20" href="${main_host!}ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
        </div>
        <ul class="topbar-right clearfix">
            <li> 
            
                <div class="nav-name"><a href="${main_host!}member/index.htm">我是代理<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="${main_host!}member/shiguOnekeyRecordinit.htm" target="_blank" rel="nofollow">已上传的商品</a>
                    <a href="${main_host!}carts.htm" target="_blank" rel="nofollow">我的购物车</a>
                </div>
            </li>
            <li>
                <div class="nav-name"><em><i class="iconfont iconsc">&#xe615;</i>收藏夹<i class="img-jiantou"></i></em></div>
                <div class="nav-list">
                    <a href="${main_host!}member/storeCollectinit.htm?index=0" target="_blank" rel="nofollow">我的收藏</a>
                    <a href="${main_host!}member/goodsCollectinit.htm?webSite=hz" target="_blank" rel="nofollow">我的数据包</a>
                </div>
            </li>
            <li> 
                <div class="nav-name"><a href="${main_host!}seller/index.htm" target="_blank">档口中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="${main_host!}seller/releaseGoodsinit.htm" target="_blank" rel="nofollow">发布宝贝</a>
                    <a href="${main_host!}seller/storeGoodsListinit.htm" target="_blank" rel="nofollow">已发布的宝贝</a>
                </div>    
            </li>
            <li class="last">
                <div class="nav-name"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=${qiye_qq!}"  target="_blank" >客服中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=${qiye_qq!}" rel="nofollow">在线客服</a>
                    <a href="http://zixun.571xz.com/article?id=87" target="_blank" rel="nofollow">联系我们</a>
                    <a href="http://zixun.571xz.com/article?id=14" target="_blank" rel="nofollow">新手入门</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="rect-wrap clearfix">
    <a class="logo iconfont fl" href="http://www.571xz.com/index.html"><img src="http://static.571xz.com:86/images/LOGO_2.png" title="四季星座网-首页" width="200" height="46"></a>
    <div class="changeCity fl">
        <strong>东北袜业</strong>
        <div class="citylist">
        <span class="changebutton">切换城市<i class="img-jiantou"></i></span>
        <ul>
        <li><a href="http://hz.571xz.com">杭州</a></li>
        <li><a href="http://cs.571xz.com">常熟</a></li>
        <li><a href="http://ss.571xz.com">石狮</a></li>
        <li><a href="http://bj.571xz.com">北京</a></li>
        <li><a href="http://gz.571xz.com">广州</a></li>
        <li class="selected"><a href="http://wa.571xz.com">辽源</a></li>
        </ul>
        </div>
    </div>
    <div class="c_shopsigns fl clearfix">
        <div class="c_shopsigns_ fl">
            <span class="iconfont"></span>
        </div>
        <div class="c_shop_info fl c_box">
            <a href="shop.htm?id=40470" title="点击进入本店铺" target="_blank"><span class="c_shop_name" title="${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}">${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</span></a>
            <#if vo.storeRelation.imQq?? && vo.storeRelation.imQq != "">
            <a class="fr c_mf10" href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank"><img src="http://static.571xz.com:86/resources2016/images/qq2016.png" alt="联系qq" width="16" height="18"></a>
            </#if>
            <span id="alww1"><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=${vo.storeRelation.imWx!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" style="width: 20px;" class="fr c_mf10 ali-base online" target="_blank"></a>
        </span>
            <i class="img-jiantou"></i>
            <div class="c_superstar"><i class="c_c_ff4400">${vo.starNum!}</i><span></span></div>
            <div class="c_smg">
                <div class="pop-shop-info clearfix">
                    <div class="fl shop-more-info">
                        <p class="info-item"><span class="title">市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;场：</span>${vo.storeRelation.marketName!} - ${vo.storeRelation.floor!}</p>
                        <p class="info-item"><span class="title">宝&nbsp;&nbsp;贝&nbsp;数：</span>${vo.storeRelation.goodsCount!}</p>
                        <p class="info-item"><span class="title">开店时间：</span>${vo.other.openTime!}</p>
                        <div class="clearfix c_shop_Icon">
                            <#if vo.shopLicenses??>
                            <#list vo.shopLicenses as license>
                                <#if license.licenseType == 3> 
                                <div class="fl"><img src="http://style.571xz.com/wa_shop_item_temp/css/img/com_shop_strz_2016.jpg" width="30" height="30">实体认证</div>
                                </#if>
                            </#list>
                            </#if>
                            <#if vo.hasAuth == 0>
                            <div class="fl"><img src="http://style.571xz.com/wa_shop_item_temp/css/img/com_shop_sqtb_2016.jpg" width="30" height="30">未授权</div>
                            <#elseif vo.hasAuth == 1>
                            <div class="fl"><img src="http://style.571xz.com/wa_shop_item_temp/css/img/com_shop_sqtb_2016.jpg" width="30" height="30">同步授权</div>
                            <#elseif vo.hasAuth == 2>
                            <div class="fl"><img src="http://style.571xz.com/wa_shop_item_temp/css/img/com_shop_sqtb_2016.jpg" width="30" height="30">授权过期</div>
                            </#if>
                        </div>
                    </div>
                    <div class="fr shop-zypp">
                        <strong>主营品牌</strong>
                        <ul class="clearfix">
                          
                        </ul>
                    </div>
                </div>
                <div class="header-operation">
                    <p class="fl c_shopAdress">店铺地址：<span><a href="http://wa.571xz.com/shop.htm?id=40470" title="http://wa.571xz.com/shop.htm?id=40470">wa.571xz.com/shop.htm?id=40470</a></span></p>
                    <a class="fr c_buttion_white scStore" data-id="${vo.storeRelation.storeId!}"><i class="iconfont"></i>收藏本档口</a>
                </div>
            </div>
        </div>
    </div>
    <div class="rect-search fr">
        <!-- 企业是什么鬼 url 要改的话 wa-search-tabbox.js 里也要改-->
        <form action="http://so.571xz.com/wasearch.htm" target="_blank" id="searchgo4">
            <div class="tabbox c_box">
                <ul>
                    <li>商品</li>
                    
                    <li>企业</li>
                </ul>
                <i class="img-jiantou"></i>
            </div>
            <input class="text-search2016" placeholder="请输入搜索关键字" name="keyword" type="text">
            <input class="j_web" value="wa" name="webSite" disabled="" type="hidden">
            <button class="btn-search2016">搜索</button>
        </form>
    </div>
</div>
<script>/*============ wa_shop_item_temp/page#header BEGIN ============*/

var webSite = '${vo.storeRelation.webSite!}';

/*============ wa_shop_item_temp/page#header END ============*/


</script> 
<div class="dht clearfix">
    <div class="dhNav">
        <ul class="clearfix">
                <li><a href="shop.htm?id=${vo.storeRelation.storeId!}" >首页</a></li>
                <li class="c_all_cat"><a href="http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2">全部商品</a><i class="iconfont">&#xe651;</i>
                    <div class="c_all_cat_fst">
                        <ul class="c_cat_fst_ul clearfix">
                            <li class="c_cat_fst_li">
                                <h4><a href="http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2">所有宝贝</a></h4>
                                <div class="c_all_cat_snd">
                                    <ul class="c_cat_snd_ul clearfix">
                                        <li class="c_cat_snd_li"><h4><a href="${main_host!}shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2&order=time_up">按新品</a></h4></li>
                                        <li class="c_cat_snd_li"><h4><a href="${main_host!}shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2&order=price-asc">按价格</a></h4></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </li>
                
                <li><a href="http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}&timeflag=4">下架商品</a></li>
                <li><a href="${main_host!}shopcomment.htm?id=${vo.storeRelation.storeId!}">店铺讨论区</a></li>
        </ul>
    </div>
</div>
<div class="content_top layout">
    <div class="crumbbox">
        <div class="ctWeb_map" >
            <ul class="j_mapCon">
                <li><a href="http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2" target="_blank" >所有宝贝</a></li>
            </ul>
        </div>
    </div>
    <div class="leftbox">
        <div class="left_Img">
            <div class="bigImg">
                <ul>
                    <#list vo.cdnItem.imgUrl as img>
                        <#if img_index == 0>
                        <li>
                            <a href="javascript:;">
                                <img src="${img!}_460x460.jpg" class="j_bigImg" alt  />
                            </a>
                        </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="smImg j_smImg">
                <ul>
                    <#list vo.cdnItem.imgUrl as img>
                        <#if img_index == 0>
                            <li class="select">
                                <a href="javascript:;">
                                    <img src="${img!}_60x60.jpg" alt width=58 height=58 />
                                </a>
                            </li>
                        <#else>    
                            <li>
                                <a href="javascript:;">
                                    <img src="${img!}_60x60.jpg" alt width=58 height=58 />
                                </a>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <div class="rtAct">
                <a href="javascript:;" onclick="sc_goods(${vo.itemId!})"><i class="iconfont cticon">&#xe6b3;</i>收藏此商品</a>
                <a href="${qiye_qq!}" target="_blankt"><i class="iconfont rticon">&#xe697;</i>举报</a>
            </div>
        </div>
        <div class="goodsDcon">
            <div class="goods_Name">
                <p><a href="javascript:;">${vo.cdnItem.title!}</a></p>
            </div>
            <div class="price_k">
                <p class="price">零售价<span>￥<em>${vo.cdnItem.price!}</em></span></p>
                <p class="p_price">批发价<span class="c_c_ff4400">￥<em>${vo.cdnItem.piPrice!}</em></span></p>
            </div>
            <div class="goods_upt">
                <dl>
                    <dt>发货地</dt>
                    <dd>${vo.cdnItem.sendFrom!}</dd>
                    <dt class="goodsN">货号</dt>
                    <dd class="sz">${vo.cdnItem.huohao!}</dd>
                    <dt>上架时间</dt>
                    <dd class="sz">${vo.cdnItem.listTime!}</dd>
                </dl>
            </div>
            <div class="proCon">
                <div class="clearfix">
                    <div id="size-label" class="name fl">尺码</div>
                    <div class="selectType gyselect j_gyselect">
                        <ul id="size_id">
                            <#list vo.cdnItem.sizes as size>
                                <li title="${size.value!}" data-value="${size.pid!}:${size.vid!}" ><a href="javascript:;">${size.value!}</a></li>
                            </#list>
                        </ul>
                    </div>
                </div>
                <div class="clearfix">
                    <div id="color-label" class="name fl" style="height:40px; line-height:40px;">颜色</div>
                    <div class="selectColor j_selectColor gyselect j_gyselect">
                        <ul id="color_id">
                            <#list vo.cdnItem.colors as fcolor>
                                <#if fcolor.imgUrl?? && fcolor.imgUrl != "">
                                <li title="${fcolor.value!}" data-value="${fcolor.pid!}:${fcolor.vid!}" ><span><img src="${fcolor.imgUrl!}_30x30.jpg" alt width=36 height=36 /></span></li>
                                <#else>
                                <li title="${fcolor.value!}" data-value="${fcolor.pid!}:${fcolor.vid!}" ><span>${fcolor.value!}</span></li>
                                </#if>
                            </#list>
                        </ul>
                    </div>
                </div>
                <div class="clearfix">
                    <div class="Sumname fl ">数量</div>
                    <div class="selectNum j_selectNum ">
                        <input type="text" id="Num" class="j_Num" value="1">
                        <a href="javascript:;" id="Add">+</a>
                        <a href="javascript:;" id="Cuts">-</a>
                    </div>
                    <div class="kcCon">
                        <span>件</span>
                        <span class="kc">库存<em>${vo.cdnItem.num!}</em>件</span>
                    </div>
                </div>
                <div class="clearfix">
                    <div class="name fl">代理</div>
                    <div class="selectsUpc gyselect j_weixin_boss">
                        <div class="ewmK j_ewmK"><div class="j_erweima erweima"><img src="" alt width=134 height=134 /></div><i class="c_jt"></i></div>
                        <p class="up_button">
                            <a class="wa_buttion_up" href="http://upload.571xz.com/publish.htm?id=${vo.itemId!}&wsit="  title="上传淘宝" target="_blank" >淘宝</a>
                            <a class="wa_buttion_up" href="http://1688.571xz.com/offer/publish.htm?id=${vo.itemId!}"  title="上传阿里" target="_blank">阿里</a>
                            <a href="javascript:;" class="wa_buttion_up j_weixin" title="上传微信" data-id="${vo.itemId!}">微信</a>
                            <a class="wa_buttion_up wa_buttion_add" href="javascript:;" onclick="sc_goods(${vo.itemId!})" title="加数据包">数据包</a>
                        </p>
                    </div>
                </div>
                <div class="shoppingBtnK gyselect">
                    <!--<a href="javascript:;" onclick="addDaifaCart()">我要进货</a>-->
                    <a href="javascript:;" class="jrShopcar" onclick="addDaifaCart()"><span class="iconfont">&#xe695;</span>加入购物车</a>
                </div>
                <div class="clearfix">
                    <div class="name fl">服务</div>
                    <div class="hasSever gyselect">
                        <ul>
                            <li class="yjdf">一件代发</li>
                            <li class="kth">可退货</li>
                            <li class="khh">可换货</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="rightbox">
        <div class="gooShop">
            <div class="gooShopName">
                <a href="shop.htm?id=${vo.storeRelation.storeId!}"> <h1>${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h1></a>
                <div class="c_superstar"><i class="c_c_ff4400">${vo.starNum!}</i><span></span></div>
            </div>
            <div class="pdCs">
                <div class="mainBrand">
                    <h2>主营品牌：</h2>
                    <div class="brandName">
                        
                    </div>
                </div>
                <div class="shopIm">
                    <ul>
                        <li class="shopAdress"><span><em>地址</em>：</span>${vo.other.address!}</li>
                        <li class="goodsNum"><span><em>宝贝数</em>：</span>${vo.storeRelation.goodsCount!}</li>
                        <li><span>开店时间：</span>${vo.other.openTime!}</li>
                        <li><span>联系电话：</span>${vo.storeRelation.telephone!}</li>
                        <li>
                            <span class="fl">在线咨询：</span>
                            <span id="alww2">
                                <script type="text/javascript">
                                    function AliStatus(json) {
                                        var a = document.getElementById('alww2');
                                        var stats = json.data == 1 ? 'online' : 'online-not';
                                        console.log(stats);
                                        a.innerHTML = '<a href="http://www.taobao.com/webww/ww.php?ver=3&touid=${vo.storeRelation.imWw!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" style="width: 20px;" class="fl c_mf10 ali-base ' + stats + '" target="_blank"></a>';
                                    }
                                </script>
                                <script type="text/javascript" src="https://amos.alicdn.com/muliuserstatus.aw?callback=AliStatus&site=cntaobao&charset=utf-8&uids=${vo.storeRelation.imWw!}"></script>
                            </span>
                            <#if vo.storeRelation.imQq != ""><a class="fl c_mf10" href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank"><img src="http://style.571xz.com/global_temp/css/resources2016/images/qq2016.png" width="16" height="18" alt="联系qq"></a></#if>
                        </li>
                    </ul>
                </div>
                <div class="rOperate">
                    <a href="shop.htm?id=${vo.storeRelation.storeId!}" target="_blank" class="enterShop" >进入店铺</a>
                    <a href="javascript:;" class="scStore" target="_blank" data-id="${vo.storeRelation.storeId!}" >收藏本档口</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="content_main layout">
    <div class="leftbox">
        
        <div class="c_ds_gClassify">
            <div class="goodsH">
                <h1>宝贝分类</h1>
            </div>
            <div class="cyDetail">
                <div class="eachCy">
                    <a href="shop.htm?id=${vo.storeRelation.storeId!}&timeflag=2" class="eachCyBtn j_eachCyBtn" >查看所有宝贝</a>
                    <ul class="newGoods">
                        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&timeflag=3">今日新品</a></li>
                        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&timeflag=5">本周更新</a></li>
                        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&timeflag=6">本月更新</a></li>
                    </ul>
                </div>
                <#list vo.shopCats as shop_cat>
                    <div class="eachCy">
                        <a href='shop.htm?id=${vo.storeRelation.storeId!}&scid=${shop_cat.cid!}" />&timeflag=2' class="eachCyBtn j_eachCyBtn">${shop_cat.name!}</a>
                        <ul class="">
                            <#if (shop_cat.subCats?size) gt 0>
                                <ul class="menuList">
                                    <#list shop_cat.subCats as scat>
                                        <li>
                                            <a href='shop.htm?id=${vo.storeRelation.storeId!}&scid=${scat.cid!}&timeflag=2'>
                                                ${scat.name!}
                                            </a>
                                        </li>
                                    </#list>
                                </ul>
                            </#if>
                        </ul>
                    </div>
                </#list>
            </div>
        </div>
        
    </div>
    <div class="rightbox">
        <div class="goodsIntro">
            <div class="txo">
                <a href="javascript:;" class="select j_wxoBtn">商品详情</a>
            </div>
            <div class="goodsIntroTextCon">
                <ul>
                    <#list vo.cdnItem.normalProps as prop>
                        <li title="${prop.value!}">${prop.pname!}:${prop.value!}</li>
                    </#list>
                </ul>
            </div>
            <div class="cfImg">
                <div align="center">
                    ${vo.cdnItem.description}
                </div>
            </div>
        </div>
    </div>
</div>
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
<script src="http://style.571xz.com/wa_shop_item_temp/js/item.js?t=20170516"></script>
<#include "/common/cnzz.ftl">
</body>
</html>