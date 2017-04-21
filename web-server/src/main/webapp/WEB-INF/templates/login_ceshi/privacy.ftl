<#assign text>{}</#assign><#assign $it=text?eval /><!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title></title>
  
    
    <link href="http://style.571xz.com/loginV2/css/privacy.css" rel="stylesheet">
    
    
    <script src="http://style.571xz.com/global/js/jquery.js"></script>
    <script src="http://style.571xz.com/loginV2/js/privacy.js"></script>
  </head>
<body>
<#include "/common/host_config.ftl">

<div class="topbar">
    <div class="layout">
        <div class="leftbox">
            <div class="cityCe">
                <span><em><#if webSite == "hz">杭州<#elseif webSite == "cs">常熟<#elseif webSite == "ss">石狮<#elseif webSite == "bj">北京<#elseif webSite == "gz">广州<#elseif webSite == "wa">辽源</#if></em><i class="downArrow"></i></span>
                <div class="cityCon">
                    <ul>
                        <li><a href="http://hz.571xz.com" <#if webSite == "hz">class="select"</#if>>杭州</a></li>
                        <li><a href="http://cs.571xz.com" <#if webSite == "cs">class="select"</#if>>常熟</a></li>
                        <li><a href="http://ss.571xz.com" <#if webSite == "ss">class="select"</#if>>石狮</a></li>
                        <li><a href="http://bj.571xz.com" <#if webSite == "bj">class="select"</#if>>北京</a></li>
                        <li><a href="http://gz.571xz.com" <#if webSite == "gz">class="select"</#if>>广州</a></li>
                        <li><a href="http://wa.571xz.com" <#if webSite == "wa">class="select"</#if>>辽源</a></li>
                    </ul>
                </div>
            </div>
            <div class="login">
                <span>你好，</span>
                <em>请</em>
                <a class="simpleLogin" onclick="loginBack()" target="_blank">登录</a>
                <a href="http://www.571xz.com/regedit.htm"  target="_blank">注册</a>
                <a class="tbLogin" href="http://www.571xz.com/ortherLogin.htm?ortherLoginType=1">淘宝登录</a>
                
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
                        <a href="${main_host!}carts.htm">
                            <i class="cgcatIcon"></i>
                            <span>购物车</span>
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
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
                                </ul>
                            </div>
                        </div>    
                    </li>
                    </#if>
                    
                <#else>
                    <li class="noDown">
                        <a href="${main_host!}carts.htm">
                            <i class="cgcatIcon"></i>
                            <span>购物车</span>
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
                                    <li><a href="${main_host!}member/goodsCollectinit.htm">收藏的宝贝</a></li>
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
                <li class="noDown"><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=${qiye_qq!}" target="_blank">联系客服</a></li>
                <li>
                    <div class="cnBox">
                        <a class="cgcom noRig"><i class="webIcon"></i><em>网站导航</em><i class="downArrow"></i></a>
                        <div class="webNav cnBoxCon">
                            <h4>市场大全</h4>
                            <ul>
                                
                                <li><a href="http://hz.571xz.com/market.htm?mid=1">电商基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=2">精品男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=3">四季星座</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=4">星座女装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=5">钱塘大厦</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=6">好四季</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=7">意法服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=8">置地国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=9">九星服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=10">之江服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=11">九天国际</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=12">新杭派</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=13">四季青</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=14">中纺服饰</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=15">中星外贸</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=16">原创男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=17">大码男装</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=18">男鞋基地</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=19">周边市场</a></li>
                                <li><a href="http://hz.571xz.com/market.htm?mid=20">石狮工厂店</a></li>
                            </ul>
                        </div>
                    </div>    
                </li>
                    
            </ul>
        </div>
    </div>
