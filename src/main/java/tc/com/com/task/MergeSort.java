package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/9.
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            System.out.println("start="+ start + ";end=" + end + "; mid=" + mid);
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, end, mid);
        }
    }


    public static void merge(int[] arr, int[] temp, int start, int end, int mid) {
        if (end > start) {
            int i = start, j = mid + 1, t = start;
            for (; i <= mid && j <= end && t < end; ) {
                if (arr[i] <= arr[j]) {
                    temp[t++] = arr[i++];
                } else {
                    temp[t++] = arr[j++];
                }
            }
            while (i <= mid) {
                temp[t++] = arr[i++];
            }
            while (j <= end) {
                temp[t++] = arr[j++];
            }
            for (; start <= end; start++) {
                arr[start] = temp[start];
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 2, 12, 9, 6};
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


}
