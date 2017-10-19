<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>包裹查询 - 星帮后台管理 - 四季星座网</title>
<#include "/common/host_config.ftl">
    <link href="http://style.571xz.com/v2/dfgl/css/parcelSearch.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/v2/dfgl/js/parcelSearch.js"></script>
    <script src="${daifa_host!}js/daifa/menudeal/menu.js"></script>
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
            <input id="menus" type="hidden" value="${menu}"/>
    </div>
</div>

<div class="mainContent">
    <div class="sideBarBox">
    <#include "/common/menu_daifa.ftl">
    </div>
    <div class="contentBox">
        <div class="statistics yahei fc9">
    <ul>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.allPackbagNum!}</span>
            <p>全部包裹数量（个）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.matchedPackbagNum!}</span>
            <p>已匹配订单数量（个）</p>
        </li>
        <li>
            <span class="fs20 arail fc3">${orderStatistics.unmatchPackbagNum!}</span>
            <p>未匹配订单数量（个）</p>
        </li>
    </ul>
</div>

<div class="orderSearch">
    <ul class="orderSearchBox">
        <li><label>快递单号：</label><input type="text" class="fmInput" name="postCode" <#if query.postCode??> value="${query.postCode!}" </#if> ></li>
        <li><label>发货人手机：</label><input type="text" class="fmInput" name="telphone" <#if query.telphone??> value="${query.telphone!}" </#if>></li>
        <li>
            <label>匹配状态：</label>
            <select class="fmInput" name="matchState">
                <option>请选择匹配状态</option>
                <option value="1" <#if query.matchState == "1">selected</#if>>已匹配订单</option>
                <option value="0" <#if query.matchState == "0">selected</#if>>未匹配订单</option>
            </select>
        </li>
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

<#assign text>{"fields":[{"name":"postCode","value":"${query.postCode!}"},{"name":"telphone","value":"${query.telphone!}"},{"name":"matchState","value":"${query.matchState!}"},{"name":"page","value":"${query.page!}"}]}</#assign>
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

