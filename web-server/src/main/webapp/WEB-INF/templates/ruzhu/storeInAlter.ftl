<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>个人中心</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/fxs/css/storeInAlter.css" rel="stylesheet">
  </head>
<body>
<input id="mainhost" value="http://192.168.1.188:55/fxs/" type="hidden">
<div class="topbar">
    <div class="inner">
        <div class="topbar-left">
            <span>Hi,</span> 
            欢迎来到四季星座网!
            <a class="login" href="http://www.571xz.com/login.htm" target="_blank">请登录</a>
            <a class="register" href="http://www.571xz.com/regedit.htm" target="_blank">免费注册</a>
        </div>
        <ul class="topbar-right clearfix">
            <li> 
            
                <div class="nav-name"><em>我是代理<i class="img-jiantou"></i></em></div>
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
                <div class="nav-name"><a href="${main_host!}member/memberghs.htm" target="_blank">档口中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="${main_host!}member/releaseGoodsinit.htm" target="_blank" rel="nofollow">发布宝贝</a>
                    <a href="${main_host!}member/storeGoodsListinit.htm" target="_blank" rel="nofollow">已发布的宝贝</a>
                </div>    
            </li>
            <li class="last">
                <div class="nav-name"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=4000761116"  target="_blank" >客服中心<i class="img-jiantou"></i></a></div>
                <div class="nav-list">
                    <a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&amp;uin=4000761116" rel="nofollow">在线客服</a>
                    <a href="http://hz.571xz.com:8070/zixun/article?id=87" target="_blank" rel="nofollow">联系我们</a>
                    <a href="http://hz.571xz.com:8070/zixun/article?id=14" target="_blank" rel="nofollow">新手入门</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="header">
    <div class="layout">
        <a class="logo iconfont" href="http://www.571xz.com">&#xe653;</a>
        <div class="box">
            <h2>分销商</h2>
            <a href="http://www.571xz.com">返回首页</a>
        </div>
        <i class="splitline"></i>
        <div class="box2">
            <a href="${main_host!}member/memberghs.htm">切换到供应商</a>
            <a href="http://daifa.571xz.net/daili/offerIndex.htm">我的代发</a>
        </div>
        <ul>
            <li ><a href="${main_host!}member/memberfxs.htm">首页</a></li>
            <li><a href="${main_host!}member/sysSetsindex.htm">账号管理</a></li>
            <li><a href="${main_host!}member/memberMessage.htm">消息</a></li>
        </ul>
    </div>
</div>
<div class="wrapper layout">
    
    
    <div class="sidebar shadow-box">
        <h2>基础功能</h2>
        <ul>
                <li><a href="${main_host!}member/fenxiaoZhanghao.htm" >第三方绑定账户</a></li>
                <li><a href="${main_host!}member/goodsCollectinit.htm" >我的数据包</a></li>
                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm" >已上传的商品</a></li>
                <li><a href="${main_host!}member/storeCollectinit.htm" >我的收藏</a></li>
        </ul> 
        <h2>代发</h2>
        <ul>
                <li><a href="http://daifa.571xz.net/daili/offerIndex.htm" >我要代发</a></li>
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
                <li><a href="${main_host!}member/memberMessage.htm" >消息提醒</a></li>
        </ul> 
        <h2>店铺申请</h2>
        <ul>
            <li><a class="selected" href="${main_host!}member/storeIn.htm">店铺申请</a></li> 
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
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="女装" name="mainCate">女装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="男装" name="mainCate">男装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="童装" name="mainCate">童装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="包包" name="mainCate">包包</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="男鞋" name="mainCate">男鞋</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="女鞋" name="mainCate">女鞋</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="服饰配件" name="mainCate">服饰配件</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="情侣装" name="mainCate">情侣装</label></li>
                            <li class="fl"><label><input type="radio" <#if applyInfo.mainCate == text>checked="checked"</#if> value="其他" name="mainCate">其他</label></li>
                        </ul>
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 档口号：</div>
                    <div class="inner">
                        <input type="text" class="textInput" name="storeNum" value="${applyInfo.storeNum!}">
                    </div>
                </div>
                <div class="accountItem">
                    <div class="label"><span class="red">*</span> 是否有淘宝店：</div>
                    <div class="inner">
                        <ul class="clearfix screenList">
                            <li class="fl"><label><input type="radio" value="1" name="hasTaobaoStore" <#if applyInfo.hasTaobaoStore == '1'>checked</#if>>有</label></li>
                            <li class="fl"><label><input type="radio" value="0" name="hasTaobaoStore" <#if applyInfo.hasTaobaoStore == '0'>checked</#if>>没有</label></li>
                        </ul>
                    </div>
                </div>
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
            
            
            
            
            
            
            <script>/*============ fxs/storeInAlter#accountInfo BEGIN ============*/

var cityName = '${applyInfo.cityName!}';
    var cityId = '${applyInfo.cityId!}';
    var marketId = '${applyInfo.marketId!}';
    var marketName = '${applyInfo.marketName!}';
    var marketFloor = '${applyInfo.marketFloor!}';
    var marketFloorNum = '${applyInfo.marketFloorNum!}';

/*============ fxs/storeInAlter#accountInfo END ============*/


</script>
        </div>
    </div>
    
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://bbs.571xz.com/" target="_blank">星座论坛</a>
            <a href="http://market.571xz.com/" target="_blank">服装批发市场</a>
            <a href="http://hz.571xz.com:8070/zixun/article?id=87" target="_blank">联系我们</a>
            <a href="http://www.571xz.com/shigu/contact/zpyc/" target="_blank">招聘英才</a> 
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            &copy; 2009-2017 571xz.com 版权所有 <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://www.571xz.com/images/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
        </p>
    </div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/fxs/js/storeInAlter.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>