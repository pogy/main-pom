<div class="p-userNav layout yahei">
    <ul>
        <li <#if $pageid == 'userWorkList' || $pageid == 'userValidate' || $pageid == 'uploadWork' || $pageid == 'validSuccess' >class="select"</#if>><a href="/photo/member/userWorkList.htm">作品集</a></li>
        <li <#if $pageid == 'userProfile' || $pageid == 'userProfileEdit'>class="select"</#if>><a href="/photo/member/userProfile.htm">个人资料</a></li>
    </ul>
</div>