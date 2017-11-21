<#assign $pageid>awardInfo</#assign>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=1300px">
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
<#assign text>{"disabledChooseCity":true,"isFxs":true}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/common/xz__topbar.ftl">
</#list>
<#include "/__ftl_links__/fxs__common__header.ftl">
<div class="wrapper">
    <div class="layout">
            <#assign sidebarType>index</#assign>
<#assign text>{"type":sidebarType}</#assign>
<#assign moduleJsonStr=text?eval />
<#list [moduleJsonStr] as $it>
<#include "/__ftl_links__/fxs__common__sidebar.ftl">
</#list>
            <div class="rightBox">
<#if (actList?size) gt 0>
    <#list actList as act>
    <div class="actBox">
        <h3 class="yahei">${act.actName!}</h3>
        <#list act.actPhaseList as phase>
         <div class="actPhase">
            <div class="actHead">
                <span class="actTime fs14 yahei fc6">活动日期：${phase.phaseTime!} </span>
                <div class="actRule yahei fr">
                    <span class="ruleBtn fcF40"><i class="icon-doubt"></i>活动规则</span>
                    <div class="rules">${phase.ruleList!}</div>
                </div>
            </div>
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
        </div>
        </#list>
    </div>
    </#list>
<#else>
<p>暂无开奖信息</p>
</#if>
            </div>
    </div>
</div>
<#include "/common/xz__footer.ftl">