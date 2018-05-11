<div class="sidebar shadowBox yahei">
    <#if $it.type == 'index'>
    <#if session_user_redis__.logshop.webSite == 'hz'>
    <h2>交易管理</h2>
    <ul>
        <#if 'myOrder' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'myOrder' == $pageid >
                            selected
                    </#if>
                "
                    href="myOrder.htm"
            >我的订单</a>
        </li>
        </#if>
        <#if 'distributionOrder' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'distributionOrder' == $pageid >
                            selected
                    </#if>
                "
                    href="distributionOrder.htm"
            >配货订单</a>
        </li>
        </#if>
    </ul>
    </#if>
    <h2>商品管理</h2>
    <ul>
        <#if 'createGoods21init' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'createGoods21init' == $pageid >
                            selected
                    </#if>
                            <#if 'releaseGoodsinit' == $pageid >
                                    selected
                            </#if>
                            <#if 'releaseGoodsSend' == $pageid >
                                    selected
                            </#if>
                            <#if 'uploadPackageList' == $pageid >
                                    selected
                            </#if>
                "
                    href="createGoods21init.htm"
            >发布商品</a>
        </li>
        </#if>
        <#if 'storeGoodsList21init' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'storeGoodsList21init' == $pageid >
                            selected
                    </#if>
                            <#if 'storeGoodsList21init' == $pageid >
                                    selected
                            </#if>
                            <#if 'storeRecommendListinit' == $pageid >
                                    selected
                            </#if>
                "
                    href="storeGoodsList21init.htm"
            >出售中的商品</a>
        </li>
        </#if>
        <#if 'storeGoodsListinit' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'storeGoodsListinit' == $pageid >
                            selected
                    </#if>
                "
                    href="storeGoodsListinit.htm"
            >仓库中的商品</a>
        </li>
        </#if>
        <#if 'storeGoodsNoListinit' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'storeGoodsNoListinit' == $pageid >
                            selected
                    </#if>
                "
                    href="storeGoodsNoListinit.htm"
            >批量修改货号</a>
        </li>
        </#if>
        <#if 'xiufuGoods21init' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'xiufuGoods21init' == $pageid >
                            selected
                    </#if>
                "
                    href="xiufuGoods21init.htm"
            >商品类目管理</a>
        </li>
        </#if>
    </ul>
    <h2>店铺管理</h2>
    <ul>
        <#if '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' == $pageid >
                            selected
                    </#if>
                "
                    href="//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"
                    target="_blank"
            >查看我的店铺</a>
        </li>
        </#if>
        <#if 'design' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'design' == $pageid >
                            selected
                    </#if>
                "
                    href="design.htm"
                    target="_blank"
            >店铺装修</a>
        </li>
        </#if>
        <#if 'pictureSpace' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'pictureSpace' == $pageid >
                            selected
                    </#if>
                "
                    href="pictureSpace.htm"
            >图片空间<i class="new"></i></a>
        </li>
        </#if>
        <#if 'shiguStoreerjiyuming' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'shiguStoreerjiyuming' == $pageid >
                            selected
                    </#if>
                "
                    href="shiguStoreerjiyuming.htm"
            >二级域名</a>
        </li>
        </#if>
        <#if 'shiguStorebasicStore' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'shiguStorebasicStore' == $pageid >
                            selected
                    </#if>
                "
                    href="shiguStorebasicStore.htm"
            >店铺资料</a>
        </li>
        </#if>
        <#if 'ghTongbu' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'ghTongbu' == $pageid >
                            selected
                    </#if>
                "
                    href="ghTongbu.htm"
            >授权管理</a>
        </li>
        </#if>
        <#if 'goodsStyleManager' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'goodsStyleManager' == $pageid >
                            selected
                    </#if>
                "
                    href="goodsStyleManager.htm"
            >风格管理</a>
        </li>
        </#if>
    </ul>
    <h2>营销管理</h2>
    <ul>
        <#if 'dtggapply' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'dtggapply' == $pageid >
                            <#if pageForLed?? >
                                selected
                            </#if>
                    </#if>
                            <#if 'dtggapplyinfo' == $pageid >
                                    <#if pageForLed?? >
                                        selected
                                    </#if>
                            </#if>
                            <#if 'dtgglist' == $pageid >
                                    <#if pageForLed?? >
                                        selected
                                    </#if>
                            </#if>
                            <#if 'dtggapplyNull' == $pageid >
                                    <#if pageForLed?? >
                                        selected
                                    </#if>
                            </#if>
                    dtgg
                "
                    href="dtggapply.htm?id=1001"
            >免费LED广告</a>
        </li>
        </#if>
        <#if 'https://shop121675953.taobao.com' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'https://shop121675953.taobao.com' == $pageid >
                            selected
                    </#if>
                "
                    style="color:#f40"
                    href="https://shop121675953.taobao.com"
                    target="_blank"
            >广告位竞拍</a>
        </li>
        </#if>
        <#if 'indexgglist' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'indexgglist' == $pageid >
                            <#if pageForLed?? >
                            <#else>
                                selected
                            </#if>
                    </#if>
                            <#if 'dtggapplyinfo' == $pageid >
                                    <#if pageForLed?? >
                                    <#else>
                                        selected
                                    </#if>
                            </#if>
                            <#if 'dtgglist' == $pageid >
                                    <#if pageForLed?? >
                                    <#else>
                                        selected
                                    </#if>
                            </#if>
                            <#if 'dtggapplyNull' == $pageid >
                                    <#if pageForLed?? >
                                    <#else>
                                        selected
                                    </#if>
                            </#if>
                            <#if 'dtgglistFinish' == $pageid >
                                    <#if pageForLed?? >
                                    <#else>
                                        selected
                                    </#if>
                            </#if>
                    indexgg
                "
                    href="indexgglist.htm"
            >广告申请</a>
        </li>
        </#if>
        <#if 'promotion' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'promotion' == $pageid >
                            selected
                    </#if>
                "
                    href="promotion.htm"
            >广告展示管理</a>
        </li>
        </#if>
        <#if '//www.571xz.com/qualityControl.htm' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if '//www.571xz.com/qualityControl.htm' == $pageid >
                            selected
                    </#if>
                "
                    href="//www.571xz.com/qualityControl.htm"
                    target="_blank"
            >我要质检</a>
        </li>
        </#if>
        <#if 'actRegister' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'actRegister' == $pageid >
                            selected
                    </#if>
                "
                    href="actRegister.htm"
            >立即报名活动</a>
        </li>
        </#if>
    </ul>
    <#elseif $it.type == 'mybag'>
    <h2>我的钱包</h2>
    <ul>
        <#if 'userBalance' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'userBalance' == $pageid >
                            selected
                    </#if>
                            <#if 'withdraw5Apply' == $pageid >
                                    selected
                            </#if>
                            <#if 'iwantToRechargein5' == $pageid >
                                    selected
                            </#if>
                            <#if 'userBonus' == $pageid >
                                    selected
                            </#if>
                "
                    href="userBalance.htm"
            >我的资金</a>
        </li>
        </#if>
        <#if 'bindAlipayUser' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'bindAlipayUser' == $pageid >
                            selected
                    </#if>
                            <#if 'bindAlipayUserOpe' == $pageid >
                                    selected
                            </#if>
                            <#if 'bindAlipaySuccess' == $pageid >
                                    selected
                            </#if>
                "
                    href="bindAlipayUser.htm"
            >绑定设置</a>
        </li>
        </#if>
    </ul>
    <#elseif $it.type == 'safecenter'>
    <h2>安全中心</h2>
    <ul>
        <#if 'safeindex' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'safeindex' == $pageid >
                            selected
                    </#if>
                            <#if 'safexgmm' == $pageid >
                                    selected
                            </#if>
                            <#if 'safeXgPaymm' == $pageid >
                                    selected
                            </#if>
                "
                    href="safeindex.htm"
            >安全设置</a>
        </li>
        </#if>
        <#if 'sysSetsindex' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'sysSetsindex' == $pageid >
                            selected
                    </#if>
                "
                    href="sysSetsindex.htm"
            >个人信息</a>
        </li>
        </#if>
    </ul>
    <#elseif $it.type == 'goodsAblum'>
    <h2>相册管理</h2>
    <ul>
        <#if 'photoAlbumManagement' != 'xiufuGoods21init' || session_user_redis__.logshop.type == 1>
        <li>
            <a
                class="
                    <#if 'photoAlbumManagement' == $pageid >
                            selected
                    </#if>
                            <#if 'photoAlbumItem' == $pageid >
                                    selected
                            </#if>
                "
                    href="photoAlbumManagement.htm"
            >商品相册</a>
        </li>
        </#if>
    </ul>
    </#if>
</div>