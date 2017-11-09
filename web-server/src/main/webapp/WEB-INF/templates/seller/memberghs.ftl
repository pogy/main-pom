<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>四季星座网-供应商中心</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    <link href="http://style.571xz.com/gys5/css/memberghs.css?t=1505784055234" rel="stylesheet">
    
  </head>
<body>
<input id="mainhost" value="http://192.168.1.66:555/gys5/" type="hidden">
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
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
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                    
                </li>
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
<script>/*============ xz/page#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/page#topbar END ============*/


</script>
<div class="header">
    <div class="layout">
        <a class="logo iconfont" href="http://www.571xz.com"></a>
        
        <i class="splitline"></i>
        <a class="shop" href="http://${session_user_redis__.logshop.webSite!}.571xz.com/${session_user_redis__.logshop.shopId!}">${session_user_redis__.logshop.market!}${session_user_redis__.logshop.shopNum!}</a>
        <#if (session_user_redis__.otherShops?size) gt 1>
        <div class="switch">
            <em>切换<i class="img-jiantou"></i></em>
            <div class="dropbox">
                <div class="msgbox">
                    
                    <#list session_user_redis__.otherShops as store>
                    <a href="javascript:;" jbtn="toConnact">${store.market!}${store.shopNum!}</a>
                    </#list>
                    
<#assign text>{                        "jid":'toConnact',                        "options":[                            {"name":'tipConText', "value":'抱歉，账号异常！'},                             {"name":'href_', "value":'http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=4000761116'},                             {"name":'tipIcon', "value":'errorTipIcon'},                             {"name":'btText', "value":'联系客服'}                        ]                    }</#assign>
<#assign $it=text?eval />
                                        <div jid="toConnact">
                        <input type="hidden" name="tipConText" value="抱歉，账号异常！" />
                        <input type="hidden" name="href_" value="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;amp;uin=4000761116" />
                        <input type="hidden" name="tipIcon" value="errorTipIcon" />
                        <input type="hidden" name="btText" value="联系客服" />
                    </div>
                </div>
            </div>
        </div>
        </#if>
    </div>
</div>
<div class="wrapper layout">
  
    
<div class="sidebar shadow-box">
    <h2>商品管理</h2>
    <ul>
        <li><a href="${main_host!}seller/createGoods21init.htm"  >发布商品</a></li> 
        <li><a href="${main_host!}seller/storeGoodsList21init.htm"  >出售中的商品</a></li> 
        <li><a href="${main_host!}seller/storeGoodsListinit.htm?pinteger=2"  >仓库中的商品</a></li> 
        <li><a href="${main_host!}seller/storeGoodsNoListinit.htm"  >批量修改货号</a></li> 
        <li><a href="${main_host!}seller/xiufuGoods21init.htm"  >商品类目管理</a></li> 
    </ul> 
    <h2>店铺管理</h2>
    <ul>
        <li><a href="http://${session_user_redis__.logshop.webSite!}.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"  target="_blank">查看我的店铺</a></li> 
        <li><a href="${main_host!}seller/design.htm"  target="_blank">店铺装修</a></li> 
        <li><a href="${main_host!}seller/pictureSpace.htm"  >图片空间<i class="new"></i></a></li> 
        <li><a href="${main_host!}seller/shiguStoreerjiyuming.htm"  >二级域名</a></li> 
        <li><a href="${main_host!}seller/shiguStorebasicStore.htm"  >店铺资料</a></li> 
        <li><a href="${main_host!}seller/ghTongbu.htm"  >授权管理</a></li> 
    </ul> 
    <h2>财务信息</h2>
    <ul>
        <li><a href="${main_host!}seller/iwantToRechargein5.htm"  >充值</a></li> 
        <li><a href="${main_host!}seller/withdraw5Apply.htm"  >提现</a></li> 
    </ul> 
    <h2>账号管理</h2>
    <ul>
        <li><a href="${main_host!}seller/safeindex.htm"  >安全设置</a></li> 
        <li><a href="${main_host!}seller/sysSetsindex.htm"  >个人信息</a></li> 
    </ul> 
    <h2>营销管理</h2>
    <ul>
        <li><a href="${main_host!}seller/dtggapply.htm?id=1001" class='dtgg' >免费LED广告</a></li> 
        <li><a href="https://shop121675953.taobao.com" target="_blank" style="color:#f40">广告位竞拍</a></li> 
        <li><a href="${main_host!}seller/indexgglist.htm" class='indexgg' >广告申请</a></li> 
        <li><a href="${main_host!}seller/promotion.htm"  >广告展示管理</a></li> 
        <li><a href="${main_host!}seller/actRegister.htm"  >立即报名活动</a></li> 
    </ul> 
