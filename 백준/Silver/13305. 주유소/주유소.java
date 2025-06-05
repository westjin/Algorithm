import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());  // 도시 수

            long[] distance = new long[N - 1];  // 거리 정보
            long[] price = new long[N];        // 리터당 기름값

            // 거리 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N - 1; i++) {
                distance[i] = Long.parseLong(st.nextToken());
            }

            // 기름값 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                price[i] = Long.parseLong(st.nextToken());
            }

            long totalCost = 0;
            long minPrice = price[0];  // 현재까지 가장 싼 가격

            for (int i = 0; i < N - 1; i++) {
                // 현재까지 본 최소 기름값으로 거리만큼 주유
                totalCost += minPrice * distance[i];

                // 다음 도시의 기름값이 더 싸면 갱신
                if (price[i + 1] < minPrice) {
                    minPrice = price[i + 1];
                }
            }

            System.out.println(totalCost);
        }
    }


