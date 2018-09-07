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
            userName: $('.orderSearchBox [name=userName]').val(),
            daifaWorker: $('.orderSearchBox [name=daifaWorker]').val(),
            phone: $('.orderSearchBox [name=phone]').val(),
            daifaSellerId: $('.orderSearchBox [name=daifaSellerId]').val(),
            useStatus: $('.orderSearchBox [name=useStatus]').val(),
            workType: $('.orderSearchBox [name=workType]').val()
        });
    });
});
/*=================左侧菜单的选中===============*/
//===================具体操作==================//
//添加
function addWorker(){

    var dstatus="<select id='useStatus' name='useStatus' class='fmInput' style='width: 137px'>";
        dstatus+= "<option value='1'>可用</option><option value='0'>不可用</option>";
        dstatus+="</select>";

    var workType="<select id='workType' name='workType' class='fmInput' style='width: 137px'>";
    workType+= "<option value='5'>拿货人员</option><option value='4'>分配人员</option><option value='9'>售后</option><option value='13'>客服</option><option value='20'>财务</option>";
    workType+="</select>";

    $$.window.open($rtpl(function(){/*

        <div style="display:inline"><label class="ptitle">用户名：</label><input id="userName" name="userName" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">登录名：</label><input id="daifaWorker" name="daifaWorker" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">密码：</label><input id="password" name="password" type="text"  class="fmInput"  /></div>
        <div><label class="ptitle">代发机构：</label><input id="daifaSellerId" name="daifaSellerId" type="text"  class="fmInput" value="999999990" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">手机号：</label><input id="phone" name="phone" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">用户类型：</label>{{#workType}}</div>
        <div><label class="ptitle">支付宝账户：</label><input id="payBaoAccount" name="payBaoAccount" type="text"  class="fmInput" /></div>

        <div style="margin-top: 20px;margin-left: 50px;">
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subdd();" value="确定">
        </div>
    */}
        ,{
            dstatus:dstatus,workType:workType
        }),{title:"用户添加",width:450});
}
//添加的提交
function subdd(){

    var userName=$("#userName").val();
    var daifaWorker=$("#daifaWorker").val();
    var password=$("#password").val();
    var daifaSellerId=$("#daifaSellerId").val();
    var useStatus=$("#useStatus").val();
    var phone=$("#phone").val();
    var workType=$("#workType").val();
    var payBaoAccount=$("#payBaoAccount").val();
    var roleId=workType;
    $.post(daifa_host+"admin/daifaWorkerAdd.json",
        {"userName":userName,"daifaWorker":daifaWorker,"password":password,"daifaSellerId":daifaSellerId,"useStatus":useStatus,
            "phone":phone,"workType":workType,"payBaoAccount":payBaoAccount,"roleId":roleId},
        function(data){
            if(data.result=="success"){
                $$.alert("添加完成");
                location.reload();
            }else{
                $$.alert("添加失败,"+data.msg);
            }
        })
}

//修改
function editWorker(obj,daifaWorkerId,password){
    var userName= $(obj).parent().prev().prev().prev().prev().prev().prev().prev().prev().children().html();//.val();
    var daifaWorker= $(obj).parent().prev().prev().prev().prev().prev().prev().prev().children().html();
    var daifaSellerId= $(obj).parent().prev().prev().prev().prev().prev().prev().children().html();
   var phone= $(obj).parent().prev().prev().prev().prev().prev().children().html();
    var payBaoAccount= $(obj).parent().prev().prev().children().html();

    var status= $(obj).parent().prev().prev().prev().children().html();

     var dstatus="<select id='useStatus' name='useStatus'>";
         if(status=="可用"){
             dstatus+="<option value='0'>不可用</option><option value='1' selected>可用</option>";
         }else{
             dstatus+= "<option value='0' selected>不可用</option><option value='1' >可用</option>";
         }
    dstatus+="</select>";

    var workType= $(obj).parent().prev().prev().prev().prev().children().html();
    var dworkType="<input id='workType' name='workType' type='text'  class='fmInput' value='"+workType+"' readonly />";

    var remark2= $(obj).parent().prev().children().html();
    var dremark2="<input id='remark2' name='remark2' type='text'  class='fmInput' value='"+remark2+"' readonly />";

    $$.window.open($rtpl(function(){/*

        <input id="daifaWorkerId" name="daifaWorkerId" type="hidden" value="{{daifaWorkerId}}"/>
        <div style="display:inline"><label class="ptitle">用户名：</label><input id="userName" name="userName" type="text" value="{{userName}}" class="fmInput" /></div>
        <div><label class="ptitle">登录名：</label><input id="daifaWorker" name="daifaWorker" type="text" value="{{daifaWorker}}" class="fmInput" /></div>
         <div><label class="ptitle">密码：</label><input id="password" name="password" type="text" value="{{password}}" class="fmInput"  /></div>
        <div><label class="ptitle">代发机构：</label><input id="daifaSellerId" name="daifaSellerId" type="text"  class="fmInput" value="{{daifaSellerId}}" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">手机号：</label><input id="phone" name="phone" type="text" value="{{phone}}" class="fmInput" /></div>
        <div><label class="ptitle">用户类型：</label>{{#dworkType}}</div>
        <div><label class="ptitle">支付宝账户：</label><input id="payBaoAccount" name="payBaoAccount" type="text" value="{{payBaoAccount}}" class="fmInput" /></div>
        <div><label class="ptitle">用户角色：</label>{{#dremark2}}</div>
        <div style="margin-top: 20px;margin-left: 50px;">
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subupdate();" value="确定">
        </div>
    */}
    ,{
            daifaWorkerId:daifaWorkerId,userName:userName,daifaWorker:daifaWorker,password:password,daifaSellerId:daifaSellerId,dstatus:dstatus,phone:phone,dworkType:dworkType,
            payBaoAccount:payBaoAccount,dremark2:dremark2
        }),{title:"用户修改",width:450});
       // return false;

}
//修改后的提交
function subupdate(){
   var daifaWorkerId=$("#daifaWorkerId").val();
   var userName=$("#userName").val();
    var daifaWorker=$("#daifaWorker").val();
   var password=$("#password").val();
   var daifaSellerId=$("#daifaSellerId").val();
   var useStatus=$("#useStatus").val();

    var phone=$("#phone").val();
    var workType=$("#workType").val();
    var payBaoAccount=$("#payBaoAccount").val();
    $.post(daifa_host+"admin/daifaWorkerEdit.json",
        {"daifaWorkerId":daifaWorkerId,"userName":userName,"daifaWorker":daifaWorker,"password":password,"daifaSellerId":daifaSellerId,"useStatus":useStatus,
            "phone":phone,"workType":workType,"payBaoAccount":payBaoAccount,"roleId":workType},
        function(data){
        if(data.result=="success"){
            $$.alert("修改完成");
            location.reload();
        }else{
            $$.alert("修改失败,"+data.msg);
        }
    })
}

