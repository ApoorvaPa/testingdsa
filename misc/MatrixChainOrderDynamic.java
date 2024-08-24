import java.util.Scanner;

public class MatrixChainOrderDynamic {
    // Function to validate if the matrices can be multiplied
    static boolean canMultiply(int[] rows, int[] cols) {
        for (int i = 0; i < rows.length - 1; i++) {
            if (cols[i] != rows[i + 1]) {
                return false; // Matrices are not compatible for multiplication
            }
        }
        return true; // All matrices are compatible for multiplication
    }

    // Function to find the minimum cost and the optimal order of multiplying the chain of matrices
    static int matrixChainOrder(int[] p, int n, int[][] s) {
        int[][] m = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k; // Storing the index of the split that resulted in the minimum cost
                    }
                }
            }
        }
        return m[1][n - 1];
    }

    // Function to print the optimal order of multiplication
    static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i+" ");
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int count = scanner.nextInt();

        int[] rows = new int[count];
        int[] cols = new int[count];
        
        for (int i = 0; i < count; i++) {
            System.out.println("Enter dimensions for matrix " + (i + 1) + " (m x n):");
            System.out.print("Rows: ");
            rows[i] = scanner.nextInt();
            System.out.print("Columns: ");
            cols[i] = scanner.nextInt();
        }

        if (!canMultiply(rows, cols)) {
            System.out.println("Cannot multiply the matrices due to incompatible dimensions.");
        } else {
            int[] dimensions = new int[count + 1];
            dimensions[0] = rows[0]; // First matrix's row
            for (int i = 0; i < count; i++) {
                dimensions[i + 1] = cols[i]; // Columns for each matrix
            }
            int[][] s = new int[count + 1][count + 1]; // Auxiliary table to store the split points
            int cost = matrixChainOrder(dimensions, count + 1, s);
            System.out.println("Minimum number of multiplications is: " + cost);
            System.out.print("The optimal order of multiplication is: ");
            printOptimalParens(s, 1, count);
        }
        scanner.close();
    }
}
