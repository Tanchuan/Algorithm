package tc.com.com.task.sort.external;

import tc.com.common.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjtanchuan on 2018/3/27.
 * 多路归并, 逆序数组（从大到小排列）
 */
public class MuliMergeSort {

    private static final int MIN = Integer.MIN_VALUE;
    private int size;
    private int[] nodeIterator;
    private int[] tree;
    private int[] node;
    private int[][] arrays;

    public MuliMergeSort(int[][] arrays) {
        this.arrays = arrays;
        this.size = arrays.length;
        nodeIterator = new int[size];
        tree = new int[size];
        node = new int[size];
        for (int i = 0; i < size; i++) {
            put(i);
        }
        int winner = CommonUtil.maxIndex(node);
        for (int i = 0; i < size; i++) {
            tree[i] = winner;
        }
        buildLoserTree();
    }

    private int get(int index) {
        return node[index];
    }

    private void put(int index) {
        if (nodeIterator[index] >= arrays[index].length) {
            node[index] = MIN;
        } else {
            node[index] = arrays[index][nodeIterator[index]++];
        }
    }

    private void adjust(int index) {
        int parent = (size + index) / 2;
        while (parent > 0) {

            if (get(index) < get(tree[parent])) {
                int temp = index;
                index = tree[parent];
                tree[parent] = temp;
            }
            parent /= 2;
        }
        tree[0] = index;
    }

    private void buildLoserTree() {
        for (int i = size - 1; i >= 0; i--) {
            adjust(i);
        }
    }

    //添加前k个元素到结果列表
    public List<Integer> getMultiMergeSort() {
        List<Integer> result = new ArrayList<>();
        while (true) {
            if (get(tree[0]) == MIN) {
                break;
            }
            result.add(get(tree[0]));
            put(tree[0]);
            adjust(tree[0]);
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] arrays = new int[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                arrays[i][j] = (2 - j) * 5 + i;
                System.out.print("arrays[" + i + "][" + "j]= " + arrays[i][j] + " ");
            }
            System.out.println("");
        }

        MuliMergeSort sortObj = new MuliMergeSort(arrays);
        for (int val : sortObj.getMultiMergeSort()) {
            System.out.print(" " + val);
        }
        System.out.println("");

    }


}
