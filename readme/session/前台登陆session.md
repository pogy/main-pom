com/shigu/taobao/actions/NewDaifaAction.java    319    淘宝订单转化
```
buyerPhone = user.getPhoneMob();
buyerAliww = user.getImAliww();
buyerQq = user.getImQq();
buyerGrade = user.getBuyerGrade().toString();
serviceFlag=newDaifaService.getServiceFlag(cglist);
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.DAIFA_BY_TAOBAO_SESSION + id, cglist);
```
com/shigu/member/actions/NewMemberUserAction.java 180     用户登陆
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.LOGIN_SESSION_USER, user);
obj=JSONObject.fromObject(user1);
```
com/shigu/member/actions/NewMemberUserSafeAction.java   629    手机绑定
```
request.getSession()
    .setAttribute(DConfig.PHONE_MOB_BINDING, sb.toString());
    //记录手机绑定验证码，存储session
```
com/shigu/memberStore/actions/NewShiguStoreAction.java   181   修改档口信息
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.STORE_SESSION, shiguStore);
```
com/shigu/memberStore/actions/NewShiguStoreAction.java   188   修改档口信息
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.STORE_NUM_SESSION, show);
```
com/shigu/memberStore/actions/NewShiguStoreFitmentAction.java 390  修改店铺装修时
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.SESSION_NEW_FIT,srecord);
```
com/shigu/memberStore/actions/NewShiguStoreFitmentAction.java 447  修改店铺装修时
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.SESSION_NEW_FIT,srecord);
```
com/shigu/member/actions/NewShopStroreManagerAction.java   97   修改店铺基本信息
```
ServletActionContext.getRequest().getSession()
    .setAttribute(DConfig.STORE_SESSION, record);
```
com/shigu/updateImghhh/UpdateImghhh.java   539    上传什么文件
```
req.getSession().setAttribute("imgNumhhh", i);
```