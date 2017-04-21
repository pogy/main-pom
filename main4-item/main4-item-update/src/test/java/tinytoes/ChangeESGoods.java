package tinytoes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opentae.data.mall.beans.ESGoods;
import com.opentae.data.mall.beans.EsSynTemp;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguSite;
import com.opentae.data.mall.examples.EsSynTempExample;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.interfaces.EsSynTempMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsExtendsMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguSiteMapper;
import com.shigu.main4.item.services.impl.EsGoodsService;
import net.sf.json.JSONObject;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.calendar.BaseCalendar;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：ChangeESGoods
 * @文件路径：tinytoes.ChangeESGoods
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：17/3/25 16:10
 * @version: domwiki
 * @since: domwiki
 * @commonents:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/main4/spring/item-update.xml")
public class ChangeESGoods {
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
    
    @Autowired
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;
    @Autowired
    private ShiguSiteMapper shiguSiteMapper;
    @Autowired
    private EsSynTempMapper esSynTempMapper;
    @Autowired
    private EsGoodsService esGoodsService;
    @Autowired
    ESConfig esconfig;
	TransportClient client;
    /**
     * shigu_goods_tiny同步到es
     */
    @Test
    public void changeEsGoods() throws UnknownHostException {

		String url = esconfig.getEsUrl ();
		String port = esconfig.getEsPort ();
		Settings settings = Settings.settingsBuilder ().put(esconfig.getClusterName (), esconfig.getApplic ()).build();
		client = TransportClient.builder ().settings(settings).build();
		client.addTransportAddress (new InetSocketTransportAddress (InetAddress.getByName (url), Integer.valueOf (port).intValue ()));
		ShiguSiteExample shiguSiteExample=new ShiguSiteExample();
    	shiguSiteExample.createCriteria().andRemark1EqualTo("1");
    	shiguSiteExample.setOrderByClause("sort_order asc");
    	List<ShiguSite> sites=shiguSiteMapper.selectByExample(shiguSiteExample);
    	for(ShiguSite site:sites){
//        	long startGoodsId=0l;//临时id
			EsSynTemp temp=selLastId(site.getCitySite());
			long startGoodsId=temp.getSynId();System.out.println(startGoodsId);
			long tempId=temp.getTempId();
        	while(true){
        		long l=new Date().getTime();
	            List<ShiguGoodsTiny> list=selTiny(startGoodsId,site.getCitySite());
	            if(list.size ()>0) {
	            	Long lastGid=null;
	                List<ESGoods> list_es=new ArrayList<ESGoods> ();
	                //把u商品转化成ES
	                for(ShiguGoodsTiny sgt:list) {
	                    ESGoods es= esGoodsService.createEsGoods (sgt);
	                    list_es.add (es);
	                }
	                lastGid=list.get(list.size()-1).getGoodsId().longValue();
	                //连接ES
					startGoodsId=addOneMoreEs(list_es,tempId,lastGid);
	                // ESConfig esconfig=new ESConfig();
	                System.out.println((new Date().getTime()-l)+","+startGoodsId+","+site.getCitySite());
	            }else{
	            	break;
	            }
        	}
    	}
    }

	/**
	 * 最后一个ID
	 * @param webSite
	 * @return
     */
	private EsSynTemp selLastId(String webSite){
		EsSynTemp esSynTemp=new EsSynTemp();
		esSynTemp.setSynType(1);//在售商品
		esSynTemp.setWebSite(webSite);
		esSynTemp=esSynTempMapper.selectOne(esSynTemp);
		if(esSynTemp==null){
			esSynTemp=new EsSynTemp();
			esSynTemp.setSynType(1);//在售商品
			esSynTemp.setWebSite(webSite);
			esSynTemp.setSynId(0l);
			esSynTempMapper.insertSelective(esSynTemp);
		}
		return esSynTemp;
	}

	/**
	 * 拿到一组tiny
	 * @param startGoodsId
	 * @param webSite
     * @return
     */
	private List<ShiguGoodsTiny> selTiny(Long startGoodsId,String webSite){
		ShiguGoodsTinyExample sgte=new ShiguGoodsTinyExample();
		sgte.setStartIndex (0);
		sgte.setEndIndex (200);
		sgte.setWebSite (webSite);
		sgte.setOrderByClause (" goods_id asc");
		sgte.createCriteria().andGoodsIdGreaterThan(startGoodsId);
		return shiguGoodsTinyMapper.selectByConditionList (sgte);
	}

    /**
	 * 完成一组添加动作
	 * @param list_es
	 * @param tempId
	 * @param lastGid
     * @return
     */
	private Long addOneMoreEs(List<ESGoods> list_es,Long tempId,Long lastGid){
		Long startGoodsId=lastGid;
		try {
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			for (ESGoods es:list_es) {
				// es.getCreated ()
				JSONObject objs= JSONObject .fromObject (es);
				objs.put ("created", dateToString(es.getCreated (),null));//listTime//modified//delistTime//loadDate
				objs.put ("listTime", dateToString(es.getListTime (),null));
				objs.put ("modified", dateToString(es.getModified (),null));
				objs.put ("delistTime", dateToString(es.getDelistTime (),null));
				objs.put ("loadDate", dateToString (es.getLoadDate (), null));
				// String see= objs.toString ();

				bulkRequest.add (client.prepareIndex (esconfig.getGoodsKU (), es.getWebSite(), es.getGoodsId ().toString ())
						.setSource (objs.toString ()));
				// bulkRequest.add (client.prepareIndex ("goods_v3", "hz", es.getGoodsId ().toString ()).setSource (JSON.toJSONString (es, SerializerFeature.PrettyFormat)));
			}
			bulkRequest.execute().actionGet ();
			//es同步成功,将最后一个ID写入数据库
			EsSynTemp esSynTemp2=new EsSynTemp();
			esSynTemp2.setTempId(tempId);
			esSynTemp2.setSynId(lastGid);
			esSynTempMapper.updateByPrimaryKeySelective(esSynTemp2);
			//将最后一个ID写入到临时id
			startGoodsId=lastGid.longValue();
		}catch (Exception e){
			System.out.println ("连接不到主机");
		}
		return startGoodsId;
	}


