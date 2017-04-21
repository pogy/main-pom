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
    <title>修改楼层展示</title>
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
        <legend>修改楼层展示</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="outerFloorId" value="${floor.outerFloorId}" />
        <input type="hidden" name="ruleId" value="${ruleId}" />
        <input type="hidden" name="webSite" id="webSite" value="${webSite}" />
        <div class="layui-form-item">
            <label class="layui-form-label">显示名称</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${floor.showName}" name="showName" autocomplete="off" placeholder="请输入显示名称" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实际楼层</label>
                <div class="layui-input-block">
                    <input type="hidden" name="floorIds" id ="marketIds" value="${floor.floorIds}"/>
                    <input style="width:500px;" value="${floor.floorNames}" type="text" name="sjmarketName" id="marketName" autocomplete="off" placeholder="选择实际楼层" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <button type="button" class="layui-btn layui-btn-primary" id="selectFloor">选择</button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">楼层排序</label>
            <div class="layui-input-inline">
                <input type="number" name="sortOrder" value="${floor.sortOrder}" lay-verify="number" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">数字越大越靠后</div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="changeOutFloor()">立即提交</button>
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
                title:'选择实际楼层',
                shadeClose: false,
                shade: [0.3, '#000'],
                maxmin: true, //开启最大化最小化按钮
                area: ['700px' , '300px'],
                content: getRealPath() + 'sysman/market/selectList.htm?webSite='+$("#webSite").val()+"&multiBand=true"
            });
        });

    });

    // 新增楼层
    function changeOutFloor(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/outFloor/changeOuterFloor.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('更新楼层成功',function(){
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