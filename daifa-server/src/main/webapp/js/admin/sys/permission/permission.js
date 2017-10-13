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
            namespace: $('.orderSearchBox [name=namespace]').val(),
            permissionTag: $('.orderSearchBox [name=permissionTag]').val(),
            createUserId: $('.orderSearchBox [name=createUserId]').val(),
            status: $('.orderSearchBox [name=status]').val()
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
//添加
function addRecord(){
    var dstatus="<select id='status' name='status'>";
        dstatus+= "<option value='0'>不可用</option><option value='1'>可用</option>";
        dstatus+="</select>";
    $$.window.open($rtpl(function(){/*

        <div style="display:inline"><label class="ptitle">namespace：</label><input id="namespace" name="namespace" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">父权限ID：</label><input id="parentPid" name="parentPid" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">权限标签：</label><input id="permissionTag" name="permissionTag" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">代发机构：</label><input id="createUserId" name="createUserId" type="text"  class="fmInput" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">权限备注：</label><input id="permissionComment" name="permissionComment" type="text"  class="fmInput" /></div>
        <div >
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subdd();" value="确定">
        </div>
    */}
        ,{
            dstatus:dstatus
        }),{title:"权限添加"});
}
//添加的提交
function subdd(){

    var namespace=$("#namespace").val();
    var parentPid=$("#parentPid").val();
    var createUserId=$("#createUserId").val();
    var permissionTag=$("#permissionTag").val();
    var status=$("#status").val();
    var permissionComment=$("#permissionComment").val();

    $.post(daifa_host+"admin/tsysPermissionAdd.json",
        {"namespace":namespace,"parentPid":parentPid,"createUserId":createUserId,"permissionTag":permissionTag,"status":status,"permissionComment":permissionComment},
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
function editRecord(obj,permissionId){
    var namespace= $(obj).parent().prev().prev().prev().prev().prev().prev().prev().children().html();//.val();
    var permissionTag= $(obj).parent().prev().prev().prev().prev().prev().prev().children().html();//权限标签
    var parentPid= $(obj).parent().prev().prev().children().html();//父权限ID
    var createUserId= $(obj).parent().prev().prev().prev().prev().prev().children().html();//代发机构ID
    var status= $(obj).parent().prev().prev().prev().prev().children().html();
    var permissionComment= $(obj).parent().prev().prev().prev().children().html();//权限备注
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
        <div style="display:inline"><label class="ptitle">namespace：</label><input id="namespace" name="namespace" type="text" value="{{namespace}}" class="fmInput" /></div>
        <div><label class="ptitle">父权限ID：</label><input id="parentPid" name="parentPid" type="text" value="{{parentPid}}"  class="fmInput" /></div>
        <div><label class="ptitle">权限标签：</label><input id="permissionTag" name="permissionTag" type="text" value="{{permissionTag}}" class="fmInput" /></div>
        <div><label class="ptitle">代发机构：</label><input id="createUserId" name="createUserId" type="text" value="{{createUserId}}" class="fmInput" /></div>
        <div><label class="ptitle">状态：</label>{{#dstatus}}</div>
        <div><label class="ptitle">权限备注：</label><input id="permissionComment" name="permissionComment" type="text" value="{{permissionComment}}" class="fmInput" /></div>
        <div >
            <input type="button" id="chanel1" name="chanel1" class="fmButton fmButton-blue" value="取消" jbtn="jqWindow.close">
            <input type="button" id="subc" name="subc" class="fmButton fmButton-blue" onclick="subupdate();" value="确定">
        </div>
    */}
    ,{
            permissionId:permissionId,namespace:namespace,permissionTag:permissionTag,parentPid:parentPid,createUserId:createUserId,dstatus:dstatus,permissionComment:permissionComment
        }),{title:"权限修改"});
       // return false;

}
//修改后的提交
function subupdate(){
   var permissionId=$("#permissionId").val();
   var namespace=$("#namespace").val();
    var permissionTag=$("#permissionTag").val();
   var createUserId=$("#createUserId").val();
   var parentPid=$("#parentPid").val();
   var status=$("#status").val();
   var permissionComment=$("#permissionComment").val();

    $.post(daifa_host+"admin/tsysPermissionEdit.json",
        {"permissionId":permissionId,"namespace":namespace,"permissionTag":permissionTag,"createUserId":createUserId,parentPid:parentPid,"status":status,"permissionComment":permissionComment},
        function(data){
        if(data.result=="success"){
            $$.alert("修改完成");
            location.reload();
        }else{
            $$.alert("修改失败,"+data.msg);
        }
    })
}

