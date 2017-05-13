package algorithms;

import java.util.Scanner;

public class InMobiTest2 {
  static int V;
  static int minDistance(int dist[], Boolean sptSet[]) {
    int min = Integer.MAX_VALUE, min_index = -1;
    for (int v = 0; v < V; v++)
      if (sptSet[v] == false && dist[v] <= min) {
        min = dist[v];
        min_index = v;
      }
    return min_index;
  }

  static int[] dijkstra(int graph[][], int src) {
    int distance[] = new int[V];
    Boolean sptSet[] = new Boolean[V];
    for (int i = 0; i < V; i++) {
      distance[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }
    distance[src] = 0;
    for (int count = 0; count < V - 1; count++) {
      int u = minDistance(distance, sptSet);
      sptSet[u] = true;
      for (int v = 0; v < V; v++)
        if (!sptSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
            && distance[u] + graph[u][v] < distance[v])
          distance[v] = distance[u] + graph[u][v];
    }
    return distance;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    V = s.nextInt();
    int relations = s.nextInt();
    int graph[][] = new int[V][V];
    for (int i = 0; i < relations; i++) {
      int u = s.nextInt();
      int v = s.nextInt();
      graph[u - 1][v - 1] = 1;
      graph[v - 1][u - 1] = 1;
    }
    int queries = s.nextInt();
    for (int i = 0; i < queries; i++) {
      int source = s.nextInt();
      int destination = s.nextInt();
      System.out.println(dijkstra(graph, source - 1)[destination - 1]);
    }
    s.close();
  }
}
