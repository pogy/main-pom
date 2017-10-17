//全部的
//不要去引用
/*==== code build by zstore0.2.2 ====*/

/*====== xz/page#config.js:2 ======*/
var $stylepath = 'http://style.571xz.com/v2/';



/*====== global/js#base.js:0 ======*/
function $$(namespace, factory, module){

    module = module || $$;

    //定义新模块
    var prevmodule; //上一级模块
    var nextkey; //下一级模块的key
    namespace.replace(/[^.]+/g, function(key){
        prevmodule = module;
        nextkey = key;
        module = module[key] = module[key] || {};
    });

    var exports = typeof factory == 'function' ? factory() : factory;

    if(typeof exports == 'function' || {}.toString.call(exports) == '[object Array]'){ //传入的是函数或数组时，直接覆盖旧的模块
        prevmodule[nextkey] = exports;
    }else if({}.toString.call(exports) == '[object Object]'){ //传入的是对象，对旧模块进行遍历扩充
        for(var key in exports){
            module[key] = exports[key];
        }
    }

}

$$('info', function(){
    return function(data){
        if(window.console && window.console.info){
            if(console.info.apply){ //ie8下console.info.apply方法不存在
                console.info.apply(null, arguments);
            }else{
                console.info(data);
            }
        }
    };
});

function $xz(namespace, factory){
    $$(namespace, factory, $xz);
}




