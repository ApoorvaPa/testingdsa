import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSP {
    private int[][] distance;
    private int N, start;
    private int[][] memo;
    private int[][] next;
    private final int END_STATE;

    public TSP(int start, int[][] distance) {
        this.distance = distance;
        this.start = start;
        N = distance.length;
        END_STATE = (1 << N) - 1;
        memo = new int[N][1 << N];
        next = new int[N][1 << N];
        for (int[] row : memo) Arrays.fill(row, -1);
        for (int[] row : next) Arrays.fill(row, -1);
    }

    public int findMinCost() {
        return computeMinCost(start, 1 << start);
    }

    private int computeMinCost(int position, int visited) {
        if (visited == END_STATE) return distance[position][start];
        if (memo[position][visited] != -1) return memo[position][visited];

        int minCost = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < N; nextCity++) {
            if ((visited & (1 << nextCity)) == 0) {
                int cost = distance[position][nextCity] + computeMinCost(nextCity, visited | (1 << nextCity));
                if (cost < minCost) {
                    minCost = cost;
                    next[position][visited] = nextCity;
                }
            }
        }
        memo[position][visited] = minCost;
        return minCost;
    }

    public List<Integer> getTour() {
        if (findMinCost() == -1) return null;
        int visited = 1 << start;
        int current = start;
        List<Integer> tour = new ArrayList<>();
        tour.add(start);

        for (int i = 1; i < N; i++) {
            current = next[current][visited];
            tour.add(current);
            visited |= 1 << current;
        }
        tour.add(start);
        return tour;
    }

    public static void main(String[] args) {
        int[][] distanceMatrix = {
                {0, 12, 10, 19, 8},
                {12, 0, 3, 7, 2},
                {10, 3, 0, 6, 20},
                {19, 7, 6, 0, 4},
                {8, 2, 20, 4, 0}
        };
        int startNode = 0;
        TSP tsp = new TSP(startNode, distanceMatrix);
        System.out.println("Tour: " + tsp.getTour());
        System.out.println("Tour cost: " + tsp.findMinCost());
    }
}
