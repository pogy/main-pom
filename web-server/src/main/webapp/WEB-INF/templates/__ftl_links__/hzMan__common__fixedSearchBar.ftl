<div class="fixedSearchBar" id="fixedSearchBar">
    <div class="innner">
        <a class="logo" href="//www.571xz.com"><img src="//style.571xz.com/v6/common/css/img/xz/mtLogo.png" title="四季星座网-首页" height="30" width="170"></a>
         <div class="searchbar">
            <#if webSite == 'hz'>
            <div class="tabbox">
                <ul>
                    <li>商品</li>
                    <li>档口</li>
                </ul>
               <i class="img-jiantou"></i>
            </div>
            <#else>
            <div class="btnbox"><span>商品</span></div>
            </#if>
            <form action="//so.571xz.com/${webSite!}search.htm" target="_blank" id="searchgo3">
                <input type="hidden" name="cid" value="30">
                <input style="text-indent:1em;" class="text-search" name="keyword" type="text">
                <button class="btn-search">搜索</button>
            </form>
        </div>
    </div>
</div>