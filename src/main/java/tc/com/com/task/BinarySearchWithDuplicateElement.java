package tc.com.com.task;

/**
 * Created by Administrator on 2018/5/19 0019.
 */
public class BinarySearchWithDuplicateElement {

    public static void binarySearchWithDuplicateElement(int[] arr, int element) {
        int begin = findFirstPos(arr, element);
        int end;
        if (begin >= 0) {
            end = findLastPos(arr, element);
        } else {
            System.out.println("找不到" + element + "元素!");
            return;
        }
        System.out.println("begin index=" + begin + "; end index= " + end);
    }

    public static void binarySearchWithDuplicateElementRec(int[] arr, int element) {
        int begin = findFirstPosRec(arr, element, 0, arr.length - 1);
        int end;
        if (begin >= 0) {
            end = findLastPosRec(arr, element, 0, arr.length - 1);
        } else {
            System.out.println("recurv, 找不到" + element + "元素!");
            return;
        }
        System.out.println("recurv, begin index=" + begin + "; end index= " + end);
    }

    private static int findFirstPos(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (end > start) {
            if (arr[mid] < element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        if (arr[start] == element) {
            return start;
        } else if(end < arr.length - 1 && arr[end + 1] == element) {
            return end + 1;
        } else {
            return -1;
        }
    }

    private static int findFirstPosRec(int[] arr, int element, int start, int end){
        if(start == end) {
            return arr[start] == element ? start : -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == element) {
            int re = findFirstPosRec(arr, element, start, mid - 1);
            return re != -1 ? re : mid;
        } else if(arr[mid] > element) {
            return findFirstPosRec(arr, element, start, mid - 1);
        } else {
            return findFirstPosRec(arr, element, mid + 1, end);
        }
    }

    private static int findLastPosRec(int[] arr, int element, int start, int end){
        if(start == end) {
            return arr[start] == element ? start : -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == element) {
            int re = findLastPosRec(arr, element, mid + 1, end);
            return re != -1 ? re : mid;
        } else if(arr[mid] > element) {
            return findLastPosRec(arr, element, start, mid - 1);
        } else {
            return findLastPosRec(arr, element, mid + 1, end);
        }
    }


    private static int binarySearch(int[] arr, int element, int start, int end){
        int mid = (start + end) / 2;
        while (start < end) {
            if(arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    private static int findLastPos(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (end > start) {
            if (arr[mid] > element) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        if (arr[end] == element){
            return end;
        } else if(start >= 1 && arr[start - 1] == element){
            return start - 1;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 2, 4, 5, 5, 5};
        binarySearchWithDuplicateElement(arr, 2);
        binarySearchWithDuplicateElementRec(arr, 2);
        binarySearchWithDuplicateElement(arr, 5);
        binarySearchWithDuplicateElementRec(arr, 5);
        binarySearchWithDuplicateElement(arr, 6);
        binarySearchWithDuplicateElementRec(arr, 6);
        int[] arr1 = {1, 2, 3};
        binarySearchWithDuplicateElement(arr1, 2);
        binarySearchWithDuplicateElementRec(arr1, 2);

    }

}
