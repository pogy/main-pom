<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Table</title>
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
        <form class="layui-form" action="${back_man_host}/sysman/shop/list.htm" id="searchForm" method="post">
            <input type="hidden" name="currentPage" id="currentPage" value="${bo.currentPage}"/>
            <input type="hidden" name="website" value="${bo.website}" id="webSite"/>
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
                <div class="layui-input-inline">
                    <select name="floorId" id="selectFloor">
                        <option value="">请选择楼层</option>
                    </select>
                </div>
                <label class="layui-form-label">档口号</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="tel" name="shopNum" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.shopNum!}">
                </div>
                <label class="layui-form-label">店铺ID</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="tel" name="shopId" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.shopId!}">
                </div>
                <label class="layui-form-label">店铺淘宝昵称</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="tel" name="tbNick" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.tbNick!}">
                </div>
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline" style="width: 100px;">
                    <input type="tel" name="userName" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.userName!}">
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
                                    <#--<th><input type="checkbox" id="selected-all"></th>-->
                                    <th>店铺ID</th>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <#--<th>用户昵称</th>-->
                                    <th>店铺淘宝昵称</th>
                                    <th>店铺名称</th>
                                    <th>市场</th>
                                    <th>楼层/二级市场</th>
                                    <th>档口号</th>
                                <#--<th>会员</th>-->
                                <#--<th>匹配规则</th>-->
                                <#--<th>设置合作伙伴</th>-->
                                <#--<th>开启自动抓取</th>-->
                                    <th>二级域名</th>
                                    <th>队列状态</th>
                                <#--<th>店铺模式</th>-->
                                    <th>授权状态</th>
                                    <th>店铺状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pager.content as shop>
                                <tr>
                                    <#--<td><input type="checkbox"></td>-->
                                    <td>
                                        <a href="${back_man_host}/shop.htm?id=${shop.shopId}" target="_blank">${shop.shopId}</a>
                                    </td>
                                    <td>
                                        ${shop.userId}
                                    </td>
                                    <td>${shop.userName}</td>
                                    <#--<td>${shop.userNick}</td>-->
                                    <td>${shop.tbNick}</td>
                                    <td>${shop.shopName}</td>
                                    <td>${shop.parentMarketName}</td>
                                    <td>${shop.marketName}</td>
                                    <td>${shop.shopNum}</td>
                                <#--<td>${}</td>-->
                                    <td>${shop.domain}</td>
                                    <td>
                                        <#if shop.tmcStatus ??>
                                            <#if shop.tmcStatus == true>
                                                在队列&nbsp;&nbsp;
                                                <#if shop.valid>
                                                    有效
                                                <#else>
                                                    无效
                                                </#if><br/>
                                                首次：${shop.tmcFirstTime?string("yyyy-MM-dd hh:mm:ss")}<br/>
                                                最后：${shop.tmcLastTime?string("yyyy-MM-dd hh:mm:ss")}<br/>
                                            </#if>
                                            <#if shop.tmcStatus == false>无效</#if>
                                        <#else>
                                            不在队列
                                        </#if>
                                    </td>
                                    <td>
                                        <#if shop.shopAuthState == 0>未授权</#if>
                                        <#if shop.shopAuthState == 1>已授权</#if>
                                        <#if shop.shopAuthState == 2>授权过期</#if>
                                    </td>
                                    <td>
                                        <#if shop.shopStatus == 0>开店</#if>
                                        <#if shop.shopStatus == 1>关店</#if>
                                    </td>
                                    <td >
                                        <#if shop.shopStatus == 0>
                                            <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="closeShop('${shop.shopId!}');">关店</a>
                                        </#if>
                                        <#if shop.shopStatus == 1>
                                            <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="openShop('${shop.shopId!}');">开店</a>
                                        </#if>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="changeOutShop('${shop.shopId}');">编辑</a>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="qyShop('${shop.shopId!}');">档口迁移</a>
                                        <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="synShop('${shop.shopId!}');">全店抓取</a>
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
        //alert();
        $("#xx").height($(window).height()-310);
//        var columns = [];
//        begtable.set({
//            bordered: true,
//            hovered: true,
//            striped: true,
//            elem: '#xx',
//            checked: true,
//            //paged:false
//        }).init();


        $('#search').on('click', function() {
            $("#searchForm").submit();
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

    // 开店
    function openShop(shopId){
        if(panIsNull(shopId)){
            return;
        }
        layer.open({
            type: 2,
            title:'开店',
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['600px' , '300px'],
            content: getRealPath() + '/sysman/shop/openView.htm?shopId='+shopId
        });
    }

    // 关店
    function closeShop(shopId){
        if(panIsNull(shopId)){
            return;
        }
        layer.open({
            type: 2,
            title:'关店',
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['600px' , '300px'],
            content: getRealPath() + '/sysman/shop/closeView.htm?shopId='+shopId
        });
    }

    // 全店抓取
    function synShop(shopId){
        if(panIsNull(shopId)){
            return;
        }
        var datajson = {"shopId":shopId};
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/shop/shopGrab.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('全店抓取成功', {icon:1});
                    return;
                }
                layer.alert(data.msg, {icon:2});
            }
        });
    }

    // 编辑
    function changeOutShop(shopId){
        if(panIsNull(shopId)){
            layer.alert('请选择一个店铺', {icon:2});
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
            content: getRealPath() + '/sysman/shop/changeShopView.htm?shopId='+shopId+'&webSite='+$("#webSite").val()
        });
    }

    // 档口迁移
    function qyShop(shopId){
        if(panIsNull(shopId)){
            layer.alert('请选择一个店铺', {icon:2});
            return;
        }
        var shopLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            offset: '100px',
            area: ['800px' , '400px'],
            content: getRealPath() + '/sysman/shop/qyShopView.htm?shopId='+shopId+'&webSite='+$("#webSite").val()
        });
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