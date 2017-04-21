<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>广告位置</title>
    <link rel="stylesheet" href="${back_man_host}/sysman/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${back_man_host}/sysman/css/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${back_man_host}/sysman/css/font-awesome.min.css">
    <link rel="stylesheet" href="${back_man_host}/sysman/css/begtable.css" />


    <style>
        .layui-form-item{
            padding: 5px 4px;
            margin-bottom: 0px;
        }
        .layui-elem-quote{
            padding:5px;
        }
        .beg-table-box {
            position: inherit;
            /* height: 100%; */
            width: 100%;
            /* max-width: 100%; */
        }
        .beg-table-body {
            overflow-x: scroll;
            /* width: 2000px; */
            max-height: 100%;
            width: 100%;
        }
        .beg-table {
            /* width: 100%; */
            /* max-width: 100%; */
            height: 100%;
            margin-bottom:0px;
        }
        td,th{white-space: nowrap; }
        td{font-size:13px;}
    </style>
</head>

<body>
<div class="admin-main">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>广告位置</legend>
    </fieldset>
            <div id="xx" style="width:100%; border: 1px solid #DDDDDD;">
                <div style="width: 100%; border: 1px solid #009688;" class="tablediv">
                    <div class="beg-table-box">
                        <div class="beg-table-body">
                            <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                                <thead >
                                <tr>
                                    <th>位置ID</th>
                                    <th>编号</th>
                                    <th>位置区域</th>
                                    <th>渠道</th>
                                    <th>广告类型</th>
                                    <th>状态</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pager.content as location>
                                <tr>
                                    <td>
                                        ${location.localId!}
                                    </td>
                                    <td>
                                        ${location.localCode!}
                                    </td>
                                    <td>${location.localAreaCode!}</td>
                                    <td>
                                        <#if location.underLine>
                                            线下
                                        <#else>
                                            线上
                                        </#if>
                                    </td>
                                    <td>
                                        <#if location.type == 1>普通广告</#if>
                                        <#if location.type == 2>商品类广告</#if>
                                        <#if location.type == 3>店铺类广告</#if>
                                    </td>
                                    <td>
                                        <#if location.disEnabled>
                                            禁用
                                        <#else>
                                            启用
                                        </#if>
                                    </td>
                                    <td>${location.createTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                                    <td>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="changeLocal('${location.localId}');">编辑</a>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="goatList('${location.localId}');">查看广告</a>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="addGoat('${location.localId}');">新增广告</a>
                                    </td>
                                </tr>

                                </#list>

                                </tbody>
                            </table>
                        </div>
                        <div class="beg-table-paged"></div>
                    </div>
                </div>
            </div>

    <hr>



</div>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>

<script>

    function reloads(){
        location.reload();
    }

    layui.config({
        base: '/sysman/js/'
    });

    layui.use(['begtable'], function() {
        var begtable = layui.begtable(),
                layer = layui.layer,
                $ = layui.jquery,
                laypage = layui.laypage;

        var totalPage = '${pager.totalPages!}';
        var currentPage = '${pager.number}';

        laypage({
            cont: $('.beg-table-paged'),
            curr:parseInt(currentPage),
            pages: parseInt(totalPage),
            groups: 10,
            jump: function(obj, first) {
                //得到了当前页，用于向服务端请求对应数据
                var curr = obj.curr;
                if(!first) {
                    //layer.msg('第 '+ obj.curr +' 页');
                    $("#currentPage").val(parseInt(curr));
                    location.href = '${back_man_host}/sysman/goat/locationList.htm?currentPage='+parseInt(curr);
                }else{
                    layer.msg('第 '+ obj.curr +' 页');
                }
            }
        });

        $("#xx").height($(window).height()-200);

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
    });

    // 广告列表
    function goatList(locationId){
        if(panIsNull(locationId)){
            layer.alert('请选择一个广告位置', {icon:2});
            return;
        }
        var goatLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['1000px' , '450px'],
            content: getRealPath() + '/sysman/goat/itemList.htm?localId='+locationId
        });
    }

    // 广告新增
    function addGoat(locationId){
        if(panIsNull(locationId)){
            layer.alert('请选择一个广告位置', {icon:2});
            return;
        }
        var goatLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '70px',
            area: ['1000px' , '450px'],
            content: getRealPath() + '/sysman/goat/addItemView.htm?locationId='+locationId
        });
    }

    // 广告编辑
    function changeLocal(locationId){
        if(panIsNull(locationId)){
            layer.alert('请选择一个广告位置', {icon:2});
            return;
        }
        var changeLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '70px',
            area: ['600px' , '350px'],
            content: getRealPath() + '/sysman/goat/changeLocationView.htm?goatLocationId='+locationId
        });
    }

</script>
</body>

</html>