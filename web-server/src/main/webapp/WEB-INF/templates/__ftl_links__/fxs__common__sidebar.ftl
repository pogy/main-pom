<div class="sidebar yahei">
    <#if $it.type == 'index'>
    <h2>交易管理</h2>
    <ul>
        <li>
            <a
                <#if 'myOrder' == $pageid >
                    class="selected"
                </#if>
                    href="/order/myOrder.htm"
            >我的订单</a>
        </li>
        <li>
            <a
                <#if 'myTbOrder' == $pageid >
                    class="selected"
                </#if>
                    href="/order/myTbOrder.htm"
                    target="_blank"
            >淘宝订单</a>
        </li>
        <li>
            <a
                <#if 'shManaOrder' == $pageid >
                    class="selected"
                </#if>
                    href="/order/shManaOrder.htm"
            >售后管理</a>
        </li>
        <#if session_user_redis__.otherPlatform.__moreOrder__ == true>
        <li>
            <a
                <#if 'myBatchTbOrder' == $pageid >
                    class="selected"
                </#if>
                        <#if 'tbBindGoodsNo' == $pageid >
                            class="selected"
                        </#if>
                    href="/order/myBatchTbOrder.htm"
                    target="_blank"
            >批量操作</a>
        </li>
        </#if>
    </ul>
    <h2>商品管理</h2>
    <ul>
        <li>
            <a
                <#if 'shiguOnekeyRecordinit' == $pageid >
                    class="selected"
                </#if>
                    href="/member/shiguOnekeyRecordinit.htm"
            >已上传的商品</a>
        </li>
        <li>
            <a
                <#if 'goodsCollectinit' == $pageid >
                    class="selected"
                </#if>
                        <#if 'goodsDataPackageinit' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/goodsCollectinit.htm"
            >我的数据包</a>
        </li>
        <li>
            <a
                <#if 'storeCollectinit' == $pageid >
                    class="selected"
                </#if>
                        <#if 'goodsCollectOriginal' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/storeCollectinit.htm"
            >我的收藏</a>
        </li>
    </ul>
    <h2>特色功能</h2>
    <ul>
        <li>
            <a
                <#if '//www.571xz.com/qualityControl.htm' == $pageid >
                    class="selected"
                </#if>
                    href="//www.571xz.com/qualityControl.htm"
                    target="_blank"
            >我要质检</a>
        </li>
    </ul>
    <h2>供应商申请</h2>
    <ul>
        <li>
            <a
                <#if 'storeIn' == $pageid >
                    class="selected"
                </#if>
                        <#if 'storeInAlter' == $pageid >
                            class="selected"
                        </#if>
                        <#if 'storeInRead' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/storeIn.htm"
            >店铺申请</a>
        </li>
    </ul>
    <h2>会员俱乐部</h2>
    <ul>
        <li>
            <a
                <#if 'awardInfo' == $pageid >
                    class="selected"
                </#if>
                    href="/member/awardInfo.htm"
            >开奖结果</a>
        </li>
        <li>
            <a
                <#if 'inviteVip' == $pageid >
                    class="selected"
                </#if>
                    href="/member/inviteVip.htm"
            >邀请有礼</a>
        </li>
    </ul>
    <#elseif $it.type == 'mybag'>
    <h2>我的钱包</h2>
    <ul>
        <li>
            <a
                <#if 'userBalance' == $pageid >
                    class="selected"
                </#if>
                        <#if 'iwantToRechargein5' == $pageid >
                            class="selected"
                        </#if>
                        <#if 'withdraw5Apply' == $pageid >
                            class="selected"
                        </#if>
                        <#if 'userBonus' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/userBalance.htm"
            >我的资金</a>
        </li>
        <li>
            <a
                <#if 'capStatistic' == $pageid >
                    class="selected"
                </#if>
                    href="/member/capStatistic.htm"
            >资金明细</a>
        </li>
        <li>
            <a
                <#if 'bindAlipayUser' == $pageid >
                    class="selected"
                </#if>
                        <#if 'bindAlipayUserOpe' == $pageid >
                            class="selected"
                        </#if>
                        <#if 'bindAlipaySuccess' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/bindAlipayUser.htm"
            >绑定设置</a>
        </li>
    </ul>
    <#elseif $it.type == 'safecenter'>
    <h2>安全中心</h2>
    <ul>
        <li>
            <a
                <#if 'safeindex' == $pageid >
                    class="selected"
                </#if>
                        <#if 'safexgmm' == $pageid >
                            class="selected"
                        </#if>
                        <#if 'safeXgPaymm' == $pageid >
                            class="selected"
                        </#if>
                    href="/member/safeindex.htm"
            >安全设置</a>
        </li>
        <li>
            <a
                <#if 'sysSetsindex' == $pageid >
                    class="selected"
                </#if>
                    href="/member/sysSetsindex.htm"
            >个人设置</a>
        </li>
        <li>
            <a
                <#if 'fenxiaoZhanghao' == $pageid >
                    class="selected"
                </#if>
                    href="/member/fenxiaoZhanghao.htm"
            >应用绑定</a>
        </li>
    </ul>
    </#if>
</div>