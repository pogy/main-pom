<div class="siteList pr yahei">
    <div class="currentSite">
        <i class="addr"></i>
        <span>
            <#if webSite == 'hz'>
                杭州
            <#elseif webSite == 'cs'>
                常熟
            <#elseif webSite == 'ss'>
                石狮
            <#elseif webSite == 'bj'>
                北京
            <#elseif webSite == 'gz'>
                广州
            <#elseif webSite == 'jx'>
                濮院
            <#elseif webSite == 'ly'>
                辽源
            <#else>
                杭州
            </#if>
        </span>
        <i class="arrow"></i>
    </div>
    <div class="siteMenu pa fs14">
        <ul>
            <li><a href="http://hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
            <li><a href="http://gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
            <li><a href="http://cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
            <li><a href="http://cs.571xz.com" <#if webSite == 'ly'>class="select"</#if>>辽源</a></li>
            <li><a href="http://ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
            <li><a href="http://jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
            <li><a href="http://bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
        </ul>
    </div>
</div>