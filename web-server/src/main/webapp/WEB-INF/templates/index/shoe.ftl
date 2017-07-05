<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>[看鞋网]-网店代理货源，网上鞋类进货，男鞋淘宝货源，女鞋淘宝货源，网络货源,网店货源导航,淘宝店货源,实体网络进货,泉州网店之家,泉州专业网店货源,泉州网店货源</title>
    <meta name="keywords" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    <meta name="description" content="看鞋网泉州的鞋类货源批发网,市场包含了华联A栋，华联B栋，义兴堂，滨江幸福广场，晋江电子商务中心等,是网络卖家网络货源平台,网店货源,女鞋货源,泉州女鞋货源,淘宝货源,实体店网络进货渠道，网店货源,实体店网络进货优选渠道!">
    
    <link href="http://style.571xz.com/xieIndex/css/shoe.css?t=1499247705759" rel="stylesheet">
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/xieIndex/js/jquery.cookie.js"></script>
<script>/*============ xieIndex/page#layoutHeader BEGIN ============*/

'${test!}'
        var hreflocation=window.location.href;
          if(hreflocation.indexOf('http://www.571xz.com')==0||hreflocation.indexOf('http://571xz.com')==0){//仅首页
              var province = '' ;
              var city = '' ;
              jQuery.getScript("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js",function(){
                  province = remote_ip_info["province"];
                  if(province=='福建'){
                      window.location.href="http://ss.571xz.com";
                  }else if(province == '江苏'){
                      window.location.href="http://cs.571xz.com";
                  }else if(province == '广东'){
                      window.location.href="http://gz.571xz.com";
                  }else if(province == '吉林'){
                      window.location.href="http://wa.571xz.com";
                  }
              }) ;
          }

/*============ xieIndex/page#layoutHeader END ============*/


</script>    <script src="http://style.571xz.com/xieIndex/js/temp/ekoo.min.js"></script>
    <script src="http://style.571xz.com/xieIndex/js/shoe.js?t=1499247705759"></script>
  </head>
<body >
<#include "/common/host_config.ftl">
<script>/*============ xieIndex/host_config#base BEGIN ============*/

'${test!}';
var main_host = 'http://www.kxie.com/';

/*============ xieIndex/host_config#base END ============*/


</script><div class="topbar">
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
<div class="fixtopbar">
    <div class="innner">
        <a class="logo" href="http://www.kxie.com"><img src="http://style.571xz.com/xz/css/img/mtLogo.png" title="四季星座网-首页" height="30" width="170"></a>
         <div class="searchbar">
            <div class="tabbox">
                <ul> 
                    <li>商品</li>
                    <li>档口</li>
                </ul>
               <i class="img-jiantou"></i>
            </div>
            <form action="http://so.571xz.com/hzsearch.htm" target="_blank" id="searchgo3">
                <#if page?? && page.type == 'W'>
                <input type="hidden" name="cid" value="16">
                <#elseif page?? && page.type == 'M'>
                <input type="hidden" name="cid" value="30">
                </#if>
                <input style="text-indent:1em;" class="text-search" name="keyword" type="text">
                <button class="btn-search">搜索</button>
            </form>
        </div>
    </div>
</div>
<#if topPic??>
<#list topPic as tp>
<div class="topPic layout">
    <a href="<#if tp.href == ''>javascript:;<#else>${tp.href!}</#if>" target="_blank">
        <img src="${tp.imgsrc!}">
    </a>
</div>
</#list>
</#if>
<div class="header layout">
    <div class="logoLeft">
        <a href="http://www.kxie.com">
            <img src="http://style.571xz.com/xz/css/img/logo.png" alt width=150 height=48 />
        </a>
        <em></em>
    </div>
    <div class="search">
        <div class="tabList clearfix">
            <ul>
                
                
                
                
                
                <li type="goods" class="select">商品</li>
                <li type="store" >档口</li>
                
            </ul>
            <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
            <a href="${main_host!}picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
            </#if>
        </div>
        <div class="searchBox">
            
            <form id="formSearch" action="http://www.kxie.com/${webSite!}search.htm" target="_blank">
                
                <input type="text" class="searchCon" name="keyword" placeholder="输入商品名称" value="<#if query.keyword??>${query.keyword!}</#if>">
                <button class="searchBtn">搜索</button>
            </form>
        </div>
    </div>
    <script>/*============ xz/kxPage#search BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/kxPage#search END ============*/


</script>
</div>
<div class="headerV1 layout">
    
