
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>已上传的商品 - 分销商中心 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">











    
    <link href="http://style.571xz.com/v2/fxsV1/css/shiguOnekeyRecordinitv1.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/fxsV1/js/shiguOnekeyRecordinitv1.js"></script>
    
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
    
        
        
            
            <li><a class="selected" href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li> 
            
        
        
    
        
        
            
            <li><a href="${main_host!}member/goodsCollectinit.htm" >我的数据包</a></li>
            
        
        
    
        
        
            
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




        <div class="rightBox fr">
    

<#assign text>{"fields":[{"name":"uploadGoodsState","value":"${query.uploadGoodsState!}"},{"name":"startTime","value":"${query.startTime!}"},{"name":"endTime","value":"${query.endTime!}"},{"name":"shopState","value":"${query.shopState!}"},{"name":"tbState","value":"${query.tbState!}"}]}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
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





    <ul class="pageTabs clearfix">
    <li <#if !query.uploadGoodsState >class="select"</#if>><a href="javascript:;" data-state="">全部</a></li>
    <li <#if query.uploadGoodsState == 1 >class="select"</#if>><a href="javascript:;" data-state="1">档口在售</a></li>
    <li <#if query.uploadGoodsState == 2 >class="select"</#if>>
        <a href="javascript:;" class="pr" data-state="2">
            档口已下架
            <#if shopDownNum??>
            <i class="shopDownNum pa">${shopDownNum!}</i>
            </#if>
        </a>
    </li>
    <li <#if query.uploadGoodsState == 3 >class="select"</#if>><a href="javascript:;" data-state="3">历史上传</a></li>
</ul>




    <div class="searchBar">
    <ul class="clearfix">
        <li>
            <label>时间：</label>
            <input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" id="startTime" placeholder="开始时间" <#if query.startTime??>value="${query.startTime!}"</#if>>
            <span class="divideLine">-</span>
            <input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" id="endTime" placeholder="截止时间" <#if query.endTime??>value="${query.endTime!}"</#if>>
        </li>
        <li><label>档口状态：</label>

<#assign text>{"value":"${query.shopState!}"}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<div class="fmSelect" id="shopState">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>



</li>
        <li><label>淘宝状态：</label>

<#assign text>{"value":"${query.tbState!}"}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>
<div class="fmSelect" id="tbState">
    <span class="text">数据加载中...</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>





</#list>



</li>
        
        <li class="noMargin">
            

<#assign text>{}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
         searchBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="searchBtn"
    
>

    
        搜索订单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

        </li>
    </ul>
</div>








<#assign text>{}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
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





    <div id="dataList" class="dataList">
    <ul class="head clearfix">
        <li class="name">
            <label>
                

<#assign text>{}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>
<label class="fmCheckbox
    
        <#if $it.checked??>
            checked
        </#if>
    
    
    
        <#if $it.disabled??>
            disabled
        </#if>
    
">
    <input 
        type="checkbox"
        autocomplete="off"
        
            name="allItems"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            <#if $it.selectParent??>
                data-selectParent="${$it.selectParent!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
        
        
            <#if $it.disabled??>
                disabled
            </#if>
        
        
    >
    <i class="before"></i> 
    <span>
    
        全选
    
    
        <#if $it.html??>
            ${$it.html}
        </#if>
    
    </span>
</label>




</#list>

            </label>
            <button jbtn="downTbGoods">批量淘宝下架</button>
        </li>
        <li class="piprice">批发价(元)</li>
        <li class="gysName">供应商</li>
        <li class="upTime">上架时间</li>
        <li class="control">操作</li>
    </ul>
    <#if (goodsList?size) gt 0 >
        <#list goodsList as goods>
        <ul class="body clearfix" goodsid="${goods.goodsId!}">
            <li class="name">
                <#if goods.taobaoSaleState == 1>
                

<#assign text>{"value":goods.goodsId}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>
<label class="fmCheckbox
    
        <#if $it.checked??>
            checked
        </#if>
    
    
    
        <#if $it.disabled??>
            disabled
        </#if>
    
">
    <input 
        type="checkbox"
        autocomplete="off"
        
            name="favoriteGoods"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="allItems"
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
        
        
            <#if $it.disabled??>
                disabled
            </#if>
        
        
    >
    <i class="before"></i> 
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    
        <#if $it.html??>
            ${$it.html}
        </#if>
    
    </span>
</label>




</#list>

                <#elseif goods.taobaoSaleState == 2>
                <span class="zwf fl"></span>
                </#if>
                <a class="piclink fl" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">
                    <img src="${goods.imgsrc!}_80x80.jpg">
                </a>
                <p class="fl">
                    <a class="title" href="http://www.571xz.com/item.htm?id=${goods.goodsId!}" title="查看宝贝详情" target="_blank">${goods.title!}</a>
                </p>
                <p class="fl"><span>货号：${goods.goodsNo!}</span></p>
                <p class="fl">
                    <#if goods.shopSaleState == 1>
                    <i class="shopSaleState"></i>
                    <#elseif goods.shopSaleState == 2>
                    <i class="shopSaleState noSale"></i>
                    </#if>
                    
                    <#if goods.taobaoSaleState == 1>
                    <i class="taobaoSaleState"></i>
                    <#elseif goods.taobaoSaleState == 2>
                    <i class="taobaoSaleState noSale"></i>
                    </#if>
                </p>
            </li>
            <li class="piprice">
                ${goods.piprice!}
            </li>
            <li class="gysName">
                <p>${goods.marketName!}</p>
                <p>${goods.shopNum!}</p>
                <p>
                    

<#assign text>{"id":"${(goods.imWw!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>

                    

<#assign text>{"id":"${(goods.imQq!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata9=text?eval />
<#list [moduledata9] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>

                </p>
            </li>
            <li class="upTime">
                <p>${goods.upTime!}</p>
            </li>
            <li class="control">
                <#if goods.taobaoSaleState == 1>
                

<#assign text>{}</#assign>
<#assign moduledata10=text?eval />
<#list [moduledata10] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-gray-o
        "
    
        jbtn="downTbGoods"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        淘宝下架
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

                </#if>
            </li>
        </ul>
        </#list>
        

<#assign text>{}</#assign>
<#assign moduledata11=text?eval />
<#list [moduledata11] as $it>

<div class="jqPagination " id="jqPagination0" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>







</#list>

    <#else>
        暂无数据
    </#if>
</div>






































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




