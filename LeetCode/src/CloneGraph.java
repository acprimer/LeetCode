import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Clone Graph
 * Link: https://oj.leetcode.com/problems/clone-graph/
 * Description:
 * -----------------------------
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * ---First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * ---Second node is labeled as 1. Connect node 1 to node 2.
 * ---Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * -----------------------------
 *
 * Tag: Hash DFS
 */


// Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class CloneGraph {
    int cnt = 0;
    Map<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
    List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }
        dfsNode(node);
        cnt = 0;
        dfsLink(node);
        return list.get(0);
    }

    // copy each link between two nodes
    private void dfsLink(UndirectedGraphNode node) {
        UndirectedGraphNode copyNode = list.get(cnt++);
        map.put(copyNode, 0);
        for(UndirectedGraphNode child : node.neighbors) {
            UndirectedGraphNode copyChild = list.get(map.get(child));
            copyNode.neighbors.add(copyChild);
            if(child == node || map.get(copyChild) != null) continue;
            dfsLink(child);
        }
    }

    // copy each node with label
    private void dfsNode(UndirectedGraphNode node) {
        map.put(node, cnt++);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        list.add(copyNode);
        for(UndirectedGraphNode child : node.neighbors) {
            if(child == node || map.get(child) != null) continue;
            dfsNode(child);
        }
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        UndirectedGraphNode node4 = new CloneGraph().cloneGraph(node0);
        dfsPrint(node4);
    }

    private static void dfsPrint(UndirectedGraphNode node) {
        System.out.print(node.label);
        for(UndirectedGraphNode child : node.neighbors) {
            if(child == node) continue;
            dfsPrint(child);
        }
    }
}
