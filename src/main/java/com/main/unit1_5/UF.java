package com.main.unit1_5;

public class UF {
    private int[] id;//分量ID 以触点作为索引
    private int count; //分量数量

    public UF(int n){
        count=n;
        id=new int[n];
        for (int i = 0; i <n ; i++) {
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        return id[p];
    }
    public void union(int p,int q){
        if(q>p){
            id[q]=id[p];
        }else{
            id[q] =id[p];
        }
        count--;
    }

    public static void main(String[] args) {
        int N =200;
        UF uf = new UF(N);
//      N  while(){
//
//        }
    }
}
