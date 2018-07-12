package com.ldj.lib;

import java.util.ArrayList;

/**
 * Created by lidajun on 2018/6/17.
 */

public class Test {
    public static void main(String[] args) {
        VerifyHelper.getInstance()
                .add(false, "FALSE", VerifyHelper.VerifyType.FALSE)
                .add(true, "TRUE", VerifyHelper.VerifyType.TRUE)
                .add("sss", "不能为空", VerifyHelper.VerifyType.NO_EMPTY)
                .add("18600000001", "请输入正确的手机号", VerifyHelper.VerifyType.MOBILE)
                .add("541221507@qq.com", "请输入正确的邮箱地址", VerifyHelper.VerifyType.EMAIL)
                .add("500383198808088888", "请输入正确的身份证号", VerifyHelper.VerifyType.IDCARD)
                .verify(new VerifyHelper.VerifyListener() {
                    @Override
                    public void onSuccess() {
                        System.out.println("通过验证");
                    }
                });


        new Validator()
                .add("18600000001", "请输入正确的手机号", ValidatorFactory.create(ValidatorFactory.VerifyType.MOBILE))
                .verify(new Validator.ValidatorCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFailure(String message) {
                        System.out.println(message);
                    }
                });
    }
}

/**
public class User {
    public String name;
    public String email;
    public String pwd;
    public String title;
    public ArrayList<Permission> permissions;
}

public class Permission {
    public String action;
    public String type;
    public String module;
}

public class Customer extends User {

}

public class Admin extends User {

}

public class Teacher {
    public User user;
    public String title;
    public String teacherId;
}
**/