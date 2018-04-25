$(function(){
	//input焦点事件
	$(".j_jd").focus(function(){
		$(this).css("border-color","#207dd3");
		$(this).next().css("color","#207dd3");
	})
	$(".j_jd").blur(function(){
		$(this).css("border-color","#fff");
		$(this).next().css("color","#bfc5ca");
	})

	//按钮验证事件
	$(".j_loginBtn").click(function(e){
		var user_v=$(".j_userN").val();
		var pass_v=$(".j_passW").val();
		if(user_v==""||user_v==null){
			$("#err_msg_div").css("display","block");
            $("#err_msg_div").text("请输入账号");
            return;
        }else{
			$("#err_msg_div").css("display","none");
		}

		if(pass_v==""||pass_v==null){
			$("#err_msg_div").css("display","block");
            $("#err_msg_div").text("请输入密码");
            return;
        }else{
			$("#err_msg_div").css("display","none");
		}
		$.post(daifa_host + "init/daifa/login.json",$("#login_form").serialize(),function (result) {
			if(!result.success){
                $("#err_msg_div").css("display","block");
                $("#err_msg_div").text(result.msg);
			}else {
                location.href = daifa_host + "init/login.htm"
            }
        })
	})
})