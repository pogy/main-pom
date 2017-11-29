
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>进货车 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/order/css/cart.css?v=2017112401" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/order/js/cart.js?v=2017112401"></script>
    
</head>
<body>


<#assign text>{"isFxs":true}</#assign>
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









<div class="header layout">
    <div class="logoLeft fl">
        <a href="http://www.571xz.com">
            <img src="http://style.571xz.com/v2/xz/css/img/mtLogo.png" width="168" height="30" />
        </a>
        <em class="yahei">进货车</em>
    </div>
    <div class="statusRight fr">
        <div class="stTitle clearfix">
            <ul>
                
                <li class="pr cgState">
                    <h5>1、确认商品</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr">
                    <h5>2、提交订单</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr">
                    <h5>3、选择支付方式</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr">
                    <h5>4、支付成功</h5>
                    <span class="pa"></span>
                </li>
                
            </ul>
        </div>
        <div class="subScript"></div>
    </div>
</div>






<div class="minHeight">
<div class="allGoods layout">
    <h3 class="fcF40 yahei fs16">全部商品 <span>${cart.goodsCount!}</span></h3>
    <#if (cart.orders?size) gt 0>
    <div class="accoutnInfo fr">
        已选商品 <span class="orderTotalNumValue fcF40 fs14 fwb">0</span> 件（不含运费）<span class="yahei fcF40">&yen;</span> <span class="fcF40 fs14 fwb orderTotalPriceValue">0.00</span>
        <span class="accountBtn pr">
            

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-out
         submitOrders"
    
        jbtn="click"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        结算
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

            <div class="tips pa fwb none">请勾选您要结算的商品 <i></i></div>
        </span>
    </div>
    </#if>
</div>



<#if (cart.orders?size) gt 0>
<div class="listBox layout">
    <div class="listHeader clearfix">
        <ul>
            <li class="checkBox">
                

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
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
        
            name="selectAll"
        
        
        
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

            </li>
            <li class="goodsTitle">货品</li>
            <li class="goodsPrice tac">单价</li>
            <li class="goodsAttr">属性</li>
            <li class="goodsCount tac">数量</li>
            <li class="goodsTotalPrice tac">小计</li>
            <li class="goodsOperate tac">操作</li>
        </ul>
    </div>

    <#list cart.orders as order>
    <div class="shopItem" data-id="${order.orderId!}" data-webSite="${order.webSite!}">
        <div class="shopInfo clearfix">
            <div class="fl">
                

<#assign text>{"name":order.orderId,"text":"${(order.marketName!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}${(order.storeNum!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>
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
        
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="selectAll"
        
        
        
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

                

<#assign text>{"id":order.imQq}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>
 
                

<#assign text>{"id":order.imWw}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>

            </div>
            <div class="fr fc9">发货地：
                <#if order.webSite == 'hz'>
                    浙江-杭州
                <#elseif order.webSite == 'cs'>
                    江苏-常熟
                <#elseif order.webSite == 'ss'>
                    福建-石狮
                <#elseif order.webSite == 'bj'>
                    北京
                <#elseif order.webSite == 'gz'>
                    广东-广州
                <#elseif order.webSite == 'wa'>
                    吉林-辽源
                <#elseif order.webSite == 'jx'>
                    浙江-濮院
                <#else>
                    浙江-杭州
                </#if>
            </div>
        </div>
        <div class="shopGoodsList clearfix">
            <#list order.childOrders as childOrder>
            <ul class="goodsItem<#if childOrder.disabled == true> goodsOut</#if>" 
    data-id="${childOrder.childOrderId!}" 
    data-price="${childOrder.price!}"
>
    <li class="checkBox">
        <#if childOrder.disabled == false>
        

<#assign text>{"name":childOrder.childOrderId,"selectParent":order.orderId}</#assign>
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
        
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
                
            </#if>
        
        
        
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
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    
        <#if $it.html??>
            ${$it.html}
        </#if>
    
    </span>
</label>




