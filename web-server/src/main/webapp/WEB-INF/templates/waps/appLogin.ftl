<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<meta charset="utf-8">
<title>登录-四季星座网</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0">
<link href="http://style.571xz.com/h5te/css/appLogin.css" rel="stylesheet">
<#include "/common/host_config.ftl">

<body>
<script>/*============ h5te/page#layout BEGIN ============*/

'${userId!}';
(function (doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function () {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                if(clientWidth>=640){
                    docEl.style.fontSize = '100px';
                }else{
                    docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';
                }
            };

        if (!doc.addEventListener) return;
        recalc();
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);

/*============ h5te/page#layout END ============*/


</script><div class="appLoginWeb">
    <div class="appLogo"><img src="http://style.571xz.com/h5te/css/img/appLogo.png" /></div>
    <form action="" id="formLogin">
        <div class="srInfo">
            <label><span>手机号码</span><input type="text" name="phone" id="phone"/></label>
            <label class="checkCode"><span>短信校验码</span><input type="text" name="ckCode" id="ckCode"  /></label>
            <button class="getCkCode" jbtn="getCkCode" type="button">获取短信校验码</button>
            <input type="hidden" name='openIid' value="${openIid!}" />
            <input type="hidden" name='backUrl' value="${backUrl!}" />
        </div>
        <button type="button" jbtn="loginBtn" class="loginBtn">登录</button>
    </form>
</div>
<script>/*============ h5te/appLogin#main BEGIN ============*/

var errorTip = '${errorTip!}';

/*============ h5te/appLogin#main END ============*/


</script>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/h5te/js/appLogin.js"></script>
<#include "/common/cnzz.ftl">
</body>
</html>