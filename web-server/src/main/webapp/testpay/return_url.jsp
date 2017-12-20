<%@ page import="java.util.Map" %>
<%@ page import="com.alipay.api.internal.util.AlipaySignature" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.alipay.api.AlipayApiException" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    Map<String, String[]> paramsMap =  request.getParameterMap();
    Map<String, String> paramsMap1 = new HashMap<String, String>();
    for (Map.Entry<String, String[]> item : paramsMap.entrySet()) {
        out.print(item.getKey() + "=====" + item.getValue()[0] + "<br/>");
        paramsMap1.put(item.getKey(), item.getValue()[0]);
    }
    try {
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap1, ALIPAY_PUBLIC_KEY, "utf-8", "RSA2") ;//调用SDK验证签名
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            out.print("验签成功");
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            out.print("验签失败");
        }
    } catch (AlipayApiException e) {
        e.printStackTrace();
    }

%>

</body>
</html>
