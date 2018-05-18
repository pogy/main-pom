<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>绑定手机 - 四季星座网</title>
  
    
    <link href="//style.571xz.com/loginV2/css/bindTelephone.css?v=2017112301" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/loginV2/js/bindTelephone.js?v=2017112301"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源<#elseif webSite == "jx">濮院</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="//hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="//cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="//ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="//bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="//gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="//wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                        <li><a href="//jx.571xz.com" <#if webSite == "jx">class="select"</#if>>濮院</a></li>
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
<div class="bindTelephone">
    <p class="once"><strong>绑定手机号码：</strong>一个手机号只能验证一个四季星座网账号</p>
    <div class="bindForm">
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>手机号码：</label>
                <input type="text" name="telephone" class="form-input" maxlength="11" placeholder="请输入手机号码" >
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>数字验证码：</label>
                <input type="text" name="imgValidate"  class="form-input" maxlength="4" placeholder="右侧验证码" >
                <img id="checkCode" class="codeImg" src="//www.571xz.com/IMG.htm" />
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>短信验证码：</label>
                <input type="text" name="msgValidate" class="form-input msgValidate" maxlength="6" placeholder="请输入短信验证码" >
                <button type="button" id="getMsgBtn" class="getMsgBtn">点击获取</button>
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label></label>
                <button class="bindButton btn btn-orange" name="bindButton" id="bindButton">立即绑定</button>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p class="sitemap"> 
        <a href="/" target="_blank">首页</a>
        <a href="//hz.571xz.com" target="_blank">杭州站</a>
        <a href="//bj.571xz.com" target="_blank">北京站</a>
        <a href="//gz.571xz.com" target="_blank">广州站</a>
        <a href="//ss.571xz.com" target="_blank">石狮站</a>
        <a href="//cs.571xz.com" target="_blank">常熟站</a>
        <a href="//wa.571xz.com" target="_blank">辽源站</a>
        <a href="//zixun.571xz.com" target="_blank">资讯</a>
        
        
        <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        
    </p>
    <p class="jyga">
        <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
        
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="//style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
    </p>
</div>
</body>
</html>