package tc.com.sp.datastructure;

import tc.com.common.DirectedEdge;

public class SPDirectedWeightedEdge implements DirectedEdge {

    private final int v;
    private final int w;
    private final double weight;

    public SPDirectedWeightedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return 0;
    }

    public int to() {
        return 0;
    }
}
