<li class="<#if prop.mustHave>mandatory</#if>">
    <label class="label-title" for="prop_${prop.pid}">${prop.name}：</label>
    <span>
    <#if prop.mustHave><em>*</em></#if>
    <#if prop.values??>
        <#assign selpv=prop.values[0]>
        <input data-type="input" data-error-title="${prop.name}" type="text" data-pid="${prop.pid}" id="prop_${prop.pid}" class="text text-short prop_from" value="${selpv.name!}">
    <#else>
        <input data-type="input" data-error-title="${prop.name}" type="text" data-pid="${prop.pid}" id="prop_${prop.pid}" class="text text-short prop_from" value="">
    </#if>
    </span>
</li>