</div>
<div class="layout">
    <div class="privacy">
        <h2>杭州石谷网络科技有限公司 隐私保护政策</h2>
        <p class="startTime">版本生效日期：2015年6月25日</p>
        <div class="privacyDetail">
            <p>杭州石谷网络科技有限公司（以下简称“石谷网络科技”）在此特别提醒您（用户）在注册成为用户之前，请认真阅读本《用户协议》（以下简称“协议”），确保您充分理解本协议中各条款，包括免除石谷网络科技责任的条款及限制用户权利的条款。请您审慎阅读并选择接受或不接受本协议。除非您接受本协议所有条款，否则您无权注册、登录或使用本协议所涉服务。您的注册、登录、使用等行为将视为对本协议的接受，并同意接受本协议各项条款的约束。</p>
            <p>本协议约定石谷网络科技与用户之间关于“石谷网络”软件服务（以下简称“服务”）的权利义务。“用户”是指注册、登录、使用本服务的个人。本协议可由石谷网络科技随时更新，更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，用户可在本网站查阅最新版协议条款。在石谷网络科技修改协议条款后，如果用户不接受修改后的条款，请立即停止使用石谷网络科技提供的服务，用户继续使用石谷网络科技提供的服务将被视为接受修改后的协议。 </p>
            <h3>一、账号注册</h3>
            <p>1、用户在使用本服务前需要注册一个“石谷网络”账号。“石谷网络”账号应当使用电子邮箱或手机号码绑定注册，请用户使用尚未与“石谷网络”账号绑定的电子邮箱或手机号码注册“石谷网络”账号。石谷网络科技可以根据用户需求或产品需要对账号注册和绑定的方式进行变更，而无须事先通知用户。 </p>
            <p>2、用户名规则 <br/>使用石谷网络用户系统注册的用户，只能用本人手机号码作为账户名，否则将不予注册。 </p>
            <p> 3、在注册前请确认你的名字与其他信息与你的真实情况相符。<br/>
                (1) 请勿以党和国家领导人或其他社会名人的真实姓名、字号、艺名、笔名注册；<br/>
                (2) 请勿以国家机构或其他机构的名称注册；<br/>
                (3) 请勿注册不文明、不健康名字，或包含歧视、侮辱、猥亵类词语的帐号；<br/>
                (4) 请勿注册易产生歧义、引起他人误解或其它不符合法律规定的帐号。 </p>
            <h3>二、服务内容</h3>
            <p>1、本产品网络服务的具体内容由本产品根据实际情况提供。 </p>
            <p>2、本产品提供的部分网络服务为收费的网络服务，用户使用收费网络服务需要向本产品支付一定的费用。对于收费的网络服务，本产品会在用户使用之前给予用户明确的提示，只有用户根据提示确认其愿意支付相关费用，用户才能使用该等收费网络服务。如用户拒绝支付相关费用，则本产品有权不向用户提供该等收费网络服务。 </p>
            <p>3、本产品仅提供相关的网络服务，除此之外与相关网络服务有关的设备(如个人电脑、手机、及其他与接入互联网或移动网有关的装置)及所需的费用(如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费)均应由用户自行负担。</p>
            <h3>三、用户个人隐私信息保护</h3>
            <p>1、用户在注册账号或使用本服务的过程中，可能需要填写或提交一些必要的信息，如法律法规、规章规范性文件（以下称“法律法规”）规定的需要填写的身份信息。如用户提交的信息不完整或不符合法律法规的规定，则用户可能无法使用本服务或在使用本服务的过程中受到限制。 </p>
            <p>2、个人隐私信息是指涉及用户个人身份或个人隐私的信息，比如，用户真实姓名、学号、手机号码、手机设备识别码、IP地址、用户记录。非个人隐私信息是指用户对本服务的操作状态以及使用习惯等明确且客观反映在石谷网络科技服务器端的基本记录信息、个人隐私信息范围外的其它普通信息，以及用户同意公开的上述隐私信息。 </p>
            <p>3、尊重用户个人隐私信息的私有性是石谷网络科技的一贯制度，石谷网络科技将采取技术措施和其他必要措施，确保用户个人隐私信息安全，防止在本服务中收集的用户个人隐私信息泄露、毁损或丢失。在发生前述情形或者石谷网络科技发现存在发生前述情形的可能时，将及时采取补救措施。 </p>
            <p> 4、石谷网络科技未经用户同意不向任何第三方公开、 透露用户个人隐私信息。但以下特定情形除外：<br/>
                    (1) 石谷网络科技根据法律法规规定或有权机关的指示提供用户的个人隐私信息；<br/>
                    (2) 由于用户将其用户密码告知他人或与他人共享注册帐户与密码，由此导致的任何个人信息的泄漏，或其他非因石谷网络科技原因导致的个人隐私信息的泄露；<br/>
                    (3) 用户自行向第三方公开其个人隐私信息；<br/>
                    (4) 用户与石谷网络科技及合作单位之间就用户个人隐私信息的使用公开达成约定，石谷网络科技因此向合作单位公开用户个人隐私信息；<br/>
                    (5) 任何由于黑客攻击、电脑病毒侵入及其他不可抗力事件导致用户个人隐私信息的泄露。 </p>
            <p> 5、用户同意石谷网络科技可在以下事项中使用用户的个人隐私信息：<br/>
                    (1) 石谷网络科技向用户及时发送重要通知，如软件更新、本协议条款的变更；<br/>
                    (2) 石谷网络科技内部进行审计、数据分析和研究等，以改进石谷网络科技的产品、服务和与用户之间的沟通；<br/>
                    (3) 依本协议约定，石谷网络科技管理、审查用户信息及进行处理措施；<br/>
                    (4) 适用法律法规规定的其他事项。<br/>
                    除上述事项外，如未取得用户事先同意，石谷网络科技不会将用户个人隐私信息使用于任何其他用途。 </p>
            <p>6、用户确认，其活动报名信息为非个人隐私信息，用户成功注册“石谷网络”账号视为确认授权石谷网络科技提取、公开及报名活动的信息。用户课程计划信息将作为用户公开资料之一，由石谷网络科技向其他用户公开。如用户需要终止向其他用户公开其活动报名信息，可随时自行删除相关数据。 </p>
            <p>7、为了改善石谷网络科技的技术和服务，向用户提供更好的服务体验，石谷网络科技或可会自行收集使用或向第三方提供用户的非个人隐私信息。 </p>
            <h3>四、内容规范</h3>
            <p>1、本条所述内容是指用户使用本服务过程中所制作、上载、复制、发布、传播的任何内容，包括但不限于账号头像、名称、用户说明等注册信息及认证资料，或文字、语音、图片、视频、图文等发送、回复或自动回复消息和相关链接页面，以及其他使用账号或本服务所产生的内容。 </p>
            <p> 2、用户不得利用“石谷网络”账号或本服务制作、上载、复制、发布、传播如下法律、法规和政策禁止的内容：<br/>
                    (1) 反对宪法所确定的基本原则的；<br/>
                    (2) 危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；<br/>
                    (3) 损害国家荣誉和利益的；<br/>
                    (4) 煽动民族仇恨、民族歧视，破坏民族团结的；<br/>
                    (5) 破坏国家宗教政策，宣扬邪教和封建迷信的；<br/>
                    (6) 散布谣言，扰乱社会秩序，破坏社会稳定的；<br/>
                    (7) 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；<br/>
                    (8) 侮辱或者诽谤他人，侵害他人合法权益的；<br/>
                    (9) 煽动非法集会、结社、游行、示威、聚众扰乱社会秩序的；<br/>
                    (10) 以非法民间组织名义活动的；<br/>
                    (11) 含有法律、行政法规禁止的其他内容的信息。 </p>
            <p>3、用户不得利用“石谷网络”账号或本服务制作、上载、复制、发布、传播如下干扰“石谷网络”正常运营，以及侵犯其他用户或第三方合法权益的内容： <br/>
                    (1) 含有任何性或性暗示的；<br/>
                    (2) 含有辱骂、恐吓、威胁内容的；<br/>
                    (3) 含有骚扰、垃圾广告、恶意信息、诱骗信息的；<br/>
                    (4) 涉及他人隐私、个人信息或资料的；<br/>
                    (5) 侵害他人名誉权、肖像权、知识产权、商业秘密等合法权利的；<br/>
                    (6) 含有其他干扰本服务正常运营和侵犯其他用户或第三方合法权益内容的信息。 </p>
            <h3>五、使用规则</h3>
            <p>1、用户在本服务中或通过本服务所传送、发布的任何内容并不反映或代表，也不得被视为反映或代表石谷网络科技的观点、立场或政策，石谷网络科技对此不承担任何责任。 </p>
            <p> 2、用户不得利用“石谷网络”账号或本服务进行如下行为：<br/>
                    (1) 提交、发布虚假信息，或盗用他人头像或资料，冒充、利用他人名义的；<br/>
                    (2) 强制、诱导其他用户关注、点击链接页面或分享信息的；<br/>
                    (3) 虚构事实、隐瞒真相以误导、欺骗他人的；<br/>
                    (4) 利用技术手段批量建立虚假账号的；<br/>
                    (5) 利用“石谷网络”账号或本服务从事任何违法犯罪活动的；<br/>
                    (6) 制作、发布与以上行为相关的方法、工具，或对此类方法、工具进行运营或传播，无论这些行为是否为商业目的；<br/>
                    (7) 其他违反法律法规规定、侵犯其他用户合法权益、干扰“石谷网络”正常运营或石谷网络科技未明示授权的行为。 </p>
            <p>3、用户须对利用“石谷网络”账号或本服务传送信息的真实性、合法性、无害性、准确性、有效性等全权负责，与用户所传播的信息相关的任何法律责任由用户自行承担，与石谷网络科技无关。如因此给石谷网络科技或第三方造成损害的，用户应当依法予以赔偿。</p>
            <p>4、石谷网络科技提供的服务中可能包括广告，用户同意在使用过程中显示石谷网络科技和第三方供应商、合作伙伴提供的广告。除法律法规明确规定外，用户应自行对依该广告信息进行的交易负责，对用户因依该广告信息进行的交易或前述广告商提供的内容而遭受的损失或损害，石谷网络科技不承担任何责任。 </p>
            <h3>六、帐户管理</h3>
            <p>1、 “石谷网络”账号的所有权归石谷网络科技所有，用户完成申请注册手续后，获得“石谷网络”账号的使用权，该使用权仅属于初始申请注册人，禁止赠与、借用、租用、转让或售卖。石谷网络科技因经营需要，有权回收用户的“石谷网络”账号。</p>
            <p>2、用户可以更改、删除“石谷网络”帐户上的个人资料、注册信息及传送内容等，但需注意，删除有关信息的同时也会删除用户储存在系统中的文字和图片。用户需承担该风险。 </p>
            <p>3、用户有责任妥善保管注册账号信息及账号密码的安全，因用户保管不善可能导致遭受盗号或密码失窃，责任由用户自行承担。用户需要对注册账号以及密码下的行为承担法律责任。用户同意在任何情况下不使用其他用户的账号或密码。在用户怀疑他人使用其账号或密码时，用户同意立即通知石谷网络科技。 </p>
            <p>4、用户应遵守本协议的各项条款，正确、适当地使用本服务，如因用户违反本协议中的任何条款，石谷网络科技有权依据协议中断或终止对违约用户“石谷网络”账号提供服务。同时，石谷网络科技保留在任何时候收回“石谷网络”账号、用户名的权利。 </p>
            <p>5、如用户注册“石谷网络”账号后一年不登录，石谷网络科技可以收回该账号，以免造成资源浪费，由此造成的不利后果由用户自行承担。 </p>
            <h3>七、数据储存</h3>
            <p>1、石谷网络科技不对用户在本服务中相关数据的删除或储存失败负责。 </p>
            <p>2、石谷网络科技可以根据实际情况自行决定用户在本服务中数据的最长储存期限，并在服务器上为其分配数据最大存储空间等。用户可根据自己的需要自行备份本服务中的相关数据。 </p>
            <p>3、如用户停止使用本服务或本服务终止，石谷网络科技可以从服务器上永久地删除用户的数据。本服务停止、终止后，石谷网络科技没有义务向用户返还任何数据。 </p>
            <h3>八、风险承担</h3>
            <p>1、用户理解并同意，“石谷网络”仅为用户提供信息分享、传送及获取的平台，用户必须为自己注册账号下的一切行为负责，包括用户所传送的任何内容以及由此产生的任何后果。用户应对“石谷网络”及本服务中的内容自行加以判断，并承担因使用内容而引起的所有风险，包括因对内容的正确性、完整性或实用性的依赖而产生的风险。石谷网络科技无法且不会对因用户行为而导致的任何损失或损害承担责任。 <br/>如果用户发现任何人违反本协议约定或以其他不当的方式使用本服务，请立即向石谷网络科技举报或投诉，石谷网络科技将依本协议约定进行处理。</p>
            <p>2、用户理解并同意，因业务发展需要，石谷网络科技保留单方面对本服务的全部或部分服务内容在任何时候不经任何通知的情况下变更、暂停、终止或撤销的权利，用户需承担此风险。 </p>
            <h3>九、知识产权声明</h3>
            <p>1、除本服务中涉及广告的知识产权由相应广告商享有外，石谷网络科技在本服务中提供的内容（包括但不限于网页、文字、图片、音频、视频、图表等）的知识产权均归石谷网络科技所有，但用户在使用本服务前对自己发布的内容已合法取得知识产权的除外。 </p>
            <p>2、除另有特别声明外，石谷网络科技提供本服务时所依托软件的著作权、专利权及其他知识产权均归石谷网络科技所有。 </p>
            <p>3、石谷网络科技在本服务中所涉及的图形、文字或其组成，以及其他石谷网络科技标志及产品、服务名称（以下统称“石谷网络科技标识”），其著作权或商标权归石谷网络科技所有。未经石谷网络科技事先书面同意，用户不得将石谷网络科技标识以任何方式展示或使用或作其他处理，也不得向他人表明用户有权展示、使用、或其他有权处理石谷网络科技标识的行为。 </p>
            <p>4、上述及其他任何石谷网络科技或相关广告商依法拥有的知识产权均受到法律保护，未经石谷网络科技或相关广告商书面许可，用户不得以任何形式进行使用或创造相关衍生作品。 </p>
            <h3>十、法律责任</h3>
            <p>1、如果石谷网络科技发现或收到他人举报或投诉用户违反本协议约定的，石谷网络科技有权不经通知随时对相关内容，包括但不限于用户资料、聊天记录进行审查、删除，并视情节轻重对违规账号处以包括但不限于警告、账号封禁 、设备封禁 、功能封禁 的处罚，且通知用户处理结果。 </p>
            <p>2、因违反用户协议被封禁的用户，可以发邮件到 kefu#creatingev.com（#换成@） 查询封禁期限，并在封禁期限届满后自助解封。其中，被实施功能封禁的用户会在封禁期届满后自动恢复被封禁功能。</p>
            <p>3、用户理解并同意，石谷网络科技有权依合理判断对违反有关法律法规或本协议规定的行为进行处罚，对违法违规的任何用户采取适当的法律行动，并依据法律法规保存有关信息向有关部门报告等，用户应承担由此而产生的一切法律责任。 </p>
            <p>4、用户理解并同意，因用户违反本协议约定，导致或产生的任何第三方主张的任何索赔、要求或损失，包括合理的律师费，用户应当赔偿石谷网络科技与合作公司、关联公司，并使之免受损害。 </p>
            <h3>十一、不可抗力及其他免责事由 </h3>
            <p>1、用户理解并确认，在使用本服务的过程中，可能会遇到不可抗力等风险因素，使本服务发生中断。不可抗力是指不能预见、不能克服并不能避免且对一方或双方造成重大影响的客观事件，包括但不限于自然灾害如洪水、地震、瘟疫流行和风暴等以及社会事件如战争、动乱、政府行为等。出现上述情况时，石谷网络科技将努力在第一时间与相关单位配合，及时进行修复，但是由此给用户或第三方造成的损失，石谷网络科技及合作单位在法律允许的范围内免责。 </p>
            <p>2、本服务同大多数互联网服务一样，受包括但不限于用户原因、网络服务质量、社会环境等因素的差异影响，可能受到各种安全问题的侵扰，如他人利用用户的资料，造成现实生活中的骚扰；用户下载安装的其它软件或访问的其他网站中含有“特洛伊木马”等病毒，威胁到用户的计算机信息和数据的安全，继而影响本服务的正常使用等等。用户应加强信息安全及使用者资料的保护意识，要注意加强密码保护，以免遭致损失和骚扰。 </p>
            <p>3、用户理解并确认，本服务存在因不可抗力、计算机病毒或黑客攻击、系统不稳定、用户所在位置、用户关机以及其他任何技术、互联网络、通信线路原因等造成的服务中断或不能满足用户要求的风险，因此导致的用户或第三方任何损失，石谷网络科技不承担任何责任。 </p>
            <p>4、用户理解并确认，在使用本服务过程中存在来自任何他人的包括误导性的、欺骗性的、威胁性的、诽谤性的、令人反感的或非法的信息，或侵犯他人权利的匿名或冒名的信息，以及伴随该等信息的行为，因此导致的用户或第三方的任何损失，石谷网络科技不承担任何责任。 </p>
            <p>5、用户理解并确认，石谷网络科技需要定期或不定期地对“石谷网络”平台或相关的设备进行检修或者维护，如因此类情况而造成服务在合理时间内的中断，石谷网络科技无需为此承担任何责任，但石谷网络科技应尽可能事先进行通告。</p>
            <p>6、石谷网络科技依据法律法规、本协议约定获得处理违法违规或违约内容的权利，该权利不构成石谷网络科技的义务或承诺，石谷网络科技不能保证及时发现违法违规或违约行为或进行相应处理。 </p>
            <p> 7、用户理解并确认，对于石谷网络科技向用户提供的下列产品或者服务的质量缺陷及其引发的任何损失，石谷网络科技无需承担任何责任：<br/>
                    (1) 石谷网络科技向用户免费提供的服务；<br/>
                    (2) 石谷网络科技向用户赠送的任何产品或者服务；<br/>
                    (3) 石谷网络科技向收费服务用户附赠的各种产品或者服务。 </p>
            <p>8、在任何情况下，石谷网络科技均不对任何间接性、后果性、惩罚性、偶然性、特殊性或刑罚性的损害，包括因用户使用“石谷网络”或本服务而遭受的利润损失，承担责任（即使石谷网络科技已被告知该等损失的可能性亦然）。尽管本协议中可能含有相悖的规定，石谷网络科技对用户承担的全部责任，无论因何原因或何种行为方式，始终不超过用户因使用石谷网络科技提供的服务而支付给石谷网络科技的费用(如有)。 </p>
            <h3>十二、服务的变更、中断、终止</h3>
            <p>1、鉴于网络服务的特殊性，用户同意石谷网络科技有权随时变更、中断或终止部分或全部的服务（包括收费服务）。如变更、中断或终止的网络服务属于免费 服务，石谷网络科技无需通知用户，且石谷网络科技不应对用户或第三方承担任何责任；在用户遵守石谷网络《用户协议》的情况下，石谷网络科技变更、中断或终止的服务属于收费服务，石谷网络科技应当在变更、中断或终止之前尽可能的事先通知用户，并应向受影响的用户提供等值的替代性的收费服务，如用户不愿意接受替代性的收费服务，石谷网络科技应当按照该用户实际使用相应收费服务的情况扣除相应金额之后将剩余的金额退还用户。 </p>
            <p> 2、如发生下列任何一种情形，石谷网络科技有权变更、中断或终止向用户提供的免费服务或收费服务，而无需对用户或任何第三方承担任何责任：<br/>
                    (1) 根据法律规定用户应提交真实信息，而用户提供的个人资料不真实、或与注册时信息不一致又未能提供合理证明；<br/>
                    (2) 用户违反相关法律法规或本协议的约定；<br/>
                    (3) 按照法律规定或有权机关的要求；<br/>
                    (4) 出于安全的原因或其他必要的情形。 </p>
            <h3>十三、其他</h3>
            <p>1、石谷网络科技郑重提醒用户注意本协议中免除石谷网络科技责任和限制用户权利的条款，请用户仔细阅读，自主考虑风险。</p>
            <p>2、本协议的效力、解释及纠纷的解决，适用于中华人民共和国法律。若用户和石谷网络科技之间发生任何纠纷或争议，首先应友好协商解决，协商不成的，用户同意将纠纷或争议提交石谷网络科技住所地有管辖权的人民法院管辖。</p>
            <p>3、本协议的任何条款无论因何种原因无效或不具可执行性，其余条款仍有效，对双方具有约束力。</p>
            <p>4、本协议的版权由石谷网络科技所有，石谷网络科技保留一切解释和修改权利。 </p>
            <p class="company">--杭州石谷网络科技有限公司</p>
            
        </div>
        <div class="links"><a href="${main_host!}contract.html" target="_blank">服务条款</a> | <a href="${main_host!}privacy.html" target="_blank">隐私政策</a></div>
    </div>
