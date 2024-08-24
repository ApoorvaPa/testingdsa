// // // // // public class OBST {
// // // // //     // Function to calculate the cost of optimal BST with successful and unsuccessful searches
// // // // //     static double optimalBST(double[] p, double[] q, int n) {
// // // // //         // Create a cost matrix to store the dynamic programming subproblems
// // // // //         double[][] e = new double[n+2][n+1];
// // // // //         // Create a weight matrix to sum up probabilities
// // // // //         double[][] w = new double[n+2][n+1];

// // // // //         // Initialize e and w for the cases where the tree contains 0 keys
// // // // //         for (int i = 1; i <= n + 1; i++) {
// // // // //             e[i][i-1] = 0;
// // // // //             w[i][i-1] = q[i];
// // // // //         }

// // // // //         // Compute the cost of optimal BSTs containing keys from i to j
// // // // //         for (int len = 1; len <= n; len++) { // len is the number of keys
// // // // //             for (int i = 1; i <= n - len + 1; i++) { // i is the starting key
// // // // //                 int j = i + len - 1; // j is the ending key
// // // // //                 e[i][j] = Double.MAX_VALUE;
// // // // //                 w[i][j] = w[i][j-1] + p[j] + q[j];

// // // // //                 // Find the optimal root for keys between i and j
// // // // //                 for (int r = i; r <= j; r++) {
// // // // //                     double t = e[i][r-1] + e[r+1][j] + w[i][j];
// // // // //                     if (t < e[i][j]) {
// // // // //                         e[i][j] = t;
// // // // //                     }
// // // // //                 }
// // // // //             }
// // // // //         }

// // // // //         // The cost of the optimal BST is at e[1][n]
// // // // //         return e[1][n];
// // // // //     }

// // // // //     public static void main(String[] args) {
// // // // //         double[] p = {0, 0.1, 0.15, 0.15, 0.1};
// // // // //         double[] q = {0.1, 0.2, 0.05, 0.05, 0.1};
// // // // //         int n = p.length - 1;

// // // // //         System.out.println("Cost of Optimal BST is " + optimalBST(p, q, n));
// // // // //     }
// // // // // }
// // // // public class OBST {

// // // //     static double optimalBST(double[] p, double[] q, int n) {
// // // //         // Create a cost matrix to store the dynamic programming subproblems
// // // //         double[][] e = new double[n + 2][n + 1];
// // // //         // Create a weight matrix to sum up probabilities
// // // //         double[][] w = new double[n + 2][n + 1];

// // // //         // Initialize for the cases where the tree contains 0 keys
// // // //         for (int i = 0; i <= n; i++) {
// // // //             int j = i;
            
// // // //             e[i][i] = 0;
// // // //             w[i][i] = q[j];
// // // //         }

// // // //         // Compute the cost and weights of optimal BSTs containing keys from i to j
// // // //         for (int len = 1; len <= n; len++) {
// // // //             for (int i = 0; i <= n - len; i++) {
// // // //                 int j = i + len;
// // // //                 e[i][j] = Double.MAX_VALUE;
// // // //                 w[i][j] = w[i][j - 1] + p[j] + q[j];

// // // //                 // Find the optimal root for keys between i and j
// // // //                 for (int r = i + 1; r <= j; r++) {
// // // //                     double t = e[i][r - 1] + e[r][j] + w[i][j];
// // // //                     if (t < e[i][j]) {
// // // //                         e[i][j] = t;
// // // //                     }
// // // //                 }
// // // //             }
// // // //         }

// // // //         // The cost of the optimal BST is at e[0][n]
// // // //         return e[0][n];
// // // //     }

// // // //     public static void main(String[] args) {
// // // //         double[] p = {0, 0.1, 0.15, 0.15, 0.1}; // Including a dummy 0 at start for alignment
// // // //         double[] q = {0.1, 0.2, 0.05, 0.05, 0.1, 0}; // Including a dummy 0 at end to align with p's length
// // // //         int n = p.length - 1;

// // // //         System.out.println("Cost of Optimal BST is " + optimalBST(p, q, n));
// // // //     }
// // // // }
// // // public class OBST {

// // //     static double optimalBST(double[] p, double[] q, int n) {
// // //         double[][] e = new double[n + 2][n + 1];
// // //         double[][] w = new double[n + 2][n + 1];

// // //         for (int i = 0; i <= n; i++) {
// // //             e[i][i] = q[i];
// // //             w[i][i] = q[i];
// // //         }

// // //         for (int len = 1; len <= n; len++) {
// // //             for (int i = 0; i <= n - len; i++) {
// // //                 int j = i + len;
// // //                 e[i][j] = Double.MAX_VALUE;
// // //                 w[i][j] = w[i][j - 1] + p[j] + q[j];

// // //                 for (int r = i + 1; r <= j; r++) {
// // //                     double t = e[i][r - 1] + e[r][j] + w[i][j];
// // //                     if (t < e[i][j]) {
// // //                         e[i][j] = t;
// // //                     }
// // //                 }
// // //             }
// // //         }

