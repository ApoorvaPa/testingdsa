import java.util.Arrays;
import java.util.Scanner;

public class ClimbingMemo {
    //O(n)
    static int Nways(int n, int[] f) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (f[n] != -1) {
            return f[n];
        }
        f[n] = Nways(n-1,f) +  Nways(n-2,f);
        return (f[n]);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n + 1];
        Arrays.fill(f, -1);
        System.out.println(Nways(n, f));
    }
    
}
