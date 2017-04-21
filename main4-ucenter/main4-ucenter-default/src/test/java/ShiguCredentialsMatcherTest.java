import com.shigu.component.shiro.ShiguCredentialsMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 密码验证器测试
 * Created by zhaohongbo on 17/2/15.
 */
public class ShiguCredentialsMatcherTest {

    @Test
    public void testCrept(){
        assertEquals("dcc62e31c8030d9488969c5da73d2f16", new ShiguCredentialsMatcher().encrypt("z123456"));
    }
}
