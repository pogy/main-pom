import org.elasticsearch.index.query.QueryBuilders;

/**
 * Created by zhaohongbo on 17/4/11.
 */
public class SearchTest {
    public static void main(String[] args) {
        System.out.println(QueryBuilders.matchQuery("ttt","2222").minimumShouldMatch("222"));

    }
}
