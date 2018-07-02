package com.shigu.goodsup.pinduoduo.bo;

/**
 * Created by gtx on 2018/6/21.
 * 生成自定义类目
 * @author gtx
 * @since
 */
public class AddPropBO {
    /**
     * 生成类型
     */
    private Integer type;
    /**
     * 属性名
     */
    private String propName;
    /**
     * 拼多多类目id
     */
    private Long pddCid;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Long getPddCid() {
        return pddCid;
    }

    public void setPddCid(Long pddCid) {
        this.pddCid = pddCid;
    }
}
