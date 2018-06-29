<div class="field clearfix">
    <label class="fl">
        <em>*</em>商品关键信息</label>
    <div class="field-content fl">
        <div id="J_module-property" class="module-property module-form ">
            <div class="skin">
                <h1>商品信息</h1>
                <ul>
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
        </div>
    </div>
</div>