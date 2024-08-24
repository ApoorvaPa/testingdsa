import java.util.*;

public class LongestIncSub {
    
    public static int LIS(int[] arr1, int[] arr2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);

                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] arr1 = { 50, 3, 10, 7, 40, 80 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);

        }
        int[] arr2 = new int[set.size()];
        int s=0;
        for (int element : set) {
            arr2[s] = element;
            s++;

        }
        System.out.println(LIS(arr1,arr2,arr1.length,arr2.length));

    }
    
}
