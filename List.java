import java.util.*;
import java.io.*;
public class List{
    static HashMap<Integer,List<Integer>> graph=new HashMap<>();
    static  void addEdge(int u,int v ,boolean direction){
      if(!graph.containsKey(u)){
        graph.put(u,new ArrayList<>());
      }
      graph.get(u).add(v);
      if(!direction){
         if(!graph.containsKey(v)){
        graph.put(v,new ArrayList<>());
      }
      graph.get(v).add(u);
      }
    }
    static void dfs(int start){
      Stack<Integer> s1=new Stack<>();
      Map<Integer,Boolean> visited=new HashMap<>();
      s1.push(start);
      visited.put(start,true);
      while (! s1.isEmpty()) {
          int u=s1.pop();
          System.out.println(u+",");
          for(int neibour : graph.get(u)){
               if(!visited.getOrDefault(neibour, false)){
                  s1.push(neibour);
                  visited.put(neibour,true);
               }
          }
      }
  }
  static void bfs(int start){
    Queue<Integer> q1=new LinkedList<>();
    Map<Integer,Boolean> visited=new HashMap<>();
    q1.add(start);
    visited.put(start,true);
    while (! q1.isEmpty()) {
        int u=q1.poll();
        System.out.println(u+",");
        for(int neibour : graph.get(u)){
             if(!visited.getOrDefault(neibour, false)){
                q1.add(neibour);
                visited.put(neibour,true);
             }
        }
    }

  }
    public static void main(String[] args) {
        addEdge(1, 2, false);
         addEdge(2, 3, true);
      dfs(1);
        
    }
}