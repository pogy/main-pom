package com.shigu.main4.test.active;

import java.util.List;

/**
 * Created by bugzy on 2017/6/6 0006.
 */
public class PemUpData {

    public PemUpData(Long pemId, Integer term) {
        this.pemId = pemId;
        this.term = term;
    }

    private Long pemId;
    private Integer term;
    private String name;
    private List<UserUpData> datas;

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public String getName() {
        if (name == null) {
            setName();
        }
        return name;
    }

    public void setName() {
        this.name = String.format("第%d期参与用户统计", term);
    }

    public List<UserUpData> getDatas() {
        return datas;
    }

    public void setDatas(List<UserUpData> datas) {
        this.datas = datas;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
