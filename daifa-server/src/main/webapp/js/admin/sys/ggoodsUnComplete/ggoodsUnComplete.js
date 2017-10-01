/*====== dfgl/orderAll#orderCon.js:0 ======*/
$(function(){
    $$.pagination(function(page){
        $$.search({page: page});
    })
});
/*====== dfgl/orderAll#orderSearch.js:1 ======*/
$(function(){
    $(document).on('click', '[jbtn=searchBtn]', function(){
        $$.search({
            page: 1

        });
    });
});
/*=================左侧菜单的选中===============*/
$(function(){

    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("permissionListByPage.htm")>0){
            $(this).prop("class","current");
        }
    });
});
//===================具体操作==================//
//修改后的提交
function ggoodsUnComplete(sellerId,createDate){
    $.post(daifa_host+"admin/ggoodsUnComplete.json",
        {"sellerId":sellerId,"createDate":createDate},
        function(data){
        if(data.result=="success"){
            $$.alert("修改完成");
            location.reload();
        }else{
            $$.alert("修改失败,"+data.msg);
        }
    })
}

