<div class="edit-recommend J_TModule" data-title="宝贝推荐" data-id="${moduleSet.moduleId!}">
    <div class="skin-box">
        <#if moduleSet.titleShow == 1>
        <div class="skin-box-hd">
            <h3>${moduleSet.title!}</h3>
        </div>
        </#if>
        <#if moduleSet.filter==1>
            <div style="border-bottom: 1px solid #eee; width: 100%; height: 28px; margin-bottom: 10px; background-color: #fff;">
                <span style="font-weight: bold; margin-left: 10px;">筛选：</span>
                <a href="/store/p/628368/search.htm?sort=5" style="display: inline-block; padding: 5px 10px; border-right: 1px solid #eee;">新品</a>
                <a href="/store/p/628368/search.htm?sort=2" style="display: inline-block; padding: 5px 10px; border-right: 1px solid #eee;">人气</a>
                <a href="/store/p/628368/search.htm?sort=3" style="display: inline-block; padding: 5px 10px; border-right: 1px solid #eee;">价格从低到高</a>
                <a href="/store/p/628368/search.htm?sort=4" style="display: inline-block; padding: 5px 10px; border-right: 1px solid #eee;">价格从高到低</a>
                <a href="/store/p/628368/search.htm" style="display: inline-block; padding: 5px 10px; float: right;">&lt;&lt;查看更多</a>
            </div>
        </#if>
        <div class="skin-box-bd">
            <ul class="clearfix goods-list" style="font-size: 0px">
                <#list promotes as p>
                <li class="li0"><a style="text-align: center; border: 1px dotted #eee" href="/item.htm?id=${p.itemId}" target="_blank">
                    <img style="display:block;margin: 0 auto;" class="lazy"
                         src="${p.imgUrl!}_400x400.jpg"
                         alt="${p.title!}"></a>
                    <div class="li-intro">
                        <#if moduleSet.showTitle == 1>
                            <div class="li-i1"><a href="/item.htm?id=${p.itemId}" target="_blank" style="color: #000">${p.title!}</a></div>
                        </#if>
                        <#if moduleSet.showGoodsNo == 1>
                            <div>货号：${p.goodsNo!}</div>
                        </#if>
                        <#if moduleSet.showPrice == 1>
                            <div class="li-i2"><span>￥</span><strong>${p.price!}</strong></div>
                        </#if>
                    </div>
                </li>
                </#list>
                <#if moduleSet.showPage==1>
                    <link rel="stylesheet" href="/design/css/common/page-link.css?t=20170314" />
                    <div class="page-link"><ul class="page-link-ul"><li class="disabled"><a>«</a></li><li class="current"><a>1</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=2">2</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=3">3</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=4">4</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=5">5</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=6">6</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=7">7</a></li><li><a href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=8">8</a></li><li><a title="下一页" href="/store/p/628368/search.htm?pageId=4285&sort=1&keyword=&size=16&lowPrice=&highPrice=&page=2">»</a></li></ul><span>1/9</span></div>
                </ul>
                </div>
                </#if>
            </ul>
        </div>
    </div>
    <script>
        //设置推荐图片的宽高自适应
        function tuijian(id) {
            var num = ${moduleSet.radio};
            //        console.log(id);
            var obj = $("div[data-id=" + id + "]");
            var allwidth = obj.width();
            //宽度是1190
            if (allwidth == 1190) {
                if (num == 4 || num == 5) {
                    allwidth = allwidth + 2;
                    var width = parseInt(allwidth / num);
                    width = width - 5;
                    obj.find(".li0").css("margin-right", "2px");

                }
                else if (num == 7) {
                    allwidth = allwidth + 6;
                    var width = parseInt(allwidth / num);
                    width = width - 6;
                    obj.find(".li0").css("margin-right", "3px");
                }
                obj.find(".goods-list").css("width", allwidth);
                obj.find(".li0 img").css("max-width", width).css("max-height", width);
                obj.find(".li0 img").css("max-height", width);
                obj.find(".li0 .li-intro .li-i1").css("width", width);
            }
//宽度是990
            if (allwidth == 990) {
                if (num == 4 || num == 5) {
                    allwidth = allwidth + 2;
                    var width = parseInt(allwidth / num);
                    width = width - 5;
                    obj.find(".li0").css("margin-right", "2px");

                }
                else if (num == 7) {
                    allwidth = allwidth;
                    var width = parseInt(allwidth / num);
                    width = width - 4;
                    obj.find(".li0").css("margin-right", "1px");
                }
                obj.find(".goods-list").css("width", allwidth);
                obj.find(".li0 img").css("max-width", width).css("max-height", width);
                obj.find(".li0 img").css("max-height", width);
                obj.find(".li0 .li-intro .li-i1").css("width", width);
            }
        }


        tuijian('${moduleSet.moduleId!}');
    </script>

</div>