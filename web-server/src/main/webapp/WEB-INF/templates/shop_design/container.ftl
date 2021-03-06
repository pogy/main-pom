 <div class="vl-layout-container">
        <div id="J_Page" class="page-container" style="background-image: none; <#if isEditer>width: 1340px; height: 373px;</#if>">
            <div class="vl-container J_PageToDesignContainer">
                <!-- header -->
                ${banner.allModules[0].html}
                <!-- end header -->
                <!-- body -->
                <div class="bg" style="width: 100%;<#if banner.allModules[0].moduleSet.bannerOption.spacing == 1>padding-top: 10px;</#if>
                <#if backgroundPic??>background-image: url('${backgroundPic}');
                    <#if backgroundType==1>background-repeat: repeat;</#if>
                    <#if backgroundType==2>background-repeat: repeat-y;</#if>
                    <#if backgroundType==3>background-repeat: repeat-x;</#if>
                    <#if backgroundType==4>background-repeat: no-repeat;</#if>
                    </#if> overflow:hidden">
                    <div id="bd" class="js-grid-body" data-index="0" style="position: relative;">
                        <#list fitmentAreas as area>
                        <div class="area clearfix" data-id="${area.areaId}">
                            <#if area.areaType==1>
                                <div class="area-1190" data-type="<#if searchModule??>0<#else>3</#if>">
                                <#if area.allModules??>
                                    <#list area.allModules as module>
                                    ${module.html}
                                    </#list>
                                </#if>
                                    <#if isEditer>
                                        <div class="js-model ui-droppable" style="<#if area.allModules??>display:none;</#if> width: calc(100% - 2px);
                                                background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;">
                                            <span>可添加模块</span>
                                        </div>
                                    </#if>
                                </div>
                            <#else>
                                    <div class="area-190" data-type="<#if searchModule??>0<#else>1</#if>">
                                <#if area.leftModules??>
                                        <#list area.leftModules as module>
                                        ${module.html}
                                        </#list>
                                </#if>
                                <#if isEditer>
                                        <div class="js-model ui-droppable" style="<#if area.leftModules??>display:none;</#if> width: calc(100% - 2px);
                             background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;">
                                            <span>可添加模块</span>
                                        </div>
                                </#if>
                                    </div>

                                    <div class="area-990" data-type="<#if searchModule??>0<#else>2</#if>">
                                <#if area.rightModules??>
                                        <#list area.rightModules as module>
                                        ${module.html}
                                        </#list>
                                </#if>
                                    <#if isEditer>
                                        <div class="js-model ui-droppable" style="<#if area.rightModules??>display:none;</#if> width: calc(100% - 2px);
                             background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;">
                                            <span>可添加模块</span>
                                        </div>
                                    </#if>
                                    </div>
                            </#if>
                        </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>