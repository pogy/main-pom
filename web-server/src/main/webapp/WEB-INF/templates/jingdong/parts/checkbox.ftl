<li id="spu_122216588" class="J_spu-property" name="spus"><label class="label-title" for="prop_${prop.pid}">${prop.name}：</label>
    <span><ul class="J_ul-multi ul-checkbox">
<#list prop.values as pv>
    <li>
                    <input data-pid="${prop.pid}" class="prop_checkbox prop_from" value="${prop.pid}:${pv.vid}"
                           <#if pv.selected>
                               checked
                           </#if>
                           type="checkbox" id="prop_${prop.pid}_${pv.vid}" data-value="${prop.pid}:${pv.vid}">
                     <label for="prop_${prop.pid}_${pv.vid}">${pv.name}</label>
                    </li>
    </#list>
                   </ul></span></li>