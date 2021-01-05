package com.inori.util;

/**
 * ArraysToCode
 *
 * @author inori
 * @date 2020/11/23
 */
public class ArraysToCode {
    public static void main(String[] args) {
        arraysToCode("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
    }

    public static void arraysToCode(String arrays) {
        System.out.println(arrays.replaceAll("\\[", "{").replaceAll("\\]", "}"));
    }
}
