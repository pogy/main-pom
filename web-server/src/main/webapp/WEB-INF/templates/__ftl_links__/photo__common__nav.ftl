<div class="p-nav yahei fs14">
    <div class="layout">
        <div class="p-navList fl yahei">
                <a href="/photo/photoIndex.htm" <#if 'photoIndex' == $pageid>class="select"</#if>>
                    首页
                </a>
                <a href="/photo/photoWorks.htm" <#if 'photoWorks' == $pageid>class="select"</#if>>
                    作品
                </a>
                <a href="/photo/photoModel.htm" <#if 'photoModel' == $pageid>class="select"</#if>>
                    模特
                </a>
                <a href="/photo/photoOrg.htm" <#if 'photoOrg' == $pageid>class="select"</#if>>
                    摄影机构
                </a>
                <a href="/photo/photoPlace.htm" <#if 'photoPlace' == $pageid>class="select"</#if>>
                    场地
                </a>
        </div>
        <a href="/photo/auth/uploadWork.htm" class="p-uploadBtn fr"><i class="icon-upload"></i>上传作品</a>
        <div class="p-search fr">
            <div class="p-currentText">
                <#if $pageid == 'photoModel'>
                    <span data-type="model">模特</span>
                <#elseif $pageid == 'photoOrg'>
                    <span data-type="org">摄影机构</span>
                <#elseif $pageid == 'photoPlace'>
                    <span data-type="place">场地</span>
                <#else>
                    <span data-type="works">作品</span>
                </#if>
                <i class="icon-downarrow down"></i><i class="icon-uparrow up none"></i>
            </div>
            <div class="p-searchType">
                <ul>
                    <li data-type='works'>作品</li>
                    <li data-type='org'>摄影机构</li>
                    <li data-type='model'>模特</li>
                    <li data-type='place'>场地</li>
                </ul>
            </div>
            <input type="text" name='keywords' class="p-searchIpt" <#if query.keyword??> value="${query.keyword!}" </#if> />
            <div class="p-searchBtn"><i class="icon-search"></i></div>
        </div>
    </div>
</div>