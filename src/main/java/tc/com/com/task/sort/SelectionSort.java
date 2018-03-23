package tc.com.com.task.sort;

import static tc.com.common.CommonUtil.swap;

/**
 * Created by bjtanchuan on 2018/3/16.
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }

    }

    public static void  main(String[] args){
        int[] arr = {5,4,3,-2,1,0,-1};
        selectionSort(arr);
        for(int a : arr){
            System.out.print(" " + a);
        }
    }

}
