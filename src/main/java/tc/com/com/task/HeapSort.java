package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/8.
 */
public class HeapSort {


    public static void heapSort(int[] arr2Sort){
        System.out.println("排序前的数组");
        for(int a : arr2Sort){
            System.out.print(" " + a);
        }
        // 建堆
        for(int i = arr2Sort.length/2 - 1; i >= 0; i--){
            adjustHeap(arr2Sort, i, arr2Sort.length);
        }

        // 排序
        for(int n = arr2Sort.length - 1 ; n > 0; n--){
            swap(arr2Sort, 0, n);
            adjustHeap(arr2Sort, 0, n);
        }

        System.out.println("\n排序后的数组");
        for(int a : arr2Sort){
            System.out.print(" " + a);
        }

    }

    //堆节点调整
    private static void adjustHeap(int[] arr2Sort, int k, int length){
        int temp = arr2Sort[k];
        int next = 2 * k + 1;
        while(next < length){
            if(next + 1 < length && arr2Sort[next] < arr2Sort[next + 1]){
                next++;
            }
            if(arr2Sort[next] > temp){
                swap(arr2Sort, k, next);
                k = next;
                next = 2* next + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] arr2Sort, int k, int next) {
        int t = arr2Sort[k];
        arr2Sort[k] = arr2Sort[next];
        arr2Sort[next] = t;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 9, 5};
        heapSort(arr);
    }

}
