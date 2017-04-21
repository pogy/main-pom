
$(document).ready(function() {
    $(".c_all_tit").mouseover(function(){
        $(this).find(".show-down").addClass("opposite");
        $(this).find(".con_bg").show();
        $(this).find(".con_bg .con").show();
    });
    $(".c_all_tit").mouseleave(function(){
        $(".show-down",this).removeClass("opposite");
        $(".con_bg").hide();
    });
    $(".c_all_tit a").hover(function () {
        $(".show-down",this).toggleClass("opposite");

    });


    //
    $(".top_menu").mouseover(function () {
        $(this).addClass("hover");
    });

    $(".top_menu").mouseleave(function () {
        $(this).removeClass("hover");
    });


    //����ȥ��ʾ

    $(".shop-information").mouseover(function () {
        $(".show-down", this).css("transform", "rotate(180deg)");
        $(".show-down", this).css("-webkit-transform", "rotate(180deg)");
        $(".show-down", this).css("filter", "progid:DXImageTransform.Microsoft.BasicImage(rotation=2)");
        $(".shop-msg").show();
    });
    $(".shop-information").mouseout(function () {
        $(".show-down", this).css("transform", "rotate(0deg)");
        $(".show-down", this).css("-webkit-transform", "rotate(0deg)");
        $(".shop-msg").hide();

    });



    //����
    $('.mlc-title em').click(function () {
        $(this).parents('ul').next().children('li.list').slideToggle(500);
        $(this).parent().toggleClass('mlc-show');

        if($(this).parent().hasClass('mlc-show')){
            $(this).text('-');
        }else{
            $(this).text('+');
        }
    });


    $('.mr-title a').eq(1).click(function () {
        $('.m-search').toggle();
        if($('.m-search').css('display') == 'block'){
            $('i',this).css('transform','rotate(180deg)');
        }else{
            $('i',this).css('transform','rotate(0deg)');
        }
    });

    $('.has-droplist').mouseover(function () {
        $(this).addClass('has-droplist-hover');
    });


    $('.has-droplist').mouseleave(function () {
        $(this).removeClass('has-droplist-hover');
    });


    //ʱ��ɸѡ
    $("#alltime").hover(function(){
        $(this).addClass("location-hover");
    },function(){
        $(this).removeClass("location-hover");
    });


    //�Զ���
    $(".J_defind").click(function(){
        $("#sec_date").show();
    });

    //ȡ������
    $("#sec_date .cal").click(function(){
        $(this).parent("#sec_date").hide();

    })


});