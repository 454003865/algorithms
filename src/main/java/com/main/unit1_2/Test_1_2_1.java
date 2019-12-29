package com.main.unit1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class Test_1_2_1 {
    public static void main(String[] args) {
        int N=100;
        Random random=new Random();
        Point2D [] points=new Point2D[N];
        for (int i = 0; i <N ; i++)
        {
            double x=random.nextDouble();
            double y=random.nextDouble();
            points[i]=new Point2D(x, y);
            //points[i].draw();
        }
        double distance=points[0].distanceTo(points[1]);
        for (int i = 0; i <N ; i++)
        {
            for (int j = i+1; j <N ; j++)
            {
                double temp=points[i].distanceTo(points[j]);
                if(distance>temp)
                {
                    distance=temp;
                }
            }
        }
        System.out.printf("%.3f",distance);
    }
}
