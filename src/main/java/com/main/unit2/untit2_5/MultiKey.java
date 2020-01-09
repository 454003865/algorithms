package com.main.unit2.untit2_5;

import java.util.Comparator;

public class MultiKey {
    private Integer key1;
    private String key2;

    MultiKey(Integer a,String b) //构造函数
    {
        key1=a;
        key2=b;
    }
    public static class Key1Order implements Comparator<MultiKey> //注意有<MultiKey>
    {
        public int compare(MultiKey x, MultiKey y) //重写compare方法，注意输入参数的类型是MultiKey
        {
            return x.key1.compareTo(y.key1); //需要注意的是，compareTo适用于Date、String、Integer这种，而不是用于int这种
        }
    }


    public static class Key2Order implements Comparator<MultiKey>
    {
        public int compare(MultiKey x,MultiKey y) //这里需要注意的是，String的compareTo结果比较特殊，不是单纯的-1，0，1三个结果
        //但仍然遵循大于是整数，小于是负数，等于是0这一规律。所以我们可以加以改造成-1，0，1这三个结果的形式。
        {
            int cmp=x.key2.compareTo(y.key2);
            if(cmp>0) return 1;
            if(cmp<0) return -1;
            return 0;
        }
    }


    public static void sort(MultiKey[] mul,Comparator c) //注意输入参数
    {
        for(int i=0;i<mul.length-1;i++) //冒泡排序
        {
            for(int j=0;j<mul.length-1-i;j++)
            {
                if(c.compare(mul[j], mul[j+1])==1)
                    exch(mul,j,j+1);
            }

        }
    }
    public static void exch(MultiKey[] mul,int i,int j)
    {
        MultiKey temp=mul[i];
        mul[i]=mul[j];
        mul[j]=temp;
    }

    public static void main(String[] args) {
        MultiKey[] mul = new MultiKey[4];
        mul[0] = new MultiKey(2, "b");
        mul[1] = new MultiKey(4, "aa");
        mul[2] = new MultiKey(100, "z");
        mul[3] = new MultiKey(3, "e");
        sort(mul, new MultiKey.Key1Order());//注意要新建类，才能使用其中的内部类
        for (int i = 0; i < mul.length; i++) {
            System.out.print(mul[i].key1 + " " + mul[i].key2);
            System.out.println();
        }

    }
}
