<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>服务条款 - 四季星座网</title>
  
    
    <link href="//style.571xz.com/loginV2/css/contract.css?v=2017112301" rel="stylesheet">
    
    
    <script src="//style.571xz.com/global/js/jquery.js"></script>
    <script src="//style.571xz.com/loginV2/js/contract.js?v=2017112301"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源<#elseif webSite == "jx">濮院</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="//hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="//cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="//ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="//bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="//gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="//wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                        <li><a href="//jx.571xz.com" <#if webSite == "jx">class="select"</#if>>濮院</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="//www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="//www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
                
            </div>
        </div>
        
        <div class="rightbox">
            <ul>
                <li class="noIndex">
                    <a href="${main_host!}" class="c_ff4400">四季星座网首页</a>
                </li>
                <#if session_user_redis__??>
                    <#if session_user_redis__.logshop??>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                            <div class="myStore cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                    <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    <#else>
                    <li class="noDown">
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
                            <em class="cgNum"></em>
                        </a>
                    </li>
                    <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                            <div class="myxz cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                            <div class="myColle cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    </#if>
                    
                <#else>
                    <li class="noDown">
                        <a href="${main_host!}order/cart.htm">
                            <i class="cgcatIcon"></i>
                            <span>进货车</span>
                            <em class="cgNum"></em>
                        </a>
                    </li>
                    <li class="noDown"><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/index.htm">我的星座<i class="downArrow"></i></a>
                            <div class="myxz cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/shiguOnekeyRecordinit.htm">已上传的商品</a></li>
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">我的数据包</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}member/storeCollectinit.htm">我的收藏<i class="downArrow"></i></a>
                            <div class="myColle cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}member/storeCollectinit.htm">收藏的档口</a></li>
                                    <li><a href="${main_host!}member/goodsCollectOriginal.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    <li>
                        <div class="cnBox">
                            <a class="cgcom" href="${main_host!}seller/index.htm">我是档口<i class="downArrow"></i></a>
                            <div class="myStore cnBoxCon">
                                <ul>
                                    <li><a href="${main_host!}seller/createGoods21init.htm">发布新商品</a></li>
                                    <li><a href="${main_host!}seller/storeGoodsList21init.htm">已发布的商品</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                </#if>
                <li class="noDown">
                    <a href="//www.571xz.com/contact.htm" target="_blank">联系客服</a>
                    
                </li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                                <li><a href="//hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="//hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<script>/*============ xz/page#topbar BEGIN ============*/

var webSite = '${webSite!}';

/*============ xz/page#topbar END ============*/


