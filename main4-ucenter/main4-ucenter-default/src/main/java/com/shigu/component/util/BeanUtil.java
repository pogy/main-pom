package com.shigu.component.util;

import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BeanUtil {
	public static List<ShiguGoodsTiny> convertGoods(List<ShiguGoodsSoldout> goodsList){
		List<ShiguGoodsTiny> list = new ArrayList<ShiguGoodsTiny>();
		ShiguGoodsTiny good = null;
		for (ShiguGoodsSoldout soldout : goodsList) {
			good = new ShiguGoodsTiny();
			good.setGoodsId(soldout.getGoodsId());//主键
			good.setNumIid(soldout.getNumIid());//淘宝商品编号
			good.setDetailUrl(soldout.getDetailUrl());//商品url
			good.setTitle(soldout.getTitle());//商品标题,不能超过60字节
			good.setNick(soldout.getNick());//卖家昵称
			good.setType(soldout.getType());//商品类型@(soldout.getfixed:一口价;auction:拍卖)注：取消团购
			good.setCreated(soldout.getCreated());//Item的发布时间@，目前仅供taobao.item.add和taobao.item.get可用
			good.setIsLightningConsignment(soldout.getIsLightningConsignment());//是否24小时闪电发货
			good.setIsFenxiao(soldout.getIsFenxiao());//非分销商品@0，代销：1，经销：2
			good.setIsXinpin(soldout.getIsXinpin());//标示商品是否为新品@ 值含义：true-是，false-否。
			good.setValidThru(soldout.getValidThru());//有效期@7或者14（默认是7天）
			good.setOuterId(soldout.getOuterId());//商家外部编码@(soldout.get可与商家外部系统对接)。需要授权才能获取。
			good.setCid(soldout.getCid());//商品所属的叶子类目 id
			good.setCidAll(soldout.getCidAll());//淘宝商品类目所有级别@把所有级别的类每层类目之间用“/”如"53355/4456/345677/33"
			good.setPicUrl(soldout.getPicUrl());//商品主图片地址
			good.setNum(soldout.getNum());//商品数量
			good.setSoldOutTime(soldout.getSoldoutTime());//下架时间
			good.setListTime(soldout.getListTime());//淘宝上架时间@（格式：yyyy-MM-dd HH:mm:ss）
			good.setDelistTime(soldout.getDelistTime());//淘宝下架时间@（格式：yyyy-MM-dd HH:mm:ss）
			good.setStuffStatus(soldout.getStuffStatus());//商品新旧程度@(soldout.get全新:new，闲置:unused，二手：second)
			good.setCity(soldout.getCity());//所在城市
			good.setProv(soldout.getProv());//所在省份
			good.setPriceString(soldout.getPriceString());//商品价格字符型@，格式：5.00；单位：元；精确到：分
			good.setPrice(soldout.getPrice());//价格数字型@默认设置成淘宝批发价*100(soldout.get让带分的数字形成一个整数)
			good.setPiPrice(soldout.getPiPrice());//批发价格@默认设置成淘宝批发价*100让小数点后面的分变成整数
			good.setPiPriceString(soldout.getPiPriceString());//批发价字符型
			good.setPriceRole(soldout.getPriceRole());//价格折扣
			good.setPostFee(soldout.getPostFee());//平邮费用@格式：5.00；单位：元；精确到：分
			good.setExpressFee(soldout.getExpressFee());//快递费用@格式：5.00；单位：元；精确到：分
			good.setEmsFee(soldout.getEmsFee());//ems费用@格式：5.00；单位：元；精确到：分
			good.setHasDiscount(soldout.getHasDiscount());//支持会员打折,true/false
			good.setFreightPayer(soldout.getFreightPayer());//运费承担方式,seller（卖家承担），buyer(soldout.get买家承担）
			good.setHasShowcase(soldout.getHasShowcase());//橱窗推荐@true/false
			good.setModified(soldout.getModified());//商品修改时间@（格式：yyyy-MM-dd HH:mm:ss）
			good.setMarketId(soldout.getMarketId());//市场ID
			good.setMarket(soldout.getMarket());//市场名
			good.setParentMarketId(soldout.getParentMarketId());//上级市场ID
			good.setParentMarketName(soldout.getParentMarketName());//上级市场
			good.setStoreNum(soldout.getStoreNum());//档口号
			good.setIsTaobaoSynchronization(soldout.getIsTaobaoSynchronization());//是否要与淘宝同步@不同步1同步默认为1
			good.setIsAkeyToUpload(soldout.getIsAkeyToUpload());//是否可一键上传@默认为1可上传
			good.setIsTrade(soldout.getIsTrade());//是否可交易@默认为0不可交易，会员 可以在店铺里进行设置为1可交易
			good.setIsEfficacious(soldout.getIsEfficacious());//是否有效
			good.setStoreId(soldout.getStoreId());//店铺ID@我们自己站点的
			good.setClicks(soldout.getClicks());//点击次数
			good.setIsClosed(soldout.getIsClosed());//是否关店@0正常1关店
			good.setGoodsStatus(soldout.getGoodsStatus());//商品状态@0正常1下架
			good.setGoodsNo(soldout.getGoodsNo());//货号@可交易商品一定要设置货号（是档口对商品的定义）
			good.setSortOrder(soldout.getSortOrder());//排序
			good.setNumberTradableGoods(soldout.getNumberTradableGoods());//可交易商品数量
			good.setNotNumberTradableGoods(soldout.getNotNumberTradableGoods());//不可交易商品数量
			good.setWebSite(soldout.getWebSite());//一键上传的站点@比如hz或gz
			//good.setsoldoutReason;//
			good.setSoldOutTime(soldout.getSoldoutTime());//
			//good.setsoldUserId;//
			good.setRemark10(soldout.getRemark10());//
			good.setRemark9(soldout.getRemark9());//
			good.setRemark8(soldout.getRemark8());//
			good.setRemark7(soldout.getRemark7());//
			good.setRemark6(soldout.getRemark6());//
			good.setRemark5(soldout.getRemark5());//
			good.setRemark4(soldout.getRemark4());//
			good.setRemark3(soldout.getRemark3());//
			good.setRemark1(soldout.getRemark1());//
			good.setRemark2(soldout.getRemark2());//
			list.add(good);
		}
		
		
		return list;
	}


	 /**
	  * 获取六位的随机数
	  * @return
	  */
	 public static String getNO(){
		 Double d = Math.random()*1000000;
		 String s = d.toString();
		 s = s.substring(0,s.lastIndexOf("."));
		 while (s.length()<6) {
			int i=(int)(Math.random()*10);
			s+=i;
		 }
		 return s;
	 }
	/**
	 * 判断对象是否为空
	 * 空返回true；非空返回false
	 * @param object
	 * @return
	 */
	public static Boolean isNull(Object object){
		Boolean isNull = null;
		if(object instanceof String){
			isNull = object!=null && object.toString().trim().length()>0 ? false : true;
		}else{
			isNull = object!=null ? false : true;
		}
		return isNull;
	}
	 public static class DateOperation {
			/**
			  * 默认日期格式
			  */
			 public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
			 /**
			  * 获取时间转换对象
			  * @param format
			  * @return
			  */
			 public static SimpleDateFormat getSimpleDateFormat(String format){
				 if (null == format || format.trim().length()<0) {
					  format = DEFAULT_FORMAT;
				  }
				 SimpleDateFormat sdf = new SimpleDateFormat(format);
				 return sdf;
			 }
			 /**
			  * 字符串转换成日期 如果转换格式为空，则利用默认格式进行转换操作
			  * @param str 字符串
			  * @param format 日期格式
			  * @return 日期
			  * @throws java.text.ParseException 
			  */
			 public static Date strDate(String str, String format){
			  if (null == str || "".equals(str)) {
			   return null;
			  }
			  SimpleDateFormat sdf = null;
			  if(!BeanUtil.isNull(format)){
				  sdf = getSimpleDateFormat(format);
			  }else{
				  sdf =  getSimpleDateFormat(DateOperation.datePattern(str));
			  }
			  Date date = null;
			    try {
					date = sdf.parse(str);
				} catch (Exception e) {
					e.printStackTrace();
				}
			    return date;
			 }

			 /** 日期转换为字符串
			  * @param date 日期
			  * @param format 日期格式
			  * @return 字符串
			  */
			 public static String dateStr(Date date, String format) {
				  if (null == date) {
					  return null;
				  }
				  SimpleDateFormat sdf = getSimpleDateFormat(format);
				  return sdf.format(date);
			 }

			 /**
			  * 时间转换为字符串
			  * @param time
			  * @return
			  */
			 public static String timestampStr(Timestamp time) {
				  Date date = null;
				  if(null != time){
					  date = new Date(time.getTime());
				  }
			  return dateStr(date, DEFAULT_FORMAT);
			 }

			 /** 字符串转换时间戳
			  * @param str
			  * @return
			  */
			 public static Timestamp strTimestamp(String str) {
				 Date date = strDate(str, DEFAULT_FORMAT);
				 return new Timestamp(date.getTime());
			 }
			 /**
			  * 匹配單純時間的正則表達式
			  */
			private static final String singleTime_regexp = "^((([0-1]?\\d)|(2[0-3]))[-,\\.:][0-5]?\\d[-,\\.:][0-5]?\\d)([-,\\.]\\d{1,3})?$";

			 /**
			  * 匹配單純日期的正則表達式
			  */
			private static final String singleDate_regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})[-\\./,](0?[13578]|1[02])[-\\./,](0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})[-\\./,](0?[13456789]|1[012])[-\\./,](0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})[-\\./,]0?2[-\\./,](0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))[-\\./,]0?2-29))$";
			/**
			 * 获取格式化格式
			 * @param dateString
			 * @return
			 */
			public static String datePattern(String dateString) {
				String pattern = dateString;
				if(!dateString.matches(singleTime_regexp)) {
				  pattern = dateString.replaceFirst("^[0-9]{4}([^0-9])", "yyyy$1");
				  pattern = pattern.replaceFirst("^[0-9]{2}([^0-9])", "yy$1");
				  pattern = pattern.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1MM$2");
				  pattern = pattern.replaceFirst("([^0-9])[0-9]{1,2}(\\s+|$)", "$1dd$2");
				}
				if(!dateString.matches(singleDate_regexp)) {
				  pattern = pattern.replaceFirst("(\\s+|^)[0-9]{1,2}([^0-9])", "$1HH$2");
				  pattern = pattern.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1mm$2");
				  pattern = pattern.replaceFirst("([^0-9])[0-9]{1,2}", "$1ss");
				  pattern = pattern.replaceFirst("([^0-9])[0-9]{1,3}", "$1SSS");
				}
				pattern = pattern.replaceAll("\\s+", UtilCharacter.BLANK_SPACE);
				return pattern;
			}
		}
}

