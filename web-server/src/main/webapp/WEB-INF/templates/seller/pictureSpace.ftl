<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>图片空间 - 供应商后台 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/gysV1/css/pictureSpace.css?v=20170821" rel="stylesheet">
    

    

    

    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
            <script src="http://style.571xz.com/v2/gysV1/plupload2.1.2/plupload.full.min.js"></script>
        
    
    <script src="http://style.571xz.com/v2/gysV1/js/pictureSpace.js?v=20170821"></script>
</head>
<body>


<#assign text>{}</#assign>
<#assign moduledata0=text?eval />
<#list [moduledata0] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            
            <div class="loginBox fl">
                
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                
                 
                <li class="noIndex">
                    <a href="${main_host!}" class="fcF40">四季星座网首页</a>
                </li>
                
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop> 
                <li class="noDown">
                    <a href="${main_host!}order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                        
                        
                    </a>
                </li>
                <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? > 
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
                            <ul>
                                <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
                <li class="noDown">
                    <a href="http://www.571xz.com/contact.htm" target="_blank">联系客服</a>
                </li>
                <#if webSite?? && webSite != ''>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon pa">
                            <h4 class="fs14 fcF40">市场大全</h4>
                            
                            <ul>
                                <li><a href="http://hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                </#if>
            </ul>
        </div>
    </div>
</div>










</#list>


<script>
var webSite = '${webSite!}';
</script>






<div class="header">
    <div class="layout">
        <a class="logo iconfont" href="http://www.571xz.com"></a>
        <i class="splitline"></i>
        <a class="shop" href="http://${session_user_redis__.logshop.webSite!}.571xz.com/${session_user_redis__.logshop.shopId!}">${session_user_redis__.logshop.market!}${session_user_redis__.logshop.shopNum!}</a>
    </div>
</div>




<div class="wrapper layout">
    
    <div class="sidebar shadowBox">

    <h2>商品管理</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/createGoods21init.htm"  >发布商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsList21init.htm"  >出售中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsListinit.htm?pinteger=2"  >仓库中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsNoListinit.htm"  >批量修改货号</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/xiufuGoods21init.htm"  >商品类目管理</a></li> 
        
        
    
    </ul> 

    <h2>店铺管理</h2>
    <ul>
    
        
        
        <li><a href="http://${session_user_redis__.logshop.webSite!}.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"  target="_blank">查看我的店铺</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/design.htm"  target="_blank">店铺装修</a></li> 
        
        
    
        
        <li><a class="selected"  href="${main_host!}seller/pictureSpace.htm">图片空间<i class="new"></i></a></li> 
        
    
        
        
        <li><a href="${main_host!}seller/shiguStoreerjiyuming.htm"  >二级域名</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/shiguStorebasicStore.htm"  >店铺资料</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/ghTongbu.htm"  >授权管理</a></li> 
        
        
    
    </ul> 

    <h2>财务信息</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/iwantToRechargein5.htm"  target="_blank">充值</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/withdraw5Apply.htm"  >提现</a></li> 
        
        
    
    </ul> 

    <h2>账号管理</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/safeindex.htm"  >安全设置</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/sysSetsindex.htm"  >个人信息</a></li> 
        
        
    
    </ul> 

    <h2>营销管理</h2>
    <ul>
    
        
        
        <li><a href="${main_host!}seller/dtggapply.htm?id=1001" class='dtgg' >免费LED广告</a></li> 
        
        
    
        
        
        <li><a href="https://shop121675953.taobao.com" target="_blank" style="color:#f40">广告位竞拍</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/indexgglist.htm" class='indexgg' >广告申请</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/promotion.htm"  >广告展示管理</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/actRegister.htm"  >立即报名活动</a></li> 
        
        
    
    </ul> 

</div>




    
    <script>
var shopId = '${session_user_redis__.logshop.shopId!}';
</script>

<div class="content shadowBox">
   <div class="headTitle fc6">
    <h2 class="fs16 fwb yahei">图片空间</h2>
</div>


   <div id="bodyContent" class="hideContent">
    
    <p class="loadingTips">图片空间加载中...</p>
    
    <div class="headButton">
    

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-blue
         uploadBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
    
        id="uploadBtn"
    
>

    
        上传
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

    

<#assign text>{}</#assign>
<#assign moduledata2=text?eval />
<#list [moduledata2] as $it>

    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <b 
    </#if>


    class="fmButton
        
         fmButton-white-b
         newFloderBtn"
    
        jbtn="newFloderBtn"
    
    
        
        <#if $it.title??>
            title=""
        </#if>
    
    
        
        <#if $it.id??>
            id=""
        </#if>
    
>

    
        新建文件夹
    


    <#if $it.href??>
    </a>
    <#else>
    </b>
    </#if>





</#list>

    <span class="fcF40">上传的文件为压缩包（zip、rar、7z），才可关联对应的商品哦！</span>
    
    <div class="imgSpace fr" id="pictureSpaceSizeInfo">
        <div class="allBar pr"><div class="bar" style="width:0%"></div></div>
        <p class="infotext fl">0M/0M</p>
        <p class="fr fc3">扩容功能即将上线</p>
    </div>
</div>


    <div class="fileList yahei" id="fileList">
    <div class="subNav" id="subNav"><span class="active">全部文件</span> <span class="fcBlue">&gt;</span> 2017年秋装</div>
    <div class="listTitle fc6">
        <ul class="clearfix">
            <li class="name">文件名称</li>
            <li class="size">大小</li>
            <li class="cjTime">创建时间</li>
        </ul>
    </div>
    <div class="fileItems" id="fileItemsBox">
        
        
        
    </div>
</div>


    
    
</div>

























































<div class="successTip pa"><i></i><span>文件上传成功！</span></div>
<div class="errorTip pa"><i></i><span>上传失败！单个文件大于150M！</span></div>






















































   
































</div>


</div>
<div class="footer">
    <div class="inner">
        <p class="sitemap"> 
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
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com 版权所有</span>
            <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank">增值电信业务经营许可证： 浙B2-20120165</a>
            | 
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank">
                <img src="http://style.571xz.com/v2/global/css/img/beian.png" alt="浙公网安备">
                浙公网安备 33010202000302号
            </a> 
        </p>
    </div>
</div>



<!--省略end，让浏览器自动添加-->




