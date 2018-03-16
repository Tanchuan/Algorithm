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


}
