
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>淘宝订单 - 分销商中心 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">











    
    <link href="http://style.571xz.com/v2/fxsV1/css/myBatchTbOrder.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/fxsV1/js/myBatchTbOrder.js"></script>
    
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
        
        
            
            <li><a class="selected" href="${main_host!}order/myBatchTbOrder.htm">批量操作</a></li> 
            
        
        
        </#if>
        
    
    </ul> 

    <h2>商品管理</h2>
    <ul>
    
        
        
            
            <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm" >已上传的商品</a></li>
            
        
        
    
        
        
            
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




        




<#assign text>{"fields":[{"name":"st","value":"${query.st!}"},{"name":"et","value":"${query.et!}"},{"name":"orderId","value":"${query.orderId!}"}]}</#assign>
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


<div class="rightBox fr">
    <div class="tabBox clearfix yahei">
    <ul>
        <li class="select"><a href="javascript:;">淘宝已卖出商品</a></li>
    </ul>
</div>


    <div class="orderSearch clearfix">
    <ul>
        <li><label>订单编号：</label><input type="text" name="orderId" <#if query.orderId??>value="${query.orderId!}"</#if>></li>
        <li>
            <label>成交时间：</label><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="starTime" placeholder="请选择时间范围起始" <#if query.st??>value="${query.st!}"</#if>><span class="divideLine">-</span><input type="text" class="jqDatepicker slInput" data-format="%Y-%M-%D" name="endTime" placeholder="请选择时间范围起始" <#if query.et??>value="${query.et!}"</#if>>
        </li>
        <li class="noMargin">
            

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
         searchBtn"
    
        jbtn="searchBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
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






    


<div class="orderDetail">
    <div class="listHead clearfix">
    <ul>
        <li class="goods">商品</li>
        <li class="tbPrice">淘宝价格</li>
        <li class="xzPrice">星座网价格</li>
        <li class="num">数量</li>
        <li class="profits">利润(元)</li>
        <li class="opera">操作</li>
    </ul>
</div>


    <#if notLinkNum gt 0>
<div class="tbOrderTip fc3">
    提示：淘宝已卖出的商品中有<em class="fcF40">${notLinkNum!}</em>件商品暂未绑定四季星座网商品库中对应的商品,只有绑定后才可准确无误下单哦！<a class="fcF40" href="tbBindGoodsNo.htm?notLinkCode=${notLinkCode!}" target="_blank">立即查看</a>
</div>
</#if>



    <div class="tbOrderCheck">
    <div class="tbOpe">
        

<#assign text>{}</#assign>
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
        
            name="flagCheckAll"
        
        
        
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

        

<#assign text>{}</#assign>
<#assign moduledata4=text?eval />
<#list [moduledata4] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
         fmButton-sm
         fmButton-white-o
         moreToOrder"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        批量下单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

    </div>
    <div class="flagCheckBox">
        <span>您也可以通过旗帜的颜色快速选择订单：</span>
        

<#assign text>{}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
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
        
            name="flagBlue"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        <i class="flag4 icon-s-flag"></i>蓝色
    
    </span>
</label>




</#list>

        

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
        
            name="flagPurple"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        <i class="flag5 icon-s-flag"></i>紫色
    
    </span>
</label>




</#list>

        

<#assign text>{}</#assign>
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
        
            name="flagRed"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        <i class="flag1 icon-s-flag"></i>红色
    
    </span>
</label>




</#list>

        

<#assign text>{}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>
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
        
            name="flagGreen"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        <i class="flag3 icon-s-flag"></i>绿色
    
    </span>
</label>




</#list>

        

<#assign text>{}</#assign>
<#assign moduledata9=text?eval />
<#list [moduledata9] as $it>
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
        
            name="flagYellow"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        <i class="flag2 icon-s-flag"></i>黄色
    
    </span>
</label>




</#list>

        

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
        
            name="flagNoColor"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                
            </#if>
        
        
        
            <#if $it.statusParent??>
                data-statusParent="${$it.statusParent!}"
            </#if>
        
        
        
            data-selectParent="flagCheckAll"
        
        
        
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
    
    
        无旗帜
    
    </span>
</label>




</#list>

    </div>
</div>


    <div class="orderBox">
        <#if (orders?size) gt 0>
            <#list orders as order>
            <div class="orderItem" data-id="${order.tbId!}">
    <div class="orderHead">
        <#if order.flagState == 1>
        

<#assign text>{}</#assign>
<#assign moduledata11=text?eval />
<#list [moduledata11] as $it>
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
        
        
        
            data-selectParent="flagRed"
        
        
        
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

        <#elseif order.flagState == 2>
        

<#assign text>{}</#assign>
<#assign moduledata12=text?eval />
<#list [moduledata12] as $it>
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
        
        
        
            data-selectParent="flagYellow"
        
        
        
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

        <#elseif order.flagState == 3>
        

