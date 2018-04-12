<div style='float:left;'>
    <#if numIid??>
        发布成功：<a id='resultTaobaoUrl' data-numiid='${numIid}'
                href='https://item.jd.com/${numIid}.html' target='_blank'>https://item.taobao.com/item.htm?id=${numIid}</a>
        <#else>
        上传失败:${errorMsg}
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>
<#list subMsgs as sm>
<br/><br/>${sm}
</#list>