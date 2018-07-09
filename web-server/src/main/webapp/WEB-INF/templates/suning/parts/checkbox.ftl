<li id="spu_122216588" class="J_spu-property" name="spus"><label class="label-title" for="prop_${prop.snCode}">${prop.name}：</label>
    <span><ul class="J_ul-multi ul-checkbox">
            <#if prop.mustHave><em>*</em></#if>
            <#list prop.values as pv>
    <li>
                    <input data-pid="${prop.snCode}" class="prop_checkbox prop_from" value="${prop.snCode}:${pv.snId}"
                           <#if pv.selected>
                               checked
                           </#if>
                           type="checkbox" id="prop_${prop.snCode}_${pv.snId}" data-value="${prop.snCode}:${pv.snId}">
                     <label for="prop_${prop.snCode}_${pv.snId}">${pv.name}</label>
                    </li>
    </#list>
                   </ul></span></li>