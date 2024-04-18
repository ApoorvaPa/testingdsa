public class FloydWarshall {
    final static int INF = 99999; 

    void floydWarshall(int graph[][], int V) {
        int distance[][] = new int[V][V];

        // A_0 as distance matrix
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                distance[i][j] = graph[i][j];

        // Compute shortest paths
        for (int k = 0; k < V; k++) { 
            for (int i = 0; i < V; i++) { 
                for (int j = 0; j < V; j++) { 
                    // Update distance[i][j] if shorter path from i to j through k exists
                    if (distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }

        printSolution(distance, V);
    }

    void printSolution(int distance[][], int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (distance[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        // int graph[][] = { {0,5,9,INF},
        //                   {INF, 0, 1, INF},
        //                   {INF, INF, 0, 2},
        //                   {INF, 3, INF, 0}
        //                 };
              int graph[][] = { {0,INF,-2,INF},
                          {4, 0, INF, INF},
                          {INF, INF, 0, 2},
                          {INF, -1, INF, 0}
                        };
        FloydWarshall a = new FloydWarshall();

        int V = 4;

        a.floydWarshall(graph, V);
    }
}
