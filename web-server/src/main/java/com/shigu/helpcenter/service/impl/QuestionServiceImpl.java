package com.shigu.helpcenter.service.impl;

import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;
import com.opentae.data.mall.examples.ShiguHelpcenterQuestionExample;
import com.opentae.data.mall.interfaces.ShiguHelpcenterQuestionMapper;
import com.shigu.helpcenter.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private ShiguHelpcenterQuestionMapper shiguHelpcenterQuestionMapper;

    @Override
    public List<ShiguHelpcenterQuestion> getAll() {
        ShiguHelpcenterQuestionExample example = new ShiguHelpcenterQuestionExample();
        example.createCriteria();
        List<ShiguHelpcenterQuestion> shiguHelpcenterQuestions = shiguHelpcenterQuestionMapper.selectByExample(example);
        if (shiguHelpcenterQuestions != null){
            return  shiguHelpcenterQuestions;
        }
        return null;
    }

    @Override
    public List<ShiguHelpcenterQuestion> getTitleByCid(int cid) {
        ShiguHelpcenterQuestionExample example = new ShiguHelpcenterQuestionExample();
        example.createCriteria().andCidEqualTo(cid);
        List<ShiguHelpcenterQuestion> shiguHelpcenterQuestions = shiguHelpcenterQuestionMapper.selectByExample(example);
        if (shiguHelpcenterQuestions != null){
            return shiguHelpcenterQuestions;
        }
        return null;
    }

    @Override
    public List<ShiguHelpcenterQuestion> getTitleByGidAndCid(int gid, int cid) {
        ShiguHelpcenterQuestionExample example = new ShiguHelpcenterQuestionExample();
        example.createCriteria().andCidEqualTo(cid).andGidEqualTo(gid);
        List<ShiguHelpcenterQuestion> shiguHelpcenterQuestions = shiguHelpcenterQuestionMapper.selectByExample(example);
        if (shiguHelpcenterQuestions != null){
            return shiguHelpcenterQuestions;
        }
        return null;
    }

    @Override
    public String getAnswerById(int id) {
        ShiguHelpcenterQuestion shiguHelpcenterQuestion = shiguHelpcenterQuestionMapper.selectByPrimaryKey(id);
        if (StringUtils.isNotBlank(shiguHelpcenterQuestion.getAnswer())){
            return shiguHelpcenterQuestion.getAnswer();
        }
        return null;
    }

    @Override
    public Integer getPkByTitle(String name) {
        ShiguHelpcenterQuestion shiguHelpcenterQuestion = new ShiguHelpcenterQuestion();
        shiguHelpcenterQuestion.setTitle(name);
        ShiguHelpcenterQuestion selectOne = shiguHelpcenterQuestionMapper.selectOne(shiguHelpcenterQuestion);
        if (selectOne != null){
            return selectOne.getCid();
        }
        return null;
    }

    @Override
    public ShiguHelpcenterQuestion getByPk(int id) {
        ShiguHelpcenterQuestion shiguHelpcenterQuestion = shiguHelpcenterQuestionMapper.selectByPrimaryKey(id);
        if (StringUtils.isNotBlank(shiguHelpcenterQuestion.getAnswer())){
            return shiguHelpcenterQuestion;
        }
        return null;
    }

    @Override
    public List<ShiguHelpcenterQuestion> search(String keyword) {
        //去掉string当中含有的所有空格
        String str = keyword.replaceAll(" ", "");
        List<ShiguHelpcenterQuestion> search = shiguHelpcenterQuestionMapper.search(str);
        if (search != null){
            return search;
        }
        return null;
    }
    @Transactional
    @Override
    public String save(ShiguHelpcenterQuestion shiguHelpcenterQuestion) {
        String msg ="error";
        try {
            shiguHelpcenterQuestionMapper.save(shiguHelpcenterQuestion);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    @Transactional
    @Override
    public String del(ShiguHelpcenterQuestion shiguHelpcenterQuestion) {
        String msg ="error";
        try {
            shiguHelpcenterQuestionMapper.del(shiguHelpcenterQuestion);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;


    }
    @Transactional
    @Override
    public String updata(ShiguHelpcenterQuestion shiguHelpcenterQuestion) {
        String msg ="error";
        try {
            shiguHelpcenterQuestionMapper.updata(shiguHelpcenterQuestion);
            msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
