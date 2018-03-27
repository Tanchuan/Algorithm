package tc.com.common;

/**
 * Created by bjtanchuan on 2018/3/8.
 */
public class CommonUtil {


    public static void swap(int[] arr2Sort, int k, int j) {
        int t = arr2Sort[k];
        arr2Sort[k] = arr2Sort[j];
        arr2Sort[j] = t;
    }

    public static int min(int[] arr){
        int min = arr[0];
        for(int ele : arr){
            if(ele < min){
                min = ele;
            }
        }
        return min;
    }

    public static int max(int[] arr){
        int max = arr[0];
        for(int ele : arr){
            if(ele > max){
                max = ele;
            }
        }
        return max;
    }

    public static int maxIndex(int[] arr){
        int max = 0;
        for(int i = 1; i < arr.length; i++){
            int ele = arr[i];
            if(ele > arr[max]){
                max = i;
            }
        }
        return max;
    }

    public static int minIndex(int[] arr){
        int min = 0;
        for(int i = 1; i < arr.length; i++){
            int ele = arr[i];
            if(ele < arr[min]){
                min = i;
            }
        }
        return min;
    }


}
