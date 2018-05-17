package tc.com.com.task;

import java.util.ArrayList;

/**
 * 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。
 * 采用递归树的思想，当左括号数大于右括号数时可以加左或者右括号，否则只能加左括号，当左括号数达到n时，剩下全部
 */
public class Parenthesis {

    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        getAllBracketCombine(res, "", n, 0, 0);
        return res;
    }

    public void getAllBracketCombine(ArrayList<String> res, String item,int n, int lbc, int rbc){

        if(lbc == n){
            for(int i = 0; i < n-rbc; i++){
                item += ")";
            }
            res.add(item);
            return;
        }
        getAllBracketCombine(res, item + "(", n, lbc + 1, rbc);
        if(lbc > rbc){
            getAllBracketCombine(res, item + ")", n, lbc, rbc + 1);
        }

    }



    public static void main(String[] args){
        Parenthesis p = new Parenthesis();
        ArrayList<String> res = p.generateParenthesis(3);
        res.stream().forEach(System.out::println);
    }

}
