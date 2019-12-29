package com.main.unit1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class Test_1_2_3 {
    public static void main(String[] args)
    {
        int N=20;
        double min=0.1;
        double max=0.9;
        Random random=new Random();
        Interval2D [] a=new Interval2D[N];
        for (int i = 0; i <N ; i++)
        {
            double xlo= StdRandom.uniform(min, max);
            double xhi=StdRandom.uniform(min, max);
            if(xlo>xhi)
            {
                double temp=xlo;
                xlo=xhi;
                xhi=temp;
            }
            double ylo=StdRandom.uniform(min, max);
            double yhi=StdRandom.uniform(min, max);
            if(ylo>yhi)
            {
                double temp=ylo;
                ylo=yhi;
                yhi=temp;
            }
            Interval1D x=new Interval1D(xlo, xhi);
            Interval1D y=new Interval1D(ylo, yhi);
            a[i]=new Interval2D(x, y);
            a[i].draw();
        }
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.005);
        Interval1D x0=new Interval1D(min, max);
        Interval1D y0=new Interval1D(min, max);
        new Interval2D(x0, y0).draw();

        int count=0;
        for (int i = 0; i <N ; i++)
        {
            for (int j = i+1; j <N ; j++)
            {
                if(a[i].intersects(a[j]))
                    count++;
            }
        }
        System.out.println(count);
    }
}
