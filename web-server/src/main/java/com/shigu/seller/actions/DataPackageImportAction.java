package com.shigu.seller.actions;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;
import com.shigu.seller.services.DataPackageImportService;
import com.shigu.seller.vo.PackageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @类编号
 * @类名称：DataPackageImportAction
 * @文件路径：com.shigu.seller.actions.DataPackageImportAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/3 20:00
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class DataPackageImportAction {

    @Autowired
    RedisIO redisIO;
    @Autowired
    DataPackageImportService dataPackageImportService;




    /**
     * ====================================================================================
     * @方法名： importtempGoods
     * @user gzy 2017/11/3 20:46
     * @功能：数据包上传后的内容
     * @param: [goodsPackageUrl, session, model]
     * @return: net.sf.json.JSONObject
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("seller/noticeGoodsPackageUploaded")
    @ResponseBody
    public JSONObject importtempGoods(String goodsPackageUrl, HttpSession session, Model model) throws Main4Exception {

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();

        List<ShiguGoodsTinyVO> list= dataPackageImportService.importtempGoods (goodsPackageUrl, logshop.getShopId (), "test");
        redisIO.put ("packageList"+logshop.getShopId (),list);
        return JsonResponseUtil.success();
    }

    /**
     * ====================================================================================
     * @方法名： uploadPackageList
     * @user gzy 2017/11/3 20:43
     * @功能：处理完毕的数据包列表
     * @param: [session, model]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("/uploadPackageList")
    public String uploadPackageList(HttpSession session, Model model) throws Main4Exception {

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        List<ShiguGoodsTinyVO> list=redisIO.getList ("packageList"+logshop.getShopId (),ShiguGoodsTinyVO.class);
        List<PackageVO> voList=new ArrayList<> ();
        if(list.size ()>0){
            for(ShiguGoodsTinyVO goodsVO:list){
                PackageVO vo=new PackageVO ();
                vo.setCatName (goodsVO.getCname ());
                vo.setGoodsId (goodsVO.getGoodsId ());
                vo.setPiPrice (goodsVO.getPiPriceString ());
                vo.setShopCode (goodsVO.getOuterId ());
                vo.setTitle (goodsVO.getTitle ());
                voList.add (vo);
            }

        }
        model.addAttribute("packageList",voList);
        model.addAttribute ("allGoodsCount",list.size ());
        redisIO.put ("packageList",list);

        return "/uploadPackageList";
    }

}
