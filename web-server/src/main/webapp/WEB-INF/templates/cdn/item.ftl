<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${vo.cdnItem.title!}-${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}-�ļ�������</title>
    
    <meta name="keywords" content="��ӭǰ���ļ�������ʵ�����ڣ�ѡ�� ${vo.cdnItem.title!}">
    
    <meta name="description" content="�ļ��������ļ���������������Ʒ�������Դ��һ��������һ���ϴ���${vo.cdnItem.title!}">
    
    
    
    
    <link href="http://style.571xz.com/shop_itemV2/css/item.css?t=1492654616644" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/shop_itemV2/js/item.js?t=1492654616644"></script>
    
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="web-topNav2016">
    <div class="topNav">
        <div class="navLeft">
            <span style="float:left">Hi,</span>
            <div class="menuHome" style="display: inline-block;">
            ��ӭ�����ļ�������!
                <span class="c_margin_l20">
                    <em>��</em>
                    <a onclick="login_backs()" target="_blank"><span class="login">��¼</span></a>
                </span>
                <a href="${main_host!}regedit.htm" target="_blank" class="c_margin_l10">���ע��</a>
                <a class="login c_margin_l20" href="${main_host!}ortherLogin.htm?ortherLoginType=1">�Ա���¼</a>
            </div>
        </div>
        <div class="navRight">
            <ul class="clearfix">
                <li class="navMap">
                    <div class="navIn">
                        <a href="${main_host!}member/index.htm">���Ǵ���<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div id="xzInfo" class="showBox">
                        <dl>
                        <dt style="display:none;">���Ǵ���</dt>
                            <dd>
                                <a rel="nofollow" href="${main_host!}member/shiguOnekeyRecordinit.htm" target="_blank">���ϴ�����Ʒ</a>
                            </dd>
                            <dd>
                                <a rel="nofollow" href="${main_host!}carts.htm" target="_blank">�ҵĹ��ﳵ</a>
                            </dd>
                        </dl>
                    </div>
                </li>
                <li class="navMap">
                    <div class="navIn">
                        <a href="javascript:;"><span class="iconfont ico2">&#xe615;</span>�ղؼ�<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="shoucang" >
                        <a rel="nofollow" class="favorite-offer" title="�ҵ��ղ�" href="${main_host!}member/storeCollectinit.htm?index=0" target="_blank">�ҵ��ղ�</a>
                        <a rel="nofollow" class="favorite-seller" title="�ҵ����ݰ�" href="${main_host!}member/goodsCollectinit.htm?webSite=hz" target="_blank">�ҵ����ݰ�</a>
                    </div>
                </li>
                <li class="navMap">
                    <div class="navIn">
                        <a href="${main_host!}seller/index.htm" target="_blank">��������<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="ghsht">
                        <a rel="nofollow" title="��������" href="${main_host!}seller/releaseGoodsinit.htm" target="_blank">��������</a>
                        <a rel="nofollow" title="�ѷ����ı���" href="${main_host!}seller/storeGoodsListinit.htm" target="_blank">�ѷ����ı���</a>
                    </div>
                </li>
                <li class="navMap">
                    <div class="customSe navIn">
                        <a href="<%=qq_qiye%>" target="_blank">�ͷ�����<span class="ico1 c_ico_jiantou"></span></a>
                    </div>
                    <div class="showBox" id="kfzx">
                          <dl>
                          <dt style="display:none;"><a href="<%=qq_qiye%>" target="_blank">�ͷ�����</a></dt>
                            <dd>
                                <a rel="nofollow" title="��ϵ�ͷ�" href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}"  target="_blank">���߿ͷ�</a>
                            </dd>
                            <dd>
                                <a rel="nofollow" title="��ϵ����" href="http://zixun.571xz.com/article?id=87"  target="_blank">��ϵ����</a>
                            </dd>
                             <dd>
                                <a rel="nofollow" title="��������" href="http://zixun.571xz.com/article?id=14" old_href="${main_host!}member/releaseGoodsinit.htm" target="_blank">��������</a>
                            </dd>
                        </dl>
                    </div>
                </li>
            </ul>
        </div>
        <div class="c_back_index fr clearfix"><a href="${main_host!}"><span class="iconfont">&#xe61e;</span>�ļ���������ҳ<span class="ico1 c_ico_jiantou"></span></a></div>
    </div>
