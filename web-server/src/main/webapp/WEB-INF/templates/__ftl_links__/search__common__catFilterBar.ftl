<div class="categoryFilterBar">
    <#if $pageid == "search">
        <div class="cateNav innerbox">
            <label>所有分类：</label>
            <div class="goodsCount"><#if query.keyword??> <span>&gt; ${query.keyword!}</span></#if>为您提供<em>${goodsCount!}</em>件宝贝</div>
        </div>
    </#if>
    <#if $pageid == "goods">
        <div class="navCate innerbox clearfix">
            <div class="layout navCon">
                <div class="navList">
                    <label>总类：</label>
                    <ul>
                        <#list navCate as cate>
                            <li <#if query.pid?? && query.pid == cate.id>class="select"</#if>>
                                <a href="?webSite=${query.webSite!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if cate.id??>&pid=${cate.id!}</#if><#if cate.keyword??>&keyword=${cate.keyword!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${cate.text!}</a>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </#if>
    <#if cates??>
        <div class="cates clearfix innerbox">
            <#if $pageid == "search">
                <label>按类目：</label>
            <#elseif $pageid == "goods">
                <label>分类：</label>
            </#if>
            <ul>
                <#if $pageid == 'goods'>
                    <li <#if query.cid??><#else>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.mid??>&mid=${query.mid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
                    </li>
                <#else>
                    <li <#if query.pid?? || query.cid??><#else>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">全部</a>
                    </li>
                </#if>
                <#list cates as cate>
                    <li <#if query.pid?? && query.pid == cate.id || query.cid?? && query.cid == cate.id >class="selected"</#if>>
                        <#if $pageid == 'goods'>
                            <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}&cid=${cate.id!}<#else>&pid=${cate.id!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${cate.text!}</a>
                        <#else>
                            <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if>&pid=${cate.id!}<#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if>">${cate.text!}</a>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if markets??>
        <div class="markets clearfix innerbox">
            <label>按市场：</label>
            <ul>
                <li <#if !query.mid>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
                </li>
                <#list markets as market>
                    <li <#if query.mid?? && query.mid == market.id>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}&mid=${market.id!}<#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.keyword??>&keyword=${query.keyword!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${market.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if styles?? && $pageid == 'goods'>
        <div class="styles clearfix innerbox">
            <label>按风格：</label>
            <ul>
                <li <#if query.keyword??><#else>class="selected"</#if>>
                    <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a>
                </li>
                <#list styles as style>
                    <li <#if query.keyword?? && query.keyword == style.keyword>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${style.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${style.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
    <#if elements?? && $pageid == 'goods'>
        <div class="elements clearfix innerbox">
            <label>按元素：</label>
            <ul>
                <li <#if query.keyword??><#else>class="selected"</#if>><a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if><#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">全部</a></li>
                <#list elements as element>
                    <li <#if query.keyword?? && query.keyword == element.keyword>class="selected"</#if>>
                        <a href="?webSite=${query.webSite!}<#if query.mid??>&mid=${query.mid!}</#if><#if query.pid??>&pid=${query.pid!}</#if><#if query.cid??>&cid=${query.cid!}</#if>&keyword=${element.keyword!}<#if query.sort??>&sort=${query.sort!}</#if><#if query.sp??>&sp=${query.sp!}</#if><#if query.ep??>&ep=${query.ep!}</#if><#if query.d??>&d=${query.d!}</#if><#if query.bpic?? && query.bpic == '1'>&bpic=1</#if><#if query.goodsVideo == '1'>&goodsVideo=1</#if>">${element.text!}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
</div>