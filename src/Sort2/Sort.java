package Sort2;


import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] arr={2,5,3,7,8};
        System.out.println(Arrays.toString(arr));
        //QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("基数排序:");
        RadixSort (arr);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] BubbleSort(int[] arr){
        int temp;
        int len=arr.length;
        boolean flag=false;

        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;i++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }else{
                flag=false;
            }
        }
        return arr;

    }


    public static int[] SelectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minindex=j;
                }

            }
            if(minindex!=i){
                arr[minindex]=arr[i];
                arr[i]=min;

            }
        }
            return arr;

    }

    public static int[] InsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int insertval=arr[i];
            int insertindex=i-1;
            while(insertindex>0&&insertval<arr[insertindex]){
                arr[insertindex+1]=arr[insertindex];
                insertindex=insertindex-1;
            }
            if((insertindex+1)!=i)
            arr[insertindex+1]=insertval;

        }
        return arr;
    }
    public static int[] ShellSort1(int[] arr){
        //交换法   太慢了
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j=j-gap){
                    if(arr[j]>arr[j+gap]){
                        int temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
        return arr;
    }
    public static int[] ShellSort2(int[] arr){
        //移动法
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                    int j=i;
                    int temp=arr[j];
                    if(arr[j]<arr[j-gap]){
                     while(j-gap>=0&&arr[j-gap]>temp){
                         arr[j]=arr[j-gap];
                         j-=gap;
                     }
                     arr[j]=temp;

                    }
            }
        }
        return arr;
    }


    public static void QuickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        int temp=0;
        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l>r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if(arr[r]==pivot)
            {
                l++;
            }
            if(arr[l]==pivot){
                r--;
            }
            if(l==r){
                l++;
                r--;
            }
        if(left<l){
            QuickSort(arr,left,r);
            }
        if(right>r){
            QuickSort(arr,l,right);
        }


        }
    }
//归并排序


    public static void MergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            MergeSort(arr,left,mid,temp);
            MergeSort(arr,mid+1,right,temp);
            MergeSort(arr,left,mid,right,temp);
        }

    }
    public static void MergeSort(int[] arr,int left,int mid,int right,int[] temp) {
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            if(arr[i]>=arr[j]){
                temp[t]=arr[j];
                j++;
                t++;
            }
            else{
                temp[t]=arr[j];
                i++;
                t++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while(j<=mid){
            temp[t]=arr[j];
            j++;
            t++;
        }
        t=0;
        int tempLeft=left;
        while(tempLeft<right){
            arr[tempLeft]=temp[t];
            tempLeft++;
            t++;
        }

    }

    public static void RadixSort(int[] arr){
        int max=arr[0];
        int maxLenght=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        while(max>1){
            max=max/10;
            maxLenght++;
        }
        int length=arr.length;

         int bucket[][]=new int[10][length];
         int count[]=new int[10];
         int digital;
         for(int i=1,n=1;i<=maxLenght;i++,n*=10){
             for(int temp:arr){
                 digital=(temp/n)%10;
                 bucket[digital][count[digital]++]=temp;
             }
             int k=0;
             for(int b=0;b<10;b++){
                if(count[b]!=0){
                 for(int w=0;w<count[b];w++){
                     arr[k++]=bucket[b][w];
                 }
                }
                count[b]=0;
             }

         }
}
}


