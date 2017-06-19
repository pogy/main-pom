<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title></title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/order/css/confirmOrder.css" rel="stylesheet">
    

    



    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/order/js/confirmOrder.js"></script>
</head>
<body>
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
                
                
                <#if !session_user_redis__ ||  !session_user_redis__.logshop > 
                <li class="noDown">
                    <a href="${main_host!}carts.htm">
                        <i class="cgcatIcon"></i>
                        <span>购物车</span>
                        
                        
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
                                <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                
                <#if !session_user_redis__ || session_user_redis__.logshop?? > 
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











<script>
var webSite = '${webSite!}';
</script>












<div class="header layout">
    <div class="logoLeft fl">
        <a href="http://www.571xz.com">
            <img src="http://style.571xz.com/v2/xz/css/img/mtLogo.png" width="168" height="30" />
        </a>
        <em class="yahei">结算页</em>
    </div>
    <div class="statusRight fr">
        <div class="stTitle clearfix">
            <ul>
                
                <li class="pr cgState">
                    <h5>1、确认商品</h5>
                    <span class="pa"></span>
                </li>
                
                <li class="pr cgState">
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






<div class="main layout">
    <h3 class="infoTitle fs16 yahei">填写并核对订单信息</h3>
    <div class="orderInfoWrite">
        

<#assign text>{"choiceCon":[{"text":"星帮代发","value":"xbdf","checked":true},{"text":"星帮代拿","value":"xbdn"}]}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="portCommonBox marBottom deliMethod">
    <h3 class="fs14 yahei">
        发货方式
        
            <span>星帮代发是指从档口帮您拿到货物并且打包，送货到物流公司！</span>
        
    </h3>
    
    <div class="choiceBox clearfix">
        <ul>
            <#list $it.choiceCon as option>
            
            

<#assign text>{"value":option.value,"text":option.text,"checked":option.checked}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<label class="fmRadio clearfix
    
        <#if $it.checked??>
            checked
        </#if>
    
    
        buttonRadio
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="deliMethod"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i>
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    </span>
</label>




</#list>

            </#list>
        </ul>
    </div>
</div>



</#list>


        
        <div class="consigneeInfo commonCss clearfix">
    <h3 class="fs14 yahei">
        收货人信息 
    </h3>
    <div class="writeConsignee clearfix" <#if tbOrderAddressInfo??>style="display:none"</#if>>
        <div class="parsing">
            <div class="parseAddress clearfix">
                <label class="fl">解析地址：</label>
                <input class="fl" type="text" name="orignAddress" placeholder="淘宝订单详情页中的地址信息黏贴到此处">
                <b class="fl" jbtn="parseBtn">一键解析</b>
            </div>
            <div class="parseFormBox">
                <ul>
                    <li class="framBox">
                        <div class="provAndCity congineeBox">
                            <label><span class="fcF40 required">*</span>所在地区：</label>
                            

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>
<div data-id="myArea" 
    class="fmCitypick" data-value="${$it.value!}">
</div>




</#list>


                        </div>
                    </li>
                    <li class="framBox">
                        <div class="detailAddress congineeBox">
                            <label><span class="fcF40 required">*</span>详细地址：</label>
                            <input type="text" name="detailAddress" placeholder="请填写准确详细的收货地址，例如街道名称，门牌号，楼层和房间号等信息" >
                        </div>
                    </li>
                    <li class="framBox">
                        <div class="congineeName congineeBox">
                            <label><span class="fcF40 required">*</span>收货人：</label>
                            <input type="text" name="congineeName" placeholder="长度不超过25个字符" maxlength="25">
                        </div>
                    </li>
                    <li class="congineeBox framBox">
                        <div class="clearfix phone">
                            <div class="mobile fl">
                                <label>手机号码：</label>
                                <input type="text" name="mobile" placeholder="手机号码、电话号码必须填写一项" maxlength="11">
                            </div>
                            <div class="telePhone fl">
                                <label>电话号码：</label>
                                <input type="text" name="telePhone" placeholder="手机号码、电话号码必须填写一项">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="qrAndColBtn">
                

<#assign text>{}</#assign>
<#assign moduledata3=text?eval />
<#list [moduledata3] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
         qrBtn
    "
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="submitPostAddress"
    
>

    
        确认
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






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
        
         fmButton-lighter-o
         collBtn
    "
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="savePostAddress"
    
>

    
        确认并收藏
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






</#list>

                <span class="lgErrorTip fcF40">地址最多可收藏5个！</span>
            </div>
        </div>
        <div class="collectCgnee simsun fl">
            <h5>收藏地址列表 <span class="fcF40 surAmount">(${(collList?size)!}/5)</span> <em class="fc9">您可使用收藏的地址</em></h5>
            <ul>
                <#list collList as coll>
                <li class="pr" data-json="${coll.name!},${coll.phone!},${coll.address!}">
                    

