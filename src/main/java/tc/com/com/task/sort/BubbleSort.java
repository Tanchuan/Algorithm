package tc.com.com.task.sort;

import static tc.com.common.CommonUtil.swap;

/**
 * Created by bjtanchuan on 2018/3/16.
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i > 0; i--){
            boolean flag = true;
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    flag = false;
                    swap(arr, j, j+1);
                }
            }
            if(flag){
                return;
            }
        }
    }

    public static void  main(String[] args){
        int[] arr = {5,4,3,-2,1,0,-1};
        bubbleSort(arr);
        for(int a : arr){
            System.out.print(" " + a);
        }
    }
}
