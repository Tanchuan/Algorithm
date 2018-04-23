package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/16.
 * 给定字英文符串A，B；判断B中的所有不重复的字符是否被A所包含
 *
 */
public class ChararcterContain {

    public static boolean chararcterContain(String a, String b){
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        long hash = 0;
        for(char c : aChars){
            hash |= (1 << c - 'A');
        }
        for(char c : bChars){
            if((hash & (1 << c - 'A')) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String a = "ABCDEF";
        String b = "ABDEFI";
        System.out.print(chararcterContain(a, b));

    }

}
