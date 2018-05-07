package com.shigu.main4.photo.enums;

public enum WorksListSortEnum {
    create_asc("t1.create_time asc"),create_desc("t1.create_time desc"),defaults(null);
    String sql;
    WorksListSortEnum(String sql){
        this.sql=sql;
    }

    public String getSql() {
        return this.sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
