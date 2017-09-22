$(function(){
    //左侧菜单的选中
    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("userAndRole.htm")>0){
            $(this).prop("class","current");
        }
    });

});

//选择具体的用户并查询出选中的角色
function checkUser(obj,userId){
    $("#userId").val(userId);
    //清理用户选中
    $("li[id^='liuserid']").each(function(){
        $(this).removeAttr("class");
    });

    //选中用户
    $(obj).prop("class","tddiv divxz");
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