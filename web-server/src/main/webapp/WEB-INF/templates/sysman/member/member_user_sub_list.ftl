<#include "/sysman/common/host_config.ftl">

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>子账号列表</title>
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
    <fieldset class="layui-elem-field">
        <legend>子账户列表</legend>
        <div class="layui-field-box">
            <div>
                <table class="site-table table-hover">
                    <thead>
                    <tr>
                        <th>子账号ID</th>
                        <th>用户ID</th>
                        <th>用户名</th>
                        <th>账户类型</th>
                        <th>登录次数</th>
                        <th>用户状态</th>
                        <th>创建时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pager.content as sub>
                    <tr>
                        <td>${sub.subUserId}</td>
                        <td>${sub.userId}</td>
                        <td>
                            ${sub.subUserName}
                        </td>
                        <td>
                            <#if sub.accountType == 3>淘宝</#if>
                            <#if sub.accountType == 7>主账号</#if>
                            <#if sub.accountType == 4>QQ</#if>
                            <#if sub.accountType == 5>微信</#if>
                            <#if sub.accountType == 6>阿里</#if>
                        </td>
                        <td>${sub.logins}</td>
                        <td>
                            <#if sub.useStatus == 1>正常</#if>
                            <#if sub.useStatus == 2>停用</#if>
                            <#if sub.useStatus == 3>解绑</#if>
                        </td>
                        <td>
                            <#if sub.createTime ??>
                                ${sub.createTime?string("yyyy-MM-dd hh:mm:ss")}
                            </#if>
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
    });
</script>
</body>

</html>