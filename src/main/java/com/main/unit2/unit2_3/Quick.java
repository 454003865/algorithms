package com.main.unit2.unit2_3;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {

    public static void main(String[] args) {
        int[] data = new int[] {26, 53, 67, 48, 57, 48, 32, 60, 50};
        int[] data2 = new int[] {5,5,1,1,1,1,1,15,5,51,23,3,7,5,87,57,45,34,22,14,18,26, 53, 67, 48, 57, 13, 48, 32, 60, 50};


        int[] data5 = new int[] {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        quick3waysort_own(data2, 0, data2.length-1);
      //  sort3(data2, 0, data2.length-1);
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }

    }
    public static int[] sort(int[] a ){
      //  StdRandom.shuffle(a);

            return null;
    }


    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }

        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

       if (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public  static void quicksort_own(int[] arr,int low,int high){

            if (low>=high){
                return;
            }

        int temp,i,j;
        i=low;
        j=high;

        temp=arr[low];

        while(i<j){
                while (arr[j]>=temp&&i<j){
                    j--;
                }
                while (arr[i]<=temp&&i<j){
                    i++;
                }
            if (i<j){


                int middle=arr[j];
                arr[j]=arr[i];
                arr[i]=middle;



            }


            }

        arr[low] = arr[i];
        arr[i] = temp;

      //  arr[j]=temp;
        quicksort_own(arr,low,j-1);
        quicksort_own(arr,j+1,high);




    }

    /**
     * 三向切分的快速排序
     * @param arr
     * @param low
     * @param high
     */
    public  static void quick3waysort_own(int[] arr,int low,int high){
        if(high<=low){
            return;
        }
            int lo=low;
            int gt=high;
            int i=low+1;
            int temp=arr[low];
        while (i<=gt){

//            while (arr[gt]>temp){
//                gt--;
//            }
            //

        //判断标准位 是否大于第一位的
            int ifchange=arr[i]-temp;
            //如果大于 则 标准位大于第一位
            if(arr[i]>temp){
                int middle=arr[gt];
                arr[gt]=arr[i];
                arr[i]=middle;
                gt--;
            }
            else if (arr[i]<temp){
                int middle=arr[i];
                arr[i]=arr[lo];
                arr[lo]=middle;
                lo++;
                i++;
            }else{
                i++;
            }
            for  (int i1:
                    arr) {
                System.out.print(i1+",");
            }
            System.out.println();
        }


        for  (int i1:
             arr) {
            System.out.print(i1+",");
        }
        System.out.println(lo+"|||"+gt+"|||"+i);
        quicksort_own(arr,low,lo-1);
        quicksort_own(arr,gt+1,high);
    }

    public  static void quick3waysort_own2(int[] arr,int low,int high){
        if(high<=low){
            return;
        }
        int lo=low;
        int gt=high;
        int i=low+1;
        int temp=arr[low];
        while (i<=gt){



        }


        for  (int i1:arr) {
            System.out.print(i1+",");
            System.out.println();
        }
        System.out.println(lo+"|||"+gt+"|||"+i);
        quicksort_own(arr,low,lo-1);
        quicksort_own(arr,gt+1,high);
    }

    public static void sort3(int[] a){
        sort3(a, 0, a.length - 1);
    }

    private static void sort3(int[] a, int low, int high){
        if(low < high){
            int mid = partition(a, low, high);//切分，即一趟排序过程
            sort3(a, low, mid - 1);//将左半部分排序
            sort3(a, mid + 1, high);//将右半部分排序
        }
    }
    private static int partition(int[] a, int low, int high){
        int key = a[low];

        while(low < high){
            while(low < high && a[high] >= key){
                high--;
            }
            if(low < high){
                a[low++] = a[high];
            }
            while(low < high && a[low] <= key){
                low++;
            }
            if(low < high){
                a[high--] = a[low];
            }
        }
        a[low] = key;

        return low;
    }

}
