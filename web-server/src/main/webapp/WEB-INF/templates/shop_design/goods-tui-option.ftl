<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>模块编辑 - 星座网</title>
    <link rel="stylesheet" href="//www.571xz.com/design/css/shop/design/option.css?t=20161219A"  type="text/css"/>
    <script type="text/javascript" src="//www.571xz.com/design/js/jquery-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/s/editor/kindeditor-min.js"></script>
    <script type="text/javascript" src="//www.571xz.com/design/js/shop/design/shop_design.js"></script>
</head>
<body>
<form id="module-options">
    <input type="hidden" name="moduleId" value="${moduleSet.moduleId}">
    <input type="hidden" name="areaId" value="${moduleSet.areaId}">
    <input type="hidden" name="sideType" value="${moduleSet.sideType}">
    <div>
        <div class="edit-recommend" id="edit-recommend">
            <div class="content">
                <div class="tips">您可以通过系统自动推荐或者手动选择最多16个店铺内宝贝，通常可以用于畅销商品、最新上架的商品推荐等场景</div>
                <div class="tab">
                    <ul class="nav clearfix" role="tablist">
                        <li class="first  selected" role="tab" id="ks-switchable1"><span>宝贝设置</span></li>
                        <li role="tab" id="ks-switchable2"><span>电脑端显示设置</span></li>
                    </ul>
                    <div class="J_TItemRecommendForm item-recommend-form form-default">
                        <div class="panels">
                            <div class="panel" role="tabpanel" aria-labelledby="ks-switchable1">
                                <div class="control-group rec-type">
                                    <label class="control-label">推荐方式：</label>
                                    <!--表单域-->
                                    <div class="control">
                                        <label>
                                            <input class="J_TRecType input-radio auto-rec" type="radio" name="promoteType"
                                                   value="1" <#if moduleSet.promoteType==1>checked</#if>> 自动推荐
                                        </label>
                                        <label>
                                            <input class="J_TRecType input-radio manual-rec" type="radio" name="promoteType"
                                                   value="2" <#if moduleSet.promoteType==2>checked</#if>> 手工推荐
                                        </label>
                                    </div>
                                </div>
                                <div class="auto-rec-content">
                                    <div class="control-group J_sort">
                                        <label class="control-label">自动推荐排序：</label>
                                        <div class="control">
                                            <select class="input-box" name="sort">
                                                <option value="1" <#if moduleSet.sort==1>selected</#if>>综合排序</option>
                                                <option value="2" <#if moduleSet.sort==2>selected</#if>>新品排序</option>
                                                <option value="3" <#if moduleSet.sort==3>selected</#if>>人气排序</option>
                                                <option value="4" <#if moduleSet.sort==4>selected</#if>>价格最低在前</option>
                                                <option value="5" <#if moduleSet.sort==5>selected</#if>>价格最低在后</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="control-group" style="display: none;">
                                        <label class="control-label">宝贝分类：</label>
                                        <div class="control">
                                            <select name="category" class="input-box" style="z-index: 1;">
                                                <option class="cat" value="-1" selected="selected">所有分类</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">关键字：</label>
                                        <div class="control">
                                            <input class="input-box J_keyword" type="text" value="${moduleSet.keyword!}"
                                                   name="keyword"
                                                   autocomplete="off">
                                    <span class="J_TMsg msg disappear">
                                        <i class="msg-icon"></i><span class="text"></span>
                                    </span>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">价格范围：</label>

                                        <div class="control">
                                            <input class="input-box short J_TPriceInput" type="text" name="lowerLimitPrice"
                                                   value="${moduleSet.lowerLimitPrice!}">
                                            <span>-</span>
                                            <input class="input-box short J_TPriceInput" type="text" name="upperLimitPrice"
                                                   value="${moduleSet.upperLimitPrice!}">
                                            <span>元</span>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">列表分页：</label>
                                        <div class="control">
                                            <select name="showPage" class="input-box" style="z-index: 1;">
                                                <option class="cat" value="1" <#if moduleSet.showPage==1>selected="selected"</#if>>显示</option>
                                                <option class="cat" value="0" <#if moduleSet.showPage==0>selected="selected"</#if>>隐藏</option>
                                            </select>
                                    <span style="color: gray; margin-left: 10px;">
                                        只有"自动推荐"才会显示分页哦~
                                    </span>
                                        </div>
                                    </div>
                                    <div class="control-group item-num">
                                        <label class="control-label">宝贝数量：</label>
                                        <div class="control">
                                            <div class="auto-item-num J_TAutoItemNumSet">
                                                <select class="input-box item-num J_TItemNumSelect" name="itemNum">
                                                    <option value="3" <#if moduleSet.itemNum==3>selected</#if>>3</option>
                                                    <option value="4" <#if moduleSet.itemNum==4>selected</#if>>4</option>
                                                    <option value="6" <#if moduleSet.itemNum==6>selected</#if>>6</option>
                                                    <option value="8" <#if moduleSet.itemNum==8>selected</#if>>8</option>
                                                    <option value="10" <#if moduleSet.itemNum==10>selected</#if>>10</option>
                                                    <option value="12" <#if moduleSet.itemNum==12>selected</#if>>12</option>
                                                    <option value="16" <#if moduleSet.itemNum==16>selected</#if>>16</option>
                                                </select>
                                        <span class="J_TMsg msg disappear"><i class="msg-icon"></i><span
                                                class="text"></span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div style="margin-bottom: 10px;">
                                    <label class="control-label">显示设置：</label>
                                    <div class="control">
                                        <label><input type="checkbox" <#if moduleSet.showTitle==1>checked</#if> data-show-title> 标题 </label>
                                        <input type="hidden" name="showTitle" value="${moduleSet.showTitle}">
                                        <label><input type="checkbox" <#if moduleSet.showGoodsNo==1>checked</#if> data-show-goodsid> 货号 </label>
                                        <input type="hidden" name="showGoodsNo" value="${moduleSet.showGoodsNo}">
                                        <label><input type="checkbox" <#if moduleSet.showPrice==1>checked</#if> data-show-price> 批发价 </label>
                                        <input type="hidden" name="showPrice" value="${moduleSet.showPrice}">
                                    </div>
                                </div>
                                <div class="manual-rec-content clearfix" style="display: none;">
                                    <iframe style="border: 0; width: 100%; height: 480px;" src="/seller/design/goods-tui-get-goods-list.htm?size=5&mid=${moduleSet.moduleId}&area=${moduleSet.areaId}&type=1">                            </iframe>
                                </div>
                            </div>
                            <!--显示设置开始-->
                            <div class="panel hidden" role="tabpanel" aria-labelledby="ks-switchable2">
                                <div class="control-group clearfix">
                                    <label class="control-label">显示标题：</label>
                                    <div class="control show-title">
                                        <label>
                                            <input type="radio" class="J_TNotShowTitle input-radio" name="titleShow" value="0" <#if moduleSet.titleShow==0>checked</#if>
                                            >
                                            不显示</label>
                                        <label>
                                            <input type="radio" class="J_TShowTitle  show-title-true input-radio"
                                                   name="titleShow"
                                                   value="1" <#if moduleSet.titleShow==1>checked</#if>> 显示</label>
                                        <input class="J_TTitleInput input-box title-input" type="text" maxlength="30"
                                               name="title" value="${moduleSet.title!}">
                                    </div>
                                </div>
                                <div class="control-group clearfix">
                                    <label class="control-label">展示方式：</label>

                                    <div class="control clearfix">

                                        <dl class="itemsLayout line-item4">
                                            <dt class="itemsLayoutShot <#if moduleSet.radio==4>dtselected</#if>">
                                                <a href="#" class="J_itemsLayoutTrigger" data-value="230" data-layout="950">
                                                    <span></span>
                                                </a>
                                                <input type="radio" name="radio" <#if moduleSet.radio==4>checked</#if>                                               value="4" style="display: none"/>
                                            </dt>
                                            <dd>
                                                <span>一行展示4个宝贝</span>
                                            </dd>
                                        </dl>
                                        <dl class="itemsLayout line-item5">
                                            <dt class="itemsLayoutShot <#if moduleSet.radio==5>dtselected</#if>">
                                                <a href="#" class="J_itemsLayoutTrigger" data-value="180" data-layout="950">
                                                    <span></span>
                                                </a>
                                                <input type="radio" name="radio" <#if moduleSet.radio==5>checked</#if>     value="5" style="display: none"/>
                                            </dt>
                                            <dd>
                                                <span>一行展示5个宝贝</span>
                                            </dd>
                                        </dl>
                                        <dl class="itemsLayout line-item7">
                                            <dt class="itemsLayoutShot <#if moduleSet.radio==7>dtselected</#if>">
                                                <a href="#" class="J_itemsLayoutTrigger" data-value="130" data-layout="950">
                                                    <span></span>
                                                </a>
                                                <input type="radio" name="radio" <#if moduleSet.radio==7>checked</#if>     value="7" style="display: none"/>
                                            </dt>
                                            <dd>
                                                <span>一行展示7个宝贝</span>
                                            </dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="control-group clearfix">
                                    <label class="control-label">显示筛选：</label>
                                    <div class="control clearfix">
                                        <label><input type="radio" name="filter" value="0" <#if moduleSet.filter==0>checked</#if>> 不显示</label>
                                        <label><input type="radio" name="filter" value="1" <#if moduleSet.filter==1>checked</#if>> 显示</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('[name=promoteType]:checked').click();
            });
            function handler() {
                var title = $('[data-show-title]').attr('checked') == undefined ? 0 : 1;
                var goodsid = $('[data-show-goodsid]').attr('checked') == undefined ? 0 : 1;
                var price = $('[data-show-price]').attr('checked') == undefined ? 0 : 1;

                $('[name="showTitle"]').val(title);
                $('[name="showGoodsNo"]').val(goodsid);
                $('[name="showPrice"]').val(price);
            }
        </script>
    </div>
