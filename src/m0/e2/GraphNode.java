package m0.e2;

import  java.util.Set;

public class GraphNode {

    private final XOField node;

    private final Set<GraphNode> children;


    public GraphNode(final XOField node, Set<GraphNode> children) {
        this.children = children;
        this.node = node;
    }

    public XOField getNode() {
        return node;
    }

    public Set<GraphNode> getChildren() {
        return children;
    }
}
