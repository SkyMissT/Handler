package com.miss.lib;

import com.miss.lib.bean.Man;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Vola on 2020/8/24.
 */
public class Methods {

    public static void main(String[] args) {

        try {

            Class clz = Class.forName("com.miss.lib.bean.Man");

            Object obj = clz.newInstance();

            System.out.println("--------------获取所有公有函数--------------");
            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("--------------获取所有公有函数--------------");
            Method[] declaredMethods = clz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(method);
            }

            System.out.println("--------------获取公有函数并调用--------------");
            Method method = clz.getMethod("setName", String.class);
            System.out.println(method);
            method.invoke(obj, "二狗子");
            Man man = (Man) obj;
            System.out.println("man.name=" + man.name);

            System.out.println("--------------获取私有函数并调用--------------");
            Method declaredMethod = clz.getDeclaredMethod("message", String.class, int.class);
            System.out.println(declaredMethod);
            //  解除私有限定
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, "二狗子",60);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
