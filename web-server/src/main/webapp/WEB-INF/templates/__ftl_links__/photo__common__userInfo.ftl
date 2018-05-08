<div class="userInfo layout clearfix yahei">
    <div class="leftInfoBox fl clearfix">
        <div class="imgBox pr fl">
            <div class="imgBoxOh">
                <#if userInfo.imgSrc??>
                <img src="${userInfo.imgSrc!}">
                <#else>
                <img src="http://style.571xz.com/v6/photo/css/img/userHomePage/defaultTx.png">
                </#if>
                <#if $pageid == 'userProfileEdit'>
                <b class="changeHeadPortrait" id="changeHeadPortrait">更换头像</b>
                </#if>
            </div>
        </div>
        <div class="infoBox fl">
            <p class="userNick">
                ${userInfo.typeName!}：${userInfo.nick!}
            </p>
            <p class="generalInfo">
                <span><i class="icon-s-phone2"></i>${userInfo.tele!}</span>
                <#if userInfo.address??>
                    <span><i class="icon-s-addr"></i>${userInfo.address!}</span>
                </#if>
            </p>
            <#if $pageid != "userHomePage" && $pageid != "userProfileEdit">
            <div class="userInfoEditBtnBox">
                <a href="/photo/member/userProfileEdit.htm">编辑</a>
            </div>
            </#if>
        </div>
    </div>
    <#if userInfo.wxQrCode??>
    <div class="rightInfoBox fr">
        <img src="${userInfo.wxQrCode!}">
        <p><i class="icon-s-weixin"></i>微信二维码</p>
    </div>
    </#if>
</div>