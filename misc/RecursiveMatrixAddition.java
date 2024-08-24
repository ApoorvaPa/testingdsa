public class RecursiveMatrixAddition {

    public static int[][] add(int[][] A, int[][] B, int row, int col) {

        int counter = 0;
        int[][] result = new int[A.length][A[0].length];
        
        if (row >= A.length || col >= A[0].length) {
            return result;

        }
        counter++;

        result[row][col] = A[row][col] + B[row][col];

        if (col < A[0].length - 1) {
            int[][] next = add(A, B, row, col + 1);
            result[row][col + 1] = next[row][col + 1];
            counter++;
        }

        if (col == A[0].length - 1 && row < A.length - 1) {
            int[][] next = add(A, B, row + 1, 0);
            System.arraycopy(next[row + 1], 0, result[row + 1], 0, A[0].length);
            counter++;
        }
        System.out.println(counter);
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] result = add(A, B, 0, 0);
        printMatrix(result); 
    }
}
