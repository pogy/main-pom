<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>四季星座网-分销商中心-第三方绑定</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/fxs2/css/fenxiaoZhanghao.css?t=1498441429511" rel="stylesheet">
    
  </head>
<body>
<input id="mainhost" value="http://192.168.1.66/fxs2/" type="hidden">
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
        <a class="logo iconfont" href="http://www.571xz.com">&#xe653;</a>
        
        <ul>
            <li ><a href="${main_host!}member/index.htm">首页</a></li>
            <li ><a href="${main_host!}member/sysSetsindex.htm">账号管理</a></li>
            
        </ul>
    </div>
</div>
<div class="wrapper layout">
    
    
    <div class="sidebar">
        <h2>商品管理</h2>
        <ul>
                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm" >已上传的商品</a></li>
                <li><a href="${main_host!}member/goodsCollectinit.htm" >我的数据包</a></li>
                <li><a href="${main_host!}member/storeCollectinit.htm" >我的收藏</a></li>
        </ul> 
        <h2>代发管理</h2>
        <ul>
                <li><a href="http://daifa.571xz.com/daili/offerIndex.htm" >我要代发</a></li>
        </ul> 
        <h2>财务信息</h2>
        <ul>
                <li><a href="${main_host!}member/iwantToRechargein5.htm" >充值</a></li>
                <li><a href="${main_host!}member/withdraw5Apply.htm" >提现</a></li>
        </ul> 
        <h2>账号管理</h2>
        <ul>
                <li><a href="${main_host!}member/safeindex.htm" >安全设置</a></li>
                <li><a href="${main_host!}member/sysSetsindex.htm" >个人设置</a></li>
            <li><a class="selected" href="${main_host!}member/fenxiaoZhanghao.htm">应用绑定</a></li> 
        </ul> 
        <h2>供应商申请</h2>
        <ul>
                <li><a href="${main_host!}member/storeIn.htm" >店铺申请</a></li>
        </ul> 
    </div>
    <div class="content">
        <div class="accountBound">
            <div class="tabBox">
                <div class="tabbutton selected"><a>账号绑定管理</a></div>
            </div>
            
            <div class="tip">绑定手机号或者第三方账号即可通过该账号登录四季星座网</div>
            
            <ul class="show-box clearfix">
                
                <#if outer_taobao??>
                <li class="bd">
                    <div class="iconApplication">
                        <i class="icon${outer_taobao.from!} iconApp"></i>
                        <i class="iconBd"></i>
                        <p>${outer_taobao.name!}</p>
                    </div>
                    <div class="status">
                        <b class="unBind" jbtn="${outer_taobao.from!}" data-id="${outer_taobao.id!}">解绑</b>
                    </div>
                </li>
                <#else>
                <li class="noBd">
                    <div class="iconApplication">
                        <i class="icontaobao iconApp"></i>
                        <i class="iconBd"></i>
                        <p>淘宝</p>
                    </div>
                    <div class="status">
                        <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
                    </div>
                </li>
                </#if>
                <#if outer_ali??>
                <li class="bd">
                    <div class="iconApplication">
                        <i class="icon${outer_ali.from!} iconApp"></i>
                        <i class="iconBd"></i>
                        <p>${outer_ali.name!}</p>
                    </div>
                    <div class="status">
                        <b class="unBind" jbtn="${outer_ali.from!}" data-id="${outer_ali.id!}">解绑</b>
                    </div>
                </li>
                <#else>
                <li class="noBd">
                    <div class="iconApplication">
                        <i class="iconali iconApp"></i>
                        <i class="iconBd"></i>
                        <p>阿里巴巴</p>
                    </div>
                    <div class="status">
                        <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=2&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
                    </div>
                </li>
                </#if>
                <#if outer_weixin??>
                <li class="bd">
                    <div class="iconApplication">
                        <i class="icon${outer_weixin.from!} iconApp"></i>
                        <i class="iconBd"></i>
                        <p>${outer_weixin.name!}</p>
                    </div>
                    <div class="status">
                        <b class="unBind" jbtn="${outer_weixin.from!}" data-id="${outer_weixin.id!}">解绑</b>
                    </div>
                </li>
                <#else>
                <li class="noBd">
                    <div class="iconApplication">
                        <i class="iconweixin iconApp"></i>
                        <i class="iconBd"></i>
                        <p>微信</p>
                    </div>
                    <div class="status">
                        <a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=4&backUrl=http://www.571xz.com/member/fenxiaoZhanghao.htm" class="goBind">立即绑定</a>
                    </div>
                </li>
                </#if>
            </ul>
            
            
                
            
            
            
            
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
<script src="http://style.571xz.com/fxs2/js/fenxiaoZhanghao.js?t=1498441429511"></script>
<#include "/common/cnzz.ftl">
</body>
</html>