<div class="postCon">
    <div class="theadCon">
        <ul class="">
            <li class="postName">快递名称</li>
            <li class="postCode">快递单号</li>
            <li class="telphone">发货人手机号码</li>
            <li class="matchState">匹配状态</li>
            <li class="time">时间</li>
            <li class="ope">操作</li>
            <li class="remark">备注</li>
        </ul>
    </div>
    <#list postList as post>
    <div class="postItem" data-id="${post.packageId!}">
        <ul class="childPostItem">
            <li class="postName">${post.postName!}</li>
            <li class="postCode">${post.postCode!}</li>
            <li class="telphone">${post.telephone!}</li>
            <li class="matchState">
                <#if post.isMatchingOrder == true>
                <p>已匹配订单</p>
                <#else>
                <p class="fcF40">未匹配</p>
                </#if>
            </li>
            <li class="time">${post.matchingTime!}</li>
            <li class="ope">
                <#if post.isMatchingOrder == true>
                <b jbtn="readDetail" class="readDetail fcBlue">查看详情</b>
                <#else>
                <p>——</p>
                </#if>
            </li>
            <li class="remark">
                <div class="packageRemark pr">
                    <i class="icon-s-message iconfont <#if post.packageRemark??>haveRemark</#if>"></i>
                    <div class="remarkCon pa">
                        <p>${post.packageRemark}</p>
                        <p><b class="addPackageRemark" jbtn="addPackageRemark">添加备注</b></p>
                    </div>
                </div>
            </li>
            <div class="packbagAllOrder">
                <table>
                <#list post.orders as order>
                <tbody class="orderItem" data-id="${order.orderId!}">
                    <tr class="orderItemHead">
                        <td class="leftConBox" colspan="2">
                            <span>订单编号：${order.orderId!}</span>
                            <span>时间：${order.afterSaleTime!}</span>
                        </td>
                        <td class="buyerInfo" colspan="2">
                            <span>下单人：${order.imTel!}<#if order.imWw??><a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${order.imWw!}&siteid=cntaobao&status=1&charset=utf-8"><img border="0" src="http://style.571xz.com/v2/xz/css/img/aliww.png" alt="点击这里给我发消息" /></a></#if><#if order.imQq??><a href="http://wpa.qq.com/msgrd?v=3&uin=${order.imQq!}&site=qq&menu=yes" target="_blank"><img src="http://style.571xz.com/v2/xz/css/img/imqq.png" alt=""></a></#if></span>
                        </td>
                        <td class="rightConBox" colspan="4">
                            <span class="fr">总费用：${order.totalFee!}（含快递：${order.expressFee!}，服务费：${order.serversFee!}，减免：${order.discountFee!}）</span>
                            <div class="pr fr buyerRemark">
                                <i class="icon-s-message iconfont haveRemark"></i>
                                <div class="remarkCon">
                                    ${order.buyerRemark}
                                </div>
                            </div>
                            <div class="fr pr receiverAddress">
                                <span class="">${order.receiverName!}（${order.receiverPhone!}）</span>
                                <div class="pa addressCon">${order.receiverName!},${order.receiverPhone!},${order.receiverAddress!}</div>
                            </div>
                        </td>
                    </tr>
                    <#list order.afterSales as afterSale>
                    <#list afterSale.childOrders as childOrder>
                    <tr class="childOrderItem" data-id="${childOrder.childOrderId!}">
    <td class="childOrderId" valign="top">${childOrder.childOrderId!}</td>
    <td class="goodsInfo" valign="top">
        <div class="fl imgBox">
            <img src="${childOrder.imgSrc!}_80x80.jpg" alt width="54" height="54">
        </div>
        <p class="title">${childOrder.title!}</p>
        <p>商品属性：${childOrder.goodsProperty!}</p>
        <p>商家编码：${childOrder.storeGoodsCode!}</p>
    </td>
    <td class="price" valign="top">
        <p>批价：${childOrder.piPrice!}</p>
        <#if childOrder.payPrice??>
        <p>实价：${childOrder.payPrice!}</p>
        <#else>
        <p>实价：——</p>
        </#if>
    </td>
    <td class="goodsNum" valign="top">${childOrder.num!}</td>
    <td class="otherFee" valign="top">
        <p>服务费：${childOrder.childServersFee!}</p>
    </td>  
    <#if childOrder_index == 0>
    <td class="orderState" valign="top" rowspan="${(afterSale.childOrders?size)!}">
        <#if afterSale.afterSaleState == 5>
        <p>退货已收到</p>
        <#elseif afterSale.afterSaleState == 25>
        <p>换货已收到</p>
        </#if>
    </td>
    
    <td class="orderOpe" valign="top" rowspan="${(afterSale.childOrders?size)!}">
        <#if (afterSale.putInStorageState?size) gt 0>
        <#list afterSale.putInStorageState as sto>
            <#if sto.type == 1>
            <p>商品已入库x${sto.storageNum!}</p>
            <#elseif sto.type == 2>
            <p>退货失败入库x${sto.storageNum!}</p>
            </#if>
        </#list>
        </#if>
        
        <#if afterSale.refundState == 1>
        <p>档口已退款</p>
        <p class="fcF40">
            <div class="pr moneyBox fcF40">
                ${afterSale.refundForShop!}
                <#if afterSale.refundFeeType == 1>
                <span class="spanIcon editIcon">改</span>
                <#elseif afterSale.refundFeeType == 2>
                <span class="spanIcon">拒</span>
                </#if>
                <div class="editInfo pa">
                    <#list afterSale.editInfo as info>
                    <p>${info!}</p>
                    </#list>
                </div>
            </div>
        </p>
        <p><b class="fcBlue editBtn" jbtn="editBtn">修改</b></p>
        <#elseif afterSale.refundState == 2>
        <p class="fcG">已退款</p>
        <p class="fcF40">${afterSale.refundForShop!}</p>
        </#if>
    </td>
    </#if>
    <#if childOrder_index == 0 && afterSale_index == 0>
    <td class="tradeState" valign="top" rowspan="${order.childOrderNum!}">
        <div class="childOrderRemark pr">
            <p class="childRemark">${order.allChildRemark}</p>
            <p><b class="addOrderRemark" jbtn="addOrderRemark">添加备注</b></p>
        </div>
    </td>
    </#if>
</tr>

                    </#list>
                    </#list>
                </tbody>
                </#list>
                </table>
            </div>
        </ul>
    </div>
    </#list>
    
</div>
    

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

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