</div>
<div class="rect-wrap clearfix">
    <div class="shopName">
    <a class="logo iconfont c_logo2016" href="http://${vo.storeRelation.webSite!}.571xz.com/index.html"><img src="http://style.571xz.com/global_temp/css/images/LOGO_2.png" title="�ļ�������-��ҳ" width="200" height="46"></a>
<div class="changeCity">
    <strong>
        <#if vo.storeRelation.webSite == "cs">����<#elseif vo.storeRelation.webSite == "hz">����<#elseif vo.storeRelation.webSite == "bj">����<#elseif vo.storeRelation.webSite == "ss">ʯʨ<#elseif vo.storeRelation.webSite == "wa">��Դ<#elseif vo.storeRelation.webSite == "gz">����</#if>
    </strong>
    <div class="topSelect">
     <a class="selectTit" href="javascript:;">�л�����</a>
     <span class="c_ico_jiantou"></span>
     <ul>
      <li<#if vo.storeRelation.webSite == "hz"> class="select"</#if>><a href="http://hz.571xz.com">����<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "cs"> class="select"</#if>><a href="http://cs.571xz.com" target="_blank">����<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "ss"> class="select"</#if>><a href="http://ss.571xz.com" target="_blank">ʯʨ<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "bj"> class="select"</#if>><a href="http://bj.571xz.com" target="_blank">����<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "gz"> class="select"</#if>><a href="http://gz.571xz.com" target="_blank">����<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
      <li<#if vo.storeRelation.webSite == "wa"> class="select"</#if>><a href="http://wa.571xz.com" target="_blank">��Դ<img src="http://static.571xz.com:86/images/xz.png" alt="selected" width="20" height="19"></a></li>
     </ul>
    </div>
