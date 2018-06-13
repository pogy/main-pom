<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <title>登录</title>
    <style type="text/css">
        body{margin:0;padding:0;font-size:12px;background:url(//www.571xz.com:80/571_admin/images/login/bg.jpg) top repeat-x;}
        .input{width:150px;height:17px;border-top:1px solid #404040;border-left:1px solid #404040;border-right:1px solid #D4D0C8;border-bottom:1px solid #D4D0C8;}
    </style>

</head>

<body>
${error}
<form action="login.htm" method="post">


    <table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="200">&nbsp;</td>
        </tr>
        <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="423" height="280" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="//www.571xz.com:80/571_admin/images/login/ltop.jpg" /></td>
                        </tr>
                        <tr>
                            <td><span style="color: #d58512;font-size: xx-large">帮助中心后台登录</span></td>
                        </tr>
                    </table></td>
                    <td width="40" align="center" valign="bottom"><img src="//www.571xz.com:80/571_admin/images/login/line.jpg" width="23" height="232" /></td>
                    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td height="90" align="center" valign="bottom"><img src="//www.571xz.com:80/571_admin/images/login/ltitle.jpg" /></td>
                        </tr>
                        <tr>
                            <td>
                                <div>
                                </div>

                                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="5">

                                    <tr>
                                        <td width="91" height="40" align="right"><strong> 用户名：</strong></td>
                                        <td width="211"></td>
                                    </tr>

                                    <tr>
                                        <td height="40" align="right"><strong>密码：</strong></td>
                                        <td><input name="psw" type="password" id="psw" value="${psw}" maxlength="32" vld="{required:true}" class="input"/></td>
                                    </tr>
                                    <tr>
                                        <td height="40" colspan="2" align="center">
                                            <button>登录</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                    </tr>
                                </table>

                            </td>
                        </tr>
                    </table></td>
                </tr>

            </table></td>
        </tr>
    </table>
</form>

</body>
</html>