</form>
<div class="opt-footer" style="margin-bottom: 15px;">
    <a href="javascript:;" class="btn-ok" id="module-options-save">保存</a>
    <a href="javascript:;"  class="btn-cancel" id="module-options-cancel">取消</a>
    <span class="J_TMsg msg disappear"><i class="msg-icon"></i><span class="text">您有未完成的输入框</span></span>
</div>
<script type="text/javascript">
    $(function () {
        var index = parent.layer.getFrameIndex(window.name);
        $('#module-options-save').click(function () {
            var edtype=$("#module-options").find(".nav li.selected").attr("type");
            edtype=parseInt(edtype)-1;
            var obj=$("#module-options").find(".panel:eq("+edtype+")");
            var idx=false;
            obj.find("input[type=text]").each(function(){

                // console.log($(this).attr("value"));
                if($(this).attr("value")==""){

                    idx=true;
                }
            });
            //大图片
            $("#edit-bigpic").find("input[type=text]").each(function(){
                if($(this).attr("value")==""){
                    idx=true;
                }
            });
//注释了判断input 框为空
//            if(idx){
//                $(this).parent().find(".J_TMsg").removeClass("disappear");
//                $(this).parent().find(".J_TMsg").addClass("failure");
//            }
//            else {
            // 处理器是否存在
            if (typeof handler === 'function') {
                handler();
            }
            var params = $('#module-options').serialize();
            $.ajax({
                url: '/seller/design/savePromoteOption.htm',
                type: 'POST',
                data: params,
                // dataType: 'json',
                success: function (d) {
                    parent.$('[data-id=${moduleSet.moduleId}]').html(d);
//                        console.log(d);
                    parent.layer.close(index);
//                       parent.location.reload();
                },
                error: function (e) {
                }
            });

//            }
        });

        $('#module-options-cancel').click(function () {
            parent.layer.close(index);

        });
    });
</script>
</body>
</html>