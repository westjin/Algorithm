import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                ones++; // 1은 곱하지 말고 무조건 더하는 게 이득
            } else if (num == 0) {
                zeros++;
            } else {
                negative.add(num);
            }
        }

        // 양수는 큰 수부터 정렬 (내림차순)
        Collections.sort(positive, Collections.reverseOrder());
        // 음수는 작은 수부터 정렬 (오름차순)
        Collections.sort(negative);

        int sum = 0;

        // 양수 처리
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                sum += positive.get(i) * positive.get(i + 1);
            } else {
                sum += positive.get(i); // 짝이 없으면 그냥 더함
            }
        }

        // 음수 처리
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                sum += negative.get(i) * negative.get(i + 1);
            } else {
                // 짝이 없는 음수는 0이 있으면 곱해서 없애고, 없으면 그냥 더함
                if (zeros == 0) {
                    sum += negative.get(i);
                }
            }
        }

        // 1은 무조건 더함
        sum += ones;

        System.out.println(sum);
    }
}
