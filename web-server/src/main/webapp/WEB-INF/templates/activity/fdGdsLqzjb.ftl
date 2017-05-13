<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0">
<link href="http://style.571xz.com/h5te/css/fdGdsLqzjb.css?t=1494673249147" rel="stylesheet">
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


</script><div class="wrapper">
    <form id="formSub" action="" method="post">
        <div class="innerbox">
            <input type="text" name="tnick" id="tbNc" /><button type="button" onclick="sureGet()" jbtn="sureGet">查询</button>
        </div>
    </form>
    <div class="info"></div>
</div>
<script src="http://style.571xz.com/global/js/jquery.js"></script>
<script src="http://style.571xz.com/h5te/js/fdGdsLqzjb.js?t=1494673249147"></script>
</body>
</html>