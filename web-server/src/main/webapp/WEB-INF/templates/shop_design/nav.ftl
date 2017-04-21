<div class="design-navigation-wrap" style="width: 1340px;">
    <div class="design-page-select">
        <a class="design-page-select-btn J_PageSelect " href="javascript:void(0);">
            <span class="page-name">${container.pageName!}</span><i></i>
        </a>
    </div>
    <div class="page-list-wrap J_PageListWrapPopup">
        <div class="page-manage-entry">
            <ul class="page-manage-entry-wrap">
                <li><a class="new-page" target="_blank" href="Javascript:;">新建页面</a></li>
                <li><a class="manage-page-list" target="_blank" href="/seller/designManage.htm">管理页面</a>
                </li>
            </ul>
            <div class="page-manage-title">我的全部页面:</div>
        </div>
        <div class="page-select-list">
            <div class="basic-pages pages-type ">
                <h2>基础页</h2>
                <div class="pages-list-wrap">
                    <ul class="pages-list">
                        <#list pages as page>
                            <#if page.type != 3>
                                <li class="page-selected">
                                    <i></i>
                                    <a href="?pageId=${page.pageId!}" title="${page.name!}">${page.name!}</a>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="basic-pages pages-type pages-type-two">
                <h2>自定义页</h2>
                <div class="pages-list-wrap">
                    <ul class="pages-list">
                    <#list pages as page>
                        <#if page.type == 3>
                            <li class="page-selected">
                                <i></i>
                                <a href="?pageId=${page.pageId!}" title="${page.name!}">${page.name!}</a>
                            </li>
                        </#if>
                    </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page-operation-btns">
        <a href="/seller/index.htm" class="" style="width: 70px; border: 0; text-decoration: underline;">&lt;&lt;返还后台</a>
        <a href="javascript:;" class="go-old" style="display: none; width: 85px;"><i></i>返回旧版装修</a>
        <a href="/seller/design/preview.htm?pageId=${page_id!}" class="page-preview-btn J_TGoldData" target="_blank">预览</a>
        <a href="javascript:;" class="page-publish-btn J-send-site J_TGoldData">发布站点</a>
    </div>
    <div class="ds-msgs">
        <span class="txt tb-hidden hidden" id="J_DSMsg"><i class="txt-icon"></i></span>
    </div>
</div>