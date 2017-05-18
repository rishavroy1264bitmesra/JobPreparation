package algorithms.graphs;

public class DFS {
  public static void main(String[] args) {
    Graph g = new Graph(4, false);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Following is DFS: ");
    DFS(g, 2);
  }

  private static void DFS(Graph graph, int start) {
    boolean visited[] = new boolean[graph.V()];
    DFSUtils(graph, visited, start);
  }

  private static void DFSUtils(Graph graph, boolean[] visited, int start) {
    if (visited[start] == false) {
      System.out.print(start + " ");
      visited[start] = true;
    } else {
      return;
    }
    for (Integer in : graph.adj(start)) {
      DFSUtils(graph, visited, in);
    }
  }
}