</script>
<div class="layout">
    <div class="contract">
        <h2>杭州石谷网络科技有限公司 服务条款</h2>
        <p class="startTime">版本生效日期：2015年6月25日</p>
        <div class="contractDetail">
            <p>为使用杭州石谷网络科技有限公司所提供服务，您应当阅读并遵守《石谷网络科技服务协议》（以下简称“本协议”）。请您务必审慎阅读、充分理解各条款内容，特别是免除或者限制责任的条款，以及开通或使用某项服务的单独协议。限制、免责条款可能以黑体加粗形式提示您注意。</p>
            <p>除非您已阅读并接受本协议所有条款，否则您无权使用石谷网络科技提供的服务。您使用石谷网络科技的服务即视为您已阅读并同意上述协议的约束。</p>
            <p>如果您未满18周岁，请在法定监护人的陪同下阅读本协议，并特别注意未成年人使用条款。</p>
            <h3>一、【协议的范围】</h3>
            <p>1.1本协议是您与石谷网络科技之间关于用户使用石谷网络科技相关服务所订立的协议。“石谷网络科技”是指石谷网络科技公司及其相关服务可能存在的运营关联单位。“用户”是指使用石谷网络科技相关服务的使用人，在本协议中更多地称为“您”。</p>
            <p>1.2本协议项下的服务是指石谷网络科技向用户提供的包括但不限于“星座网APP”、“四季星座网”等产品及服务（以下简称“本服务”）。</p>
            <h3>二、【帐号与密码安全】</h3>
            <p>2.1您在使用石谷网络科技的服务时可能需要注册一个帐号。关于您使用帐号的具体规则，请遵守协议。</p>
            <p>2.2石谷网络科技特别提醒您应妥善保管您的帐号和密码。当您使用完毕后，应安全退出。因您保管不善可能导致遭受盗号或密码失窃，责任由您自行承担。</p>
            <h3>三、【用户个人信息保护】</h3>
            <p>3.1保护用户个人信息是石谷网络科技的一项基本原则。</p>
            <p>3.2您在注册帐号或使用本服务的过程中，可能需要填写一些必要的信息。若国家法律法规有特殊规定的，您需要填写真实的身份信息。若您填写的信息不完整，则无法使用本服务或在使用过程中受到限制。</p>
            <p>3.3一般情况下，您可随时浏览、修改自己提交的信息，但出于安全性和身份识别（如号码申诉服务）的考虑，您可能无法修改注册时提供的初始注册信息及其他验证信息。</p>
            <p>3.4  石谷网络科技将运用各种安全技术和程序建立完善的管理制度来保护您的个人信息，以免遭受未经授权的访问、使用或披露。</p>
            <p>3.5  石谷网络科技不会将您的个人信息转移或披露给任何非关联的第三方，除非：<br/>
                （1）相关法律法规或法院、政府机关要求；<br/>
                （2）为完成合并、分立、收购或资产转让而转移；或<br/>
                （3）为提供您要求的服务所必需。</p>
            <p>3.6  石谷网络科技非常重视对未成年人个人信息的保护。若您是18周岁以下的未成年人，在使用石谷网络科技的服务前，应事先取得您家长或法定监护人（以下简称"监护人"）的书面同意。</p>
            <h3>四、【使用本服务的方式】</h3>
            <p>4.1除非您与石谷网络科技另有约定，您同意本服务仅为您个人非商业性质的使用。</p>
            <p>4.2您应当通过石谷网络科技提供或认可的方式使用本服务。您依本协议条款所取得的权利不可转让。</p>
            <p>4.3您不得使用未经石谷网络科技授权的插件、外挂或第三方工具对本协议项下的服务进行干扰、破坏、修改或施加其他影响。</p>
            <h3>五、【按现状提供服务】</h3>
            <p>您理解并同意，石谷网络科技的服务是按照现有技术和条件所能达到的现状提供的。石谷网络科技会尽最大努力向您提供服务，确保服务的连贯性和安全性；但石谷网络科技不能随时预见和防范法律、技术以及其他风险，包括但不限于不可抗力、病毒、木马、黑客攻击、系统不稳定、第三方服务瑕疵、政府行为等原因可能导致的服务中断、数据丢失以及其他的损失和风险。</p>
            <h3>六、【自备设备】</h3>
            <p>6.1您应当理解，您使用石谷网络科技的服务需自行准备与相关服务有关的终端设备（如电脑、调制解调器等装置），并承担所需的费用（如电话费、上网费等费用）。</p>
            <p>6.2您理解并同意，您使用本服务时会耗用您的终端设备和带宽等资源。</p>
            <h3>七、【广告】</h3>
            <p>7.1您同意石谷网络科技可以在提供服务的过程中自行或由第三方广告商向您发送广告、推广或宣传信息（包括商业与非商业信息），其方式和范围可不经向您特别通知而变更。</p>
            <p>7.2  石谷网络科技可能为您提供选择关闭广告信息的功能，但任何时候您都不得以本协议未明确约定或石谷网络科技未书面许可的方式屏蔽、过滤广告信息。</p>
            <p>7.3  石谷网络科技依照法律的规定对广告商履行相关义务，您应当自行判断广告信息的真实性并为自己的判断行为负责，除法律明确规定外，您因依该广告信息进行的交易或前述广告商提供的内容而遭受的损失或损害，石谷网络科技不承担责任。</p>
            <p>7.4您同意，对石谷网络科技服务中出现的广告信息，您应审慎判断其真实性和可靠性，除法律明确规定外，您应对依该广告信息进行的交易负责。 </p>
            <h3>八、【收费服务】</h3>
            <p>8.1  石谷网络科技的部分服务是以收费方式提供的，如您使用收费服务，请遵守相关的协议。</p>
            <p>8.2  石谷网络科技可能根据实际需要对收费服务的收费标准、方式进行修改和变更，石谷网络科技也可能会对部分免费服务开始收费。前述修改、变更或开始收费前，石谷网络科技将在相应服务页面进行通知或公告。如果您不同意上述修改、变更或付费内容，则应停止使用该服务。 </p>
            <h3>九、【第三方提供的产品或服务】</h3>
            <p>您在石谷网络科技平台上使用第三方提供的产品或服务时，除遵守本协议约定外，还应遵守第三方的用户协议。石谷网络科技和第三方对可能出现的纠纷在法律规定和约定的范围内各自承担责任。</p>
            <h3>十、【基于软件提供服务】</h3>
            <p>若石谷网络科技依托“软件”向您提供服务，您还应遵守以下约定：</p>
            <p>10.1您在使用本服务的过程中可能需要下载软件，对于这些软件，石谷网络科技给予您一项个人的、不可转让及非排他性的许可。您仅可为访问或使用本服务的目的而使用这些软件。</p>
            <p>10.2为了改善用户体验、保证服务的安全性及产品功能的一致性，石谷网络科技可能会对软件进行更新。您应该将相关软件更新到最新版本，否则石谷网络科技并不保证其能正常使用。</p>
            <p>10.3   石谷网络科技可能为不同的终端设备开发不同的软件版本，您应当根据实际情况选择下载合适的版本进行安装。您可以直接从石谷网络科技的网站上获取软件，也可以从得到石谷网络科技授权的第三方获取。如果您从未经石谷网络科技授权的第三方获取软件或与软件名称相同的安装程序，石谷网络科技无法保证该软件能够正常使用，并对因此给您造成的损失不予负责。</p>
            <p> 10.4除非石谷网络科技书面许可，您不得从事下列任一行为：<br/>
                （1）删除软件及其副本上关于著作权的信息；<br/>
                （2）对软件进行反向工程、反向汇编、反向编译，或者以其他方式尝试发现软件的源代码；<br/>
                （3）对石谷网络科技拥有知识产权的内容进行使用、出租、出借、复制、修改、链接、转载、汇编、发表、出版、建立镜像站点等；<br/>
                （4）对软件或者软件运行过程中释放到任何终端内存中的数据、软件运行过程中客户端与服务器端的交互数据，以及软件运行所必需的系统数据，进行复制、修改、增加、删除、挂接运行或创作任何衍生作品，形式包括但不限于使用插件、外挂或非经石谷网络科技授权的第三方工具/服务接入软件和相关系统；</br>
                （5）通过修改或伪造软件运行中的指令、数据，增加、删减、变动软件的功能或运行效果，或者将用于上述用途的软件、方法进行运营或向公众传播，无论这些行为是否为商业目的；<br/>
                （6）通过非石谷网络科技开发、授权的第三方软件、插件、外挂、系统，登录或使用石谷网络科技软件及服务，或制作、发布、传播非石谷网络科技开发、授权的第三方软件、插件、外挂、系统。 </p>
            <h3>十一、【知识产权声明】</h3>
            <p>11.1石谷网络科技在本服务中提供的内容（包括但不限于网页、文字、图片、音频、视频、图表等）的知识产权归石谷网络科技所有，用户在使用本服务中所产生的内容的知识产权归用户或相关权利人所有。</p>
            <p>11.2除另有特别声明外，石谷网络科技提供本服务时所依托软件的著作权、专利权及其他知识产权均归石谷网络科技所有。</p>
            <p>11.3石谷网络科技在本服务中所使用的“四季星座网”、“石谷网络科技”、“571xz”及星字符号等商业标识，其著作权或商标权归石谷网络科技所有。</p>
            <p>11.4上述及其他任何本服务包含的内容的知识产权均受到法律保护，未经石谷网络科技、用户或相关权利人书面许可，任何人不得以任何形式进行使用或创造相关衍生作品。</p>
            <h3>十二、【用户违法行为】</h3>
            <p>12.1您在使用本服务时须遵守法律法规，不得利用本服务从事违法违规行为，包括但不限于：<br/>
                （1）发布、传送、传播、储存危害国家安全统一、破坏社会稳定、违反公序良俗、侮辱、诽谤、淫秽、暴力以及任何违反国家法律法规的内容；<br/>
                （2）发布、传送、传播、储存侵害他人知识产权、商业秘密等合法权利的内容；<br/>
                （3）恶意虚构事实、隐瞒真相以误导、欺骗他人；<br/>
                （4）发布、传送、传播广告信息及垃圾信息；<br/>
                （5）其他法律法规禁止的行为。</p>
            <p>12.2如果您违反了本条约定，相关国家机关或机构可能会对您提起诉讼、罚款或采取其他制裁措施，并要求石谷网络科技给予协助。造成损害的，您应依法予以赔偿，石谷网络科技不承担任何责任。</p>
            <p>12.3如果石谷网络科技发现或收到他人举报您发布的信息违反本条约定，石谷网络科技有权进行独立判断并采取技术手段予以删除、屏蔽或断开链接。同时，石谷网络科技有权视用户的行为性质，采取包括但不限于暂停或终止服务，限制、冻结或终止四季星座网账号的使用，追究法律责任等措施。</p>
            <p>12.4您违反本条约定，导致任何第三方损害的，您应当独立承担责任；石谷网络科技因此遭受损失的，您也应当一并赔偿。 </p>
            <h3>十三、【遵守当地法律监管】</h3>
            <p>13.1您在使用本服务过程中应当遵守当地相关的法律法规，并尊重当地的道德和风俗习惯。如果您的行为违反了当地法律法规或道德风俗，您应当为此独立承担责任。</p>
            <p>13.2您应避免因使用本服务而使石谷网络科技卷入政治和公共事件，否则石谷网络科技有权暂停或终止对您的服务。 </p>
            <h3>十四、【用户发送、传播的内容与第三方投诉处理】</h3>
            <p>14.1您通过本服务发送或传播的内容（包括但不限于网页、文字、图片、音频、视频、图表等）均由您自行承担责任。</p>
            <p>14.2您发送或传播的内容应有合法来源，相关内容为您所有或您已获得权利人的授权。</p>
            <p>14.3您同意石谷网络科技可为履行本协议或提供本服务的目的而使用您发送或传播的内容。</p>
            <p>14.4如果石谷网络科技收到权利人通知，主张您发送或传播的内容侵犯其相关权利的，您同意石谷网络科技有权进行独立判断并采取删除、屏蔽或断开链接等措施。</p>
            <h3>十五、【不可抗力及其他免责事由】</h3>
            <p>15.1您理解并同意，在使用本服务的过程中，可能会遇到不可抗力等风险因素，使本服务发生中断。不可抗力是指不能预见、不能克服并不能避免且对一方或双方造成重大影响的客观事件，包括但不限于自然灾害如洪水、地震、瘟疫流行和风暴等以及社会事件如战争、动乱、政府行为等。出现上述情况时，石谷网络科技将努力在第一时间与相关单位配合，及时进行修复，但是由此给您造成的损失石谷网络科技在法律允许的范围内免责。</p>
            <p>15.2在法律允许的范围内，石谷网络科技对以下情形导致的服务中断或受阻不承担责任：<br/>
                （1）受到计算机病毒、木马或其他恶意程序、黑客攻击的破坏；<br/>
                （2）用户或石谷网络科技的电脑软件、系统、硬件和通信线路出现故障；<br/>
                （3）用户操作不当；<br/>
                （4）用户通过非石谷网络科技授权的方式使用本服务；<br/>
                （5）其他石谷网络科技无法控制或合理预见的情形。</p>
            <p>15.3您理解并同意，在使用本服务的过程中，可能会遇到网络信息或其他用户行为带来的风险，石谷网络科技不对任何信息的真实性、适用性、合法性承担责任，也不对因侵权行为给您造成的损害负责。这些风险包括但不限于：<br/>
                （1）来自他人匿名或冒名的含有威胁、诽谤、令人反感或非法内容的信息；<br/>
                （2）因使用本协议项下的服务，遭受他人误导、欺骗或其他导致或可能导致的任何心理、生理上的伤害以及经济上的损失；<br/>
                （3）其他因网络信息或用户行为引起的风险。</p>
            <p>15.4您理解并同意，本服务并非为某些特定目的而设计，包括但不限于核设施、军事用途、医疗设施、交通通讯等重要领域。如果因为软件或服务的原因导致上述操作失败而带来的人员伤亡、财产损失和环境破坏等，石谷网络科技不承担法律责任。</p>
            <p>15.5石谷网络科技依据本协议约定获得处理违法违规内容的权利，该权利不构成石谷网络科技的义务或承诺，石谷网络科技不能保证及时发现违法行为或进行相应处理。</p>
            <p>15.6在任何情况下，您不应轻信借款、索要密码或其他涉及财产的网络信息。涉及财产操作的，请一定先核实对方身份，并请经常留意石谷网络科技有关防范诈骗犯罪的提示。</p>
            <h3>十六、【协议的生效与变更】</h3>
            <p>16.1您使用石谷网络科技的服务即视为您已阅读本协议并接受本协议的约束。</p>
            <p>16.2石谷网络科技有权在必要时修改本协议条款。您可以在相关服务页面查阅最新版本的协议条款。</p>
            <p>16.3本协议条款变更后，如果您继续使用石谷网络科技提供的软件或服务，即视为您已接受修改后的协议。如果您不接受修改后的协议，应当停止使用石谷网络科技提供的软件或服务。 </p>
            <h3>十七、【服务的变更、中断、终止】</h3>
            <p>17.1石谷网络科技可能会对服务内容进行变更，也可能会中断、中止或终止服务。 </p>
            <p> 17.2您理解并同意，石谷网络科技有权自主决定经营策略。在石谷网络科技发生合并、分立、收购、资产转让时，石谷网络科技可向第三方转让本服务下相关资产；石谷网络科技也可在单方通知您后，将本协议下部分或全部服务转交由第三方运营或履行。具体受让主体以石谷网络科技通知的为准。</p>
            <p>17.3如发生下列任何一种情形，石谷网络科技有权不经通知而中断或终止向您提供的服务：<br/>
                （1）根据法律规定您应提交真实信息，而您提供的个人资料不真实、或与注册时信息不一致又未能提供合理证明；<br/>
                （2）您违反相关法律法规或本协议的约定；<br/>
                （3）按照法律规定或主管部门的要求；<br/>
                （4）出于安全的原因或其他必要的情形。</p>
            <p>17.4石谷网络科技有权按本协议8.2条的约定进行收费。若您未按时足额付费，石谷网络科技有权中断、中止或终止提供服务。</p>
            <p>17.5您有责任自行备份存储在本服务中的数据。如果您的服务被终止，石谷网络科技可以从服务器上永久地删除您的数据,但法律法规另有规定的除外。服务终止后，石谷网络科技没有义务向您返还数据。</p>
            <h3>十八、【管辖与法律适用】</h3>
            <p>18.1本协议签订地为中华人民共和国浙江省杭州市拱墅区。</p>
            <p>18.2本协议的成立、生效、履行、解释及纠纷解决，适用中华人民共和国大陆地区法律（不包括冲突法）。</p>
            <p>18.3若您和石谷网络科技之间发生任何纠纷或争议，首先应友好协商解决；协商不成的，您同意将纠纷或争议提交本协议签订地有管辖权的人民法院管辖。</p>
            <p>18.4本协议所有条款的标题仅为阅读方便，本身并无实际涵义，不能作为本协议涵义解释的依据。</p>
            <p>18.5本协议条款无论因何种原因部分无效或不可执行，其余条款仍有效，对双方具有约束力。</p>
            <h3>十九、【未成年人使用条款】</h3>
            <p>19.1若用户未满18周岁，则为未成年人，应在监护人监护、指导下阅读本协议和使用本服务。</p>
            <p>19.2未成年人用户涉世未深，容易被网络虚象迷惑，且好奇心强，遇事缺乏随机应变的处理能力，很容易被别有用心的人利用而又缺乏自我保护能力。因此，未成年人用户在使用本服务时应注意以下事项，提高安全意识，加强自我保护：<br/>
                （1）认清网络世界与现实世界的区别，避免沉迷于网络，影响日常的学习生活；<br/>
                （2）填写个人资料时，加强个人保护意识，以免不良分子对个人生活造成骚扰；<br/>
                （3）在监护人或老师的指导下，学习正确使用网络；<br/>
                （4）避免陌生网友随意会面或参与联谊活动，以免不法分子有机可乘，危及自身安全。</p>
            <p>19.3监护人、学校均应对未成年人使用本服务时多做引导。特别是家长应关心子女的成长，注意与子女的沟通，指导子女上网应该注意的安全问题，防患于未然。</p>
            <h3>二十、【其他】</h3>
            <p>如果您对本协议或本服务有意见或建议，可与石谷网络科技客户服务部门联系，我们会给予您必要的帮助。（正文完）</p>
            <p class="company">--杭州石谷网络科技有限公司</p>
        </div>
        <div class="links"><a href="${main_host!}contract.htm" target="_blank">服务条款</a> | <a href="${main_host!}privacy.htm" target="_blank">隐私政策</a></div>
    </div>
</div>
<div class="footer">
    <p class="sitemap"> 
        <a href="/" target="_blank">首页</a>
        <a href="//hz.571xz.com" target="_blank">杭州站</a>
        <a href="//bj.571xz.com" target="_blank">北京站</a>
        <a href="//gz.571xz.com" target="_blank">广州站</a>
        <a href="//ss.571xz.com" target="_blank">石狮站</a>
        <a href="//cs.571xz.com" target="_blank">常熟站</a>
        <a href="//wa.571xz.com" target="_blank">辽源站</a>
        <a href="//zixun.571xz.com" target="_blank">资讯</a>
        
        
        <a href="//zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        
    </p>
    <p class="jyga">
        <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="//www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
        
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="//style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
    </p>
</div>
</body>
</html>