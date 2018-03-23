package tc.com.com.task.sort;

/**
 * Created by bjtanchuan on 2018/3/16.
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            for(; j > 0 && arr[j - 1] > temp; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void insertSort(float[] arr){
        for(int i = 1; i < arr.length; i++){
            float temp = arr[i];
            int j = i;
            for(; j > 0 && arr[j - 1] > temp; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void  main(String[] args){
        int[] arr = {5,4,3,-2,1,0,-1};
        insertSort(arr);
        for(int a : arr){
            System.out.print(" " + a);
        }
    }

}
