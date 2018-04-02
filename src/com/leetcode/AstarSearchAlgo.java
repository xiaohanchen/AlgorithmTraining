package com.leetcode;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;


/**
*    A* algorithm: shortest path finder algorithm   DP
*
*    G value: distance between start node and current node (regardless of obstacle)   (N.B. G value is calculated according to VISITED nodes)
*    H value: distance between end node and current node (regardless of obstacle)   (H value is all known in advance)
*    F value: G + H
*
*    1 Find the visited nodes' surrounding nodes with lowest F value to proceed.
*    2 (if there are multiple nodes with the same F, then choose the one with lowest G/H value depends on the algorithm)
*
*    3 when you visitd a node, updates its surrounding nodes
*
*
*    EXTEND: A* algorithm VS dijkstra
*/

public class AstarSearchAlgo{




    /* A* search in 2d array */

    public static void main2(String[] args) {


        /*could move in four direction, shang xia zuo you
         *UPPER LEFT to LOWER RIGHT*/

        /**
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 1 1 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 1 1 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0
         * */




        int[][] graph = {{0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                         {1,1,1,1,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,1,1,1,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                         {0,0,1,1,1,1,1,1,1,1},
                         {0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0}};





    }

    void pathFinder(int[][] graph){

        int xMax = graph[0].length;
        int yMax = graph.length;

        //create 2d array of graph node information
        Set<Node> visitedNodes = new HashSet<>();
        Node[][] visitedNodeGraph = new Node[graph.length][graph[0].length];
        PriorityQueue<Node> queueToExplore = new PriorityQueue<>(100, new Comparator<Node>() {
            @Override
            public int compare(Node i, Node j){
                if(i.f_scores > j.f_scores){
                    return 1;
                }

                else if (i.f_scores < j.f_scores){
                    return -1;
                }

                else{
                    return 0;
                }
            }
        });

        Node start = new Node("start", 9+9);
        start.g_scores = 0;
        start.f_scores = start.g_scores + start.h_scores;
        start.x = 0;
        start.y = 0;
        visitedNodes.add(start);
        visitedNodeGraph[0][0] = start;
        queueToExplore.add(start);

        while(queueToExplore.size() != 0){
            Node currentNode = queueToExplore.remove();

            //UP
            if(currentNode.y - 1 >= 0){
                int x = currentNode.x;
                int y = currentNode.y - 1;
                double hValue = getHvalue(xMax, yMax, x, y);
                double tempG = currentNode.g_scores + 1;
                double tempF = tempG + hValue;


                if(visitedNodeGraph[x][y] != null){
                    //visited
                    Node existNode =visitedNodeGraph[x][y];
                    if(existNode.f_scores > tempF){
                        existNode.f_scores = tempF;
                        existNode.g_scores = tempG;
                        existNode.parent = currentNode;
                    }
                }else{
                    Node newNode = new Node("", hValue);
                    newNode.g_scores = tempG;
                    newNode.f_scores = tempF;
                    newNode.parent = currentNode;
                    queueToExplore.add(newNode);
                    visitedNodeGraph[x][y] = newNode;
                }
            }

            //DOWN
            if(currentNode.y + 1 < yMax){


            }





        }








    }

    private int getHvalue(int xMax, int yMax, int x, int y) {
        return xMax-x + yMax - y;
    }






    /* A* search in node graph */

    //h scores is the stright-line distance from the current city to Bucharest
    public static void main(String[] args){

        //initialize the graph base on the Romania map   n1 start, n13 end
        Node n1 = new Node("Arad",366);     //start
        Node n2 = new Node("Zerind",374);
        Node n3 = new Node("Oradea",380);
        Node n4 = new Node("Sibiu",253);
        Node n5 = new Node("Fagaras",178);
        Node n6 = new Node("Rimnicu Vilcea",193);
        Node n7 = new Node("Pitesti",98);
        Node n8 = new Node("Timisoara",329);
        Node n9 = new Node("Lugoj",244);
        Node n10 = new Node("Mehadia",241);
        Node n11 = new Node("Drobeta",242);
        Node n12 = new Node("Craiova",160);
        Node n13 = new Node("Bucharest",0);     //end
        Node n14 = new Node("Giurgiu",77);

        //initialize the edges

        //Arad
        n1.adjacencies = new Edge[]{
                new Edge(n2,75),
                new Edge(n4,140),
                new Edge(n8,118)
        };

        //Zerind
        n2.adjacencies = new Edge[]{
                new Edge(n1,75),
                new Edge(n3,71)
        };


        //Oradea
        n3.adjacencies = new Edge[]{
                new Edge(n2,71),
                new Edge(n4,151)
        };

        //Sibiu
        n4.adjacencies = new Edge[]{
                new Edge(n1,140),
                new Edge(n5,99),
                new Edge(n3,151),
                new Edge(n6,80),
        };


        //Fagaras
        n5.adjacencies = new Edge[]{
                new Edge(n4,99),

                //178
                new Edge(n13,211)
        };

        //Rimnicu Vilcea
        n6.adjacencies = new Edge[]{
                new Edge(n4,80),
                new Edge(n7,97),
                new Edge(n12,146)
        };

        //Pitesti
        n7.adjacencies = new Edge[]{
                new Edge(n6,97),
                new Edge(n13,101),
                new Edge(n12,138)
        };

        //Timisoara
        n8.adjacencies = new Edge[]{
                new Edge(n1,118),
                new Edge(n9,111)
        };

        //Lugoj
        n9.adjacencies = new Edge[]{
                new Edge(n8,111),
                new Edge(n10,70)
        };

        //Mehadia
        n10.adjacencies = new Edge[]{
                new Edge(n9,70),
                new Edge(n11,75)
        };

        //Drobeta
        n11.adjacencies = new Edge[]{
                new Edge(n10,75),
                new Edge(n12,120)
        };

        //Craiova
        n12.adjacencies = new Edge[]{
                new Edge(n11,120),
                new Edge(n6,146),
                new Edge(n7,138)
        };

        //Bucharest
        n13.adjacencies = new Edge[]{
                new Edge(n7,101),
                new Edge(n14,90),
                new Edge(n5,211)
        };

        //Giurgiu
        n14.adjacencies = new Edge[]{
                new Edge(n13,90)
        };

        AstarSearch(n1,n13);

        List<Node> path = printPath(n13);

        System.out.println("Path: " + path);


    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();

        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }

    public static void AstarSearch(Node source, Node goal){

        Set<Node> explored = new HashSet<Node>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
                new Comparator<Node>(){
                    //override compare method
                    public int compare(Node i, Node j){
                        if(i.f_scores > j.f_scores){
                            return 1;
                        }

                        else if (i.f_scores < j.f_scores){
                            return -1;
                        }

                        else{
                            return 0;
                        }
                    }

                }
        );

        //cost from start
        source.g_scores = 0;

        queue.add(source);

        boolean found = false;

        while((!queue.isEmpty())&&(!found)){

            //the node in having the lowest f_score value
            Node current = queue.poll();

            explored.add(current);

            //goal found
            if(current.value.equals(goal.value)){
                found = true;
            }

            //check every child of current node
            for(Edge e : current.adjacencies){
                Node child = e.target;
                double cost = e.cost;
                double temp_g_scores = current.g_scores + cost;
                double temp_f_scores = temp_g_scores + child.h_scores;


                                /*if child node has been evaluated and
                                the newer f_score is higher, skip*/

                if((explored.contains(child)) &&
                        (temp_f_scores >= child.f_scores)){     //decide if we need to update the f value
                    continue;
                }

                /*else if child node is not in queue or
                newer f_score is lower*/
                else if((!queue.contains(child)) || (temp_f_scores < child.f_scores)){

                    child.parent = current;
                    child.g_scores = temp_g_scores;
                    child.f_scores = temp_f_scores;

                    if(queue.contains(child)){    //visited on the way
                        queue.remove(child);
                    }  //INTERESTING remove then add, so refresh the queue!

                    queue.add(child);

                }

            }

        }

    }

}



class Node{

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;
    public int x;
    public int y;

    public Node(String val, double hVal){
        value = val;
        h_scores = hVal;
    }

    public String toString(){
        return value;
    }

}

class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
        target = targetNode;
        cost = costVal;
    }
}








