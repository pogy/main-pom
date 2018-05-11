<div id="hd" class="Js-head" style="position:relative;">

    <div class="ovbox shopsigns" style="">
    <#if moduleSet.bannerOption.imgShow == 1>
        <div class="mod_item">
            <#if moduleSet.storeImg.type == 1>
                <div class="hd-main" style="background-image:url('${moduleSet.storeImg.imgPic!}'); min-height: ${moduleSet.storeImg.height}px; max-height: ${moduleSet.storeImg.height}px; background-position:center; background-repeat:no-repeat; overflow: hidden;">
                </div>
                <#else>
                    <div class="hd-main" style="text-align: center; min-height: ${moduleSet.storeImg.height}px; max-height: ${moduleSet.storeImg.height}px; background-position:center; background-repeat:no-repeat; overflow: hidden;">
                    ${moduleSet.storeImg.content}
                    </div>
            </#if>
        </div>
    </#if>
    </div>
    <div class="ovbox hd-nav" id="bgcolor" style="background:${moduleSet.storeNav.background};">
        <div class="mod_item">
            <div class="nav-main clearfix">
                <ul class="clearfix">
                    <li>
                        <#if shop.domain != "" && shop.domain??>
                            <a href="//${shop.domain}.571xz.com" style="color:${moduleSet.storeNav.color};">
                                首页
                            </a>
                        <#else >
                            <a href="//${shop.webSite}.571xz.com/${shop.shopId}" style="color:${moduleSet.storeNav.color};">
                                首页
                            </a>
                        </#if>
                    </li>
                    <li class="c_all_tit">
                        <a href="/shop/search.htm?id=${shop.shopId}" style="color:${moduleSet.storeNav.color};">
                            全部商品
                            <i class="show-down">
                            </i>
                        </a>
                        <div class="con_bg" style="display: none;">
                            <div class="con clearfix" style="display: block">
                                <ul class="first clearfix">
                                    <li class="f_con">
                                        <a href="/shop/search.htm?id=${shop.shopId}">
                                            查看所有宝贝
                                            <span>
                                                &gt;
                                            </span>
                                        </a>
                                        <div class="sec_con">
                                            <ul class="second">
                                                <li>
                                                    <a href="/shop/search.htm?id=${shop.shopId}&dd=1">
                                                        今日新品
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="/shop/search.htm?id=${shop.shopId}&dd=7">
                                                        7日新品
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="/shop/search.htm?id=${shop.shopId}&dd=30">
                                                        30日新品
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                <#list shopcats as cat>
                                    <li class="f_con">
                                        <a href="/shop/search.htm?id=${shop.shopId}&scid=${cat.cid!}">
                                            ${cat.name!}
                                            <span>
                                                &gt;
                                            </span>
                                        </a>
                                        <#if cat.subCats??>
                                           <#if cat.subCats?size gt 0>
                                            <div class="sec_con">
                                                <ul class="second">
                                                    <#list cat.subCats as subcat>
                                                        <li>
                                                            <a href="/shop/search.htm?id=${shop.shopId}&?scid=${subcat.cid!}">
                                                                ${subcat.name!}
                                                            </a>
                                                        </li>
                                                    </#list>
                                                </ul>
                                            </div>
                                           </#if>
                                        </#if>
                                    </li>
                                </#list>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <#if shopStyles??>
                        <#if (shopStyles?size>0)>
                            <li class="c_all_tit">
                                <a href="/shop/search.htm?id=${shop.shopId}" style="color:${moduleSet.storeNav.color};"">
                                    风格类别
                                    <i class="show-down">
                                    </i>
                                </a>
                                <div class="con_bg" style="display: none;">
                                   <div class="con clearfix" style="display: block">
                                     <ul class="first clearfix">
                                         <#list shopStyles as style >
                                             <li class="f_con">
                                                 <a href="/shop/search.htm?id=${shop.shopId}&spid=${style.spid!}">
                                                     ${style.name!}
                                                 </a>
                                             </li>
                                         </#list>
                                     </ul>
                                   </div>
                                </div>
                            </li>
                        </#if>
                    </#if>
                    <#list checkedNavs as nav>
                        <li>
                            <a href="${nav.href!}" style="color:${moduleSet.storeNav.color!};">
                            ${nav.pageName!}
                            </a>
                        </li>
                    </#list>
                    <#list moduleSet.storeNavAuto as nav>
                    <li>
                        <a href="${nav.targetUrl!}" style="color:${moduleSet.storeNav.color!};">
                            ${nav.name!}
                        </a>
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
    <#if isEditer>
        <div class="edit-bar" style="display: none;">
            <a class="bar-edit edit_content" title="编辑">
            </a>
        </div>
    </#if>
</div>
