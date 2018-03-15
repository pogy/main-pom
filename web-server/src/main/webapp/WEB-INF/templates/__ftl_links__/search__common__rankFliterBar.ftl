<div class="formFilterBar clearfix" id="formFilterBar">
    <div class="sortTypeBox">
        <b jbtn="rankBySort" data-sort="comp" <#if query.sort?? && query.sort == 'comp'>class="selected"</#if>>综合</b>
        <b jbtn="rankBySort" data-sort="xp" <#if query.sort?? && query.sort == 'xp'>class="selected"</#if>>新品</b>
        <b jbtn="rankBySort" data-sort="popular" <#if query.sort?? && query.sort == 'popular'>class="selected"</#if>>人气</b>
    </div>
    <div class="sortPriceBox<#if query.sort == 'price-asc' || query.sort == 'price-desc'> actived</#if>">
        <#if query.sort == 'price-desc'>
            <b class="initial">批发价从高到低<i class="imgicon16"></i></b>
            <div class="hoverBox">
                <b class="selected">批发价从高到低</b>
                <b jbtn="rankBySort" data-sort="price-asc">批发价从低到高</b>
            </div>
        <#elseif query.sort == 'price-asc'>
            <b class="initial">批发价从低到高<i class="imgicon16"></i></b>
            <div class="hoverBox">
                <b class="selected">批发价从低到高</b>
                <b jbtn="rankBySort" data-sort="price-desc">批发价从高到低</b>
            </div>
        <#else>
        <b class="initial">批发价<i class="imgicon16"></i></b>
        <div class="hoverBox">
            <b jbtn="rankBySort" data-sort="price-asc" class="first">批发价从低到高</b>
            <b jbtn="rankBySort" data-sort="price-desc">批发价从高到低</b>
        </div>
        </#if>
    </div>
    <div class="filterPriceBox">
        <div class="innerbox">
            <input placeholder="&yen;" name="sp" id="sp" value="${query.sp!}">-<input placeholder="&yen;" id="ep" name="ep" value="${query.ep!}">
            <b id="searchPriceSE">确定</b>
        </div>
    </div>
    <div class="rtbox">
        <#if $pageid == "goods">
            <div class="dateClassify">
                <div class="inner">
                    <b jbtn="searchTime" <#if !query.d && !query.et && !query.st> class="selected"</#if> data-day="">全部</b>
                    <b jbtn="searchTime" <#if query.d =="1"> class="selected"</#if> data-day="1">1日内</b>
                    <b jbtn="searchTime" <#if query.d =="2"> class="selected"</#if> data-day="2">2日内</b>
                    <b jbtn="searchTime" <#if query.d =="3"> class="selected"</#if> data-day="3">3日内</b>
                </div>
            </div>
            <div class="sortTimeBox">
                <div class="bg1"></div>
                <b class="initial" <#if query.d gt 3 || query.st??> id="selected" </#if>>
                    <#if query.d??>
                        <#if query.d == '7'>
                            1周内
                        <#elseif query.d == '30'>
                            1月内
                        <#elseif query.d == '90'>
                            3月内
                        <#elseif query.d == '180'>
                            6月内
                        <#elseif query.d == '365'>
                            1年内
                        <#elseif query.d == '1' || query.d == '2' || query.d == '3'>
                            其他
                        </#if>
                    <#else>
                        <#if query.et?? || query.st??>
                            自定义时间
                        <#else>
                            其他
                        </#if>
                    </#if>
                <i class="imgicon16"></i></b>
                <div class="hoverBox">
                     <div class="innerbox">
                        <b jbtn="searchTime" <#if query.d =="7"> class="selected"</#if> data-day="7">1周内</b>
                        <b jbtn="searchTime" <#if query.d =="30"> class="selected"</#if> data-day="30">1月内</b>
                        <b jbtn="searchTime" <#if query.d =="90"> class="selected"</#if> data-day="90">3月内</b>
                        <b jbtn="searchTime" <#if query.d =="180"> class="selected"</#if> data-day="180">6月内</b>
                        <b jbtn="searchTime" <#if query.d =="365"> class="selected"</#if> data-day="365">1年内</b>
                        <b id="selfDefine" <#if query.st?? && query.et??> class="selected"</#if>>自定义</b>
                    </div>
                </div>
            </div>
        <#else>
        <div class="sortTimeBox">
            <div class="bg1"></div>
            <b class="initial">
                <#if query.d??>
                    <#if query.d == '1'>
                        1日内
                    <#elseif query.d == '7'>
                        1周内
                    <#elseif query.d == '30'>
                        1月内
                    <#elseif query.d == '90'>
                        3月内
                    <#elseif query.d == '180'>
                        6月内
                    <#elseif query.d == '365'>
                        1年内
                    </#if>
                <#else>
                    全部时间
                </#if>
            <i class="imgicon16"></i></b>
            <div class="hoverBox">
                <div class="innerbox">
                    <b jbtn="searchTime" <#if !query.d> class="selected"</#if> data-day="">全部</b>
                    <b jbtn="searchTime" <#if query.d =="1"> class="selected"</#if> data-day="1">1日内</b>
                    <b jbtn="searchTime" <#if query.d =="7"> class="selected"</#if> data-day="7">1周内</b>
                    <b jbtn="searchTime" <#if query.d =="30"> class="selected"</#if> data-day="30">1月内</b>
                    <b jbtn="searchTime" <#if query.d =="90"> class="selected"</#if> data-day="90">3月内</b>
                    <b jbtn="searchTime" <#if query.d =="180"> class="selected"</#if> data-day="180">6月内</b>
                    <b jbtn="searchTime" <#if query.d =="365"> class="selected"</#if> data-day="365">1年内</b>
                </div>
            </div>
        </div>
        </#if>
        <div class="defineTime">
            <i class="cal"></i>
            <input type="text" class="jqDatepicker" data-format="%Y-%M-%D" id="startTime" placeholder="开始时间">
            <input type="text" class="jqDatepicker" data-format="%Y-%M-%D" id="endTime" placeholder="结束时间">
            <button id="searchByUserTime">确定</button>
        </div>
        <div class="paginationBox">
            <i class="prevPage prev<#if query.page == 1> disabled</#if>"></i>
            <span><em class="curPage">${query.page!}</em>/<em class="totalPage">${totalPage!}</em></span>
            <i class="nextPage next<#if query.page == totalPage> disabled</#if>"></i>
        </div>
    </div>
</div>