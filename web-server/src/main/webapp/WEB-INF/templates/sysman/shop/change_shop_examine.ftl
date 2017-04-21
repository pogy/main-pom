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
    <title>修改店铺申请</title>
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
        <legend>修改店铺入驻申请信息</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="ruzhuId" value="${apply.ruzhuId}" />
        <div class="layui-form-item">
            <label class="layui-form-label">店铺市场</label>
            <div class="layui-input-inline">
                <select name="marketId" id="selectMarket" lay-filter="market" onclick="floorajaxlist();">
                    <option value="">请选择市场</option>
                <#list shiguMarketList as market>
                    <option value="${market.marketId}">${market.marketName}</option>
                </#list>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">店铺楼层</label>
            <div class="layui-input-inline">
                <select name="floorId" id="selectFloor">
                    <option value="">请选择楼层</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">档口号</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.shopNum}" name="shopNum" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.telephone}" name="telephone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">微信号</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.imWx}" name="imWx" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">QQ号</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.imQq}" name="imQq" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.email}" name="email" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">淘宝昵称</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.tbNick}" name="tbNick" autocomplete="off" class="layui-input">
            </div>
        </div>
        <#--<div class="layui-form-item">
            <label class="layui-form-label">淘宝链接</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${apply.tbUrl}" name="tbUrl" autocomplete="off" class="layui-input">
            </div>
        </div>-->
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="changeShop()">立即提交</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>
<script>

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        form.on('select(market)', function(data){
            floorajaxlist();
            form.render('select'); //刷新selec
        });
    });

    // 修改
    function changeShop(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/shop/changeShopExamine.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    alert('更新店铺入驻申请成功');
                    window.parent.search();
                    window.parent.layer.close(index);
                    return;
                }
                alert(data.msg);
            }
        });
    }

    // 楼层
    function floorajaxlist(){
        var marketId = $("#selectMarket").val();
        if(panIsNull(marketId)){
            return;
        }
        var datajson = {"marketId":marketId};
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/floor/ajaxlist.json',
            data : datajson,
            dataType : "json",
            async : false,
            success : function(data) {
                $("#selectFloor").html('');
                var flooroption = '';
                var json_data=eval("("+data+")");
                for(var i = 0;i<json_data.length;i++){
                    flooroption += "<option value='"+json_data[i].marketId+"'>"+json_data[i].marketName+"</option>";
                }
                $("#selectFloor").html(flooroption);
            }
        });
    }

    var marketId = '${apply.marketId}';
    var floorId = '${apply.floorId}';
    $(document).ready(function(){
        if(!panIsNull(marketId)){
            $("#selectMarket").val(marketId);
            floorajaxlist();
            if(!panIsNull(floorId)){
                $("#selectFloor").val(floorId);
            }
        }
    });
</script>
</body>

</html>