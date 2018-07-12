<select id="J_deliverTemplate" name="postage_id">
    <option value="" valu="">请选择运费模板</option>
    <#if deliveyList??>
        <#list deliveyList as dy>
            <#if dy??>
                <option class='expressType' data-unit="${dy.valuation}" value="${dy.freightId}" <#if erverDyTemplateId==dy.freightId>selected</#if> valu="${dy.valuation}">${dy.freigtName}</option>
            </#if>
        </#list>
    </#if>
</select>
<#--<a href="javascript:;" id="deliverUpdate" class="gengxin gengxin_yf"><i></i>更新运费模板</a>-->
<div class="msg-error" style="display: none;margin-top: 3px;">
    <i class="icon icon-error"></i>
    <div class="msg"></div>
</div>

<input type="hidden" id="nav_postageid" data-feed="err_nav_postageid">
<div id="err_nav_postageid" style="display:none"></div>