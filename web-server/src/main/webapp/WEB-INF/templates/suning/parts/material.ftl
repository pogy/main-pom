<li id="spu_${prop.pid}" class="J_spu-property" name="spus">
    <label class="label-title" id="ariaby-prop_${prop.pid}">材质成分：</label>
                                        <span>
                        <ul class="J_ul-single ul-czcf">
                          <li>
                              <#if prop.values?? && prop.values?size gt 0>
                                  <#list prop.values as pv>
                                      <#if pv.materialPecent??>
                                          <#list pv.materialPecent?keys as key>

                                                  <div class="kui-combobox czct-box" role="combobox">
                              <div class="kui-dropdown-trigger czcf-con">
                                  <input data-num="${key_index}" data-pid="${prop.pid}" data-type="input"
                                         class="kui-combobox-caption prop_from" style="width:127px;" readonly="true"
                                         role="textbox" aria-autocomplete="list" aria-haspopup="true" value="${key}"
                                         id="simulate-prop_ss" aria-label="下摆设计： 上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                  <div class="kui-icon-dropdown">

                                  </div>
                              </div>
                              <div class="czcf-con">
                                  <#if pv.materialPecent[key]??>
                                          <input type="text" id="pre${key_index}" class="componentPercentNum kui-combobox-caption content-input"
                                                 style="width:55px;" value="${pv.materialPecent[key]!}" >
                                  <#else >
                                          <input type="text" id="pre${key_index}" class="componentPercentNum kui-combobox-caption content-input disable"
                                                 style="width:55px;" value="" disabled="disabled">
                                  </#if>

                                  <div class="txt-con">%</div>
                                  <a class="J_delContent">删除</a><#if key_index==0><a class="J_addContent">添加</a></#if>
                              </div>
                          </div>
                                          </#list>
                                          <#else>
                                              <div class="kui-combobox czct-box" role="combobox">
                              <div class="kui-dropdown-trigger czcf-con">
                                  <input data-num="0" data-pid="${prop.pid}" data-type="input"
                                         class="kui-combobox-caption prop_from" style="width:127px;" readonly="true"
                                         role="textbox" aria-autocomplete="list" aria-haspopup="true"
                                         id="simulate-prop_ss" aria-label="下摆设计： 上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                  <div class="kui-icon-dropdown">

                                  </div>
                              </div>
                              <div class="czcf-con">
                                  <input type="text" id="pre0" class="componentPercentNum kui-combobox-caption content-input disable"
                                         style="width:55px;" disabled="disabled">
                                  <div class="txt-con">%</div>
                                  <a class="J_delContent" style="display: none;">删除</a><a class="J_addContent">添加</a>
                              </div>
                          </div>
                                      </#if>
                                  </#list>
                              <#else>
                                  <div class="kui-combobox czct-box" role="combobox">
                              <div class="kui-dropdown-trigger czcf-con">
                                  <input data-num="1484292171014" data-pid="${prop.pid}" data-type="input"
                                         class="kui-combobox-caption prop_from" style="width:127px;" readonly="true"
                                         role="textbox" aria-autocomplete="list" aria-haspopup="true"
                                         id="simulate-prop_ss" aria-label="下摆设计： 上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                  <div class="kui-icon-dropdown">

                                  </div>
                              </div>
                              <div class="czcf-con">
                                  <input type="text" id="pre1484292171014" class="componentPercentNum kui-combobox-caption content-input disable"
                                         style="width:55px;" disabled="disabled">
                                  <div class="txt-con">%</div>
                                  <a class="J_delContent" style="display: none;">删除</a><a class="J_addContent">添加</a>
                              </div>
                          </div>
                              </#if>
                              <select class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                              <option value="三醋酯纤维(三醋纤)">三醋酯纤维(三醋纤)</option>
                              <option value="二烯类弹性纤维(橡胶)">二烯类弹性纤维(橡胶)</option>
                              <option value="亚麻">亚麻</option>
                              <option value="兔毛">兔毛</option>
                              <option value="兔绒">兔绒</option>
                              <option value="再生纤维素纤维">再生纤维素纤维</option>
                              <option value="大豆蛋白复合纤维">大豆蛋白复合纤维</option>
                              <option value="大豆蛋白纤维">大豆蛋白纤维</option>
                              <option value="大麻(汉麻)">大麻(汉麻)</option>
                              <option value="头层牛皮" data-nonum="true">头层牛皮</option>  false
                              <option value="山羊皮" data-nonum="true">山羊皮</option>false
                              <option value="山羊绒(羊绒)">山羊绒(羊绒)</option>
                              <option value="改性聚丙烯腈纤维(改性腈纶)">改性聚丙烯腈纤维(改性腈纶)</option>
                              <option value="新型聚酯纤维">新型聚酯纤维</option>
                              <option value="木棉">木棉</option>
                              <option value="柞蚕丝">柞蚕丝</option>
                              <option value="桑蚕丝">桑蚕丝</option>
                              <option value="棉">棉</option>
                              <option value="海藻纤维">海藻纤维</option>
                              <option value="牛二层皮" data-nonum="true">牛二层皮</option>
                              <option value="牦牛毛">牦牛毛</option>
                              <option value="牦牛绒">牦牛绒</option>
                              <option value="猪皮" data-nonum="true">猪皮</option>
                              <option value="玻璃纤维">玻璃纤维</option>
                              <option value="甲克素纤维">甲克素纤维</option>
                              <option value="石棉(石绵)">石棉(石绵)</option>
                              <option value="碳纤维">碳纤维</option>
                              <option value="竹原纤维(竹纤维)">竹原纤维(竹纤维)</option>
                              <option value="粘胶纤维(粘纤)">粘胶纤维(粘纤)</option>
                              <option value="绵羊皮" data-nonum="true">绵羊皮</option>
                              <option value="羊毛">羊毛</option>
                              <option value="羊驼毛">羊驼毛</option>
                              <option value="羊驼绒">羊驼绒</option>
                              <option value="聚丙烯纤维(丙纶)">聚丙烯纤维(丙纶)</option>
                              <option value="聚丙烯腈纤维(腈纶)">聚丙烯腈纤维(腈纶)</option>
                              <option value="聚乙烯纤维(乙纶)">聚乙烯纤维(乙纶)</option>
                              <option value="聚乙烯醇纤维(维纶)">聚乙烯醇纤维(维纶)</option>
                              <option value="聚乳酸纤维(PLA)">聚乳酸纤维(PLA)</option>
                              <option value="聚四氟乙烯纤维(氟纶)">聚四氟乙烯纤维(氟纶)</option>
                              <option value="聚对苯二甲酸乙二酯(涤纶)">聚对苯二甲酸乙二酯(涤纶)</option>
                              <option value="聚氨酯弹性纤维(氨纶)">聚氨酯弹性纤维(氨纶)</option>
                              <option value="聚氯乙烯(氯纶)">聚氯乙烯(氯纶)</option>
                              <option value="聚烯烃弹性纤维">聚烯烃弹性纤维</option>
                              <option value="聚苯硫醚纤维(赖顿（Ryton）)">聚苯硫醚纤维(赖顿（Ryton）)</option>
                              <option value="聚酯纤维">聚酯纤维</option>
                              <option value="聚酰亚胺纤维">聚酰亚胺纤维</option>
                              <option value="聚酰胺纤维(锦纶)">聚酰胺纤维(锦纶)</option>
                              <option value="芳香族聚酰胺纤维(芳纶)">芳香族聚酰胺纤维(芳纶)</option>
                              <option value="苎麻">苎麻</option>
                              <option value="莫代尔纤维(莫代尔)">莫代尔纤维(莫代尔)</option>
                              <option value="莱赛尔纤维(莱赛尔)">莱赛尔纤维(莱赛尔)</option>
                              <option value="貂毛">貂毛</option>
                              <option value="超高分子量聚乙烯纤维(高强高模聚乙烯纤维)">超高分子量聚乙烯纤维(高强高模聚乙烯纤维)</option>
                              <option value="醋酯纤维(醋纤)">醋酯纤维(醋纤)</option>
                              <option value="金属纤维">金属纤维</option>
                              <option value="金属镀膜纤维">金属镀膜纤维</option>
                              <option value="铜氨纤维(铜氨丝)">铜氨纤维(铜氨丝)</option>
                              <option value="陆禽毛">陆禽毛</option>
                              <option value="陶瓷纤维">陶瓷纤维</option>
                              <option value="马毛">马毛</option>
                              <option value="马海毛">马海毛</option>
                              <option value="骆驼毛">骆驼毛</option>
                              <option value="骆驼绒">骆驼绒</option>
                              <option value="鹿皮" data-nonum="true">鹿皮</option>
                              <option value="黄麻">黄麻</option>
                              <option value="其他">其他</option>
                            </select>
                          </li>
                        </ul>
                      </span>
    <div class="error" id="err_NotNull_${prop.pid}"></div>
</li>