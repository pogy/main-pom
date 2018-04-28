/*=================左侧菜单的选中===============*/
$(function(){
    //左侧菜单的选中
    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("roleAndPermission.htm")>0){
            $(this).prop("class","current");
        }
    });
});

//选择具体的用户并查询出选中的角色
function checkRole(obj,roleId){
    $("#roleId").val(roleId);
    //清理用户选中
    $("li[id^='liuserid']").each(function(){
        $(this).removeAttr("class");
    });

    //选中用户
    $(obj).prop("class","tddiv divxz");
    //========================清理选中start==========
    $("input[name^='permissionId']").each(function(){

        if($(this).prop("checked"))
        {
            $(this).removeAttr("checked");
        }
    });
    //========================清理选中end==============
    //查询这个用户下的角色
    $.post(daifa_host+"admin/jsonRoleAndPermission.json",
        {"roleId":roleId},
        function(data){
            var lists=data.list;
            for(var i=0; i<lists.length;i++){
                var permissionIdse=lists[i].permissionId;
                $("input[name^='permissionId']").each(function(){
                    if(this.value==permissionIdse){
                        $(this).prop("checked",true);
                    }
                });
            }

        });
}
//保存用户角色
function saveRoleAndPermission(){
    var roleId= $("#roleId").val();
    var permissionId=[];
    //取得选中的roleId
    //========================清理选中start==========
    $("input[name^='permissionId']").each(function(){

        if($(this).prop("checked"))
        {
            permissionId.push(this.value);
        }
    });
    //========================清理选中end==============
    $.post(daifa_host+"admin/jsonupdateRoleAndPermissions.json",
        {"roleId":roleId,permissionIds:permissionId.join(',')},//以'，'分隔
        function(data){
            if(data.result=="success"){
                alert(data.msg);
                location.reload();
            }else{
                alert(data.msg);
            }
        });
}