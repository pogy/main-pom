package com.shigu.spread.enums;

/**
 * 广告code
 * Created by zhaohongbo on 17/4/12.
 */
public enum SpreadEnum {
    QZGG("全站公告", "QZGG"), MAN_DT("男装大图", "MAN-DT"), MAN_XT("男装小图", "MAN-XT"),
    MAN_RM("热卖广告", "MAN-RM"), MAN_FG("风格", "MAN-FG"), MAN_YS("元素", "MAN-YS"),
    MAN_TJDK("推荐档口", "MAN-TJDK"), MAN_XHTX("喜欢T恤", "MAN-XHTX"), MAN_XHNZ("喜欢牛仔", "MAN-XHNZ"),
    MAN_XHXZ("喜欢鞋子", "MAN-XHXZ"), MAN_HOTBOT("热卖下方条形广告", "MAN-HOTBOT"), MAN_STYLEBOT("风格下方条形广告", "MAN-STYLEBOT"),
    WOMAN_DT("男装大图", "WOMAN-DT"), WOMAN_XT("男装小图", "WOMAN-XT"),
    WOMAN_RM("热卖广告", "WOMAN-RM"), WOMAN_FG("风格", "WOMAN-FG"), WOMAN_YS("元素", "WOMAN-YS"),
    WOMAN_TJDK("推荐档口", "WOMAN-TJDK"), WOMAN_XHTX("喜欢T恤", "WOMAN-XHTX"), WOMAN_XHNZ("喜欢牛仔", "WOMAN-XHNZ"),
    WOMAN_XHXZ("喜欢鞋子", "WOMAN-XHXZ"), WOMAN_HOTBOT("热卖下方条形广告", "WOMAN-HOTBOT"), WOMAN_STYLEBOT("风格下方条形广告", "WOMAN-STYLEBOT"), MAN_GOODS_RIGHT("男装商品库右侧", "MAN-GOODS-RIGHT"),
    WOMAN_GOODS_RIGHT("女装商品库右侧", "WOMAN-GOODS-RIGHT"),
    SEARCH_RIGHT("搜索右侧", "SEARCH-RIGHT"), INDEX_TOP("首页顶部", "INDEX-TOP"), LOGIN_GT("登录页", "LOGIN_GT"),
    BACK_SHOP("供应商后台", "BACK_SHOP"), BACK_MEMBER("分销商后台", "BACK_MEMBER"),


    JX_SPREAD_INDEX_DT("濮院站首页幻灯片商品广告", "JX_SPREAD_INDEX_DT"),
    JX_SPREAD_INDEX_XT("濮院站首页幻灯片下方商品广告", "JX_SPREAD_INDEX_XT"),
    JX_SPREAD_INDEX_MENS("濮院站首页男装商品广告", "JX_SPREAD_INDEX_MENS"),
    JX_SPREAD_INDEX_WOMAN("濮院站首页女装商品广告", "JX_SPREAD_INDEX_WOMAN"),
    JX_SPREAD_INDEX_MENSHOES("濮院站首页男鞋商品广告", "JX_SPREAD_INDEX_MENSHOES"),
    JX_SPREAD_INDEX_SELLHOT("濮院站首页热销商品广告", "JX_SPREAD_INDEX_SELLHOT"),
    JX_SPREAD_INDEX_KUZI("濮院站首页裤子商品广告", "JX_SPREAD_INDEX_KUZI"),
    JX_SPREAD_INDEX_CHILDRENCOLTHING("濮院站首页童装商品广告", "JX_SPREAD_INDEX_CHILDRENCOLTHING"),
    JX_QZGG("濮院站首页公告管理广告", "JX_QZGG"),


    CS_MAN_DT("男装大图", "CS-MAN-DT"), CS_MAN_XT("男装小图", "CS-MAN-XT"),
    CS_MAN_RM("热卖广告", "CS-MAN-RM"), CS_MAN_FG("风格", "CS-MAN-FG"), CS_MAN_YS("元素", "CS-MAN-YS"),
    CS_MAN_TJDK("推荐档口", "CS-MAN-TJDK"), CS_MAN_XHTX("喜欢T恤", "CS-MAN-XHTX"), CS_MAN_XHNZ("喜欢牛仔", "CS-MAN-XHNZ"),
    CS_MAN_XHXZ("喜欢鞋子", "CS-MAN-XHXZ"), CS_MAN_HOTBOT("热卖下方条形广告", "CS-MAN-HOTBOT"), CS_MAN_STYLEBOT("风格下方条形广告", "CS-MAN-STYLEBOT"),
    CS_WOMAN_DT("男装大图", "CS-WOMAN-DT"), CS_WOMAN_XT("男装小图", "CS-WOMAN-XT"),
    CS_WOMAN_RM("热卖广告", "CS-WOMAN-RM"), CS_WOMAN_FG("风格", "CS-WOMAN-FG"), CS_WOMAN_YS("元素", "CS-WOMAN-YS"),
    CS_WOMAN_TJDK("推荐档口", "CS-WOMAN-TJDK"), CS_WOMAN_XHTX("喜欢T恤", "CS-WOMAN-XHTX"), CS_WOMAN_XHNZ("喜欢牛仔", "CS-WOMAN-XHNZ"),
    CS_WOMAN_XHXZ("喜欢鞋子", "CS-WOMAN-XHXZ"),

    KX_MAN_DT("男鞋大图", "KX-MAN-DT"),  KX_MAN_XT("看鞋首页大图轮播下方", "KX-MAN-XT"),  KX_GOODS_RIGHT("看鞋商品库右侧", "KX-GOODS-RIGHT");

    SpreadEnum(String title, String code) {
        this.title = title;
        this.code = code;
    }

    /**
     * 按名字拿
     *
     * @return
     */
    public SpreadEnum parseToWOMAN() {
        if (this.code.startsWith("MAN-")) {
            String womanCode = this.code.replace("MAN", "WOMAN");
            for (SpreadEnum is : SpreadEnum.values()) {
                //查出不是自己
                if (is.getCode().equals(womanCode)) {
                    return is;
                }
            }
        }
        return null;
    }

    private String title;

    private String code;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
