<div class="sidebar fl yahei">
    <ul>

        <li>
            <a id="niemenu" href="adminOrder.htm" ><i class="icon-allorders"></i>全部订单</a>
        </li>
        <li>
            <a id="niemenu" href="orderWaitSendList.htm" ><i class="icon-allorders"></i>未发货订单显示</a>
        </li>
        <li>
            <a href="javascript:;" ><i class="icon-allorders"></i>订单发货错误</a>
            <ul>
                <li>
                    <a id="niemenu" href="orderSendErrorindex.htm"><i></i>主单错误</a>
                </li>
                <li>
                    <a id="niemenu" href="sendTest.htm" ><i></i>测试发货修改</a>
                </li>
                <li>
                    <a id="niemenu" href="orderSendErrorSubindex.htm"><i></i>子单属性错误</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:;" ><i class="icon-allocation"></i>订单退款</a>
            <ul>
                <li>
                    <a id="niemenu" href="orderRefundList.htm"><i></i>订单退款</a>
                </li>
                <!--
                <li>
                    <a href="orderHasAllocation.htm"><i></i>我的任务</a>
                </li>
                -->
            </ul>
        </li>

        <li>
            <a href="javascript:;" ><i class="icon-allocation"></i>商品统计</a>
            <ul>

                <li>
                    <a id="niemenu" href="statisGoodsbyGoods.htm"><i></i>按商品统计</a>
                </li>
                <li>
                    <a id="niemenu" href="statisGoodsByStoreNum.htm"><i></i>按档口统计商品</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:;" ><i class="icon-allocation"></i>拿货相关</a>
            <ul>
                <li>
                    <a id="niemenu" href="ggoodsUnListByPage.htm"><i></i>拿货未完成数据</a>
                </li>
                <li>
                    <a id="niemenu" href="workerTakeGoods.htm"><i></i>分配的任务</a>
                </li>
            </ul>
        </li>

        <li>
            <a href="javascript:;" ><i class="icon-allocation"></i>系统管理</a>
            <ul>
                <li>
                    <a id="niemenu" href="workerListByPage.htm"><i></i>用户管理</a>
                </li>
                <li>
                    <a id="niemenu" href="roleListByPage.htm"><i></i>角色管理</a>
                </li>
                <li>
                    <a id="niemenu" href="userAndRole.htm"><i></i>用户角色</a>
                </li>
                <li>
                    <a id="niemenu" href="permissionListByPage.htm"><i></i>权限管理</a>
                </li>
                <li>
                    <a id="niemenu" href="roleAndPermission.htm"><i></i>角色权限</a>
                </li>
            </ul>
        </li>

    </ul>
</div>
<script>
    $(function(){
        var href=window.location.href.substring(window.location.href.lastIndexOf("/")+1);
        href=href.split("?")[0];
        $("a[id^='niemenu']").each(function(){
            if($(this).prop("href").indexOf(href)>0){
                $(this).prop("class","current");
            }
        });
    })
</script>