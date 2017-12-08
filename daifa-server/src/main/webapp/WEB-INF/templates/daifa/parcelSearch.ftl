<#assign $pageid>parcelSearch</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>包裹查询 - 星帮后台管理 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/daifa__common_css.ftl">
<#include "/__style_torrent__/daifa__parcelSearch_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/daifa__common_js.ftl">
<#include "/__style_torrent__/daifa__parcelSearch_js.ftl">
</head>
<body>
<#include "/__ftl_links__/daifa__common__header.ftl">
<div class="mainContent">
    <div class="sideBarBox">
<#include "/__ftl_links__/daifa__common__sidebar.ftl">
    </div>
    <div class="contentBox">
<#assign text>{"fields":[{"name":"postCode","value":""+query.postCode},{"name":"telphone","value":""+query.telphone},{"name":"matchState","value":""+query.matchState}]}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
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
                <option value="">请选择匹配状态</option>
                <option value="1" <#if query.matchState == "1">selected</#if>>已匹配订单</option>
                <option value="2" <#if query.matchState == "2">selected</#if>>未匹配订单</option>
            </select>
        </li>
        <li>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
         searchBtn"
        jbtn="searchBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
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
    </button>
    </#if>
</#list></li>
    </ul>
</div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
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
                            <span>下单人：${order.imTel!}
<#assign text>{"id":order.imWw}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.id != ''>
<a class="imAliww" href="https://amos.alicdn.com/getcid.aw?v=3&groupid=0&s=1&charset=utf-8&site=cntaobao&groupid=0&s=1&uid=${$it.id!}" target="_blank"></a>
</#if>
</#list>
<#assign text>{"id":order.imQq}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.id != ''>
<a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
</#if>
</#list></span>
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
        <p><b class="fcBlue editBtn" jbtn="editBtn" data-id="${afterSale.refundId!}">修改</b></p>
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
            <p><b class="addOrderRemark" jbtn="addCustomerServiceRemark" data-orderid="${order.orderId!}">添加备注</b></p>
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
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<div class="jqPagination " id="jqPagination0"
    <#if $it.pageOption??>
        data-option="${$it.pageOption!}"
    <#else>
        data-option="${pageOption!}"
    </#if>
></div>
<#assign text>{}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#if $it.fields??>
<form id="wgt_search">
    <#list $it.fields as field>
    <input type=hidden name="${field.name!}" value="${field.value!}">
    </#list>
</form>
</#if>
</#list>
</#list>
    </div>
</div>