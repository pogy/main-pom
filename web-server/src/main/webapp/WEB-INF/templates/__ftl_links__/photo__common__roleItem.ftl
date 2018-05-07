<div class="roleItem yahei">
    <a href="/photo/userHomePage.htm?id=${item.userId!}" target="_blank" class="imgBox">
        <img src="${item.imgsrc!}_300x300.jpg" />
    </a>
    <div class="infoBox">
        <a href="/photo/userHomePage.htm?id=${item.userId!}" target="_blank" title="${item.userNick!}">
            <img src="${item.headImgSrc!}" /><span class="ellip">${item.userNick!}</span>
        </a>
        <span class="fr userAddr ellip"><i class="icon-s-addr"></i>${item.address!}</span>
    </div>
</div>