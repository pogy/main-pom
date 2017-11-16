
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>已生成的数据包 - 分销商中心 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">











    
    <link href="http://style.571xz.com/v2/fxsV1/css/goodsDataPackageinit.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/fxsV1/js/goodsDataPackageinit.js"></script>
    
</head>
<body>


<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            
            <div class="loginBox fl">
                
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                
                 
                <li class="noIndex">
                    <a href="${main_host!}" class="fcF40">四季星座网首页</a>
                </li>
                
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop> 
                <li class="noDown">
                    <a href="${main_host!}order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                        
                        
                    </a>
                </li>
                <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? > 
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
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
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            
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
                </#if>
            </ul>
        </div>
    </div>
</div>










</#list>


<script>
var webSite = '${webSite!}';
</script>






<div class="header">
    <div class="layout">
        <a href="http://www.571xz.com" class="fl">
            <img src="http://style.571xz.com/v2/xz/css/img/whiteLogo.png" width="168" height="28" />
        </a>
        <ul class="fl fs16 yahei clearfix">
            <li><a href="${main_host!}member/index.htm"  >首页</a></li>
            <li><a href="${main_host!}member/userBalance.htm" >我的钱包</a></li>
            <li><a href="${main_host!}member/sysSetsindex.htm" >安全中心</a></li>
        </ul>
    </div>
</div>


<div class="wrapper">
    <div class="layout">
        <div class="leftSidebar yahei">

    <h2>交易管理</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}order/myOrder.htm" >我的订单</a></li>
            
        
        
    
        
        
            
            <li><a href="${main_host!}order/myTbOrder.htm" target="_blank">淘宝订单</a></li>
            
        
        
    
        
        
            
            <li><a href="${main_host!}order/shManaOrder.htm" >售后管理</a></li>
            
        
        
    
        
        <#if session_user_redis__.otherPlatform.__moreOrder__>
        
        
            
            <li><a href="${main_host!}order/myBatchTbOrder.htm" target="_blank">批量操作</a></li>
            
        
        
        </#if>
        
    
    </ul> 

    <h2>商品管理</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm" >已上传的商品</a></li>
            
        
        
    
        
        
            
            <li><a class="selected" href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li> 
            
        
        
    
        
        
            
            <li><a href="${main_host!}member/storeCollectinit.htm" >我的收藏</a></li>
            
        
        
    
    </ul> 

    <h2>供应商申请</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/storeIn.htm" >店铺申请</a></li>
            
        
        
    
    </ul> 

    <h2>会员俱乐部</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/awardInfo.htm" >开奖结果</a></li>
            
        
        
    
    </ul> 

</div>




        <div class="rightBox yahei fr">
    <div class="tabBox clearfix">
    <div class="tabbutton "><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></div>
    <div class="splitline"></div>
    <div class="tabbutton selected"><a href="${main_host!}member/goodsDataPackageinit.htm">已生成的数据包</a></div>
</div>


    <#if (goodslist?size) gt 0>
    
<div class="goodslist">
    <ul class="head clearfix">
        <li class="name">
            <label><input type="checkbox" class="checkbox">全选</label>
            <button jbtn="rmvZipdp">全部删除</button>
        </li>
        <li class="count">未下架的商品数</li>
        <li class="time">时间</li>
        <li class="control">操作</li>
    </ul>
    
    <#list goodslist as zipdp>
    <ul class="body clearfix" zipdpid="${zipdp.id!}">
        <li class="name">
            
            <dl>
            <#if zipdp.remark10??>
                <dt>
                    <input type="checkbox" class="checkbox" zipdpid=${zipdp.dataPackageId!}>
                    <a class="piclink" href="javascript:;" title="查看宝贝详情">
                        <img src="${zipdp.remark9!}">
                    </a>
                    <p>
                        <a class="title" href="javascript:;" title="${zipdp.remark10!}">${zipdp.remark10!}</a>
                    </p>
                </dt>
            <#else>
            
                <#list zipdp.goods as goods>
                
                <#if goods_index == 0>
                <dt>
                    <input type="checkbox" class="checkbox" zipdpid=${zipdp.dataPackageId!}>
                    <a class="piclink" href="#" title="查看宝贝详情" target="_blank">
                        <img src="${goods.imgsrc!}">
                    </a>
                    <p>
                        <a class="title" href="${main_host!}item.htm?id=${goods.id!}" title="查看宝贝详情" target="_blank">标题：${goods.title!}</a>
                    </p>
                </dt>
                </#if>
                
                <dd>
                    <i class="line"></i>
                    <a class="piclink smallpic" href="#" title="查看宝贝详情" target="_blank">
                        <img src="${goods.imgsrc!}">
                    </a>
                    <p>
                        <a class="title" href="${main_host!}item.htm?id=${goods.id!}" title="查看宝贝详情" target="_blank">标题：${goods.title!}</a>
                    </p>
                    
                </dd>
                
                </#list>
            </#if>
            </dl>
            
        </li>
        <li class="count">
            <#if zipdp.remark10??>
            数据包中的商品都已下架
            <#else>
            ${(zipdp.goods?size)!}
            </#if>
        </li>
        <li class="time">${zipdp.createtime!}</li>
        <li class="control">
            <a href="${zipdp.href!}" target="_blank">下载</a>
            <button jbtn="rmvZipdp" zipdpid=${zipdp.dataPackageId!}>删除</button>
            <#if zipdp.remark10??>
            
            <#else>
                <#if (goodslist?size) gt 0>
                <button jbtn="toggleZipdp">展开</button>
                </#if>
            </#if>
        </li>
    </ul>
    </#list>
</div>




































    <#else>
    <p class=emptylist>暂无数据</p>

    </#if>
    

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

<div class="jqPagination " id="jqPagination0" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>







</#list>

    
</div>


<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
        <#if field.timeFormat??>
            <#if field.value??>
            <input type=hidden name="${field.name!}" value="${field.value?string(field.timeFormat)}">
            <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
            </#if>
        <#else>
            <input type=hidden name="${field.name!}" value="${field.value!}">
        </#if>
    </#list>
</form>
</#if>





</#list>






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
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            | 
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <img src="http://style.571xz.com/v2/global/css/img/beian.png" alt="浙公网安备">
                浙公网安备 33010202000302号
            </a> 
        </p>
    </div>
</div>



<!--省略end，让浏览器自动添加-->

<#include "/common/cnzz.ftl">




