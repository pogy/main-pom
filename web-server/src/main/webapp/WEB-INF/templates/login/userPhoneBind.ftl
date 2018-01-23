<#assign $pageid="userPhoneBind">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>绑定手机 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/login__common_css.ftl">
<#include "/__style_torrent__/login__userPhoneBind_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/login__userPhoneBind_js.ftl">
</head>
<body>
<#list [{}] as $it>
<div class="topbar">
    <div class="layout">
        <div class="fl">
            <#if $it.disabledChooseCity == null || $it.disabledChooseCity == false>
            <div class="cityChooseBox fl pr">
                <span class="lable pr">
                    <em>
                        <#if webSite == 'hz'>
                            杭州
                        <#elseif webSite == 'cs'>
                            常熟
                        <#elseif webSite == 'ss'>
                            石狮
                        <#elseif webSite == 'bj'>
                            北京
                        <#elseif webSite == 'gz'>
                            广州
                        <#elseif webSite == 'jx'>
                            濮院
                        <#else>
                            杭州
                        </#if>
                    </em>
                    <i class="downArrow"></i>
                </span>
                <ul>
                    <li><a href="http://hz.571xz.com" <#if webSite == 'hz'>class="select"</#if>>杭州</a></li>
                    <li><a href="http://cs.571xz.com" <#if webSite == 'cs'>class="select"</#if>>常熟</a></li>
                    <li><a href="http://ss.571xz.com" <#if webSite == 'ss'>class="select"</#if>>石狮</a></li>
                    <li><a href="http://bj.571xz.com" <#if webSite == 'bj'>class="select"</#if>>北京</a></li>
                    <li><a href="http://gz.571xz.com" <#if webSite == 'gz'>class="select"</#if>>广州</a></li>
                    <li><a href="http://jx.571xz.com" <#if webSite == 'jx'>class="select"</#if>>濮院</a></li>
                </ul>
            </div>
            </#if>
            <div class="loginBox fl">
            </div>
        </div>
        <div class="fr">
            <ul class="menuContainer">
                <#if $it.disabledBackIndex == null || $it.disabledBackIndex == false>
                <li class="noIndex">
                    <a href="/" class="fcF40">四季星座网首页</a>
                </li>
                </#if>
                <#if !session_user_redis__ || $it.isFxs?? ||  !session_user_redis__.logshop>
                <li class="noDown">
                    <a href="/order/cart.htm">
                        <i class="cgcatIcon"></i>
                        <span>进货车</span>
                    </a>
                </li>
                <li class="noDown"><a href="/member/goodsCollectinit.htm">我的数据包</a></li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="/member/index.htm">我的星座<i class="downArrow"></i></a>
                        <div class="myxz cnBoxCon pa">
                            <ul>
                                <li><a href="/member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                <li><a href="/member/goodsCollectinit.htm">我的数据包</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="/member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                        <div class="myColle cnBoxCon pa">
                            <ul>
                                <li><a href="/member/storeCollectinit.htm">收藏的档口</a></li>
                                <li><a href="/member/goodsCollectOriginal.htm">收藏的商品</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                </#if>
                <#if !session_user_redis__ || $it.isGys?? || session_user_redis__.logshop?? >
                <li>
                    <div class="cnBox pr">
                        <a class="cgcom pr" href="/seller/index.htm">我是档口<i class="downArrow"></i></a>
                        <div class="myStore cnBoxCon pa">
                            <ul>
                                <li><a href="/seller/createGoods21init.htm">发布新商品</a></li>
                                <li><a href="/seller/storeGoodsList21init.htm">已发布的商品</a></li>
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
                            <ul></ul>
                        </div>
                    </div>
                </li>
                </#if>
            </ul>
        </div>
    </div>
</div>
</#list>
<div class="bindTelephone">
    <p class="once"><strong>绑定手机号码：</strong>一个手机号只能验证一个四季星座网账号</p>
    <div class="bindForm">
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>手机号码：</label>
                <input type="text" name="telephone" class="fmInput" maxlength="11" placeholder="请输入手机号码" >
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>数字验证码：</label>
                <input type="text" name="imgValidate"  class="fmInput" maxlength="4" placeholder="右侧验证码" >
                <img id="checkCode" class="codeImg" src="/IMG.htm" />
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label><i>*</i>短信验证码：</label>
                <input type="text" name="msgValidate" class="fmInput msgValidate" maxlength="6" placeholder="请输入短信验证码" >
                <button type="button" id="getMsgBtn" class="getMsgBtn">点击获取</button>
            </div>
        </div>
        <div class="bindFormItem">
            <div class="formGroup">
                <label></label>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         bindButton"
        jbtn="click"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        id="bindButton"
>
        立即绑定
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
            </div>
        </div>
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
            <a href="http://py.571xz.com" target="_blank">濮院站</a>
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
                <i class="bigIcon" title="浙公网安备"></i>
                浙公网安备 33010202000302号
            </a>
        </p>
    </div>
</div>
<#include "/common/cnzz.ftl">