<!DOCTYPE html>
<html>
<head>
    <title>商品推荐-模块编辑-网商园</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/design/css/shop/design/option.css?t=20161219A"  type="text/css"/>
    <link rel="stylesheet" href="/design/css/common/page-link.css?t=20161219" />
</head>
<body>
<div>
    <span class="J_TManualRecMsg manual-rec-msg msg disappear">
        <i class="msg-icon"></i><span class="text"></span>
    </span>
    <div class="item-srch">
        <div class="srch-conds clearfix">
            <form action="" method="get">
                <input type="hidden" name="id" value="${bo.id}">
                <input type="hidden" name="area" value="${bo.area}">
                <div class="control-group srch-cond keyword">
                    <div class="control">
                        <span>筛选：</span>
                        <input placeholder="关键字" class="J_TKeywordInput" name="q" type="text" value="${bo.q!}" autocomplete="off">
                    </div>
                </div>
                <div class="control-group srch-cond price" style="margin-left: 10px;">
                    <div class="control">
                        <label>
                            <span>价格：</span>
                            <input class="low-price-input J_TPriceInput" name="lowPrice" type="text" value="${bo.lowPrice!}">
                            <span>-</span>
                            <input class="high-price-input J_TPriceInput" name="highPrice" type="text" value="${bo.highPrice!}">
                        </label>
                    </div>
                </div>
                <div class="control-group srch-action">
                    <input type="submit" class="srch-btn J_TSrchBtn" value="" style="border: 0;" />
                    <span style="display: none;" data-pjax data-url data-view=".manual-rec-content">Search</span>
                </div>
            </form>
        </div>
        <div class="items-count">
            <a class="want-opt <#if bo.type == 1>selected</#if>" href="?id=${bo.id}&area=${bo.area}&type=1"
               style="display:inline-block;min-width: 60px; text-align: center; padding: 1px 3px;">全部商品(${pager.totalCount})</a>
            <a class="want-opt <#if bo.type == 2>selected</#if>" href="?id=${bo.id}&area=${bo.area}&type=2"
               style="display:inline-block;min-width: 60px; text-align: center; padding: 1px 3px;">已推荐(<span id="tuiCount">${promotes.totalCount}</span>)</a>
            <span style="margin-left: 5px; color: gray;">
                                最多可推荐16个商品
                            </span>
        </div>
    </div>
    <#if bo.type == 2>
        <#assign pager = promotes>
    </#if>
    <!-- 手动推荐 -->
    <div class="form_nav2_con" style="width: calc(100% - 50px);">
        <ul class="all">
            <#list pager.content as item>
            <li class="clearfix" style="height: 45px;">
                <div class="img clearfix" style="background-color: #fff;">
                    <a href="/item.htm?id=4014162" target="_blank">
                        <img src="${item.imgUrl!}" alt="${item.title!}">
                    </a>
                </div>
                <div class="intro clearfix">
                    <div class="i1">
                        <a href="/item.htm?id=${item.itemId!}" target="_blank">${item.title!}</a>
                    </div>
                    <div style="margin-top: 2px;">
                        <span>货号：${item.goodsNo!}</span>
                    </div>
                    <div class="i2" style="margin-top: 2px;">
                        ￥${item.price!}                                            </div>
                </div>
                <div class="fnbtn clearfix">
                    <a href="javascript:;" data-item="${item.itemId!}" class="tj" data-type="1">推荐</a>
                </div>
            </li>
            </#list>
            <#if pager.content?size == 0>
                <li class="clearfix">
                    <span>抱歉，没有商品哦~</span>
                </li>
            </#if>
        </ul>
        <ul class="done"></ul>
    </div>
    <!-- 翻页 -->
    <#if pager.content?size gt 0>
    <div class="editpage clearfix" style="margin-top: 25px;">
        <div class="page-link">

            <ul class="page-link-ul">
                <li<#if pager.number == 1> class="disabled"><a href="javascript:;">«</a><#else>><a title="上一页" href="?size=5&id=${bo.id!}&area=${bo.area!}&type=${bo.type!}&page=${pager.number - 1}">«</a></#if></li>
                <#list 1..pager.totalPages as p>
                    <#if p gt 0>
                    <li <#if pager.number == p>class="current"><a href="javascript:;">${p}</a><#else>><a href="?size=5&id=${bo.id!}&area=${bo.area!}&type=${bo.type!}&page=${p}">${p}</a></#if></li>
                    </#if>
                </#list>
                <li<#if pager.number &gt;= pager.totalPages> class="disabled"><a href="javascript:;">»</a><#else>><a title="下一页" href="?size=5&id=${bo.id!}&area=${bo.area!}&type=${bo.type!}&page=${pager.number + 1}">»</a></#if></li>
            </ul>
            <span>${pager.number!}/${pager.totalPages}</span>
        </div>
    </div>
    </#if>
</div>
<script type="text/javascript" src="/design/js/jquery-min.js"></script>
<script type="text/javascript">
    $(function(){
        $('.tj').click(function() {
            var _this = $(this),
                    mid = '${bo.id}',
                    id = _this.data('item'),
                    area = '${bo.area!}',
                    type = '2',
                    mode = _this.data('type');
            if (mode == 1) {
                $.ajax({
                    url: '/seller/design/design-option/goods-tui-set-goods.json',
                    type: 'POST',
                    data: { 'id':id,'area':area,'type':type,'mid':mid },
                    dataType: 'json',
                    success: function(d){
                        if (d.status == 0) {
                            _this.data('type', 2);
                            _this.html('取消推荐');
                            var num = parseInt($('#tuiCount').text());
                            $('#tuiCount').text(num+1);
                        } else {
                            alert(d.message);
                        }
                    }
                });
            } else {
                $.ajax({
                    url: '/seller/design/design-option/goods-tui-del-goods.json',
                    type: 'POST',
                    data: { 'id':id,'area':area,'type':type,'mid':mid },
                    dataType: 'json',
                    success: function(d){
                        if (d.status == 0) {
                            _this.data('type', 1);
                            _this.html('推荐');
                            var num = parseInt($('#tuiCount').text());
                            $('#tuiCount').text(num-1);
                        } else {
                            alert(d.message);
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>