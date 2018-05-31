package com.shigu.main4.item.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 属性
 * Created by zhaohongbo on 17/1/10.
 */
public class PropertyItemVO implements Serializable,Cloneable{

    private static final long serialVersionUID = -2116803040868807220L;

    /**
     * 属性ID
     */
    private Long pid;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 属性前端表现形式,输入框、选择项、多选
     */
    private PropType type;
    /**
     * 是否允许别名,允许为true
     */
    private boolean canAlias;
    /**
     * 值
     */
    private List<PropertyValueVO> values;
    /**
     * 是否必须,true为必须
     */
    private boolean mustHave;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 加一批值
     * @param pvvs
     */
    public void addPropValueList(List<PropertyValueVO> pvvs){
        if(values==null){
            values=new ArrayList<PropertyValueVO>();
            //如果是选择类的,第一个放空
            if(type.equals(PropType.SELECT)){
                addEmpty();
            }
        }
        if(pvvs!=null)
        values.addAll(pvvs);
    }
    /**
     * 带更新的添加
     * 按vid唯一匹配
     * 如果存在,更新
     * 如果不存在,增加
     * @param pvv
     * @return 0代表什么也没加,2代表原来已经有了现在至少是第2次修改,1代表新加
     */
    public int addPropValue(PropertyValueVO pvv){
        int result=addPropValueNoUpdate(pvv);
        if(result==2){
            PropertyValueVO oldpvv=values.get(values.indexOf(pvv));
            oldpvv.noNullAdd(pvv);
        }
        return result;
    }

    /**
     * 带更新的添加
     * 返回被操作的ID
     * @param pvv
     * @return
     */
    public Long addPropValueReturnId(PropertyValueVO pvv){
        int result=addPropValueNoUpdate(pvv);
        if(result==2){
            PropertyValueVO oldpvv=values.get(values.indexOf(pvv));
            oldpvv.noNullAdd(pvv);
            //同名不同ID
            return oldpvv.getVid();
        }
        return pvv.getVid();
    }

    /**
     * 如果已经存在,不更新
     * @param pvv
     * @return
     */
    public int addPropValueNoUpdate(PropertyValueVO pvv){
        //如果没有vid认为是不能成功的
        if(pvv==null||pvv.getVid()==null){
            return 0;
        }
        if(values==null){
            values=new ArrayList<PropertyValueVO>();
            //如果是选择类的,第一个放空
            if(type.equals(PropType.SELECT)){
                addEmpty();
            }
        }
        //取出原有的value
        if(values.contains(pvv)){//原来已经有
            return 2;
        }else{//新加
            values.add(pvv);
            return 1;
        }
    }

    /**
     * 如果是选择类的,加个空项
     */
    public void addEmpty(){
       //第一个放空
        PropertyValueVO ppv=new PropertyValueVO();
        ppv.setVid(-1L);
        ppv.setName("");
        values.add(ppv);
    }

    /**
     * 按vid获得属性
     * @param vid
     * @return
     */
    public PropertyValueVO getPropValueByVid(Long vid){
        if(values==null||vid==null){
            return null;
        }
        PropertyValueVO pvv=new PropertyValueVO();
        pvv.setVid(vid);
        if(values.contains(pvv)){
            return values.get(values.indexOf(pvv));
        }else{
            return null;
        }
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropType getType() {
        return type;
    }

    public void setType(PropType type) {
        this.type = type;
    }

    public List<PropertyValueVO> getValues() {
        return values;
    }

    /**
     * 只在计算sku时使用这个方法,其它地方,请走addPropValue
     * @param values
     */
    public void setValues(List<PropertyValueVO> values) {
        this.values = values;
    }

    public boolean isMustHave() {
        return mustHave;
    }

    public void setMustHave(boolean mustHave) {
        this.mustHave = mustHave;
    }

    public boolean isCanAlias() {
        return canAlias;
    }

    public void setCanAlias(boolean canAlias) {
        this.canAlias = canAlias;
    }
}
