package algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public static void main(String[] args) {
    Graph g = new Graph(4, true);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    BFS(2, g);
  }

  private static void BFS(int start, Graph graph) {
    boolean[] visited = new boolean[graph.V()];
    Queue<Integer> nodes = new LinkedList<>();
    nodes.add(start);
    visited[start] = true;
    while (!nodes.isEmpty()) {
      int in = nodes.poll();
      System.out.print(in + " ");
      Iterator<Integer> iterator = graph.adj(in).iterator();
      while (iterator.hasNext()) {
        int element = iterator.next();
        if (visited[element] == false) {
          nodes.add(element);
          visited[element] = true;
        }
      }
    }
  }
}
