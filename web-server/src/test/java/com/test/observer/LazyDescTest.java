package com.test.observer;

import com.shigu.tools.HtmlImgsLazyLoad;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.*;

/**
 * Created by wxc on 2017/3/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class LazyDescTest {

    String desc = "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2Fyi8hgJlpuFjSspjXXcT.pXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB21ryFhbtlpuFjSspfXXXLUpXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB22jlwiHlmpuFjSZFlXXbdQXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2d6mEhl0kpuFjSsziXXa.oVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2rZyKheJ8puFjy1XbXXagqVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB23FaFhhXkpuFjy0FiXXbUfFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2VLVjiNBmpuFjSZFsXXcXpFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB22BxiiUlnpuFjSZFjXXXTaVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i3/812490113/TB2xIFMiH4npuFjSZFmXXXl4FXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2ruB6diC9MuFjSZFoXXbUzFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2ef0jiNBmpuFjSZFsXXcXpFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2OLJciSVmpuFjSZFFXXcZApXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2FfiFhbXlpuFjSszfXXcSGXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2syfthgxlpuFjy0FoXXa.lXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2Kpq_hbFkpuFjy1XcXXclapXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2UVq_hbFkpuFjy1XcXXclapXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2bxqRhgRkpuFjy1zeXXc.6FXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2HXKChgNlpuFjy0FfXXX3CpXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2u8BLiHBmpuFjSZFAXXaQ0pXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2iy8xiNhmpuFjSZFyXXcLdFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2L.VuiOlnpuFjSZFgXXbi7FXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i3/812490113/TB2lMIgdncCL1FjSZFPXXXZgpXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2LKmNhmxjpuFjSszeXXaeMVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2xf8jiNBmpuFjSZFsXXcXpFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i3/812490113/TB22xqRhgRkpuFjy1zeXXc.6FXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2AdOqhmXlpuFjy0FeXXcJbFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2XHoUiAqvpuFjSZFhXXaOgXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i2/812490113/TB2DsKKheJ8puFjy1XbXXagqVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i3/812490113/TB2VnP3Xr_0UKFjy1XaXXbKfXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB26iOyhbBkpuFjy1zkXXbSpFXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i3/812490113/TB2aO54hmFjpuFjSspbXXXagVXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i1/812490113/TB2_fqFhbXlpuFjSszfXXcSGXXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB2DGEWitBopuFjSZPcXXc9EpXa_!!812490113.jpg\">\n" +
            "<img align=\"middle\" src=\"https://img.alicdn.com/imgextra/i4/812490113/TB223MgdncCL1FjSZFPXXXZgpXa_!!812490113.jpg\">";

    String bug = "<img class=\"fix\" src=https://img.alicdn.com/bao/uploaded/i2/2987681715/TB2mmh.bG8lpuFjy0FpXXaGrpXa_!!2987681715.jpg_220x220.jpg style=zoom: 1;>";

    String bug2 = "<p style=\"text-align: center\"><p style=\"box-sizing: content-box; color: rgb(0, 0, 0); font-family: &quot;microsoft yahei&quot;, 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体, sans-serif; font-size: 12px; line-height: 18px; text-align: center\"><strong style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; font-size: 20px\"><span style=\"box-sizing: content-box; background-color: rgb(255, 255, 0)\">100%实拍</span></span></strong></p><p style=\"box-sizing: content-box; color: rgb(0, 0, 0); font-family: &quot;microsoft yahei&quot;, 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体, sans-serif; font-size: 12px; line-height: 18px; text-align: center\"><strong style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; font-size: 18px\">尺码参考</span></strong></p><p style=\"box-sizing: content-box; color: rgb(0, 0, 0); font-family: &quot;microsoft yahei&quot;, 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体, sans-serif; font-size: 12px; line-height: 18px; text-align: center\"><strong style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; font-size: 18px\"><span style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; line-height: 30px\">\u200B均码：长73胸围108肩宽43袖长58</span></span></span></strong></p><p style=\"box-sizing: content-box; color: rgb(0, 0, 0); font-family: &quot;microsoft yahei&quot;, 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体, sans-serif; font-size: 12px; line-height: 18px; text-align: center\"><strong style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; font-size: 18px\"><span style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; line-height: 30px\">\u200B</span></span></span>\u200B<span style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; line-height: 30px\">手工测量，1-3cm误差</span></span></strong></p><p style=\"box-sizing: content-box; color: rgb(0, 0, 0); font-family: &quot;microsoft yahei&quot;, 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体, sans-serif; font-size: 12px; line-height: 18px; text-align: center\"><strong style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box\"><span style=\"box-sizing: content-box; line-height: 30px\">\u200B<img src=http://sgimage.571xz.com/new_image_site/SGimg/0916cfd00070b03dfe2599f6fece325d..jpg alt=\"\" /></span></span></strong></p> <img src=http://sgimage.571xz.com/new_image_site/SGimg/0355cd0cab45c0df4e19615125bece27..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/cf0c73010c42584c9fd93620e46f4627..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/149136632c2f8764b761e73d0d31e597..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/8fe2777cba0aaba68483471f483f081a..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/bc7143016d602d5c881ce0f4bb3c5666..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/3d90eaad0030c6dd50c6bd7b087a562a..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/2a80edc7c6488d144282a942c3a5cf13..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/0a879c27cca2cebfb9cdc94403f35cdf..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/b545193a7a7e2ae2757baed768043bd7..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/5d852cb7fa68fb986ad15db86e2407a8..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/cf866ff01e10f6ee93b49d3645613ea6..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/fc389a8c1b5b7fa04a622005b2c3c114..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/e8c27d207d294d1eb78daf6a34a897d3..jpg alt=\"\" /></p><p style=\"text-align: center\"><img src=http://sgimage.571xz.com/new_image_site/SGimg/560bc24fdecaa6c5a64f6b3d7d89d1f0..jpg alt=\"\" /></p>";

    String bug3 = "<p align='center'><img src='https://img.alicdn.com/imgextra/i4/704228474/TB2KT5QeFXXXXbDXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i2/704228474/TB2B5yNeFXXXXcpXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2IHGPeFXXXXb0XXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2_9iAeFXXXXazXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2b4eSeFXXXXbkXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i2/704228474/TB2adeUeFXXXXaUXXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<div align='center'>\n" +
            "<div style='display:block;'>\n" +
            "<div align='center'>\n" +
            "<div align='center'>\n" +
            "<div style='display:block;'>\n" +
            "<div align='center'>\n" +
            "<div style='display:block;'>\n" +
            "<div style='text-align:center;width:100.0%;float:left;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB2uXeyeFXXXXbZXpXXXXXXXXXX_!!704228474.jpg'><br></div></div>\n" +
            "<div style='display:block;'>&nbsp; <img src='https://img.alicdn.com/imgextra/i3/704228474/TB24OJveXXXXXawXpXXXXXXXXXX_!!704228474.jpg'></div>\n" +
            "<p></p>\n" +
            "<p align='center'><img alt='' align='middle' src='https://img.alicdn.com/imgextra/i4/704228474/TB2TjWDeFXXXXaJXpXXXXXXXXXX_!!704228474.jpg' width='750'> </p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB23pW2eFXXXXXhXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i4/704228474/TB2R4KNeFXXXXb6XXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB2rDSVeFXXXXaiXXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i2/704228474/TB2vl1HbFXXXXXVXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<p></p>\n" +
            "<p align='center'><img alt='' align='middle' src='https://img.alicdn.com/imgextra/i1/704228474/TB2_HixeFXXXXbkXpXXXXXXXXXX_!!704228474.jpg' width='750'> </p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i4/704228474/TB2e3pBeXXXXXciXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB28EGFeFXXXXX7XpXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB2Do5AeFXXXXbaXpXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB29l4LeXXXXXXJXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i2/704228474/TB229qPeFXXXXbCXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB2d3GKeFXXXXc.XXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i4/704228474/TB26OKUeFXXXXaZXXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB2XDuVeFXXXXarXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB2xHdMeXXXXXXIXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i3/704228474/TB2Rm5PeFXXXXb1XXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i2/704228474/TB2pdq1eFXXXXXtXXXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i4/704228474/TB2e3pBeXXXXXciXXXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<p></p>\n" +
            "<p align='center'><img alt='' align='middle' src='https://img.alicdn.com/imgextra/i1/704228474/TB2nNSJeFXXXXc6XXXXXXXXXXXX_!!704228474.jpg' width='750'> </p>\n" +
            "<p align='center'></p>\n" +
            "<div style='width:150.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i2/704228474/TB2OIiFeFXXXXaXXpXXXXXXXXXX_!!704228474.jpg' width='150'></div>\n" +
            "<div style='width:600.0px;display:inline;'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB2TBmDeFXXXXatXpXXXXXXXXXX_!!704228474.jpg' width='600'></div>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<p></p>\n" +
            "<p align='center'></p>\n" +
            "<div style='display:block;'>\n" +
            "<div style='display:block;'>\n" +
            "<p align='center'><img src='https://img.alicdn.com/imgextra/i1/704228474/TB2F9KYeFXXXXXOXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2YuyDeFXXXXaSXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i4/704228474/TB2c_uHeFXXXXXzXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i1/704228474/TB2ssmGeFXXXXXfXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i1/704228474/TB2qBuPeFXXXXbKXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i1/704228474/TB29G1DeFXXXXaQXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i2/704228474/TB2ha9CeFXXXXaRXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i1/704228474/TB2lXeyeFXXXXbtXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2.xGMeFXXXXcLXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i4/704228474/TB2vGKWeFXXXXaGXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i1/704228474/TB2sRCEeFXXXXadXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2ddCqeFXXXXXcXFXXXXXXXXXX_!!704228474.jpg'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2_NeBeFXXXXaVXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i4/704228474/TB2SQKNeFXXXXcfXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i2/704228474/TB2Mq9SeFXXXXbnXXXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i2/704228474/TB2VAyCeFXXXXamXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i4/704228474/TB2KDSweFXXXXb4XpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2_1OAeFXXXXbjXpXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2ddCqeFXXXXXcXFXXXXXXXXXX_!!704228474.jpg'> <img src='https://img.alicdn.com/imgextra/i3/704228474/TB2ZU5KeFXXXXc9XXXXXXXXXXXX_!!704228474.jpg'> </p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i2/704228474/TB2ZKSReFXXXXbCXXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i2/704228474/TB244eMeFXXXXcGXXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i1/704228474/TB2M.SDeFXXXXaCXpXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i3/704228474/TB2BPWHeFXXXXXEXpXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i4/704228474/TB2ylaEeFXXXXamXpXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i3/704228474/TB2klSQeFXXXXa9XXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i2/704228474/TB2VfmFeFXXXXXHXpXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i3/704228474/TB2.c10eFXXXXXMXXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i2/704228474/TB2Jv5YeFXXXXaXXXXXXXXXXXXX_!!704228474.jpg'></p>\n" +
            "<p align='center'><img align='middle' src='https://img.alicdn.com/imgextra/i3/704228474/TB24luWeFXXXXatXXXXXXXXXXXX_!!704228474.jpg'></p></div></div></div></div></div></div></div></div>";

    @org.junit.Test
    public void testLazy() {
        System.out.println(HtmlImgsLazyLoad.replaceLazyLoad((bug3)));
    }

    public String anlazy(String source) {
        StringBuilder sb = new StringBuilder(source);
        int src = sb.indexOf(" src=") + 5;
        if (sb.charAt(src) != '\"') {
            sb.insert(src, "\"");
            sb.insert(sb.indexOf(" ", src), "\"");
        }
        return sb.toString();
    }
}
