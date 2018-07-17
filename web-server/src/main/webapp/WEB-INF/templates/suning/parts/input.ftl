<li class="<#if prop.mustHave>mandatory</#if>">
    <label class="label-title" for="prop_${prop.snCode}">${prop.name}：</label>
    <span>
    <#if prop.mustHave><em>*</em></#if>
    <#if prop.values??>
    <#if prop.values[0]??>
        <#assign selpv=prop.values[0]>
        <input data-type="input" data-error-title="${prop.name}" type="text" data-pid="${prop.snCode}" id="prop_${prop.snCode}" class="text text-short prop_from" value="${selpv.name!}">
    <#else>
        <input data-type="input" data-error-title="${prop.name}" type="text" data-pid="${prop.snCode}" id="prop_${prop.snCode}" class="text text-short prop_from" value="">
    </#if>
    <#else>
        <input data-type="input" data-error-title="${prop.name}" type="text" data-pid="${prop.snCode}" id="prop_${prop.snCode}" class="text text-short prop_from" value="">
    </#if>
    </span>
</li>