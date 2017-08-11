<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title></title>

    
    
    
    
    
    <link href="http://style.571xz.com/v2/dfgl/css/scanBarCode.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/scanBarCode.js"></script>
</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if (userIcon?size) gt 0>
        <img src="${userIcon!}">
        <#else>
        <img src="${$stylepath!}${$projectid!}/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="#" class="fcF40 fs16">退出</a>
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
                
                <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>
                
                
                <ul>
                    
                    <li>
                        
                        <a href="orderAllocation.htm"><i></i>任务分配</a>
                        
                    </li>
                    
                    <li>
                        
                        <a href="orderHasAllocation.htm"><i></i>我的任务</a>
                        
                    </li>
                    
                    <li>
                        
                        <a class="current" href="scanBarCode.htm"><i></i>扫描打印</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
    </ul>
</div>




    </div>
    <div class="contentBox">
        <div class="scanContainer fs14 yahei">
    <div class="scanInput">
        <label>条形码：</label><input type="text" class="fmInput fmInput-lg fs14 yahei" name="barCode" placeholder="扫描或者输入标签条形码">
    </div>
    <div class="scanResult">
        <ul>
            <li><label>条码信息：</label><span class="fs20 arail barCodeNum"><!--34678923578923457--></span></li>
            <li><label>商品信息：</label><span class="goodsProp"><!--DSJD_A209_K0975678 黑色 XXL--></span></li>
            <li><label>扫码结果：</label><span class="msg"><!--订单全部已拿到货，快递单打印失败（申通快递，没有快递单号了）--></span></li>
        </ul>
    </div>    
</div>
























    </div>
</div>
<!--省略end，让浏览器自动添加-->




