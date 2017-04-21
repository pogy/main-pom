package com.shigu.component.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

//import com.zy.services.recruitment.webSiteResume.util.ExcelUtil;

/**
 * 提供日志输出功能类（使用Log4j）
 *==================================================================
 * @author 顾邹阳
 * @Date 2009-7-2上午08:51:38
 * @comments:
 *==================================================================
 */
public final class LogUtil {
	//定义重庆网通输出日志文件的名称
	public static final String FILE_LAND_LOG = "zy_log.log";//要输出的一般日志名
    //定义iBaties输出日志文件的名称
	/*public static final String FILE_IBATIES_LOG = "ibaties.log";//要输出的ibaties文件名
	//定义SQL输出日志文件的名称
	public static final String FILE_SQL_LOG = "land_sql.log";//要输出的sql文件名
	*/
	//定义hibernate3的日志输出
	public static final String FILE_HIBERNATE_LOG="mybatis.log";//要输出的hibernate文件名
    //定义struts输出日志文件的名称
	public static final String FILE_STRUTS_LOG = "struts.log";//要输出的struts日志名
	
	
	//定义输出日志文件的目录
	public static final String FOLDER_LOG = "logs" + File.separatorChar;
	
	private LogUtil() {
		//构造器为私有，不允许客户创建此对象（通过getLog方法获取）
	}//end of constructor
	
	//初始化类( 初始Log4j )
    static {
    	//查找log4j配置文件
    	URL url = Loader.getResource( "land_log4j.properties" ); //这是是配制文件的名称，//放在SRC下或CLASSES下
        try {
			if( url != null ) {
                //实现地址重新编码（防止中文字符变成乱码'%xx'）
				String systemEncoding = ( new OutputStreamWriter( new ByteArrayOutputStream() ) ).getEncoding();
				String urlpath = "";
				if( systemEncoding == null || systemEncoding.trim().length() < 1 ) {
				    urlpath = URLDecoder.decode( url.getPath(), "UTF-8" );
				} else {
					urlpath = URLDecoder.decode( url.getPath(), systemEncoding );
				}
				//获取配置文件在系统中实际路径
				String fileRFSPath = new File( urlpath ).getAbsolutePath();
				//获取LOG日志所在路径（因为配置文件放于class目录下，所以取得的地址为"WEB-INF\logs\land_cms.log"，如有变动需改动代码）如果是windows那么可以用\\如果是liux或AIX那么就用File.separator
				/*String tempLogFileUri = fileRFSPath.substring( 0, fileRFSPath.lastIndexOf( "\\" ) );
				String landLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( "\\" ) ) 
				                        + File.separatorChar + FOLDER_LOG + FILE_LAND_LOG; 
			    String iBatiesLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( "\\" ) ) 
			                               + File.separatorChar + FOLDER_LOG + FILE_IBATIES_LOG; 
			    String strutsLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( "\\" ) ) 
			                              + File.separatorChar + FOLDER_LOG + FILE_STRUTS_LOG; */
String tempLogFileUri = fileRFSPath.substring( 0, fileRFSPath.lastIndexOf( File.separator ) );
				String landLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( File.separator ) ) 
				                        + File.separatorChar + FOLDER_LOG + FILE_LAND_LOG; 
			 /*   String iBatiesLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( File.separator ) ) 
			                               + File.separatorChar + FOLDER_LOG + FILE_IBATIES_LOG; 
			    String sqlLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( File.separator ) ) 
                + File.separatorChar + FOLDER_LOG + FILE_SQL_LOG; */
			    String hibernateLogFileUri=fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( File.separator ) ) 
                + File.separatorChar + FOLDER_LOG + FILE_HIBERNATE_LOG; 
			    String strutsLogFileUri = fileRFSPath.substring( 0, tempLogFileUri.lastIndexOf( File.separator ) ) 
			                              + File.separatorChar + FOLDER_LOG + FILE_STRUTS_LOG;
				//设置系统环境变量（配置文件中用于读取LOG日志存放位置）
				System.setProperty( "zy_log.logfile", landLogFileUri );
				//System.setProperty( "land_iBatis.logfile", iBatiesLogFileUri );
				System.setProperty( "zy_struts.logfile", strutsLogFileUri );
				//System.setProperty( "land_SQL.logfile", sqlLogFileUri );
				System.setProperty( "zy_mybatis.logfile", hibernateLogFileUri );
				
				
				//用配置文件配置LOG4J
				PropertyConfigurator.configure( fileRFSPath ); 
			} else {
				//无法找到Log4j配置文件，但忽略错误
			}
		} catch (UnsupportedEncodingException e) {
			//不支持UTF-8编码方式，忽略错误
		}//end of catch
    }//end of static
    
    /**
     * 根据配置获得log4j的Logger对象，用于日志输出之类.(如果参数为String,
     * 则该String作为日志输出栏目名称,否则则以类名作为日志输出栏目名称)
     * @param obj
     * @return Logger
     */
    public static Logger getLog( Object obj ) {
    	if( obj instanceof String ) {
    		return Logger.getLogger( (String)obj );
    	} else if ( obj instanceof Class ) {
    		return Logger.getLogger( (Class)obj );
    	} else {
    		return Logger.getLogger( obj.getClass() );
    	}//end of else
    }//end of method getLog()

//	public static LogUtil getLogger(Class<ExcelUtil> class1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}//end of class

