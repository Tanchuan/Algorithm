package tc.com.com.task.tree;

/**
 * Created by bjtanchuan on 2018/4/2.
 */
public class Node<T> {

    public Node<T> left;
    public Node<T> right;
    public int n;//节点数目
    public T value;

    public Node(T value) {
        this.value = value;
        this.n = 1;
    }


    public String toString(){
        return "[tree node, n = " + n + "; value = " + value + "]";
    }

}
