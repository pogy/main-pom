
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>消息提示-四季星座网</title>
    <style>
        body{background-color: #F6F6F6;font: 12px/20px "Microsoft YaHei","微软雅黑", helvetica, arial, verdana, tahoma, sans-serif;}
        .msg{background-color: #fff;border: 1px solid #ebebeb;width: 760px;margin: 150px auto 0;padding: 100px 0;text-align: center;color: #666;font-size: 14px;}
        .msg h3{font-size: 24px;font-weight: 400;color: #555;}
        .time a{color: #36c;text-decoration: none;margin-left: 5px;}
        .sc{background-color: #f40;color: #fff;text-decoration: none;display: inline-block;height: 26px; line-height: 26px;width: 80px;text-align: center;margin:0 10px;}
        .close{background-color: #fff;color: #666;text-decoration: none;display: inline-block;height: 26px; line-height: 26px;width: 80px;text-align: center;margin:0 10px;border: 1px #ccc solid;}
    </style>
</head>
<body>
<div class="msg">
    <h3>亲，您已上传过该商品！</h3>
    <p class="time">上传时间：${lastup.lastTime?string('yyyy-MM-dd HH:mm:ss')}<a href="https://item.taobao.com/item.htm?id=${lastup.numIid}">查看宝贝</a></p>
    <p><a href="/publish.htm?id=${goodsId}&yesrepeat=1" class="sc">继续上传</a><a href="javascript:window.opener=null;window.open(&#39;&#39;,&#39;_self&#39;);window.close();" class="close">关闭页面</a></p>
</div>
<div style="display:none">
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " //");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255319538'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1255319538' type='text/javascript'%3E%3C/script%3E"));</script>
    <script src="//s6.cnzz.com/stat.php?id=1697486&amp;web_id=1697486" language="JavaScript"></script>
</div>
</body></html>