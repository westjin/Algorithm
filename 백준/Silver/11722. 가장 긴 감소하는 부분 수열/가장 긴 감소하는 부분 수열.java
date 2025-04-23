import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[N];
        int[] dp = new int[N];
        int maximum = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N ; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (maximum < dp[i]){
                maximum = dp[i];
            }
        }

        System.out.println(maximum);
        bufferedReader.close();



    }

}
