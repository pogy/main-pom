<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <title>${item.title} - 发布商品</title>
    <link href="public/css/global-min.css" type="text/css" rel="stylesheet">
    <link href="public/css/fabu20170108.css?t=012001" type="text/css" rel="stylesheet">
    <link href="public/css/tc-min.css" type="text/css" rel="stylesheet">
    <link href="public/css/saved_resource.css" type="text/css" rel="stylesheet">

    <script>
        var $build = true
    </script>
    <script type="text/javascript" src="public/js/jquery.min.js"></script>
    <script type="text/javascript" src="public/js/main.js?t=20170808"></script>
    <script type="text/javascript" src="public/js/ajax.js?t=2017102602"></script>
    <script src="//style.571xz.com/v6/gys/plugin/plupload2.1.2/plupload.full.min.js"></script>
    <script src="//style.571xz.com/v6/common/js/base_v20180509_194914.js"></script>
    <script src="//style.571xz.com/v6/common/js/xz_v20180511_135030.js"></script>
    <script type="text/javascript" src="public/js/webOSS.js"></script>
<body id="body" class="ke-webkit">
<div style="display:none;" id="skuData"></div>
<div class="site-nav">
    <div class="site-nav-bd clearfix">
        <div class="site-nav-js site-nav-l">
            <div class="user">
        <span>
          欢迎登录：
          <a target="_top" href="javascript:void(0)">${session_user_redis__.userNick}</a> <a href="//www.571xz.com/membertc.htm">退出</a>
            </span>
            </div>
        </div>
        <div class="site-nav-js site-nav-r">
            <a href="//www.571xz.com/">星座网首页</a>|
            <a href="//www.571xz.com/contact.htm" target="_blank">意见反馈</a></div>
    </div>
</div>

