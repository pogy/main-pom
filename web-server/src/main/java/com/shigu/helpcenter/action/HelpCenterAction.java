package com.shigu.helpcenter.action;


import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;
import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;
import com.shigu.helpcenter.service.LevelOneService;
import com.shigu.helpcenter.service.LevelTwoService;
import com.shigu.helpcenter.service.QuestionService;
import com.shigu.helpcenter.vo.*;
import com.shigu.tools.JsonResponseUtil;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
* 帮助中心 helpCenter
* 创建时间 18.1.16
* 创建者 张喜惠
* v1.2 ： 添加一些注释，精简部分代码 18.1.17
* */
@Controller
@RequestMapping("helpCenter/")
public class HelpCenterAction {
    @Autowired
    private LevelOneService levelOneService;
    @Autowired
    private LevelTwoService levelTwoService;
    @Autowired
    private QuestionService questionService;
    /*
    * 帮助中心首页
    * 请求地址：helpCenter/queIndex.htm
    * 参数：
    *   gid      一级目录ID
    *   id       问题ID
    *   keyword  搜索关键字
    *   page     页码
    * */
    @RequestMapping("queIndex")
    @ResponseBody
    public JSONObject getLecelOneAll(Integer gid, Integer id, String keyword, Integer page) {
        //初始化page
        if (page == null) {
            page = 1;
        }
        if (id == null && StringUtils.isBlank(keyword)) {
            List<QueIndexVo> queIndexVos = getAll();
            return JsonResponseUtil.success().element("helpCenter", queIndexVos);
        }
        if (id != null && StringUtils.isBlank(keyword)) {
            List<QueIndexVo> queIndexVos = getAll();
            QueIndexVo queIndexVo = new QueIndexVo();
            //获取二级目录下对应ID的问题
            queIndexVo.setQuestionList(getTitleByCid(gid, id, page));
            queIndexVos.add(queIndexVo);
            return JsonResponseUtil.success().element("helpCenter", queIndexVos);
        }
        //搜索
        if (StringUtils.isNotBlank(keyword)) {
           /* List<ShiguHelpcenterQuestion> search = questionService.search(keyword);
            ShiguHelpcenterQuestionSearchVo shiguHelpcenterQuestionSearchVo = new ShiguHelpcenterQuestionSearchVo();
            shiguHelpcenterQuestionSearchVo.setShiguHelpcenterQuestions(search);
            shiguHelpcenterQuestionSearchVo.setKeyword(keyword);*/
            return showQuestion(page, keyword);
        }
        return null;
    }
    /*
     * 帮助中心详情
     * 请求地址：helpCenter/queDetail.htm
     * 参数：
     *   id  问题ID
     * */
    @RequestMapping("queDetail")
    @ResponseBody
    public JSONObject getAnswerById(Integer id) {
        List<QueDetailVo> queDetailVos = getAllQ();
        if (queDetailVos != null) {
            ShiguHelpcenterQuestion questionServiceByPk = questionService.getByPk(id);
            String answer = questionServiceByPk.getAnswer();
            String gname = levelOneService.getByPk(questionServiceByPk.getGid()).getName();
            String cname = levelTwoService.getByPk(questionServiceByPk.getCid()).getName();
            //拼装路径信息
            String queCateNamePath = gname + " > " + cname;
            QueDetailVo queDetailVo = new QueDetailVo();
            queDetailVo.setAnswer(answer);
            queDetailVo.setQueCateNamePath(queCateNamePath);
            queDetailVos.add(queDetailVo);
            return JsonResponseUtil.success().element("helpCenter", queDetailVos);
        }
        return null;
    }

