<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>四季星座网-供应商中心-出售中的宝贝</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/gys4/css/storeGoodsList21init.css?t=" rel="stylesheet">
    
  </head>
<body>
<input id="mainhost" value="http://192.168.1.188:55/gys4/" type="hidden">
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="http://cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="http://ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="http://bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="http://gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="http://wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
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
                <li class="noDown"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a></li>
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
            <li><a class="selected"  href="${main_host!}seller/storeGoodsList21init.htm">出售中的商品</a></li> 
            <li><a href="${main_host!}seller/storeGoodsListinit.htm?pinteger=2"  >仓库中的商品</a></li> 
            <li><a href="${main_host!}seller/storeGoodsNoListinit.htm"  >批量修改货号</a></li> 
            <li><a href="${main_host!}seller/xiufuGoods21init.htm"  >商品类目管理</a></li> 
        </ul> 
        <h2>店铺管理</h2>
        <ul>
            <li><a href="http://${session_user_redis__.logshop.webSite!}.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"  target="_blank">查看我的店铺</a></li> 
            <li><a href="${main_host!}seller/fitmentStorefitmentStore.htm?tab=1"  >店铺装修</a></li> 
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
            <li><a href="${main_host!}seller/dtggapply.htm?id=1001" class='dtgg' >广告派位</a></li> 
            <li><a href="${main_host!}seller/indexgglist.htm" class='indexgg' >首页广告申请</a></li> 
        </ul> 
    </div>
    
    <div class="goods-info content shadow-box">
        <div class="infobox">
            <span>${goods_counts.sale!}</span>
            <em>出售中的宝贝（件）</em>
        </div>
        <div class="splitline"></div>
        <div class="infobox">
            <span>${goods_counts.tj!}/${goods_counts.sale!}</span>
            <em>橱窗位总数（件）</em>
        </div>
        <div class="splitline"></div>
        <div class="infobox">
            <span>${goods_counts.store!}</span>
            <em>仓库中宝贝（件）</em>
        </div>
    </div>
    <div class="content shadow-box">
        <div class="goods-tabbox clearfix">
            <div class="tabbutton selected"><a href="${main_host!}seller/storeGoodsList21init.htm">出售中的宝贝<em>${goods_counts.sale!}</em></a></div>
            <div class="splitline"></div>
            <div class="tabbutton"><a href="${main_host!}seller/storeRecommendListinit.htm">推荐宝贝<em>${goods_counts.tj!}</em></a></div>
        </div>
        <div class="goods-search">
            <input type="hidden" id="webSite" value="${webSite!}">
            <ul class="clearfix">
                <li><label>宝贝名称：</label><input id="keyword" class="textinput" value="${get.keyword!}"></li>
<li><label>宝贝货号：</label><input id="goodsNo" class="textinput" value="${get.goodsNo!}"></li>                    <li><label>淘宝宝贝ID：</label><input id="goodsId" class="textinput" value="${get.goodsId!}"></li>
                <li><button onclick="goods_search()">查询</button></li>
            </ul>
        </div>
        <#if (goodslist?size) gt 0 >
        <div class="goods-list">
            <ul class="head clearfix">
                <li class="name">
                    <label><input type="checkbox" class="checkbox">全选</label>
                </li>
                <li class="price">批发价(元)</li>
                <li class="lowestPrice">最低零售价(元)</li>
                <li class="upcount">上货量</li>
                <li class="control">操作</li>
            </ul>
            <ul class="funOpe">
                <li>
                    <button class="tbGoods someTbGoods">批量同步商品</button>
                    <button class="tbGoods allTbGoods" data-id="${session_user_redis__.logshop.shopId!}">同步整店商品</button>
                    
                    <button class="tjgoods">推荐</button>
                    
                </li>
            </ul>
            <#list goodslist as item>
            <ul class="body clearfix" data-id="${item.id!}">
                <li class="name">
                    <input type="checkbox" class="checkbox" value="${item.id!},<#if item.tj == true>1<#else>0</#if>">
                    <a class="piclink" href="${item.href!}" title="查看宝贝详情" target="_blank">
                        <img src="${item.imgsrc!}_80x80.jpg">
                    </a>
                    <p>
                        <a class="title" href="${item.href!}" title="${item.title!}" target="_blank">${item.title!}</a>
                        <span class="goodsNoParent">货号：<em class="goodsNo">${item.goodsNo!}</em> <b class="penIcon" jbtn="xgGoodsNo"></b></span>
                         
                        
                    </p>
                    
                </li>
                <li class="price">
                    <p class="p2"><span>${item.price2!}</span><b class="penIcon" jbtn="piPrice"></b></p>
                </li>
                <li class="lowestPrice">
                    <p class="p3"><span>${item.price3!}</span><b class="penIcon" jbtn="lowPrice"></b></p>
                </li>
                <li class="upcount">${item.count!}</li>
                <li class="control">
                    <#if !item.tj>
                    <p><em class="tjgoods">推荐</em></p>
                    </#if>
                    
                    <#if item.detailUrlnew != null>
                    <p><b class="tbGoods">同步商品</b></p>
                    <#else>
                    <p><em class="xjgoods">下架</em></p>
                    </#if>
                </li>
            </ul>
            </#list>
        </div>
        <div class="jq_pagination" data-option="${pageOption!}"></div>
        <div class="edit-box shadow-box">
            <i></i>
            <div class="inner">
                <div class="nameform">
                    <p><label class="vertical-top">标题：</label><textarea id="goodsname-input" maxlength="30"></textarea><span class="vertical-top text-tj">0/30</span></p>
                    <p><label>货号：</label><input id="goodsnumber-input"></p>
                    <p>
                        <label></label><button class="submit">确定</button><span class="cancel">取消</span>
                    </p>
                </div>
                
                <div class="priceform">
                    <p><label>建议零售价：</label><input id="price1-input"><span>元</span></p>
                    <p><label>拿货价：</label><input id="price2-input"><span>元</span></p>
                    <p>
                        <label></label><button class="submit">确定</button><span class="cancel">取消</span>
                    </p>
                </div>
                
            </div>
        </div>
        
        <#else>
        <p class="goodslist-is-empty">找不到结果</p>
        </#if>
        
        
        
        
        
        
        
        
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
<script src="http://style.571xz.com/gys4/js/storeGoodsList21init.js?t="></script>
<#include "/common/cnzz.ftl">
</body>
</html>