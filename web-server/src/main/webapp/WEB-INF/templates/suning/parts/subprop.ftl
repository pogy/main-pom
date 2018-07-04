<#if prop??>
<li id="cip:${prop.pid}" class='level-2'>
    <label class='simulate-label' for="simulate-prop_${prop.pid}" id="ariaby-prop_${prop.pid}">${prop.name}</label>
    <select data-transtype='dropbox' class='' id="prop_${prop.pid}" name="cp_${prop.pid}" style='display: none; visibility: hidden;'>
        <#list prop.values as pv>
            <option class="props_option_${prop.pid}" data-pid="${pv.vid}" value="${prop.pid}:${pv.vid}">${pv.name}</option>
        </#list>
    </select>
    <div class='kui-combobox' role='combobox'>
        <div class='kui-dropdown-trigger'>
            <input data-pid="${prop.pid}" class='kui-combobox-caption prop_from' value='' style='width:190px;' readonly='true' role='textbox' aria-autocomplete='list' aria-haspopup='true' id="simulate-prop_${prop.pid}" aria-expanded='false' aria-label="${prop.name}  上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
            <div class='kui-icon-dropdown'></div>
        </div>
    </div>
</li>
</#if>