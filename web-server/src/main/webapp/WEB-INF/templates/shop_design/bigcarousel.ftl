<div class=" J_TModule" data-title="全屏轮播" data-id="${moduleSet.moduleId!}">
    <link rel="stylesheet" href="/design/js/swiper/css/swiper.min.css">
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
    <div class="skin-box" style="width: 1920px;">
        <div class="fullscreen-img">
            <div class="J_TWidget slide-box" style="min-height: 100px; height: ${viewPager.modHeight}px;">
                <div id="_${moduleSet.moduleId!}" class="swiper-container swiper-container-horizontal">
                    <ul class="swiper-wrapper">
                        <#if moduleSet.images??>
                            <#list moduleSet.images as img>
                            <li class="swiper-slide" style="width: 100%;">
                                <a href="${img.targetUrl!}" target="_blank">
                                    <img style="width: 100%;" src="${img.picUrl!}">
                                </a>
                            </li>
                            </#list>
                        </#if>
                    </ul>
                    <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/design/js/swiper/swiper.min.js"></script>
    <script type="text/javascript">
        var swiper = new Swiper('#_${moduleSet.moduleId!}', {
            pagination: '#_${moduleSet.moduleId!} .swiper-pagination',
            paginationClickable: true,
            spaceBetween: 30,
            autoplay: 2500,
            autoplayDisableOnInteraction: false,
            paginationBulletRender: function (swiper, index, className) {
                return '<span class="' + className + '"></span>';
            }
        });
    </script>
</div>