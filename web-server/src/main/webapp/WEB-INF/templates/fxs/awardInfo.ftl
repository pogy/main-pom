<#assign $pageid="awardInfo">
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300">
    <title>开奖结果 - 分销商中心 - 四季星座网</title>
<#include "/common/base__config.ftl">
    <#include "/__style_torrent__/common__base_css.ftl">
<#include "/__style_torrent__/common__xz_css.ftl">
<#include "/__style_torrent__/fxs__common_css.ftl">
<#include "/__style_torrent__/fxs__awardInfo_css.ftl">
    <script src="http://style.571xz.com/v6/common/js/jquery.js"></script>
    <#include "/__style_torrent__/common__base_js.ftl">
<#include "/__style_torrent__/common__xz_js.ftl">
<#include "/__style_torrent__/fxs__awardInfo_js.ftl">
</head>
<body>
<#list [{"disabledChooseCity":true,"isFxs":true}] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType="index">
<#list [{"type":sidebarType}] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#if (actList?size) gt 0>
    <div class="actBox">
        <div class="actBoxTab yahei clearfix">
            <ul>
                <#list actList as act>
                    <li <#if act_index == 0 >class="select"</#if>><span>${act.actName!}</span></li>
                </#list>
            </ul>
        </div>
        <div class="actDetail">
            <#list actList as list>
                <div <#if list_index gt 0>style="display:none"</#if>>
                    <#list list.actPhaseList as phase>
                        <div class="actPhase">
                            <div class="actHead">
                                <span class="actTime fs14 yahei fc6">活动日期：${phase.phaseTime!} </span>
                                <div class="actRule yahei fr">
                                    <span class="ruleBtn fcF40"><i class="icon-doubt"></i>活动规则</span>
                                    <div class="rules">
                                        <#list phase.ruleList as rule>
                                            <p>${rule!}</p>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                            <#if (phase.awardList?size) gt 2>
                                <div class="awardList clearfix">
                                    <ul>
                                        <#list phase.awardList as award>
                                            <li>
                                                <dl>
                                                    <dt><img src="${award.img!}"></dt>
                                                    <dd>
                                                        <span>${award.name!}</span>
                                                        <p>${award.prize!}</p>
                                                    </dd>
                                                </dl>
                                                <div class="lotteryState">
                                                    <#if award.state == 1>
                                                        等待抽奖
                                                    <#elseif award.state == 2>
                                                        未中奖
                                                    <#elseif award.state == 3>
                                                        <#if award.takedIs == true>
                                                            <span class="hasTake">已领取</span>
                                                        <#else>
                                                            <span class="hasLottery">已中奖（领取码：${award.takeCode!}） </span>
                                                        </#if>
                                                    </#if>
                                                </div>
                                            </li>
                                        </#list>
                                    </ul>
                                </div>
                            <#else>
                                <div class="justOneAward">
                                    <#list phase.awardList as award>
                                        <div class="awardBox">
                                            <div class="awardMoney" style="background-image:url(${award.img!})"></div>
                                            <div class="awardInfo">
                                                <ul>
                                                    <li>中奖情况：
                                                        <#if award.state == 1>
                                                            等待抽奖
                                                        <#elseif award.state == 2>
                                                            未中奖
                                                        <#elseif award.state == 3>
                                                            <#if award.takedIs == true>
                                                                <span class="hasTake">已领取</span>
                                                            <#else>
                                                                <span class="hasLottery">已中奖（领取码：${award.takeCode!}） </span>
                                                            </#if>
                                                        </#if>
                                                    </li>
                                                    <li>
                                                        <#if award.uploadNum??>上传商品个数：
                                                            <#if award.state == 3>
                                                                <span class="fcF40">${award.uploadNum!}</span>
                                                            <#else>
                                                                ${award.uploadNum!}
                                                            </#if>
                                                        <#else>
                                                        类型：摄影代金券
                                                        </#if>
                                                    </li>
                                                    <li>领取地点：置地国际电商基地1楼</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </#if>
                        </div>
                    </#list>
                </div>
            </#list>
        </div>
    </div>
<#else>
    <p class="fs20 tac fc6">暂无开奖信息</p>
</#if>
            </div>
    </div>
</div>
<#list [{}] as $it>
<#include "/common/xz__footer.ftl">
</#list>