<div id="page">
    <form id="mainform" name="mainform" action="" method="post" enctype="multipart/form-data">
        <!--onsubmit="return validate_form()"-->
        <div class="hd clearfix">
            <span class="fl">拼多多宝贝发布</span></div>
        <div id="main">
            <div id="catPath">星座网类目：${xzCatName!} </div>
            <div id="catPath">拼多多类目：${pddCatName!} <a href="changeGoodsCate.htm?allCids=${allCids!}&goodsId=${(item.goodsId)!}" style=" color:#337ab7; margin-left:6px;">更换目录</a> </div>
            <div class="field clearfix">
                <label class="fl"><em>*</em>商品关键信息</label>
                <div class="field-content fl">
                    <div id="J_module-property" class="module-property module-form pddKeyInfo">
                        <div class="skin">
                            <ul class="ul-select">
                                <li>
                                    <label class="label-title">发货时间承诺：</label>
                                    <select name="delivery" class="keyPropClass">
                                        <option value="1" <#if returnsTemplate.delivery == 1>selected</#if>>48小时</option>
                                        <option value="0" <#if returnsTemplate.delivery == 0>selected</#if>>24小时</option>
                                    </select>
                                </li>
                                <li>
                                    <label class="label-title">7天无理由退换货：</label>
                                    <select name="returns" class="keyPropClass">
                                        <option value="1" <#if returnsTemplate.returns == 1>selected</#if>>是</option>
                                        <option value="0" <#if returnsTemplate.returns == 0>selected</#if>>否</option>
                                    </select>
                                </li>
                                <li>
                                    <label class="label-title">假一赔十：</label>
                                    <select name="artificial" class="keyPropClass">
                                        <option value="1" <#if returnsTemplate.artificial == 1>selected</#if>>是</option>
                                        <option value="0" <#if returnsTemplate.artificial == 0>selected</#if>>否</option>
                                    </select>
                                </li>
                            </ul>
                            <b class="setUserGoodsModule" id="setUserGoodsModule">设置模板</b><span class="moduleTip">(便于其他商品上传时使用设置的默认模板)</span>
                        </div>
                    </div>
                </div>
            </div>
            <#if fabricContent?? && goodsFabric??>
            <div class="field clearfix">
                <label class="fl"><em>*</em>商品成分</label>
                <div class="field-content fl">
                    <div id="J_module-property" class="module-property module-form pddKeyInfo">
                        <div class="skin">
                            <ul class="ul-select">
                                <li>
                                    <label class="label-title">商品面料：</label>
                                    <div class="J_spu-property J_ul-single" style="float: left">
                                        <select id="prop_0_select" class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                                            <#list goodsFabric as item>
                                                <option value="${item.code}">${item.desc}</option>
                                            </#list>
                                        </select>
                                        <div class="kui-combobox" role="combobox" data-iswrite="1">
                                            <div class="kui-dropdown-trigger">
                                                <input  class="kui-combobox-caption prop_from" readonly="true" value="" style="width:190px;" role="textbox" aria-autocomplete="list" aria-haspopup="true" aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                                <input type="hidden" name="goodsFabricCode" id="goodsFabricCode" class="upInfoItHide">
                                                <div class="kui-icon-dropdown"></div>  <!--data-value="//$sku_data_value_mini"-->
                                                <!--以为pid=122216588时候中文：流行元素/工艺+服装款式细节 他的defaul是数组所以如果是数组则用第一个-->
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <label class="label-title">面料含量：</label>
                                    <div class="J_spu-property J_ul-single" style="float: left">
                                        <select id="prop_0_select" class="keyPropClass" data-transtype="dropbox" style="display: none; visibility: hidden;">
                                            <#list fabricContent as item>
                                                <option value="${item.code}">${item.desc}</option>
                                            </#list>
                                        </select>
                                        <div class="kui-combobox" role="combobox" data-iswrite="1">
                                            <div class="kui-dropdown-trigger">
                                                <input  class="kui-combobox-caption prop_from" readonly="true" value="" style="width:190px;" role="textbox" aria-autocomplete="list" aria-haspopup="true" aria-label="上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项">
                                                <input type="hidden" name="fabricContentCode" id="fabricContentCode" class="upInfoItHide">
                                                <div class="kui-icon-dropdown"></div>  <!--data-value="//$sku_data_value_mini"-->
                                                <!--以为pid=122216588时候中文：流行元素/工艺+服装款式细节 他的defaul是数组所以如果是数组则用第一个-->
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            </#if>
            <!--一般商品属性-->
            <#--<#include "/pinduoudo/parts/normal_prop.ftl"/>-->
            <div class="field clearfix">
                <label class="fl">
                    <em>*</em>宝贝标题</label>

                <div class="field-content fl">
                    <input type="text" id="TitleID" class="text text-long notBeEmpty" data-error-title='宝贝标题'
                           name="title" value="${item.title}">
                    <span id="J_TitleCountDownTip" class="input-count"><span>${item.titleLength}</span>/60</span>
                    <a id="titleRule" class="readRule">查看规则</a>
                    <input type="hidden" id="nav_title" data-feed="err_nav_title">
                    <div id="err_nav_title" style="display:none">
                        <div class="errors">
                            <ul>
                                <li>
                                    <i class="icon iconfont icon-removecircle"></i>
                                    <span class="errorinfo">不能超过30个字或60个字符!</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="field clearfix">
                <label class="fl">短标题</label>

                <div class="field-content fl">
                    <input type="text" id="smallTitleID" class="text text-long" data-error-title='短标题'
                           name="smallTitle" value="">
                    <span id="J_smallTitleCountDownTip" class="input-count"><span>0</span>/20</span>
                    <a id="smallTitleRule" class="readRule">查看规则</a>
                    <input type="hidden" id="nav_smallTitle" data-feed="err_nav_title">
                    <div id="err_nav_smallTitle" style="display:none">
                        <div class="errors">
                            <ul>
                                <li>
                                    <i class="icon iconfont icon-removecircle"></i>
                                    <span class="errorinfo">不能超过10个字或20个字符!</span>

                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="field clearfix">
                <label class="fl"><em>*</em>商品描述</label>
                <div class="field-content fl">
                    <textarea id="SubheadingID" class="xzw-textarea" cols="77" rows="3" name="sellPoint" placeholder="建议200字以内">${item.title!}</textarea>
                    <span id="J_SubheadingCountDownTip" class="input-count" style="vertical-align: top;"><span>${item.titleLength}</span>/500</span>
                    <input type="hidden" id="nav_subTitle" data-feed="err_nav_subTitle">
                    <div id="err_nav_subTitle" style="display:none">
                        <div class="errors">
                            <ul>
                                <li>
                                    <i class="icon iconfont icon-removecircle"></i>
                                    <span class="errorinfo">不能超过250个字或500个字符!</span></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="field clearfix">
                <label class="fl"><em>*</em>市场价</label>
                <div class="field-content fl">
                    <input type="text" id="marketPrice" name="marketPrice" size="15" value="${(item.price?number * 2 + 100)?string("0.00")}" class="text text-pri notBeEmpty" data-error-title='市场价'>
                    <span class="pri">元</span>
                </div>
            </div>
            <div class="field clearfix">
                <label class="fl"><em>*</em>物流重量</label>
                <div class="field-content fl">
                    <input type="text" id="goodsWeight" name="goodsWeight" size="15" value="1" class="text text-weight notBeEmpty" data-error-title='物流重量' disabled>
                    <span class="pri">kg</span>
                </div>
            </div>
            <!--sku信息-->
            <#include "/pinduoduo/parts/sku.ftl"/>
            <div class="field clearfix">
                <label class="fl"><em>*</em>宝贝数量</label>
                <div class="field-content fl">
                    <input type="text" id="quantityId" class="text text-pri text-short J_Quantity" name="num" size="15" value="">
                    <span class="pri">件</span>
                </div>
            </div>
            <div class="field clearfix">
                <label class="fl">商家编码</label>
                <div class="field-content fl">
                    <input type="text" class="text text-bmlong notBeEmpty" data-error-title='商家编码' name="outerId"
                           size="64" value="${item.marketName!}_${item.shopNum!}_P${item.price!}_#${item.goodsNo!}">
                    <span class="pri">注：市场_档口_P价格_#货号</span></div>
            </div>
            <div class="field clearfix">
                <label class="fl">
                    <em>*</em>宝贝图片</label>
                <div class="field-content fl">
                    <div class="block info" style="margin: 0 0px 3px;">宝贝主图大小不能超过3MB；700*700 以上的图片上传以后宝贝详情页自动提供放大镜的功能
                    </div>
                    <div class="multmedia-wrap clearfix" id="multiImage">
                        <div class="multimage-wrap zhu-img">
                            <ul class="image-list">
                                <#assign imgs=item.imgSrcs>
                                <#list 1..5 as index>
                                <#if imgs[index_index]??>
                                    <li data-index="${index}" class="has-media">
                                        <input type="hidden" class="picUrl" name="picUrl[]" id="picurl${index}"
                                               value="${imgs[index_index]}">

                                        <div class="operate">
                                            <i class="icon iconfont icon-sortleft toleft" title="左移">&lsaquo;</i>
                                            <i class="icon iconfont icon-sortright toright" title="右移">&rsaquo;</i>
                                            <i class="icon iconfont icon-remove del" title="删除">x</i>
                                        </div>
                                        <div class="preview ">
                                            <a title="上传图片 " href="javascript:; " class="upload-tip" style="display: none;">
                                                <i class="icon iconfont icon-tianjia">+</i>
                                            </a>
                                            <div class="img">
                                                <img src="${imgs[index_index]}_400x400.jpg">
                                            </div>
                                        </div>
                                    </li>
                                <#else>
                                    <li data-index="${index}" class="has-media">
                                        <input type="hidden" class="picUrl" name="picUrl[]" id="picurl${index}" value="">

                                        <div class="operate">
                                            <i class="icon iconfont icon-sortleft toleft" title="左移">‹</i>
                                            <i class="icon iconfont icon-sortright toright" title="右移">›</i>
                                            <i class="icon iconfont icon-remove del" title="删除">x</i>
                                        </div>
                                        <div class="preview ">
                                            <a title="上传图片 " href="javascript:;" class="upload-tip" style="display: inline-block;">
                                                <i class="icon iconfont icon-tianjia">+</i>
                                            </a>
                                            <div class="img">
                                                <img src="">
                                            </div>
                                        </div>
                                    </li>
                                </#if>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="field clearfix">

                <div class="field clearfix">
                    <label class="fl"><em>*</em>宝贝描述</label>
                    <div class="field-content fl">
                        <div class="block info descImgTip" style="margin: 0 0px 3px;">当前商品共有 <#if item.detailsImgs?size gt 20>20<#else>${item.detailsImgs?size}</#if> 张图片</div>
                        <div class="multimage-wrap long-img ">
                            <ul class="image-list">
                                <#list item.detailsImgs as img>
                                    <#if img_index lt 20>
                                        <li data-index="${img_index}" class="has-media">
                                            <input type="hidden" class="picUrl" name="descPicUrl[]" id="descPicUrl${img_index}"
                                                   value="${img}">

                                            <div class="operate">
                                                <i class="icon iconfont icon-sortleft toleft" title="左移">&lsaquo;</i>
                                                <i class="icon iconfont icon-sortright toright" title="右移">&rsaquo;</i>
                                                <i class="icon iconfont icon-remove del" title="删除">x</i>
                                            </div>
                                            <div class="preview ">
                                                <a title="上传图片 " href="javascript:; " class="upload-tip" style="display: none;">
                                                    <i class="icon iconfont icon-tianjia">+</i>
                                                </a>
                                                <div class="img">
                                                    <a href="${img}" target="_blank"> <img src="${img}_400x400.jpg"></a>
                                                </div>
                                            </div>
                                        </li>
                                    </#if>
                                </#list>
                                <b class="addDimg" <#if item.detailsImgs?size gt 20>style="display:none"</#if>>+</b>
                            </ul>
                            <div class="block info" style="margin: 0 0px 3px;"></div>
                        </div>
                    </div>
                </div>



                <div class="field clearfix">
                    <label class="fl">
                        <em>*</em>运费</label>
                    <div class="field-content fl">
                        <div id="transport">
                            <div class="transport-item logis" id="J_Logistics">
                                <#if item.deliveyList??>
                                    <#assign deliveyList=item.deliveyList>
                                    <#assign erverDyTemplateId=item.erverDyTemplateId>
                                    <#include "/pinduoduo/parts/deliver.ftl">
                                 <#else>
                                    <span style="color:#f40; vertical-align: -3px;">您暂未设置运费模板，请前往拼多多商家管理后台进行设置！</span>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
                <h1> 宝贝其他信息</h1>
                <div class="field clearfix">
                    <label class="fl"><em>*</em>团购人数</label>
                    <div class="field-content fl">
                        <select name="grouponer" style="width: 194px;height: 26px;border: 1px solid #C9C9C9;">
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </select>
                    </div>
                </div>
                <div class="field clearfix">
                    <label class="fl"><em>*</em>单次限量</label>
                    <div class="field-content fl">
                        <input type="text" id="singleLimit" name="singleLimit" value="99999">
                    </div>
                </div>
                <div class="field clearfix">
                    <label class="fl"><em>*</em>限购次数</label>
                    <div class="field-content fl">
                        <input type="text" id="purchaseLimit" name="purchaseLimit" value="99999">
                    </div>
                </div>
                <div id="commit" class="floatbar rootStruct J_FlexSubmitBar">
                    <a href="javascript:;" id="J_LiRun">利润设置</a>
                    <span>|</span>利润：
                    <input type="text" id="curlirun" class="lr-txt" value="${item.profit}">元
                    <input id="event_submit_do_publish" type="button" onclick="checkform()" class="J_Submit pb-btn blue"
                           value="发 布" data-name="event_submit_do_publish"></div>
                <input type="hidden" id="pPrice" value="${item.price}">
                <input type="hidden" id="piPrice" value="${item.piPrice}">
                <input type="hidden" id="cid" name="cid" value="${pddCid}">
                <input type="hidden" id="tempCode" name="tempCode" value="${tempCode}">
                <input type="hidden" id="mid" name="mid" value="${item.goodsId}">
                <input type="hidden" id="domain" value="//upload.571xz.com/">
            </div>
    </form>
