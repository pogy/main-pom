package com.shigu.order.vo;

import java.util.List;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ExpressVo {
    private String name;
    private String id;
    private Long createTime;
    private List<ExpressDetailVo> detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ExpressDetailVo> getDetail() {
        return detail;
    }

    public void setDetail(List<ExpressDetailVo> detail) {
        this.detail = detail;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
