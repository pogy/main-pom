<div class="sidebar fl yahei">
    <ul>

        <@shiro.hasAnyPermissions name="df:admin">
        <li>
            <a id="daifamenu"  href="orderAll.htm" ><i class="icon-allorders"></i>全部订单</a>
        </li>
        </@shiro.hasAnyPermissions>
        <@shiro.hasAnyPermissions name="df:kefu">
        多个权限用这个
            <li>
                <a id="daifamenu" href="orderForServer.htm" ><i class="icon-allorders"></i>客服查询</a>
            </li>
        </@shiro.hasAnyPermissions>
        <@shiro.hasPermission name="tb:jklist">
        单一权限
            <li><a href="jklist.htm"><i class="fa fa-angle-double-right"></i> 接口列表</a></li>
        </@shiro.hasPermission>

        <li>
            <a  href="javascript:;" ><i class="icon-allocation"></i>订单分配</a>
            <ul>
                <li>
                    <a id="daifamenu" href="orderAllocation.htm"><i></i>任务分配</a>
                </li>
                <li>
                    <a id="daifamenu" href="orderHasAllocation.htm"><i></i>我的任务</a>
                </li>
            </ul>
        </li>
        <li>
            <a  href="javascript:;" ><i class="icon-allocation"></i>发货管理</a>
            <ul>
                <li>
                    <a id="daifamenu" href="scanBarCode.htm"><i></i>扫描打印</a>
                </li>
                <li>
                    <a id="daifamenu" href="hasBeenShipped.htm"><i></i>已发货订单</a>
                </li>
                <li>
                    <a id="daifamenu" href="notYetSipped.htm"><i></i>未发货订单</a>
                </li>
            </ul>
        </li>
        <li>
            <a  href="javascript:;" ><i class="icon-allocation"></i>售后管理</a>
            <ul>
                <li>
                    <a id="daifamenu" href="afterSaleOrder.htm"><i></i>售后订单</a>
                </li>
                <li>
                    <a id="daifamenu" href="parcelSweepCode.htm"><i></i>包裹扫码</a>
                </li>
                <li>
                    <a id="daifamenu" href="afterSaleProcess.htm"><i></i>售后处理</a>
                </li>
                <li>
                    <a id="daifamenu" href="parcelSearch.htm"><i></i>包裹查询</a>
                </li>
            </ul>
        </li>
        <@shiro.hasAnyPermissions name="df:caiwu">
        <li>
            <a  href="javascript:;" ><i class="icon-allocation"></i>财务管理</a>
            <ul>
                <li>
                    <a id="daifamenu" href="financialStatistic.htm"><i></i>财务统计</a>
                </li>
            </ul>
        </li>
        </@shiro.hasAnyPermissions>
    </ul>
</div>