</div>
        <h2>
            ${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}
            <a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=${vo.storeRelation.imWw!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><img src="http://static.571xz.com:86/resources2016/images/ww2016.png" alt="��ϵ����" width="16" height="18"></a>
            <#if vo.storeRelation.imQq?? && vo.storeRelation.imQq != "">
            <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank"><img src="http://static.571xz.com:86/resources2016/images/qq2016.png" alt="��ϵqq" width="16" height="18"></a>
            </#if>
        </h2>
        <div class="Diamonds pdl0 xinyuxingxingB">
            <div class="starnumbox">
            <#if vo.starNum lt 11>
                <i class="star1"></i>
            <#elseif vo.starNum lt 41>
                <i class="star1"></i>
                <i class="star1"></i>
            <#elseif vo.starNum lt 91>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
            <#elseif vo.starNum lt 151>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
            <#elseif vo.starNum lt 251>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
                <i class="star1"></i>
            <#elseif vo.starNum lt 501>
                <i class="star2"></i>
            <#elseif vo.starNum lt 1001>
                <i class="star2"></i>
                <i class="star2"></i>
            <#elseif vo.starNum lt 2001>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
            <#elseif vo.starNum lt 5001>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
            <#elseif vo.starNum lt 10001>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
                <i class="star2"></i>
            <#elseif vo.starNum lt 20001>
                <i class="star3"></i>
            <#elseif vo.starNum lt 50001>
                <i class="star3"></i>
                <i class="star3"></i>
            <#elseif vo.starNum lt 100001>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
            <#elseif vo.starNum lt 200001>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
            <#elseif vo.starNum lt 500001>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
                <i class="star3"></i>
            <#elseif vo.starNum lt 1000001>
                <i class="star4"></i>
            <#elseif vo.starNum lt 2000001>
                <i class="star4"></i>
                <i class="star4"></i>
            <#elseif vo.starNum lt 5000001>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
            <#elseif vo.starNum lt 10000001>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
            <#elseif vo.starNum gt 10000000>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
                <i class="star4"></i>
            </#if>
            </div>
            
            
            
            
       </div>
    </div>
    <form id="searchgo3" class="c_shop_search_2016" action="http://so.571xz.com/${vo.storeRelation.webSite!}search.htm">
    <button id="allSearchbtn">��ȫվ</button>
    <div class="shopSecrh">
        <div class="search">
            <input id="keyword" name="keyword" class="text-search" placeholder="�����������ؼ���" type="text">
            <input id="soInStore" class="btn-search" value="�ѱ�����" type="button">
        </div>
    </div>
    </form>
</div>
<div class="shopNav">
    <ul>
        <li><a href='<#if vo.domain != "">http://${vo.domain!}.571xz.com<#else>http://${vo.storeRelation.webSite!}.571xz.com/shop.htm?id=${vo.storeRelation.storeId!}</#if>'>������ҳ</a></li>
        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=2">ȫ����Ʒ</a></li>
        
        <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=4">�¼���Ʒ</a></li>
            <li><a href="shopcomment.htm?id=${vo.storeRelation.storeId!}">����������</a></li>
        <li class="all" style="float:right;"><a href="http://${vo.storeRelation.webSite!}.571xz.com/<#if vo.storeRelation.webSite == 'hz'>market.htm<#else>huoyuan</#if>">�����г�</a></li>
    </ul>
</div>
<div class="content_top layout">
    <div class="leftbox">
        <div class="shopContent">
            <div class="proBanner">
                <div class="bigBanner">
                    <ul>
                        <#list vo.cdnItem.imgUrl as img>
                        <#if img_index == 0>
                        <li><a href="javascript:;"><img id="conImage" src="${img!}_400x400.jpg"></a></li>
                        </#if>
                        </#list>
                    </ul>
                </div>
                <div class="imageBox">
                    <ul>
                        <#list vo.cdnItem.imgUrl as img>
                            <#if img_index lt 6>
                            <li class="" data_img='${img!}'><a href="javascript:;"><img src='${img!}_72x72.jpg'  width="72px" height="72px"></a></li>
                            </#if>
                        </#list>
                    </ul>
                </div>
                <div class="shareBox">
                    <a class="red" href="javascript:;" onclick="sc_goods(${vo.itemId!})" ><span class="iconfont">&#xe649;</span>�ղ���Ʒ<!--��228������--></a>
                    <a class="green" href="${qq_qy!}" target="_blankt"><span class="iconfont">&#xe677;</span>�ٱ�</a>
                </div>
            </div>
            <div class="proconInfo">
                <#if vo.onsale == true>
                <div class="ewm">
                    <span><div id="j_erweimahhh" style="width:100px;height:100px;background:url(http://www.571xz.com/images/loading_s.gif) center no-repeat;margin: 0 auto;"></div></span>
                    <p>ɨ��ά���ϴ�΢��<a style="font-size: 12px; color: #1179EA;" href="http://www.571xz.com/help_site/help.htm?p=xzwfx">(����)</a></p>
                </div>
                </#if>
                <div id="proTitle"><!--������������� ����Ҫ������,0 �Ա� 1 ���ݰ� 2��վ���� 3:���� -->
                    <#if vo.cdnItem.itemFrom.value == "taobao">
                    <a class="tb-main-title"  rel="nofollow" href="https://item.taobao.com/item.htm?id=${vo.cdnItem.tbNumIid!}" target="_blankt"><span class="iconfont" title="��ת���������Ա�ҳ�棬�鿴��Դ" >&#xe679;</span></a><h2>${vo.cdnItem.title!}</h2>
                    <#elseif vo.cdnItem.itemFrom.value == "package">
                    <span class="iconfont" title="����ƷΪ���ݰ��ϴ�">&#xe6a6;</span><h2>${vo.cdnItem.title!}</h2>
                    <#else>
                    <h2>${vo.cdnItem.title!}</h2>
                    </#if>
                </div>
                <div class="proPrice">
                    <p>���ۼۣ�<span class="style1">?${vo.cdnItem.price!}</span><a href="http://zixun.571xz.com/article?id=382" target="_blank" style="color: #ff4400; margin-left: 10px;">ʲô�����ۼۣ�</a></p>
                    <#if vo.cdnItem.price == vo.cdnItem.piPrice>
                    <p>�û��ۣ�<span class="style2" style="position: relative;">?${vo.cdnItem.piPrice!}<b class='iconfont alt_no_pi_price' alt='���ҿ���δ�Ը���Ʒ���������ۣ���֪ͨ����������������������' title='���ҿ���δ�Ը���Ʒ���������ۣ���֪ͨ����������������������'>&#xe630;</b></span></p>
                    <#else>
                    <p>�û��ۣ�<span class="style2">?${vo.cdnItem.piPrice!}</span></p>
                    </#if>
                </div>
                <table class="proconTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="name" width="64">�ϼ�ʱ�䣺</td>
                    <td>${vo.cdnItem.listTime!} <em>���ţ�</em>${vo.cdnItem.huohao!}<em>�����أ�</em>${vo.cdnItem.sendFrom!}</td>
                  </tr>
                  <tr>
                    <td class="name">ѡ����룺</td>
                    <td class="selectStyle"  id="size_id">
                    <#list vo.cdnItem.sizes as size>
                    <span class="radioBtn">
                        <label>
                            <input name="size" type="radio" data-value='${size.pid!}:${size.vid!}' title="${size.value!}"/>${size.value!}
                        </label>
                    </span>
                    </#list>
                    </td>
                  </tr>
                  <tr>
                    <td class="name">ѡ����ɫ��</td>
                    <td class="selectStyle" id="color_id">
                        <#list vo.cdnItem.colors as fcolor>
                            <#if fcolor.imgUrl?? && fcolor.imgUrl != "">
                            <span class="radioBtn" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}" style='width:30px;height:30px;background:url(${fcolor.imgUrl!}_30x30.jpg) center no-repeat;' alt='${fcolor.value!}'
                                  data_img='${fcolor.imgUrl!}' ><img src='${fcolor.imgUrl!}_30x30.jpg' width="30"></span>
                            <#else>
                            <span class="radioBtn" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}" ><label><input name="color" type="radio" data-value='${fcolor.pid!}:${fcolor.vid!}' title="${fcolor.value!}"  />${fcolor.value!}</label></span>
                            </#if>
                        </#list>
                    </td>
                  </tr>
                  <tr>
                    <td class="name">ѡ��������</td>
                    <td>
                        <div class="selectNum">
                            <a href="javascript:;" id="Cuts">-</a>
                            <input type="text" id="Num" value="1">
                            <a href="javascript:;" id="Add">+</a>
                        </div>
                        
                    </td>
                  </tr>
                   <#if vo.onsale == true>
                  <tr>
                      <td colspan="2">
                        <div  id="j_upload_btns"></div>
                        <div>
                            <button class="addPro imgDownload" xzclick="showDownloadWindow" data-goodsid="${vo.itemId!}">
                                <span>ͼƬ����</span>
                            </button>
                        </div>
                        <div id="j_upload_items">
                            <button class="keyUpload"  onclick="showOnkeyUploadWindow();this.blur();"  >
                                <span>һ���ϴ�</span>
                            </button>
                        </div>
                      </td>
                    
                  </tr>
                  <tr class="j_upload_item">
                    <td colspan="2">
                        <div class="boxBtn">
                            <a  class="first" href="http://www.571xz.net/publish.htm?id=${vo.itemId!}" target="_blankt"  alt="�ϴ��Ա�"  title="�����ť���ɽ�����Ʒֱ���ϴ��������Ա���" >���Ա�</a>
                            <a href="http://1688.571xz.com/offer/publish.htm?id=${vo.itemId!}" target="_blankt" alt="�ϴ�����"  title="�����ť���ɽ�����Ʒֱ���ϴ������İ���Ͱ�">������</a>
                             
                            <a href="javascript:;" onclick="sc_goods(${vo.itemId!})" title="�����ť���ɽ�����Ʒ�����������ݰ�"  data-hhh="20160307test4" >�����ݰ�</a>
                        </div>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                        <!--<p style="color:#ff4901"><font color="#666">��ʾ��</font>��������ƷΪ��֤�����Ŷӽӵ������߽���ֱ�����̼��µ���</p>-->
                    </td>
                  </tr>
                  <#else>
                  <tr>
                    <td colspan="2">
                    <div style="width: 100%;height: 150px;text-align: center;line-height: 150px;font-size: 42px;border: 3px #ddd dashed;">
                    ��Ʒ���¼�!
                    </div>
                    </td>
                  </tr>
                  </#if>
                </table>
            </div>
            
        </div>
        <input type="hidden" id="goodsId" value="${vo.itemId!}">
        <script>/*============ shop_itemV2/item#goodsinfo BEGIN ============*/