<#assign text>{}</#assign>
<#assign moduledata13=text?eval />
<#list [moduledata13] as $it>
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
        
        
        
            data-selectParent="flagGreen"
        
        
        
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

        <#elseif order.flagState == 4>
        

<#assign text>{}</#assign>
<#assign moduledata14=text?eval />
<#list [moduledata14] as $it>
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
        
        
        
            data-selectParent="flagBlue"
        
        
        
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

        <#elseif order.flagState == 5>
        

<#assign text>{}</#assign>
<#assign moduledata15=text?eval />
<#list [moduledata15] as $it>
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
        
        
        
            data-selectParent="flagPurple"
        
        
        
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

        <#else>
        

<#assign text>{}</#assign>
<#assign moduledata16=text?eval />
<#list [moduledata16] as $it>
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
        
        
        
            data-selectParent="flagNoColor"
        
        
        
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
        
        <span class="fc6 mr">订单编号：<em class="fs14">${order.tbId!}</em></span>
        <span class="fc6 mr">成交时间：<em class="fs14">${order.time!}</em></span>
        <b class="fcBlue fr detailBtn" jbtn="detailBtn">详情<i class="icon-downarrow"></i></b>
        <#if order.flagState??>
        <i class="flag${order.flagState!} icon-s-flag fr flag"></i>
        </#if>
        <#if order.lastTime??>
        <em class="fr fc6">${order.lastTime!} 已下单</em>
        </#if>
    </div>
    <div class="orderCon">
        <div class="orderInfo">
            <#list order.childOrders as childOrder>
            <div class="childOrderItem" name="${childOrder.numiid!}" data-webSite="${childOrder.webSite!}">
    <ul class="clearfix">
        <li class="goods clearfix borderBot" data-imgSrc="${childOrder.imgSrc!}" data-title="${childOrder.title!}" data-goodsNo="${childOrder.goodsNo!}" data-price="<#if childOrder.newTbPrice??>${childOrder.newTbPrice!}<#else>${childOrder.oldTbPrice!}</#if>" data-tbId="${childOrder.numiid!}">
            <a href="javascript:;" class="imgBox fl">
                <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="80" height="80">
            </a>
            <div class="goodsInfo fl">
                <a href="javascript:;" title="${childOrder.title!}">${childOrder.title!}</a>
                <p class="fc9" title="颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}">颜色：${childOrder.color!}&nbsp;&nbsp;&nbsp;&nbsp;尺码：${childOrder.size!}</p>
                <#if childOrder.goodsNo??>
                <p class="goodsNoShow" title="已关联货号：${childOrder.goodsNo!}">已关联货号：${childOrder.goodsNo!}</p>
                <p class="goodsGlBtn">

<#assign text>{}</#assign>
<#assign moduledata17=text?eval />
<#list [moduledata17] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-white-o
         glBtn"
    
        jbtn="glWindowBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        重新关联
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
                <#else>
                <p class="goodsNoShow" title="">已关联货号：<em class="fcF40">暂未关联</em></p>
                <p class="goodsGlBtn">

<#assign text>{}</#assign>
<#assign moduledata18=text?eval />
<#list [moduledata18] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange-o
         toGlBtn"
    
        jbtn="glWindowBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        暂未关联
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</p>
                </#if>
            </div>
        </li>
        <li class="tbPrice yahei borderBot">
            <p class="<#if childOrder.newTbPrice??>oldTbPrice</#if>">&yen;${childOrder.oldTbPrice!}</p> 
            <#if childOrder.newTbPrice??>
            <p class="fs14">&yen; ${childOrder.newTbPrice!}<i class="editIcon"></i></p> 
            </#if>
        </li>
        <li class="xzPrice yahei borderBot">
            <#if childOrder.xzPrice??>
            <p class="fs14">&yen; ${childOrder.xzPrice!}</p>
            <#else>
            <p class="fs12 fcF40">暂未关联</p>
            </#if>
        </li>
        <li class="num fs14 borderBot">${childOrder.num!}</li>
        <li class="profits fcF40 fs16 borderLe">
            <#if childOrder_index == 0>
            ${order.profits!}
            </#if>
        </li>
        <li class="opera borderLe">
            <#if childOrder_index == 0>
                <#if order.canOrder == true>
                

<#assign text>{}</#assign>
<#assign moduledata19=text?eval />
<#list [moduledata19] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
         toOrder"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        立即下单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

                <#else>
                

<#assign text>{}</#assign>
<#assign moduledata20=text?eval />
<#list [moduledata20] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
        
         notOrder"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        立即下单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

                </#if>
            </#if>
        </li>
    </ul>
</div>






            </#list>
        </div>
        <div class="receAddress">
            ${order.address!}
        </div>
    </div>
</div>




            </#list>
        <#else>
            <p class="tac fs20 fc6">暂无数据</p>
        </#if>
    </div>
</div>










































































    

<#assign text>{}</#assign>
<#assign moduledata21=text?eval />
<#list [moduledata21] as $it>

<div class="jqPagination " id="orderPagination" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>







</#list>

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




