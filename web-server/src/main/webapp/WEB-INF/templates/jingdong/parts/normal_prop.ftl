<div class="field clearfix">
    <label class="fl">
        <em>*</em>宝贝属性</label>
    <div class="field-content fl">
        <div id="J_module-property" class="module-property module-form ">
            <h1>基本参数</h1>
            <div class="skin">
                <ul>
                    <#if allData.props.pingpai??>
                        <li id="spu_${allData.props.pingpai.pid}" class="J_spu-property" name="spus">
                            <label class="label-title" id="ariaby-prop_${allData.props.pingpai.pid}">品牌：</label>
                            <span>
                                <#if allData.props.pingpai.mustHave><em>*</em></#if>
                                <ul class="J_ul-single ul-select">
                                    <li>
                                        <#assign lastvid=allData.props.pingpai.values[0].vid>
                                        <select id="prop_${allData.props.pingpai.pid}_select" class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                                            <#list allData.props.pingpai.values as pppv>
                                            <option data-pid="${allData.props.pingpai.pid}" data-fid="${pppv.fid}"
                                                <#if pppv.selected>
                                                selected
                                                </#if>
                                                value="${allData.props.pingpai.pid}:${pppv.vid}"
                                            >${pppv.name}</option>
                                            <#assign lastvid=pppv.vid>
                                            </#list>
                                        </select>
                                        <div class="kui-combobox" role="combobox">
                                            <div class="kui-dropdown-trigger">
                                                <input readonly="true" class="kui-combobox-caption prop_from" data-pid="${allData.props.pingpai.pid}" data-value="" value="" style="width:190px;" id="prop_${allData.props.pingpai.pid}" role="textbox" aria-autocomplete="list" aria-haspopup="true" aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
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
                                <#include "/jingdong/parts/input.ftl" />
                            <#elseif prop.type.value=="select">
                                <#include "/jingdong/parts/select.ftl" />
                            <#elseif prop.type.value=="checkbox">
                                <#include "/jingdong/parts/checkbox.ftl" />
                        </#if>
                    </#list>
                </ul>
                <div class="error" id="err_NotNull_20603"></div>
            </div>
            <h1>规格参数</h1>
            <div class="skin">
                <ul>
                    <#list allData.props.specification  as prop >
                        <#if prop.type.value=="input">
                            <#include "/jingdong/parts/input.ftl" />
                        <#elseif prop.type.value=="select">
                            <#include "/jingdong/parts/select.ftl" />
                        <#elseif prop.type.value=="checkbox">
                            <#include "/jingdong/parts/checkbox.ftl" />
                        </#if>
                    </#list>
                </ul>
            </div>
            <h1>商品信息</h1>
            <div class="skin">
                <ul>
                    <li>
                        <label class="label-title">[包装]长：</label>
                        <span><em>*</em><input type="text" name="length" class="text text-short" value=""> mm</span>
                    </li>
                    <li>
                        <label class="label-title">[包装]宽：</label>
                        <span><em>*</em><input type="text" name="wide" class="text text-short" value=""> mm</span>
                    </li>
                    <li>
                        <label class="label-title">[包装]高：</label>
                        <span><em>*</em><input type="text" name="high" class="text text-short" value=""> mm</span>
                    </li>
                    <li>
                        <label class="label-title">商品毛重：</label>
                        <span><em>*</em><input type="text" name="weight" class="text text-short" value=""> 公斤</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>