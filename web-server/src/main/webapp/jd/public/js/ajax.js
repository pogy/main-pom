$(document).ready(function () {
    cidHidden=$('#cid').val();
    tokenHidden=$('#token').val();
    // 选择空间上传图片
    $("#J_MultimageField1").change(function(){
        var objUrl = getObjectURL(this.files[0]); //二进制显示
        fireUrl=$(this).val();
        if(fireUrl.indexOf("fakepath")){
            var formData = new FormData($( "#spaceImg" )[0]);
            $.ajax({
                url: 'zs.571xz.com/detailImg/upload.json?callback=?' ,
                type: 'POST',
                dataType: 'jsonp',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (returndata) {
                    objUrl=returndata;
                },
                error: function (returndata) {
                    alert(returndata);
                }
            });
        }
        var addHtml = "";
        $(".sui-nav li").eq(0).removeClass("active").siblings().addClass("active");
        $(".tab-content .upload-container").eq(0).hide().siblings().show();
        addHtml += "<li><div class='ii'><img src='"+objUrl+"'></div></li>"
        $("#J_ListTable").prepend(addHtml);

    });
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    //品牌属性动态加载
    $(".J_spu-property").delegate(".kui-combobox-caption,.kui-icon-dropdown","click",function(event){
        $(".kui-oversize").on("scroll",function(){
            viewH =$(this).height();//可见高度
            contentH =$(this).find(".kui-group").height();
            scrollTop =$(this).scrollTop();//滚动高度
            if(contentH - viewH - scrollTop ==0){
                dataVid =$(this).attr('data-vvid');
                vidTemp = dataVid.split(':');  //取得vid
                pid=vidTemp[0];
                $.post("propmore.action", {"cid":cidHidden,"value" : dataVid,'_csrf':tokenHidden},
                    function(data){
                        if(data['status']=='1'){
                            $("#kui-list-6659").append(data['div']);
                            $("#prop_20000_select").append(data['select']);
                            //
                            $('#flag_prop_more_'+pid).attr('data-vvid',data['lastVid']);
                            //return false;
                        }
                    },"json");
            }

        });
    });

    //text区域点击回车提交
    $(":text").bind('keydown',function(event){
        if(event.keyCode == "13")
        {
            checkform();
        }
    });

});


//属于弹出部分，放在js里面则不能用不知为何
var c=0;
var t = "";
function timeCount(){
    if(c>1200){
        clearTimeout(t);
        $('#tip_content').html("<p style='text-align: center'>请求超时</p>");
        $('#tip_content').show();
        $('#tip_default').hide();
        $('.time-con').hide();
        return false;
    }
    c = c+0.01;
    t = setTimeout(function(){
        $("#txt").val(c.toFixed(2));
        timeCount();
    },10);
}

/*
 *简单校验表单数据
 */
