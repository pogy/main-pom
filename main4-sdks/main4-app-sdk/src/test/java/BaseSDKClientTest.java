import com.alibaba.fastjson.JSON;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import com.shigu.main4.tools.RedisIO;

import java.lang.reflect.Field;

/**
 * 类名：BaseSDKClientTest
 * 类路径：PACKAGE_NAME.BaseSDKClientTest
 * 创建者：王浩翔
 * 创建时间：2017-09-21 14:59
 * 项目：main-pom
 * 描述：
 */
public class BaseSDKClientTest {
    protected OpenClient client = new PcOpenClient("3838438", "37456A6A5CA10F9A988F12BFECD88575", "test");
    protected RedisIO redisIO = getRedisIOInstance();
    protected void sout(Object obj){
        System.out.println(JSON.toJSONString(obj));
    }


    private RedisIO getRedisIOInstance() {
        RedisIO redisIO = new RedisIO();
        try {
            setValues(redisIO, "IP", "121.41.168.7");
            setValues(redisIO, "PORT", 30000);
            setValues(redisIO, "AUTH", "r-bp1ce514f820bd84:Killer81682024");
            setValues(redisIO, "MAX_ACTIVE", 600);
            setValues(redisIO, "MAX_IDLE", 300);
            setValues(redisIO, "MAX_WAIT", 1000);
        } catch (IllegalAccessException | NoSuchFieldException ignore) {
        }
        redisIO.init();
        return redisIO;
    }

    private void setValues(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
