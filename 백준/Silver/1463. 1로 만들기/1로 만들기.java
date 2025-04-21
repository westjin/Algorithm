import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoDate;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int dp[] = new int[N + 1];

        if (N == 1) {
            System.out.println(0);
            return;
        } else if (N == 2) {
            System.out.println(1);
            return;
        } else if (N == 3) {
            System.out.println(1);
            return;
        } else {

            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + 1;
                if (i % 2 == 0) {
                    dp[i] = min(dp[i], dp[i / 2] + 1);
                }
                if (i % 3 == 0) {
                    dp[i] = min(dp[i], dp[i / 3] + 1);
                }
            }

            System.out.println(dp[N]);
        }
    }
}
