import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 소수 구하기 (에라토스테네스의 체)
        // 주어진 수 까지의 소수들을 primes에 담기
        boolean[] isNotPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // 2. 투 포인터 알고리즘
        // 소수들로만 만든 배열에서 모든 연속된 구간을 살펴본다.
        int left = 0, right = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= primes.get(left++); // 왼쪽을 줄여서 합 줄이기
            } else {
                if (right == primes.size()) break; // 끝까지 탐색했다면 종료
                sum += primes.get(right++); // 오른쪽 확장
            }
        }

        System.out.println(count);
    }

}
