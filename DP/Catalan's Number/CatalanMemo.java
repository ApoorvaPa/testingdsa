import java.util.Arrays;

public class CatalanMemo {

    
    public static int Catalans(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        
        int sum = 0;
        
        for (int i = 0; i <= n - 1; i++) {
            sum += Catalans(i,dp) * Catalans(n - i - 1,dp);

        }
            
        return dp[n] = sum;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(Catalans(n,dp));
    }


    
}
