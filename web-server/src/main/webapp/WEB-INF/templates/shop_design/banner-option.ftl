<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>页头编辑 - 旗舰店装修 - 星座网</title>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/option.css?t=20170419U" type="text/css"/>
    <link rel="stylesheet" href="//www.571xz.com/design/theme/xzw/js/layer/skin/layer.css" type="text/css"/>
    <link href="//cdn.bootcss.com/jquery-minicolors/2.2.4/jquery.minicolors.min.css" rel="stylesheet">
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/layer/layer.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/s/editor/kindeditor-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/shop_design.js"></script>
    <script src="//cdn.bootcss.com/jquery-minicolors/2.2.4/jquery.minicolors.min.js"></script>
    <style type="text/css">
        .color-panel {
            display: inline-block;
            margin-left: 5px;
            height: 20px;
            padding: 5px;
            padding-left: 9px;
            background-color: #ddd;
            font-size: 0;
        }

        .color-panel a {
            width: 20px;
            height: 20px;
            display: inline-block;
            margin-right: 4px;
        }

        .color-panel-input {
            position: relative;
            top: -7px;
        }

        .color-panel-input input.nav_name {
            outline: none;
            width: 80px;
            height: 28px;
            line-height: 28px;
        }
    </style>
</head>
<body>
<div class="edit-shopsigns" id="edit-shopsigns">
    <div class="content">
        <div class="tab" id="J_Tab">
            <ul class="nav clearfix">
                <li class="selected first" role="tab" id="ks-switchable200" type="1"><span>招牌内容</span></li>
                <li role="tab" id="ks-switchable201" type="2"><span>页面导航</span></li>
                <li role="tab" id="ks-switchable202" type="3"><span>自定义导航</span></li>
                <li role="tab" id="ks-switchable203" type="4"><span>导航风格设置</span></li>
            </ul>
        </div>
        <form class="custom-set-form form-default" method="post" action="" id="module-options" name="customSetForm">
            <div class="panels">
                <div class="panel custom-set" role="tabpanel" type="1" aria-labelledby="ks-switchable200">
                    <div class="control-group J_BannerTypeRadioBox">
                        <label class="control-label">招牌类型：</label>
                        <div class="control">
                            <label class="type-name">
                                <input class="input-radio J_DefaultTypeRadio" name="storeImg.type" type="radio"
                                       value="1" <#if moduleSet.storeImg.type ==1 >checked="checked"</#if> >默认招牌
                            </label>
                            <label class="type-name">
                                <input class="input-radio J_CustomTypeRadio" name="storeImg.type" type="radio"
                                       value="2" <#if moduleSet.storeImg.type ==2 >checked="checked"</#if> >自定义招牌
                            </label>
                        </div>
                    </div>
                    <div class="J_DefaultType <#if moduleSet.storeImg.type ==2 >hidden</#if>">
                        <div class="control-group">
                            <label class="control-label">背景图：</label>
                            <div class="control"
                                 style=" background-color:#eee;  width:350px; border: 1px solid #ebebeb; padding: 5px;">
                                <a class="btn-style-1 J_TadgetSelect" href="javascript:;" style="display: none;">
                                    <span class="btn-text">上传图片</span>
                                    <div class="file-input-wrapper" style="overflow: hidden;">
                                        <input type="file" id="imgPicSelect" value class="shop-file-input">
                                        <input type="hidden" id="store_img_pic" name="storeImg.imgPic"
                                               value="${moduleSet.storeImg.imgPic!}">
                                    </div>
                                </a>
                                <a class="back-default J_BackDefaultImg" href="javascript:;">使用默认图片</a>
                                <div class="url_pop" style="display:block; width:350px; margin-top: 5px;">
                                    <div>
                                        <span>图片链接：</span>
                                        <input type="text" placeholder="请输入链接地址" data-url
                                               style="width: 200px; height: 26px;"/>
                                        <a class="btn-ok url-save" data-url-preview>预览</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="preview-box" style="margin-left:50px;margin-right:50px;">
                            <img style="width:698px" src="${moduleSet.storeImg.imgPic!}">
                        </div>
                    </div>
                    <div class="J_CustomType <#if moduleSet.storeImg.type ==1 >hidden</#if>">
                        <div class="control-group">
                            <label class="control-label" for="content">自定义内容：</label>
                            <div class="control" id="design_main">
                                <textarea id="content" name="storeImg.content"
                                          style="width: 100%; min-height: 150px; max-width: 100%;">${moduleSet.storeImg.content}</textarea>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                        var width = $('#design_main').width();
                        KE.show({
                            id: 'content',
                            allowFileManager: false,
                            allowPreviewEmoticons: false,
                            allowUpload: false,
                            minWidth: width,
                            maxWidth: width,
                            minHeight: 350,
                            items: [
                                'source', '|', 'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
                                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                                'insertunorderedlist', '|', 'emoticons', 'image', 'link']
                        });
                        function handler() {
                            $('#content').html(KE.html('content'));
                        }
                    </script>
                    <div class="control-group">
                        <label class="control-label">高度：</label>
                        <div class="control">
                            <label>
                                <input class="input-box short J_Height" name="storeImg.height" type="text"
                                       value="${moduleSet.storeImg.height!}">px
                            </label>
                            <span class="height-overflow hidden">
                                <span class="prompt">不能超过150px</span>
                            </span>
                            <span style="padding-left:15px;color:#999;">宽度为950像素，高度建议不超过150像素，否则导航显示可能异常</span>
                        </div>
                    </div>
                </div>
                <div class="panel" style="display: none;" role="tabpanel" type="2" aria-labelledby="ks-switchable201">
                    <p class="nav-head desc">请选择要添加的页面</p>
                    <div class="diy-pages-content panel-content">
                        <span class="text-tips">基础页面</span>
                        <ul class="diy-page-list"></ul>
                        <span class="text-tips">自定义页面</span>
                        <ul class="diy-page-list">
                            <#list allpages as ap>
                                <li class="diy-page">
                                    <label>
                                        <input type="checkbox" name="storeNav.pages[${ap_index}]" <#if ap.checked>checked</#if> value="${ap.pageId}" class="checkbox
                                    J_TCheckbox"/>
                                        <span class="diy-page-name">${ap.pageName}</span>
                                    </label>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
                <div class="panel" id="edit-nav" style="display: none;" role="tabpanel" type="3"
                     aria-labelledby="ks-switchable202">
                    <div class="lb_bd" style="padding-bottom: 20px;">
                        <div class="lb_topnav">
                            <div id="item_line_wrap2" class="item_line_wrap item_line_wrap2">
                                <#list moduleSet.storeNavAuto as nav>
                                    <div class="item_line floor clearfix" data-type="cust">
                                        <div class="name J_name">
                                            <label>名称：</label>
                                        <span class="name_all">
                                            <input type="text" class="nav_name"
                                                   name="storeNavAuto[${nav_index}].name" value="${nav.name}">
                                        </span>
                                        </div>
                                    <span class="link J_link">
                                        <label>跳转链接：</label>
                                        <span class="url">
                                            <input type="text" class="img_link"
                                                   name="storeNavAuto[${nav_index}].targetUrl"
                                                   value="${nav.targetUrl}">
                                        </span>
                                    </span>
                                    <span class="oper">
                                        <i class="del" title="删除">删除</i>
                                        <i class="up first_up" title="上移">上移</i>
                                        <i class="down " title="下移">下移</i>
                                    </span>
                                    </div>
                                </#list>
                            </div>
                            <div class="add_wrap" style="margin-top: 10px;">
                                <a href="javascript:;" class="add_line"><span>添加导航内容</span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel" type="4" style="display: none;" role="tabpanel" aria-labelledby="ks-switchable203">
                    <div class="control-group">
                        <label class="control-label">背景颜色：</label>
                        <div class="control">
                            <label class="color-panel-input">
                                <input type="text" class="nav_name" name="storeNav.background" value="${moduleSet.storeNav.background}" data-select-color>
                            </label>
                            <label class="color-panel">
                                <a href="javascript:;" style="background-color: #000000;" data-color="#000000"></a>
                                <a href="javascript:;" style="background-color: #0b9feb;" data-color="#0b9feb"></a>
                                <a href="javascript:;" style="background-color: #ffffff;" data-color="#ffffff"></a>
                            </label>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">字体颜色：</label>
                        <div class="control">
                            <label class="color-panel-input">
                                <input type="text" class="nav_name" name="storeNav.color" value="${moduleSet.storeNav.color}" data-select-color>
                            </label>
                            <label class="color-panel">
                                <a href="javascript:;" style="background-color: #000000;" data-color="#000000"></a>
                                <a href="javascript:;" style="background-color: #0b9feb;" data-color="#0b9feb"></a>
                                <a href="javascript:;" style="background-color: #ffffff;" data-color="#ffffff"></a>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div>&nbsp;</div>
        <p class="control-group opt-footer">
            <a href="javascript:void(0);" class="btn-ok" data-save>保存</a>
            <a href="javascript:void(0);" class="btn-cancel" data-cancel>取消</a>
            <span class="J_TMsg msg disappear"><i class="msg-icon"></i><span class="text">您有未完成的输入框</span></span>
        </p>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var index = parent.layer.getFrameIndex(window.name);
        // 保存按钮
        $('[data-save]').click(function () {
            handler();
            var params = $('#module-options').serialize();
            $.ajax({
                url: '/seller/design/pageUpdateHead.json',
                type: 'POST',
                data: params,
                success: function (d) {
                    console.log(d);
                    parent.location.reload();
                }
            });
        });
        // 取消按钮
        $('[data-cancel]').click(function () {
            parent.layer.close(index);
        });
        // 选择店招图片
        $('#imgPicSelect').change(function () {
            $('#store_img_pic').val($(this).val());
        });
        $('[data-url-preview]').click(function () {
            var url = $('[data-url]').val();
            $('[name="storeImg.imgPic"]').val(url);
            $('.preview-box>img').attr('src', url);
        });

        $('[data-select-color]').minicolors();
        $('[data-color]').click(function () {
            var color = $(this).data('color');
            var div = $(this).parent().prev().children('div');
            div.children('input').val(color);
            div.find('.minicolors-swatch-color').css('background-color', color);
        });
    });
</script>