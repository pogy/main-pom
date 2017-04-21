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
    
    <link href="http://style.571xz.com/fxs/css/storeIn.css" rel="stylesheet">
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
    <div class="content">
        <div class="tabbox clearfix">
            <div class="tabbutton selected"><a href="#">店铺申请</a></div>
            <div class="add_store"><a href="ruzhu.htm" target="_blank">添加店铺</a></div>
        </div>
    <div class="storelist">
        <table>
            <thead>
                <th class="store_name">店铺</th>
                <th class="sqtime">申请时间</th>
                <th class="status">状态</th>
                <th class="ope">操作</th>
            </thead>
            <tbody>
                <#list storelist as store>
                <tr>
                    <td>${store.storeName!}</td>
                    <td>${store.sqTime!}</td>
                    <td><#if store.status == 0><p class="red">审核不通过</p><#elseif store.status == 1><p class="red">审核中...</p><#else><p class="green">已通过</p></#if></td>
                    <td>
                        <a class="btn" jbtn="xiugai" href="storeInAlter.htm?userCode=${store.userCode!}" target="_blank">修改</a>
                        <a class="btn" jbtn="search" href="storeInRead.htm?userCode=${store.userCode!}" target="_blank">查看</a>
                        <b class="btn" jbtn="remove" data-code="${store.userCode!}">删除</b>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
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
<script src="http://style.571xz.com/fxs/js/storeIn.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>