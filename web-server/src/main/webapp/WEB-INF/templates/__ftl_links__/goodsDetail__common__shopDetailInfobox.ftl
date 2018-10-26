<div class="storeDetailInfobox">
    <div class="p1 clearfix">
        <ul class="r1">
            <li title="${shopInfo.marketName!}${shopInfo.floor!}"><label>地址：</label>
                <#if webSite == "hz">
                    杭州
                <#elseif webSite == "cs">
                    常熟
                <#elseif webSite == "gz">
                    广州
                <#elseif webSite == "ss">
                    石狮
                <#elseif webSite == "bj">
                    北京
                <#elseif webSite == "jx">
                    濮院
                <#elseif webSite == "qz">
                    泉州
                <#elseif webSite == "cz">
                    沧州
                </#if> - ${shopInfo.marketName!}${shopInfo.floor!}</li>
            <li><label>档口电话：</label>${shopInfo.mobile!}</li>
            <#if shopInfo.isZx??><li><label>发货咨询：</label>${shopInfo.advisoryMobile!}</li></#if>
            <li><label>主营：</label>${shopInfo.mainBus!}</li>
            <li><label>开店时间：</label>${shopInfo.openTime!}</li>
        </ul>
        <ul class="r2">
            <#if shopInfo.shopLicenses??>
                <#list shopInfo.shopLicenses as license>
                    <#if license.licenseType == 3>
                    <li><i class="i1"></i>实体认证</li>
                    </#if>
                </#list>
            </#if>
            <#if shopInfo.tbAuthState == '0'>
            <li><i class="i2"></i>未授权</li>
            <#elseif shopInfo.tbAuthState == '1'>
            <li><i class="i2"></i>同步授权</li>
            <#elseif shopInfo.tbAuthState == '2'>
            <li><i class="i2"></i>授权过期</li>
            </#if>
        </ul>
    </div>
    <div class="p2 clearfix">
        <b><a href="//www.571xz.com/shop.htm?id=${shopInfo.shopId!}">进入店铺</a></b>
        <#if shopInfo.tbUrl??>
        <a class="link" href="${shopInfo.tbUrl!}" target="_blank">淘宝店铺</a>
        </#if>
        <#if session_user_redis__?? && session_user_redis__.logshop??>
            <em class="b3 disabled">收藏档口</em>
        <#else>
            <b xzclick="collectShop" data-shopid="${shopInfo.shopId!}" class="b3"><i class="iconfont">&#xe6b3;</i>收藏档口</b>
        </#if>
    </div>
</div>