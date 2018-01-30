<div class="pageCateMenu yahei <#if $it.style == 'close'>close</#if>">
    <h3 class="fs16"><span id="styleMenuName"></span>类目</h3>
    <div class="cateMenu">
        <#list catemenu as cate>
             <h4 class="fs14 fc3">${cate.text!}</h4>
            <ul>
                <#list cate.submenu as menu>
                    <li><a href="styleGoodsList.htm?spid=${query.spid!}&pid=${menu.pid!}<#if menu.cid??>&cid=${menu.cid!}</#if><#if menu.keyword??>&keyword=${menu.keyword!}</#if>" target="_blank">${menu.text!}</a></li>
                </#list>
            </ul>
        </#list>
    </div>
</div>