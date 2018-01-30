<div class="J_TModule clearfix ui-droppable">
    <link rel="stylesheet" href="http://www.571xz.com/design/css/common/page-link.css?t=20161216" />
    <script type="text/javascript" src="http://www.571xz.com/design/theme/xzw/js/laydate/laydate.js"></script>

    <div class="js-module" data-not-edit="" data-not-del="">
        <#if shopStyles??>
            <div class="clearfix diyStyle">
                <#list shopStyles as cate>
                    <a class="styleItem
                        <#if cate.spid == 1>
                            green
                        <#elseif cate.spid == 2>
                            purple
                        <#elseif cate.spid == 3>
                            blue
                        <#elseif cate.spid == 4>
                            pink
                        <#elseif cate.spid == 5>
                            yellow
                        <#elseif cate.spid == 6>
                            orange
                        </#if>
                        <#if cate.spid == bo.spid>
                            selected
                        <#elseif cate.spid == bo.spid>
                            selected
                        <#elseif cate.spid == bo.spid>
                            selected
                        <#elseif cate.spid == bo.spid>
                            selected
                        <#elseif cate.spid == bo.spid>
                            selected
                        <#elseif cate.spid == bo.spid>
                            selected
                        </#if>
                        " href="/shop/search.htm?${sortparam}&amp;spid=${cate.spid}">${cate.name!}</a>
                </#list>
            </div>
        </#if>
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
                                <#--<li class="">-->
                                <#--<a href="/shop/search.htm?id=${shop.shopId}&cid=${poly.cid}">全部</a>-->
                                <#--</li>-->
                                    <#list poly.subPolymerizations as subpoly>
                                        <li <#if subpoly.cid == bo.cid>class="on"</#if>>
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
                <form id="search" action="/shop/search.htm" method="get">
                    <input type="hidden" name="id" value="${shop.shopId}">
                    <span>关键字:&nbsp;&nbsp;</span>
                    <input type="text" name="pstring" value="${bo.pstring!}" style="width: 130px;">
                    <span>价格:&nbsp;&nbsp;</span>
                    <input id="lowPrice" type="text" name="beginPrice" value="${bo.beginPrice!}" style="width:40px;">
                    <span>—&nbsp;&nbsp;&nbsp;</span>
                    <input id="highPrice" type="text" name="endPrice" value="${bo.endPrice!}" style="width:40px;">
                    <button type="submit">搜索</button>
                    <!---->
                </form>
            </div>
        </div>
        <!--  -->
        <div class="m-sortbar">
            <div class="sort-row clearfix">
                <div class="sort-inner">
                    <ul class="sorts">
                    <#--<li class="sort">-->
                    <#--<a href="/shop/search.htm?id=${shop.shopId}&amp;order=" class="link " title="">综合</a>-->
                    <#--</li>-->
                    <#assign sortparam="id="+shop.shopId/>
                    <#if bo??>
                        <#if bo.spid??>
                            <#assign sortparam=sortparam+"&spid="+bo.spid/>
                        </#if>
                        <#if bo.pstring??>
                            <#assign sortparam=sortparam+"&pstring="+bo.pstring/>
                        </#if>
                        <#if bo.cid??>
                            <#assign sortparam=sortparam+"&cid="+bo.cid/>
                        </#if>
                        <#if bo.scid??>
                            <#assign sortparam=sortparam+"&scid="+bo.scid/>
                        </#if>
                        <#if bo.beginPrice??>
                            <#assign sortparam=sortparam+"&beginPrice="+bo.beginPrice/>
                        </#if>
                        <#if bo.endPrice??>
                            <#assign sortparam=sortparam+"&endPrice="+bo.endPrice/>
                        </#if>
                        <#if bo.dd??>
                            <#assign sortparam=sortparam+"&dd="+bo.dd/>
                        </#if>
                        <#if bo.startDate??>
                            <#assign sortparam=sortparam+"&startDate="+bo.startDate/>
                        </#if>
                        <#if bo.endDate??>
                            <#assign sortparam=sortparam+"&endDate="+bo.endDate/>
                        </#if>
                    </#if>
                        <li class="sort">
                            <a href="/shop/search.htm?${sortparam}&amp;order=common" class="link <#if bo??><#if bo.order=='common'>first</#if></#if>" title="">综合</a>
                        </li>
                        <li class="sort">
                            <a href="/shop/search.htm?${sortparam}&amp;order=time_down" class="link <#if bo??><#if bo.order=='time_down'>first</#if></#if>" title="">新品</a>
                        </li>
                        <li class="sort">
                            <a href="/shop/search.htm?${sortparam}&amp;order=popular" class="link <#if bo??><#if bo.order=='popular'>first</#if></#if>" title="">人气</a>
                        </li>
                        <li class="sort has-droplist">
                            <div class="trigger">
                                <div class="link <#if bo??><#if bo.order=='price-desc'>first</#if><#if bo.order=='price-asc'>first</#if></#if>">
                                    <span class="text" title="价格从低到高">价格</span>
                                    <span class="icon icon-btn-arrow-2-h"></span>
                                </div>
                            </div>
                            <ul class="droplist">
                                <li class="sort">
                                    <a class="J_Ajax link" href="/shop/search.htm?${sortparam}&amp;order=price-asc" title="价格从低到高">价格从低到高</a>
                                </li>
                                <li class="sort">
                                    <a class="J_Ajax link" href="/shop/search.htm?${sortparam}&amp;order=price-desc" title="价格从高到低">价格从高到低</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="location" id="alltime">
                        <div class="trigger">
                            <div class="inner">
                                        <span class="text" title=""><#if bo??>
                                            <#if bo.dd??>
                                                <#if bo.dd==-1>
                                                    自定义
                                                </#if>
                                                <#if bo.dd==0>
                                                    全部时间
                                                </#if>
                                                <#if bo.dd==1>
                                                    1日内
                                                </#if>
                                                <#if bo.dd==7>
                                                    1周内
                                                </#if>
                                                <#if bo.dd==30>
                                                    1月内
                                                </#if>
                                                <#if bo.dd==90>
                                                    3月内
                                                </#if>
                                                <#if bo.dd==180>
                                                    6月内
                                                </#if>
                                                <#if bo.dd==365>
                                                    1年内
                                                </#if>
                                            <#else>
                                                全部时间
                                            </#if>
                                        <#else>
                                            全部时间
                                        </#if>

                                                                                    </span>
                                <span class="icon icon-btn-arrow-2-h"></span>
                            </div>
                        </div>
                    <#assign timeparam="id="+shop.shopId/>
                    <#if bo??>
                        <#if bo.pstring??>
                            <#assign timeparam=timeparam+"&pstring="+bo.pstring/>
                        </#if>
                        <#if bo.cid??>
                            <#assign timeparam=timeparam+"&cid="+bo.cid/>
                        </#if>
                        <#if bo.scid??>
                            <#assign timeparam=timeparam+"&scid="+bo.scid/>
                        </#if>
                        <#if bo.beginPrice??>
                            <#assign timeparam=timeparam+"&beginPrice="+bo.beginPrice/>
                        </#if>
                        <#if bo.endPrice??>
                            <#assign timeparam=timeparam+"&endPrice="+bo.endPrice/>
                        </#if>
                        <#if bo.order??>
                            <#assign timeparam=timeparam+"&order="+bo.order/>
                        </#if>
                    </#if>
                        <div class="sections">
                            <ul class="clearfix">
                                <li><a href="?${timeparam}&dd=0">全部</a></li>
                                <li><a href="?${timeparam}&dd=1">1日内</a></li>
                                <li><a href="?${timeparam}&dd=7">1周内</a></li>
                                <li><a href="?${timeparam}&dd=30">1月内</a></li>
                                <li><a href="?${timeparam}&dd=90">3月内</a></li>
                                <li><a href="?${timeparam}&dd=180">6月内</a></li>
                                <li><a href="?${timeparam}&dd=365">1年内</a></li>
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

                                <input type="hidden" name="id" value="${shop.shopId}">
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
            <#if goodsList.content?size gt 0>
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
                                <span>¥</span> <strong>${g.price!}</strong>
                            </div>
                        </div>

                        <div class="tit">
                            <a href="/item.htm?id=${g.itemId}" target="_blank">${g.title!}</a>
                        </div>

                        <div class="btnview">
                            <a href="http://upload.571xz.com/publish.htm?id=${g.itemId}" target="_blank" class="contrast">
                                <i></i>
                                淘宝
                            </a>
                            <a href="http://1688.571xz.com/offer/publish.htm?id=${g.itemId}" target="_blank" class="contrast">
                                <i></i>
                                阿里
                            </a>
                            <a class="contrast sjb package" xzclick="addGoodsData" href="javascript:;" data-goodsid="${g.itemId}" title="加入数据包">
                                <i></i>
                                数据包
                            </a>
                        </div>
                    </div>
                </div>
            </#list>
            <#else>
                <div style="background: url(http://style.571xz.com/xz/css/img/ku.png) no-repeat center 70px; padding: 200px 0">
                    <p style="font-size: 18px; text-align: center;">Sorry, 未查询到相应商品~</p>
                </div>
            </#if>
            </div>
        </div>
    <#assign pageparam="id="+shop.shopId/>
    <#if bo??>
        <#if bo.pstring??>
            <#assign pageparam=pageparam+"&pstring="+bo.pstring/>
        </#if>
        <#if bo.cid??>
            <#assign pageparam=pageparam+"&cid="+bo.cid/>
        </#if>
        <#if bo.scid??>
            <#assign pageparam=pageparam+"&scid="+bo.scid/>
        </#if>
        <#if bo.beginPrice??>
            <#assign pageparam=pageparam+"&beginPrice="+bo.beginPrice/>
        </#if>
        <#if bo.endPrice??>
            <#assign pageparam=pageparam+"&endPrice="+bo.endPrice/>
        </#if>
        <#if bo.order??>
            <#assign pageparam=pageparam+"&order="+bo.order/>
        </#if>
        <#if bo.dd??>
            <#assign pageparam=pageparam+"&dd="+bo.dd/>
        </#if>
        <#if bo.startDate??>
            <#assign pageparam=pageparam+"&startDate="+bo.startDate/>
        </#if>
        <#if bo.endDate??>
            <#assign pageparam=pageparam+"&endDate="+bo.endDate/>
        </#if>
    </#if>
    <#assign href = "/shop/search.htm?${pageparam}&pageNo=">
    <#if goodsList.content?size gt 0>
        <div class="editpage clearfix" style="margin-top: 25px;">
            <div class="page-link">
                <ul class="page-link-ul">
                    <li<#if goodsList.number == 1> class="disabled"><a href="javascript:;">«</a><#else>><a title="上一页" href="${href}${goodsList.number - 1}">«</a></#if></li>
                    <#if goodsList.number <= 5 || goodsList.totalPages < 10>
                        <#assign start = 1>
                        <#if goodsList.totalPages < 9>
                            <#assign end = goodsList.totalPages>
                        <#else>
                            <#assign end = 9>
                        </#if>
                    <#else>
                        <#assign start = goodsList.number - 4>
                        <#assign end = goodsList.number + 4>
                        <#if goodsList.totalPages < end>
                            <#assign start = goodsList.totalPages - 8>
                            <#assign end = goodsList.totalPages>
                        </#if>
                    </#if>
                    <#list start..end as p>
                        <#if p gt 0>
                            <li <#if goodsList.number == p>class="current"><a href="javascript:;">${p}</a><#else>><a href="${href}${p}">${p}</a></#if></li>
                        </#if>
                    </#list>
                    <li<#if goodsList.number &gt;= goodsList.totalPages> class="disabled"><a href="javascript:;">»</a><#else>><a title="下一页" href="${href}${goodsList.number + 1}">»</a></#if></li>
                </ul>
                <span>${goodsList.number!}/${goodsList.totalPages}</span>
            </div>
        </div>
    </#if>
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