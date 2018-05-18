<html lang="en"><head>
    <meta charset="UTF-8">
    <title>新建页面 - 店铺装修</title>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/page.css" type="text/css">
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/page.js"></script>
</head>
<body>

<div class="form-default" id="new-page">
    <form id="submit-new-page">
        <input type="hidden" name="method" value="submit">
        <div class="control-group">
            <label class="control-label">页面名称：</label>
            <div class="controls">
                <input class="input-box" name="title" type="text" maxlength="10" placeholder="页面名称">
                <p class="tips" style="display: block">页面名称不能超过10个字,建议先选择页面内容，后输入页面名称</p>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">页面地址：</label>
            <div class="control">
                <span class="J_TUrl">//www.571xz.com/shop/${shop}/${code}.htm</span>
                <input type="hidden" id="page-address" value="${code}" name="alias">
                <p class="tips" style="display: block">买家访问该页面的地址，可以直接在导航模块添加该链接</p>
            </div>
        </div>
        <div class="control-group" style="margin-bottom: 60px;">
            <label class="control-label">页面内容：</label>
            <div class="controls">
                <div class="tabs">
                    <div class="tab-content">
                        <div class="pannel" style="display: block;">
                            <div class="item clearfix ">
                                <div class="checkbox">
                                    <input type="radio" name="type" value="2" checked="checked" class="prepare">
                                </div>
                                <div class="thumb">
                                    <img src="//www.571xz.com/design/img/shop/rightleft60.jpg" alt="">
                                </div>
                                <div class="detail">
                                    <h3>左右栏自定义页</h3>
                                    <p>添加一个左右栏形式的默认模块页。</p>
                                </div>
                            </div>
                            <div class="item clearfix item-last">
                                <div class="checkbox">
                                    <input type="radio" name="type" value="1" class="prepare">
                                </div>
                                <div class="thumb">
                                    <img src="//www.571xz.com/design/img/shop/topbottom60.jpg" alt="">
                                </div>
                                <div class="detail">
                                    <h3>通栏自定义页</h3>
                                    <p>添加一个无左边侧栏的默认模块页。</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div class="opt-footer">
        <a class="btn-ok J_TSubmit" href="javascript:;">保存</a>
        <a href="javascript:;" class="btn-cancel">取消</a>
    </div>
</div>


<style>@font-face {font-family: "yourDictFontAwesome";src: url("chrome-extension://dmckmhkomggmpalekfadjibdcknieljf/lib/fontawesome-webfont.ttf") format("truetype");font-weight: normal;font-style: normal;}</style></body></html>