<div style='float:left;'>
    <#if numIid??>
        发布成功：前往拼多多商家后台<a id='resultTaobaoUrl' data-numiid='${numIid}'
                href='https://mms.pinduoduo.com/Pdd.html#/goods/goods_edit/index?id=${numIid}' target='_blank' style="color: blue;">编辑</a>
        <#else>
        上传失败:${errorMsg}
    </#if>
</div>
<div id='tipsMobile' style='float:left;'></div><br/>