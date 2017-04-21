/**控制器**/
var controller = {
    //初始化
    init: function () {
        this.initDrag();
    },
    //初始化可拖拽组件
    initDrag: function () {
        $(".J_TModule,.js-model").droppable({
            accept: ".js-module-list li",
            drop: controller.handler
        });
        $(".js-module-list li").draggable({
            helper: "clone"
        });
    },

    /**
     * 添加区域
     */
    addArea: function ($grid, type, sideAreaId, after, callback) {
        $.ajax({
            url: '/seller/design/addArea.json',
            type: 'GET',
            data: {'type': type, 'side': sideAreaId, 'after': after},
            success: function (d) {
                if (callback) callback($grid, d);
            }
        });
    },

    /**
     * 添加宝贝分类模块
     * @param $grid
     * @param areaId 区域ID
     * @param moduleId 模块ID
     * @param sideModuleId 旁边的模块ID
     * @param type 存放区域类型
     * @param after 放在之后
     */
    addModule: function ($grid, areaId, moduleId, sideModuleId, type, after) {
        $.ajax({
            url: '/seller/design/addModule.htm',
            type: 'GET',
            data: {'id': moduleId, 'area': areaId, 'type': type, 'side': sideModuleId, 'after': after},
            success: function (d) {
                // 在模块后面
                if (after == 1) {
                    $grid.after(d);
                    $grid.next().droppable({
                        accept: ".js-module-list li",
                        drop: controller.handler
                    });
                } else {
                    $grid.before(d);
                    $grid.prev().droppable({
                        accept: ".js-module-list li",
                        drop: controller.handler
                    });
                }
                // 隐藏可拖入提示
                if ($grid.hasClass('js-model')) {
                    $grid.hide();
                }
            }
        })
    },

    handler: function (e, ui) {
        // 获取该模块可放的类型
        var areaType = ui.draggable.data("type").toString().split(',');
        var parent = $(this).parent(),
            // 获取区域ID
            areaId = parent.parent().data('id'),
            // 获取模块ID
            moduleId = ui.draggable.data('tpl'),
            // 获取该区域存放的类型
            type = parent.data("type").toString();

        if (type == 0) {
            return;
        }

        // 是否加入后面
        var after = 1;
        if (($(this).height() / 2) > (e.pageY - $(this).offset().top)) {
            // 加入前面
            after = 2;
        }

        // 是否可拖放
        if (areaType.indexOf(type) == -1) {
            if (type == 2) {
                if (areaType.indexOf('3') != -1) {
                    type = 1;
                }
            }
            controller.addArea($(this), type, areaId, after, function ($grid, d) {
                if (d.status != 0) {
                    console.log('创建区域失败');
                    return;
                }
                var areaHtml = '';
                if (type == 1) {
                    // 1190
                    areaHtml = '<div class="area-1190" data-type="3"><div class="js-model ui-droppable" style=" width: calc(100% - 2px);background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;"><span>可添加模块</span></div></div>';
                } else {
                    // 190&750
                    areaHtml = '<div class="area-190" data-type="1"><div class="js-model ui-droppable" style=" width: calc(100% - 2px);background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;"><span>可添加模块</span></div></div>';
                    areaHtml += '<div class="area-990" data-type="2"><div class="js-model ui-droppable" style=" width: calc(100% - 2px);background: rgba(1, 177, 255, 0.2); color: #000; border: 1px dotted #0a9eea;"><span>可添加模块</span></div></div>';
                }
                var areaId = d.data,
                    html = '<div class="area clearfix" data-id="' + areaId + '">' + areaHtml + '</div>';

                // 在页面中添加区域html
                var area = $grid.parent().parent(),
                    js_model = null;
                if (after == 1) {
                    area.after(html);
                    area = area.next();
                } else {
                    area.before(html);
                    area = area.prev();
                }
                // 为区域绑定拖放事件
                js_model = area.children(type == 1 ? '.area-1190' : '.area-190')
                    .children('.js-model');
                area.children('div').find('.js-model').droppable({
                    accept: ".js-module-list li",
                    drop: controller.handler
                });
                // 在该区域中添加当前拖拽模块
                controller.addModule(js_model, areaId, moduleId, 'none', type == 1 ? 3 : 1, after);
            });
            return;
        }

        // 鼠标放开位置的模块ID
        var sideModuleId = $(this).data('id');
        // 添加模块
        controller.addModule($(this), areaId, moduleId, sideModuleId, type, after);
    }
};

$(document).ready(function () {
    controller.init();
});