import com.openJar.responses.api.SnCategoryResponse;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.suning.api.entity.item.CategoryQueryResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SnTest {
    @Autowired
    SnCategoryService snCategoryService;
    @Test
    public void test() throws CustomException{

        SnCategoryResponse response=snCategoryService.getCategory("", 1l);
        List<CategoryQueryResponse.CategoryQuery> categoryQueries = response.getCategoryQueryList();
    }
}
