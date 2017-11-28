
import com.alibaba.fastjson.JSON;
import com.shigu.main4.order.vo.CantSendVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CantSendTest {

    public static void main(String[] args) {
        CantSendVO vo=new CantSendVO();
        vo.setCompanyId(66L);
        List<Long> list=new ArrayList<>();
        list.add(9L);
        list.add(15L);
        list.add(6L);
        list.add(13L);
        list.add(12L);
        list.add(14L);
        vo.setAreaIds(list);
        List<Long> provList=new ArrayList<>();
        provList.add(10L);
        vo.setProvIds(provList);
        List<CantSendVO> vos=new ArrayList<>();
        vos.add(vo);
        String jsonarr=JSONArray.fromObject(vos).toString();
        System.out.println(jsonarr);
//        List<CantSendVO> vos2=JSON.parseArray(jsonarr,CantSendVO.class);
//        System.out.println(test(vos2,66L,9L));
//        System.out.println(test(vos2,66L,20L));
//        System.out.println(test(vos2,67L,9L));
    }

    public static boolean test(List<CantSendVO> cantSendVOS,Long companyId,Long townId){
        CantSendVO vo=null;
        for(CantSendVO c:cantSendVOS){
            if (c.getCompanyId().equals(companyId)) {
                vo=c;
                break;
            }
        }
        if (vo == null) {
            return false;
        }
        //得到地区ID
        for(Long twid:vo.getAreaIds()){
            if (twid.equals(townId)) {
                return true;
            }
        }
        return false;
    }
}
