import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int maxSafe;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 여기서부터 알고리즘 로직 호출하면 됨
        walls(0,0);
        System.out.println(maxSafe);


    }

    //이 함수에서 바이러스는 건들지 않는다. 오직 “벽 위치 조합”만 책임진다.
    public static void walls(int count,int start){
        if (count == 3){
            int[][] temp = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = board[i][j];
                }
            }

            //바이러스 퍼트리기
            spreadVirus(temp);
            //안전구역
            int safe = countSafe(temp);
            maxSafe = Math.max(maxSafe, safe);
            return;
        }

        for (int i = start; i < N*M; i++) {
            // i로 부터 r,c 를 끌어내야함
            int r = i / M;
            int c = i % M;
            if (board[r][c] != 0){
                continue;
            }
            board[r][c] = 1;
            walls(count+1,i+1);
            board[r][c] = 0;
        }




    }

    private static void spreadVirus(int[][] temp) {
        // 1. 큐 생성
        Queue<int[]> q = new LinkedList<>();
        // 2. temp 전체 순회하면서 temp[r][c] == 2 이면 큐에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        // 3. dr, dc 정의
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        // 4. while 큐가 빌 때까지:
        while (!q.isEmpty()){
            //    - poll 해서 (r,c) 가져오기
            int pos[] = q.poll();
            int r = pos[0];
            int c = pos[1];
            //    - 4방향에 대해 nr, nc 계산
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;
                //    - 범위 체크
                if(nr >= 0 && nr < N && nc >= 0 && nc <M){
                    if (temp[nr][nc] == 0){
                        temp[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                    }
                }

            }
        }

    }


    private static int countSafe(int[][] temp) {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0){
                    num++;
                }
            }

        }
        return num;
    }

}