/*====== global/js#rtpl.js:0 ======*/
$rtpl = function(){

    var utils = {
        $escape: escape,
        $tostring: tostring,
        $each: foreach
    };

    return rtpl;

    function rtpl(str, data){

        //从函数注释内提取模板
        if(typeof str == 'function'){
            str = (str +'').match(/\/\*([\w\W]+)\*\//)[1];
        }

        data = data || {};

        var lines = [];

        foreach(
            str
                .replace(/\{\{\{/g, '{{')
                .replace(/\}\}\}/g, '}}')
                .replace(/\r/g, '')
                .split(/\n/g),
            function(line){
                if(/^\s*\{\{.+?\}\}\s*$/.test(line)){
                    lines.push(trim(line));
                }else{
                    lines.push(line+'\r\n');
                }
            }

        );

        str = lines.join('');

        str = str
            .replace(/<zstoreToken:clientOpenFlag>/g, '{{')
            .replace(/<zstoreToken:clientCloseFlag>/g, '}}')
            .replace(/<zstore_module [^>]*>/g, '')
            .replace(/<\/zstore_module>/g, '');

        var uniq = {$data:1, $out:1};

        var p1 = '$out.push(';
        var p2 = ');';

        var header = 'var ';
        var body = '$out = [];';
        var footer = 'return $out.join("")';

        foreach(str.split('{{'), function(code){

            code = code.split('}}');

            if(code.length == 1){
                body += html(code[0]);
            }else{
                body += makejs(code[0]);
                if(code[1]){
                    body += html(code[1]);
                }
            }

        });

        var code = header + body + footer;

        try{
            return format(trim(Function("$utils", "$data", code)(utils, data)));
        }catch(e){
            throw e;
        }

        function html(code){
            return p1 + stringify(code) + p2 +'\n';
        }

        function makejs(code){

            code = parse(code);

            foreach(getVariable(code), function(name){

                if(uniq[name]){
                    return;
                }

                var value;

                // 声明模板变量
                // 赋值优先级:
                // utils > data
                if (utils[name]) {
                    value = "$utils." + name;
                }else if(name in data){
                    value = "$data." + name;
                }else{
                    value = 'undefined';
                }

                header += name + "=" + value + ",";

                uniq[name] = true;

            });

            return code + "\n";
        }

        //分析逻辑指令
        function parse(code){

            var split = code.split(' ');
            var key = split.shift();
            var args = split.join(' ');

            switch(key){

                case 'if':

                    code = 'if('+ args +'){';
                    break;

                case 'else':

                    if (split.shift() == 'if') {
                        code = '}else if('+ split.join(' ') +'){';
                    } else {
                        code = '}else{';
                    }
                    break;

                case '/if':

                    code = '}';
                    break;

                case 'each':

                    var object = split[0] || '$data';
                    var as     = split[1] || 'as';
                    var value  = split[2] || '$value';
                    var index  = split[3] || '$index';

                    var param   = value +','+ index;

                    if (as != 'as') {
                        object = '[]';
                    }

                    code =  '$each('+ object +',function('+ param +'){';
                    break;

                case '/each':

                    code = '});';
                    break;

                case 'break':
                    code = 'return false;';
                    break;
                case 'continue':
                    code = 'return;';
                    break;

                case 'module':
                    //console.info(args)
                    var zstorepath_zstoredata = args.split(' ');
                    var zstorepath = zstorepath_zstoredata.shift();
                    var zstoredata = zstorepath_zstoredata.join(' ');

                    if(zstoredata){
                        zstoredata = trim(zstoredata)
                            .replace(/\\\\/g, '\\')
                            .replace(/\\\{/g, '{')
                            .replace(/\\\}/g, '}')
                        ;

                    }

                    if(zstoredata){
                        code = '$out.push(function(){ try{ var $it = '+zstoredata+';}catch(e){return "<error>";} try{var $out = [];';
                    }else{
                        code = '$out.push(function($it, $out){$it = {};try{$out = [];';
                    }

                    break;
                case '/module':
                    code = ' return $out.join("");}catch(e){return "<error>";} }());';
                    break;
                case 'script':
                    code = '';
                    break;
                default:

                    if(/^#/.test(key)){
                        code = "$tostring("+ code.substr(1) +")";
                    }else{
                        code = "$escape("+ code +")";
                    }

                    code = p1 + code + p2;
            }

            return code;

        }

        function trim(str){
            return str.replace(/^\s+|\s$/g, '');
        }

    }

    function escape(str){
        return tostring(str)
            .replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;');
    }

    function tostring(str){
        if(str == null){
            return '';
        }
        return ''+ str;
    }

    function foreach(data, callback){
        if({}.toString.call(data) == '[object Array]'){
            for(var i = 0; i < data.length; i++){
                callback.call(data, data[i], i, data);
            }
        }else{
            for (var i in data) {
                callback.call(data, data[i], i);
            }
        }
    }

    function stringify(str){
        return "'"+ (''+ str)
            .replace(/('|\\)/g, '\\$1')
            .replace(/\r/g, '\\r')
            .replace(/\n/g, '\\n') + "'";
    }

//获取模板中的变量名
    function getVariable(code){

        var KEYWORDS =
            // 关键字
            'break,case,catch,continue,debugger,default,delete,do,else,false'
            + ',finally,for,function,if,in,instanceof,new,null,return,switch,this'
            + ',throw,true,try,typeof,var,void,while,with'

            // 保留字
            + ',abstract,boolean,byte,char,class,const,double,enum,export,extends'
            + ',final,float,goto,implements,import,int,interface,long,native'
            + ',package,private,protected,public,short,static,super,synchronized'
            + ',throws,transient,volatile'

            //+ ',Math'

            // ECMA 5 - use strict
            + ',arguments,let,yield'

            + ',undefined';

        var REMOVE_RE = /\/\*[\w\W]*?\*\/|\/\/[^\n]*\n|\/\/[^\n]*$|"(?:[^"\\]|\\[\w\W])*"|'(?:[^'\\]|\\[\w\W])*'|\s*\.\s*[$\w\.]+/g;
        var SPLIT_RE = /[^\w$]+/g;
        var KEYWORDS_RE = new RegExp(["\\b" + KEYWORDS.replace(/,/g, '\\b|\\b') + "\\b"].join('|'), 'g');
        var NUMBER_RE = /^\d[^,]*|,\d[^,]*/g;
        var BOUNDARY_RE = /^,+|,+$/g;
        var SPLIT2_RE = /^$|,+/;

        // 获取变量
        getVariable = function(code){
            return code
                .replace(REMOVE_RE, '')
                .replace(SPLIT_RE, ',')
                .replace(KEYWORDS_RE, '')
                .replace(NUMBER_RE, '')
                .replace(BOUNDARY_RE, '')
                .split(SPLIT2_RE);
        };

        return getVariable(code);
    }

    function format(code){ //格式化对齐缩进
        var
            lineText = code.split('\n'),
            linePadding = Array(30).join(' ');
        for(var i = 1; i < lineText.length; i++){

            if(/^\s*$/.test(lineText[i])){ //过滤空行
                continue;
            }

            var curPadding = lineText[i].match(/^\s*/)[0];
            if(curPadding){
                linePadding =
                    curPadding.length < linePadding.length
                        ? curPadding
                        : linePadding;
            }else{
                linePadding = '';
                break;
            }

        }

        return code.replace(RegExp('^'+linePadding, 'mg'), '');
    }

}();



/*====== jq/wgt#window.js:0 ======*/
$$('window', function(){

    var pid = 0;
    var openLength = 0; //当前打开的窗口数量
    var options = {}; //多例配置
    var exports = {
        open: open,
        alert: alert,
        confirm: confirm
    };

    var OVERFLOW_Y = $('html').css('overflow-y'); //默认的overflow属性
    var SCROLL_WIDTH;
    $(function(){
        SCROLL_WIDTH = getScrollSize(); //滚动条宽度
    });

    $(document).on('click', '[jbtn="jqWindow.close"],[jbtn="jqWindow.submit"]', function(e){
        ({
            'jqWindow.close': close,
            'jqWindow.submit': submit
        })[$(this).attr('jbtn')]($(this).parents('.jqWindow'), this);

    });

    $(window).on('resize', function(){
        if(openLength){
            $.each(options, function(pid, option){
                setPosition(option.$window);
            });
        }
    });

    return exports;

    function open(content, option){

        option = option || {};
        openLength++;

        var $container = $($rtpl(function(){/*
            <div data-pid="{{pid}}" class="jqWindow {{clsName ? ''+ clsName : ''}}">
                <div class="masklayer"></div>
                {{if closeButton == 'outer'}}<i class="outerCloseButton icon-close" jbtn="jqWindow.close"></i>{{/if}}
                <div class="jqWindowWrapper">
                    <div class="jqWindowPanel">
                        {{if closeButton == 'inner'}}<i jbtn="jqWindow.close" class="innerCloseButton icon-close"></i>{{/if}}
                        {{if title}}<div class="title"><em style="display:block">{{title}}</em></div>{{/if}}
                        <div class="jqWindowContent">
                            {{#content}}
                            {{if buttonStyle}}
                                <div class="buttonbox {{buttonStyle}}Style"><b jbtn="jqWindow.submit" class="ok">确定</b><b jbtn="jqWindow.close" class="close">取消</b></div>
                            {{/if}}
                        </div>
                    </div>
                </div>
            </div>
        */}, {
            pid: ++pid,
            content: content,
            title: option.title,
            clsName: option.clsName,
            closeButton: option.closeButton || 'inner',  //'inner|outer|none'
            buttonStyle: option.buttonStyle,
            end: null
        }));

        $('body').append($container);

        var $windowPanel = $container.find('.jqWindowPanel');

        options[pid] = {
            onsubmit: option.onsubmit,
            onclose: option.onclose,
            $window: $windowPanel
        };

        var cssAttr = {};
        var hasAttr = false;
        $.each('width height'.split(' '), function(i, name){
            if(name in option){
                hasAttr = true;
                cssAttr[name] = option[name] +'px';
            }
        });

        if(hasAttr){
            $windowPanel.css(cssAttr);
        }

        if(openLength == 1){
            $('html').css('overflow-y', 'hidden');
            if(OVERFLOW_Y == 'scroll'){
                $('html').css('margin-right', SCROLL_WIDTH);
            }
        }

        $container.show();

        setPosition($windowPanel);

        return {
            close: function(){
                close($container);
            },
            submit: function(){
                submit($container);
            },
            refresh: function(){
                setPosition($windowPanel);
            }
        };

    }

    function close($container, button){

        openLength--;

        var pid = $container.attr('data-pid');
        var onclose = options[pid].onclose;
        onclose && onclose(button);
        delete options[pid];

        $container.remove();

        if(!openLength){ //恢复滚动条
            $('html').css('overflow-y', OVERFLOW_Y);
            if(OVERFLOW_Y == 'scroll'){
                $('html').css('margin-right', 0);
            }
        }

    }

    function submit($container, button){
        var onsubmit = options[$container.attr('data-pid')].onsubmit;
        if(!onsubmit || onsubmit &&
            onsubmit(button, function(){
                close($container, button);
            }) !== false //返回为false为异步，需要手动调用resolve
        ){
            close($container, button);
        }
    }

    function alert(msg, onclose){
        open('<div class="msgbox fs14">'+ msg +'</div><div class="buttonbox"><b jbtn="jqWindow.submit" class="ok">确定</b></div>', {title:'系统提示', clsName:'sysbox', onclose:onclose});
    }

    function confirm(msg, yes, no){
        open('<div class="msgbox fs14">'+ msg +'</div><div class="buttonbox"><b jbtn="jqWindow.submit" class="ok">确定</b><b jbtn="jqWindow.close" class="close">取消</b></div>', {title:'系统提示', clsName:'sysbox', onclose:no, onsubmit:yes});
    }

    function setPosition($windowPanel){
        $windowPanel.css({
            marginLeft: -$windowPanel.width() / 2,
            marginTop: -Math.min( window.innerHeight || document.documentElement.clientHeight, $windowPanel.height() ) / 2
        });
    }

    function getScrollSize(){
        var div = document.createElement('div');
        div.style.cssText = 'position:absolute; top:-99px; width:66px; height:66px;';
        document.body.appendChild(div);
        var width = div.clientWidth;
        div.style.overflow = 'scroll';
        width -= div.clientWidth;
        document.body.removeChild(div);
        return width;
    }

});

$$('alert', function(){
    return function(){
        $$.window.alert.apply(null, arguments);
    };
});

$$('confirm', function(){
    return function(){
        $$.window.confirm.apply(null, arguments);
    };
});




/*====== jq/wgt#post.js:0 ======*/
$$.post = function(url, callback, data, option){

    option = option || {loaddingType: -1};
    var timeout = option.timeout || 600000;
    var loaddingText = option.loaddingText || '正在同步中，请稍后…';
    var loaddingType = option.loaddingType || 10;
    var tipsBox;
    var loaddingCtn = option.loaddingCtn;
    var postDataEscape = option.postDataEscape || false;
    var delay = option.delay >= 0 ? option.delay : 1000; //默认延迟时间
    var startTime = +new Date;

    if(loaddingType == -1){

    }else if(loaddingType == 1){

        tipsBox = $$.window.open($rtpl(function(){/*
            <div class="loadingShow">
                <p class="loadingGif"><i></i></p>
                <p>{{loaddingText}}</p>
            </div>
        */},{loaddingText:loaddingText}), {clsName:'lgWindow', title:'提示'});
    }else{
        tipsBox = $('<div class="jqPostTipbox"><div class="masklayer"></div><span class="tipstext">数据提交中，请稍后...</span></div>');
        if(loaddingCtn){
            tipsBox.css('position', 'absolute');
            $(loaddingCtn).append(tipsBox);
        }else{
            tipsBox.css('position', 'fixed');
            $('body').append(tipsBox);
        }
    }

    $.ajax({
        url:url,
        type:'post',
        data:data,
        dataType:'json',
        timeout:timeout,
        success:function(data){
            if(loaddingType == -1){
                if(data.result == 'success' || data.result === true){
                    callback(data);
                }else if(typeof data == 'object'){
                    data.err = data.msg || '数据错误';
                    callback(data);
                }else{
                    callback({
                        err: '数据格式错误，返回的数据不能为字符串！'
                    });
                }
            }else{
                setTimeout(function(){
                    if(loaddingType == 1){
                        tipsBox && tipsBox.close();
                    }else{
                        tipsBox && tipsBox.remove();
                    }
                    if(data.result == 'success' || data.result === true){
                        callback(data);
                    }else if(typeof data == 'object'){
                        data.err = data.msg || '数据错误';
                        callback(data);
                    }else{
                        callback({
                            err: '数据格式错误，返回的数据不能为字符串！'
                        });
                    }
                }, Math.max(0, delay - (+new Date - startTime) ) );
            }

        },
        error:function(data){
            setTimeout(function(){
                if(loaddingType == 1){
                    tipsBox && tipsBox.close();
                }else{
                    tipsBox && tipsBox.remove();
                }
                callback({
                    err: '请求异常'
                });
            }, 666);
        }
    });

};



/*====== jq/wgt#datepicker.js:0 ======*/
$$.datepicker = function(){

    var exports = {};
    var $input; //当前激活的input
    var $panel; //日历面板
    var visible; //日历面板是否显示
    var year;//当前的年
    var month;//当前的月，从0开始
    var now = new Date;
    var selected = now;
    var dates = [];

    $(function(){
        $('body').append($panel = $('<div class="jqDatepickerWindow"></div>'));

        $(document)
            .on('click', setEvent)
            .on('keyup', setEvent);

        $panel.click(function(e){

            e.stopPropagation();

            var $target = $(e.target);

            if($target.hasClass('disable')){
                return;
            }

            if($target.hasClass('day')){
                var old_value =  $input.val();
                var new_value = pickdate($target.attr('dates-index'), $input.attr('data-format'));
                if(old_value != new_value){
                    $input.val(new_value).change();
                }
                hide();
            }else if($target.hasClass('prev-year')){
                render(year - 1, month);
            }else if($target.hasClass('prev-month')){
                render(year, month - 1);
            }else if($target.hasClass('next-year')){
                render(year + 1, month);
            }else if($target.hasClass('next-month')){
                render(year, month + 1);
            }

        });

        function setEvent(e){

            var target = e.target;

            if($input && $input[0] != target){
                hide();
            }

            if(
                $(target).hasClass('jqDatepicker') && (!visible || $input && $input[0] != target)){
                show(target);
            }

        }

    });

    return exports;

    function hide(){
        $panel.hide();
        $input = null;
        visible = false;
    }

    function show(input){
        $input = $(input);

        var old_date = formatdate($input.val());

        selected = old_date || now;

        render(selected.getFullYear(), selected.getMonth());

        $panel
            .css({
                display:'block',
                left:$input.offset().left,
                top:$input.offset().top + $input[0].offsetHeight,
                opacity:0
            })
            .animate({opacity:1}, 200);
        visible = true;
    }

    function render(newYear, newMonth){

        year = newYear;
        month = newMonth;
        if(newMonth == 12){ //输入的月大于12，说明是下一年
            year = ++newYear;
            month = 0;
        }else if(newMonth == -1){ //等于-1，说明是上一年
            year = --newYear;
            month = 11;
        }

        $panel.html('\
            <div class="zjs-datepicker-days"><table>\
                <thead>\
                    <tr>\
                        <th class="prev-year" title="上一年">‹‹</th>\
                        <th class="prev-month" title="上个月">‹</th>\
                        <th class="date disable" colspan="3">'+ [year, month + 1].join('.').replace(/\.(\d)$/, '.0$1') +'</th>\
                        <th class="next-month" title="下个月">›</th>\
                        <th class="next-year" title="下一年">››</th>\
                    </tr>\
                    <tr>\
                        <th class="disable">日</th>\
                        <th class="disable">一</th>\
                        <th class="disable">二</th>\
                        <th class="disable">三</th>\
                        <th class="disable">四</th>\
                        <th class="disable">五</th>\
                        <th class="disable">六</th>\
                    </tr>\
                </thead>\
                <tbody>\
                '+ function(){

            //上个月的日期
            var prev_month_last_date = new Date(year, month, 0).getDate(); //上个月的总天数


            var cur_month_first_date = new Date(year, month, 1);
            var prev_month_day_show_count = cur_month_first_date.getDay(); //上个月需要显示的日期

            var cur_month_day_show_count = new Date(year, month + 1, 0).getDate(); //当前月份天数

            var cur_month_end_date = new Date(year, month, cur_month_day_show_count);
            var next_month_day_show_count = 6 - cur_month_end_date.getDay(); //下个月需要显示的日期

            dates = [];
            var day_text = prev_month_last_date - prev_month_day_show_count + 1;
            for(var i = 0; i < prev_month_day_show_count; i++){
                dates.push(new Date(year, month - 1, day_text++));
            }

            var day_text = 1;
            for(var i = 0; i < cur_month_day_show_count; i++){
                dates.push(new Date(year, month, day_text++));
            }

            var day_text = 1;
            for(var i = 0; i < next_month_day_show_count; i++){
                dates.push(new Date(year, month + 1, day_text++));
            }

            var dates_index = 0;
            var tbody = [];
            var dates_copy = dates.slice(0);
            while(dates_copy.length){
                tbody.push('<tr>');
                for(var i = 0; i < 7; i++){
                    var date = dates_copy.shift();
                    var cur_month = date.getMonth();
                    var text = date.getDate();
                    var className = ['day'];

                    if(cur_month == month){

                    }else if(cur_month < month){
                        className.push('prev-month-day');
                    }else{
                        className.push('next-month-day');
                    }

                    if(
                        selected.getFullYear() == date.getFullYear() &&
                        selected.getMonth() == date.getMonth() &&
                        selected.getDate() == date.getDate()
                    ){
                        className.push('selected');
                    }

                    tbody.push('<td class="'+ className.join(' ') +'" dates-index="'+ dates_index++ +'">'+ text +'</td>');

                }
                tbody.push('</tr>');
            }

            return tbody.join('');

        }() +'\
                </tbody>\
            </table></div>\
        ');

    }

    function pickdate(index, format){
        format = format || '%Y.%M.%D';
        var date = dates[index];
        var maps = {
            '%Y': date.getFullYear(),
            '%M': ('0'+ (date.getMonth() + 1)).match(/\d\d$/)[0],
            '%D':  ('0'+ date.getDate()).match(/\d\d$/)[0]
        };
        return format.replace(/(%Y)|(%M)|(%D)/g, function(match, year, month, date){
            return maps[match];
        });
    }

    function formatdate(date){
        var old_date;
        date.replace(/(\d{4})[.-](\d\d)[.-](\d\d)/, function(match, year, month, date){
            old_date = new Date(year, month - 1, date);
        });
        return old_date;
    }

}();



/*====== jq/wgt#search.js:0 ======*/
$$.search = function(){
    var $container;
    var href = location.href.split('#')[0].split('?')[0];

    $(function(){
        $container = $('#wgt_search');
    });

    search.set = function(name, value){
        if(typeof name == 'object'){
            $.each(name, search.set);
        }else{
            $container.find('input[name='+ name +']').val(value);
        }
    };

    search.get = function(name){
        if(name == null || name === true){
            var datas = {};
            $container.find('input').each(function(){
                if(name === true && !/^\s*$/.test(this.value) || name == null){
                    datas[this.name] = this.value;
                }
            });
            return datas;
        }else{
            return $container.find('input[name='+ name +']').val();
        }
    };

    return search;

    function search(callback, option){
        option = option || {};
        //console.info(search.get());
        var data =  search.get(); //默认数据
        if(typeof callback == 'function'){
            var newdata = callback(data); //修改返回的数据
        }else if(typeof callback == 'object'){ //传入的是对象，则添加到数据到默认的数据
            $.each(callback, function(name, value){
                data[name] = value;
            });
        }

        var senddata = newdata || data; //当没有返回数据时，使用data数据，即data可能会在callback中已经发生修改
        var param = [];
        $.each(senddata, function(name, value){
            if(!/^\s*$/.test(value)){
                param.push(name +'='+ value);
            }
        });
        param = param.length ? '?'+ param.join('&') : '';
        location.href = (option.href || href) + param;

    }
}();


/*====== jq/wgt#pagination.js:0 ======*/
$$('pagination', function(){

    var DEFAULT_ID = '#jqPagination0'; //默认id
    var DEFAULT_BTN_COUNT = 9; //默认按钮个数

    return function(id, callback, option){

        if(typeof id == 'function'){ //只传一个参数，默认id
            option = callback;
            callback = id;
            id= DEFAULT_ID;
        }

        option = option || {};
        var $container =  $(id);
        if(option.pageStyle){
            $container.addClass(option.pageStyle);
        }

        var pageOption = $container.attr('data-option').split(',');
        var ITEM_COUNTS = +pageOption[0]; //总个数
        var PAGE_SIZE = +pageOption[1]; //分页条数
        var PAGE_FOCUS = +pageOption[2]; //当前选中页
        var PAGE_COUNT = Math.ceil(ITEM_COUNTS / PAGE_SIZE); //页码总数
        var BUTTON_COUNTS = option.btnCount || DEFAULT_BTN_COUNT; //显示按钮个数

        var curpage = PAGE_FOCUS;

        $container = $container.html('<div class="inner"></div>');

        render();

        bindClick($container);

        return {
            reload: function(data_option){
                $container.attr('data-option', data_option);
                var pageOption = data_option.split(',');
                ITEM_COUNTS =+ pageOption[0];
                PAGE_SIZE =+ pageOption[1];
                PAGE_FOCUS =+ pageOption[2];
                PAGE_COUNT =+ Math.ceil(ITEM_COUNTS / PAGE_SIZE);

                curpage = PAGE_FOCUS;

                render();
            }
        }

        function bindClick(container){
            container.on('click', '[jq_pagination_button]', function(){
                var index = $(this).attr('jq_pagination_button');
                if(index == 'next'){
                    if(curpage < PAGE_COUNT){
                        focus(curpage + 1);
                    }
                }else if(index == 'prev'){
                    if(curpage > 0){
                        focus(curpage - 1);
                    }
                }else if(index == 'goto'){
                    var newpage = parseInt($container.find('input').val());
                    if(newpage > 0 && newpage <= PAGE_COUNT){
                        focus(newpage);
                    }else{
                        alert('请输入正确的页数');
                    }
                }else if(index != curpage){
                    focus(+index);
                }
            });
        }

        function render(){
            var
                SIZE = BUTTON_COUNTS,
                TOTAL = PAGE_COUNT,
                current = curpage,
                offset = SIZE / 2,
                prev = '',
                next = '',
                header = '', //头部点
                tailer = '', //尾部点
                body = '',
                numSize = SIZE, //中间部分数字长度
                num, //中间开始页码
                i = 0;



            //如果当前页是首页
            prev = current == 1 ? '<span class="prev dis">上一页</span>' : '<span class="prev" jq_pagination_button="prev">上一页</span>';
            //如果当前页是最后一页
            next = current == TOTAL ? '<span class="next dis"></span>' : '<span class="next" jq_pagination_button="next">下一页</span>';

            if(TOTAL > SIZE){//页码总数大于按钮个数，有左右点
                if(current > offset){ //有左点dot
                    header = '<span class="num" jq_pagination_button="1">1</span><span class="dot">...</span>';
                    numSize -= 2;
                }
                if((TOTAL - current) > (offset - 1)){ //有右点dot
                    tailer = '<span class="dot">...</span><span class="num" jq_pagination_button="'+TOTAL+'">'+TOTAL+'</span>';
                    numSize -= 2;
                }
            }else{
                numSize = Math.min(numSize, TOTAL);
            }

            num = //中间部分数字
                header && tailer //左右都有点
                    ? current - ~~(numSize/2)
                    : tailer
                    ? 1 //只有尾部有点
                    : TOTAL + 1 - numSize; //只有头部有点

            while(numSize--){
                body += num == current //当前页面
                    ? '<span class="num cur">'+num+'</span>'
                    : '<span class="num" jq_pagination_button="'+num+'">'+num+'</span>';
                num++;
            }

            var info = [
                '<span class="info">共'+ TOTAL +'页</span>',
                '<span class="goto">到第<input>页<button jq_pagination_button="goto">确定</button></span>'
            ].join('');


            $container.find('.inner').html([prev, header, body, tailer, next, info]);

            if(TOTAL > 1){
                $container.show();
            }else{
                $container.hide();
            }
        }

        function focus(index){
            callback(curpage = index);
            render();
        }

    };
});



/*====== dfgl/page#windowOperate.js:0 ===可能已废弃===*/
$$('windowOperate', function(){
    var windowOperate = {};

    windowOperate.chooseUser = function(userList){
        $$.window.open($rtpl(function(){/*
            <div class="chooseUserBox fc6 yahei fs14">
                <ul>
                    {{each userList as user}}
                    <li><label><input type="radio" name="users" data-userid="{{user.id}}">{{user.name}}</label></li>
                    {{/each}}
                </ul>
            </div>
            <div class="buttonbox">
                <b jbtn="submitAllocation" class="ok">确定</b>
                <b jbtn="jqWindow.close" class="close">取消</b>
            </div>
        */},{userList: userList}), {
            title: '请选择用户',
            clsName: 'windowStyle chooseUerWindow'
        });
    };

    windowOperate.setTime = function(callback){
        $$.window.open($rtpl(function(){/*
            <div class="setTimeBox">
                <input class="fmInput" placeholder="点击设置有货时间" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            </div>
            <div class="buttonbox">
                <b jbtn="jqWindow.submit" class="ok">设置</b>
                <b jbtn="jqWindow.close" class="close">取消</b>
            </div>
        */}), {
            title: '设置时间',
            clsName: 'windowStyle setTimeWindow',
            onsubmit: callback
        });
    };

    windowOperate.setRemark = function(callback){
        $$.window.open($rtpl(function(){/*
            <div class="setRemarkBox">
                <textarea class="fs14 fc3 yahei"></textarea>
            </div>
            <div class="buttonbox">
                <b jbtn="jqWindow.submit" class="ok">确定</b>
                <b jbtn="jqWindow.close" class="close">取消</b>
            </div>
        */}), {
            title: '备注内容',
            clsName: 'windowStyle setRemarkWindow',
            onsubmit: callback
        });
    };

    windowOperate.errorTip = function(msg){
        $$.window.open($rtpl(function(){/*
            <div class="msgbox yahei fs14 fc6">
                {{msg}}
            </div>
            <div class="buttonbox">
                <b jbtn="jqWindow.close" class="ok">我知道了</b>
            </div>
        */},{msg: msg}), {
            title: '系统提示',
            clsName: 'windowStyle'
        });
    };

    windowOperate.setGoodsNo = function(callback){
        $$.window.open($rtpl(function(){/*
            <div class="setGoodsNoBox">
                <p class="fcF40 yahei">输入的货号无法修改，请谨慎填写</p>
                <input class="fs14 fc3 yahei goodsNoCon" type="text"></>
            </div>
            <div class="buttonbox">
                <b jbtn="jqWindow.submit" class="ok">确定</b>
                <b jbtn="jqWindow.close" class="close">取消</b>
            </div>
        */}), {
            title: '设置商品货号',
            clsName: 'windowStyle setGoodsNoWindow',
            onsubmit: callback
        });
    };

    return windowOperate;

});



/*====== dfgl/page#noSale.js:0 ===已废弃===*/
$(function(){
    var userList;
    var childOrderId;
    $(document).on('click', '[jbtn=noSale]', function(){
        childOrderId = $(this).parents('.childOrderItem').attr('data-id');
        if(!userList){
            $$.post('getUserList.json', function(resp){
                if(resp.err){
                    $$.windowOperate.errorTip(resp.err);
                }else{
                    userList = resp.userList;
                    $$.windowOperate.chooseUser(resp.userList);
                }
            });
        }else{
            $$.windowOperate.chooseUser(userList);
        }
    });

    $(document).on('click', '[jbtn=submitAllocation]', function(){
        var userid = $('.chooseUerWindow .chooseUserBox input:checked').attr('data-userid');
        if(!userid || userid == ""){
            return;
        }else{
            $('.chooseUerWindow .buttonbox .close').click();
            $$.post('setTallyJson.json', function(resp){
                if(resp.err){
                    $$.windowOperate.errorTip(resp.err);
                }else{
                    $$.alert('标记成功', function(){
                        location.reload();
                    });
                }
            },{
                userId: userid,
                childOrderId: childOrderId
            },{});
        }
    });
});



/*====== dfgl/page#setHaveGoodsTime.js:0 ===已废弃===*/
$(function(){
    $(document).on('click', '[jbtn=setTime]', function(){
        var childOrderId = $(this).parents('.childOrderItem').attr('data-id');
        $$.windowOperate.setTime(function(){
            var timeStr = $('.setTimeBox .fmInput').val();
            if(!timeStr){
                return $$.windowOperate.errorTip('请填写时间');
            }
            $$.post('setTimeJson.json', function(resp){
                if(resp.err){
                    $$.windowOperate.errorTip(resp.err);
                }else{
                    $$.alert('设置成功', function(){
                        location.reload();
                    });
                }
            },{timeStr: timeStr, childOrderId: childOrderId});
        });
    });
});



/*====== dfgl/page#addChildRemark.js:0 ====已废弃==*/
$(function(){
    $(document).on('click', '[jbtn=addChildRemark]', function(){
        var childOrderId = $(this).parents('.childOrderItem').attr('data-id');
        $$.windowOperate.setRemark(function(){
            var addRemarkCon = $('.setRemarkBox textarea').val();
            if(!addRemarkCon || addRemarkCon == ""){
                return $$.windowOperate.errorTip('请填写备注内容');
            }
            $$.post('addChildRemarkJson.json', function(resp){
                if(resp.err){
                    $$.windowOperate.errorTip(resp.err);
                }else{
                    $$.alert('添加成功', function(){
                        location.reload();
                    });
                }
            },{childOrderId: childOrderId, remarkCon: addRemarkCon});
        });
    });
});



/*====== dfgl/orderAll#orderCon.js:0 ======*/
$(function(){
    $$.pagination(function(page){
        $$.search({page: page});
    })
});

/*====== dfgl/orderAll#orderSearch.js:1 ======*/
$(function(){
    $(document).on('click', '[jbtn=searchBtn]', function(){
        $$.search({
            page: 1,
            roleName: $('.orderSearchBox [name=roleName]').val(),
            roleTag: $('.orderSearchBox [name=roleTag]').val(),
            createUserId: $('.orderSearchBox [name=createUserId]').val(),
            status: $('.orderSearchBox [name=status]').val()
        });
    });
});


