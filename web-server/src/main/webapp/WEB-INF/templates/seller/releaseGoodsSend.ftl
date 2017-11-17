
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>发布宝贝 - 供应商后台 - 四季星座网</title>

    
    
    
    
<#include "/common/host_config.ftl">





    
    <link href="http://style.571xz.com/v2/gysV1/css/releaseGoodsSend.css" rel="stylesheet">
    

    

    
    
    
    
    
    

    
        
            <link href="http://style.571xz.com/v2/gysV1/temp/webuploader/webuploader.css" rel="stylesheet">
        
    
        
    
        
    
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    
        
    
        
            <script src="http://style.571xz.com/v2/gysV1/temp/webuploader/webuploader.js"></script>
        
    
        
            <script src="http://style.571xz.com/v2/gysV1/plupload2.1.2/plupload.full.min.js"></script>
        
    
    <script src="http://style.571xz.com/v2/gysV1/js/releaseGoodsSend.js"></script>
    
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
                                <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
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
    
        
        <li><a class="selected"  href="${main_host!}seller/createGoods21init.htm">发布商品</a></li> 
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsList21init.htm"  >出售中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsListinit.htm?pinteger=2"  >仓库中的商品</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/storeGoodsNoListinit.htm"  >批量修改货号</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/xiufuGoods21init.htm"  >商品类目管理</a></li> 
        
        
    
    </ul> 

    <h2>店铺管理</h2>
    <ul>
    
        
        
        <li><a href="http://${session_user_redis__.logshop.webSite!}.571xz.com/shop.htm?id=${session_user_redis__.logshop.shopId!}"  target="_blank">查看我的店铺</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/design.htm"  target="_blank">店铺装修</a></li> 
        
        
    
        
        
        <li><a href="${main_host!}seller/pictureSpace.htm"  >图片空间<i class="new"></i></a></li> 
        
        
    
        
        
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




    
    <div class="content shadowBox pr">
    
    <form id="form-postgoods" autocomplete="off">
    
    <div class="category-box">
    <em class="fc6">类目：${category_text!}</em>
    <a href="${main_host!}seller/releaseGoodsinit.htm">重选类目</a>
    <input type="hidden" value="${get.cid!}" id="cat_id">
</div>



    
     
    
    <div class="form-input form-title">
        <label class="form-key"><i>*</i>宝贝标题：</label>
        <div class="form-data">
            <input id="goods-title" type="text" value="" size="30" maxlength="30" name="_fma.pu._0.ti" class="input">
            <span class="after-text">0/30</span>
        </div>
    </div>
    
    
    
    <div class="form-input form-subtitle">
        <label class="form-key">宝贝卖点：</label>
        <div class="form-data">
            <textarea id="sellPoint" type="text" value="" name="subTitle" class="input" maxlength="150"></textarea>
            <span class="after-text">0/150</span>
        </div>
    </div>
    
    
    <div class="formPriceAndGoodsNo clearfix">
    <label class="form-key"><i>*</i>批发价与货号：</label>
    <div class="formPriceAGnInfoCon clearfix fl">
        <div class="form-input form-inprice fl">
            <label class="form-key"><i>*</i>批发价</label>
            <div class="form-data">
                <input id="piPrice" type="text" value="" maxlength="12" name="_fma.pu._0.m" class="input">
            </div>
        </div>
        
        <div class="form-input form-count fl">
            <label class="form-key"><i>*</i>数量</label>
            <div class="form-data">
                <input id="quantity" type="text" value="" maxlength="12" name="_fma.pu._0.q" class="input">
            </div>
        </div>
        
        <div class="form-input form-oid fl">
            <label class="form-key"><i>*</i>商品货号</label>
            <div class="form-data">
                <input id="goodsNo" type="text" value="" maxlength="12" name="_fma.pu._0.o" class="input">
            </div>
        </div>
        
        <div class="form-input form-outprice fl">
            <label class="form-key">电商最低零售价</label>
            <div class="form-data">
                <input id="buynow" type="text" value="" maxlength="12" name="_fma.pu._0.m" class="input">
            </div>
        </div>
    </div>
</div>

    <div class="goodsFabric clearfix">
    <label class="form-key"><i>*</i>材料成分：</label>
    <div class="goodsFabricInfoCon clearfix fl">
        <div class="form-input formFabric fl">
            <label class="form-key"><i>*</i>面料成分</label>
            <div class="form-data">
                <input id="fabric" type="text" value="" maxlength="30" placeholder="最多可输入30个字符" name="" class="input">
            </div>
        </div>
        
        <div class="form-input formInFabric fl">
            <label class="form-key">里料成分</label>
            <div class="form-data">
                <input id="inFabric" type="text" value="" maxlength="30" placeholder="最多可输入30个字符" name="" class="input">
            </div>
        </div>
    </div>
