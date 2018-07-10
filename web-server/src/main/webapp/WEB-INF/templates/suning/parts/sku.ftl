<div class="field clearfix">
    <div id="J_SellProperties" class="sku-style">
        <div>
        <#if (allData.propsVo.color)??>
            <#include "/suning/parts/color.ftl">
            <#assign color=allData.propsVo.color>
            <#assign selected_color={}>
        <div class="sku-group sku-color " data-caption="${color.name}" data-p="${color.snCode}" data-features="image edit">
            <label class="sku-lable">${color.name}：</label>
            <div class="sku-box sku-color" id="sku-color-wrap">
                <ul class="sku-list">
                    <#list color.values as c>
                        <li class="sku-item <#if c.selected>edit</#if>">
                            <input type="checkbox" data-pid='${color.snCode}' data-vid='${c.name}' data-name='${c.name}'
                                   id="prop_${color.snCode}_${c_index}" name="cp[]"
                                   class="J_Checkbox colorCheckbox" value="${color.snCode}:${c.name}"
                                   <#if c.selected>checked</#if>/>
                            <label class="color-lump" for="prop_${color.snCode}_${c_index}"></label>
                            <label class="labelname" for="prop_${color.snCode}_${c_index}" title="${c.name}" <#if c.selected>style="display: none;" </#if>>${c.name}</label>
                            <input type="text" data-pid='${color.snCode}' data-vid='${c.name}' data-name='${c.name}'
                                   id="J_Alias_${color.snCode}-${c_index}" class="editbox text" maxlength=15
                                   value="${c.name}" <#if !c.selected>style="display: none;"</#if>/>
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
                    <#list color.values as c>
                    <tr id="J_MapImg_${color.snCode}-${c_index}" <#if !c.selected>
                        style="display: none;"
                    </#if>
                    >
                        <td class="tile">
                            <i class="color-lump" style="background-color:#${colorMap["${c.vid}"]};"></i>
                            <span class="J_Map" data-value="${color.snCode}:${c.name}">${c.name}</span>
                        </td>
                        <td>
                            <input type="button" value="上传图片">
                        </td>
                        <td class="preview">
                            <#if c.imgUrl??>
                                <input type="hidden" id="prop_img-${color.snCode}_${c_index}" name="prop_img[]"
                                       class="prop_img_default" data-value="${color.snCode}:${c.name}"
                                       name="cpvf_old_${color.snCode}:${c_index}[]"
                                       value="${color.snCode}_${c.name}##${c.imgUrl}">
                                <a target="_blank" href="${c.imgUrl}">
                                    <img height="40px" width="40px;" src="${c.imgUrl}_40x40.jpg">
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
        <#if allData.propsVo.saleProps??>
            <#list allData.propsVo.saleProps as s>
                <div class="sku-group required sku-size " data-caption="${s.name}" data-features=" edit" data-p="${s.snCode}">
                    <label class="sku-lable">${s.name}：</label>
                    <div class="sku-box ">
                        <ul class="sku-list">
                            <#list s.values as sv>
                                <li class="sku-item <#if sv.selected>edit</#if>">
                                    <input type="checkbox" id="prop_${s.snCode}_${sv_index}" name="cp[]"
                                           class="J_Checkbox" value="${s.snCode}:${sv.name}" <#if sv.selected>
                                           checked
                                    </#if>/>
                                    <label class="labelname" for="prop_${s.snCode}_${sv_index}"
                                           title="${sv.name}">${sv.name}</label>
                                    <input type="text" id="J_Alias_${s.snCode}-${sv_index}" class="editbox text" maxlength=15
                                           value="${sv.name}"/>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </#list>
        </#if>

            <div class="sku-wrapper">
                <label class="sku-lable">&nbsp;</label>
                <div class="sku-map sku-loading" id="J_SKUMapContainer">
                <#if allData.propsVo.skus??>
                    <#assign mskus=allData.propsVo.skus>
                    <table border="0" cellspacing="0" style="visibility: visible;">
                        <caption>销售属性匹配表</caption>
                        <#list mskus as s>
                            <#if s_index==0>
                                <thead>
                                <tr>
                                    <#list s as si>
                                        <th class="J_Map_${si.snCode}">
                                            <span>${si.value}</span>
                                        </th>
                                    </#list>
                                    <th class="J_Map_0">
                                            <span class="required">价格
                                              <input id="batchprice" type="button" class="batch d_size2" data-t="price">
                                            </span>
                                    </th>
                                    <th class="J_Map_0">
                                            <span class="required">数量
                                              <input type="button" class="batch d_size2" data-t="quantity">
                                            </span>
                                    </th>
                                    <th class="J_Map_0">
                                            <span class="">商家编码
                                              <input type="button" class="batch d_size2" data-t="tsc">
                                            </span>
                                    </th>
                                </tr>
                                </thead>
                            </#if>
                        </#list>
                        <tbody>
                            <#list color.values as c>
                                <#if c.selected>
                                    <#list allData.propsVo.saleProps as s>
                                        <#list s.values as sv>
                                            <#if sv.selected>
                                            <tr class="J_MapRow" data-color="${color.snCode}-${c_index}">
                                                <#if sv.firstChange>
                                                <td rowspan="${selectedSizeLength}" class="tile">
                                                    <i class="color-lump"></i>
                                                    <span class="J_Map_${color.snCode}-${c_index}">${c.name}</span>
                                                </td>
                                                 </#if>
                                                <td class="size">
                                                    <span class="J_Map_${s.snCode}-${sv_index}">${sv.name}</span>
                                                </td>
                                                <td class="price">
                                                    <input data-id="${color.snCode}-${c_index}_${s.snCode}-${sv_index}" id="J_SkuField_price_${color.snCode}-${c_index}_${s.snCode}-${sv_index}" class="J_MapPrice text" data-type="price" type="text" value="${item.price}">
                                                </td>
                                                <td class="quantity">
                                                    <input maxlength="9" data-id="${color.snCode}-${c_index}_${s.snCode}-${sv_index}" id="J_SkuField_quantity_${color.snCode}-${c_index}_${s.snCode}-${sv_index}" class="J_MapQuantity text" data-type="quantity" type="text" value="100">
                                                </td>
                                                <td class="tsc">
                                                    <input data-id="${color.snCode}-${c_index}_${s.snCode}-${sv_index}" id="J_SkuField_tsc_${color.snCode}-${c_index}_${s.snCode}-${sv_index}" class="J_MapProductid text" data-type="tsc" type="text" value="">
                                                </td>
                                            </tr>
                                            </#if>
                                        </#list>
                                    </#list>
                                </#if>
                            </#list>
                        </tbody>

                    </table>
                </#if>
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