var marketId = ${vo.cdnItem.marketId!};
var storeId = ${vo.cdnItem.shopId!};
var item_id = ${vo.itemId!};
if(storeId == 34869){
    var supportStore=false;
}else{
    var supportStore=true;
}
var gysShopId = '${session_user_redis__.logshop.shopId!}';
if(gysShopId && gysShopId != ""){
    var isGys = true;
}else{
    var isGys = false;
}

/*============ shop_itemV2/item#goodsinfo END ============*/


</script>
    </div>
    <div class="rightbox">
        <div class="shopInfo">
            <h2>${vo.storeRelation.marketName!}${vo.storeRelation.storeNum!}</h2>
            <div class="Diamonds xinyuxingxingS">
                <div class="starnumbox">
                <#if vo.starNum lt 11>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 41>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 91>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 151>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 251>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                    <i class="star1"></i>
                <#elseif vo.starNum lt 501>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 1001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 2001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 5001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 10001>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                    <i class="star2"></i>
                <#elseif vo.starNum lt 20001>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 50001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 100001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 200001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 500001>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                    <i class="star3"></i>
                <#elseif vo.starNum lt 1000001>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 2000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 5000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum lt 10000001>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                <#elseif vo.starNum gt 10000000>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                    <i class="star4"></i>
                </#if>
                </div>
                
                
            </div>
            <ul class="setShow item_page">
                <#if vo.storeRelation.webSite == "hz" || vo.storeRelation.webSite == "cs" || vo.storeRelation.webSite == "ss" >
                <li>
                    <div class="iconfont cor1">&#xe63d;</div>
                    <p>һ������</p>
                </li>
                </#if>
                <#list vo.tags as tag>
                <#if tag == 1>
                    <li><div class="iconfont cor2">&#xe67a;</div><p>���ֽ�</p></li>
                </#if>
                <#if tag == 2>
                <li><div class="iconfont cor3">&#xe673;</div><p>������</p></li>
                </#if>
                </#list>
                
            </ul>
            <div class="txtInfo">
                <p>�г���${vo.storeRelation.marketName!} ${vo.storeRelation.floor!}</p>
                <p>�绰��<font color="#ff4901">${vo.storeRelation.telephone!}</font></p>
                <p>����Ʒ��棺${vo.cdnItem.num!}</p>
                
            </div>
            <ul class="contactUl" style="display:none">
                <li>���߿ͷ���</li>
                <li>
                    <#if vo.storeRelation.imQq?? && vo.storeRelation.imQq != "">
                    <a class="online" href="http://wpa.qq.com/msgrd?v=3&amp;uin=${vo.storeRelation.imQq!}&amp;site=qq&amp;menu=yes" target="_blank" style="color:#333"><i class="qq"></i>������ϵ</a>
                    </#if>
                    
                    
                    <a target="_blank" href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=${vo.storeRelation.imWw!}&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8"><img src="http://amos.alicdn.com/online.aw?v=2&amp;uid=${vo.storeRelation.imWw!}&amp;site=cntaobao&amp;s=1&amp;charset=utf-8" alt="��������ҷ���Ϣ" border="0"></a>
        
        
                </li>
            </ul>
            <div class="Coll">
                <ul>
                    <li><a href="javascript:;" id="scStore" data-id="${vo.storeRelation.storeId!}" title="�ղر���">�ղر���</a></li>
                    <#if vo.other.taobaoUrl != "">
                    <li><a href="${vo.other.taobaoUrl!}" rel="nofollow" target="_blank" title="�����������Ա�����">�����Ա���</a></li>
                    <#else>
                    <li><a class="disabled" rel="nofollow" target="_blank" title="�����������Ա�����">�����Ա���</a></li>
                    </#if>
                </ul>
            </div>
        </div>
        
        
    </div>
