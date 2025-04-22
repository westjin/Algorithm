import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];
        int[] dp = new int[12];
        dp[0] = 1;


        for (int i = 1; i <= 11; i++) {
            if (i - 1 >= 0) dp[i] += dp[i - 1];
            if (i - 2 >= 0) dp[i] += dp[i - 2];
            if (i - 3 >= 0) dp[i] += dp[i - 3];
        }

        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < target.length; i++) {
            System.out.println(dp[target[i]]);
        }


    }

}
