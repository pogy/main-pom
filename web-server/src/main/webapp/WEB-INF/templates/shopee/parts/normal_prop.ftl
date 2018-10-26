<div class="field clearfix">
    <label class="fl">
        <em>*</em>宝贝属性</label>
    <div class="field-content fl">
        <div id="J_module-property" class="module-property module-form ">
            <div class="skin">
                <h1>基本参数</h1>
                <ul>
                    <#if allData.props.pingpai??>
                        <li id="spu_${allData.props.pingpai.pid}" class="J_spu-property <#if allData.props.pingpai.mustHave>mandatory</#if>" name="spus">
                            <label class="label-title" id="ariaby-prop_${allData.props.pingpai.pid}">品牌：</label>
                            <span>
                                <#if allData.props.pingpai.mustHave><em>*</em></#if>
                                <ul class="J_ul-single ul-select">
                                    <li>
                                        <#assign lastvid=allData.props.pingpai.values[0].name>
                                        <select id="prop_${allData.props.pingpai.pid}_select" class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                                            <#assign selectedpv=allData.props.pingpai.values[0]>
                                            <#list allData.props.pingpai.values as pppv>
                                            <option data-pid="${allData.props.pingpai.pid}" data-fid="${pppv.fid}"
                                                    data-vid="${pppv_index}"
                                                <#if pppv.selected>
                                                    <#assign selectedpv=pppv>
                                                selected
                                                </#if>
                                                value="${allData.props.pingpai.pid}:${pppv.name}"
                                            >${pppv.name}</option>
                                            <#assign lastvid=pppv.name>
                                            </#list>
                                        </select>
                                        <div class="kui-combobox" role="combobox">
                                            <div class="kui-dropdown-trigger">
                                                <input readonly="true" class="kui-combobox-caption prop_from" data-pid="${allData.props.pingpai.pid}" data-value="${allData.props.pingpai.pid}:${selectedpv.name}" value="${selectedpv.name}" style="width:190px;" id="prop_${allData.props.pingpai.pid}" role="textbox" aria-autocomplete="list" aria-haspopup="true" aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                                <div class="kui-icon-dropdown"></div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </span>
                            <div class="error" id="err_NotNull_${allData.props.pingpai.pid}"></div>
                        </li>
                    </#if>
                    <#list allData.props.properties  as prop >
                        <#if prop.type.value=="input">
                                <#include "/shopee/parts/input.ftl" />
                            <#elseif prop.type.value=="select">
                                <#include "/shopee/parts/select.ftl" />
                            <#elseif prop.type.value=="checkbox">
                                <#include "/shopee/parts/checkbox.ftl" />
                        </#if>
                    </#list>
                </ul>
                <div class="error" id="err_NotNull_20603"></div>
            </div>
            <#if (allData.props.specification)?? && allData.props.specification?size gt 0>
                <div class="skin">
                    <h1>规格参数</h1>
                    <ul>
                        <#list allData.props.specification  as prop >
                            <#if prop.type.value=="input">
                                <#include "/shopee/parts/input.ftl" />
                            <#elseif prop.type.value=="select">
                                <#include "/shopee/parts/select.ftl" />
                            <#elseif prop.type.value=="checkbox">
                                <#include "/shopee/parts/checkbox.ftl" />
                            </#if>
                        </#list>
                    </ul>
                </div>
            </#if>
            <div class="skin">
                <h1>商品信息</h1>
                <ul>
                    <li>
                        <label class="label-title">商品毛重：</label>
                        <span><em>*</em><input type="text" id="weight" name="weight" class="text text-short notBeEmpty" value="" data-error-title="包装重量"> 公斤</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>