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
    <title>编辑商品权重</title>
    <link rel="stylesheet" href="${back_man_host}/sysman/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${back_man_host}/sysman/css/font-awesome.min.css" />

    <style>
        .layui-input-block{
            margin-left:87px;
        }
    </style>
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>编辑商品权重</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="goodsId" value="${shiguGoodsTiny.goodsId}" />

        <div class="layui-form-item">
            <label class="layui-form-label">权重</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="number" id="sortOrder" name="sortOrder" value="${shiguGoodsTiny.sortOrder/1000}" autocomplete="off" class="layui-input" />
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="changeWh()">编辑提交</button>
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
    });

    var layer = layui.layer;

    // 修改权重
    function changeWh(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/goods/changeWh.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('编辑权重成功',function(){
                        window.parent.search();
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