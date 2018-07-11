<div style='float:left;'>
    <#if success??>
        发布成功：
        <#else>
        上传失败:${errorMsg}
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>
<#list subMsgs as sm>
<br/><br/>${sm}
</#list>