public class KnapsackTab {

    public static int Knapsack(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int w = wt[i - 1];
                int v = val[i - 1];
                if (w <= j) {
                    int inc = v + dp[i - 1][j - w];
                    int exc = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exc);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

    
        return dp[n][W];

    }

    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };
        int W = 7;

        System.out.println(Knapsack(wt, val, W));
    }
    
}