</div>
<div class="footer clearfix">
    <div class="footer-a">
        <a href="//zixun.571xz.com/article?id=67" target="_blank">关于星座网</a>
        <span>|</span>
        <a href="//www.571xz.com/contact.htm" target="_blank">联系我们</a>
        <span>|</span>
        <a href="//www.571xz.com/ruzhu.htm" target="">供应商入驻</a></div>
    <div class="footer-b">增值电信业务经营许可证：
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&id=4063" target="_blank">浙B2-20120165</a>
        <span>|</span>
        <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302">浙公网安备案
            33010202000302号
            <img src="public/images/beian.png"></a>
    </div>
    <div class="footer-c">Copyright © 2009-2017 星座网www.571xz.com 版权所有</div>
</div>


<!--index-->
<div class="pop" id="kc">
    <div class="sc_cancel">
        <i class="layui-layer-close"></i>
    </div>
    <div class="con">
        <div class="wrapper clearfix">

            <div id="J_FilterItems" class="app-page filter-items">
                <ul class="sui-nav clearfix">
                    <li class="upload-tab-title  active"><a href="javascript:;" data-type="0">本地上传</a></li>
                    <li class="area-tab-title file-tab"><a href="javascript:;" data-type="1">从图片空间选择</a></li>
                </ul>

                <form id="Tangram_PicListForm" action="" method="post">
                    <input id="J_MID" type="hidden" name="id" value="${item.goodsId}">
                    <input id="J_CurrentPage" type="hidden" name="pageid" value="1">
                    <input id="J_SelectType" type="hidden" name="type" value="1">
                    <select id="J_SelectCategory" style="display:none" name="category">
                        <option value="0">本地上传</option>
                        <option value="1">从图片空间选择</option>
                    </select>
                </form>

                <div class="tab-content">
                    <div class="upload-container">
                        <b id="J_MultimageField1" style="padding:6px 16px; background:#fff; border:1px solid #e8e8e8; color:#333; cursor:pointer; font-weight:normal;">图片上传</b>
                    </div>
                    <div class="upload-container" style="display:none;">
                        <div class="kongjian-table-container">
                            <ul id="J_ListTable" class="pic clearfix">
                            </ul>
                            <div class="page clearfix"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<!-- 设置利润 -->
