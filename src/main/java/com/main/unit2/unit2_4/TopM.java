package com.main.unit2.unit2_4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

import java.rmi.MarshalledObject;

public class TopM {
    public static void main(String[] args) {
        int m=Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq= new MaxPQ<Transaction>(m+1);

        while (StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size()>m){
                pq.delMax();
            }
        }

        Stack<Transaction> stack=new Stack<Transaction>();

    }
}
