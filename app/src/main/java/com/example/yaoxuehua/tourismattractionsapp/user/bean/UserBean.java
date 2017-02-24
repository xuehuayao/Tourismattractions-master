package com.example.yaoxuehua.tourismattractionsapp.user.bean;

/**
 * Created by Administrator on 2017/2/24.
 */

public class UserBean {

    private String name;
    private int password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
