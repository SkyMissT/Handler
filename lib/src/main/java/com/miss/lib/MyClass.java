package com.miss.lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyClass {

    public static void main(String[] args) {

        try {
            Class clz = Class.forName("com.miss.lib.bean.Man");

            //  获取所有public构造函数
            System.out.println("----获取公有构造函数---");
            Constructor[] constructors = clz.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }

            //  获取所有构造函数（public、private）
            System.out.println("----获取所有构造函数---");
            Constructor[] declaredConstructors = clz.getDeclaredConstructors();
            for (Constructor c : declaredConstructors) {
                System.out.println(c);
            }

            //  获取公有、无参构造函数
            System.out.println("----获取公有、无参构造函数---");
            Constructor constructor = clz.getConstructor();
            System.out.println(constructor);
            //  调用构造方法
            Object o = constructor.newInstance();

            //  获取私有、有参构造函数---后面填的是参数列表
            System.out.println("----获取私有、有参构造函数---");
            Constructor priConstructor = clz.getDeclaredConstructor(int.class);
            System.out.println(priConstructor);
            //  调用构造方法,可访问
            priConstructor.setAccessible(true);
            Object obj = priConstructor.newInstance(24);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}