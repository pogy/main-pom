<div style='float:left;'>
    <#if shopeeUrl??>
        发布成功：<a id='resultTaobaoUrl' data-numiid='' href='${shopeeUrl!}' target='_blank' style="color: blue;">${shopeeUrl!}</a>
    <#else>
        上传失败:${errorMsg}
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>
<#list subMsgs as sm>
<br/><br/>${sm}
</#list>