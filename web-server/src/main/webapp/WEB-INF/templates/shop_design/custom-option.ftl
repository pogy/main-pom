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
        <div id="edit-design">
            <div id="design_main" style="width: 98%; margin: 5px auto;">
                <p style="margin-bottom: 5px;">
                    <span>是否显示标题：</span>
                    <label><input type="radio" name="titleShow" value="0" <#if moduleSet.titleShow==0>checked</#if>> 不显示</label>
                    <label><input type="radio" name="titleShow" value="1" <#if moduleSet.titleShow==1>checked</#if>> 显示</label>
                    <label>
                        <input type="text" name="title" value="${moduleSet.title!"自定义内容区"}" placeholder="自定义内容区">
                    </label>
                </p>
                <p style="margin-bottom: 8px; display: none;">
                    <span>显示区域宽度：</span>
                    <label style="margin-right: 8px;">
                        <input type="radio" name="nav_width" value="1" checked> 950px
                    </label>
                    <label style="margin-right: 8px;">
                        <input type="radio" name="nav_width" value="2"> 1200px
                    </label>
                    <label style="margin-right: 8px;">
                        <input type="radio" name="nav_width" value="3"> 1920px
                    </label>
                </p>
                <label>
                    <textarea id="content" name="content" style="width: 100%; min-height: 350px; max-width: 100%;">
                        <#if moduleSet.content!='<p style="text-align: center; padding: 20px 0 30px;">自定义内容，可以用来展示店铺特色的宝贝、活动。</p>'>${moduleSet.content!}</#if>
                    </textarea>
                </label>
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
                url: '/seller/design/saveCustomOption.htm',
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