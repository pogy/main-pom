<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>市场</title>
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
    <input type="hidden" name="webSite" value="${outerMarketBo.website}" id="webSite"/>
    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 新增市场展示
        </a>
        <a href="javascript:;" class="layui-btn layui-btn-small" id="del">
            删除
        </a>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>市场展示列表</legend>
        <div class="layui-field-box">
            <div>
            <table class="site-table table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" id="selected-all"></th>
                    <th>ID</th>
                    <th>展示市场</th>
                    <th>指向市场</th>
                    <th>展示楼层</th>
                    <th>排序</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list outerMarketList as market>
                <tr>
                    <td><input type="checkbox" name="ruleId" value="${market.ruleId}"/></td>
                    <td>${market.ruleId}</td>
                    <td>
                        <a href="${back_man_host}/market.htm?mid=${market.ruleId}" target="_blank">${market.marketName}</a>
                    </td>
                    <td>
                        <#if market.pointMarketName ??>
                            ${market.pointMarketName}
                        <#else>
                            无指向/自定义
                        </#if>
                    </td>
                    <td>
                        <#if market.outerFloorIds ??>
                            存在
                        <#else>
                            不存在
                        </#if>
                    </td>
                    <td>${market.sortOrder}</td>
                    <td >
                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="outFloorList('${market.ruleId}');">市场楼层</a>
                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="changeOutMarket('${market.ruleId}');">编辑</a>
                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="danduDelOutMarket('${market.ruleId}');">删除</a>
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
                offset: '100px',
                area: ['800px' , '400px'],
                content: getRealPath() + '/sysman/outmarket/addView.htm?webSite='+$("#webSite").val()

            });
        });

        $("#del").click(function(){
            delOutMarket();
        });

    });

    function refreshLoad(){
        location.reload();
    }

    // 修改市场
    function changeOutMarket(marketId){
        if(panIsNull(marketId)){
            alert('请选择一个市场')
            return;
        }
        var marketLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['800px' , '400px'],
            content: getRealPath() + '/sysman/outmarket/changeOutMarketView.htm?ruleId='+marketId+"&webSite="+$("#webSite").val()
        });
    }

    // 楼层列表
    function outFloorList(marketId){
        if(panIsNull(marketId)){
            alert('请选择外部楼层')
            return;
        }
        var datajson = {"marketId":marketId};
        var marketLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['900px' , '400px'],
            content: getRealPath() + '/sysman/outFloor/list.htm?outMarketId='+marketId+"&webSite="+$("#webSite").val()
        });
        layer.full(marketLayer);
    }

    // 删除删除市场
    function danduDelOutMarket(ruleId){
        if(confirm('确认删除市场吗？请慎重，此操作无法恢复哦')){
            var loadi = layer.load();
            var datajson = {"marketIds":ruleId}
            $.ajax({
                type : "POST",
                url : getRealPath() + '/sysman/outmarket/delOutMarket.json',
                data : datajson,
                dataType : "json",
                async : true,
                success : function(data) {
                    layer.close(loadi);
                    if(data.status == 'success'){
                        alert('删除市场成功');
                        refreshLoad();
                        layer.close(index);
                        return;
                    }
                    alert(data.msg);
                }
            });

            return;
        }
    }

    // 市场
    function delOutMarket(){
        var allSum = $("input[name='ruleId']:checked");
        if (parseInt(allSum.length) == 0) {
            alert('请选择你要删除的数据');
            return;
        }
        if(confirm('确认删除市场吗？请慎重，此操作无法恢复哦')){
            var loadi = layer.load();
            var datajson = {"marketIds":eachBox(allSum)}
            $.ajax({
                type : "POST",
                url : getRealPath() + '/sysman/outmarket/delOutMarket.json',
                data : datajson,
                dataType : "json",
                async : true,
                success : function(data) {
                    layer.close(loadi);
                    if(data.status == 'success'){
                        alert('删除市场成功');
                        refreshLoad();
                        layer.close(index);
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