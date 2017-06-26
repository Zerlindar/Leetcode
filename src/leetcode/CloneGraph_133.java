package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongfeng on 17/5/10.
 */
public class CloneGraph_133 {


    private Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null == node){
            return null;
        }
        if(null != map.get(node)){
            return map.get(node);
        }
        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(node.label);
        List<UndirectedGraphNode> neighbors = new ArrayList<>();
        undirectedGraphNode.neighbors = neighbors;
        map.put(node,undirectedGraphNode);
        if(null == node.neighbors || 0  == node.neighbors.size()){
            undirectedGraphNode.neighbors = node.neighbors;
        }else{
            for(UndirectedGraphNode neighbor : node.neighbors){
                neighbors.add(cloneGraph(neighbor));
            }
            undirectedGraphNode.neighbors = neighbors;
        }
        return undirectedGraphNode;
    }

    /*
     if(!node) return NULL;
        if(hash.count(node)) return hash[node];
        hash[node] = new UndirectedGraphNode(node->label);
        for(auto val: node->neighbors)
            hash[node]->neighbors.push_back(cloneGraph(val));
        return hash[node];
     */


    class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }


}

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 */
