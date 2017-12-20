/*=================左侧菜单的选中===============*/
$(function(){
    //左侧菜单的选中
    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("sendTest.htm")>0){
            $(this).prop("class","current");
        }
    });

});


//保存用户角色
function testex(){

    var level= $("#level").val();


    $.post(daifa_host+"admin/testException.json",
        {"level":level},//以'，'分隔
        function(data){
            if(data.result=="success"){
                alert(data.msg);
                location.reload();
            }else{
                alert(data.msg);
            }
        });
}