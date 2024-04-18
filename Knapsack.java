public class Knapsack{

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapsack(int W, int[] weight, int[] value, int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If the weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (weight[n - 1] > W)
            return knapsack(W, weight, value, n - 1);

        else
            return Math.max(value[n - 1] + knapsack(W - weight[n - 1], weight, value, n - 1),
                            knapsack(W, weight, value, n - 1));
    }

    public static void main(String args[]) {
        int[] value = new int[] { 60, 100, 120 };
        int[] weight = new int[] { 10, 20, 30 };
        int W = 50;
        int n = value.length;
        
        System.out.println("Total value in the knapsack = " + knapsack(W, weight, value, n));
    }
}
