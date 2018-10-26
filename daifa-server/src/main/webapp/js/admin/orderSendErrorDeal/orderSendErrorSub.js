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
            dfTradeId: $('.orderSearchBox [name=dfTradeId]').val()

        });
    });
});
/*=================左侧菜单的选中===============*/

//===================具体操作==================//
//修改
function editProp(obj,dfOrderId){


    var propStr= $(obj).parent().prev().prev().prev().prev().prev().children().val();
    var goodsCode= $(obj).parent().prev().prev().prev().prev().children().val();
    var storeGoodsCode= $(obj).parent().prev().prev().prev().children().val();
    //alert("receiverName="+receiverName+" @@@receiverAddr="+receiverAddr);
    $$.post('dealSubOrderErrorJson.json', function(resp){
        if(resp.err){
            $$.windowOperate.errorTip(resp.err);
        }else{
            $$.alert('设置成功', function(){
                location.reload();
            });
        }
    },{dfOrderId: dfOrderId, propStr:propStr,goodsCode:goodsCode,storeGoodsCode:storeGoodsCode});
}