</div>
<div class="firstScreen layout">
    <div class="leftbox developBg1">
        <div class="catemenu" id="catemenu">
            
            <h3 class="head">
                <em>快速导航</em>
                
            </h3>
            
            <div class="listbox">
                
                <div class="list" data-menuid="manMarket">
                    <h3 class="mtitle"><em>市场分类</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=1">华联A栋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=2">华联B栋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=3">义兴堂</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=4">旧车站</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=5">滨江幸福广场</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=6">晋江电子商务中心</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/market.htm?mid=7">周边市场</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="manShoes">
                    <h3 class="mtitle"><em>男鞋分类</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011745">凉鞋/拖鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=青春潮流">青春潮流</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=日常休闲">日常休闲</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;cid=50011744">帆布/板鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;=商务皮鞋">商务皮鞋</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="womenShoes">
                    <h3 class="mtitle"><em>女鞋分类</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012032">凉鞋/拖鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=单鞋">单鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;cid=50012042">帆布鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=高帮鞋">高帮鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=靴子">靴子</a></li>
                        </ul>
                    </div>
                </div>
                <div class="list" data-menuid="elementCate">
                    <h3 class="mtitle"><em>流行元素</em><i class="iconfont"></i></h3>
                    <div class="mlist">
                        <ul class="clearfix">
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=男鞋">男鞋</a></li>
                            <li><a target="_blank" href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=女鞋">女鞋</a></li>
                        </ul>
                    </div>
                </div>
                
                
            </div>
            
            <div class="detailbox">
                    <div class="innerbox w320c2 manMarket" data-width="w320c2">
                        <div class="itemConTop">
                            <h4 class="itemTitle">市场导航</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/market.htm?mid=1" target="_blank">华联A栋</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=2" target="_blank">华联B栋</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=3" target="_blank">义兴堂</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=4" target="_blank">旧车站</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=5" target="_blank">滨江幸福广场</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=6" target="_blank">晋江电子商务中心</a></li>
                                <li><a href="http://www.kxie.com/market.htm?mid=7" target="_blank">周边市场</a></li>
                            </ul>
                        </div>
                    
                    </div>
                    <div class="innerbox w320c0 manShoes" data-width="w320c0">
                    
                        
                        <div class="itemsbox">
                            <h4>凉鞋/拖鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=凉拖鞋" target="_blank">凉拖鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=网面鞋" target="_blank">网面鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=洞洞鞋" target="_blank">洞洞鞋</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>青春潮流</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=潮流低帮" target="_blank">潮流低帮</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=韩版" target="_blank">韩版</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=英伦" target="_blank">英伦</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=复古" target="_blank">复古</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=铆钉" target="_blank"> 铆钉</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=编制" target="_blank">编制</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=豹纹" target="_blank">豹纹</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=大头" target="_blank">大头</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>日常休闲</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=皮鞋" target="_blank">皮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012906" target="_blank">低帮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=反绒皮" target="_blank">反绒皮</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=大头鞋" target="_blank">大头鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=帆船鞋" target="_blank">帆船鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=懒人鞋" target="_blank">懒人鞋</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>帆布/板鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012907" target="_blank">高帮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;cid=50012906" target="_blank">低帮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=皮革面" target="_blank">皮革面</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=魔术贴" target="_blank">魔术贴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=条纹" target="_blank">条纹</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=情侣款" target="_blank">情侣款</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=厚底" target="_blank">厚底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=人本" target="_blank">人本</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=回力" target="_blank">回力</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>商务皮鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=休闲皮鞋" target="_blank">休闲皮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=正装皮鞋" target="_blank">正装皮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=布洛克" target="_blank">布洛克</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=内增高" target="_blank">内增高</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=反绒皮 " target="_blank">反绒皮 </a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=搭扣" target="_blank">搭扣</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=英伦风" target="_blank">英伦风</a></li>
                            </ul>
                        </div>
                        
                    </div>
                    <div class="innerbox w320c0 womenShoes" data-width="w320c0">
                    
                        
                        <div class="itemsbox">
                            <h4>凉鞋/拖鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=鱼嘴" target="_blank">鱼嘴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=尖头" target="_blank">尖头</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=粗跟" target="_blank">粗跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=坡跟" target="_blank">坡跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=细跟" target="_blank">细跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=厚底" target="_blank">厚底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=夹趾" target="_blank">夹趾</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=平跟" target="_blank">平跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=包头" target="_blank">包头</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=系带" target="_blank">系带</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>单鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=高跟" target="_blank">高跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=平底" target="_blank">平底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=厚底" target="_blank">厚底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=中跟" target="_blank">中跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=粗跟" target="_blank">粗跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=坡跟" target="_blank">坡跟</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=深口" target="_blank">深口</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=尖头" target="_blank">尖头</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=圆头" target="_blank">圆头</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>帆布鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=高帮" target="_blank">高帮</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=低帮" target="_blank">低帮</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=魔术贴" target="_blank">魔术贴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=懒人鞋" target="_blank">懒人鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=厚底" target="_blank">厚底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=系带" target="_blank">系带</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=情侣款" target="_blank">情侣款</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>高帮鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=内增高" target="_blank">内增高</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=厚底" target="_blank">厚底</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=系带" target="_blank">系带</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=魔术贴" target="_blank">魔术贴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=拉链" target="_blank">拉链</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=松紧带" target="_blank">松紧带</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=套脚" target="_blank">套脚</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>靴子</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=裸靴" target="_blank">裸靴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=短靴" target="_blank">短靴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=马丁靴" target="_blank">马丁靴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=中筒" target="_blank">中筒</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=高筒" target="_blank">高筒</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=切尔西靴" target="_blank">切尔西靴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=雪地靴" target="_blank">雪地靴</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=过膝" target="_blank">过膝</a></li>
                            </ul>
                        </div>
                        
                    </div>
                    <div class="innerbox w320c0 elementCate" data-width="w320c0">
                    
                        
                        <div class="itemsbox">
                            <h4>男鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=白色" target="_blank">白色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=纯色" target="_blank">纯色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=手绘" target="_blank">手绘</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=印花" target="_blank">印花</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=撞色" target="_blank">撞色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=格子" target="_blank">格子</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=荧光色" target="_blank">荧光色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=热点" target="_blank">热点</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=韩版" target="_blank">韩版</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=系带" target="_blank">系带</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=校园风" target="_blank">校园风</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=运动风" target="_blank">运动风</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50011740&amp;keyword=铆钉" target="_blank">铆钉</a></li>
                            </ul>
                        </div>
                        <div class="itemsbox">
                            <h4>女鞋</h4>
                            <ul class="itemlist clearfix">
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=铆钉" target="_blank">铆钉</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=欧美" target="_blank">欧美</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=韩风" target="_blank">韩风</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=金色" target="_blank">金色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=银色" target="_blank">银色</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=特色鞋" target="_blank">特色鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=妈妈鞋" target="_blank">妈妈鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=孕妇鞋" target="_blank">孕妇鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=潮鞋" target="_blank">潮鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=大码鞋" target="_blank">大码鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=小码鞋" target="_blank">小码鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=婚鞋" target="_blank">婚鞋</a></li>
                                <li><a href="http://www.kxie.com/${webSite!}goods.htm?pid=50006843&amp;keyword=负跟鞋" target="_blank">负跟鞋</a></li>
                            </ul>
                        </div>
                        
                    </div>
                
            </div>
        
            
            
        </div>
        
    </div>
    <div class="centerbox">
        <div class="topNav">
            <ul class="clearfix">
                <li>
                    <a href="http://www.kxie.com/market.htm" target="_blank">
