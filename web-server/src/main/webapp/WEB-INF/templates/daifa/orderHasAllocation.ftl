<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title></title>

    
    
    
    
    
    <link href="http://style.571xz.com/v2/dfgl/css/orderHasAllocation.css" rel="stylesheet">
    

    

    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/orderHasAllocation.js"></script>
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
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
        <div class="sidebar fl yahei">
    <ul>
        <li><a href="#"><i class="icon-allorders"></i>全部订单</a></li>
        <li class="current">
            <a href="javascript:;"><i class="icon-allocation"></i>订单分配</a>
            <ul>
                <li class="current"><a href="#"><i></i>任务分配</a></li>
                <li><a href="#"><i></i>我的任务</a></li>
                <li><a href="#"><i></i>扫描打印</a></li>
            </ul>
        </li>
    </ul>
</div>


    </div>
    <div class="contentBox">
        
    </div>
</div>
<!--省略end，让浏览器自动添加-->


