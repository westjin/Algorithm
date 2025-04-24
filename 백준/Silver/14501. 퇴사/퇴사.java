import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.DoublePredicate;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] T = new int[n];
        int[] P = new int[n];
        int[] dp = new int[n+1];
        int max = 0;
        dp[n] = 0;


        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = n-1; i >= 0 ; i--) {
            if (i + T[i] > n ){
                dp[i] = dp[i + 1];
            }else {
                dp[i] =Math.max(dp[i +1], P[i] + dp[i + T[i]]);
            }
        }


        System.out.println(dp[0]);

        bufferedReader.close();


    }
}
