import com.aliyun.oss.OSSClient;
import com.shigu.main4.tools.OssIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * oss test
 * Created by zhaohongbo on 17/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/spring/store_test.xml" )
public class OssIOTest {

    @Autowired
    OssIO ossIO;
    @Test
    public void test(){
        OSSClient ossClient = new OSSClient(ossIO.getEndpoint(), ossIO.getAccessKeyId(), ossIO.getAccessKeySecret());
        boolean found = ossClient.doesObjectExist(ossIO.getBucketName(), "gg/publish.png");
        System.out.println(found);
        ossClient.shutdown();
        found = ossClient.doesObjectExist(ossIO.getBucketName(), "gg/publish.png");
        System.out.println(found);
        ossClient.shutdown();
    }
}
