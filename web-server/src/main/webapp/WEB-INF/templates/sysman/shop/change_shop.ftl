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
    <title>修改店铺</title>
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
        <legend>修改店铺信息</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="shopId" value="${shop.shopId}" />
        <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">店铺市场</label>-->
            <#--<div class="layui-input-inline">-->
                <#--<select name="marketId" id="selectMarket" lay-filter="market" onclick="floorajaxlist();">-->
                    <#--<option value="">请选择市场</option>-->
                <#--<#list shiguMarketList as market>-->
                    <#--<option value="${market.marketId}">${market.marketName}</option>-->
                <#--</#list>-->
                <#--</select>-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">店铺楼层</label>-->
            <#--<div class="layui-input-inline">-->
                <#--<select name="floorId" id="selectFloor">-->
                    <#--<option value="">请选择楼层</option>-->
                <#--</select>-->
            <#--</div>-->
        <#--</div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">店铺名称</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${shop.shopName}" name="shopName" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">淘宝昵称</label>
            <div class="layui-input-inline">
                <input type="hidden" value="${shop.tbNick}" id="hiddenTbNick"/>
                <input style="width:200px;" type="text" value="${shop.tbNick}" name="tbNick" id="tbNick" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">&nbsp;此处修改请慎重操作！昵称修改可重新授权与更换淘宝链接</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">档口号</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${shop.shopNum}" name="shopNum" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">排序档口</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${shop.sortOrderKey}" name="sortOrderKey" autocomplete="off" class="layui-input">
            </div>
        </div>
        <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">淘宝链接</label>-->
            <#--<div class="layui-input-block">-->
                <#--<input style="width:200px;" type="text" value="${shop.taobaoUrl}" name="taobaoUrl" autocomplete="off" class="layui-input">-->
            <#--</div>-->
        <#--</div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">开店时间</label>
            <div class="layui-input-block">
                <input onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" style="width:200px;" type="text" value="${shop.createDate?string("yyyy-MM-dd hh:mm:ss")}" name="createDateStr" autocomplete="off" class="layui-input" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">系统备注</label>
            <div class="layui-input-block">
                <input style="width:200px;" type="text" value="${shop.systemRecommon}" name="systemRecommon" autocomplete="off" class="layui-input">
            </div>
        </div>
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
        var hiddenTbNicks = $("#hiddenTbNick").val();
        var tbNick = $("#tbNick").val();
        var pans = false;
        if(panIsNull(hiddenTbNicks)){
            if(!panIsNull(tbNick)){
                pans = true;
            }
        }else{
            if(panIsNull(tbNick)){
                layer.alert('淘宝昵称不能设置为空', {icon:2});
                return;
            }
            if(hiddenTbNicks!=tbNick){
                pans = true;
            }
        }
        if(pans){
            var confirms = layer.confirm("您确定要修改店铺昵称吗?昵称修改可更换淘宝链接，同时也会修改店铺绑定的用户。若无这需求，请不要修改淘宝昵称", {
                btn : [ '确定', '取消' ], // 按钮
                shade : false
                // 显示遮罩
            }, function() {
                layer.close(confirms);
                changeQuer();
            }, function() {
                // 取消
                return;
            });
        }else{
            changeQuer();
        }

    }

    function changeQuer(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/shop/changeShop.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('更新店铺成功', {icon:1});
                    window.parent.search();
                    window.parent.layer.close(index);
                    return;
                }
                layer.alert(data.msg, {icon:2});
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

    var marketId = '${shop.marketId}';
    var floorId = '${shop.floorId}';
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