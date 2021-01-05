package com.inori.test;

import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Invoke
 *
 * @author inori
 * @date 2020/12/15
 */
public class Invoke {
    public static void main(String[] args) throws Throwable {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        System.out.println(c == d);
        MethodHandle methodHandle = methodHandle(System.out);
        methodHandle.invokeExact("hello world");

    }

    public static <T, R> MethodHandle methodHandle(Object obj) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
    }
}