function checkform(){

    actionFocus='';
    //sku数量不能为空
    error_msg='';

    $('.mandatory').each(function(){
        var val = $(this).find('input').val();
        if(!val){
            error_msg='存在未填写的必填属性，请补全';
        }
    });

    $(".J_MapQuantity").each(function(){
        skuNum=$(this).val();
        if(!skuNum){
            error_msg='宝贝sku数量不能为空';
            return false;
        }
    });

    //判断sku是否合法 sku价格只能在主价格的上下10%
    price=$('#buynow').val();
    var marketPrice = $('#marketPrice').val();
    if(parseFloat(marketPrice) < parseFloat(price)){
        error_msg = '市场价必须大于京东价'
        actionFocus = 'marketPrice';
    }
    if(price){
        tenPercent=Number(parseFloat(price)*0.1).toFixed(2);
        priceMini=Number(parseFloat(price)-parseFloat(tenPercent)).toFixed(2);
        priceMax =Number(parseFloat(price)+parseFloat(tenPercent)).toFixed(2);
        $(".J_MapPrice").each(function(){
            skuValue=Number(parseFloat($(this).val())).toFixed(2);
            if(parseInt(skuValue)>parseInt(priceMax) || parseInt(skuValue)<parseInt(priceMini)){
                error_msg='价格'+skuValue+'不合法,sku价格只能在主价格的上下10%!'+priceMini+'~'+priceMax;
                actionFocus=$(this).prop('id');
                return false;
            }
        });
    }

    //如果存在材料成分那么加起来必须为100%
    componentPercentNumDefault=0;
    componentPercentNumFlag=0;
    $(".componentPercentNum").each(function(){
        isDisabled=$(this).prop('disabled');if(isDisabled==true){return;}//如果是不需要百分比的则跳过
        componentPercentNumFlag=1;
        componentPercentVal=$(this).val();
        componentPercentNumDefault=Number(parseFloat(componentPercentNumDefault)+parseFloat(componentPercentVal)).toFixed(2);
    });
    if(componentPercentNumFlag==1){
        if(componentPercentNumDefault!=100){
            error_msg='材料成分相加必须百分之百(无需百分比的成分和百分比成分不能混用)';
        }
    }

    //检测主图是否存在
    imgMain=$("#picurl1").val();
    if(!imgMain){
        error_msg='主图不存在;';
    }

    //除属性外的必填项
    $(".notBeEmpty").each(function(){
        val=$(this).val();
        if(!val){
            error=title=$(this).attr('data-error-title');
            error_msg=error+'不能为空;';
            actionFocus = $(this).attr('id');
            return false;
        }
    });

    //货号中不能出现逗号
    prop_goodsid=$("[data-error-title='货号']").val();
    if(prop_goodsid) {
        if (prop_goodsid.indexOf(",") >= 0) {
            error_msg = "货号中不能出现'逗号';";
        }
    }

    //判断你是否是重量或者体积运费模板,如果有则体积或重量必填
    unit=0;
    $(".expressType").each(function(){
        isselected=$(this).prop('selected');
        unitType=$(this).data('unit');
        if(isselected==true){
            unit=unitType;
        }
    });
    if (unit == 1) {  //重量
        isWrite = $('#item_weight').val();
        if(!isWrite){
            error_msg='运费模板出错 使用按重量运费模板但宝贝没有填写重量';
            actionFocus='item_weight';
        }
    } else if (unit == 3) {
        isWrite = $('#item_size').val();
        if(!isWrite){
            error_msg='运费模板出错 使用按体积运费模板但宝贝没有填写体积';
            actionFocus='item_size';
        }
    }

    //判断可用户自定义的值中是否有,有就报错，接口不允许
    // $("[data-type='input']").each(function(){
    //   val=$(this).val();
    //   if(val.indexOf(",")>=0){
    //     error=$(this).attr('data-error-title');
    //     error_msg=error+'不能出现逗号;';
    //     return false;
    //   }
    // });


    if(error_msg!=''){
        alert(error_msg);
        if(actionFocus){
            $('#'+actionFocus).focus();
        }
        return false;
    }else{
        //表单校验成功开始提交
        ready_publish();
    }

}

/*
 *点击发布后触发的，程序主题程序
 */
