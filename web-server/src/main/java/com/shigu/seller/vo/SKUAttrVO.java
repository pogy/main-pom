package com.shigu.seller.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxc on 2016/12/27.
 *
 * @author wxc
 * @version main-site3.2 3.0.0
 * @since main-site3.2 3.0.0
 */
public class SKUAttrVO {

    public static final Map<String,String> colorsMap=new HashMap<String,String>();

    static {
        colorsMap.put("1627207:28321", "fffbf0");//乳白色
        colorsMap.put("1627207:28320", "ffffff");//白色
        colorsMap.put("1627207:4266701", "eedeb0");//米白色
        //白色系end
        colorsMap.put("1627207:28332", "e4e4e4");//浅灰色
        colorsMap.put("1627207:3232478", "666666");//深灰色
        colorsMap.put("1627207:28334", "808080");//灰色
        colorsMap.put("1627207:28330", "c0c0c0");//银色
        //灰色系end
        colorsMap.put("1627207:28341", "000000");//黑色
        //黑色系end
        colorsMap.put("1627207:4950473", "ff7500");//桔红色
        colorsMap.put("1627207:3594022", "df1b76");//玫红色
        colorsMap.put("1627207:3232480", "ffb6c1");//粉红色
        colorsMap.put("1627207:28326", "ff0000");//红色
        colorsMap.put("1627207:4464174", "eed0d8");//藕色
        colorsMap.put("1627207:3743025", "f05654");//西瓜红
        colorsMap.put("1627207:28327", "990000");//酒红色
        //红色系end
        colorsMap.put("1627207:28331", "c3b091");//卡其色
        colorsMap.put("1627207:15409374", "ffc773");//姜黄色
        colorsMap.put("1627207:20412615", "ffff01");//明黄色
        colorsMap.put("1627207:30155", "f7eed6");//杏色
        colorsMap.put("1627207:132476", "ffec43");//柠檬黄
        colorsMap.put("1627207:90554", "ffa500");//桔色
        colorsMap.put("1627207:60092", "faff72");//浅黄色
        colorsMap.put("1627207:6134424", "eaff56");//荧光黄
        colorsMap.put("1627207:28328", "ffd700");//金色
        colorsMap.put("1627207:130166", "ffffff");//香槟色
        colorsMap.put("1627207:28324", "ffff00");//黄色
        //黄色系end
        colorsMap.put("1627207:3232483", "5d762a");//军绿色
        colorsMap.put("1627207:80557", "ffffff");//墨绿色
        colorsMap.put("1627207:30156", "98fb98");//浅绿色
        colorsMap.put("1627207:28335", "008000");//绿色
        colorsMap.put("1627207:8588036", "0aa344");//翠绿色
        colorsMap.put("1627207:6535235", "23fa07");//荧光绿
        colorsMap.put("1627207:3455405", "00e09e");//青色
        //绿色系end
        colorsMap.put("1627207:3232484", "44cef6");//天蓝色
        colorsMap.put("1627207:5138330", "00a4c5");//孔雀蓝
        colorsMap.put("1627207:3707775", "4b5cc4");//宝蓝色
        colorsMap.put("1627207:28337", "d2f0f4");//浅蓝色
        colorsMap.put("1627207:28340", "041690");//深蓝色
        colorsMap.put("1627207:5483105", "30dff3");//湖蓝色
        colorsMap.put("1627207:28338", "0000fe");//蓝色
        colorsMap.put("1627207:28866", "2e4e7e");//藏青色
        //蓝色系end
        colorsMap.put("1627207:4104877", "ede0e6");//浅紫色
        colorsMap.put("1627207:3232479", "430653");//深紫色
        colorsMap.put("1627207:5167321", "8b0062");//紫红色
        colorsMap.put("1627207:80882", "b7ace4");//紫罗兰
        colorsMap.put("1627207:28329", "800080");//紫色
        //紫色系end
        colorsMap.put("1627207:129819", "603912");//咖啡色
        colorsMap.put("1627207:3232481", "d2691e");//巧克力色
        colorsMap.put("1627207:6071353", "60281e");//栗色
        colorsMap.put("1627207:30158", "b35c44");//浅棕色
        colorsMap.put("1627207:3232482", "bdb76b");//深卡其布色
        colorsMap.put("1627207:6588790", "7c4b00");//深棕色
        colorsMap.put("1627207:132069", "855b00");//褐色
        colorsMap.put("1627207:3224419", "a88462");//驼色
        //棕色系end
        colorsMap.put("1627207:130164", "ffffff");//花色
        colorsMap.put("1627207:107121", "transparent");//透明
    }
    private String cnname;
    private String color;
    private String inputName;
    private String key;
    private String checkboxName;
    private Long pid;
    private Long vid;
    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public static Map<String, String> getColorsMap() {
        return colorsMap;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getKey_(){
        return pid+"_"+vid;
    }
    public String getColor() {
        String s = colorsMap.get(getKey());
        return s == null ? null : "#" + s;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInputName() {
        return "cpva_" + this.getKey();
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getKey() {
        return pid + ":" + vid;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCheckboxName() {
        return "cp_" + this.pid;
    }

    public void setCheckboxName(String checkboxName) {
        this.checkboxName = checkboxName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }
}
