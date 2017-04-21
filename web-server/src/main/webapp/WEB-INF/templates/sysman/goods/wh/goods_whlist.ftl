<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>修改商品权重</title>
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
        <form class="layui-form" action="${back_man_host}/sysman/goods/wh_list.htm" id="searchForm" method="post">
            <input type="hidden" name="currentPage" id="currentPage" value="${bo.currentPage}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">商品ID</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="number" name="goodsId" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.goodsId!}">
                </div>
            </div>
        </form>

        <blockquote class="layui-elem-quote">
            <a href="javascript:;" class="layui-btn layui-btn-small" id="search">
                <i class="layui-icon">&#xe615;</i> 搜索
            </a>
        </blockquote>

        <div id="xx" style="width:100%; border: 1px solid #DDDDDD;">
            <div style="width: 100%; border: 1px solid #009688;" class="tablediv">
                <div class="beg-table-box">
                    <div class="beg-table-body">
                        <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                            <thead >
                            <tr>
                                <th>
                                    商品ID
                                </th>
                                <th>店铺ID</th>
                                <th>主图</th>
                                <th>标题</th>
                                <th>权重</th>
                                <th>上架时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list pager.content as goods>
                                <tr>
                                    <td>
                                        <a href="${back_man_host}/item.htm?id=${goods.goodsId}" target="_blank">${goods.goodsId}</a>
                                    </td>
                                    <td>
                                        <a href="${back_man_host}/shop.htm?id=${goods.storeId}" target="_blank">
                                            ${goods.storeId}
                                        </a>
                                    </td>
                                    <td>
                                        <img src="${goods.picUrl}" style="width:70px;"/>
                                    </td>
                                    <td>${goods.title}</td>
                                    <td>${goods.sortOrder/1000}</td>
                                    <td>${goods.created?string("yyyy-MM-dd hh:mm:ss")}</td>
                                    <td>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="changeWh('${goods.goodsId!}');">编辑权重</a>
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
    function search(){
        $("#searchForm").submit();
    }

    layui.config({
        base: '/sysman/js/'
    });

    layui.use(['begtable'], function() {
        var begtable = layui.begtable(),
                layer = layui.layer,
                $ = layui.jquery,
                laypage = layui.laypage;
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green'
        });

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
                    $("#searchForm").submit();
                }else{
                    layer.msg('第 '+ obj.curr +' 页');
                }
            }
        });

        $("#xx").height($(window).height()-310);

        $('#search').on('click', function() {
            $("#currentPage").val(1);
            $("#searchForm").submit();
        });

    });

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;
    });

    // 编辑
    function changeWh(goodsId){
        if(panIsNull(goodsId)){
            layer.alert('请选择一个商品', {icon:2});
            return;
        }
        var shopLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['700px' , '350px'],
            content: getRealPath() + '/sysman/goods/changeWhView.htm?goodsId='+goodsId
        });
    }
</script>
</body>

</html>