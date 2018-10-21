<select id="J_deliverTemplate" name="postage_id">
    <option value="" valu="">请选择运费模板</option>
    <#if deliveyList??>
        <#list deliveyList as dy>
            <#if dy??>
                <input type="checkbox" name="deliver[]" value="${dy.templateId}">${dy.name}
            </#if>
        </#list>
    </#if>
</select>
<div class="msg-error" style="display: none;margin-top: 3px;">
    <i class="icon icon-error"></i>
    <div class="msg"></div>
</div>

<input type="hidden" id="nav_postageid" data-feed="err_nav_postageid">
<div id="err_nav_postageid" style="display:none"></div>