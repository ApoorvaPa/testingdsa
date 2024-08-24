class test2 {
    static int counter = 0;
    static {
        counter++;
    }

    public static int[][] add(int[][] A, int[][] B) {
        
        int rows = A.length;
        counter++;
        int cols = A[0].length;
        counter++;
        int[][] C = new int[rows][cols];
        counter++;

        for (int i = 0; i < rows; i++) {
            counter++;
            for (int j = 0; j < cols; j++) {
                counter++;
                C[i][j] = A[i][j] + B[i][j];
                counter++;
            }counter++;
        }counter++;
        
        return C;
    
    }

    public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {counter++;
        for (int val : row) {
            counter++;
            System.out.print(val + " ");
        }counter++;
        System.out.println();
    }counter++;
}
    
    

    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 3, 4 } };
        counter++;
        int[][] B = { { 5, 6 }, { 7, 8 } };
        counter++;
        int[][] result = add(A, B);
        counter++;
        printMatrix(result);
        counter++;
        System.out.println(counter);
    }
}
