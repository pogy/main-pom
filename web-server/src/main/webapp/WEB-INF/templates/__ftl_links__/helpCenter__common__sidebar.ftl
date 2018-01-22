<div class="sidebar">
    <h2 class="yahei fs16">常见问题分类</h2>
    <div class="sidebarCon">
        <ul>
            <#list sidebarList as item>
            <li class="firstCate <#if query.pid == item.pid>unfolding</#if>">
                <p class="queCateName"><span class="fs14"><i class="theZoom"></i>${item.name!}</span></p>
                <div class="subSidebar">
                    <ul>
                        <#list item.subSidebarList as subItem>
                        <li <#if query.cid == subItem.cid>class="selected"</#if>>
                            <a href="queIndex.htm?cid=${subItem.cid!}"><i class="rightArrow"></i>${subItem.name!}</a>
                        </li>
                        </#list>
                    </ul>
                </div>
            </li>
            </#list>
        </ul>
    </div>
</div>