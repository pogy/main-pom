<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>店铺绑定列表</title>
    <link rel="stylesheet" href="${back_man_host}/sysman/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${back_man_host}/sysman/css/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${back_man_host}/sysman/css/font-awesome.min.css">
    <link rel="stylesheet" href="${back_man_host}/sysman/css/table.css" />


    <style>
        .layui-form-item{
            padding: 5px 4px;
            margin-bottom: 0px;
        }
        .layui-elem-quote{
            padding:5px;
        }
        td{font-size:13px;}
    </style>
</head>

<body>
<div class="admin-main">
    <input type="hidden" name="webSite" value="${webSite}" id="webSite"/>
    <input type="hidden" name="outerFloorId" value="${outFloorId}" id="outerFloorId"/>
    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 新增绑定店铺
        </a>
        <a href="javascript:;" class="layui-btn layui-btn-small" id="del">
            删除
        </a>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>市场展示楼层绑定店铺列表</legend>
        <div class="layui-field-box">
            <div>
            <table class="site-table table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" id="selected-all"></th>
                    <th>ID</th>
                    <th>店铺名称</th>
                    <th>档口号</th>
                    <th>市场</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list shopList as shop>
                <tr>
                    <td><input type="checkbox" name="ruleId" value="${shop.shopId}" /></td>
                    <td>${shop.shopId}</td>
                    <td>${shop.shopName}</td>
                    <td>
                        ${shop.shopNum}
                    </td>
                    <td>
                        ${shop.parentMarketName}
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="danDudelOutShop('${shop.shopId}');">删除</a>
                    </td>
                </tr>

                </#list>

                </tbody>
            </table>
            </div>
        </div>
    </fieldset>
</div>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>

<script>
    layui.config({
        base: '/sysman/plugins/layui/modules/'
    });

    var layer = layui.layer;

    layui.use(['icheck', 'laypage','layer'], function() {
        var $ = layui.jquery,
                laypage = layui.laypage,
                layer = layui.layer;
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green'
        });

        $('.site-table tbody tr').on('click', function(event) {
            var $this = $(this);
            var $input = $this.children('td').eq(0).find('input');
            $input.on('ifChecked', function(e) {
                $this.css('background-color', '#EEEEEE');
            });
            $input.on('ifUnchecked', function(e) {
                $this.removeAttr('style');
            });
            $input.iCheck('toggle');
        }).find('input').each(function() {
            var $this = $(this);
            $this.on('ifChecked', function(e) {
                $this.parents('tr').css('background-color', '#EEEEEE');
            });
            $this.on('ifUnchecked', function(e) {
                $this.parents('tr').removeAttr('style');
            });
        });
        $('#selected-all').on('ifChanged', function(event) {
            var $input = $('.site-table tbody tr td').find('input');
            $input.iCheck(event.currentTarget.checked ? 'check' : 'uncheck');
        });

        $("#add").click(function(){
            var marketLayer = layer.open({
                type: 2,
                title:false,
                shadeClose: false,
                shade: [0.3, '#000'],
                maxmin: true, //开启最大化最小化按钮
                offset: '50px',
                area: ['900px' , '400px'],
                content: getRealPath() + '/sysman/outFloor/addOutShopView.htm?outFloorId='+$("#outerFloorId").val()+'&webSite='+$("#webSite").val()
            });
        });

        $("#del").click(function(){
            delOutShop();
        });

    });

    function refreshLoad(){
        location.reload();
    }

    // 删除店铺
    function danDudelOutShop(shopId){
        if(confirm('确认删除绑定店铺吗？请慎重，此操作无法恢复哦')){
            var loadi = layer.load();
            var datajson = {"shopIds":shopId,"outFloorId":$("#outerFloorId").val()}
            $.ajax({
                type : "POST",
                url : getRealPath() + '/sysman/outFloor/delOutShop.json',
                data : datajson,
                dataType : "json",
                async : true,
                success : function(data) {
                    layer.close(loadi);
                    if(data.status == 'success'){
                        alert('删除店铺成功');
                        refreshLoad();
                        return;
                    }
                    alert(data.msg);
                }
            });

            return;
        }
    }

    // 删除店铺
    function delOutShop(){
        var allSum = $("input[name='ruleId']:checked");
        if (parseInt(allSum.length) == 0) {
            alert('请选择你要删除的数据');
            return;
        }
        if(confirm('确认删除绑定店铺吗？请慎重，此操作无法恢复哦')){
            var loadi = layer.load();
            var datajson = {"shopIds":eachBox(allSum),"outFloorId":$("#outerFloorId").val()}
            $.ajax({
                type : "POST",
                url : getRealPath() + '/sysman/outFloor/delOutShop.json',
                data : datajson,
                dataType : "json",
                async : true,
                success : function(data) {
                    layer.close(loadi);
                    if(data.status == 'success'){
                        alert('删除店铺成功');
                        refreshLoad();
                        return;
                    }
                    alert(data.msg);
                }
            });

            return;
        }
    }
</script>
</body>

</html>