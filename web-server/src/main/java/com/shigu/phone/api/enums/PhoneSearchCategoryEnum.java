package com.shigu.phone.api.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-10-01.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public enum PhoneSearchCategoryEnum {

    TOTAL_CATEGORY(0),
    MAN_CATEGORY(1),
    WOMAN_CATEGORY(2);


    /**
     * 1总类目(不分男女)2男类3女类
     */
    int type;

    public List<Integer> getTypes(){
        List<Integer> list = new ArrayList<>();
        list.add(TOTAL_CATEGORY.getType());
        list.add(MAN_CATEGORY.getType());
        list.add(WOMAN_CATEGORY.getType());
        return list;
    }

    public List<String> getCateValues(){
        List<String> list = new ArrayList<>();
        if (this.type == 1){//男类
            list.add("30");//男装
            list.add("50011740");//男鞋
        }else if(this.type == 2){//女类
            list.add("16");//女装
            list.add("50006843");//女鞋
        }
        return list;
    }


    PhoneSearchCategoryEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