<#assign text>{"text":"${coll.name!},${coll.phone!},${coll.address!}"}</#assign>
<#assign moduledata5=text?eval />
<#list [moduledata5] as $it>
<label class="fmRadio clearfix
    
        <#if $it.checked??>
            checked
        </#if>
    
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="collAdress"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i>
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    </span>
</label>




</#list>

                    <b class="deleteColl pa" jbtn="deleteCollBtn" data-id="${coll.id!}">删除</b>
                </li>
                </#list>
            </ul>
        </div>
    </div>
    
    <input id="postProv" <#if tbOrderAddressInfo??>value="${tbOrderAddressInfo.prov!}"</#if> type="hidden"> 
    <div class="sureConsignee clearfix" <#if !tbOrderAddressInfo>style="display:none"</#if>>
    <div class="simuCheckBox select"><#if tbOrderAddressInfo??>${tbOrderAddressInfo.name!}</#if></div>
    <div id="fullAreaText" class="fl congineeText">
        <#if tbOrderAddressInfo??>
            ${tbOrderAddressInfo.address!}
        </#if>
    </div>
    <b class="alterAddress" jbtn="alterAddress">更改地址</b>
</div>
<input type="hidden" id="fullAreaInput" name="fullAreaInput" <#if tbOrderAddressInfo??>value="${tbOrderAddressInfo.address!}"</#if>>




</div>

































        
        
        <input type="hidden" id="updatePostPrice">

<script>
var postRulers = ${postRulers!};
</script>




        

<#assign text>{"choiceCon":postInfo}</#assign>
<#assign moduledata6=text?eval />
<#list [moduledata6] as $it>
<div class="portCommonBox marBottom courierName">
    <h3 class="fs14 yahei">
        快递名称
        
    </h3>
    
    <div class="choiceBox clearfix">
        <ul>
            <#list $it.choiceCon as option>
            
            

<#assign text>{"value":option.value,"text":option.text,"checked":option.checked}</#assign>
<#assign moduledata7=text?eval />
<#list [moduledata7] as $it>
<label class="fmRadio clearfix
    
        <#if $it.checked??>
            checked
        </#if>
    
    
        buttonRadio
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="courierName"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i>
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    </span>
</label>




</#list>

            </#list>
        </ul>
    </div>
</div>



</#list>


        
        

<#assign text>{"choiceCon":[{"text":"有货先发","value":"yhxf","checked":true},{"text":"缺货不发","value":"qhbf"}]}</#assign>
<#assign moduledata8=text?eval />
<#list [moduledata8] as $it>
<div class="portCommonBox marBottom shipOption">
    <h3 class="fs14 yahei">
        发货选择
        
            <span>有货先发是指3日内采购到的货物先发货，剩余货物自动退款！</span>
        
    </h3>
    
    <div class="choiceBox clearfix">
        <ul>
            <#list $it.choiceCon as option>
            
            

<#assign text>{"value":option.value,"text":option.text,"checked":option.checked}</#assign>
<#assign moduledata9=text?eval />
<#list [moduledata9] as $it>
<label class="fmRadio clearfix
    
        <#if $it.checked??>
            checked
        </#if>
    
    
        buttonRadio
    
">
    <input 
        type="radio"
        autocomplete="off"
        
            name="shipOption"
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            </#if>
        
        
        
            <#if $it.checked??>
                checked
            </#if>
        
    >
    <i class="before"></i>
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    </span>
</label>




</#list>

            </#list>
        </ul>
    </div>
</div>



</#list>


        
        <div class="orderGoods">
    <h3 class="fs14 yahei orderBoxTitle">商品清单 <a href="#">返回进货车</a></h3>
    <div class="orderDetail clearfix">
    <div class="listHeader clearfix">
        <ul>
            <li class="goodsTitle tac">商品</li>
            <li class="goodsPrice tac">单价</li>
            <li class="goodsAttr">属性</li>
            <li class="goodsCount tac">数量</li>
            <li class="postFee tac">快递费用</li>
            <li class="serverFee tac">服务费用</li>
        </ul>
    </div>
    <div class="orderAllInfo fl" data-post="${list.postPrice!}" data-firstPost="${list.postCost!}">
        <#list list.orders as order>
        <div class="orderItemInfo fl" data-id="${order.id!}">
            <div class="orderInfo clearfix">
                <span class="orderStore">档口：${order.marketName!}  ${order.storeNum!}</span>
                

<#assign text>{"id":order.imQq}</#assign>
<#assign moduledata10=text?eval />
<#list [moduledata10] as $it>
<#if $it.id != "">
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>

</#list>
 
                

<#assign text>{"id":order.imWw}</#assign>
<#assign moduledata11=text?eval />
<#list [moduledata11] as $it>
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>

</#list>

            </div>
            <div class="shopGoodsList clearfix">
                <#list order.childOrders as childOrder>
                <ul class="orderItem" 
    data-id="${childOrder.id!}" 
    data-price="${childOrder.price!}"
    data-weight="${childOrder.weight!}"
