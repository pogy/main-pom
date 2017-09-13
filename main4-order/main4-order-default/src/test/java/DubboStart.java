import com.alibaba.dubbo.container.Main;
import com.shigu.main4.order.model.impl.XzPayerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DubboStart {
    private static final Logger logger = LoggerFactory.getLogger(XzPayerServiceImpl.class);
    public static void main(String[] args) {
        Main.main(args);
    }
}
