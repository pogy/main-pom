package com.shigu.main4.spread.vo;

import com.shigu.main4.spread.enums.GoatTypeEnum;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import com.shigu.main4.spread.exceptions.GoatException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 一个位置的广告位
 * Created by Licca on 17/4/9.
 */
public class GoatALocation {
    /**
     * 广告位置 ID
     */
    private Long localId;
    /**
     * 广告位置编号
     */
    private String localCode;
    /**
     * 广告类别
     */
    private GoatTypeEnum type;
    /**
     * 变量集合
     */
    private List<GoatFieldVO> fields;
    /**
     * 模板
     */
    private String model;
    /**
     * 广告
     */
    private List<GoatAItem> items;


    public List<GoatFieldVO> getFields() {
        return fields;
    }

    public void setFields(List<GoatFieldVO> fields) {
        this.fields = fields;
    }

    public List<GoatAItem> getItems() {
        return items;
    }

    public void setItems(List<GoatAItem> items) {
        this.items = items;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GoatTypeEnum getType() {
        return type;
    }

    public void setType(Integer t) {
        for(GoatTypeEnum gt:GoatTypeEnum.values()){
            if (gt.getValue().equals(t)){
                type=gt;
                break;
            }
        }
    }

    /**
     * 按变量名,取属性
     * @param fieldName
     * @return
     */
    public GoatFieldVO getFieldByName(String fieldName){
        if(fields==null||fields.size()==0){
            return null;
        }
        for(GoatFieldVO gfv:fields){
            if(fieldName.equals(gfv.getFieldName())){
                return gfv;
            }
        }
        return null;
    }

    /**
     * 创建一个实例
     * @return
     */
    public GoatAItem getItemInstense(){
        return new GoatAItem();
    }
    /**
     * 单个广告类
     */
    public class GoatAItem extends HashMap<GoatFieldVO,String>{
        /**
         * 广告ID
         */
        private Long goatId;
        /**
         * 开始时间
         */
        private Date startTime;
        /**
         * 结束时间
         */
        private Date endTime;

        /**
         * 按fieldName拿值
         * @param fieldName
         * @return
         */
        public String selValueByFieldName(String fieldName){
            GoatFieldVO fieldVO=getFieldByName(fieldName);
            if(fieldVO!=null){
                return this.get(fieldVO);
            }
            return null;
        }

        /**
         * 输出html
         * @return
         */
        public String parseToHTML() throws GoatException, IOException, TemplateException {
            if(model==null||"".equals(model)){
                throw new GoatException("模板不存在");
            }
            Configuration cfg = new Configuration();
            cfg.setTemplateLoader(new StringTemplateLoader(model));
            cfg.setDefaultEncoding("UTF-8");
            Template template = cfg.getTemplate("");
            StringWriter writer = new StringWriter();
            Map<String,String> param=new HashMap<>();
            Iterator<GoatFieldVO> it=this.keySet().iterator();
            while(it.hasNext()){
                GoatFieldVO vo=it.next();
                param.put(vo.getFieldName(),this.get(vo));
            }
            template.process(param, writer);
            String strdata = writer.toString();
            writer.close();
            return strdata;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public Long getGoatId() {
            return goatId;
        }

        public void setGoatId(Long goatId) {
            this.goatId = goatId;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            GoatAItem goatAItem = (GoatAItem) o;

            return !(goatId != null ? !goatId.equals(goatAItem.goatId) : goatAItem.goatId != null);

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (goatId != null ? goatId.hashCode() : 0);
            return result;
        }
    }
}