<div class="pop hint-contentbox" id="L_liRun">
    <div class="content">
        <div id="liruncontent" class="lirun-tc">
            <#if profitTemplate??>
                <div class="cont">
                    <div class="l1">
                        <label>
                            <input type="checkbox" id="lirunauto" class="checkbox" <#if profitTemplate.actived == 1> checked="checked"</#if>>
                            自动设置利润
                        </label>
                    </div>
                    <div class="l2">
                        <input type="radio" id="lirun0" class="radio" name="_radio.lirun" value="1"
                               <#if profitTemplate.type == 1>checked="checked"</#if>>
                        <input id="lirunval0" type="text" value="${profitTemplate.profit}" class="txt">
                        元
                    </div>
                    <div class="l2">
                        <input type="radio" id="lirun1" class="radio" name="_radio.lirun" value="2"
                               <#if profitTemplate.type == 2>checked="checked"</#if>>
                        <input id="lirunval1" type="text" value="${profitTemplate.profit}" class="txt" disabled="">
                        %
                        <label>
                            <input type="checkbox" id="lirunzheng" class="checkbox" <#if profitTemplate.rounding == 1> checked="checked"</#if>>
                            结果取整
                        </label>
                    </div>
                </div>
            <#else>
                <div class="cont">
                <div class="l1">
                    <label>
                        <input type="checkbox" id="lirunauto" class="checkbox" checked="checked">
                        自动设置利润
                    </label>
                </div>
                <div class="l2">
                    <input type="radio" id="lirun0" class="radio" name="_radio.lirun" value="1"
                           checked="checked">
                    <input id="lirunval0" type="text" value="0" class="txt">
                    元
                </div>
                <div class="l2">
                    <input type="radio" id="lirun1" class="radio" name="_radio.lirun" value="2">
                    <input id="lirunval1" type="text" value="0" class="txt" disabled="">
                    %
                    <label>
                        <input type="checkbox" id="lirunzheng" class="checkbox" checked="checked">
                        结果取整
                    </label>
                </div>
            </div>
            </#if>
        </div>
    </div>
    <div class="button">
        <button class="btn btn-primary confirm">
            <span class="btn-txt">确定</span></button>
        <button class="btn btn-default layui-layer-close cancel">取消</button>
    </div>
