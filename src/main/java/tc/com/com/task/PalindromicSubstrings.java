package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/3/6.
 */
public class PalindromicSubstrings {

    //自己的版本，马拉车算法实现
    public static int countSubstrings(String s) {
        char[] arr = new char[2 * s.length() + 3];
        arr[0] = '^';
        arr[1] = '#';
        arr[arr.length - 1] = '$';
        int index = 2;
        for (char c : s.toCharArray()) {
            arr[index++] = c;
            arr[index++] = '#';
        }
        int center=0;
        int right=0;
        int maxCenter=0;
        int maxRadius=0;
        int[] p= new int[arr.length];
        p[0] = 1;
        p[p.length - 1] = 1;
        for(int i = 1; i < arr.length - 1; i++) {
            p[i] = i < right ? Math.min(right - i, p[2*center - i]) : 1;
            while(arr[i + p[i]] == arr[i - p[i]]){
                p[i]++;
            }
            if(p[i] + i > right){
                center = i;
                right = p[i] + i;
            }
            if(maxRadius < p[i]){
                maxCenter = i;
                maxRadius = p[i];
            }
        }
        int ret = 0;
        for(int len : p){
            ret += len/2;
        }
        int beginIndex = (maxCenter-maxRadius)/2;
        int endIndex = beginIndex + maxRadius - 1;
        String maxSubPalindromicString = s.substring(beginIndex, endIndex);

        System.out.println("s=" + s);
        System.out.print("arr=");
        for(char c : arr){
            System.out.print(c+":");
        }
        System.out.println("\n----");
        System.out.print("p=");
        for(int c : p){
            System.out.print(c+":");
        }
        System.out.println("\n----");
        System.out.println("maxSubPalindromicString=" + maxSubPalindromicString);
        return ret;
    }

    //网上别人的版本
    public static int countSubstrings2(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }


    public static void main(String[] args){
        String testStr = "abaaba";
        System.out.println(countSubstrings2(testStr));
        System.out.println(countSubstrings(testStr));

    }

}
