<#assign $pageid="picSearch">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
    <title>星座图搜 - 四季星座网 - 搜索(男装、女装、男鞋、女鞋代理平台)</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/xzPage__picSearch_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <script src="http://style.571xz.com/v6/common/js/plugin/jq.form.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.lazyload.js"></script>
<script src="http://style.571xz.com/v6/common/js/plugin/jq.qrcode.js"></script>
<#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzPage__picSearch_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<div class="headerPicSearch">
    <div class="layout">
        <div class="logoLeft">
            <a href="http://${webSite!}.571xz.com">
                <img src="http://style.571xz.com/v6/common/css/img/xz/mtLogo.png" width="168" height="30" />
            </a>
        </div>
       <div class="searchRight">
           <div class="searchInput">
               <input class="searchUrl" type="text" name="" placeholder="用图片找到你想要的商品" value=""/>
                <div class="camera">
                    <img src="http://style.571xz.com/v6/xzPage/css/img/picSearch/imgsearch_03.png" alt="" />
                    <input type="file" name="file" accept=".jpg,.jpeg,.bmp,.gif,.png">
                </div>
           </div>
           <div class="searchExplain">
               <p>
                   <span class="title">支持输入:</span>
                   <span class="imgUrl">复制图片链接，粘贴 ( Ctrl+v ) 到输入框</span>
                   <span class="imgUpload">上传图片</span>
               </p>
           </div>
       </div>
    </div>
</div>
<div class="upPicLook">
    <div class="layout upPicLookCon"></div>
    <canvas id="myCanvas" style="border:1px solid;"></canvas>
</div>
<div class="picSearResu bg">
    <div class="layout">
        <div class="goodsList">
            <p class="firstStep yahei">请输入您要找的商品…</p>
        </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">
<#include "/common/cnzz.ftl">