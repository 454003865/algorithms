package com.main.unit2.unit2_2;

public class Mergesort2 {


    public static void main(String[] args) {
        int[] data = new int[] {26, 53, 67, 48, 57, 48, 32, 60, 50};
        int[] data2 = new int[] {1,23,3,7,5,87,57,45,34,22,14,18,26, 53, 67, 48, 57, 13, 48, 32, 60, 50};


        int[] data5 = new int[] {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};

     //   data2=  mergesort3(Inser2(data2));
        data5= Inser2(data5);
        for (int i:
                data5) {
            System.out.print(i+" ,");
        }
    }
    public static int[] mergesort3(int[] arr){
        int lo=0;
        int mid=arr.length/2;
        int hi=arr.length;

        int i=lo,j=mid+1;
        int[] aux=new int[arr.length];
        for (int k = 0; k <aux.length; k++) {
            aux[k]=arr[k];
        }
        for (int k = 0; k <arr.length ; k++) {
            System.out.println(k+"  现在正在执行的是:  i:"+i+"  j:"+j +" AUX I "+aux[i] +" aux j "+aux[j]);
            if (i>mid) arr[k]=aux[j++];
            else if (j>hi)  arr[k]=aux[i++];
          //  else if (aux[i]>=aux[j]) arr[k]=aux[j++];
            else if (aux[i]>aux[j]) arr[k]=aux[j++];
            else     arr[k]=aux[i++];
        }



        return aux;
    }

    public static  int[] Inser2(int[] arr){
        int temp;
        for (int i = 1; i <arr.length ; i++) {
            //如果正在选择的数字 小于已经排好序的数组最大的一个 也就是ARR[I-1]
            if(arr[i]<arr[i-1]){
                temp=arr[i];

                for (int j = i; j >=0 ; j--) {
                    if (j>0&&arr[j-1]>=temp){
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

}
