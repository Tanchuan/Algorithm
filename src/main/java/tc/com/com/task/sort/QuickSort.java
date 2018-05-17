package tc.com.com.task.sort;

import tc.com.common.CommonUtil;

/**
 * Created by bjtanchuan on 2018/3/8.
 */
public class QuickSort {

    public static int pattition(int[] arr2Sort, int lo, int hi) {
        int temp = arr2Sort[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            while (i <= hi && arr2Sort[i] < temp) i++;
            while (j > lo && arr2Sort[j] > temp) j--;
            if (j > i) {
                CommonUtil.swap(arr2Sort, i, j);
            } else {
                break;
            }
        }
        if (j > lo) {
            CommonUtil.swap(arr2Sort, lo, j);
        }
        return j;
    }

    public static int pattition2(int[] arr2Sort, int lo, int hi) {
        int temp = arr2Sort[hi];
        int i = lo - 1;
        int j = lo;
        while (j < hi) {
            if(arr2Sort[j] < temp){
                CommonUtil.swap(arr2Sort, ++i, j);
            }
            j++;
        }
        ++i;
        CommonUtil.swap(arr2Sort, i, hi);
        return i;
    }

    public static void quickSort(int[] arr2Sort, int lo, int hi) {
        if (lo < hi) {
            int midVal = pattition2(arr2Sort, lo, hi);
            quickSort(arr2Sort, lo, midVal - 1);
            quickSort(arr2Sort, midVal + 1, hi);
        }
    }


    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 9, 5, 1, 11};
//        quickSort(arr, 0, 6);
        int[] arr = {4, 3};
        quickSort(arr, 0, 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }


}
