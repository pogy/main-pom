<div class="topbar">
    <div class="layout">
        <div class="fl">
            <#if $it.disabledChooseCity == null || $it.disabledChooseCity == false>
            <div class="cityChooseBox fl pr">
                <span class="lable pr">
                    <em>
                        <#if webSite == 'hz'>
                            杭州
                        <#elseif webSite == 'cs'>
                            常熟
                        <#elseif webSite == 'ss'>
                            石狮
                        <#elseif webSite == 'bj'>
                            北京
                        <#elseif webSite == 'gz'>
                            广州
                        <#elseif webSite == 'jx'>
                            濮院
                        <#elseif webSite == 'qz'>
                            泉州
                        <#elseif webSite == 'zl'>
                            织里
                        <#elseif webSite == 'cz'>
                            沧州
                        <#else>
                            杭州
                        </#if>
                    </em>
                    <i class="downArrow"></i>
                </span>
                <ul>
                    <li><a href="//hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
                    <li><a href="//cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
                    <li><a href="//ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
                    <li><a href="//bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
                    <li><a href="//gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
                    <li><a href="//jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
                    <li><a href="//qz.571xz.com" <#if webSite == 'qz'>class="select"</#if>>泉州</a></li>
                    <li><a href="//cz.571xz.com" <#if webSite == 'cz'>class="select"</#if>>沧州</a></li>
                </ul>
            </div>
            </#if>
            <div class="loginBox fl">
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                <#if $it.disabledBackIndex == null || $it.disabledBackIndex == false>
                <li class="noIndex">
                    <a href="${mainHost!}/" class="fcF40">四季星座网首页</a>
                </li>
                </#if>
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop>
                <li class="noDown">
                    <a href="${mainHost!}/order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                    </a>
                </li>
                <li class="noDown"><a href="${mainHost!}/member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${mainHost!}/member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="${mainHost!}/member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${mainHost!}/member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${mainHost!}/member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="${mainHost!}/member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${mainHost!}/member/goodsCollectOriginal.htm">收藏的商品</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                </#if>
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? >
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${mainHost!}/seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
                            <ul>
                                <li><a href="${mainHost!}/seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="${mainHost!}/seller/storeGoodsList21init.htm">已发布的商品</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                </#if>
                <li class="noDown">
                    <a href="//www.571xz.com/contact.htm" target="_blank">联系我们</a>
                </li>
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            <ul></ul>
                        </div>
                    </div>
                </li>
                </#if>
                <li class="noDown">
                    <a href="//www.571xz.com/helpCenter/queIndex.htm" target="_blank">帮助中心</a>
                </li>
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><em>手机APP</em><i class="downArrow"></i></a>
                        <div class="appQr cnBoxCon pa">
                            <ul>
                                <li>
                                    <p><img src="//style.571xz.com/v6/common/img/AppDownloadQr.png" width="80" hieght="80"></p>
                                    <p class="fwb tac fs14">分销商App</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
                </#if>
            </ul>
        </div>
    </div>
</div>