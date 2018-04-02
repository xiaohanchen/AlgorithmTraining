package com.leetcode;

import java.util.*;

public class CloneUndirectedGraph {


    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);

        node1.neighbors.add(node1);
        node1.neighbors.add(node1);

        cloneGraph(node1);
    }



    static Set<UndirectedGraphNode> visitedNodes = new HashSet<>();
    static HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }

        if(visitedNodes.contains(node)){
            return map.get(node);
        }
        visitedNodes.add(node);

        UndirectedGraphNode cloneNode;
        if(map.containsKey(node)) {
            cloneNode = map.get(node);
        }else{
            cloneNode = new UndirectedGraphNode(node.label);
            map.put(node, cloneNode);
        }

        for(UndirectedGraphNode neighbor : node.neighbors){
            if(!visitedNodes.contains(neighbor)){
                UndirectedGraphNode clonedNeighbor = cloneGraph(neighbor);
                cloneNode.neighbors.add(clonedNeighbor);
            }else{
                cloneNode.neighbors.add(map.get(neighbor));
            }
        }

        return cloneNode;
    }



    static class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
    }
}
