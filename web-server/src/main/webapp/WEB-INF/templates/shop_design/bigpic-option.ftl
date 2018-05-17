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
        <div class="edit-bigpic" id="edit-bigpic">
            <div class="content">
                <div class="tips">模块使用小贴士：您可以通过图片+文字的方式引导用点击图片跳转到您指定的链接。通常用于有店铺的最新单品、精彩活动或优惠推荐。</div>
                <div class="tab">
                    <div class="main-slide-form form-default">
                        <div class="panels">
                            <div class="panel content-set">
                                <div class="edit-module">
                                    <div class="edit-item  edit-head">
                                        <div class="column column1">
                                            <span>图片地址<span style="color:red;">(宽1920，高最大800)</span></span>
                                        </div>
                                        <div class="column column2">
                                            <span>链接地址:</span>
                                        </div>
                                    </div>
                                    <div class="pic-list">
                                        <div class="edit-item J_TEditItem first even last">
                                            <div class="column column1">
                                                <label>
                                                    <input class="J_ImgUrl" type="text" name="picUrl"
                                                           value="<#if moduleSet.picUrl != '//img.alicdn.com/tps/TB1iG39KXXXXXbBXVXXXXXXXXXX-1920-540.png'>${moduleSet.picUrl!}</#if>" placeholder="请输入图片地址链接">
                                                </label>
                                            </div>
                                            <div class="column column2">
                                                <label>
                                                    <input class="J_LinkUrl" type="text" name="targetUrl"
                                                           value="<#if moduleSet.targetUrl != 'javascript:;'>${moduleSet.targetUrl}</#if>" placeholder="为空，默认不跳转">
                                                </label>
                                            </div>
                                        </div>
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
                url: '/seller/design/saveBigpicOption.htm',
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