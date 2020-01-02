package com.main.unit2.unit2_4;

public class HeapSortMaxAndMin {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        System.out.println("排序前:");
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+",");
        }

        System.out.println();
        System.out.println("分割线---------------------------------------------------------------------------");
        heapSort(array);       
        System.out.println("排序后:");
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+",");
        }
    }

    private static void heapSort(int[] array) {
        if (array==null||array.length==1)
            return;
        //将数组元素转化为大顶堆/小顶堆
        buildArrayToHeap(array);
        for (int i = array.length-1; i >=1 ; i--) {
            // 经过上面的一些列操作，目前array[0]是当前数组里最大的元素，需要和末尾的元素交换，然后拿出最大的元素
            
            swap(array,0,i);
            /**
             * 交换完后，下次遍历的时候，就应该跳过最后一个元素，也就是最大的那个
             * 值，然后开始重新构建最大堆堆的大小就减去1，然后从0的位置开始最大堆
             */
            
            buildMinHeap(array, i, 0);


        }
    }

    private static void buildMinHeap(int[] array, int heapSieze, int index) {
        int left = index * 2 + 1; // 左子节点
        int right = index * 2 + 2; // 右子节点
        int mimValue = index; // 暂时定在Index的位置就是最小值
        // 如果左子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (left < heapSieze && array[left] < array[mimValue]) {
            mimValue = left;
        }
// 如果右子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (right < heapSieze && array[right] < array[mimValue]) {
            mimValue = right;
        }

        if (mimValue != index) {
            swap(array, index, mimValue); // 就要交换位置元素
            buildMinHeap(array, heapSieze, mimValue);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//构建堆
    private static void buildArrayToHeap(int[] array) {
       if (array==null|| array.length==1)
           return;
       int cursor =array.length/2;

        for (int i = cursor; i >=0 ; i--) {
            buildMinHeap(array, array.length, i);
        }

    }
}
