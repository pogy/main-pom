<#assign $pageid="editGoodsInfo">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>编辑宝贝 - 供应商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <link rel=stylesheet href="//style.571xz.com/v6/gys/temp/webuploader/webuploader.css">
<#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/gys__common_css.ftl">
<#include "/__style_torrent__/gys__editGoodsInfo_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="//style.571xz.com/v6/gys/temp/webuploader/webuploader.js"></script>
<script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/gys__editGoodsInfo_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isGys":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/gys__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/gys__common__sidebar.ftl">
</#list>
            <div class="rightBox shadowBox">
<script modulepath="gys/editGoodsInfo#config">
var deschtml = '${goodsInfo.deschtml}';
</script>
<script modulepath="gys/editGoodsInfo#config">
var deschtml = '${goodsInfo.deschtml}';
</script>
<link href="//g.alicdn.com/kissy/k/1.4.7/editor/theme/cool/editor-min.css?1" rel="stylesheet">
<script src="//g.alicdn.com/kissy/k/1.4.7/seed.js" data-config="{combine:true}"></script>
<script src="//style.571xz.com/v6/gys/temp/deonkey.js?v1"></script>
<div class="releaseGoodsBox pr">
<div class="categoryBox">
    <em class="fc6">类目：${cateText!}</em>
    <input id="cateId" value="${cateId!}" type="hidden">
    <input id="goodsId" value="${query.goodsId!}" type="hidden">
</div>
<div class="formInput formTitle">
    <label class="formKey"><i>*</i>宝贝标题：</label>
    <div class="formData">
        <input id="goodsTitle" type="text" value="${goodsInfo.goodsTitle!}" maxlength="60" name="_fma.pu._0.ti" class="input">
        <span class="afterText">0/60</span>
    </div>
    <div class="formData fcF40 errorWarn">不能超过60个字符</div>
</div>
<#if webSite != 'qz'>
<div class="goodsFabric clearfix">
    <label class="formKey"><i>*</i>材料成分：</label>
    <div class="goodsFabricInfoCon clearfix fl">
        <div class="formInput formFabric fl">
            <label class="formKey"><i>*</i>面料成分</label>
            <div class="formData">
                <input id="fabric" type="text" value="${goodsInfo.fabric!}" maxlength="30" placeholder="最多可输入30个字符" name="" class="input">
            </div>
        </div>
        <div class="formInput formInFabric fl">
            <label class="formKey">里料成分</label>
            <div class="formData">
                <input id="inFabric" type="text" value="${goodsInfo.inFabric!}" maxlength="30" placeholder="最多可输入30个字符" name="" class="input">
            </div>
        </div>
    </div>
</div>
</#if>
<div class="formPicks formAttribute">
    <label class="formKey">宝贝属性：</label>
    <div class="formData">
        <p class="tips">填错宝贝属性，可能会引起宝贝下架，影响您的正常销售。请认真准确填写</p>
        <ul class="clearfix">
            <#list goodsInfo.formAttribute as item>
            <li>
                <label class="attrKey"><#if item.need??><i>*</i></#if>${item.name!}</label>
                <div class="attrValue">
                <#if item.formitem.type == 'select'>
                    <select name="${item.formitem.name!}">
                        <option value=""></option>
                        <#list item.formitem.options as option>
                            <option value="${option.value!}" <#if option.selected == true>selected</#if>>${option.text!}</option>
                        </#list>
                    </select>
                <#elseif item.formitem.type == 'checkbox'>
                    <div class="checkboxWrapper">
                    <#list item.formitem.checkboxs as checkbox>
                    <label><input class="checkbox" type="checkbox" name="${checkbox.name!}" value="${checkbox.value!}" <#if checkbox.checked == true>checked</#if>>${checkbox.text!}</label>
                    </#list>
                    </div>
                <#else>
                    <input class="input" name="${item.formitem.name!}" <#if item.name == '货号：'>id="huohao"</#if> type="text" value="${item.formitem.value!}">
                </#if>
                </div>
            </li>
            </#list>
        </ul>
    </div>
</div>
<#list goodsInfo.skuAttribute as item>
<div class="formPicks formSku">
    <label class="formKey">${item.name!}</label>
    <div class="formData">
    <#if item.type == 'colorset'>
        <ul class="skuColor">
            <#list item.formitems as formitem>
            <li <#if formitem.checked == true>class="edit"</#if>>
                <input class="checkbox" id="sku_${formitem.key_!}" type="checkbox" value="${formitem.key!}" name="${formitem.checkboxName!}" data-color="${formitem.color!}" <#if formitem.checked == true>checked</#if>>
                <label class="bgcolor" for="sku_${formitem.key_!}" style="background:${formitem.color!}"></label>
                <label class="bgtext" title="${formitem.cnname!}" for="sku_${formitem.key_!}">${formitem.cnname!}</label>
                <input class="input" type="text" value="${formitem.cnname!}" name="${formitem.inputName!}" maxlength="15">
            </li>
            </#list>
        </ul>
    <#elseif item.type == 'required'>
        <ul class="skuBox">
            <#list item.formitems as formitem>
            <li <#if formitem.checked == true>class="edit"</#if>>
                <input class="checkbox" id="sku_${formitem.key_!}" type="checkbox" value="${formitem.key!}" name="${formitem.checkboxName!}" <#if formitem.checked == true>checked</#if>>
                <label class="bgtext" title="${formitem.cnname!}" for="sku_${formitem.key_!}">${formitem.cnname!}</label>
                <input class="input" type="text" value="${formitem.cnname!}" name="${formitem.inputName!}" maxlength="15">
            </li>
            </#list>
        </ul>
    </#if>
    </div>
