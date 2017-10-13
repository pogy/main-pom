<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>财务统计 - 星帮后台管理 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/dfgl/css/financialStatistic.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
    <script src="http://style.571xz.com/v2/dfgl/js/financialStatistic.js"></script>
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
                        
                        <a href="parcelSweepCode.htm"><i></i>包裹扫码</a>
                        
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
                        
                        <a  class="current" href="financialStatistic.htm"><i></i>财务统计</a>
                        
                    </li>
                    
                </ul>
                
            </li>
        
    </ul>
</div>




    </div>
    <div class="contentBox">
        <div class="orderSearch orderSearchBox">
    <ul>
        <li><label>日期查询：</label><input type="text" class="jqDatepicker fmInput" data-format="%Y-%M-%D" name="time" placeholder="请选择时间" <#if query.time??> value="${query.time!}" </#if>></li>
        <li>

<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-blue
         searchBtn"
    
        jbtn="searchBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        搜索
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>
</li>
    </ul>
</div>













<#assign text>{"fields":[{"name":"time","value":"${query.time!}"}]}</#assign>
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





<div class="financialList">
    <h3 class="fs20 fc3">今日所需费用 <span class="fs12 fc6">${query.time!}</span></h3>
    <ul class="clearfix">
        <li>
            <p class="fcF40 fs20">${orderStatistics.daifaNeedFee!}</p>
            <p class="fc6">今日代发所需费用总额（元）</p>
        </li>
        <li>
            <p class="fcF40 fs20">${orderStatistics.getGoodsFee!}</p>
            <p class="fc6">今日商品拿货所需总额（元）</p>
        </li>
        <li>
            <p class="fcF40 fs20">${orderStatistics.notYetGoodsFee!}</p>
            <p class="fc6">今日未拿到货物货款总额（元）</p>
        </li>
        <li>
            <p class="fcF40 fs20">${orderStatistics.daifaServerFee!}</p>
            <p class="fc6">今日代发服务费总额（元）</p>
        </li>
        <li>
            <p class="fcF40 fs20">${orderStatistics.shipmentsFee!}</p>
            <p class="fc6">今日发货快递费总额（元）</p>
        </li>
        <li>
            <p class="fcF40 fs20">${orderStatistics.refundFee!}</p>
            <p class="fc6">今日退款总额（元）</p>
        </li>
    </ul>
</div>




    </div>
</div>
<!--省略end，让浏览器自动添加-->




