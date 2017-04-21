/*
 * Created by renhuimin on 2016/9/26.
 */
//拿到登录状态
function info() {
    var h = '/member/login.htm?f=top&amp;redirectURL=http%3A%2F%2F' + location.host + '%2F';
    var e = '/member/reg.htm?f=top';
    var k = '/callback/login.htm?type=1&redirectURL=http%3A%2F%2F' + location.host + '%2F';
    var s = '/shop/home.htm';
    var d = '/member/home.htm';
    var ej='/provider/buy.htm';
    var r = '/member/login.htm?act=logout&redirectURL=http%3A%2F%2F' + location.host + '%2F';
    var tname;
    var cart;
    var type;
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; "); //分号分隔
    //console.log( arrCookie);
    var cook = [];
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        if ("ltype" == arr[0]) {
            return arr[1];
        }
        cook.push(arr);
    }
//循环cook 拿到对应想要的键值
    for (var j = 0; j < cook.length; j++) {
        if (cook[j][0] == 'cart_num') {
            cart = cook[j][1];
        }
        else if (cook[j][0] == 'tracknick') {
            tname = cook[j][1];
        }
        else if (cook[j][0] == 'usertype') {
            type = cook[j][1];
        }
    }


    if (type == '1') {
        $("#dl").show();
        $("#dl").next().show();
        $("#scj").show();
        $("#scj").next().show();
        $(".sjb").show();
        $(".sjb").next().show();
        $(".gwc").show();
        $(".gwc").next().show();
    }
    else if (type == '2') {
        $("#dk").show();
        $("#dk").next().show();

    }
    else if(type=='3'){
        $("#ej").show();

    }
    else {
        $("#dl").show();
        $("#dl").next().show();
        $("#scj").show();
        $("#scj").next().show();
        $(".sjb").show();
        $(".sjb").next().show();
        $(".gwc").show();
        $(".gwc").next().show();
        $("#dk").show();
        $("#dk").next().show();
        // $("#ej").show();
    }

//将拿到的值解码
    var nname = decodeURI(tname);

    //console.log( nname);
    var html = "";
    if (nname != 'undefined') {
        if (type == "1") {
            html += '<span><a target="_top" href ="' + d + '">' + nname + '</a><a target="_top" href="' + r + '" id="J_Logout">退出</a></span>'
        }
        else if (type == "2") {
            html += '<span><a target="_top" href ="' + s + '">' + nname + '</a><a target="_top" href="' + r + '" id="J_Logout">退出</a></span>'
        }
        else if(type=="3"){
            html += '<span><a target="_top" href ="' + ej + '">' + nname + '</a><a target="_top" href="' + r + '" id="J_Logout">退出</a></span>'
        }
        else {
            html += '<a href="' + h + '" target="_top">登录</a>&nbsp;<a href="' + e + '" target="_top">注册</a><a href="' + k + '" target="_top" class="tbdl">淘宝登录</a>'
        }
    }
    else{
        html+='<a href="'+h+'" target="_top">登录</a>&nbsp;<a href="'+e+'" target="_top">注册</a><a href="'+k+'" target="_top" class="tbdl">淘宝登录</a>'
    }

    $(".user").html(html);

    $("#T_cartnum").html(cart);
    $("#J_cart_num").html(cart);

}

$(document).ready(function(){
    info();
    //顶部下拉框
    $(".site-nav dl.top_menu").mouseover(function(){
        $(this).addClass("hover");

    });
    $(".site-nav dl.top_menu").mouseleave(function(){
        $(this).removeClass("hover");
    });
    //搜图相关的
    $(".J_searchpic").click(function(){
        $(".search-pic-pop").show();
    });
    //搜图关闭
    $(".search-pic-pop .close").click(function(){
        $(".search-pic-pop").hide();
    });
    //本地上传图片
    $("body").on("change", ".search-pic-pop .file-input", function() {

        var objUrl = getObjectURL(this.files[0]);

        console.log(objUrl);

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

});

$(document).delegate("#J_SearchTab li","click",function(){
    $(this).addClass("search-on");
    $(this).siblings().removeClass("search-on");
    $("#J_TSearchForm").find( "input[name='search_type']").attr('value', $(this).attr("data_type"));
});


//旗舰店标签鼠标显示层
$(function(){
    $(".shopIcon .icon-top").mousemove(function(){
        $(".shopIcon .tri").hide();
        $(".shopIcon .fs-tip").hide();
        $(this).find("i").show();
        $(this).find(".fs-tip").show()
    });
    $(".shopIcon .fs-tip").mouseleave(function(){
        $(this).hide();
        $(this).siblings("i").hide();
    });
    $(".shopIcon .icon-top").mouseleave(function(){
        $(".shopIcon .tri").hide();
        $(".shopIcon .fs-tip").hide();
    });
});
