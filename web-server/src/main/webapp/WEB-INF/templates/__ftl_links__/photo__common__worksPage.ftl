<div class="worksPage">
    <#if totalPage gt 1>
    <b class="moreWorksBtn" data-id="${query.id!}" data-page="1" data-totalpage="${totalPage!}">查看更多精彩作品</b>
    <#else>
    <p class="tac fs16 fc3">没有更多了</p>
    </#if>
</div>