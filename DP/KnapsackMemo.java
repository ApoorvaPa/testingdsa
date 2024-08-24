public class KnapsackMemo {

  
    public static int Knapsack(int[] wt, int[] val, int W, int n){


        if(n==0 || W == 0){
            return 0;
        }
        if (wt[n - 1] <= W) {
            return (Math.max(val[n-1]+Knapsack(wt, val, W - wt[n - 1], n - 1), Knapsack(wt, val, W, n - 1)));
        } else {
            return (Knapsack(wt, val, W, n - 1));
        }
    }
    


    public static void main(String[] args) {
        int n = 3;
        int W = 4;
        int[] wt = { 4, 5, 1 };
        int[] val = { 1, 2, 3 };
        System.out.println(Knapsack(wt, val, W, n));


    }

    
}
