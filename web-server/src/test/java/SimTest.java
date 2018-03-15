import com.shigu.zf.utils.SimilarityMap;

public class SimTest {
    public static void main(String[] args) {
        SimilarityMap map=new SimilarityMap<>();
        map.put("哈尔滨市",1L);
        System.out.println(map.get("哈密市"));
    }
}
