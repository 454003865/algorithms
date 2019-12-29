package com.main.unit2.unit2_1;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {2,5,3,6,4,9,8,7,1};
        int temp;

        for (int i=1;i<arr.length;i++){

            //待排元素小于有序序列的最后一个元素时，向前插入
            if (arr[i]<arr[i-1]){
                temp = arr[i];
                //从 i~0的排序
                for (int j=i;j>=0;j--){
                    //这个部分没看懂

                    if (j>0 && arr[j-1]>temp) {
                        arr[j]=arr[j-1];
                    }else {
                        arr[j]=temp;
                        break;
                    }
                }
            }
            System.out.println(i+" "+Arrays.toString(arr));
        }
      //  System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * 希尔排序 用之前的一些排序方法让插入排序之前的数组变得更有顺序 然后在进行判断排序
     */
    @Test
    public void test4(){
        int[] data = new int[] {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < data.length; i++){
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment){
                    if (temp < data[j]){
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
            for (int i = 0; i < data.length; i++){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

}
