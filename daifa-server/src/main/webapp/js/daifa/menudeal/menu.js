
/*=================左侧菜单的选中===============*/
$(function(){
var menus=$("#menus").val();
    $("a[id^='daifamenu']").each(function(){

        if($(this).prop("href").indexOf(menus)>0){
            $(this).prop("class","current");
        }
    });
});
