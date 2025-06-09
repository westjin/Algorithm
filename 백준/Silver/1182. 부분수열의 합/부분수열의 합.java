import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken()); // 정수의 개수
        int target = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N];
        int result = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

//        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < (1 << N); i++) { // 공집합 제외를 위해 1 제거
            int sum = 0;

            for (int j = 0; j < N; j++) { // 배열의 인덱스
                if((i & (1 << j)) != 0){  // i에서 j번째 비트가 1인지 확인
                    sum += arr[j];
                }
            }

            if(sum == target)
                result++;
        }

        System.out.println(result);


    }

}
