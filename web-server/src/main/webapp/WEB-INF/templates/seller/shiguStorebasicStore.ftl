<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>四季星座网-供应商中心-店铺基本设置</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/gys5/css/shiguStorebasicStore.css?t=1498810181556" rel="stylesheet">
    
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
        <li><a class="selected"  href="${main_host!}seller/shiguStorebasicStore.htm">店铺资料</a></li> 
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
        <li><a href="${main_host!}seller/indexGgChange.htm"  >首页广告管理</a></li> 
        <li><a href="${main_host!}seller/actRegister.htm"  >活动报名</a></li> 
    </ul> 
</div>
    <div class="content shadow-box">
        <form action="shiguStorebasicStore.htm" id="register_form" method="post">
        <#if submit_info??><input type="hidden" id="submit_info"  value="${submit_info!}"></#if>
        <div class="typeset">
            <div class="item clearfix">
                <h4>经营种类：</h4>
                <ul>
                      <#list typeset.business_type as value>
                      <li><label><input type="radio" <#if typeset.mainBus == value>checked</#if> name="mainBus" value="${value!}">${value!}</label></li>
                      </#list>
                </ul>
            </div>
            <div class="item clearfix">
                <h4>服务级别：</h4>
                <ul>
                      <#list typeset.server_level as type>
                      <li><label><input type="checkbox" <#list typeset.servers as server><#if server == type.value>checked</#if></#list> name="servers" value="${type.value!}"><span style="background:${type.color!}"></span>${type.text!}</label></li>
                      </#list>
                </ul>
            </div>
        </div>
        <div class="baseset">
            <ul>
                <#list shopinfo as item>
                  <li> 
                      <label><#if item.name == "telephone" || item.name == "imWw" || item.name == "imQq"><em class="c_ff4400">※</em></#if>${item.label!}：</label>
                      <input type="text" value="${item.value!}" name="${item.name!}" class="textinput" <#if item.readonly == true>readonly="readonly"</#if>>
                  </li>
                  <li class="error"><div class="errorTip"><i class="iconWarn"></i><em class="c_ff4400"></em></div></li>
                  </#list>
            </ul>
            <div class="pd-box">
                <label><input type="checkbox" id="allow_ck" checked>我同意<a href="http://www.571xz.com/static/mianze/contract.html" target="_blank">《服务条款》</a>和<a href="http://www.571xz.com/static/mianze/contract.html" target="_blank">《政策》</a></label>
<#assign text>{'text':'保存',"id":'dosubmit'}</#assign>
<#assign $it=text?eval />
                        
                    <button class="button-base button-1" id="dosubmit">保存</button>
                
                
            </div>
        </div>
        </form>
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
<script src="http://style.571xz.com/gys5/js/shiguStorebasicStore.js?t=1498810181556"></script>
<#include "/common/cnzz.ftl">
</body>
</html>