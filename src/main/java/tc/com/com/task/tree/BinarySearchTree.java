package tc.com.com.task.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private Node<Integer> root = new Node<>(null);

    public void buildTreeFromArray(int[] arr){
        if (null != arr) {
            for(int val : arr){
                insert(val);
            }
        }
    }

    public Node<Integer> search(int val){
        return searchNode(val, root);
    }

    private Node<Integer> searchNode(int val, Node<Integer> node){
        if(null == node){
            return null;
        }
        if(val < node.value){
            return searchNode(val, node.left);
        } else if(val == node.value){
            return node;
        } else {
            return searchNode(val, node.right);
        }
    }

    private void insert(int val){
        if(root.value == null){
            root.value = val;
            root.n = 1;
            return;
        }
        insertByNode(val, root);

    }

    private List<Node<Integer>> searchByRange(int min, int max){
        List<Node<Integer>> results = new ArrayList<>();
        return results;
    }


    private void insertByNode(int val, Node<Integer> node){
        if(node != null){
            if(node.value > val){
                if(node.left != null){
                    insertByNode(val, node.left);
                } else {
                    Node<Integer> newNode = new Node<>(val);
                    node.left = newNode;
                }
            } else if(node.value < val){
                if(node.right != null){
                    insertByNode(val, node.right);
                } else {
                    Node<Integer> newNode = new Node<>(val);
                    node.right = newNode;
                }
            }
            node.n = (node.left != null ? node.left.n : 0) + (node.right != null ? node.right.n : 0) + 1;
        }
    }

    //求不大于val的最大值
    public Integer floor(int val){
        if(root.value == null){
            return null;
        }
        Node<Integer> node = floor(val, root);
        return node == null ? null : node.value;
    }

    private Node<Integer> floor(int val, Node<Integer> node){
        if(node == null){
            return null;
        } else {
            if(val < node.value){
                return floor(val, node.left);
            }
            if(val == node.value){
                return node;
            }
            Node<Integer> temp = floor(val, node.right);
            return null != temp ? temp : node;
        }
    }

    //求不小于val的最小值
    public Integer ceil(int val){
        if(root.value == null){
            return null;
        }
        Node<Integer> node = ceil(val, root);
        return node == null ? null : node.value;
    }

    private Node<Integer> ceil(int val, Node<Integer> node){
        if(null == node){
            return null;
        }
        if(val > node.value){
            return ceil(val, node.right);
        }
        if(val == node.value){
            return node;
        }
        Node<Integer> temp = ceil(val, node.left);
        return null != temp ? temp : node;
    }

    public Node<Integer> min(){
        if(root.value == null){
            return null;
        }
        Node<Integer> min = root;
        Node<Integer> node = root;
        while(node != null){
            min = node;
            node = node.left;
        }
        return min;
    }

    private Node<Integer> min(Node<Integer> node){
        if(null == node) {
            return null;
        }
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Node<Integer> max(){
        if(root.value == null){
            return null;
        }
        Node<Integer> max = root;
        Node<Integer> node = root;
        while(node != null){
            max = node;
            node = node.right;
        }
        return max;
    }

//    private Node<Integer> delMin(Node<Integer> node){
//        if(node != null){
//            Node<Integer> parent = node;
//            Node<Integer> min = node;
//            while(node != null){
//                parent = min;
//                parent.n--;
//                min = node;
//                node = node.left;
//            }
//            if(parent != min){
//                parent.left = min.right;
//            }
//            min.right = null;
//            return min;
//        }
//        return null;
//    }

    public void delMin(){
        if(root.value == null){
            return;
        }
        root = delMin(root);
    }

    private Node<Integer> delMin(Node<Integer> node){

        if(node.left == null) {
            return node.right;
        }
        node.left = delMin(node.left);
        node.n = (node.left != null ? node.left.n : 0) + (node.right != null ? node.right.n : 0) + 1;
        return node;
    }
    

    public void delete(int val){
        if(root.value == null){
            return;
        }
        root = delete(root, val);
    }

    private Node<Integer> delete(Node<Integer> node, int val){
        if(node == null){
            return null;
        }
        if(val < node.value){
            node.left = delete(node.left, val);
        } else if(val > node.value){
            node.right = delete(node.right, val);
        } else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            Node<Integer> temp = node;
            node = min(node.right);
            node.right = delMin(temp.right);
            node.left = temp.left;
        }
        node.n = (node.left != null ? node.left.n : 0) + (node.right != null ? node.right.n : 0) + 1;
        return node;
    }



    public void preOrderTraverse(){
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node<Integer> node){
        if (null != node) {
            System.out.print(" " + node.value + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void midOrderTraverse(){
        midOrderTraverse(root);
        System.out.println();
    }

    private void midOrderTraverse(Node<Integer> node){
        if (null != node) {
            midOrderTraverse(node.left);
            System.out.print(" " + node.value + " ");
            midOrderTraverse(node.right);
        }
    }


    public int height(){
        if(root.value == null){
            return 0;
        }
        return height(root);
    }

    private int height(Node<Integer> node){
        if(null == node){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 9, 1, 5, 7, 8, 2};
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildTreeFromArray(arr);
        System.out.println(bst.height());
        System.out.println(bst.floor(3));
        System.out.println(bst.ceil(3));
        System.out.println(bst.max().value);
        System.out.println(bst.min().value);
        bst.preOrderTraverse();
        bst.midOrderTraverse();
        bst.delete(3);
        bst.preOrderTraverse();
        bst.midOrderTraverse();
    }

}
