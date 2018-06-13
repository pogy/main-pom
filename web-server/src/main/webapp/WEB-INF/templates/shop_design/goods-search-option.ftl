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
        <div class="edit-search" id="edit-search">
            <div class="content">
                <div class="tab">
                    <ul class="nav clearfix">
                        <li class="selected first" type="1"><span>显示设置</span></li>
                    </ul>
                    <div class="panels form-default">
                        <div class="panel" type="1">
                            <div class="control-group">
                                <label class="control-label">显示标题：</label>
                                <div class="control show-title">
                                    <label>
                                        <input type="radio" class="input-radio" name="titleShow" value="0" <#if moduleSet.titleShow==0>checked</#if>
                                        >不显示
                                    </label>
                                    <label><input type="radio" class="input-radio" name="titleShow" value="1"
                                                  <#if moduleSet.titleShow==1>checked</#if>>显示</label>
                                    <label>
                                        <input class="input-box title-input" style="display:inline-block;" type="text"
                                               autocomplete="off"
                                               maxlength="12" name="title" value="${moduleSet.title}">
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">预置关键字：</label>
                                <div class="control">
                                    <label>
                                        <input class="input-box short keyword-input" type="text"
                                               name="keyword" value="${moduleSet.keyword}" autocomplete="off" maxlength="10">
                                        <span class="tips">预置在搜索框中，最长5个汉字、10个字母</span>
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">推荐关键字：</label>
                                <div class="control">
                                    <label>
                                        <input class="input-box short keyword-input" type="text" name="keywords[0]"
                                               value="${moduleSet.keywords[0]!}" autocomplete="off" maxlength="10">
                                        <input class="input-box short keyword-input" type="text" name="keywords[1]"
                                               value="${moduleSet.keywords[1]!}" autocomplete="off" maxlength="10">
                                        <input class="input-box short keyword-input" type="text" name="keywords[2]"
                                               value="${moduleSet.keywords[2]!}" autocomplete="off" maxlength="10">
                                        <span class="tips">搜索按钮后推荐，最长5个汉字、10个字母</span>
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">是否显示：</label>
                                <div class="control">
                                    <label>
                                        <input type="checkbox" class="input-checkbox" data-price-screen <#if moduleSet.priceScreen==1>checked</#if>>价格筛选
                                        <input type="hidden" name="priceScreen" value="${moduleSet.priceScreen}">
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('[data-price-screen]').change(function () {
                    $('[name=priceScreen]').val(($(this).attr('checked') == undefined ? 0 : 1).toString());
                });
            })
        </script>
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
                url: '/seller/design/saveGoodsSearchOption.htm',
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