</#list>

        </#if>
    </li>
    <li class="goodsInfo">
        <#if childOrder.disabled == true>
        <a href="javascript:;"><img src="${childOrder.imgsrc!}_240x240.jpg" class="fl"></a>
        <#else>
        <a href="http://${order.webSite!}.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank"><img src="${childOrder.imgsrc!}_240x240.jpg" class="fl"></a>
        </#if>
        <div class="fl goodsTitle fc3">
            <h4>
                <#if childOrder.disabled == true>
                <a href="javascript:;" class="out">${childOrder.title!}</a>
                <#else>
                <a href="http://${order.webSite!}.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank">${childOrder.title!}</a>
                </#if>
            </h4>
            <p class="fwb">商品货号：${childOrder.goodsNo!}</p>
        </div>
    </li>
    <li class="goodsPrice tac fc3 yahei"><span>&yen;</span><span class="fwb">${childOrder.price!}</span></li>
    <li class="goodsAttr fc9 pr">
        <div class="skuBox" data-colorId="${childOrder.color!}" data-sizeId="${childOrder.size!}">
            颜色：${childOrder.color!}<br>尺码：${childOrder.size!}
        </div>
        <#if childOrder.disabled == false>
        <i class="edit">修改</i>
        <div class="attrInfo">
            <em></em>
            <div class="attrItem clearfix">
                <label class="fl">颜色：</label>
                <ul class="fl">
                    <#list childOrder.colors as color>
                    <li <#if childOrder.color == color>class="selected"</#if> >${color!}</li>
                    </#list>
                </ul>
            </div>
            <div class="attrItem clearfix">
                <label class="fl">尺码：</label>
                <ul class="fl">
                    <#list childOrder.sizes as size>
                    <li <#if childOrder.size == size>class="selected"</#if> >${size!}</li>
                    </#list>
                </ul>
            </div>
            <div class="btnsBox clearfix">
                

<#assign text>{}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
        "
    
        jbtn="submit"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        确定
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

                

<#assign text>{}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-none
        "
    
        jbtn="close"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        取消
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

            </div>
        </div>
        </#if>
    </li>
    <li class="goodsCount tac">
        <#if childOrder.disabled == true>
            <span>商品已失效</span>
        <#else>
            

<#assign text>{"name":childOrder.childOrderId,"value":childOrder.num}</#assign>
<#assign moduledata9=text?eval />
<#list [moduledata9] as $it>

<span class="fmNumberInput">
    <i jbtn="reduce">-</i>
    <input class="textInput" type="text" autocomplete=off 

        
            <#if $it.name??>
                data-name="${$it.name!}"
            <#else>
                data-name="fmNumberInput0"
            </#if>
        
        
        
            <#if $it.value != null >
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
        
        
        
            <#if $it.minValue != null >
                minValue="${$it.minValue!}"
            <#else>
                minValue="1"
            </#if>
        
        
        
            <#if $it.maxValue != null >
                maxValue="${$it.maxValue!}"
            <#else>
                maxValue="*"
            </#if>
        
    
    maxlength="">
    
    <input class="realInput" type="hidden" 
    
        
            <#if $it.name??>
                name="${$it.name!}"
            <#else>
                name="fmNumberInput0"
            </#if>
        
        
        
            <#if $it.value != null >
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
        
        
   >
    <i jbtn="add">+</i>
</span>








</#list>

        </#if>
    </li>
    
    <li class="goodsTotalPrice tac fcF40 yahei"><span>&yen;</span><span class="fwb goodsTotalPriceValue">0</span></li>
    <li class="goodsOperate tac"><b>删除</b></li>
</ul>




































            </#list>
        </div>
    </div>
    </#list>
        
    
    
</div>
<#else>
<div class="layout noData tac">
    <p class="fs16 fc6">进货车里空空的哦，先去<a href="http://www.571xz.com/">逛一逛</a>吧！</p>
</div>
</#if>





<#if (cart.orders?size) gt 0>
<div class="totalAccount layout" id="totalAccount">
    <div class="totalWrap layout">
        <div class="fl operateBox">
            

<#assign text>{}</#assign>
<#assign moduledata10=text?eval />
<#list [moduledata10] as $it>
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
        
            name="selectAll"
        
        
        
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

            <b id="deleteAll">删除</b>
        </div>
        <div class="accountBtnBox fr pr yahei">
            

<#assign text>{}</#assign>
<#assign moduledata11=text?eval />
<#list [moduledata11] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-out
         submitOrders"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        结算
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

            <div class="tips pa fwb none">请勾选您要结算的商品 <i></i></div>
        </div>
        <div class="fr totalInfo">
            已选商品<span class="fs18 yahei fcF40 count orderTotalNumValue">0</span>件
            合计（不含运费）：<span class="fs18 yahei fcF40"><em class="fs14">&yen;</em> <em class="fwb totalPrice orderTotalPriceValue">0</em></span>
        </div>
    </div>
    <form action="" id="submitOrdersForm">
        <input type="hidden" id="submitOrderIds" name="childOrderIds">
    </form>
</div>
</#if>






















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







