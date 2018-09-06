<#if topPic??>
    <#list topPic as tp>
        <div class="topGoatPic">
            <div class="layout">
                <a href="<#if tp.href == ''>javascript:;<#else>${tp.href!}</#if>" target="_blank">
                    <img src="${tp.imgsrc!}">
                </a>
            </div>
        </div>
    </#list>
</#if>