package com.main.unit1_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        binomial(100,50,0.25);
    }

    /**
     * 编写一个程序 从命令行得到三个整数参数
     * 如果都相等则打印equal
     * 如果不相等 则打印not equal
     */
    public static void test1_1_3(){

        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("num1：");
        // 判断是否还有输入
          int num1=scan.nextInt();
        System.out.println("num2：");
        // 判断是否还有输入
        int num2=scan.nextInt();
        System.out.println("num3：");
        // 判断是否还有输入
        int num3=scan.nextInt();
            if((num1==num2)&&(num1==num3)){
                System.out.println("equal");
            }else{
                System.out.println("not equal");
            }
    }
    public static void test1_1_6(){
        int f=0;
        int g=1;
        for (int i = 0; i <=15 ; i++) {
            System.out.println(i+"---------------------------------");
            StdOut.println("f："+f);
            StdOut.println("g:"+g);
            f=f+g;
            g=f-g;

        }
    }
    public static void test1_1_12(){
        int[] a= new int[10];
        for (int i = 0; i <10 ; i++) {
            a[i]=9-i;
        }
        for (int i = 0; i <10 ; i++) {
            a[i]=a[a[i]];
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(a[i]);
        }
    }
    public static  void test1_1_27(){



    }
    public static double binomial(int N,int k ,double p){
        System.out.println(N+","+k);
        if(N==0&&k==0) return 1.0;
        if(N<0||k<0) return 0.0;
        return (1.0-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
    }
}
