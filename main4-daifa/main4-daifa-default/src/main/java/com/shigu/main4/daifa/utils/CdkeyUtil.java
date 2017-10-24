package com.shigu.main4.daifa.utils;


import com.opentae.data.daifa.beans.DaifaCdkey;
import com.opentae.data.daifa.examples.DaifaCdkeyExample;
import com.opentae.data.daifa.interfaces.DaifaCdkeyMapper;
import com.shigu.main4.tools.SpringBeanFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CdkeyUtil {

	//字母选择区域
	private static String[] zimu={"A","B","C","D","E","F","G","H","J"
		,"K","L","M","N","P","Q","R","S","T","U","V","W","X","Y"};
	private static int number_size = 999;
	private static Map<String, String> map = new HashMap<>();
	
	static{
		map.put("0", "A");
		map.put("1", "B");
		map.put("2", "C");
		map.put("3", "D");
		map.put("4", "E");
		map.put("5", "F");
		map.put("6", "G");
		map.put("7", "H");
		map.put("8", "J");
		map.put("9", "K");
		map.put("A", "L");
		map.put("B", "M");
		map.put("C", "N");
		map.put("D", "P");
		map.put("E", "Q");
		map.put("F", "R");
		map.put("G", "S");
		map.put("H", "T");
		map.put("I", "U");
		map.put("J", "V");
		map.put("K", "W");
		map.put("L", "X");
		map.put("M", "Y");
	}
	
	
	private static DaifaCdkeyMapper daifaCdkeyMapper;

	static{
        daifaCdkeyMapper=SpringBeanFactory.getBean(DaifaCdkeyMapper.class);
    }

	

	
	/*
	 * 获取cdkey
	 */
	public static synchronized String getkey()
	{
		Date d = new Date();
		int i;
		try {
			i = getnumber(d);
		} catch (ParseException e) {
			return null;
		}
		String cdkey = CdkeyUtil.number2CDkey(i+1, d);
		if(cdkey==null)
			return null;
		DaifaCdkey daifaCdkey = new DaifaCdkey();
		daifaCdkey.setCreateTime(d);
		daifaCdkey.setDate(d);
		daifaCdkey.setCdkey(cdkey);
		int j = insertCdkey(daifaCdkey);
		if(j==0){
			return null;
		}else
		{
			return cdkey;
		}
	}
	
	/*
	 * 查询某一天的条数
	 */
	private static int getnumber(Date date) throws ParseException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String datestr =df.format(date);
		Date dateday = df.parse(datestr);   
		DaifaCdkeyExample example = new DaifaCdkeyExample();
		example.createCriteria().andDateEqualTo(dateday);
		return daifaCdkeyMapper.countByExample(example);
	}
	
	/*
	 * 
	 * 
	 */
	private static int  insertCdkey(DaifaCdkey cdkey)
	{
		return daifaCdkeyMapper.insert(cdkey);
	}
	
	
	/*
	 * 通过数字或者cdkey
	 */
	private static String number2CDkey(int i, Date date)
	{
		int zimu_numbers = zimu_number(i);
		int nextnumber = next_number(i);
		String zimu_1 = zimu_size(zimu_numbers);
		if(zimu_1!=null)
		{
			if(date==null)
				date= new Date();
			SimpleDateFormat df=new SimpleDateFormat("MMdd-");
			String dstr = df.format(date);
			return dstr+change(zimu_1)+nextnumber;
		}else
		{
			return null;
		}
	}
	
	//通过传入数字换算需要几个字母，每个字母的进制为number_size
	private static int zimu_number(int i)
	{
		int j = i/number_size;
		if(next_number(i)==number_size)
		{
			return j-1;
		}
		return j;
	}


    /*
	 * 剩下的数字
	 */
	private static int next_number(int i)
	{
		int j = i%number_size;
		if(j==0)
		{
			return number_size;
		}
		return j;
	}
	
	//通过字母数量来计算需要的zimu.length进制的数字
	private static String zimu_size(int i)
	{
		BigNumber number_10_jinzhi = new BigNumber(""+i,10) ;
        BigNumber out =  number_10_jinzhi.HexConversion(zimu.length, 0);
        return out.toString();
    }
	
	//23进制数字转换成符合条件的字符串，根据map里面对应的来
	private static String change(String old)
	{
		String newstr = "";
		if(old!=null)
		{
			for(int j=0;j<old.length();j++ )
			{
				char cart = old.charAt(j);
				if(map.containsKey(""+cart))
				{
					newstr += map.get(""+cart);
					
				}else
				{
					return null;
				}
			
			}
			return newstr;
		}else
		{
			return "A";
		}
	}
}
