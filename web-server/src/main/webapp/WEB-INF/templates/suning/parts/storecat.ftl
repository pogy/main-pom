<#if cats??>
<#list cats as cat>
<#if cat??>
<li>
    <label>
        <#if cat.subCat??>
        ${cat.name}
        <#else>
            <input name='seller_cids[]' type="checkbox" class="checkbox"
                   value="${cat.catId}"/>${cat.name}
        </#if>
    </label>
    <#if cat.subCat??>
        <ul>
            <#list cat.subCat as sc>
                <li><label><input name='seller_cids[]' type="checkbox" value="${sc.catId}"/>${sc.name}</label>
                </li>
            </#list>
        </ul>
    </#if>
</li>
</#if>
</#list>
</#if>