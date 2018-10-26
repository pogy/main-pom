<div style='float:left;'>
    <#if success??>
        发布成功：商品编码-${numIid}
        <#else>
        上传失败:${errorMsg} <#if num??>第${num}张图<#else></#if>
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>
<#list subMsgs as sm>
<br/><br/>${sm}
</#list>