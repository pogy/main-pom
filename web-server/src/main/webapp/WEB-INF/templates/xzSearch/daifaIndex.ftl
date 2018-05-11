<#assign $pageid="daifaIndex">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>一件代发，您身边的服务</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/common__form_css.ftl">
<#include "/__style_torrent__/xzSearch__common_css.ftl">
<#include "/__style_torrent__/xzSearch__daifaIndex_css.ftl">
    <script src="//style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/xzSearch__daifaIndex_js.ftl">
</head>
<body>
<#list [{}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#assign headerTitle=null>
<#assign searchType="goods">
<#include "/common/xz__searchHeader.ftl">
<#include "/__ftl_links__/xzSearch__common__pageNav.ftl">
<div class="banner">
    <div class="layout pr">
<div class="notice pa yahei">
    <h2 class="fs18">【公告】</h2>
    <h3 class="fs16 fc3">四季星座网一件代发功能，您身边的服务</h3>
    <p>四季星座网致力于为您提供高效、优质的服务。在使用过程中有任何问题、意见与建议，请与客服联系。我们会及时跟进解决。</p>
    <p>目前代发开通的市场：电商基地，四季星座，钱塘大厦。</p>
    <ul>
        <li><a href="//www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后悠悠&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺1</span></a></li>
        <li><a href="//www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后小匀&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺2</span></a></li>
        <li class="last"><a href="//www.taobao.com/webww/ww.php?ver=3&amp;touid=杭州石谷网络科技有限公司:售后慧慧&amp;siteid=cntaobao&amp;status=1&amp;charset=utf-8" target="_blank"><i class="icon-s-aliww"></i><span>代发旺旺3</span></a></li>
    </ul>
    <p class="serviceTime">服务时间 :  9:00-18:00  （周六，周日不休息）</p>
    <p class="tac tel"><i class="icon-s-phone"></i><span>0571-86070380</span></p>
<#list [{}] as $it>
    <#if $it.href??>
    <a href="${$it.href!}"
    <#else>
    <button type="button"
    </#if>
    class="fmButton
         fmButton-orange
         toMyOrders"
        <#if $it.disabled == true>disabled="disabled"</#if>
        <#if $it.dataId??>
            data-id="${$it.dataId!}"
        </#if>
        <#if $it.title??>
            title=""
        </#if>
        <#if $it.id??>
            id=""
        </#if>
>
        我的代发订单
    <#if $it.href??>
    </a>
    <#else>
    </button>
    </#if>
</#list>
</div>
    </div>
