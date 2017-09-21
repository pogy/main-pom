<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>包裹扫码 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/parcelSweepCode.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/parcelSweepCode.js"></script>
</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if userIcon??>
        <img src="${userIcon!}">
        <#else>
        <img src="http://style.571xz.com/v2/dfgl/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="${daifa_host!}init/logout.htm" class="fcF40 fs16">退出</a>
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
        <div class="sidebar fl yahei">
    <ul>
        
            <li>
                
                <a  href="orderAll.htm" ><i class="icon-allorders"></i>全部订单</a>
                
                
            </li>
        
            <li>
                
                <a  href="orderForServer.htm" ><i class="icon-allorders"></i>客服查询</a>
                
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="orderAllocation.htm"><i></i>任务分配</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="orderHasAllocation.htm"><i></i>我的任务</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>发货管理</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="scanBarCode.htm"><i></i>扫描打印</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="hasBeenShipped.htm"><i></i>已发货订单</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="notYetSipped.htm"><i></i>未发货订单</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>售后管理</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="afterSaleOrder.htm"><i></i>售后订单</a>
                        
                    </li>
                    
                    <li>
                        
                        <a  class="current" href="parcelSweepCode.htm"><i></i>包裹扫码</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="afterSaleProcess.htm"><i></i>售后处理</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="parcelSearch.htm"><i></i>包裹查询</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
            <li>
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>财务管理</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="financialStatistic.htm"><i></i>财务统计</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
    </ul>
</div>




    </div>
    <div class="contentBox">
        <div class="scanPost">
    <label>快递单号：</label><input type="text" class="fmInput fmInput-lg fs14 yahei scanPostCode" placeholder="扫描或者输入快递单号">
    <div class="postCon">
        <ul>
            <li><label>快递单号：</label><span class="postCodeCon"><!--1234567890987654--></span></li>
            <li><label>快递名称：</label><span class="postNameCon"><!--申通快递--></span></li>
            <li><label>查询结果：</label><span class="callbackMsg"><!--已查询到此快递单在如下售后订单中，并且已自动标记已收到售后商品--></span></li>
        </ul>
    </div>
    <div class="setWareBox"><b jbtn="setWareBtn" class="setWareBtn">保存包裹信息并入库登记</b></div>
</div>





<div class="orderCon">
    
</div>
    

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

<div class="jqPagination " id="jqPagination0" 
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}" 
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>







</#list>
























































































    </div>
</div>
<!--省略end，让浏览器自动添加-->




