package tc.com.com.task;

import tc.com.common.CommonUtil;

/**
 * Created by bjtanchuan on 2018/4/23.
 */
public class Permutation {


    public static void permutation(char[] arr){
        printPermutation(arr, 0, arr.length - 1);
    }

    public static void printPermutation(char[] arr, int from, int to){
        if(from == to){
            System.out.println(String.valueOf(arr));
        }
        for(int i = from; i <= to; i++){
            CommonUtil.swap(arr, from, i);
            printPermutation(arr, from + 1, to);
            CommonUtil.swap(arr, from, i);
        }

    }

    public static void main(String[] args){
        String a = "ABC";
        permutation(a.toCharArray());

    }

}
