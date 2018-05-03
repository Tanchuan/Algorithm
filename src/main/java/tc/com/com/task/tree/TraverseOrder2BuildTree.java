package tc.com.com.task.tree;

/**
 * 根据中后序确定前序
 */
public class TraverseOrder2BuildTree {

    private Integer current = 0;

    public void findPre(char[] mid, char[] post, int fm, int lm, int fp, int lp, char[] result){
        if(null == mid || mid.length != post.length) return;
        if(fm <= lm){
            result[current++] = post[lp];
        } else {
            return;
        }
        int rootPosInMid = findPos(mid, post[lp]);
        if(rootPosInMid < 0){
            System.out.println("出错了, rootPosInMid=" + rootPosInMid);
            return;
        }
        int leftLength = rootPosInMid - fm;
        //左子树
        findPre(mid, post, fm, rootPosInMid - 1, fp, fp + leftLength - 1, result);
        //右子树
        findPre(mid, post, rootPosInMid + 1,  lm, fp + leftLength, lp - 1, result);

    }

    int findPos(char[] arr, char ele){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ele){
                return i;
            }
        }
        return  -1;
    }

    public static void main(String[] args){
        char[] mid = {'D', 'B', 'E', 'A', 'F', 'C'};
        char[] post = {'D', 'E', 'B', 'F', 'C', 'A'};
        char[] result = new char[mid.length];
        new TraverseOrder2BuildTree().findPre(mid, post, 0, mid.length - 1, 0, post.length - 1, result);
        for(char c : result){
            System.out.print(" " + c);
        }

    }


}
