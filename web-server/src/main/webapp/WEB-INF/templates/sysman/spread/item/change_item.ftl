<#include "common/host_config.ftl">

<!DOCTYPE html>

<html>

<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <title>编辑广告</title>
    <link rel="stylesheet" href="${back_man_host}/sysman/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="${back_man_host}/sysman/css/font-awesome.min.css" />

    <style>
        .layui-input-block{
            margin-left:87px;
        }
        .buttonClass{margin-top:-25px;}
        .uploadify{left:87px;margin-top: 30px;}
    </style>
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>编辑广告</legend>
    </fieldset>
    <form class="layui-form" action="" id="submitForm">
        <input type="hidden" name="localId" value="${locationId}" />
        <input type="hidden" name="goatId" value="${goatItem.goatId}" />

        <#list fieldList as field>
            <input type="hidden" name="${field.fieldName}_vid" value="${field.vId}"/>
            <#if field.fieldType == 1>
                <div class="layui-form-item">
                    <label class="layui-form-label">${field.title}</label>
                    <div class="layui-input-block">
                        <input style="width:200px;" type="text" name="${field.fieldName}" value="${field.values}" autocomplete="off" placeholder="请输入${field.title}" class="layui-input" />
                    </div>
                </div>
            </#if>
            <#if field.fieldType == 2>
                <div class="layui-form-item">
                    <label class="layui-form-label">${field.title}</label>
                    <div class="layui-input-block">
                        <#if field.values??>
                            <img src="${field.values}" class="lltPicImg_${field.fieldName}" style="width:250px;"/><br/>
                            <input type="hidden" name="${field.fieldName}" class="mainPicUrl_${field.fieldName}" value="${field.values}"/><br/>
                            <input class="layui-upload-file" type="file" name="uploadFile_${field.fieldName}" id="file_upload_${field.fieldName}" fieldname="${field.fieldName}" style="height:100px;"/>
                        <#else>
                            <img src="${back_man_host }/sysman/images/no_pic.png" alt="暂无缩略图" class="lltPicImg_${field.fieldName}" style="width:250px;"/><br/>
                            <input type="hidden" name="${field.fieldName}" class="mainPicUrl_${field.fieldName}"/><br/>
                            <input class="layui-upload-file" type="file" name="uploadFile_${field.fieldName}" id="file_upload_${field.fieldName}" fieldname="${field.fieldName}" style="height:100px;"/>
                        </#if>
                    </div>
                </div>
            </#if>
        </#list>

        <div class="layui-form-item">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="${goatItem.startTime?string("yyyy-MM-dd hh:mm:ss")}" style="width:200px;" type="text"  name="startTimeStr" autocomplete="off" class="layui-input" />
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="${goatItem.endTime?string("yyyy-MM-dd hh:mm:ss")}" style="width:200px;" type="text"  name="endTimeStr" autocomplete="off" class="layui-input" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否禁用</label>
            <div class="layui-input-inline">
                <select name="disEnabled">
                    <option value="true" <#if goatItem.disEnabled == true>selected="selected"</#if> >禁用</option>
                    <option value="false" <#if goatItem.disEnabled == false>selected="selected"</#if>>启用</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">排序</label>
            <div class="layui-input-block">
                <input  style="width:200px;" type="number" name="sort" autocomplete="off" class="layui-input" value="${goatItem.sort}"/>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="changeItem()">编辑提交</button>
            </div>
        </div>
    </form>


</div>
<script type="text/javascript" src="${back_man_host}/sysman/plugins/layui/layui.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${back_man_host}/sysman/js/custom_common.js"></script>
<script>
    layui.use(['upload','form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        $("input[type=file]").each(function(n,item){
            var ids = $(item).attr("fieldname");
            layui.upload({
                url: '${back_man_host}/sysman/spread/aliyun_upload.htm?domId='+ids
                ,elem: '#file_upload_'+ids
                ,success: function(res, input){
                    if(res.status=='success'){
                        $(".lltPicImg_"+res.data.domId).attr("src",res.data.phPath);
                        $(".mainPicUrl_"+res.data.domId).val(res.data.phPath);
                        return;
                    }
                }
            });
        });

    });

    // 新增广告
    function changeItem(){
        var datajson = $("#submitForm").serialize();
        var index = parent.layer.getFrameIndex(window.name);
        var loadi = layer.load();
        $.ajax({
            type : "POST",
            url : getRealPath() + '/sysman/goat/changeItem.json',
            data : datajson,
            dataType : "json",
            async : true,
            success : function(data) {
                layer.close(loadi);
                if(data.status == 'success'){
                    layer.alert('编辑广告成功',function(){
                        window.parent.reloads();
                        window.parent.layer.close(index);
                    });
                    return;
                }
                layer.alert(data.msg);
            }
        });
    }



</script>
</body>

</html>