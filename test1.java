class test1 {
    static int counter = 0;
    static {
        counter++;
    }
    public static int[][] multiply(int[][] A, int[][] B) {
        
        int rowsA = A.length;
        counter++;
        int colsA = A[0].length;
        counter++;
        int colsB = B[0].length;
        counter++;

        int[][] C = new int[rowsA][colsB];
        counter++;

        for (int i = 0; i < rowsA; i++) {
            counter++;
            for (int j = 0; j < colsB; j++) {
                counter++;
                for (int k = 0; k < colsA; k++) {
                    counter++;
                    C[i][j] += A[i][k] * B[k][j];
                    counter++;
                }
                counter++;
            }
            counter++;
        }
        counter++;
        
        return C;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            counter++;
        
            for (int val : row) {
                counter++;
                System.out.print(val + " ");
            }
        counter++;
        System.out.println();
    }counter++;
}


    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 3, 4} };
        counter++;
        int[][] B = { { 5, 6 }, { 7, 8 } };
        counter++;
        int[][] result = multiply(A, B);
        counter++;
        
        printMatrix(result);
        counter++;

        System.out.println(counter);
    }
}
