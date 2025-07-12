package Questions.TreesAndGraphs;
/*Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.*/

import java.util.*;

public class Q1 {

    static boolean checkRoute(Map<String, List<String>> graph,String start,String end){
        System.out.print(start + " and " + end);
        //TODO:make visited set and queue list
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.add(start);
            while(!queue.isEmpty()){
                //TODO:add current node to queue
                    String current = queue.poll(); //removes and returns the first element

                //TODO:check is its the last : retrun true
                if(current.equals(end)) { return true;}

                //TODO: mark current visited
                if(!visited.contains(current)){
                    visited.add(current);

                    //TODO: check if any neighbouring node : Add to queue
                    List<String> neighbours = graph.getOrDefault(current,new ArrayList<>());
                    for(String neighbour : neighbours){
                        if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                        }
                    }
                }
            }
       return false;

    }


    public static void main(String[] arg){
        //TODO:make a graph
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B","C")); // now you cant modify the list
        graph.put("B", Arrays.asList("D"));
        graph.put("C", new ArrayList<>());
        graph.put("D", Arrays.asList("E"));
        graph.put("E", new ArrayList<>());

        //TODO:call search method
        System.out.println(" Route present: "+checkRoute(graph,"A","E"));
        System.out.println(" Route present: "+checkRoute(graph,"C","E"));
    }

}
