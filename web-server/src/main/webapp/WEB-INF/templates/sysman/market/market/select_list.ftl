<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Table</title>
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
<#if bo.multiBand>
    <form class="layui-form" action="${back_man_host}/sysman/market/selectList.htm" id="searchForm" method="get">
        <input type="hidden" name="currentPage" id="currentPage" value="${bo.currentPage}"/>
        <input type="hidden" name="website" value="${bo.website}"/>
        <input type="hidden" name="multiBand" value="${bo.multiBand}"/>

        <div class="layui-form-item">
            <label class="layui-form-label">市场</label>
            <div class="layui-input-inline">
                <select name="marketId" id="selectMarket" lay-filter="market" onclick="floorajaxlist();">
                <#list shiguMarketList as market>
                    <option value="${market.marketId}">${market.marketName}</option>
                </#list>
                </select>
            </div>
        </div>

    </form>

    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="search">
            <i class="layui-icon">&#xe615;</i> 搜索
        </a>
    </blockquote>
</#if>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-left:0px;">
            <button class="layui-btn" id="selectBtn" type="button">确认选择</button>
        </div>
    </div>
    <fieldset class="layui-elem-field">
        <legend>市场选择列表</legend>
        <div class="layui-field-box">
            <div>
            <table class="site-table table-hover">
                <thead>
                <tr>
                    <th>
                        <#if bo.multiBand>
                            <input type="checkbox" id="selected-all">
                        <#else>
                            选择
                        </#if>
                    </th>
                    <th>ID</th>
                    <th>市场名称</th>
                    <th>上级市场ID</th>
                    <th>上级市场</th>
                </tr>
                </thead>
                <tbody>
                <#list marketList as market>
                <tr>
                    <td>
                        <#if bo.multiBand>
                            <input type="checkbox" name="marketId" data-bandtype="${bo.multiBand}" value="${market.marketId}" data-id="${market.marketId}" data-value="${market.marketName}" />
                        <#else>
                            <input type="radio" name="marketId" data-bandtype="${bo.multiBand}" value="${market.marketId}" data-id="${market.marketId}" data-value="${market.marketName}" title=" " />
                        </#if>
                    </td>
                    <td>${market.marketId}</td>
                    <td>
                        ${market.marketName}
                    </td>
                    <td>${market.parentMarketId}</td>
                    <td>${market.parentMarketName}</td>
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
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>
<script>
    layui.config({
        base: '/sysman/plugins/layui/modules/'
    });

    layui.use(['form'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        $('#search').on('click', function() {
            $("#searchForm").submit();
        });

        form.on('select(market)', function(data){
        });

        $("#selectBtn").click(function(){
            selectMarket();
        });

    });

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
                var flooroption = '<option value>请选择</option>';
                var json_data=eval("("+data+")");
                for(var i = 0;i<json_data.length;i++){
                    flooroption += "<option value='"+json_data[i].marketId+"'>"+json_data[i].marketName+"</option>";
                }
                $("#selectFloor").html(flooroption);
            }
        });
    }

    var bandtype = '${bo.multiBand}';
    function selectMarket(){
        var allSum = $("input[name='marketId']:checked").val();
        if(panIsNull(allSum)){
            alert('请选择一条数据');
            return;
        }
        allSum = $("input[name='marketId']:checked");
        if(!panIsNull(bandtype) && bandtype){
            // 多选
            if (parseInt(allSum.length) == 0) {
                alert('还未选择数据');
                return;
            }
            var ids = eachBox(allSum);
            var array = '';
            $.each(allSum, function(n, item) {
                array += $(item).attr('data-value') + ',';
            });
            array = array.substring(0, array.length - 1);
            var parsentIds =  window.parent.document.getElementById("marketIds").value;
            var parsentNames = window.parent.document.getElementById("marketName").value;
            if(panIsNull(parsentNames)){
                window.parent.document.getElementById("marketIds").value =ids;
                window.parent.document.getElementById("marketName").value=array;
                var index = parent.layer.getFrameIndex(window.name);
                window.parent.layer.close(index);
                return;
            }
            window.parent.document.getElementById("marketIds").value = parsentIds +','+ ids;
            window.parent.document.getElementById("marketName").value=parsentNames + ',' +array;
            var index = parent.layer.getFrameIndex(window.name);
            window.parent.layer.close(index);
            return;
        }
        window.parent.document.getElementById("marketId").value = $(allSum).attr("data-id");
        window.parent.document.getElementById("marketName").value= $(allSum).attr("data-value");
        var index = parent.layer.getFrameIndex(window.name);
        window.parent.layer.close(index);
    }

    var marketId = '${bo.marketId}';
    var floorId = '${bo.floorId}';
    $(document).ready(function(){
        if(!panIsNull(marketId)){
            $("#selectMarket").val(marketId);
        }
    });

</script>

<#if bo.multiBand>
    <script>
        layui.use(['icheck','laypage','layer'], function() {
            var $ = layui.jquery,
                    laypage = layui.laypage,
                    layer = parent.layer === undefined ? layui.layer : parent.layer;
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

        });

    </script>
</#if>
</body>

</html>