</div>
<div class="advantage listBox">
    <div class="layout yahei">
        <div class="title"></div>
        <div class="advList">
            <ul>
                <li>
                    <span class="icon-fbkj"></span>
                    <h3>方便快捷</h3>
                    <p>支持手动下单与淘宝同步一键下单<br>两种方式可根据需要任意选择</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-jsfh"></span>
                    <h3>发货及时</h3>
                    <p>一般每日16点前下的不缺货订单<br>保证当天发货</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-fwbz"></span>
                    <h3>服务保障</h3>
                    <p>强大的客服团队<br>提供优质服务，保障客户利益。</p>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="progress listBox">
    <div class="layout yahei">
        <div class="title title-progress"></div>
        <div class="proList">
            <ul>
                <li>
                    <span class="icon-tjdd"></span>
                    <h3>1、提交订单</h3>
                    <p>添加需要代发的商品，完善收货地址，提交订单</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-qrdd"></span>
                    <h3>2、确认订单</h3>
                    <p>核对包裹的商品及收件人信息准确无误</p>
                </li>
                <li class="icon-step"></li>
                <li>
                    <span class="icon-wcjs"></span>
                    <h3>3、完成结算</h3>
                    <p>结算该笔订单代发安排发货</p>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="problems listBox">
    <div class="layout yahei">
        <div class="title title-problem"></div>
        <div class="proContainer">
            <div class="proTitle clearfix">
                <ul>
                    <li class="current">代发问题<em></em></li>
                    <li>售后问题<em></em></li>
                    <li>合作市场<em></em></li>
                </ul>
            </div>
            <div class="proContent fs14">
                <div class="">
                    <ul>
                        <li>
                            <p class="question">1、星座网代发什么时候截单？</p>
                            <p class="answer">每天16:00截单，如有特殊情况会提前截单。为了保证您的发货时效，请尽早下单。</p>
                        </li>
                        <li>
                            <p class="question">2、星座网代发什么时候拿货？</p>
                            <p class="answer">每日11时起，会有专门的配货员为您配货，直至截单后最后一单配货完成。</p>
                        </li>
                        <li>
                            <p class="question">3、星座网代发什么时候发货？</p>
                            <p class="answer">当天配齐订单，保证当天发货，物流信息以快递公司揽件后更新为准。</p>
                        </li>
                        <li>
                            <p class="question">4、已下代发订单可以取消吗？</p>
                            <p class="answer">1）未配商品：即时退款，包括商品金额+代配服务费等该订单所涉及的费用。</p>
                            <p class="answer">2）已配商品：如果商品已经采购，代配服务费已经产生，不予以退还，如有增值服务费用系统即时自动返还：增值服务费用。商品进入售后流程，第二天退货后退款（如遇档口下架商品无法退货，此商品视为您的库存商品）。</p>
                            <p class="answer">3）发货完成：如果商品已经发货完成，视为正常售后流程所产生的费用不予以退还，本平台可以配合物流公司进行截单服务，为您更好控制损失。</p>
                        </li>
                        <li>
                            <p class="question">5、下单的宝贝没有货，可以退款吗？</p>
                            <p class="answer">1）单件缺货继续配货或者退款：</p>
                            <p class="answer">当天缺货，我们默认会在第二天重新安排采购，您无需重新下单，我们会第一时间反馈后台方便您操作。单件连续缺货3天或者档口下架，我们将直接进行退款处理。</p>
                            <p class="answer">2）多件缺货：</p>
                            <p class="answer">配货员在配货时如遇缺货会第一时间反馈予您的后台，您可根据情况转成缺货先发或者取消订单进入退款流程。如连续3天（以日期为单位第一日至第三日16时为准）配货缺货时未进行操作，平台默认为同意缺货先发，扣除快递等费用，未配货进入退款或拆单流程。</p>
                        </li>
                        <li>
                            <p class="question">6、代发商品，你们会进行检查吗？</p>
                            <p class="answer">拿到商品，我们会检查外包装，包括：颜色，尺码，款式，套装是否齐整一致，是否大面积破损等。不包括：拆包平铺检查、剪线头、破损包装袋、内衬、口袋、拉链、袖子、裤管</p>
                            <p class="answer">注：以下非质检问题：</p>
                            <p class="answer">面料问题：掉色、面料潮湿、起球、开线等；</p>
                            <p class="answer">做工问题：做工粗糙；</p>
                            <p class="answer">尺寸问题：尺寸和档口描述相差大；</p>
                            <p class="answer">货不对板：实物与图片版型、款式、颜色等相差大。</p>
                        </li>
                    </ul>
                </div>
                <div class="none">
                    <ul>
                        <li>
                            <p class="question">1、怎么进行退货申请？</p>
                            <p class="answer">退货需先进行退货申请，请让客户留便签随包寄回，方便为你提供快捷的售后时效。</p>
                            <p class="answer">如未申请寄回，本公司一律按未知件处理，后续不便售后查询，无法保证时效。</p>
                            <p class="answer">如若快件超过15天（以签收时间为准）未主动申请，本公司将商品视为无效件概不负责，作废品处理，将无法找回。</p>
                        </li>
                        <li>
                            <p class="question">2、退货申请时间多久？</p>
                            <p class="answer">建议您在收到退货后的7天内申请退货退款，保证您的退货时效，以免商品下架无法退货，造成您的经济损失。</p>
                        </li>
                        <li>
                            <p class="question">3、退货后，多久可以退款？</p>
                            <p class="answer">快递签收后第二天进行退货后退款。重大促销比如618、双十一、双十二等，杭州男装市场每月1日休业，节假日春节放假等，市场不接受退货，退货退款时间顺延。</p>
                            <p class="answer">如果档口下架等无法退货，后台会反馈予您，您可以在售后页面里面进行查看，再根据情况联系客服，进行寄回等处理（库存物品我们为您保管30天，如30天未申请操作，本公司视为无人认领物品，作废品处理）。</p>
                        </li>
                        <li>
                            <p class="question">4、申请退货失败，怎么办？</p>
                            <p class="answer">退货失败后，您可以联系客服，申请将商品寄回（库存物品我们为您保管30天，如30天未申请操作，本公司视为无人认领物品，作废品处理）。</p>
                            <p class="answer">若超过30天未主动申请，本公司将商品视为无效件，作废品处理无法找回。</p>
                        </li>
                    </ul>
                </div>
                <div class="none">
                    <p>目前开通市场： 电商基地，四季星座，钱塘大厦，保太和（星座女装），好四季</p>
                </div>
            </div>
        </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>
<#include "/common/cnzz.ftl">