// // //         return e[0][n];
// // //     }

// // //     public static void main(String[] args) {
// // //         double[] p = {0, 0.1, 0.15, 0.15, 0.1}; 
// // //         double[] q = {0.1, 0.2, 0.05, 0.05, 0.1, 0}; 
// // //         int n = p.length-1;

// // //         System.out.println("Cost of Optimal BST is " + optimalBST(p, q, n));
// // //     }
// // // }
// // public class OBST {
// //     // Function to calculate the cost of optimal BST with successful and unsuccessful searches
// //     static double optimalBST(double[] p, double[] q, int n) {
// //         // Create a cost matrix to store the dynamic programming subproblems
// //         double[][] e = new double[n+2][n+1];
// //         // Create a weight matrix to sum up probabilities
// //         double[][] w = new double[n+2][n+1];
// //         // Create a root matrix to store the roots of the subtrees
// //         int[][] root = new int[n+1][n+1];

// //         // Initialize e and w for the cases where the tree contains 0 keys
// //         for (int i = 0; i <= n; i++) {
// //             e[i][i] = q[i];
// //             w[i][i] = q[i];
// //         }

// //         // Compute the cost of optimal BSTs containing keys from i to j
// //         for (int len = 1; len <= n; len++) { // len is the number of keys
// //             for (int i = 0; i <= n - len; i++) { // i is the starting key
// //                 int j = i + len; // j is the ending key
// //                 e[i][j] = Double.MAX_VALUE;
// //                 w[i][j] = w[i][j-1] + p[j] + q[j];

// //                 // Find the optimal root for keys between i and j
// //                 for (int r = i; r < j; r++) {
// //                     double t = e[i][r] + e[r+1][j] + w[i][j];
// //                     if (t < e[i][j]) {
// //                         e[i][j] = t;
// //                         root[i][j] = r;
// //                     }
// //                 }
// //             }
// //         }

// //         // The cost of the optimal BST is at e[0][n]
// //         return e[0][n];
// //     }

// //     public static void main(String[] args) {
// //         double[] p = {0, 0.1, 0.15, 0.15, 0.1};
// //         double[] q = {0.1, 0.2, 0.05, 0.05, 0.1, 0.1};
// //         int n = p.length - 1;

// //         System.out.println("Cost of Optimal BST is " + optimalBST(p, q, n));
// //     }
// // // }
// public class OBST {
//     public static double optimalCost(double[] p, double[] q) {
//         int n = p.length;
//         double[][] cost = new double[n + 1][n + 1];
//         double[][] weight = new double[n + 1][n + 1];

        
//         for (int i = 0; i < n; i++) {
//             int j = i;
//             weight[i][i] = q[j];
//             cost[i][i] = 0;
//         }

        
//         for (int len = 2; len <= n; len++) {
//             for (int i = 1; i <= n - len + 1; i++) {
//                 int j = i + len ;
//                 weight[i][j] = weight[i][j -1] + p[j ] + q[j ];
//                 cost[i][j] = Double.MAX_VALUE;

//                 for (int r = i; r <= j; r++) {
//                     double val = r > i ? cost[i][r - 1] : 0;
//                     val += r < j ? cost[r + 1][j] : 0;
//                     val += weight[i][j];
//                     cost[i][j] = Math.min(cost[i][j], val);
//                 }
//             }
//         }   

//         return cost[1][n];
//     }

//     public static void main(String[] args) {
//         double[] p = {0.0, 0.1, 0.15, 0.15, 0.1};
//         double[] q = {0.1, 0.2, 0.05, 0.05, 0.1};
//         double optimalCost = optimalCost(p, q);
//         System.out.println("Optimal cost: " + optimalCost);
//     }
// }
public class OBST {
    public static double optimalCost(double[] p, double[] q) {
        int n = p.length;
        double[][] cost = new double[n + 1][n + 1];
        double[][] weight = new double[n + 1][n + 1];

        
        for (int i = 0; i < n; i++) {
            weight[i][i] = q[i];
            cost[i][i] = 0;
        }

        
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                weight[i][j] = weight[i][j - 1] + p[j - 1] + q[j - 1];
                cost[i][j] = Double.MAX_VALUE;

                for (int r = i; r <= j; r++) {
                    double val = r > i ? cost[i][r - 1] : 0;
                    val += r < j ? cost[r + 1][j] : 0;
                    val += weight[i][j];
                    cost[i][j] = Math.min(cost[i][j], val);
                }
            }
        }   

        return cost[1][n];
    }

    public static void main(String[] args) {
        double[] p = {0.0, 0.1, 0.15, 0.15, 0.1};
        double[] q = {0.1, 0.2, 0.05, 0.05, 0.1};
        double optimalCost = optimalCost(p, q);
        System.out.println("Optimal cost: " + optimalCost);
    }
}