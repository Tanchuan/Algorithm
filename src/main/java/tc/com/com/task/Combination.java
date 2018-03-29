package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/29.
 */
public class Combination {

    /**
     * 从数组arr的起始位置为start中打印出所有长度为m的整数组合
     * */
    public static void combine(int[] arr, int m, int start, int[] result, int resultSize){
        for(int i = start; arr.length - i >= m; i++){
            //选取当前i为结果数组下标为 resultSize-m 的元素
            result[resultSize - m] = arr[i];
            if(m - 1 > 0){
                //从arr的 i+1 位置开始选取 m-1 个整数的全组合
                combine(arr, m - 1, i + 1, result, resultSize);
            } else {
                //当接下来需要选取的组合个数为0时（即 m-1==0 ），打印结果打印结果
                for(int ele : result){
                    System.out.print(" " + ele + " ");
                }
                System.out.println("");
            }
        }
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int[] result = new int[2];
        combine(arr, 2, 0, result, 2);
    }


}
