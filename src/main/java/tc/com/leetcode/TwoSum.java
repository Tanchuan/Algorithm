package tc.com.leetcode;

import java.util.HashMap;


public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < l; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = map.get(target - nums[i]);
                if(i != j) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
