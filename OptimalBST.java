public class OptimalBST {
    public static double optimalBST(int keys[], double freq[], int n) {
        double cost[][] = new double[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i][i] = freq[i - 1];
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 1; i <= n - L + 1; i++) {
                int j = i + L - 1;
                cost[i][j] = Double.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    double c = ((r > i) ? cost[i][r - 1] : 0) +
                               ((r < j) ? cost[r + 1][j] : 0) +
                               sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[1][n];
    }
    private static double sum(double freq[], int i, int j) {
        double s = 0;
        for (int k = i; k <= j; k++) {
            if (k <= freq.length)
                s += freq[k - 1];
        }
        return s;
    }

    public static void main(String[] args) {
        int keys[] = {10, 20, 30, 40, 50};
        double freq[] = {0.1, 0.2, 0.4, 0.2, 0.1};
        int n = keys.length;

        System.out.println("Cost of Optimal BST is " + optimalBST(keys, freq, n));
    }
}