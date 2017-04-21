package com.shigu.sysman.spread.actions;

import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.GoatItem;
import com.opentae.data.mall.beans.GoatLocation;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.sysman.spread.bo.GoatFieldBo;
import com.shigu.sysman.spread.bo.GoatFieldValueBo;
import com.shigu.sysman.spread.bo.GoatItemBo;
import com.shigu.sysman.spread.bo.GoatLocationBo;
import com.shigu.sysman.spread.service.GoatFieldService;
import com.shigu.sysman.spread.service.GoatFieldValueService;
import com.shigu.sysman.spread.service.GoatItemService;
import com.shigu.sysman.spread.vo.GoatFieldValueVo;
import com.shigu.sysman.spread.vo.GoatFieldVo;
import com.shigu.sysman.spread.vo.GoatItemVo;
import com.shigu.sysman.spread.vo.GoatLocationVo;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 广告位控制器
 *
 * @author shigu_zjb
 * @date 2017/04/10 10:11
 *
 */
@Controller
public class GoatItemController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(GoatItemController.class);

    @Autowired
    private GoatItemService goatItemService;

    @Autowired
    private GoatFieldService goatFieldService;

    @Autowired
    private GoatFieldValueService goatFieldValueService;


    /**
     * 广告位管理
     * @param goatItemBo
     * @return
     */
    @RequestMapping(value = "/sysman/goat/itemList" , method = RequestMethod.GET)
    public String queryList(GoatItemBo goatItemBo, HttpServletRequest request){
        if(goatItemBo == null){
            goatItemBo = new GoatItemBo();
        }
        ShiguPager<GoatItemVo> goatItemVoShiguPager = goatItemService.findGoatItemPager(goatItemBo);
        request.setAttribute("pager", goatItemVoShiguPager);
        return "sysman/spread/item/item_list";
    }

    /**
     * 新增广告位VIEW
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addItemView" , method = RequestMethod.GET)
    public String addGoatItemView(Long locationId, HttpServletRequest request){
        GoatFieldBo goatFieldBo = new GoatFieldBo();
        goatFieldBo.setLocationId(locationId);
        List<GoatFieldVo> goatFieldList = goatFieldService.findGoatFieldList(goatFieldBo);
        request.setAttribute("locationId", locationId);
        request.setAttribute("fieldList", goatFieldList);
        return "sysman/spread/item/add_item";
    }

    /**
     * 新增广告位
     * @param goatItem
     * @return
     */
    @RequestMapping(value = "/sysman/goat/addGoatItem" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addGoatItem(GoatItem goatItem,String startTimeStr,String endTimeStr, HttpServletRequest request){
        ResponseBase rsp = new ResponseBase();

        if(goatItem == null){
            rsp.setMsg("新增广告位发生错误");
            return JSONObject.fromObject(rsp);
        }
        if(goatItem.getLocalId() == null){
            rsp.setMsg("请输入广告位ID");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(startTimeStr)){
            rsp.setMsg("请选择开始时间");
            return JSONObject.fromObject(rsp);
        }
        if(StringUtils.isEmpty(endTimeStr)){
            rsp.setMsg("请选择结束时间");
            return JSONObject.fromObject(rsp);
        }
        if(goatItem.getSort() == null){
            goatItem.setSort(0);
        }

        Date startTime = DateUtil.stringToDate(startTimeStr,DateUtil.patternD);
        Date endTime = DateUtil.stringToDate(endTimeStr,DateUtil.patternD);
        goatItem.setStartTime(startTime);
        goatItem.setEndTime(endTime);
        GoatFieldBo goatFieldBo = new GoatFieldBo();
        goatFieldBo.setLocationId(goatItem.getLocalId());
        List<GoatFieldVo> goatFieldList = goatFieldService.findGoatFieldList(goatFieldBo);

        if(goatFieldList.size() == 0){
            rsp.setMsg("广告列为空无法新增广告");
            return JSONObject.fromObject(rsp);
        }

        List<GoatFieldValue> fieldValueList = new ArrayList<GoatFieldValue>();
        for(int i = 0;i<goatFieldList.size();i++){
            GoatFieldVo goatFieldVo = goatFieldList.get(i);
            String values = request.getParameter(goatFieldVo.getFieldName());

            if(goatFieldVo.getMustHave()&&StringUtils.isEmpty(values)){
                rsp.setMsg(goatFieldVo.getTitle() + " 不能为空");
                return JSONObject.fromObject(rsp);
            }
            if(goatFieldVo.getMaxLength()!=null){
                if(values.length() > goatFieldVo.getMaxLength().intValue()){
                    rsp.setMsg(goatFieldVo.getTitle() + " 最大长度" + goatFieldVo.getMaxLength().intValue());
                    return JSONObject.fromObject(rsp);
                }
            }
            GoatFieldValue goatFieldValue = new GoatFieldValue();
            goatFieldValue.setFid(goatFieldVo.getFid());
            goatFieldValue.setValue(values);
            fieldValueList.add(goatFieldValue);
        }

        goatItem.setDisEnabled(false);
        goatItemService.addItem(goatItem, fieldValueList);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 更新广告位
     * @param goatItemId
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeItemView" , method = RequestMethod.GET)
    public String changeItemView(Long goatItemId, HttpServletRequest request){
        GoatItemBo goatItemBo = new GoatItemBo();
        goatItemBo.setItemId(goatItemId);
        GoatItemVo goatItemVo = goatItemService.findGoatItemByBo(goatItemBo);

        GoatFieldBo goatFieldBo = new GoatFieldBo();
        goatFieldBo.setLocationId(goatItemVo.getLocalId());
        List<GoatFieldVo> goatFieldList = goatFieldService.findGoatFieldList(goatFieldBo);
        for(int i = 0;i<goatFieldList.size();i++){
            GoatFieldValueBo goatFieldValueBo = new GoatFieldValueBo();
            goatFieldValueBo.setfId(goatFieldList.get(i).getFid());
            goatFieldValueBo.setGoatId(goatItemId);
            GoatFieldValueVo goatFieldValue = goatFieldValueService.findGoatFieldValueByBo(goatFieldValueBo);
            if(goatFieldValue != null){
                goatFieldList.get(i).setValues(goatFieldValue.getValue());
                goatFieldList.get(i).setvId(goatFieldValue.getVid());
            }
        }

        request.setAttribute("locationId", goatItemVo.getLocalId());
        request.setAttribute("fieldList", goatFieldList);

        request.setAttribute("goatItem", goatItemVo);
        return "sysman/spread/item/change_item";
    }

    /**
     * 更新广告位
     * @param goatItem
     * @return
     */
    @RequestMapping(value = "/sysman/goat/changeItem" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeItem(GoatItem goatItem, String startTimeStr,String endTimeStr,HttpServletRequest request){
        ResponseBase rsp = new ResponseBase();

        if(goatItem == null){
            rsp.setMsg("广告位不能为空");
            return JSONObject.fromObject(rsp);
        }
        if(goatItem.getGoatId() == null){
            rsp.setMsg("请输入广告位ID");
            return JSONObject.fromObject(rsp);
        }

        Date startTime = DateUtil.stringToDate(startTimeStr,DateUtil.patternD);
        Date endTime = DateUtil.stringToDate(endTimeStr,DateUtil.patternD);
        goatItem.setStartTime(startTime);
        goatItem.setEndTime(endTime);
        GoatFieldBo goatFieldBo = new GoatFieldBo();
        goatFieldBo.setLocationId(goatItem.getLocalId());
        List<GoatFieldVo> goatFieldList = goatFieldService.findGoatFieldList(goatFieldBo);

        if(goatFieldList.size() == 0){
            rsp.setMsg("广告列为空无法新增广告");
            return JSONObject.fromObject(rsp);
        }

        List<GoatFieldValue> fieldValueList = new ArrayList<GoatFieldValue>();
        for(int i = 0;i<goatFieldList.size();i++){
            GoatFieldVo goatFieldVo = goatFieldList.get(i);
            String values = request.getParameter(goatFieldVo.getFieldName());
            String vid = request.getParameter(goatFieldVo.getFieldName() + "_vid");
            if(goatFieldVo.getMustHave()&&StringUtils.isEmpty(values)){
                rsp.setMsg(goatFieldVo.getTitle() + " 不能为空");
                return JSONObject.fromObject(rsp);
            }
            if(goatFieldVo.getMaxLength()!=null){
                if(values.length() > goatFieldVo.getMaxLength().intValue()){
                    rsp.setMsg(goatFieldVo.getTitle() + " 最大长度" + goatFieldVo.getMaxLength().intValue());
                    return JSONObject.fromObject(rsp);
                }
            }
            GoatFieldValue goatFieldValue = new GoatFieldValue();
            goatFieldValue.setFid(goatFieldVo.getFid());
            goatFieldValue.setValue(values);
            goatFieldValue.setVid(Long.valueOf(vid));
            fieldValueList.add(goatFieldValue);
        }


        goatItemService.updateItem(goatItem, fieldValueList);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(rsp);
    }

    /**
     * 删除广告
     * @param goatId
     * @return
     */
    @RequestMapping(value = "sysman/goat/delItem" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delItem(Long goatId){
        ResponseBase rsp = new ResponseBase();

        if(goatId == null){
            rsp.setMsg("请选择一个广告");
            return JSONObject.fromObject(rsp);
        }

        goatItemService.delItem(goatId);
        rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(rsp);
    }
}
