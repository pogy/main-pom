<div class="sidebar shadowBox yahei">
    <#if $it.type == 'index'>
        <#if session_user_redis__.logshop.webSite == 'hz'>
    <h2>交易管理</h2>
    <ul>
        <#if 'myOrder' != 'xiufuGoods21init' && 'myOrder' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'myOrder' != 'videoSpace' || 'myOrder' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'myOrder' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'distributionOrder' != 'xiufuGoods21init' && 'distributionOrder' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'distributionOrder' != 'videoSpace' || 'distributionOrder' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'distributionOrder' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
    </#if>
    <h2>商品管理</h2>
    <ul>
        <#if 'createGoods21init' != 'xiufuGoods21init' && 'createGoods21init' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'createGoods21init' != 'videoSpace' || 'createGoods21init' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'createGoods21init' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'storeGoodsList21init' != 'xiufuGoods21init' && 'storeGoodsList21init' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'storeGoodsList21init' != 'videoSpace' || 'storeGoodsList21init' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'storeGoodsList21init' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'storeGoodsListinit' != 'xiufuGoods21init' && 'storeGoodsListinit' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'storeGoodsListinit' != 'videoSpace' || 'storeGoodsListinit' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'storeGoodsListinit' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'storeGoodsNoListinit' != 'xiufuGoods21init' && 'storeGoodsNoListinit' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'storeGoodsNoListinit' != 'videoSpace' || 'storeGoodsNoListinit' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'storeGoodsNoListinit' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'xiufuGoods21init' != 'xiufuGoods21init' && 'xiufuGoods21init' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'xiufuGoods21init' != 'videoSpace' || 'xiufuGoods21init' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'xiufuGoods21init' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'goodsCategory' != 'xiufuGoods21init' && 'goodsCategory' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'goodsCategory' != 'videoSpace' || 'goodsCategory' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'goodsCategory' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
            <li>
                <a
                    class="
                        <#if 'goodsCategory' == $pageid >
                                selected
                        </#if>
                    "
                        href="goodsCategory.htm"
                >商品分类</a>
            </li>
            </#if>
            </#if>
        </#if>
    </ul>
    <h2>店铺管理</h2>
    <ul>
        <#if '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' != 'xiufuGoods21init' && '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' != 'videoSpace' || '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if '//www.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'design' != 'xiufuGoods21init' && 'design' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'design' != 'videoSpace' || 'design' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'design' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'pictureSpace' != 'xiufuGoods21init' && 'pictureSpace' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'pictureSpace' != 'videoSpace' || 'pictureSpace' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'pictureSpace' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
            <li>
                <a
                    class="
                        <#if 'pictureSpace' == $pageid >
                                selected
                        </#if>
                    "
                        href="pictureSpace.htm"
                >图片空间</a>
            </li>
            </#if>
            </#if>
        </#if>
        <#if 'videoSpace' != 'xiufuGoods21init' && 'videoSpace' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'videoSpace' != 'videoSpace' || 'videoSpace' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'videoSpace' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
            <li>
                <a
                    class="
                        <#if 'videoSpace' == $pageid >
                                selected
                        </#if>
                    "
                        href="videoSpace.htm"
                >视频空间<i class="new"></i></a>
            </li>
            </#if>
            </#if>
        </#if>
        <#if 'shiguStoreerjiyuming' != 'xiufuGoods21init' && 'shiguStoreerjiyuming' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'shiguStoreerjiyuming' != 'videoSpace' || 'shiguStoreerjiyuming' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'shiguStoreerjiyuming' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'shiguStorebasicStore' != 'xiufuGoods21init' && 'shiguStorebasicStore' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'shiguStorebasicStore' != 'videoSpace' || 'shiguStorebasicStore' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'shiguStorebasicStore' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'ghTongbu' != 'xiufuGoods21init' && 'ghTongbu' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'ghTongbu' != 'videoSpace' || 'ghTongbu' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'ghTongbu' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'goodsStyleManager' != 'xiufuGoods21init' && 'goodsStyleManager' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'goodsStyleManager' != 'videoSpace' || 'goodsStyleManager' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'goodsStyleManager' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
        <#if session_user_redis__.logshop.webSite != 'qz'>
    <h2>营销管理</h2>
    <ul>
        <#if 'dtggapply' != 'xiufuGoods21init' && 'dtggapply' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'dtggapply' != 'videoSpace' || 'dtggapply' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'dtggapply' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'https://shop121675953.taobao.com' != 'xiufuGoods21init' && 'https://shop121675953.taobao.com' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'https://shop121675953.taobao.com' != 'videoSpace' || 'https://shop121675953.taobao.com' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'https://shop121675953.taobao.com' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
                >广告竞拍/秒杀</a>
            </li>
            </#if>
            </#if>
        </#if>
        <#if 'indexgglist' != 'xiufuGoods21init' && 'indexgglist' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'indexgglist' != 'videoSpace' || 'indexgglist' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'indexgglist' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'promotion' != 'xiufuGoods21init' && 'promotion' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'promotion' != 'videoSpace' || 'promotion' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'promotion' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if '//www.571xz.com/qualityControl.htm' != 'xiufuGoods21init' && '//www.571xz.com/qualityControl.htm' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if '//www.571xz.com/qualityControl.htm' != 'videoSpace' || '//www.571xz.com/qualityControl.htm' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if '//www.571xz.com/qualityControl.htm' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'actRegister' != 'xiufuGoods21init' && 'actRegister' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'actRegister' != 'videoSpace' || 'actRegister' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'actRegister' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
    </#if>
    <#elseif $it.type == 'mybag'>
    <h2>我的钱包</h2>
    <ul>
        <#if 'userBalance' != 'xiufuGoods21init' && 'userBalance' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'userBalance' != 'videoSpace' || 'userBalance' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'userBalance' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'bindAlipayUser' != 'xiufuGoods21init' && 'bindAlipayUser' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'bindAlipayUser' != 'videoSpace' || 'bindAlipayUser' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'bindAlipayUser' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
    <#elseif $it.type == 'safecenter'>
    <h2>安全中心</h2>
    <ul>
        <#if 'safeindex' != 'xiufuGoods21init' && 'safeindex' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'safeindex' != 'videoSpace' || 'safeindex' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'safeindex' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
        <#if 'sysSetsindex' != 'xiufuGoods21init' && 'sysSetsindex' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'sysSetsindex' != 'videoSpace' || 'sysSetsindex' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'sysSetsindex' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
    <#elseif $it.type == 'goodsAblum'>
    <h2>相册管理</h2>
    <ul>
        <#if 'photoAlbumManagement' != 'xiufuGoods21init' && 'photoAlbumManagement' != 'ghTongbu' || session_user_redis__.logshop.type == 1>
            <#if 'photoAlbumManagement' != 'videoSpace' || 'photoAlbumManagement' == 'videoSpace' && session_user_redis__.logshop.type == 2 &&session_user_redis__.logshop.webSite == 'qz'>
            <#if 'photoAlbumManagement' != 'goodsCategory' || (session_user_redis__.logshop.type == 2 && (session_user_redis__.logshop.webSite == 'hz' || session_user_redis__.logshop.webSite == 'qz'))>
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
            </#if>
        </#if>
    </ul>
    </#if>
</div>