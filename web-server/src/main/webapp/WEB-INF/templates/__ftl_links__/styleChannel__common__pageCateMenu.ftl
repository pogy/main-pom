<div class="pageCateMenu yahei <#if $it.style == 'close'>close</#if>">
    <h3 class="fs16"><span id="styleMenuName"></span>类目</h3>
    <div class="cateMenu">
        <#list catemenu as cate>
            <#list cate.detailitems as item>
                <h4 class="fs14 fc3">${item.text!}</h4>
                <ul>
                    <#list item.items as menu>
                        <li><a href="styleGoodsList.htm?spid=${query.spid!}&${menu.href!}" target="_blank">${menu.text!}</a></li>
                    </#list>
                </ul>
            </#list>
        </#list>
    </div>
</div>