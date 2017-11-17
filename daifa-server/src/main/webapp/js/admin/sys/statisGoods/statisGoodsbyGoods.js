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
            page: 1,
            takeGoodsStatus: $('.orderSearchBox [name=takeGoodsStatus]').val(),
            startTime: $('.orderSearchBox [name=startTime]').val(),
            endTime: $('.orderSearchBox [name=endTime]').val()
        });
    });
});
/*=================左侧菜单的选中===============*/
$(function(){

    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("statisGoodsbyGoods.htm")>0){
            $(this).prop("class","current");
        }
    });
});


