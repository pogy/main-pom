package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-19/17:12
 */
public class CatVO implements Serializable{
    /**类目id*/
    private String id;
    /**类目名称*/
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
