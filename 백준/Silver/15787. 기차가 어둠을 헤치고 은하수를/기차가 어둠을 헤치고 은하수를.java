import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 기차 개수 및 명령 수 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기차 수
        int M = Integer.parseInt(st.nextToken()); // 명령 수

        int[] trains = new int[N + 1]; // 기차 번호 1번부터 사용
        final int FULL_MASK = (1 << 20) - 1; // 20개의 좌석만 유지하는 마스크
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                // TODO: 탑승 - train번 기차 x번 좌석 ON
                trains[train] |= (1 << (x-1));
            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                // TODO: 하차 - train번 기차 x번 좌석 OFF
                trains[train] &= ~(1 << (x-1));
            } else if (cmd == 3) {
                trains[train] = (trains[train] << 1) & FULL_MASK;
            } else if (cmd == 4) {
                    trains[train] >>= 1;
                    trains[train] &= FULL_MASK;  
                }

            


        }
        // 서로 다른 기차 상태 개수 세기
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            // TODO: set에 trains[i] 추가
            set.add(trains[i]);
        }

        // 출력
        System.out.println(set.size());

        }

}
