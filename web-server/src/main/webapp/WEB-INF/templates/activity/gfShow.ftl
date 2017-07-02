<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
        <title>港风系列 - 四季星座网</title>
    
        <#if $it.keywords??>
        <meta name="keywords" content="${$it.keywords!}">
        </#if>
    
        <#if $it.description??>
        <meta name="description" content="${$it.description!}">
        </#if>
    
    <link href="http://style.571xz.com/fdGoodsV5/css/gfShow.css?t=1498990650457" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/fdGoodsV5/js/gfShow.js?t=1498990650457"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="content clearfix">
    <div class="bannerImg">
        <div class="imgShow">
            <img src="http://style.571xz.com/fdGoodsV5/css/img/banner.jpg" alt>
        </div>
    </div>
    <div class="detailInfo">
        <div class="goodsList layout pr">
                
                
            <ul>
                <#list goodsList as goodsItem>
                <li>
                    <a href="http://hz.571xz.com/item.htm?id=${goodsItem.goodsId!}" target="_blank">
                        <img src="${goodsItem.imgSrc!}_300x300.jpg" alt="${goodsItem.title!}" >
                    </a>
                    <h4 class="text-333"><a href="http://hz.571xz.com/item.htm?id=${goodsItem.goodsId!}" target="_blank">${goodsItem.title!}</a></h4>
                    <div class="goodsInfo clearfix pr text-f40">
                        <span class="goodsPrice"><i>&yen;</i>${goodsItem.piPriceString!}</span>
                        <a class="goodAddr text-999 pr" href="http://hz.571xz.com/shop.htm?id=${goodsItem.shopId!}" target="_blank" title="${goodsItem.marketName!} ${goodsItem.shopNum!}"><i></i>${goodsItem.marketName!} ${goodsItem.shopNum!}</a>
                    </div>
                </li>
                </#list>
            </ul>
        </div>
    </div>
    <div class="imgLoading">
        <div class="layout">
            <p>数据加载中……</p>
            <div class="loading"></div>
        </div> 
    </div>
</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:650px;"> 
            <a href="/" target="_blank">首页</a>
            <a href="http://hz.571xz.com" target="_blank">杭州站</a>
            <a href="http://bj.571xz.com" target="_blank">北京站</a>
            <a href="http://gz.571xz.com" target="_blank">广州站</a>
            <a href="http://ss.571xz.com" target="_blank">石狮站</a>
            <a href="http://cs.571xz.com" target="_blank">常熟站</a>
            <a href="http://wa.571xz.com" target="_blank">辽源站</a>
            <a href="http://jx.571xz.com" target="_blank">濮院站</a>
            <a href="http://zixun.571xz.com" target="_blank">资讯</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="互联网经营许可证" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">
</body>
</html>