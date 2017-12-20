<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form name="punchout_form" method="post" action="https://openapi.alipay.com/gateway.do?charset=utf-8&method=alipay.trade.page.pay&sign=Kar9pTE6Eolg%2BCLJJMcL3K1KJ%2BmR1tpmyDcJZToY%2BsjLavg5VsclL0SxE5LOTn8luTM2yDVHEuuuiZZHiiok9m3mXX%2BftmLABVv1XvgbxtILr9q3qa5dk%2B452lQjTjGT5gcJ3noSby5xZ%2FbFvj%2BAuHZvzM%2FiITxuYm4rYN%2FZQmY%3D&return_url=http%3A%2F%2Fwww.571xz.com%2Ftestpay%2Freturn_url.jsp&notify_url=http%3A%2F%2Fdomain.com%2FCallBack%2Fnotify_url.jsp&version=1.0&app_id=2017062007531060&sign_type=RSA&timestamp=2017-06-27+12%3A49%3A54&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json">
    <input type="hidden" name="biz_content" value="{    &quot;out_trade_no&quot;:&quot;5&quot;,    &quot;product_code&quot;:&quot;FAST_INSTANT_TRADE_PAY&quot;,    &quot;total_amount&quot;:0.01,    &quot;subject&quot;:&quot;iphone 6plus 手机&quot;  }">
    <input type="submit" value="立即支付" style="display:none" >
</form>
<script>document.forms[0].submit();</script>

</body>
</html>
