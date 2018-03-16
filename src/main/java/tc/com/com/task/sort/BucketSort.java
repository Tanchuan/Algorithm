package tc.com.com.task.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjtanchuan on 2018/3/15.
 */
public class BucketSort {

    /**
     * 适合数据分布较为均匀，且值在[0,1)的数据排序
     * */
    public static void bucketSort(float[] arr, int bucketNum, int multiplyFactor){
        Map<Integer, Integer> map = new HashMap<>();

        //计算桶中每行数组长度
        for(float a : arr){
            int key = (int) a * multiplyFactor;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        //初始化桶
        float[][] bucket = new float[bucketNum][];
        for(int i = 0; i < bucketNum; i++){
            int len = map.getOrDefault(i, 0);
            if (len > 0) {
                bucket[i] = new float[len];
            }
        }

        //间数据加入到桶中
        for(int i = arr.length - 1; i >= 0; i--){
            float a = arr[i];
            int key = (int) a * multiplyFactor;
            float[] temp = bucket[key];
            int index =  map.get(key);
            temp[index - 1] = a;
            map.put(key, map.get(key) - 1);
        }

        //对桶中每一行数组插入排序
        for(int i = 0; i < bucketNum; i++){
            if(null != bucket[i] && bucket[i].length > 0) {
                InsertSort.insertSort(bucket[i]);
            }
        }

        //把桶中每一行数组连接起来
        for(int i = 0, t = 0; i < bucketNum && t < arr.length; i++){
            float[] temp = bucket[i];
            if(null != bucket[i] && bucket[i].length > 0){
                for(float a :temp){
                    arr[t++] = a;
                }
            }
        }
    }

    public static void  main(String[] args){
        float[] arr = {0.15f, 0.11f, 0.3f, 0.2f, 0.8f, 0.7f,0.66f,0.9f, 0.51f, 0.44f, 0.51f};
        bucketSort(arr, 10, 10);
        for(float a : arr){
            System.out.print("--" + a);
        }
    }


}
