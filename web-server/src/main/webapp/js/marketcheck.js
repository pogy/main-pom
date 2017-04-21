var manaurl="http://admin1.571xz.net/";
function marketallData(){
    //查出随便一个店ID去请求数据
    var href=$('.floor2016 .loucheng2016').find('li').eq(0).find('a').attr('href');
    var id=href.substr(href.indexOf('id=')+3);
    $.getJSON(
        manaurl+"ckmarket/tbauthdatas.json?callback=?",
        {'storeId':id},
        function(data){
            var idarrs={};
            var datarow=data.data;
            for(var i=0;i<datarow.length;i++){
                idarrs[datarow[i].storeId]=datarow[i].endTime;
            }
            //拿到所有的li,进行处理
            var lis=$('.floor2016 .loucheng2016').find('li');
            console.log(lis);
            for(var i=0;i<lis.length;i++){
                var li=$(lis[i]);
                console.log(li);
                var lihref=li.find('a').attr('href');
                var liid=lihref.substr(lihref.indexOf('id=')+3);
                var time=idarrs[liid]*1000;
                addInitMsg(li,time);
            }
        }
    );
}
function addInitMsg(li,time){
    //如果是未授权，
    if(time==0){
        return;
    }
    li.find('.ckadd').remove();
    var a=li.find('a');
    var timestr=new Date(time).Format("yyyy-MM-dd hh:mm:ss");
    $("<p class='ckadd' style='color: brown'>"+timestr+"</p><p class='ckadd ckbtn' style='color: green'><button onclick='ssck(this)'>实时检测</button></p>").insertBefore(a);
    //按time处理时间，比现在大是正常
    var now=new Date().getTime();
    if(now<time){//没过期
        li.attr('style','background-color:#9cc2cb');
    }else{//过期
        li.attr('style','background-color:rosybrown');
    }
}
function ssck(obj){
    var li=$(obj).parent().parent();
    var href=li.find('a').attr('href');
    var id=href.substr(href.indexOf('id=')+3);
    $.getJSON(
        manaurl+"ckmarket/tbshisi.json?callback=?",
        {'storeId':id},
        function(data){
            if(data.result=='session-ok'){
                sstrue(li);
            }else{
                ssfalse(li);
            }
        }
    );
}
/**
 * 实时检测为正常
 */
function sstrue(li){
    li.attr('style','background-color:#9cc2cb');
    li.find('.ckbtn').html('有效');
}
/**
 * 实时检测为不正常
 */
function ssfalse(li){
    li.attr('style','background-color:rosybrown');
    li.find('.ckbtn').html('无效');
}

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

marketallData();