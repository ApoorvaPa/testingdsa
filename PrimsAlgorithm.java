import java.util.*;

public class PrimsAlgorithm {
    private static int stepCounter = 0;
    private static int count = 0;

    public static void primsAlgorithm(int[][] graph) {
        int V = graph.length;
        count++;
        int[] parent = new int[V]; 
        count++;
        int[] key = new int[V];
        count++;
        boolean[] mstSet = new boolean[V];
        count++;

        Arrays.fill(key, Integer.MAX_VALUE);
        count++;
        key[0] = 0; 
        count++;
        parent[0] = -1; 
        count++;

        for (int count = 0; count < V - 1; count++) {
            count++;
            int u = minKey(key, mstSet);
            count++;
            mstSet[u] = true;
            count++;

            for (int v = 0; v < V; v++) {
                count++;
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    count++;
                    parent[v] = u;
                    count++;
                    key[v] = graph[u][v];
                    count++;
                    stepCounter++; 
                    count++;
                }

            }
            count++;
        }

        printMST(parent, graph);
        count++;
    }

    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        count++;
        for (int v = 0; v < key.length; v++) {
            count++;
            if (!mstSet[v] && key[v] < min) {
                count++;
                min = key[v];
                count++;
                minIndex = v;
                count++;
            }
        }
        count++;
        count++;
        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            count++;
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }count++;
    }

    public static void main(String[] args) {
                 int graph[][] = new int[][] {
    { 0, 10, 6, 5 },
    { 10, 0, 0, 15 },
    { 6, 0, 0, 4 },
    { 5, 15, 4, 0 }
                 };
count++;
primsAlgorithm(graph);
        count++;
        System.out.println("Total steps in Prim's algorithm: " + stepCounter);
        System.out.println("Final Count Value "+count);
    }
}