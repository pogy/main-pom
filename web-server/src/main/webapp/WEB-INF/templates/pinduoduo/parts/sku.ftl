<div class="field clearfix">
    <div id="J_SellProperties" class="sku-style">
        <div>
            <#if (item.colors)??>
                <#include "/jingdong/parts/color.ftl">
                    <#assign color=item.colors>
                    <#assign selected_color={}>
                    <div class="sku-group sku-color " data-features="image edit">
                        <label class="sku-lable">颜色：</label>
                        <div class="sku-box sku-color" id="sku-color-wrap">
                            <ul class="sku-list">
                                <#list color as c>
                                    <li class="sku-item edit">
                                        <input type="checkbox" data-name='${c.text}'
                                               id="prop_${c_index}" name="cp[]"
                                               class="J_Checkbox colorCheckbox" value="${c.text}"
                                               checked/>
                                        <label class="labelname" for="prop_${c_index}" title="${c.text}" style="display: none;">${c.text}</label>
                                        <input type="text" data-name='${c.text}'
                                               id="J_AliasColor_${c_index}" class="editbox text" maxlength=15 data-type="color"
                                               value="${c.text}"/>
                                    </li>
                                </#list>
                            </ul>
                        </div>
                </#if>
            </div>
            <div id="J_SKUColorWrapper" class="sku-wrapper">

                <label class="sku-lable">&nbsp;</label>
                <table border="0" cellspacing="0" class="J_SKUImgTable img-table">
                    <caption>颜色属性图片上传表格</caption>
                    <thead>
                        <tr>
                            <th>颜色</th>
                            <th>图片（无图片可不填）</th>
                            <th>已有图片</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list color as c>
                        <tr id="J_MapImg_${c_index}">
                            <td class="tile">
                                <span class="J_MapColor_${c_index}">${c.text}</span>
                            </td>
                            <td>
                                <input type="button" value="上传图片">
                            </td>
                            <td class="preview">
                                <#if c.imgSrc??>
                                <input type="hidden" id="prop_img-${c_index}" name="prop_img[]"
                                    class="prop_img_default"
                                    name="cpvf_old[]"
                                    value="${c.imgSrc}">
                                <a target="_blank" href="${c.imgSrc}">
                                    <img height="40px" width="40px;" src="${c.imgSrc}_40x40.jpg">
                                </a>
                                <a class="del" href="javascript:void(0);">删除</a>
                                <a class="undel" data-path="" href="javascript:void(0);">恢复删除</a>
                                <#else >
                                当前无图片
                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <#if item.size??>
                <div class="sku-group required sku-size " data-features=" edit">
                    <label class="sku-lable">尺码：</label>
                    <div class="sku-box ">
                        <ul class="sku-list">
                            <#list item.size as sv>
                                <li class="sku-item edit">
                                    <input type="checkbox" id="prop_${sv_index}" name="cp[]"
                                           class="J_Checkbox" value="${sv}"
                                           checked
                                    />
                                    <label class="labelname" for="prop_${sv_index}"
                                           title="${sv}">${sv}</label>
                                    <input type="text" id="J_Alias_${sv_index}" class="editbox text" maxlength=15
                                           value="${sv}" data-type="size"/>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </#if>

            <div class="sku-wrapper">
                <label class="sku-lable">&nbsp;</label>
                <div class="sku-map sku-loading" id="J_SKUMapContainer">
                        <table border="0" cellspacing="0" style="visibility: visible;">
                            <caption>销售属性匹配表</caption>

                                    <thead>
                                    <tr>
                                       <th class="J_MapColor">
                                           <span>颜色</span>
                                        </th>
                                        <th class="J_MapSize">
                                            <span>尺码</span>
                                        </th>
                                        <th class="J_MapPrice">
                                            <span class="required">团购价
                                              <input id="grouponprice" type="button" class="batch d_size2" data-t="gprice">
                                            </span>
                                        </th>
                                        <th class="J_MapOnePrice">
                                            <span class="required">价格
                                              <input id="batchprice" type="button" class="batch d_size2" data-t="price">
                                            </span>
                                        </th>
                                        <th class="J_MapNum">
                                            <span class="required">数量
                                              <input type="button" class="batch d_size2" data-t="quantity">
                                            </span>
                                        </th>
                                        <th class="J_MapMarketCode">
                                            <span class="">商家编码
                                              <input type="button" class="batch d_size2" data-t="tsc">
                                            </span>
                                        </th>
                                    </tr>
                                    </thead>
                                <tbody>
                                <#list item.colors as c>
                                    <#list item.size as s>
                                        <tr class="J_MapRow" data-color="${c_index}">
                                            <#if s_index == 0>
                                            <td rowspan="${item.size?size}" class="tile">
                                                <span class="J_MapColor_${c_index}">${c.text}</span>
                                            </td>
                                            </#if>
                                            <td>
                                                <span class="J_MapSize_${s_index}">${s}</span>
                                            </td>
                                            <td class="gprice">
                                                <input data-id="${c_index}_${s_index}"
                                                       id="J_SkuField_gprice_${c_index}_${s_index}"
                                                       class="J_MapPrice text" data-type="gprice" type="text" value="${item.price}">
                                            </td>
                                            <td class="price">
                                                <input data-id="${c_index}_${s_index}"
                                                       id="J_SkuField_price_${c_index}_${s_index}"
                                                       class="J_MapOnePrice text" data-type="price" type="text" value="${((item.price?number)*2)?string("0.00")}">
                                            </td>
                                            <td class="quantity">
                                                <input maxlength="9" data-id="${c_index}_${s_index}"
                                                       id="J_SkuField_quantity_${c_index}_${s_index}"
                                                       class="J_MapQuantity text" data-type="quantity" type="text"
                                                       value="100">
                                            </td>
                                            <td class="tsc">
                                                <input data-id="${c_index}_${s_index}"
                                                       id="J_SkuField_tsc_${c_index}_${s_index}"
                                                       class="J_MapProductid text" data-type="tsc" type="text" value="">
                                            </td>

                                        </tr>
                                    </#list>
                                </#list>
                                    </tbody>


                        </table>
                </div>
            </div>
        </div>
        <div class="sku-mapfeed" style="display: none;">
            <div class="msg-error">
                <i class="icon icon-error"></i>
                <p class="msg">您需要选择所有的销售属性，才能组合成完整的规格信息。</p>
            </div>
        </div>
    </div>
</div>