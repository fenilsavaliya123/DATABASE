import java.util.*;

class Graph {
    HashMap<Integer, ArrayList<Integer>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public void add(int u, int v, boolean direction) {
        if (!map.containsKey(u)) {
            map.put(u, new ArrayList<>());
        }
        map.get(u).add(v);
        
        if (!direction) {
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
    }

    public void BFS(int start){
        Queue<Integer> q1 = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        q1.add(start);
        visited.put(start, true);
        while(!q1.isEmpty()){
            int u = q1.poll();
            System.out.println(u+" ");
            for(int Neighbour : map.get(u)){
                if(!visited.getOrDefault(Neighbour, false)){
                    q1.add(Neighbour);
                    visited.put(Neighbour, true);
                }
            }
        }
    }
}

public class GraphImplement {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add(1, 2, false);
        graph.add(1, 5, true);
        graph.add(2, 3, false);
        graph.add(3, 4, true);
        graph.add(1, 2, false);
        graph.BFS(1);
    }
}
