<!DOCTYPE html>
<html lang="zh-CN">
<#include "/common/host_config.ftl">
<head>


    <style>
        .btn{
            border: 0px solid;
            border-radius:25px;
        }

    </style>
    <script src="http://style.571xz.com/v2/global/js/jquery.js"></script>
    <script>
        function adminRefund(){
            var tid=$("#adminRefund_dfTradeId").val();
            var oids=$("#adminRefund_dfOrderId").val();
            var refundId=$("#adminRefund_refundId").val();
            if(!tid){
                alert("请输入主单号");
                return;
            }
            if(!oids){
                alert("请输入子单号");
                return;
            }
            if(!refundId){
                alert("请输入售后ID");
                return;
            }
            $.post(daifa_host+"admin/adminRefund.json",{"tid":tid,"oids":oids,"refundId":refundId},function(data){
                if(data.result=="success"){
                    alert("退款完成");
                }else{
                    alert("退款失败,"+data.msg);
                }
            })
        }
    </script>

</head>
<body>
<table>
    <tr>
        <td>
            主单id:<input id="adminRefund_dfTradeId"/>
        </td>
        <td>
            子单id(多个用","分割):<input id="adminRefund_dfOrderId"/>
        </td>
        <td>
            refundId:<input id="adminRefund_refundId"/>
        </td>
        <td>
            <input class="btn" type="button" onclick="" value="退款"/>
        </td>
    </tr>
</table>


</body>
</html>