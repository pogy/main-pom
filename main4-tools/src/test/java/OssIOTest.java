import com.aliyun.oss.OSSClient;
import com.shigu.main4.tools.OssFile;
import com.shigu.main4.tools.OssIO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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


    @Test
    public void testCreateDir() {
        ossIO.createDir("testdir/", "innerdir/aa/ff");
    }

    @Test
    public void testListFile() {
        List<OssFile> list =  ossIO.listFiles("testdir/");
        System.out.println(list);
    }

    @Test
    public void testRenameFile() {
        ossIO.renameFile("testdir/11/33/logoWeb.png", "testdir/11/33/logoWeb1.png");
    }

    @Test
    public void testDeleteFile() {
        ossIO.deleteFile("testdir/11/22/");
    }

    @Test
    public void testMoveFile() {
        ossIO.moveFile("testdir/11/33/logoWeb1.png", "testdir/11/44/logoWeb.png");
    }


    @Test
    public void testGetFileSize() {
        ossIO.getFileSize("testdir/");
    }
}
