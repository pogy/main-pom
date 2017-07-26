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
        List<OssFile> list =  ossIO.getFileList("testdir/");
        System.out.println(list);
    }

    @Test
    public void testRenameFile() {
        ossIO.renameFile("testdir2/dd/", "testdir2/11/");
    }

    @Test
    public void testDeleteFile() {
        ossIO.deleteFile("testdir/aa/");
    }

    @Test
    public void testMoveFile() {
        ossIO.moveFile("testdir2/zz/", "testdir2/rr/");
    }


    @Test
    public void testGetFileSize() {
        ossIO.getSizeInfo("testdir/");
    }
}