</div>
<script>/*============ shop_itemV2/item#showOnkeyUploadWindow BEGIN ============*/

var goodsId = '${vo.itemId!}';

/*============ shop_itemV2/item#showOnkeyUploadWindow END ============*/


</script>
<div class="content_main layout">
    <div class="leftbox">
        
        
<#assign text>{            "freemarker":true,            "fields":[                {"name":'id', 'value':${vo.storeRelation.storeId!}}            ]        }</#assign>
<#assign $it=text?eval />
                <form id="wgt_search">
            <#list $it.fields as field>
            <input type=hidden name="${field.name!}" value="${field.value!}">
            </#list>
        </form>
        
        <h2 class="shopStyle">վ������</h2>
        <ul class="searchInfo">
        <form>
            <input name="storeNumId" value="${vo.storeRelation.storeId!}" type="hidden">
            <li>��Ʒ��<input class="pro" name="keyword" id="pstring" value="" type="text"></li>
            <li>�۸�<input class="price j_Num" name="" placeholder="��" value="" id="beginPrice" type="text"><span>-</span><input class="price j_Num" name="" placeholder="��" value="" id="endPrice" type="text"></li>
            <li><input class="button" id="dosearchOnShop" value="ȷ��" type="button"></li>
        </form>
        </ul>
        
        <h2 class="shopStyle">��Ʒ����</h2>
        <ul class="sxUl">
            <li class="all"><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=2"><span class="iconfont">�O</span>�鿴���б���</a></li>
            <li class="allTime">
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=3">�����¿�</a>
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=5">���ܸ���</a>
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;timeflag=6">���¸���</a>
            </li>
        </ul>
        
        <#list vo.shopCats as cat>
            
            <span class="shopMenu" title="${cat.name!}">
                <a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;scid=${cat.cid!}&amp;timeflag=2">${cat.name!}</a>
                <#if cat.subCats??> 
                <span class="iconfont j_iconfont">&#xe658;</span>
                <#else>
                <span class="iconfont">&#xe676;</span>
                </#if>
            </span>
            
            <#if (cat.subCats?size) gt 0>
            <ul class="menuList">
                <#list cat.subCats as subCat>
                <li><a href="shop.htm?id=${vo.storeRelation.storeId!}&amp;scid=${subCat.cid!}&amp;timeflag=2">${subCat.name!}</a></li>
                </#list>
            </ul>
            </#if>
        
        </#list>
        
    </div>
    
    <div class="right">
        <div class="conRight">
            <h1 class="conTitle">
                <a class="select" href="javascript:;">��Ʒ����</a>
                <!-- <a href="javascript:;">��������</a> -->
            </h1>
            <ul class="shopConTab">
                <li class="shopli" style="display:block">
                    <div class="conProInfo">
                        <ul>
                            <#list vo.cdnItem.normalProps as prop>
                            <li title="${prop.value!}"><span>${prop.pname!}:</span>${prop.value!}</li>
                            </#list>
                        </ul>
                    </div>
                    <div class="proPicSow">
                        ${vo.cdnItem.description}
                    </div>
                </li>
           </ul>
        </div>
    </div>
    <div class="right2box">
        <div id="onkeyupFixbar" class="onkeyupFixbar">
            <div class="innerbox">
                <ul class="keybox">
                    <li><a class="btn" href="http://www.571xz.net/publish.htm?id=${vo.itemId!}" target="_blank"><i class="ii"></i><span>�ϴ����Ա�</span></a></li>
                    <li><a class="btn" href="http://1688.571xz.com/offer/publish.htm?id=${vo.itemId!}" target="_blank"><i class="ii"></i><span>�ϴ�������</span></a></li>
                    <li class="wxContainer"><b xzclick="showGoodsWx" data-goodsid="${vo.itemId!}"><i class="ii"></i><span>��������Ȧ</span></b><div id="wxEwmbox"></div></li>
                    <li class="addData"><b xzclick="addGoodsData"><i class="ii"></i><span>�������ݰ�</span></b></li>
                </ul>
                <div class="grewLine"></div>
                <div class="contactbox">
                    <h3>��ϵ����</h3>
                    <#if vo.storeRelation.imWw??><p class="wangwang">��������<#assign text>{"id":"${vo.storeRelation.imWw!}"}</#assign>
