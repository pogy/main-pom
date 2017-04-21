
### 主站中session
session变量名 | sessionKey | 留存原因 | 状态（old/null/new）
------------ | ------------- | ------------ | ------------
SESSION_USER_BALANCE | ub  | 此session用于缓存用户余额，未来会被ehcahe取代 | old
LOGIN_SESSION_USER | session_user  | 用户登陆 | new 
LOGIN_SESSION_USER_ID或USER_ID | userId | 用户ID，在登陆成功后会加，很多页面中会取，原因为明 | null
LOGIN_SESSION_USER_NAME | userName | 用户名，在登陆后会加，很多页面中会取，原因为明 | null
LOGIN_SESSION_USER_IM_ALIWW | imAliww | 阿里旺旺，在登陆后会加，很多页面中会取，原因为明 | null
LOGIN_SESSION_USER_IM_NICK | nick | 淘宝昵称 | null
无 | sysuser | 系统用户，登陆后会加 | new
无 | webcss | 管理后台样式，默认为default | null
LOGIN_SESSION_AUTHCODE | session_authCode | 手机验证码 | old
SESSION_AUTH_CODE_PHONE | auth_code_phone | 收验证码的手机号 | old
STORE_SESSION | store_session | 登陆选择店铺以后店铺信息(用的数据bean) | new
SET_PASSWORD_SESSION_PHONE | phone | 忘记密码接收验证码的手机号 | old
LOGIN_MEMBER_SESSION | memberuser | 又一个登陆信息,在登陆的时候放memberUser | null
FLAG_TAOBAO | flag_taobao | 登陆的时候加的，用于老版本供货商左侧栏判断，现已没用 | null
LOGIN_SESSION_USER_TYPE | userType | 用户类型0为分销商1为供货商，没地取，只有存 | null
FLAG_QUERY | flag_query | 是否需要查询，1需要0不需要 | old
BIND_REG_SESSION_PHONE | bind_reg_phone | 手机验证码登陆时，验证手机 | null
SESSION_HEBING_USERIDS | hebing_userIds | 手机登陆绑定，存用户IDs | old
PHONE_MOB_BINDING | phoneMobBinding | 合并绑定手机同一用户到现有用户 | old
DAIFA_BY_TAOBAO_SESSION + id | daifa_by_taobao+id | 淘宝订单转化 | old
STORE_LIST_SESSION | store_list_session | 刚登陆时选店铺 | old 
STORE_NUM_SESSION | store_num_session | 数据包多店铺选择完成后的提交 | old
SESSION_DES3_USER_ID | des3_user_id | 登陆时加的，没找到取的地方 | old
SESSION_NEW_FIT | NEW_STORE_FIT | 店铺装修的内容(用的数据bean) | new
无 | is_store_webSite | 读取当前用户的店铺批发价规则 | old
LOGIN_REGEDIT_AUTHCODE | regedit_authCode | 发送注册验证码,用于保存验证码 | old
无 | coupon_image_temp_uri | 上传优惠卷图片 | old
无 | validate_code | 普通验证码 | old





