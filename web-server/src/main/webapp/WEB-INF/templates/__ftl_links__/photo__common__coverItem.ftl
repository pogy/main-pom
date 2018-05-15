<div class="coverItem pr yahei <#if $pageid == 'userHomePage' || $pageid == 'userWorkList'>smallMar</#if>">
    <a href="/photo/photoDetail.htm?id=${item.worksId!}" target="_blank" class="imgBox">
        <img src="${item.imgsrc!}_j300x300.jpg" />
    </a>
    <div class="infoBox">
        <a href="/photo/photoDetail.htm?id=${item.worksId!}" target="_blank" title="${item.title!}" class="ellip title">${item.title!}</a>
        <p class="fc9"><span>${item.typeName!}：${item.nick!}</span> <span class="fr">${item.address!}</span></p>
        <p class="fc9"><span class="publishedTime"><i class="icon-time"></i>${item.publishedTime!}</span> <span class="fr none"><i class="icon-store"></i>${item.thumbUpCount!}</span></p>
    </div>
    <#if $pageid == 'userWorkList'>
        <#if item.checkState !=1>
        <div class="opeBtnBox pa">
            <a href="/photo/auth/uploadWork.htm?id=${item.worksId!}" target="_blank"><i class="icon-s-edit fs16 fc9"></i></a>
            <b class="removeWorks" data-id="${item.worksId!}"><i class="icon-delete fs16 fc9"></i></b>
        </div>
        </#if>
    </#if>
    <#if item.checkState?? && item.checkState == 1>
        <div class="shadow">
            <h4>审核中...</h4>
            <p>请耐心等待</p>
        </div>
    <#elseif item.checkState?? && item.checkState == 2>
        <div class="shadow">
            <h4>未通过审核！</h4>
            <p>重复上传作品，图片不符合！<br/>图片不符合！</p>
        </div>
    </#if>
</div>