    /**
     * 下架商品同步
     */
    
    public void changeEsSoldGoods(){
    	ShiguSiteExample shiguSiteExample=new ShiguSiteExample();
    	shiguSiteExample.createCriteria().andRemark1EqualTo("1");
    	shiguSiteExample.setOrderByClause("sort_order asc");
    	List<ShiguSite> sites=shiguSiteMapper.selectByExample(shiguSiteExample);
    	for(ShiguSite site:sites){
        	long startGoodsId=0l;//临时id
        	EsSynTemp esSynTemp=new EsSynTemp();
        	esSynTemp.setSynType(2);//2:下架商品
        	esSynTemp.setWebSite(site.getCitySite());
        	esSynTemp=esSynTempMapper.selectOne(esSynTemp);
        	if(esSynTemp==null){
        		esSynTemp=new EsSynTemp();
        		esSynTemp.setSynType(2);//2:下架商品
        		esSynTemp.setWebSite(site.getCitySite());
        		esSynTemp.setSynId(0l);
        		esSynTempMapper.insertSelective(esSynTemp);
        	}
        	startGoodsId=esSynTemp.getSynId();
        	Date threeMouth=monthOfYear(new Date(),-3);
        	while(true){
        		long l=new Date().getTime();
	            ShiguGoodsSoldoutExample sgte=new ShiguGoodsSoldoutExample();
	            sgte.setStartIndex (0);
	            sgte.setEndIndex (200);
	            sgte.setWebSite (site.getCitySite());
	            sgte.setOrderByClause (" goods_id asc");
	            sgte.createCriteria().andGoodsIdGreaterThan(startGoodsId).andSoldoutTimeGreaterThan(threeMouth);
	            List<ShiguGoodsSoldout> list= shiguGoodsSoldoutMapper.selectByConditionList (sgte);
	            if(list.size ()>0) {
	            	Long lastGid=null;
	                List<ESGoods> list_es=new ArrayList<ESGoods> ();
	                //把u商品转化成ES
	                for(ShiguGoodsSoldout sgt:list) {
	                    ESGoods es= esGoodsService.createEsGoods (sgt);
	                    list_es.add (es);
	                }
	                lastGid=list.get(list.size()-1).getGoodsId().longValue();
	                //连接ES
	
	                // ESConfig esconfig=new ESConfig();
	                String url = esconfig.getEsUrl ();
	                String port = esconfig.getEsPort ();
	                Settings settings = Settings.settingsBuilder ().put(esconfig.getClusterName (), esconfig.getApplic ()).build();
	                TransportClient client = TransportClient.builder ().settings(settings).build();
	                try {
	                    client.addTransportAddress (new InetSocketTransportAddress (InetAddress.getByName (url), Integer.valueOf (port).intValue ()));
	                    BulkRequestBuilder bulkRequest = client.prepareBulk();
	                    for (ESGoods es:list_es) {
	                        // es.getCreated ()
	                        JSONObject objs= JSONObject .fromObject (es);
	                        objs.put ("created", dateToString(es.getCreated (),null));//listTime//modified//delistTime//loadDate
	                        objs.put ("listTime", dateToString(es.getListTime (),null));
	                        objs.put ("modified", dateToString(es.getModified (),null));
	                        objs.put ("delistTime", dateToString(es.getDelistTime (),null));
	                        objs.put ("loadDate", dateToString (es.getLoadDate (), null));
	                        // String see= objs.toString ();
	
	                        bulkRequest.add (client.prepareIndex (esconfig.getGoodsKU (), es.getWebSite(), es.getGoodsId ().toString ())
	                                                 .setSource (objs.toString ()));
	                        // bulkRequest.add (client.prepareIndex ("goods_v3", "hz", es.getGoodsId ().toString ()).setSource (JSON.toJSONString (es, SerializerFeature.PrettyFormat)));
	                    }
	                    bulkRequest.execute().actionGet ();
	                    //es同步成功,将最后一个ID写入数据库
	                    EsSynTemp esSynTemp2=new EsSynTemp();
	                    esSynTemp2.setTempId(esSynTemp.getTempId());
	                    esSynTemp2.setSynId(lastGid);
	                    esSynTempMapper.updateByPrimaryKeySelective(esSynTemp2);
	                    //将最后一个ID写入到临时id
	                    startGoodsId=lastGid.longValue();
	                }catch (UnknownHostException e){
	                    System.out.println ("连接不到主机");
	                }
	                System.out.println(new Date().getTime()-l);
	            }else{
	            	break;
	            }
        	}
    	}
    	
    }
    
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    public static Date monthOfYear(Date d,int i){
    	Calendar calendar = Calendar.getInstance(); //得到日历
    	calendar.setTime(d);//把当前时间赋给日历
    	calendar.add(calendar.MONTH, i);  //设置为前3月
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	return calendar.getTime();
    }
}
	

