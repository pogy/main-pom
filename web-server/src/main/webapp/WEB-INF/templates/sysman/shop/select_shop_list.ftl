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

        <form class="layui-form" action="${back_man_host}/sysman/shop/selectList.htm" id="searchForm" method="post">
            <input type="hidden" name="currentPage" id="currentPage" value="${bo.currentPage}"/>
            <input type="hidden" name="website" value="${bo.website}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">市场</label>
                <div class="layui-input-inline">
                    <select name="marketId" id="selectMarket" lay-filter="market" onclick="floorajaxlist();">
                        <option value="">请选择市场</option>
                        <#list shiguMarketList as market>
                            <option value="${market.marketId}">${market.marketName}</option>
                        </#list>
                    </select>
                </div>
                <label class="layui-form-label">楼层</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <select name="floorId" id="selectFloor">
                        <option value="">请选择楼层</option>
                    </select>
                </div>
                <label class="layui-form-label">店铺ID</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="tel" name="shopId" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.shopId!}">
                </div>
            </div>
        </form>


    <blockquote class="layui-elem-quote">
        <a href="javascript:;" class="layui-btn layui-btn-small" id="search">
            <i class="layui-icon">&#xe615;</i> 搜索
        </a>
    </blockquote>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-left:0px;">
            <button class="layui-btn" id="selectBtn" type="button">确认选择</button>
        </div>
    </div>
    <fieldset class="layui-elem-field">
        <legend>店铺列表</legend>
        <div class="layui-field-box">
            <div>
            <table class="site-table table-hover">
                <thead>
                <tr>
                    <th>选择</th>
                    <th>店铺ID</th>
                    <th>店铺</th>
                    <th>市场</th>
                    <th>顶级市场</th>
                    <th>档口号</th>
                </tr>
                </thead>
                <tbody>
                <#list pager.content as shop>
                <tr>
                    <td>
                        <input type="radio" name="shopId" value="${shop.shopId}" data-shopnum = "${shop.shopNum}"/>
                    </td>
                    <td>${shop.shopId}</td>
                    <td>${shop.shopName}</td>
                    <td>${shop.marketName}</td>
                    <td>${shop.parentMarketName}</td>
                    <td>${shop.shopNum}</td>
                </tr>

                </#list>

                </tbody>
            </table>
            </div>
        </div>
    </fieldset>

</div>
<div class="admin-table-page">
    <div id="page" class="page">
    </div>
</div>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>

<script>
    function search(){
        $("#searchForm").submit();
    }

    layui.config({
        base: '/sysman/plugins/layui/modules/'
    });

    layui.use(['laypage','layer'], function() {
        var $ = layui.jquery,
                laypage = layui.laypage,
                layer = parent.layer === undefined ? layui.layer : parent.layer;

        var totalPage = '${pager.totalPages!}';
        var currentPage = '${pager.number}';
        //page
        laypage({
            cont: 'page',
            curr:parseInt(currentPage),
            pages: parseInt(totalPage),
            groups: 10,
            jump: function(obj, first) {
                //得到了当前页，用于向服务端请求对应数据
                var curr = obj.curr;
                if(!first) {
                    //layer.msg('第 '+ obj.curr +' 页');
                    $("#currentPage").val(parseInt(curr));
                    $("#searchForm").submit();
                }else{
                    layer.msg('第 '+ obj.curr +' 页');
                }
            }
        });

        $('#search').on('click', function() {
            $("#searchForm").submit();
        });

    });

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        form.on('select(market)', function(data){
            floorajaxlist();
            form.render('select'); //刷新selec
        });

        $("#selectBtn").click(function(){
            selectShop();
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
                var flooroption = '';
                var json_data=eval("("+data+")");
                for(var i = 0;i<json_data.length;i++){
                    flooroption += "<option value='"+json_data[i].marketId+"'>"+json_data[i].marketName+"</option>";
                }
                $("#selectFloor").html(flooroption);
            }
        });
    }

    function selectShop(){
        var allSum = $("input[name='shopId']:checked").val();
        if(panIsNull(allSum)){
            alert('请选择一条数据');
            return;
        }
        allSum = $("input[name='shopId']:checked");

        // 多选
        if (parseInt(allSum.length) == 0) {
            alert('还未选择数据');
            return;
        }
        var ids = eachBox(allSum);
        var array = '';
        $.each(allSum, function(n, item) {
            array += $(item).attr('data-shopnum') + ',';
        });
        array = array.substring(0, array.length - 1);
        window.parent.document.getElementById("shopId").value = ids;
        window.parent.document.getElementById("shopNum").value=array;
        var index = parent.layer.getFrameIndex(window.name);
        window.parent.layer.close(index);
        return;
    }

    var marketId = '${bo.marketId}';
    var floorId = '${bo.floorId}';
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