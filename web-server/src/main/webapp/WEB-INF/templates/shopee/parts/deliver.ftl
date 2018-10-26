
<#if deliveyList??>
    <#list deliveyList as dy>
        <#if dy??>
            <label><input type="checkbox" name="deliver[]" value="${dy.templateId}">${dy.name}</label>
        </#if>
    </#list>
</#if>
<div class="msg-error" style="display: none;margin-top: 3px;">
    <i class="icon icon-error"></i>
    <div class="msg"></div>
</div>

<input type="hidden" id="nav_postageid" data-feed="err_nav_postageid">
<div id="err_nav_postageid" style="display:none"></div>