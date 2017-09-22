<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>用户角色 - 星帮后台管理 - 四季星座网</title>

<#include "/common/host_config.ftl">

    <link href="http://style.571xz.com/v2/dfgl/css/scanBarCode.css" rel="stylesheet">

    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <!--
    <script src="http://style.571xz.com/v2/dfgl/js/userAndRole.js"></script>
    -->
    <style>
        .div-inline{ display:inline}
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
        <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="保存" onclick="saveUserAndRole()">
        <input type="text" id="userId" name="userId" >
        <div class="scanContainer fs14 yahei">
            <div style="float:left;display:inline;width:45%;" >
            <ul class="clearfix">
            <#list userTree as listuser>
                <li class="tddiv" onclick="checkUser('${listuser.daifaWorkerId!}');"><p>${listuser.userName!}</p></li>
            </#list>
            </ul>

            </div>

            <div style="float:left;display:inline;width:45%;" >
                <ul class="clearfix">
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
    $(function(){
        //左侧菜单的选中

    });
    //选择具体的用户并查询出选中的角色
    function checkUser(userId){
        $("#userId").val(userId);
        //========================清理选中start==========
        $("input[name^='roleId']").each(function(){

            if($(this).prop("checked"))
            {
                $(this).removeAttr("checked");
            }
        });
        //========================清理选中end==============
        //查询这个用户下的角色
        $.post(daifa_host+"admin/jsonUserAndRole.json",
                {"userId":userId},
                function(data){


                    var lists=data.list;
                    for(var i=0; i<lists.length;i++){
                       var roleidse=lists[i].roleId;
                        $("input[name^='roleId']").each(function(){
                            if(this.value==roleidse){
                                $(this).prop("checked",true);
                            }
                        });
                    }
                    /*if(data.result=="success"){
                        alert("修改完成");
                    }else{
                        alert("修改失败,"+data.msg);
                    }*/
                });

    }
    //保存用户角色
    function saveUserAndRole(){
       var userId= $("#userId").val();
       var roleIds=[];
       //取得选中的roleId
        //========================清理选中start==========
        $("input[name^='roleId']").each(function(){

            if($(this).prop("checked"))
            {
                //$(this).removeAttr("checked");
                //roleId.
                roleIds.push(this.value);

            }
        });
        //========================清理选中end==============

        roleIds.join(',');//以'，'分隔
        //alert("userId="+userId+"@@@roleId="+roleIds);
        $.post(daifa_host+"admin/jsonupdateUserAndRoles.json",
                {"userId":userId,roleIds:roleIds},
                function(data){

                    if(data.result=="success"){
                        alert(data.msg);
                    }else{
                        alert(data.msg);
                    }

                });
    }
</script>



