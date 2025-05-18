import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] tree = new int[n];
        long max = 0;
        long min = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(max < tree[i]){
                max = tree[i];
            }
        }

        while (min < max){
            long mid = (min + max) / 2;
            long sum = 0;
            for (int height : tree){
                if(height - mid > 0) {
                    sum += (height - mid);
                }
            }
            if (sum < m){ // 높이 낮춰여 함
                    max = mid;
            }else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }

}
