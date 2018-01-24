<div class="pageCateMenu yahei <#if $it.style == 'close'>close</#if>">
    <h3 class="fs16"><span id="styleMenuName"></span>类目</h3>
    <div class="cateMenu">
        <#list cateList as style>
            <h4 class="fs14 fc3">${style.cateName!}</h4>
            <ul>
                <#list style.childCateList as item>
                    <li><a href="styleGoodsList.htm?spid=${query.spid!}&cid=${item.cid!}" target="_blank">${item.cname!}</a></li>
                </#list>
            </ul>
        </#list>
    </div>
</div>