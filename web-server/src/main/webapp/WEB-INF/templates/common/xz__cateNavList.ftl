<div class="catNavList">
    <div class="cateFication yahei fs14">全部商品分类 <i class="icon-downarrow"></i></div>
    <div class="cateCon">
        <ul>
            <#list catemenu as menu>
                <li>
                    <em class="${menu.icon!}"></em>${menu.text!}<i class="icon-rightarrow"></i>
                    <div class="cateDatail">
                        <h3 class="yahei fs14 fc3">${menu.text!}</h3>
                        <div class="dateItem">
                            <#list menu.submenu as item>
                                <a href="//so.571xz.com/${webSite!}goods.htm?pid=${item.pid!}<#if item.cid??>&cid=${item.cid!}</#if><#if item.keyword??>&keyword=${item.keyword!}</#if>" target="_blank">${item.text!}</a>
                            </#list>
                        </div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>
</div>