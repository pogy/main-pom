//by renhuimin
$(document).ready(function() {
    if ($('.design-navigation-wrap').length) {
        $('.vl-site-version-tip').css({
            "top": "150px"
        })
    }
    $('.vl-site-version-tip').show();
    setTimeout(function() {
        $('.vl-site-version-tip').removeClass('.vl-site-version-tip-highlight');
    }, 3000);
    $('.J_SiteVersionTipMin').on('click', function(e) {
        e.preventDefault();
        $('.vl-site-version-tip').addClass('vl-site-version-tip-hide')
    });
    $('.J_SiteVersionTipMax').on('click', function(e) {
        e.preventDefault();
        $('.vl-site-version-tip').removeClass('vl-site-version-tip-hide')
    });
    /* topbar */
    var oldId = localStorage.getItem('topCustom');
    var smart = $('input[name="isSmartShopVersion"]').val() === 'true' ? true : false;
    var siteCategoryId = $('input[name="siteCategoryId"]').val();
    var type = 'smart';
    var data = localStorage.getItem('topCustom');
    if (data) {
        data = JSON.parse(data);
    }
    if (!smart) {
        if (siteCategoryId === '1') {
            type = 'jichu';
        } else if (siteCategoryId === '2') {
            type = 'zhuanye';
        } else if (siteCategoryId === '3') {
            type = 'tmall';
        }
    }
    var element = $('#topbar-custom .topbar-custom-item[data-type="' + type + '"]');
    var id = element.attr('data-id');
    if (!data || data[type] !== id) {
        $('#topbar-custom').show();
        element.show();
    }
    $('.top-close').on('click', function() {
        $('#topbar-custom').remove();
        if (!data) {
            data = {};
        }
        if (data) {
            data[type] = id;
        }
        localStorage.setItem('topCustom', JSON.stringify(data));
    });
    /*左侧边栏*/
    $(".vl-sidebar .J_ToolBar li").click(function() {
        var Width = document.body.offsetWidth;
        var datas = $(this).attr("data-slide");
        //console.log(datas);
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $(this).parents(".vl-sidebar").find(".toolbar li").removeClass("selected");
        $(this).parents(".vl-sidebar").find(".toolbar li[data-slide='" + datas + "']").addClass("selected");
        $("#J_Page").css({
            "width": Width - 80 - 230
        });
        $(".design-navigation-wrap").css({
            "width": Width - 80 - 230
        });
        $(".main-wrapper").addClass("wpst-toolbar-show");
    });
    //左侧边栏是否显示店招
    $(".page-head-slide .operate-btn span").click(function() {
        if ($(this).hasClass("onselected")) {
            if ($(this).hasClass("open")) {
                if ($(this).hasClass("J_TenPx")) {
                    $(".bg").css("padding-top", "10px");
                } else {
                    $(".Js-head .shopsigns").show();
                }
            } else {
                if ($(this).hasClass("J_TenPx")) {
                    $(".bg").css("padding-top", "0px");
                } else {
                    $(".Js-head .shopsigns").hide();
                }
            }
        } else {
            $(this).addClass("onselected");
            $(this).siblings().removeClass("onselected");
            if ($(this).hasClass("open")) {
                if ($(this).hasClass("J_TenPx")) {
                    $(".bg").css("padding-top", "10px");
                } else {
                    $(".Js-head .shopsigns").show();
                }
            } else {
                if ($(this).hasClass("J_TenPx")) {
                    $(".bg").css("padding-top", "0px");
                } else {
                    $(".Js-head .shopsigns").hide();
                }
            }
        }
    });
    //修改的修改图片
    var layerindex;
    $("body").on("click", ".page-slide .ks-uploader-button", function() {
        layerindex = layer.open({
            type: 1,
            title: "设置背景图",
            area: ['300px', '160px'],
            content: $(".url_pop")
        });
    });
    $("body").on("click", ".url-save", function() {
        var imgurl = $(".url_pop input").val();
        var reg = new RegExp("[a-zA-z]+://[^\s]*");
        if (reg.test(imgurl) == true) {
            //console.log(imgurl);
            layer.close(layerindex);
            $(".page-slide .file-input-wrapper .file-input").attr("value", imgurl);
            $(".J_pageBgImage").attr('src', imgurl);
            var state = $(".page-slide .onselected").attr("data-bg-show");
            //console.log(state);
            $("#J_Page .bg").css({
                "background-image": "url(" + imgurl + ")",
                "background-repeat": state
            })
        } else {
            $(".urlerror").show();
        }
    });
    //获得焦点
    $(".url_pop input").focus(function() {
        $(".urlerror").hide();
    });
    //页面上传图片
    $("body").on("change", ".page-slide .file-input-wrapper .file-input", function() {
        // console.log(2);
        var objUrl = getObjectURL(this.files[0]);
        $(".J_pageBgImage").attr('src', objUrl);
        var state = $(".page-slide .onselected").attr("data-bg-show");
        //console.log(state);
        $("#J_Page .bg").css({
            "background-image": "url(" + objUrl + ")",
            "background-repeat": state
        })
    });

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    //页面删除背景
    $(".page-slide .action-btn .delete").click(function() {
        $(this).parents(".page-slide").find(".J_pageBgImage").attr('src', "/design/img/shop/img.gif");
        $("#J_Page .bg").css({
            "background-image": "",
            "background-repeat": ""
        })
    });
    //页面背景切换
    $(".page-slide .J_pageShowSelect").click(function() {
        $(this).parents(".bg-show").find(".J_pageShowSelect").removeClass("onselected");
        $(this).addClass("onselected");
        var state = $(this).attr("data-bg-show");
        $("#J_Page .bg").css({
            "background-repeat": state
        })
    });
    /*关闭侧边栏*/
    $(".J_ToolbarItemClose").click(function() {
        var Width = document.body.offsetWidth;
        $(this).parents(".vl-sidebar").find("li").removeClass("selected");
        $("#J_Page").css({
            "width": Width - 80
        });
        $(".design-navigation-wrap").css({
            "width": Width - 80
        });
        $(".main-wrapper").removeClass("wpst-toolbar-show");
    });
    /*改变宽度*/
    $(window).resize(function() {
        var Width = document.body.offsetWidth;
        var Height = document.body.offsetHeight;
        //console.log(Width);
        //console.log(Height);
        var bin = $(".vl-sidebar .J_ToolBar li").hasClass("selected");
        //  console.log(bin);
        if (bin) {
            $("#J_Page").css({
                "height": Height,
                "width": Width - 80 - 230
            });
            $(".design-navigation-wrap").css({
                "width": Width - 80 - 230
            });
        } else {
            $("#J_Page").css({
                "height": Height,
                "width": Width - 80
            });
            $(".design-navigation-wrap").css({
                "width": Width - 80
            });
        }
    });

    //top移上去显示编辑框
    $(".Js-head").mouseover(function () {
        $(this).find(".edit-bar").show();
    });
    //top移上去删除编辑框
    $(".Js-head").mouseleave(function() {
        $(this).find(".edit-bar").hide();
    });
    //模块区域
    $("body").delegate(".J_TModule", "mouseenter", function() {
        var html = "";
        var not_edit = typeof($(this).find(".js-module").attr("data-not-edit")) == "undefined";
        var not_del = typeof($(this).find(".js-module").attr("data-not-del")) == "undefined";
        //判断是否显示需要显示编辑框
        html += "<div class='edit-bar'>";
        html += "<div class='J_NewInsertNode new-insert-node up' style='display:none ; left: 0px; top: 10px;'><span class='tip'>松开鼠标,模块会放到该上方</span></div>";
        html += "<a class='bar-moveup " + ($(this).prev().length == 0 ? 'no-moveup' : '') + "' title='上移'><span></span></a>";
        html += "<a class='bar-movedown " + ($(this).next().hasClass('js-model') || $(this).next().length == 0 ? 'no-movedown' : '') + "' title='下移'><span></span></a>";
        if (not_edit) html += "<a class='bar-edit edit_content' title='编辑'><span></span></a>";
        if (not_del) html += "<a class='bar-del' title='删除'><span></span></a>";
        html += "<div class='J_NewInsertNode new-insert-node down' style='display:none; left: 0px; bottom: 10px;'><span class='tip'>松开鼠标,模块会放到该下方</span></div>";
        html += "</div>";
        $(this).append(html);
    }).delegate(".J_TModule", "mouseleave", function() {
        //移上去删除编辑框
        $(this).find(".edit-bar").remove();
    }).delegate(".bar-del", "click", function() {
        // 删除模块
        var $this = $(this);
        var module = $this.parent().parent(),
            moduleId = module.data('id'),
            parent = module.parent(),
            type = parent.data('type'),
            area = parent.parent(),
            areaId = area.data('id');
        $.ajax({
            url: '/seller/design/remModule.json',
            type: 'GET',
            data: {
                'id': moduleId,
                'area': areaId,
                'type': type
            }
        });
        module.remove();
        parent.children('.js-model').show();
        // 删除区域
        var len = area.find('.J_TModule').length;
        if (len == 0) {
            // 是否还有多个区域（保留1个950区域）
            if (area.parent().children('.area').length >= 1) {
                // 1190区域的总数
                var area1190 = area.parent().find('.area-1190').length;
                // 是否只剩当前区域
                if (area1190 == area.find('.area-1190').length) {
                    return;
                }
            }
            area.remove();
            // $.ajax({
            //     url: '/seller/design/remArea.json',
            //     type: 'GET',
            //     data: {
            //         'id': areaId
            //     },
            //     success: function() {
            //         area.remove();
            //     }
            // });
        }
    }).delegate('.bar-moveup', 'click', function() {
        var module = $(this).parent().parent(),
            moduleId = module.data('id'),
            modulePrev = module.prev(),
            modulePrevId = modulePrev.data('id'),
            type = module.parent().data('type'),
            area = module.parent().parent(),
            areaId = area.data('id');
        if (modulePrevId == undefined) {
            return;
        }
        $.ajax({
            url: '/seller/design/move-module.json',
            type: 'get',
            data: {
                'area': areaId,
                'type': type,
                'moduleId': moduleId,
                'sideId': modulePrevId,
                'after':1
            },
            dataType: 'json',
            success: function(d) {
                if (d.status != 0) {
                    layer.msg('位置更换失败，请稍后重试');
                } else {
                    module.children('.edit-bar').remove();
                    modulePrev.before(module.prop("outerHTML"));
                    module.remove();
                    modulePrev.prev().droppable({
                        accept: ".js-module-list li",
                        drop: controller.handler
                    });
                }
            }
        });
    }).delegate('.bar-movedown', 'click', function() {
        var module = $(this).parent().parent(),
            moduleId = module.data('id'),
            moduleNext = module.next(),
            moduleNextId = moduleNext.data('id'),
            type = module.parent().data('type'),
            area = module.parent().parent(),
            areaId = area.data('id');
        if (moduleNextId == undefined) {
            return;
        }
        $.ajax({
            url: '/seller/design/move-module.json',
            type: 'get',
            data: {
                'area': areaId,
                'type': type,
                'moduleId': moduleId,
                'sideId': moduleNextId,
                'after':2
            },
            dataType: 'json',
            success: function(d) {
                if (d.status != 0) {
                    layer.msg('位置更换失败，请稍后重试');
                } else {
                    module.children('.edit-bar').remove();
                    moduleNext.after(module.prop("outerHTML"));
                    module.remove();
                    moduleNext.next().droppable({
                        accept: ".js-module-list li",
                        drop: controller.handler
                    });
                }
            }
        });
    });
    $(" .J_ModuleListHead .dropdown-icon").click(function() {
        var data = $(this).parents(".inside").find(".sizes span.size-selected").attr("data-size");
        //console.log(data);
        var idx = true;
        $(this).parent().parent().find("ul").each(function() {
            var size = $(this).attr("data-size");
            if (size == data) {
                //$(this).css("transform","rotate(180deg)")
                $(this).toggle();
            }
            if ($(this).css("display") == "block") {
                idx = false;
            }
        });
        if (idx) {
            $(this).css("transform", "rotate(180deg)");
        } else {
            $(this).css("transform", "rotate(0deg)");
        }
    });
    $(document).on("selectstart", function() {
        return false;
    });
    /*head编辑*/
    $(".Js-head .edit_content").click(function() {
        layer.open({
            type: 2,
            title: "页头编辑",
            skin: 'layui-layer-rim', //加上边框
            area: ['800px', '500px'],
            content: "/seller/design/page-get-head.htm"
        })
    });
    var fault;
    $("body").on("change", ".shop-file-input", function() {
        var objUrl = getObjectURL(this.files[0]);
        fault = $(this).parents(".J_DefaultType").find(".preview-box img").attr('src');
        $(this).parents(".J_DefaultType").find(".preview-box img").attr('src', objUrl);
        //保存图片链接
        $('#imgPicSelect').ajaxSubmit({
            dataType: 'json',
            url: '/seller/design/upload-image.htm',
            uploadProgress: function(event, position, total, percentComplete) {
                var percentVal = percentComplete + '%'; //获得进度
                console.log(percentVal); //上传进度条宽度变宽
            },
            success: function(data) { //成功
                console.log(data);
            },
            error: function(xhr) { //上传失败
                console.log(xhr);
            }
        });
        //$("#Js-shopsigns").attr("value", objUrl);
    });
    //使用默认图片
    $(".J_BackDefaultImg").click(function() {
        var img = $(this).parents(".J_DefaultType").find(".preview-box img");
        fault = '/share/shopid/default_logo.jpg';
        img.attr('src', fault);
        //保存图片的链接
        $('#store_img_pic').val(fault);
    });
    // 选择上传图片
    $("body").on("click", "#edit-shopsigns .J_TadgetSelect .btn-text", function() {
        $('#imgPicSelect').click();
    });
    $("body").on("click", "#edit-shopsigns .url-save", function() {
        var imgurl = $(".url_pop input").val();
    });
    /*店招编辑*/
    $(".shopsigns .edit_content").click(function() {
        //console.log(33);
        layer.open({
            type: 2,
            title: "店招编辑",
            skin: 'layui-layer-rim', //加上边框
            //closeBtn: 0,
            area: ['800px', '300px'],
            content: "/seller/design/modules/hd-option.htm",
        })
    });
    //店招 切换使用哪种模式店招
    $("body").on("click", ".edit-shopsigns input.input-radio", function() {
        $(this).parent().find(".input-radio").attr("checked", false);
        $(this).attr("checked", true);
        var idx = $(this).val();
        //console.log(idx);
        if (idx == 2) {
            $(this).parents(".panel").find(".J_DefaultType").addClass("hidden");
            $(this).parents(".panel").find(".J_CustomType").removeClass("hidden");
        } else {
            $(this).parents(".panel").find(".J_DefaultType").removeClass("hidden");
            $(this).parents(".panel").find(".J_CustomType").addClass("hidden");
        }
    });
    ////是否显示标题
    //
    //$("body").on("click",".edit-search input.input-radio",function(){
    //    $(this).parents(".show-title").find(".input-radio").attr("checked", false);
    //    $(this).attr("checked", true);
    //    var idx = $(this).val();
    //    if(idx == 0){
    //        $(this).parents(".show-title").find(".title-input").hide();
    //
    //    }else{
    //        $(this).parents(".show-title").find(".title-input").show();
    //    }
    //
    //});
    /*导航编辑-弹框*/
    $(".hd-nav .edit_content").click(function() {
        layer.open({
            type: 1,
            title: "导航编辑",
            skin: 'layui-layer-rim', //加上边框
            area: ['700px', '500px'],
            content: $("#edit-nav")
        })
    });
    /*导航编辑- tab切换*/
    $("body").delegate("#edit-shopsigns .nav li", "click", function() {
        var id = $(this).attr("id");
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $("#edit-shopsigns").find(".panels .panel").each(function() {
            var conid = $(this).attr("aria-labelledby");
            if (conid == id) {
                $(this).css("display", "block");
                $(this).siblings().css("display", "none");
            } else {
                return;
            }
        })
    });
    /*导航编辑-*/
    $("body").on("click", ".lb_topnav .add_wrap span", function() {
        var html = '';
        var length = $("#item_line_wrap2").children(".item_line").length;
        html += '<div class="item_line floor clearfix" data-type="cust">';
        html += '<div class="name J_name">';
        html += '<label for="navName">名称:</label>';
        html += '<span class="name_all">';
        html += '<input type="text" class="nav_name" name="storeNavAuto[' + length + '].name" value="">';
        html += '</span>';
        html += '</div>';
        html += '<span class="link J_link">';
        html += '<label for="navName">跳转链接:</label>';
        html += '<span class="url">';
        html += '<input type="text" class="img_link" name="storeNavAuto[' + length + '].targetUrl" value="">';
        html += '</span>';
        html += '</span>';
        html += '<span class="oper"> <i class="del" title="删除">删除</i><i class="up" title="上移">上移</i><i class="down last_down" title="下移">下移</i></span></div>';
        $(this).parent().parent().prev().append(html);
        var html2 = '';
        html2 += '<li><a href="javascript:;"></a></li>';
        $(".nav-main ul").append(html2);
        //最上面和最下面的不能上下移动
        var length = $(".item_line").length;
        //console.log(length);
        $(".item_line").each(function() {
            $(this).find(".first_up").removeClass("first_up");
            $(this).find(".last_down").removeClass("last_down");
        });
        $(".item_line").eq(0).find(".up").addClass("first_up");
        $(".item_line").eq(length - 1).find(".down").addClass("last_down");
    });
    /*导航链接-删除*/
    $("body").delegate(".oper .del", "click", function() {
        var len = $(".item_line_wrap2>div").size();
        if (len != 1) {
            $(this).parents(".item_line").remove();
        }
    });
    //导航链接-上移
    $("body").on("click", "#edit-nav .up", function() {
        var index = $(this).parents('item_line').index();
        //console.log(index);
        if (index != '0') {
            $(this).parent().parent().prev().before($(this).parent().parent());
        }
        //最上面和最下面的不能上下移动
        var length = $(".item_line").length;
        $(".item_line").each(function() {
            $(this).find(".first_up").removeClass("first_up");
            $(this).find(".last_down").removeClass("last_down");
        });
        $(".item_line").eq(0).find(".up").addClass("first_up");
        $(".item_line").eq(length - 1).find(".down").addClass("last_down");
    });
    //导航链接-下移
    $("body").on("click", "#edit-nav .down", function() {
        var length = $(".item_line").length;
        var index = $(this).parent().parent().index();
        if (index != length) {
            $(this).parent().parent().next().after($(this).parent().parent());
        }
        //最上面和最下面的不能上下移动
        $(".item_line").each(function() {
            $(this).find(".first_up").removeClass("first_up");
            $(this).find(".last_down").removeClass("last_down");
        });
        $(".item_line").eq(0).find(".up").addClass("first_up");
        $(".item_line").eq(length - 1).find(".down").addClass("last_down");
    });
    //导航编辑--新增保存
    //$("body").on("click", "#edit-nav .opt-footer .btn-ok ", function () {
    //
    //    $(".nav-main a").html('');
    //    $(".nav-main a").attr('href', '');
    //    var length = $("#item_line_wrap2").find(".item_line").length;
    //    var item_line = $("#item_line_wrap2").find(".item_line");
    //    //console.log(item_line);
    //    for (var i = 1; i <= length; i++) {
    //        $(".hd-nav .nav-main a").eq(i - 1).text(item_line.eq(i - 1).find(".nav_name").val());
    //        $(".hd-nav .nav-main a").eq(i - 1).attr("href", item_line.eq(i - 1).find(".img_link").val());
    //    }
    //});
    //店招保存按钮
    $("body").on("click", "#edit-shopsigns .J_SubmitButton", function() {
        var index = parent.layer.getFrameIndex(window.name);
        //console.log(index);
        // console.log(3333);
        var edtype = $(this).parents(".content").find(".nav li.selected").attr("type");
        edtype = parseInt(edtype) - 1;
        var obj = $(this).parents(".content").find(".panel:eq(" + edtype + ")");
        var idx = false;
        //console.log(obj);
        obj.find("input[type=text]").each(function() {
            //console.log($(this));
            if ($(this).val() == "") {
                idx = true;
            }
        });
        if (idx) {
            $(this).parent().find(".J_TMsg").removeClass("disappear");
            $(this).parent().find(".J_TMsg").addClass("failure");
        } else {
            //ajax
            var params = $('#module-options').serialize();
            $.ajax({
                url: '/seller/design/saveModuleOption.json',
                type: 'POST',
                data: params,
                // dataType: 'json',
                success: function(d) {
                    //parent.$('').html(d);
                    //console.log(d);
                    parent.$(".nav-main a").html('');
                    parent.$(".nav-main a").attr('href', '');
                    var length = $("#item_line_wrap2").find(".item_line").length;
                    var item_line = $("#item_line_wrap2").find(".item_line");
                    //console.log(item_line);
                    for (var i = 1; i <= length; i++) {
                        parent.$(".hd-nav .nav-main a").eq(i - 1).text(item_line.eq(i - 1).find(".nav_name").val());
                        parent.$(".hd-nav .nav-main a").eq(i - 1).attr("href", item_line.eq(i - 1).find(".img_link").val());
                    }
                    var urlobj = $("#Js-shopsigns").val();
                    //console.log(urlobj);
                    //console.log(parent.$(".hd-main")[0]);
                    parent.$(".hd-main").css({
                        "background-image": "url(" + urlobj + ")",
                        "background-repeat": "no-repeat"
                    });
                    parent.layer.close(index);
                },
                error: function(e) {}
            });
        }
    });
    //input 框拿到焦点
    $("body").delegate("input[type=text]", "focus", function() {
        $(".J_TMsg").removeClass("failure");
        $(".J_TMsg").addClass("disappear");
    });
    /*图片编辑-tab 切换*/
    $("body").delegate("#edit-carousel .nav li", "click", function() {
        var id = $(this).attr("id");
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $("#edit-carousel").find(".panels .panel").each(function() {
            var conid = $(this).attr("aria-labelledby");
            if (conid == id) {
                $(this).removeClass("hidden");
                $(this).siblings().addClass("hidden");
            }
        })
    });
    /*图片编辑-添加*/
    $("body").delegate(".add-one", " click", function() {
        $("#J_TMsg").removeClass("failure");
        $("#J_TMsg").addClass("disappear");
        var length = $("#J_EditorBox").find(".edit-item").length;
        $("#J_EditorBox").find(".edit-item").eq(length - 1).removeClass("last");
        html = '';
        html += '<div class="edit-item J_TEditItem last">';
        html += "<div class='column column1'><input class='J_ImgUrl' type='text' name='images[" + length + "].picUrl' value=''></div> ";
        html += "<div class='column column2'><input class='J_LinkUrl' type='text' name='images[" + length + "].targetUrl' value=''></div> ";
        html += "<div class='column column3 J_Control'>";
        html += "<a title='上移' class='up' href='javascript:;'></a><a title='下移' class='down' href='javascript:;'></a>";
        html += "<a title='删除' class='delete' href='javascript:;'></a></div>";
        $("#J_EditorBox").append(html);
    });
    /*图片编辑-删除*/
    $("body").delegate(".delete", "click", function() {
        var len = $("#J_EditorBox>div").size();
        if (len != 1) {
            $("#J_EditorBox").find(".edit-item").eq(len - 2).addClass("last");
            $('[name=hdfile]').val('');
            $(this).parents(".J_TEditItem").remove();
        } else {
            $("#J_TMsg").removeClass("disappear");
            $("#J_TMsg").addClass("failure");
        }
    });
    //获得焦点删除提示信息
    $("body").delegate("input[type=text]", "focus", function() {
        $("#J_TMsg").removeClass("failure");
        $("#J_TMsg").addClass("disappear");
    });
    /*图片编辑-上下移动*/
    //图片编辑-上移
    $("body").on("click", "#edit-carousel .up", function() {
        var index = $(this).parents('.edit-item').index();
        //console.log(index);
        if (index != '0') {
            $(this).parent().parent().prev().before($(this).parent().parent());
        }
        //最上面和最下面的不能上下移动
        var length = $("#J_EditorBox").find(".edit-item").length;
        $("#J_EditorBox").find(".edit-item").each(function() {
            $(this).removeClass("first");
            $(this).removeClass("last");
        });
        $("#J_EditorBox").find(".edit-item").eq(0).addClass("first");
        $("#J_EditorBox").find(".edit-item").eq(length - 1).addClass("last");
    });
    //图片编辑-下移
    $("body").on("click", "#edit-carousel .down", function() {
        var length = $("#J_EditorBox").find(".edit-item").length;
        var index = $(this).parents('.edit-item').index();
        if (index != length) {
            $(this).parent().parent().next().after($(this).parent().parent());
        }
        //最上面和最下面的不能上下移动
        $("#J_EditorBox").find(".edit-item").each(function() {
            $(this).removeClass("first");
            $(this).removeClass("last");
        });
        $("#J_EditorBox").find(".edit-item").eq(0).addClass("first");
        $("#J_EditorBox").find(".edit-item").eq(length - 1).addClass("last");
    });
    /*编辑-保存 ajax请求*/
    //$("body").delegate("#module-options-save", "click", function () {
    //    $(".piccarousel .slide-content").html("");
    //    $(".slide-triggers").html("");
    //    var length = $("#J_EditorBox").find(".edit-item").length;
    //    var edit_item = $("#J_EditorBox").find(".edit-item");
    //    //console.log(length);
    //    var idx = 0;
    //    for (var i = 1; i <= length; i++) {
    //        var src = edit_item.eq(i - 1).find(".column1 input").val();
    //        var href = edit_item.eq(i - 1).find(".column2 input").val();
    //        console.log(src);
    //        if (src) {
    //            var html = "";
    //            html += "<li style='display: block;'><a target='_blank' title=''  href='+href+'>";
    //            html += "<img src='" + src + "'></a></li>";
    //            $(".piccarousel .slide-content").append(html);
    //        }
    //        else {
    //            edit_item.eq(i - 1).find(".column1 .J_TMsg").removeClass("disappear");
    //            edit_item.eq(i - 1).find(".column1 .J_TMsg").addClass("failure");
    //            return false;
    //        }
    //    }
    //
    //    for (var j = 1; j <= length; j++) {
    //        var html = "";
    //        if (idx == 0) {
    //            html += "<li class='first selected'><span>" + j + "</span><s></s></li>";
    //            idx++;
    //        }
    //        else {
    //            html += " <li><span>" + j + "</span><s></s></li>"
    //        }
    //        $(".slide-triggers").append(html);
    //    }
    //});
    /*编辑-弹框 */
    $("body").delegate(".J_TModule  .edit_content", "click", function() {
        var title = $(this).parent().parent().attr("data-title");
        var parent = $(this).parent().parent();
        var id = parent.data('id'),
            type = parent.parent().data('type'),
            area = parent.parent().parent().data('id');
        layer.open({
            type: 2,
            title: title,
            skin: 'layui-layer-rim', //加上边框
            area: ['800px', '500px'],
            content: "/seller/design/getModuleOption.htm?id=" + id + '&area=' + area + '&type=' + type
        });
    });
    //drag
    $('.J_NModule').on('mousedown', function() {
        window.bin = true;
    });
    //鼠标移上去
    $("body").delegate(".J_TModule", "mousemove", function(e) {
        // bin=true;
        if (window.bin) {
            //console.log($(this).parent().attr("data-type"));
            var height = $(this).height();
            var top = $(this).offset().top;
            var yy = e.pageY;
            if ((height / 2) > (yy - top)) {
                if ($(this).parent().attr("data-type") == 0) {
                    $(".edit-bar  .up .tip").html("该区域不能放置任何模块");
                    $(".edit-bar  .up .tip").css({
                        "background-color": "red"
                    })
                    $(".edit-bar  .up").css({
                        "display": "block"
                    });
                    $(".edit-bar  .down").css({
                        "display": "none"
                    });
                } else {
                    $(".edit-bar  .up").css({
                        "display": "block"
                    });
                    $(".edit-bar  .down").css({
                        "display": "none"
                    });
                }
                //  console.log("上方显示div");
            } else {
                if ($(this).parent().attr("data-type") == 0) {
                    $(".edit-bar  .down .tip").html("该区域不能放置任何模块");
                    $(".edit-bar  .down .tip").css({
                        "background-color": "red"
                    });
                    $(".edit-bar  .down").css({
                        "display": "block"
                    });
                    $(".edit-bar  .up").css({
                        "display": "none"
                    });
                } else {
                    $(".edit-bar  .down").css({
                        "display": "block"
                    });
                    $(".edit-bar  .up").css({
                        "display": "none"
                    });
                }
                // console.log("下下方显示div");
            }
        }
    });
    //鼠标离开事件
    $("body").delegate(".J_TModule", "mouseleave", function(e) {
        $(".J_NewInsertNode").css("display", "none");
    });
    //全局绑定鼠标抬起事件
    $("body").on('mouseup', function() {
        window.bin = false;
    });
    /*宝贝推荐编辑-tab 切换*/
    $("body").delegate("#edit-recommend .nav li", "click", function() {
        var id = $(this).attr("id");
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
        $("#edit-recommend").find(".panels .panel").each(function() {
            var conid = $(this).attr("aria-labelledby");
            if (conid == id) {
                $(this).removeClass("hidden");
                $(this).siblings().addClass("hidden");
            }
        })
    });
    $("body").delegate("#edit-recommend .itemsLayout", "click", function() {
        $(this).siblings().find("dt").removeClass("dtselected");
        $(this).find("dt").addClass("dtselected");
    });
    //手动和自动切换
    $("body").delegate("input[name=promoteType]", "click", function() {
        var name = $(this).val();
        if (name.trim() == "2") {
            $(this).parents(".panel").find(".auto-rec-content").hide();
            $(this).parents(".panel").find(".manual-rec-content").show();
        } else {
            $(this).parents(".panel").find(".auto-rec-content").show();
            $(this).parents(".panel").find(".manual-rec-content").hide();
        }
    });
    //点击确定
    $(".J_PageSelect").click(function() {
        if ($(this).parent().next().hasClass("page-list-visible")) {
            $(this).find("i").css("transform", "rotate(0deg)");
            $(this).parent().next().removeClass("page-list-visible");
        } else {
            $(this).find("i").css("transform", "rotate(180deg)");
            $(this).parent().next().addClass("page-list-visible");
        }
    });
    // 切换选择是一行显示几个
    $("body").delegate("#edit-recommend .itemsLayout", "click", function() {
        $(this).siblings().find("input[name='radio']").attr("checked", false);
        $(this).find("input[name='radio']").attr("checked", true);
    });
    //width-size切换
    $(" .toolbar .sizes span").click(function() {
        $(this).addClass("size-selected");
        $(this).siblings().removeClass("size-selected");
        var data = $(this).attr("data-size");
        $(this).parent().next().find("ul").each(function() {
            var size = $(this).attr("data-size");
            if (size == data) {
                $(this).show();
                $(this).siblings().hide();
                $(this).parent().find(".head").show();
            }
            return;
        })
    });
    //新建页面
    $(".new-page").click(function() {
        layer.open({
            type: 2,
            title: "新建页面",
            skin: 'layui-layer-rim', //加上边框
            area: ['700px', '500px'],
            content: "/seller/designManage/page-add.htm"
        });
    });
   //search 下拉显示
    $('.mr-title a').eq(1).click(function () {
        $('.m-search').toggle();
        if($('.m-search').css('display') == 'block'){
            $('i',this).css('transform','rotate(180deg)');
        }else{
            $('i',this).css('transform','rotate(0deg)');
        }
    });

    //绑定全局事件
    $(document).bind('click', function() {
        $('.J_PageListWrapPopup').removeClass('page-list-visible');
    });
    //绑定除了 下拉框以及下拉框内容点击时候 不触发该事件
    $('.J_PageSelect, .J_PageListWrapPopup .new-page ').bind('click', function(e) {
        stopPropagation(e);
    });

    function stopPropagation(e) {
        if (e.stopPropagation) {
            e.stopPropagation();
        } else {
            e.cancelBubble = true;
        } //阻止该事件的发生
    }
});