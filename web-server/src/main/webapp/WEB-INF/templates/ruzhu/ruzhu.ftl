<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>[四季星座网]-申请开店</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/ruzhu_temp/css/ruzhu.css?t=" rel="stylesheet">
    
  </head>
<body>
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
        <div class="box">
            <h2>分销商</h2>
        </div>
        <i class="splitline"></i>
        <div class="box2">
            <a href="${main_host!}member/memberghs.htm">切换到供应商</a>
            <a href="http://daifa.571xz.net/daili/offerIndex.htm">我的代发</a>
        </div>
        <ul>
            <li ><a href="${main_host!}member/index.htm">首页</a></li>
            <li><a href="${main_host!}member/sysSetsindex.htm">账号管理</a></li>
        </ul>
    </div>
</div>
<div class="main">
    <div class="layout rz_content">
        <div class="rzct_status clearfix">
            <span class="active first">
                <em>1</em>
                <i>填写账户信息</i>
            </span>
            <span class="second">
                <i class="line"></i>
                <em>2</em>
                <i>等待专员审核</i>
            </span>
            <span class="third">
                <i class="line"></i>
                <em>3</em>
                <i>入驻成功</i>
            </span>
        </div>
        
        <form id=form1>
        <div class="accountInfo">
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 主营商品：</div>
                <div class="inner">
                    <ul class="clearfix screenList">
                        
                        <#list mainbusList as mainbus>
                            <li class="fl"><label><input type="radio" value="${mainbus!}" name="mainCate">${mainbus!}</label></li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 档口号：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="storeNum" value="">
                </div>
            </div>
            
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 淘宝绑定：</div>
                <div class="inner">
                    <label><#if tbNick??>${tbNick}<#else>您还未绑定淘宝,<a href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1&backUrl=http%3A%2F%2Fwww.571xz.com%2Fruzhu.htm" target="_blank" class="red">立即绑定</a></#if></label>
                    <input name="tbNick" type="hidden" value="${tbNick!}">
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 联系电话：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="tel" value="">
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 微信号：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="wx" value="">
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 旺旺号：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="aliWw" value="">
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> QQ：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="qq" value="">
                </div>
            </div>
            <div class="accountItem">
                <div class="label">电子邮箱：</div>
                <div class="inner">
                    <input type="text" class="textInput" name="email" value="">
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 所属市场：</div>
                <div class="inner">
                    <select id="cityId" name="cityId" class="checksubstation">
                        <option value="-1">请选择站点</option>
                    </select>
                    <select id="marketId" name="marketId" class="checksubstation">
                        <option value="-1">请选择市场</option>
                    </select>
                    <select id="marketFloor" name="marketFloor" class="checksubstation">
                        <option value="-1">请选择楼层</option>
                    </select>
                </div>
            </div>
            <div class="accountItem">
                <div class="label"><span class="red">*</span> 售后服务：</div>
                <div class="inner">
                    <ul class="clearfix screenList">
                        <li class="fl"><label><input id="serverType1" class="kt" type="checkbox">可退</label></li>
                        <li class="fl"><label><input id="serverType2" class="kh" type="checkbox">可换</label></li>
                    </ul>
                    <input type=hidden id="serverLevel" name="serverLevel" value="0">
                </div>
            </div>
            <div class="subBox">
                <div class="clause">
                    <label><input name="agree" type="checkbox" checked="checked">我同意“<a href="http://www.571xz.com/static/mianze/contract.html">服务条款</a>”和“<a href="http://www.571xz.com/static/mianze/contract.html">政策</a>”</label>
                </div>
                <div> 
                      <button id="submitRuzhu" class="orangeSubBtn" type=button>提交</button>
                </div>
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
<script src="http://style.571xz.com/ruzhu_temp/js/ruzhu.js?t="></script>
<#include "/common/cnzz.ftl">
</body>
</html>