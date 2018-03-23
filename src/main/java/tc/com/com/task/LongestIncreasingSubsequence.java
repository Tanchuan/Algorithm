package tc.com.com.task;

import tc.com.common.CommonUtil;

/**
 * Created by bjtanchuan on 2018/3/23.
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {


    public static int lengthOfLIS1(int[] nums) {
        int[] minMaxV = new int[nums.length + 1];
        int[] lenOfSeq = new int[nums.length];
        minMaxV[0] =  CommonUtil.min(nums) - 1;//哨兵

        for(int i = 0; i < nums.length; i++){
            lenOfSeq[i] = 1;
        }
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            for(;j < i; j++){

            }
        }




        return 0;
    }


    public static int lengthOfLIS2(int[] nums) {
        return 0;
    }

    public static void main(String[] args){

    }

}
