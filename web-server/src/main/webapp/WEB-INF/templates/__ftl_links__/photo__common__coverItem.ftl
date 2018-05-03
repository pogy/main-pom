<div class="coverItem pr yahei <#if $pageid == 'userHomePage' || $pageid == 'userWorkList'>smallMar</#if>">
    <a href="/photo/photoDetail.htm?id=${item.worksId!}" target="_blank" class="imgBox">
        <img src="${item.imgsrc!}_300x300.jpg" />
    </a>
    <div class="infoBox">
        <a href="/photo/photoDetail.htm?id=${item.worksId!}" target="_blank" title="${item.title!}" class="ellip title">${item.title!}</a>
        <p class="fc9"><span>${item.typeName!}：${item.nick!}</span> <span class="fr">${item.address!}</span></p>
        <p class="fc9"><span class="publishedTime"><i class="icon-time"></i>${item.publishedTime!}</span> <span class="fr"><i class="icon-store"></i>${item.thumbUpCount!}</span></p>
    </div>
    <#if $pageid == 'userWorkList'>
    <div class="opeBtnBox pa">
        <a href="/photo/auth/uploadWork.htm?id=${item.worksId!}" target="_blank"><i class="icon-s-edit fs16 fc9"></i></a>
        <b class="removeWorks" data-id="${item.worksId!}"><i class="icon-delete fs16 fc9"></i></b>
    </div>
    </#if>
</div>