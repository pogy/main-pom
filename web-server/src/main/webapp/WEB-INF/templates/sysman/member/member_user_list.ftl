<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>会员列表</title>
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
            margin-bottom: 0px;
        }
        td,th{white-space: nowrap; }
        td{font-size:13px;}
    </style>
</head>

<body>
<div class="admin-main">

    <form class="layui-form" action="${back_man_host}/sysman/memberUser/list.htm" id="searchForm" method="post">
        <input type="hidden" name="currentPage" id="currentPage" value="${bo.currentPage}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="tel" name="userName" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.userName!}">
            </div>
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="tel" name="userNick" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.userNick!}">
            </div>
            <label class="layui-form-label">登录手机号</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="tel" name="loginPhone" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.loginPhone!}">
            </div>
            <label class="layui-form-label">子账号</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="tel" name="subUserName" lay-verify="phone" autocomplete="off" class="layui-input" value="${bo.subUserName!}">
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
                            <th>用户ID</th>
                            <th>用户名</th>
                            <th>用户昵称</th>
                            <#--<th>登陆邮箱</th>-->
                            <th>登陆手机号</th>
                            <th>子账号</th>
                            <th>联系方式</th>
                            <th>登录次数</th>
                            <th>最后登录</th>
                            <th>注册时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list pager.content as member>
                            <tr>
                                <td>${member.userId}</td>
                                <td>${member.userName}</td>
                                <td>${member.userNick}</td>
                                <#--<td>${member.loginEmail}</td>-->
                                <td>${member.loginPhone}</td>
                                <td>${member.subUserNameGroups!}</td>
                                <td>
                                    <if member.imQq??>QQ:${member.imQq}&nbsp;</if>
                                    <if member.imAliww??>旺旺:${member.imAliww}&nbsp;</if>
                                    <if member.imWeixin??>微信:${member.imWeixin}&nbsp;</if>
                                </td>
                                <td>${member.logins}</td>
                                <td>
                                    ${member.lastIp}&nbsp;&nbsp;
                                    <#if member.lastTime??>${member.lastTime?string("yyyy-MM-dd hh:mm:ss")}</#if>
                                </td>
                                <td>
                                    <#if member.regTime ??>
                                        ${member.regTime?string("yyyy-MM-dd hh:mm:ss")}
                                    </#if>
                                </td>
                                <td>
                                    <a href="javascript:void(0);" class="layui-btn layui-btn-mini" onclick="sublist('${member.userId}');">子账号</a>
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
                    $("#currentPage").val(parseInt(curr));
                    $("#searchForm").submit();
                }else{
                    layer.msg('第 '+ obj.curr +' 页');
                }
            }
        });
        $("#xx").height($(window).height()-310);


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

    });

    // 子账户
    function sublist(userId){
        if(panIsNull(userId)){
            alert('请选择一个用户')
            return;
        }
        var userLayer = layer.open({
            type: 2,
            title:false,
            shadeClose: false,
            shade: [0.3, '#000'],
            maxmin: true, //开启最大化最小化按钮
            //offset: '100px',
            area: ['900px' , '400px'],
            content: getRealPath() + '/sysman/memberUser/subList.htm?userId='+ userId
        });
    }

</script>
</body>

</html>