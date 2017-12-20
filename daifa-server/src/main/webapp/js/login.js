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
			$(".j_userError").css("display","block");
		}else{
			$(".j_userError").css("display","none");
		}

		if(pass_v==""||pass_v==null){
			$(".j_passError").css("display","block");
		}else{
			$(".j_passError").css("display","none");
		}
	})
})