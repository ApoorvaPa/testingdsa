public class Optimal {
    public static double optimalCost(double[] p, double[] q) {
        int n = p.length;//n=5
        System.out.println(n);
        double[][] cost = new double[n+1 ][n+1 ];
        double[][] weight = new double[n+1 ][n+1 ];

        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = -1;
                weight[i][j] = -1;

            }
        }
        for (int i = 0; i < n; i++) {
            weight[i][i] = q[i];
            cost[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(weight[i][j] + " ");

            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < j) && (j - i == 1)) {
                    weight[i][j] = weight[i][j - 1] + p[j] + q[j];

                }
            }
        }
        System.out.println("after updates");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(weight[i][j] + " ");

            }
            System.out.println();
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