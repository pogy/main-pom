<div class="dataEmpty tac">
    <i class="errorPng"></i>
    <#if $it.errorCon??>
        <p class="tac fs14 fc6 yahei">${$it.errorCon!}</p>
    <#else>
        <p class="tac fs14 fc6 yahei">暂无数据！</p>
    </#if>
</div>