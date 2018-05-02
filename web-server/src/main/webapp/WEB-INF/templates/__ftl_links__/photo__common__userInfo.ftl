<div class="userInfo layout clearfix yahei">
    <div class="leftInfoBox fl clearfix">
        <div class="imgBox pr fl">
            <img src="http://style.571xz.com/v6/photo/css/img/userHomePage/defaultTx.png" class="fl">
            <#if $pageid == 'userProfileEdit'>
            <b class="changeHeadPortrait" id="changeHeadPortrait">更换头像</b>
            </#if>
        </div>
        <div class="infoBox fl">
            <p class="userNick">
                ${userInfo.typeName!}：${userInfo.nick!}
            </p>
            <p class="generalInfo">
                <span><i class="icon-s-addr"></i>${userInfo.address!}</span>
                <span><i class="icon-s-phone2"></i>${userInfo.tele!}</span>
            </p>
            <#if $pageid != "userHomePage" && $pageid != "userProfileEdit">
            <div class="userInfoEditBtnBox">
                <a href="member/userProfileEdit.htm">编辑</a>
            </div>
            </#if>
        </div>
    </div>
    <#if userInfo.wxQrCode??>
    <div class="rightInfoBox fr">
        <img src="${userInfo.wxQrCode!}">
    </div>
    </#if>
</div>