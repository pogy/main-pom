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
            roleName: $('.orderSearchBox [name=roleName]').val(),
            roleTag: $('.orderSearchBox [name=roleTag]').val(),
            createUserId: $('.orderSearchBox [name=createUserId]').val(),
            status: $('.orderSearchBox [name=status]').val()
        });
    });
});
/*=================左侧菜单的选中===============*/
$(function(){

    $("a[id^='niemenu']").each(function(){
        if($(this).prop("href").indexOf("roleListByPage.htm")>0){
            $(this).prop("class","current");
        }
    });
});
//===================具体操作==================//
//添加
function addRole(){
    var dstatus="<select id='status' name='status'>";
        dstatus+= "<option value='0'>不可用</option><option value='1'>可用</option>";
        dstatus+="</select>";
    $$.window.open($rtpl(function(){/*

        <div style="display:inline"><label class="ptitle">角色名：</label><input id="roleName" name="roleName" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">角色标签：</label><input id="roleTag" name="roleTag" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">代发机构：</label><input id="createUserId" name="createUserId" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">角色备注：</label><input id="roleComment" name="roleComment" type="text"  class="fmInput" /></div>
        <div >
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subdd();" value="确定">
        </div>
    */}
        ,{
            dstatus:dstatus
        }),{title:"角色添加"});
}
//添加的提交
function subdd(){

    var roleName=$("#roleName").val();
    var roleTag=$("#roleTag").val();
    var createUserId=$("#createUserId").val();
    var status=$("#status").val();
    var roleComment=$("#roleComment").val();

    $.post(daifa_host+"admin/roleAdd.json",
        {"roleName":roleName,"createUserId":createUserId,"status":status,"roleComment":roleComment,"roleTag":roleTag},
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
function editRole(obj,roleId){
    var roleName= $(obj).parent().prev().prev().prev().prev().prev().prev().children().html();//.val();
    var roleTag= $(obj).parent().prev().prev().prev().prev().prev().children().html();
    var createUserId= $(obj).parent().prev().prev().prev().prev().children().html();
    var status= $(obj).parent().prev().prev().prev().children().html();
    var roleComment= $(obj).parent().prev().prev().children().html();
     var dstatus="<select id='status' name='status'>";
         if(status=="可用"){
             dstatus+="<option value='0'>不可用</option><option value='1' selected>可用</option>";
         }else{
             dstatus+= "<option value='0' selected>不可用</option><option value='1' >可用</option>";
         }

    dstatus+="</select>";

    //alert(roleName);
    $$.window.open($rtpl(function(){/*

        <input id="roleId" name="roleId" type="hidden" value="{{roleId}}"/>
        <div style="display:inline"><label class="ptitle">角色名：</label><input id="roleName" name="roleName" type="text" value="{{roleName}}" class="fmInput" /></div>
        <div><label class="ptitle">角色标签：</label><input id="roleTag" name="roleTag" type="text" value="{{roleTag}}" class="fmInput" /></div>
        <div><label class="ptitle">代发机构：</label><input id="createUserId" name="createUserId" type="text" value="{{createUserId}}" class="fmInput" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">角色备注：</label><input id="roleComment" name="roleComment" type="text" value="{{roleComment}}" class="fmInput" /></div>
        <div >
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subupdate();" value="确定">
        </div>
    */}
    ,{
            roleId:roleId,roleName:roleName,roleTag:roleTag,createUserId:createUserId,dstatus:dstatus,roleComment:roleComment
        }),{title:"角色修改"});
       // return false;

}
//修改后的提交
function subupdate(){
   var roleId=$("#roleId").val();
   var roleName=$("#roleName").val();
    var roleTag=$("#roleTag").val();
   var createUserId=$("#createUserId").val();
   var status=$("#status").val();
   var roleComment=$("#roleComment").val();

    $.post(daifa_host+"admin/roleEdit.json",
        {"roleId":roleId,"roleName":roleName,"createUserId":createUserId,"status":status,"roleComment":roleComment,"roleTag":roleTag},
        function(data){
        if(data.result=="success"){
            $$.alert("修改完成");
            location.reload();
        }else{
            $$.alert("修改失败,"+data.msg);
        }
    })
}

