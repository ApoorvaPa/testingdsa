import java.util.Scanner;
public class ClimbingDPmy {





    static int Ways(int n) {

        int[] dp = new int[n + 1]; // 0 -- n
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n;i++)
        {
            
                dp[i] = dp[i - 1] + dp[i - 2];
           
        }
        return (dp[n]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(Ways(n));
        
    }
    
}

    