</div>
<div class="footer">
    <p class="sitemap"> 
        <a href="/" target="_blank">首页</a>
        <a href="http://hz.571xz.com" target="_blank">杭州站</a>
        <a href="http://bj.571xz.com" target="_blank">北京站</a>
        <a href="http://gz.571xz.com" target="_blank">广州站</a>
        <a href="http://ss.571xz.com" target="_blank">石狮站</a>
        <a href="http://cs.571xz.com" target="_blank">常熟站</a>
        <a href="http://wa.571xz.com" target="_blank">辽源站</a>
        <a href="http://zixun.571xz.com" target="_blank">资讯</a>
        
        
        <a href="http://zixun.571xz.com/article?id=87" target="_blank">联系我们</a>
        
    </p>
    <p class="jyga">
        <span>&copy; 2009-2017 571xz.com 版权所有</span> <a href="http://www.571xz.com/templets/xingzuo/images/footer/scdjz.jpg" target="_blank" rel="nofollow">网上交易市场登记证</a>
        
        <a href="http://www.zca.gov.cn/txzf/bulletinLatest.htm?method=getBulletinDetail&amp;id=4063" target="_blank" rel="nofollow">增值电信业务经营许可证： 浙B2-20120165</a> | <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202000302" target="_blank"> <img src="http://style.571xz.com/global/css/img/beian.png" alt="浙公网安备"> 浙公网安备 33010202000302号 </a> 
    </p>
</div>
</body>
</html>