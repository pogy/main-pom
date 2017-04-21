<#include "common/host_config.ftl">

<!DOCTYPE html>

<html>

<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <title>新增店铺绑定展示</title>
    <link rel="stylesheet" href="${back_man_host}/sysman/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${back_man_host}/sysman/css/font-awesome.min.css">

    <style>
        .layui-input-block{
            margin-left:87px;
        }
    </style>
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>新增店铺绑定展示</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="outFloorId" value="${outFloorId}" id="outerFloorId"/>
        <input type="hidden" name="webSite" value="${webSite}" id="webSite"/>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">店铺ID</label>
                <div class="layui-input-block">
                    <input style="width:150px;" type="text" name="shopId" id ="shopId" readonly="readonly" class="layui-input"/>
                </div>
            </div>
            <div class="layui-inline">
                <button type="button" class="layui-btn layui-btn-primary" id="selectFloor">选择</button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">店铺档口号</label>
            <div class="layui-input-block">
                <input class="layui-input" style="width:150px;" type="text" name="shopNum" id ="shopNum"/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="addOutShop()">立即提交</button>
            </div>
        </div>
    </form>


</div>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        $("#selectFloor").click(function(){
            var marketLayer = layer.open({
                type: 2,
                title:'选择绑定店铺',
                shadeClose: false,
                shade: [0.3, '#000'],
                maxmin: true, //开启最大化最小化按钮
                area: ['700px' , '300px'],
                content: getRealPath() + 'sysman/shop/selectList.htm?website='+$("#webSite").val()
            });
        });

    });

    // 新增绑定店铺
    function addOutShop(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/outFloor/addOutShop.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('新增店铺成功',function(){
                        window.parent.refreshLoad();
                        window.parent.layer.close(index);
                    });
                    return;
                }
                layer.alert(data.msg);
            }
        });
    }

</script>
</body>

</html>