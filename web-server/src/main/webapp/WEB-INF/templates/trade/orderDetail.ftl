<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>订单详情 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">




    
    <link href="http://style.571xz.com/v2/order/css/orderDetail.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/order/js/orderDetail.js"></script>
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









<div class="headerOrange">
    <div class="layout">
        <a href="http://www.571xz.com" class="fl">
            <img src="http://style.571xz.com/v2/xz/css/img/whiteLogo.png" width="168" height="28" />
        </a>
        <ul class="fl fs16 yahei">
            <li><a href="#">首页</a></li>
            <li><a href="#">账号管理</a></li>
        </ul>
    </div>
</div>



<div class="minHeight">
<div class="currentPage layout">
    <label class="fc9">当前位置：</label>
    <a href="#" target="_blank">首页</a> &gt;
    <a href="#" target="_blank">我的星座网</a> &gt;
    
    <span class="fcF40">我的订单</span>
</div> 

<div class="orderStatus layout fs3 clearfix">
    <#if orderStateNum == 4>
    <ul class="title cancel">
        <li>提交订单</li>
        <li class="fc9">交易取消</li>
    </ul>
    <ul class="status cancel">
        <li class="current"><i></i><span>1</span></li>
        <li class="current"><i></i><span>2</span></li>
    </ul>
    <#else>
    <ul class="title">
        
        <li  class="current" >提交订单</li>
        
        <li >买家付款</li>
        
        <li >商品配货</li>
        
        <li >交易完成</li>
        
    </ul>
    <ul class="status">
        
        <li  class="current"><i></i><span>1</span></li>
        
        <li ><i></i><span>2</span></li>
        
        <li ><i></i><span>3</span></li>
        
        <li ><i></i><span>4</span></li>
        
    </ul>
    </#if>
    <ul class="time fs14 arail <#if orderStateNum == 4> cancel </#if>">
        <#list orderStateTime as time>
        <li>${time!}</li>
        </#list>
    </ul>
</div>



<div class="orderInfo layout">
    <div class="infoBox fl fc6">
        <ul>
            <li>
                <label>订单编号：</label>
                <p class="fs14 arail">${orderId!}</p>
            </li>
            <li>
                <label>成交时间：</label>
                <p class="fs14 arail">${orderDealTime!}</p>
            </li>
            <li>
                <label>收货人信息：</label>
                <p>${orderAddrInfo.name!},${orderAddrInfo.phone!},${orderAddrInfo.address!}</p>
            </li>
        </ul>
    </div>
    <#if orderStateNum == 0>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已提交，等待买家付款！</div>
        <p><i></i>您还有
        <span class="fcF40">
            

<#assign text>{"nowTime":"${(nowTime!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}","endTime":"${(endTime!(''))?replace('\\', '\\\\')?replace('\"','\\\"')}"}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>
<span id="countdown1" class="xzCountdown" data-format="%dd天%hh小时%mm分%ss秒" data-nowTime="${$it.nowTime!}" data-endTime="${$it.endTime!}"></span>




</#list>

        </span>
        未支付，72小时候自动取消订单</p>
        <div class="goto">
            您可以

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    <a href="payMode.htm"
        


    class="fmButton
         fmButton-sm
         fmButton-orange
        "
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        立即支付
    


    </a>






</#list>

            <b class="cancel" id="cancelOrderBtn">取消订单</b>
        </div>
    </div>
    <#elseif orderStateNum == 1>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：等待配货</div>
    </div>
    <#elseif orderStateNum == 2>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已发货</div>
        <p><i></i><span class="fc6">${express.name!}</span> <span class="fc3 fs14 arail vm">${express.id!}</span></p>
        <div class="expressInfo">
        <#list express.detail as express>
            <#if express_item lt 2>
            <p class="nodot"><span class="fc3 fs14 arail vm">${express.date!}  ${express.time!}</span> ${express.desc!}</p>
            </#if>
        </#list>
        </div>
        <p class="nodot"><a href="expressDetail.htm" target="_blank">查看详情</a></p>
    </div>
    <#elseif orderStateNum == 3>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：交易完成</div>
    </div>
    <#elseif orderStateNum == 4>
    <div class="orderStatusInfo fl">
        <div class="orderCurrentStatus yahei fwb fs14"><span></span>订单当前状态：订单已取消</div>
    </div>
    </#if>
</div>


<script>
var orderId = '${orderId!}'
</script>

























