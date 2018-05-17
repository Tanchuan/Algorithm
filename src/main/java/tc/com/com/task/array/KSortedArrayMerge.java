package tc.com.com.task.array;

import tc.com.common.CommonUtil;

/**
 * K个有序数组的合并
 */
public class KSortedArrayMerge {

    private int[][] arr;
    private Integer total;
    private int[] heap;
    private int[] index;
    private int n;

    public KSortedArrayMerge(int[][] arr, Integer total) {
        this.arr = arr;
        this.total = total;
        this.n = arr.length;
        this.heap = new int[n];
        for(int i = 0; i < n; i++){
            heap[i] = i;
        }
        this.index = new int[n];
        buildHeap();
    }

    public int[] arrayMerge(){
        if(null != arr) {
            int count = 0;
            int[] result = new int[total];
            while(count < total){
                result[count] = arr[heap[0]][index[0]];
                if(index[0] < arr[heap[0]].length - 1){
                    index[0]++;
                } else {
                    CommonUtil.swap(heap, 0, n-1);
                    CommonUtil.swap(index, 0, n-1);
                    n--;
                }
                adjust(0);
                count++;
            }
            return result;
        }
        return null;
    }

    private void buildHeap(){
        for(int i = n/2; i >= 0; i--){
            adjust(i);
        }
    }

    private void adjust(int i){
        int child = i * 2 + 1;
        while(child < n){
            int current = arr[heap[i]][index[i]];
            int val = arr[heap[child]][index[child]];
            if(child + 1 < n &&  arr[heap[child + 1]][index[child + 1]] < val){
                val = arr[heap[child + 1]][index[child + 1]];
                child += 1;
            }
            if(current > val){
                CommonUtil.swap(heap, i, child);
                CommonUtil.swap(index, i, child);
            }
            i = child;
            child = i * 2 + 1;
        }
    }

    public static void main(String[] args){
        int[][] arr = {
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };

        KSortedArrayMerge kSortedArrayMerge = new KSortedArrayMerge(arr, 9);
        int[] res = kSortedArrayMerge.arrayMerge();
        for(int e : res){
            System.out.println(e);
        }
    }




}
