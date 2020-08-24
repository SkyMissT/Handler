package com.miss.lib;

import com.miss.lib.bean.Man;

import java.lang.reflect.Field;

/**
 * Created by Vola on 2020/8/24.
 */
public class Fields {

    public static void main(String[] args) {

        try {
            Class clz = Class.forName("com.miss.lib.bean.Man");

            Object obj = clz.newInstance();

            System.out.println("-------------获取所有公有变量-------------");
            Field[] fields = clz.getFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            System.out.println("-------------获取所有变量-------------");
            Field[] declaredFields = clz.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f);
            }

            System.out.println("-------------获取公有变量-------------");
            Field field = clz.getField("name");
            //  为对象设置值
            field.set(obj,"二狗子");
            Man man = (Man) obj;
            System.out.println("man.name=" + man.name);

            System.out.println("-------------获取私有变量-------------");
            Field declaredField = clz.getDeclaredField("age");
            //  解除私有限定
            declaredField.setAccessible(true);
            declaredField.set(obj,26);
            System.out.println("man.getAge=" + man.getAge());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}
