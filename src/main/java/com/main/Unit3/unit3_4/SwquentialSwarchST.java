package com.main.Unit3.unit3_4;


import java.util.Scanner;

import edu.princeton.cs.algs4.*;

public class SwquentialSwarchST {


        public static void main(String[] args) {
            //50个随机数字
            Integer[] a = new Integer[50];
            for (int i = 0; i < a.length; i++) {
                a[i] = new Integer(StdRandom.uniform(1, 1000));
            }

            //50个随机字符串
            char ch = 'a';
            int chl;
            String []b = new String[50];
            for (int i = 0; i < b.length; i++) {
                int sl = StdRandom.uniform(1, 10);
                b[i] = new String();
                for (int j = 0; j < sl; j++) {
                    chl = StdRandom.uniform(0, 23);
                    b[i] += (char)(ch + chl);
                }
            }
            //构建散列表
        /*SeparateChainingHashST<String, Integer> hashmap = new SeparateChainingHashST<String, Integer>(50);

        for (int i = 0; i < b.length; i++) {
            hashmap.put(b[i], a[i]);
        }*/


            LinearProbingHashST<String, Integer> hashmap = new LinearProbingHashST<String, Integer>();
            //占有率最好在1/2和1/8之间（数学证明结果），占有率越高，查找操作越难以命中，如果占有率为1，输入没有的值就会无限循环
            for (int i = 0; i < b.length; i++) {
                hashmap.put(b[i], a[i]);
            }

            hashmap.show();

            String KeyShuRu;
            Scanner ShuRu = new Scanner(System.in);
            while (true) {
                KeyShuRu = ShuRu.nextLine();
                System.out.println(hashmap.get(KeyShuRu));
                hashmap.delete(KeyShuRu);
                hashmap.show();
            }
        }
    }

    /*
     * 基于拉链法的散列表
     * 散列值相同时，用一个链表储存
     */
    class SeparateChainingHashST<K, V> {
        private K key;
        private V value;
        private int M;
        private SequentialSearchST<K, V>[] st;
        public SeparateChainingHashST(int M) {
            st = (SequentialSearchST<K, V>[]) new SequentialSearchST[M];
            for (int i = 0; i < M; i++) {
                st[i] = new SequentialSearchST();
            }
        }
        /*
         * 插入
         */
        public void put(K key, V value) {
            st[hash(key)].put(key, value);
        }
        /*
         * 查找
         */
        public V get(K key) {
            return st[hash(key)].get(key);
        }
        /*
         * 输出整个表
         */
        public void show() {
            for (int i = 0; i < M; i++) {
                System.out.print("chain ["+i+"]  ");
                st[i].show();
                System.out.println();
            }
        }
        /*
         * 获取哈希值
         */
        private int hash(K key) {
            return (key.hashCode() & 0x7fffffff) % M; //可以返回一个M以内的正整数hash值

        }
    }

    /*
     * 基于线性探测法的散列表
     * 散列值处已经有元素，就把值存在散列值处的后面（触底返0）
     */
    class LinearProbingHashST<K, V> {
        private K[] key;
        private V[] value;
        private int M = 16; //线性探测表的大小
        private int N; //表中键值对的多少
        public LinearProbingHashST() {
            key = (K[]) new Object[M];
            value = (V[]) new Object[M];
        }
        /*
         * 插入
         */
        public void put(K key, V value) {
            if (N >= M/2) { resize(2*M);}

            int hashv = hash(key);
            while (true) {
                if (hashv == M) { hashv = 0;}

                if (this.key[hashv] == null) {
                    this.key[hashv] = key;
                    this.value[hashv] = value;
                    N++;
                    break;
                }
                else if (key.equals(this.key[hashv])) {
                    this.value[hashv] = value;
                    break;
                }

                hashv++;
            }
        }
        /*
         * 查找
         */
        public V get(K key) {
            int hashv = hash(key);
            while (true) {
                System.out.println("hashv = "+hashv);
                if (this.key[hashv] == null) { return null;}
                if (key.equals(this.key[hashv])) { return this.value[hashv];}
                hashv++;
                if (hashv == M) { hashv = 0;}
            }
        }
        /*
         * 输出表
         */
        public void show() {
            for (int i = 0; i < M; i++) {
                System.out.printf("[%d]  %-10s%4d  \n", i, key[i], value[i]);
            }
        }
        /*
         * 删除元素
         */
        public void delete(K key) {
            //将元素删除
            int hashv = hash(key);
            while (true) {
                if (this.key[hashv] == null) {
                    System.out.println("the value is not exist");
                    return;
                }

                if (key.equals(this.key[hashv])) {
                    this.key[hashv]   = null;
                    this.value[hashv] = null;
                    N--;
                    System.out.println("The value has been deleted");
                    break;
                }

                hashv++;
                if (hashv == M) { hashv = 0;}
            }

            //将后面的元素全部重新插入
            hashv = hash(key) + 1;
            while (this.key[hashv] != null) {
                K tempkey   = this.key[hashv];
                V tempvalue = this.value[hashv];

                this.key[hashv]   = null;
                this.value[hashv] = null;
                N--;

                put(tempkey, tempvalue);

                hashv ++;
                if (hashv == M) { hashv = 0;}
            }
        }
        /*
         * 获取哈希值
         */
        private int hash(K key) {
            return (key.hashCode() & 0x7fffffff) % M;
        }
        /*
         * 改变大小
         */
        private void resize(int M) {
            this.M = M;
            K[] tempkey   = (K[]) new Object[M];
            V[] tempvalue = (V[]) new Object[M];

            for (int i = 0; i < key.length; i++) {
                tempkey[i]   = key[i];
                tempvalue[i] = value[i];
            }

            key   = tempkey;
            value = tempvalue;
        }
    }


    /*
     * 链表
     */
    class SequentialSearchST<K, V> {
        private Node head;
        private Node root;
        class Node {
            private K key;
            private V value;
            private Node next;
            private Node(K key, V value) {
                this.key   = key;
                this.value = value;
            }
            /*
             * 输出节点
             */
            private void show() {
                System.out.printf("%-10s%4d  ", key, value);
            }
        }
        /*
         * 插入
         */
        public void put(K key, V value) {
            if (root != null) {
                Node tempnode = root;
                while (true) {
                    if (key.equals(tempnode.key)) {
                        tempnode.value = value;
                        return;
                    }

                    if (tempnode == head) { break;}
                    tempnode = tempnode.next;
                }
            }
            //上面是避免有重复的key
            Node newnode = new Node(key, value);
            if (root == null) {
                root = newnode;
                head = newnode;
                return;
            }

            head.next = newnode;
            head = newnode;
        }
        /*
         * 查找
         */
        public V get(K key) {
            Node tempnode = root;

            while (!(tempnode == null)) {
                if (key.equals(tempnode.key)) { return tempnode.value;}
                tempnode = tempnode.next;
            }

            return null;
        }
        /*
         * 输出整条链
         */
        public void show() {
            Node tempnode = root;
            while (!(tempnode == null)) {
                tempnode.show();
                tempnode = tempnode.next;
            }
        }


}
