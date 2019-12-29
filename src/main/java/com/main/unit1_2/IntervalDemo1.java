package com.main.unit1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;

public class IntervalDemo1 {
    public static void main(String[] args) {
        double xlo=.2;
        double xhi=.5;
        double ylo=.5;
        double yhi=.8;
        int t=10000297;
        Interval1D xinterval = new Interval1D(xlo,xhi);
        Interval1D yinterval = new Interval1D(ylo,yhi);
        StdOut.println(xinterval);
        StdOut.println(yinterval);
        Interval2D box= new Interval2D(xinterval,yinterval);
       // Interval2D box1= new Interval2D(xinterval,yinterval);
      //  box.intersects(box1);
        box.draw();
    }
}