function ready_publish(){

    midHidden=$('#mid').val();
    domainHidden=$('#domain').val();
    tokenHidden=$('#token').val();
    uid=$('#uid').val();

    //重置图片尝试重试错误次数
    img_main_error=0;
    img_prop_error=0;

    //清空上次表单提交时候生成的各种参数
    $(".skuStr").remove();
    $(".picUrlPathStr").remove();

    //点击发布后先清空已经存在的提示消息
    $('#tip_default').show();
    $('#tip_content').html('');
    $('#tip_content').hide();


    //素有属性生成隐藏域
    propsComponent='';
    $(".sku-props").remove();
    $(".prop_from").each(function(){
        inputType=$(this).attr('type');
        if(inputType=='checkbox'){
            ischecked=$(this).prop('checked');
            if(ischecked==false){
                return;
            }
        }
        dataPid=$(this).attr('data-pid');
        dataValue=$(this).attr('data-value');
        dataType=$(this).attr('data-type');
        dataNum=$(this).attr('data-num');
        value=$(this).val();
        if(!dataPid){
            alert('pid不存在，操作失败');
            return false;
        }

        if(dataType=='input' && value){  //如果是input方式提交的 表单
            if(dataNum){  //有dataNum说明是特殊的 成分材质 属性
                numPrecent=$('#pre'+dataNum).val();
                if(numPrecent>0){
                    value=value+numPrecent+'%';
                    propsComponent=propsComponent+' '+value;
                    return;
                }
            }
            if(value!='其他' && value!='其它' && value!='其她'){ //这三个词不能以input方式提交,除了材质里面的其他
                dataValue=dataPid+':###'+value;   //三个###表示是input方式
            }
        }
        if(!dataValue){
            return;
        }
        // $("#mainform").append("<input type='hidden' name='sku-props-"+dataPid+"[]' class='sku-props' value='"+dataValue+"'>");
        $("#mainform").append("<input type='hidden' name='sku_props[]' class='sku-props' value='"+dataValue+"'>");
    });
    if(propsComponent){
        componentPid=$('#componentPid').val();
        // $("#mainform").append("<input type='hidden' name='sku-props-"+componentPid+"[]' class='sku-props' value='"+'149422948:'+propsComponent+'###'+"'>");
        $("#mainform").append("<input type='hidden' name='sku_props[]' class='sku-props' value='"+'149422948:###'+propsComponent + "'>");
    }


    fbLay = layer.open({
        type: 1,
        title: '发布商品',
        closeBtn: 1,
        shade: 0.5,
        shadeClose: false,
        area: ['550px', ''],
        content: $("#J_publish"),
    });

    //生成所有sku的隐藏域
    var skudata = [];
    $(".J_MapProductid").each(function(){
        data=$(this).data('id');
        var color = data.split('_')[0];
        var size = data.split('_')[1];
        var colorPid = color.split('-')[0]
        var colorVid = color.split('-')[1]
        var sizePid = size.split('-')[0]
        var sizeVid = size.split('-')[1]
        dataDetailTemp=data.split("_");

        colorName = $('.J_Map_'+dataDetailTemp[0]).html();
        sizeName  = $('.J_Map_'+dataDetailTemp[1]).html();
        quantity = $('#J_SkuField_quantity_'+data).val();
        price = $('#J_SkuField_price_'+data).val();
        var tsc=$('#J_SkuField_tsc_'+data).val();
        var colorIsExist = false;
        if(skudata.length){
            $.each(skudata, function(i, item){
                if(item.vid == colorVid){
                    colorIsExist = true;
                    item.sizes.push({
                        pid: sizePid,
                        vid: sizeVid,
                        name: sizeName,
                        num: quantity,
                        price: price,
                        code: tsc
                    })
                    return false;
                }
            });
        }


        if(!colorIsExist){
            skudata.push({
                pid: colorPid,
                vid: colorVid,
                name: colorName,
                sizes:[]
            })
            $.each(skudata, function(i, item){
                if(item.vid == colorVid){
                    item.sizes.push({
                        pid: sizePid,
                        vid: sizeVid,
                        name: sizeName,
                        num: quantity,
                        price: price,
                        code: tsc
                    })
                }
            });
        }
    });
    skudata = JSON.stringify(skudata);
    $("#mainform").append("<input type='hidden' name='skus' class='skuStr' value='"+skudata+"'>");

    // var prop_arr = new Array;
    // $(".prop_from").each(function(){
    //   dataValue=$(this).data('value');
    //   prop_arr.push(dataValue);
    // });
    // $(".prop_checkbox").each(function(){
    //   isSelected = $(this).prop('checked');
    //   if(isSelected==true){
    //     dataValue=$(this).data('value');
    //     prop_arr.push(dataValue);
    //   }
    // });

    //抓取宝贝描述图拼接成数组
    isReportRequest=$('.imgDetailTemp').length;
    if(isReportRequest>0) {
        //第二次提交，内容图片已经被替换则用最新
        imgList=$('#pcContent').val();
    }else{
        //第一次提交，直接抓取编辑器中的内容
        imgList = pcContentObj.getContentDocData();  //获取编辑器的值
        $('#pcContent').html(imgList); //将编辑器中的值付给textare，因为提交的是textare
        $('#pcContent').val(imgList);
    }

    var imgReg = /<img.*?(?:>|\/>)/gi;
    var srcReg = /src=[\'\"]?([^\'\"]*)[\'\"]?/i;
    var arr = imgList.match(imgReg);
    if(arr){
        var imgsList=new Array();
        var errorNum=0;
        for (var i = 0; i < arr.length; i++) {
            iTrue=i-errorNum;
            var src = arr[i].match(srcReg);
            if (src && src[1]) {
                imgsList[iTrue + 1] = src[1];
            }else{
                errorNum++;
            }
        }
        imgAllNum=imgsList.length-1;

        //抓取商品描述图搬家记录并生成数组 搬家=将编辑器中的图片通过ajax替换成自动京东相册中的图片
        var img_detal_arr_temp = new Array();
        $(".imgDetailTemp").each(function(){
            imgOwn=$(this).data('own');
            img_detal_arr_temp.push(imgOwn);
        });
    }else{
        //如果详细图片里一个图片也没有
        img_detal_arr_temp=new Array();
        imgOwn=new Array();
    }


    //抓取宝贝主图拼接成数组
    var img_arr_list_main = new Array();
    var img_arr_id_main=new Array();
    var picUrlI=0;
    $(".picUrl").each(function(){
        picUrlI=picUrlI+1;
        picUrlValue=$(this).val();
        picUrlId=$(this).attr('id');
        if(picUrlValue){
            img_arr_list_main[picUrlI]=picUrlValue;
            img_arr_id_main[picUrlI]=picUrlId;
        }
    });
    img_arr_list_main_count=img_arr_list_main.length-1;


    //抓取宝贝属性图拼接成数组
    var img_arr_list_prop = new Array();
    var img_arr_id_prop=new Array();
    var picUrlI=0;
    $(".prop_img_default").each(function(){
        picUrlI=picUrlI+1;
        picUrlValue=$(this).val();
        picUrlId=$(this).attr('id');
        if(picUrlValue){
            img_arr_list_prop[picUrlI]=picUrlValue;
            img_arr_id_prop[picUrlI]=picUrlId;
        }
    });
    img_arr_list_prop_count=img_arr_list_prop.length-1;

    var is_pic_full=0;//图片空间是否满了，1表示满了，0表示未满
    var is_show_full=0;//是否提示过满了
//将描述图上传到京东并替换链接
    function download_detail(url,order,times) {
        if(!times){times=0;}
        if(is_pic_full==1){
            order=imgAllNum+1;
            if(is_show_full==0){
                is_show_full=1;
                $('#tip_content').html('您的京东图片空间容量不足，请进入京东图片空间进行删除或订购！' +
                    '<br/><br/>前往图片空间：<a href="https://tadget.taobao.com/redaction/manager.htm" target="_blank">https://tadget.taobao.com/redaction/manager.htm</a>');
                $('#tip_content').show();
                $('#tip_default').hide();
            }
            return false;
        }
        if(order>imgAllNum){
            download_main(img_arr_list_main,1);return false;
        }
        if(in_array(url[order],img_detal_arr_temp)){
            download_detail(url,order+1,0);return false;
        }
        $.getJSON("http://zs.571xz.com/detailImg/uploadByUrl.json?callback=?", {"url" : url[order],'order':order,"uid" : uid, "mid" : midHidden,'_csrf':tokenHidden},
            function(data){
                if(data['status']=='1'){
                    $('#imgType').html('开始搬家：描述图');

                    imgtemp=$('#pcContent').val();
                    oldUrl=url[order].replace(new RegExp("[?]","g"),"[?]");  //把原url中的?id=123 替换成 [?]id=123 这样正则才能识别
                    re = new RegExp(oldUrl, "g");
                    imgreplace=imgtemp.replace(re,data['url']);

                    $('#pcContent').html(imgreplace); //兼容Firfox
                    $('#pcContent').val(imgreplace);

                    $("#body").append("<input type='hidden' id='imgDetailTemp"+order+"' class='imgDetailTemp' data-old='"+url[order]+"' data-own='"+data['url']+"'>");

                    $('#imgOrderNum').html(order);
                    $('#imgAllNum').html(imgAllNum);
                    order=order+1;
                }else if(data['msg']=='img018'){
                    is_pic_full=1;
                }else if(data['msg']!='img016'&&data['msg']!='img017'){
                    if(times>=3){
                        //重试3次后放弃
                        imgtemp=$('#pcContent').val();
                        if(url[order]!==undefined)
                        oldUrl=url[order].replace(new RegExp("[?]","g"),"[?]");  //把原url中的?id=123 替换成 [?]id=123 这样正则才能识别
                        re = new RegExp(oldUrl, "g");
                        imgreplace=imgtemp.replace(re,'');

                        $('#pcContent').html(imgreplace); //兼容Firfox
                        $('#pcContent').val(imgreplace);

                        //order=order+1;
                        times=0;
                    }else{
                        console.log('#'+times+'$'+order+'#'+data['msg']+'&');
                        order=order+1;
                        times++;
                    }

                }else{
                    order=order+1;
                }
                download_detail(url,order,times);
            },"json");
    }
    download_detail(imgsList,1,0);


    //将主图片上传到星座网
    function download_main(url,order){
        if(order>img_arr_list_main_count){
            download_prop(img_arr_list_prop,1);return false;
        }
        if(url[order]==undefined || url[order].indexOf("@")==0){   //如果用户没刷新修改参数后点击发布，则绕开上传直接跳过+图片被取消
            download_main(url,order+1);return false;
        }
        $.getJSON("http://zs.571xz.com/detailImg/uploadByUrl.json?callback=?", {"url" : url[order],"order":order,"mid" : midHidden,'witch':'main','_csrf':tokenHidden},
            function(data){
                if(data['status']=='1'){
                    img_main_error=0;
                    $('#'+img_arr_id_main[order]).val(data['url']);
                    $('#imgType').html('开始搬家：商品主图');
                    $('#imgOrderNum').html(order);
                    $('#imgAllNum').html(img_arr_list_main_count);
                    order=order+1;
                }else{
                    img_main_error=img_main_error+1;
                    error_report(img_main_error,'主图');
                }
                download_main(url,order);
            },"json");
    }

    //将属性图上传到星座网

    function download_prop(url,order){
        if(order>img_arr_list_prop_count){
            //显示计时器
            clearTimeout(t);
            $('.time-con').show();
            c=0;
            timeCount();
            //
            $('#tip_content').html('<img src='+domainHidden+'public/images/loading.gif align="absmiddle" />&nbsp;图片搬家完成，正在上传到京东,请勿取消...<br/>过程大概需要1-3分钟。');
            $('#tip_content').show();
            $('#tip_default').hide();
            //alert('搞定');return false;
            //$('#mainform').submit();return false;
            upForm(); return false;
        }
        if(url[order]==undefined || url[order].indexOf("@")==0){   //如果用户没刷新修改参数后点击发布，则绕开上传直接跳过
            download_prop(url,order+1); return false;
        }
        var propurl=url[order];
        var propids='';
        if(propurl.indexOf("##")>=0){
            propids=propurl.substring(0,propurl.indexOf("##"));
            propurl=propurl.substring(propurl.indexOf("##")+2);
        }
        $.getJSON("http://zs.571xz.com/detailImg/uploadByUrl.json?callback=?", {"url" : propurl,"order":order, "mid" : midHidden,'witch':'prop','_csrf':tokenHidden},
            function(data){
                if(data['status']=='1'){
                    img_prop_error=0;
                    //$("#mainform").append("<input type='hidden' name='picUrlPath[]' class='picUrlPathStr' value="+data['data']+">");
                    $('#'+img_arr_id_prop[order]).val(propids+"##"+data['url']);
                    $('#imgType').html('开始搬家：商品属性图');
                    $('#imgOrderNum').html(order);
                    $('#imgAllNum').html(img_arr_list_prop_count);
                    order=order+1;
                }else{
                    img_prop_error=img_prop_error+1;
                    error_report(img_prop_error,'属性图');
                }
                download_prop(url,order);
            },"json");
    }



}

//开始

//提交表单
function upForm(){
    getDetail=$('#getToken').val();
    $.ajax({
        url : "index.action?"+getDetail,
        type : "POST",
        dataType: "html",
        data : $( '#mainform').serialize(),
        success : function(data) {
            $('#tip_content').html(data);
            $('#tip_default').hide();
            $('.time-con').hide();
            is_need_mobile_desc=$('#needMakeMobileDesc').prop('checked');
            if(is_need_mobile_desc==true){
                num_iid = $('#resultTaobaoUrl').data('numiid');
                if (num_iid) {
                    makeMobileDesc(num_iid);
                }
            }
        }
        // error: function(data) {
        //  alert('超时');
        // }
    });
}


/**
 * 点击属性后判断是否有子菜单
 */
function hasSonProp(pid,fid,vid){
    if(fid=='1'){
        $.post("propson.action", {"cid":cidHidden, "value":pid+':'+vid,'_csrf':tokenHidden},
            function(data){
                $('#prop_son_'+pid).html(data);
            },"html");
        $('#prop_son_'+pid).show();
    }else{
        $('#prop_son_'+pid).hide();
    }
}

function makeMobileDesc(num_iid){
    $('#tipsMobile').html('&nbsp;<img src='+domainHidden+'public/images/loadingMobile.gif />');
    var imgList=$('#pcContent').val();
    url=$('#resultTaobaoUrl').prop('href');
    midHidden=$('#mid').val();
    error_break(); //请求超时中断链接
    $.post("make-mobile-desc.action", {"imgList" : imgList,"num_iid" : num_iid,'_csrf':tokenHidden},
        function(data){
            if(data['status']=='1'){
                $('#tipsMobile').html('&nbsp;生成成功');
                if(url) {
                    setTimeout(function(){  window.location.href = url;  },1000);
                }
            }else{
                $('#tipsMobile').html("&nbsp;<a style='color:blue;' href='#' onclick='makeMobileDesc("+num_iid+")'>重新生成</a>");
            }
        },"json");
}

/*
 * 请求超时中断链接,时间:1分半
 */
function error_break(){
    setTimeout(function(){
        tipsMobile=$('#tipsMobile').html();
        if(tipsMobile=='&nbsp;<img src='+domainHidden+'public/images/loadingMobile.gif />'){
            alert('请求超时');
            $('#tipsMobile').html("&nbsp;<a style='color:blue;' href='#' onclick='makeMobileDesc("+num_iid+")'>重新生成</a>");
        }
    },90000);
}
/**
 * 跳过缓存，立刻更新状态并写入缓存
 */
$(document).ready(function () {
    //店铺分类
    uid=$('#uid').val();
    $("#ShopCatUpdate").click(function(){
        $('#J_ShopCatList').html('刷新中...');
        $(this).hide();
        $.post("shop-cat-update.action", {'_csrf':tokenHidden,'uid':uid},
            function(data){
                $('#J_ShopCatList').html(data);
            },"html");
    });
    //运费模板
    $("#deliverUpdate").click(function(){
        $('#J_Logistics').html('刷新中...');
        $.post("express-update.action", {'_csrf':tokenHidden,'uid':uid},
            function(data){
                $('#J_Logistics').html(data);
            },"html");
    });
    //运费橱窗使用情况
    $("#getWindowsUpdate").click(function(){
        $('#simple-inline-WindowsUpdate').html('刷新中...');
        $.post("windowsnum-update.action", {'_csrf':tokenHidden,'uid':uid},
            function(data){
                $('#simple-inline-WindowsUpdate').html(data);
            },"html");
    });
});



//图片上传失败后判断错误次数
function error_report(value,msg){
    if(value>3){
        $('#tip_content').html("<p style='text-align: center'>已失败三次，程序停止</p>");
        $('#tip_content').show();
        $('#tip_default').hide();
        return false;
    }else{
        alert(msg+'上传失败正在重试');
    }
}


//自己定于的工具数组
function in_array(search,array){
    for(var i in array){
        if(array[i]==search){
            return true;
        }
    }
    return false;
}