package com.shigu.helpcenter.action;


import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;
import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;
import com.shigu.helpcenter.service.LevelOneService;
import com.shigu.helpcenter.service.LevelTwoService;
import com.shigu.helpcenter.service.QuestionService;
import com.shigu.helpcenter.vo.*;
import com.shigu.tools.JsonResponseUtil;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Value("${help.center.psw}")
    private String helpCenterPsw;
    @Value("${help.center.session}")
    private String helpCenterSession;
    @Value("${help.center.index}")
    private String helpCenterIndex;

    @RequestMapping("login")
    public String helpLogin(String psw,HttpSession session,Model model){
        if(session.getAttribute(helpCenterSession)!=null){
            return "redirect:"+helpCenterIndex;
        }
        if(!StringUtils.isBlank(psw)){
            if(helpCenterPsw.endsWith(psw)){
                session.setAttribute(helpCenterSession,1);
                return "redirect:"+helpCenterIndex;
            }else{
                model.addAttribute("err","密码错误");
            }
        }
        return "helpCenter/helpLogin";
    }


    /*
     * 帮助中心首页
     * 请求地址：helpCenter/queIndex.htm
     * 参数：
     *
     *   id       问题ID
     *   keyword  搜索关键字
     *   page     页码
     * */
    @RequestMapping("queIndex")
    public String getLecelOneAll(Integer page,Integer id, String keyword, Model model) {
        if (id == null) {
            id = 1;
        }
        //初始化page
        if (page == null) {
            page = 1;
        }
        List<ShiguHelpcenterLevel1> level1List = levelOneService.getAll();
        List<IndexVo> sidebarList = new ArrayList<IndexVo>();
        for (ShiguHelpcenterLevel1 s : level1List) {
            IndexVo indexVo = new IndexVo();
            indexVo.setPid(s.getPid());
            indexVo.setName(s.getName());
            List<ShiguHelpcenterLevel2> level2s = levelTwoService.getLevelTowByGid(s.getPid());
            indexVo.setSubSidebarList(level2s);
            sidebarList.add(indexVo);
        }
        List<IndexVo> vos = sidebarList.stream().sorted((p1, p2) -> (p1.getPid() - p2.getPid())).collect(Collectors.toList());
        Integer pageSize = 10;
        List<ShiguHelpcenterQuestion> title = null;
        if (StringUtils.isNotBlank(keyword)) {
            title = questionService.search(keyword);
        } else {
            title = questionService.getTitleByCid(id);
        }
        List<ShiguHelpcenterQuestion> collect = title.stream()
                .limit(page * pageSize)
                .skip((page - 1) * pageSize).collect(Collectors.toList());
        Integer pageNo = page;
        //分页配置参数，分别是商品总数，每页显示条数，当前页码，使用逗号隔开，比如：'28,10,1'
        String pageOption = String.valueOf(title.size()) + "," + String.valueOf(pageSize) + "," + String.valueOf(pageNo);
        String gname = levelOneService.getByPk(levelTwoService.getByPk(id).getGid()).getName();
        String cname = levelTwoService.getByPk(id).getName();

        String queCateNamePath = null;
        if (keyword == null){
            queCateNamePath = gname + " > " + cname;
        }else {
            queCateNamePath = "搜索结果";
        }
        Query query = new Query();
        query.setKeyword(keyword);

        model.addAttribute("query", query);
        model.addAttribute("sidebarList", vos);
        model.addAttribute("pageOption", pageOption);
        model.addAttribute("queList", collect);
        model.addAttribute("cid",id);
        model.addAttribute("pid",levelTwoService.getByPk(id).getGid());
        model.addAttribute("queCateNamePath", queCateNamePath);

        return "helpCenter/queIndex";
    }

    /*
     * 帮助中心详情
     * 请求地址：helpCenter/queDetail.htm
     * 参数：
     *   id  问题ID
     * */
    @RequestMapping("queDetail")

    public String getAnswerById(Integer id, String keyword,Model model) {
        List<ShiguHelpcenterLevel1> level1List = levelOneService.getAll();
        List<IndexVo> indexVos = new ArrayList<IndexVo>();
        for (ShiguHelpcenterLevel1 s : level1List) {
            IndexVo indexVo = new IndexVo();
            indexVo.setPid(s.getPid());
            indexVo.setName(s.getName());
            List<ShiguHelpcenterLevel2> level2s = levelTwoService.getLevelTowByGid(s.getPid());
            indexVo.setSubSidebarList(level2s);
            indexVos.add(indexVo);
        }
        List<IndexVo> sidebarList = indexVos.stream().sorted((p1, p2) -> (p1.getPid() - p2.getPid())).collect(Collectors.toList());

        ShiguHelpcenterQuestion question = questionService.getByPk(id);

        String gname = levelOneService.getByPk(question.getGid()).getName();
        String cname = levelTwoService.getByPk(question.getCid()).getName();
        String title = question.getTitle();
        String queCateNamePath = gname + " > " + cname + " > " + title;
        Query query = new Query();
        query.setKeyword(keyword);
        model.addAttribute("sidebarList",sidebarList);
        model.addAttribute("pid",question.getGid());
        model.addAttribute("cid",question.getCid());
        model.addAttribute("queTitle",question.getTitle());
        model.addAttribute("queDetail",question.getAnswer());
        model.addAttribute("queCateNamePath",queCateNamePath);
        model.addAttribute("query",query);


        return "helpCenter/queDetail";


    }

    /*
     * 后台首页
     * 请求地址：helpCenter/showQuestion.htm
     * 参数：
     *   page     页码
     *   keyword  搜索关键字
     * */
    @RequestMapping("showQuestion")
    public String showQuestion(Integer page, String keyword, Model model) {
        //初始化page
        if (page == null) {
            page = 1;
        }
        Integer pageSize = 10;
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
            Query query = new Query();
            query.setKeyword(keyword);
            model.addAttribute("query", query);
            model.addAttribute("queList", collect);
            model.addAttribute("pageOption", pageOption);
            return "helpCenter/showQuestion";
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
    public JSONObject saveQuestion(Integer pid, Integer cid,Integer queId, String mainCateName, String categoryName, String queTitle, String queAnswer) {
        //当没有PID,CID认为添加全新的一级二级和问题  OK
        if (pid == null && cid == null && queId == null) {
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
                        return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
                    }
                }
            }
        }

        //增加问题 OK
        if (pid != null && cid != null && queId == null && StringUtils.isBlank(mainCateName) && StringUtils.isBlank(categoryName) && StringUtils.isNotBlank(queTitle) && StringUtils.isNotBlank(queAnswer)){
            ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
            shiguHelpcenterQuestion.setGid(pid);
            shiguHelpcenterQuestion.setCid(cid);
            shiguHelpcenterQuestion.setTitle(queTitle);
            shiguHelpcenterQuestion.setAnswer(queAnswer);
            String save = questionService.save(shiguHelpcenterQuestion);
            if (save.equals("success")){
                return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
            }
        }

        //当有PID CID 时获取问题标题,更改该标题下的答案内容和问题标题  OK
        if (pid != null && cid != null && cid != null && StringUtils.isNotBlank(queTitle) && StringUtils.isBlank(mainCateName) && StringUtils.isBlank(categoryName)) {
            ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
            shiguHelpcenterQuestion.setId(queId);
            shiguHelpcenterQuestion.setTitle(queTitle);
            shiguHelpcenterQuestion.setAnswer(queAnswer);

           // System.out.println(shiguHelpcenterQuestion);

            String updata = questionService.updata(shiguHelpcenterQuestion);
            if (updata.equals("success")) {
                return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
            }
        }




        /*//更改主目录
        if (pid != null & cid == null && StringUtils.isNotBlank(mainCateName) && StringUtils.isBlank(categoryName)){
            ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = new ShiguHelpcenterLevel1();
            shiguHelpcenterLevel1.setPid(pid);
            shiguHelpcenterLevel1.setName(mainCateName);
            String updata = levelOneService.updata(shiguHelpcenterLevel1);
            if (updata.equals("success")){
                return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
            }
            return JsonResponseUtil.error("error updata level_1");

        }*/
       /* //更改子目录
        if (pid != null && StringUtils.isBlank(mainCateName) && StringUtils.isNotBlank(categoryName) && queTitle.equals("修改")){
            ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = new ShiguHelpcenterLevel2();
            shiguHelpcenterLevel2.setCid(cid);
            shiguHelpcenterLevel2.setName(categoryName);
            String updata = levelTwoService.updata(shiguHelpcenterLevel2);
            if (updata.equals("success")){
                return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
            }
            return JsonResponseUtil.error("error updata level_2");
        }*/
        /*//增加主类目
        if (pid == null && StringUtils.isNotBlank(mainCateName) && cid == null && StringUtils.isBlank(categoryName)){
            ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = new ShiguHelpcenterLevel1();
            shiguHelpcenterLevel1.setName(mainCateName);
            String save = levelOneService.save(shiguHelpcenterLevel1);
            if (save.equals("success")){
                return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
            }
            return JsonResponseUtil.error("error");
        }*/

       //增加子类目 ok
         if (pid != null && cid == null && StringUtils.isBlank(mainCateName) && StringUtils.isNotBlank(categoryName) && StringUtils.isNotBlank(queTitle)) {
            ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = new ShiguHelpcenterLevel2();
            ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
            shiguHelpcenterLevel2.setGid(pid);
            shiguHelpcenterLevel2.setName(categoryName);
            List<ShiguHelpcenterQuestion> questions = questionService.getAll();
            boolean flag = true;
            for (ShiguHelpcenterQuestion s : questions){
                if (s.getTitle().equals(queTitle)){
                    flag = false;
                }
            }
            if (flag){
                String save1 = levelTwoService.save(shiguHelpcenterLevel2);
                if (save1.equals("success")) {
                    shiguHelpcenterQuestion.setGid(pid);
                    shiguHelpcenterQuestion.setCid(levelTwoService.getPkByName(categoryName));
                    shiguHelpcenterQuestion.setTitle(queTitle);
                    shiguHelpcenterQuestion.setAnswer(queAnswer);
                    String save2 = questionService.save(shiguHelpcenterQuestion);
                    if (save2.equals("success")) {
                        return JsonResponseUtil.success().element("redictUrl","/helpCenter/queIndex.htm");
                    }
                }
            }
            return JsonResponseUtil.error("error");
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
        ShiguHelpcenterQuestion question = questionService.getByPk(id);
        ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
        shiguHelpcenterQuestion.setId(id);
        String del = questionService.del(shiguHelpcenterQuestion);
        if (del.equals("success")){
            List<ShiguHelpcenterQuestion> titleByGidAndCid = questionService.getTitleByGidAndCid(question.getGid(), question.getCid());
            if (titleByGidAndCid.size()<1){
                ShiguHelpcenterLevel2 shiguHelpcenterLevel2 = new ShiguHelpcenterLevel2();
                shiguHelpcenterLevel2.setCid(question.getCid());
                String del1 = levelTwoService.del(shiguHelpcenterLevel2);
                if (del1.equals("success")){
                    List<ShiguHelpcenterLevel2> levelTowByGid = levelTwoService.getLevelTowByGid(question.getGid());

                    if (levelTowByGid.size()<1){
                        ShiguHelpcenterLevel1 shiguHelpcenterLevel1 = new ShiguHelpcenterLevel1();
                        shiguHelpcenterLevel1.setPid(question.getGid());
                        String del2 = levelOneService.del(shiguHelpcenterLevel1);
                        if (del2.equals("success")){
                            return JsonResponseUtil.success();
                        }
                    }
                }
            }
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
    public String addOrModify(Integer id, Model model) {
        if (id == null){
            List<ShiguHelpcenterLevel1> all = levelOneService.getAll();
            List<PidChangeIdVo> pidChangeIdVoList = new ArrayList<PidChangeIdVo>();
            for (ShiguHelpcenterLevel1 s : all){
                PidChangeIdVo pidChangeIdVo = new PidChangeIdVo();
                pidChangeIdVo.setId(s.getPid());
                pidChangeIdVo.setName(s.getName());
                pidChangeIdVoList.add(pidChangeIdVo);
            }

            model.addAttribute("mainCate", pidChangeIdVoList);
            model.addAttribute("query", null);

            return "helpCenter/addOrModify";
        }
        ShiguHelpcenterQuestion questionServiceByPk = questionService.getByPk(id);
        List<ShiguHelpcenterLevel1> all = levelOneService.getAll();

        Query query = new Query();
        if (questionServiceByPk != null) {
            List<PidChangeIdVo> pidChangeIdVoList = new ArrayList<PidChangeIdVo>();
            for (ShiguHelpcenterLevel1 s : all){
                PidChangeIdVo pidChangeIdVo = new PidChangeIdVo();
                pidChangeIdVo.setId(s.getPid());
                pidChangeIdVo.setName(s.getName());
                pidChangeIdVoList.add(pidChangeIdVo);
            }
            query.setId(id);
            model.addAttribute("mainCate", pidChangeIdVoList.stream().sorted((p1,p2)->(p1.getId()-p2.getId())).collect(Collectors.toList()));
            model.addAttribute("queTitle", questionServiceByPk.getTitle());
            model.addAttribute("queAnswer", questionServiceByPk.getAnswer());
            model.addAttribute("pid", questionServiceByPk.getGid());
            model.addAttribute("cid", questionServiceByPk.getCid());
            model.addAttribute("query", query);
        }
        return "helpCenter/addOrModify";
    }

    @RequestMapping("getCategories")
    @ResponseBody
    public JSONObject getCategories(Integer pid) {
        List<ShiguHelpcenterLevel2> level2s = levelTwoService.getLevelTowByGid(pid);
        ArrayList<CidChangeIdVo> cidChangeIdVos = new ArrayList<CidChangeIdVo>();
        for (ShiguHelpcenterLevel2 s : level2s){
            CidChangeIdVo cidChangeIdVo = new CidChangeIdVo();
            cidChangeIdVo.setId(s.getCid());
            cidChangeIdVo.setName(s.getName());
            cidChangeIdVo.setPid(s.getGid());
            cidChangeIdVos.add(cidChangeIdVo);
        }
        return JsonResponseUtil.success().element("categories",cidChangeIdVos);
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
        Integer pageSize = 10;
        //当前页码
        Integer pageNo = page;

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
