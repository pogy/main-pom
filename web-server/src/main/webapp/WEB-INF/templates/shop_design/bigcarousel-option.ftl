<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>模块编辑 - 星座网</title>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/option.css?t=20161219A"  type="text/css"/>
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/s/editor/kindeditor-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/shop_design.js"></script>
</head>
<body>
<form id="module-options">
    <input type="hidden" name="moduleId" value="${moduleSet.moduleId}">
    <input type="hidden" name="areaId" value="${moduleSet.areaId}">
    <input type="hidden" name="sideType" value="${moduleSet.sideType}">
    <div>
        <div class="edit-carousel" id="edit-carousel">
            <div class="content">
                <span class="J_TMsg msg disappear"><i class="msg-icon"></i><span class="text"></span></span>
                <div class="tab">
                    <ul class="nav clearfix" role="tablist">
                        <li class="selected first" role="tab" type="1" id="ks-switchable10"><span>内容设置</span></li>
                        <li class="" role="tab" type="2" id="ks-switchable11"><span>显示设置</span></li>
                    </ul>
                    <div class="main-slide-form form-default">
                        <div class="panels">
                            <div class="panel" type="1" aria-labelledby="ks-switchable10">
                                <div class="edit-module">
                                    <div class="edit-item edit-head">
                                        <div class="column column1"><span>图片地址:</span></div>
                                        <div class="column column2"><span>链接地址:</span></div>
                                        <div class="column column3"><span>操作:</span></div>
                                    </div>
                                    <div id="J_EditorBox" class="pic-list">
                                    <#list moduleSet.images as img>
                                        <div class="edit-item J_TEditItem <#if img_index==0>even firstlast</#if> <#if img_has_next==false>last</#if>">
                                                <div class="column column1">
                                                    <label>
                                                        <input class="J_ImgUrl" type="text" name="images[${img_index}].picUrl" value="${img.picUrl}">
                                                    </label>
                                                </div>
                                                <div class="column column2">
                                                    <label>
                                                        <input class="J_LinkUrl" type="text" name="images[${img_index}].targetUrl" value="${img.targetUrl}">
                                                    </label>
                                                </div>
                                                <div class="column column3 J_Control">
                                                    <a title="上移" class="up" href="javascript:;"></a><a title="下移" class="down" href="javascript:;"></a><a title="删除" class="delete" href="javascript:;"></a>
                                                </div>
                                        </div>
                                    </#list>
                                    </div>
                                    <div class="bottom">
                                        <a class="add-one btn-style-1" href="javascript:;">添加</a>
                                    </div>
                                    <div class="J_TMsg item-number-msg msg disappear" id="J_TMsg">
                                        <i class="msg-icon"></i><span class="text">请至少选中一组</span>
                                    </div>
                                </div>
                                <div id="J_Tadget" class="tadget-box"></div>

                            </div>
                            <div class="panel hidden" type="2" role="tabpanel" aria-labelledby="ks-switchable11">
                                <div class="control-group module-height">
                                    <label class="control-label">模块高度:</label>
                                    <div class="control">
                                        <div>
                                            <label>
                                                <input autocomplete="off" name="mod_height" type="text" value="${moduleSet.modHeight!}">
                                                <span>px</span>&nbsp;<span>*请设置在100-600px之间</span>
                                            </label>
                                        </div>
                                <span class="J_TMsg msg disappear">
                                    <i class="msg-icon"></i><span class="text"></span>
                                </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<div class="opt-footer" style="margin-bottom: 15px;">
    <a href="javascript:;" class="btn-ok" id="module-options-save">保存</a>
    <a href="javascript:;"  class="btn-cancel" id="module-options-cancel">取消</a>
    <span class="J_TMsg msg disappear"><i class="msg-icon"></i><span class="text">您有未完成的输入框</span></span>
</div>
<script type="text/javascript">
    $(function () {
        var index = parent.layer.getFrameIndex(window.name);
        $('#module-options-save').click(function () {
            var edtype=$("#module-options").find(".nav li.selected").attr("type");
            edtype=parseInt(edtype)-1;
            var obj=$("#module-options").find(".panel:eq("+edtype+")");
            var idx=false;
            obj.find("input[type=text]").each(function(){

                // console.log($(this).attr("value"));
                if($(this).attr("value")==""){

                    idx=true;
                }
            });
            //大图片
            $("#edit-bigpic").find("input[type=text]").each(function(){
                if($(this).attr("value")==""){
                    idx=true;
                }
            });
//注释了判断input 框为空
//            if(idx){
//                $(this).parent().find(".J_TMsg").removeClass("disappear");
//                $(this).parent().find(".J_TMsg").addClass("failure");
//            }
//            else {
            // 处理器是否存在
            if (typeof handler === 'function') {
                handler();
            }
            var params = $('#module-options').serialize();
            $.ajax({
                url: '/seller/design/saveBigcarouselOption.htm',
                type: 'POST',
                data: params,
                // dataType: 'json',
                success: function (d) {
                    parent.$('[data-id=${moduleSet.moduleId}]').html(d);
//                        console.log(d);
                    parent.layer.close(index);
//                       parent.location.reload();
                },
                error: function (e) {
                }
            });

//            }
        });

        $('#module-options-cancel').click(function () {
            parent.layer.close(index);

        });
    });
</script>
</body>
</html>