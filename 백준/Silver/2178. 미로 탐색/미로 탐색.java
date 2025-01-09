
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    //배열애서  x는 0만큼 y는 1만큼 -> 아래를 탐색해라?
    //배열에서 x는 0만큼 y는 -1만큼 -> 위를 탐색해라

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));

            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);


    }
    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>(); // 데이터가 두개 들어오니까 인트 배열로 만들겠다??
        queue.offer(new int[] {i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int now[] = queue.poll();
//            System.out.println("now " + now[0] + " ," + now[1]);
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k]; // -> 0
                int y = now[1] + dy[k]; // -> 1
//                System.out.println("x,y " + x + " ," + y);
                if(x >= 0 && y >= 0 && x < N && y < M ){ //범위를 넘어가서는 안된다.
                    if (A[x][y] != 0 && !visited[x][y]){ //0이거나 방문했던 곳이면 안된다.
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 핵심
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }

}
