package com.shigu.photo.bo;

import com.shigu.main4.photo.bo.PhotoWorksBO;

import java.util.Arrays;
import java.util.Collections;

public class PhotoAuthorListBO {

    private Integer crid;
    private Integer coid;
    private Long sid;
    private String keyword;
    private Integer page;

    public PhotoWorksBO toPhotoWorksBO(Integer superType){
        PhotoWorksBO bo=new PhotoWorksBO();
        if(superType!=null){
            if(superType==1){
                bo.setUserTypes(Collections.singletonList(1));
                if(crid!=null){
                    bo.setSex(coid);
                }
            }else{
                if(coid==null){
                    bo.setUserTypes(Arrays.asList(2,3));
                }else{
                    bo.setUserTypes(Collections.singletonList(coid));
                }
            }
        }else{
            bo.setUserTypes(Collections.singletonList(4));
        }
        if(page==null){
            page=1;
        }
        bo.setTitle(keyword);
        bo.setPage(page);
        bo.setPageSize(10);
        bo.setStyleId(sid);
        return bo;
    }

    public Integer getCrid() {
        return this.crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Long getSid() {
        return this.sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCoid() {
        return this.coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }
}
