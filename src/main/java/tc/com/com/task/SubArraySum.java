package tc.com.com.task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjtanchuan on 2018/3/9.
 */
public class SubArraySum {

    public static int subArraySumEqualSppecifiedValueCount1(int[] nums, int k){
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(k == sum){
                //若刚好加和为k则计数器加一
                count++;
            }
            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int subArraySumEqualSppecifiedValueCount2(int[] nums, int k){
        int count = 0;
        for(int start = 0; start < nums.length; start++){
            int sum = 0;
            for(int end = start ; end < nums.length; end++){
                sum += nums[end];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {0,0,0,0,0,0,0,0,0,0};
        System.out.print(subArraySumEqualSppecifiedValueCount1(nums, 0));
    }

}
