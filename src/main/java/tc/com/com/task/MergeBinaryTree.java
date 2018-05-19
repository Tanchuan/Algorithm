package tc.com.com.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by bjtanchuan on 2018/3/9.
 */
public class MergeBinaryTree {

    public TreeNode mergeBinaryTree(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }
        TreeNode t3 = new TreeNode(0);

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2, t3});
        while (!stack.isEmpty()) {
            TreeNode temp = null;
            TreeNode[] nodes = stack.pop();
            boolean bothExists = false;
            if (nodes[0] == null) {
                temp = nodes[1];
            } else if (nodes[1] == null) {
                temp = nodes[0];
            } else {
                bothExists = true;
            }
            if (bothExists) {
                nodes[2].val = nodes[0].val + nodes[1].val;
                if (null != nodes[0].left || null != nodes[1].left) {
                    nodes[2].left = new TreeNode(0);
                    stack.push(new TreeNode[]{nodes[0].left, nodes[1].left, nodes[2].left});
                }

                if (null != nodes[0].right || null != nodes[1].right) {
                    nodes[2].right = new TreeNode(0);
                    stack.push(new TreeNode[]{nodes[0].right, nodes[1].right, nodes[2].right});
                }
            } else {
                temp = safeCopy(temp);
                if (null != temp) {
                    nodes[2].val = temp.val;
                    nodes[2].left = temp.left;
                    nodes[2].right = temp.right;
                }
            }
        }
        return t3;
    }

    private TreeNode safeCopy(TreeNode node) {
        if (null != node) {
            TreeNode res = new TreeNode(node.val);
            res.left = safeCopy(node.left);
            res.right = safeCopy(node.right);
            return res;
        } else {
            return null;
        }
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //从数组建树（链表）
    public TreeNode buildTreeFromArr(Integer[] arr) {
        TreeNode root = null;
        if (null != arr) {
            TreeNode[] nodes = new TreeNode[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (null != arr[i]) {
                    TreeNode node = new TreeNode(arr[i]);
                    nodes[i] = node;
                } else {
                    nodes[i] = null;
                }
            }
            for (int i = 0; i < nodes.length / 2; i++) {
                TreeNode node = nodes[i];
                int left = 2 * i + 1;
                if (left < nodes.length && null != nodes[left]) {
                    node.left = nodes[left];
                }
                int right = 2 * i + 2;
                if (right < nodes.length && null != nodes[right]) {
                    node.right = nodes[right];
                }
            }
            root = nodes[0];
        }
        return root;
    }

    //层序遍历
    public void visitLevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int current = 1;
        int next = 0;
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + " ");
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                next++;
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                next++;
            }
            current--;
            if(current==0){
                current=next;
                next=0;
                height++;
            }
        }
        System.out.print(" end \n");
        System.out.println("height =" + height);

    }

    public static void main(String[] args) {
        MergeBinaryTree instance = new MergeBinaryTree();
        Integer[] a = {1, 3, 2, 5};
        TreeNode t1 = instance.buildTreeFromArr(a);
        instance.visitLevelOrder(t1);
        Integer[] b = {2, 1, 3, null, 4, null, 7};
        TreeNode t2 = instance.buildTreeFromArr(b);
        instance.visitLevelOrder(t2);

        TreeNode t3 = instance.mergeBinaryTree(t1, t2);
        instance.visitLevelOrder(t3);

    }

}
