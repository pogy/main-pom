<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺讨论区域-${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}-四季星座网</title>
    
    <meta name="keywords" content="欢迎前来四季星座网 ${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!} 优质档口，众多商品任你选择  ">
        <meta name="description" content="四季星座，四季星座网，一键代发，一键上传，${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}">
        
    
    
    
    <link href="http://style.571xz.com/shop_itemV2/css/shopcomment.css" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/shop_itemV2/js/shopcomment.js"></script>
    
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="web-topNav2016">
    <div class="topNav">
        <div class="navLeft">
            <span style="float:left">Hi,</span>
            <div class="menuHome" style="display: inline-block;">
            欢迎来到四季星座网!
                <span class="c_margin_l20">
                    <em>请</em>
                    <a onclick="login_backs()" target="_blank"><span class="login">登录</span></a>
                </span>
                <a href="${main_host!}regedit.htm" target="_blank" class="c_margin_l10">免费注册</a>
                <a class="login c_margin_l20" href="${main_host!}ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
            </div>
        </div>
        <div class="navRight">
            <ul class="clearfix">
                <li class="navMap">
                    <div class="navIn">
                        <a href="${main_host!}member/index.htm">我是代理<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div id="xzInfo" class="showBox">
                        <dl>
                        <dt style="display:none;">我是代理</dt>
                            <dd>
                                <a rel="nofollow" href="${main_host!}member/shiguOnekeyRecordinit.htm" target="_blank">已上传的商品</a>
                            </dd>
                            <dd>
                                <a rel="nofollow" href="${main_host!}carts.htm" target="_blank">我的购物车</a>
                            </dd>
                        </dl>
                    </div>
                </li>
                <li class="navMap">
                    <div class="navIn">
                        <a href="javascript:;"><span class="iconfont ico2">&#xe615;</span>收藏夹<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="shoucang" >
                        <a rel="nofollow" class="favorite-offer" title="我的收藏" href="${main_host!}member/storeCollectinit.htm?index=0" target="_blank">我的收藏</a>
                        <a rel="nofollow" class="favorite-seller" title="我的数据包" href="${main_host!}member/goodsCollectinit.htm?webSite=hz" target="_blank">我的数据包</a>
                    </div>
                </li>
                <li class="navMap">
                    <div class="navIn">
                        <a href="${main_host!}seller/index.htm" target="_blank">档口中心<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="ghsht">
                        <a rel="nofollow" title="发布宝贝" href="${main_host!}seller/releaseGoodsinit.htm" target="_blank">发布宝贝</a>
                        <a rel="nofollow" title="已发布的宝贝" href="${main_host!}seller/storeGoodsListinit.htm" target="_blank">已发布的宝贝</a>
                    </div>
                </li>
                <li class="navMap">
                    <div class="customSe navIn">
                        <a href="<%=qq_qiye%>" target="_blank">客服中心<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="kfzx">
                          <dl>
                          <dt style="display:none;"><a href="<%=qq_qiye%>" target="_blank">客服中心</a></dt>
                            <dd>
                                <a rel="nofollow" title="联系客服" href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}"  target="_blank">在线客服</a>
                            </dd>
                            <dd>
                                <a rel="nofollow" title="联系我们" href="http://zixun.571xz.com/article?id=87"  target="_blank">联系我们</a>
                            </dd>
                             <dd>
                                <a rel="nofollow" title="新手入门" href="http://zixun.571xz.com/article?id=14" old_href="${main_host!}member/releaseGoodsinit.htm" target="_blank">新手入门</a>
                            </dd>
                        </dl>
                    </div>
                </li>
            </ul>
        </div>
        <div class="c_back_index fr clearfix"><a href="${main_host!}"><span class="iconfont">&#xe61e;</span>四季星座网首页<span class="ico1 c_ico_jiantou"></span></a></div>
    </div>
</div>
<div class="rect-wrap clearfix">
    <div class="shopName">
    <a class="logo iconfont c_logo2016" href="http://${vo.storeRelation.webSite!}.571xz.com/index.html"><img src="http://style.571xz.com/global_temp/css/images/LOGO_2.png" title="四季星座网-首页" width="200" height="46"></a>
<div class="changeCity">
    <strong>
        <#if vo.storeRelation.webSite == "cs">常熟<#elseif vo.storeRelation.webSite == "hz">杭州<#elseif vo.storeRelation.webSite == "bj">北京<#elseif vo.storeRelation.webSite == "ss">石狮<#elseif vo.storeRelation.webSite == "wa">辽源<#elseif vo.storeRelation.webSite == "gz">广州</#if>
    </strong>
    <div class="topSelect">
     <a class="selectTit" href="javascript:;">切换城市</a>
     <span class="c_ico_jiantou"></span>
     <ul>
      <li<#if vo.storeRelation.webSite == "hz"> class="select"</#if>><a href="http://hz.571xz.com">杭州<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "cs"> class="select"</#if>><a href="http://cs.571xz.com" target="_blank">常熟<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "ss"> class="select"</#if>><a href="http://ss.571xz.com" target="_blank">石狮<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "bj"> class="select"</#if>><a href="http://bj.571xz.com" target="_blank">北京<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "gz"> class="select"</#if>><a href="http://gz.571xz.com" target="_blank">广州<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "wa"> class="select"</#if>><a href="http://wa.571xz.com" target="_blank">辽源<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
     </ul>
    </div>
</div>
        <h2>
            ${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}
            <a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=${vo.storeRelation.imWw!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><img src="http://static.571xz.com:86/resources2016/images/ww2016.png" alt="联系旺旺" width="16" height="18"></a>
            <#if vo.storeRelation.imQq?? && vo.storeRelation.imQq != "">
            <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank"><img src="http://static.571xz.com:86/resources2016/images/qq2016.png" alt="联系qq" width="16" height="18"></a>
            </#if>
        </h2>
        <div class="Diamonds pdl0 xinyuxingxingB">
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
    </div>
    <form id="searchgo3" class="c_shop_search_2016" action="http://so.571xz.com/${vo.storeRelation.webSite!}search.htm">
    <button id="allSearchbtn">搜全站</button>
    <div class="shopSecrh">
        <div class="search">
            <input id="keyword" name="keyword" class="text-search" placeholder="请输入搜索关键字" type="text">
            <input id="soInStore" class="btn-search" value="搜本店铺" type="button">
        </div>
    </div>
    </form>
</div>
<div class="shopNav">
    <ul>
        <li><a href='<#if vo.domain != "">http://${vo.domain!}.571xz.com<#else>http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}</#if>'>店铺首页</a></li>
        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=2">全部商品</a></li>
        
        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=4">下架商品</a></li>
            <li class="all"><a href="shopcomment.htm?id=${vo.storeRelation.storeId!}">店铺讨论区</a></li>
        <li class="all" style="float:right;"><a href="http://${vo.storeRelation.webSite!}.571xz.com/<#if vo.storeRelation.webSite == 'hz'>market.htm<#else>huoyuan</#if>">返回市场</a></li>
    </ul>
</div>
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
                <li><a href="javascript:;" id="scStore" data-id="${vo.storeRelation.storeId!}" title="收藏本店">收藏本店</a></li>
                <#if vo.other.taobaoUrl != "">
                <li><a href="${vo.other.taobaoUrl!}" rel="nofollow" target="_blank" title="进入批发商淘宝店铺">进入淘宝店</a></li>
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
    
    <script>/*============ shop_itemV2/shopcomment#comment_con BEGIN ============*/

var storeId = ${vo.storeRelation.storeId!};

/*============ shop_itemV2/shopcomment#comment_con END ============*/


</script>
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
</body>
</html>