package tc.com.common;

/**
 * Created by bjtanchuan on 2018/3/8.
 */
public class CommonUtil {


    public static void swap(int[] arr2Sort, int k, int next) {
        int t = arr2Sort[k];
        arr2Sort[k] = arr2Sort[next];
        arr2Sort[next] = t;
    }


}
