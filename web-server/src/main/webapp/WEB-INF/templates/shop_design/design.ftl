
<!doctype html>
<html style="/*overflow: hidden*/">
<head>
    <meta charset="utf-8">
    <title>首页 - 店铺装修 - 星座网</title>
    <link rel="stylesheet" type="text/css" href="//www.571xz.com/design/theme/xzw/css/globaladmin.css?t=20170413U">
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/common.css?t=20161230A" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/preview.css?t=20170321E" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="//www.571xz.com/design/theme/xzw/js/layer/skin/layer.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/jquery-ui.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/jquery.loadTemplate.min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/theme/xzw/js/global-min.js?t=20170413U"></script>
    <script type="text/javascript" src="//www.571xz.com/design/s/editor/kindeditor-min.js?t=20160106"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/shop_design.js?t=20170119"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/builder.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/layer/layer.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/theme/xzw/shop/js/shopedit_page-min.js?t=20160427"></script>
</head>
<body>
<div id="page" class="shop-taobao" style="height: 100%; overflow-y: hidden">
    <div class="main-wrapper main-wrapper-design-mode">
        <div id="tip" style="display:none">提示内容</div>
    <#include "/shop_design/sidebar.ftl">
        <div class="vl-main">
            <#include "/shop_design/nav.ftl">
                <div class="pc-page J_PageDesignContainer" style="overflow-y: auto; height: 100%;">
            ${container.html!}
                </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $(".vl-sidebar .J_ToolBar li:eq(0)").click();
        $('[data-hd-apply]').click(function () {
            var showImg = $('[data-show-img].onselected').data('value'),
                    showSpacing = $('[data-show-spacing].onselected').data('value');
            $.ajax({
                url: '/seller/design/page-update-head-option.json',
                type: 'GET',
                data: {
                    'imgShow': showImg, 'spacing': showSpacing
                },
                dataType: 'json',
                success: function (d) {
                    if (d.status == 0) {
                        layer.msg('应用成功');
                    } else {
                        layer.msg(d.message);
                    }
                }
            });
        });
        $('[data-bg-apply]').click(function () {
            var hdFile = $('[name=hdfile]').val(),
                    bgShow = $('[data-bg-show].onselected').data('value');
            $.ajax({
                url: '/seller/design/page-update-background.json',
                type: 'GET',
                data: {
                    'page':'${page_id}','pic': hdFile, 'type': bgShow
                },
                dataType: 'json',
                success: function (d) {
                    if (d.status == 0) {
                        layer.msg('应用成功');
                    } else {
                        layer.msg(d.message);
                    }
                }
            });
        });
        $('.page-publish-btn').click(function () {
            $.ajax({
                url: '/seller/design/publish.json',
                type: 'GET',
                dataType: 'json',
                success: function (d) {
                    layer.msg(d.message);
                }
            });
        });
    });
</script>

<!--编辑功能-->
<div class="url_pop" style="display: none">
    <div style="margin: 20px; margin-top: 10px">
        <span>图片链接：</span>
        <input type="text" placeholder="请输入链接地址" style="width: 200px; height: 26px; line-height: 26px;"/>
    </div>
    <div class="opt-footer">
        <a class="btn-ok url-save">保存</a>
    </div>
</div>
</body>
</html>