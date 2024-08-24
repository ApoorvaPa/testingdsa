public class TargetSum {

    public static boolean TargetSum(int[] arr, int sum) {
        int n = arr.length;
        int s = sum;
        boolean[][] dp = new boolean[n + 1][s + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                int v = arr[i - 1];
                //include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;

                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }

                //exclude

            }
        }
        return (dp[n][s]);

    }
    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(TargetSum(arr,sum));
    }
}