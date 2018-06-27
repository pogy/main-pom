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

    //text区域点击回车提交
    $(":text").bind('keydown',function(event){
        if(event.keyCode == "13")
        {
            checkform();
        }
    });

    //设置模板
    $('#setUserGoodsModule').click(function(){
        var delivery = $(this).parents('.pddKeyInfo').find('select[name=delivery]').val();
        var returns = $(this).parents('.pddKeyInfo').find('select[name=returns]').val();
        var artificial = $(this).parents('.pddKeyInfo').find('select[name=artificial]').val();
        var moduleData = {
            delivery: delivery,
            returns: returns,
            artificial: artificial
        }
        $.post('updatereturnsTemplate.json', moduleData, function(resp){
            if(resp.result == 'success'){
                alert('设置成功!');
            }else{
                alert(resp.msg);
            }
        })
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

    var title = $('#TitleID').val();
    var sellPoint = $('#SubheadingID').val();
    if(!title || !sellPoint){
        error_msg='宝贝标题和商品描述不能为空';
    }

    var smallTitle = $('#smallTitleID').val();
    var charBt = smallTitle.replace(/[^\x00-\xff]/g, '**').length;
    if(smallTitle && (charBt < 4 || charBt > 20)){
        error_msg='短标题限制4-20字符';
    }

    var goodsWeight = $('#goodsWeight').val();
    if(!goodsWeight){
        error_msg='宝贝重量不能为空';
    }

    $(".J_MapQuantity").each(function(){
        skuNum=$(this).val();
        if(!skuNum){
            error_msg='宝贝sku数量不能为空';
            return false;
        }
    });

    //判断sku是否合法 sku价格只能在主价格的上下10%
    price=$('#pPrice').val();
    var marketPrice = $('#marketPrice').val();
    if(parseFloat(marketPrice) < (parseFloat(price)*2)){
        error_msg = '市场价必须大于原始单买价！'
        actionFocus = 'marketPrice';
    }
    // if(price){
    //     tenPercent=Number(parseFloat(price)*0.1).toFixed(2);
    //     priceMini=Number(parseFloat(price)-parseFloat(tenPercent)).toFixed(2);
    //     priceMax =Number(parseFloat(price)+parseFloat(tenPercent)).toFixed(2);
    //     $(".J_MapPrice").each(function(){
    //         skuValue=Number(parseFloat($(this).val())).toFixed(2);
    //         if(parseInt(skuValue)>parseInt(priceMax) || parseInt(skuValue)<parseInt(priceMini)){
    //             error_msg='价格'+skuValue+'不合法,sku价格只能在主价格的上下10%!'+priceMini+'~'+priceMax;
    //             actionFocus=$(this).prop('id');
    //             return false;
    //         }
    //     });
    // }

    var allQuantity = $('#quantityId').val();
    if(!allQuantity){
        error_msg='宝贝总数不能为空';
    }

    //检测主图是否存在
    imgMain=$("#picurl1").val();
    if(!imgMain){
        error_msg='主图不存在;';
    }

    var postage_id = $('#J_Logistics').find('#J_deliverTemplate').val();
    if(!postage_id){
        error_msg='请选择运费模板';
    }


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

    //重置图片尝试重试错误次数
    img_main_error=0;
    img_prop_error=0;

    //清空上次表单提交时候生成的各种参数
    $(".skuStr").remove();
    $(".sku-props").remove();
    $('.thumbUrl').remove();
    $('.hdThumbUrl').remove();

    //点击发布后先清空已经存在的提示消息
    $('#tip_default').show();
    $('#tip_content').html('');
    $('#tip_content').hide();


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
    var colorSizeSku = [];

    //所有选中的颜色
    $('#sku-color-wrap li').each(function(){
        if($(this).hasClass('edit')){
            colorSizeSku.push({
                propName: $(this).find('.editbox').val(),
                type: 1,
                pddCid: $('#cid').val()
            });
        }
    });

    //所有选中的尺码
    $('.sku-size li').each(function(){
        if($(this).hasClass('edit')){
            colorSizeSku.push({
                propName: $(this).find('.editbox').val(),
                type: 0,
                pddCid: $('#cid').val()
            });
        }
    });

    $(".J_MapProductid").each(function(){
        data=$(this).data('id');
        var color = data.split('_')[0];
        var size = data.split('_')[1];
        dataDetailTemp=data.split("_");

        colorName = $('.J_MapColor_'+dataDetailTemp[0]).html();
        sizeName  = $('.J_MapSize_'+dataDetailTemp[1]).html();
        quantity = $('#J_SkuField_quantity_'+data).val();
        price = $('#J_SkuField_price_'+data).val();
        gprice = $('#J_SkuField_gprice_'+data).val();
        var tsc=$('#J_SkuField_tsc_'+data).val();
        var colorIsExist = false;
        if(skudata.length){
            $.each(skudata, function(i, item){
                if(item.vid == color){
                    colorIsExist = true;
                    item.sizes.push({
                        vid: size,
                        name: sizeName,
                        num: quantity,
                        price: price,
                        gprice: gprice,
                        code: tsc
                    })
                    return false;
                }
            });
        }


        if(!colorIsExist){
            skudata.push({
                vid: color,
                name: colorName,
                sizes:[]
            })
            $.each(skudata, function(i, item){
                if(item.vid == color){
                    item.sizes.push({
                        vid: size,
                        name: sizeName,
                        num: quantity,
                        price: price,
                        gprice: gprice,
                        code: tsc
                    })
                }
            });
        }
    });

    var colorSizeLength = colorSizeSku.length;

    $.each(colorSizeSku, function(i, item){
        $.post('addProp.json', item, function(resp){
            var propName = item.propName;
            var type = item.type;
            if(resp.result == 'success'){
                $.each(skudata, function(i, sku){
                    if(type == 1 && propName == sku.name){
                        sku.vid = resp.specId;
                    }
                    if(type == 0){
                        $.each(sku.sizes, function(i, size){
                            if(propName == size.name){
                                size.vid = resp.specId;
                            }
                        });
                    }
                })
                colorSizeLength = colorSizeLength - 1;
            }

            // if(colorSizeLength == 0){
            //     skudata = JSON.stringify(skudata);
            //     $("#mainform").append("<input type='hidden' name='skus' class='skuStr' value='"+skudata+"'>");
            // }
        })
    });


    //抓取宝贝描述图拼接成数组
    var arr = [];
    var imgsList;
    $('.long-img li .picUrl').each(function () {
        arr.push($(this).val());
    });

    if(arr.length > 0){
        imgsList=new Array();
        var errorNum=0;
        for (var i = 0; i < arr.length; i++) {
            iTrue=i-errorNum;
            var src = arr[i];
            if (src) {
                imgsList[iTrue + 1] = src;
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
    var ossMainImgs = [];
    var img_arr_id_main=new Array();
    var picUrlI=0;
    $(".zhu-img .picUrl").each(function(){
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
    var ossPropImgs = [];
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

    var ossDetailImgs = [];
//将描述图上传到星座网并替换链接
    function download_detail(url,order,times) {
        if(!times){times=0;}

        if(order>imgAllNum){
            upDetailImg(ossDetailImgs,0);return false;
        }
        if(in_array(url[order],img_detal_arr_temp)){
            download_detail(url,order+1,0);return false;
        }
        $.getJSON("http://imgbj.571xz.net/down-img-other.json?callback=?", {"url" : url[order],'order':order, "mid" : midHidden, witch:'desc'},
            function(data){
                if(data['status']=='1'){
                    $('#imgType').html('开始搬家：描述图');

                    $('#descPicUrl'+ (order - 1)).val(data['url']);
                    ossDetailImgs.push(data['url']);
                    $('#imgOrderNum').html(order);
                    $('#imgAllNum').html(imgAllNum);
                    order=order+1;
                }else if(data['msg']=='img018'){
                    is_pic_full=1;
                }else if(data['msg']!='img016'&&data['msg']!='img017'){
                    if(times>=3){
                        //重试3次后放弃
                        $('#descPicUrl'+ (order - 1)).val('');
                        $('#descPicUrl'+ (order - 1)).parent('li').find('img').attr('src', '')

                        order=order+1;
                        times=0;
                    }else{
                        console.log('#'+times+'$'+order+'#'+data['msg']+'&');
                        times++;
                    }

                }else{
                    order=order+1;
                }
                download_detail(url,order,times);
            },"json");
    }
    download_detail(imgsList,1,0);

    //将描述图传给gtx
    function upDetailImg(url,order){
        console.info(url)
        if(order>(imgAllNum - 1)){
            download_main(img_arr_list_main,1);return false;
        }

        if(order == 0){
            $('.long-img ul.image-list li').remove();
        }

        $.post('uploadImg.json', {imgUrl:url[order], tempCode:$('#tempCode').val(), type:4}, function(resp){
            if(resp.result == 'success'){
                if(resp.pddImgInfo.num <= 20){
                    var addDescHtml = '';
                    $.each(resp.pddImgInfo.pddImgUrls, function(i, img){
                        addDescHtml += '<li data-index="' + (resp.pddImgInfo.num - i) + '" class="has-media">' +
                                '<input type="hidden" class="picUrl" name="descPicUrl[]" id="descPicUrl' + (resp.pddImgInfo.num - i) + '" value="'+ img +'">' +
                                '<div class="operate">' +
                                    '<i class="icon iconfont icon-sortleft toleft" title="左移">&lsaquo;</i>' +
                                    '<i class="icon iconfont icon-sortright toright" title="右移">&rsaquo;</i>' +
                                    '<i class="icon iconfont icon-remove del" title="删除">x</i>' +
                                '</div>' +
                                '<div class="preview ">' +
                                    '<a title="上传图片 " href="javascript:; " class="upload-tip" style="display: none;">' +
                                        '<i class="icon iconfont icon-tianjia">+</i>' +
                                    '</a>' +
                                    '<div class="img">' +
                                        '<a href="'+ img +'" target="_blank"> <img src="'+ img +'"></a>' +
                                    '</div>' +
                                '</div>' +
                            '</li>';
                    });
                    $('.long-img ul.image-list .addDimg').before(addDescHtml);
                    $('.descImgTip').html('当前商品共有 '+resp.pddImgInfo.num+' 张图片');

                    if(resp.pddImgInfo.num == 20){
                        $('.long-img .image-list .addDimg').hide();
                        download_main(img_arr_list_main,1);return;
                    }
                }
            }
            order = order + 1;
            upDetailImg(url,order);
        });
    }

    //将主图片上传到星座网
    function download_main(url,order){
        if(order>img_arr_list_main_count){
            upMainImg(ossMainImgs,0);return false;
        }
        if(url[order]==undefined || url[order].indexOf("@")==0){   //如果用户没刷新修改参数后点击发布，则绕开上传直接跳过+图片被取消
            download_main(url,order+1);return false;
        }
        $.getJSON("http://imgbj.571xz.net/down-img-other.json?callback=?", {"url" : url[order],"order":order,"mid" : midHidden,'witch':'main'},
            function(data){
                if(data['status']=='1'){
                    img_main_error=0;
                    $('#'+img_arr_id_main[order]).val(data['url']);
                    ossMainImgs.push(data['url']);
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

    //将主图上传给gtx
    function upMainImg(url, order){
        if(order>(img_arr_list_main_count - 1)){
            upHdImg(url);return false;
        }

        $.post('uploadImg.json', {imgUrl:url[order], tempCode:$('#tempCode').val(), type:3}, function(resp){
            if(resp.result = 'success'){
                $('#'+img_arr_id_main[order+1]).val(resp.pddImgInfo.pddImgUrls[0]);
            }
            order = order + 1;
            upMainImg(url,order);
        });
    }

    //将高清缩略图
    function upHdImg(url){
        $.post('uploadImg.json', {imgUrl:url[0], tempCode:$('#tempCode').val(), type:1}, function(resp){
            if(resp.result = 'success'){
                $('#mainform').append("<input type='hidden' name='hdThumbUrl' class='hdThumbUrl' value='"+resp.pddImgInfo.pddImgUrls[0]+"'>")
            }
            upThumbImg(url);
        });
    }

    //普通缩略图
    function upThumbImg(url) {
        $.post('uploadImg.json', {imgUrl:url[0], tempCode:$('#tempCode').val(), type:2}, function(resp){
            if(resp.result = 'success'){
                $('#mainform').append("<input type='hidden' name='thumbUrl' class='thumbUrl' value='"+resp.pddImgInfo.pddImgUrls[0]+"'>")
            }
            upMainImg(url);
        });
    }

    //主图
    function upMainImg(url) {
        $.post('uploadImg.json', {imgUrl:url[0], tempCode:$('#tempCode').val(), type:5}, function(resp){
            if(resp.result = 'success'){
                $('#mainform').append("<input type='hidden' name='mainImg' class='mainImg' value='"+resp.pddImgInfo.pddImgUrls[0]+"'>")
                mainUrl
            download_prop(img_arr_list_prop,1);
        });
    }

    //将属性图上传到星座网

    function download_prop(url,order){
        if(order>img_arr_list_prop_count){
            //显示计时器
            upPropImg(ossPropImgs, 0);return false;
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
        $.getJSON("http://imgbj.571xz.net/down-img-other.json?callback=?", {"url" : propurl,"order":order, "mid" : midHidden,'witch':'prop'},
            function(data){
                if(data['status']=='1'){
                    img_prop_error=0;
                    ossPropImgs.push(data['url']);
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

    //将属性图上传给gtx
    function upPropImg(url, order) {
        if(order>(img_arr_list_prop_count-1)){
            //显示计时器
            skudata = JSON.stringify(skudata);
            $("#mainform").append("<input type='hidden' name='skus' class='skuStr' value='"+skudata+"'>");
            clearTimeout(t);
            $('.time-con').show();
            c=0;
            timeCount();
            $('#tip_content').html('<img src=public/images/loading.gif align="absmiddle" />&nbsp;图片搬家完成，正在上传到拼多多,请勿取消...<br/>过程大概需要1-3分钟。');
            $('#tip_content').show();
            $('#tip_default').hide();
            upForm(); return false;
        }

        $.post('uploadImg.json', {imgUrl:url[order], tempCode:$('#tempCode').val(), type:0}, function(resp){
            if(resp.result = 'success'){
                $.each(skudata, function(i, sku){
                    if(i == order){
                        sku.imgSrc = resp.pddImgInfo.pddImgUrls[0];
                    }
                })
            }
            order = order + 1;
            upPropImg(url,order);
        });
    }



}

//开始

//提交表单
function upForm(){
    getDetail=$('#getToken').val();
    $.ajax({
        url : "index.json?"+getDetail,
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
        if(tipsMobile=='&nbsp;<img src=public/images/loadingMobile.gif />'){
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
    initDeliverModule();

    $(document).on('click', '#deliverUpdate', function(){
        $('#J_Logistics').html('刷新中...');
        initDeliverModule()
    });

    function initDeliverModule() {
        $.post("selPostTemplate.json", {'_csrf':tokenHidden,'uid':uid},
        function(data){
            if(data.result == 'error') {
                alert(data.msg+',请再次更新模板!');
            }else{
                $('#J_Logistics').html(data);
            }
        });
    }

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

//提交利润模板
function setProfitTemplate(lrauto, fbTemp, lrPrice1, qzauto) {
    var actived = lrauto? 1 : 0;
    var type = fbTemp;
    var profit = lrPrice1;
    var rounding = qzauto? 1 : 0;
    var profitData = {
        actived: actived,
        type: type,
        profit: profit,
        rounding: rounding
    };

    $.post('updateProfitTemplate.json', profitData, function (resp) {
        if(resp.result == 'success'){
            alert('设置利润模板成功');
        }else{
            alert(resp.msg);
        }
    })


}