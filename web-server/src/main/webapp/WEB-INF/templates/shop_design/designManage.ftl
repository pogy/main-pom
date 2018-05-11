
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>页面管理 - 店铺装修 - 星座网</title>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/page.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <link rel="stylesheet" href="//www.571xz.com/design/theme/xzw/js/layer/skin/layer.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="//www.571xz.com/design/js/zclip/jquery.zeroclipboard.min.js"></script>

    <script type="text/javascript" src="//www.571xz.com/design/js/layer/layer.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/page.js"></script>
</head>
<body>
<div class="page-main">
    <div class="vl-sidebar">
        <ul id="pages-manage-left">
            <li class="selected">
                <a class="" href="javascript:;">
                    <span class="line"></span>
                    <span class="content">电脑端页面</span>
                </a>
            </li>
            <li>
                <a class="" href="javascript:;">
                    <span class="line"></span>
                    <span class="content">手机端页面敬请期待</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="page-list-wrap">
        <div class="page-title">
            <div><a class="create-new-page  new-page" href="javascript:;">新建页面</a></div>
        </div>
        <div class="pages-table">
            <ul class="page-type-tab  clearfix">
                <li class="page-type current-page-type" data-type="1">首页</li>
                <li class="page-type" data-type="2">自定义页</li>
            </ul>
            <div class="page-list">
                <table class="table-show" data-type="1">
                    <thead>
                    <tr>
                        <th width="20%">页面名称</th>
                        <th width="40%">页面地址</th>
                        <th width="20%">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                    <#list pages as page>
                        <#if page.type != 3>
                        <tr data-id="111">
                            <td>${page.name!}</td>
                            <td>
                                <a class="copy J_TCopy" href="javascript:void(0);">复制</a>
                                <span>${page.href!}</span>
                                <span class="hidden">复制成功</span>
                            </td>
                            <td><span>
                            <a href="/seller/design.htm?pageId=${page.pageId!}">装修</a>
                        </span>
                            </td>
                        </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
                <table class="" data-type="2">
                    <thead>
                    <tr>
                        <th width="20%">页面名称</th>
                        <th width="40%">页面地址</th>
                        <th width="20%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pages as page>
                        <#if page.type == 3>
                        <tr data-id="111">
                            <td>${page.name!}</td>
                            <td>
                                <a class="copy J_TCopy" href="javascript:void(0);">复制</a>
                                <span>${page.href!}</span>
                                <span class="hidden">复制成功</span>
                            </td>
                            <td>
                                <span>
                                    <a href="/seller/design.htm?pageId=${page.pageId!}">装修</a>
                                    <a class="page-del" data-id="${page.pageId!}" href="javascript:;">删除</a>
                                </span>
                            </td>
                        </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>
<script language="JavaScript">
    $(function () {
        var config = {
            "copy": function (e) {
                var content = $(this).next().html();
                e.clipboardData.clearData();
                e.clipboardData.setData("text/plain", content);
                e.preventDefault();
            },
            "beforecopy": function (e) {

            },
            "aftercopy": function (e) {
                // alert('复制成功');
                $(this).next().next().show();
                $(this).next().next().delay("2000").hide(0);
            },
        };
        $("body").on(config, ".copy");
    });
</script>
</html>