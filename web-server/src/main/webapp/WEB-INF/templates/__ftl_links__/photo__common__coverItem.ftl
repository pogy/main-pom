<div class="coverItem <#if $pageid == 'userHomePage'>smallMar</#if>">
    <a href="photoDetail.htm?id=${item.worksId!}" target="_blank" class="imgBox">
        <img src="${item.imgsrc!}_300x300.jpg" />
    </a>
    <div class="infoBox">
        <a href="photoDetail.htm?id=${item.worksId!}" target="_blank" title="${item.title!}" class="ellip title">${item.title!}</a>
        <p class="fc9"><span>${item.typeName!}：${item.nick!}</span> <span class="fr">${item.address!}</span></p>
        <p class="fc9 fs14"><span class="publishedTime"><i class="icon-time"></i>${item.publishedTime!}</span> <span class="fr"><i class="icon-store"></i>${item.thumbUpCount!}</span></p>
    </div>
</div>