</div>
    <div class="bindRight fr">
        
        <div class="c_top clearfix">
            <div class="fl c_shop_logo">
                <div class="c_default_logo"><span class="iconfont">&#xe604;</span></div>
                <div class="c_own_logo">
                    <#if session_user_redis__.headUrl??>
                    <img src="${session_user_redis__.headUrl!}" width="120" height="120">
                    <#else>
                    <img src="http://www.571xz.com/images/default160.jpg" width="120" height="120">
                    </#if>
                </div>
            </div>
            <div class="fl clearfix c_shop_info">
                <div class="clearfix c_name">
                    <strong class="fl">${session_user_redis__.userNick!}</strong>
                    <p class="fr">
                        <#if session_user_redis__.logshop.tbNick??>
                        <span class="iconfont c_ff7112" title="店铺授权" alt="店铺授权" >&#xe619;</span>
                        <#else>
                        <span class="iconfont" title="店铺未授权" alt="店铺未授权">&#xe619;</span>
                        </#if>
                        <span class="iconfont c_22ca75" title="实名认证" alt="实名认证">&#xe618;</span>
                    </p>
                    <p class="fr">店铺名称:<i>${session_user_redis__.logshop.shopName!}</i></p>
                </div>
                <div class="c_cb c_address clearfix">
                    <p>城市：
                        <i>
                            <#if session_user_redis__.logshop.webSite == 'jx'>嘉兴<#elseif session_user_redis__.logshop.webSite == 'ss'>石狮<#elseif session_user_redis__.logshop.webSite == 'gz'>广州<#elseif session_user_redis__.logshop.webSite == 'cs'>常熟<#elseif session_user_redis__.logshop.webSite == 'bj'>北京<#else>杭州</#if>
                        </i>
                    </p>
                    <p class="c_dkh">档口号：<i style="float:right; width: 80px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" title="${session_user_redis__.logshop.shopNum!}">${session_user_redis__.logshop.shopNum!}</i></p>
                    <p>市场：<i style="float:right; width: 70px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" title="${session_user_redis__.logshop.market!}">${session_user_redis__.logshop.market!}</i></p>
                </div>
                
            </div>
            <div class="fr c_index">
              <p>关注指数：<i>5120</i> 排名 44</p>
              <p>评价积分：<i>5.0</i> 高于 4.83179</p>
              <p>商家权重：<i>正常</i> 提升权重</p>
            </div>
        </div>
         
        <div class="c_goods_info clearfix">
        
            <div class="imglist_left fl">
              <p class="c_title">热门宝贝<!--  <a href="javascript:;">查看更多> --></span></p>
              <ul class="hotGoods clearfix">
              <!--<li><a href="http://www.571xz.com/item.htm?id=8431271" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/http://img.alicdn.com/imgextra/i3/25771684245/TB2c4iAmXXXXXbzXXXXXXXXXXXX_!!25771684245.jpg" width="84" height="84"><p>￥29.00</p></a></li>-->
              </ul>
              <p class="c_title">建议优化宝贝<!-- @<span>近30天未被上传 <a href="javascript:;">马上去优化></span> @--></p>
              <ul class="nothotGoods clearfix">
              <!--
              <li><a href="http://www.571xz.com/item.htm?id=8167777" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i3/TB1sfQmHFXXXXcfXpXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥78.00</p></a></li>
              <li><a href="http://www.571xz.com/item.htm?id=8185266" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i3/TB1IidYJFXXXXXTXpXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥115.00</p></a></li>
              <li><a href="http://www.571xz.com/item.htm?id=8185267" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i1/TB1XeTpJXXXXXciXFXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥188.00</p></a></li>
              <li><a href="http://www.571xz.com/item.htm?id=8185265" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i3/TB1VdRuJpXXXXbFXFXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥60.00</p></a></li>
              <li><a href="http://www.571xz.com/item.htm?id=8167764" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i4/TB1JL4JJVXXXXXOXpXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥168.00</p></a></li>
              <li><a href="http://www.571xz.com/item.htm?id=8167758" target="_blank"><img src="https://img.alicdn.com/bao/uploaded/i1/TB10jTTJVXXXXcFXpXXXXXXXXXX_!!0-item_pic.jpg" width="84" height="84"><p>￥110.00</p></a></li>
              -->
              </ul>
            </div>
            <div class="imglist_right fr">
              
              <p><img src="http://www.571xz.com/jquery2015/imgTempindex/shaoma.jpg"></p>
              <!-- <p>一年来，他们共卖出了</p>
              <p><span><font style="color:#ff4901;font-weight:bold;">￥1125.00元</font></span></p>
              <p><a href="#" class="button button-rounded button-tiny">那么，我赚了多少</a></p>
              <p><a href="#" class="button button-rounded button-tiny">我要去显摆一下</a></p> -->
            </div>
            
        </div>
        
        <div class="c_agent">
        <h2>代理数据分析</h2>
        <div id="j_echart_2" class="c_echart_2"><p class='c_no_data'>暂无数据~</p></div>
    
        </div>
    
    </div>
    
    
    <script>/*============ xz/huodong#imgtips1 BEGIN ============*/

var imgsrc = '${imgsrc!}';
var tHref = '${tHref!}';

/*============ xz/huodong#imgtips1 END ============*/


</script>
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
        <script src="http://style.571xz.com/gys5/temp/echarts.js"></script>
        <script src="http://style.571xz.com/gys5/temp/html5sup.js"></script>
<script src="http://style.571xz.com/gys5/js/memberghs.js?t=1505784055234"></script>
<#include "/common/cnzz.ftl">
</body>
</html>