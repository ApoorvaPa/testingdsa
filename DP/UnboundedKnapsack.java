public class UnboundedKnapsack {

    public static int Knapsack(int[] wt,int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                //valid
                if (wt[i - 1] <= j) {
                    //include
                    int incprofit = val[i - 1] + dp[i][j - wt[i - 1]];
                    int excprofit = dp[i - 1][j];
                    dp[i][j] = Math.max(incprofit, excprofit);
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
        System.out.println(Knapsack(wt,val,W));
    }

}
