<div style='float:left;'>
    <#if numIid??>
        发布成功：<a id='resultTaobaoUrl' data-numiid='${numIid}'
                href='https://product.suning.com/${shopId}/${numIid}.html' target='_blank' style="color: blue;">https://product.suning.com/${shopId}/${numIid}.html</a>
        <#else>
        上传失败:${errorMsg}
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>
<#list subMsgs as sm>
<br/><br/>${sm}
</#list>