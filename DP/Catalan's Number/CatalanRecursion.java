public class CatalanRecursion {


    public static int Catalans(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i <= n - 1; i++) {
            sum += Catalans(i) * Catalans(n - i - 1);

        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(Catalans(n));
    }
    
}
