package com.lemon.spring5.bean;

public class Orders {

    private String oname;

    public Orders() {
        System.out.println("1. 执行无参构造");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2. 执行set方法");
    }

    public void init() {
        System.out.println("3. 初始化方法");
    }

    public void destroy() {
        System.out.println("5. 销毁方法");
    }
}