    /*
     * 后台首页
     * 请求地址：helpCenter/showQuestion.htm
     * 参数：
     *   page     页码
     *   keyword  搜索关键字
     * */
    @RequestMapping("showQuestion")
    @ResponseBody
    public JSONObject showQuestion(Integer page, String keyword) {
        //初始化page
        if (page == null) {
            page = 1;
        }
        Integer pageSize = 2;
        List<ShiguHelpcenterQuestion> questionList = null;
        if (StringUtils.isNotBlank(keyword)) {
            questionList = questionService.search(keyword);
        } else {
            questionList = questionService.getAll();
        }
        List<ShiguHelpcenterQuestion> collect = questionList.stream()
                .limit(page * pageSize)
                .skip((page - 1) * pageSize).collect(Collectors.toList());
        Integer pageTol = questionList.size();
        Integer pageNo = page;
        //分页配置参数，分别是商品总数，每页显示条数，当前页码，使用逗号隔开，比如：'28,10,1'
        String pageOption = String.valueOf(pageTol) + "," + String.valueOf(pageSize) + "," + String.valueOf(pageNo);
        if (questionList != null) {
            ShowQuestionVo showQuestionVo = new ShowQuestionVo();
            showQuestionVo.setQueList(collect);
            showQuestionVo.setPageOption(pageOption);
            return JsonResponseUtil.success().element("helpCenter", showQuestionVo);
        }
        return null;
    }

    /**
     * 请求地址：helpCenter/saveQuedata.htm
     * 参数
     * mainCateName	手动添加的主类目
     * categoryName	手动添加的子类目
     * pid	        已存在的主类目id
     * cid	        已存在的子类目id
     * queTitle   	问题标题
     * queAnswer  	问题答案
     */
    @RequestMapping("saveQuedata")
    @ResponseBody
    public JSONObject saveQuestion(Integer pid, Integer cid, String mainCateName, String categoryName, String queTitle, String queAnswer) {
        //当没有PID,CID认为添加新的问题
        if (pid == null && cid == null) {
            ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = new ShiguHelpcenterLevel1();
            ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = new ShiguHelpcenterLevel2();
            ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
            shiguHelpcenterLevel1.setName(mainCateName);
            String save1 = levelOneService.save(shiguHelpcenterLevel1);
            if (save1.equals("success")) {
                shiguHelpcenterLevel2.setName(categoryName);
                //获取GID后存入对象
                shiguHelpcenterLevel2.setGid(levelOneService.getPkByName(mainCateName));
                String save2 = levelTwoService.save(shiguHelpcenterLevel2);
                if (save2.equals("success")) {
                    shiguHelpcenterQuestion.setTitle(queTitle);
                    shiguHelpcenterQuestion.setAnswer(queAnswer);
                    //获取GID后存入对象
                    shiguHelpcenterQuestion.setGid(levelOneService.getPkByName(mainCateName));
                    //获取CID后存入对象
                    shiguHelpcenterQuestion.setCid(levelTwoService.getPkByName(categoryName));
                    String save3 = questionService.save(shiguHelpcenterQuestion);
                    if (save3.equals("success")) {
                        return JsonResponseUtil.success();
                    }
                }
            }
        }
        //当有PID CID 时获取问题标题更改改标题下的答案内容
        if (pid != null && cid != null && StringUtils.isBlank(mainCateName) && StringUtils.isBlank(categoryName)) {
            ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
            //shiguHelpcenterQuestion.setTitle(queTitle);
            shiguHelpcenterQuestion.setAnswer(queAnswer);
            shiguHelpcenterQuestion.setId(questionService.getPkByTitle(queTitle));
            String updata = questionService.updata(shiguHelpcenterQuestion);
            if (updata.equals("success")) {
                return JsonResponseUtil.success().element("redictUrl", "/helpCenter/addOrModify.htm");
            }
        }
        return JsonResponseUtil.error("error");
    }
    /* 删除操作
     * 请求地址：helpCenter/deleteQue.htm
     * 参数
     *      id  问题ID
     */
    @RequestMapping("deleteQue")
    @ResponseBody
    public JSONObject deleteQue(Integer id) {
        ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
        shiguHelpcenterQuestion.setId(id);
        String del = questionService.del(shiguHelpcenterQuestion);
        if (del.equals("success")) {
            return JsonResponseUtil.success();
        }
        return JsonResponseUtil.error("error");
    }
    /* 修改页问题详情展示
     * 请求地址：helpCenter/deleteQue.htm
     * 参数
     *      id  问题ID
     */
    @RequestMapping("addOrModify")
    @ResponseBody
    public JSONObject addOrModify(Integer id) {
        ShiguHelpcenterQuestion questionServiceByPk = questionService.getByPk(id);
        AllUpdataVo allUpdataVo = new AllUpdataVo();
        if (questionServiceByPk != null) {
            allUpdataVo.setId(id);
            allUpdataVo.setCid(questionServiceByPk.getCid());
            allUpdataVo.setPid(questionServiceByPk.getGid());
            allUpdataVo.setMainCate(levelOneService.getByPk(questionServiceByPk.getGid()));
            allUpdataVo.setQueTitle(questionServiceByPk.getTitle());
            allUpdataVo.setQueAnswer(questionServiceByPk.getAnswer());
        }
        return JsonResponseUtil.success().element("helpCenter", allUpdataVo);
    }

