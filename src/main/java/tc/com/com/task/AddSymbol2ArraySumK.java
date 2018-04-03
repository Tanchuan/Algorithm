package tc.com.com.task;

/**
 * 给数组每一个元素添加正负号，使其和为指定值
 */
public class AddSymbol2ArraySumK {

    private int[] symbols;//1 加, -1 减
    private int[] nums;
    private int M;

    public AddSymbol2ArraySumK(int[] nums, int M) {
        this.nums = nums;
        this.M = M;
        this.symbols = new int[nums.length];
    }

    public boolean generateSymbol(int index, int sum) {
        if (index > 0) {
            if (generateSymbol(index - 1, sum - nums[index])) {
                symbols[index] = 1;
                return true;
            } else if (generateSymbol(index - 1, sum + nums[index])) {
                symbols[index] = -1;
                return true;
            } else {
                return false;
            }
        } else if (index == 0) {
            if (nums[index] == sum) {
                symbols[index] = 1;
                return true;
            } else if (nums[index] == -sum) {
                symbols[index] = -1;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int[] getResult(){

        if(generateSymbol(nums.length - 1, M)){
            return symbols;
        } else {
            return null;
        }
    }

    public int[] getSymbols() {
        return symbols;
    }

    public void setSymbols(int[] symbols) {
        this.symbols = symbols;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public static void main(String[] args) {
        AddSymbol2ArraySumK sumK = new AddSymbol2ArraySumK(new int[]{1, 2, 3}, 8);
        int[] symbols = sumK.getResult();
        if(null == symbols){
            System.out.println("搜索失败");
        } else {
            for (int ele : symbols) {
                System.out.print(" " + ele + " ");
            }
        }
    }


}
