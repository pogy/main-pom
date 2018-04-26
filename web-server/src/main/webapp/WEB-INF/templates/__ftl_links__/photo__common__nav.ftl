<div class="p-nav yahei fs14">
    <div class="layout">
        <div class="p-navList fl yahei">
                <a href="photoIndex.htm" <#if 'photoIndex' == $pageid>class="select"</#if>>
                    首页
                </a>
                <a href="photoWorks.htm" <#if 'photoWorks' == $pageid>class="select"</#if>>
                    作品
                </a>
                <a href="photoModel.htm" <#if 'photoModel' == $pageid>class="select"</#if>>
                    模特
                </a>
                <a href="photoOrg.htm" <#if 'photoOrg' == $pageid>class="select"</#if>>
                    摄影机构
                </a>
                <a href="photoPlace.htm" <#if 'photoPlace' == $pageid>class="select"</#if>>
                    场地
                </a>
        </div>
        <a href="uploadWork.htm" class="p-uploadBtn fr">上传作品</a>
        <div class="p-search fr">
            <div class="p-currentText" data-type="works"><span>作品</span><i class="icon-downarrow down"></i><i class="icon-uparrow up none"></i></div>
            <div class="p-searchType">
                <ul>
                    <li data-type='works'>作品</li>
                    <li data-type='org'>摄影机构</li>
                    <li data-type='model'>模特</li>
                    <li data-type='place'>场地</li>
                </ul>
            </div>
            <input type="text" name='keywords' class="p-searchIpt" />
            <div class="p-searchBtn"><i class="icon-search"></i></div>
        </div>
    </div>
</div>