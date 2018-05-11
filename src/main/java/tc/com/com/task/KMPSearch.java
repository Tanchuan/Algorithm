package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/5/11.
 */
public class KMPSearch {

    private int[] next(char[] pattern) {
        int[] next = new int[pattern.length];
        int j = 0;
        int k = -1;
        next[0] = -1;

        while (j < pattern.length - 1) {
            if (k == -1 || pattern[j] == pattern[k]) {
                k++;
                j++;
                if (pattern[j] != pattern[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int kmpSearch(char[] s, char[] p) {
        int[] next = next(p);
        int i = 0;
        int j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }

        }
        if (j == p.length) {
            return i - j;
        }
        return -1;
    }


    public static void main(String[] args) {
        KMPSearch k = new KMPSearch();
        char[] s = "abdabcabaabi".toCharArray();
        char[] p = "abi".toCharArray();

        int i = k.kmpSearch(s, p);
        int end = i + p.length;
        for (; i < end; i++) {
            System.out.println("s[" + i + "]=" + s[i]);
        }

    }


}
