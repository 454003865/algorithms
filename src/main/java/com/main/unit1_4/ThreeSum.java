package com.main.unit1_4;

import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    public static int count(int[] a){
        int n =a.length;
        int cnt=0;
        for (int i = 0; i < n; i++) {
        //    System.out.println(i);
            for (int j = i+1; j <n ; j++) {
                for (int k = j+1; k <n ; k++) {
                    cnt++;
                    System.out.println("i:"+i+" j:"+j+" k:"+k);
                }
            }
        }
        return cnt;
    }

    /**
     *这个就是累加的问题   1
     * @param args
     */
    public static void main(String[] args) {
//        1140
        int [] a ={1,2,2,32,13,123,12,3,12,312,3,12,3,123,12,3,-123,-123,-54,-54};
        int [] a2 ={1,2,2,5};
        System.out.println(a.length);
        StdOut.println(count(a ));
        int sum=0;
//   1 1+2 1+2+3 1+2+3
//        for (int i = 0; i <20 ; i++) {
////            System.out.println("i:"+i);
////                int count1=(1+i)/2*i;
////            System.out.println(count1);
////            System.out.println(sum+=count1);
//            int count=0;
//            for (int j = 0; j <i ; j++) {
//                count=count+j;
//            }
//            sum=sum+count;
//            System.out.println("i:"+i+" count:"+count+" sum"+sum);
//        }
    }
}
