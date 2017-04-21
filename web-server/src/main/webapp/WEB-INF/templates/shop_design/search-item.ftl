<div class="J_TModule clearfix ui-droppable">
    <link rel="stylesheet" href="/design/css/common/page-link.css?t=20161216" />
    <div class="js-module" data-not-edit="" data-not-del="">
        <div class="mr-title">
            <a>所有宝贝</a>
            <a href="javascript:;" style="">
                收起筛选 <i class="show-down"></i>
            </a>
        </div>
        <div class="m-search">
            <div class="mr-c clearfix">
                <div class="sp_type_nav" style="border-top: 0;">
                <#if catPolymerizations??>
                    <#list catPolymerizations as poly>
                    <div class="type_section clearfix">
                                <div class="s-title">
                                    <span class="selector-iocn06_${poly.cid}"> <i></i>
                                        ${poly.name}
                                    </span>
                                </div>
                            <div class="sl-value">
                            <ul>
                                <li class="">
                                    <a href="/shop/search.htm?id=${shop.shopId}&cid=${poly.cid}">全部</a>
                                </li>
                            <#list poly.subPolymerizations as subpoly>
                                <li class="">
                                    <a href="/shop/search.htm?id=${shop.shopId}&cid=${subpoly.cid}">${subpoly.name}(${subpoly.number})</a>
                                </li>
                            </#list>
                            </ul>
                            </div>
                    </div>
                    </#list>
                </#if>
                </div>
            </div>
        </div>

        <div class="mr-search">
            <div class="search-result">
                <a href="javascript:;">共搜索到 ${goodsList.totalCount} 个符合条件的商品</a>
            </div>
            <div class="search-input">
                <form id="search" action="" method="get">
                    <input type="hidden" name="id" value="628368">
                    <span>关键字:&nbsp;&nbsp;</span>
                    <input type="text" name="keyword" value="" style="width: 130px;">
                    <span>价格:&nbsp;&nbsp;</span>
                    <input id="lowPrice" type="text" name="lowPrice" value="" style="width:40px;">
                    <span>—&nbsp;&nbsp;&nbsp;</span>
                    <input id="highPrice" type="text" name="highPrice" value="" style="width:40px;">
                    <button type="submit">搜索</button>

                    <input type="hidden" name="pageId" value="312">
                    <!---->
                </form>
            </div>
        </div>
        <!--  -->
        <div class="m-sortbar">
            <div class="sort-row clearfix">
                <div class="sort-inner">
                    <ul class="sorts">
                        <li class="sort">
                            <a href="/store/p/628368/search.htm?sort=1&amp;pageId=312" class="link " title="">综合</a>
                        </li>
                        <li class="sort">
                            <a href="/store/p/628368/search.htm?sort=5&amp;pageId=312" class="link first" title="">新品</a>
                        </li>
                        <li class="sort has-droplist">
                            <div class="trigger">
                                <div class="link ">
                                    <span class="text" title="价格从低到高">价格</span>
                                    <span class="icon icon-btn-arrow-2-h"></span>
                                </div>
                            </div>
                            <ul class="droplist">
                                <li class="sort">
                                    <a class="J_Ajax link" href="/store/p/628368/search.htm?sort=3&amp;pageId=312" title="价格从低到高">价格从低到高</a>
                                </li>
                                <li class="sort">
                                    <a class="J_Ajax link" href="/store/p/628368/search.htm?sort=4&amp;pageId=312" title="价格从高到低">价格从高到低</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="location" id="alltime">
                        <div class="trigger">
                            <div class="inner">
                                        <span class="text" title="">
                                                                                            全部时间
                                                                                    </span>
                                <span class="icon icon-btn-arrow-2-h"></span>
                            </div>
                        </div>
                        <div class="sections">
                            <ul class="clearfix">
                                <li><a href="?pageId=312&amp;dd=0">全部</a></li>
                                <li><a href="?pageId=312&amp;dd=1">1日内</a></li>
                                <li><a href="?pageId=312&amp;dd=7">1周内</a></li>
                                <li><a href="?pageId=312&amp;dd=30">1月内</a></li>
                                <li><a href="?pageId=312&amp;dd=90">3月内</a></li>
                                <li><a href="?pageId=312&amp;dd=180">6月内</a></li>
                                <li><a href="?pageId=312&amp;dd=365">1年内</a></li>
                                <li><a class="J_defind" href="javascript:;">自定义</a></li>
                            </ul>
                        </div>

                    </div>
                    <div class="sec_date" id="sec_date">
                        <i class="cal"></i>
                        <form action="?" method="get">
                            <div class="date">
                                <input type="text" value="" maxlength="" name="startDate" class="laydate-icon" placeholder="请输入日期" onclick="laydate()">
                                <span style="font-weight: bold">-</span>
                                <input type="text" value="" maxlength="64" name="endDate" class="laydate-icon" placeholder="请输入日期" onclick="laydate()">

                                <input type="hidden" name="pageId" value="312">
                                <!---->

                                <input type="hidden" name="dd" value="-1">

                                <button type="submit">确定</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <div class="goods_list clearfix" id="content">
            <div class="goods_list_bd">
<#list goodsList.content as g>
                <div class="item-c">
                    <div class="item">
                        <div class="pic">
                            <a href="/item.htm?id=${g.itemId}" target="_blank" title="${g.title!}">
                                <img class="lazy" src="${g.imgUrl!}_240x240.jpg" data-ks-lazyload="${g.imgUrl!}_240x240.jpg" alt="${g.title!}">
                            </a>
                        </div>

                        <div class="pri-dk">
                            <div class="pri">
                                <span>¥</span> <strong>${price!}</strong>
                            </div>
                        </div>

                        <div class="tit">
                            <a href="/item.htm?id=4014162" target="_blank">${g.title!}</a>
                        </div>

                        <div class="btnview">
                            <a href="http://upload.571xz.com/publish.htm?id=${g.itemId}" target="_blank" class="contrast">
                                <i></i>
                                淘宝
                            </a>
                            <a href="http://1688.571xz.com/publish.htm?id=${g.itemId}" target="_blank" class="contrast">
                                <i></i>
                                阿里
                            </a>
                            <a class="contrast sjb package" href="javascript:;" data-id="${g.itemId}" title="加入数据包">
                                <i></i>
                                数据包
                            </a>
                        </div>
                    </div>
                </div>
</#list>
            </div>
        </div>
        <div class="page-link"><ul class="page-link-ul"><li class="disabled"><a>«</a></li><li class="current"><a>1</a></li><li><a href="?pageId=312&amp;page=2">2</a></li><li><a href="?pageId=312&amp;page=3">3</a></li><li><a href="?pageId=312&amp;page=4">4</a></li><li><a href="?pageId=312&amp;page=5">5</a></li><li><a href="?pageId=312&amp;page=6">6</a></li><li><a href="?pageId=312&amp;page=7">7</a></li><li><a title="下一页" href="?pageId=312&amp;page=2">»</a></li></ul><span>1/7</span></div>
    </div>
    <#if isEditer>
        <div class="edit-bar">
            <div class="J_NewInsertNode new-insert-node up" style="display:none ; left: 0px; top: 10px;">
                <span class="tip">松开鼠标,模块会放到该上方</span>
            </div>
            <a class="bar-moveup no-moveup" title="上移"><span></span></a>
            <a class="bar-movedown no-movedown" title="下移"><span></span></a>
            <div class="J_NewInsertNode new-insert-node down" style="display:none; left: 0px; bottom: 10px;">
                <span class="tip">松开鼠标,模块会放到该下方</span>
            </div>
        </div>
    </#if>
</div>