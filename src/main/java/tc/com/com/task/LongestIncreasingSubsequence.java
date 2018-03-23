package tc.com.com.task;

import tc.com.common.CommonUtil;

/**
 * Created by bjtanchuan on 2018/3/23.
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {


    public static int lengthOfLIS1(int[] nums) {
        if(null == nums || nums.length <= 0){
            return 0;
        }
        int[] minMaxV = new int[nums.length + 1];
        int[] lenOfSeq = new int[nums.length];
        minMaxV[0] =  CommonUtil.min(nums) - 1;//哨兵
        minMaxV[1] =  nums[0];

        for(int i = 0; i < nums.length; i++){
            lenOfSeq[i] = 1;
        }

        int maxLen = 1;
        for(int i = 1; i < nums.length; i++){
            int j = maxLen;
            for(;j >= 0; j--){
                if(nums[i] > minMaxV[j]){
                    lenOfSeq[i] = j + 1;
                    break;
                }
            }

            if(lenOfSeq[i] > maxLen){
                maxLen = lenOfSeq[i];
                minMaxV[lenOfSeq[i]] = nums[i];
            } else if (nums[i] > minMaxV[j] && nums[i] < minMaxV[j + 1]){
                minMaxV[j + 1] = nums[i];
            }
        }
        return maxLen;
    }


    public static int lengthOfLIS2(int[] nums) {
        if(null == nums || nums.length <= 0){
            return 0;
        }
        int maxIndex = -1;
        int maxLen = 1;
        int[] prev = new int[nums.length];
        int[] lengths = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            lengths[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && lengths[j] + 1 > lengths[i]){
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if(lengths[i] > maxLen){
                maxLen = lengths[i];
                maxIndex = i;
            }
        }

        int leftCount = maxLen;
        for(; leftCount > 0; maxIndex = prev[maxIndex], leftCount--){
            System.out.print(" " + nums[maxIndex]);
        }
        System.out.println();
        return maxLen;
    }

    public static void main(String[] args){
        int[] arr = {1, -1, 2, -3, 4, -5, 6, -7};
        System.out.println(lengthOfLIS1(arr));
        System.out.println(lengthOfLIS2(arr));
    }

}
