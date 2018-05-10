import com.utils.publics.Opt3Des;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class DESEncryptTest {

    public static void main(String[] args) throws IOException {
        String encryptPlainDate = Opt3Des.encryptPlainData("drawingkibu");
        Connection nick = Jsoup.connect("http://www.571xz.com/genTbToken.htm").data("nick", encryptPlainDate);
        Connection.Response execute = nick.execute();
        System.out.println(execute.body());
        System.out.println(execute);
    }
}
