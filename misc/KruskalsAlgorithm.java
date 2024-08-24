import java.util.*;

public class KruskalsAlgorithm {
    private static int stepCounter = 0; 
    private static int count = 0; 
    private static List<Edge> mst = new ArrayList<>(); 
    static {
        count++;
    }
    
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            count++;
            return this.weight - compareEdge.weight;  
        } 
    }

    static class Subset {
        int parent, rank;
    }

    public static int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) 
        {count++; 
            subsets[i].parent = find(subsets, subsets[i].parent); 
            count++;
        }
            count++;  
        return subsets[i].parent;  
    }

    public static void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x); 
        count++;
        int yroot = find(subsets, y); 
        count++;

        if (subsets[xroot].rank < subsets[yroot].rank) 
        {
            count++;
            
            subsets[xroot].parent = yroot; 
            count++;}
        else if (subsets[xroot].rank > subsets[yroot].rank) 
        {
            count++;
            subsets[yroot].parent = xroot;
            count++;
         }
         else 
        {
            count++;
            
            subsets[yroot].parent = xroot;
            count++;
            subsets[xroot].rank++;
            count++;
        }
    }

    public static void kruskalsAlgorithm(Edge[] edges, int V) {
        Arrays.sort(edges);
        count++;
        Subset[] subsets = new Subset[V];
        count++;
        for (int v = 0; v < V; ++v) {
            count++;
            subsets[v] = new Subset();
            count++;
            subsets[v].parent = v;
            count++;
            subsets[v].rank = 0;
            count++;
        }count++;

        for (Edge edge : edges) {
            count++;
            int x = find(subsets, edge.src);
            count++;
            int y = find(subsets, edge.dest);
            count++;

            if (x != y) {
                count++;
                union(subsets, x, y);
                count++;
                mst.add(edge);
                count++;
                stepCounter++; 
                count++;
            }
        }count++;

        printMST();count++;
    }

    private static void printMST() {
        System.out.println("Edge \tWeight");
        for (Edge edge : mst) {
            count++;
            System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
        }count++;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        count++;
        KruskalsAlgorithm.Edge[] edges = new KruskalsAlgorithm.Edge[5];
count++;
edges[0] = new KruskalsAlgorithm.Edge();
count++;
edges[0].src = 0;
count++;
edges[0].dest = 1;
count++;
edges[0].weight = 10;
count++;

edges[1] = new KruskalsAlgorithm.Edge();
count++;
edges[1].src = 0;
count++;
edges[1].dest = 2;
count++;
edges[1].weight = 6;
count++;

edges[2] = new KruskalsAlgorithm.Edge();
count++;
edges[2].src = 0;
count++;
edges[2].dest = 3;
count++;
edges[2].weight = 5;
count++;

edges[3] = new KruskalsAlgorithm.Edge();
count++;
edges[3].src = 1;
count++;
edges[3].dest = 3;
count++;
edges[3].weight = 15;
count++;

edges[4] = new KruskalsAlgorithm.Edge();
count++;
edges[4].src = 2;
count++;
edges[4].dest = 3;
count++;
edges[4].weight = 4;
count++;

kruskalsAlgorithm(edges, V);
        count++;
        System.out.println("Total steps in Kruskal's algorithm: " + stepCounter);
        System.out.println("Final Count value "+count);
    }
}