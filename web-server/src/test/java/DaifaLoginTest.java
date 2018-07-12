import com.shigu.component.encryption.MD5;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhaohongbo on 17/3/21.
 */
public class DaifaLoginTest {

    @Test
    public void test() throws IOException {
        Connection conn=Jsoup.connect("http://www.571xz.com/selLoginUid.json");
        conn.cookie("JSESSIONID","55EAE3A25E8EBAB58EA0CE0DAB5840FD");
        conn.ignoreContentType(true);
        System.out.println(conn.execute().body());
    }

    public static void main(String[] args) {
        System.out.println(MD5.encrypt("524106"));
    }
}
