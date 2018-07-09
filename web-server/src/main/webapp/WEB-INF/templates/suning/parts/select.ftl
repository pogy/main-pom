<li id="spu_${prop.snCode}" class="J_spu-property <#if prop.mustHave>mandatory</#if>" name="spus">
    <label class="label-title" id="ariaby-prop_${prop.snCode}">${prop.name}：</label>
                                                <span>
                        <#if prop.mustHave><em>*</em></#if>                                                    <ul class="J_ul-single ul-select">
                          <li>
                            <select id="prop_${prop.snCode}_select" class="keyPropClass" data-transtype="dropbox"
                                    style="display: none; visibility: hidden;">
                                  <!--必填的参数不给于第一个空值的选项-->
                                <#assign selectedpv=prop.values[0]>
                                <#list prop.values as pv>
                                    <option data-pid="${prop.snCode}"
                                            class="props_option_${prop.snCode}"
                                            data-vid="${pv.snId}"
                                            <#if pv.selected>
                                                <#assign selectedpv=pv>
                                            selected
                                            </#if>
                                            data-fid="${pv.fid}"
                                            value="${prop.snCode}:${pv.snId}">${pv.name}</option>
                                </#list>
                            </select>
                            <div class="kui-combobox" role="combobox" data-iswrite="1">
                              <div class="kui-dropdown-trigger">
                                <input data-pid="${prop.snCode}" class="kui-combobox-caption prop_from" readonly="true"
                                       data-value="${prop.snCode}:${selectedpv.snId}" value="${selectedpv.name}" style="width:190px;" id="prop_${prop.snCode}"
                                       role="textbox" aria-autocomplete="list" aria-haspopup="true"
                                       aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                <div class="kui-icon-dropdown"></div>  <!--data-value="//$sku_data_value_mini"-->
                                  <!--以为pid=122216588时候中文：流行元素/工艺+服装款式细节 他的defaul是数组所以如果是数组则用第一个-->
                              </div>
                            </div>
                          </li>
                          <div id="prop_son_${prop.snCode}">
                              <#if selectedpv.subPropItem??>
                              <li id="cip:${selectedpv.subPropItem.snCode}" class="level-2">
                            <label class="simulate-label" for="simulate-prop_${selectedpv.subPropItem.snCode}" id="ariaby-prop_${selectedpv.subPropItem.snCode}">${selectedpv.subPropItem.name}:</label>
                          &nbsp;                                  <select data-transtype="dropbox" class="" id="prop_${selectedpv.subPropItem.name}" style="display: none; visibility: hidden;">
                                  <#assign subselectedpv=selectedpv.subPropItem.values[0]>
                                  <#list selectedpv.subPropItem.values as spv>
                                      <option class="props_option_${selectedpv.subPropItem.snCode}" data-pid="${spv.snId}"
                                              <#if spv.selected>
                                              <#assign subselectedpv=spv>
                                                  selected
                                              </#if>
                                              value="${selectedpv.subPropItem.snCode}:${spv.snId}">${spv.name}</option>
                                  </#list>
                                                                 </select>
                            <div class="kui-combobox" role="combobox">
                              <div class="kui-dropdown-trigger">
                                <input data-pid="${selectedpv.subPropItem.snCode}" class="kui-combobox-caption prop_from"
                                       data-value="${selectedpv.subPropItem.snCode}:${subselectedpv.snId}"
                                       value="${subselectedpv.name}" style="width:190px;" readonly="true" role="textbox"
                                       aria-autocomplete="list" aria-haspopup="true" id="simulate-prop_${selectedpv.subPropItem.snCode}"
                                       aria-expanded="false" aria-label="${selectedpv.subPropItem.name}  上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                <div class="kui-icon-dropdown"></div>
                              </div>
                            </div>
                          </li>
                              </#if>
                          </div>
                        </ul>
                      </span>
</li>