<#assign $it=text?eval />
<a class="imAliww" href="http://www.taobao.com/webww/ww.php?ver=3&touid=${$it.id!}&siteid=cntaobao&status=1&charset=utf-8" target="_blank"></a>
        </p></#if>
                    <#if vo.storeRelation.imQq??><p class="qq">����QQ<#assign text>{"id":"${vo.storeRelation.imQq!}"}</#assign>
<#assign $it=text?eval />
<#if $it.id != "">
        <a class="imQQ" href="http://wpa.qq.com/msgrd?v=3&uin=${$it.id!}&site=qq&menu=yes" target="_blank"></a>
        </#if>
        </p></#if>
                </div>
            </div>
        </div>
    </div>
</div>
<#if newGoodsList??>
<div class="newGoods layout">
    <h3>������Ʒ</h3>
    <#list newGoodsList as goods>
    <div class="goodsitem">
        <a class="imgbox" href="item.htm?id=${goods.itemId!}" target="_blank">
            <img class="lazyload img" src="http://style.571xz.com/xz/css/img/opacity0.png" data-original="${goods.imgUrl!}_240x240.jpg">
        </a> 
        <p class="p1">
            <span class="pricebox">&yen; ${goods.price!}</span>
        </p>
        <p class="title"><a href="item.htm?id=${goods.itemId!}" target="_blank">${goods.title!}</a></p>
    </div>
    </#list>
