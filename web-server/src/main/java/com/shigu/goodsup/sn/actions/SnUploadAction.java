package com.shigu.goodsup.sn.actions;

import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.shigu.goodsup.sn.service.SnUpItemService;
import com.shigu.goodsup.sn.service.SnUserInfoService;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.Map;

@Controller
public class SnUploadAction {
    @Autowired
    SnUserInfoService snUserInfoService;
    @Autowired
    SnCategoryService snCategoryService;
    @Autowired
    SnUpItemService snUpItemService;

    @RequestMapping("sn/index")
    public String upload(HttpSession session,Map<String,Object> map,Long itemId) throws CustomException{
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String SnUsername=snUserInfoService.getSnUsernameBySubUid(ps.getSubUserId());
        int total = Integer.valueOf(snCategoryService.getCategory(SnUsername).getTotalSize());
        if(total==0){
            throw new CustomException("不是苏宁商家");
        }
        SnPageItem snPageItem=snUpItemService.findGoods(itemId);
        if(snPageItem==null){
            map.put("errmsg","商品不存在");
            return "suning/uperror";
        }
        if(snPageItem.getItem().getTitle()!=null){
            snPageItem.setTitleLength(snPageItem.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
        }
        if(snPageItem.getItem().getSellPoint()!=null){
            snPageItem.setSellPointLength(snPageItem.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
        }
        return "suning/part/success";
    }
}
