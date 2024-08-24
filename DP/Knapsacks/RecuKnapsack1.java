public class RecuKnapsack1 {

    public static int Knapsack(int[] wt, int[] val, int W, int n) {
        
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + Knapsack(wt, val, W - wt[n - 1], n - 1);
            int ans2 = Knapsack(wt, val, W, n - 1);
            return (Math.max(ans1, ans2));
        } else {
            return (Knapsack(wt, val, W, n - 1));
        }
    }


    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] val = { 15, 14, 10, 45, 30 };
        int W = 7;
        int n = val.length;

        System.out.println(Knapsack(wt, val, W, n));
    }
    
}
