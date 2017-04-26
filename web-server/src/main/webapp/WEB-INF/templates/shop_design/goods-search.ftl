<div class=" J_TModule" data-title="宝贝搜索" data-id="${moduleSet.moduleId}">
    <div class="skin-box tb-module tshop-pbsm-shop-srch-inshop" style="">
        <#if moduleSet.titleShow==1>
            <div class="skin-box-hd">
                <h3><span>${moduleSet.title!}</span></h3>
            </div>
        </#if>
        <div class="skin-box-bd">
            <form name="SearchForm" action="/shop/search.htm" method="get">
                <ul class="clearfix">
                    <li class="keyword">
                        <label>
                            <span class="key">关键字:</span>
                            <input type="text" size="18" name="keyword" autocomplete="off" value="${moduleSet.keyword!}" class="keyword-input prompt" placeholder="标题或货号">
                        </label>
                    </li>
                    <#if moduleSet.priceScreen == 1>
                        <li class="price">
                            <label>
                                <span class="key">&nbsp;&nbsp;&nbsp;价格:</span>
                                <input type="text" id="price1" name="lowPrice" class="J_TPrice1" size="4" value="">
                                <span class="connect-line">-</span>
                                <input type="text" id="price2" name="highPrice" class="J_TPrice2" size="4" value="">
                            </label>
                        </li>
                    </#if>

                    <li class="submit">
                        <input value="搜索" class="J_TSubmitBtn btn-ok" type="submit">
                    </li>
                    <li style="margin-left: 10px;">
                        <#if moduleSet.keywords??>
                            <#list moduleSet.keywords as key>
                                <span style="display: inline-block; margin: 0 2px;"><a href="/shop/search.htm?id=${shop.shopId}&amp;keyword=${key!}">${key!}</a></span>
                            </#list>
                        </#if>
                    </li>
                </ul>
                <input type="hidden" name="id" value="${shop.shopId}">
            </form>
        </div>
    </div>
</div>