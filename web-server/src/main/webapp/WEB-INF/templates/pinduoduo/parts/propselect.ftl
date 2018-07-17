<#if pvlist??>
    <#list pvlist as pv>
    <div id='prop_option_${pv.vid}' class='kui-option' role='menuitem' data-value='20000:${pv.vid}'  title='${pv.name}'>${pv.name}</div>
    </#list>
</#if>