</div>
</#if>
<div class="footer">
    <div class="inner">
        <p class="sitemap" style="width:650px;"> 
            <a href="/" target="_blank">��ҳ</a>
            <a href="http://hz.571xz.com" target="_blank">����վ</a>
            <a href="http://bj.571xz.com" target="_blank">����վ</a>
            <a href="http://gz.571xz.com" target="_blank">����վ</a>
            <a href="http://ss.571xz.com" target="_blank">ʯʨվ</a>
            <a href="http://cs.571xz.com" target="_blank">����վ</a>
            <a href="http://wa.571xz.com" target="_blank">��Դվ</a>
            <a href="http://zixun.571xz.com" target="_blank">��Ѷ</a>
            
            
            <a href="http://zixun.571xz.com/article?id=87" target="_blank">��ϵ����</a>
            
        </p>
        <p class="imgs">
            <a class="img-aqlm" href="http://www.anquan.org/authenticate/cert/?site=www.571xz.com" target="_blank"></a>
            <a class="img-yyzz" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33010200000476" target="_blank" ></a>
            <a class="img-jyxkz" href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" title="��������Ӫ���֤" target="_blank"></a>
            <a class="img-jybz" href="http://www.315online.com.cn/" target="_blank"></a>
            <a class="img-cxwz" href="https://credit.szfw.org/CX20131217003383003800.html" target="_blank"></a>
        </p>
        <p class="jyga">
            <span>&copy; 2009-2017 571xz.com ��Ȩ����</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">���Ͻ����г��Ǽ�֤</a>
            <br> 
            <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">��ֵ����ҵ��Ӫ���֤�� ��B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="�㹫������"> �㹫������ 33010202000302�� </a>
        </p>
    </div>
</div>
</body>
</html>