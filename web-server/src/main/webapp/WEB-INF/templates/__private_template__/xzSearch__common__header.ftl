
<div class="header">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/v4/common/css/img/xz/mtLogo.png" alt width=168 height=30 />
            </a>
            <em></em>
        </div>
        
<div class="searchBar fr">
    <div class="tabList clearfix">
        <ul>
            
            <li type="goods" class="select">商品</li>
            
            <li type="store" >档口</li>
            
            
        </ul>
        <#if webSite == 'hz' || webSite == 'jx' || webSite == 'cs'>
        <a href="/picSearch.htm?webSite=${webSite!}" class="picSearchBox" target="_blank">图搜</a>
        </#if>
    </div>
    <div class="searchBox">
        
        <form id="formSearch"
            
                action="http://so.571xz.com/${webSite!}search.htm" 
            
            
        >
            
            
            
            
            <input type="text" class="searchCon fl" name="keyword" placeholder="输入商品名称" >
            <button type="submit" class="searchBtn fs14">搜索</button>
        </form>
    </div>
</div>






    </div>
</div>

