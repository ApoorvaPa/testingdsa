public class RecuKnap {

    public static int Knapsack(int[] wt, int[] val, int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }
        if (wt[i-1] <= W) {
            int ans1 = val[i-1] + Knapsack(wt, val, W - wt[i-1], i - 1);
            int ans2 = Knapsack(wt, val, W, i - 1);
            return(Math.max(ans1, ans2));
        } else {
            return (Knapsack(wt, val, W, i - 1));
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