    /*
     * 以下为自建的方法，提供给control使用
     *
     * */
    public List<QueIndexVo> getAll() {
        List<ShiguHelpcenterLevel1> level1List = levelOneService.getAll();
        List<QueIndexVo> queIndexVoList = new ArrayList<QueIndexVo>();
        if (level1List != null) {
            for (ShiguHelpcenterLevel1 s : level1List) {
                QueIndexVo queIndexVo = new QueIndexVo();
                queIndexVo.setSidebarList(s);
                queIndexVo.setSubSidebarList(levelTwoService.getLevelTowByGid(s.getPid()));
                queIndexVoList.add(queIndexVo);
            }
            return queIndexVoList;
        }
        return null;
    }


    public List<QueDetailVo> getAllQ() {
        List<ShiguHelpcenterLevel1> level1List = levelOneService.getAll();
        List<QueDetailVo> queDetailVoList = new ArrayList<QueDetailVo>();
        if (level1List != null) {
            for (ShiguHelpcenterLevel1 s : level1List) {
                QueDetailVo queDetailVo = new QueDetailVo();
                queDetailVo.setSidebarList(s);
                queDetailVo.setSubSidebarList(levelTwoService.getLevelTowByGid(s.getPid()));
                queDetailVoList.add(queDetailVo);
            }
            return queDetailVoList;
        }
        return null;
    }


    public JSONObject getLevelTowByGid(int gid) {
        List<ShiguHelpcenterLevel2> levelTowByGid = levelTwoService.getLevelTowByGid(gid);
        if (levelTowByGid != null) {
            return JsonResponseUtil.success().element("levelTowByGid", levelTowByGid);
        }
        return null;
    }


    public ShiguHelpcenterQuestionVo getTitleByCid(int gid, int cid, Integer page) {
        List<ShiguHelpcenterQuestion> titleByCid = questionService.getTitleByGidAndCid(gid, cid);
        ShiguHelpcenterQuestionVo shiguHelpcenterQuestionVo = new ShiguHelpcenterQuestionVo();
        //数据总数
        Integer pageTol = titleByCid.size();
        //每页显示数量
        Integer pageSize = 2;
        //当前页码
        Integer pageNo = page;
        //分页配置参数，分别是商品总数，每页显示条数，当前页码，使用逗号隔开，比如：'28,10,1'
        String pageOption = String.valueOf(pageTol) + "," + String.valueOf(pageSize) + "," + String.valueOf(pageNo);

        List<ShiguHelpcenterQuestion> questionList = titleByCid.stream()
                .limit(page * pageSize)
                .skip((page - 1) * pageSize).collect(Collectors.toList());
        String gname = levelOneService.getByPk(questionList.get(1).getGid()).getName();
        String cname = levelTwoService.getByPk(questionList.get(1).getCid()).getName();
        if (titleByCid != null) {
            shiguHelpcenterQuestionVo.setTitle(questionList);
            shiguHelpcenterQuestionVo.setQueCateNamePath(gname + " > " + cname);
            shiguHelpcenterQuestionVo.setPageOption(pageOption);
            return shiguHelpcenterQuestionVo;
        }
        return null;
    }

}
