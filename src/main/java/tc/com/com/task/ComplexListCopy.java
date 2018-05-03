package tc.com.com.task;

/**
 * Created by bjtanchuan on 2018/5/3.
 */
public class ComplexListCopy {

    static class Node {
        int val;
        Node next;
        Node sibling;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("value = " + val);
            sb.append(", next = " + (next == null ? "null" : next.val));
            sb.append(", sibling = " + (sibling == null ? "null" : sibling.val));
            return sb.toString();
        }
    }

    static void copyNext(Node head){
        if(head == null ){
            return;
        }

        while(head != null){
            Node cNode = new Node();
            cNode.val = head.val;
            cNode.next = head.next;
            head.next = cNode;
            head = cNode.next;
        }

    }

    static void copySibling(Node head){
        if(head == null ){
            return;
        }
        while(head != null){
            Node cNode = head.next;
            if (null != head.sibling) {
                cNode.sibling = head.sibling.next;
            }
            head = cNode.next;
        }
    }

    static Node divideList(Node head){
        if(head == null ){
            return null;
        }
        Node cHead = head.next;
        while(head != null){
            Node cNode = head.next;
            head.next = cNode.next;
            head = cNode.next;
            if (null != head) {
                cNode.next = head.next;
            }
        }
        return cHead;
    }

    static Node copy(Node head){
        copyNext(head);
        copySibling(head);
        return divideList(head);
    }

    public static void main(String[] args){
        Node head = new Node();
        head.val = 1;

        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;

        Node node4 = new Node();
        node4.val = 4;

        Node node5 = new Node();
        node5.val = 5;

        head.next = node2;
        head.sibling = node3;

        node2.next = node3;
        node2.sibling = node5;

        node3.next = node4;

        node4.next = node5;
        node4.sibling = node2;

        Node node  = copy(head);

        while(node != null){
            System.out.println(node);
            node = node.next;
        }
    }


}
