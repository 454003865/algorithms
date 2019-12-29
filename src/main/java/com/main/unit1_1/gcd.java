package com.main.unit1_1;

public class gcd {
    public static void main(String[] args) {
     //   System.out.println(gcd(3,100));

    }

    /**
     * 计算两个非负整数 P Q的最大公约数            
     * 若q是0 则最大公约数为P。否则将P除以Q得到余数R,P和Q的最大公约数即为Q和R的最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p,int q){
        if(q==0) return p;
        int r=p%q;
        System.out.println(r);
        return gcd(q,r);
    }
}
