<#assign $pageid="bqsqIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>专业知识产权服务平台 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__bqsqIndex_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/common__form_js.ftl">
<#include "/__style_torrent__/xzSearch__bqsqIndex_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="banner yahei">
    <div class="layout pr">
        <h2></h2>
        <a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=百优先生&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank" class="consultBtn fs16 tac">立即咨询</a>
<div class="consultForm pa">
    <div class="pr">
<#list [{"name":"type"}] as $it>
<div class="fmSelect" id="registType">
    <span class="text">请选择</span>
    <i class="icon-downarrow bt_arrow"></i>
    <ul class="options"></ul>
    <input class="realInput" type="hidden"
        <#if $it.name??>name="${$it.name!}"</#if>
        <#if $it.value??>value="${$it.value!}"</#if>
    >
</div>
</#list>
        <input class="fmInput nameInput fl" placeholder="您的姓名">
        <input class="fmInput telInput" placeholder="您的联系电话">
        <textarea class="detailText" placeholder="请填写您的详细说明"></textarea>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         submitBtn"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        确认提交
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
        <div class="errorTip typeError pa">注册类型为必选项！</div>
        <div class="errorTip teleError pa">联系姓名和联系电话为必填项！</div>
    </div>
    <div class="contactBox">
        <h3 class="fs12 tac">有疑问可以点击</h3>
        <ul>
            <li><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=百优先生&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>阿里旺旺</span></a></li>
            <li><a href="http://wpa.qq.com/msgrd?v=3&uin=1030995998&amp;site=qq&amp;menu=yes" target="_blank"><i class="icon-s-qq"></i><span>QQ在线</span></a></li>
            <li><i class="icon-s-tel"></i><span>400-076-1116</span></li>
        </ul>
    </div>
</div>
    </div>
</div>
<div class="trademark layout yahei">
    <div class="registTitle">
        <h2>商标注册</h2>
        <p>TRADEMARK REGISTRATION</p>
    </div>
    <div class="registList">
            <div class="registItem">
                <div class="registDefault">
                    <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/trademark1.jpg">
                    <h3>普通注册</h3>
                    <p class="fs16 fc9">1288元/件</p>
                </div>
                <div class="registHover">
                    <h2>普通注册</h2>
                    <p>专业查询分析，进程实时监控。</p>
                    <div class="price"><em>￥</em>1288</div>
                    <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.9.6403c6c4dAGPor&amp;id=559970936103" target="_blank" class="contactBtn">立即办理</a>
                </div>
            </div>
            <div class="registItem">
                <div class="registDefault">
                    <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/trademark2.jpg">
                    <h3>加急注册</h3>
                    <p class="fs16 fc9">1398元/件</p>
                </div>
                <div class="registHover">
                    <h2>加急注册</h2>
                    <p>当天提交申报到商标局。</p>
                    <div class="price"><em>￥</em>1398</div>
                    <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.15.6403c6c4dAGPor&amp;id=560064777629" target="_blank" class="contactBtn">立即办理</a>
                </div>
            </div>
            <div class="registItem">
                <div class="registDefault">
                    <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/trademark3.jpg">
                    <h3>担保注册</h3>
                    <p class="fs16 fc9">1680元/件</p>
                </div>
                <div class="registHover">
                    <h2>担保注册</h2>
                    <p>专业把关通过率，注册不成功全额退款。</p>
                    <div class="price"><em>￥</em>1680</div>
                    <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.24.6403c6c4dAGPor&amp;id=560127246264" target="_blank" class="contactBtn">立即办理</a>
                </div>
            </div>
            <div class="registItem">
                <div class="registDefault">
                    <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/trademark4.jpg">
                    <h3>双享注册</h3>
                    <p class="fs16 fc9">1600元/件</p>
                </div>
                <div class="registHover">
                    <h2>双享注册</h2>
                    <p>商标注册不成功，可免费提供一次商标普通注册。</p>
                    <div class="price"><em>￥</em>1600</div>
                    <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.27.6403c6c4dAGPor&amp;id=560127986051" target="_blank" class="contactBtn">立即办理</a>
                </div>
            </div>
    </div>
</div>
<div class="copyright yahei">
    <div class="layout">
        <div class="registTitle">
            <h2>版权注册</h2>
            <p>COPYRIGHT REGISTRATION</p>
        </div>
        <div class="registList">
                <div class="registItem">
                    <div class="registDefault">
                        <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/copyright1.jpg">
                        <h3>普通登记</h3>
                        <p class="fs16 fc9">800元/件</p>
                    </div>
                    <div class="registHover">
                        <h2>普通登记</h2>
                        <p>版权登记，保护你的作品创意。</p>
                        <div class="price"><em>&yen;</em>800</div>
                        <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.12.6403c6c4dAGPor&amp;id=559975012669" target="_blank" class="contactBtn">立即办理</a>
                    </div>
                </div>
                <div class="registItem">
                    <div class="registDefault">
                        <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/copyright2.jpg">
                        <h3>加急登记</h3>
                        <p class="fs16 fc9">1000元/件</p>
                    </div>
                    <div class="registHover">
                        <h2>加急登记</h2>
                        <p>专业顾问分析，最快流程办理。</p>
                        <div class="price"><em>&yen;</em>1000</div>
                        <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.30.6403c6c4dAGPor&amp;id=560129154701" target="_blank" class="contactBtn">立即办理</a>
                    </div>
                </div>
                <div class="registItem">
                    <div class="registDefault">
                        <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/copyright3.jpg">
                        <h3>外观专利</h3>
                        <p class="fs16 fc9">1300元/件</p>
                    </div>
                    <div class="registHover">
                        <h2>外观专利</h2>
                        <p>从有想法到完成申报最晚8个工作日。</p>
                        <div class="price"><em>&yen;</em>1300</div>
                        <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.21.6403c6c4dAGPor&amp;id=560068845596" target="_blank" class="contactBtn">立即办理</a>
                    </div>
                </div>
                <div class="registItem">
                    <div class="registDefault">
                        <img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/copyright4.jpg">
                        <h3>设计稿作品</h3>
                        <p class="fs16 fc9">898元/件</p>
                    </div>
                    <div class="registHover">
                        <h2>设计稿作品</h2>
                        <p>办理流程简单，专业客服全程服务。</p>
                        <div class="price"><em>&yen;</em>898</div>
                        <a href="https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-13309679213.18.6403c6c4dAGPor&amp;id=560068557887" target="_blank" class="contactBtn">立即办理</a>
                    </div>
                </div>
        </div>
    </div>
</div>
<div class="successCase layout yahei">
    <div class="registTitle">
        <h2>成功案例</h2>
        <p>SUCCESSFUL CASE</p>
    </div>
    <div class="caseList">
        <ul>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case1.jpg"></li>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case2.jpg"></li>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case3.jpg"></li>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case4.jpg"></li>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case5.jpg"></li>
               <li><img src="http://style.571xz.com/v6/xzSearch/css/img/trademark/case6.jpg"></li>
        </ul>
    </div>
</div>
<div class="bottomContact yahei">
    <ul>
        <li><a href="http://www.taobao.com/webww/ww.php?ver=3&amp;touid=百优先生&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>阿里旺旺</span></a><em></em></li>
        <li><a href="http://wpa.qq.com/msgrd?v=3&uin=1030995998&amp;site=qq&amp;menu=yes" target="_blank"><i class="icon-s-qq"></i><span>QQ在线</span></a><em></em></li>
        <li><i class="icon-s-tel"></i><span>400-076-1116</span></li>
    </ul>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">