逛市场<i class="hot"></i>                    </a>
                </li>
                <li>
                    <a href="http://www.kxie.com/kxgoods.htm" target="_blank">
商品库                    </a>
                </li>
            </ul>
        </div>
        
        <div class="topBanner">
            
            <div class="slides" id="slides"> 
                <div class="ulDiv">
                    <ul>
                    <#list topBanner as item>
                        <li>
                            <a href="${item.href!}" target="_blank"><img width="742" height="342px" alt="" src="${item.imgsrc!}"></a>
                        </li>
                    </#list>
                    </ul>
                </div>
             
                <div class="small"><div class="small-lab">
                    
                    
                </div></div>
                <div class="j_next c_next iconfont">&#xe603;</div>
                <div class="j_prev c_prev iconfont">&#xe602;</div>
            </div>
            
        </div>
        <div class="topStoread">
            <ul class="clearfix">
                <#list topStoread as item>
                <li><a href="${item.href!}" target="_blank"><img src="${item.imgsrc!}"></a></li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="rightbox">
        <div class="topChooseType">
            
        </div>
        <div class="topRtbox">
            
            <div class="noticebox">
                <div class="tabBtn">
                    <b class="btn1 selected ">公告</b>
                </div>
                <div class="tabCon">
                    <ul>
                        <#list notices as item>
                        <li><a href="${item.href!}" target="_blank">${item.text!}</a></li>
                        </#list>
                    </ul>
                </div>
            </div>
            
            <div class="userbox">
                
                <div class="p1 clearfix">
                    <div class="userIcon">
                        <img src="http://style.571xz.com/xieIndex/css/img/touxiang.png">
                    </div>
                    <div class="wellcom">
                        <p class="s1">Hi，欢迎来到</p>
                        <p>www.kxie.com</p>
                    </div>
                </div>
                
                
                <div class="p2 clearfix">
                    <a class="first" onclick="loginBack()">登录</a>
                    <a href="${main_host!}regedit.htm">注册</a>
                    <a href="${main_host!}ruzhu.htm">商家入驻</a>
                </div>
            </div>
            
            <div class="userCount">
                <div class="p1">
                    <ul class="clearfix">
                        <#list userCount as num>
                        <li>${num!}</li>
                        </#list>
                    </ul>
                </div>
                <div class="p2">
                    服装采购商的选择
                </div>
            </div>
            
        </div>
        <script>/*============ xieIndex/page#topRtbox BEGIN ============*/

