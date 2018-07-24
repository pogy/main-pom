<div class="field clearfix">
    <label class="fl">
        <em>*</em>宝贝属性</label>
    <div class="field-content fl">
        <div id="J_module-property" class="module-property module-form ">
            <div class="skin">
                <h1>基本参数</h1>
                <ul>
                    <#if allData.propsVo.pingpai??>
                        <li id="spu_999999" class="J_spu-property <#if allData.propsVo.pingpai.mustHave>mandatory</#if>" name="spus">
                            <label class="label-title" id="ariaby-prop_999999">品牌：</label>
                            <span>
                                <#if allData.propsVo.pingpai.mustHave><em>*</em></#if>
                                <ul class="J_ul-single ul-select">
                                    <li>
                                        <#assign lastvid=allData.propsVo.pingpai.values[0].snId>
                                        <#assign selectVal=allData.propsVo.pingpai.values[0]>
                                        <select id="prop_999999_select" class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                                            <#list allData.propsVo.pingpai.values as pppv>
                                            <option data-pid="999999" data-fid="${pppv.fid}"
                                                <#if pppv.selected>
                                                    <#assign selectVal=pppv>
                                                selected
                                                </#if>
                                                value="999999:${pppv.snId}"
                                            >${pppv.name}</option>
                                            <#assign lastvid=pppv.snId>
                                            </#list>
                                        </select>
                                        <div class="kui-combobox" role="combobox">
                                            <div class="kui-dropdown-trigger">
                                                <input readonly="true" class="kui-combobox-caption prop_from" data-pid="999999" data-value="999999:${selectVal.snId}" value="${selectVal.name}" style="width:190px;" id="prop_999999" role="textbox" aria-autocomplete="list" aria-haspopup="true" aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                                <div class="kui-icon-dropdown"></div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </span>
                            <div class="error" id="err_NotNull_999999"></div>
                        </li>
                    </#if>
                    <#list allData.propsVo.properties  as prop >
                        <#if prop.type.value=="input">
                                <#include "/suning/parts/input.ftl" />
                            <#elseif prop.type.value=="select">
                                <#include "/suning/parts/select.ftl" />
                            <#elseif prop.type.value=="checkbox">
                                <#include "/suning/parts/checkbox.ftl" />
                        </#if>
                    </#list>
                </ul>
                <div class="error" id="err_NotNull_20603"></div>
            </div>
            <#if (allData.propsVo.specification)?? && allData.propsVo.specification?size gt 0>
                <div class="skin">
                    <h1>规格参数</h1>
                    <ul>
                        <#list allData.propsVo.specification  as prop >
                            <#if prop.type.value=="input">
                                <#include "/suning/parts/input.ftl" />
                            <#elseif prop.type.value=="select">
                                <#include "/suning/parts/select.ftl" />
                            <#elseif prop.type.value=="checkbox">
                                <#include "/suning/parts/checkbox.ftl" />
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        </div>
    </div>
</div>