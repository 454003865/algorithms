package com.main.unit1_3;

import com.sun.istack.internal.NotNull;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class test1 {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<String>();
        stack.push("123");
        stack.push("234");
      Iterator<String> iter=  stack.iterator();
        System.out.println(stack.toString());
        String next =stack.pop();
        System.out.println(next);
    }
}
