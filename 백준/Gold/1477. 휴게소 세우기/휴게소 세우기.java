import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[N+2];
        arr[0] = 0;


        //arr배열 채우기
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        arr[N+1] = L;
        Arrays.sort(arr);

        int left = 1;
        int right = L-1;
        int result = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < arr.length; i++) {
                int dist = arr[i] - arr[i-1]; // 휴게소 사이 거리.
                count += (dist - 1) / mid; // 휴게소 개수
            }

            if(count > M){ // 조건 불만족!
                left = mid + 1;
            }else {
                result = mid;
                right = mid - 1;
            }

        }

        System.out.println(result);

    }
}
