
public class FinalKnap {


    public static int Knapsack(int[] wt, int[] val, int W, int n, int[][] dp) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return (dp[n][W]);
        }

        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + Knapsack(wt, val, W - wt[n - 1], n - 1, dp);
            int ans2 = Knapsack(wt, val, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = Knapsack(wt, val, W, n - 1, dp);
            return dp[n][W];
        }
        
    }


    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };
        int W = 7;
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
                
                
            }
        }
        System.out.println(Knapsack(wt, val, W, n, dp));
        
    }
    
}
