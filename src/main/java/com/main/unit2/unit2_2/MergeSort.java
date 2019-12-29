package com.main.unit2.unit2_2;

import com.main.unit2.unit2_1.InsertSort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] data = new int[] {26, 53, 67, 48, 57, 48, 32, 60, 50};
        int[] data2 = new int[] {1,23,3,7,5,87,57,45,34,22,14,18,26, 53, 67, 48, 57, 13, 48, 32, 60, 50};


        int[] data5 = new int[] {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};

         int[] endarr= new int[data.length+data2.length];
        data=Inser2(data);
        data2=Inser2(data2);
        int[] endarr2= new int[data.length+data2.length];
        data=  mergesort2(data);
        for (int i:
        data) {
            System.out.println(i);
        }
/**
 *  插入排序后 归并排序
 */
        System.out.println(data.length+"   "+Arrays.toString(data));
        System.out.println(data2.length+"   "+Arrays.toString(data2));
            int datanum=0;
            int data2num=0;

        for (int i = 0; i <endarr.length ; i++) {

           if(datanum==data.length){
                endarr[i]=data2[data2num];
                data2num++;
            }else if (data2num==data2.length){
                endarr[i]=data[datanum];
                datanum++;
            }else if(data[datanum]>data2[data2num]&&(datanum!=data.length)&&(data2num!=data2.length)){
                endarr[i]=data2[data2num];
                data2num++;

            } else {
                endarr[i]=data[datanum];
                datanum++;
            }
            System.out.println(i+"|||"+datanum+"|||"+data2num+"|||"+Arrays.toString(endarr));

        }
        System.out.println("最后的结果为"+Arrays.toString(endarr));
    }

    public static int[] Insert(int[] arr){

          //  int[] data1 = new int[] {26, 53, 67, 48, 57, 13, 48, 32, 60, 50,458,789,657,157,358,489,4,87,21,54,8566,12312,54754,2342366,547};
             int[] data = arr;
            int j = 0;
        System.out.println("最开始的排序顺序 ");
        for (int qwe: arr) {
            System.out.print("    "+qwe);
        }
        System.out.println(" ");
            for (int i = 1; i <data.length ; i++) {
                //被选择的那位数
                int temp = data[i];
                System.out.println("");
                System.out.print("temp:"+temp+"  "+i+" data排序顺序前为:");
                for (int qwe: data) {
                    System.out.print("    "+qwe);
                }
                System.out.println();
                for (int k = i; k >=0 ; k--) {
                //   System.out.println(i+"|"+k+"|"+temp+"|"+data[k]);
                    /**
                     * 如果发现插入排序之后 大于最后一个数的
                     * 则最后的那个数 插入那个K值的位置 而K值的位置并且之后 的位置都往后退一个数
                     * 也就是K到i的范围  所有值的顺序都等于+1
                     */
                     if (temp<=data[k]){
                         System.out.println(temp+"|||"+data[k]+"k:"+k);
                          for (int j1= k ; j1 <= i; j1++) {

                             data[j1]=data[j1-1];

                          }

                          data[k]=temp;
                       break;
                      }
                }
                System.out.println("");
                System.out.print(i+" data排序顺序后为:");
                for (int qwe: data) {
                    System.out.print("    "+qwe);
                }
            }

        for (int i = 0; i <data.length ; i++) {
            System.out.println("data:  "+data[i]);
        }


            return data;
    }

    public static  int[] Inser2(int[] arr){
     int temp;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<arr[i-1]){
                temp=arr[i];

                for (int j = i; j >=0 ; j--) {
                    if (j>0&&arr[j-1]>temp){
                        arr[j]=arr[j-1];
                    }else {
                        arr[j]=temp;
                        break;
                    }

                }

            }
        }

return arr;


    }

    public static int [] insertSort(int [] array){
        for(int out=1;out<array.length;out++){
            int temp = array[out];//被标记的值或者说是当前需要插入的值
            int in = out;
//如果轮循值大于被标记值则往后移

//            while( in > 0 && temp < array[in - 1]){
//                array[in] = array[in - 1];
//                in -- ;
//            }
            while( in > 0 && temp < array[in - 1]){
                array[in] = array[in - 1];
                in -- ;
            }
//将被标记值插入最终移出的空位置
            array[in] = temp;
        }

        return array;
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
            int i=lo ,j=mid+1;
//        Comparable[] aux= new Comparable[];
//        for (int k = 0; k <=hi ; k++)
//            aux[k]=a[k];
//        for (int k = 0; k <=hi ; k++) {
//            if (i>mid) a[k]=aux[j++];
//           // else if (j>hi)
//        }
            
    }
    public int[] mergesort(int[] arr,int lo,int mid,int hi){


        return null;
    }
    public static int[] mergesort2(int[] arr){
        int lo=0;
        int mid=arr.length/2;
        int hi=arr.length;

        int i=lo,j=mid+1;
        int[] aux=new int[arr.length];
        for (int k = 0; k <aux.length; k++) {
            aux[k]=arr[k];
        }
        for (int k = 0; k <arr.length ; k++) {
            if (i>mid) arr[k]=aux[j++];
            else if (j>hi)  arr[k]=aux[i++];
            else if (aux[i]>aux[j]) arr[k]=aux[j++];
            else     arr[k]=aux[i++];
        }



        return aux;
    }

}
