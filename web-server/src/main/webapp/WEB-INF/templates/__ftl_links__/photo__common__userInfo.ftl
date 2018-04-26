<div class="userInfo layout clearfix">
    <div class="leftInfoBox fl clearfix">
        <div class="imgBox fl">
            <img src="http://style.571xz.com/v6/photo/css/img/userHomePage/defaultTx.png" class="fl">
        </div>
        <div class="infoBox fl">
            <p class="userNick">
                ${userInfo.typeName!}：${userInfo.nick!}
            </p>
            <p class="generalInfo">
                <span><i class="icon-s-addr"></i>${userInfo.address!}</span>
                <span><i class="icon-s-phone2"></i>${userInfo.tele!}</span>
            </p>
        </div>
    </div>
    <div class="rightInfoBox fr">
        <img src="${userInfo.wxQrImgSrc!}">
    </div>
</div>