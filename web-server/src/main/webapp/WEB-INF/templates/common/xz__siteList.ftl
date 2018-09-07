<div class="siteList pr yahei">
    <div class="currentSite">
        <span>
            <#if webSite == 'hz'>
                杭州
            <#elseif webSite == 'cs'>
                常熟
            <#elseif webSite == 'ss'>
                石狮
            <#elseif webSite == 'gz'>
                广州
            <#elseif webSite == 'jx'>
                濮院
            <#elseif webSite == 'qz'>
                泉州
            <#elseif webSite == 'zl'>
                织里
            <#elseif webSite == 'cz'>
                沧州
            <#else>
                杭州
            </#if>
        </span>
    </div>
    <div class="changeCity">[切换城市<i class="arrow"></i>]</div>
    <div class="siteMenu pa fs14">
        <ul>
            <li><a href="//hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
            <li><a href="//cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
            <li><a href="//qz.571xz.com" <#if webSite == 'qz'>class="select"</#if>>泉州</a></li>
            <li><a href="//cz.571xz.com" <#if webSite == 'cz'>class="select"</#if>>沧州</a></li>
        </ul>
    </div>
</div>