${test!}
var isgys = false;
var session_shopId = '${session_user_redis__.logshop.shopId!}';
if(session_shopId != ""){
    isgys = true;
}else{
    isgys = false;
}

/*============ xieIndex/page#topRtbox END ============*/


</script>
    </div>
</div>
<div class="hotsaleGoodslist advs layout">
    <a class="sideNavbarDot" name="hotsaleGoods" data-text="热销"></a>
    <h3>热卖商品 <span>爆款尖货  品质护航</span></h3>
    <div class="goodslist clearfix">
        <ul class="clearfix tle tleL">
            
            <#list hotsaleGoodslist as item>
            <li class="item1">
                <a class="imgBox" href="http://www.kxie.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://www.kxie.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="elementGoodslist advs layout">
    <a class="sideNavbarDot" name="elementGoods" data-text="元素"></a>
    <h3>流行元素 <span>潮流阵地  时尚前沿</span></h3>
    <div class="goodslist clearfix">
        <div class="elementGoods clearfix">
            <#list elementCateList as item>
            <div class="element"><a href="${item.href!}" target="_blank">${item.text!}</a></div>
            </#list>
        </div>
        
        <ul class="clearfix tle tleL">
            <#list elementGoodslist as item>
            <li class="item1">
                <a class="imgBox" href="http://www.kxie.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://www.kxie.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="recommendShoplist layout advs">
    <a class="sideNavbarDot" name="recommendShop" data-text="推荐"></a>
    <h3>推荐档口 <span>实力档口  源头好货</span></h3>
    <div class="goodslist clearfix">
        <ul class="clearfix tle tleL">
            
            <#list recommendShoplist as item>
            <li class="item2">
                <a class="imgBox" href="http://www.kxie.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                <div class="gsOtInfo">
                    <div class="inSell">
                        <a href="http://www.kxie.com/shop.htm?id=${item.storeId!}" target="_blank">
                            <span class="s1">${item.marketText!}</span>
                            <span class="s2">${item.storeNum!}</span>
                        </a>
                        
                    </div>
                
                <div class="userText" title="${item.userText!}">${item.userText!}</div>
                
                </div>
            </li>
            
            
            </#list>
            
        </ul>
    </div>
</div>
<div class="loveGoodslist advs layout">
    <a class="sideNavbarDot" name="loveGoods" data-text="喜欢"></a>
    <h3><i class="iconLove"></i>猜您喜欢</h3>
    <p class="title">实时推荐 最适合你的商品</p>
    <div class="clearfix goodslist">
        
        <#list loveGoodslist as pitem>
            <ul class="clearfix tle <#if pitem_index % 2 ==0>tleL<#else>tleR</#if>">
            <#list pitem.items as item>
            <li class="item1">
                <a class="imgBox" href="http://www.kxie.com/item.htm?id=${item.id!}" target="_blank">
                    <img src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${item.imgsrc!}_300x300.jpg" alt width=230 height=230 />
                </a>
                
                <div class="gsOtInfo">
                    <span class="price">¥${item.piprice!}</span>
                    <div class="storeNum" title="${item.storeText!}"><a href="http://www.kxie.com/shop.htm?id=${item.storeId!}" target="_blank">${item.storeText!}</a></div>
                </div>
                <#if item.styleText?? && item.styleText != "" >
                    <div class="tally">${item.styleText!}</div>
                </#if>
                <#if item.elementText?? && item.elementText != "">
                <div class="tally">${item.elementText!}</div>
                </#if>
            </li>
            
            </#list>
            <li class="loveCate">${pitem.typeText!}</li>
            </ul>
        </#list>
    </div>
</div>
<div class="serverIntro">
    <div class="layout serverCon">
        
        <ul>
            <li>
                <i class="iconServer manDp"></i>
                <p>15,000多家档口</p>
                <span>集合最优质货源</span>
            </li>
            <li>
                <i class="iconServer manUp"></i>
                <p>1键轻松上传</p>
                <span>上传各大网购平台</span>
            </li>
            <li>
                <i class="iconServer manDf"></i>
                <p>1件商品代发</p>
                <span>0库存，0成本</span>
            </li>
            <li>
                <i class="iconServer manTh"></i>
                <p>无理由退换</p>
                <span>可支持无条件退换货</span>
            </li>
        </ul>
    </div>
</div>
<div class="sideNavbar" id="sideNavbar">
    
</div>
<script>/*============ xieIndex/shoe#main BEGIN ============*/

'${hacker!}';
$(".imgBox img").lazyload({
    effect: "fadeIn", // 载入使用何种效果
    threshold: 400 // 提前开始加载
});

/*============ xieIndex/shoe#main END ============*/


</script>
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