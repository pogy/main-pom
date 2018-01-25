package com.shigu.goodsup.jd.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 属性值
 * Created by zhaohongbo on 17/1/10.
 */
public class PropertyValueVO implements Serializable{

    private static final long serialVersionUID = -4917888476580949069L;
    /**
     * 值ID
     */
    private Long vid;
    /**
     * 值名称
     */
    private String name;
    private String oldName;
    /**
     * 是否被选中
     * 如果是select类型时,这个可用
     */
    private boolean selected;
    /**
     * 如果是颜色,可能要配图
     */
    private String imgUrl;
    /**
     * 1表示还有下级,2表示没有下级的
     */
    private Integer fid;
    /**
     * 子选择,如果没有子级,这里为null
     */
    private PropertyItemVO subPropItem;

    /**
     * 材质成分含量
     */
    private Map<String,String> materialPecent;

    /**
     * 目标对象中非null属性加入
     * @param pvv
     */
    public PropertyValueVO noNullAdd(PropertyValueVO pvv){
//        if(pvv.getVid()!=null){
//            this.setVid(pvv.getVid());
//        }
        if(pvv.getName()!=null){
            this.setName(pvv.getName());
        }
        if(pvv.getSubPropItem()!=null){
            this.setSubPropItem(pvv.getSubPropItem());
        }
        if(pvv.getFid()!=null){
            this.setFid(pvv.getFid());
        }
        if(pvv.getImgUrl()!=null){
            this.setImgUrl(pvv.getImgUrl());
        }
        this.setSelected(pvv.selected);
        return this;
    }

    /**
     * 计算材质成份
     */
    public void calMaterialPecent(){
        if(this.getName()!=null&&!"".equals(this.getName())){
            if(this.materialPecent==null){
                this.setMaterialPecent(new HashMap<String, String>());
            }
            //把name转化成Map里面值,棉78% 新型聚酯纤维20.5% 聚氯乙烯(氯纶)1.5%
            String[] nameArr=this.getName().split(" ");
            if(nameArr.length>0){
                materialPecent=new HashMap<String,String>();
                for(String na:nameArr){
                    Pattern pattern = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
                    Matcher matcher = pattern.matcher(na);
                    if (matcher.find()){
                        String pecent=matcher.group();
                        String type=na.replace(pecent+"%","");
                        materialPecent.put(type,pecent);
                    }else{//如果没%就没成份
                        materialPecent.put(na,null);
                    }
                }
            }
        }
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyItemVO getSubPropItem() {
        return subPropItem;
    }

    public void setSubPropItem(PropertyItemVO subPropItem) {
        this.subPropItem = subPropItem;
    }

    public Map<String, String> getMaterialPecent() {
        return materialPecent;
    }

    public void setMaterialPecent(Map<String, String> materialPecent) {
        this.materialPecent = materialPecent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null||!(obj instanceof PropertyValueVO)){
            return false;
        }
        PropertyValueVO pvv= (PropertyValueVO) obj;
        //如果name不为空且一样,认为也是同一个,不再比vid
        if(pvv.getName()!=null&&this.getName()!=null&&this.getName().equals(pvv.getName())){
            return true;
        }
        if(pvv.getVid()==null){
            return false;
        }
        return pvv.getVid().equals(this.getVid());
    }

    public String getOldName() {
        return this.oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}
