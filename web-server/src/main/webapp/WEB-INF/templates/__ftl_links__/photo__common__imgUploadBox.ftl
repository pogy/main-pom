<div class="imgUploadBox <#if $it.isAdd??>addBox</#if> <#if $it.isShowPic??>showPic</#if> <#if $it.isCover??>isCover</#if>">
    <input type="hidden" value="<#if $it.imgData??>${$it.imgData!}</#if>" <#if $it.name??>name="${$it.name!}"</#if> class="picUrl">
    <b class="addPicBtn" id="${$it.uploadBtn!}">
        <i></i>
        添加图片
    </b>
    <div class="imgBox">
        <b class="changeWorks" id="<#if $it.changeId??>${$it.changeId!}<#else>changeWorks</#if>"></b>
        <b class="setCover">设为封面</b>
        <span class="cover">封面</span>
        <img src="<#if $it.img??>${$it.img!}</#if>">
    </div>
    <div class="removeBox">
        <b class="removePic"><i></i></b>
    </div>
</div>