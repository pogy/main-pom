package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 邮箱绑定参数
 * Created by zhaohongbo on 17/3/14.
 */
public class SaveEmailBO implements Serializable{

    @NotEmpty(message = "请输入邮箱")
    @Email(message = "请输入正确的邮箱格式")
    @SafeHtml(message = "email包含非法页面标签")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
