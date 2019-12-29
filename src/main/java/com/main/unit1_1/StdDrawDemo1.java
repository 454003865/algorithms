package com.main.unit1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class StdDrawDemo1 {
    public static void main(String[] args) {
        StdDrawDemo1 demo1= new StdDrawDemo1();
      //  demo1.test1();
      //  demo1.test2();
        System.out.println((0+15)/2);
        System.out.println((2.0e-6*1000000000.1));
        System.out.println(true&&false||true&&true);
    }

    /**
     * 函数图像画图
     */
    public static void test1(){
        int N=100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <=N ; i++) {
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));

        }

    }
    public static void test2(){
      int N=50;
      double[] a =new double[N];
        for (int i = 0; i <N ; i++) {
            a[i]= StdRandom.random();
        }
        for (int i = 0; i <N ; i++) {
            double x= 1.0*i/N;
            double y=a[i]/N;
            double rw=N/4.0;
            double rw1=0.5/N;
            double rh=a[i]/2.0;
            //我后来才发现，原来x,y代表是矩形中心的坐标。 rw, rh分别代表矩形宽的一半，和高的一半。
            StdDraw.filledRectangle(x,y,rw1,rh);
        }

    }
}
