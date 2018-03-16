package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/15.
 */
public class CountSort {

    /**
     * 待排序数组的值不能太大，且需要为正值（可以将负值通过加一个相同的正数转化为正值），否则浪费太多空间
     * */
    public static void countsort(int[] arr, int[] result, int upper){
        int[] count = new int[upper];

        for(int i = 0; i < arr.length; i++){
            count[arr[i]] += 1;
        }
        for(int i = 1; i < upper; i++){
            count[i] = count[i] + count[i - 1];
        }

        //从后往前处理是为了保证排序的稳定性
        for(int i = arr.length - 1; i >= 0; i--){
            result[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

    }

    public static void main(String[] args){
        int[] arr = {9, 8,6,6,6,4,3,1};
        int[] result = new int[arr.length];
        countsort(arr, result, 11);
        for(int a : result){
            System.out.print(" " + a);
        }
    }


}
