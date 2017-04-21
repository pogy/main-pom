package com.shigu.main4.item.update.wxc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.ShiguGoodsExtends;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPropImgs;
import com.opentae.data.mall.interfaces.ShiguGoodsExtendsMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguPropImgsMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.item.services.impl.EsGoodsService;
import com.shigu.main4.item.services.impl.ItemAddOrUpdateServiceImpl;
import com.shigu.main4.item.tools.ItemHelper;
import com.shigu.main4.item.vo.SynItem;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by wxc on 2017/3/1.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TestItemHelper extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(TestItemHelper.class);

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;

    @Autowired
    private ShiguPropImgsMapper shiguPropImgsMapper;

    @Autowired
    private EsGoodsService esGoodsService;

    public static String json = "{\n" +
            "\t\"cid\":162201,\n" +
            "\t\"cidAll\":\",774242958,\",\n" +
            "\t\"city\":\"杭州\",\n" +
            "\t\"created\":1376270504000,\n" +
            "\t\"delistTime\":1418607040000,\n" +
            "\t\"detailUrl\":\"http://item.taobao.com/item.htm?id=19600754830&spm=2014.21720662.0.0\",\n" +
            "\t\"floorId\":914,\n" +
            "\t\"freightPayer\":\"buyer\",\n" +
            "\t\"goodsDesc\":\"<p><img alt=\\\"\\\" src=\\\"http://img02.taobaocdn.com/imgextra/i2/1641940278/TB2krwkXVXXXXaIXXXXXXXXXXXX_!!1641940278.jpg\\\"></p><br><table><tr><td><div style=\\\"width: 750.0px;float: left;\\\"><div style=\\\"text-align: left;background-color: #2b3346;padding-left: 30.0px;width: 720.0px;font: bold 13.0px 35.0px 微软雅黑;float: left;color: #ffffff;\\\">全部数据为人工测量所获得，由于测量方式不同，会有1--2CM误差！</div><div style=\\\"width: 750.0px;float: left;\\\"><div style=\\\"text-align: center;margin-top: 5.0px;width: 750.0px;font: 13.0px 微软雅黑;float: left;\\\"><table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" height=\\\"315\\\" style=\\\"border-bottom: #999999 1.0px solid;border-left: #999999 1.0px solid;font: 13.0px 微软雅黑;border-top: #999999 1.0px solid;border-right: #999999 1.0px solid;\\\" width=\\\"748\\\"><tr align=\\\"middle\\\" valign=\\\"center\\\"><td colspan=\\\"10\\\" height=\\\"30\\\" style=\\\"border-bottom: #999999 1.0px solid;border-right: #999999 1.0px solid;\\\" width=\\\"80%\\\"><strong>平铺参考尺寸</strong>（单位：CM）</td><td rowspan=\\\"10\\\" width=\\\"20%\\\"><img src=\\\"http://img03.taobaocdn.com/imgextra/i3/1641940278/TB2E6.kXVXXXXaaXXXXXXXXXXXX_!!1641940278.jpg\\\"></td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#2b3346\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #ffffff;border-right: #999999 1.0px solid;\\\" width=\\\"14%\\\">尺寸</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"6%\\\">26</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"6%\\\">27</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"6%\\\">28</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">29</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">30</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">31</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">32</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">33</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">34</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">对应腰围</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">1尺9</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺1</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺2</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺3</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺4</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺5</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺6</td><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">2尺7</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">腰围</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">63.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">67.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">70</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">73.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">76.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">80</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">83.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">86.8</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">臀围</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">86.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">90</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">93.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">96.4</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">100</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">103.3</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">106.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">110</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">裤长</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">99.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">101</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">101.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">102</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">102.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">103</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">103.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">104</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">大腿围</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">50.4</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">52</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">53.6</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">55.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">56.8</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">58.4</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">60</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">61.6</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">前裆</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">23.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">24</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">24.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">25</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">25.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">26</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">26.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">27</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">后裆</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">33.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">34</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">34.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">35</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">35.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">36</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">36.5</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">37</td><td bgcolor=\\\"#ffffff\\\" style=\\\"border-bottom: #999999 1.0px solid;color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr><tr align=\\\"middle\\\" height=\\\"30\\\" valign=\\\"center\\\"><td bgcolor=\\\"#d1d2d4\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"51\\\">脚围</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">29.8</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">31</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">32.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">33.4</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">34.6</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">35.8</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">37</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">38.2</td><td bgcolor=\\\"#ffffff\\\" style=\\\"color: #000000;border-right: #999999 1.0px solid;\\\" width=\\\"8%\\\">&nbsp;</td></tr></table></div></div></div></td></tr></table><p><img alt=\\\"\\\" src=\\\"http://img04.taobaocdn.com/imgextra/i4/1641940278/TB27CUiXVXXXXbiXXXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img01.taobaocdn.com/imgextra/i1/1641940278/TB2iKggXVXXXXXQXpXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img04.taobaocdn.com/imgextra/i4/1641940278/TB2ApckXVXXXXaMXXXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img04.taobaocdn.com/imgextra/i4/1641940278/TB2YYckXVXXXXaGXXXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img04.taobaocdn.com/imgextra/i4/1641940278/TB2AvkgXVXXXXXKXpXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img01.taobaocdn.com/imgextra/i1/1641940278/TB2YlklXVXXXXaXXXXXXXXXXXXX_!!1641940278.jpg\\\"><br><img alt=\\\"\\\" src=\\\"http://img04.taobaocdn.com/imgextra/i4/1641940278/TB2klZlXVXXXXctXXXXXXXXXXXX_!!1641940278.jpg\\\"><br>&nbsp;</p><p>&nbsp;</p>\",\n" +
            "\t\"goodsId\":1990685,\n" +
            "\t\"hasShowcase\":\"true\",\n" +
            "\t\"imageList\":[\n" +
            "\t\t\"http://img02.taobaocdn.com/bao/uploaded/i2/10278038626224377/T1.MKeFfXbXXXXXXXX_!!0-item_pic.jpg\",\n" +
            "\t\t\"http://img01.taobaocdn.com/bao/uploaded/i1/1641940278/T2KB.VXXNXXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\"http://img01.taobaocdn.com/bao/uploaded/i1/1641940278/T2luIgXdBaXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\"http://img02.taobaocdn.com/bao/uploaded/i2/1641940278/T2.4MVXeJXXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\"http://img01.taobaocdn.com/bao/uploaded/i1/1641940278/T2UmbdXhdbXXXXXXXX_!!1641940278.jpg\"\n" +
            "\t],\n" +
            "\t\"inputPids\":\"13021751,20000\",\n" +
            "\t\"inputStr\":\"8726,靓丽倾情\",\n" +
            "\t\"itemFrom\":\"TAOBAO\",\n" +
            "\t\"listTime\":1418002240000,\n" +
            "\t\"marketId\":913,\n" +
            "\t\"modified\":1411451243000,\n" +
            "\t\"num\":2798,\n" +
            "\t\"numIid\":19600754830,\n" +
            "\t\"onsale\":false,\n" +
            "\t\"piPriceString\":\"128.00\",\n" +
            "\t\"picUrl\":\"http://img02.taobaocdn.com/bao/uploaded/i2/10278038626224377/T1.MKeFfXbXXXXXXXX_!!0-item_pic.jpg\",\n" +
            "\t\"priceString\":\"128.00\",\n" +
            "\t\"propImgs\":[\n" +
            "\t\t{\n" +
            "\t\t\t\"pid\":1627207,\n" +
            "\t\t\t\"url\":\"http://img01.taobaocdn.com/bao/uploaded/i1/1641940278/T2zZVcXs0XXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\t\"vid\":30156\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"pid\":1627207,\n" +
            "\t\t\t\"url\":\"http://img04.taobaocdn.com/bao/uploaded/i4/1641940278/T2qUBaXwJaXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\t\"vid\":3232478\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"pid\":1627207,\n" +
            "\t\t\t\"url\":\"http://img01.taobaocdn.com/bao/uploaded/i1/1641940278/T2wv5qXaBbXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\t\"vid\":28326\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"pid\":1627207,\n" +
            "\t\t\t\"url\":\"http://img04.taobaocdn.com/bao/uploaded/i4/1641940278/T2y7ifXjlcXXXXXXXX_!!1641940278.jpg\",\n" +
            "\t\t\t\"vid\":107121\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\t\"propertyAlias\":\"20518:28422:26（1尺9）;20518:28359:28（2尺1）;20518:28357:27（2尺）;20518:28366:32（2尺5）;20518:28362:30（2尺3）;20518:28361:29（2尺2）;20518:28364:31（2尺4）;1627207:107121:卡其色;1627207:28326:绛红色;1627207:30156:雀绿色;1627207:3232478:黑色\",\n" +
            "\t\"props\":\"20418023:157305307;13021751:3364906;122276315:3925131;33235:20525;20677:29954;20551:28355;20608:6384766;18073285:28105;1627207:30156;1627207:3232478;1627207:28326;1627207:107121;20000:15873070;20518:28422;20518:28357;20518:28359;20518:28361;20518:28362;20518:28364;20518:28366;13328588:492838735;122216588:3243112;122216507:3226292;122216347:209928864\",\n" +
            "\t\"propsName\":\"20418023:157305307:主图来源:自主实拍图;13021751:3364906:货号:8726;122276315:3925131:女裤裤型:铅笔裤;33235:20525:裤长:长裤;20677:29954:女裤腰高:中腰;20551:28355:面料:涤纶;20608:6384766:风格:通勤;18073285:28105:通勤:韩版;1627207:30156:颜色分类:浅绿色;1627207:3232478:颜色分类:深灰色;1627207:28326:颜色分类:红色;1627207:107121:颜色分类:透明;20000:15873070:品牌:靓丽倾情;20518:28422:尺寸:64厘米（1尺9）;20518:28357:尺寸:66厘米（2尺）;20518:28359:尺寸:70厘米（2尺1）;20518:28361:尺寸:74厘米（2尺2）;20518:28362:尺寸:76厘米（2尺3）;20518:28364:尺寸:80厘米（2尺4）;20518:28366:尺寸:84厘米（2尺5）;13328588:492838735:成分含量:91%(含)-95%(含);122216588:3243112:服装款式细节:口袋;122216507:3226292:厚薄:常规;122216347:209928864:年份季节:2013年秋季\",\n" +
            "\t\"prov\":\"浙江\",\n" +
            "\t\"sellPromise\":\"false\",\n" +
            "\t\"shopId\":17183,\n" +
            "\t\"title\":\"2013秋冬新款女裤 韩版百搭修身小脚裤铅笔裤长 休闲裤女\",\n" +
            "\t\"webSite\":\"hz\"\n" +
            "}";

    @Test
    public void helpMe() throws IllegalAccessException {
        SynItem item = JSON.parseObject(json, SynItem.class);
        for (Field field : SynItem.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(item) == null)
                logger.info(field.getName());
        }

        logger.info("\n\n");
        ItemHelper.SynItemContainer container = ItemHelper.helpMe(item);
        //查数据库
        toSynItem();
        Object[] objects = {tiny, ext, img};
        Object[] data = {container.getTiny(), container.getGoodsExtends(), container.getShiguPropImgs()};
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            if (object != null) {
                Object d = data[i];
                if (d == null) {
                    logger.warn("数据反解包含NULL," + i);
                    continue;
                }
                Class<?> clazz = object.getClass();
                try {
                    for (Field field : clazz.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object source = field.get(object);
                        Object target = field.get(d);
                        if (!Objects.equals(source, target)) {
                            if (target != null)
                            logger.info("\n对不上, 原数据：\n" + clazz.getSimpleName() + "." + field.getName() + "=" + source + "， data:" + target);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else logger.warn("从数据库查到null！" + i);
        }

    }
    private ShiguGoodsTiny tiny;
    private ShiguGoodsExtends ext;
    private ShiguPropImgs img;
    @Test
    public void toSynItem() {
        Long goodsId = 1990685L;
        tiny = new ShiguGoodsTiny();
        tiny.setWebSite("hz");
        tiny.setGoodsId(goodsId);
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);

        ext = new ShiguGoodsExtends();
        ext.setGoodsId(goodsId);
        ext.setWebSite("hz");
        ext = shiguGoodsExtendsMapper.selectByPrimaryKey(ext);

        img = new ShiguPropImgs();
        img.setItemId(goodsId);
        img = shiguPropImgsMapper.selectOne(img);

        SynItem synItem = ItemHelper.toSynItem(tiny, ext, img);
        logger.info("\n" + JSON.toJSONString(synItem, SerializerFeature.PrettyFormat));

    }

    /**
     *  测试 转为ES对象
     */
    @Test
    public void testToEsGoods() {
        Long goodsId = 1990685L;
        tiny = new ShiguGoodsTiny();
        tiny.setWebSite("hz");
        tiny.setGoodsId(goodsId);
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        tiny.setGoodsNo("asdasdasd");// 元数据空，这里自己设置一个
        ESGoods esGoods = esGoodsService.createEsGoods(tiny);
        Map<String, Object> bingo = new HashMap<>();
        for (Field field : ESGoods.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object o = field.get(esGoods);
                if (o == null)
                    logger.warn(field.getName());
                else bingo.put(field.getName(), o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("\n\n 命中");
        for (Map.Entry<String, Object> s : bingo.entrySet()) {
            logger.info(s.getKey() + " = " + s.getValue());
        }
    }

    @Test
    public void testPriceStringFormat() {
        SynItem synItem = new SynItem();
        synItem.setPriceString("80");
        ItemHelper.SynItemContainer synItemContainer = ItemHelper.helpMe(synItem);
        System.out.println(synItemContainer.getTiny().getPriceString());
    }

    @Test
    public void testObjectIsnotBlank() {
        ShiguGoodsExtends extendss = new ShiguGoodsExtends();
        extendss.setGoodsId(654551L);
        extendss.setWebSite("wqsda");
        System.out.println(new ItemAddOrUpdateServiceImpl().objectIsNotBlank(extendss));
    }
}