>
    <li class="goodsTitle clearfix">
        <a href="javascript:;" class="fl imgBox"><img src="${childOrder.imgsrc!}_70x70.jpg" width=62 height=62 class="fl"></a>
        <div class="fl goodsInfo fc3">
            <h4>${childOrder.title!}</h4>
            <p class="fwb">商家编码：${childOrder.goodsCode!}</p>
        </div>
    </li>
    <li class="goodsPrice tac fc3 yahei"><span>&yen;</span><span class="fwb">${childOrder.price!}</span></li>
    <li class="goodsAttr fc9 pr">
        <div class="skuBox" data-colorId="${childOrder.colorId!}" data-sizeId="${childOrder.sizeId!}">
            颜色：${childOrder.colorText!}<br>尺码：${childOrder.sizeText!}
        </div>
    </li>
    <li class="goodsCount tac">
        

<#assign text>{"name":childOrder.id,"value":childOrder.num}</#assign>
<#assign moduledata12=text?eval />
<#list [moduledata12] as $it>

<span class="fmNumberInput">
    <i jbtn="reduce">-</i>
    <input class="textInput" type="text" autocomplete=off 

        
            <#if $it.name??>
                data-name="${$it.name!}"
            <#else>
                data-name="fmNumberInput0"
            </#if>
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
        
        
        
            <#if $it.minValue??>
                minValue="${$it.minValue!}"
            <#else>
                minValue="1"
            </#if>
        
        
        
            <#if $it.maxValue??>
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
        
        
        
            <#if $it.value??>
                value="${$it.value!}"
            <#else>
                value="1"
            </#if>
        
        
   >
    <i jbtn="add">+</i>
</span>








</#list>

    </li>
</ul>


                </#list>
            </div>
            <div class="orderRemark">
                <label>留言：<input type=text placeholder="请输入对本次交易的说明" ></label>
            </div>
        </div>
        </#list>
    </div>
    <div class="orderCost tac fl clearfix">
        <div class="postFee postCost fl">
            &yen;<span class="postCostShow">0.00</span>
        </div>
        <div class="serverFee serverCost fl">
            &yen;<span class="serverCostShow">0.00</span>
            <div class="serverDetail pr">
                <p class="fc9 curPointer">详情<i class="downArrow"></i></p>
                <div class="serverCon pa">
                </div>
            </div>
        </div>
    </div>
</div>






    <div class="orderLastBox">
        <p>
            

<#assign text>{}</#assign>
<#assign moduledata13=text?eval />
<#list [moduledata13] as $it>
<label class="fmCheckbox
    
        <#if $it.checked??>
            checked
        </#if>
    
">
    <input 
        type="checkbox"
        autocomplete="off"
        
            name="agreen"
        
        
        
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
        
    >
    <i class="before"></i> 
    <span>
    
        <#if $it.text??>
            ${$it.text!}
        </#if>
    
    
        同意<a href="#" target="_blank">《档口退换货规则》</a><span class="fcF40">（特别提示：货物是否可退货换是根据档口规则，所以拍下时请咨询档口）</span>
    
    </span>
</label>




</#list>

        </p>
        <p class="tar goodsFee">商品总金额:<em class="fcF40 goodsCostShow">0.00</em>元</p>
    </div>
</div>


    </div>
    <div class="settlement tar">
    <div class="settlementBox">
        <div class="settleInfo">
            <ul>
                <li>
                    <span>运费总计：</span>
                    <em class="fs14 yahei">&yen;<span class="postCostShow">0.00</span></em>
                </li>
                <li>
                    <span>服务费总计：</span>
                    <em class="fs14 yahei">&yen;<span class="serverCostShow">0.00</span></em>
                </li>
                <li>
                    <span>商品金额总计：</span>
                    <em class="fs14 yahei">&yen;<span class="goodsCostShow">0.00</span></em>
                </li>
            </ul>
        </div>
        <div class="corfirmInfo">
            <p>应付总金额：<em class="fcF40 yahei fs20">&yen;</em><span class="fcF40 yahei totalAmount">0.00</span></p>
            <p class="confirmAddress fc9"><span>寄送至：浙江杭州上城望江清江路136号 置地国际电商基地 5楼 （四季星座网办公室）</span><span>收货人：王朝晖15868488816</span></p>
        </div>
    </div>
    <div class="settleBtn clearfix">
        

<#assign text>{}</#assign>
<#assign moduledata14=text?eval />
<#list [moduledata14] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-orange
        
    "
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="submitOrder"
    
>

    
        提交订单
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>






</#list>

        <a href="#" class="backCart">返回进货车</a>
    </div>
</div>




<input type="hidden" id="updateServicePrice">

<script>
var serviceRulers = ${serviceRulers!};
</script>








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

