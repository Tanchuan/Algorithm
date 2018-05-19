package tc.com.com.task;

import java.util.Stack;

/**
 * 给定入栈序列判断给定出栈序列是否合法
 */
public class StackSeqValid {


    public static boolean validPopSeq(int[] pushSeq, int[] popSeq){
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        while(i < pushSeq.length){
            s.push(pushSeq[i]);
            while(!s.isEmpty() && s.peek() == popSeq[j]){
                s.pop();
                j++;
            }
            i++;
        }
        return i == pushSeq.length && j == i;

    }

    public static void main(String[] args){
        int[] pushSeq = {1, 2, 3, 4, 5};
        int[] popSeq = {4, 5, 3, 2, 1};
        int[] popSeq2 = {4, 5, 3, 1, 2};
        int[] popSeq3 = {4, 5, 1, 3, 2};
        System.out.println(validPopSeq(pushSeq, popSeq));
        System.out.println(validPopSeq(pushSeq, popSeq2));
        System.out.println(validPopSeq(pushSeq, popSeq3));
    }


}
