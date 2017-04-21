package test;

import java.io.*;

/**
 * Created by wxc on 2017/4/2.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class CountSync {

    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/wxc/Desktop/sync.log");
        int i = 0;
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                if (tmp.contains("全店同步处理结果")){
                    i++;
                    if (tmp.contains("失效"))
                        System.out.println(tmp);
                }
            }
        }
        System.out.println(i);
    }
}
