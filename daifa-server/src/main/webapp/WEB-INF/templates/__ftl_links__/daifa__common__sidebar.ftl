<@shiro.hasAnyPermissions name="df:admin">
<#assign isAdmin = true />
</@shiro.hasAnyPermissions>
<@shiro.hasAnyPermissions name="df:feipei">
<#assign isFeiPei = true />
</@shiro.hasAnyPermissions>
<@shiro.hasAnyPermissions name="df:nahuo">
<#assign isNaHuo = true />
</@shiro.hasAnyPermissions>
<@shiro.hasAnyPermissions name="df:kefu">
<#assign isKeFu = true />
</@shiro.hasAnyPermissions>
<@shiro.hasAnyPermissions name="df:aftersale">
<#assign isAfterSale = true />
</@shiro.hasAnyPermissions>
<@shiro.hasAnyPermissions name="df:caiwu">
<#assign isCaiWu = true />
</@shiro.hasAnyPermissions>
<div class="sidebar fl yahei">
    <ul>
                <#if isAdmin == true || isFeiPei == true || isNaHuo == true || isKeFu == true || isAfterSale == true || isCaiWu == true>
            <li>
                <a
                    <#if 'orderAll' == $pageid >
                        class="current"
                    </#if>
                        href="orderAll.htm"
                    >
                    <i class="icon-allorders"></i>全部订单</a>
            </li>
                </#if>
                <#if isAdmin == true || isKeFu == true>
            <li>
                <a
                    <#if 'orderForServer' == $pageid >
                        class="current"
                    </#if>
                        href="orderForServer.htm"
                    >
                    <i class="icon-allorders"></i>客服查询</a>
            </li>
                </#if>
                <#if isAdmin == true || isFeiPei == true || isNaHuo == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>订单分配</a>
                <ul>
                    <li>
                        <a
                            <#if 'orderAllocation' == $pageid >
                                class="current"
                            </#if>
                            href="orderAllocation.htm"><i></i>任务分配</a>
                    </li>
                    <li>
                        <a
                            <#if 'orderHasAllocation' == $pageid >
                                class="current"
                            </#if>
                            href="orderHasAllocation.htm"><i></i>我的任务</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true || isFeiPei == true || isNaHuo == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>发货管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'scanBarCode' == $pageid >
                                class="current"
                            </#if>
                            href="scanBarCode.htm"><i></i>扫描打印</a>
                    </li>
                    <li>
                        <a
                            <#if 'hasBeenShipped' == $pageid >
                                class="current"
                            </#if>
                            href="hasBeenShipped.htm"><i></i>已发货订单</a>
                    </li>
                    <li>
                        <a
                            <#if 'notYetSipped' == $pageid >
                                class="current"
                            </#if>
                            href="notYetSipped.htm"><i></i>未发货订单</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true || isKeFu == true || isAfterSale == true || isCaiWu == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>售后管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'afterSaleOrder' == $pageid >
                                class="current"
                            </#if>
                            href="afterSaleOrder.htm"><i></i>售后订单</a>
                    </li>
                    <li>
                        <a
                            <#if 'parcelSweepCode' == $pageid >
                                class="current"
                            </#if>
                            href="parcelSweepCode.htm"><i></i>包裹扫码</a>
                    </li>
                    <li>
                        <a
                            <#if 'afterSaleProcess' == $pageid >
                                class="current"
                            </#if>
                            href="afterSaleProcess.htm"><i></i>售后处理</a>
                    </li>
                    <li>
                        <a
                            <#if 'parcelSearch' == $pageid >
                                class="current"
                            </#if>
                            href="parcelSearch.htm"><i></i>包裹查询</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true || isAfterSale == true || isCaiWu == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>财务管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'dfStatistic' == $pageid >
                                class="current"
                            </#if>
                            href="dfStatistic.htm"><i></i>代发统计</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true || isAfterSale == true || isKeFu == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>库存管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'allInventory' == $pageid >
                                class="current"
                            </#if>
                            href="allInventory.htm"><i></i>全部库存</a>
                    </li>
                    <li>
                        <a
                            <#if 'goodsPutInStorage' == $pageid >
                                class="current"
                            </#if>
                            href="goodsPutInStorage.htm"><i></i>商品入库</a>
                    </li>
                    <li>
                        <a
                            <#if 'goodsOutbound' == $pageid >
                                class="current"
                            </#if>
                            href="goodsOutbound.htm"><i></i>商品出库</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true || isNaHuo == true || isCaiWu == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>团队管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'takeGoodsStatistic' == $pageid >
                                class="current"
                            </#if>
                            href="takeGoodsStatistic.htm"><i></i>拿货统计</a>
                    </li>
                </ul>
            </li>
                </#if>
                <#if isAdmin == true>
            <li>
                <a
                    <#if '' == $pageid >
                        class="current"
                    </#if>
                        href="javascript:;"
                    >
                    <i class="icon-allorders"></i>快递管理</a>
                <ul>
                    <li>
                        <a
                            <#if 'showCourierTemp' == $pageid >
                                class="current"
                            </#if>
                            href="showCourierTemp.htm"><i></i>快递模板</a>
                    </li>
                    <li>
                        <a
                            <#if 'showCourierTemp' == $pageid >
                                class="current"
                            </#if>
                            href="showCourierTemp.htm"><i></i>订单操作信息</a>
                    </li>
                </ul>
            </li>
                </#if>
    </ul>
</div>