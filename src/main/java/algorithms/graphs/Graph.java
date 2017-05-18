package algorithms.graphs;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Graph {

  private final int V;
  private int E;
  private boolean isDirected;
  private Map<Integer, LinkedHashSet<Integer>> adj;


  public Graph(int V, boolean isDirected) {
    if (V < 0)
      throw new IllegalArgumentException("Number of vertices must be nonnegative");
    this.V = V;
    this.E = 0;
    this.isDirected = isDirected;
    this.adj = new HashMap<>();
    for (int v = 0; v < V; v++) {
      adj.put(v, new LinkedHashSet<Integer>());
    }
  }


  public int V() {
    return V;
  }


  public int E() {
    return E;
  }


  private void validateVertex(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }


  public void addEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    E++;
    adj.get(v).add(w);
    if (!isDirected)
      adj.get(w).add(v);
  }


  public Iterable<Integer> adj(int v) {
    validateVertex(v);
    return adj.get(v);
  }


  public int degree(int v) {
    validateVertex(v);
    return adj.get(v).size();
  }


  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " vertices, " + E + " edges \n");
    for (int v = 0; v < V; v++) {
      s.append(v + ": ");
      for (int w : adj.get(v)) {
        s.append(w + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

}
