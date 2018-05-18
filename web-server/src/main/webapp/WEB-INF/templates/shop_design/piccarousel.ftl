<div class=" J_TModule" data-title="图片轮播" data-id="${moduleSet.moduleId}">
    <link rel="stylesheet" href="//www.571xz.com/design/js/swiper/css/swiper.min.css">
    <style>
        .swiper-container {
            width: 100%;
            height: 100%;
        }

        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
    </style>
    <div class="skin-box">
    <#if moduleSet.titleShow == 1>
        <div class="skin-box-hd">
            <h3>${moduleSet.title!}</h3>
        </div>
    </#if>
        <div class="skin-box-bd">
            <div class="J_TWidget slide-box" style="min-height: 100px; height: ${moduleSet.modHeight}px;">
                <div id="_${moduleSet.moduleId}" class="swiper-container swiper-container-horizontal">
                    <ul class="swiper-wrapper">
                        <#list moduleSet.images as img>
                            <li class="swiper-slide" style="width: 100%;">
                                <a href="<#if img.targetUrl != ''>${img.targetUrl!}<#else>javascript:void(0)</#if>" target="_blank">
                                    <img style="width: 100%;" src="${img.picUrl!}">
                                </a>
                            </li>
                        </#list>
                    </ul>
                    <div class="swiper-pagination"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="//www.571xz.com/design/js/swiper/swiper.min.js"></script>
    <script type="text/javascript">
        var swiper = new Swiper('#_${moduleSet.moduleId}', {
            pagination: '#_${moduleSet.moduleId} .swiper-pagination',
            paginationClickable: true,
            spaceBetween: 30,
            <#if moduleSet.modType==2>
                effect: 'fade',
            </#if>
            autoplay: 2500,
            autoplayDisableOnInteraction: false,
            paginationBulletRender: function (swiper, index, className) {
                return '<span class="' + className + '"></span>';
            }
        });
    </script>
</div>