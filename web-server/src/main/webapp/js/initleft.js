/**
 * Created by zhaohongbo on 16/5/23.
 */
function extendMenuBar(li){
    $(li).addClass('active');
    $(li).find('.zhbbar-title i.pull-right').attr("class","fa pull-right fa-angle-down");
    $(li).find('ul.treeview-menu').attr('style','display: block');
}
// --- 设置cookie
function setCookie(sName,sValue,expireHours) {
    var cookieString = sName + "=" + escape(sValue);
    //;判断是否设置过期时间
    if (expireHours>0) {
        var date = new Date();
        date.setTime(date.getTime + expireHours * 3600 * 1000);
        cookieString = cookieString + "; expire=" + date.toGMTString();
    }
    document.cookie = cookieString;
}

//--- 获取cookie
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    for (var j=0; j < aCookie.length; j++){
        var aCrumb = aCookie[j].split("=");
        if (escape(sName) == aCrumb[0])
            return unescape(aCrumb[1]);
    }
    return null;
}
//加工标题
function _parseName(menuName){
    var name=encodeURIComponent(menuName);
    name=name.replace(new RegExp(/\%/g),'');
    return name;
}

    //拿到sidemenu的数字编号
        var showmenu=getCookie("sidemenu");
        //console.log(showmenu);
        if(showmenu==null){
            showmenu='';
        }
        if(showmenu!==undefined&&showmenu!=''){
            $('ul.sidebar-menu>li').each(function(){
                //console.log('9wefwefewfewf  '+showmenu);
                var name=_parseName($(this).find('.zhbbar-title span').text());
                if(showmenu.indexOf(name)>=0){
                    extendMenuBar(this);
                }
            });
        }
    //加事件
    $('ul.sidebar-menu>li').on('click',function(){
        //console.log($(this).html());
        //先判断是关闭还是展开
        var flag=$(this).hasClass('active');
        var name=_parseName($(this).find('.zhbbar-title span').text());
        if(flag&&showmenu.indexOf(','+name)<0){//是展开
            showmenu+=','+name;
        }else{//是关闭
            showmenu=showmenu.replace(','+name,'');
        }
        setCookie('sidemenu',showmenu,1);
    });
    $('ul.sidebar-menu ul.treeview-menu li').click(function(e){
        //阻止起泡取消下面的注释
        e.stopPropagation();
    });