import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;
/**
 * Created By pc on 2017-10-24/17:35
 */
public class ScanImgTest {

    public static final String storeUrl ="https://www.wsy.com/market.htm?kid=1";
//    public static final String imgUrl ="https://www.wsy.com/store/p/xxx/search.htm";

    @Test
    public void scanImg() throws IOException, WriteException {
        Document doc = Jsoup.connect(storeUrl).timeout(1000*60*30).get();
        Elements container = doc.getElementsByClass("shoplist");
        Document containerDoc = Jsoup.parse(container.toString());
        Elements module = containerDoc.getElementsByClass("dk");
        Document moduleDoc = Jsoup.parse(module.toString());

        Elements clearfix = moduleDoc.select("a");  //选择器的形式

        Map<String,String> stores = new HashMap<>();
        Map<String,String> items = new HashMap<>();
        for (Element clearfixli : clearfix){
            Document clearfixliDoc1 = Jsoup.parse(clearfixli.toString());
            Elements kind = clearfixliDoc1.select("a");  //选择器的形式
            Elements title = clearfixliDoc1.select("span");

//            System.out.println("详情链接"+kind.attr("href"));  //标题下的链接
//            System.out.println("标题"+title.text());

//            stores.put(title.text(),"https://www.wsy.com"+kind.attr("href"));

            String url = "https://www.wsy.com/store/p"+kind.attr("href")+"/search.htm";
            Document doc1 = Jsoup.connect(url).timeout(1000*60*30).get();
            Elements container1 = doc1.getElementsByClass("goods_list_bd");
            Document moduleDoc22 = Jsoup.parse(container1.toString());
            Elements module22 = moduleDoc22.select("a");

            for (Element item : module22){
                Document clearfixliDoc3 = Jsoup.parse(item.toString());
                Elements kind3 = clearfixliDoc3.select("img");  //选择器的形式
                String href = kind3.attr("src");
                Elements a = clearfixliDoc3.select("a");  //选择器的形式
                boolean flag = false;
                if (href.contains("wsy.com")){
                    System.err.println(href);
                    flag =true;
                    for (Element aitem : a){
                        items.put("https://wsy.com"+aitem.attr("href"),href);
                    }
                }
                if (flag) {
                    stores.put(title.text(), url);
                }
            }
        }
        createExcel(new FileOutputStream(new File("D:\\otherWorkSpace\\网商园wsy-com商品.xls")),items,"商品链接","图片链接");
        createExcel(new FileOutputStream(new File("D:\\otherWorkSpace\\网商园wsy-com.xls")),stores,"档口号","档口链接");
//        System.out.println(stores);

    }

    public void createExcel(OutputStream os,Map<String,String> stores,String title1,String title2 ) throws WriteException,IOException{
        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        Label xuexiao = new Label(0,0,title1);
        sheet.addCell(xuexiao);
        Label zhuanye = new Label(1,2,title2);
        sheet.addCell(zhuanye);
        //把创建的内容写入到输出流中，并关闭输出流
        int i = 1;
        for (Map.Entry<String,String> entry : stores.entrySet()){
            Label qinghua = new Label(0,i,entry.getKey());
            sheet.addCell(qinghua);
            Label jisuanji = new Label(1,i,entry.getValue());
            sheet.addCell(jisuanji);
            i++;
        }
        workbook.write();
        workbook.close();
        os.close();
    }

}
