package com.shigu.main4.jd.vo;

public class JdItemPropVO {
        private long aid;
        private String name;
        private boolean isKeyProp;
        private boolean isColorProp;
        private boolean isSizeProp;
        private boolean isSaleProp;
        private long indexId;
        private String status;
        private String attType;
        private long inputType;
        private String options;
        private String isReq;
        private String isFet;
        private String isNav;
        private String cid;
        private String groupId;

        public String getCid() {
            return this.cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public long getAid() {
            return this.aid;
        }

        public void setAid(long aid) {
            this.aid = aid;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getKeyProp() {
            return this.isKeyProp;
        }

        public void setKeyProp(boolean keyProp) {
            this.isKeyProp = keyProp;
        }

        public boolean getSaleProp() {
            return this.isSaleProp;
        }

        public void setSaleProp(boolean saleProp) {
            this.isSaleProp = saleProp;
        }

        public boolean isColorProp() {
            return this.isColorProp;
        }

        public void setColorProp(boolean colorProp) {
            this.isColorProp = colorProp;
        }

        public boolean isSizeProp() {
            return this.isSizeProp;
        }

        public void setSizeProp(boolean sizeProp) {
            this.isSizeProp = sizeProp;
        }

        public long getIndexId() {
            return this.indexId;
        }

        public void setIndexId(long indexId) {
            this.indexId = indexId;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAttType() {
            return this.attType;
        }

        public void setAttType(String attType) {
            this.attType = attType;
        }

        public long getInputType() {
            return this.inputType;
        }

        public void setInputType(long inputType) {
            this.inputType = inputType;
        }

        public String getOptions() {
            return this.options;
        }

        public void setOptions(String options) {
            this.options = options;
        }

        public String getReq() {
            return this.isReq;
        }

        public void setReq(String req) {
            this.isReq = req;
        }

        public String getFet() {
            return this.isFet;
        }

        public void setFet(String fet) {
            this.isFet = fet;
        }

        public String getNav() {
            return this.isNav;
        }

        public void setNav(String nav) {
            this.isNav = nav;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }
}
