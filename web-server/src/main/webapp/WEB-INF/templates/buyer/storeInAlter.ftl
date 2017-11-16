<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title> 四季星座网-分销商中心-店铺申请修改</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/fxs2/css/storeInAlter.css?t=1498814567270" rel="stylesheet">
    
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
                <li><a href="${main_host!}member/fenxiaoZhanghao.htm" >应用绑定</a></li>
        </ul> 
        <h2>供应商申请</h2>
        <ul>
            <li><a class="selected" href="${main_host!}member/storeIn.htm">店铺申请</a></li> 
        </ul> 
        <h2>会员俱乐部</h2>
        <ul>
                <li><a href="${main_host!}member/awardInfo.htm" >开奖结果</a></li>
        </ul> 
    </div>
    <div class="main">
        <div class="layout rz_content">
            <form id=form1>
            <div class="accountInfo">
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 主营商品：</div>
                    <div class="inner">
                        <ul class="clearfix screenList">
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '女装'>checked="checked"</#if> value="女装" name="mainCate">女装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '男装'>checked="checked"</#if> value="男装" name="mainCate">男装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '童装'>checked="checked"</#if> value="童装" name="mainCate">童装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '包包'>checked="checked"</#if> value="包包" name="mainCate">包包</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '男鞋'>checked="checked"</#if> value="男鞋" name="mainCate">男鞋</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '女鞋'>checked="checked"</#if> value="女鞋" name="mainCate">女鞋</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '服饰配件'>checked="checked"</#if> value="服饰配件" name="mainCate">服饰配件</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '情侣装'>checked="checked"</#if> value="情侣装" name="mainCate">情侣装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == '其他'>checked="checked"</#if> value="其他" name="mainCate">其他</label></li>
                            
                        </ul>
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 档口号：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="storeNum" value="${applyInfo.storeNum!}">
                    </div>
                </div>
                <#if applyInfo.hasTaobaoStore == "1">
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 是否有淘宝店：</div>
                    <div class="inner">
                        <a class="tbUrl" href="${applyInfo.tbStoreUrl!}" target="_blank">${applyInfo.tbStoreUrl!}</a>
                        <span>（${applyInfo.tbStoreName!}）</span>
                    </div>
                </div>
                </#if>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 联系电话：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="tel" value="${applyInfo.tel!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 微信号：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="wx" value="${applyInfo.wx!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 旺旺号：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="aliWw" value="${applyInfo.aliWw!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> QQ：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="qq" value="${applyInfo.qq!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label">电子邮箱：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="email" value="${applyInfo.email!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 所属市场：</div>
                    <div class="inner">
                        ${applyInfo.marketName!} — ${applyInfo.marketFloorNum!}
                        <input id="cityId" name="cityName" style="display: none" value="1" />
                        <input id="marketId" name="marketId" style="display: none" value="1" />
                        <input id="marketFloor" name="marketFloor" style="display: none" value="1" />
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 售后服务：</div>
                    <div class="inner">
                        <ul class="clearfix screenList">
                            <li class="fl"><label><input id="serverType1" class="kt" type="checkbox"<#if applyInfo.serverLevel == "1" || applyInfo.serverLevel == "3">checked</#if> name="" value="0">可退</label></li>
                            <li class="fl"><label><input id="serverType2" class="kh" type="checkbox"<#if applyInfo.serverLevel == "2" || applyInfo.serverLevel == "3">checked</#if> name="" value="1">可换</label></li>
                        </ul>
                        <input type=hidden name="serverLevel" value="0">
                    </div>
                </div>
                <div class="subBox">
                    <div class="clause">
                        <input name="agree" id="agree" type="checkbox" checked="checked"><label>我同意“<a href="http://www.571xz.com/static/mianze/contract.html">服务条款</a>”和“<a href="http://www.571xz.com/static/mianze/contract.html">政策</a>”</label>
                    </div>
                    <div> 
                          <button id="submitRuzhu" class="orangeSubBtn" type=button>提交</button>
                    </div>
                </div>
            </div>
            </form>
            
            
            
            
            
            
            <script>/*============ fxs2/storeInAlter#accountInfo BEGIN ============*/

var selectReturnValue = { //3级联动回填数据
    cityId: '${applyInfo.cityId!}',
    cityName: '${applyInfo.cityName!}',
    marketId: '${applyInfo.marketId!}',
    marketName: '${applyInfo.marketName!}',
    marketFloor: '${applyInfo.marketFloor!}',
    marketFloorNum: '${applyInfo.marketFloorNum!}'
};

/*============ fxs2/storeInAlter#accountInfo END ============*/


</script>
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
<script src="http://style.571xz.com/fxs2/js/storeInAlter.js?t=1498814567270"></script>
<#include "/common/cnzz.ftl">
</body>
</html>