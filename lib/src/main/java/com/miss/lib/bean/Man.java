package com.miss.lib.bean;

/**
 * Created by Vola on 2020/8/24.
 */
public class Man {

    public Man() {
        System.out.println("public---无参构造函数---");
    }

    private Man(int age){
        this.age = age;
        System.out.println("private---有参构造函数---age=" + age);
    }

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("public---有参构造函数---:age=" + age + "---name=" + name);
    }

    private int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void message(String name,int time) {
        System.out.println("提供马杀鸡服务：" + name + ",时间：" + time + "分钟");
    }

}
