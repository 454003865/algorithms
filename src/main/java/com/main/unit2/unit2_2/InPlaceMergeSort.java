package com.main.unit2.unit2_2;

public class InPlaceMergeSort {


    private static void reverse(int[] arr, int i, int j) {
        while(i < j)
        {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    // swap [bias, bias+headSize) and [bias+headSize, bias+headSize+endSize)
    private static void swapAdjacentBlocks(int arr[], int bias, int oneSize, int anotherSize) {
        reverse(arr, bias, bias + oneSize - 1);
        reverse(arr, bias + oneSize, bias + oneSize + anotherSize - 1);
        reverse(arr, bias, bias + oneSize + anotherSize - 1);
    }

    private static void inplaceMerge(int arr[], int l, int mid, int r)
    {
        int i = l;     // 指示左侧有序串
        int j = mid + 1; // 指示右侧有序串
        while(i < j && j <= r) //原地归并结束的条件。
        {
            while(i < j && arr[i] <= arr[j])
            {
                i++;
            }
            int index = j;
            while(j <= r && arr[j] <= arr[i])
            {
                j++;
            }
            swapAdjacentBlocks(arr, i, index-i, j-index);
            i += (j-index);
        }
    }

    public static void mergeSort(int arr[], int l, int r)
    {
        if(l < r)
        {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            inplaceMerge(arr, l, mid, r);
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+", ");
        }
        System.out.println();
    }

    /* 测试用例 */
    public static void main(String[] args) {
        int[] arr = {3,5,1,7,0,6,9,11};
        mergeSort(arr, 0, arr.length-1);
        print(arr);
    }

}
