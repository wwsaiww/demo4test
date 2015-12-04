package com.jialin.test.annotation;

import java.lang.reflect.Method;

/**
 * @Author : JiaLin
 * @Group : TGB
 * @Date : 2014/6/9
 * @Description :
 */
public class MyClass {

    @MyDeprecated
    public String sayHelloWorld()
    {
        return "Hello,World!";
    }

    public String sayHelloJiaLin()
    {
        return "Hello,Jialin!";
    }


    public static void main(String[] args) {
        testMyDeclared(MyClass.class);
    }

    public static void testMyDeclared(Class<?> myClass) {
        for (Method method : myClass.getDeclaredMethods()) {

            MyDeprecated myDeprecated = method.getAnnotation(MyDeprecated.class);
            if (myDeprecated != null) {
                System.out.println(myDeprecated.description()+method.getName());
            }
        }
    }

}
