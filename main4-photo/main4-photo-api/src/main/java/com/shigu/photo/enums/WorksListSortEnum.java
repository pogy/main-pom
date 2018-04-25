package com.shigu.photo.enums;

public enum WorksListSortEnum {
    create_asc("create_time asc"),create_desc("create_time desc"),defaults(null);
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
