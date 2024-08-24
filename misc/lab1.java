public class lab1 {
    public static int[][] multiply(int[][] A, int[][] B) {

        int counter1 = 0;
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Invalid input: Cannot multiply matrices with these dimensions");

        }
        counter1++;
        //System.out.println(counter1 + "below if");

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                    counter1++;
                }
                result[i][j] = sum;
                counter1++;

            }

        }

        System.out.println(counter1);
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
        int ar1[][] = { { 1, 2, 3 }, { 3, 4, 5 } };
        int ar2[][] = { { 5, 6, 7 }, { 7, 8, 8 } };
        int arraymul[][] = multiply(ar1, ar2);

        // for (int i = 0; i <= arraymul.length; i++) {
        //     for (int j = 0; j <= arraymul.length[0]; j++) {

        //     }
        printMatrix(arraymul);

    }
}
