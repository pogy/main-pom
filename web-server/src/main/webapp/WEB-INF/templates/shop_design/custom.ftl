<div class="edit-design J_TModule" data-title="自定义" data-id="${moduleSet.moduleId}">
    <div class="skin-box " style=" width:100%;position:relative; overflow-x: hidden;">
        <#if moduleSet.titleShow == 1>
            <div class="skin-box-hd">
                <h3><span>${moduleSet.title!}</span></h3>
            </div>
        </#if>
        <div class="skin-box-bd clear-fix">
            ${moduleSet.content!}
        </div>
    </div>

</div>