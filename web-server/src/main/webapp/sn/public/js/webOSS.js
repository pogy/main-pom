$$('fileUpload', function(){
    ////www.cnblogs.com/2050/p/3913184.html

    var accessInfoApiUrl = 'getAccessInfo.json';
    var isRandomName = false;
    var accessInfo; //授权信息
    var indexTorrent = 1;

    return exports;

    function exports(option){
        var fileUploader;

        var newOption = {
            browse_button: option.buttons, //触发文件选择对话框的按钮，为那个元素id
            url: '//imgs.571xz.net', //服务器端的上传页面地址
            //url : '//post-test.oss-cn-hangzhou.aliyuncs.com/', //服务器端的上传页面地址
            flash_swf_url : $stylepath + 'gys/plugin/plupload2.1.2/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
            silverlight_xap_url : $stylepath + 'gys/plugin/plupload2.1.2/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            //unique_names: true, //生成唯一文件名
            //file_data_name: 'fileMoreImg',
            filters: {
                mime_types : option.acceptFileList,
                max_file_size : option.maxFile || '5mb', //最大只能上传150mb的文件
                prevent_duplicates : !true //不允许选取重复文件
            },
            init: {
                BeforeUpload: function(up, file){
                    file.name = isRandomName ? getRandomName(file.name) : file.name;
                    file.path = accessInfo.host + accessInfo.dir + file.name;
                    up.setOption({
                        'url': accessInfo.host,
                        'multipart_params': {
                            'key' : accessInfo.dir + file.name, //file.name,//file.name,
                            'policy': accessInfo.policy,
                            'OSSAccessKeyId': accessInfo.accessid,
                            'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
                            'signature': accessInfo.signature
                        }
                    });
                },
                Error: function(up, err) {
                    var errorMsg;

                    if(err.code == -600){
                        errorMsg = '选择的文件不能超过'+ (option.maxFile||'5mb') +'!';
                    }else if(err.code == -601){
                        errorMsg = option.fileSuffixErrMsg || '选择的文件后缀不对!';
                    }else if(err.code == -602){
                        errorMsg = '这个文件已经上传过一遍!';
                    }else if(err.code == -200){
                        errorMsg = '上传路径不对！';
                    }else{
                        errorMsg = err.response;
                    }
                    alert(errorMsg);
                }
            }
        };
        isRandomName = option.randomName;
        accessInfoApiUrl = option.accessInfoApiUrl || accessInfoApiUrl;

        if(option.listen){

            $.each(option.listen, function(key, userMethod){
                var sysMethod = newOption.init[key];
                newOption.init[key] = sysMethod ? function(){
                    sysMethod.apply(null, arguments);
                    userMethod.apply(null, arguments);
                } : userMethod;
            });

            //$.extend(newOption.init, option.listen || {});

        }

        fileUploader = new plupload.Uploader(newOption);
        fileUploader.init();

        return start;

        function start(up, files){
            getAccessInfo(function(accessInfo){
                up.start();
            });
        }

    }





    function getAccessInfo(callback){
        if(!accessInfo || accessInfo.expire < (+new Date / 1000) + 3){ //不存在accessKey或者accessKey过期状态下，重新获取
            $$.post(accessInfoApiUrl, function(resp){
                callback(accessInfo = resp);
            });
        }else{
            callback(accessInfo);
        }
    }

    function getRandomName(oringinFileName){
        var ext = oringinFileName.match(/\.\w+$/)[0] || '';
        return (+new Date).toString(36) + (0|Math.random() * 10000000).toString(36) + indexTorrent++ + ext;
    }

});
