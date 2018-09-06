package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class UserAction implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     *
     */
    private Date gmtCreate;

    /**
     *
     */
    private Date gmtModif;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private String action;

    /**
     *
     */
    private String ip;

    /**
     *
     */
    private Integer time;

    /**
     *
     */
    private String url;

    /**
     *
     */
    private String params;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setGmtModif(Date gmtModif) {
        this.gmtModif = gmtModif;
    }

    public Date getGmtModif() {
        return this.gmtModif;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParams() {
        return this.params;
    }

    public static class Builder {
        private Long id;

        private Date gmtCreate;

        private Date gmtModif;

        private Long userId;

        private String action;

        private String ip;

        private Integer time;

        private String url;

        private String params;

        private int type;

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setGmtCreate(Date gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }

        public Builder setGmtModif(Date gmtModif) {
            this.gmtModif = gmtModif;
            return this;
        }

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setTime(Integer time) {
            this.time = time;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setParams(String params) {
            this.params = params;
            return this;
        }

        private void construct(UserAction userAction) {
            userAction.setId(id);
            userAction.setAction(action);
            userAction.setGmtCreate(gmtCreate);
            userAction.setGmtModif(gmtModif);
            userAction.setIp(ip);
            userAction.setParams(params);
            userAction.setTime(time);
            userAction.setUrl(url);
            userAction.setUserId(userId);
            userAction.setType(type);
        }

        public UserAction create() {
            UserAction userAction = new UserAction();
            construct(userAction);
            return userAction;
        }
    }
}