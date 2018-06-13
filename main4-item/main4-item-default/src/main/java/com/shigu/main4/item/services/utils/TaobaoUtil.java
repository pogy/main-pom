package com.shigu.main4.item.services.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.openJar.requests.imgs.UptoImgsRequest;
import com.openJar.responses.imgs.UptoImgsResponse;
import com.openJar.tools.PcOpenClient;
import com.openJar.utils.WebUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.FileItem;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.ItemProp;
import com.taobao.api.domain.Shop;
import com.taobao.api.domain.UserInfo;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import com.taobao.top.schema.exception.TopSchemaException;
import com.taobao.top.schema.factory.SchemaReader;
import com.taobao.top.schema.factory.SchemaWriter;
import com.taobao.top.schema.field.ComplexField;
import com.taobao.top.schema.field.Field;
import com.taobao.top.schema.field.MultiCheckField;
import com.taobao.top.schema.value.ComplexValue;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class TaobaoUtil {
	private static final Logger log = LoggerFactory.getLogger(TaobaoUtil.class);
	private static DefaultTaobaoClient client;

	@Value("${taobao.app.key}")
	private String APPKEY;

	@Value("${taobao.app.secret}")
	private String SECRET;

	@Value("${taobao.app.server.url}")
	private String TOP_SERVER_URL;

	@Value("${xz_appkey}")
	private String XZAPPKEY;

	@Value("${xz_secret}")
	private String XZSECRET;

	@Value("${xz_type}")
	private String XZTYPE;

	private final String SCHEMA_XML="<itemRule><field id=\"descForMobile\" name=\"宝贝无线端描述\" type=\"complex\"><rules><rule name=\"maxTargetSizeRule\" value=\"1536\" exProperty=\"include\" unit=\"kb\"/><rule name=\"maxLengthRule\" value=\"500\" exProperty=\"include\" unit=\"character\"/></rules><fields><field id=\"shortDesc\" name=\"无线宝贝摘要\" type=\"input\"><rules><rule name=\"maxLengthRule\" value=\"140\" exProperty=\"include\"/><rule name=\"valueTypeRule\" value=\"text\"/></rules></field><field id=\"voice\" name=\"无线宝贝音频\" type=\"complex\"><rules><rule name=\"maxTargetSizeRule\" value=\"200\" exProperty=\"include\" unit=\"kb\"/></rules><fields><field id=\"voice_filename\" name=\"无线商品描述音频标题\" type=\"input\"><rules><rule name=\"valueTypeRule\" value=\"text\"/></rules></field><field id=\"voice_fileurl\" name=\"无线商品描述音频文件地址\" type=\"input\"><rules><rule name=\"valueTypeRule\" value=\"url\"/></rules></field></fields></field><field id=\"content\" name=\"无线宝贝描述内容（文本或图片）\" type=\"multiComplex\"><fields><field id=\"type\" name=\"无线商品描述类型\" type=\"singleCheck\"><options><option displayName=\"图片\" value=\"image\"/><option displayName=\"文本\" value=\"text\"/></options></field><field id=\"value\" name=\"无线商品描述内容\" type=\"input\"><rules><rule name=\"valueTypeRule\" value=\"text\"><depend-group operator=\"and\"><depend-express fieldId=\"type\" value=\"text\" symbol=\"==\"/></depend-group></rule><rule name=\"maxLengthRule\" value=\"500\" exProperty=\"include\" unit=\"character\"><depend-group operator=\"and\"><depend-express fieldId=\"type\" value=\"text\" symbol=\"==\"/></depend-group></rule><rule name=\"valueTypeRule\" value=\"url\"><depend-group operator=\"and\"><depend-express fieldId=\"type\" value=\"image\" symbol=\"==\"/></depend-group></rule><rule name=\"tipRule\" value=\"上传时系统将自动调整图片尺寸(宽度480-620之间，高度小于等于960),以适配手机端.\"/></rules></field></fields></field></fields></field><field id=\"update_fields\" name=\"更新字段列表\" type=\"multiCheck\"><default-values><default-value>descForMobile</default-value></default-values></field></itemRule>";
	
	private TaobaoClient getClient(){
		if(client==null){
			client=new DefaultTaobaoClient(TOP_SERVER_URL,APPKEY, SECRET);
		}
		return client;
	}
	
	/**
	 * 提交商品
	 * @param session
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	public ItemAddResponse submitItem(String session, ItemAddRequest req) throws ApiException {
		TaobaoClient client=getClient();
		return client.execute(req, session);
	}
	/**
	 * 
	 *=========================================================
	 *@方法名：selItemProp
	 *@功能： 取得类目属性
	 *@param cid
	 *@param parentPid
	 *@return
	 *@throws ApiException:List<ItemProp>
	 *=========================================================
	 */
	public List<ItemProp> selItemProp(Long cid, Long parentPid) throws ApiException{
		TaobaoClient client=getClient();
		ItempropsGetRequest req=new ItempropsGetRequest();
		req.setFields("pid,parent_pid,parent_vid,is_key_prop,is_sale_prop,is_color_prop,is_enum_prop,is_material,is_item_prop,name,must,multi,prop_values,status,sort_order,child_template,is_allow_alias,is_input_prop,cid");
		req.setCid(cid);
		if(parentPid!=null){
			req.setParentPid(parentPid);
		}
		ItempropsGetResponse response = client.execute(req);
		if(!response.isSuccess()){
			log.error("get taobao itemprops error"+response.getBody());
		}
		return response.getItemProps();
	}

	/**
	 *
	 *=========================================================
	 *@方法名：selItemProp
	 *@功能： 取得类目属性
	 *@param cid
	 *@param pid
	 *@return
	 *@throws ApiException:List<ItemProp>
	 *=========================================================
	 */
	public List<ItemProp> selItemPropByPid(Long cid,Long pid) throws ApiException{
		TaobaoClient client=getClient();
		ItempropsGetRequest req=new ItempropsGetRequest();
		req.setFields("pid,parent_pid,parent_vid,is_key_prop,is_sale_prop,is_color_prop,is_enum_prop,is_material,is_item_prop,name,must,multi,prop_values,status,sort_order,child_template,is_allow_alias,is_input_prop,cid");
		req.setCid(cid);
		if(pid!=null){
			req.setPid(pid);
		}
		ItempropsGetResponse response = client.execute(req);
		if(!response.isSuccess()){
			log.error("get taobao itemprops error"+response.getBody());
		}
		return response.getItemProps();
	}

	/**
	 *
	 *=========================================================
	 *@方法名：selItemProp
	 *@功能： 取得类目属性
	 *@param cid
	 *@param path
	 *@return
	 *@throws ApiException:List<ItemProp>
	 *=========================================================
	 */
	public List<ItemProp> selItemPropByPath(Long cid,String path) throws ApiException{
		TaobaoClient client=getClient();
		ItempropsGetRequest req=new ItempropsGetRequest();
		req.setFields("pid,parent_pid,parent_vid,is_key_prop,is_sale_prop,is_color_prop,is_enum_prop,is_material,is_item_prop,name,must,multi,prop_values,status,sort_order,child_template,is_allow_alias,is_input_prop,cid");
		req.setCid(cid);
		if(path!=null){
			req.setChildPath(path);
		}
		ItempropsGetResponse response = client.execute(req);
		if(!response.isSuccess()){
			log.error("get taobao itemprops error"+response.getBody());
		}
		return response.getItemProps();
	}
	
	/**
	 * 根据numIid调用一件商品信息
	 * @param numIid
	 * @return
	 * @throws ApiException
	 */
	public Item selItemByNumIid(Long numIid) throws ApiException{
		TaobaoClient client=getClient();
		ItemGetRequest req=new ItemGetRequest();
		req.setFields("detail_url,num_iid,title,nick,type,desc,sku,props_name,created,is_lightning_consignment,is_fenxiao,auction_point,property_alias,template_id,after_sale_id,is_xinpin,sub_stock,inner_shop_auction_template_id,outer_shop_auction_template_id,features,item_weight,item_size,with_hold_quantity,valid_thru,outer_id,auto_fill,custom_made_type_id,wireless_desc,barcode,cid,seller_cids,props,input_pids,input_str,pic_url,num,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,item_img,prop_img,is_virtual,is_taobao,is_ex,is_timing,video,is_3D,one_station,second_kill,violation,wap_desc,wap_detail_url,cod_postage_id,sell_promise");
		req.setNumIid(numIid);
		ItemGetResponse response = client.execute(req);
		return response.getItem();
	}
	
	public void addSkus(String session,Long numIid,String props,String prices,String nums,String outers) throws ApiException{
		TaobaoClient client=getClient();
		ItemUpdateRequest req=new ItemUpdateRequest();
		req.setNumIid(numIid);
		req.setSkuProperties(props);
		req.setSkuPrices(prices);
		req.setSkuQuantities(nums);
		req.setSkuOuterIds(outers);
		ItemUpdateResponse response = client.execute(req , session);
		//System.out.println(response.getBody());
	}

	/**
	 * 传统添加方式
	 * @param numIid
	 * @param url
	 * @param session
	 * @param ismajor
	 * @throws ApiException
	 */
	public void itemToPicByUpload(Long numIid,String url,String session,boolean ismajor) throws ApiException {
		TaobaoClient client = getClient();
		ItemImgUploadRequest req = new ItemImgUploadRequest();
		req.setNumIid(numIid);
		//得到图片数据
		try {
			Connection conn= WebUtil.getConn(url);
			conn.timeout(30000);
			Connection.Response cr=conn.execute();
			//https://img.alicdn.com/bao/uploaded/i2/2274504687/TB2286RlpXXXXXyXpXXXXXXXXXX-2274504687.jpg
			String fileName=url.substring(url.lastIndexOf("/") + 1);
			req.setImage(new FileItem(fileName,cr.bodyAsBytes()));
			req.setIsMajor(ismajor);
			ItemImgUploadResponse rsp = client.execute(req, session);
//			System.out.println(rsp.getBody());
			if(!rsp.isSuccess()&&("isv.pictureServiceClient-service-error:SERVER_IS_BUSY".equals(rsp.getSubCode())
		||"isv.pictureServiceClient-service-error:PICTURE_SYS_ERROR".equals(rsp.getSubCode())
			||"isv.pictureServiceClient-service-error:EXECUTE_FAILURE".equals(rsp.getSubCode()))){
				reitemToPicByUpload(numIid,url,session,ismajor);
			}
		} catch (IOException e) {
			log.error("上传图片异常",e);
		}
	}

	public void reitemToPicByUpload(Long numIid,String url,String session,boolean ismajor) throws ApiException {
		TaobaoClient client = getClient();
		ItemImgUploadRequest req = new ItemImgUploadRequest();
		req.setNumIid(numIid);
		//得到图片数据
		try {
			Connection conn= WebUtil.getConn(url);
			conn.timeout(30000);
			Connection.Response cr=conn.execute();
			//https://img.alicdn.com/bao/uploaded/i2/2274504687/TB2286RlpXXXXXyXpXXXXXXXXXX-2274504687.jpg
			String fileName=url.substring(url.lastIndexOf("/") + 1);
			req.setImage(new FileItem(fileName,cr.bodyAsBytes()));
			req.setIsMajor(ismajor);
			ItemImgUploadResponse rsp = client.execute(req, session);
//			System.out.println(rsp.getBody());
		} catch (IOException e) {
			log.error("上传商品图片异常",e);
		}
	}

	public void itemToPic2(Long numIid,String url,String session,boolean ismajor) throws ApiException{
		TaobaoClient client=getClient();
		ItemJointImgRequest req=new ItemJointImgRequest();
		req.setNumIid(numIid);
		if(url!=null&&url.contains("imgextra")){
			url=url.substring(url.indexOf("imgextra")).replace("imgextra/", "");
		}else if(url!=null&&url.contains("bao/uploaded")){
			url=url.substring(url.indexOf("bao/uploaded")).replace("bao/uploaded/", "");
		}else{
			return;
		}
		req.setIsMajor(ismajor);
		req.setPicPath(url);
		ItemJointImgResponse response = client.execute(req , session);
	}
	
	public void itemToPic(Long numIid,String url,String session) throws ApiException{
		TaobaoClient client=getClient();
		ItemJointImgRequest req=new ItemJointImgRequest();
		req.setNumIid(numIid);
		if(url!=null&&url.contains("imgextra")){
			url=url.substring(url.indexOf("imgextra")).replace("imgextra/", "");
		}else{
			return;
		}
		req.setPicPath(url);
		ItemJointImgResponse response = client.execute(req , session);
	}
	
	public void joinpropImg(String session,String prop,String url,Long numIid) throws ApiException{
		
		TaobaoClient client=getClient();
		ItemJointPropimgRequest req=new ItemJointPropimgRequest();
		req.setProperties(prop);
		if(url!=null&&url.contains("imgextra")){
			url=url.substring(url.indexOf("imgextra")).replace("imgextra/", "");
		}else{
			return;
		}
		req.setPicPath(url);
		req.setNumIid(numIid);
		ItemJointPropimgResponse response = client.execute(req , session);
	}
	/**
	 * 根据numIid调用一件商品信息
	 * @param numIid
	 * @return
	 * @throws ApiException
	 */
	public Item selPropNameByNumIid(Long numIid) throws ApiException{
		TaobaoClient client=getClient();
		ItemGetRequest req=new ItemGetRequest();
		req.setFields("props_name");
		req.setNumIid(numIid);
		ItemGetResponse response = client.execute(req);
		return response.getItem();
	}

	/**
	 * 查店铺的信息、橱窗之类的
	 * @param nick
	 * @return
	 * @throws ApiException 
	 */
	public Shop selShopByNick(String nick) throws ApiException{
		TaobaoClient client=getClient();
		ShopGetRequest req=new ShopGetRequest();
		req.setFields("sid,cid,title,nick,desc,bulletin,pic_path,created,modified,remain_count,all_count,used_count");
		req.setNick(nick);
		ShopGetResponse response = client.execute(req);
		return response.getShop();
	}

	/**
	 * 查用户的图片空间信息
	 * @param session
	 * @return
	 * @throws ApiException
	 */
	public UserInfo selPicUserInfo(String session) throws ApiException{
		TaobaoClient client=getClient();
		PictureUserinfoGetRequest req=new PictureUserinfoGetRequest();
		PictureUserinfoGetResponse response = client.execute(req , session);
		return response.getUserInfo();
	}
	
	
	/**
	 * 上传手机详情
	 * @param desc 手机详情
	 * @param numIid 商品numIid
	 * @param session 授权
	 * @return
	 * @throws ApiException
	 */
	public String updateWldesc0803(String desc,Long numIid,String session,String title,Long userId,String nick) throws ApiException{
		try {
			if(desc==null){
				return null;
			}
			desc=desc.replace("<img>", "<imge>").replace("</img>", "</imge>");
			Map<String,Field> fieldMap = SchemaReader.readXmlForMap(SCHEMA_XML);
			Field f=fieldMap.get("descForMobile");
			ComplexField cf=(ComplexField) f;
			ComplexValue cv=new ComplexValue();
			cf.setComplexValue(cv);
			//只处理图文
			List<ComplexValue> complexValueList=new ArrayList<ComplexValue>();
			cv.setMultiComplexFieldValues("content", complexValueList);
			//解析desc
			Document dom=Jsoup.parse(desc);
			Elements descEls=dom.select("wapDesc");
			if(descEls.size()<1){
				return null;
			}
			long imgsize=0;
			Element wapDesc=descEls.get(0);
			Elements childs=wapDesc.children();
			for(Element e:childs){
				ComplexValue cv1=new ComplexValue();
				cv1.setInputFieldValue("value", e.html());
				if("imge".equals(e.tagName())){//图片
					String url= e.html();
//					System.out.println(url);
					if(checkImg(url)==1){//如果是图片，先检查图片是不是 要搬家，//或者是不是有效的
						UptoImgsResponse imgres=changeImgPhone(nick, title+"_手机", title+"_手机", url, userId);
						imgsize+=imgres.getImgsize();
						if(imgsize>=2560000){
							continue;
						}
						if(imgres.isSuccess()){
							cv1.setInputFieldValue("value", imgres.getNewUrl());
						}else{
							continue;
						}
					}
					cv1.setSingleCheckFieldValue("type", new com.taobao.top.schema.value.Value("image"));
				}else if("txt".equals(e.tagName())){
					cv1.setSingleCheckFieldValue("type", new com.taobao.top.schema.value.Value("text"));
				}
				complexValueList.add(cv1);
			}
			
			//做提交字段链表
			MultiCheckField mcf=(MultiCheckField) fieldMap.get("update_fields");
			mcf.addValue("descForMobile");
			//准备写出
			Iterator<String> it=fieldMap.keySet().iterator();
			List<Field> fieldlist=new ArrayList<Field>();
			while(it.hasNext()){
				fieldlist.add(fieldMap.get(it.next()));
			}
			SchemaWriter write=new SchemaWriter();
			String str=write.writeParamXmlString(fieldlist);
			
			//System.out.println(str);
			
			TaobaoClient client=getClient();
			ItemSchemaIncrementUpdateRequest req=new ItemSchemaIncrementUpdateRequest();
			req.setItemId(numIid);
			req.setParameters("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+str);
			ItemSchemaIncrementUpdateResponse response = client.execute(req , session);
//			System.out.println(response.getBody());
			//System.out.println(response.getSubMsg());
			return response.getSubMsg();
		} catch (TopSchemaException e) {
			// TODO Auto-generated catch block
			log.error("手机详情Schema转化异常",e);
		}
		return null;
	}
	
	/**
	 * 上传手机详情
	 * @param desc 手机详情
	 * @param numIid 商品numIid
	 * @param session 授权
	 * @return
	 * @throws ApiException
	 */
	public String updateWldesc(String desc,Long numIid,String session,String title,Long userId,String nick) throws ApiException{
		try {
			if(desc==null){
				return null;
			}
			desc=desc.replace("<img>", "<imge>").replace("</img>", "</imge>");
			Map<String,Field> fieldMap = SchemaReader.readXmlForMap(SCHEMA_XML);
			Field f=fieldMap.get("wl_description");
			ComplexField cf=(ComplexField) f;
			ComplexValue cv=new ComplexValue();
			cf.setComplexValue(cv);
			//只处理图文
			List<ComplexValue> complexValueList=new ArrayList<ComplexValue>();
			cv.setMultiComplexFieldValues("wl_description_content", complexValueList);
			//解析desc
			Document dom=Jsoup.parse(desc);
			Elements descEls=dom.select("wapDesc");
			if(descEls.size()<1){
				return null;
			}
			long imgsize=0;
			Element wapDesc=descEls.get(0);
			Elements childs=wapDesc.children();
			for(Element e:childs){
				ComplexValue cv1=new ComplexValue();
				cv1.setInputFieldValue("wl_description_content_content", e.html());
				if("imge".equals(e.tagName())){//图片
					String url= e.html();
					if(checkImg(url)==1){//如果是图片，先检查图片是不是 要搬家，//或者是不是有效的
						UptoImgsResponse imgres=changeImgPhone(nick, title+"_手机", title+"_手机", url, userId);
						imgsize+=imgres.getImgsize();
						if(imgsize>=2560000){
							continue;
						}
						if(imgres.isSuccess()){
							cv1.setInputFieldValue("wl_description_content_content", imgres.getNewUrl());
						}
					}
					cv1.setSingleCheckFieldValue("wl_description_content_type", new com.taobao.top.schema.value.Value("image"));
				}else if("txt".equals(e.tagName())){
					cv1.setSingleCheckFieldValue("wl_description_content_type", new com.taobao.top.schema.value.Value("text"));
				}
				complexValueList.add(cv1);
			}
			
			//做提交字段链表
			MultiCheckField mcf=(MultiCheckField) fieldMap.get("update_fields");
			mcf.addValue("wl_description");
			//准备写出
			Iterator<String> it=fieldMap.keySet().iterator();
			List<Field> fieldlist=new ArrayList<Field>();
			while(it.hasNext()){
				fieldlist.add(fieldMap.get(it.next()));
			}
			SchemaWriter write=new SchemaWriter();
			String str=write.writeParamXmlString(fieldlist);
			
			//System.out.println(str);
			
			TaobaoClient client=getClient();
			ItemSchemaIncrementUpdateRequest req=new ItemSchemaIncrementUpdateRequest();
			req.setItemId(numIid);
			req.setParameters("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+str);
			ItemSchemaIncrementUpdateResponse response = client.execute(req , session);
//			System.out.println(response.getBody());
			//System.out.println(response.getSubMsg());
			return response.getSubMsg();
		} catch (TopSchemaException e) {
			// TODO Auto-generated catch block
			log.error("手机详情处理失败",e);
		}
		return null;
	}
	/**
	 * 返回0不需要处理，返回1要搬家
	 * @param url
	 * @return
	 */
	public static int checkImg(String url){
		if(!url.contains("taobaocdn.com")||url.contains("_!!")){
			return 1;
		}
		return 0;
	}

	/**
	 * 把一张图传到自己图片空间
	 * @param nick
	 * @param imagefilename
	 * @param title
	 * @param url
	 * @param userId
	 * @return
	 */
	public UptoImgsResponse changeImgPhone(String nick, String imagefilename, String title, String url, Long userId){
		UptoImgsRequest upload=new UptoImgsRequest();
		upload.setNick(nick);
		upload.setImagefilename(imagefilename);
		upload.setImagetitle(title);
		upload.setImgurl(url);
		upload.setUserid(userId);
		UptoImgsResponse res=(UptoImgsResponse) new PcOpenClient(XZAPPKEY, XZSECRET, XZTYPE).execute(upload);
		return res;
	}
}