</div>

    <div class="form-picks form-attribute">
    <label class="form-key">宝贝属性：</label>
    <div class="form-data">
        <p class="tips">填错宝贝属性，可能会引起宝贝下架，影响您的正常销售。请认真准确填写</p>
        <ul>
            <#list formAttribute as item>
            <li>
                <label class="attr-key"><#if item.need??><i>*</i></#if>${item.name!}</label>
                <div class="attr-value">
                <#if item.formitem.type == 'select'>
                    <select name="${item.formitem.name!}">
                        <option value=""></option>
                        <#list item.formitem.options as option>
                            <option value="${option.value!}">${option.text!}</option>
                        </#list>
                    </select>
                <#elseif item.formitem.type == 'checkbox'>
                    <div class="checkbox-wrapper">
                    <#list item.formitem.checkboxs as checkbox>
                    <label><input class="checkbox" type="checkbox" name="${checkbox.name!}" value="${checkbox.value!}">${checkbox.text!}</label>
                    </#list>
                    </div>
                <#else>
                    <input class="input" name="${item.formitem.name!}" <#if item.name=='货号：'>id="huohao"</#if> type="text">
                </#if>
                </div>
            </li>
            </#list>
        </ul>
    </div>
</div>

    <#list skuAttribute as item>
<div class="form-picks form-sku">
    <label class="form-key">${item.name!}</label>
    <div class="form-data">
    <#if item.type == 'colorset'>
        <ul class="sku-color">
            <#list item.formitems as formitem>
            <li>
                <input class="checkbox" id="sku_${formitem.key_!}" type="checkbox" value="${formitem.key!}" name="${formitem.checkboxName!}" data-color="${formitem.color!}">
                <label class="bgcolor" for="sku_${formitem.key_!}" style="background:${formitem.color!}"></label>
                <label class="bgtext" title="${formitem.cnname!}" for="sku_${formitem.key_!}">${formitem.cnname!}</label>
                <input class="input" type="text" value="${formitem.cnname!}" name="${formitem.inputName!}" maxlength="15">
                
            </li>
            </#list>
        </ul>
    <#elseif item.type == 'required'>
        <ul class="sku-box">
            <#list item.formitems as formitem>
            <li>
                <input class="checkbox" id="sku_${formitem.key_!}" type="checkbox" value="${formitem.key!}" name="${formitem.checkboxName!}">
                <label class="bgtext" title="${formitem.cnname!}" for="sku_${formitem.key_!}">${formitem.cnname!}</label>
                <input class="input" type="text" value="${formitem.cnname!}" name="${formitem.inputName!}" maxlength="15">
            </li>    
            </#list>
        </ul>
    </#if>
    </div>
</div>
</#list>



    
    
    <div class="form-input form-pic">
    <label class="form-key">宝贝图片：</label>
    <div class="form-data">
        <p class="tips">图片大小不能超过3M；700*700 以上的图片可以在宝贝详情页主图提供图片放大功能 </p>
        <ul class="clearfix">
            
            <li  class="active">
                <i class="iconfont bg icon-plus"></i>
                
                <span class="main-text"><i>*</i>宝贝主图</span>
                
                <div class="ct-box">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont toright icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    
                </div>
                <div class="waitgif"></div>
            </li>
            
            <li  >
                <i class="iconfont bg icon-plus"></i>
                
                <div class="ct-box">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont toright icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    
                </div>
                <div class="waitgif"></div>
            </li>
            
            <li  >
                <i class="iconfont bg icon-plus"></i>
                
                <div class="ct-box">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont toright icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    
                </div>
                <div class="waitgif"></div>
            </li>
            
            <li  >
                <i class="iconfont bg icon-plus"></i>
                
                <div class="ct-box">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont toright icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    
                </div>
                <div class="waitgif"></div>
            </li>
            
            <li  >
                <i class="iconfont bg icon-plus"></i>
                
                <div class="ct-box">
                    <i class="iconfont toleft icon-leftarrow"></i>
                    <i class="iconfont toright icon-rightarrow"></i>
                    <i class="iconfont delete icon-close"></i>
                </div>
                <div class="imgbox">
                    
                </div>
                <div class="waitgif"></div>
            </li>
            
        </ul>
    </div>
</div>




 
    <div class="form-input form-editor">
        <label class="form-key">宝贝描述：</label>
        <div class="form-data">
            <textarea id="J_ItemDescTextarea_newer" name="_fma.pu._0.d" style="width:745px; height:450px;"></textarea>
        </div>
    </div>
    
    
    <div class="moreImgUpload">
    <#if showMoreImgBtnIs == true>
    <b class="showMoreImgWindowBtn">选择要上传的图片</b>
    </#if>
</div>










































    
    <div class="form-submit pa">
        

<#assign text>{}</#assign>
<#assign moduledata1=text?eval />
<#list [moduledata1] as $it>


    
    <button class="button-base button-1" id="dosubmit">确认并发布宝贝</button>
    



</#list>


    </div>
    
    
    </form>
</div>

<link href="http://g.alicdn.com/kissy/k/1.4.7/editor/theme/cool/editor-min.css?1" rel="stylesheet">
<script src="http://g.alicdn.com/kissy/k/1.4.7/seed.js" data-config="{combine:true}"></script>
<script src="http://style.571xz.com/v2/gysV1/temp/deonkey.js"></script>













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




