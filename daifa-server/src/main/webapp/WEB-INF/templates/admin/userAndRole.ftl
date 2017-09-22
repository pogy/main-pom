<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>用户角色 - 星帮后台管理 - 四季星座网</title>

<#include "/common/host_config.ftl">
    <!--
    <link href="http://style.571xz.com/v2/dfgl/css/scanBarCode.css" rel="stylesheet">
    -->
    <link href="${daifa_host}/fonts/demo.css" rel="stylesheet">
    <link href="${daifa_host}/css/table.css" rel="stylesheet">
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script src="${daifa_host}js/admin/sys/userandrole/userAndRole.js"></script>

    <style>
        .div-inline{ display:inline;}
        .divxz{
            color: blue;
            border: 1px solid #ffb6ac;
            background-color: #FBEC88;
        }
        .div-tree{
            float:left;
            display:inline;
            width:45%;
            height: 800px;
            padding-left: 10px;
            margin-left: 10px;
            margin-top: 10px;
            border: 2px solid #95B8E7;
        }
        .button-position{
            margin-left: 10px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="pageHeader yahei">
    <h1 class="fl">代发后台管理</h1>
    <div class="xbUser fr">
        <#if userIcon??>
        <img src="${userIcon!}">
        <#else>
        <img src="http://style.571xz.com/v2/dfgl/css/img/headImg.jpg">
        </#if>
        <span class="fcBlue fs16">${userName!}</span>
        <a href="${daifa_host!}init/logout.htm" class="fcF40 fs16">退出</a>
    </div>
</div>




<div class="mainContent">
    <div class="sideBarBox">
    <#include "/admin/common/menu_admin.ftl">
    </div>
    <div class="contentBox">
        <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue button-position" value="保存" onclick="saveUserAndRole()">
        <input type="hidden" id="userId" name="userId" >
        <div class="scanContainer fs14 yahei" style="margin-left: 10px;">
            <div class="div-tree" >
            <ul class="clearfix">
                <li class="tddiv" ><p>用户树</p></li>
            <#list userTree as listuser>
                <li id="liuserid" class="tddiv" onclick="checkUser(this,'${listuser.daifaWorkerId!}');">
                    <p><i class="icon-user"></i>${listuser.userName!}<!--<i class="iconfont">&#xe65f;</i>--></p>
               </li>
            </#list>
            </ul>

            </div>

            <div class="div-tree" >
                <ul class="clearfix">
                    <li class="tddiv" ><p>角色树</p></li>
                <#list roleTree as listrole>
                    <li class="tddiv" >
                        <input type="checkbox" id="roleId" name="roleId" value="${listrole.roleId!}">
                        <input type="hidden" id="roleTag" name="roleTag" value="${listrole.roleTag!}">
                        ${listrole.roleName!}
                    </li>
                </#list>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--省略end，让浏览器自动添加-->
<script>

</script>



