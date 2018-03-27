package tc.com.com.task.sort.external;

import tc.com.common.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjtanchuan on 2018/3/27.
 * 多路归并, 逆序数组（从大到小排列）
 */
public class MuliMergeSort {

    private int size;
    private int[] nodeIterator;
    private int[] tree;
    private int[] node;
    private int[][] arrays;

    public MuliMergeSort(int[][] arrays){
        this.arrays = arrays;
        this.size = arrays.length;
        nodeIterator = new int[size];
        tree = new int[size];
        node = new int[size];
        for(int i = 0; i < size; i++){
            node[i] = arrays[i][0];
        }
        int winner = CommonUtil.maxIndex(node);
        for(int i = 0; i < size; i++){
            tree[i] = winner;
        }
    }

    private int get(int index){
        return node[index];
    }

    private void put(int index){
        node[index] = arrays[index][nodeIterator[index]++];
    }

    private void adjust(int index){
        int parent = (size + index)/2;
        while(parent > 0){

            if(get(index) < get(tree[parent])){
                int temp = index;
                index = parent;
                tree[parent] = temp;
            }
            parent /= 2;
        }
        tree[0] = index;
    }

    private void buildLoserTree(){

    }

    public List<Integer> multiMergeSort(){
        List<Integer> result = new ArrayList<>();
        return result;
    }


}