</div>
</#list>
<div class="editGoodsSkuDetail formSkuDetail clearfix">
    <label class="formKey"></label>
    <div class="formData">
        <h5 class="fc3">宝贝销售规格：</h5>
        <p class="fc9 tip">该类目下：颜色，尺码，请全选或全不选，如果只选一部分则无法保存对应的价格和库存；库存为0的宝贝规格，在商品详情页不能展示</p>
        <div class="batchSkuBox">
            <div class="batchEdit">
                <label class="fc3">批量填充：</label>
                <input type="text" class="fmInput fmInput-sm pPrice" placeholder="价格">
                <input type="text" class="fmInput fmInput-sm batchEditNum" placeholder="数量">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-sm
         fmButton-blue
         batchBtn"
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
        确定
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
            <div class="skuList">
                <table class="list">
                <thead>
                    <th>颜色</th>
                    <th>尺寸</th>
                    <th><em class="fcF40">*</em>价格(元)</th>
                    <th><em class="fcF40">*</em>数量(件)</th>
                </thead>
                <#list goodsInfo.skuSpecs as sku>
                <tbody data-cpvid="${sku.colorId!}" data-cptext="${sku.colorText!}">
                    <#list sku.sizes as size>
                    <tr>
                        <#if size_index == 0>
                            <td rowspan="${(sku.sizes?size)!}" data-pvid="${sku.colorId!}" data-text="${sku.colorText!}" class="colorSpeces">${sku.colorText!}</td>
                        </#if>
                        <td data-pvid="${size.sizeId!}" data-text="${size.sizeText!}" class="sizeSpeces">${size.sizeText!}</td>
                        <td><input type="text" class="eachSkuPrice" value="${size.price!}"></td>
                        <td><input type="text" class="inventory" value="${size.num!}"></td>
                    </tr>
                    </#list>
                </tbody>
                </#list>
            </table>
            </div>
        </div>
    </div>
</div>
<div class="formPriceAndGoodsNo clearfix">
    <label class="formKey"><i>*</i>批发价与货号：</label>
    <div class="formPriceAGnInfoCon clearfix fl">
        <div class="formInput formInprice fl">
            <label class="formKey"><i>*</i>批发价</label>
            <div class="formData">
                <input id="piPrice" type="text" value="${goodsInfo.piPrice!}" maxlength="12" name="_fma.pu._0.m" class="input">
            </div>
        </div>
        <div class="formInput formCount fl">
            <label class="formKey"><i>*</i>数量</label>
            <div class="formData">
                <input id="quantity" type="text" value="${goodsInfo.quantity!}" maxlength="12" name="_fma.pu._0.q" class="input">
            </div>
        </div>
        <div class="formInput formOid fl">
            <label class="formKey"><i>*</i>商品货号</label>
            <div class="formData">
                <input id="goodsNo" type="text" value="${goodsInfo.goodsNo!}" maxlength="12" name="_fma.pu._0.o" class="input">
            </div>
        </div>
        <div class="formInput formOutprice fl">
            <label class="formKey">电商最低零售价</label>
            <div class="formData">
                <input id="buynow" type="text" value="${goodsInfo.lowestLiPrice!}" maxlength="12" name="_fma.pu._0.m" class="input">
            </div>
        </div>
    </div>
</div>
<div class="formInput formPic">
    <label class="formKey">宝贝图片：</label>
    <div class="formData">
        <p class="tips">图片大小不能超过3M；700*700 以上的图片可以在宝贝详情页主图提供图片放大功能 </p>
        <ul class="clearfix">
            <#if goodsInfo.picPath??>
            <li class="active">
                <i class="iconfont bg icon-plus"></i>
                <span class="mainText"><i>*</i>宝贝主图</span>
                <div class="ctBox">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont tori ght icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    <img src="${goodsInfo.picPath!}" class="showDefaultPic">
                </div>
                <div class="waitgif"></div>
            </li>
            </#if>
            <#list goodsInfo.allimg as img>
            <li>
                <i class="iconfont bg icon-plus"></i>
                <div class="ctBox">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont tori ght icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    <img src="${img!}" class="showDefaultPic">
                </div>
                <div class="waitgif"></div>
            </li>
            </#list>
        </ul>
    </div>
</div>
<div class="moreMainImgUpload">
    <#if webSite == 'qz'>
    <b class="showMoreMainImgWindowBtn">选择要上传的主图</b>
    </#if>
</div>
<div class="formInput formEditor">
    <label class="formKey">宝贝描述：</label>
    <div class="formData">
        <textarea id="J_ItemDescTextarea_newer" name="_fma.pu._0.d" style="width:745px; height:450px;">${goodsInfo.deschtml}</textarea>
    </div>
</div>
<div class="moreImgUpload">
    <b class="showMoreImgWindowBtn">选择要上传的图片</b>
</div>
<div class="form-submit pa">
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-blue
        "
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="dosubmit"
>
        保存
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
</div>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>