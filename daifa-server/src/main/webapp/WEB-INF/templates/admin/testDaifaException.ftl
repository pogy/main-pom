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

    <script src="${daifa_host}js/admin/sys/testException/testException.js"></script>

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
            width:100%;
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
                <li class="tddiv" ><p>测试异常</p></li>
                <li id="liuserid" class="tddiv" >

                    <p>

                        <select id='level' name='level' class='fmInput' style='width: 137px'>
                            <option value='debug'>debug</option>
                            <option value='warn'>warn</option>
                            <option value='info'>info</option>
                            <option value='error'>error</option>
                            <option value='fatal'>fatal</option>
                            <option value='default'>default</option>
                            <option value='orther'>其他</option>
                        </select>
                    </p>
                </li>

                <li id="liuserid" class="tddiv" >

                    <p><input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="testex();" value="确定"></p>
                </li>


            </ul>

            </div>


        </div>
    </div>
</div>
<!--省略end，让浏览器自动添加-->
<script>

</script>