<script >
$(function(){
    //倒计时初始化
    $xz.countdown('#countdown1', function(e){
        if(e.time.remain <= 0){
            e.$container.html('倒计时结束');
        }
    });   
    
    //取消订单
    $('#cancelOrderBtn').on('click', function(){
        $$.window.open($rtpl(function(){/*
            <div class="msgbox fs14">您是否取消此订单？</div>
            <div class="buttonbox">
                <b jbtn="jqWindow.submit" class="ok">确定</b>
                <b jbtn="jqWindow.close" class="close">取消</b>
            </div>
        */}), {
            title: '取消订单',
            clsName: 'windowStyle',
            onsubmit: function(){
                $$.post('cancelOrder.json', function(resp){
                    if(resp.err){
                        $$.alert(resp.err);
                    }else{
                        location.reload();
                    }
                }, {
                    orderId: orderId
                }, {loaddingType:-1, loaddingText:'正在取消订单,请稍后…'});
               
            }
        });
    });
});
</script>








<div class="orderGoodsInfo layout">
    <div class="goodsInfoHead">
        <ul>
            <li class="goodsDesc">商品</li>
            <li class="goodsAttrs">属性</li>
            <li class="goodsCount">数量</li>
            <li class="goodsPrice">价格</li>
            <li class="goodsStatus">订单状态</li>
        </ul>
    </div>
    <div class="goodsList clearfix">
        <#list list.childOrders as childOrder>
        <ul>
            <li class="goodsDesc">
                <a href="http://${webSite!}.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank" class="fl"><img src="${childOrder.imgsrc!}"></a>
                <div class="goodsTitle pr fl">
                    <h4><a href="http://${webSite!}.571xz.com/item.htm?id=${childOrder.goodsid!}" target="_blank">${childOrder.title!}</a></h4>
                    <p class="marketCode fwb pa">商品货号：${childOrder.goodsCode!}</p>
                </div>
            </li>
            <li class="goodsAttrs fwb fc3">${childOrder.color!} ${childOrder.size!}</li>
            <li class="goodsCount fs14"><span class="yahei fwb">${childOrder.num!}</span></li>
            <li class="goodsPrice fs14 yahei">&yen; <span class="fwb">${childOrder.price!}</span></li>
            <li class="goodsStatus">
                <#if childOrder.status == 0>
                    <span class="fcF40">待付款</span>
                <#elseif childOrder.status == 1>
                    <span>已付款</span>
                <#elseif childOrder.status == 2>
                    <#if childOrder.shState == 0>
                    <span>已发货</span>
                    <#elseif childOrder.shState == 1>
                    <span>售后处理中</span>
                    <#elseif childOrder.shState == 2>
                    <span class="fcBlue">退款成功
                        <#if childOrder.tkNum gt 0> x${childOrder.tkNum!} </#if>
                    </span>
                    <#elseif childOrder.shState == 3>
                    <span class="fcBlue">换货成功</span>
                    </#if>
                <#elseif childOrder.status == 3>
                    <span>交易完成</span>
                    <#if childOrder.shState == 1>
                    <br><span class="fcBlue">售后处理中</span>
                    <#elseif childOrder.shState == 2>
                    <br><a class="fcBlue">退款成功
                        <#if childOrder.tkNum gt 0> x${childOrder.tkNum!} </#if>
                    </span>
                    <#elseif childOrder.shState == 3><br>
                    <span class="fcBlue">换货成功</span>
                    </#if>
                <#elseif childOrder.status == 4>
                    <span>交易已取消</span>
                </#if>
            </li>
        </ul>
        </#list>
    </div>
    <div class="goodsTotal clearfix">
        <label>运费总计：</label><span class="yahei fs14">&yen;<em class="fwb">${total.expressPrice!}</em></span><br>
        <label>服务费总计：</label><span class="yahei fs14">&yen;<em class="fwb">${total.servicePrice!}</em></span><br>
        <label>商品总金额：</label><span class="yahei fs14">&yen;<em class="fwb">${total.childOrdersPrice!}</em></span>
        <p>
            <#if orderStateNum == 0>
                <label>待付款总金额：</label>
            <#else>
                <label>已付款总金额：</label>
            </#if>
            <span class="yahei fs14 fcF40">&yen;<em class="fwb">${total.orderTotalPrice!}</em></span>
        </p>
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
            <a href="http://py.571xz.com" target="_blank">濮院站</a>
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







