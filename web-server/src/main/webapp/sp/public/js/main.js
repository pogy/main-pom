
$(function(){
    var objLay = "";  //0:宝贝图片 1：手机端描述插入图片 2：颜色选择图片
    var objModule = ""; //0:音频  1：摘要 2：图片 3：文字
    // 其他
    $("#findOther").click(function(){
        $(this).siblings(".ul-select").find("input").val("other/其他");
    });
    $(".kui-dropdown-trigger input").focus(function(){
        $(this).siblings(".kui-placeholder").hide();
    }).blur(function(){
        var value = $(this).val();
        //alert(value);
        if(value==""){
            $(this).siblings(".kui-placeholder").show();
        }
    });
    // 宝贝属性下拉	 
    var oldList = "";
    $(".J_spu-property").delegate(".kui-combobox-caption,.kui-icon-dropdown","click",function(event){
        $(".kui-listbox").hide();
        var nowList = "";
        var downHtml = "";
        var lastVid = '';
        var pid = ''
        var $select = $(this).parents(".kui-combobox").siblings("select").find("option");
        $select.each(function(i,e){
            var optionVal = $(e).text();
            var dataVal = $(e).attr("value");
            nonum = $(e).attr("data-nonum")
            pid = $(e).attr("data-pid");
            fid = $(e).attr("data-fid");
            vid = $(e).attr("data-vid");
            lastVid = dataVal;   //在div使用类似option的方式写入id，为只用ajax后部after数据提供条件
            fid=$(this).data('fid');
            nowList += "<div data-nonum='"+nonum+"' data-fid='"+fid+"' data-pid='"+pid+"' data-vid='"+vid+"' id='prop_option_"+dataVal+"' class='has_son_prop kui-option' role='menuitem' data-value='"+dataVal+"'  title='"+optionVal+"'>"+optionVal+"</div>"; //onclick='propSon("+fid+")'
        });
        downHtml += "<div role='menu' class='kui-list kui-listbox'>";
        downHtml += "<div class='kui-header' role='region'>" ;
        downHtml += "<input type='text' name='kuiSearch' class='kui-dropdown-search' autocomplete='off'>";
        downHtml += "</div>";
        downHtml += "<div class='kui-body kui-oversize' style='width: 190px;' id='flag_prop_more_"+pid+"' data-vvid='"+lastVid+"'>";//写入最后的那个pid:vid, ajax拿这个去接口请求数据
        downHtml += "<div class='kui-list kui-group' id='kui-list-6659'>";
        //downHtml += "<div class='kui-option' role='menuitem'  title=''></div>";  //默认下拉列表第一个空
        downHtml += "" + nowList + "";
        downHtml += "</div>";
        downHtml += "</div>";
        downHtml += "</div>";
        var hasList = $(this).parents(".kui-combobox").find(".kui-listbox");
        var isread =  $(this).attr("readonly");
        //判断下拉内容是否存在
        if(hasList.length==0){
            $(this).parents(".kui-combobox").append(downHtml);
        }else{
            hasList.show();
        }
        if(isread){
            $(this).parents(".kui-combobox").find("input[name=kui-search]").focus();
        }
        event.stopPropagation();

        oldList = $(this).parents(".kui-combobox").find(".kui-group").html();
        $("body").delegate(".kui-option","click",function(event){
            var curVal = $(this).text();
            var dataPid = $(this).attr("data-pid");
            var dataFid = $(this).attr("data-fid");
            var dataVid = $(this).attr("data-vid");
            var dataNonum = $(this).attr("data-nonum");
            hasSonProp(dataPid,dataFid,dataVid);  //如果有子属性则显示			
            var dataCheck = $(this).attr("data-value");
            var $curCaption = $(this).parents(".kui-listbox").siblings(".kui-dropdown-trigger").find(".kui-combobox-caption");
            var $czcfInput = $(this).parents(".kui-listbox").siblings(".czcf-con").find(".content-input");
            $curCaption.attr("value",curVal);
            $curCaption.attr("data-value",dataCheck);
            //点击div模拟的下拉列表后，先将所有selectd情况，然后将选中的selectd选中  xuk添加
            // $(".props_option_"+dataPid).attr("selected",false); 
            // if(dataCheck){
            // $("option[value='"+dataCheck+"']").attr("selected",true);
            // }
            //
            $(this).parents(".kui-listbox").hide();
            $(this).parents(".kui-listbox").siblings(".kui-dropdown-trigger").find(".kui-placeholder").hide();
            event.stopPropagation();

            if(dataNonum=="true" || curVal==""){
                $czcfInput.addClass("disable").attr("disabled","disabled").val("");
            }else{
                $czcfInput.removeClass("disable").removeAttr("disabled");
            }

        });
        $(".kui-header").on("click",function(event){
            event.stopPropagation();
        });

        //$(".ul-select li").click(function(event){
        //$(this).find("input[name=kui-search]").focus();
        //$(this).parents(".J_spu-property").siblings("li").find(".kui-listbox").hide();
        //event.stopPropagation();
        //});
        $("body").click(function(){
            $(".kui-listbox").hide();
        });

        // $(".kui-oversize").on("scroll",function(){   //已经在页面里了
        // viewH =$(this).height(),//可见高度
        // contentH =$(this).find(".kui-group").height(),//内容高度
        // scrollTop =$(this).scrollTop();//滚动高度
        // if(contentH - viewH - scrollTop ==0){
        // alert(1)
        // }
        // });
    });

    /*
     **品牌搜索
     */
    cidHidden=$('#cid').val();
    $(".J_ul-single").delegate(".kui-dropdown-search","keyup",function(){ //.ul-select
        var searchVal = "";
        var $option = $(this).parents(".kui-header").siblings(".kui-body").find(".kui-option");
        var $brand = $(this).parents("li.J_spu-property").find("input.kui-combobox-caption");
        var nowList = "<div class='kui-option' role='menuitem' title=''></div>";
        searchVal = $(this).val();
        if($brand.attr("data-pid")==20000){
            if(searchVal!=""){
                $.post("prop-select.action", {"cid":cidHidden,'_csrf':tokenHidden,'key':searchVal},
                    function(data){
                        $(".kui-combobox-caption[data-pid='20000']").parents("li").find(".kui-group").html(data);
                    },"html");
                //var brandAry = [{name:"棉麻",val:"20019:3267700"},{name:"磨毛布",val:"20019:3267700"},{name:"other/其他",val:"20019:3267700"}];
            }else if(searchVal == ""){
                $(".kui-combobox-caption[data-pid='20000']").parents("li").find(".kui-group").html(oldList);
            }

        }else{
            $option.each(function(i,e){
                var str = $(e).text();
                var x = str.indexOf(searchVal);
                if(x==-1){
                    $(e).hide();
                }else{
                    $(e).show();
                }
            });
        }
    });


    //添加
    $(".J_ul-single").delegate(".J_addContent","click",function(){
        var $czcfUl = $(this).parents(".ul-czcf");
        $(".J_delContent").show();
        // 材质成分 添加  删除
        var timestampnow = (new Date()).valueOf();
        var czcfHtml = "";
        czcfHtml += "<div class='kui-combobox czct-box' role='combobox'>";
        czcfHtml += "<div class='kui-dropdown-trigger czcf-con'>";
        czcfHtml += "<input data-num="+timestampnow+" data-pid='149422948' data-type='input' class='kui-combobox-caption prop_from' style='width:127px;' readonly='true' role='textbox' aria-autocomplete='list' aria-haspopup='true' id='simulate-prop_ss' aria-label='下摆设计： 上下键打开选项列表，回车选中选项，ESC关闭列表，关闭后TAB键跳转到其他选项'>";
        czcfHtml += "<div class='kui-icon-dropdown'></div>";
        czcfHtml += "</div>";
        czcfHtml += "<div class='czcf-con'>";
        czcfHtml += "<input type='text' id='pre"+timestampnow+"' class='componentPercentNum kui-combobox-caption content-input disable' style='width:55px;' disabled='disabled'>";
        czcfHtml += "<div class='txt-con'>%</div>";
        czcfHtml += "<a class='J_delContent'>删除</a></div></div>";
        $czcfUl.find("li").prepend(czcfHtml);
    });
    //删除
    $(".J_ul-single").delegate(".J_delContent","click",function(){
        var $czcfBox = $(this).parents(".czct-box");
        var $prevBox = $czcfBox.prev(".czct-box");
        var hasAdd = $(this).siblings(".J_addContent").length; //点击-删除-判断是否有兄弟节点-添加 0：否 1：是
        var hasPre = $prevBox.length;  //点击-删除-判断是否有上一个兄弟节点 0：否 1：是
        var addBtn = "<a class='J_addContent'>添加</a>";
        var boxLen = $(".ul-czcf").find(".kui-combobox").length;
        if(boxLen==2){
            $czcfBox.remove();
            $(".J_delContent").hide();
            $prevBox.find(".J_delContent").after(addBtn);

        }else{
            if(hasAdd==0){
                $czcfBox.remove();
            }else if(hasPre==1){
                $prevBox.find(".J_delContent").after(addBtn);
                $czcfBox.remove();
            }
        }



    });

    //宝贝标题
    $("#TitleID").keyup(function(){
        var txtCount = 60;
        var obj = $('#TitleID');
        var errID = $("#err_nav_title");
        getBt(obj,txtCount,errID);
    });
    //宝贝卖点
    $("#SubheadingID").keyup(function(){
        var txtCount = 3000;
        var obj = $('#SubheadingID');
        var errID = $("#err_nav_subTitle");
        getBt(obj,txtCount,errID);
    });

    function getBt(obj,count,errID){
        var txtVal = obj.val();
        var charBt = txtVal.replace(/[^\x00-\xff]/g, '**').length;
        if(charBt>count){
            obj.siblings(".input-count").addClass("overcount");
            obj.siblings(".input-count").find("span").text(charBt).addClass("warning");
            errID.show();
        }else{
            obj.siblings(".input-count").removeClass("overcount");
            obj.siblings(".input-count").find("span").text(charBt).removeClass("warning");
            errID.hide();
        }
    }

    // 颜色
    $(".sku-color li").each(function(){
        var hasEdit = $(this).hasClass("edit");
        var labelE = $(this).find(".labelname");
        var inputE = $(this).find(".editbox");
        var checkB = $(this).find(".J_Checkbox");
        if(hasEdit){
            labelE.hide();
            inputE.show();
        }else{
            labelE.show();
            inputE.hide();
        }
    });
    // 选取颜色
    var dataP = $(".sku-color").attr("data-p"); //data-p="1627207"
    var buyNowPrice = $("#buynow").val(); //一口价
    $(".sku-color li").find(".J_Checkbox").on("click",function(){
        var skuLi = $(this).parents("li");
        var inputC = skuLi.find(".J_Checkbox");
        var labelE = skuLi.find(".labelname");
        var labelC = skuLi.find(".color-lump ");
        var inputE = skuLi.find(".editbox");
        var propId = inputC.attr("id").substr(6+(dataP.length)); //id="prop_1627207_28327"
        var sibL = skuLi.siblings("li.edit").length;

        if(inputC.is(":checked")){

            labelE.hide();
            inputE.show();
            skuLi.addClass("edit");
            $("#J_SKUColorWrapper").show();

            //颜色显示
            $(".J_SKUImgTable tbody tr").each(function(){
                var imgId = $(this).attr("id").substr(10+(dataP.length)); //id="J_MapImg_1627207-28327"
                if(propId==imgId){
                    $(this).show();
                }
            });

            //新增颜色尺码			
            var curPre = skuLi.prevAll(".edit").length;	    //选取颜色时之前有几个被选的个数
            var addHtml = "";
            var hasSize = $(".sku-group").hasClass("sku-size");
            var dataPropIdC = dataP+'-'+propId //1627207-3232483 对应颜色
            if(hasSize){  //存在尺码
                var sizeCount  = $(".sku-size").find(".edit").length;
                $(".sku-size").find(".edit").each(function(i,e){
                    var checkboxId = $(e).find(".J_Checkbox").attr("id").substr(6+(dataSizeP.length)); //id="prop_20509_25054027"
                    var sizeVal = $(e).find(".editbox ").val();
                    var dataPropIdS = dataSizeP+'-'+checkboxId //20509-25054027  对应尺码

                    if(i==0){
                        addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                        addHtml += '<td rowspan="'+sizeCount+'" class="tile">';
                        addHtml += '<i class="color-lump" style="'+labelC.attr("style")+';"></i>';
                        addHtml += '<span class="J_Map_'+dataPropIdC+'">'+labelE.html()+'</span></td>';
                        addHtml += '<td rowspan="1">';
                        addHtml += '<span class="J_Map_'+dataPropIdS+'">'+sizeVal+'</span></td>';
                        addHtml += '<td class="price">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_price_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                        addHtml += '<td class="quantity">';
                        addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_quantity_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                        addHtml += '<td class="tsc">'
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_tsc_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                        addHtml += '</tr>';
                    }else{
                        addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                        addHtml += '<td rowspan="1">';
                        addHtml += '<span class="J_Map_'+dataPropIdS+'">'+sizeVal+'</span></td>';
                        addHtml += '<td class="price">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_price_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                        addHtml += '<td class="quantity">';
                        addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_quantity_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                        addHtml += '<td class="tsc">'
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataPropIdS+'" id="J_SkuField_tsc_'+dataPropIdC+'_'+dataPropIdS+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                        addHtml += '</tr>';
                    }
                });

            }else{  //尺码不存在
                var sizeCount = 1;
                addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                addHtml += '<td rowspan="'+sizeCount+'" class="tile">';
                addHtml += '<i class="color-lump" style="'+labelC.attr("style")+';"></i>';
                addHtml += '<span class="J_Map_'+dataPropIdC+'">'+labelE.html()+'</span></td>';
                addHtml += '<td class="price">';
                addHtml += '<input data-id="'+dataPropIdC+'" id="J_SkuField_price_'+dataPropIdC+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                addHtml += '<td class="quantity">';
                addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'" id="J_SkuField_quantity_'+dataPropIdC+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                addHtml += '<td class="tsc">'
                addHtml += '<input data-id="'+dataPropIdC+'" id="J_SkuField_tsc_'+dataPropIdC+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                addHtml += '</tr>';
            }
            if(curPre==0){
                $(".sku-loading tbody tr").eq(0).before(addHtml);
            }else{
                $(".sku-loading tbody tr").eq(curPre*sizeCount-1).after(addHtml);
            }
        }else{
            if(sibL==0){
                $("#J_SKUColorWrapper").hide();
            }
            labelE.show();
            inputE.hide();
            skuLi.removeClass("edit");
            //颜色隐藏
            $(".J_SKUImgTable tbody tr").each(function(){
                var imgId = $(this).attr("id").substr(10+(dataP.length));
                if(propId==imgId){
                    $(this).hide();
                }
            });

            //删除颜色尺码
            var aliasId = inputE.attr("id").substr(8); //id="J_Alias_1627207-28327"
            $(".sku-loading tbody tr").each(function(){
                var d = $(this).attr("data-color");
                if(d==aliasId){
                    $(this).remove();
                }
            });

        }
    });

    // 改变颜色值&&尺码值
    $(".editbox").blur(function(){
        var newVal = $(this).val();
        var aliasId = $(this).attr("id").substr(7); //id="J_Alias_1627207-28327"
        var mapId = "J_Map" + aliasId;
        $("."+mapId).html(newVal);
        $(this).siblings(".labelname").html(newVal).attr("title",newVal);
        $(this).val(newVal);
    });





    // 选取尺码	
    var dataSizeP = $(".sku-size").attr("data-p"); //data-p="20509"	
    $(".sku-size li").find(".J_Checkbox").on("click",function(){
        var sizeCount = "";
        var skuLi = $(this).parents("li");
        var inputC = skuLi.find(".J_Checkbox");
        var labelE = skuLi.find(".labelname");
        var inputE = skuLi.find(".editbox");
        var propId = inputC.attr("id").substr(6+(dataSizeP.length)); //id="prop_20509_25054027"
        sizeCount = $(".sku-size").find(".edit").length;
        colorCount  = $(".sku-color").find(".edit").length;

        if(inputC.is(":checked")){
            labelE.hide();
            inputE.show();
            skuLi.addClass("edit");
            $(".sku-mapfeed").hide();
            $(".sku-wrapper").show();

            $("#J_SKUMapContainer").show();
            $(".sku-mapfeed").hide();

            //增加尺码
            $(".J_MapRow .tile").attr("rowspan",sizeCount+1);
            var AliasId = "J_Alias_" +dataSizeP+"-"+ propId; //对应的尺码id
            var checkVal = $("#"+AliasId).val(); //对应尺码值

            var curPre = skuLi.prevAll(".edit").length;	    //选取尺码时之前有几个被选的尺码个数
            var tbodyStr = $(".sku-loading tbody tr").length;
            //判断新增尺码时tbody是否为空
            if(tbodyStr==0){
                for(i=0;i<colorCount;i++){
                    addHtml = "";
                    var $color = $(".sku-color .edit").eq(i).find("input:last");
                    var background = $(".sku-color .edit").eq(i).find("label:first").attr("style");
                    firstTtml = $color.val();
                    dataPropIdC = $color.attr("id").substr(8);
                    addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                    addHtml += '<td rowspan="1" class="tile"><i class="color-lump" style="'+background+'"></i><span class="J_Map_'+dataPropIdC+'">'+firstTtml+'</span></td>';
                    addHtml += '<td rowspan="1">';
                    addHtml += '<span class="J_Map_'+dataSizeP+'-'+propId+'">'+checkVal+'</span></td>';
                    addHtml += '<td class="price">';
                    addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_price_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                    addHtml += '<td class="quantity">';
                    addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_quantity_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                    addHtml += '<td class="tsc">';
                    addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_tsc_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                    addHtml += '</tr>';
                    $(".sku-loading tbody").append(addHtml);
                }
            }else{
                //判断增加的尺码是否是第一个
                if(curPre==0){
                    for(i=0;i<colorCount;i++){
                        var firstTtml = "";
                        var dataPropIdC = "";
                        var addHtml = "";
                        var element = $(".sku-loading tbody tr").eq((sizeCount+1)*i);
                        firstTtml = element.find("td:first").html();
                        dataPropIdC = element.attr("data-color");
                        addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                        addHtml += '<td rowspan="'+(sizeCount+1)+'" class="tile">'+firstTtml+'</td>';
                        addHtml += '<td rowspan="1">';
                        addHtml += '<span class="J_Map_'+dataSizeP+'-'+propId+'">'+checkVal+'</span></td>';
                        addHtml += '<td class="price">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_price_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                        addHtml += '<td class="quantity">';
                        addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_quantity_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                        addHtml += '<td class="tsc">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_tsc_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                        addHtml += '</tr>';
                        element.find("td:first").remove();
                        element.before(addHtml);
                    }
                }else{
                    for(i=0;i<colorCount;i++){
                        var dataPropIdC = "";
                        var addHtml = "";
                        dataPropIdC = $(".sku-loading tbody tr").eq((sizeCount+1)*i).attr("data-color");

                        addHtml += '<tr class="J_MapRow" data-color="'+dataPropIdC+'">';
                        addHtml += '<td rowspan="1">';
                        addHtml += '<span class="J_Map_'+dataSizeP+'-'+propId+'">'+checkVal+'</span></td>';
                        addHtml += '<td class="price">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_price_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapPrice text" data-type="price" type="text" value="'+buyNowPrice+'"></td>';
                        addHtml += '<td class="quantity">';
                        addHtml += '<input maxlength="9" data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_quantity_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapQuantity text" data-type="quantity" type="text" value=""></td>';
                        addHtml += '<td class="tsc">';
                        addHtml += '<input data-id="'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" id="J_SkuField_tsc_'+dataPropIdC+'_'+dataSizeP+'-'+propId+'" class="J_MapProductid text" data-type="tsc" type="text" value=""></td>';
                        addHtml += '</tr>';

                        $(".sku-loading tbody tr").eq(curPre+(sizeCount+1)*i-1).after(addHtml);

                    }
                }
            }

        }else{
            labelE.show();
            inputE.hide();
            skuLi.removeClass("edit");
            // var hasEdit = skuLi.siblings("li").hasClass("edit");
            // if(!hasEdit){
            // $(".sku-mapfeed").show();
            // $(".sku-wrapper").hide();
            // }

            var hasEdit = skuLi.siblings("li").hasClass("edit");
            //判断尺码个数是否为0
            if(!hasEdit){
                $("#J_SKUMapContainer").hide();
                $(".sku-mapfeed").show()
            }

            //减少尺码
            $(".J_MapRow .tile").attr("rowspan",sizeCount-1);
            // 判断是否删除第一个
            var mapId = "J_Map_" +dataSizeP+"-"+ propId; //对应的尺码
            var firstTr = $("."+mapId).parents("td").siblings().hasClass("tile");
            if(firstTr){
                for(i=0;i<colorCount;i++){
                    var firstTtml = $(".sku-loading").find("."+mapId).eq(i).parents("td").prev().clone();
                    $("."+mapId).eq(i).parents(".J_MapRow").next().prepend(firstTtml);
                }
                $("."+mapId).parents(".J_MapRow").remove();

            }else{
                $("."+mapId).parents(".J_MapRow").remove();
            }


        }
    });

    //价格设置
    $(document).on("blur",".J_MapPrice",function(){
        var price = $(this).val();
        var reg=/^\d+(\.\d{0,2})?$/;
        if(reg.test(price)==false){
            alert("不是纯数字，失败");
            $(this).val("");
        }
    });
    $("#batchprice").click(function(){
        var newPrice = $(".price:first input").val();
        $(".price input").val(newPrice);
    });


    //数量设置
    $(document).on("blur",".J_MapQuantity",function(){
        var quantity = $(this).val();
        var reg=/^[1-9]\d*$|^0$/;
        if(reg.test(quantity)==false){
            alert("不是整数，失败");
            $(this).val("");
        }
    });
    $(".required .batch").click(function(){
        var newQuan = $(".quantity:first input").val();
        $(".quantity input").val(newQuan);
        var quanCount = $(".quantity input").length;
        $("#quantityId").val(quanCount*newQuan);
    });

    //商家编码设置
    $(".d_size2").click(function(){
        var tsc = $(".tsc:first input").val();
        $(".J_MapProductid").val(tsc);
    });

    //选择图片
    var $imgE ="";
    var imgHtml = "";
    var $inputBtn = "";
    var tileVal = "";
    var $undel = "";
    $(".img-table tbody tr").find("input:first").click(function(){
        objLay = 2;
        //var objUrl = getObjectURL(this.files[0]);
        $imgE = $(this).parents("td").siblings(".preview").find("img");
        $undel =$(this).parents("td").siblings(".preview").find(".undel");
        $inputBtn = $(this);
        tileVal = $(this).parents("td").siblings(".tile").find("span").attr("data-value");
        imgLay=layer.open({
            type: 1,
            title: '图片空间',
            closeBtn: 1,
            shade: 0.5,
            shadeClose: true,
            area: ['840px', '610px'],
            content: $("#kc"),
        });
    });

    $(".preview").delegate(".del","click",function(){
        $(this).prev().hide();
        $(this).hide();
        $(this).next().show();
        $(this).siblings("input.prop_img_default").val("");
    });
    $(".preview").delegate(".undel","click",function(){
        var imgUrl = $(this).parents(".preview").find("a:first").attr("href");
        $(this).prevAll("a").show();
        $(this).hide();
        $(this).siblings("input.prop_img_default").val(imgUrl);
    });

    //图片宝贝

    // 删除图片
    $(".operate .del").on("click",function(){
        $(this).parents("li").find(".picUrl").val("");
		$(this).parents(".operate").siblings(".preview ").find("div.img img").attr("src","");
		$(this).parents(".operate").siblings(".preview ").find(".upload-tip").show();
        $(this).parents(".operate").find("i").show();
    });
    //左移动图片
	$(".multimage-wrap").delegate(".toleft","click",function(){
        var index = $(this).parents("li").attr("data-index");
		var direction = 0;
		moveImg(direction,index);
    });
    //右移动图片
	$(".multimage-wrap").delegate(".toright","click",function(){
        var index = parseInt($(this).parents("li").attr("data-index"));
		var direction = 1;
		moveImg(direction,index);
    });
	function moveImg(direction,index){
		if(direction == 0 && index != 0){
			var sibIndex = index-1;
		}
		if(direction == 1 && index != 5){
			var sibIndex = index+1;
		}
		if(direction == 0 && index != 0 || direction == 1 && index != 5){

			var $curIndex = $(".image-list li[data-index="+(index)+"]");
			var $sibIndex = $(".image-list li[data-index="+sibIndex+"]");
			var curVal = $curIndex.find("input.picUrl").val();
			var changeVal = $sibIndex.find("input.picUrl").val();
			var curPreview = $curIndex.find(".preview").html();
			var sibPreview = $sibIndex.find(".preview").html();
			$sibIndex.find("input.picUrl").val(curVal);
			$curIndex.find("input.picUrl").val(changeVal);
			$sibIndex.find(".preview").html(curPreview);
			$curIndex.find(".preview").html(sibPreview);
		}
	}

    //当前商品图片展开
    $("#J_BanJiaExpand").click(function(){
        $("#banjia").toggle();
    });


    // 在线编辑图片
    $(".sui-nav li").click(function(){
        var index = $(this).index();
        $(this).addClass("active").siblings().removeClass("active");
        $(".tab-content .upload-container").eq(index).show().siblings().hide();
    });
    // 从图片中选择
    var imgUrl = "";
    var imgData = "";
    var imgLay;
    $(".image-list").delegate(".icon-tianjia","click",function(){
        objLay = 0;
        imgData = $(this).parents("li").attr("data-index");
        imgLay=layer.open({
            type: 1,
            title: '在线编辑图片',
            closeBtn: 1,
            shade: 0.5,
            shadeClose: true,
            area: ['840px', '610px'],
            content: $("#kc"),
        });
    });



    // 选择上传图片
    // $("#J_MultimageField1").change(function(){
    // var objUrl = getObjectURL(this.files[0]);
    // var addHtml = "";
    // $(".sui-nav li").eq(0).removeClass("active").siblings().addClass("active");
    // $(".tab-content .upload-container").eq(0).hide().siblings().show();
    // addHtml += "<li><div class='ii'><img src='"+objUrl+"'></div></li>"
    // $("#J_ListTable").prepend(addHtml);

    // });



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



    //手机端详情

    var tools = "";
    var conImg = ""; //图片
    var conText = ""; //文字
    var cover ="";
    var conDesc = ""; //摘要
    var editDesc =""; //摘要area
    $(".control-panel").delegate(".text-div,.image-div","click",function(){
        var $module = $(this).parents(".module");
        var end = $module.next().length;
        var start = $module.prev().length;
        var hasDesc = $module.prev(".module").hasClass("m-shortDesc");
        $module.addClass("current").siblings().removeClass("current");
        //最后一个模块，第一个模块判断	
        if(end==0){
            $module.addClass("end");
        }else if(start==0 || hasDesc){
            $module.addClass("first")
        }
    });

    //上移下移替换删除HTML
    tools += "<ul class='tools'>";
    tools += "<li><a href='javascript:void(0)' class='up'>上移</a></li>";
    tools += "<li><a href='javascript:void(0)' class='down'>下移</a></li>";
    tools += "<li><a href='javascript:void(0)' class='edit'>替换</a></li>";
    tools += "<li><a href='javascript:void(0)' class='delete'>删除</a></li>";
    tools += "</ul>";

    //cover层HTML
    cover = "<div class='cover'></div>";

    //图片HTML
    function addImg(obj){
        conImg = "";
        conImg += "<div class='module m-image'>";
        conImg += tools;
        conImg += "<div class='content'>";
        conImg += "<div class='image-div'>";
        conImg += "<img src='"+obj+"'>";
        conImg += "</div></div>"+cover+"</div>";
    }


    //文字HTML
    function addText(obj){
        conText = "";
        conText += "<div class='module m-text'>";
        conText += tools;
        conText += "<div class='content'>";
        conText += "<div class='text-div'>";
        conText += "<div class='text-html J_Html'>"+obj+"</div>";
        conText += "</div></div>"+cover+"</div>";
    }


    //摘要area	
    function addArea(count,obj,text){
        editDesc = "";
        editDesc += "<div class='edit-text text-shortDesc'>";
        editDesc += "<p class='text-tip'>"+text+"<b>"+count+"</b>字</p>";
        editDesc += "<div class='text-textarea'><textarea>"+obj+"</textarea></div>";
        editDesc += "<div class='button'>";
        editDesc += "<input type='button' value='确认' class='text-submit'>";
        editDesc += "<input type='button' value='取消' class='text-cancel'>";
        editDesc += "</div><a href='#' class='text-close'>关闭</a></div>";
    }

    //添加摘要
    $(".shortDesc").mousemove(function(){
        var dese = $(".control-panel").find(".module").hasClass("m-shortDesc");
        if(dese){
            $(".shortDesc").find(".overlay").show();
        }
    }).mouseleave(function(){
        $(".shortDesc").find(".overlay").hide();
    });
    $(".shortDesc").click(function(){
        var areaCount = 140;
        var areaL = $("#J_EditSummaryArea").html()
        var areaVal ="";
        var text = "摘要只能输入";
        addArea(areaCount,areaVal,text);
        if(areaL==""){
            $(".content-edit").animate({scrollTop: 0},200);
            $("#J_EditSummaryArea").show().append(editDesc);
        }
        $(".text-submit").click(function(){
            areaVal = $(this).parents(".button").siblings(".text-textarea").find("textarea").val();
            //插入摘要
            conDesc = "";
            conDesc += "<div class='module m-shortDesc'>";
            conDesc += "<ul class='tools'>";
            conDesc += "<li><a href='javascript:void(0)' class='edit'>编辑</a></li>";
            conDesc += "<li><a href='javascript:void(0)' class='delete'>删除</a></li>";
            conDesc += "</ul>";
            conDesc += "<div class='content'>";
            conDesc += "<div class='text-div'><i class='icon iconfont icon-listbullet shortDesc-icon J_icon'></i>";
            conDesc += "<div class='text-html J_Html'>"+areaVal+"</div>";
            conDesc += "</div></div>"+cover+"</div>";
            $(".control-panel").prepend(conDesc);
            $("#J_EditSummaryArea").html("");
        });
        $(".text-cancel").click(function(){
            $("#J_EditSummaryArea").html("");
            editDesc="";
        });
        areaTextCount(areaCount);
    });

    //编辑摘要,替换图片,编辑文字
    $(".control-panel").delegate(".edit","click",function(){
        var $module = $(this).parents(".module");
        var Maudio = $module.hasClass("m-audio");
        var MshortDesc = $module.hasClass("m-shortDesc");
        var Mimage = $module.hasClass("m-image");
        var Mtext = $module.hasClass("m-text");

        if(Maudio){
            objModule = 0;	 //音频		
        }else if(MshortDesc){
            objModule = 1;	//摘要
        }else if(Mimage){
            objModule = 2;	//图片
        }else if(Mtext){
            objModule = 3;	//文字
        }

        switch(objModule){
            case 1: editDesc="";
                var $content = $(this).parents(".tools").siblings(".content");
                $content.find(".text-div").hide();
                var textCount = 140;
                var textVal = $content.find(".text-html").text();
                var text = "摘要只能输入";
                var newCount = textCount-textVal.length;
                addArea(newCount,textVal,text);
                $content.parents(".module").removeClass('current');
                $content.append(editDesc);
                //确认&取消
                $(".text-submit").click(function(){
                    areaVal = $(this).parents(".button").siblings(".text-textarea").find("textarea").val();
                    $(this).parents(".edit-text").siblings(".text-div").show().find(".text-html").text(areaVal);
                    $(this).parents(".edit-text").remove();

                });
                $(".text-cancel").click(function(){
                    $content.find(".text-div").show();
                    $content.find(".text-html").text(textVal);
                    $(".edit-text").remove();
                });
                areaTextCount(textCount);
                break;
            case 2: imgLay=layer.open({
                type: 1,
                title: '图片空间',
                closeBtn: 1,
                shade: 0.5,
                shadeClose: true,
                area: ['840px', '610px'],
                content: $("#kc"),
            });
                $("#J_ListTable").delegate("li","click",function(){
                    layer.close(imgLay);
                    imgUrl = $(this).find("img").attr("src");
                    $(".current").find(".image-div img").attr("src",imgUrl);
                    $(".module").removeClass("current");
                });
                break;
            case 3: var $mText = $(this).parents(".m-text");
                var textCount = 4991;
                var textVal = $mText.find(".text-html").text();
                var text = "单个文本框字数不得超过";
                var newCount = textCount-textVal.length;
                addArea(newCount,textVal,text);
                $mText.append(editDesc);
                $mText.removeClass("current");
                $mText.find(".content").hide();

                $(".text-submit").click(function(){
                    areaVal = $(this).parents(".button").siblings(".text-textarea").find("textarea").val();
                    $mText.find(".text-html").text(areaVal);
                    $mText.find(".content").show();
                    $(".edit-text").remove();
                });
                $(".text-cancel").click(function(){
                    $mText.find(".content").show();
                    $mText.find(".text-html").text(textVal);
                    $(".edit-text").remove();
                });
                areaTextCount(textCount);
                break;
        }


    });
    //删除模块
    $(".control-panel").delegate(".delete","click",function(){
        $(this).parents(".module").remove();
    });

    //添加图片
    $(".image").click(function(){
        objLay = 1;
        imgLay=layer.open({
            type: 1,
            title: '图片空间',
            closeBtn: 1,
            shade: 0.5,
            shadeClose: true,
            area: ['840px', '610px'],
            content: $("#kc"),
        });
    });

    $("#J_ListTable").delegate("li","click",function(){
        layer.close(imgLay);
        imgUrl = $(this).find("img").attr("src");
        if(objLay==0){   //插入宝贝图片
            var Html = "";
            var $imgList = $(".image-list li[data-index='"+imgData+"']");
			// Html += "<div class='img'>";
			// Html += "<img src='"+imgUrl+"'></div>";
			$imgList.find(".img img").attr("src",imgUrl);
            var imgW = $(this).find("img")[0].naturalWidth;
            var imgH = $(this).find("img")[0].naturalHeight;
            if(imgData==6){
                //if(imgW/imgH==2/3){
                //$imgList.find(".preview").append(Html);   //这边到时可以改一下
                //$imgList.find(".picUrl").val(imgUrl);
                //$imgList.find(".upload-tip").hide();
                //}else{
                //alert("上传图片比例不对，请重新上传")
                //}
                $imgList.find(".preview").append(Html);   //这边到时可以改一下
                $imgList.find(".picUrl").val(imgUrl);
                $imgList.find(".upload-tip").hide();
            }else{
                $imgList.find(".preview").append(Html);
                $imgList.find(".picUrl").val(imgUrl);
                $imgList.find(".upload-tip").hide();
            }
        }else if(objLay==1){   //插入手机端详情图片
            addImg(imgUrl);
            $(".control-panel").append(conImg);
        }else if(objLay==2){	//颜色选择图片
            imgHtml='';
            layer.close(imgLay);
            imgUrl = $(this).find("img").attr("src");

            if($imgE.length==0|| !$undel.is(":hidden")){
                imgId=tileVal.replace(/:/, '_');  //id里有：jquey赋值会失败
                imgHtml += '<input type="hidden" id="prop_img-'+imgId+'" name="prop_img[]" class="prop_img_default" data-value="'+tileVal+'" value="'+imgId+'##'+imgUrl+'_800x800.jpg">';
                imgHtml += '<a target="_blank" href="'+imgUrl+'">';
                imgHtml += '<img width="40px" src="'+imgUrl+'"></a>';
                imgHtml += '<a class="del" href="javascript:void(0);">删除</a>';
                imgHtml += '<a class="undel" href="javascript:void(0);">恢复删除</a>';
                $inputBtn.parents("td").siblings(".preview").html(imgHtml);
            }else{
                $imgE.attr('src',imgUrl);
                $imgE.parents("a").attr("href",imgUrl);
                $imgE.parents("a").siblings("input").val(imgUrl)
            }
        }

    });

    //添加文字
    $(".text").click(function(){
        var areaL = $("#J_EditArea").html();
        var areaCount = 4991;
        var areaVal ="";
        var text = "单个文本框字数不得超过";
        addArea(areaCount,areaVal,text);
        if(areaL==""){
            $("#J_EditArea").show().append(editDesc);
            $(".content-edit").animate({scrollTop: $(".control-panel").height()},200);
        }
        $(".text-submit").click(function(){
            areaVal = $(this).parents(".button").siblings(".text-textarea").find("textarea").val();
            addText(areaVal);
            var conText1 = conText.replace('替换', '编辑');
            $(".control-panel").append(conText1);
            $("#J_EditArea").html("");
        });
        $(".text-cancel").click(function(){
            $("#J_EditArea").html("");
        });
        areaTextCount(areaCount);
    });

    //移动模块
    $(".control-panel").delegate(".tools .up","click",function(){
        var $module = $(this).parents(".module");
        var idnex = $module.index();
        var html =  $module.clone().removeClass("current").removeClass("end");
        $(".module").eq(idnex-1).before(html);
        $module.remove();
    });
    $(".control-panel").delegate(".tools .down","click",function(){
        var $module = $(this).parents(".module");
        var idnex = $module.index();
        var html =  $module.clone().removeClass("current").removeClass("first");
        $(".module").eq(idnex+1).after(html);
        $module.remove();
    });

    //摘要文字数字计算
    function areaTextCount(obj){
        $("body").delegate(".text-textarea textarea","keyup",function(){
            var $tipb = $(this).parents(".text-textarea").siblings(".text-tip").find("b");
            var enterCount = $(this).val().length;
            $tipb.text(obj-enterCount);
        });
    }

    // 运费模板
    $("#J_Logistics").delegate("#J_deliverTemplate","change",function(){
        var $this = $("#J_deliverTemplate");
        var $list = $("#J_Logistics .list-box");
        var opVal = $this.find("option:selected").attr("valu");
        if(opVal==""){
            $list.hide();
        }else{
            $list.hide();
            $list.eq(opVal).show();
        }
    });

    //开始时间
    $(".checkbox-wrap input").click(function(){
        if($("#_now1").is(":checked")){
            $("#_now1").siblings("select").removeAttr("disabled")
        }else{
            $("#_now1").siblings("select").attr("disabled","disabled");
        }
    });


    //开始时间
    var d = new Date();
    var dYear = d.getFullYear();
    var dMonth = d.getMonth()+1;
    var dDate = d.getDate();
    var today = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
    var dd = d;
    var MOption = "";
    MOption += "<option value='0'>0</option>";
    MOption += "<option value='5'>5</option>";
    MOption += "<option value='10'>10</option>";
    MOption += "<option value='15'>15</option>";
    MOption += "<option value='20'>20</option>";
    MOption += "<option value='25'>25</option>";
    MOption += "<option value='30'>30</option>";
    MOption += "<option value='35'>35</option>";
    MOption += "<option value='40'>40</option>";
    MOption += "<option value='45'>45</option>";
    MOption += "<option value='50'>50</option>";
    MOption += "<option value='55'>55</option>";
    $(".checkbox-wrap input").click(function(){
        if($("#_now1").is(":checked")){
            $("#_now1").siblings("select").removeAttr("disabled");
            var dHours = d.getHours();
            var dMinu = d.getMinutes();
            var dOption = "";
            var hOption = "";
            d = new Date(dd);
            // 年月日
            dOption += "<option value='"+dYear+"-"+dMonth+"-"+dDate+"'>"+dYear+"年"+dMonth+"月"+dDate+"日</option>"
            for(var i =0 ;i<14;i++){
                var newday = new Date(d.setDate(d.getDate()+1));
                var y = newday.getFullYear();
                var m = newday.getMonth()+1;
                var date = newday.getDate();
                dOption += "<option value='"+y+"-"+m+"-"+date+"'>"+y+"年"+m+"月"+date+"日</option>"
            }
            $(".field-content select[name='_date']").html(dOption);
            //小时
            for(dHours;dHours<24;dHours++){
                hOption += "<option value='"+dHours+"'>"+dHours+"</option>"
            }
            $(".field-content select[name='_hour']").html(hOption);
            //分钟


            $(".field-content select[name='_minute']").html(MOption);
            $(".field-content select[name='_minute']").find("option").each(function(i){
                if($(this).val()<dMinu){
                    if(dMinu<55){
                        $(this).remove();
                    }else{
                        dHours = d.getHours();
                        $(".field-content select[name='_minute']").html("<option value='0'>0</option>");
                        hOption = "";
                        for((dHours+1);dHours<24;dHours++){
                            hOption += "<option value='"+(dHours+1)+"'>"+(dHours+1)+"</option>"
                        }
                        $(".field-content select[name='_hour']").html(hOption);
                    }
                }

            });



        }else{
            $("#_now1").siblings("select").attr("disabled","disabled");
        }
    });
    $(".field-content select[name='_date']").change(function(){
        var dHours = d.getHours();
        var dMinu = d.getMinutes();if(!dMinu){dMinu=0;}
        var hOption = "";
        var curDate = $(this).val();
        $(".field-content select[name='_minute']").html(MOption);
        if(today==curDate){
            var dHours = d.getHours();
            for(dHours;dHours<24;dHours++){
                hOption += "<option value='"+dHours+"'>"+dHours+"</option>"
            }
            $(".field-content select[name='_minute']").find("option").each(function(i){
                if($(this).val()<dMinu){
                    $(this).remove();
                }
            });
        }else{
            hours = 0;
            for(hours;hours<24;hours++){
                if(dHours==hours){
                    hOption += "<option value='"+hours+"' selected='selected'>"+hours+"</option>"
                }else{
                    hOption += "<option value='"+hours+"'>"+hours+"</option>"
                }
            }
            $(".field-content select[name='_minute']").find("option").each(function(i){
                $val = $(this).val();
                if(dMinu<$val && $val<(dMinu+5)){
                    $(this).attr("selected","selected");

                }
            });
        }
        $(".field-content select[name='_hour']").html(hOption);


    });

    $(".field-content select[name='_hour']").change(function(){
        var dHours = d.getHours();
        var curHours = $(this).val();
        var dMinu = d.getMinutes();
        var curDate = $(".field-content select[name='_date']").val();
        if(parseToDate(today) < parseToDate(curDate)){
            $(".field-content select[name='_minute']").html(MOption);
        }else{
            $(".field-content select[name='_minute']").html(MOption);
            if(dHours<curHours){
                $(".field-content select[name='_minute']").find("option").each(function(i){
                    $val = $(this).val();
                    if(dMinu<$val && $val<(dMinu+5)){
                        $(this).attr("selected","selected");
                    }
                });
            }else{
                $(".field-content select[name='_minute']").find("option").each(function(i){
                    if($(this).val()<dMinu){
                        $(this).remove();
                    }
                });
            }
        }



    });

    function parseToDate(str){
        var s=str.split('-');
        var month=parseInt(s[1]);
       return new Date(s[0],month-1,s[2]);
    }


    //利润设置,改变一口价时
    var price = parseFloat($('#buynow').val()-$('#curlirun').val());
    $("#buynow").blur(function(){
        var buyNowPrice = $(this).val();
        var buyPrice = parseFloat(buyNowPrice - price).toFixed(2);
        $("#curlirun").val(buyPrice);
        $(".J_MapRow td.price input").val(buyNowPrice);
    });
    $("#curlirun").blur(function(){
        var lrPrice = parseFloat($(this).val());
        var buyPrice = "";
        if(lrPrice<0 || isNaN(lrPrice)){
            lrPrice = 0;
            $(this).val(0)
        }
        buyPrice = parseFloat(price+lrPrice);
        $("#buynow").val(buyPrice);
        $(".J_MapRow td.price input").val(buyPrice);
    });
    $("#J_LiRun").click(function(){
        liLay = layer.open({
            type: 1,
            title: '设置利润',
            closeBtn: 1,
            shade: 0.5,
            shadeClose: true,
            area: ['410px', '260px'],
            content: $("#L_liRun"),
        });
        var $radio = $("#liruncontent .radio");
        var $input = $("#liruncontent input[type=text]");
        $radio.click(function(){
            $radio.removeAttr("disabled");
            $input.attr("disabled","disabled");
            $(this).siblings("input").removeAttr("disabled");
        });
		
		// 修改默认利润 
		$("#L_liRun .btn-primary").click(function(){
            layer.close(liLay);
			var lrauto = $("#lirunauto").is(":checked");	//自动设置利润 booleans
			var qzauto = $("#lirunzheng").is(":checked");	//是否取整
			var $lr = $("#liruncontent input[type='radio']:checked");
			var fbTemp = $lr.val();
			var lrPrice1 = "";
			if(lrauto){
				var lrPrice =  parseFloat($lr.siblings("input[type='text']").val());
				$(".fl-label[data-index='"+(fbTemp-1)+"']").show().siblings(".fl-label").hide();
				if(fbTemp == 1){	//按固定值
					$(".set-sty option[value='"+(fbTemp-1)+"']").prop("selected",true);
            }else{
					lrPrice1=lrPrice;
					if(qzauto){	//取整
						lrPrice =  parseFloat(Math.round(price*lrPrice1/100));
						$(".set-sty option[value='"+fbTemp+"']").prop("selected",true);
					}else{	//不取整
						lrPrice =  parseFloat(price*lrPrice1/100);
						$(".set-sty option[value='"+(fbTemp-1)+"']").prop("selected",true);
            }
					$("#lrPrice").html(lrPrice);
				}
                $("#curlirun").val(lrPrice);
                $("#buynow").val(price+lrPrice);
				$(".J_MapRow td.price input").val(price+lrPrice);
			}
        });
    });

	//改变利润类型

	$(".set-sty").change(function(){
		var lrauto = $("#lirunauto").is(":checked");	//自动设置利润 booleans
		var fbTemp = $(this).find("option:selected").val();	//0:按固定值   1:按比例（不取整）  2:按比例（取整）
		var lrPrice ="",lrPrice1 ="";	//利润值
		var buyPrice = "";	//最新价格

		if(lrauto){
			if(fbTemp == 0){
				lrPrice= parseFloat($("#lirunval0").val());
			}else{
				lrPrice= parseFloat($("#lirunval1").val());
			}
		}else{
			lrPrice=0;
			lrPrice1=0;
		}

		if(fbTemp == 0){
			$(".fl-label[data-index='0']").show().siblings(".fl-label").hide();
			buyPrice = parseFloat(price+lrPrice);
			$("#curlirun").val(lrPrice);
			// $("#buynow").val(buyPrice);
			// $(".J_MapRow td.price input").val(buyPrice);
		}else{
			$(".fl-label[data-index='1']").show().siblings(".fl-label").hide();
			//lrPrice= parseFloat($("#lirunval1").val());
			if(fbTemp == 1){
				lrPrice1 = price*lrPrice/100;

			}else if(fbTemp == 2){
				lrPrice1 = Math.round(price*lrPrice/100);
			}
			buyPrice = parseFloat(price+lrPrice1);
			$("#lrPrice").html(lrPrice1);
			$("#curlirun").val(lrPrice);

		}
		$(".J_MapRow td.price input").val(buyPrice);
		$("#buynow").val(buyPrice);
	});

	//改变利润数值
	/*$("#curlirun").blur(function(){
		var fbTemp = $(".set-sty").find("option:selected").val();//0:按固定值   1:按比例（不取整）  2:按比例（取整）
		var lrPrice = parseFloat($(this).val());	//利润值
		var buyPrice = "";	//最新价格
		if(lrPrice<0 || isNaN(lrPrice)){
			lrPrice = 0;
			$(this).val(0)
		}
		if(fbTemp == 0){	//按固定值
			buyPrice = parseFloat(price+lrPrice);		
		}else if(fbTemp == 1){	//按比例（不取整）
			lrPrice = price*lrPrice/100
			buyPrice = parseFloat(price+lrPrice);
		}else if(fbTemp == 2){	//按比例（取整）
			lrPrice = Math.round(price*lrPrice/100);
			buyPrice = parseFloat(price+lrPrice);
		}	
		$("#lrPrice").html(lrPrice);	
		$("#buynow").val(buyPrice);
		$(".J_MapRow td.price input").val(buyPrice);
	});*/

	
	

    //发布

    // $("#event_submit_do_publish").click(function(){
    // fbLay = layer.open({
    // type: 1,
    // title: '发布商品',
    // closeBtn: 1,
    // shade: 0.5,
    // shadeClose: false,
    // area: ['550px', ''],
    // content: $("#J_publish"),
    // });
    // timeCount();
    // c=0;
    // });
    $("#J_publish .fb-btn").click(function(){
        //layer.close(fbLay);
        // clearTimeout(t);
    });

});