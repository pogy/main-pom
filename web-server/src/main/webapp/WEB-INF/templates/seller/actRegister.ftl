<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>活动报名 - 四季星座网</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/gys5/css/actRegister.css?t=1498966411743" rel="stylesheet">
    
  </head>
<body>
<input id="mainhost" value="http://192.168.1.66/gys5/" type="hidden">
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
        <li><a href="${main_host!}seller/design.htm"  target="_blank">店铺装修<i class="ne"></i></a></li> 
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
        <li><a href="${main_host!}seller/indexgglist.htm" class='indexgg' >首页广告申请</a></li> 
        <li><a href="${main_host!}seller/promotion.htm"  >广告展示管理</a></li> 
        <li><a class="selected"  href="${main_host!}seller/actRegister.htm">立即报名活动</a></li> 
    </ul> 
</div>
    <div class="content shadow-box">
        <div class="goods-tabbox clearfix">
            <ul>
                <li class="tabbutton selected"><a href="JavaScript:;">所有活动</a></li>
                <li class="tabbutton"><a href="JavaScript:;">已参加的活动</a></li>
                <li class="tabbutton"><a href="JavaScript:;">未参加的活动</a></li>
            </ul>
        </div>
        <div class="actContent">
            <div class="actItems allActs">
                <#list activities as actItem>
                <div class="actItem clearfix">
                    <div class="actImg">
                        <img src=${actItem.actImg!}>
                    </div>
                    <div class="actDetails">
                        <p class="lineHei32">
                            <span class="actTitle">${actItem.actTitle!}</span>
                            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
                            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
                            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
                        </p>
                        <p class="lineHei32">
                            报名资质：<#if actItem.supportReturn??><span class="applyQualify">支持退货</span></#if>
                            <#if actItem.supportReturn??><span class="applyQualify">支持换货</span></#if>
                        </p>
                    </div>
                    <div class="applyStatus">
                        <#if actItem.hdStatus == true>
                            <#if actItem.sqStatus == '0'>
                            
                            <a href='http://192.168.1.66/gys5/actDetails.html?actid=${actItem.actid!}' class="gyButton goRegister">立即报名</a>
                            <#elseif actItem.sqStatus == '1'>
<#assign text>{"text":'已报名', "cls":"registered"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registered" jbtn="" id="">已报名</button>
                            
                            <span class="statusTip">审核中…</span>
                            <#elseif actItem.sqStatus == '2'>
<#assign text>{"text":'报名已通过', "cls":"registerSuccess"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registerSuccess" jbtn="" id="">报名已通过</button>
                            
                            </#if>
                        <#else>
<#assign text>{"text":'活动已结束', "cls":"actEnd"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton actEnd" jbtn="" id="">活动已结束</button>
                            
                        </#if>
                    </div>
                </div>
                </#list>
            </div>
            <div class="actItems partedActs">
                <#list activities as actItem>
                <#if actItem.sqStatus == "2">
                <div class="actItem clearfix">
                    <div class="actImg">
                        <img src=${actItem.actImg!}>
                    </div>
                    <div class="actDetails">
                        <p class="lineHei32">
                            <span class="actTitle">${actItem.actTitle!}</span>
                            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
                            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
                            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
                        </p>
                        <p class="lineHei32">
                            报名资质：<#if actItem.supportReturn??><span class="applyQualify">支持退货</span></#if>
                            <#if actItem.supportReturn??><span class="applyQualify">支持换货</span></#if>
                        </p>
                    </div>
                    <div class="applyStatus">
                        <#if actItem.hdStatus == true>
                            <#if actItem.sqStatus == '0'>
                            
                            <a href='http://192.168.1.66/gys5/actDetails.html?actid=${actItem.actid!}' class="gyButton goRegister">立即报名</a>
                            <#elseif actItem.sqStatus == '1'>
<#assign text>{"text":'已报名', "cls":"registered"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registered" jbtn="" id="">已报名</button>
                            
                            <span class="statusTip">审核中…</span>
                            <#elseif actItem.sqStatus == '2'>
<#assign text>{"text":'报名已通过', "cls":"registerSuccess"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registerSuccess" jbtn="" id="">报名已通过</button>
                            
                            </#if>
                        <#else>
<#assign text>{"text":'活动已结束', "cls":"actEnd"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton actEnd" jbtn="" id="">活动已结束</button>
                            
                        </#if>
                    </div>
                </div>
                </#if>
                </#list>
            </div>
            <div class="actItems noPartedActs">
                <#list activities as actItem>
                <#if actItem.sqStatus == "0">
                <div class="actItem clearfix">
                    <div class="actImg">
                        <img src=${actItem.actImg!}>
                    </div>
                    <div class="actDetails">
                        <p class="lineHei32">
                            <span class="actTitle">${actItem.actTitle!}</span>
                            <span class="applyTime">报名时间：${actItem.applyTime!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="applyRange">报名产品范围：${actItem.applyRange!}</span>
                        </p>
                        <p class="lineHei32">
                            <span class="actTime">活动时间：${actItem.actStartTime!}-${actItem.actEndTime!}</span>
                            <span class="actNums">名额：${actItem.actNums!} 款商品</span>
                            <span class="chargeStyle">收费类型：<#if actItem.chargeStyle == 'free'>免费<#else>&yen;${actItem.chargeStyle!}</#if></span>
                        </p>
                        <p class="lineHei32">
                            报名资质：<#if actItem.supportReturn??><span class="applyQualify">支持退货</span></#if>
                            <#if actItem.supportReturn??><span class="applyQualify">支持换货</span></#if>
                        </p>
                    </div>
                    <div class="applyStatus">
                        <#if actItem.hdStatus == true>
                            <#if actItem.sqStatus == '0'>
                            
                            <a href='http://192.168.1.66/gys5/actDetails.html?actid=${actItem.actid!}' class="gyButton goRegister">立即报名</a>
                            <#elseif actItem.sqStatus == '1'>
<#assign text>{"text":'已报名', "cls":"registered"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registered" jbtn="" id="">已报名</button>
                            
                            <span class="statusTip">审核中…</span>
                            <#elseif actItem.sqStatus == '2'>
<#assign text>{"text":'报名已通过', "cls":"registerSuccess"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton registerSuccess" jbtn="" id="">报名已通过</button>
                            
                            </#if>
                        <#else>
<#assign text>{"text":'活动已结束', "cls":"actEnd"}</#assign>
<#assign $it=text?eval />
                                                <button class="gyButton actEnd" jbtn="" id="">活动已结束</button>
                            
                        </#if>
                    </div>
                </div>
                </#if>
                </#list>
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
<script src="http://style.571xz.com/gys5/js/actRegister.js?t=1498966411743"></script>
<#include "/common/cnzz.ftl">
</body>
</html>