</div>

<!--标题规则-->
<div class="pop hint-contentbox" id="L_titleRule">
    <div class="content">
        <img src="public/images/titleTip.png" alt width="650" height="434">
    </div>
</div>

<!--短标题标题规则-->
<div class="pop hint-contentbox" id="L_smallTitleRule">
    <div class="content">
        <img src="public/images/smallTitleTip.png" alt width="700" height="532">
    </div>
</div>

<!-- 发布 -->
<div class="pop" id="J_publish">
    <div class="content fb-con" style="padding:12px">
        <!--    <div  style="display: none"></div>-->
        <div>
            <p id="tip_default">
                <img src="//upload.571xz.com/public/images/loading.gif" align="absmiddle">
                正在上传中,请稍后
                <span id="imgType">开始计算图片</span>，一共<span id='imgAllNum'></span>张，当前第<span id='imgOrderNum'></span>张
            </p>
            <p id="tip_content"></p>
            <#--<p class="time-con" style="display:none;">已使用时间<input id="txt" vlaue="0">秒</p>-->
        </div>
        <#--<div class="" style="margin-top:10px;"><img src="public/images/2_1.png" style="max-width:530px;" /></div>-->
        <!--<a href="#" class="fb-btn">知道了</a>-->
    </div>
</div>
</body>
<script type="text/javascript" src="public/js/layer.js"></script>
<script type="text/javascript">
    <!--
    function setcity() {
        switch (document.mainform.prov.value) {
            case "安徽":
                var b = ["合肥(*)", "合肥", "安庆", "安庆", "蚌埠", "蚌埠", "亳州", "亳州", "巢湖", "巢湖", "滁州", "滁州", "阜阳", "阜阳", "贵池", "贵池", "淮北", "淮北", "淮化", "淮化", "淮南", "淮南", "黄山", "黄山", "九华山", "九华山", "六安", "六安", "马鞍山", "马鞍山", "宿州", "宿州", "铜陵", "铜陵", "屯溪", "屯溪", "芜湖", "芜湖", "宣城", "宣城"];
                break;
            case "北京":
                var b = ["北京", "北京"];
                break;
            case "重庆":
                var b = ["重庆", "重庆"];
                break;
            case "福建":
                var b = ["福州(*)", "福州", "福安", "福安", "龙岩", "龙岩", "南平", "南平", "宁德", "宁德", "莆田", "莆田", "泉州", "泉州", "三明", "三明", "邵武", "邵武", "石狮", "石狮", "永安", "永安", "武夷山", "武夷山", "厦门", "厦门", "漳州", "漳州"];
                break;
            case "甘肃":
                var b = ["兰州(*)", "兰州", "白银", "白银", "定西", "定西", "敦煌", "敦煌", "甘南", "甘南", "金昌", "金昌", "酒泉", "酒泉", "临夏", "临夏", "嘉峪关", "嘉峪关", "平凉", "平凉", "天水", "天水", "武都", "武都", "武威", "武威", "西峰", "西峰", "张掖", "张掖"];
                break;
            case "广东":
                var b = ["广州(*)", "广州", "潮阳", "潮阳", "潮州", "潮州", "澄海", "澄海", "东莞", "东莞", "佛山", "佛山", "河源", "河源", "惠州", "惠州", "江门", "江门", "揭阳", "揭阳", "开平", "开平", "茂名", "茂名", "梅州", "梅州", "清远", "清远", "汕头", "汕头", "汕尾", "汕尾", "韶关", "韶关", "深圳", "深圳", "顺德", "顺德", "阳江", "阳江", "英德", "英德", "云浮", "云浮", "增城", "增城", "湛江", "湛江", "肇庆", "肇庆", "中山", "中山", "珠海", "珠海"];
                break;
            case "广西":
                var b = ["南宁(*)", "南宁", "百色", "百色", "北海", "北海", "桂林", "桂林", "防城港", "防城港", "河池", "河池", "贺州", "贺州", "柳州", "柳州", "钦州", "钦州", "梧州", "梧州", "玉林", "玉林"];
                break;
            case "贵州":
                var b = ["贵阳(*)", "贵阳", "安顺", "安顺", "毕节", "毕节", "都匀", "都匀", "凯里", "凯里", "六盘水", "六盘水", "铜仁", "铜仁", "兴义", "兴义", "玉屏", "玉屏", "遵义", "遵义"];
                break;
            case "海南":
                var b = ["海口(*)", "海口", "儋县", "儋县", "陵水", "陵水", "琼海", "琼海", "三亚", "三亚", "五指山", "五指山", "万宁", "万宁"];
                break;
            case "河北":
                var b = ["石家庄(*)", "石家庄", "保定", "保定", "北戴河", "北戴河", "沧州", "沧州", "承德", "承德", "丰润", "丰润", "邯郸", "邯郸", "衡水", "衡水", "廊坊", "廊坊", "南戴河", "南戴河", "秦皇岛", "秦皇岛", "唐山", "唐山", "新城", "新城", "邢台", "邢台", "张家口", "张家口"];
                break;
            case "黑龙江":
                var b = ["哈尔滨(*)", "哈尔滨", "北安", "北安", "大庆", "大庆", "大兴安岭", "大兴安岭", "鹤岗", "鹤岗", "黑河", "黑河", "佳木斯", "佳木斯", "鸡西", "鸡西", "牡丹江", "牡丹江", "齐齐哈尔", "齐齐哈尔", "七台河", "七台河", "双鸭山", "双鸭山", "绥化", "绥化", "伊春", "伊春"];
                break;
            case "河南":
                var b = ["郑州(*)", "郑州", "安阳", "安阳", "鹤壁", "鹤壁", "潢川", "潢川", "焦作", "焦作", "济源", "济源", "开封", "开封", "漯河", "漯河", "洛阳", "洛阳", "南阳", "南阳", "平顶山", "平顶山", "濮阳", "濮阳", "三门峡", "三门峡", "商丘", "商丘", "新乡", "新乡", "信阳", "信阳", "许昌", "许昌", "周口", "周口", "驻马店", "驻马店"];
                break;
            case "湖北":
                var b = ["武汉(*)", "武汉", "恩施", "恩施", "鄂州", "鄂州", "黄冈", "黄冈", "黄石", "黄石", "荆门", "荆门", "荆州", "荆州", "潜江", "潜江", "十堰", "十堰", "随州", "随州", "武穴", "武穴", "仙桃", "仙桃", "咸宁", "咸宁", "襄阳", "襄阳", "襄樊", "襄樊", "孝感", "孝感", "宜昌", "宜昌"];
                break;
            case "湖南":
                var b = ["长沙(*)", "长沙", "常德", "常德", "郴州", "郴州", "衡阳", "衡阳", "怀化", "怀化", "吉首", "吉首", "娄底", "娄底", "邵阳", "邵阳", "湘潭", "湘潭", "益阳", "益阳", "岳阳", "岳阳", "永州", "永州", "张家界", "张家界", "株洲", "株洲"];
                break;
            case "江苏":
                var b = ["南京(*)", "南京", "常熟", "常熟", "常州", "常州", "海门", "海门", "淮安", "淮安", "江都", "江都", "江阴", "江阴", "昆山", "昆山", "连云港", "连云港", "南通", "南通", "启东", "启东", "沭阳", "沭阳", "宿迁", "宿迁", "苏州", "苏州", "太仓", "太仓", "泰州", "泰州", "同里", "同里", "无锡", "无锡", "徐州", "徐州", "盐城", "盐城", "扬州", "扬州", "宜兴", "宜兴", "仪征", "仪征", "张家港", "张家港", "镇江", "镇江", "周庄", "周庄"];
                break;
            case "江西":
                var b = ["南昌(*)", "南昌", "抚州", "抚州", "赣州", "赣州", "吉安", "吉安", "景德镇", "景德镇", "井冈山", "井冈山", "九江", "九江", "庐山", "庐山", "萍乡", "萍乡", "上饶", "上饶", "新余", "新余", "宜春", "宜春", "鹰潭", "鹰潭"];
                break;
            case "吉林":
                var b = ["长春(*)", "长春", "白城", "白城", "白山", "白山", "珲春", "珲春", "辽源", "辽源", "梅河", "梅河", "吉林", "吉林", "四平", "四平", "松原", "松原", "通化", "通化", "延吉", "延吉"];
                break;
            case "辽宁":
                var b = ["沈阳(*)", "沈阳", "鞍山", "鞍山", "本溪", "本溪", "朝阳", "朝阳", "大连", "大连", "丹东", "丹东", "抚顺", "抚顺", "阜新", "阜新", "葫芦岛", "葫芦岛", "锦州", "锦州", "辽阳", "辽阳", "盘锦", "盘锦", "铁岭", "铁岭", "营口", "营口"];
                break;
            case "内蒙古":
                var b = ["呼和浩特(*)", "呼和浩特", "阿拉善盟", "阿拉善盟", "包头", "包头", "赤峰", "赤峰", "东胜", "东胜", "海拉尔", "海拉尔", "集宁", "集宁", "临河", "临河", "通辽", "通辽", "乌海", "乌海", "乌兰浩特", "乌兰浩特", "锡林浩特", "锡林浩特"];
                break;
            case "宁夏":
                var b = ["银川(*)", "银川", "固原", "固原", "石嘴山", "石嘴山", "吴忠", "吴忠"];
                break;
            case "青海":
                var b = ["西宁(*)", "西宁", "德令哈", "德令哈", "格尔木", "格尔木", "共和", "共和", "海东", "海东", "海晏", "海晏", "玛沁", "玛沁", "同仁", "同仁", "玉树", "玉树"];
                break;
            case "山东":
                var b = ["济南(*)", "济南", "滨州", "滨州", "兖州", "兖州", "德州", "德州", "东营", "东营", "菏泽", "菏泽", "济宁", "济宁", "莱芜", "莱芜", "聊城", "聊城", "临沂", "临沂", "蓬莱", "蓬莱", "青岛", "青岛", "曲阜", "曲阜", "日照", "日照", "泰安", "泰安", "潍坊", "潍坊", "威海", "威海", "烟台", "烟台", "枣庄", "枣庄", "淄博", "淄博"];
                break;
            case "上海":
                var b = ["上海", "上海", "崇明", "崇明", "朱家角", "朱家角"];
                break;
            case "山西":
                var b = ["太原(*)", "太原", "长治", "长治", "大同", "大同", "候马", "候马", "晋城", "晋城", "离石", "离石", "临汾", "临汾", "宁武", "宁武", "朔州", "朔州", "忻州", "忻州", "阳泉", "阳泉", "榆次", "榆次", "运城", "运城"];
                break;
            case "陕西":
                var b = ["西安(*)", "西安", "安康", "安康", "宝鸡", "宝鸡", "汉中", "汉中", "渭南", "渭南", "商州", "商州", "绥德", "绥德", "铜川", "铜川", "咸阳", "咸阳", "延安", "延安", "榆林", "榆林"];
                break;
            case "四川":
                var b = ["成都(*)", "成都", "巴中", "巴中", "达州", "达州", "德阳", "德阳", "都江堰", "都江堰", "峨眉山", "峨眉山", "广安", "广安", "广元", "广元", "九寨沟", "九寨沟", "康定", "康定", "乐山", "乐山", "泸州", "泸州", "马尔康", "马尔康", "绵阳", "绵阳", "眉山", "眉山", "南充", "南充", "内江", "内江", "攀枝花", "攀枝花", "遂宁", "遂宁", "汶川", "汶川", "西昌", "西昌", "雅安", "雅安", "宜宾", "宜宾", "自贡", "自贡", "资阳", "资阳"];
                break;
            case "天津":
                var b = ["天津", "天津"];
                break;
            case "新疆":
                var b = ["乌鲁木齐(*)", "乌鲁木齐", "阿克苏", "阿克苏", "阿勒泰", "阿勒泰", "阿图什", "阿图什", "博乐", "博乐", "昌吉", "昌吉", "东山", "东山", "哈密", "哈密", "和田", "和田", "喀什", "喀什", "克拉玛依", "克拉玛依", "库车", "库车", "库尔勒", "库尔勒", "奎屯", "奎屯", "石河子", "石河子", "塔城", "塔城", "吐鲁番", "吐鲁番", "伊宁", "伊宁"];
                break;
            case "西藏":
                var b = ["拉萨(*)", "拉萨", "阿里", "阿里", "昌都", "昌都", "林芝", "林芝", "那曲", "那曲", "日喀则", "日喀则", "山南", "山南"];
                break;
            case "云南":
                var b = ["昆明(*)", "昆明", "大理", "大理", "保山", "保山", "楚雄", "楚雄", "东川", "东川", "个旧", "个旧", "景洪", "景洪", "开远", "开远", "临沧", "临沧", "丽江", "丽江", "六库", "六库", "潞西", "潞西", "曲靖", "曲靖", "思茅", "思茅", "文山", "文山", "西双版纳", "西双版纳", "玉溪", "玉溪", "中甸", "中甸", "昭通", "昭通"];
                break;
            case "浙江":
                var b = ["杭州(*)", "杭州", "安吉", "安吉", "慈溪", "慈溪", "定海", "定海", "奉化", "奉化", "海盐", "海盐", "黄岩", "黄岩", "湖州", "湖州", "嘉兴", "嘉兴", "金华", "金华", "临安", "临安", "临海", "临海", "丽水", "丽水", "宁波", "宁波", "瓯海", "瓯海", "平湖", "平湖", "千岛湖", "千岛湖", "衢州", "衢州", "江山", "江山", "瑞安", "瑞安", "绍兴", "绍兴", "嵊州", "嵊州", "台州", "台州", "温岭", "温岭", "温州", "温州", "舟山", "舟山"];
                break;
            case "香港":
                var b = ["香港", "香港", "九龙", "九龙", "新界", "新界"];
                break;
            case "澳门":
                var b = ["澳门", "澳门"];
                break;
            case "台湾":
                var b = ["台北(*)", "台北", "基隆", "基隆", "台南", "台南", "台中", "台中", "新竹", "新竹", "嘉义", "嘉义", "高雄", "高雄", "金门县", "金门县", "南投县", "南投县", "台北县", "台北县", "宜兰县", "宜兰县", "新竹县", "新竹县", "桃园县", "桃园县", "苗栗县", "苗栗县", "台中县", "台中县", "彰化县", "彰化县", "嘉义县", "嘉义县", "云林县", "云林县", "台南县", "台南县", "高雄县", "高雄县", "屏东县", "屏东县", "台东县", "台东县", "花莲县", "花莲县", "澎湖县", "澎湖县", "其它", "其它"];
                break;
            case "海外":
                var b = ["美国(*)", "美国", "英国", "英国", "法国", "法国", "瑞士", "瑞士", "澳洲", "澳洲", "新西兰", "新西兰", "加拿大", "加拿大", "奥地利", "奥地利", "韩国", "韩国", "日本", "日本", "德国", "德国", "意大利", "意大利", "西班牙", "西班牙", "俄罗斯", "俄罗斯", "泰国", "泰国", "印度", "印度", "荷兰", "荷兰", "新加坡", "新加坡", "其它国家", "其它国家"];
                break;
            default:
                var b = ["", ""]
        }
        document.mainform.city.options.length = 0;
        for (var a = 0; a < b.length / 2; a++) {
            document.mainform.city.options[a] = new Option(b[a * 2], b[a * 2 + 1]);
            if (document.mainform.city.options[a].value == "杭州") document.mainform.city.selectedIndex = a
        }
        if (true) return;
        var d = document.mainform.prov.value, c = document.location.href;
        if (d == "香港") if (c != null && (c.indexOf("personal_info.jhtml") >= 0 || c.indexOf("business_certify.jhtml") >= 0)) if (document.mainform._lang) {
            document.mainform._lang.value = "zh_HK:utf-8";
            document.mainform.submit()
        }
    }
    function initprovcity() {
        return;
        for (var b = document.mainform.prov, a = 0; a < document.mainform.prov.options.length; a++) if (document.mainform.prov.options[a].value == "浙江") document.mainform.prov.selectedIndex = a;
        setcity()
    }
    initprovcity()
    -->
</script>
<div style="display:none">
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255319538'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1255319538' type='text/javascript'%3E%3C/script%3E"));</script>
    <script src="http://s6.cnzz.com/stat.php?id=1697486&amp;web_id=1697486" language="JavaScript"></script>
</div>
</html>