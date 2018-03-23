package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/15.
 */
public class MaximumSubarraySum {

    public static int maximumSubarraySum(int[] arr){
        int max = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = arr[i] + Math.max(0, sum);
            if(max < sum){
                max = sum;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {-2, -1, -1};
        System.out.println(maximumSubarraySum(arr));
    }


}
