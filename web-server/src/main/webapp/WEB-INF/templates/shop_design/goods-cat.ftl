<div class=" J_TModule" data-title="宝贝分类" data-id="${moduleSet.moduleId}">
    <div class="js-module clearfix" style="width: 190px; position: relative; margin-bottom: 5px;" data-not-edit>
        <div class="main-left">
            <div class="ml-c">
                <dl>
                    <dt>宝贝分类</dt>
                    <dd>
                        <ul>
                            <li class="mlc-title">
                                <a href="javascript:;" class="mlc-show"> <em>-</em>
                                    <a href="/shop/search.htm?id=${shop.shopId}">查看所有宝贝</a>
                                </a>
                            </li>
                        </ul>
                        <ul>
                            <li class="list">
                                <a href="/shop/search.htm?id=${shop.shopId}&d=1">
                                    <i class="show-down"></i>
                                    今日新品
                                </a>
                            </li>
                            <li class="list">
                                <a href="/shop/search.htm?id=${shop.shopId}&d=7">
                                    <i class="show-down"></i>
                                    7日新品
                                </a>
                            </li>
                            <li class="list">
                                <a href="/shop/search.htm?id=${shop.shopId}&d=30">
                                    <i class="show-down"></i>
                                    30日新品
                                </a>
                            </li>
                        </ul>
                    <#list shopcats as cat>
                        <ul>
                            <li class="mlc-title">
                                <a href="javascript:;" class="mlc-show"> <em>-</em>
                                    <a href="/shop/search.htm?id=${shop.shopId}&scid=${cat.cid!}">${cat.name!}</a>
                                </a>
                            </li>
                        </ul>
                        <#if cat.subCats??>
                        <ul>
                            <#list cat.subCats as subcat>
                                <li class="list">
                                    <a href="/shop/search.htm?id=${shop.shopId}&scid=${subcat.cid!}">
                                        <i class="show-down"></i>
                                        ${subcat.name!}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </#list>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
</div>